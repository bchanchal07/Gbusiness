package com.milkyway.gbusiness.fragments


import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.utils.CommonUtil
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.WalletBalanceDataClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.widget.*
import androidx.navigation.fragment.findNavController
import com.google.gson.JsonParser
import com.milkyway.gbusiness.models.PaynowDataClass
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class WithdrawalFragment : Fragment() {

    lateinit var mContext : Context
    lateinit var edTotalWalletAmount : EditText
    lateinit var edWithDrawAmount : EditText
    lateinit var edWithDrawAmountInRupee : EditText
    lateinit var edWithDrawDetails : EditText
    lateinit var withdrawlCheckThree : CheckBox
    lateinit var withdrawlCheckTwo : CheckBox
    lateinit var withdrawlCheckOne : CheckBox
    private lateinit var myWithdrawalBack : ImageView
    lateinit var wallBal : String

    lateinit var withdrawPayNowBtn : TextView

     var payMode : String = "googlepay"
    var balance :Double = 0.00



    override fun onAttach(context: Context)
    {
        super.onAttach(context)

        mContext = context

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_with_darawl_fagment, container, false)

        edTotalWalletAmount = view.findViewById(R.id.edTotalWalletAmount)
        edWithDrawAmount = view.findViewById(R.id.edWithDrawAmount)
        edWithDrawAmountInRupee = view.findViewById(R.id.edWithDrawAmountInRupee)
        edWithDrawDetails = view.findViewById(R.id.edWithDrawDetails)
        withdrawPayNowBtn = view.findViewById(R.id.withdrawPayNowBtn)
         withdrawlCheckThree = view.findViewById(R.id.withdrawlCheckThree)
         withdrawlCheckTwo = view.findViewById(R.id.withdrawlCheckTwo)
        withdrawlCheckOne = view.findViewById(R.id.withdrawlCheckOne)
        withdrawlCheckThree.isChecked = true
        edWithDrawDetails.visibility = View.VISIBLE
        myWithdrawalBack = view.findViewById<ImageView>(R.id.myWithdrawalBack)
        myWithdrawalBack.setOnClickListener	 { findNavController().navigate(R.id.action_withDarawlFagment_to_mainFragment) }

        withdrawlCheckOne.setOnClickListener { checkOne() }
        withdrawlCheckTwo.setOnClickListener { checkTwo() }
        withdrawlCheckThree.setOnClickListener { checkThree() }
        withdrawPayNowBtn.setOnClickListener { paynow() }


        edWithDrawAmount.addTextChangedListener(object : TextWatcher
        {
            override fun afterTextChanged(p0: Editable?)
            {
                var enterdMoney =edWithDrawAmount.text.toString()
                if (!enterdMoney.equals(""))
                {
                  //  if (enterdMoney.toDouble() >= 15) {
                    if (wallBal.toDouble() >= 15.0) {
                        doAsync {

                            val url_str = "https://api.exchangerate-api.com/v4/latest/USD"


                            val url = URL(url_str)
                            val request = url.openConnection() as HttpURLConnection
                            request.connect()

                            val jp = JsonParser()
                            val root = jp.parse(InputStreamReader(request.getContent() as InputStream))
                            val jsonobj = root.asJsonObject

                            val jsonObject = jsonobj.getAsJsonObject("rates")
                            Log.i("dfdfd", jsonobj.toString())
                            Log.i("dfdfd", jsonObject.get("GBP").toString())



                            uiThread {
                                edWithDrawAmountInRupee.setText("1 USD : " + jsonObject.get("INR").toString() + " INR ")
                            }
                        }
                    } else CommonUtil.toast("your wallet balance is less than 15 usd",mContext)

                }




            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int)
            {

                edWithDrawAmountInRupee.setText("")


            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int)
            {

            }
        })


        getWalltBalApi()
        return view
    }

    //todo api for wath draw amount
    private fun paynow()
    {
        if (checkValidation()) {



            if (CommonUtil.checkNetwork(mContext)) {
                var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
              //  Log.i("TAGddad", userID)
               // Log.i("TAGddad", edWithDrawAmount.text.toString())
                //Log.i("TAGddad", payMode)
                //Log.i("TAGddad", edWithDrawDetails.text.toString())

                CommonUtil.showDialog(mContext)
                val dataNotic = GbusinessService.create(mContext)
                if (userID != null) {
                    dataNotic.getWithdrawalRequest(
                        "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),
                        userID,
                        edWithDrawAmount.text.toString().trim(),
                        payMode,
                        edWithDrawDetails.text.toString().trim()
                    ).enqueue(object : Callback<PaynowDataClass> {
                        override fun onFailure(call: Call<PaynowDataClass>, t: Throwable) {

                            CommonUtil.hideDialog(mContext)
                            CommonUtil.toast(R.string.showError.toString(), mContext)
                            CommonUtil.logi(t.localizedMessage.toString())
                        }

                        override fun onResponse(
                            call: Call<PaynowDataClass>,
                            response: Response<PaynowDataClass>
                        ) {
                            CommonUtil.hideDialog(mContext)
                            val getdata = response?.body()
                            // CommonUtil.logi(getdata.toString())
                            Log.i("TAGddad", getdata.toString())

                            if (getdata != null) {
                                if (getdata.success) {
                                    // Log.i("TAGddad", "jkfdjhfdjgf")
                                    edWithDrawAmount.setText("")
                                    edWithDrawAmountInRupee.setText("0")
                                    edWithDrawDetails.setText("")
                                    CommonUtil.toast(" Success ", mContext)
                                } else CommonUtil.toast(getdata.data, mContext)
                            } else CommonUtil.toast("SomeThing went Wrong", mContext)
                        }

                    })
                }

            } else {
                CommonUtil.toast("Check Internet", mContext)
            }
        }

    }

    private fun checkValidation(): Boolean
    {
        if (edTotalWalletAmount.text.toString().isEmpty())
        {
            edTotalWalletAmount.requestFocus()
            edTotalWalletAmount.error = "Refresh page"

            return false
        }
        if (edWithDrawAmount.text.toString().isEmpty())
        {
            edWithDrawAmount.requestFocus()
            edWithDrawAmount.error = "Enter USD"
            return false
        }
        var enterdMoney =edWithDrawAmount.text.toString()

        if (wallBal.toDouble() < 15)
        {
          //  CommonUtil.toast("minimum $15 is required",mContext)
            edWithDrawAmount.requestFocus()
            edWithDrawAmount.error = "minimum wallet balance $15  required"
            return false
        }

        if (edWithDrawDetails.text.toString().isEmpty())
        {
            edWithDrawDetails.requestFocus()
            edWithDrawDetails.error = "Enter details"
            return false
        }



        return true

    }


    private fun checkThree() {

        edWithDrawDetails.visibility = View.VISIBLE
        withdrawlCheckOne.isChecked = false
        withdrawlCheckTwo.isChecked = false

        payMode = "paytm"
    }

    private fun checkTwo() {


        edWithDrawDetails.visibility = View.VISIBLE
        withdrawlCheckOne.isChecked = false
        withdrawlCheckThree.isChecked = false
        payMode = "paypal"
    }

    private fun checkOne() {
        edWithDrawDetails.visibility = View.VISIBLE

        withdrawlCheckTwo.isChecked = false
        withdrawlCheckThree.isChecked = false
        payMode ="googlepay"
    }

    private fun getWalltBalApi()
    {
        if (CommonUtil.checkNetwork(mContext))
        {
            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)
            val dataNotic = GbusinessService.create(mContext)
            if (userID != null) {
                dataNotic.getWalletBalance("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), userID
                ).enqueue(object : Callback<WalletBalanceDataClass>{
                    override fun onFailure(call: Call<WalletBalanceDataClass>, t: Throwable) {

                        CommonUtil.hideDialog(mContext)
                        CommonUtil.toast(R.string.showError.toString(),mContext)
                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(
                        call: Call<WalletBalanceDataClass>,
                        response: Response<WalletBalanceDataClass>
                    ) {
                        CommonUtil.hideDialog(mContext)
                        val getdata = response?.body()
                        // CommonUtil.logi(getdata.toString())
                        Log.i("TAGddad", getdata.toString())

                        if (getdata != null) {
                            if (getdata.success)
                            {
                                if (getdata.data!=null && getdata.data.size>0)
                                {

                                     balance = getdata.data.get(0).balance
                                     wallBal =CommonUtil.decimslToString(balance)

                                    edTotalWalletAmount.setText("$ "+wallBal)

                                   /*
                                    var enterdMoney = edWithDrawAmount.text.toString()
                                    var usdIntoRupee = CommonUtil.convertUsdIntoINR()

                                    edWithDrawAmountInRupee.setText((usdIntoRupee.toDouble()*enterdMoney.toDouble()).toString() +" INR")*/



                                }

                            }
                            if(getdata.message!=null)  CommonUtil.toast(getdata.message,mContext)
                        }
                        else CommonUtil.toast("SomeThing went Wrong",mContext)
                    }

                })
            }
            // startActivity(Intent(this,OtpActivity::class.java))
        }
        else
        {
            CommonUtil.toast("Check Internet",mContext)
        }
    }


}

