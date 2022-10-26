package com.milkyway.gbusiness.fragments


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.adaptor.WithDrawalHistoryAdapter

import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.utils.CommonUtil
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.WithDrawHistoryDataClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WithDrawalHistory : Fragment() {

      lateinit var viewAdapter : WithDrawalHistoryAdapter
      var recyclerView : RecyclerView? = null
      private lateinit var viewManager: RecyclerView.LayoutManager
      private lateinit var mContext : Context
    private lateinit var myWithdrawalHistoryBack : ImageView


    //val array : ArrayList<DataXXXXXXXXX>()

    override fun onAttach(context: Context)
      {
          super.onAttach(context)
          mContext = context
      }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_with_drawal_history, container, false)


        viewManager = LinearLayoutManager(mContext)

        recyclerView = view.findViewById<RecyclerView>(R.id.withDrawHistoryRecyclerView)
        recyclerView?.hasFixedSize()
        recyclerView!!.layoutManager = LinearLayoutManager(mContext)

        myWithdrawalHistoryBack = view.findViewById<ImageView>(R.id.myWithdrawalHistoryBack)
        myWithdrawalHistoryBack.setOnClickListener	 { findNavController().navigate(R.id.action_withDrawalHistory_to_mainFragment) }

      /*  viewAdapter = WithDrawalHistoryAdapter()
        recyclerView?.adapter=viewAdapter*/

        getWithDrawHistory()
        return view
    }

    private fun getWithDrawHistory()
    {
        if (CommonUtil.checkNetwork(mContext))
        {
            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)
            val dataNotic = GbusinessService.create(mContext)
            if (userID != null) {
                dataNotic.getWithdrawalhistory("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), userID
                ).enqueue(object : Callback<WithDrawHistoryDataClass> {
                    override fun onFailure(call: Call<WithDrawHistoryDataClass>, t: Throwable) {

                        CommonUtil.hideDialog(mContext)
                        CommonUtil.toast(R.string.showError.toString(),mContext)
                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(
                        call: Call<WithDrawHistoryDataClass>,
                        response: Response<WithDrawHistoryDataClass>
                    ) {
                        CommonUtil.hideDialog(mContext)
                        val getdata = response?.body()
                         CommonUtil.logi(getdata.toString())
                        //Log.i("TAGddad", getdata.toString())

                        if (getdata != null) {
                            if (getdata.success)
                            {
                                if (getdata.data!=null && getdata.data.size>0)
                                {
                                    Log.i("TAGddad","its ok baby")

                                    viewAdapter = WithDrawalHistoryAdapter(getdata.data)
                                    recyclerView?.adapter=viewAdapter

                                }
                            }
                            if(getdata.message!=null)  CommonUtil.toast(getdata.message,mContext)

                        } else CommonUtil.toast("SomeThing went Wrong",mContext)
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
