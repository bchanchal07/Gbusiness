package com.milkyway.gbusiness.fragments


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.adaptor.TrashLisFragmentAdaptor
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.api.OnClickServices
import com.milkyway.gbusiness.models.DataXXXXXXXXXXXXXXXXXX
import com.milkyway.gbusiness.models.TrashListDataClass
import com.milkyway.gbusiness.models.UpdatePhone
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.global.CommonUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TrashLisFragment : Fragment(), Callback<TrashListDataClass>, OnClickServices {
    override fun onFailure(call: Call<TrashListDataClass>, t: Throwable) {


        CommonUtil.hideDialog(mContext)
        CommonUtil.logi(t.localizedMessage.toString())


    }

    override fun onResponse(call: Call<TrashListDataClass>, response: Response<TrashListDataClass>) {

        CommonUtil.hideDialog(mContext)
        val getdata = response?.body()
        Log.i("TAGddad", getdata.toString())
        if (getdata != null) {
            if (getdata.success) {
                if (getdata.data != null && getdata.data.size > 0) {
                    arrayList = ArrayList()
                    arrayList = getdata.data
                    viewAdapter = TrashLisFragmentAdaptor(this, arrayList)
                    recyclerView?.adapter = viewAdapter
                }
            }
            if (getdata.message != null) CommonUtil.toast(getdata.message, mContext)
        } else CommonUtil.toast(R.string.showError.toString(), mContext)
    }

    override fun onClick(id: String, name: String) {
        // Log.i("dfd",name)
        if (name.equals("remove")) siteRemove(id)
        else siteReStore(id)

    }


    lateinit var viewAdapter: TrashLisFragmentAdaptor
    var recyclerView: RecyclerView? = null
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var myTrashBack: ImageView
    private lateinit var mContext: Context
    private var arrayList: ArrayList<DataXXXXXXXXXXXXXXXXXX>? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val view = inflater.inflate(R.layout.fragment_trash_lis, container, false)

        viewManager = LinearLayoutManager(mContext)
        myTrashBack = view.findViewById<ImageView>(R.id.myTrashBack)
        recyclerView = view.findViewById<RecyclerView>(R.id.trashRecyclrView)
        recyclerView?.hasFixedSize()
        recyclerView!!.layoutManager = LinearLayoutManager(mContext)

        myTrashBack.setOnClickListener { findNavController().navigate(R.id.action_trashLisFragment_to_mySiteFragment) }
        getTrashApi()

        return view
    }

    private fun getTrashApi() {

        if (CommonUtil.checkNetwork(mContext)) {
            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)
            val dataNotic = GbusinessService.create(mContext)
            if (userID != null) {
                dataNotic.getTrashList("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), userID).enqueue(this)
            }
            // startActivity(Intent(this,OtpActivity::class.java))
        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }


    private fun siteReStore(tempID: String) {

        if (CommonUtil.checkNetwork(mContext)) {

            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)

            //  Log.i("siteReStore", tempID)

            val dataNotic = GbusinessService.create(mContext)
            if (userID != null) {
                dataNotic.reStoreProjectFromTrast(
                    "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),
                    tempID
                ).enqueue(object : Callback<UpdatePhone> {
                        override fun onFailure(
                            call: Call<UpdatePhone>,
                            t: Throwable,
                        ) {
                            CommonUtil.hideDialog(mContext)


                            CommonUtil.logi(t.localizedMessage.toString())
                        }

                        override fun onResponse(
                            call: Call<UpdatePhone>,
                            response: Response<UpdatePhone>,
                        ) {
                            CommonUtil.hideDialog(mContext)

                            // Log.i("siteReStore", response.body().toString())
                            val getdata = response.body()
                            CommonUtil.logi(getdata.toString())

                            if (getdata != null) {
                                if (getdata.success) {

                                    //todo to refresh the trashList fragment
                                    findNavController().navigate(R.id.action_trashLisFragment_to_mySiteFragment)
                                    Log.i(" siteReStore", getdata.data)
                                }
                                if (getdata.data != null) CommonUtil.toast(getdata.data, mContext)

                            } else CommonUtil.toast(R.string.showError.toString(), mContext)
                        }
                    })
            }
        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }

    private fun siteRemove(tempID: String) {
        if (CommonUtil.checkNetwork(mContext)) {

            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)
            //   Log.i("siteRemove", tempID)

            val dataNotic = GbusinessService.create(mContext)
            if (userID != null) {
                dataNotic.removeProjectFromTrast(
                    "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),
                    tempID
                ).enqueue(object : Callback<UpdatePhone> {
                    override fun onFailure(
                        call: Call<UpdatePhone>,
                        t: Throwable,
                    ) {
                        CommonUtil.hideDialog(mContext)
                        CommonUtil.toast(R.string.showError.toString(), mContext)


                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(
                        call: Call<UpdatePhone>,
                        response: Response<UpdatePhone>,
                    ) {
                        CommonUtil.hideDialog(mContext)

                        Log.i("siteRemove", response.body().toString())
                        val getdata = response.body()
                        CommonUtil.logi(getdata.toString())

                        if (getdata != null) {
                            if (getdata.success) {

                                //todo to refresh the trashList fragment
                                findNavController().navigate(R.id.action_trashLisFragment_to_mySiteFragment)
                                Log.i(" siteRemove", getdata.data)
                            }
                            if (getdata.data != null) CommonUtil.toast(getdata.data, mContext)

                        } else CommonUtil.toast(R.string.showError.toString(), mContext)
                    }
                })
            }
            // startActivity(Intent(this,OtpActivity::class.java))
        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }
}
