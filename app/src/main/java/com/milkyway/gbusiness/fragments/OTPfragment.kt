package com.milkyway.gbusiness.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.utils.CommonUtil
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.UpdatePhone
import com.pawegio.kandroid.textWatcher
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class OTPfragment : Fragment() {

    lateinit var mContext: Context
    lateinit var otpFieldOne : EditText
    lateinit var otpFieldTwo : EditText
    lateinit var otpFieldThree : EditText
    lateinit var otpFieldFour : EditText
    lateinit var otpFieldFive : EditText
    lateinit var otpFieldSix : EditText

    override fun onAttach(context: Context) {
        super.onAttach(context)

        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_otpfragment, container, false)

        val updatePhone = arguments?.getString("phNumber")
        val cuntryCode = arguments?.getString("cuntryCode")

        //  Log.i("otp - ",updatePhone)

        otpFieldOne = view.findViewById(R.id.otpFieldOne)
        otpFieldTwo = view.findViewById(R.id.otpFieldTwo)
        otpFieldThree = view.findViewById(R.id.otpFieldThree)
        otpFieldFour = view.findViewById(R.id.otpFieldFour)
        otpFieldFive = view.findViewById(R.id.otpFieldFive)
        otpFieldSix = view.findViewById(R.id.otpFieldSix)


        otpFieldOne.textWatcher { afterTextChanged { otpFieldTwo.requestFocus() } }
        otpFieldTwo.textWatcher { afterTextChanged { otpFieldThree.requestFocus() } }
        otpFieldThree.textWatcher { afterTextChanged { otpFieldFour.requestFocus() } }
        otpFieldFour.textWatcher { afterTextChanged { otpFieldFive.requestFocus() } }
        otpFieldFive.textWatcher { afterTextChanged { otpFieldSix.requestFocus() } }

        view.findViewById<CardView>(R.id.otpSubmitBtn).setOnClickListener {verifyMobileNumber(updatePhone)  }
        view.findViewById<ImageView>(R.id.myOtpBack).setOnClickListener { view.findNavController().navigate(R.id.action_OTPfragment_to_profileFragment)  }

        return view
    }


    private fun verifyMobileNumber(updatePhone: String?)
    {

        if (CommonUtil.checkNetwork(mContext))
        {

            if (checkValidation())
            {
                val setOtp = otpFieldOne.text.toString()+otpFieldTwo.text.toString()+otpFieldThree.text.toString()+otpFieldFour.text.toString()+otpFieldFive.text.toString()+otpFieldSix.text.toString()

                val userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
                CommonUtil.showDialog(mContext)
                val dataNotic = GbusinessService.create(mContext)
                if (userID != null) {
                    dataNotic.verifyMobileNumber("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),userID,setOtp,updatePhone!!
                    ).enqueue(object : Callback<UpdatePhone> {
                        override fun onFailure(call: Call<UpdatePhone>, t: Throwable)
                        {
                            CommonUtil.hideDialog(mContext)
                            CommonUtil.toast(R.string.showError.toString(),mContext)
                            CommonUtil.logi(t.localizedMessage.toString())
                        }

                        override fun onResponse(
                            call: Call<UpdatePhone>,
                            response: Response<UpdatePhone>
                        )
                        {
                            CommonUtil.hideDialog(mContext)
                            val getdata = response?.body()
                          //  Log.i("web", getdata.toString())


                            if (getdata != null)
                            {
                                if (getdata.success)
                                {
                                    val bundle = Bundle()

                                    findNavController().navigate(R.id.action_OTPfragment_to_profileFragment,bundle)
                                }
                                if (getdata.data!=null) CommonUtil.toast(getdata.data,mContext)


                            }  else CommonUtil.toast(R.string.showError.toString(),mContext)


                        }
                    })
                }

            }else
            {
                CommonUtil.toast("Enter Otp",mContext)

            }


        }
        else
        {
            CommonUtil.toast("Check Internet",mContext)
        }

    }

    private fun checkValidation(): Boolean
    {
        if (otpFieldOne.text.isNullOrEmpty() || otpFieldTwo.text.isNullOrEmpty() || otpFieldThree.text.isNullOrEmpty() || otpFieldFour.text.isNullOrEmpty() || otpFieldFive.text.isNullOrEmpty()
            || otpFieldSix.text.isNullOrEmpty())
        {return false}

        return true

    }

}
