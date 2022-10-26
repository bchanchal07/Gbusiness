package com.milkyway.gbusiness.adaptor

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.models.BusinessHrsDataClass
import kotlinx.android.synthetic.main.recyclerview_item_business_hrs.view.*

class BusinessHrsAdaptor(
    private val mCtx: Context,
    private val bHrsList: List<BusinessHrsDataClass.HrsData>,
) : RecyclerView.Adapter<BusinessHrsAdaptor.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_business_hrs, parent, false);

        return MyViewHolder(view);
    }

    override fun getItemCount() = bHrsList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = bHrsList[position]
        //setAnimation(holder.itemView, position)
        // sets the text to the textview from our itemHolder class
        if (position % 2 == 0)
            holder.layoutBHrs.setBackgroundResource(R.drawable.bg_bhrs)
        /*else
            holder.layoutBHrs.setBackgroundResource(R.drawable.bg_bhrs)*/

        if (list.days.contentEquals("null")) {
            when (position) {
                0 -> holder.tvBusinessDays.text = "Monday"
                1 -> holder.tvBusinessDays.text = "Tuesday"
                2 -> holder.tvBusinessDays.text = "Wednesday"
                3 -> holder.tvBusinessDays.text = "Thirsday"
                4 -> holder.tvBusinessDays.text = "Friday"
                5 -> holder.tvBusinessDays.text = "Saturday"
                6 -> holder.tvBusinessDays.text = "Sunday"
            }
        }else
            holder.tvBusinessDays.text = list.days
        if (list.startTime.contentEquals("null") || list.endTime.contentEquals("null")) {
            holder.tvBusinessHrs.text = "Closed"
        } else
            holder.tvBusinessHrs.text = "${list.startTime} - ${list.endTime}"

    }

    private fun setAnimation(view: View, position: Int) {
        val animation: Animation = if (position % 2 == 0) {
            AnimationUtils.loadAnimation(mCtx, R.anim.enter_from_left)
        } else {
            AnimationUtils.loadAnimation(mCtx, R.anim.enter_from_right)
        }

        view.animation = animation
    }

    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val tvBusinessDays = view.tvBusinessDays!!
        val tvBusinessHrs = view.tvBusinessHrs!!
        val layoutBHrs = view.layoutBHrs!!

    }
}




