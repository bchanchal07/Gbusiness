package com.milkyway.gbusiness.adaptor

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.models.DomainOrderResponse
import com.milkyway.gbusiness.utils.DateTimeUtils

class DomainOrderAdapter(
    private val context: Context,
    private val domainOrderList: List<DomainOrderResponse.Orders.Order>, var listner: OnInvoiceViewClick,
) : RecyclerView.Adapter<DomainOrderAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item_domain, parent, false);

        return MyViewHolder(view);
    }

    override fun getItemCount() = domainOrderList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = domainOrderList[position]
        holder.tvDomainName.text = data.lineitems.lineitem[0].domain
        holder.tvOrderID.text = data.id.toString()
        holder.tvMobileNo.text = data.ordernum.toString()
        holder.tvOrderAmount.text = data.lineitems.lineitem[0].amount
        holder.tvPaymentStatus.text = data.paymentstatus
        //try {
            val dateFormatStr = DateTimeUtils.formatDateFromDateString(
                DateTimeUtils.DATE_FORMAT_33,
                DateTimeUtils.DATE_FORMAT_8,
                data.date
            )
            holder.tvOrderDateTime.text = dateFormatStr
        /*} catch (e: Exception) {
            e.printStackTrace()
        }*/

        holder.tvInvoiceView.setOnClickListener {
            listner.onItemClicked(position, data.invoiceid)
        }
        if (data.paymentstatus.contentEquals("Paid"))
            holder.tvPaymentStatus.setTextColor(Color.GREEN)
        else
            holder.tvPaymentStatus.setTextColor(Color.RED)
    }

    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val tvDomainName: TextView = view.findViewById(R.id.tvDomainName)
        val tvOrderID: TextView = view.findViewById(R.id.tvOrderID)
        val tvOrderDateTime: TextView = view.findViewById(R.id.tvOrderDateTime)
        val tvMobileNo: TextView = view.findViewById(R.id.tvMobileNo)
        val tvPaymentStatus: TextView = view.findViewById(R.id.tvPaymentStatus)
        val tvOrderAmount: TextView = view.findViewById(R.id.tvOrderAmount)
        val tvInvoiceView: TextView = view.findViewById(R.id.tvInvoiceView)
    }

    interface OnInvoiceViewClick {
        fun onItemClicked(position: Int, invoiceId: Int)
    }

}