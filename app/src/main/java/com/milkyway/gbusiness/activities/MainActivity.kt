package com.milkyway.gbusiness.activities

import android.Manifest
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.provider.Settings
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.InstanceIdResult
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.api.CallPemission
import com.milkyway.gbusiness.firebaseimpl.RealmStorageModelClass
import com.milkyway.gbusiness.fragments.PaymentFragment
import com.milkyway.gbusiness.ui.main.MainFragment
import com.milkyway.gbusiness.ui.main.MainFragment.Companion.REQUEST_ID_MULTIPLE_PERMISSIONS
import com.milkyway.gbusiness.utils.CommonUtil
import com.razorpay.PaymentData
import com.razorpay.PaymentResultWithDataListener
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle
import java.util.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,/*BookDomainInterface,*/
    BottomNavigationView.OnNavigationItemSelectedListener, PaymentResultWithDataListener {

    private var doubleBackToExitPressedOnce = false
    lateinit var listener: CallPemission
    lateinit var realm: Realm
    lateinit var timer: Timer

    companion object {
        lateinit var navController: NavController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sessionHandling()
        realm = Realm.getDefaultInstance()
        // saveData()
        // todo start service backbround
        // readData()

        navController = findNavController(R.id.nav_host_fragment)
        val mainFrag = MainFragment()
        listener = mainFrag

        getFireBaseToken()

        // setSupportActionBar(toolbar)
        // setupActionBarWithNavController(navController)
        navigation.setupWithNavController(navController)
        //navigationView.setupWithNavController(navController)
        navigation.setOnNavigationItemSelectedListener(this@MainActivity)
        //NavigationUI.setupWithNavController(navigationView, navController)
        navigation.itemIconTintList = null // used to set orignal image in bootom navigation bar
        //navigationView.setNavigationItemSelectedListener(this@MainActivity)

    }


    /* private fun saveData() {
         realm.executeTransactionAsync({
             val student = it.createObject(RealmStorageModelClass::class.java)
             student.paytype = "card"
             student.pay_id = "6d6fdsg"
         }, {
             Log.i("reaml", "On Success: Data Written Successfully!")

         }, {
             Log.i("reaml", it.localizedMessage)
         })
     }

     private fun readData() {
         try {

             val paydetl = realm.where(RealmStorageModelClass::class.java).findAll()
             var response = ""
             Log.i("realm", paydetl.size.toString())
             if (paydetl.size > 0) {
                 val intent = Intent(this, MyService::class.java)
                 startService(intent)
             }
           //  else stopService(Intent(this, MyService::class.java));

             paydetl.forEach {
                 response = response + "paytype: ${it.paytype}, payId: ${it.pay_id}" + "\n"
             }
             Log.i("realm", response)

         }catch (e  : Exception)
         {
             Log.i("reaml", e.localizedMessage)
         }


     }*/


    private fun getFireBaseToken() {
        FirebaseInstanceId.getInstance().instanceId.addOnSuccessListener(this@MainActivity,
            OnSuccessListener<InstanceIdResult> { instanceIdResult ->
                val newToken = instanceIdResult.token
                Log.i("newToken", newToken)
            })
    }

    override fun onSupportNavigateUp() = NavigationUI.navigateUp(navController, drawer_layout)

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        menuItem.isChecked = true
        drawer_layout.closeDrawers()
        when (menuItem.itemId) {
            R.id.bottomNavFragmentHome -> {
                navController.navigate(R.id.mainFragment)
                return true
            }
            R.id.bottomNavFragmentEarning -> {
                navController.navigate(R.id.earningFragment)
                return true
            }
            R.id.bottomNavFragmentProfile -> {
                navController.navigate(R.id.profileFragment)
                //navController.navigate(R.id.paymentStatus)
                return true
            }
            else -> return true
        }
    }

    /*fun openCloseNavigationDrawer() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            drawer_layout.openDrawer(GravityCompat.START)
        }
    }*/


    override fun onBackPressed() {

        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            finish()
            return
        }

        this.doubleBackToExitPressedOnce = true
        CommonUtil.toast("Please click back again to exit", this)
        Handler().postDelayed(Runnable { doubleBackToExitPressedOnce = false }, 2000)
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        Log.d("TAG", "Permission callback called-- main Activity-----")
        when (requestCode) {
            REQUEST_ID_MULTIPLE_PERMISSIONS -> {

                val perms = HashMap<String, Int>()
                // Initialize the map with both permissions
                perms[Manifest.permission.CAMERA] = PackageManager.PERMISSION_GRANTED
                perms[Manifest.permission.WRITE_EXTERNAL_STORAGE] = PackageManager.PERMISSION_GRANTED

                // Fill with actual results from user
                if (grantResults.isNotEmpty()) {
                    for (i in permissions.indices)
                        perms[permissions[i]] = grantResults[i]
                    // Check for both permissions
                    if (perms[Manifest.permission.CAMERA] == PackageManager.PERMISSION_GRANTED
                        && perms[Manifest.permission.WRITE_EXTERNAL_STORAGE] == PackageManager.PERMISSION_GRANTED
                    ) {
                        Log.d("TAG", "CAMERA & WRITE_EXTERNAL_STORAGE")

                        //else any one or both the permissions are not granted
                    } else {
                        Log.d("TAG", "Some permissions are not granted ask again ")
                        //permission is denied (this is the first time, when "never ask again" is not checked) so ask again explaining the usage of permission
                        //                        // shouldShowRequestPermissionRationale will return true
                        //show the dialog or snackbar saying its necessary and try again otherwise proceed with setup.
                        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)
                            || ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        ) {
                            showDialogOK("Service Permissions are required for this app",
                                DialogInterface.OnClickListener { dialog, which ->
                                    when (which) {
                                        DialogInterface.BUTTON_POSITIVE -> listener.onClickPermission()
                                        DialogInterface.BUTTON_NEGATIVE ->
                                            // proceed with logic by disabling the related features or quit the app.
                                            finish()
                                    }
                                })
                        } /*else {
                            explain("You needddddd to give some mandatory permissions to continue. Do you want to go to app settings?")
                            //                            //proceed with logic by disabling the related features or quit the app.
                        }*/
                    }
                }
            }
        }

    }

    private fun showDialogOK(message: String, okListener: DialogInterface.OnClickListener) {
        AlertDialog.Builder(this)
            .setMessage(message)
            .setPositiveButton("OK", okListener)
            .setNegativeButton("Cancel", okListener)
            .create()
            .show()
    }

    private fun explain(msg: String) {

        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setMessage(msg)
        // Set a positive button and its click listener on alert dialog
        builder.setPositiveButton("YES") { dialog, which ->
            // Do something when user press the positive button
            startActivity(
                Intent(
                    Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                    Uri.parse("package:com.example.parsaniahardik.kotlin_marshmallowpermission")
                )
            )
        }
        builder.setNegativeButton("No") { dialog, which ->
            Toast.makeText(applicationContext, "You are not agree.", Toast.LENGTH_SHORT).show()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }


    override fun onPaymentError(p0: Int, p1: String?, p2: PaymentData?) {
        Log.e("tag", "p0=$p0")
        Log.e("tag", "p1=$p1")
        Log.e("tag", "p2=$p2")
        paymentErrorToast("Payment failed \nError code: $p1")
        //Toast.makeText(this, " Payment Error : \n$p1", Toast.LENGTH_SHORT).show()
    }


    override fun onPaymentSuccess(p0: String?, data: PaymentData?) {

        try {
            //Toast.makeText(this, "Payment successful:MainActivity", Toast.LENGTH_SHORT).show()
            PaymentFragment().checkRazorResponse(this, data, true)
        } catch (e: Exception) {
            Log.e("Exception in success", e.toString())
            e.printStackTrace()
        }
        val paymentId = data?.paymentId
        val signature = data?.signature
        val orderId = data?.orderId
        realm.executeTransactionAsync({
            val razorDetails = it.createObject(RealmStorageModelClass::class.java)
            razorDetails.payMethod = "razorpay"
            razorDetails.paytype = "card"
            razorDetails.pay_id = paymentId
            razorDetails.invoice_id = PaymentFragment.invoic_id
            razorDetails.user_id = null
            razorDetails.captured = null
            razorDetails.transaction_id = paymentId
            razorDetails.bank_ref_no = null
            razorDetails.order_status = null
            razorDetails.failure_message = null
            razorDetails.payment_mode = null
            razorDetails.card_name = null
            razorDetails.currency = null
            razorDetails.amount = null
            razorDetails.created_at = null
            razorDetails.domain_name = null
            razorDetails.status = "1"
            razorDetails.workingStage = "1"

        }, {
            Log.i("reaml", "On Success: Data Written Successfully!")

        }, {
            Log.i("reaml", it.localizedMessage)
        })
    }

    private fun paymentErrorToast(message: String) {
        MotionToast.createColorToast(this,
            "Payment Error!",
            message,
            MotionToastStyle.ERROR,
            MotionToast.GRAVITY_CENTER,
            MotionToast.LONG_DURATION,
            ResourcesCompat.getFont(this, R.font.helvetica_regular))
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
        if (timer != null) timer.cancel()

    }


    private fun sessionHandling() {
        Log.i("timer", "start")
        timer = Timer()
        val restTime = LogOutTimerTask(this@MainActivity)
        timer.schedule(restTime, 1500000)
    }


    class LogOutTimerTask(val mainActivity: MainActivity) : TimerTask() {
        override fun run() {

            // val intent = Intent(this, LoginActivity::class.java)
            //  startActivity(intent)
            Log.i("timer", "logout")
            mainActivity.startActivity(Intent(mainActivity, LoginActivity::class.java))
        }

    }
}
