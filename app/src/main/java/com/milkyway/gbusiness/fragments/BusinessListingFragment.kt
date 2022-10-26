package com.milkyway.gbusiness.fragments

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.speech.RecognizerIntent
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.leo.searchablespinner.SearchableSpinner
import com.leo.searchablespinner.interfaces.OnItemSelectListener
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.activities.MainActivity
import com.milkyway.gbusiness.adaptor.BusinessListingAdaptor
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.*
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.utils.CommonUtil
import id.ionbit.ionalert.IonAlert
import kotlinx.android.synthetic.main.dlg_error_msg.view.*
import kotlinx.android.synthetic.main.dlg_get_quote.view.*
import kotlinx.android.synthetic.main.fragment_business_cat_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [BusinessListingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BusinessListingFragment : Fragment(), BusinessListingAdaptor.OnBListingAdaptorClick {

    lateinit var mContext: Context
    lateinit var businessListingResponse: BusinessDirectoryDataClass
    private lateinit var businessList: List<BusinessDirectoryDataClass.Data>
    private lateinit var rvBusinessListing: RecyclerView
    private lateinit var myBusinessListingBack: ImageView
    private lateinit var btnSelectCategory: AppCompatButton
    private lateinit var etSearch: AppCompatEditText
    private lateinit var noSearchResultsFoundText: TextView
    private lateinit var clearQueryImageView: ImageView
    private lateinit var voiceSearchImageView: ImageView
    var categoryList: List<CategoryDataClass.Data>? = null
    var selectedCategoryId: Int = 0
    var selectedCategorySlug: String = ""
    private lateinit var name: String
    private lateinit var email: String
    private lateinit var phone: String
    private lateinit var query: String
    private lateinit var mView: View
    private lateinit var mViewError: View

    private lateinit var searchableSpinnerCategory: SearchableSpinner

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_business_listing, container, false)
        initializeView(view)
        clickListener(view)
        return view
    }

    private fun initializeView(view: View) {
        rvBusinessListing = view.findViewById(R.id.rvBusinessListing)
        btnSelectCategory = view.findViewById(R.id.btnSelectCategory)
        myBusinessListingBack = view.findViewById(R.id.myBusinessListingBack)
        etSearch = view.findViewById(R.id.search_edit_text)
        noSearchResultsFoundText = view.findViewById(R.id.no_search_results_found_text)
        clearQueryImageView = view.findViewById(R.id.clear_search_query)
        voiceSearchImageView = view.findViewById(R.id.voice_search_query)
        searchableSpinnerCategory = SearchableSpinner(requireActivity())
        searchableSpinnerCategory.windowTitle = "Select/Search Category"
        etSearch.hint = "Search Business List"
        callCategoryApi()
        getBusinessListingApi()
    }

    private fun getBusinessListingApi() {
        if (CommonUtil.checkNetwork(mContext)) {
            CommonUtil.showDialog(mContext)
            val apiServices = GbusinessService.create(mContext)
            //if (userID != null) {
            apiServices.getAllBusinessListing(
            ).enqueue(object : Callback<BusinessDirectoryDataClass> {
                override fun onResponse(call: Call<BusinessDirectoryDataClass>, response: Response<BusinessDirectoryDataClass>) {
                    CommonUtil.hideDialog(mContext)

                    businessListingResponse = response.body()!!
                    when (response.code()) {
                        200 -> {
                            if (businessListingResponse.data != null) {
                                //if (businessListingResponse.data.isNotEmpty()) {
                                businessList = businessListingResponse.data

                                setBusinessListingAdaptor(businessList)

                                /*} else {
                                    Toast.makeText(requireActivity(), "Data is not available", Toast.LENGTH_SHORT).show()
                                }*/

                            }
                        }
                        400 -> {
                            /*IonAlert(requireActivity(), IonAlert.WARNING_TYPE)
                                .setTitleText("Not Found!")
                                .setContentText("Data not found in this category")
                                .setConfirmText("Ok")
                                .setConfirmClickListener {
                                    MainActivity.navController.navigate(R.id.action_myCatDetailsFragment_to_mySubCategoryFragment)
                                    it.dismissWithAnimation()
                                }
                                .show()*/

                        }
                    }
                }

                override fun onFailure(call: Call<BusinessDirectoryDataClass>, t: Throwable) {
                    CommonUtil.hideDialog(mContext)
                    CommonUtil.toast(R.string.showError.toString(), mContext)
                    CommonUtil.logi(t.localizedMessage.toString())
                }

            })
            //}

        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }

    private fun setBusinessListingAdaptor(businessList: List<BusinessDirectoryDataClass.Data>) {
        val businessUpdatedList = ArrayList<BusinessDirectoryDataClass.Data>()
        /*for (i in businessList.indices) {
            if (businessList[i].status == 0) {
                businessUpdatedList.add(BusinessDirectoryDataClass.Data(
                    businessList[i].address,
                    businessList[i].businessAboutUs,
                    businessList[i].businessEmail,
                    businessList[i].businessLogo,
                    businessList[i].businessName,
                    businessList[i].businessPhone,
                    businessList[i].businessServices,
                    businessList[i].businessType,
                    businessList[i].businessWebUrl,
                    businessList[i].categoryId,
                    businessList[i].city,
                    businessList[i].countryId,
                    businessList[i].createdAt,
                    businessList[i].establishDate,
                    businessList[i].facebookUrl,
                    businessList[i].friday,
                    businessList[i].fridayEndTime,
                    businessList[i].fridayStartTime,
                    businessList[i].galleryImage,
                    businessList[i].id,
                    businessList[i].instagramUrl,
                    businessList[i].linkedinUrl,
                    businessList[i].monday,
                    businessList[i].mondayEndTime,
                    businessList[i].mondayStartTime,
                    businessList[i].name,
                    businessList[i].saturday,
                    businessList[i].saturdayEndTime,
                    businessList[i].saturdayStartTime,
                    businessList[i].sellerUrl,
                    businessList[i].sponsor,
                    businessList[i].stateId,
                    businessList[i].status,
                    businessList[i].subCategoryId,
                    businessList[i].subDomain,
                    businessList[i].sunday,
                    businessList[i].sundayEndTime,
                    businessList[i].sundayStartTime,
                    businessList[i].thirsday,
                    businessList[i].thirsdayEndTime,
                    businessList[i].thirsdayStartTime,
                    businessList[i].tuesday,
                    businessList[i].tuesdayEndTime,
                    businessList[i].tuesdayStartTime,
                    businessList[i].twitterUrl,
                    businessList[i].updatedAt,
                    businessList[i].urlSlug,
                    businessList[i].userId,
                    businessList[i].wednesday,
                    businessList[i].wednesdayEndTime,
                    businessList[i].wednesdayStartTime,
                    businessList[i].zipCode))
            }
        }*/
        rvBusinessListing.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val adapter = BusinessListingAdaptor(requireActivity(), this, businessList)
        rvBusinessListing.adapter = adapter

    }

    private fun filterWithQuery(query: String) {
        if (query.isNotEmpty()) {
            val filteredList: List<BusinessDirectoryDataClass.Data> = onFilterChanged(query)
            //attachAdapter(filteredList)
            setBusinessListingAdaptor(filteredList)
            toggleRecyclerView(filteredList)
        } else if (query.isEmpty()) {
            //attachAdapter(sportsList)
            setBusinessListingAdaptor(businessList)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == AppConstants.SPEECH_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val spokenText: String? =
                data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS).let { results ->
                    results?.get(0)
                }
            // Do something with spokenText
            etSearch.setText(spokenText)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun toggleRecyclerView(catList: List<BusinessDirectoryDataClass.Data>) {
        if (catList.isEmpty()) {
            rvBusinessListing.visibility = View.INVISIBLE
            noSearchResultsFoundText.visibility = View.VISIBLE
        } else {
            rvBusinessListing.visibility = View.VISIBLE
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

    private fun onFilterChanged(filterQuery: String): List<BusinessDirectoryDataClass.Data> {
        val filteredList = java.util.ArrayList<BusinessDirectoryDataClass.Data>()
        for (searchList in businessList) {
            if (searchList.businessName.lowercase().contains(filterQuery) ||
                searchList.address.lowercase().contains(filterQuery)
            ) {
                filteredList.add(searchList)
            }
        }
        return filteredList
    }

    private fun clickListener(view: View?) {
        myBusinessListingBack.setOnClickListener {
            MainActivity.navController.navigate(R.id.action_myBusinessListingFragment_to_mainFragment)
        }
        btnSelectCategory.setOnClickListener {
            searchableSpinnerCategory.show()
        }

        searchableSpinnerCategory.onItemSelectListener = object : OnItemSelectListener {
            override fun setOnItemSelectListener(position: Int, selectedCategoryName: String) {
                //Toast.makeText(requireActivity(), "${searchableSpinnerCountry.selectedItem}  ${searchableSpinnerCountry.selectedItemPosition}", Toast.LENGTH_SHORT).show()
                for (i in categoryList?.indices!!) {
                    val categoryName = categoryList!![i].name
                    if (selectedCategoryName.contentEquals(categoryName)) {
                        selectedCategoryId = categoryList!![i].id
                        selectedCategorySlug = categoryList!![i].catUrl
                        getBListingDetailsByCategorySlugApi(selectedCategorySlug)
                    }
                }

            }
        }

        etSearch.doOnTextChanged { text, _, _, _ ->
            val query = text.toString().toLowerCase()
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
            startActivityForResult(intent, AppConstants.SPEECH_REQUEST_CODE)
        }

        clearQueryImageView.setOnClickListener {
            etSearch.setText("")
            setBusinessListingAdaptor(businessList)
        }

    }

    private fun callCategoryApi() {

        if (CommonUtil.checkNetwork(mContext)) {
            val dataNotic = GbusinessService.create(mContext)

            dataNotic.getCategoryList().enqueue(object : Callback<CategoryDataClass> {
                override fun onResponse(call: Call<CategoryDataClass>, response: Response<CategoryDataClass>) {
                    val getCategoryResponse = response.body()
                    if (getCategoryResponse != null) {
                        if (response.isSuccessful) {
                            //CommonUtil.toast("Country list successfully fetched.", mContext)
                            categoryList = getCategoryResponse.data
                            if (!categoryList.isNullOrEmpty()) {

                                searchableSpinnerCategory.setSpinnerListItems(loadCategoriesNameList(categoryList!!))
                                /*for (i in categoryList!!.indices) {
                                    val categoryId = categoryList!![i].id
                                    getBListingDetailsByCategoryIdApi(categoryId)
                                }*/
                            }
                        } else
                            CommonUtil.toast("Something went wrong", mContext)
                    }

                }

                override fun onFailure(call: Call<CategoryDataClass>, t: Throwable) {
                    CommonUtil.toast(R.string.showError.toString(), mContext)
                    CommonUtil.logi(t.localizedMessage.toString())
                }
            })

        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }

    private fun loadCategoriesNameList(categoryList: List<CategoryDataClass.Data>): ArrayList<String> {
        val catList = ArrayList<String>()
        if (!categoryList.isNullOrEmpty()) {
            for (list in categoryList) {
                val name = list.name
                catList.add(name)
            }
        }
        return catList
    }

    /*private fun getBListingDetailsByCategoryIdApi(catId: Int?) {

        if (CommonUtil.checkNetwork(mContext)) {
            //CommonUtil.showDialog(mContext)
            val dataNotic = GbusinessService.create(mContext)
            //if (userID != null) {
            dataNotic.getBusinessListByCategoryDetails(
                catId!!
            ).enqueue(object : Callback<BusinessDirectoryDataClass> {
                override fun onResponse(call: Call<BusinessDirectoryDataClass>, response: Response<BusinessDirectoryDataClass>) {
                    CommonUtil.hideDialog(mContext)
                    // Log.i("TAGad", response.body()?.success.toString())
                    val businessDirectoryResponse = response.body()!!
                    if (response.code() == 200) {
                        if (businessDirectoryResponse.data != null) {

                            if (businessDirectoryResponse.data.isNotEmpty()) {
                                rvBusinessListing.visibility = View.VISIBLE
                                val businessList = businessDirectoryResponse.data
                                setBusinessListingAdaptor(businessList)
                            } else {
                                rvBusinessListing.visibility = View.GONE
                                Toast.makeText(requireActivity(), "Data is not available", Toast.LENGTH_SHORT).show()
                            }

                        }
                    } else if (response.code() == 400) {

                        IonAlert(requireActivity(), IonAlert.WARNING_TYPE)
                            .setTitleText("Not Found!")
                            .setContentText("Data not found in this category")
                            .setConfirmText("Ok")
                            .setConfirmClickListener {
                                it.dismissWithAnimation()
                            }
                            .show()
                    }
                }

                override fun onFailure(call: Call<BusinessDirectoryDataClass>, t: Throwable) {
                    CommonUtil.hideDialog(mContext)
                    CommonUtil.toast(R.string.showError.toString(), mContext)
                    CommonUtil.logi(t.localizedMessage.toString())
                }
            })
        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }*/

    private fun getBListingDetailsByCategorySlugApi(catUrl: String?) {

        if (CommonUtil.checkNetwork(mContext)) {
            //CommonUtil.showDialog(mContext)
            val dataNotic = GbusinessService.create(mContext)
            //if (userID != null) {
            dataNotic.getBusinessListByCategoryDetails(
                catUrl!!
            ).enqueue(object : Callback<BusinessDirectoryDataClass> {
                override fun onResponse(call: Call<BusinessDirectoryDataClass>, response: Response<BusinessDirectoryDataClass>) {
                    CommonUtil.hideDialog(mContext)
                    // Log.i("TAGad", response.body()?.success.toString())
                    val businessDirectoryResponse = response.body()!!
                    if (response.code() == 200) {
                        if (businessDirectoryResponse.data != null) {

                            if (businessDirectoryResponse.data.isNotEmpty()) {
                                rvBusinessListing.visibility = View.VISIBLE
                                val businessList = businessDirectoryResponse.data
                                setBusinessListingAdaptor(businessList)
                            } else {
                                rvBusinessListing.visibility = View.GONE
                                Toast.makeText(requireActivity(), "Data is not available", Toast.LENGTH_SHORT).show()
                            }

                        }
                    } else if (response.code() == 400) {

                        IonAlert(requireActivity(), IonAlert.WARNING_TYPE)
                            .setTitleText("Not Found!")
                            .setContentText("Data not found in this category")
                            .setConfirmText("Ok")
                            .setConfirmClickListener {
                                it.dismissWithAnimation()
                            }
                            .show()
                    }
                }

                override fun onFailure(call: Call<BusinessDirectoryDataClass>, t: Throwable) {
                    CommonUtil.hideDialog(mContext)
                    CommonUtil.toast(R.string.showError.toString(), mContext)
                    CommonUtil.logi(t.localizedMessage.toString())
                }
            })
        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }

    override fun onItemClicked(position: Int, list: BusinessDirectoryDataClass.Data) {
        //CommonUtil.toast("Clicked on item", mContext)
        val id = list.id
        val businessLogoUrl = list.businessLogo
        val businessName = list.businessName
        val businessEmail = list.businessEmail
        val businessPhone = list.businessPhone
        val businessWebUrl = list.businessWebUrl
        val businessAboutUs = list.businessAboutUs
        val countryId = list.countryId
        val stateId = list.stateId
        val city = list.city
        val zipCode = list.zipCode
        val address = list.address
        val catId = list.categoryId
        val subCatId = list.subCategoryId

        val bundle = Bundle()
        bundle.putString("address", list.address)
        bundle.putString("businessAboutUs", list.businessAboutUs)
        bundle.putString("businessName", list.businessName)
        bundle.putString("businessEmail", list.businessEmail)
        bundle.putString("businessPhone", list.businessPhone)
        bundle.putString("businessLogoUrl", list.businessLogo)
        bundle.putString("business_services", list.businessServices)
        bundle.putString("business_services_other", list.businessServicesOther)
        bundle.putInt("id", list.id)
        bundle.putString("establish_date", list.establishDate)
        bundle.putString("businessWebUrl", list.businessWebUrl)
        bundle.putString("subDomainUrl", list.subDomain)
        bundle.putString("sellerUrl", list.sellerUrl)
        bundle.putString("facebookUrl", list.facebookUrl)
        bundle.putString("linkedinUrl", list.linkedinUrl)
        bundle.putString("twitterUrl", list.twitterUrl)
        bundle.putString("instagramUrl", list.instagramUrl)
        bundle.putInt("countryId", list.countryId)
        bundle.putInt("stateId", list.stateId)
        bundle.putString("city", list.city)
        bundle.putInt("zipCode", list.zipCode)
        bundle.putInt("catId", list.categoryId)
        bundle.putInt("subCatId", list.subCategoryId)

        bundle.putString("sunday", list.sunday)
        bundle.putString("sunday_start_time", list.sundayStartTime)
        bundle.putString("sunday_end_time", list.sundayEndTime)
        bundle.putString("monday", list.monday)
        bundle.putString("monday_start_time", list.mondayStartTime)
        bundle.putString("monday_end_time", list.mondayEndTime)
        bundle.putString("tuesday", list.tuesday)
        bundle.putString("tuesday_start_time", list.tuesdayStartTime)
        bundle.putString("tuesday_end_time", list.tuesdayEndTime)
        bundle.putString("wednesday", list.wednesday)
        bundle.putString("wednesday_start_time", list.wednesdayStartTime)
        bundle.putString("wednesday_end_time", list.wednesdayEndTime)
        bundle.putString("thirsday", list.thirsday)
        bundle.putString("thirsday_start_time", list.thirsdayStartTime)
        bundle.putString("thirsday_end_time", list.thirsdayEndTime)
        bundle.putString("friday", list.friday)
        bundle.putString("friday_start_time", list.fridayStartTime)
        bundle.putString("friday_end_time", list.fridayEndTime)
        bundle.putString("saturday", list.saturday)
        bundle.putString("saturday_start_time", list.saturdayStartTime)
        bundle.putString("saturday_end_time", list.saturdayEndTime)

        MainActivity.navController.navigate(R.id.action_myBusinessListingFragment_to_businessListingDetailsFragment, bundle)
    }

    override fun onBtnClickedWebsite(pos: Int, list: BusinessDirectoryDataClass.Data) {
        val bundle = Bundle()
        bundle.putString("back", "BusinessListingFragment")
        bundle.putString("webUrl", list.businessWebUrl)
        view?.findNavController()?.navigate(R.id.action_myBusinessListingFragment_to_paymentOrInvoiceWebView, bundle)
    }

    override fun onBtnClickedQuote(pos: Int, list: BusinessDirectoryDataClass.Data) {

        alertQuoteDialog(list.userId)
    }

    private fun alertQuoteDialog(userId: Int) {
        var dialog: Dialog? = null
        try {
            if (dialog != null) {
                dialog.dismiss()
                dialog = null
            }
            dialog = Dialog(requireActivity(), R.style.AppCompatAlertDialogStyleBig)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.window!!.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT
            );
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setCancelable(false)
            val mInflater = LayoutInflater.from(activity)
            mView = mInflater.inflate(R.layout.dlg_get_quote, null, false)

            val finalDialog: Dialog = dialog
            mView.btnSubmitQuote.setOnClickListener {
                name = mView.etNamePopup.text.toString()
                email = mView.etEmailPopup.text.toString()
                phone = mView.etContactPopup.text.toString()
                query = mView.etQueryPopup.text.toString()
                //finalDialog.dismiss()
                //if (validate()) {
                callApiBusinessEnquiry(userId, name, email, phone, query, finalDialog)
                //}
            }
            mView.ivCancel.setOnClickListener {
                finalDialog.dismiss()
            }
            dialog.setContentView(mView)
            dialog.show()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    private fun callApiBusinessEnquiry(userId: Int, name: String, email: String, phone: String, query: String, finalDialog: Dialog) {
        if (CommonUtil.checkNetwork(mContext)) {

            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)

            //  Log.i("siteReStore", tempID)

            val dataNotic = GbusinessService.create(mContext)
            if (userID != null) {
                dataNotic.businessEnquiry(
                    "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),
                    userId, name, email, phone, query
                )

                    .enqueue(object : Callback<Any> {
                        override fun onFailure(
                            call: Call<Any>,
                            t: Throwable,
                        ) {
                            CommonUtil.hideDialog(mContext)

                            CommonUtil.logi(t.localizedMessage.toString())
                        }

                        override fun onResponse(
                            call: Call<Any>,
                            response: Response<Any>,
                        ) {
                            CommonUtil.hideDialog(mContext)

                            if (response.isSuccessful) {
                                val gson = Gson()
                                val businessEnqData = gson.fromJson(gson.toJson(response.body()), BusinessEnquiryResponse::class.java)
                                CommonUtil.logi(businessEnqData.toString())
                                if (businessEnqData.status.contains("success")) {
                                    CommonUtil.toast(businessEnqData.result.msg, mContext)
                                    finalDialog.dismiss()
                                } else /*if (businessEnqData.status.contains("error")) */ {
                                    try {
                                        /*val errorBody = response.errorBody()!!.string()
                                        var jsonObject = JSONObject(errorBody.trim { it <= ' ' })
                                        jsonObject = jsonObject.getJSONObject("result")*/

                                        //val errorBody = response.errorBody()?.string()
                                        val errorBody = gson.fromJson(gson.toJson(response.body()), BusinessEnqErrorResponse::class.java)
                                        if (errorBody != null) {
                                            alertErrorDialog(errorBody)
                                        }

                                        /*val type = object : TypeToken<BusinessEnqErrorResponse>() {}.type
                                        val errorResponse: BusinessEnqErrorResponse? = gson.fromJson(errorBody.charStream(), type)
                                        val errorMessage = errorResponse?.result*/
                                        //val errorBody = response.errorBody().toString()
                                        /*var jsonObjectResponse = JSONObject(errorBody)
                                        var jsonObjectResult = jsonObjectResponse.getJSONObject("result")
                                        val keys: Iterator<*> = jsonObjectResult.keys()
                                        var errors = ""
                                        while (keys.hasNext()) {
                                            // loop to get the dynamic key
                                            val currentDynamicKey = keys.next() as String

                                            // get the value of the dynamic key
                                            val currentDynamicValue = jsonObjectResult.getJSONObject(currentDynamicKey)

                                            errors += "$currentDynamicKey  :  $currentDynamicValue"
                                        }*/
                                        //CommonUtil.toastError(errorMessage.toString(), mContext)

                                    } catch (e: java.lang.Exception) {
                                        e.printStackTrace()
                                        CommonUtil.toastError(e.localizedMessage, mContext)
                                    }
                                } /*else if (getData.status.contains("error") && getData.msg.contains("Something went wrong or email is wrong!"))
                                        CommonUtil.toastError(getData.msg, mContext)*/
                            }

                        }
                    })
            }

        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }

    fun alertErrorDialog(errorBody: BusinessEnqErrorResponse) {
        var dialog: Dialog? = null
        try {
            if (dialog != null) {
                dialog.dismiss()
                dialog = null
            }
            dialog = Dialog(requireActivity(), R.style.AppCompatAlertDialogStyleBig)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.window!!.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT
            );
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setCancelable(false)
            val mInflater = LayoutInflater.from(activity)
            mViewError = mInflater.inflate(R.layout.dlg_error_msg, null, false)
            val finalDialog: Dialog = dialog
            val nameError = errorBody.result.nameError
            val emailError = errorBody.result.emailError
            val mobileNumberError = errorBody.result.mobileNumberError
            val queryError = errorBody.result.queryError
            var name = mViewError.tvNameError.text.toString()

            if (nameError != null) {
                mViewError.tvNameError.text = getString(R.string.name_error)
                mViewError.tvNameError.visibility = View.VISIBLE
            } else {
                mViewError.tvNameError.visibility = View.GONE
            }

            if (emailError != null) {
                mViewError.tvEmailError.text = getString(R.string.email_error)
                mViewError.tvEmailError.visibility = View.VISIBLE
            } else {
                mViewError.tvEmailError.visibility = View.GONE
            }

            if (mobileNumberError != null) {
                mViewError.tvMobileError.text = getString(R.string.mobile_error)
                mViewError.tvMobileError.visibility = View.VISIBLE
            } else {
                mViewError.tvMobileError.visibility = View.GONE
            }

            if (queryError != null) {
                mViewError.tvQueryError.text = getString(R.string.query_error)
                mViewError.tvQueryError.visibility = View.VISIBLE
            } else {
                mViewError.tvQueryError.visibility = View.GONE
            }

            mViewError.tvCancelError.setOnClickListener {
                finalDialog.dismiss()
            }
            dialog.setContentView(mViewError)
            dialog.show()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }
}

    