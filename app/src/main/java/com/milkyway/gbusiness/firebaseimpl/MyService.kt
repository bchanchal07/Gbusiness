package com.milkyway.gbusiness.firebaseimpl


import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.util.Log
import io.realm.Realm


class MyService : Service() {
    val mContext: Context = this

    override fun onBind(intent: Intent?): IBinder? {
        Log.i("ppawa", "start onBind")

        return null
    }

    private var mHandler: Handler? = null

    // default interval for syncing data
    val DEFAULT_SYNC_INTERVAL = (30 * 1000).toLong()

    // task to be run here
    private val runnableService = object : Runnable {
        override fun run() {
            syncData()
            Log.i("realm", "run MyService")

            // Repeat this runnable code block again every ... min
            mHandler!!.postDelayed(this, DEFAULT_SYNC_INTERVAL)
        }
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        // Create the Handler object
        mHandler = Handler()
        // Execute a runnable task as soon as possible
        mHandler!!.post(runnableService)

        return Service.START_STICKY
    }

    @Synchronized
    private fun syncData() {
        // call your rest service here
        val realm = Realm.getDefaultInstance()
        val details = realm.where(RealmStorageModelClass::class.java).findAll()


        details.forEach {


            if (it.payMethod.equals("razorpay")) {
                Log.i("pawan", "main service service start for  razorpay")
                val intentsec = Intent(mContext, RazorpayPaymentService::class.java)
                intentsec.putExtra("payId", it.pay_id)
                intentsec.putExtra("orderId", "service")
                startService(intentsec)

            } else {
                Log.i("paypal", "main service service start for  paypal")

                val intent = Intent(mContext, PayPalPaymentService::class.java)
                intent.putExtra("payId", it.pay_id)
                intent.putExtra("orderId", "service")
                intent.putExtra("invoice", it.invoice_id)
                startService(intent)
            }
        }
    }


}