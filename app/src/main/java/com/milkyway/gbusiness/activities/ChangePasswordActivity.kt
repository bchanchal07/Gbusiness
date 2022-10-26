package com.milkyway.gbusiness.activities

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.ForgetPasswordDataClass
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.utils.CommonUtil
import kotlinx.android.synthetic.main.activity_change_password.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChangePasswordActivity : AppCompatActivity() {

    var otp: String? = null
    var withQustion: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        otp = intent.extras?.getString("otp")
        withQustion = intent.extras!!.getBoolean("withQustion")
        if (withQustion) edtRefCode.setText(otp)

        findViewById<TextView>(R.id.changePasswordBtn).setOnClickListener { veryOTP() }


    }

    private fun veryOTP() {
        if (checkValidation()) {
            if (otp != null) {
                if (withQustion) {
                    callAPiWithQustn()

                } else {
                    withQustion = false
                    //  Log.i("djfa",otp)
                    //  Log.i("djfa",edtPassword.text.toString().trim())
                    if (edtRefCode.text.toString().trim().equals(otp)) {
                        callAPiWithQustn()

                    } else CommonUtil.toast("Otp not match", this)
                }

            }

        }

    }

    private fun checkValidation(): Boolean {


        if (edtRefCode.text!!.isEmpty()) {
            edtRefCode.requestFocus()
            edtRefCode.error = "Enter Ref. Code"
            return false
        }
        if (edtPassword.text!!.isEmpty()) {
            edtPassword.requestFocus()
            edtPassword.error = "Enter new Password"
            return false
        }
        if (edtConfirmPassword.text!!.isEmpty()) {
            edtConfirmPassword.requestFocus()
            edtConfirmPassword.error = "Enter Confirm Password"
            return false
        }

        if (!edtPassword.text.toString().equals(edtConfirmPassword.text.toString())) {
            CommonUtil.toast("match not password", this)
            return false
        }
        if (edtPassword.text.toString().count() < 6) {
            CommonUtil.toast("Password must be 6 digit", this)
            return false
        }
        if (edtConfirmPassword.text.toString().count() < 6) {
            CommonUtil.toast("Password must be 6 digit", this)
            return false
        }

        return true
    }


    fun callAPiWithQustn() {

        //dataNotic.getForgotOtp(recovery_type,"Bearer " + CommonUtil.getPreferencesString(this@ChangePasswordActivity, AppConstants.EMAIL))
        CommonUtil.showDialog(this@ChangePasswordActivity)
        val dataNotic = GbusinessService.create(this)
        dataNotic.accountRecoverywithQustn(CommonUtil.getPreferencesString(this, AppConstants.USER_ID)!!, otp!!, edtPassword.text.toString())
            .enqueue(object : Callback<ForgetPasswordDataClass> {
                override fun onFailure(call: Call<ForgetPasswordDataClass>, t: Throwable) {
                    CommonUtil.hideDialog(this@ChangePasswordActivity)
                    CommonUtil.toast(R.string.showError.toString(), this@ChangePasswordActivity)
                    CommonUtil.logi(t.localizedMessage.toString())
                }

                override fun onResponse(call: Call<ForgetPasswordDataClass>, response: Response<ForgetPasswordDataClass>) {
                    CommonUtil.hideDialog(this@ChangePasswordActivity)

                    //  Log.i("TAGad", response.body()?.success.toString())

                    val getdata = response.body()
                    CommonUtil.logi(getdata.toString())
                    if (getdata != null) {

                        if (getdata.success) {
                            if (getdata.data != null) CommonUtil.toast(getdata.data, this@ChangePasswordActivity)


                            var intent = Intent(this@ChangePasswordActivity, LoginActivity::class.java)
                            startActivity(intent)
                            finish()


                        } else {
                            CommonUtil.toast(R.string.showError.toString(), this@ChangePasswordActivity)
                        }
                    }
                }

            })

    }

}
