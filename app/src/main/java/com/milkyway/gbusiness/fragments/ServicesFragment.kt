package com.milkyway.gbusiness.fragments


import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.adaptor.ServicesFragmentAdaptor
import com.milkyway.gbusiness.api.DialogClick
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.api.OnServiceAdapterClick
import com.milkyway.gbusiness.models.SendEnqueyAndBuyDataClass
import com.milkyway.gbusiness.models.ServicesDataClass
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.utils.CommonUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ServicesFragment : Fragment(), Callback<ServicesDataClass>, OnServiceAdapterClick, DialogClick {


    override fun onDialogClick() {
        Toast.makeText(mContext, "Ok, service Coming soon.", Toast.LENGTH_SHORT).show()
    }

    private lateinit var viewAdapter: ServicesFragmentAdaptor
    private var recyclerView: RecyclerView? = null
    private lateinit var myServiceBack: ImageView
    private lateinit var edtName: EditText
    private lateinit var edtEmail: EditText
    private lateinit var edtPhone: EditText
    private lateinit var edtType: EditText
    private lateinit var edtMessage: EditText
    private lateinit var btnSubmitQuotes: AppCompatButton

    private lateinit var layoutClose: RelativeLayout
    private lateinit var headerOne: TextView
    private lateinit var headerTwo: TextView
    private lateinit var termCondition: TextView
    private lateinit var policeCondition: TextView
    private lateinit var serviceCheckBox: CheckBox
    private lateinit var edtServiceMessage: EditText
    private lateinit var btnBuyService: Button
    private lateinit var closeBottomSheet: RelativeLayout
    private lateinit var openOtherDialog: BottomSheetDialog
    private lateinit var openBuyDialog: BottomSheetDialog
    var buyOrOther: Boolean = false


    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var mContext: Context


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_services, container, false)
        initializeViews(view)

        return view
    }

    private fun initializeViews(view: View) {
        viewManager = LinearLayoutManager(mContext)
        myServiceBack = view.findViewById(R.id.myServiceBack)
        myServiceBack.setOnClickListener { findNavController().navigate(R.id.action_servicesFragment_to_mainFragment) }

        recyclerView = view.findViewById(R.id.servicesRecyclerView)
        recyclerView?.hasFixedSize()
        recyclerView!!.layoutManager = GridLayoutManager(mContext, 1)
        getServiceApi()

        //callSignature()
    }

    private fun callSignature() {
        val data = "order_IwzKeC5Lpozw3v|pay_IwzLM0fzTgB6fM"
        val signature1 = CommonUtil.hmacWithJava("HmacSHA256", data, AppConstants.RAZORPAY_TEST_SECRET)
        val signature = "e6d761bd7006127060ab7796611b010f7f6c999dbf14e348df70b0c749009e13"
        Log.i("Signature:", "\nGenerated:$signature1\nRazorpay:$signature")
        if (signature1.contentEquals(signature)) {
            Toast.makeText(context, "Matched", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "Not Matched", Toast.LENGTH_LONG).show()
        }
    }

    private fun getServiceApi() {
        if (CommonUtil.checkNetwork(mContext)) {
            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)
            val dataNotic = GbusinessService.create(mContext)
            if (userID != null) {
                dataNotic.getServices("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), "application/json"
                ).enqueue(this)
            }

        } else {
            CommonUtil.toast("Check Internet", mContext)
        }


    }

    override fun onFailure(call: Call<ServicesDataClass>, t: Throwable) {
        CommonUtil.hideDialog(mContext)
        CommonUtil.toast(R.string.showError.toString(), mContext)
        CommonUtil.logi(t.localizedMessage.toString())

    }


    override fun onResponse(call: Call<ServicesDataClass>, response: Response<ServicesDataClass>) {
        CommonUtil.hideDialog(mContext)
        // Log.i("TAGad", response.body()?.success.toString())
        val getdata = response.body()
        CommonUtil.logi(getdata.toString())

        if (getdata != null) {
            if (getdata.success) {
                if (getdata.data != null && getdata.data.isNotEmpty()) {
                    val array = getdata.data
                    viewAdapter = ServicesFragmentAdaptor(this!!, array)
                    recyclerView?.adapter = viewAdapter
                }

            }
            if (getdata.message != null) CommonUtil.toast(getdata.message, mContext)
        } else CommonUtil.toast(R.string.showError.toString(), mContext)
    }

    override fun onClickServiceItem(
        service_id: String,
        name: String,
        enqri: String,
        price: String,
        tittle: String,
        descrip: String,
        serviceType: String,
        image: String,
    ) {
        if (price.contentEquals("0"))
            openOtherBottomSheet(service_id, name, enqri, price) // call other
        else
            openBuyBottomSheet(service_id, name, enqri, price, tittle, descrip, serviceType)
    }

    //todo for buy section
    @SuppressLint("SetTextI18n")
    private fun openBuyBottomSheet(
        service_id: String,
        name: String,
        enqri: String,
        price: String,
        firstHeading: String,
        secondHeading: String,
        serviceType: String,
    ) {
        openBuyDialog = BottomSheetDialog(mContext)
        val dialogView = requireActivity().layoutInflater.inflate(R.layout.buy_quites_service, null, false)

        closeBottomSheet = dialogView.findViewById<RelativeLayout>(R.id.closeBottomSheet)
        headerOne = dialogView.findViewById<TextView>(R.id.headerOne)
        headerTwo = dialogView.findViewById<TextView>(R.id.headerTwo)
        termCondition = dialogView.findViewById<TextView>(R.id.termCondition)
        policeCondition = dialogView.findViewById<TextView>(R.id.policeCondition)

        serviceCheckBox = dialogView.findViewById(R.id.serviceCheckBox)
        edtServiceMessage = dialogView.findViewById<EditText>(R.id.edtServiceMessage)
        btnBuyService = dialogView.findViewById<Button>(R.id.btnBuyService)

        btnBuyService.setOnClickListener {
            if (checkConditions()) {
                buyOrOther = true

                //todo hit api for buy a service
                goForPayment(service_id, price, name, secondHeading)
            }
        }
        headerOne.text = firstHeading
        headerTwo.text = secondHeading
        btnBuyService.text = "$$price BUY NOW"
        openBuyDialog.setContentView(dialogView)
        openBuyDialog.setCanceledOnTouchOutside(false)
        closeBottomSheet.setOnClickListener(View.OnClickListener { openBuyDialog.hide() })
        openBuyDialog.show()

    }

    private fun goForPayment(service_id: String, price: String, serviceType: String, description: String) {
        Log.i("serviceType", "serviceType = $serviceType")
        if (CommonUtil.checkNetwork(mContext)) {

            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            var userProfessionID = CommonUtil.getPreferencesString(mContext, AppConstants.PROFESSION)
            var authToken = "Bearer ${CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN)}"
            CommonUtil.showDialog(mContext)

            val dataNotic = GbusinessService.create(mContext)
            if (userID != null && price != null && id != null) {
                dataNotic.getBilling(authToken,
                    "application/json",
                    userID,
                    "android",
                    price,
                    serviceType,
                    "USD",
                    service_id,
                    userProfessionID!!
                ).enqueue(object : Callback<BillingDataClass> {
                    override fun onFailure(call: Call<BillingDataClass>, t: Throwable) {

                        CommonUtil.hideDialog(mContext)
                        CommonUtil.toast(R.string.showError.toString(), mContext)
                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(
                        call: Call<BillingDataClass>,
                        response: Response<BillingDataClass>,
                    ) {
                        CommonUtil.hideDialog(mContext)
                        val getdata = response.body()
                        CommonUtil.logi(getdata.toString())

                        //if (getdata != null) {
                        if (response.code() == 200) {
                            // Log.i("dfdfgf",getdata.walletAmount.balance.toString())
                            if (getdata!!.success) {
                                CommonUtil.saveStringPreferences(mContext, AppConstants.Wbalance, getdata!!.walletAmount.balance)
                                PaymentFragment.invoic_id = getdata.invoice_id.toString()
                                PaymentFragment.serviceName = getdata.invoice_slip.domain_name
                                //PaymentFragment.Description = getdata.invoice_slip.description.toString()
                                PaymentFragment.Description = description
                                PaymentFragment.minPrice = getdata.invoice_slip.price.toString()
                                PaymentFragment.totalPrice = getdata.invoice_slip.total.toString()
                                PaymentFragment.service = serviceType
                                CommonUtil.saveStringPreferences(mContext, AppConstants.price, getdata.payAmount)
                                if (buyOrOther)
                                    openBuyDialog.cancel()
                                else
                                    openOtherDialog.cancel()
                                val bundle = Bundle()
                                bundle.putString("currency", getdata.currency)
                                findNavController().navigate(R.id.action_servicesFragment_to_paymentFragment, bundle)
                            }
                        } else if (response.code() == 500) {
                            CommonUtil.errorToast("Server Error!", "Server isn't responding currently.", requireActivity())
                        } else
                            CommonUtil.toast(getdata!!.message, mContext)
                    } /*else {
                            CommonUtil.toast("SomeThing Went Wrong", mContext)
                        }*/

                })
            }
        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }

    //todo for other section
    private fun openOtherBottomSheet(id: String, ser_name: String, enqri: String, price: String) {

        openOtherDialog = BottomSheetDialog(mContext)
        val dialogView = requireActivity().layoutInflater.inflate(R.layout.send_quites_service, null)

        edtName = dialogView.findViewById<EditText>(R.id.edtName)
        edtEmail = dialogView.findViewById<EditText>(R.id.edtEmail)
        edtPhone = dialogView.findViewById<EditText>(R.id.edtPhone)
        edtMessage = dialogView.findViewById<EditText>(R.id.edtMessage)
        layoutClose = dialogView.findViewById<RelativeLayout>(R.id.layoutClose)
        edtType = dialogView.findViewById<EditText>(R.id.edtType)
        btnSubmitQuotes = dialogView.findViewById<AppCompatButton>(R.id.btnSubmitQuotes)

        var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
        val fullName = CommonUtil.getPreferencesString(mContext, AppConstants.FULL_NAME)
        val email = CommonUtil.getPreferencesString(mContext, AppConstants.EMAIL)
        val phone = CommonUtil.getPreferencesString(mContext, AppConstants.MOBILE)

        btnSubmitQuotes.setOnClickListener {
            if (checkCondition()) {
                buyOrOther = false
                submitEnquiry(fullName, email, phone, ser_name, id, enqri, price, edtMessage.text.toString())
            }
        }

        openOtherDialog.setContentView(dialogView)
        openOtherDialog.setCanceledOnTouchOutside(false)
        edtName.setText(fullName)
        edtEmail.setText(email)
        edtPhone.setText(phone)

        layoutClose.setOnClickListener(View.OnClickListener { openOtherDialog.hide() })
        openOtherDialog.show()
    }

    private fun checkConditions(): Boolean {
        if (edtServiceMessage.text.toString().isEmpty()) {
            edtServiceMessage.requestFocus()
            edtServiceMessage.error = "enter message"
            return false
        }
        if (!serviceCheckBox.isChecked) {
            CommonUtil.toast("check terms and policy ", mContext)
            return false
        }
        return true
    }


    private fun checkCondition(): Boolean {
        if (edtName.text.toString().isEmpty()) {
            edtName.requestFocus()
            edtName.error = "enter name"
            return false
        }
        if (edtEmail.text.toString().isEmpty()) {
            edtEmail.requestFocus()
            edtEmail.error = "enter email"
            return false
        }
        if (edtPhone.text.toString().isEmpty()) {
            edtPhone.requestFocus()
            edtPhone.error = "enter phone"
            return false
        }
        if (edtType.text.toString().isEmpty()) {
            edtType.requestFocus()
            edtType.error = "enter service"
            return false
        }
        if (edtMessage.text.toString().isEmpty()) {
            edtMessage.requestFocus()
            edtMessage.error = "enter message"
            return false
        }
        return true
    }

    private fun submitEnquiry(
        firstName: String?,
        email: String?,
        phone: String?,
        serName: String,
        id: String,
        enquiry: String,
        price: String,
        messageUser: String,
    ) {

        if (CommonUtil.checkNetwork(mContext)) {

            CommonUtil.showDialog(mContext)

            val dataNotic = GbusinessService.create(mContext)
            if (email != null) {
                dataNotic.getSendEnqueyAndBuy("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),
                    "application/json",
                    firstName!!,
                    email,
                    phone!!,
                    serName,
                    messageUser,
                    id,
                    enquiry
                ).enqueue(object : Callback<SendEnqueyAndBuyDataClass> {
                    override fun onFailure(call: Call<SendEnqueyAndBuyDataClass>, t: Throwable) {
                        CommonUtil.hideDialog(mContext)
                        CommonUtil.toast(R.string.showError.toString(), mContext)
                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(
                        call: Call<SendEnqueyAndBuyDataClass>,
                        response: Response<SendEnqueyAndBuyDataClass>,
                    ) {
                        CommonUtil.hideDialog(mContext)

                        // Log.i("TAGad", response.body()?.success.toString())
                        val getdata = response.body()
                        CommonUtil.logi(getdata.toString())

                        if (getdata != null) {
                            if (getdata.success) {
                                //  Log.i("dfdfgf","fisdjhgfgf")
                                CommonUtil.toast(getdata.data.toString(), mContext)
                                if (buyOrOther)
                                    openBuyDialog.hide()
                                else
                                    openOtherDialog.hide()
                            }
                        } else CommonUtil.toast(R.string.showError.toString(), mContext)
                    }
                })
            }
        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }
}



