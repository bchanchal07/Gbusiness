package com.milkyway.gbusiness.fragments

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.global.CommonUtil
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.api.OnClickServices
import com.milkyway.gbusiness.models.DataXXXXXXXXXXX
import kotlinx.android.synthetic.main.recyclerview_item_payment_invoice.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PaymentORInvoiceAdoptor(
    val listner: OnClickServices,
    val data: List<DataXXXXXXXXXXX>,
    val mContext: View,
    val mmContext: Context
) : RecyclerView.Adapter<PaymentORInvoiceAdoptor.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_payment_invoice, parent, false)



        return MyViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = data[position]

        if (list.invoice_id != null) holder.payInvoice.text = list.invoice_id
        if (list.transaction_id != null) holder.payTransID.text = list.transaction_id
        if (list.date != null) holder.payDate.text = list.date
        if (list.payment_method != null) holder.payMode.text = list.payment_method

        if (list.payment_status != null) {

            if (list.payment_status.contains("Completed")) {
                holder.payStatus.text = list.payment_status
                holder.payView.visibility = View.VISIBLE
                holder.payDownload.visibility = View.VISIBLE
            } else {
                holder.payStatus.text = "PAY NOW"
                holder.payView.visibility = View.GONE
                holder.payDownload.visibility = View.GONE
            }
        }

        holder.payStatus.setOnClickListener {

            if (holder.payStatus.text.contains("PAYNOW")) {
                if (CommonUtil.checkNetwork(mmContext)) {

                    var userID = CommonUtil.getPreferencesString(mmContext, AppConstants.USER_ID)
                    var userProfessionID = CommonUtil.getPreferencesString(mmContext, AppConstants.PROFESSION)
                    CommonUtil.showDialog(mmContext)


                    val dataNotic = GbusinessService.create(mmContext)
                    if (userID != null && list.invoice_amount != null) {
                        var priced = list.invoice_amount.split("$")
                        Log.i("dffdfdfddfs", priced[1])
                        dataNotic.getBilling(
                            "Bearer " + CommonUtil.getPreferencesString(mmContext, AppConstants.TOKEN),
                            "application/json",
                            userID,
                            "android",
                            priced[1],
                            list.services,
                            "$",
                            "543",
                            userProfessionID!!
                        )
                            .enqueue(object : Callback<BillingDataClass> {
                                override fun onFailure(call: Call<BillingDataClass>, t: Throwable) {

                                    CommonUtil.hideDialog(mmContext)
                                    CommonUtil.toast(R.string.showError.toString(), mmContext)
                                    CommonUtil.logi(t.localizedMessage.toString())
                                }

                                override fun onResponse(
                                    call: Call<BillingDataClass>,
                                    response: Response<BillingDataClass>
                                ) {
                                    CommonUtil.hideDialog(mmContext)
                                    /* Log.i("dfdfgf userID",userID)
                                     Log.i("dfdfgf userID",domainName)
                                     Log.i("dfdfgf price",price)
                                     Log.i("dfdfgf services",services)
                                     Log.i("dfdfgf currency",currency)
                                     Log.i("dfdfgf cart_id",cart_id)
                                     Log.i("dfdfgf userProfessionID",userProfessionID)
         */

                                    // Log.i("TAGad", response.body()?.success.toString())
                                    val getdata = response.body()
                                    CommonUtil.logi(getdata.toString())

                                    if (getdata != null) {
                                        if (getdata.success) {
                                            // Log.i("dfdfgf",getdata.walletAmount.balance.toString())
                                            if (getdata.walletAmount.balance != null) {
                                                CommonUtil.saveStringPreferences(mmContext, AppConstants.Wbalance, getdata.walletAmount.balance.toString())

                                                PaymentFragment.invoic_id = getdata.invoice_id.toString()
                                                PaymentFragment.serviceName = getdata.invoice_slip.domain_name.toString()
                                                PaymentFragment.Description = getdata.invoice_slip.description.toString()
                                                PaymentFragment.minPrice = getdata.invoice_slip.price.toString()
                                                PaymentFragment.totalPrice = getdata.invoice_slip.total.toString()
                                                PaymentFragment.service = "Digital marketing services"


                                                CommonUtil.saveStringPreferences(mmContext, AppConstants.price, getdata.payAmount)

                                                Navigation.findNavController(mContext).navigate(R.id.action_paymentORInvoice2_to_paymentFragment)


                                            }
                                        } else CommonUtil.toast(getdata.message, mmContext)


                                    } else {
                                        CommonUtil.toast("SomeThing Went Wrong", mmContext)
                                    }
                                }

                            })
                    }

                } else {
                    CommonUtil.toast("Check Internet", mmContext)
                }


                /*  //  CommonUtil.saveStringPreferences(mContext, AppConstants.Wbalance,getdata.walletAmount.balance.toString())
                    PaymentFragment.invoic_id = list.invoice_id
                    PaymentFragment.serviceName = "service"
                    PaymentFragment.Description = "Description"
                    PaymentFragment.minPrice = list.invoice_amount
                    PaymentFragment.totalPrice = list.invoice_amount
                    PaymentFragment.service = "link"

                    Navigation.findNavController(mContext).navigate(R.id.action_paymentORInvoice2_to_paymentFragment)*/
            }
        }

        if (list.invoice_amount != null) holder.payAmount.text = list.invoice_amount

        if (list.view != null) holder.payView.setOnClickListener { listner.onClick("1", list.view.toString()) }
        // Log.i("download",list.download)
        if (list.download != null) holder.payDownload.setOnClickListener { listner.onClickDownload(list.download.toString()) }

    }

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val payInvoice = view.tvPaymentAndInvoiceID
        val payTransID = view.tvPaymentAndInvoiceTransID
        val payDate = view.tvPaymentAndInvoiceDate
        val payMode = view.tvPaymentAndInvoicePayMode

        val payStatus = view.tvPaymentAndInvoiceStatus
        val payAmount = view.tvPaymentAndInvoicePaymentAmount
        val payView = view.tvPaymentAndInvoiceView
        val payDownload = view.tvPaymentAndInvoiceDowmload
    }
}