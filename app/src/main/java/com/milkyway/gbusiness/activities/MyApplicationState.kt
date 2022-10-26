package com.milkyway.gbusiness.activities

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class MyApplicationState : Application()
{

    override fun onCreate() {
        super.onCreate()

       // Log.i("realm","fdgsfdkgklfdsjgklsjdfkl")
        Realm.init(this)
        val config = RealmConfiguration.Builder().name("JaiHanumanJaiHo.realm").build()
        Realm.setDefaultConfiguration(config)

        /*val intent = Intent(this, MyService::class.java)
        startService(intent)*/
    }
}
