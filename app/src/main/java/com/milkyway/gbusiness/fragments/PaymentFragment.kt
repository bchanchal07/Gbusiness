package com.milkyway.gbusiness.fragments


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.activities.MainActivity.Companion.navController
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.api.OnAdpterClick
import com.milkyway.gbusiness.models.ProfileDataErrorResponse
import com.milkyway.gbusiness.models.ProfileDetailaDataClass
import com.milkyway.gbusiness.models.RazorPayOrderId
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.utils.CommonUtil
import com.paypal.android.sdk.payments.PayPalConfiguration
import com.paypal.android.sdk.payments.PayPalPayment
import com.paypal.android.sdk.payments.PayPalService
import com.razorpay.Checkout
import com.razorpay.PaymentData
import id.ionbit.ionalert.IonAlert
import io.realm.Realm
import kotlinx.android.synthetic.main.fragment_payment.*
import org.jetbrains.anko.doAsync
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.math.BigDecimal


class PaymentFragment : Fragment(), OnAdpterClick {
    override fun OnClick(cartId: String) {
        openOrderStatus = true

    }

    override fun onClickBtn(cart_id: String, price: String, domainName: String, services: String, currency: String) {
        //not in  use
    }

    private lateinit var paymentBack: ImageView
    var openOrderStatus = false
    var razorpayAmountInINR: Int = 0
    lateinit var realm: Realm
    lateinit var paypal: TextView
    lateinit var myWalletBalanceTv: TextView
    lateinit var tvPayFromWallet: TextView
    lateinit var invoice_id: TextView
    lateinit var radioGpPayment: RadioGroup
    lateinit var inputCurrency: String
    lateinit var inputCurrencyInCreateOrder: String

    lateinit var paymentServicePayAmount: TextView
    lateinit var paymentServiceDes: TextView
    lateinit var paymentServiceName: TextView
    lateinit var paymentServicePrice: TextView
    lateinit var paymentServiceTotalPrice: TextView
    lateinit var btnApplyCoupon: Button

    var razorOrderId: String = "null"
    var receipt: String = "800"
    lateinit var enterWalletAmountEdt: EditText
    private lateinit var mContext: Context
    private lateinit var creditCheckBox: CheckBox
    private lateinit var debitCheckBox: CheckBox
    private lateinit var PaypalCheckBox: CheckBox
    private lateinit var RazorCheckBox: CheckBox
    private lateinit var WalletCheckBox: CheckBox
    private lateinit var paymentButton: Button
    private var access_tokenPaypal: String? = null

    //private var payType: String = "paypal"
    private var paymentMode: String = ""
    var price: String = "0"
    var domainName: String = "dummy"
    var rstl: Int = 4
    var rtnvalue: Int = 4
    var enterBal: Double = 0.0


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onResume() {
        super.onResume()
        Log.i("pawan", "mContext onResume")
        if (openOrderStatus) {
            findNavController().navigate(R.id.action_paymentFragment_to_paymentStatusFragment)
            openOrderStatus = false
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_payment, container, false)
        initializeView(view)
        clickListener(view)


        /* myWalletBalanceTv = view.findViewById(R.id.myWalletBalanceTv)
         tvPayFromWallet = view.findViewById(R.id.tvPayFromWallet)*/
        /*enterWalletAmountEdt = view.findViewById(R.id.enterWalletAmountEdt)
        enterWalletAmountEdt.setText("0")*/

        /*creditCheckBox = view.findViewById(R.id.creditCheckBox)
        debitCheckBox = view.findViewById(R.id.debitCheckBox)
        PaypalCheckBox = view.findViewById(R.id.PaypalCheckBox)
        RazorCheckBox = view.findViewById(R.id.RazorCheckBox)
        WalletCheckBox = view.findViewById(R.id.WalletCheckBox)
        btnApplyCoupon = view.findViewById(R.id.btnApplyCoupon)

        PaypalCheckBox.isChecked = true
        paypal = view.findViewById(R.id.paymentPayPal)*/
        // paypal.setOnClickListener { startpaypal() }

        //creditCheckBox.setOnClickListener { allowCreadet() }
        //debitCheckBox.setOnClickListener { allowDebit() }
        //PaypalCheckBox.setOnClickListener { allowPaypal() }
        //WalletCheckBox.setOnClickListener { allowWallet() }
        //RazorCheckBox.setOnClickListener { allowRazor() }

        //btnApplyCoupon.setOnClickListener { openDialogCoupon() }

        /*enterWalletAmountEdt.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                var interAmount = enterWalletAmountEdt.text.toString()
                if (s.toString().isEmpty()) {
                    interAmount = "0"

                    //  enterWalletAmountEdt.setText("0")
                }

                if (CommonUtil.getPreferencesString(mContext, AppConstants.Wbalance) != null) {
                    if (CommonUtil.getPreferencesString(mContext, AppConstants.Wbalance) != null) {
                        var waltBal: Double = CommonUtil.getPreferencesString(mContext, AppConstants.Wbalance!!)!!.toDouble()

                        var amountInDouble = interAmount.toDouble()
                        rtnvalue = compareFun(waltBal, amountInDouble)//2 is good
                        Log.i("dfjkhfdgjk", rtnvalue.toString())
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }
        })*/

        /*if (CommonUtil.getPreferencesString(mContext, AppConstants.Wbalance!!) != null) {
            val number = CommonUtil.getPreferencesString(mContext, AppConstants.Wbalance!!)
            val rounded = number!!.toBigDecimal().setScale(5, RoundingMode.UP).toDouble()
            myWalletBalanceTv.setText("Global Business Wallet :-  $ " + rounded.toString())
        }*/
        return view
    }

    private fun initializeView(view: View) {
        realm = Realm.getDefaultInstance()
        Checkout.preload(context) //for razor pay
        paymentBack = view.findViewById(R.id.paymentBack)
        radioGpPayment = view.findViewById(R.id.radioGpPayment)
        invoice_id = view.findViewById(R.id.invoice_id)

        paymentButton = view.findViewById(R.id.paymentButton)

        paymentServicePayAmount = view.findViewById(R.id.paymentServicePayAmount)
        paymentServiceDes = view.findViewById(R.id.paymentServiceDes)
        paymentServiceName = view.findViewById(R.id.paymentServiceName)
        paymentServicePrice = view.findViewById(R.id.paymentServicePrice)
        paymentServiceTotalPrice = view.findViewById(R.id.paymentServiceTotalPrice)
        price = CommonUtil.getPreferencesString(mContext, AppConstants.price)!!
        domainName = CommonUtil.getPreferencesString(mContext, AppConstants.One)!!
        val args = arguments
        inputCurrency = args!!.getString("currency", "")
        if (!inputCurrency.isNullOrEmpty()) {
            inputCurrencyInCreateOrder = if (inputCurrency.contentEquals("USD")) {
                "USD"
            } else {
                "INR"
            }
        }
        setDefaultData()
        /*val data =  "$invoic_id|pay_IwxBla1DnxF7xx"
        var signature1 = CommonUtil.encode(data,AppConstants.RAZORPAY_TEST_SECRET)
        var signature2 = CommonUtil.generateHashWithHmac256(data,AppConstants.RAZORPAY_TEST_SECRET)*/


    }

    private fun setDefaultData() {
        invoice_id.text = "#$invoic_id"
        //mCtx.resources.getString(R.string.rs)
        val prefix = if (inputCurrencyInCreateOrder.contentEquals("USD")) {
            "$"
        } else {
            mContext.resources.getString(R.string.rs)
        }
        if (price != null) paymentServicePayAmount.text = "$prefix $price"
        if (Description != null) paymentServiceDes.text = Description
        if (serviceName != null) paymentServiceName.text = serviceName
        if (minPrice != null) paymentServicePrice.text = "$prefix $minPrice"
        if (totalPrice != null) paymentServiceTotalPrice.text = "$prefix $totalPrice"
    }

    private fun clickListener(view: View) {
        paymentBack.setOnClickListener { findNavController().navigate(R.id.action_paymentFragment_to_servicesFragment) }
        radioGpPayment.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.radioBtnCreditCard && radioBtnCreditCard.isChecked) {
                paymentMode = "credit_card"
            } else if (checkedId == R.id.radioBtnDebitCard && radioBtnDebitCard.isChecked) {
                paymentMode = "debit_card"
            } else if (checkedId == R.id.radioBtnPayPal && radioBtnPayPal.isChecked) {
                paymentMode = "paypal"
            } else if (checkedId == R.id.radioBtnRazorpay && radioBtnRazorpay.isChecked) {
                paymentMode = "razorpay"
            }
            //CommonUtil.successToast("", "you have selected $paymentMode payment gateway.", requireActivity())
        })
        paymentButton.setOnClickListener {
            if (radioGpPayment.checkedRadioButtonId == -1) {
                CommonUtil.warningToast("Payment Mode!", "Please select a payment mode", requireActivity())
            } else {
                when (paymentMode) {
                    "credit_card" -> {
                        //payNowWithCreditCard(paymentMode)
                    }
                    "debit_card" -> {
                        //payNowWithDebitCard()
                    }
                    "paypal" -> {
                        //payNowWithPaypal()
                    }
                    "razorpay" -> {
                        getProfileApi(totalPrice)

                        //startPaymentWithRazorPay("order_123456789", "55", 100, "Vinod Kumar Pal", "vinod@milkywayservices.com", "9540381085", "H 146 147 Sector 63, Noida - 201301")
                    }
                }
                //checkValidation()
            }
        }
    }

    private fun getProfileApi(totalPrice: String) {
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
                                            getRazorpayOrderId(totalPrice, "0", fullName, email!!, mobile!!, fullAddress, inputCurrencyInCreateOrder)
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
                navController.navigate(R.id.action_paymentFragment_to_profileFragment)
            }
            .show()
    }

    //todo get razor order id
    private fun getRazorpayOrderId(payAmount: String, wallet: String, fullName: String, email: String, mobile: String, fullAddress: String, inputCurrencyInCreateOrder: String) {
        if (CommonUtil.checkNetwork(mContext)) {

            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)
            val apiService = GbusinessService.create(mContext)
            if (userID != null) {
                apiService.getRazorPayOrderId(
                    "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),
                    invoic_id,
                    serviceName,
                    wallet,
                    payAmount,
                    inputCurrencyInCreateOrder
                )
                    .enqueue(object : Callback<RazorPayOrderId> {
                        override fun onFailure(call: Call<RazorPayOrderId>, t: Throwable) {

                            CommonUtil.hideDialog(mContext)
                            CommonUtil.toast(R.string.showError.toString(), mContext)
                            CommonUtil.logi(t.localizedMessage.toString())
                        }

                        override fun onResponse(
                            call: Call<RazorPayOrderId>,
                            response: Response<RazorPayOrderId>,
                        ) {
                            CommonUtil.hideDialog(mContext)

                            Log.i("TAGad", response.body()?.success.toString())
                            val getdata = response.body()
                            if (getdata != null) {
                                if (getdata.success) {
                                    razorOrderId = getdata.data.id
                                    receipt = getdata.data.receipt
                                    razorpayAmountInINR = getdata.data.amount_due

                                    doAsync {
                                        //startPaymentWithRazorPay("order_123456789", receipt, razorpayAmountInINR, fullName, email, mobile, "H 146 147 Sector 63, Noida - 201301")
                                        startPaymentWithRazorPay(razorOrderId, receipt, razorpayAmountInINR, fullName, email, mobile, fullAddress)
                                    }
                                }
                            } else
                                CommonUtil.toast("Something went wrong", mContext)
                        }
                    })
            }
            // startActivity(Intent(this,OtpActivity::class.java))
        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }

    //todo start payment with razorpay
    private fun startPaymentWithRazorPay(razorOrderId: String, receipt: String, razorpayAmountInINR: Int, fullName: String?, email: String, mobile: String, fullAddress: String) {

        //val payAmountInt = razorpayAmountInINR.toInt()
        //val finalAmount = payAmountInt * 100
        CommonUtil.saveStringPreferences(mContext, AppConstants.RazorAmount, razorpayAmountInINR.toString())
        // You need to pass current activity in order to let Razorpay create CheckoutActivity
        // val activity = this

        Log.i("tag", "razor pay start")
        val activity: Activity = requireActivity()
        val co = Checkout()
        co.setKeyID(AppConstants.RAZORPAY_TEST_KEY) // set your razorpay api key
        co.setImage(R.drawable.logo) // set your logo here
        try {
            val options = JSONObject()
            options.put("name", fullName)
            options.put("description", serviceName)
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png")
            options.put("currency", "INR")
            options.put("order_id", razorOrderId) //phelee ek api se order id genrate krte h nhai to code nhai chle ga by vinod kumar pal
            options.put("amount", razorpayAmountInINR)

            val preFill = JSONObject()
            preFill.put("email", "vkpal.its@gmail.com")
            preFill.put("contact", "9540381085")

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
    }

    fun checkRazorResponse(context: Context, paymentData: PaymentData?, success: Boolean) {
        if (success) {
            updatePaymentStatus(paymentData, context)
            //do your api call
        } else {
            //handle error message
        }
    }

    fun getToast(context: Context) {
        Toast.makeText(context, "Hello Payment Fragment", Toast.LENGTH_SHORT).show()
    }

    private fun updatePaymentStatus(data: PaymentData?, context: Context) {
        val razorpayPaymentId = data?.paymentId
        val razorpaySignature = data?.signature
        val razorpayOrderId = data?.orderId

        val bundle = Bundle()
        bundle.putString("payId", razorpayPaymentId)
        bundle.putString("orderId", razorpayOrderId)
        bundle.putString("signature", razorpaySignature)
        paymentStatus(context, bundle)
    }


    private fun paymentStatus(context: Context, bundle: Bundle) {
        IonAlert(context, IonAlert.WARNING_TYPE)
            .setTitleText("Payment Status!")
            .setContentText("Payment is under processing...")
            .setConfirmText("Continue...")
            .showCancelButton(false)
            .setConfirmClickListener {
                it.dismissWithAnimation()
                navController.navigate(R.id.action_paymentFragment_to_paymentStatusFragment, bundle)
            }
            .show()
    }

    private fun payNowWithCreditCard(paymentMode: String) {
        val web = "https://www.gbusiness.co/app-paynow?wallet_amount=$totalPrice&invoice_id=$invoic_id"
        val ccAvenueWebUrl = "https://secure.ccavenue.com/transaction/transaction.do?command=initiateTransaction"
        var bundle = Bundle() // bundleOf("web",web)
        bundle.putString("webs", web)
        findNavController().navigate(R.id.action_paymentFragment_to_CCavanuPaymentWebview, bundle)
    }

    /*private fun openDialogCoupon() {
        try {

            val dialog = AlertDialog.Builder(mContext).create()
            dialog.setCancelable(false)
            val lay = LayoutInflater.from(mContext).inflate(R.layout.dialog_coupon, null)
            dialog.setView(lay)

            val btnCloss = lay.findViewById<ImageView>(R.id.imgCoupnCloss)
            val coupon = lay.findViewById<EditText>(R.id.edCouponInput)

            btnCloss.setOnClickListener { dialog.dismiss() }
            lay.findViewById<Button>(R.id.btnApplyCoupon).setOnClickListener {

                if (!coupon.text.toString().isNullOrEmpty()) {
                    callAPIForApplyCoupon(coupon.text.toString());

                    dialog.dismiss()
                } else {
                    CommonUtil.toast("enter coupon", mContext)
                }
            }

            dialog.show()
        } catch (e: Exception) {
            Log.i("error on coupon", e.localizedMessage)
        }
    }*/

    /*private fun callAPIForApplyCoupon(copon: String) {

        if (CommonUtil.checkNetwork(mContext)) {

            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)




            CommonUtil.showDialog(mContext)
            val apiService = GbusinessService.create(mContext)
            if (userID != null) {
                apiService.applyCoupn(
                    "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),
                    userID,
                    invoic_id,
                    copon
                )
                    .enqueue(object : Callback<ApplyCouponResponse> {
                        override fun onFailure(call: Call<ApplyCouponResponse>, t: Throwable) {

                            CommonUtil.hideDialog(mContext)
                            CommonUtil.toast(R.string.showError.toString(), mContext)
                            CommonUtil.logi(t.localizedMessage.toString())
                        }

                        override fun onResponse(
                            call: Call<ApplyCouponResponse>,
                            response: Response<ApplyCouponResponse>,
                        ) {
                            CommonUtil.hideDialog(mContext)

                            Log.i("TAGad", response.body()?.success.toString())
                            val getdata = response.body()
                            if (getdata != null) {
                                if (getdata.success) {
                                    btnApplyCoupon.setText("APPLIED")
                                    CommonUtil.toast("successfully apply", mContext)
                                    // findNavController().navigate(R.id.action_paymentFragment_to_mainFragment)
                                } else CommonUtil.toast("fail try again", mContext)

                            } else CommonUtil.toast("Something went wrong", mContext)

                        }

                    })
            }
            // startActivity(Intent(this,OtpActivity::class.java))
        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }*/


    private fun checkValidation() {

        //  Log.i("dfdfd","payType"+payType)
        //    Log.i("dfdfd","rtnvalue"+rtnvalue)
        //   Log.i("dfdfd","rtnvalue"+rtnvalue)

        /*if (rtnvalue != 0 || rtnvalue != 2) {
            if (payType.equals("paypal")) {
                payNow()
                //       Log.i("dfdfd","paynow")
            } else if (payType.equals("ccavenu")) {
                payNowWithCcavanu()
                //        Log.i("dfdfd","payNowWithCcavanu")

            } else if (payType.equals("razor")) {
                payNowWithRazor()
                //          Log.i("dfdfd","razor")
            }
        } else {
            enterWalletAmountEdt.requestFocus()
            enterWalletAmountEdt.error = "enter valid amount"
        }*/
    }

    /*private fun payNowWithRazorPay() {
        if (payType == "razor") {
            var getValue = enterWalletAmountEdt.text.toString()
            enterBal = if (getValue == "")
                0.0
            else
                getValue.toDouble()

            if (enterWalletAmountEdt.text.toString().isEmpty()) {

                if (price != "" && domainName != null && domainName != "") {
                    //todo add payment and domain details in server
                    //  addPaymentDetailsDataBAse(price,enterBal.toString())
                    // CommonUtil.toast("Go with======= razor full payment${price.toString()}",mContext)

                    //getRazorpayOrderId(price, "0")
                    startPaymentWithRazorPay(razorOrderId, receipt, razorpayAmountInINR.toString())
                }
            } else {
                price = CommonUtil.getPreferencesString(mContext, AppConstants.price)!!
                var domainPrice = price.toDouble()

                rstl = compareFun(domainPrice, enterBal) //2 good

                if (rstl == 2 || rstl == 0) {
                    var gotopayment = domainPrice.minus(enterBal)

                    Log.i("dfjkhfdgjkgotopayment ", gotopayment.toString())

                    if (gotopayment == 0.0) {
                        // CommonUtil.toast("go for wallet payment",mContext)
                        paymentThroughWallet(enterWalletAmountEdt.text.toString())

                    }


                    if (gotopayment > 0.0) {
                        // CommonUtil.toast("gotopayment razor ${gotopayment.toString()}",mContext)

                        Log.i("pawan", "paypal= " + gotopayment)
                        Log.i("pawan", "wallet= " + enterBal)

                        //todo add payment and domain details in server (withPayPAl,with Wallet)
                        //   addPaymentDetailsDataBAse(gotopayment.toString(),enterBal.toString())
                        //getRazorpayOrderId(gotopayment.toString(), enterBal.toString())
                        startPaymentWithRazorPay(razorOrderId, receipt, razorpayAmountInINR.toString())
                    }
                    // if (gotopayment.toString().contains("-"))  CommonUtil.toast("--------",mContext)

                } else {
                    CommonUtil.toast("wrong input", mContext)
                }


                *//* var domainName = CommonUtil.getPreferencesString(mContext,AppConstants.content_one)
                 if (price!=null && !price.equals("") && domainName!=null && !domainName.equals(""))
                 {

                     //    startpaypal(price,domainName!!)
                 }*//*
            }


            *//*   Log.i("dfjkhfdgjk = ", rstl.toString())
               Log.i("dfjkhfdgjk price = ", price.toString())
               Log.i("dfjkhfdgjk enter bal= ", enterBal.toString())
   *//*


        }
    }*/

    /*private fun payNowWithCcavanu() {

        if (payType.equals("ccavenu")) {
            var getValue = enterWalletAmountEdt.text.toString()
            if (getValue.equals("")) enterBal = 0.0
            else enterBal = getValue.toDouble()

            if (enterWalletAmountEdt.text.toString().isEmpty()) {


                if (price != null && !price.equals("") && domainName != null && !domainName.equals("")) {
                    //  CommonUtil.toast("Go with======= ccavanu full payment${price.toString()}",mContext)


                    //todo add payment and domain details in server
                    //  addPaymentDetailsDataBAse(price,enterBal.toString())
                    //  val  web ="https://www.gbusiness.co/uat/app-paynow?wallet_amount=$enterBal&invoice_id=$invoic_id"
                    val web = "https://www.gbusiness.co/app-paynow?wallet_amount=$enterBal&invoice_id=$invoic_id"


                    var bundle = Bundle() // bundleOf("web",web)
                    bundle.putString("webs", web)
                    findNavController().navigate(R.id.action_paymentFragment_to_CCavanuPaymentWebview, bundle)
                }

            } else {
                price = CommonUtil.getPreferencesString(mContext, AppConstants.price)!!
                var domainPrice = price.toDouble()

                rstl = compareFun(domainPrice, enterBal) //2 good

                if (rstl == 2 || rstl == 0) {
                    var gotopayment = domainPrice.minus(enterBal)

                    //   Log.i("dfjkhfdgjkgotopayment ", gotopayment.toString())

                    if (gotopayment == 0.0) {
                        //  CommonUtil.toast("go for wallet payment",mContext)
                        //paymentThroughWallet(enterWalletAmountEdt.text.toString())

                    }


                    if (gotopayment > 0.0) {
                        // CommonUtil.toast("gotopayment ccavanu ${gotopayment.toString()}",mContext)

                        Log.i("pawan", "paypal= " + gotopayment)
                        Log.i("pawan", "wallet= " + enterBal)

                        //todo add payment and domain details in server (ccananue)
                        // val web = "https://www.gbusiness.co/uat/app-paynow?wallet_amount=$enterBal&invoice_id=$invoic_id"
                        val web = "https://www.gbusiness.co/app-paynow?wallet_amount=$enterBal&invoice_id=$invoic_id"

                        var bundle = Bundle()
                        bundle.putString("webs", web)
                        findNavController().navigate(R.id.action_paymentFragment_to_CCavanuPaymentWebview, bundle)
                        //   addPaymentDetailsDataBAse(gotopayment.toString(),enterBal.toString())
                    }
                    // if (gotopayment.toString().contains("-"))  CommonUtil.toast("--------",mContext)

                } else {
                    CommonUtil.toast("wrong input", mContext)
                }


                var domainName = CommonUtil.getPreferencesString(mContext, AppConstants.content_one)
                if (price != null && !price.equals("") && domainName != null && !domainName.equals("")) {

                    //    startpaypal(price,domainName!!)
                }
            }


            Log.i("dfjkhfdgjk = ", rstl.toString())
            Log.i("dfjkhfdgjk price = ", price.toString())
            Log.i("dfjkhfdgjk enter bal= ", enterBal.toString())


        }
    }*/

    //todo paypal sdk
    /*private fun payNow() {

        if (payType.equals("paypal")) {
            var getValue = enterWalletAmountEdt.text.toString()
            if (getValue.equals("")) enterBal = 0.0
            else enterBal = getValue.toDouble()

            if (enterWalletAmountEdt.text.toString().isEmpty()) {

                Log.i("dfdfd", "price" + price)
                Log.i("dfdfd", "domainName" + domainName)

                if (price != null && !price.equals("") && domainName != null && !domainName.equals("")) {
                    //startpaypal(price,domainName!!)
                    addPaymentDetailsDataBAse(price, enterBal.toString())
                    //  CommonUtil.toast("Go with======= paypal full payment${price.toString()}",mContext)
                }

            } else {
                price = CommonUtil.getPreferencesString(mContext, AppConstants.price)!!
                var domainPrice = price.toDouble()

                rstl = compareFun(domainPrice, enterBal) //2 good

                if (rstl == 2 || rstl == 0) {
                    var gotopayment = domainPrice.minus(enterBal)

                    Log.i("dfjkhfdgjkgotopayment ", gotopayment.toString())

                    if (gotopayment == 0.0) {
                        //  CommonUtil.toast("go for wallet payment",mContext)
                        paymentThroughWallet(enterWalletAmountEdt.text.toString())

                    }


                    if (gotopayment > 0.0) {
                        // CommonUtil.toast("gotopayment paypal ${gotopayment.toString()}",mContext)
*//*
                        Log.i("pawan","paypal= "+gotopayment)
                        Log.i("pawan","wallet= "+enterBal)*//*

                        //todo (paypal = gotopayment and pay with wallet = enterBal)
                        addPaymentDetailsDataBAse(gotopayment.toString(), enterBal.toString())
                    }
                    // if (gotopayment.toString().contains("-"))  CommonUtil.toast("--------",mContext)

                } else {
                    CommonUtil.toast("wrong input", mContext)
                }


                *//* var domainName = CommonUtil.getPreferencesString(mContext,AppConstants.content_one)
                 if (price!=null && !price.equals("") && domainName!=null && !domainName.equals(""))
                 {

                     //    startpaypal(price,domainName!!)
                 }*//*
            }


            *//* Log.i("dfjkhfdgjk = ", rstl.toString())
             Log.i("dfjkhfdgjk price = ", price.toString())
             Log.i("dfjkhfdgjk enter bal= ", enterBal.toString())
 *//*


        }
    }

    private fun allowCreadet() {
        if (creditCheckBox.isChecked) {
            RazorCheckBox.isChecked = false
            debitCheckBox.isChecked = false
            PaypalCheckBox.isChecked = false
            payType = "ccavenu"
        } else WalletCheckBox.isChecked = true
    }

    private fun allowDebit() {
        if (debitCheckBox.isChecked) {
            creditCheckBox.isChecked = false
            PaypalCheckBox.isChecked = false
            RazorCheckBox.isChecked = false
            payType = "ccavenu"
        } else WalletCheckBox.isChecked = true

    }

    private fun allowPaypal() {
        if (PaypalCheckBox.isChecked) {
            debitCheckBox.isChecked = false
            creditCheckBox.isChecked = false
            RazorCheckBox.isChecked = false
            payType = "paypal"
        } else WalletCheckBox.isChecked = true

    }

    private fun allowWallet() {
        if (WalletCheckBox.isChecked) {
            tvPayFromWallet.visibility = View.VISIBLE
            enterWalletAmountEdt.visibility = View.VISIBLE
            // payType= "wallet"
        } else {
            enterWalletAmountEdt.setText("0")

            tvPayFromWallet.visibility = View.INVISIBLE
            enterWalletAmountEdt.visibility = View.INVISIBLE
            if (!PaypalCheckBox.isChecked && !creditCheckBox.isChecked && !RazorCheckBox.isChecked && !debitCheckBox.isChecked) {
                PaypalCheckBox.isChecked = true
            }
        }


    }

    private fun allowRazor() {
        if (RazorCheckBox.isChecked) {
            debitCheckBox.isChecked = false
            creditCheckBox.isChecked = false
            PaypalCheckBox.isChecked = false
            payType = "razor"
        } else WalletCheckBox.isChecked = true


    }*/

    //todo api to use book domain into server using php
    /*private fun addPaymentDetailsDataBAse(byPaypay: String, byWallet: String) {
        if (CommonUtil.checkNetwork(mContext)) {

            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            var myCart_id = CommonUtil.getPreferencesString(mContext, AppConstants.cart_id)
            val apiService = GbusinessService.create(mContext)
            *//* Log.i("TAGad", "aaaaaaaaaaaaaaaaaaaaa byPaypay = "+byPaypay)
             Log.i("TAGad", "aaaaaaaaaaaaaaaaaaaaa byWallet = "+byWallet)
             Log.i("TAGad", "aaaaaaaaaaaaaaaaaaaaa"+myCart_id)
             Log.i("TAGad", "aaaaaaaaaaaaaaaaaaaaa USER_ID "+userID)
             Log.i("TAGad", "aaaaaaaaaaaaaaaaaaaaa service ="+service)
             Log.i("TAGad", "aaaaaaaaaaaaaaaaaaaaa TOKEN ="+CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN))*//*

            CommonUtil.showDialog(mContext)
            apiService.getChackOutPaypal(
                "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),
                byPaypay,
                byWallet!!,
                userID!!,
                service,
                invoic_id,
                myCart_id!!
            )
                .enqueue(object : Callback<expressChackOutPaypalDataClass> {
                    override fun onFailure(call: Call<expressChackOutPaypalDataClass>, t: Throwable) {

                        // Log.i("TAGad", "fgsfdjgifidgfdgifgfgggggg")

                        CommonUtil.hideDialog(mContext)
                        CommonUtil.toast(R.string.showError.toString(), mContext)
                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(call: Call<expressChackOutPaypalDataClass>, response: Response<expressChackOutPaypalDataClass>) {
                        CommonUtil.hideDialog(mContext)


                        Log.i("TAGad", response.body().toString())

                        val getdata = response.body()
                        CommonUtil.logi(getdata.toString())
                        if (getdata != null) {

                            if (getdata.success) {

                                if (getdata.data != null) {
                                    if (getdata.data.name != null) startpaypal(byPaypay, getdata.data.name)
                                } else CommonUtil.toast(R.string.showError.toString(), mContext)

                                //  startpaypal(byPaypay,service)

                            } else {
                                CommonUtil.toast("please enter valid current password", mContext)
                            }
                        } else CommonUtil.toast(R.string.showError.toString(), mContext)
                    }

                })

            // startActivity(Intent(this,OtpActivity::class.java))


        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }*/


    /*private fun startpaypal(price: String, buyThingName: String) {
        // CommonUtil.toast("ok",mContext)

        val intent = Intent(mContext, PayPalService::class.java)
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config)
        requireActivity().startService(intent)


        val thingToBuy = getThingToBuy(PayPalPayment.PAYMENT_INTENT_SALE, price, buyThingName)

        *//*
         * See getStuffToBuy(..) for examples of some available payment options.
         *//*

        val intents = Intent(mContext, PaymentActivity::class.java)

        // send the same configuration for restart resiliency
        intents.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config)

        intents.putExtra(PaymentActivity.EXTRA_PAYMENT, thingToBuy)

        startActivityForResult(intents, REQUEST_CODE_PAYMENT)


    }*/

    private fun getThingToBuy(paymentIntent: String, price: String, buyThingName: String): PayPalPayment {


        val payment = PayPalPayment(BigDecimal(price.toDouble()), "USD", buyThingName, paymentIntent)
        payment.invoiceNumber(invoic_id)
        return payment
    }

    public override fun onDestroy() {
        // Stop service when done
        requireActivity().stopService(Intent(mContext, PayPalService::class.java))
        realm.close()
        super.onDestroy()
    }

    // todo used in paypal
    companion object {
        private val TAG = "paymentExample"

        /**
         * - Set to PayPalConfiguration.ENVIRONMENT_PRODUCTION to move real money.
         * - Set to PayPalConfiguration.ENVIRONMENT_SANDBOX to use your test credentials
         * from https://developer.paypal.com
         * - Set to PayPalConfiguration.ENVIRONMENT_NO_NETWORK to kick the tires
         * without communicating to PayPal's servers.
         */
        private val CONFIG_ENVIRONMENT = PayPalConfiguration.ENVIRONMENT_SANDBOX

        // note that these credentials will differ between live & sandbox environments.

        //  private val CONFIG_CLIENT_ID = "Af7eYMHAKHmCjIdIIxWhCRFDPYoLxhesJSavVk1P_t1Z92qbOSaJWlHPMk3jqqNSgJU5JDF0yqZPwuhT" //sandbox
        private val CONFIG_CLIENT_ID = "AdPqT75Bupur0gIMKw7ESr5URvgtRtlqiry53xUO4hWg24TmPusfyBPws56whyeI7UirHp4LlR5wOq36"   //live
        private val CONFIG_SEC_ID = "ELGdx52-2Caagvv5yftzAFm1so3-uzEt-JbSXJJtiELy3MCiH4aH6QF9KVXoFh_oPl0xjKbY_LEEwDby"
        private val REQUEST_CODE_PAYMENT = 1
        private val REQUEST_CODE_FUTURE_PAYMENT = 2
        private val REQUEST_CODE_PROFILE_SHARING = 3
        var invoic_id: String = "null"
        var serviceName: String = "null"
        var Description: String = "null"
        var minPrice: String = "null"
        var totalPrice: String = "null"
        var service: String = "domain"

        private val config = PayPalConfiguration()
            .environment(CONFIG_ENVIRONMENT)
            .clientId(CONFIG_CLIENT_ID)
            .merchantName("milkywal")
            .merchantPrivacyPolicyUri(Uri.parse("https://www.gbusiness.co/privacy-and-policy"))
            .merchantUserAgreementUri(Uri.parse("https://www.gbusiness.co/privacy-and-policy"))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        /*if (requestCode == REQUEST_CODE_PAYMENT) {
            if (resultCode == Activity.RESULT_OK) {
                val confirm = data?.getParcelableExtra<PaymentConfirmation>(PaymentActivity.EXTRA_RESULT_CONFIRMATION)
                if (confirm != null) {
                    try {

                        Log.i(TAG, "pawan khatri " + confirm.toJSONObject().toString(4))
                        //  Log.i(TAG, "pawan"+ confirm.payment.toJSONObject().toString(4))
                        */
        /**
         * TODO: send 'confirm' (and possibly confirm.getPayment() to your server for verification
         * or consent completion.
         * See https://developer.paypal.com/webapps/developer/docs/integration/mobile/verify-mobile-payment/
         * for more details.
         * For sample mobile backend interactions, see
         * https://github.com/paypal/rest-api-sdk-python/tree/master/samples/mobile_backend
         *//*
                        var datas = confirm.toJSONObject()
                        var res = datas.getJSONObject("response")
                        var payID = res.getString("id")

                        // displayResultText("PaymentConfirmation info received from PayPal")
                        //  displayResultText("payID $payID")

                        *//*  getAccesTokanPaypal(payID)*//*

                        //todo start service for paypal payment
                        sendDataFOrPaypalWithService(payID, invoic_id)

                    } catch (e: JSONException) {
                        Log.e(TAG, "an extremely unlikely failure occurred: ", e)
                    }

                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Log.i(TAG, "The user canceled.")
            } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
                Log.i(
                    TAG,
                    "An invalid Payment or PayPalConfiguration was submitted. Please see the docs."
                )
            }
        } else if (requestCode == REQUEST_CODE_FUTURE_PAYMENT) {
            if (resultCode == Activity.RESULT_OK) {
                val auth = data?.getParcelableExtra<PayPalAuthorization>(PayPalFuturePaymentActivity.EXTRA_RESULT_AUTHORIZATION)
                if (auth != null) {
                    try {
                        Log.i("FuturePaymentExample", auth.toJSONObject().toString(4))

                        val authorization_code = auth.authorizationCode
                        Log.i("FuturePaymentExample", authorization_code)

                        //  sendAuthorizationToServer(auth)
                        displayResultText("Future Payment code received from PayPal")

                    } catch (e: JSONException) {
                        Log.e("FuturePaymentExample", "an extremely unlikely failure occurred: ", e)
                    }

                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Log.i("FuturePaymentExample", "The user canceled.")
            } else if (resultCode == PayPalFuturePaymentActivity.RESULT_EXTRAS_INVALID) {
                Log.i(
                    "FuturePaymentExample",
                    "Probably the attempt to previously start the PayPalService had an invalid PayPalConfiguration. Please see the docs."
                )
            }
        } else if (requestCode == REQUEST_CODE_PROFILE_SHARING) {
            if (resultCode == Activity.RESULT_OK) {
                val auth = data?.getParcelableExtra<PayPalAuthorization>(PayPalProfileSharingActivity.EXTRA_RESULT_AUTHORIZATION)
                if (auth != null) {
                    try {
                        Log.i("ProfileSharingExample", auth.toJSONObject().toString(4))

                        val authorization_code = auth.authorizationCode
                        Log.i("ProfileSharingExample", authorization_code)

                        //   sendAuthorizationToServer(auth)
                        displayResultText("Profile Sharing code received from PayPal")

                    } catch (e: JSONException) {
                        Log.e("ProfileSharingExample", "an extremely unlikely failure occurred: ", e)
                    }

                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Log.i("ProfileSharingExample", "The user canceled.")
            } else if (resultCode == PayPalFuturePaymentActivity.RESULT_EXTRAS_INVALID) {
                Log.i(
                    "ProfileSharingExample",
                    "Probably the attempt to previously start the PayPalService had an invalid PayPalConfiguration. Please see the docs."
                )
            }
        }*/
    }

    /*private fun getAccesTokanPaypal(payID: String?) {
        if (payID != null) {
            //   Log.i("paypal", "start paypal payment =" + payID)


            val CONFIG_CLIENT_ID = resources.getString(R.string.configClintID)
            val CONFIG_SEC_ID = resources.getString(R.string.secID)
            val credentials = Credentials.basic(
                CONFIG_CLIENT_ID,
                CONFIG_SEC_ID
            )

            initRetrofit().getAccessToken(credentials, "client_credentials")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { token -> Log.d(TAG, token.access_token)*//* Log.d(TAG, token.access_token)*//* },
                    { error -> Log.d("paypal", error.localizedMessage) }
                )
        }
    }*/

    /*private fun initRetrofit(): PayPalClient {

        return Retrofit.Builder()
            .baseUrl("https://api.paypal.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(PayPalClient::class.java)
    }*/

    //todo send payid and access token to server
    /*private fun getTransationDetails(accessToken: String, payID: String) {

        if (CommonUtil.checkNetwork(mContext)) {

            Log.i("paypal", "getTransationDetails  accessToken = " + accessToken)
            Log.i("paypal ", "invoic_id = " + invoice_id)

            val apiService = GbusinessService.create(mContext)
            CommonUtil.showDialog(mContext)
            apiService.sendPaypalDetailsTOServer(
                "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),
                accessToken,
                payID,
                "https://api.paypal.com/v1/payments/payment/",
                invoic_id

            )
                .enqueue(object : Callback<sendPayalCredentailsToServerDataClass> {
                    override fun onFailure(
                        call: Call<sendPayalCredentailsToServerDataClass>,
                        t: Throwable,
                    ) {
                        CommonUtil.hideDialog(mContext)
                        // Log.i("TAGad", "fgsfdjgifidgfdgifgfgggggg")
                        Log.i("paypal", "error")

                    }

                    override fun onResponse(
                        call: Call<sendPayalCredentailsToServerDataClass>,
                        response: Response<sendPayalCredentailsToServerDataClass>,
                    ) {


                        val getdata = response.body()
                        //   CommonUtil.logi(getdata.toString())
                        Log.i("paypal resutl = ", getdata.toString())
                        if (getdata != null) {

                            if (getdata.success) {

                                Log.i("paypal", "payment success for palpal")
                                //  delRealmDetails(payID)
                                PaymentStatus.paymentStatudResult.setText("payment success")

                            } else {
                                // CommonUtil.toast("please enter valid current password", mContext)
                                Log.i("paypal", "get fails for payment")

                            }
                        } else Log.i("paypal", "SomeThing went wrong")
                        //   CommonUtil.toast("SomeThing went wrong", mContext)


                    }

                })

            // startActivity(Intent(this,OtpActivity::class.java))


        } else {
            CommonUtil.toast("Check Internet", mContext)
        }

    }*/

    /*private fun sendDataFOrPaypalWithService(payID: String, invoicId: String) {
        val realm = Realm.getDefaultInstance()
        realm.executeTransactionAsync({
            val savePayID = it.createObject(RealmStorageModelClass::class.java)

            savePayID.payMethod = "paypal"
            savePayID.paytype = "paypal"
            savePayID.pay_id = payID
            savePayID.invoice_id = invoicId
            savePayID.user_id = null
            savePayID.captured = null
            savePayID.transaction_id = payID
            savePayID.bank_ref_no = null
            savePayID.order_status = null
            savePayID.failure_message = null
            savePayID.payment_mode = null
            savePayID.card_name = null
            savePayID.currency = null
            savePayID.amount = null
            savePayID.created_at = null
            savePayID.domain_name = null
            savePayID.status = "1"
            savePayID.workingStage = "1"
        }, {
            Log.i("paypal reaml", "On Success: Data Written Successfully!")

            val intent = Intent(mContext, SecondService::class.java)
            intent.putExtra("payId", payID)
            intent.putExtra("orderId", "paypal")
            mContext.startService(intent)

        }, {
            Log.i("paypal p.f reaml", it.localizedMessage)
        })
    }*/


    fun displayResultText(result: String) {

        Toast.makeText(
            mContext,
            result, Toast.LENGTH_LONG
        ).show()
    }


    //todo function to compare to double numbers
    fun compareFun(a: Double, b: Double): Int {
        return if (a.toString().contentEquals(b.toString())) 0 else if (a < b) 1 else 2
    }


    //todo pay from wallet
    /*fun paymentThroughWallet(amount: String) {
        if (CommonUtil.checkNetwork(mContext)) {
            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)

            Log.i("TAGad", invoic_id)
            Log.i("TAGad", serviceName)
            Log.i("TAGad", amount.toString())
            //Log.i("TAGad", invoic_id)
            if (userID != null) {
                Log.i("TAGad", userID)
            }

            CommonUtil.showDialog(mContext)
            val apiService = GbusinessService.create(mContext)
            if (userID != null) {
                apiService.payWithWallet(
                    "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),
                    "0",
                    amount,
                    service,
                    invoic_id, userID
                )
                    .enqueue(object : Callback<PayWithWalletResponse> {
                        override fun onFailure(call: Call<PayWithWalletResponse>, t: Throwable) {

                            CommonUtil.hideDialog(mContext)
                            CommonUtil.toast(R.string.showError.toString(), mContext)
                            CommonUtil.logi(t.localizedMessage.toString())
                        }

                        override fun onResponse(
                            call: Call<PayWithWalletResponse>,
                            response: Response<PayWithWalletResponse>,
                        ) {
                            CommonUtil.hideDialog(mContext)

                            Log.i("TAGad", response.body()?.success.toString())
                            val getdata = response.body()
                            if (getdata != null) {
                                if (getdata.success) {
                                    CommonUtil.toast(getdata.message, mContext)
                                    findNavController().navigate(R.id.action_paymentFragment_to_mainFragment)
                                } else CommonUtil.toast(getdata.message, mContext)

                            } else CommonUtil.toast("Something went wrong", mContext)

                        }

                    })
            }
            // startActivity(Intent(this,OtpActivity::class.java))
        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }*/

    override fun onDetach() {
        super.onDetach()
        Log.i("pawan", "onDetach")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("pawan", "onDestroyView")
    }
}
