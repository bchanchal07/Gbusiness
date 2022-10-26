package com.milkyway.gbusiness.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.api.OnClickServices
import com.milkyway.gbusiness.models.DataXXXXXXXXXXXXXXXXXXXXXXXXXXX
import kotlinx.android.synthetic.main.domain_mysite_adapter.view.*

class DomainListAdaptot(
    val listener: OnClickServices,
    val arrayDomin: List<DataXXXXXXXXXXXXXXXXXXXXXXXXXXX>,
    var tampleteID: String,
) : RecyclerView.Adapter<DomainListAdaptot.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.domain_mysite_adapter, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount() = arrayDomin.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = arrayDomin[position]

        if (list.name != null) holder.siteDomainName.text = list.name
        if (list.id != null) holder.btnSelectSiteDomain.setOnClickListener { listener.nowPublishWebSite(tampleteID, list.id.toString()) }
    }

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val siteDomainName: TextView = view.siteDomainName
        val btnSelectSiteDomain: Button = view.siteDomainSelect
    }
}