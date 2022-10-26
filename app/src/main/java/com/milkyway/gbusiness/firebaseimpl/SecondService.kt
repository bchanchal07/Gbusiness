package com.milkyway.gbusiness.firebaseimpl

import android.app.IntentService
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.activities.MainActivity

class SecondService : IntentService("razorpay") {
    override fun onHandleIntent(intent: Intent?) {
        var bundle = Bundle()
        bundle.putString("payId", intent?.extras?.get("payId").toString())
        bundle.putString("orderId", intent?.extras?.get("orderId").toString())
        MainActivity.navController.navigate(R.id.action_paymentFragment_to_paymentStatusFragment, bundle)
        // Navigation.findNavController(applicationContext.ankoView()).navigate(R.id.action_paymentFragment_to_paymentStatus,bundle)
        Log.i("pawan", "start service = 87")

    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("pawan", "start service = 87 distroy ")

    }
}