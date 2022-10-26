package com.milkyway.gbusiness.adaptor

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.models.DataXXXXXXXXXXXXXXXXXXXXXXXXXXXX
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recyclerview_item_direct.view.*

class MyDirectsPeoplesAdptor(
    val data: List<DataXXXXXXXXXXXXXXXXXXXXXXXXXXXX>,
    val mContext: Context
) : RecyclerView.Adapter<MyDirectsPeoplesAdptor.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_direct, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount() = data.size


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val itm = data.get(position)

        if (itm.referral_id != null) holder.directDateJoin.setText(itm.referral_id)
        if (itm.fullname != null) holder.directName.setText(itm.fullname)
        if (itm.amount != null) holder.directMyEarning.setText("$ " + itm.amount)

        if (itm.total_earning != null) holder.directTotalPurchas.setText("$ " + itm.total_earning)
        if (itm.action != null) {


            if (itm.action.equals("unpaid")) {
                holder.directStatus.setText(itm.action)
                holder.directStatus.setTextColor(Color.RED)
                holder.directStatus.setBackgroundTintList(ColorStateList.valueOf(mContext.resources.getColor(R.color.white)))
            } else {
                holder.directStatus.setText(itm.action)
                holder.directStatus.setTextColor(Color.GREEN)
                holder.directStatus.setBackgroundTintList(ColorStateList.valueOf(mContext.resources.getColor(R.color.white)))

            }
        }
        if (itm.avatar != null) Picasso.get().load(itm.avatar).placeholder(R.mipmap.user).into(holder.directPhoto)


        //  if (itm.services!=null) holder.directStatus.setText(itm.action)

        if (itm.services.isNotEmpty()) {
            holder.directServices.text = "Name : ${itm.services[0].name} \nPrice : ${itm.services[0].price} \nPayment Method : ${itm.services[0].payment_method} Created At : ${itm.services[0].created_at}"

            // Log.i("djfkjdk",dfd.toString())
        }
        // if (itm.services.size>0) holder.directService.setText(itm.services.get(position).toString())


    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val directPhoto = view.directPhoto
        val directName = view.directName
        val directMyEarning = view.directMyEarning
        val directTotalPurchas = view.directTotalPurchas
        val directStatus = view.directStatus
        val directDateJoin = view.directDateJoin
        val directServices = view.directServices

    }
}