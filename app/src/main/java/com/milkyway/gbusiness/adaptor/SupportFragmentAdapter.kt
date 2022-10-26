package com.milkyway.gbusiness.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.models.DataXXXXXXXXXXXXXXX
import kotlinx.android.synthetic.main.recyclerview_item_support.view.*

class SupportFragmentAdapter(val mContext: Context, val array: List<DataXXXXXXXXXXXXXXX>) : RecyclerView.Adapter<SupportFragmentAdapter.MyViewHolder>() {
    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val issueType = view.issueType!!
        val issueTicketID = view.issueTicketID!!
        val issueStatus = view.issueStatus!!
        val issueDate = view.issueDate!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_support, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount() = array.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = array[position]
        if (list.issue_type != null) holder.issueType.text = list.issue_type
        if (list.ticket_no != null) holder.issueTicketID.text = list.ticket_no
        if (list.domain_name != null) {
            if (list.domain_name.contentEquals("open")) {
                holder.issueStatus.background = mContext.resources.getDrawable(R.drawable.bg_left_corner_color_green)
            } else {
                holder.issueStatus.background = mContext.resources.getDrawable(R.drawable.bg_left_corner_color_red)
            }
            holder.issueStatus.text = list.domain_name
        }
        if (list.cdate != null) holder.issueDate.text = list.cdate

    }
}