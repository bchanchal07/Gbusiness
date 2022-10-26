package com.milkyway.gbusiness.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.github.ybq.android.spinkit.style.CubeGrid
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.activities.MainActivity
import com.milkyway.gbusiness.firebaseimpl.RazorpayPaymentService
import com.milkyway.gbusiness.firebaseimpl.RazorpayResultReceiver
import com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass
import com.milkyway.gbusiness.fragments.PaymentFragment.Companion.invoic_id
import com.milkyway.gbusiness.fragments.PaymentFragment.Companion.totalPrice
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.utils.CommonUtil
import io.realm.Realm
import java.text.SimpleDateFormat
import java.util.*

class PaymentStatusFragment : Fragment(), RazorpayResultReceiver.AppReceiver {
    lateinit var payStatusInvoiceId: TextView
    lateinit var payStatusOrderId: TextView
    lateinit var payStatusDateTime: TextView
    lateinit var payStatusPayAmount: TextView
    lateinit var successImage: ImageView
    lateinit var mContext: Context
    var razorpayPaymentId: String = ""
    var razorpayOrderId: String = ""
    var razorpaySignature: String = ""
    var paymentMode: String = ""
    lateinit var resultReceiver: RazorpayResultReceiver


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    companion object {
        lateinit var payStatusResult: TextView
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val view = inflater.inflate(R.layout.fragment_payment_status, container, false)

        razorpayPaymentId = arguments?.getString("payId").toString()
        razorpayOrderId = arguments?.getString("orderId").toString()
        razorpaySignature = arguments?.getString("signature").toString()
        val sdf = SimpleDateFormat("dd/MM/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())
        payStatusResult = view.findViewById(R.id.payStatusResult)
        payStatusInvoiceId = view.findViewById(R.id.payStatusInvoiceId)
        payStatusOrderId = view.findViewById(R.id.payStatusOrderId)
        payStatusDateTime = view.findViewById(R.id.payStatusDateTime)
        payStatusPayAmount = view.findViewById(R.id.payStatusPayAmount)
        successImage = view.findViewById(R.id.successImage)

        payStatusResult.text = "PROCESSING"
        payStatusInvoiceId.text = "Invoice No-#$invoic_id"
        payStatusOrderId.text = razorpayOrderId
        payStatusDateTime.text = currentDate
        payStatusPayAmount.text = "$ $totalPrice"

        /*val credentials = Credentials.basic("rzp_test_Gv3wViqaGKhLio", "fv9Ecn2XwmxIxe0rbyvqGz0k") //testing mode vkp
        if(payID !=null){
            initRetrofitRazorpay(payID).getRazorpayCaptureStatus(credentials,)
        }*/
        paymentMode = if (razorpayPaymentId != null) {
            "razorpay"
        } else {
            "paypal"
        }

        if (paymentMode.contentEquals("paypal")) {
            /*val intentPayPalService = Intent(mContext, PayPalPaymentService::class.java)
            intentPayPalService.putExtra("payId", payID)
            intentPayPalService.putExtra("orderId", orderID)
            intentPayPalService.putExtra("invoice", getInvoiceID(payID))
            mContext.startService(intentPayPalService)
            Log.i("PayPalPaymentService", "start paypal")*/
        } else {
            /*
         * Step 2: We pass the ResultReceiver via the intent to the intent service
         * */
            if (verifySignature(razorpayOrderId, razorpayPaymentId, razorpaySignature)) {
                val intentRazorpayService = Intent(mContext, RazorpayPaymentService::class.java)
                resultReceiver = RazorpayResultReceiver(Handler(), this)
                intentRazorpayService.putExtra("receiver", resultReceiver)
                intentRazorpayService.putExtra("payId", razorpayPaymentId)
                intentRazorpayService.putExtra("orderId", razorpayOrderId)
                mContext.startService(intentRazorpayService)
                Log.i("RazorpayService", "start MainService")
            }
        }

        animation(view)
        //registerReceiver()
        //dummyUpdater()
        return view
    }

    private fun verifySignature(razorpayOrderId: String, razorpayPaymentId: String, razorpaySignature: String): Boolean {

        val data = "$razorpayOrderId|$razorpayPaymentId"
        val generatedSignature = CommonUtil.hmacWithJava("HmacSHA256", data, AppConstants.RAZORPAY_TEST_SECRET)
        //val signature = "e6d761bd7006127060ab7796611b010f7f6c999dbf14e348df70b0c749009e13"
        return generatedSignature.contentEquals(razorpaySignature)
        /*val data = "order_IwzKeC5Lpozw3v|pay_IwzLM0fzTgB6fM"
        val signature1 = CommonUtil.hmacWithJava("HmacSHA256", data, AppConstants.RAZORPAY_TEST_SECRET)
        val signature = "e6d761bd7006127060ab7796611b010f7f6c999dbf14e348df70b0c749009e13"
        Log.i("Signature:", "\nGenerated:$signature1\nRazorpay:$signature")
        if (signature1.contentEquals(signature)) {
            Toast.makeText(context, "Matched", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "Not Matched", Toast.LENGTH_LONG).show()
        }*/
    }

    private fun dummyUpdater() {
        val mRun = Thread(Runnable {
            Thread.sleep(10000)
            payStatusResult.text = "Success"
            Log.i("pawan", "start fun update")
        })
        mRun.start()
    }


    private fun animation(view: View) {
        val progressBar = view.findViewById(R.id.spin_kit) as ProgressBar
        val cubeGrid = CubeGrid()
        progressBar.indeterminateDrawable = cubeGrid
    }

    private fun getInvoiceID(payID: String): String {
        var responsed: String
        val realm = Realm.getDefaultInstance()
        try {
            var invoiceArray = realm.where(RealmStorageModelClass::class.java).equalTo("pay_id", payID).findAll()
            if (invoiceArray.size > 0) {
                invoiceArray.forEach {
                    responsed = it.invoice_id!!
                    return responsed
                }
            }
        } finally {
            realm?.close()
        }
        return "null"
    }

    override fun onReceiveResult(resultCode: Int, resultData: Bundle?) {
        /*
         * Step 3: Handle the results from the intent service here!
         * */

        if (resultReceiver != null) {
            //if(resultCode==RESULT_CODE_OK){
            if (resultData != null) {
                //resultReceiver.onReceiveResult(resultCode, resultData)
                val msg = resultData.getString("message")
                if (msg.contentEquals("Payment completed successfully")) {
                    Toast.makeText(requireActivity(), "Payment Status:: $msg", Toast.LENGTH_LONG).show()
                    //findNavController().navigate(R.id.action_paymentStatusFragment_to_mainFragment)
                    startActivity(Intent(requireActivity(), MainActivity::class.java))
                }

            }
            // }
        }
    }

    override fun onStop() {
        super.onStop()
        /*
         * Step 4: don't forget to clear receiver in order to avoid leaks.
         * */
        if (resultReceiver != null) {
            resultReceiver.setAppReceiver(null)
        }
    }
}
