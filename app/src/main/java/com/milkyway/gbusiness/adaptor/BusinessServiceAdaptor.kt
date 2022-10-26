package com.milkyway.gbusiness.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.models.BusinessServiceModelClass
import kotlinx.android.synthetic.main.recyclerview_item_business_service_list.view.*

class BusinessServiceAdaptor(
    private val mCtx: Context, var listner: OnBusinessServiceAdaptorClick,
    private val bServiceList: List<BusinessServiceModelClass.Data>,
) : RecyclerView.Adapter<BusinessServiceAdaptor.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_business_service_list, parent, false);

        return MyViewHolder(view);
    }

    override fun getItemCount() = bServiceList.size
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = bServiceList[position]
        // sets the text to the textview from our itemHolder class
        holder.serviceName.text = list.name
        holder.itemView.setOnClickListener {
            listner.onItemClicked(position, list)
        }
    }

    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val serviceName = view.tvBServices!!

    }

    interface OnBusinessServiceAdaptorClick {
        fun onItemClicked(position: Int, data: BusinessServiceModelClass.Data)

    }


}




