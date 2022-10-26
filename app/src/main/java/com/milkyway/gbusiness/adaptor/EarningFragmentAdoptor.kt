package com.milkyway.gbusiness.adaptor

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.models.Totalearning
import kotlinx.android.synthetic.main.earning_adopter.view.*
import java.math.RoundingMode

class EarningFragmentAdoptor(
    var mContext: Context,
    val array: List<Totalearning>
) : RecyclerView.Adapter<EarningFragmentAdoptor.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.earning_adopter, parent, false);

        return MyViewHolder(view);
    }

    override fun getItemCount() = array.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = array[position]

        for (i in 1 until array.size) {
            if (position % 2 != 0) {
                holder.layoutEarning.setBackgroundColor(mContext.resources.getColor(R.color.greyLightLight))
            }
        }
        Log.i("pawan", "else")


        if (list.date != null) {
            val mDate = list.date
            var splits = mDate.split(" ")

            var dateOne = splits[0]
            var dateTwo = splits[1]
            // var dateThree = splits[2]
            holder.tvearningDate.text = "$dateOne\n$dateTwo"

        }

        if (list.earning_type != null) holder.tvearningType.text = list.earning_type
        //if (list.amount!=null) holder.tvEarningAmount.setText(list.amount.toString()!!)

        if (list.amount != null) {
            val number: Double = list.amount
            val rounded = number.toBigDecimal().setScale(3, RoundingMode.UP).toDouble()
            holder.tvEarningAmount.text = "$ $rounded" //"$ "+rounded.toString()

        }
        if (list.Referance_name != null) holder.tvEarningRefl.text = list.Referance_name


    }

    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val tvearningDate = view.earningDate!!
        val tvearningType = view.earningType!!
        val tvEarningAmount = view.earningAmount!!
        val tvEarningRefl = view.earningRef!!
        val layoutEarning = view.layoutEarningAdaptor!!

    }

}