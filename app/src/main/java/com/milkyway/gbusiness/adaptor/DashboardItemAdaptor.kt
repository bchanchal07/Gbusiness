package com.milkyway.gbusiness.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.models.DashboardData
import kotlinx.android.synthetic.main.recyclerview_item_dashboard.view.*

class DashboardItemAdaptor(val mCtx: Context, var listner : OnDashboardAdaptorClick, private val dashList: List<DashboardData>) : RecyclerView.Adapter<DashboardItemAdaptor.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_dashboard, parent, false);
        return MyViewHolder(view);
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = dashList[position]
        // sets the image to the imageview from our itemHolder class
        holder.image.setImageResource(list.image)

        // sets the text to the textview from our itemHolder class
        holder.title.text = list.title
        holder.itemView.setOnClickListener {
                listner.OnItemClicked(position)

        }

    }

    override fun getItemCount() = dashList.size

    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val title = view.tvTitleDash!!
        val image = view.ivCategoryDash!!

    }

    interface OnDashboardAdaptorClick
    {
        fun OnItemClicked(position: Int)

    }


}




