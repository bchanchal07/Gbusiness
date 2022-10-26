package com.milkyway.gbusiness.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.fragments.NotificationOnGbusniess
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.models.DataXXXXXXXXXXXXXXXXXXXXX
import kotlinx.android.synthetic.main.noty_adaptor.view.*

class NotificationOnGbusniessAdaptor
    (
   val arrayList: ArrayList<DataXXXXXXXXXXXXXXXXXXXXX>,
   val listner: NotificationOnGbusniess
) : RecyclerView.Adapter<NotificationOnGbusniessAdaptor.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder
    {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.noty_adaptor,parent,false)


        return MyViewHolder(view)

    }

    override fun getItemCount() = arrayList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int)
    {

        if (arrayList.get(position).type!=null) holder.noty_type.setText(arrayList.get(position).type)
        if (arrayList.get(position).notif_message!=null)holder.noty_message.setText(arrayList.get(position).notif_message)

    }

    class MyViewHolder(val view : View) :RecyclerView.ViewHolder(view)
    {
        val noty_type = view.noty_type
        val noty_message = view.noty_message

    }
}