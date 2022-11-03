package com.milkyway.gbusiness.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.beautycoder.pflockscreen.PFFLockScreenConfiguration
import com.beautycoder.pflockscreen.fragments.PFLockScreenFragment
import com.beautycoder.pflockscreen.viewmodels.PFPinCodeViewModel
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.global.CommonUtil
import org.jetbrains.anko.doAsync

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        showLockScreenFragment()
    }

    private val mCodeCreateListener =
        PFLockScreenFragment.OnPFLockScreenCodeCreateListener { encodedCode ->
            Toast.makeText(this@Main2Activity, "lock activated ", Toast.LENGTH_SHORT).show()
           // PreferencesSettings.saveToPref(this@Main2Activity, encodedCode)

            CommonUtil.saveStringPreferences(this, AppConstants.PIN_PASS,encodedCode)
    Log.i("lock","mCodeCreateListener")
            showMainFragment()
        }

    private val mLoginListener = object : PFLockScreenFragment.OnPFLockScreenLoginListener {

        override fun onCodeInputSuccessful() {
           // Toast.makeText(this@Main2Activity, "Code successfull", Toast.LENGTH_SHORT).show()
            showMainFragment()
        }

        override fun onFingerprintSuccessful() {
            //Toast.makeText(this@Main2Activity, "Fingerprint successfull", Toast.LENGTH_SHORT).show()
            showMainFragment()
        }

        override fun onPinLoginFailed() {
            Toast.makeText(this@Main2Activity, "Pin failed", Toast.LENGTH_SHORT).show()
        }

        override fun onFingerprintLoginFailed() {
            Toast.makeText(this@Main2Activity, "Fingerprint failed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showLockScreenFragment() {
        Log.i("lock","showLockScreenFragment")

        PFPinCodeViewModel().isPinCodeEncryptionKeyExist.observe(
            this,
            Observer { result ->
                if (result == null) {
                    return@Observer
                }
                if (result.error != null) {
                    Toast.makeText(
                        this@Main2Activity,
                        "Can not get pin code info",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@Observer
                }
                showLockScreenFragment(result.result)
            }
        )
    }

    private fun showLockScreenFragment(isPinExist: Boolean) {

        Log.i("lock","showLockScreenFragment(isPinExist: Boolean) ")

        val builder = PFFLockScreenConfiguration.Builder(this)
            .setTitle(if (isPinExist) "Unlock with your pin code or fingerprint" else "Create Code")
            .setCodeLength(4)
            .setLeftButton("Can't remeber",View.OnClickListener {
                Toast.makeText(
                    this@Main2Activity,
                    "Left button pressed",
                    Toast.LENGTH_LONG
                ).show()
            })
            .setUseFingerprint(true)
        val fragment = PFLockScreenFragment()



        builder.setMode(
            if (isPinExist)
                PFFLockScreenConfiguration.MODE_AUTH
            else
                PFFLockScreenConfiguration.MODE_CREATE
        )
        if (isPinExist) {
            fragment.setEncodedPinCode(CommonUtil.getPreferencesString(this, AppConstants.PIN_PASS))
            fragment.setLoginListener(mLoginListener)
        }

        fragment.setConfiguration(builder.build())
        fragment.setCodeCreateListener(mCodeCreateListener)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_views, fragment).commit()

    }
    private fun showMainFragment() {
        val intent = Intent(this@Main2Activity, MainActivity::class.java)
        doAsync {
            startActivity(intent)
            finish()
        }
    }
}
