package com.milkyway.gbusiness.fragments


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.speech.RecognizerIntent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.adaptor.DomainOrderAdapter
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.DomainOrderResponse
import com.milkyway.gbusiness.firebaseimpl.AutoLoginService
import com.milkyway.gbusiness.firebaseimpl.RazorpayResultReceiver
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.retrofit.AppConstants.SPEECH_REQUEST_CODE
import com.milkyway.gbusiness.utils.CommonUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DomainOrderFragment : Fragment(), DomainOrderAdapter.OnInvoiceViewClick,RazorpayResultReceiver.AppReceiver {

    private lateinit var domainAdapter: DomainOrderAdapter
    private var recyclerViewOrder: RecyclerView? = null
    private lateinit var mContext: Context
    private lateinit var myMyOrderBack: ImageView

    private lateinit var etSearch: AppCompatEditText
    private lateinit var noSearchResultsFoundText: TextView
    private lateinit var searchEditText: TextView
    private lateinit var clearQueryImageView: ImageView
    private lateinit var voiceSearchImageView: ImageView
    private lateinit var domainOrderDataList: List<DomainOrderResponse.Orders.Order>
    lateinit var resultReceiver: RazorpayResultReceiver


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_domain_order, container, false)
        initializeViews(view)

        return view
    }

    private fun initializeViews(view: View) {
        myMyOrderBack = view.findViewById(R.id.myMyOrderBack)
        myMyOrderBack.setOnClickListener { findNavController().navigate(R.id.action_myOrderFragment_to_mainFragment) }

        recyclerViewOrder = view.findViewById(R.id.recyclerViewOrder)

        etSearch = view.findViewById(R.id.search_edit_text)
        noSearchResultsFoundText = view.findViewById(R.id.no_search_results_found_text)
        clearQueryImageView = view.findViewById(R.id.clear_search_query)
        voiceSearchImageView = view.findViewById(R.id.voice_search_query)
        searchEditText = view.findViewById(R.id.search_edit_text)
        searchEditText.hint = "Search Domain Order"

        recyclerViewOrder!!.hasFixedSize()
        recyclerViewOrder!!.layoutManager = LinearLayoutManager(mContext)

        view.findViewById<TextView>(R.id.myOrderSubDomainList).setOnClickListener { view.findNavController().navigate(R.id.action_myOrderFragment_to_myOrderSubDomainList) }

        getDomainOrderListApi()

        etSearch.doOnTextChanged { text, _, _, _ ->
            /*val query = text.toString().toLowerCase(Locale.getDefault())
            filterWithQuery(query)
            toggleImageView(query)*/
        }

        voiceSearchImageView.setOnClickListener {
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                putExtra(
                    RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                    RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
                )
            }
            startActivityForResult(intent, SPEECH_REQUEST_CODE)
        }

        clearQueryImageView.setOnClickListener {
            etSearch.setText("")
            setDomainAdapter(domainOrderDataList)
        }
    }

    private fun toggleImageView(query: String) {
        if (query.isNotEmpty()) {
            clearQueryImageView.visibility = View.VISIBLE
            voiceSearchImageView.visibility = View.INVISIBLE
        } else if (query.isEmpty()) {
            clearQueryImageView.visibility = View.INVISIBLE
            voiceSearchImageView.visibility = View.VISIBLE
        }
    }

    private fun filterWithQuery(query: String) {
        if (query.isNotEmpty()) {
            val filteredList: List<DomainOrderResponse.Orders.Order> = onFilterChanged(query)
            //attachAdapter(filteredList)
            setDomainAdapter(filteredList)
            toggleRecyclerView(filteredList)
        } else if (query.isEmpty()) {
            //attachAdapter(sportsList)
            setDomainAdapter(domainOrderDataList)
        }
    }

    private fun toggleRecyclerView(filteredList: List<DomainOrderResponse.Orders.Order>) {
        if (filteredList.isEmpty()) {
            recyclerViewOrder?.visibility = View.INVISIBLE
            noSearchResultsFoundText.visibility = View.VISIBLE
        } else {
            recyclerViewOrder?.visibility = View.VISIBLE
            noSearchResultsFoundText.visibility = View.INVISIBLE
        }
    }

    private fun onFilterChanged(filterQuery: String): List<DomainOrderResponse.Orders.Order> {
        val filteredList = ArrayList<DomainOrderResponse.Orders.Order>()
        for (searchList in domainOrderDataList) {
            if (searchList.lineitems.lineitem[0].domain.lowercase().contains(filterQuery) ||
                searchList.paymentstatus.lowercase().contentEquals(filterQuery) ||
                searchList.id.toString().lowercase().contains(filterQuery) ||
                searchList.ordernum.toString().lowercase().contains(filterQuery) ||
                searchList.date.lowercase().contains(filterQuery)
            ) {
                filteredList.add(searchList)
            }
        }
        return filteredList
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val spokenText: String? =
                data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS).let { results ->
                    results?.get(0)
                }
            // Do something with spokenText
            etSearch.setText(spokenText)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun getDomainOrderListApi() {
        if (CommonUtil.checkNetwork(mContext)) {
            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            var whmcsClientID = CommonUtil.getPreferencesString(mContext, AppConstants.WHMCS_CLIENT_ID)
            CommonUtil.showDialog(mContext)
            val apiService = GbusinessService.create(mContext)
            if (userID != null) {
                apiService.getDomainOrderedList("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), userID, whmcsClientID!!
                ).enqueue(object : Callback<DomainOrderResponse> {
                    override fun onFailure(call: Call<DomainOrderResponse>, t: Throwable) {
                        CommonUtil.hideDialog(mContext)
                        CommonUtil.toast(R.string.showError.toString(), mContext)
                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(
                        call: Call<DomainOrderResponse>,
                        response: Response<DomainOrderResponse>,
                    ) {
                        CommonUtil.hideDialog(mContext)
                        val domainDataResponse = response.body()
                        Log.i("TAG", domainDataResponse.toString())

                        if (domainDataResponse != null) {
                            if (domainDataResponse.result.contentEquals("success")) {
                                if (domainDataResponse.totalresults > 0) {

                                    if (domainDataResponse.orders?.order != null && domainDataResponse.orders?.order.isNotEmpty()) {
                                        domainOrderDataList = domainDataResponse.orders.order
                                        setDomainAdapter(domainOrderDataList)
                                    }
                                } else {
                                    noSearchResultsFoundText.visibility = View.VISIBLE
                                    noSearchResultsFoundText.text = "Sorry!, No domain order found currently."
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

    private fun setDomainAdapter(dataList: List<DomainOrderResponse.Orders.Order>) {

        domainAdapter = DomainOrderAdapter(requireActivity(), dataList, this)
        recyclerViewOrder!!.adapter = domainAdapter
    }

    override fun onItemClicked(position: Int, invoiceId: Int) {
        val autoLoginService = Intent(mContext, AutoLoginService::class.java)
        resultReceiver = RazorpayResultReceiver(Handler(), this)
        autoLoginService.putExtra("autologin_receiver", resultReceiver)
        autoLoginService.putExtra("invoiceId", invoiceId)
        mContext.startService(autoLoginService)

        val url = "https://client.gbusiness.co/viewinvoice.php?id=$invoiceId"
        //val url = "https://www.gbusiness.co/domain/invoce/$invoiceId"

        /*if (url != null) {
            val bundle = Bundle()
            bundle.putString("back", "DomainOrderFragment")
            bundle.putString("webUrl", url)
            findNavController().navigate(R.id.action_myOrderFragment_to_paymentOrInvoiceWebView, bundle)
        } else {
            CommonUtil.toast("No View Found", mContext)
        }*/
    }

    override fun onReceiveResult(resultCode: Int, resultData: Bundle?) {
        if (resultReceiver != null) {
            if (resultData != null) {
                val url = resultData.getString("autoLoginUrl")
                val invoiceId = resultData.getInt("invoiceId")

                val bundle = Bundle()
                bundle.putString("back", "DomainOrderFragment")
                bundle.putString("webUrl", url)
                bundle.putInt("invoiceId", invoiceId)
                //Toast.makeText(requireActivity(), "AutoLogin Url:: $url", Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_myOrderFragment_to_paymentOrInvoiceWebView, bundle)
            }
        }
    }


}
