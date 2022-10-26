package com.milkyway.gbusiness.activities
import android.annotation.SuppressLint
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import android.app.NotificationManager
import android.media.RingtoneManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent

import androidx.core.app.NotificationCompat
import android.app.NotificationChannel
import android.os.Build


class MyFirebaseMessagingService : FirebaseMessagingService() {
    val TAG = "FirebaseMessagingService"

    override fun onNewToken(s: String?) {
        super.onNewToken(s)
        Log.i("NEW_TOKEN", s!!)
    }

    @SuppressLint("LongLogTag")
    override fun onMessageReceived(remoteMessage: RemoteMessage)
    {
        Log.i(TAG, "Dikirim dari: ${remoteMessage.from}")
        Log.i(TAG, "Dikirim dari = : $remoteMessage")
        Log.i(TAG, "Dikirim dari = : "+remoteMessage.data.toString())
        Log.i(TAG, "Dikirim dari = : "+ remoteMessage.data["title"])
        Log.i(TAG, "Dikirim dari = : "+ remoteMessage.data["message"])
        Log.i(TAG, "Dikirim dari = : "+remoteMessage.notification.toString())


        //todo for data packet
        if(remoteMessage.data.isNotEmpty())
        {
            showNotification(remoteMessage.data["title"], remoteMessage.data["message"])
        }

        //todo for push noification
        if (remoteMessage.notification != null) {

            Log.i(TAG, "testing msg: = ${remoteMessage.notification?.title}")
            Log.i(TAG, "testing2 msg: = ${remoteMessage.notification?.body}")

            showNotification(remoteMessage.notification?.title, remoteMessage.notification?.body)

        }
    }


    private fun showNotification(title: String?, body: String?) {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)
        val channelId = "Default"
        val builder = NotificationCompat.Builder(this, channelId)
           // .setSmallIcon(R.drawable.noty_icon_one)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)

            .setSmallIcon(android.R.drawable.ic_delete)
            .setContentTitle(title)
            .setContentText(body)
            .setAutoCancel(true)
            .setSound(soundUri)
            .setContentIntent(pendingIntent)
            .setPriority(5)
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, "Default channel", NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
        }
        manager.notify(0, builder.build())

       /* val pendingIntent = PendingIntent.getActivity(this, 0, intent,
            PendingIntent.FLAG_ONE_SHOT)

        val soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(this)
            .setLargeIcon(
                BitmapFactory.decodeResource(applicationContext.getResources(),
                R.drawable.noty_icon_one))
            .setSmallIcon(R.drawable.noty_icon_one)
            .setContentTitle(title)
            .setContentText(body)
            .setAutoCancel(true)
            .setSound(soundUri)
            .setContentIntent(pendingIntent)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(0, notificationBuilder.build())*/
    }
}