package com.milkyway.gbusiness.activities

import android.app.Application
import android.util.Log
import com.facebook.drawee.backends.pipeline.Fresco
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import io.realm.Realm
import io.realm.RealmConfiguration


class MyApplication : Application() {
    companion object {
        lateinit var instance: MyApplication
    }


    private var refWatcher: RefWatcher? = null

    override fun onCreate() {
        super.onCreate()
        Log.i("app", "Application")
        /*Realm.init(this)
        val config = RealmConfiguration.Builder().build()
        Realm.setDefaultConfiguration(config)*/
        Fresco.initialize(this);

        Realm.init(this)
        val config = RealmConfiguration.Builder().name("JaiHanumanJaiHo.realm").build()
        Realm.setDefaultConfiguration(config)

        instance = this
        //refWatcher = LeakCanary.install(this)
    }

    fun mustDie(`object`: Any) {
        if (refWatcher != null) {
            refWatcher!!.watch(`object`)
            Log.i("distroy", "Application")
        }
    }
}