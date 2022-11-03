package com.milkyway.gbusiness.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.activities.MainActivity
import com.milkyway.gbusiness.adaptor.OrderCartItemAdapter
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.*
import com.milkyway.gbusiness.extension.alert
import com.milkyway.gbusiness.firebaseimpl.AutoLoginService
import com.milkyway.gbusiness.firebaseimpl.RazorpayResultReceiver
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.global.CommonUtil
import com.razorpay.Checkout
import id.ionbit.ionalert.IonAlert
import org.json.JSONException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*


/**
 * A simple [Fragment] subclass.
 * Use the [OrderSummaryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrderSummaryFragment : Fragment(), OrderCartItemAdapter.OnOrderListAdaptorClick, RazorpayResultReceiver.AppReceiver {
    private lateinit var myOrderItemBack: ImageView
    private lateinit var mContext: Context
    private lateinit var rvDomainOrderItem: RecyclerView
    private lateinit var tvTotalAmount: TextView
    private lateinit var btnPayNow: AppCompatButton
    private var listCart: List<SearchDomainDataDetailsClass.DomainList>? = null
    var listCheckout: List<CheckoutRequest.Cart>? = null
    lateinit var adapter: OrderCartItemAdapter
    private var grandTotalTwoDecimal = ""
    private var gradTotalInt: Int = 0
    lateinit var resultReceiver: RazorpayResultReceiver


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_order_summary, container, false)
        initializeViews(view)
        setClickListener(view)
        return view
    }

    private fun setClickListener(view: View?) {
        btnPayNow.setOnClickListener {
            //val cartId = createRandomId().toString()
            val cartId = generateRandomArray(10)
            //Toast.makeText(requireActivity(), "Cart ID: $cartId", Toast.LENGTH_LONG).show()
            getProfileApi()
            //goCheckOut()
        }
    }

    private fun initializeViews(view: View?) {
        //val num = createRandomId()
        //Toast.makeText(requireActivity(), "$num", Toast.LENGTH_LONG).show()
        Checkout.preload(context)
        rvDomainOrderItem = view?.findViewById(R.id.rvDomainOrderItem)!!
        myOrderItemBack = view?.findViewById(R.id.myOrderItemBack)!!
        tvTotalAmount = view?.findViewById(R.id.tvTotalAmount)!!
        btnPayNow = view?.findViewById(R.id.btnPayNow)!!
        listCart = CommonUtil.getCartItems(mContext)
        myOrderItemBack.setOnClickListener {
            MainActivity.navController.navigate(R.id.action_orderSummaryFragment_to_cartItemFragment)
        }
        setOrderListAdapter()

        var grandTotal = 0.0
        for (i in listCart!!.indices)
            grandTotal += listCart!![i].subscriptionTotalAmount.toDouble()
        gradTotalInt = grandTotal.toInt()
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
        grandTotalTwoDecimal = df.format(grandTotal)
        tvTotalAmount.text = "Payable Amount : ${mContext.resources.getString(R.string.rs)} $grandTotalTwoDecimal"
        val anim: Animation = AlphaAnimation(0.0f, 1.0f)
        anim.duration = 700 //You can manage the blinking time with this parameter
        anim.startOffset = 20
        anim.repeatMode = Animation.REVERSE
        anim.repeatCount = Animation.INFINITE
        tvTotalAmount.startAnimation(anim)
    }


    private fun getProfileApi() {
        if (CommonUtil.checkNetwork(mContext)) {
            val userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            val profileData = GbusinessService.create(mContext)
            if (userID != null) {
                profileData.getUserProfile(
                    "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),
                    "application/json", userID)
                    .enqueue(object : Callback<Any> {
                        override fun onResponse(call: Call<Any>, response: Response<Any>) {
                            val gson = Gson()
                            when (response.code()) {
                                200 -> {
                                    val profileDataResponse = gson.fromJson(gson.toJson(response.body()), ProfileDetailaDataClass::class.java)
                                    if (profileDataResponse!!.success) {
                                        val firstName = profileDataResponse.data.first_name
                                        val lastName = profileDataResponse.data.last_name
                                        val email = profileDataResponse.data.email
                                        val mobile = profileDataResponse.data.phone
                                        val country = profileDataResponse.data.crtname
                                        val state = profileDataResponse.data.stname
                                        val city = profileDataResponse.data.city
                                        val address = profileDataResponse.data.address
                                        val zipCode = profileDataResponse.data.zip_code

                                        if (CommonUtil.eligibleForPurchaseDomain(firstName, lastName, email, mobile, country, state, city, address, zipCode)) {
                                            val fullName = "$firstName $lastName"
                                            val fullAddress = "$address, $city, ($state), $country - $zipCode"
                                            goCheckOut()
                                            //getRazorpayOrderId(totalPrice, "0", fullName, email!!, mobile!!, fullAddress, inputCurrencyInCreateOrder)
                                        } else {
                                            errorToastProfileNotComplete()
                                        }
                                    } else {
                                        val errorBody = gson.fromJson(gson.toJson(response.body()), ProfileDataErrorResponse::class.java)
                                        if (errorBody != null) {
                                            val ionAlert = IonAlert(requireActivity(), IonAlert.ERROR_TYPE)
                                            ionAlert.titleText = "Profile Error!"
                                            ionAlert.contentText = errorBody.message
                                            ionAlert.show()
                                        }
                                    }
                                }
                                500 -> {
                                    val ionAlert = IonAlert(requireActivity(), IonAlert.ERROR_TYPE)
                                    ionAlert.titleText = "Server Error!"
                                    ionAlert.contentText = "Server is not responding at present."
                                    ionAlert.show()
                                }
                            }
                        }

                        override fun onFailure(call: Call<Any>, t: Throwable) {

                        }
                    })
            }

        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }

    private fun goCheckOut() {
        if (CommonUtil.checkNetwork(mContext)) {
            val whmcsClientId = CommonUtil.getPreferencesString(mContext, AppConstants.WHMCS_CLIENT_ID)?.toInt()
            try {
                val jsonObjectParent = JsonObject()
                val jsonArray = JsonArray()
                for (cart in listCart!!) {
                    val jsonObject = JsonObject()
                    jsonObject.addProperty("domain", cart.domainName)
                    jsonObject.addProperty("year", cart.subscriptionYr)
                    jsonObject.addProperty("whmcs_client_id", whmcsClientId)
                    jsonArray.add(jsonObject)
                }
                jsonObjectParent.add("cart", jsonArray)
                Log.e("JSONArray", java.lang.String.valueOf(jsonArray))
                Log.e("jsonObjectParent", java.lang.String.valueOf(jsonObjectParent.toString()))

                CommonUtil.showDialog(mContext)
                val apiService = GbusinessService.create(mContext)
                apiService.goCheckoutForDomainBuy(jsonObjectParent!!)
                    .enqueue(object : Callback<DomainCartCheckout> {
                        override fun onResponse(call: Call<DomainCartCheckout>, response: Response<DomainCartCheckout>) {
                            CommonUtil.hideDialog(mContext)
                            when (response.code()) {
                                200 -> {
                                    callAutoLoginService(response.body()?.invoiceid)
                                    //Toast.makeText(requireActivity(), "Invoice created success: ${response.body()?.invoiceid}", Toast.LENGTH_LONG).show()
                                }
                                500 -> {
                                    val ionAlert = IonAlert(requireActivity(), IonAlert.ERROR_TYPE)
                                    ionAlert.titleText = "Server Error!"
                                    ionAlert.contentText = "Server is not responding at present."
                                    ionAlert.show()
                                }
                            }
                        }

                        override fun onFailure(call: Call<DomainCartCheckout>, t: Throwable) {
                            CommonUtil.hideDialog(mContext)
                            Toast.makeText(requireActivity(), t.message, Toast.LENGTH_LONG).show()
                        }
                    })
            } catch (jse: JSONException) {
                jse.printStackTrace()
            }
            /*val jsonObject = JSONObject()
            val jsonArray = jsonObject.getJSONArray("cart")
            for (i in 0 until jsonArray.length()) {

                val domain = jsonArray.getJSONObject(i).getString("domain")
                val year = jsonArray.getJSONObject(i).getString("year")
                val clientId = jsonArray.getJSONObject(i).getString("whmcs_client_id")
                val checkoutModel = CheckoutRequest(listCheckout!!)
            }*/

        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }

    private fun callAutoLoginService(invoiceId: Int?) {
        val autoLoginService = Intent(mContext, AutoLoginService::class.java)
        resultReceiver = RazorpayResultReceiver(Handler(), this)
        autoLoginService.putExtra("autologin_receiver", resultReceiver)
        autoLoginService.putExtra("invoiceId", invoiceId)
        mContext.startService(autoLoginService)
        CommonUtil.removeCartItems(mContext)
    }

    private fun errorToastProfileNotComplete() {
        IonAlert(requireActivity(), IonAlert.WARNING_TYPE)
            .setTitleText("Profile Update!")
            .setContentText("You have to completed your profile first. After that you will eligible for buying the services.")
            .setCancelText("No,cancel plz!")
            .setConfirmText("Yes,update profile!")
            .showCancelButton(true)
            .setCancelClickListener {
                it.cancel()
            }
            .setConfirmClickListener {
                it.dismissWithAnimation()
                MainActivity.navController.navigate(R.id.action_orderSummaryFragment_to_profileFragment)
            }
            .show()
    }


    /*private fun getProfileApi(domainOrderId: String?, grandTotalInt: Int) {
        if (CommonUtil.checkNetwork(mContext)) {
            val userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            val profileData = GbusinessService.create(mContext)
            if (userID != null) {
                profileData.getUserProfile(
                    "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),
                    "application/json", userID)
                    .enqueue(object : Callback<ProfileDetailaDataClass> {
                        override fun onResponse(call: Call<ProfileDetailaDataClass>, response: Response<ProfileDetailaDataClass>) {
                            val profileDataResponse = response.body()
                            if (response.isSuccessful && profileDataResponse!!.success) {
                                val firstName = profileDataResponse.data.first_name
                                val lastName = profileDataResponse.data.last_name
                                val email = profileDataResponse.data.email
                                val mobile = profileDataResponse.data.phone
                                val country = profileDataResponse.data.crtname
                                val state = profileDataResponse.data.stname
                                val city = profileDataResponse.data.city
                                val address = profileDataResponse.data.address
                                val zipCode = profileDataResponse.data.zip_code

                                if (CommonUtil.eligibleForPurchaseDomain(firstName, lastName, email, mobile, country, state, city, address, zipCode)) {
                                    val fullName = "$firstName $lastName"
                                    val fullAddress = "$address, $city, ($state), $country - $zipCode"
                                    startPaymentWithRazorPay(domainOrderId!!, grandTotalInt, "receipt", fullName, fullAddress, email, mobile)
                                } else {
                                    errorToast("You have to completed your profile first. After that you will eligible for purchasing the domain.")
                                    MainActivity.navController.navigate(R.id.action_orderSummaryFragment_to_profileFragment)
                                }
                            }
                        }

                        override fun onFailure(call: Call<ProfileDetailaDataClass>, t: Throwable) {

                        }
                    })
            }

        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }*/

    private fun errorToast(message: String) {
        MotionToast.createColorToast(requireActivity(),
            "Authentication Error!",
            message,
            MotionToastStyle.ERROR,
            MotionToast.GRAVITY_CENTER,
            MotionToast.LONG_DURATION,
            ResourcesCompat.getFont(requireActivity(), R.font.helvetica_regular))
    }

    @SuppressLint("SimpleDateFormat")
    fun createCartId(): String? {
        val dateFormat = "yyMMdd_HHmmss"
        val prefix = "cart_2K_"
        val date = Date(System.currentTimeMillis())
        return "$prefix${SimpleDateFormat(dateFormat).format(date)}"
    }

    private fun generateRandomArray(n: Int): List<Int>? {
        val list = ArrayList<Int>(n)
        val random = Random()
        for (i in 0 until n) {
            list.add(random.nextInt(1000000000))
        }
        return list
    }

    private fun createRandomId(): Int? {
        val random = Random()
        return random.nextInt(1000000000)
    }


    private fun setOrderListAdapter() {
        rvDomainOrderItem.layoutManager = LinearLayoutManager(context)

        adapter = OrderCartItemAdapter(mContext, listCart!!, this)
        // Setting the Adapter with the recyclerview
        rvDomainOrderItem.adapter = adapter
    }

    override fun onClickedDeleterOrder(pos: Int, list: SearchDomainDataDetailsClass.DomainList) {
        CommonUtil.toast("Clicked on item ${pos + 1} for delete action", mContext)
        alert("Cart Item!", "Are you sure, want to delete cart item?") {
            positiveButton("YES") {
                CommonUtil.removeCartItem(mContext, list)
                setOrderListAdapter()
                CommonUtil.toast("Cart item removed successfully.", mContext)
            }
            negativeButton("NO") {
            }
        }.show()
    }

    override fun onClickedSpinnerYear(selectedText: String, years: Array<String>, clickedPosition: Int, posAdapter: Int, positionSpinner: Int, spinnerYrDuration: Spinner, tvTtlPrice: TextView, list: SearchDomainDataDetailsClass.DomainList) {
        var subscriptionYr = 0
        var getYearInt = 0

        for (i in years.indices) {
            val yrItem = years[i]
            if (selectedText.contentEquals(yrItem))
                subscriptionYr = positionSpinner + 1
        }

        // adapter.modifyItem(posAdapter, listCart!!)
        val finalDomainList = ArrayList<SearchDomainDataDetailsClass.DomainList>()
        var priceTwoDecimal = ""
        for (i in listCart?.indices!!) {
            val priceDouble = listCart!![posAdapter].domainPrice.toDouble()
            val finalPriceDouble = (subscriptionYr) * priceDouble
            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.CEILING
            priceTwoDecimal = df.format(finalPriceDouble)
            val totalPrice = priceTwoDecimal.toString()
            if (listCart!![posAdapter].domainName == listCart!![i].domainName) {
                finalDomainList.add(SearchDomainDataDetailsClass.DomainList(listCart!![i].domainName, listCart!![i].domainPrice, subscriptionYr, totalPrice))
            } else {
                finalDomainList.add(SearchDomainDataDetailsClass.DomainList(listCart!![i].domainName, listCart!![i].domainPrice, listCart!![i].subscriptionYr, listCart!![i].subscriptionTotalAmount))
            }
            //CommonUtil.toast(domainPriceData.toString(), mCtx)
            CommonUtil.saveCartItem(mContext, finalDomainList)
        }
        var grandTotal = 0.0
        for (i in CommonUtil.getCartItems(mContext)!!.indices) grandTotal += CommonUtil.getCartItems(mContext)!![i].subscriptionTotalAmount.toDouble()
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
        val grandTotalTwoDecimal = df.format(grandTotal)
        tvTotalAmount.text = "Payable Amount : ${mContext.resources.getString(R.string.rs)} $grandTotalTwoDecimal"
        //CommonUtil.toast("Cart updated successfully.", mContext)
        tvTtlPrice.text = "${mContext.resources.getString(R.string.rs)} $priceTwoDecimal"
    }

    override fun onReceiveResult(resultCode: Int, resultData: Bundle?) {
        if (resultReceiver != null) {
            if (resultData != null) {
                val url = resultData.getString("autoLoginUrl")
                val invoiceId = resultData.getInt("invoiceId")

                val bundle = Bundle()
                bundle.putString("back", "OrderSummaryFragment")
                bundle.putString("webUrl", url)
                bundle.putInt("invoiceId", invoiceId)
                //Toast.makeText(requireActivity(), "AutoLogin Url:: $url", Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_orderSummaryFragment_to_paymentOrInvoiceWebView, bundle)
            }
        }
    }

    /*fun startPaymentWithRazorPay(domainOrderId: String, payAmountInt: Int, receipt: String, fullName: String, fullAddress: String, email: String, mobile: String) {

        val finalAmount = payAmountInt * 100
        //val razor = payAmount.toInt() / 100
        //CommonUtil.saveStringPreferences(mContext, AppConstants.RazorAmount, razor.toString())

        //var firstName = CommonUtil.getPreferencesString(mContext, AppConstants.First_NAME)
        // var lastName = CommonUtil.getPreferencesString(mContext, AppConstants.LAST_NAME)
        //var email = CommonUtil.getPreferencesString(mContext, AppConstants.EMAIL)
        //var mobile = CommonUtil.getPreferencesString(mContext, AppConstants.MOBILE)
        //You need to pass current activity in order to let Razorpay create CheckoutActivity
        //  val activity = this
        Log.i("tag", "razor pay start")
        val co = Checkout()
        */
    /**
     * Set your logo here
     *//*
        co.setImage(R.drawable.logo)

        try {
            val options = JSONObject()
            options.put("name", fullName)
            options.put("description", "Domain Name")
            //You can omit the image option to fetch the image from dashboard
            //options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png")
            options.put("currency", "INR")
            //options.put("order_id", domainOrderId) //phelee ek api se order id genrate krte h nhai to code nhai chle ga by pawan
            //   options.put("orderId", "443")
            options.put("amount", 100)
            val preFill = JSONObject()
            preFill.put("email", "vinod@milkywayservices.com")
            preFill.put("contact", "+919540381085")

            val noTes = JSONObject()
            noTes.put("address", fullAddress)
            noTes.put("merchant_order_id", receipt)
            options.put("prefill", preFill)
            options.put("notes", noTes)

            co.open(activity, options)

        } catch (e: Exception) {
            // Toast.makeText(activity, "Error in payment: " + e.message, Toast.LENGTH_SHORT).show()
            Log.i("tag", "msg=====" + e.message)
            e.printStackTrace()
        }

        *//*val activity: Activity = requireActivity()
        val co = Checkout()
        co.setKeyID("rzp_live_qZl14ZaFGphjhz")

        try {
            val options = JSONObject()
            options.put("name", "Razorpay Corp")
            options.put("description", "Demoing Charges")
            //You can omit the image option to fetch the image from dashboard
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png")
            options.put("theme.color", "#3399cc")
            options.put("currency", "INR")
            //options.put("order_id", "order_DBJOWzybf0sJbb")
            options.put("amount", "50000")//pass amount in currency subunits

            val retryObj = JSONObject()
            retryObj.put("enabled", true)
            retryObj.put("max_count", 4)
            options.put("retry", retryObj)

            val prefill = JSONObject()
            prefill.put("email", "gaurav.kumar@example.com")
            prefill.put("contact", "9876543210")

            options.put("prefill", prefill)
            co.open(activity, options)
        } catch (e: Exception) {
            Toast.makeText(activity, "Error in payment: " + e.message, Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }*//*
    }*/

    /*override fun onPaymentSuccess(razorpayPaymentID: String?, p1: PaymentData?) {
        try {
            toast("Payment Successful: $razorpayPaymentID", mContext)
        } catch (e: java.lang.Exception) {
            //Log.e(TAG, "Exception in onPaymentSuccess", e)
        }
    }

    override fun onPaymentError(code: Int, p1: String?, p2: PaymentData?) {
        try {
            errorToast("Payment failed \nError code:$code ($p1)")
            //Toast.makeText(this, "Payment failed: " + code.toString() + " " + response, Toast.LENGTH_SHORT).show()
        } catch (e: java.lang.Exception) {
            //Log.e(TAG, "Exception in onPaymentError", e)
        }
    }*/

}