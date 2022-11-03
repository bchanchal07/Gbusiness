package com.milkyway.gbusiness.firebaseimpl

import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.util.Log
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.global.CommonUtil
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.api.PayPalRazorpayClient
import com.milkyway.gbusiness.models.sendPayalCredentailsToServerDataClass
import com.milkyway.gbusiness.fragments.PaymentStatusFragment.Companion.payStatusResult
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.Credentials
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import io.realm.Realm



class PayPalPaymentService : IntentService("paypal") {
    lateinit var payID: String
    lateinit var invoice: String

    lateinit var orderId: String
    var mContext: Context = this

    override fun onHandleIntent(intent: Intent?) {

        payID = intent?.getExtras()?.get("payId").toString()
        orderId = intent?.getExtras()?.get("orderId").toString()
        invoice = intent?.getExtras()?.get("invoice").toString()

        Log.i("paypal", "start paypal payment =" + invoice)

      //  getInVoiceID(payID)

            if (payID != null) {
                Log.i("paypal", "start paypal payment =" + payID)


                val CONFIG_CLIENT_ID = resources.getString(R.string.configClintID)
                val CONFIG_SEC_ID = resources.getString(R.string.secID)
                val credentials = Credentials.basic(
                    CONFIG_CLIENT_ID,
                    CONFIG_SEC_ID
                )

                initRetrofit().getAccessToken(credentials, "client_credentials")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        { token -> getTransationDetails(token.access_token)/* Log.d(TAG, token.access_token)*/ },
                        { error -> Log.d("TAG", error.localizedMessage) }
                    )
            }
    }


    private fun initRetrofit(): PayPalRazorpayClient {
        return Retrofit.Builder()
           .baseUrl("https://api.paypal.com") // live
           // .baseUrl("https://api.sandbox.paypal.com") //sandbox
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(PayPalRazorpayClient::class.java)
    }

    //todo send payid and access token to server
    private fun getTransationDetails(accessToken: String) {

        if (CommonUtil.checkNetwork(mContext)) {

            Log.i("paypal", "getTransationDetails  accessToken = " + accessToken)
            Log.i("paypal ", "invoic_id = " + invoice)

            val dataNotic = GbusinessService.create(this)
            //   Log.i("TAGad", "aaaaaaaaaaaaaaaaaaaaa")
            //  Log.i("TAGad accessToken =", accessToken)
            // Log.i("TAGad payID =", payID)
            Log.i("paypal link =", "https://api.paypal.com/v1/payments/payment/") //live

//https://api.sandbox.paypal.com/v1/payments/payment/  for sandbox
            //  CommonUtil.showDialog(mContext)
            dataNotic.sendPaypalDetailsTOServer(
                "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),
                accessToken,
                payID,
                "https://api.paypal.com/v1/payments/payment/",
                invoice

            )
                .enqueue(object : Callback<sendPayalCredentailsToServerDataClass> {
                    override fun onFailure(
                        call: Call<sendPayalCredentailsToServerDataClass>,
                        t: Throwable
                    ) {
                        // Log.i("TAGad", "fgsfdjgifidgfdgifgfgggggg")
                        Log.i("paypal", "error"+t.localizedMessage)

                    }

                    override fun onResponse(
                        call: Call<sendPayalCredentailsToServerDataClass>,
                        response: Response<sendPayalCredentailsToServerDataClass>
                    ) {


                        val getdata = response.body()
                        //   CommonUtil.logi(getdata.toString())
                        Log.i("paypal", getdata.toString())
                        if (getdata != null) {

                            if (getdata.success) {

                                Log.i("paypal", "payment success for palpal")
                                delRealmDetails(payID)
                                if (!orderId.equals("service")) payStatusResult.setText("payment success")

                            } else {
                                // CommonUtil.toast("please enter valid current password", mContext)
                                Log.i("paypal", "get fails for payment")

                            }
                        } else Log.i("paypal", "SomeThing went wrong")
                        //   CommonUtil.toast("SomeThing went wrong", mContext)


                    }

                })

            // startActivity(Intent(this,OtpActivity::class.java))


        } else {
            CommonUtil.toast("Check Internet", mContext)
        }

    }

    fun delRealmDetails(payID: String) {
        val realm = Realm.getDefaultInstance()
        try {


            // Log.i("reaml", " test for del!")

            realm.executeTransactionAsync({
                val razorDetails =
                    it.where(RealmStorageModelClass::class.java).equalTo("pay_id", payID)
                        .findFirst()
                razorDetails!!.deleteFromRealm()
            }, {
                Log.i("paypal reaml", " Data Delete Successfully!")
            }, {
               // Log.i("paypal reaml ", it.localizedMessage)
                Log.i("reaml", "error in paypal service")
            })
        } finally {
            if (realm != null) realm.close()
        }

    }


   /* private fun getInVoiceID(payID: String) {


        val realm = Realm.getDefaultInstance()

        try {


            realm.executeTransactionAsync({
                val razorDetails =
                    it.where(RealmStorageModelClass::class.java).equalTo("pay_id", payID).findAll()
                // invoiceID =  razorDetails?.invoice_id!!
                if (razorDetails.size > 0)
                {
                   *//* razorDetails.forEach {
                        invoiceID = it.invoice_id!!
                    }*//*
                }


            }, {
                Log.i("reaml", " get invoice")


            }, {
                Log.i("reaml", it.localizedMessage)
            })
           // Log.i("paypal", " get invoice = " + invoiceID)


        } finally {
            if (realm != null) realm.close()
        }
    }*/
}