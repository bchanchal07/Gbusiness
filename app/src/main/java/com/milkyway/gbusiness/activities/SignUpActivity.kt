package com.milkyway.gbusiness.activities

import android.app.Dialog
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.iid.FirebaseInstanceId
import com.google.gson.Gson
import com.hbb20.CountryCodePicker
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.SignupDataErrorResponse
import com.milkyway.gbusiness.models.SignupDataResponse
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.global.CommonUtil
import id.ionbit.ionalert.IonAlert
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.dlg_error_msg.view.*
import org.jetbrains.anko.doAsync
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.regex.Matcher
import java.util.regex.Pattern


class SignUpActivity : AppCompatActivity() {

    private lateinit var firstNameStr: String
    private lateinit var lastNameStr: String
    private lateinit var emailStr: String
    private lateinit var passwordStr: String
    private lateinit var mobileStr: String
    private var countryCode: String = "+91"
    private lateinit var mViewError: View

    private lateinit var etFirstNameSignUp: TextInputEditText
    private lateinit var etLastNameSignUp: TextInputEditText
    private lateinit var etEmailSignUp: TextInputEditText
    private lateinit var etPasswordSignUp: TextInputEditText
    private lateinit var etMobileSignUp: TextInputEditText
    private lateinit var cCPickerSignUp: CountryCodePicker
    var sharedPreferencesEditor: SharedPreferences.Editor? = null
    private var sharedPreferences: SharedPreferences? = null
    private var saveLogin: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        initViews()
        clickListeners()
    }

    private fun initViews() {
        getFireBaseToken()

        etFirstNameSignUp = findViewById(R.id.etFirstNameSignUp)
        etLastNameSignUp = findViewById(R.id.etLastNameSignUp)
        etEmailSignUp = findViewById(R.id.etEmailSignUp)
        etPasswordSignUp = findViewById(R.id.etPasswordSignUp)
        etMobileSignUp = findViewById(R.id.etMobileSignUp)
        cCPickerSignUp = findViewById(R.id.cCPickerSignUp)


    }

    private fun clickListeners() {
        txtLogin.setOnClickListener {
            val loginIntent = Intent(this@SignUpActivity, LoginActivity::class.java)
            startActivity(loginIntent)
            finish()
        }
        btnSignUp.setOnClickListener {
            if (isValidate()) {
                //launchActivity<LoginActivity>()

                firstNameStr = etFirstNameSignUp.text.toString().trim()
                lastNameStr = etLastNameSignUp.text.toString().trim()
                emailStr = etEmailSignUp.text.toString().trim()
                passwordStr = etPasswordSignUp.text.toString().trim()
                mobileStr = etMobileSignUp.text.toString().trim()
                callSignUpApi(firstNameStr, lastNameStr, emailStr, passwordStr, countryCode, mobileStr)
                //Toast.makeText(this,"$firstNameStr\n$lastNameStr\n$emailStr\n$passwordStr\n$countryCode\n$mobileStr",Toast.LENGTH_LONG).show()
            }
        }

        etConfirmPasswordSignUp.doOnTextChanged { text, _, _, _ ->
            val cpw = text.toString()

            val password: String = etPasswordSignUp.text.toString()
            if (cpw.isNotEmpty() && password.isNotEmpty()) {
                if (!cpw.contentEquals(password)) {
                    // give an error that password and confirm password not match
                    tilConfirmPass.error = "Confirm password doesn't match with password."
                    etConfirmPasswordSignUp.requestFocus()
                } else {
                    tilConfirmPass.isErrorEnabled = false
                }
            }
        }

        cCPickerSignUp.setOnCountryChangeListener {
            countryCode = cCPickerSignUp!!.selectedCountryCodeWithPlus
        }
    }

    private fun callSignUpApi(firstNameStr: String, lastNameStr: String, emailStr: String, passwordStr: String, countryCode: String, mobile: String) {
        CommonUtil.showLoadingProgress(this@SignUpActivity)
        GbusinessService.create(this).userRegistration(firstNameStr, lastNameStr, emailStr, passwordStr, countryCode, mobile)
            .enqueue(object : Callback<Any> {
                override fun onResponse(call: Call<Any>, response: Response<Any>) {
                    CommonUtil.dismissLoadingProgress()
                    val gson = Gson()
                    if (response.code() == 200) {


                            //CommonUtil.toast(mLoginResponse.message, this@LoginActivity)

                            //CommonUtil.customToast("Success!", mLoginResponse.message, this@LoginActivity, IonAlert.SUCCESS_TYPE)
                        val mSignUpResponse = gson.fromJson(gson.toJson(response.body()), SignupDataResponse::class.java)
                            if (mSignUpResponse?.success == true) {

                                CommonUtil.successToast("Success!", mSignUpResponse.message, this@SignUpActivity)

                                if (mSignUpResponse.message == "Thanks for signing up! You have registered successfully") {
                                    val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
                                    doAsync {
                                        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                                        startActivity(intent)
                                        finish()
                                    }
                                }
                            } else {
                                val errorBody = gson.fromJson(gson.toJson(response.body()), SignupDataErrorResponse::class.java)
                                if (errorBody != null) {
                                    alertErrorDialog(errorBody)
                                }

                            }
                    } else if (response.code() == 500) {
                        val ionAlert = IonAlert(this@SignUpActivity, IonAlert.ERROR_TYPE)
                        ionAlert.titleText = "Server Error!"
                        ionAlert.contentText = "Server is not responding at present."
                        ionAlert.show()
                        //CommonUtil.toastError("Server is not responding at present.", this)
                        CommonUtil.successToast("Server Error!", "Server isn't responding currently.", this@SignUpActivity)
                    } else if (response.code() == 404) {
                        val errorBodyResponse = gson.fromJson(gson.toJson(response.errorBody()), SignupDataResponse::class.java)
                        try {
                            if (errorBodyResponse != null) {
                                if (!errorBodyResponse.success) {
                                    val ionAlert = IonAlert(this@SignUpActivity, IonAlert.ERROR_TYPE)
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
                    //launchActivity<LoginActivity>()
                }

                override fun onFailure(call: Call<Any>, t: Throwable) {
                    CommonUtil.dismissLoadingProgress()
                }
            })
    }

    fun alertErrorDialog(errorBody: SignupDataErrorResponse) {
        var dialog: Dialog? = null
        try {
            if (dialog != null) {
                dialog.dismiss()
                dialog = null
            }
            dialog = Dialog(this, R.style.AppCompatAlertDialogStyleBig)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.window!!.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT
            );
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setCancelable(false)
            val mInflater = LayoutInflater.from(this)
            mViewError = mInflater.inflate(R.layout.dlg_error_msg_signup, null, false)
            val finalDialog: Dialog = dialog
            val emailError = errorBody.error.email
            val mobileNumberError = errorBody.error.phone


            if (emailError != null) {
                mViewError.tvEmailError.text = errorBody.error.email[0]
                mViewError.tvEmailError.visibility = View.VISIBLE
            } else {
                mViewError.tvEmailError.visibility = View.GONE
            }

            if (mobileNumberError != null) {
                mViewError.tvMobileError.text = errorBody.error.phone[0]
                mViewError.tvMobileError.visibility = View.VISIBLE
            } else {
                mViewError.tvMobileError.visibility = View.GONE
            }

            mViewError.tvCancelError.setOnClickListener {
                finalDialog.dismiss()
            }
            dialog.setContentView(mViewError)
            dialog.show()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }


    private fun getFireBaseToken(): String {
        var newToken = "null"
        FirebaseInstanceId.getInstance().instanceId.addOnSuccessListener(
            this) { instanceIdResult ->
            newToken = instanceIdResult.token
            Log.i("newToken", newToken)
        }
        CommonUtil.saveStringPreferences(this, AppConstants.TOKEN_FIREBASE, newToken)
        return newToken
    }

    private fun isValidate(): Boolean {
        when {
            TextUtils.isEmpty(etFirstNameSignUp.text.toString()) -> {
                etFirstNameSignUp.error = "First name can't be empty."
                etFirstNameSignUp.requestFocus()
                return false
            }
            TextUtils.isEmpty(etLastNameSignUp.text.toString()) -> {
                etLastNameSignUp.error = "Last name can't be empty."
                etLastNameSignUp.requestFocus()
                return false
            }
            TextUtils.isEmpty(etEmailSignUp.text.toString()) -> {
                etEmailSignUp.error = "Email can't be empty."
                etEmailSignUp.requestFocus()
                return false
            }
            isValidMail(etEmailSignUp.text.toString()) -> {
                etEmailSignUp.error = "Please enter valid e-mail."
                etEmailSignUp.requestFocus()
                return false
            }
            TextUtils.isEmpty(etPasswordSignUp.text.toString()) -> {
                etPasswordSignUp.error = "Password can't be empty."
                etPasswordSignUp.requestFocus()
                return false
            }
            TextUtils.isEmpty(etConfirmPasswordSignUp.text.toString()) -> {
                etConfirmPasswordSignUp.error = "Confirm password can't be empty."
                etConfirmPasswordSignUp.requestFocus()
                return false
            }
            TextUtils.isEmpty(etMobileSignUp.text.toString()) -> {
                etMobileSignUp.error = "Mobile number can't be empty."
                etMobileSignUp.requestFocus()
                return false
            }
            isValidMobile(etMobileSignUp.text.toString()) -> {
                etMobileSignUp.error = "Please enter valid mobile."
                etMobileSignUp.requestFocus()
                return false
            }
            else -> return true
        }
    }

    private fun isValidMail(mail: String?): Boolean {
        val pattern: Pattern
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z0-9]+\\.+[a-z]+"
        pattern = Pattern.compile(emailPattern)
        val matcher: Matcher = pattern.matcher(mail)
        return !matcher.matches()
    }

    private fun isValidMobile(mobile: String?): Boolean {
        val pattern: Pattern
        val mobilePattern = "^[1-9][0-9]{9}$"
        pattern = Pattern.compile(mobilePattern)
        val matcher: Matcher = pattern.matcher(mobile)
        return !matcher.matches()
    }
}
