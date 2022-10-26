package com.milkyway.gbusiness.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.api.RecyclerviewCallbacks
import com.milkyway.gbusiness.models.DataXXXXX
import kotlinx.android.synthetic.main.alert_profession_item.view.*

class UserProfessionAdapter(
   val professionList: ArrayList<DataXXXXX>
): RecyclerView.Adapter<UserProfessionAdapter.MyViewHolder>() {


    private var selectedItem: Int = -1
    var callback: RecyclerviewCallbacks<DataXXXXX>? = null



    fun selectedItem(position: Int){
        selectedItem = position
        notifyItemChanged(position)
    }

    override fun onBindViewHolder(holder: MyViewHolder, p1: Int) {
        val item = professionList.get(p1)
        holder.profession_name.text = item.profession_name



    }

    fun setOnClick(click: RecyclerviewCallbacks<DataXXXXX>)
    {
        callback = click
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.alert_profession_item,p0,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return professionList.size
    }

    inner class MyViewHolder(item: View) : RecyclerView.ViewHolder(item) {


        var profession_layout =item.profession_layout
        var profession_name =item.profession_name
        init {
            setClickListener(profession_layout)
        }

        private fun setClickListener(view: View) {
            view.setOnClickListener {
                callback?.onItemClick(it, adapterPosition, professionList[adapterPosition])
            }
        }
    }

}