package com.milkyway.gbusiness.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.global.CommonUtil
import java.util.ArrayList

class WeekdaysNameAdapter(private val mContext: Context, private val daysNameList: List<String>): RecyclerView.Adapter<WeekdaysNameAdapter.ViewHolder>() {

    private val itemList = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.business_working_weekdays_name, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = daysNameList[position]
        holder.tv_weekends_name.text = item

        prepareItems()
        bindAdapter(holder,mContext, "set_text")

        holder.switch_btn.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                holder.tv_open.visibility = View.VISIBLE
                holder.tv_close.visibility = View.GONE
                holder.rv_start_and_end_time.visibility = View.VISIBLE
                if(holder.tv_weekends_name.text == "Sunday"){
                    CommonUtil.setSunday(mContext,holder.tv_weekends_name.text.toString())
                    Toast.makeText(mContext, CommonUtil.getSunday(mContext), Toast.LENGTH_SHORT).show()
                }
                if (holder.tv_weekends_name.text == "Monday"){
                    CommonUtil.setMonday(mContext,holder.tv_weekends_name.text.toString())
                    Toast.makeText(mContext, CommonUtil.getMonday(mContext), Toast.LENGTH_SHORT).show()
                }
                if (holder.tv_weekends_name.text == "Tuesday"){
                    CommonUtil.setTuesday(mContext,holder.tv_weekends_name.text.toString())
                    Toast.makeText(mContext, CommonUtil.getTuesday(mContext), Toast.LENGTH_SHORT).show()
                }
                if (holder.tv_weekends_name.text == "Wednesday"){
                    CommonUtil.setWednesday(mContext,holder.tv_weekends_name.text.toString())
                    Toast.makeText(mContext, CommonUtil.getWednesday(mContext), Toast.LENGTH_SHORT).show()
                }
                if (holder.tv_weekends_name.text == "Thursday"){
                    CommonUtil.setThursday(mContext,holder.tv_weekends_name.text.toString())
                    Toast.makeText(mContext, CommonUtil.getThursday(mContext), Toast.LENGTH_SHORT).show()
                }
                if (holder.tv_weekends_name.text == "Friday"){
                    CommonUtil.setFriday(mContext,holder.tv_weekends_name.text.toString())
                    Toast.makeText(mContext, CommonUtil.getFriday(mContext), Toast.LENGTH_SHORT).show()
                }
                if (holder.tv_weekends_name.text == "Saturday"){
                    CommonUtil.setSaturday(mContext,holder.tv_weekends_name.text.toString())
                    Toast.makeText(mContext, CommonUtil.getSaturday(mContext), Toast.LENGTH_SHORT).show()
                }

            }
            else{
                holder.tv_close.visibility = View.VISIBLE
                holder.tv_open.visibility = View.GONE
                holder.rv_start_and_end_time.visibility = View.GONE
                CommonUtil.setSunday(mContext,"")
                CommonUtil.setMonday(mContext,"")
                CommonUtil.setTuesday(mContext,"")
                CommonUtil.setWednesday(mContext,"")
                CommonUtil.setThursday(mContext,"")
                CommonUtil.setFriday(mContext,"")
                CommonUtil.setSaturday(mContext, "")
                bindAdapter(holder,mContext, "clear_text")
            }
        }

    }

    override fun getItemCount(): Int {
        return daysNameList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tv_weekends_name = itemView.findViewById<TextView>(R.id.tv_weekends_name)
        var switch_btn = itemView.findViewById<Switch>(R.id.switch_btn)
        var tv_close = itemView.findViewById<TextView>(R.id.tv_close)
        var tv_open = itemView.findViewById<TextView>(R.id.tv_open)
        var rv_start_and_end_time = itemView.findViewById<RecyclerView>(R.id.rv_start_and_end_time)
    }

    fun bindAdapter(holder: ViewHolder, mContext: Context, flag: String) {
        var linearLayoutManager: LinearLayoutManager = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        var weekdaysTimeShowAdapter: WeekdaysTimeShowAdapter = WeekdaysTimeShowAdapter(mContext, itemList, flag)
        holder.rv_start_and_end_time.layoutManager = linearLayoutManager
        holder.rv_start_and_end_time.adapter = weekdaysTimeShowAdapter
    }

    //todo list items add....
    private fun prepareItems() {
        itemList.add("Start Time")
    }


}