package com.milkyway.gbusiness.fragments


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
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
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.adaptor.SubdomainListAdapter
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.DataXXXXXXXXXXXXXXXXXXX
import com.milkyway.gbusiness.models.DomainListDataClass
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.retrofit.AppConstants.SPEECH_REQUEST_CODE
import com.milkyway.gbusiness.utils.CommonUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class BookedSubdomainFragment : Fragment() {

    lateinit var myDomainBack: ImageView
    lateinit var recyclerView: RecyclerView
    lateinit var adaptor: SubdomainListAdapter
    lateinit var mContext: Context

    private lateinit var etSearch: AppCompatEditText
    private lateinit var noSearchResultsFoundText: TextView
    private lateinit var searchEditText: TextView
    private lateinit var clearQueryImageView: ImageView
    private lateinit var voiceSearchImageView: ImageView
    private lateinit var subdomainDataList: List<DataXXXXXXXXXXXXXXXXXXX>

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    //getSubDomainList
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_booked_sub_domain_list, container, false)
        initializeViews(view)
        return view
    }

    private fun initializeViews(view: View) {
        myDomainBack = view.findViewById(R.id.myDomainBack)
        myDomainBack.setOnClickListener { findNavController().navigate(R.id.action_myORderDomainList_to_myOrderFragment) }
        recyclerView = view.findViewById(R.id.recyclerViewOrderDomain)

        etSearch = view.findViewById(R.id.search_edit_text)
        noSearchResultsFoundText = view.findViewById(R.id.no_search_results_found_text)
        clearQueryImageView = view.findViewById(R.id.clear_search_query)
        voiceSearchImageView = view.findViewById(R.id.voice_search_query)
        searchEditText = view.findViewById(R.id.search_edit_text)
        searchEditText.hint = "Search Subdomain"

        recyclerView.hasFixedSize()
        recyclerView.layoutManager = LinearLayoutManager(mContext)
        getSubdomainListApi()

        etSearch.doOnTextChanged { text, _, _, _ ->
            val query = text.toString().toLowerCase(Locale.getDefault())
            filterWithQuery(query)
            toggleImageView(query)
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
            setSubdomainAdapter(subdomainDataList)
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
            val filteredList: List<DataXXXXXXXXXXXXXXXXXXX> = onFilterChanged(query)
            //attachAdapter(filteredList)
            setSubdomainAdapter(filteredList)
            toggleRecyclerView(filteredList)
        } else if (query.isEmpty()) {
            //attachAdapter(sportsList)
            setSubdomainAdapter(subdomainDataList)
        }
    }

    private fun toggleRecyclerView(filteredList: List<DataXXXXXXXXXXXXXXXXXXX>) {
        if (filteredList.isEmpty()) {
            recyclerView?.visibility = View.INVISIBLE
            noSearchResultsFoundText.visibility = View.VISIBLE
        } else {
            recyclerView?.visibility = View.VISIBLE
            noSearchResultsFoundText.visibility = View.INVISIBLE
        }
    }

    private fun onFilterChanged(filterQuery: String): List<DataXXXXXXXXXXXXXXXXXXX> {
        val filteredList = ArrayList<DataXXXXXXXXXXXXXXXXXXX>()
        for (searchList in subdomainDataList) {
            if (searchList.domain_name.lowercase().contains(filterQuery) ||
                searchList.created_at.lowercase().contains(filterQuery)
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

    private fun getSubdomainListApi() {
        if (CommonUtil.checkNetwork(mContext)) {
            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)
            val dataNotic = GbusinessService.create(mContext)
            if (userID != null) {
                dataNotic.subdomainList("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), userID
                ).enqueue(object : Callback<DomainListDataClass> {
                    override fun onFailure(call: Call<DomainListDataClass>, t: Throwable) {

                        CommonUtil.hideDialog(mContext)
                        CommonUtil.toast(R.string.showError.toString(), mContext)
                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(
                        call: Call<DomainListDataClass>,
                        response: Response<DomainListDataClass>,
                    ) {
                        CommonUtil.hideDialog(mContext)
                        val getdata = response?.body()
                        Log.i("TAGddad", getdata.toString())

                        if (getdata != null) {
                            if (getdata.success) {
                                if (getdata.data != null && getdata.data.isNotEmpty()) {
                                    subdomainDataList = getdata.data
                                    setSubdomainAdapter(subdomainDataList)
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

    private fun setSubdomainAdapter(subdomainDataList: List<DataXXXXXXXXXXXXXXXXXXX>) {
        adaptor = SubdomainListAdapter(mContext, subdomainDataList)
        recyclerView.adapter = adaptor
    }
}
