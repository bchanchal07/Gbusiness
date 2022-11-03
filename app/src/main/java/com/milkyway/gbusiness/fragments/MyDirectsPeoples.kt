package com.milkyway.gbusiness.fragments


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.adaptor.MyDirectsPeoplesAdptor
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.global.CommonUtil
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.MyDirectResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * getMyDirect()
 */
class MyDirectsPeoples : Fragment() {

    lateinit var recycle: RecyclerView
    lateinit var mContext: Context
    lateinit var mAdoptor: MyDirectsPeoplesAdptor
    lateinit var directProgBar: ProgressBar

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_my_directs_peoples, container, false)
        directProgBar = view.findViewById(R.id.directProgBar)
        directProgBar.setVisibility(View.VISIBLE)
        //  mContext = container!!.context
        view.findViewById<ImageView>(R.id.myDirectBack).setOnClickListener {
            view.findNavController().navigate(R.id.action_myDirectsPeoples_to_earningFragment)
        }
        recycle = view.findViewById<RecyclerView>(R.id.myDirectsRecyclerView)
        recycle.hasFixedSize()
        recycle.layoutManager = LinearLayoutManager(mContext)

        loadDirect()
        return view
    }

    private fun loadDirect() {
        if (CommonUtil.checkNetwork(mContext)) {
            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)

            //CommonUtil.showDialog(mContext)


            val dataNotic = GbusinessService.create(mContext)
            if (userID != null) {
                dataNotic.getMyDirect("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),
                    "application/json", userID)
                    .enqueue(object : Callback<MyDirectResponse> {
                        override fun onFailure(call: Call<MyDirectResponse>, t: Throwable) {
                            directProgBar.setVisibility(View.GONE)

                            CommonUtil.toast(R.string.showError.toString(), mContext)
                            CommonUtil.logi(t.localizedMessage.toString())
                        }

                        override fun onResponse(
                            call: Call<MyDirectResponse>,
                            response: Response<MyDirectResponse>
                        ) {

                            directProgBar.setVisibility(View.GONE)


                            //   Log.i("manu", response.body().toString())
                            val getdata = response.body()
                            CommonUtil.logi(getdata.toString())


                            if (getdata != null) {
                                if (getdata.success) {
                                    if (getdata.data.size > 0) {
                                        mAdoptor = MyDirectsPeoplesAdptor(getdata.data, mContext)
                                        recycle.adapter = mAdoptor

                                    } else CommonUtil.toast("no entry found", mContext)


                                }


                            } else CommonUtil.toast("no entry found", mContext)
                        }

                    })
            }
            // startActivity(Intent(this,OtpActivity::class.java))
        } else {
            CommonUtil.toast("Check Internet", mContext)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (directProgBar != null) directProgBar.setVisibility(View.GONE)

    }
}
