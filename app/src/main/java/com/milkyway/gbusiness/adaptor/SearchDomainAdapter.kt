package com.milkyway.gbusiness.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.models.SearchDomainDataDetailsClass
import kotlinx.android.synthetic.main.recyclerview_search_domain_list.view.*

class SearchDomainAdapter(private val mCtx: Context, private val list: List<SearchDomainDataDetailsClass.DomainList>, var listner: SearchDomainAdapter.OnDomainListAdaptorClick) : RecyclerView.Adapter<SearchDomainAdapter.SearchDomainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchDomainViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_search_domain_list, parent, false);

        return SearchDomainViewHolder(view);
    }

    override fun onBindViewHolder(holder: SearchDomainViewHolder, position: Int) {
        val list = list[position]

        // sets the text to the textview from our itemHolder class
        holder.domainName.text = list.domainName
        holder.domainPrice.text = "${mCtx.resources.getString(R.string.rs)} ${list.domainPrice}"
        holder.btnSearchDomainAddCart.setOnClickListener(View.OnClickListener {
            if (listner != null) {
                listner.onBtnClickedAddToCart(position, list, holder.btnSearchDomainAddCart)
            }
        })

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class SearchDomainViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val domainName = view.searchDomainName!!
        val domainPrice = view.searchDomainPrice!!
        val btnSearchDomainAddCart = view.btnSearchDomainAddCart!!

    }

    interface OnDomainListAdaptorClick {
        //fun onItemClicked(position: Int)
        fun onBtnClickedAddToCart(pos: Int, list: SearchDomainDataDetailsClass.DomainList, btnSearchDomainAddCart: AppCompatButton)
    }
}