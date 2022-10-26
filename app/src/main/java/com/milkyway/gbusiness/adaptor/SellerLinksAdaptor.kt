package com.milkyway.gbusiness.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.models.SellerLinkData
import kotlinx.android.synthetic.main.recyclerview_item_seller_links.view.*

class SellerLinksAdaptor(
    val mCtx: Context, var listner: SellerLinksAdaptorClick,
    private val dashList: List<SellerLinkData>,
) : RecyclerView.Adapter<SellerLinksAdaptor.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.step_1_business_list_items_adapter_layout, parent, false);
        return MyViewHolder(view);
    }

    override fun getItemCount() = dashList.size
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = dashList[position]
        holder.image.setImageResource(list.image)
        // sets the text to the textview from our itemHolder class
        holder.title.text = list.title
        holder.itemView.setOnClickListener {
            listner.onSellerLinkItemClicked(position,list)

        }

    }

    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val title = view.tvSellerTitle!!
        val image = view.ivSellerImage!!

    }

    interface SellerLinksAdaptorClick {
        fun onSellerLinkItemClicked(position: Int,list:SellerLinkData)

    }


}




