package com.milkyway.gbusiness.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.utils.CommonUtil
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.OptBySignUPGmailDataClass

import com.milkyway.gbusiness.models.PhoneVerificationDataClass
import com.pawegio.kandroid.textWatcher
import kotlinx.android.synthetic.main.activity_otp.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OtpActivity : AppCompatActivity(){


    private lateinit var setOtp :String
    var email :String? =null
    var password :String? =null
    var otp : String? = null

    var phoneNumber : String? = null
    var professionSelected : String? = null
    var refcode : String? = null
    var countryCode : String? = null

    companion object
    {
        var openBy :String = "null"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)

        if (openBy == "phoneActivity")
        {
            phoneNumber = intent.extras?.getString("phoneNumber")
            professionSelected = intent.extras?.getString("professionSelected")
            refcode = intent.extras?.getString("refcode")
            countryCode = intent.extras?.getString("countryCode")

        }else
        {
            email=intent.getStringExtra("email")
            password=intent.getStringExtra("password")
            otp=intent.getStringExtra("otp")
        }


        inti()

        fieldOne.textWatcher { afterTextChanged { fieldTwo.requestFocus() } }
        fieldTwo.textWatcher { afterTextChanged { fieldThree.requestFocus() } }
        fieldThree.textWatcher { afterTextChanged { fieldFour.requestFocus() } }
        fieldFour.textWatcher { afterTextChanged { fieldFive.requestFocus() } }
        fieldFive.textWatcher { afterTextChanged { fieldSix.requestFocus() } }
        fieldSix.textWatcher { afterTextChanged { checkConnection() } }
    }

    private fun inti()
    {
        if (openBy == "phoneActivity")
        {
            submitBtn.setOnClickListener { verifyOTP() }
            resendOtp.setOnClickListener {reSendOtp(phoneNumber!!,professionSelected!!,refcode!!,countryCode!!)}

        }else
        {
            submitBtn.setOnClickListener { checkConnection() }
            resendOtp.setOnClickListener { CommonUtil.toast("coming coon",this@OtpActivity) }
        }


    }



    private fun verifyOTP()
    {

        var userID = CommonUtil.getPreferencesString(this, AppConstants.USER_ID)

        setOtp = fieldOne.text.toString()+fieldTwo.text.toString()+fieldThree.text.toString()+fieldFour.text.toString()+fieldFive.text.toString()+fieldSix.text.toString()
        CommonUtil.showDialog(this)

        if (userID != null) {
            Log.i("mu",userID)
        }

        val dataNotic = GbusinessService.create(this)
        if (userID != null) {
            dataNotic.getOtpVerification(setOtp, userID)
                .enqueue(object : Callback<OptBySignUPGmailDataClass> {
                override fun onFailure(call: Call<OptBySignUPGmailDataClass>, t: Throwable) {
                    CommonUtil.hideDialog(this@OtpActivity)
                    CommonUtil.toast(t.localizedMessage, this@OtpActivity)
                    CommonUtil.logi(t.localizedMessage.toString())
                }

                override fun onResponse(call: Call<OptBySignUPGmailDataClass>, response: Response<OptBySignUPGmailDataClass>) {
                    CommonUtil.hideDialog(this@OtpActivity)

                    Log.i("professddion", response.body().toString())
                    val getdata = response.body()
                    CommonUtil.logi(getdata.toString())

                    if (getdata != null)
                    {
                        if (getdata.success)
                        {
                            if(getdata.data!=null)
                            {
                                if (getdata.data.email!=null) CommonUtil.saveStringPreferences(this@OtpActivity, AppConstants.EMAIL, getdata.data.email)
                                if (getdata.data.full_name!=null) CommonUtil.saveStringPreferences(this@OtpActivity, AppConstants.FULL_NAME, getdata.data.full_name)
                                if (getdata.data.phone!=null) CommonUtil.saveStringPreferences(this@OtpActivity, AppConstants.MOBILE, getdata.data.phone)
                                if (getdata.data.user_id!=null) CommonUtil.saveStringPreferences(this@OtpActivity, AppConstants.USER_ID,getdata.data.user_id.toString())


                            }
                            if(getdata.token!=null) CommonUtil.saveStringPreferences(this@OtpActivity, AppConstants.TOKEN,getdata.token.toString())
                            if(getdata.message!=null) CommonUtil.toast(getdata.message,this@OtpActivity)

                            if (getdata.token!=null)
                            {
                                val intent = Intent(this@OtpActivity, MainActivity::class.java)
                                intent.flags=Intent.FLAG_ACTIVITY_CLEAR_TOP

                                startActivity(intent)


                            }else
                            {
                                CommonUtil.toast("some thing went wrong ",this@OtpActivity)

                            }

                        }
                        else CommonUtil.toast("some thing went wrong try again ",this@OtpActivity)

                    }
                    else CommonUtil.toast("some thing went wrong try again ",this@OtpActivity)

                }

            })
        }
        // startActivity(Intent(this,OtpActivity::class.java))
     else
    {
        CommonUtil.toast("Check Internet",this@OtpActivity)
    }


    }

    private fun checkConnection()
    {
        if(checkStatus())
        {


            setOtp = fieldOne.text.toString()+fieldTwo.text.toString()+fieldThree.text.toString()+fieldFour.text.toString()+fieldFive.text.toString()+fieldSix.text.toString()

           if (setOtp==otp)
           {
               val myInt = Intent(this, MainActivity::class.java)
               myInt.flags=Intent.FLAG_ACTIVITY_CLEAR_TOP

               startActivity(myInt)


           }else
           {
              // CommonUtil.toast("invalid otp",this)
           }

        }
    }

    //check valdation
    fun checkStatus(): Boolean
    {
        if (fieldOne.text.toString().isEmpty())

        {
            fieldOne.requestFocus()
            fieldOne.error="Enter Number "
            return false
        }
        if (fieldTwo.text.toString().isEmpty())

        {
            fieldTwo.requestFocus()
            fieldTwo.error="Enter Number"
            return false
        }
        if (fieldThree.text.toString().isEmpty())

        {
            fieldThree.requestFocus()
            fieldThree.error="Enter Number"
            return false
        }
        if (fieldFour.text.toString().isEmpty())

        {
            fieldFour.requestFocus()
            fieldFour.error="Enter Number"
            return false
        }
        if (fieldFive.text.toString().isEmpty())

        {
            fieldFive.requestFocus()
            fieldFive.error="Enter Number"
            return false
        }
        if (fieldSix.text.toString().isEmpty())

        {
            fieldSix.requestFocus()
            fieldSix.error="Enter Number"
            return false
        }


        return true
    }

    private fun reSendOtp(phoneNumber : String, professionSelected : String,refcode : String,countryCode : String)
    {
        if (CommonUtil.checkNetwork(this))
        {
            /* Log.i("professddion id =",professionSelected)
             Log.i("professddion id2 =",CommonUtil.getPreferencesString(this, AppConstants.PROFESSION))*/
            var userID = CommonUtil.getPreferencesString(this, AppConstants.USER_ID)
            CommonUtil.showDialog(this)

            val dataNotic = GbusinessService.create(this)
            if (userID != null) {
                dataNotic.getPhoneVerification(
                    "Bearer " + CommonUtil.getPreferencesString(this, AppConstants.TOKEN), "application/json",
                    phoneNumber,
                    professionSelected!!,
                    refcode,
                    userID,
                    countryCode,
                    "code"
                ).enqueue(object : Callback<PhoneVerificationDataClass> {
                    override fun onFailure(call: Call<PhoneVerificationDataClass>, t: Throwable) {
                        CommonUtil.hideDialog(this@OtpActivity)
                        //  CommonUtil.toast(t.localizedMessage, this@PhoneNumberActivity)
                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(call: Call<PhoneVerificationDataClass>, response: Response<PhoneVerificationDataClass>) {
                        CommonUtil.hideDialog(this@OtpActivity)

                        Log.i("professddion", response.body().toString())
                        val getdata = response.body()
                        CommonUtil.logi(getdata.toString())


                        if (getdata != null)
                        {

                            if (getdata.success)
                            {
                                if(getdata.data!=null) CommonUtil.toast(getdata.data.toString(),this@OtpActivity)

                                openBy = "phoneActivity"
                                startActivity(Intent(this@OtpActivity, OtpActivity::class.java))

                            } else
                            {
                                if(getdata.error!=null)
                                {
                                    CommonUtil.toast(getdata.error, this@OtpActivity)

                                }
                            }

                        }else
                        {
                            CommonUtil.toast(R.string.showError.toString(), this@OtpActivity)
                        }

                    }

                })
            }
            // startActivity(Intent(this,OtpActivity::class.java))
        } else {
            CommonUtil.toast("Check Internet", this@OtpActivity)
        }
    }
}
