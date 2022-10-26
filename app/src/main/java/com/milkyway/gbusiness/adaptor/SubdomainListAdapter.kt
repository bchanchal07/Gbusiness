package com.milkyway.gbusiness.adaptor

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.models.DataXXXXXXXXXXXXXXXXXXX
import com.milkyway.gbusiness.utils.DateTimeUtils
import kotlinx.android.synthetic.main.recyclerview_item_subdomain.view.*

class SubdomainListAdapter(
    val mContext: Context,
    private val subdomainList: List<DataXXXXXXXXXXXXXXXXXXX>,
) : RecyclerView.Adapter<SubdomainListAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_subdomain, parent, false)

        return MyViewHolder(view)

    }

    override fun getItemCount() = subdomainList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val subdomainData = subdomainList[position]
        holder.tvSrNo.text = (position + 1).toString()
        holder.tvSubdomainName.text = subdomainData.domain_name
        holder.tvSubdomainStatus.text = subdomainData.status
        val dateFormatStr = DateTimeUtils.formatDateFromDateString(
            DateTimeUtils.DATE_FORMAT_12,
            DateTimeUtils.DATE_FORMAT_8,
            subdomainData.created_at
        )
        holder.tvSubdomainBookingDate.text = dateFormatStr

    }

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val tvSrNo: TextView = view.tvSrNo
        val tvSubdomainName: TextView = view.tvSubdomainName
        val tvSubdomainStatus: TextView = view.tvSubdomainStatus
        val tvSubdomainBookingDate: TextView = view.tvSubdomainBookingDate

    }
}