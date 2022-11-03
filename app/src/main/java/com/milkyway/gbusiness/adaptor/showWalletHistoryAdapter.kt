package com.milkyway.gbusiness.adaptor

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.global.CommonUtil
import com.milkyway.gbusiness.models.DataXXXXXXXXXXXXXXXXXXXX
import kotlinx.android.synthetic.main.recyclerview_item_wallet_history.view.*

class showWalletHistoryAdapter(val data: List<DataXXXXXXXXXXXXXXXXXXXX>) : RecyclerView.Adapter<showWalletHistoryAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_wallet_history, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount() = data.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = data[position]

        holder.walletDate.text = list.datetime
        holder.walletBal.text = "$ " + CommonUtil.decimslToStringUPtoFourDigit(list.remaining_balance)
        if (list.debit != null)
            holder.walletDr.text = "Dr.  $" + CommonUtil.decimslToStringUPtoFourDigit(list.debit)
        else
            holder.walletDr.text = "Dr.  $0.0000"
        holder.walletDesc.text = list.description
        holder.walletCr.text = "Cr.  $ " + CommonUtil.decimslToStringUPtoFourDigit(list.credit)
    }

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val walletDate: TextView = view.tvWalletDate
        val walletBal: TextView = view.tvWalletBal
        val walletDr: TextView = view.tvWalletDr
        val walletDesc: TextView = view.tvWalletDesc
        val walletCr: TextView = view.tvWalletCr

    }
}