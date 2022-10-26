package com.milkyway.gbusiness.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.models.DataXXXXXXXXX
import kotlinx.android.synthetic.main.recyclerview_item_withdraw_history.view.*

class WithDrawalHistoryAdapter(val data: List<DataXXXXXXXXX>) : RecyclerView.Adapter<WithDrawalHistoryAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_withdraw_history,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount()= data.size
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val list =  data.get(position)
        if(list.count!= null)  holder.tvWithDrowHistorySerialNo.setText(list.date)
        if(list.balance!= null)   holder.tvWithDrowHistoryBalAmount.setText("Withdraw Amount (\u20A8 - "+list.withdraw_inramount.toString()+")")
       // if(list.date!= null)   holder.tvWithDrowHistoryDate.setText("Date ("+list.withdraw_inramount.toString()+")")
        if(list.withdraw_amount!= null)   holder.tvWithDrowHistoryWithDrowAmount.setText("Withdraw Amount ($"+list.withdraw_amount.toString()+")")
        if(list.status!= null)    holder.tvWithDrowHistoryStatus.setText("Status ("+list.status+")")

    }

    class MyViewHolder(var view: View) :RecyclerView.ViewHolder(view)
    {
        val tvWithDrowHistorySerialNo = view.tvWithDrowHistorySerialNo
        val tvWithDrowHistoryBalAmount = view.tvWithDrowHistoryBalAmount
        val tvWithDrowHistoryDate = view.tvWithDrowHistoryDate
        val tvWithDrowHistoryWithDrowAmount = view.tvWithDrowHistoryWithDrowAmount
        val tvWithDrowHistoryStatus = view.tvWithDrowHistoryStatus

    }
}