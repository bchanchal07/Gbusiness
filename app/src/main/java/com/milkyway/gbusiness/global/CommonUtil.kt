package com.milkyway.gbusiness.global

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.net.Uri
import android.preference.PreferenceManager
import android.util.Base64
import android.util.Log
import android.util.Patterns
import android.view.Gravity
import android.view.View
import android.view.Window
import android.webkit.URLUtil
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.google.gson.Gson
import com.milkyway.gbusiness.models.SearchDomainDataDetailsClass
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.retrofit.AppConstants.CART_ITEM
import com.milkyway.gbusiness.retrofit.AppConstants.PREFS_NAME
import com.pawegio.kandroid.layoutInflater
import id.ionbit.ionalert.IonAlert
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle
import java.io.ByteArrayOutputStream
import java.math.RoundingMode
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec


class CommonUtil {
    // var interfaceDialog = DialogClick
    companion object {

        internal lateinit var dialog: Dialog
        open var dialogLoader: Dialog? = null

        open fun dismissLoadingProgress() {
            if (dialogLoader != null && dialogLoader!!.isShowing) {
                dialogLoader!!.dismiss()
                dialogLoader = null
            }
        }

        open fun showLoadingProgress(context: Activity) {
            if (dialogLoader != null) {
                dialogLoader!!.dismiss()
                dialogLoader = null
            }
            dialogLoader = Dialog(context)
            dialogLoader!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialogLoader!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialogLoader!!.setContentView(R.layout.dlg_progress)
            dialogLoader!!.setCancelable(false)
            dialogLoader!!.show()
        }

        fun eligibleForPurchaseDomain(
            firstName: String?,
            lastName: String?,
            email: String?,
            mobile: String?,
            country: String?,
            state: String?,
            city: String?,
            address: String?,
            zipCode: String?,
        ): Boolean {
            return (firstName.isNullOrEmpty() && lastName.isNullOrEmpty() && email.isNullOrEmpty() && mobile.isNullOrEmpty() &&
                    country.isNullOrEmpty() && state.isNullOrEmpty() && city.isNullOrEmpty() && address.isNullOrEmpty() && zipCode.isNullOrEmpty())
            /*if (firstName.isNullOrEmpty())
                return false
            if (lastName.isNullOrEmpty())
                return false
            if (email.isNullOrEmpty())
                return false
            if (mobile.isNullOrEmpty())
                return false
            if (country.isNullOrEmpty())
                return false
            if (state.isNullOrEmpty())
                return false
            if (city.isNullOrEmpty())
                return false
            if (address.isNullOrEmpty())
                return false
            if (zipCode.isNullOrEmpty())
                return false
            return true*/
        }

        fun toast(message: String, context: Context) {

            // Call toast.xml file for toast layout
            val view: View = context.layoutInflater!!.inflate(com.milkyway.gbusiness.R.layout.toast, null)
            view.findViewById<TextView>(R.id.tvCustomToast).text = message

            val toast = Toast(context)

            // Set layout to toast
            toast.view = view
            toast.setGravity(
                Gravity.CENTER_VERTICAL or Gravity.BOTTOM,
                0, 300
            )
            toast.duration = Toast.LENGTH_SHORT
            toast.show()

        }

        fun customToast(title: String, message: String, context: Activity, type: Int) {
            val ionAlert = IonAlert(context, type)
            ionAlert.titleText = title
            ionAlert.contentText = message

            ionAlert.show()
        }

        fun errorToast(title: String, message: String, context: Activity) {
            MotionToast.createColorToast(context,
                title,
                message,
                MotionToastStyle.ERROR,
                MotionToast.GRAVITY_CENTER,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(context, R.font.helvetica_regular))
        }

        fun successToast(title: String, message: String, context: Activity) {
            MotionToast.createColorToast(context,
                title,
                message,
                MotionToastStyle.SUCCESS,
                MotionToast.GRAVITY_CENTER,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(context, R.font.helvetica_regular))
        }

        fun warningToast(title: String, message: String, context: Activity) {
            MotionToast.createColorToast(context,
                title,
                message,
                MotionToastStyle.WARNING,
                MotionToast.GRAVITY_CENTER,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(context, R.font.helvetica_regular))
        }

        fun infoToast(title: String, message: String, context: Activity) {
            MotionToast.createColorToast(context,
                title,
                message,
                MotionToastStyle.INFO,
                MotionToast.GRAVITY_CENTER,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(context, R.font.helvetica_regular))
        }

        fun deleteToast(title: String, message: String, context: Activity) {
            MotionToast.createColorToast(context,
                title,
                message,
                MotionToastStyle.DELETE,
                MotionToast.GRAVITY_CENTER,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(context, R.font.helvetica_regular))
        }

        fun noInternetToast(title: String, message: String, context: Activity) {
            MotionToast.createColorToast(context,
                title,
                message,
                MotionToastStyle.NO_INTERNET,
                MotionToast.GRAVITY_CENTER,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(context, R.font.helvetica_regular))
        }

        fun toastError(message: CharSequence, context: Context) {

            // Call toast.xml file for toast layout
            val view: View = context.layoutInflater!!.inflate(com.milkyway.gbusiness.R.layout.toast, null)
            view.findViewById<TextView>(R.id.tvCustomToast).text = message
            view.findViewById<TextView>(R.id.tvCustomToast).setBackgroundColor(context.resources.getColor(R.color.red))
            val toast = Toast(context)

            // Set layout to toast
            toast.view = view
            toast.setGravity(
                Gravity.CENTER_VERTICAL or Gravity.BOTTOM,
                0, 300
            )
            toast.duration = Toast.LENGTH_SHORT
            toast.show()

        }

        fun saveStringPreferences(mContext: Context, key: String, value: String) {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext)
            val editor = sharedPreferences.edit()
            editor.putString(key, value)
            editor.apply()
        }

        fun saveIntPreferences(mContext: Context, key: String, value: Int) {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext)
            val editor = sharedPreferences.edit()
            editor.putInt(key, value)
            editor.apply()
        }

        fun getPreferencesString(mContext: Context, key: String): String? {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext)
            return sharedPreferences.getString(key, "")
        }

        fun getIntPreferences(mContext: Context, key: String): Int {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext)
            return sharedPreferences.getInt(key, 0)
        }

        fun ClearSession(mContext: Context) {
            val editor: SharedPreferences.Editor = PreferenceManager.getDefaultSharedPreferences(mContext).edit()
            editor.clear()
            editor.commit()
        }

        fun saveCartItem(context: Context, cartItemList: ArrayList<SearchDomainDataDetailsClass.DomainList>?) {
            val editor: SharedPreferences.Editor
            val settings: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            editor = settings.edit()
            val gson = Gson()
            val jsonCartItems = gson.toJson(cartItemList)
            editor.putString(CART_ITEM, jsonCartItems)
            editor.apply()
        }

        fun getCartItems(context: Context): ArrayList<SearchDomainDataDetailsClass.DomainList>? {
            var cartData: List<SearchDomainDataDetailsClass.DomainList?>?
            val settings: SharedPreferences = context.getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE)
            if (settings.contains(CART_ITEM)) {
                val jsonCartItems = settings.getString(CART_ITEM, null)
                val gson = Gson()
                val cartItems: Array<SearchDomainDataDetailsClass.DomainList> = gson.fromJson<Array<SearchDomainDataDetailsClass.DomainList>>(jsonCartItems, Array<SearchDomainDataDetailsClass.DomainList>::class.java)
                cartData = listOf(*cartItems)
                cartData = ArrayList<SearchDomainDataDetailsClass.DomainList>(cartData)

            } else
                return null
            return cartData as ArrayList<SearchDomainDataDetailsClass.DomainList>
        }

        fun removeCartItems(context: Context) {
            val settings: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            settings.edit().clear().apply()
        }

        fun addCartItem(context: Context?, domain: SearchDomainDataDetailsClass.DomainList) {
            var cartData: ArrayList<SearchDomainDataDetailsClass.DomainList>? = getCartItems(context!!)
            if (cartData == null)
                cartData = ArrayList<SearchDomainDataDetailsClass.DomainList>()
            cartData.add(domain)
            saveCartItem(context, cartData)
        }

        fun removeCartItem(context: Context?, product: SearchDomainDataDetailsClass.DomainList) {
            val cartData: ArrayList<SearchDomainDataDetailsClass.DomainList>? = getCartItems(context!!)
            if (cartData != null) {
                cartData.remove(product)
                saveCartItem(context, cartData)
            }
        }

        @SuppressLint("MissingPermission")
        fun checkNetwork(context: Context): Boolean {
            return (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo?.isConnected == true
        }

        /*fun showDomainSearchDialog(context : Context){
            dialog = Dialog(context)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            //set cancelable false so that it's never get hidden
            dialog.setCancelable(false)
            //that's the layout i told you will inflate later
            dialog.setContentView(R.layout.custom_loader_layout)

            //initialize the imageView form inflated layout
            val gifImageView: ImageView = dialog.findViewById(R.id.custom_loading_imageView)

            *//*
            it was never easy to load gif into an ImageView before Glide or Others library
            *//*

            //now load that gif which we put inside the drawable folder here with the help of //Glide
            Glide.with(context)
                .load(R.drawable.serp_animation_loader)
                .placeholder(R.drawable.serp_animation_loader)
                .centerCrop()
                .into(gifImageView)


            //on back dismiss loader
            dialog.setOnKeyListener { arg0, keyCode, event ->
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    dialog.dismiss()
                }
                true
            }
        }

        fun hideDomainSearchDialog(){
            dialog.dismiss()
        }*/


        fun showDialog(context: Context) {

            dialog = Dialog(context)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            //...set cancelable false so that it's never get hidden
            dialog.setCancelable(false)
            //...that's the layout i told you will inflate later
            dialog.setContentView(com.milkyway.gbusiness.R.layout.dlg_custom_progress)
            //set transparent background
            dialog.getWindow()?.setBackgroundDrawableResource(android.R.color.transparent)

            dialog.show()
        }


        fun hideDialog(context: Context) {
            dialog.dismiss()
        }

        fun logi(classBody: String) {
            Log.i("TAG", classBody)

        }


        fun toBase64String(bm: Bitmap): String {

            val baos = ByteArrayOutputStream()
            bm.compress(Bitmap.CompressFormat.PNG, 100, baos) //bm is the bitmap object
            val b = baos.toByteArray()

            return Base64.encodeToString(b, Base64.DEFAULT)
        }

        fun decimslToString(money: Double): String {

            val rounded = money.toBigDecimal().setScale(7, RoundingMode.UP).toDouble()
            return rounded.toString()

        }

        fun decimslToStringUPtoFourDigit(money: Double): String {

            val rounded = money.toBigDecimal().setScale(4, RoundingMode.UP).toDouble()
            return rounded.toString()

        }


        /*  fun showAlertDialogButtonClicked(
              mContext: Context,
              listner: TrashListner
          ) {
              // setup the alert builder
              val builder = AlertDialog.Builder(mContext);
              builder.setTitle("WARNING !!!");
              builder.setMessage("Are you sure you want to move it to trash ?");
              // add the buttons
              val utilss = CommonUtil()

              // create and show the alert dialog
              val dialog = builder.create();

              builder.setPositiveButton("Continue", listner.continueTrash("dhfhsdf"));
              builder.setNegativeButton("Cancel", listner.cancleTrash("dd"));
              dialog.show();
          }
  */

        fun isValidMail(mail: String?): Boolean {
            val pattern: Pattern
            val emailPattern = "[a-zA-Z0-9._-]+@[a-z0-9]+\\.+[a-z]+"
            pattern = Pattern.compile(emailPattern)
            val matcher: Matcher = pattern.matcher(mail)
            return !matcher.matches()
        }

        fun isValidMobile(mobile: String?): Boolean {
            val pattern: Pattern
            val mobilePattern = "^[1-9][0-9]{9}$"
            pattern = Pattern.compile(mobilePattern)
            val matcher: Matcher = pattern.matcher(mobile)
            return !matcher.matches()
        }

        fun isValidUrl(urlString: String?): Boolean {

            return URLUtil.isValidUrl(urlString) && Patterns.WEB_URL.matcher(urlString).matches()
        }

        fun isUriEmpty(uri: Uri?): Boolean {
            return uri == null || uri == Uri.EMPTY
        }

        @Throws(NoSuchAlgorithmException::class, InvalidKeyException::class)
        fun hmacWithJava(algorithm: String?, data: String, key: String): String {
            val secretKeySpec = SecretKeySpec(key.toByteArray(), algorithm)
            val mac = Mac.getInstance(algorithm)
            mac.init(secretKeySpec)
            return bytesToHex(mac.doFinal(data.toByteArray()))
        }

        private fun bytesToHex(hash: ByteArray): String {
            val hexString = StringBuilder(2 * hash.size)
            for (h in hash) {
                val hex = Integer.toHexString(0xff and h.toInt())
                if (hex.length == 1) hexString.append('0')
                hexString.append(hex)
            }
            return hexString.toString()
        }

        //todo method to load fragment from fragment...
        fun loadFragmentsWithBackStack(activity: FragmentActivity, selectedFragment: Fragment?, fragment_tag: String?) {
            activity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.nav_host_fragment, selectedFragment!!, fragment_tag)
                .addToBackStack(null)
                .commit()
        }
    }
}









