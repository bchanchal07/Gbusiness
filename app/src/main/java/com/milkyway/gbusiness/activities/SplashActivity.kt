package com.milkyway.gbusiness.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.LogInDataClass
import com.milkyway.gbusiness.models.LogInErrorClass
import com.milkyway.gbusiness.models.SignUpDataClass
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.global.CommonUtil
import id.ionbit.ionalert.IonAlert
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.doAsync
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashActivity : AppCompatActivity(), Callback<Any> {

    private lateinit var splashRelativeLyt: RelativeLayout
    private var barsDialog: ProgressBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        setContentView(R.layout.activity_splash)

        Log.i("First Time Login", CommonUtil.getPreferencesString(this@SplashActivity, AppConstants.isFirstTime)!!)

        splashRelativeLyt = findViewById(R.id.splashRelativeLyt)

        Thread(Runnable {

            Thread.sleep(1000)

            //   CommonUtil.saveStringPreferences(this@SplashActivity,AppConstants.IS_PIN_PASS,"true")

            if (CommonUtil.getPreferencesString(this@SplashActivity, AppConstants.isFirstTime).equals("true"))
                launchHomeScreen()
            else {
                CommonUtil.saveStringPreferences(this, AppConstants.SHOW_RATE, "1")
                CommonUtil.saveStringPreferences(this, AppConstants.IS_SHOW_RATE, "1")
                startActivity(Intent(this, IntroActivity::class.java))
                finish()
            }


        }).start()

    }

    private fun launchHomeScreen() {
        //  prefManager!!.setLaunched(false)
        CommonUtil.saveStringPreferences(this, AppConstants.isFirstTime, "true")
        barsDialog = findViewById(R.id.progressBarIntro)
        barsDialog = ProgressBar(this)

        val userID = CommonUtil.getPreferencesString(this, AppConstants.USER_ID)
        if (userID != null) {
            Log.i("login  userid", userID)
        }
        if (!userID.equals("USER_ID") && !userID.isNullOrEmpty())
            checkForAutoLogin()
        else {
            launchLoginScreen()
        }

    }

    private fun launchLoginScreen() {
        startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
        finish()
        //launchActivity<LoginActivity>()
    }


    private fun checkForAutoLogin() {
        val loginWith = CommonUtil.getPreferencesString(this, AppConstants.LOGINWITH)
        if (loginWith != null) {
            Log.i("login", loginWith)
        }
        when (loginWith) {
            "normal" -> {
                Log.i("login", "normal")
                checkConnection()
            }
            "withEmail" -> {
                Log.i("login", "withEmail")
                /*if (AppConstants.SOCIAL_ID.isEmpty()) {
                    checkConnection()
                } else*/
                loginWithSocial()
            }
            else -> Log.i("login", "non")
        }
    }

    private fun loginWithSocial() {
        if (CommonUtil.checkNetwork(this)) {

            val userName = CommonUtil.getPreferencesString(this, AppConstants.FULL_NAME)
            val userEmail = CommonUtil.getPreferencesString(this, AppConstants.EMAIL)
            val userUID = CommonUtil.getPreferencesString(this, AppConstants.SOCIAL_ID)
            val userPhotoUrl = CommonUtil.getPreferencesString(this, AppConstants.IMAGE_USER)

            Log.i("TAGad", "aaaaaaaaaaaaaaaaaaaaa")
            Log.i("TAGad userName = ", userName.toString())
            Log.i("TAGad userEmail = ", userEmail.toString())
            Log.i("TAGad userUID = ", userUID.toString())
            Log.i("TAGad userPhotoUrl = ", userPhotoUrl.toString())


            barsDialog!!.visibility = View.VISIBLE
            GbusinessService.create(this).getSignUp(
                "Bearer " + CommonUtil.getPreferencesString(this, AppConstants.TOKEN),
                "application/json",
                userName!!,
                userEmail!!,
                userUID!!,
                "google",
                userPhotoUrl!!)
                .enqueue(object : Callback<SignUpDataClass> {
                    override fun onFailure(call: Call<SignUpDataClass>, t: Throwable) {

                        barsDialog!!.visibility = View.GONE
                        // CommonUtil.toast(t.localizedMessage, this@SplashActivity)
                        CommonUtil.logi(t.localizedMessage.toString())
                        launchLoginScreen()
                    }

                    override fun onResponse(
                        call: Call<SignUpDataClass>,
                        response: Response<SignUpDataClass>,
                    ) {
                        barsDialog!!.visibility = View.GONE

                        Log.i("TAG", response.body().toString())
                        CommonUtil.saveStringPreferences(this@SplashActivity, AppConstants.TOKEN, "null")
                        val getdata = response.body()
                        CommonUtil.logi(getdata.toString())
                        if (getdata != null) {
                            if (getdata.success) {
                                //  CommonUtil.toast("okdd", this@SplashActivity)
                                CommonUtil.saveStringPreferences(this@SplashActivity, AppConstants.USER_ID, getdata.user_id.toString())
                                CommonUtil.saveStringPreferences(this@SplashActivity, AppConstants.EMAIL, getdata.data.email)
                                CommonUtil.saveStringPreferences(this@SplashActivity, AppConstants.FULL_NAME, getdata.data.full_name)
                                CommonUtil.saveStringPreferences(this@SplashActivity, AppConstants.MOBILE, getdata.data.phone)
                                CommonUtil.saveStringPreferences(this@SplashActivity, AppConstants.SOCIAL_ID, userUID)
                                CommonUtil.saveStringPreferences(this@SplashActivity, AppConstants.IMAGE_USER, userPhotoUrl)


                                CommonUtil.saveStringPreferences(this@SplashActivity, AppConstants.TOKEN, getdata.token.toString())
                                // if(getdata.message!=null) CommonUtil.toast(getdata.message,this@SplashActivity)

                                if (CommonUtil.getPreferencesString(this@SplashActivity, AppConstants.IS_PIN_PASS).equals("true")) {
                                    startActivity(Intent(this@SplashActivity, Main2Activity::class.java))
                                } else {
                                    val intent = Intent(this@SplashActivity, MainActivity::class.java)
                                    doAsync {
                                        startActivity(intent)
                                        finish()
                                    }
                                }


                            } else launchLoginScreen()
                        } else launchLoginScreen()
                    }

                })


        } else {

            //  Toast.makeText(this,"Check Internet",Toast.LENGTH_SHORT).show()
            launchLoginScreen()
        }
    }

    private fun checkConnection() {

        if (CommonUtil.checkNetwork(this@SplashActivity)) {
            /* Log.i("TAGhfghgh","otp ="+opts)
             Log.i("TAGhfghgh","email ="+loginUserEmail.text.toString())
             Log.i("TAGhfghgh","pass ="+loginUserPassword.text.toString())
*/

            val email = CommonUtil.getPreferencesString(this, AppConstants.LOGINUSER)
            val pass = CommonUtil.getPreferencesString(this, AppConstants.LOGINPASSWORD)
            val firebaseToken = CommonUtil.getPreferencesString(this, AppConstants.TOKEN_FIREBASE)


            barsDialog!!.visibility = View.VISIBLE
            val apiService = GbusinessService.create(this)
            apiService.getLogin("application/json",
                email!!,
                pass!!, "0",
                firebaseToken!!)
                .enqueue(this)

        } else {
            // CommonUtil.toast("Check Internet",this@SplashActivity)
            launchLoginScreen()
        }
    }

    override fun onFailure(call: Call<Any>, t: Throwable) {
        barsDialog!!.visibility = View.GONE
        //  CommonUtil.toast(R.string.showError.toString(),this)
        CommonUtil.logi(t.localizedMessage.toString())
        launchLoginScreen()
    }

    override fun onResponse(call: Call<Any>, response: Response<Any>) {
        barsDialog!!.visibility = View.GONE
        Log.i("TAG", response.body().toString())
        val gson = Gson()
        if (response.code() == 200) {
            val mLoginResponse = gson.fromJson(gson.toJson(response.body()), LogInDataClass::class.java)
            if (mLoginResponse.success) {
                CommonUtil.saveStringPreferences(this, AppConstants.USER_ID, mLoginResponse.data.user_id.toString())
                CommonUtil.saveStringPreferences(this, AppConstants.FULL_NAME, mLoginResponse.data.full_name)
                CommonUtil.saveStringPreferences(this, AppConstants.EMAIL, mLoginResponse.data.email)
                CommonUtil.saveStringPreferences(this, AppConstants.MOBILE, mLoginResponse.data.phone)
                CommonUtil.saveStringPreferences(this, AppConstants.TOKEN, mLoginResponse.data.token)
                CommonUtil.saveStringPreferences(this, AppConstants.isFirstOtp, "0")

                if (mLoginResponse.message == "You have sucessfully logged") {
                    /* val intent = Intent(this,MainActivity::class.java)
                     doAsync {

                         intent.flags=Intent.FLAG_ACTIVITY_CLEAR_TOP
                         startActivity(intent)
                         finish();

                     }*/
                    if (CommonUtil.getPreferencesString(this@SplashActivity, AppConstants.IS_PIN_PASS).equals("true")) {
                        startActivity(Intent(this@SplashActivity, Main2Activity::class.java))
                    } else {
                        val intent = Intent(this, MainActivity::class.java)
                        doAsync {
                            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                            startActivity(intent)
                            finish();
                        }
                    }
                } else {
                    val intent = Intent(this, OtpActivity::class.java)
                    doAsync {

                        intent.putExtra("email", loginUserEmail.text.toString())
                        intent.putExtra("password", loginUserPassword.text.toString())
                        intent.putExtra("otp", mLoginResponse.otp.toString())
                        startActivity(intent)
                    }
                }
            } else launchLoginScreen()
        } else if (response.code() == 500) {
            val ionAlert = IonAlert(this@SplashActivity, IonAlert.ERROR_TYPE)
            ionAlert.titleText = "Server Error!"
            ionAlert.contentText = "Server is not responding at present."
            ionAlert.show()
        } else if (response.code() == 404) {
            val errorType = object : TypeToken<LogInErrorClass>() {}.type
            var errorBodyResponse: LogInErrorClass? = gson.fromJson(response.errorBody()!!.charStream(), errorType)
            try {
                if (errorBodyResponse != null) {
                    if (!errorBodyResponse.success) {
                        launchLoginScreen()
                        /*val ionAlert = IonAlert(this@SplashActivity, IonAlert.ERROR_TYPE)
                        ionAlert.titleText = "Server Error!"
                        ionAlert.contentText = errorBodyResponse.message
                        ionAlert.setConfirmClickListener {
                            launchLoginScreen()
                        }
                        ionAlert.show()*/
                        //CommonUtil.toastError(errorBodyResponse.message, mContext)
                    }
                } else {
                    CommonUtil.errorToast("Error!", "Something went wrong! Plz try again.....", this@SplashActivity)
                }

            } catch (e: java.lang.Exception) {
                e.printStackTrace()
                //CommonUtil.toastError(e.localizedMessage, mContext)
            }
        } else {
            val errorBodyResponse = gson.fromJson(gson.toJson(response.errorBody()), LogInErrorClass::class.java)
            try {
                if (errorBodyResponse != null) {
                    if (errorBodyResponse.success) {
                        val ionAlert = IonAlert(this@SplashActivity, IonAlert.ERROR_TYPE)
                        ionAlert.titleText = "Server Error!"
                        ionAlert.contentText = errorBodyResponse.message
                        ionAlert.show()
                        //CommonUtil.toastError(errorBodyResponse.message, mContext)
                    }
                }

            } catch (e: java.lang.Exception) {
                e.printStackTrace()
                //CommonUtil.toastError(e.localizedMessage, mContext)
            }
        }
    }
}
