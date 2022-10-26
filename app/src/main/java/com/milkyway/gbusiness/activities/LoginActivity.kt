package com.milkyway.gbusiness.activities

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.installreferrer.api.InstallReferrerClient
import com.android.installreferrer.api.InstallReferrerStateListener
import com.android.installreferrer.api.ReferrerDetails
import com.crashlytics.android.Crashlytics
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.GraphRequest
import com.facebook.HttpMethod
import com.facebook.login.LoginManager
import com.facebook.login.widget.LoginButton
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.InstanceIdResult
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.api.DialogClick
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.LogInDataClass
import com.milkyway.gbusiness.models.LogInErrorClass
import com.milkyway.gbusiness.models.SignUpDataClass
import com.milkyway.gbusiness.extension.launchActivity
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.utils.CommonUtil
import com.milkyway.gbusiness.utils.CommonUtil.Companion.checkNetwork
import id.ionbit.ionalert.IonAlert
import io.fabric.sdk.android.Fabric
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.doAsync
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity(), DialogClick {

    private lateinit var referrerClient: InstallReferrerClient
    lateinit var broadcastReceiver: BroadcastReceiver
    lateinit var mOtp: String
    lateinit var mCheckBoxRemember: CheckBox

    //Gmail
    private lateinit var mGoogleSignInButton: SignInButton
    lateinit var mAuth: FirebaseAuth
    private val RC_SIGN_IN = 2
    private var opts: String = "1"
    lateinit var mGoogleSignInClient: GoogleSignInClient

    //Facebook
    lateinit var mFacebookLoginButton: LoginButton
    private var callbackManager: CallbackManager? = null
    var mFbName: String = "pawan"
    var mFbEmail: String? = "email"
    var mFbId: String = "7082184904"
    var mFbPicUrl: String = "pawankhatri14311@gmail.com"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fabric.with(this, Crashlytics())
        setContentView(R.layout.activity_login)
        initViews()
        clickListener()
        initSec()

        // sendBroadcast(Intent(this, LocalBroadcastReceiver::class.java).setAction("com.hello.action"))
        //  registerReceiver()

        //todo facebook
        //initFacebook()

    }

    private fun initViews() {
        mFacebookLoginButton = findViewById(R.id.facebook_login_button)
        mCheckBoxRemember = findViewById(R.id.checkBoxRemember)
        callbackManager = CallbackManager.Factory.create()
        referrerClient = InstallReferrerClient.newBuilder(this).build()
        getFireBaseToken()
        sendBroadcast(Intent("hanu"))
        autoFillLogDetails()
        initFacebookLogin()
        initGoogleLogin()

        /*if (AppPreferences.isLogin) {
            mCheckBoxRemember.isChecked = true
            loginUserEmail.setText(AppPreferences.username)
            loginUserPassword.setText(AppPreferences.password)
        } else {

        }*/
    }

    private fun initFacebookLogin() {

    }

    private fun initGoogleLogin() {
        //todo gmail
        initGmail()
    }

    private fun clickListener() {

        loginBtn.setOnClickListener { callLoginWithApp() }
        txtSignUp.setOnClickListener { callSignUpActivity() }

        tvPasswordForgot.setOnClickListener {

            val email = loginUserEmail.text.toString()
            if (email.isNotEmpty()) {
                val intent = Intent(this, ForgotActivity::class.java)
                intent.putExtra("emailaddress", loginUserEmail.text.toString())
                startActivity(intent)

            } else {
                loginUserEmail.requestFocus()
                loginUserEmail.error = "enter emailID"

            }
        }

        mGoogleSignInButton.setOnClickListener {
            signIn()
        }
        /*mFacebookLoginButton.setOnClickListener {
            if (isAppInstalled("com.facebook.katana")) {
                // Do somethin
                //   CommonUtil.toast("facebook install",this)
                var accessToken = AccessToken.getCurrentAccessToken()
                var isLoggedIn = accessToken != null && !accessToken.isExpired
                Log.i("tag", "accessToken $accessToken")
                Log.i("tag", "isLoggedIn $isLoggedIn")
                if (isLoggedIn) {
                    getFacebookData(accessToken)
                } else {
                    signupWithFaceBook()
                }
            } else {
                CommonUtil.toast("facebook ", this)
                doAsync {
                    val i = Intent(Intent.ACTION_VIEW);
                    i.data = Uri.parse("https://play.google.com/store/apps/details?id=com.facebook.katana");
                    startActivity(i);
                }
            }
        }*/
    }

    private fun callSignUpActivity() {
        launchActivity<SignUpActivity>()
        /*val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
        startActivity(intent)
        finish()*/
    }


    private fun initSec() {

        referrerClient.startConnection(object : InstallReferrerStateListener {

            override fun onInstallReferrerSetupFinished(responseCode: Int) {
                when (responseCode) {
                    InstallReferrerClient.InstallReferrerResponse.OK -> {
                        // Connection established
                        val response: ReferrerDetails = referrerClient.installReferrer
                        response.installReferrer
                        response.referrerClickTimestampSeconds
                        response.installBeginTimestampSeconds

                        // Log.i("realm","v = ok"+response.toString())
                        Log.i("realm", "mReferralCode = ok2 " + response.installReferrer)

                        val mReferralCode = response.installReferrer.toString()
                        val mReferralCodeFinal = mReferralCode.split("=")

                        val isAutoRfCodeGenerateAuto =
                            CommonUtil.getPreferencesString(
                                this@LoginActivity,
                                AppConstants.AUTO_REFCODE
                            )

                        if (isAutoRfCodeGenerateAuto.equals("true") || isAutoRfCodeGenerateAuto.equals(
                                ""
                            )
                        )
                            CommonUtil.saveStringPreferences(
                                this@LoginActivity,
                                AppConstants.ReferalCode,
                                mReferralCodeFinal[1]
                            )
                    }
                    InstallReferrerClient.InstallReferrerResponse.FEATURE_NOT_SUPPORTED -> {
                        // API not available on the current Play Store app
                        Log.i("realm", "mReferralCode = FEATURE_NOT_SUPPORTED")
                    }
                    InstallReferrerClient.InstallReferrerResponse.SERVICE_UNAVAILABLE -> {
                        // Connection could not be established
                        Log.i("realm", "mReferralCode = SERVICE_UNAVAILABLE")
                    }
                }
            }

            override fun onInstallReferrerServiceDisconnected() {
                // Try to restart the connection on the next request to
                // Google Play by calling the startConnection() method.
                Log.i("realm", "mReferralCode = ReferrerServiceDisconnected")
            }
        })
    }


    private fun getFireBaseToken(): String {
        var newToken = "null"
        FirebaseInstanceId.getInstance().instanceId.addOnSuccessListener(
            this, OnSuccessListener<InstanceIdResult> { instanceIdResult ->
                newToken = instanceIdResult.token
                Log.i("newToken", newToken)
            })
        CommonUtil.saveStringPreferences(this, AppConstants.TOKEN_FIREBASE, newToken)
        return newToken
    }


    /*private fun signupWithFaceBook() {
        mFacebookLoginButton.setPermissions(listOf("email,public_profile,user_friends"));
        // If you are using in a fragment, call mFacebookLoginButton.setFragment(this);

        // Callback registration
        mFacebookLoginButton.registerCallback(
            callbackManager,
            object : FacebookCallback<LoginResult> {
                override fun onSuccess(loginResult: LoginResult) {
                    Log.i(
                        "tag",
                        "" + "Facebook: onSuccess()" + loginResult.accessToken.applicationId
                    )
                    Log.i("tag", "Facebook: onSuccess()" + loginResult.accessToken.userId)

                    getFacebookData(loginResult.accessToken)
                    */
    /* val accessToken = AccessToken.getCurrentAccessToken();
                     var isLoggedIn = accessToken != null && !accessToken.isExpired();*/
    /*
                    //  Log.i("tag","Facebook: onSuccess()"+loginResult.accessToken.getUserName())
                }

                override fun onCancel() {
                    // App code
                    Log.i("tag", "Facebook: onCancel()")
                }

                override fun onError(exception: FacebookException) {
                    Log.i("tag", "Facebook: onError()" + exception.localizedMessage)
                    Log.i("tag", "Facebook: onError()" + exception.message)
                }
            })
    }*/

    private fun autoFillLogDetails() {
        val email = CommonUtil.getPreferencesString(this, AppConstants.LOGINUSER)
        val userPass = CommonUtil.getPreferencesString(this, AppConstants.LOGINPASSWORD)
        if (email.equals("LOGINUSER") || email.isNullOrEmpty() || userPass.equals("LOGINPASSWORD") || userPass.isNullOrEmpty())
            Log.i("pawan", "empty details AUTO for login")
        else {
            loginUserEmail.setText(email)
            loginUserPassword.setText(userPass)
        }
    }

    /*private fun getFacebookData(accessToken: AccessToken) {

        val request = GraphRequest.newMeRequest(accessToken) { `object`, _ ->
            try {
                //here is the data that you want
                Log.i("Fb_Login_JSON_Response", `object`.toString())

                if (`object`.has("id")) {
                    mFbId = `object`.getString("id")
                    Log.i("Fb_Login_JSON_Response", `object`.getString("id"))
                }
                if (`object`.has("name")) {
                    mFbName = `object`.getString("name")
                    Log.i("Fb_Login_JSON_Response", `object`.getString("name"))
                }
                if (`object`.has("email")) {
                    mFbEmail = `object`.getString("email")
                    Log.i("Fb_Login_JSON_Response", `object`.getString("email"))
                }

                */
    /*  val pic = `object`.getJSONObject("picture")
                  val data = `pic`.getJSONObject("data")
                  mFbPicUrl = data.getString("url")
                  Log.i("Fb_Login_JSON_Response", mFbPicUrl)*/
    /*

                if (`object`.has("picture")) {
                    Log.i("Fb_Login_JSON_Response", "fdfdfdfdfdfdfdfdfdfdfdfdfd")

                    val pic = `object`.getJSONObject("picture")
                    if (pic.has("data")) {
                        Log.i("Fb_Login_JSON_Response", "ok")
                        val data = pic.getJSONObject("data")
                        mFbPicUrl = data.getString("url")
                        Log.i("Fb_Login_JSON_Response", mFbPicUrl)
                    }
                }

                if (mFbName != "pawan") {
                    callSocialSignUpAPI(mFbName, mFbEmail, mFbPicUrl, mFbId)
                }

            } catch (e: Exception) {
                e.printStackTrace()
                // dismissDialogLogin()
            }
        }

        val parameters = Bundle()
        parameters.putString("fields", "name,email,id,picture.type(large)")
        request.parameters = parameters
        request.executeAsync()
    }*/

    private fun isAppInstalled(packageName: String): Boolean {
        return try {
            this.packageManager.getApplicationInfo(packageName, 0);
            true;
        } catch (e: PackageManager.NameNotFoundException) {
            false;
        }
    }

    private fun callLoginWithApp() {
        if (validation()) {
            if (checkNetwork(this@LoginActivity)) {
                CommonUtil.saveStringPreferences(this, AppConstants.LOGINWITH, "normal")
                CommonUtil.saveStringPreferences(
                    this,
                    AppConstants.LOGINUSER,
                    loginUserEmail.text.toString()
                )
                CommonUtil.saveStringPreferences(
                    this,
                    AppConstants.LOGINPASSWORD,
                    loginUserPassword.text.toString()
                )

                if (CommonUtil.getPreferencesString(this, AppConstants.isFirstOtp).equals("true")) {
                    mOtp = "1"
                    callAppLoginApi(mOtp)
                } else {
                    mOtp = "0"
                    callAppLoginApi(mOtp)
                }

                /*if (CommonUtil.getPreferencesString(this, AppConstants.isFirstOtp).equals("true")) {


                    //CommonUtil.showDialog(this@LoginActivity)
                    CommonUtil.showLoadingProgress(this@LoginActivity)
                    val mLoginService = GbusinessService.create(mContext)
                    mLoginService.getLogin(
                        "application/json",
                        loginUserEmail.text.toString(),
                        loginUserPassword.text.toString(), "1",
                        getFireBaseToken()
                    )
                        .enqueue(this)
                } else {
                    //CommonUtil.showDialog(this@LoginActivity)
                    CommonUtil.showLoadingProgress(this@LoginActivity)
                    val mLoginService = GbusinessService.create(mContext)
                    mLoginService.getLogin(
                        "application/json",
                        loginUserEmail.text.toString(),
                        loginUserPassword.text.toString(), "0",
                        getFireBaseToken()
                    )
                        .enqueue(this)
                }*/


            } else {
                CommonUtil.noInternetToast("Internet Connectivity!", "No internet connectivity. Plz connect your internet.", this)
                /*val ionAlert = IonAlert(this@LoginActivity, IonAlert.ERROR_TYPE)
                ionAlert.titleText = "Internet Connectivity!"
                ionAlert.contentText = "No internet connectivity. Plz connect your internet."
                ionAlert.show()*/
            }

        }
    }

    private fun callAppLoginApi(mOtp: String) {
        CommonUtil.showLoadingProgress(this@LoginActivity)
        GbusinessService.create(this).getLogin(
            "application/json",
            loginUserEmail.text.toString(),
            loginUserPassword.text.toString(), mOtp,
            getFireBaseToken()
        ).enqueue(object : Callback<Any> {
            override fun onResponse(
                call: Call<Any>,
                response: Response<Any>,
            ) {
                CommonUtil.dismissLoadingProgress()
                val gson = Gson()
                when (response.code()) {
                    200 -> {
                        val mLoginResponse = gson.fromJson(gson.toJson(response.body()), LogInDataClass::class.java)
                        if (mLoginResponse != null) {
                            //CommonUtil.successToast("Success!", mLoginResponse.message, this@LoginActivity)
                            val ionAlert = IonAlert(this@LoginActivity, IonAlert.SUCCESS_TYPE)
                            ionAlert.titleText = "Login Success!"
                            ionAlert.contentText = mLoginResponse.message
                            ionAlert.show()
                            //CommonUtil.customToast("Success!", mLoginResponse.message, this@LoginActivity, IonAlert.SUCCESS_TYPE)
                            if (mLoginResponse?.success) {
                                CommonUtil.saveStringPreferences(this@LoginActivity, AppConstants.USER_ID, mLoginResponse.data.user_id.toString())
                                CommonUtil.saveStringPreferences(this@LoginActivity, AppConstants.WHMCS_CLIENT_ID, mLoginResponse.data.whmcs_client_id.toString())
                                CommonUtil.saveStringPreferences(this@LoginActivity, AppConstants.FULL_NAME, mLoginResponse.data.full_name)
                                CommonUtil.saveStringPreferences(this@LoginActivity, AppConstants.TOKEN, mLoginResponse.data.token)
                                CommonUtil.saveStringPreferences(this@LoginActivity, AppConstants.isFirstOtp, "0")
                                CommonUtil.saveStringPreferences(this@LoginActivity, AppConstants.EMAIL, mLoginResponse.data.email)
                                CommonUtil.saveStringPreferences(this@LoginActivity, AppConstants.MOBILE, mLoginResponse.data.phone)
                                //getProfileApi()

                                /*if (mCheckBoxRemember.isChecked) {
                                    AppPreferences.isLogin = true
                                    AppPreferences.username = loginUserEmail.text.toString()
                                    AppPreferences.password = loginUserPassword.text.toString()
                                } else {
                                    AppPreferences.isLogin = false
                                    AppPreferences.username = ""
                                    AppPreferences.password = ""
                                }*/

                                if (mLoginResponse.message == "You have sucessfully logged") {
                                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                                    doAsync {

                                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                                        startActivity(intent)
                                        finish()
                                    }
                                } else {
                                    val intent = Intent(this@LoginActivity, OtpActivity::class.java)
                                    doAsync {

                                        intent.putExtra("email", loginUserEmail.text.toString())
                                        intent.putExtra("password", loginUserPassword.text.toString())
                                        intent.putExtra("otp", mLoginResponse.otp.toString())
                                        startActivity(intent)
                                    }
                                }
                            }
                        } else {
                            CommonUtil.toast("wrong id or password", this@LoginActivity)
                        }
                    }
                    404 -> {
                        val errorType = object : TypeToken<LogInErrorClass>() {}.type
                        var errorBodyResponse: LogInErrorClass? = gson.fromJson(response.errorBody()!!.charStream(), errorType)
                        try {
                            if (errorBodyResponse != null) {
                                if (!errorBodyResponse.success) {
                                    val ionAlert = IonAlert(this@LoginActivity, IonAlert.ERROR_TYPE)
                                    ionAlert.titleText = "Server Error!"
                                    ionAlert.contentText = errorBodyResponse.message
                                    ionAlert.show()
                                    //CommonUtil.toastError(errorBodyResponse.message, mContext)
                                }
                            } else {
                                CommonUtil.errorToast("Error!", "Something went wrong! Plz try again.....", this@LoginActivity)
                            }

                        } catch (e: java.lang.Exception) {
                            e.printStackTrace()
                            //CommonUtil.toastError(e.localizedMessage, mContext)
                        }
                    }
                    500 -> {
                        CommonUtil.successToast("Server Error!", "Server isn't responding currently.", this@LoginActivity)
                    }
                    else -> CommonUtil.errorToast("Error!", "Something went wrong! Please try again.....", this@LoginActivity)
                }

                /*if (response.code() == 200) {
                    val mLoginResponse = gson.fromJson(gson.toJson(response.body()), LogInDataClass::class.java)
                    if (mLoginResponse != null) {
                        //CommonUtil.toast(mLoginResponse.message, this@LoginActivity)
                        CommonUtil.successToast("Success!", mLoginResponse.message, this@LoginActivity)
                        //CommonUtil.customToast("Success!", mLoginResponse.message, this@LoginActivity, IonAlert.SUCCESS_TYPE)
                        if (mLoginResponse?.success) {
                            CommonUtil.saveStringPreferences(
                                this@LoginActivity,
                                AppConstants.USER_ID,
                                mLoginResponse.data.user_id.toString()
                            )
                            CommonUtil.saveStringPreferences(
                                this@LoginActivity,
                                AppConstants.First_NAME,
                                mLoginResponse.data.full_name.toString()
                            )
                            CommonUtil.saveStringPreferences(
                                this@LoginActivity,
                                AppConstants.EMAIL,
                                mLoginResponse.data.email.toString()
                            )
                            CommonUtil.saveStringPreferences(
                                this@LoginActivity,
                                AppConstants.MOBILE,
                                mLoginResponse.data.phone.toString()
                            )
                            CommonUtil.saveStringPreferences(
                                this@LoginActivity,
                                AppConstants.TOKEN,
                                mLoginResponse.data.token.toString()
                            )
                            CommonUtil.saveStringPreferences(
                                this@LoginActivity,
                                AppConstants.isFirstOtp,
                                "0"
                            )

                            if (mCheckBoxRemember.isChecked) {
                                AppPreferences.isLogin = true
                                AppPreferences.username = loginUserEmail.text.toString()
                                AppPreferences.password = loginUserPassword.text.toString()
                            } else {
                                AppPreferences.isLogin = false
                                AppPreferences.username = ""
                                AppPreferences.password = ""
                            }




                            if (mLoginResponse.message == "You have sucessfully logged") {
                                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                                doAsync {

                                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                                    startActivity(intent)
                                    finish()
                                }
                            } else {
                                val intent = Intent(this@LoginActivity, OtpActivity::class.java)
                                doAsync {

                                    intent.putExtra("email", loginUserEmail.text.toString())
                                    intent.putExtra("password", loginUserPassword.text.toString())
                                    intent.putExtra("otp", mLoginResponse.otp.toString())
                                    startActivity(intent)
                                }
                            }
                        }
                    } else {
                        CommonUtil.toast("wrong id or password", this@LoginActivity)
                    }
                } else if (response.code() == 500) {
                    *//*val ionAlert = IonAlert(this@LoginActivity, IonAlert.ERROR_TYPE)
                    ionAlert.titleText = "Server Error!"
                    ionAlert.contentText = "Server is not responding at present."
                    ionAlert.show()*//*
                    //CommonUtil.toastError("Server is not responding at present.", this)
                    CommonUtil.successToast("Server Error!", "Server isn't responding currently.", this@LoginActivity)
                } else if (response.code() == 404) {
                    val errorBodyResponse = gson.fromJson(gson.toJson(response.errorBody()), LogInErrorClass::class.java)
                    val errorResponse = gson.fromJson(gson.toJson(response.errorBody()), LogInDataClass::class.java)
                    try {
                        if (errorBodyResponse != null) {
                            if (!errorBodyResponse.success) {
                                val ionAlert = IonAlert(this@LoginActivity, IonAlert.ERROR_TYPE)
                                ionAlert.titleText = "Server Error!"
                                ionAlert.contentText = errorBodyResponse.message
                                ionAlert.show()
                                //CommonUtil.toastError(errorBodyResponse.message, mContext)
                            }
                        }else{
                            CommonUtil.errorToast("Error!", "Something went wrong! Plz try again.....", this@LoginActivity)
                        }

                    } catch (e: java.lang.Exception) {
                        e.printStackTrace()
                        //CommonUtil.toastError(e.localizedMessage, mContext)
                    }
                }*/
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                CommonUtil.dismissLoadingProgress()
                CommonUtil.toast(R.string.showError.toString(), this@LoginActivity)
                CommonUtil.logi(t.localizedMessage.toString())
            }

        })

    }

    /*private fun getProfileApi() {
        var userID = CommonUtil.getPreferencesString(this@LoginActivity, AppConstants.USER_ID)

        val apiService = GbusinessService.create(mContext)
        if (userID != null) {
            apiService.getUserProfile("Bearer " + CommonUtil.getPreferencesString(this@LoginActivity, AppConstants.TOKEN),
                "application/json", userID)
                .enqueue(object : Callback<ProfileDetailaDataClass> {
                    override fun onResponse(call: Call<ProfileDetailaDataClass>, response: Response<ProfileDetailaDataClass>) {
                        val getProfileData = response.body()
                        if (getProfileData != null) {
                            if (getProfileData.success) {
                                val firstName = if (!getProfileData.data.first_name.isNullOrEmpty())
                                    getProfileData.data.first_name
                                else ""
                                val lastName = if (!getProfileData.data.last_name.isNullOrEmpty())
                                    getProfileData.data.last_name
                                else ""
                                val email = if (!getProfileData.data.email.isNullOrEmpty())
                                    getProfileData.data.email
                                else ""
                                val phone = if (!getProfileData.data.phone.isNullOrEmpty())
                                    getProfileData.data.phone
                                else ""
                                val country = if (!getProfileData.data.country.isNullOrEmpty())
                                    getProfileData.data.country
                                else ""
                                val state = if (!getProfileData.data.state.isNullOrEmpty())
                                    getProfileData.data.state
                                else ""
                                val city = if (!getProfileData.data.city.isNullOrEmpty())
                                    getProfileData.data.city
                                else ""
                                val address = if (!getProfileData.data.address.isNullOrEmpty())
                                    getProfileData.data.address
                                else ""
                                val zipCode = if (!getProfileData.data.zip_code.isNullOrEmpty())
                                    getProfileData.data.zip_code
                                else ""

                                CommonUtil.saveStringPreferences(this@LoginActivity, AppConstants.FIRST_NAME, firstName)
                                CommonUtil.saveStringPreferences(this@LoginActivity, AppConstants.LAST_NAME, lastName)
                                CommonUtil.saveStringPreferences(this@LoginActivity, AppConstants.EMAIL, email)
                                CommonUtil.saveStringPreferences(this@LoginActivity, AppConstants.MOBILE, phone)
                                CommonUtil.saveStringPreferences(this@LoginActivity, AppConstants.COUNTRY, country)
                                CommonUtil.saveStringPreferences(this@LoginActivity, AppConstants.STATE, state)
                                CommonUtil.saveStringPreferences(this@LoginActivity, AppConstants.CITY, city)
                                CommonUtil.saveStringPreferences(this@LoginActivity, AppConstants.ADDRESS, address)
                                CommonUtil.saveStringPreferences(this@LoginActivity, AppConstants.ZIP_CODE, zipCode)
                            }
                        } else
                            CommonUtil.toast(R.string.showError.toString(), this@LoginActivity)
                    }

                    override fun onFailure(call: Call<ProfileDetailaDataClass>, t: Throwable) {
                        CommonUtil.hideDialog(this@LoginActivity)
                        CommonUtil.toast(R.string.showError.toString(), this@LoginActivity)
                        CommonUtil.logi(t.localizedMessage.toString())
                    }
                })
        }

    }*/

    //check validation
    private fun validation(): Boolean {
        if (loginUserEmail.text.toString().isEmpty()) {
            loginUserEmail.requestFocus()
            loginUserEmail.error = "Enter email address"
            return false
        }
        if (loginUserPassword.text.toString().isEmpty()) {
            loginUserPassword.requestFocus()
            loginUserPassword.error = "Enter password"
            return false
        }
        return true
    }

    /*private fun initFacebook() {
        ///  FacebookSdk.sdkInitialize(getApplicationContext())
        //  AppEventsLogger.activateApp(this);
        AppEventsLogger.activateApp(getApplication());


        var loginBtn = findViewById<CardView>(R.id.facebook_login_button)

        loginBtn.setOnClickListener {
            //   Log.i("facebook","dfjdfhsdsssssssssssssssssssssssssssssssssssssssss")
            CommonUtil.saveStringPreferences(this, AppConstants.LOGINWITH, "withEmail")

            if (isAppInstalled("com.facebook.katana")) {
                // Do somethin
                CommonUtil.toast("facebook install", this)

            } else {
                CommonUtil.toast("facebook ", this)
                val i = Intent(android.content.Intent.ACTION_VIEW);
                doAsync {
                    i.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.facebook.katana"));
                    startActivity(i);
                }

            }

            callbackManager = CallbackManager.Factory.create()

            LoginManager.getInstance().registerCallback(callbackManager,
                object : FacebookCallback<LoginResult> {
                    override fun onSuccess(loginResult: LoginResult) {
                        var profile = Profile.getCurrentProfile()
                        Log.i(
                            "facebook",
                            "dfjdfhsdddddddddddddddddddddddddd==================1" + loginResult.toString()
                        )
                        Log.i(
                            "facebook",
                            "dfjdfhsddddd==================1" + loginResult.accessToken.applicationId
                        )
                        Log.i("facebook", "dfjdfhsdddd==================1" + profile.firstName)
                        Log.i("facebook", "dfjdfhsd==================1" + profile.lastName)
                        Log.i("facebook", "dfjdfhsd==================1" + profile.name)
                        Log.i("facebook", "dfjdfhsd==================1" + profile.linkUri)
                        Log.i(
                            "facebook",
                            "dfjdfhsd==================1" + profile.getProfilePictureUri(100, 100)
                        )


                        val request =
                            GraphRequest.newMeRequest(loginResult.accessToken) { `object`, response ->
                                try {
                                    //here is the data that you want
                                    Log.i("facebook", "facebook====" + `object`.has("id"))

                                    val id = `object`.getString("id")
                                    val first_name = `object`.getString("first_name")
                                    val last_name = `object`.getString("last_name")
                                    val gender = `object`.getString("gender")
                                    val birthday = `object`.getString("birthday")
                                    val image_url =
                                        "http://graph.facebook.com/$id/picture?type=large"

                                    var email: String? = null
                                    if (`object`.has("email")) {
                                        email = `object`.getString("email")
                                    }

                                    Log.i("facebook", "dfjdfhsd=" + first_name)
                                    Log.i("facebook", "dfjdfhsd=" + last_name)
                                    Log.i("facebook", "dfjdfhsd=" + gender)
                                    Log.i("facebook", "dfjdfhsd=" + birthday)
                                    Log.i("facebook", "dfjdfhsd=" + image_url)
                                    Log.i("facebook", "dfjdfhsd=" + email)


                                } catch (e: Exception) {
                                    e.printStackTrace()

                                }
                            }

                        val parameters = Bundle()
                        parameters.putString("fields", "name,email,id,picture.type(large)")
                        request.parameters = parameters
                        request.executeAsync()
                    }

                    override fun onCancel() {
                        Log.i("facebook", "dfjdfhsd==================onCancel")
                    }

                    override fun onError(exception: FacebookException) {
                        Log.i(
                            "facebook",
                            "dfjdfhsd==================onError=" + exception.localizedMessage
                        )
                    }
                })
        }
    }*/


    private fun initGmail() {
        mAuth = FirebaseAuth.getInstance()
        mGoogleSignInButton = findViewById(R.id.sign_in_button)
        mGoogleSignInButton.setSize(SignInButton.SIZE_STANDARD)


        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
    }

    //todo gmail
    private fun signIn() {
        CommonUtil.saveStringPreferences(this, AppConstants.LOGINWITH, "withEmail")

        val signInIntent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    //todo gmail
    override fun onStart() {
        super.onStart()

        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = mAuth.getCurrentUser()
        // updateUI(currentUser);
    }

    //todo gmail or facebook
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //  callbackManager!!.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data)

        Log.i("facebook", "testing  ")
        if (requestCode == RC_SIGN_IN) {
            Log.i("Google SignIn", "Google sign in failed.")
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.i("Google SignIn", "Google sign ApiException" + e.localizedMessage)
            }
        } else {
            Log.i("Facebook SignIn", "in facebook login")
            callbackManager?.onActivityResult(requestCode, resultCode, data)
        }
    }


    //todo gmail
    private fun firebaseAuthWithGoogle(account: GoogleSignInAccount) {
        //  Log.d("TAG", "firebaseAuthWithGoogle:" + account.id!!)

        val credential = GoogleAuthProvider.getCredential(account.idToken, null)

        mAuth.signInWithCredential(credential)
            ?.addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    //   Log.d("TAG", "signInWithCredential:success")
                    val userName = mAuth.currentUser?.displayName
                    val userEmail = mAuth.currentUser?.email
                    //  val userupdate = mAuth.getCurrentUser()?.updatePassword("pawankhatri")
                    val userPhotoUrl = mAuth.currentUser?.photoUrl
                    val userUID = mAuth.uid.toString()

                    /* Log.d("TAG", "signInWithCredential:uid"+userUID)
                     Log.d("TAG", "signInWithCredential:userName"+userName)
                     Log.d("TAG", "signInWithCredential:userEmail"+userEmail)
                     Log.d("TAG", "signInWithCredential:userPhotoUrl"+userPhotoUrl)*/

                    callSocialSignUpAPI(userName, userEmail, userPhotoUrl.toString(), userUID)

                    //  updateUI(user);
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("TAG", "signInWithCredential:failure", task.exception)
                    Toast.makeText(this@LoginActivity, "Authentication Failed", Toast.LENGTH_SHORT).show()
                    //  Snackbar.make(findViewById(R.id.main_layout), "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
                    // updateUI(null);
                }

                // ...
            }
    }

    //todo singn or login using gmail or facebook
    private fun callSocialSignUpAPI(userName: String?, userEmail: String?, userPhotoUrl: String = "null", userUID: String) {
        /* Log.d("TAG", "signInWithCredential:uid"+userUID)
         Log.d("TAG", "signInWithCredential:userName"+userName)
         Log.d("TAG", "signInWithCredential:userEmail"+userEmail)
         Log.d("TAG", "signInWithCredential:userPhotoUrl"+userPhotoUrl)*/

        if (checkNetwork(this)) {

            val mLoginService = GbusinessService.create(this)
            /*Log.i("TAGad", "aaaaaaaaaaaaaaaaaaaaa")
            Log.i("TAGad userName = ", userName)
            Log.i("TAGad userEmail = ", userEmail)
            Log.i("TAGad userUID = ", userUID)
            Log.i("TAGad userUID = ", userUID)
            Log.i("TAGad userPhotoUrl = ", userPhotoUrl)*/

            //CommonUtil.showDialog(this)
            CommonUtil.showLoadingProgress(this@LoginActivity)
            mLoginService.getSignUp("Bearer " + getFireBaseToken()/*CommonUtil.getPreferencesString(this, AppConstants.TOKEN)*/, "application/json", userName!!, userEmail!!, userUID, "google", userPhotoUrl)
                .enqueue(object : Callback<SignUpDataClass> {
                    override fun onFailure(call: Call<SignUpDataClass>, t: Throwable) {
                        CommonUtil.dismissLoadingProgress()
                        CommonUtil.toast(t.localizedMessage, this@LoginActivity)
                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(call: Call<SignUpDataClass>, response: Response<SignUpDataClass>) {
                        //CommonUtil.hideDialog(this@LoginActivity)
                        CommonUtil.dismissLoadingProgress()

                        Log.i("TAG", response.body().toString())
                        CommonUtil.saveStringPreferences(this@LoginActivity, AppConstants.TOKEN, "null"
                        )
                        val getdata = response.body()
                        CommonUtil.logi(getdata.toString())
                        if (getdata != null) {

                            if (getdata.success) {

                                //  CommonUtil.toast("okdd", this@LoginActivity)

                                if (getdata.user_id != null) {
                                    CommonUtil.saveStringPreferences(this@LoginActivity, AppConstants.USER_ID, getdata.user_id.toString())
                                }
                                if (getdata.data != null) {
                                    //if (getdata.data.full_name != null) CommonUtil.saveStringPreferences(this@LoginActivity, AppConstants.First_NAME, getdata.data.full_name)
                                    if (getdata.data.email != null) CommonUtil.saveStringPreferences(this@LoginActivity, AppConstants.EMAIL, getdata.data.email)
                                    if (getdata.data.full_name != null) CommonUtil.saveStringPreferences(this@LoginActivity, AppConstants.FULL_NAME, getdata.data.full_name)
                                    if (getdata.data.phone != null) CommonUtil.saveStringPreferences(this@LoginActivity, AppConstants.MOBILE, getdata.data.phone)
                                    CommonUtil.saveStringPreferences(this@LoginActivity, AppConstants.SOCIAL_ID, userUID)
                                    CommonUtil.saveStringPreferences(this@LoginActivity, AppConstants.IMAGE_USER, userPhotoUrl)
                                }
                                if (getdata.token != null) CommonUtil.saveStringPreferences(this@LoginActivity, AppConstants.TOKEN, getdata.token)
                                if (getdata.message != null) CommonUtil.toast(getdata.message, this@LoginActivity)

                                if (getdata.token != null) {
                                    //disconnectFromFacebook()
                                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                                    doAsync {
                                        startActivity(intent)
                                    }
                                } else {
                                    //disconnectFromFacebook()
                                    val intent = Intent(this@LoginActivity, PhoneNumberActivity::class.java)
                                    doAsync {
                                        startActivity(intent)
                                    }
                                }
                            } else {
                                CommonUtil.toast("please enter valid current password", this@LoginActivity)
                            }
                        }
                    }
                })
        } else {
            CommonUtil.toast("Check Internet", this)
        }
    }


    fun disconnectFromFacebook() {

        if (AccessToken.getCurrentAccessToken() == null) {
            return; // already logged out
        }
        GraphRequest(
            AccessToken.getCurrentAccessToken(),
            "/me/permissions/",
            null,
            HttpMethod.DELETE
        ) { LoginManager.getInstance().logOut() }.executeAsync()
    }


    /* fun forceCrash(view: View) {
         throw RuntimeException("This is a crash")
     }*/

    /*  override fun onDestroy() {
          super.onDestroy()
          MyApplication.instance.mustDie(this)
          Log.i("distroy","MyLogin")
      }*/


    /*  fun registerReceiver() {
         broadcastReceiver = object : BroadcastReceiver() {
             override fun onReceive(context: Context, intent: Intent) {
               //  val otpCode = intent.getStringExtra("com")

                 Log.i("pawan","opt=  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
             }
         }
         registerReceiver(broadcastReceiver, IntentFilter("MyAction"))
     }
     override fun onStop() {
         super.onStop()
         if(broadcastReceiver != null) {
             unregisterReceiver(broadcastReceiver);
         }
     }*/

    override fun onPause() {
        super.onPause()

    }

    override fun onDialogClick() {
        //  Log.i("pawan","logout")
        // signOut()

    }

    fun signOut() {
        Toast.makeText(this, "SIGN OUT", Toast.LENGTH_SHORT).show();
        FirebaseAuth.getInstance().signOut()

    }
}

