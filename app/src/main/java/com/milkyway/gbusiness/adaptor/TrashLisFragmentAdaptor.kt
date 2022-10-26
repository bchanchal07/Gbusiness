package com.milkyway.gbusiness.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.api.OnClickServices
import com.milkyway.gbusiness.models.DataXXXXXXXXXXXXXXXXXX
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.trash_adapter.view.*


class TrashLisFragmentAdaptor(
    val listener: OnClickServices,
    val arrayList: ArrayList<DataXXXXXXXXXXXXXXXXXX>?
) : RecyclerView.Adapter<TrashLisFragmentAdaptor.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.trash_adapter,parent,false);

        return TrashLisFragmentAdaptor.MyViewHolder(view);
    }

    override fun getItemCount() = arrayList!!.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int)
    {
        val list = arrayList?.get(position)
        
        Picasso.get().load(list?.thumbnail).placeholder(R.mipmap.my_site).into(holder.trashAdpImage)
        if (list?.id!=null) holder.trashRemove.setOnClickListener { listener.onClick(list?.id.toString(),"remove") }
        if (list?.id!=null) holder.trashRestore.setOnClickListener { listener.onClick(list?.id.toString(),"restore") }


        holder.trashTittle.setText(list?.title)
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val trashAdpImage = view.trashAdpImage
        val trashRemove = view.trashRemove
        val trashRestore = view.trashRestore
        val trashTittle = view.trashTittle
        val trashSubTittle = view.trashSubTittle

    }
}