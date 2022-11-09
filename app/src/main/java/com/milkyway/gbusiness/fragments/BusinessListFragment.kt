package com.milkyway.gbusiness.fragments

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.activities.MainActivity
import com.milkyway.gbusiness.adaptor.BusinessListAdaptor
import com.milkyway.gbusiness.adaptor.BusinessUserAddListAdapter
import com.milkyway.gbusiness.models.BusinessListingResponse
import com.milkyway.gbusiness.models.DeleteBusinessListResponse
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.retrofit.AppConstants.SPEECH_REQUEST_CODE
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.global.CommonUtil
import id.ionbit.ionalert.IonAlert
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [BusinessListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BusinessListFragment : Fragment(), BusinessUserAddListAdapter.BtnClickListener {
    lateinit var mContext: Context
    private lateinit var rvBusinessList: RecyclerView
    private lateinit var myBusinessListBack: ImageView
    private lateinit var btnAddNewList: AppCompatButton
    private var listingDataList: List<BusinessListingResponse.Data> = ArrayList()
    private lateinit var businessListAdapter: BusinessListAdaptor

    private lateinit var etSearch: AppCompatEditText
    private lateinit var noSearchResultsFoundText: TextView
    private lateinit var clearQueryImageView: ImageView
    private lateinit var voiceSearchImageView: ImageView
    private lateinit var scrollView: ScrollView
    private var expendableList: ExpandableListView? = null

//    var dialog: Dialog = Dialog(mContext)
    //todo skjnvksdnvk

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = BusinessListFragment().apply {}
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_business_list, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView(view)
        clickListener(view)
    }

    private fun clickListener(view: View) {
        myBusinessListBack.setOnClickListener {
            MainActivity.navController.navigate(R.id.action_myBusinessListFragment_to_mainFragment)
//            dialog.hide()
        }

        btnAddNewList.setOnClickListener {
            MainActivity.navController.navigate(R.id.action_myBusinessListFragment_to_createBusinessListFragment)
        }

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
//            setListingDataAdapter(listingDataList)
            bindExpandableListAdapter(listingDataList)
        }
    }

    private fun initializeView(view: View) {
        rvBusinessList = view.findViewById(R.id.rvBusinessList)
        myBusinessListBack = view.findViewById(R.id.myBusinessListBack)
        btnAddNewList = view.findViewById(R.id.btnAddNewList)
        scrollView = view.findViewById(R.id.scrollView)
        expendableList = view.findViewById(R.id.expendableList)

        etSearch = view.findViewById(R.id.search_edit_text)
        noSearchResultsFoundText = view.findViewById(R.id.no_search_results_found_text)
        clearQueryImageView = view.findViewById(R.id.clear_search_query)
        voiceSearchImageView = view.findViewById(R.id.voice_search_query)
        etSearch.hint = "Search Here...."

        callBusinessListingApi()
    }

    //todo call business lists...
    private fun callBusinessListingApi() {
        if (CommonUtil.checkNetwork(mContext)) {
            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)
            val apiServices = GbusinessService.create(mContext)
            if (userID != null) {
                apiServices.getBusinessListData("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), userID
                ).enqueue(object : Callback<BusinessListingResponse> {
                    @SuppressLint("SetTextI18n")
                    override fun onResponse(
                        call: Call<BusinessListingResponse>,
                        response: Response<BusinessListingResponse>,
                    ) {
                        CommonUtil.hideDialog(mContext)
                        val getDataList = response.body()!!
                        Log.i("TAG", getDataList.toString())

                        if (getDataList != null) {
                            if (response.code() == 200) {
                                var businessListingResponse: List<BusinessListingResponse> = listOf(getDataList)
                                listingDataList = getDataList.data
                                if (listingDataList.isNotEmpty() && getDataList.success) {
//                                        setListingDataAdapter(listingDataList)
                                    bindExpandableListAdapter(listingDataList)

                                    //todo changed visibility..
                                    scrollView.visibility = View.INVISIBLE
                                    noSearchResultsFoundText.visibility = View.INVISIBLE
                                } else if (!getDataList.success) {
                                    scrollView.visibility = View.INVISIBLE

                                    noSearchResultsFoundText.text = "Sorry! No business listing found."
                                    noSearchResultsFoundText.visibility = View.VISIBLE
                                }
                            }
                        } else CommonUtil.toast(R.string.showError.toString(), mContext)
                    }

                    override fun onFailure(call: Call<BusinessListingResponse>, t: Throwable) {
                        CommonUtil.hideDialog(mContext)
                        CommonUtil.toast(R.string.showError.toString(), mContext)
                        CommonUtil.logi(t.localizedMessage.toString())
                    }
                })
            }
        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }

    private fun setListingDataAdapter(listingDataList: List<BusinessListingResponse.Data>) {
        rvBusinessList.layoutManager = LinearLayoutManager(context)
        businessListAdapter = BusinessListAdaptor(mContext, listingDataList)
        rvBusinessList.adapter = businessListAdapter
    }

    //todo bind expendable list...
    private fun bindExpandableListAdapter(listingDataList: List<BusinessListingResponse.Data>) {
        var businessUserListAdapter = BusinessUserAddListAdapter(mContext, listingDataList, this)
        expendableList?.setAdapter(businessUserListAdapter)
    }

    //todo action onClick listener...
    override fun onBtnClick(position: Int, list: BusinessListingResponse.Data) {
        val inflater = requireActivity().layoutInflater
        val PopupView: View = inflater.inflate(R.layout.show_bottom_action_layout, null)
        var dialog = Dialog(requireActivity(), R.style.CustomDialogManualQty)
        val window = dialog.window
        val layoutParams = window!!.attributes
        layoutParams.gravity = Gravity.BOTTOM
        window!!.attributes = layoutParams
        window!!.attributes.windowAnimations = R.style.bottome_dialog_animation
        dialog.setContentView(PopupView)
        window!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.setCancelable(true)
        dialog.show()
        dialog.setCancelable(true)

        var update_linear_layout = PopupView.findViewById<LinearLayout>(R.id.update_linear_layout)
        var delete_linear_layout = PopupView.findViewById<LinearLayout>(R.id.delete_linear_layout)
        var step_1_linear_layout = PopupView.findViewById<LinearLayout>(R.id.step_1_linear_layout)
        var step_2_linear_layout = PopupView.findViewById<LinearLayout>(R.id.step_2_linear_layout)

        update_linear_layout.setOnClickListener {
            IonAlert(requireActivity(), IonAlert.WARNING_TYPE)
                .setTitleText("Are you sure?")
                .setContentText("You want to update business list!")
                .setCancelText("No,cancel plz!")
                .setConfirmText("Yes,update it!")
                .showCancelButton(true)
                .setCancelClickListener {
                    it.cancel()
                }
                .setConfirmClickListener {
                    it.dismissWithAnimation()
                    val bundle = Bundle()
                    bundle.putSerializable("list",  list)
                    findNavController().navigate(R.id.action_myBusinessListFragment_to_editBusinessListFragment, bundle)
                }.show()
            dialog.hide()
        }

        delete_linear_layout.setOnClickListener {
            IonAlert(requireActivity(), IonAlert.WARNING_TYPE)
                .setTitleText("Are you sure?")
                .setContentText("Won't be able to recover this file!")
                .setCancelText("No,cancel plz!")
                .setConfirmText("Yes,delete it!")
                .showCancelButton(true)
                .setCancelClickListener {
                    it.cancel()
                }
                .setConfirmClickListener {
                    it.dismissWithAnimation()
                    callDeleteBusinessListItemApi(list)
                }
                .show()
            dialog.hide()
        }

        step_1_linear_layout.setOnClickListener {
            MainActivity.navController.navigate(R.id.action_myBusinessListFragment_to_stepOneBusinessListFragment)
            CommonUtil.saveIntPreferences(mContext, AppConstants.BUSINESS_ID, list.id)
            dialog.hide()
        }

        step_2_linear_layout.setOnClickListener {
            MainActivity.navController.navigate(R.id.action_myBusinessListFragment_to_step_2_BusinessListFragment)
            CommonUtil.saveIntPreferences(mContext, AppConstants.BUSINESS_ID, list.id)
            dialog.hide()
        }


    }

    //todo call delete business list item...
    private fun callDeleteBusinessListItemApi(list: BusinessListingResponse.Data) {
        if (CommonUtil.checkNetwork(mContext)) {
            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)
            val apiServices = GbusinessService.create(mContext)
            if (userID != null) {
                apiServices.deleteBusinessListItem("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), list.id
                ).enqueue(object : Callback<DeleteBusinessListResponse> {
                    override fun onResponse(
                        call: Call<DeleteBusinessListResponse>,
                        response: Response<DeleteBusinessListResponse>,
                    ) {
                        CommonUtil.hideDialog(mContext)
                        val getData = response?.body()
                        Log.i("TAG", getData.toString())

                        if (getData != null) {
                            if (getData.success) {
                                callBusinessListingApi()
                                val ionAlert = IonAlert(requireActivity(), IonAlert.SUCCESS_TYPE)
                                ionAlert.titleText = "Delete Success!"
                                ionAlert.contentText = getData.message
                                ionAlert.show()
                            }
                        } else CommonUtil.toast(R.string.showError.toString(), mContext)
                    }

                    override fun onFailure(call: Call<DeleteBusinessListResponse>, t: Throwable) {
                        CommonUtil.hideDialog(mContext)
                        CommonUtil.toast(R.string.showError.toString(), mContext)
                        CommonUtil.logi(t.localizedMessage.toString())
                    }
                })
            }
        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }

    //todo filter for search bar...
    private fun filterWithQuery(query: String) {
        if (query.isNotEmpty()) {
            val filteredList: List<BusinessListingResponse.Data> = onFilterChanged(query)
            bindExpandableListAdapter(filteredList)
            toggleRecyclerView(filteredList)
        } else if (query.isEmpty()) {
            //attachAdapter(sportsList)
            bindExpandableListAdapter(listingDataList)
//            setListingDataAdapter(listingDataList)
        }
    }

    //todo activity start for voice speaker search bar..
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val spokenText: String? = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS).let { results ->
                results?.get(0)
            }
            // Do something with spokenText
            etSearch.setText(spokenText)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun toggleRecyclerView(catList: List<BusinessListingResponse.Data>) {
        if (catList.isEmpty()) {
            rvBusinessList.visibility = View.INVISIBLE
            scrollView.visibility = View.INVISIBLE
            noSearchResultsFoundText.visibility = View.VISIBLE
        } else {
            rvBusinessList.visibility = View.VISIBLE
            scrollView.visibility = View.VISIBLE
            noSearchResultsFoundText.visibility = View.INVISIBLE
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

    private fun onFilterChanged(filterQuery: String): List<BusinessListingResponse.Data> {
        val filteredList = ArrayList<BusinessListingResponse.Data>()
        for (searchList in listingDataList) {
            if (searchList.business_name.lowercase().contains(filterQuery) ||
                searchList.catname.lowercase().contains(filterQuery) ||
                searchList.subcatname.lowercase().contains(filterQuery)
            ) {
                filteredList.add(searchList)
            }
        }
        return filteredList
    }


}