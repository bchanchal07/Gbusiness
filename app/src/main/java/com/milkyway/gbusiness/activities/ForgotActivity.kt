package com.milkyway.gbusiness.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import androidx.core.view.isVisible
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.global.CommonUtil
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.ForgetPasswordDataClass
import kotlinx.android.synthetic.main.activity_forgot.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForgotActivity : AppCompatActivity() {

    lateinit var checkboxOne : CheckBox
    lateinit var checkboxTwo : CheckBox
    lateinit var checkboxThree : CheckBox

    lateinit var recovery_type : String
    lateinit var security_answer : String
    var selectQuestion : Boolean =false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)


        val email = intent.extras?.getString("emailaddress")
        if (email != null) {
            Log.i("fjd",email)
        }
        checkboxOne = findViewById(R.id.checkboxOne)
        checkboxTwo = findViewById(R.id.checkboxTwo)
        checkboxThree = findViewById(R.id.checkboxThree)

        checkboxOne.setOnClickListener { conditionOne() }
        checkboxTwo.setOnClickListener { conditionTwo() }
        checkboxThree.setOnClickListener { conditionThree() }



        forgetRecBtn.setOnClickListener{
            if (selectQuestion)
            {
                callAPiForQustn()

            }else
                callAPi(email)
        }


        inits()
    }


    private fun callAPiForQustn()
    {
       // Log.i("TAGad",security_answer)
        //Log.i("TAGad",forgotAnswerField.text.toString())
        if (security_answer.equals(forgotAnswerField.text.toString()))

        {
          //  withQustion = true

            val myOTP: String = security_answer

           // answer = myOTP
            var intent = Intent(this@ForgotActivity, ChangePasswordActivity::class.java)
            intent.putExtra("otp", myOTP)
            intent.putExtra("withQustion", true)
            startActivity(intent)
            finish()
        }else
        {
            CommonUtil.toast("wrong answer",this)
        }


    }


    private fun conditionOne()
    {
        checkboxOne.isChecked = true
        checkboxTwo.isChecked = false
        checkboxThree.isChecked = false
        selectQuestion = false
        if (tvShowQuestion.isVisible)  tvShowQuestion.visibility= View.GONE
        if (forgotAnswerField.isVisible)  forgotAnswerField.visibility= View.GONE

        recovery_type="email"

    }
    private fun conditionTwo()
    {
        selectQuestion = false

        checkboxOne.isChecked = false
        checkboxTwo.isChecked = true
        checkboxThree.isChecked = false
        if (tvShowQuestion.isVisible)  tvShowQuestion.visibility= View.GONE
        if (forgotAnswerField.isVisible)  forgotAnswerField.visibility= View.GONE

        recovery_type="phone"

    }
    private fun conditionThree()
    {
         recovery_type = "question"
        checkboxOne.isChecked = false
        checkboxTwo.isChecked = false
        checkboxThree.isChecked = true
         tvShowQuestion.visibility= View.GONE
         forgotAnswerField.visibility= View.GONE
        selectQuestion = false

    }

    private fun inits()
    {
        checkboxOne.isChecked = true
        recovery_type="email"

    }

    fun callAPi(email: String?)
    {

        if (!recovery_type.equals("null"))
        {
            Log.i("TAGad", "call api = "+recovery_type)
            //dataNotic.getForgotOtp(recovery_type,"Bearer " + CommonUtil.getPreferencesString(this@ForgotActivity, AppConstants.EMAIL))
            CommonUtil.showDialog(this@ForgotActivity)
            val dataNotic = GbusinessService.create(this)
            dataNotic.accountRecovery(recovery_type,email!!)
                .enqueue(object : Callback<ForgetPasswordDataClass>
                {
                    override fun onFailure(call: Call<ForgetPasswordDataClass>, t: Throwable) {
                        CommonUtil.hideDialog(this@ForgotActivity)
                        CommonUtil.toast(R.string.showError.toString(),this@ForgotActivity)
                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(call: Call<ForgetPasswordDataClass>, response: Response<ForgetPasswordDataClass>) {
                        CommonUtil.hideDialog(this@ForgotActivity)

                        //  Log.i("TAGad", response.body()?.success.toString())

                        val getdata = response.body()
                        CommonUtil.logi(getdata.toString())
                        if (getdata!=null)
                        {

                            if (getdata.success)
                            {
                               if (getdata.data!=null) CommonUtil.toast(getdata.data,this@ForgotActivity)

                                if (recovery_type.equals("question"))
                                {

                                   var question = getdata.question
                                    security_answer = getdata.security_question

                                    if (!tvShowQuestion.isVisible)  tvShowQuestion.visibility= View.VISIBLE
                                    if (!forgotAnswerField.isVisible)  forgotAnswerField.visibility= View.VISIBLE

                                      tvShowQuestion.setText(question)
                                      selectQuestion =true

                                }
                                else
                                {
                                    val myOTP: String = getdata.otp.toString()
                                    val intent = Intent(this@ForgotActivity, ChangePasswordActivity::class.java)
                                    intent.putExtra("otp", myOTP)
                                    startActivity(intent)
                                    finish()
                                }


                            }else
                            {
                                CommonUtil.toast("Something went wrong",this@ForgotActivity)
                            }
                        }
                    }

                })

        }
    }




}

