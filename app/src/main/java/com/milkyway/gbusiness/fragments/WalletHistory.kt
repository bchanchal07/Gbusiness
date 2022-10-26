package com.milkyway.gbusiness.fragments


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.adaptor.showWalletHistoryAdapter
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.utils.CommonUtil
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.WalletHistoryDataClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WalletHistory : Fragment() {

    lateinit var mContext: Context
    lateinit var Walletdopter: showWalletHistoryAdapter
    var recyclerViewWalletHostory: RecyclerView? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_wallet_history, container, false)

        val backButoon = view.findViewById<ImageView>(R.id.myWalletHistoryBack)
        backButoon.setOnClickListener {

            findNavController().navigate(R.id.action_walletHistory_to_earningFragment)

        }
        showWalletHistory(view)

        return view

    }

    private fun showWalletHistory(view: View) {
        if (CommonUtil.checkNetwork(mContext)) {
            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)
            val dataNotic = GbusinessService.create(mContext)
            if (userID != null) {
                dataNotic.getWallethistory("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), userID)
                    .enqueue(object : Callback<WalletHistoryDataClass> {
                        override fun onFailure(call: Call<WalletHistoryDataClass>, t: Throwable) {
                            CommonUtil.hideDialog(mContext)
                            CommonUtil.toast(R.string.showError.toString(), mContext)
                            CommonUtil.logi(t.localizedMessage.toString())
                        }

                        override fun onResponse(
                            call: Call<WalletHistoryDataClass>,
                            response: Response<WalletHistoryDataClass>
                        ) {

                            CommonUtil.hideDialog(mContext)
                            val getdata = response?.body()

                            // Log.i("TAGddad", getdata.toString())

                            if (getdata != null) {
                                if (getdata.success) {
                                    if (getdata.data.size > 0) {
                                        recyclerViewWalletHostory = view!!.findViewById(R.id.myWalletRecycler)
                                        recyclerViewWalletHostory!!.hasFixedSize()
                                        recyclerViewWalletHostory!!.layoutManager = LinearLayoutManager(mContext)
                                        Walletdopter = showWalletHistoryAdapter(getdata.data)
                                        recyclerViewWalletHostory!!.adapter = Walletdopter
                                    }
                                }
                            } else CommonUtil.toast(R.string.showError.toString(), mContext)
                        }
                    })
            }

        } else {
            CommonUtil.toast("Check Internet", mContext)
        }


    }


}
