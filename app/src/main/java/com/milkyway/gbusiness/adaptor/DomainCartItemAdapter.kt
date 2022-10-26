package com.milkyway.gbusiness.adaptor

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.models.SearchDomainDataDetailsClass
import kotlinx.android.synthetic.main.recyclerview_added_item_cart.view.*

class DomainCartItemAdapter(private val mCtx: Context, private val list: ArrayList<SearchDomainDataDetailsClass.DomainList>, var listner: OnDomainListAdaptorClick) : RecyclerView.Adapter<DomainCartItemAdapter.SearchDomainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchDomainViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_added_item_cart, parent, false);
        return SearchDomainViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: SearchDomainViewHolder, position: Int) {
        val list = list[position]

        // sets the text to the textview from our itemHolder class
        holder.tvSearchedDomainName.text = list.domainName
        holder.tvSearchDomainPrice.text = "${mCtx.resources.getString(R.string.rs)} ${list.domainPrice}"
        holder.tvRemoveCardItem.setOnClickListener(View.OnClickListener {
            if (listner != null) {
                listner.onBtnClickedRemoveFromCart(position, list)
            }
        })

        holder.tvCheckOutCartItem.setOnClickListener(View.OnClickListener {
            if (listner != null) {
                listner.onBtnClickedCheckoutCart(position, list)
            }
        })
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class SearchDomainViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val tvSearchedDomainName = view.tvSearchedDomainName!!
        val tvSearchDomainPrice = view.tvSearchDomainPrice!!
        val tvRemoveCardItem = view.tvRemoveCardItem!!
        val tvCheckOutCartItem = view.tvCheckOutCartItem!!

    }

    interface OnDomainListAdaptorClick {
        //fun onItemClicked(position: Int)
        fun onBtnClickedRemoveFromCart(pos: Int, list: SearchDomainDataDetailsClass.DomainList)
        fun onBtnClickedCheckoutCart(pos: Int, list: SearchDomainDataDetailsClass.DomainList)
    }
}