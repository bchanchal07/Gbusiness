package com.milkyway.gbusiness.firebaseimpl

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.milkyway.gbusiness.activities.LoginActivity


class LocalBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        Log.i("pawan","opt= start")





            Log.i("pawan","opt= send")


            val intent = Intent(context, LoginActivity::class.java)
            val extras = Bundle()
            extras.putString("com", "1235")
            intent.putExtras(extras)
            context?.sendBroadcast(intent.setAction("com.hello.action"))

       //   val message =  intent.getExtras().get("local");

            /*if (message!=null)
            {
               *//* Log.i("pawan","opt= send")


                val intent = Intent("com.hello.action")
                val extras = Bundle()
                extras.putString("com", "1235")
                intent.putExtras(extras)
                context?.sendBroadcast(intent)*//*
            }*/

    }
}