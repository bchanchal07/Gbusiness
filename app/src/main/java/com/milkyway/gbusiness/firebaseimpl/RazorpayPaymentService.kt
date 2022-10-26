package com.milkyway.gbusiness.firebaseimpl

import android.annotation.SuppressLint
import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.ResultReceiver
import android.util.Log
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.api.PayPalRazorpayClient
import com.milkyway.gbusiness.models.RazorPayStatusINdb
import com.milkyway.gbusiness.models.RazorTransDetailsDataClass
import com.milkyway.gbusiness.fragments.PaymentFragment
import com.milkyway.gbusiness.fragments.PaymentStatusFragment.Companion.payStatusResult
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.utils.CommonUtil
import com.milkyway.gbusiness.utils.DateTimeUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import okhttp3.Credentials
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RazorpayPaymentService : IntentService("razorpay") {
    var mContext: Context = this
    var payID: String = "dummy"
    var orderId: String = "dummy"
    var successMsg: String = ""
    var receiver: ResultReceiver? = null

    @SuppressLint("CheckResult")
    override fun onHandleIntent(intent: Intent?) {
        /*
         * Step 1: We pass the ResultReceiver from the activity to the intent service via intent.
         *  */
        //final ResultReceiver receiver = intent.getParcelableExtra("receiver");
        receiver = intent?.getParcelableExtra("receiver")
        //TODO: process background task here!
        val amountPay = CommonUtil.run { getPreferencesString(mContext, AppConstants.RazorAmount) }

        Log.d("MainService:", "Service Started!")
        payID = intent?.extras?.get("payId").toString()
        orderId = intent?.extras?.get("orderId").toString()

        if (payID != null) {

            Log.i("pawan = payID =", payID)

            //val credentials = Credentials.basic("rzp_live_qZl14ZaFGphjhz","Axy88XZtnfVJzpOhLvF7LOKN") // live mode
            //val credentials = Credentials.basic("rzp_test_fThEOcFtsuRRzO", "cI3QgMuGZzval2q0fROXJKCk") //testing mode
            val credentials = Credentials.basic(AppConstants.RAZORPAY_TEST_KEY, AppConstants.RAZORPAY_TEST_SECRET) //testing mode vkp

            initRetrofitRazor(payID).getTransForRazorToken(credentials, amountPay!!, "INR")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(////* Log.d(TAG, token.access_token)
                    // { myAmount -> Log.d(TAG, myAmount.amount.toString())},
                    { myAmount -> getInfo(myAmount) },
                    { startBplanForPayment() }
                    //  { error -> Log.d("pawan", error.localizedMessage) }
                )
        }


    }


    private fun initRetrofitRazor(payID: String): PayPalRazorpayClient {
        return Retrofit.Builder()
            .baseUrl("https://api.razorpay.com/v1/payments/$payID/") //base url is same for both live and demo capture
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(PayPalRazorpayClient::class.java)
    }


    private fun getInfo(myAmount: RazorTransDetailsDataClass?) {
        Log.i("pawan", "getTransDetailsForRezorPay= getInfo  Start .....")

        val bankRefNo: String
        if (myAmount?.bank == null) bankRefNo = "no data" else bankRefNo = myAmount.bank.toString()
        //  Log.i("pawan", bankRefNo)
        //  MainService.yesTesting(myAmount,activity!!,bankRefNo)
        try {
            if (CommonUtil.checkNetwork(mContext)) {

                val userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
                val userToken = CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN)
                val invoiceID = PaymentFragment.invoic_id
                val paymentID = myAmount!!.id
                val captureStatus = myAmount.captured.toString()
                val capStatus = myAmount.status
                val type = myAmount.card.type
                val cardName = myAmount.card.name

                val amount = myAmount.amount.toString()
                val createdDate = myAmount.created_at
                val description = myAmount.description
                val createdAt = DateTimeUtils.dateStringFromSeconds(createdDate.toLong(), DateTimeUtils.DATE_FORMAT_33)


                //todo call update function
                updateRealm("razorpay", paymentID, invoiceID, userID, captureStatus, paymentID, bankRefNo, capStatus, type, cardName, "INR", amount, createdAt!!, description)

                //todo call send razor pay details to server online
                startAplanForPayment(userToken, paymentID, invoiceID, userID, captureStatus, paymentID, bankRefNo, capStatus, type, cardName, amount, createdAt!!, description)
            } else {
                //    CommonUtil.toast("Check Internet", mContext)
                Log.i("pawan", "finush Check Internet")
            }

        } catch (e: Exception) {
            Log.i("pawan error", e.localizedMessage)
        }
    }


    // todo relam dell this details after success full payment
    private fun delFromRealmDataBase(payId: String) {

        val realm = Realm.getDefaultInstance()
        realm.executeTransactionAsync({
            //realm.where(Dog.class).equalTo("age", 1).findFirst();
            val razorDetails = it.where(RealmStorageModelClass::class.java).equalTo("pay_id", payId).findFirst()
            razorDetails!!.deleteFromRealm()
        }, {
            Log.i("pawan", "On Success: Data Delete Successfully!")

        }, {
            Log.i("pawan", "REALM DELL ERROR")
            // Log.i("pawan",it.localizedMessage)
            stopSelf()
        })
    }


    override fun onCreate() {
        super.onCreate()
        Log.i("pawan", "MyCommonService onCreate() method is invoked.")
    }

    override fun onDestroy() {
        Log.i("pawan", "MyCommonService onDestroy() method is invoked.")
    }

    // todo relam update this details  with payment fields
    private fun updateRealm(s: String, paymentID: String, invoiceID: String, userID: String?, captureStatus: String, paymentID1: String, bank_ref_no: String, capStatus: String, type: String, cardName: String, s11: String, amount: String, createdAt: String, description: String) {
        val realm = Realm.getDefaultInstance()
        realm.executeTransactionAsync({
            //realm.where(Dog.class).equalTo("age", 1).findFirst();
            val razorDetails = it.where(RealmStorageModelClass::class.java).equalTo("pay_id",
                payID
            ).findFirst()

            razorDetails?.payMethod = "razorpay"
            razorDetails?.paytype = "razorpay"
            razorDetails?.pay_id = paymentID
            razorDetails?.invoice_id = invoiceID
            razorDetails?.user_id = userID
            razorDetails?.captured = captureStatus
            razorDetails?.transaction_id = paymentID1
            razorDetails?.bank_ref_no = bank_ref_no
            razorDetails?.order_status = capStatus
            razorDetails?.failure_message = null
            razorDetails?.payment_mode = type
            razorDetails?.card_name = cardName
            razorDetails?.currency = s11
            razorDetails?.amount = amount
            razorDetails?.created_at = createdAt
            razorDetails?.domain_name = description
            razorDetails?.status = "1"
            razorDetails?.workingStage = "2"

        }, {
            Log.i("pawan", "On Success: Data Update Successfully!")

        }, {
            Log.i("pawan", " REALM UPDATE DATA ERROR")
            //Log.i("pawan",it.localizedMessage)
        })

    }


    private fun startAplanForPayment(
        userToken: String?, paymentID: String, invoiceID: String, userID: String?, captureStatus: String,
        paymentID1: String, bankRefNo: String, capStatus: String, type: String, cardName: String, amount: String,
        createdAt: String, description: String,
    ) {
        Log.i("pawan", "pain A Start")
        //Toast.makeText(applicationContext, "Start Razorpay success API", Toast.LENGTH_LONG).show()
        val dataNotic = GbusinessService.create(this)
        if (userID != null) {
            dataNotic.sendRazorPayDetails("Bearer $userToken", paymentID, invoiceID, userID, captureStatus, paymentID,
                bankRefNo, capStatus, "null", type, cardName, "INR", amount, createdAt, description, "1"
            ).enqueue(object : Callback<RazorPayStatusINdb> {
                override fun onFailure(call: Call<RazorPayStatusINdb>, t: Throwable) {
                    /*    CommonUtil.hideDialog(mContext)*/
                    // CommonUtil.toast(t.localizedMessage, mContext)
                    CommonUtil.logi(t.localizedMessage.toString())
                    Log.i("pawan plan one", t.localizedMessage.toString())
                }

                override fun onResponse(
                    call: Call<RazorPayStatusINdb>,
                    response: Response<RazorPayStatusINdb>,
                ) {
                    /*  CommonUtil.hideDialog(mContext)*/
                    //  Log.i("pawan", response.body()?.success.toString())
                    val getdata = response.body()
                    when (response.code()) {
                        200 -> {
                            if (getdata != null) {
                                Log.i("pawan", "finush not null")
                                if (getdata.success) {
                                    //Toast.makeText(applicationContext, "Razorpay success Response", Toast.LENGTH_LONG).show()
                                    /*
                                     * Step 2: Now background service is processed,
                                     * we can pass the status of the service back to the activity using the resultReceiver
                                     * */


                                    Log.i("pawan", "PAYMENT SUCCESSFUL FOR ${getdata.pay_id}")
                                    //Toast.makeText(mContext, "Payment successful for payId: ${getdata.pay_id}", Toast.LENGTH_LONG).show()
                                    delFromRealmDataBase(getdata.pay_id)
                                    if (getdata.message.contentEquals("Payment completed successfully")) {
                                        successMsg = getdata.message
                                        val b = Bundle()
                                        b.putString("message", successMsg)
                                        receiver!!.send(AppConstants.STATUS_FINISHED, b)
                                        payStatusResult.text = "Payment Success"

                                    }
                                    //if (!orderId.equals("service")) payStatusResult.text = "payment success "
                                }
                            } else Log.i("pawan", "finush not")
                        }
                        /*500 -> {
                            //CommonUtil.successToast("Server Error!", "Server isn't responding currently.", mContext)
                            val ionAlert = IonAlert(mContext, IonAlert.ERROR_TYPE)
                            ionAlert.titleText = "Server Error!"
                            ionAlert.contentText = "Server isn't responding currently."
                            ionAlert.show()
                        }*/
                    }
                }
            })
        }
    }


    private fun startBplanForPayment() {
        val realm = Realm.getDefaultInstance()
        try {
            Log.i("pawan", "plan B Start")
            var response = ""
            realm.executeTransactionAsync { it ->
                //realm.where(Dog.class).equalTo("age", 1).findFirst();
                val razorDetails = it.where(RealmStorageModelClass::class.java).equalTo("pay_id", payID).findAll()
                if (razorDetails.size > 0) {
                    razorDetails.forEach {
                        response = response + "paytype: ${it.pay_id}, payType: ${it.paytype}" + "\n"

                        startAplanForPayment(
                            CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),
                            it.pay_id!!,
                            it.invoice_id!!,
                            it.user_id,
                            it.captured!!,
                            it.pay_id!!,
                            it.bank_ref_no!!,
                            it.order_status!!,
                            it.payment_mode!!,
                            it.card_name!!,
                            it.amount!!,
                            it.created_at!!,
                            it.domain_name!!
                        )
                    }
                    Log.i("pawan planBres  = ", response)
                }
            }
        } finally {
            realm?.close()
        }
    }
}