package com.milkyway.gbusiness.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.adaptor.NotificationOnGbusniessAdaptor

import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.global.CommonUtil
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.DataXXXXXXXXXXXXXXXXXXXXX
import com.milkyway.gbusiness.models.NotificationDataClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NotificationOnGbusniess : Fragment() {

    lateinit var recyclerView : RecyclerView
    lateinit var adaptor: NotificationOnGbusniessAdaptor
    lateinit var mContext : Context
    lateinit var arrayList : ArrayList<DataXXXXXXXXXXXXXXXXXXXXX>

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext= context
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_notification_on_gbusniess, container, false)
        view.findViewById<ImageView>(R.id.myNotyBack).setOnClickListener {
            findNavController().navigate(R.id.action_notificationOnGbusniess_to_mainFragment)

        }
        arrayList = ArrayList()
        recyclerView = view.findViewById(R.id.notificationRecyclerView)
        recyclerView.hasFixedSize()
        recyclerView.layoutManager = LinearLayoutManager(mContext)

        getNotificationAPI()


        return view

    }

    private fun getNotificationAPI()
    {
        if (arrayList== null) arrayList = ArrayList()

        if (CommonUtil.checkNetwork(mContext))
        {
            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)
            val dataNotic = GbusinessService.create(mContext)
            if (userID != null) {
                dataNotic.getAllNotifaication("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), userID
                ).enqueue(object : Callback<NotificationDataClass>{
                    override fun onFailure(call: Call<NotificationDataClass>, t: Throwable)
                    {
                        CommonUtil.hideDialog(mContext)
                        CommonUtil.toast("SomeThing went wrong",mContext)
                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(
                        call: Call<NotificationDataClass>,
                        response: Response<NotificationDataClass>)
                    {
                        CommonUtil.hideDialog(mContext)
                        val getdata = response?.body()
                        CommonUtil.logi(getdata.toString())
                       // Log.i("TAGddad", getdata.toString())


                        if (getdata != null)
                        {
                            if (getdata.success)
                            {
                                if (getdata.data.size>0)
                                {
                                    arrayList= getdata.data!!

                                    adaptor = NotificationOnGbusniessAdaptor(arrayList,this@NotificationOnGbusniess)
                                    recyclerView.adapter = adaptor

                                } else CommonUtil.toast("Nothing to Show",mContext)

                            }
                            else CommonUtil.toast("There is no data",mContext)

                        }  else CommonUtil.toast("SomeThing went wrong",mContext)


                    }
                })
            }

        }
        else
        {
            CommonUtil.toast("Check Internet",mContext)
        }

    }


}
