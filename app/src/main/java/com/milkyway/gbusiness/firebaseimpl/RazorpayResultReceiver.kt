package com.milkyway.gbusiness.firebaseimpl

import android.os.Bundle
import android.os.Handler
import android.os.ResultReceiver

/*
 * Step 1: The AppReceiver is just a custom interface class we created.
 * This interface is implemented by the activity
 */
class RazorpayResultReceiver(handler: Handler?, private val appReceiver: AppReceiver?) : ResultReceiver(handler) {
    public override fun onReceiveResult(resultCode: Int, resultData: Bundle) {
        appReceiver?.onReceiveResult(resultCode, resultData)
    }

    private var mReceiver: AppReceiver? = null
    fun setAppReceiver(receiver: AppReceiver?) {
        mReceiver = receiver
    }

    interface AppReceiver {
        fun onReceiveResult(resultCode: Int, resultData: Bundle?)
    }
}