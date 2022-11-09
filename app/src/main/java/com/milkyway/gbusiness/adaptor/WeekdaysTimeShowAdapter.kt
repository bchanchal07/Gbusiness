package com.milkyway.gbusiness.adaptor

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.global.CommonUtil

class WeekdaysTimeShowAdapter(private val mContext: Context, private val itemList: List<String>, private var flag: String): RecyclerView.Adapter<WeekdaysTimeShowAdapter.ViewHolder>() {

    var timingList = arrayOf("12:00 AM", "12:30 AM", "1:00 AM", "1:30 AM", "2:00 AM", "2:30 AM", "3:00 AM", "3:30 AM", "4:00 AM", "4:30 AM",
        "5:00 AM", "5:30 AM", "6:00 AM", "6:30 AM", "7:00 AM", "7:30 AM", "8:00 AM", "8:30 AM", "9:00 AM", "9:30 AM", "10:00 AM", "10:30 AM", "11:00 AM", "11:30 AM",
        "12:00 PM", "12:30 PM", "1:00 PM", "1:30 PM", "2:00 PM", "2:30 PM", "3:00 PM", "3:30 PM", "4:00 PM", "4:30 PM",
    "5:00 PM", "5:30 PM", "6:00 PM", "6:30 PM", "7:00 PM", "7:30 PM", "8:00 PM", "8:30 PM", "9:00 PM", "9:30 PM", "10:00 PM", "10:30 PM", "11:00 PM", "11:30 PM")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.business_workinghours_start_and_end_time_layout, parent, false)
        return WeekdaysTimeShowAdapter.ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.tv_startTime.text = item

        //todo text clear....
        if (flag.contentEquals("clear_text")){
            holder.ac_start_time.setText("")
            CommonUtil.setSunStartTime(mContext, "")
            CommonUtil.setMonStartTime(mContext, "")
            CommonUtil.setTueStartTime(mContext, "")
            CommonUtil.setWedStartTime(mContext, "")
            CommonUtil.setThurStartTime(mContext, "")
            CommonUtil.setFriStartTime(mContext, "")
            CommonUtil.setSatStartTime(mContext, "")
        }
        //todo Creating the instance of ArrayAdapter containing list of fruit names
        var startTimeAdapter: ArrayAdapter<String> = ArrayAdapter<String>(mContext, R.layout.drop_down_list, timingList)
        holder.ac_start_time.threshold = 1;
        holder.ac_start_time.setAdapter(startTimeAdapter)
        holder.ac_start_time.setTextColor(Color.BLACK)

        holder.ac_start_time.setOnItemClickListener(object : AdapterView.OnItemClickListener{
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (CommonUtil.getSunday(mContext) == "Sunday"){
                    CommonUtil.setSunStartTime(mContext, timingList[position])
                    Toast.makeText(mContext, CommonUtil.getSunStartTime(mContext),Toast.LENGTH_SHORT).show()
                }
                if (CommonUtil.getMonday(mContext) == "Monday"){
                    CommonUtil.setMonStartTime(mContext, timingList[position])
                    Toast.makeText(mContext, CommonUtil.getMonStartTime(mContext),Toast.LENGTH_SHORT).show()
                }
                if (CommonUtil.getTuesday(mContext) == "Tuesday"){
                    CommonUtil.setTueStartTime(mContext, timingList[position])
                    Toast.makeText(mContext, CommonUtil.getTueStartTime(mContext),Toast.LENGTH_SHORT).show()
                }
                if (CommonUtil.getWednesday(mContext) == "Wednesday"){
                    CommonUtil.setWedStartTime(mContext, timingList[position])
                    Toast.makeText(mContext, CommonUtil.getWedStartTime(mContext),Toast.LENGTH_SHORT).show()
                }
                if (CommonUtil.getThursday(mContext) == "Thursday"){
                    CommonUtil.setThurStartTime(mContext, timingList[position])
                    Toast.makeText(mContext, CommonUtil.getThurStartTime(mContext),Toast.LENGTH_SHORT).show()
                }
                if (CommonUtil.getFriday(mContext) == "Friday"){
                    CommonUtil.setFriStartTime(mContext, timingList[position])
                    Toast.makeText(mContext, CommonUtil.getFriStartTime(mContext),Toast.LENGTH_SHORT).show()
                }
                if (CommonUtil.getSaturday(mContext) == "Saturday"){
                    CommonUtil.setSatStartTime(mContext, timingList[position])
                    Toast.makeText(mContext, CommonUtil.getSatStartTime(mContext),Toast.LENGTH_SHORT).show()
                }
            }
        })

        //todo text clear....
        if (flag.contentEquals("clear_text")){
            holder.ac_end_time.setText("")
            CommonUtil.setSunEndTime(mContext, "")
            CommonUtil.setMonEndTime(mContext, "")
            CommonUtil.setTueEndTime(mContext, "")
            CommonUtil.setWedEndTime(mContext, "")
            CommonUtil.setThurEndTime(mContext, "")
            CommonUtil.setFriEndTime(mContext, "")
            CommonUtil.setSatEndTime(mContext, "")
        }
        var endTimeAdapter: ArrayAdapter<String> = ArrayAdapter<String>(mContext, R.layout.drop_down_list, timingList)
        holder.ac_end_time.threshold = 1;
        holder.ac_end_time.setAdapter(endTimeAdapter)
        holder.ac_end_time.setTextColor(Color.BLACK)

        holder.ac_end_time.setOnItemClickListener(object : AdapterView.OnItemClickListener{
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (CommonUtil.getSunday(mContext) == "Sunday"){
                    CommonUtil.setSunEndTime(mContext, timingList[position])
                    Toast.makeText(mContext, CommonUtil.getSunEndTime(mContext),Toast.LENGTH_SHORT).show()
                }
                if (CommonUtil.getMonday(mContext) == "Monday"){
                    CommonUtil.setMonEndTime(mContext, timingList[position])
                    Toast.makeText(mContext, CommonUtil.getMonEndTime(mContext),Toast.LENGTH_SHORT).show()
                }
                if (CommonUtil.getTuesday(mContext) == "Tuesday"){
                    CommonUtil.setTueEndTime(mContext, timingList[position])
                    Toast.makeText(mContext, CommonUtil.getTueEndTime(mContext),Toast.LENGTH_SHORT).show()
                }
                if (CommonUtil.getWednesday(mContext) == "Wednesday"){
                    CommonUtil.setWedEndTime(mContext, timingList[position])
                    Toast.makeText(mContext, CommonUtil.getWedEndTime(mContext),Toast.LENGTH_SHORT).show()
                }
                if (CommonUtil.getThursday(mContext) == "Thursday"){
                    CommonUtil.setThurEndTime(mContext, timingList[position])
                    Toast.makeText(mContext, CommonUtil.getThurEndTime(mContext),Toast.LENGTH_SHORT).show()
                }
                if (CommonUtil.getFriday(mContext) == "Friday"){
                    CommonUtil.setFriEndTime(mContext, timingList[position])
                    Toast.makeText(mContext, CommonUtil.getFriEndTime(mContext),Toast.LENGTH_SHORT).show()
                }
                if (CommonUtil.getSaturday(mContext) == "Saturday"){
                    CommonUtil.setSatEndTime(mContext, timingList[position])
                    Toast.makeText(mContext, CommonUtil.getSatEndTime(mContext),Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tv_startTime = itemView.findViewById<TextView>(R.id.tv_startTime)
        var ac_start_time = itemView.findViewById<AutoCompleteTextView>(R.id.ac_start_time)
        var ac_end_time = itemView.findViewById<AutoCompleteTextView>(R.id.ac_end_time)

    }
}