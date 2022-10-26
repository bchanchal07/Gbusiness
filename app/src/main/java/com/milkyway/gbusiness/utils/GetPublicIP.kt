package com.milkyway.gbusiness.utils

import android.util.Log
import io.fabric.sdk.android.services.concurrency.AsyncTask
import java.io.IOException
import java.net.URL
import java.util.*

class GetPublicIP : AsyncTask<String?, String?, String>() {
    protected override fun doInBackground(vararg p0: String?): String? {
        var publicIP = ""
        try {
            val s = Scanner(
                URL(
                    "https://api.ipify.org")
                    .openStream(), "UTF-8")
                .useDelimiter("\\A")
            publicIP = s.next()
            println("My current IP address is $publicIP")
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return publicIP
    }

    override fun onPostExecute(publicIp: String) {
        super.onPostExecute(publicIp)
        Log.e("PublicIP", publicIp + "")
        //Here 'publicIp' is your desire public IP
    }
}