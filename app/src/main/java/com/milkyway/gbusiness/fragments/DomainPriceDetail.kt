package com.milkyway.gbusiness.fragments


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.activities.MainActivity
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.utils.CommonUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DomainPriceDetail : Fragment() {


    lateinit var mContext: Context
    lateinit var domainDetailDomainNames: TextView
    lateinit var domainDetailDomainPrices: TextView
    lateinit var domainDetailOfferOne: TextView
    lateinit var domainDetailOfferTwo: TextView
    lateinit var domainDetailOfferThree: TextView
    lateinit var domainDetailOfferFour: TextView
    lateinit var domainDetailOfferFive: TextView
    lateinit var domainDetailOfferSix: TextView
    lateinit var domainDetailDomainBuy: TextView
    private lateinit var myDomainDetailsBack: ImageView


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_domain_price_detail, container, false)
        initializeView(view)

        return view
    }

    private fun initializeView(view: View) {

        domainDetailDomainNames = view.findViewById(R.id.domainDetailDomainNames)
        domainDetailDomainPrices = view.findViewById(R.id.domainDetailDomainPrices)

        domainDetailOfferOne = view.findViewById(R.id.domainDetailOfferOne)
        domainDetailOfferTwo = view.findViewById(R.id.domainDetailOfferTwo)
        domainDetailOfferThree = view.findViewById(R.id.domainDetailOfferThree)
        domainDetailOfferFour = view.findViewById(R.id.domainDetailOfferFour)
        domainDetailOfferFive = view.findViewById(R.id.domainDetailOfferFive)
        domainDetailOfferSix = view.findViewById(R.id.domainDetailOfferSix)

        domainDetailDomainBuy = view.findViewById(R.id.domainDetailDomainBuy)
        myDomainDetailsBack = view.findViewById<ImageView>(R.id.myDomainDetailssBack)
        myDomainDetailsBack.setOnClickListener { MainActivity.navController.navigate(R.id.action_domainPriceDetail_to_bookYourDomainFragment) }
        insertData()

    }


    private fun insertData() {
        val domainName = CommonUtil.getPreferencesString(mContext, AppConstants.One)!!
        val currency = CommonUtil.getPreferencesString(mContext, AppConstants.currency)!!
        val price = CommonUtil.getPreferencesString(mContext, AppConstants.price)!!
        val contentOne = CommonUtil.getPreferencesString(mContext, AppConstants.content_one)!!
        val contentTwo = CommonUtil.getPreferencesString(mContext, AppConstants.content_two)!!
        val contentThree = CommonUtil.getPreferencesString(mContext, AppConstants.content_three)!!
        val contentFour = CommonUtil.getPreferencesString(mContext, AppConstants.content_four)!!
        val contentFive = CommonUtil.getPreferencesString(mContext, AppConstants.content_five)!!
        val contentSix = CommonUtil.getPreferencesString(mContext, AppConstants.content_six)!!

        domainDetailDomainNames.text = domainName

        val temp = "$currency $price/ year"
        domainDetailDomainPrices.text = temp
        domainDetailOfferOne.text = contentOne
        domainDetailOfferTwo.text = contentTwo
        domainDetailOfferThree.text = contentThree
        domainDetailOfferFour.text = contentFour
        domainDetailOfferFive.text = contentFive
        domainDetailOfferSix.text = contentSix

        domainDetailDomainBuy.setOnClickListener { buyNow() }
    }

    private fun buyNow() {
        if (CommonUtil.checkNetwork(mContext)) {

            val userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            val price = CommonUtil.getPreferencesString(mContext, AppConstants.price)
            val domainName = CommonUtil.getPreferencesString(mContext, AppConstants.One)
            val services = CommonUtil.getPreferencesString(mContext, AppConstants.services)
            val currency = CommonUtil.getPreferencesString(mContext, AppConstants.currency)
            val cartId = CommonUtil.getPreferencesString(mContext, AppConstants.cart_id)
            val accessToken = "Bearer ${CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN)}"

            val userProfessionID = CommonUtil.getPreferencesString(mContext, AppConstants.PROFESSION)
            CommonUtil.showDialog(mContext)


            val dataNotic = GbusinessService.create(mContext)
            if (userID != null && price != null && domainName != null && services != null && currency != null && cartId != null) {
                dataNotic.getBilling(accessToken,
                    "application/json",
                    userID,
                    domainName,
                    price,
                    services,
                    currency,
                    cartId,
                    userProfessionID!!
                )
                    .enqueue(object : Callback<BillingDataClass> {
                        override fun onFailure(call: Call<BillingDataClass>, t: Throwable) {
                            CommonUtil.hideDialog(mContext)
                            CommonUtil.toast(R.string.showError.toString(), mContext)
                            CommonUtil.logi(t.localizedMessage.toString())
                        }

                        override fun onResponse(
                            call: Call<BillingDataClass>,
                            response: Response<BillingDataClass>,
                        ) {
                            try {
                                CommonUtil.hideDialog(mContext)
                                Log.i("TAGad", response.body()?.success.toString())
                                val getdata = response.body()
                                CommonUtil.logi(getdata.toString())

                                if (getdata != null) {
                                    if (getdata.success) {
                                        Log.i("dfdfgf", getdata.walletAmount.balance.toString())
                                        if (getdata.walletAmount.balance != null) {
                                            CommonUtil.saveStringPreferences(mContext, AppConstants.Wbalance, getdata.walletAmount.balance.toString())
                                            PaymentFragment.invoic_id = getdata.invoice_id.toString()
                                            if (getdata.invoice_slip != null) {
                                                PaymentFragment.serviceName = getdata.invoice_slip.domain_name.toString()
                                                PaymentFragment.Description = getdata.invoice_slip.description.toString()
                                                PaymentFragment.minPrice = getdata.invoice_slip.price.toString()
                                                PaymentFragment.totalPrice = getdata.invoice_slip.total.toString()
                                                PaymentFragment.service = "domain"

                                                findNavController().navigate(R.id.action_domainPriceDetail_to_paymentFragment)
                                            } else CommonUtil.toast("SomeThing went wrong", mContext)
                                        }
                                    } else CommonUtil.toast("SomeThing Went Wrong", mContext)
                                } else CommonUtil.toast("SomeThing Went Wrong", mContext)
                            } catch (e: Exception) {

                            }
                        }
                    })
            }
        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }

    override fun onStop() {
        super.onStop()
        if (CommonUtil.dialog != null)
            CommonUtil.dialog.hide()
    }
}
