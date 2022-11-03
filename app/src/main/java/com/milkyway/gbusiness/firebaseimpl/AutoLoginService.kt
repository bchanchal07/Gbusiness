package com.milkyway.gbusiness.firebaseimpl

import android.annotation.SuppressLint
import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.ResultReceiver
import android.util.Log
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.milkyway.gbusiness.retrofit.ApiCall
import com.milkyway.gbusiness.models.AutoLoginWhmcsResponse
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.global.CommonUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class AutoLoginService : IntentService("auto_login") {
    var mContext: Context = this
    var receiver: ResultReceiver? = null
    var invoiceId: Int? = null

    @SuppressLint("CheckResult")
    override fun onHandleIntent(intent: Intent?) {
        /*
         * Step 1: We pass the ResultReceiver from the activity to the intent service via intent.
         *  */
        //final ResultReceiver receiver = intent.getParcelableExtra("receiver");
        receiver = intent?.getParcelableExtra("autologin_receiver")
        invoiceId = intent?.getIntExtra("invoiceId", 0)

        //TODO: process background task here!
        Log.d("AutoLoginService:", "Service Started!")

        if (receiver != null) {
            val userEmail = CommonUtil.getPreferencesString(mContext, AppConstants.EMAIL)!!
            initRetrofitRazor().autoLoginWHMCS(userEmail)
                .enqueue(object : Callback<AutoLoginWhmcsResponse> {
                    override fun onResponse(call: Call<AutoLoginWhmcsResponse>, response: Response<AutoLoginWhmcsResponse>) {

                        when (response.code()) {
                            200 -> {
                                val autoLoginResponse = response.body()
                                if (autoLoginResponse!!.success) {
                                    val b = Bundle()
                                    b.putString("autoLoginUrl", autoLoginResponse.data)
                                    b.putInt("invoiceId", invoiceId!!)
                                    receiver!!.send(AppConstants.STATUS_FINISHED, b)
                                }
                            }
                            /*500 -> {
                                val ionAlert = IonAlert(mContext, IonAlert.ERROR_TYPE)
                                ionAlert.titleText = "Server Error!"
                                ionAlert.contentText = "Server is not responding at present."
                                ionAlert.show()
                            }*/
                        }
                    }

                    override fun onFailure(call: Call<AutoLoginWhmcsResponse>, t: Throwable) {
                        CommonUtil.toast(t.message!!, mContext)
                    }
                })
        }
    }

    private fun initRetrofitRazor(): ApiCall {
        return Retrofit.Builder()
            .baseUrl("https://www.gbusiness.co/api/") //base url is same for both live and demo capture
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(ApiCall::class.java)
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("AutoLoginService", "onCreate() method is invoked.")
    }

    override fun onDestroy() {
        Log.i("AutoLoginService", "onDestroy() method is invoked.")
    }
}