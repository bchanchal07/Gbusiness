package com.milkyway.gbusiness.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.api.OnAdpterClick
import com.milkyway.gbusiness.models.DataXXXXXX
import kotlinx.android.synthetic.main.recyclerview_item_cart.view.*

class MyCartFramentAdaptor(var listner : OnAdpterClick, var array: List<DataXXXXXX>) : RecyclerView.Adapter<MyCartFramentAdaptor.MyViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item_cart,parent,false);

        return MyViewHolder(view);
    }

    override fun getItemCount() = array.size
    override fun onBindViewHolder(holder: MyCartFramentAdaptor.MyViewHolder, position: Int)
    {
        val list =array.get(position)

        holder.tvDoainName.text=list.name
        holder.tv_domainPrice.setText("$ "+list.price)
        holder.closeBtn.setOnClickListener { listner.OnClick(list.cart_id.toString()) }
        holder.btnBuyNow.setOnClickListener { listner.onClickBtn(list.cart_id.toString(),list.price,list.name,list.services ,list.currency) }

    }

    class MyViewHolder(var view : View) : RecyclerView.ViewHolder(view)
    {

        val closeBtn =view.closeBtn
        val tvDoainName =view.tvDoainName
        val tv_domainPrice =view.tv_domainPrice
        val btnBuyNow =view.btnBuyNow

    }
}