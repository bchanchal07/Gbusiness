package com.milkyway.gbusiness.fragments


import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.api.OnClickServices
import com.milkyway.gbusiness.models.PaymentINvoiceDataClass
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.utils.CommonUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PaymentORInvoice : Fragment(), OnClickServices {

    lateinit var Adopter: PaymentORInvoiceAdoptor
    var recyclerViewEarning: RecyclerView? = null
    lateinit var mContext: Context
    private lateinit var myPaymentInvoiceBack: ImageView
    private lateinit var root: View

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        root = inflater.inflate(R.layout.fragment_payment_orinvoice, container, false)

        myPaymentInvoiceBack = root.findViewById(R.id.myPaymentInvoiceBack)
        myPaymentInvoiceBack.setOnClickListener { findNavController().navigate(R.id.action_paymentORInvoice2_to_mainFragment) }

        recyclerViewEarning = root.findViewById(R.id.recyclerViewpaymentOrInvoice)
        recyclerViewEarning!!.hasFixedSize()
        recyclerViewEarning!!.layoutManager = LinearLayoutManager(mContext)

        getPaymentOrInvoiceApi()
        return root
    }

    private fun getPaymentOrInvoiceApi() {
        if (CommonUtil.checkNetwork(mContext)) {
            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)
            val dataNotic = GbusinessService.create(mContext)
            if (userID != null) {
                dataNotic.getPaymentAndInvoice("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), userID
                ).enqueue(object : Callback<PaymentINvoiceDataClass> {
                    override fun onFailure(call: Call<PaymentINvoiceDataClass>, t: Throwable) {

                        CommonUtil.hideDialog(mContext)
                        CommonUtil.toast(R.string.showError.toString(), mContext)
                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(
                        call: Call<PaymentINvoiceDataClass>,
                        response: Response<PaymentINvoiceDataClass>,
                    ) {
                        CommonUtil.hideDialog(mContext)
                        val getdata = response?.body()
                        CommonUtil.logi(getdata.toString())
                        //   Log.i("TAGddad", getdata.toString())

                        if (getdata != null) {
                            if (getdata.success) {
                                if (getdata.data != null && getdata.data.size > 0) {
                                    Adopter = PaymentORInvoiceAdoptor(this@PaymentORInvoice, getdata.data, root, mContext)
                                    recyclerViewEarning!!.adapter = Adopter
                                }
                            }
                            if (getdata.message != null) CommonUtil.toast(getdata.message, mContext)

                        } else CommonUtil.toast(R.string.showError.toString(), mContext)
                    }
                })
            }
        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }


    override fun onClick(id: String, name: String) {
        if (name != null) {
            val bundle = Bundle()
            bundle.putString("back", "PaymentOrInvoice")
            bundle.putString("webUrl", name)
            findNavController().navigate(R.id.action_paymentORInvoice2_to_paymentOrInvoiceWebView, bundle)
        } else {
            CommonUtil.toast("No View Found", mContext)
        }

    }

    override fun onClickDownload(webUrl: String) {

        if (webUrl != null) {
            userDownload(webUrl, "Invoice")
        } else {
            CommonUtil.toast("Not Found", mContext)
        }

    }

    private fun userDownload(link: String, tittle: String) {
        //     Log.i("TAGTAGs", "dddddddddd: =$link")

        val request = DownloadManager.Request(Uri.parse(link))
        request.setDescription("G Business")
        request.setTitle(tittle)
        // in order for this if to run, you must use the android 3.2 to compile your app
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            request.allowScanningByMediaScanner()
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        }
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "$tittle.pdf")

        // get download service and enqueue file
        val manager = requireActivity().getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        manager.enqueue(request)
    }


}
