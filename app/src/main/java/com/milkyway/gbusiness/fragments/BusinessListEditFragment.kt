package com.milkyway.gbusiness.fragments

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.drjacky.imagepicker.ImagePicker
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.textfield.TextInputEditText
import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.google.i18n.phonenumbers.Phonenumber
import com.hbb20.CountryCodePicker
import com.leo.searchablespinner.SearchableSpinner
import com.leo.searchablespinner.interfaces.OnItemSelectListener
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.activities.MainActivity
import com.milkyway.gbusiness.adaptor.WeekdaysNameAdapter
import com.milkyway.gbusiness.extension.setLocalImage
import com.milkyway.gbusiness.global.CommonUtil
import com.milkyway.gbusiness.global.CustomDatePickers
import com.milkyway.gbusiness.global.FileUtils
import com.milkyway.gbusiness.models.*
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.retrofit.GbusinessService
import kotlinx.android.synthetic.main.dlg_new_ticket.view.*
import kotlinx.android.synthetic.main.recyclerview_business_listing.*
import kotlinx.android.synthetic.main.recyclerview_item_business_listing.*
import libs.mjn.fieldset.FieldSetView
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [BusinessListEditFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BusinessListEditFragment : Fragment() , CountryCodePicker.OnCountryChangeListener{

    lateinit var mContext: Context
    private lateinit var editBusinessListingBack: ImageView
    private lateinit var ivBusinessLogoUpdate: ImageView
    private lateinit var ivCameraUpdate: ImageView
    private lateinit var fsvBusinessCategoryUpdate: FieldSetView
    private lateinit var fsvBusinessSubcategoryUpdate: FieldSetView
    private lateinit var tvBusinessCategoryUpdate: TextView
    private lateinit var tvBusinessSubcategoryUpdate: TextView
    private lateinit var btnUpdateBusinessData: AppCompatButton
    private lateinit var etBusinessNameUpdate: EditText
    private lateinit var etEmailUpdate: EditText
    private lateinit var etWebUrlUpdate: EditText
    private lateinit var etAboutUsPageUpdate: EditText
    private lateinit var etBusinessEstablishDateUpdate: EditText
    private lateinit var etBusinessSubdomainUrl: EditText
    private lateinit var fsvBusinessCountry: FieldSetView
    private lateinit var fsvBusinessState: FieldSetView
    private lateinit var tvBusinessCountry: TextView
    private lateinit var tvBusinessState: TextView
    private lateinit var etBusinessCity: EditText
    private lateinit var etBusinessZipCode: EditText
    private lateinit var etBusinessAddress: EditText
    private lateinit var etMobileBusinessListing: TextInputEditText
    private lateinit var etSellerUrlCreate: EditText
    private lateinit var etFacebookUrlCreate: EditText
    private lateinit var etTwitterUrlCreate: EditText
    private lateinit var etInstagramUrlCreate: EditText
    private lateinit var etLinkedinUrlCreate: EditText
    private lateinit var fsvLayoutFacebookUrl: FieldSetView
    private lateinit var fsvLayoutTwitterUrl: FieldSetView
    private lateinit var fsvLayoutInstagramUrl: FieldSetView
    private lateinit var fsvLayoutLinkedinUrl: FieldSetView
    private lateinit var listData: BusinessListingResponse.Data
    private lateinit var searchableSpinnerCategory: SearchableSpinner
    private lateinit var searchableSpinnerSubcategory: SearchableSpinner
    private lateinit var categoryDataList: List<CategoryDataClass.Data>
    private lateinit var subCatDataList: List<SubCategoryDataClass.Subcategory>
    private var selectedCatId: Int = 0
    private var selectedSubcatId: Int = 0
    private var mBusinessLogoImageUri: Uri? = null
    var county_name_code: String = ""
    var county_code: String = ""

    private lateinit var rv_working_weekdays: RecyclerView
    private lateinit var workingDaysLayoutManager: LinearLayoutManager
    private lateinit var ll_business_working_hours: LinearLayout
    private lateinit var card_view_show_list: CardView
    private lateinit var card_view_hide_list: CardView
    private lateinit var CCP: CountryCodePicker
    var weekdaysNameAdapter : WeekdaysNameAdapter? = null
    private val daysNameList = ArrayList<String>()
    private lateinit var searchableSpinnerCountry: SearchableSpinner
    private lateinit var searchableSpinnerState: SearchableSpinner
    var countryList: List<CountryDataClass.Country>? = null
    var stateList: List<StateDataClass.State>? = null
    var cityList: List<CityDataClass.City>? = null
    var selectedCountryId: Int = 0
    var selectedStateId: Int = 0

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
        val view = inflater.inflate(R.layout.fragment_business_list_edit, container, false)
        initializeView(view)
        clickListener(view)
        return view
    }

    private fun clickListener(view: View) {
        editBusinessListingBack.setOnClickListener {
            MainActivity.navController.navigate(R.id.action_editBusinessListFragment_to_myBusinessListFragment)
        }
        fsvBusinessCategoryUpdate.setOnClickListener {
            searchableSpinnerCategory.show()
        }

        fsvBusinessSubcategoryUpdate.setOnClickListener {
            searchableSpinnerSubcategory.show()
        }

        btnUpdateBusinessData.setOnClickListener {
            if (validate()) {
                callUpdateBusinessUpdateApi(mBusinessLogoImageUri, selectedCatId, selectedSubcatId)
            }
        }

        ivCameraUpdate.setOnClickListener {
            //showDialog()
            pickBusinessLogo(view)
        }

        searchableSpinnerCategory.onItemSelectListener = object : OnItemSelectListener {
            override fun setOnItemSelectListener(position: Int, selectedCatName: String) {
                //Toast.makeText(requireActivity(), "${searchableSpinnerCountry.selectedItem}  ${searchableSpinnerCountry.selectedItemPosition}", Toast.LENGTH_SHORT).show()
                tvBusinessCategoryUpdate.text = selectedCatName
                for (i in categoryDataList?.indices!!) {
                    val catName = categoryDataList!![i].name
                    if (selectedCatName.contentEquals(catName)) {
                        selectedCatId = categoryDataList!![i].id
                        //CommonUtil.successToast("Test", "Cat ID: $selectedCatId", requireActivity())
                        callSubcategoryApi(selectedCatId)
                    }
                }
            }
        }

        searchableSpinnerSubcategory.onItemSelectListener = object : OnItemSelectListener {
            override fun setOnItemSelectListener(position: Int, selectedSubCatName: String) {
                tvBusinessSubcategoryUpdate.text = selectedSubCatName
                for (i in subCatDataList?.indices!!) {
                    val subCatName = subCatDataList!![i].name
                    if (selectedSubCatName.contentEquals(subCatName)) {
                        selectedSubcatId = subCatDataList!![i].id
                        //CommonUtil.successToast("Test", "Subcat ID: $selectedSubcatId", requireActivity())
                    }
                }

            }
        }


        //todo hide and show working days hours....
        prepareItems() //todo add items in list.....
        card_view_show_list.setOnClickListener {
            card_view_show_list.visibility = View.GONE
            card_view_hide_list.visibility = View.VISIBLE
            ll_business_working_hours.visibility = View.VISIBLE
            bindWeekDaysAdapter()
        }

        card_view_hide_list.setOnClickListener {
            card_view_hide_list.visibility = View.GONE
            card_view_show_list.visibility = View.VISIBLE
            ll_business_working_hours.visibility = View.GONE
        }

        //todo call country api---
        callGetCountriesApi()

        fsvBusinessCountry.setOnClickListener {
            searchableSpinnerCountry.show()
        }

        searchableSpinnerCountry.onItemSelectListener = object : OnItemSelectListener {
            override fun setOnItemSelectListener(position: Int, selectedCountryName: String) {
                tvBusinessCountry.text = selectedCountryName

                for (i in countryList?.indices!!) {
                    val countryName = countryList!![i].name
                    if (selectedCountryName.contentEquals(countryName)) {
                        selectedCountryId = countryList!![i].id
                        Log.e("selectedCountryId----", selectedCountryId.toString())
                        callGetStatesApi(selectedCountryId)
                    }
                }
            }
        }

        //todo get state names according to country name...
        fsvBusinessState.setOnClickListener {
            searchableSpinnerState.show()
        }

        searchableSpinnerState.onItemSelectListener = object : OnItemSelectListener {
            override fun setOnItemSelectListener(position: Int, selectedStateName: String) {
                tvBusinessState.text = selectedStateName
                for (i in stateList?.indices!!) {
                    val stateName = stateList!![i].name
                    if (selectedStateName.contentEquals(stateName)) {
                        selectedStateId = stateList!![i].id
                        Log.e("selectedStateId---", selectedStateId.toString())
                    }
                }
            }
        }
    }

    //todo adapter for week days....
    fun bindWeekDaysAdapter(){
        weekdaysNameAdapter = WeekdaysNameAdapter(mContext,daysNameList )
        rv_working_weekdays.layoutManager = workingDaysLayoutManager
        rv_working_weekdays.adapter = weekdaysNameAdapter
    }

    //todo list items add....
    private fun prepareItems() {
        daysNameList.add("Sunday")
        daysNameList.add("Monday")
        daysNameList.add("Tuesday")
        daysNameList.add("Wednesday")
        daysNameList.add("Thursday")
        daysNameList.add("Friday")
        daysNameList.add("Saturday")
        weekdaysNameAdapter?.notifyDataSetChanged()
    }

    //todo initializer....
    private fun initializeView(view: View) {
        editBusinessListingBack = view.findViewById(R.id.editBusinessListingBack)
        ivBusinessLogoUpdate = view.findViewById(R.id.ivBusinessLogoUpdate)
        ivCameraUpdate = view.findViewById(R.id.ivCameraUpdate)
        etBusinessNameUpdate = view.findViewById(R.id.etBusinessNameUpdate)
        fsvBusinessCategoryUpdate = view.findViewById(R.id.fsvBusinessCategoryUpdate)
        fsvBusinessSubcategoryUpdate = view.findViewById(R.id.fsvBusinessSubcategoryUpdate)
        tvBusinessCategoryUpdate = view.findViewById(R.id.tvBusinessCategoryUpdate)
        tvBusinessSubcategoryUpdate = view.findViewById(R.id.tvBusinessSubcategoryUpdate)
        etEmailUpdate = view.findViewById(R.id.etEmailUpdate)
        etWebUrlUpdate = view.findViewById(R.id.etWebUrlUpdate)
        etAboutUsPageUpdate = view.findViewById(R.id.etAboutUsPageUpdate)
        btnUpdateBusinessData = view.findViewById(R.id.btnUpdateBusinessListUpdate)
        etBusinessEstablishDateUpdate = view.findViewById(R.id.etBusinessEstablishDateUpdate)
        etBusinessSubdomainUrl = view.findViewById(R.id.etBusinessSubdomainUrl)
        fsvBusinessCountry = view.findViewById(R.id.fsvBusinessCountry)
        fsvBusinessState = view.findViewById(R.id.fsvBusinessState)
        tvBusinessCountry = view.findViewById(R.id.tvBusinessCountry)
        tvBusinessState = view.findViewById(R.id.tvBusinessState)
        etBusinessCity = view.findViewById(R.id.etBusinessCity)
        etBusinessZipCode = view.findViewById(R.id.etBusinessZipCode)
        etBusinessAddress = view.findViewById(R.id.etBusinessAddress)
        etMobileBusinessListing = view.findViewById(R.id.etMobileBusinessListing)
        etSellerUrlCreate = view.findViewById(R.id.etSellerUrlCreate)
        fsvLayoutFacebookUrl = view.findViewById(R.id.fsvLayoutFacebookUrl)
        etFacebookUrlCreate = view.findViewById(R.id.etFacebookUrlCreate)
        etTwitterUrlCreate = view.findViewById(R.id.etTwitterUrlCreate)
        fsvLayoutTwitterUrl = view.findViewById(R.id.fsvLayoutTwitterUrl)
        fsvLayoutInstagramUrl = view.findViewById(R.id.fsvLayoutInstagramUrl)
        etInstagramUrlCreate = view.findViewById(R.id.etInstagramUrlCreate)
        fsvLayoutLinkedinUrl = view.findViewById(R.id.fsvLayoutLinkedinUrl)
        etLinkedinUrlCreate = view.findViewById(R.id.etLinkedinUrlCreate)
        card_view_show_list = view.findViewById(R.id.card_view_show_list)
        card_view_hide_list = view.findViewById(R.id.card_view_hide_list)
        ll_business_working_hours = view.findViewById(R.id.ll_business_working_hours)
        CCP = view.findViewById(R.id.cCPickerBusinessListing)
        rv_working_weekdays = view.findViewById(R.id.rv_working_weekdays)
        workingDaysLayoutManager = LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false)

        searchableSpinnerCategory = SearchableSpinner(requireActivity())
        searchableSpinnerCategory.windowTitle = "Select/Search Category"

        searchableSpinnerSubcategory = SearchableSpinner(requireActivity())
        searchableSpinnerSubcategory.windowTitle = "Select/Search Subcategory"

        searchableSpinnerCountry = SearchableSpinner(requireActivity())
        searchableSpinnerCountry.windowTitle = "Select/Search Country"

        searchableSpinnerState = SearchableSpinner(requireActivity())
        searchableSpinnerState.windowTitle = "Select/Search State"

        val args = arguments ?: return
        listData = args.getSerializable("list") as BusinessListingResponse.Data
        setDefaultData(listData)
        callCategoryApi()

        //todo establish date ........
        etBusinessEstablishDateUpdate.setOnClickListener {
            var customDatePickers : CustomDatePickers = CustomDatePickers(mContext)
            customDatePickers.showDatePickerDialog(etBusinessEstablishDateUpdate)
        }
        //callSubcategoryApi(selectedCatId)

        //todo get default county code and name..
        onCountrySelected()
        CCP.setOnCountryChangeListener {
            onCountrySelected()
        }

    }

    private fun callUpdateBusinessUpdateApi(fileUri: Uri?, selectedCatId: Int, selectedSubCatId: Int) {
        var filePhotoLogo: MultipartBody.Part? = null
        if (fileUri != null) {
            try {
                val file: File = FileUtils.getFile(requireActivity(), fileUri)
                if (file.exists()) {
                    val requestBody: RequestBody = RequestBody.create("*/*".toMediaTypeOrNull(), file)
                    filePhotoLogo = MultipartBody.Part.createFormData("business_logo", file.name, requestBody)
                }
            } catch (e: NullPointerException) {
                e.printStackTrace()
            }
        } else {
            val defaultUrl = "${GbusinessService.BASE_IMG_URL}${listData.business_logo}"
            val attachmentEmpty = RequestBody.create("text/plain".toMediaTypeOrNull(), defaultUrl)
            filePhotoLogo = MultipartBody.Part.createFormData("business_logo", "", attachmentEmpty)
        }

        try {
            val userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            val bName = etBusinessNameUpdate.text.toString().trim()
            val bEmail = etEmailUpdate.text.toString().trim()
            val bWebUrl = etWebUrlUpdate.text.toString().trim()
            val bAboutUs = etAboutUsPageUpdate.text.toString().trim()
            val bCatName = tvBusinessCategoryUpdate.text.toString().trim()
            val bSubCatName = tvBusinessSubcategoryUpdate.text.toString().trim()
            var catName = ""
            var catId = 0
            var subCatName = ""
            var subCatId = 0

            /*for (i in categoryDataList?.indices!!) {
                catName = categoryDataList!![i].name
                //catId = categoryDataList!![i].id
                if (catName.contentEquals(bCatName)) {
                    chooseCatID = categoryDataList!![i].id
                    CommonUtil.successToast("Test", "Cat ID: $chooseCatID", requireActivity())
                } else {
                    chooseCatID = selectedCatId
                }
            }

            for (i in subCatDataList?.indices!!) {
                subCatName = subCatDataList!![i].name
                //subCatId = subCatDataList!![i].id
                if (subCatName.contentEquals(bSubCatName)) {
                    chooseSubCatID = subCatDataList!![i].id
                    CommonUtil.successToast("Test", "Subcat ID: $chooseSubCatID", requireActivity())
                } else {
                    chooseSubCatID = selectedSubCatId
                }
            }
*/

            val rbUserID: RequestBody = if (userID!!.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), userID) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbSelectedCatID: RequestBody = if (selectedCatId.toString().isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), selectedCatId.toString()) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbSelectedSubCatID: RequestBody = if (selectedSubCatId.toString().isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), selectedSubCatId.toString()) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbName: RequestBody = if (bName.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), bName) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbMail: RequestBody = if (bEmail.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), bEmail) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbWebUrl: RequestBody = if (bWebUrl.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), bWebUrl) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbAboutUs: RequestBody = if (bAboutUs.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), bAboutUs) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")

            if (CommonUtil.checkNetwork(mContext)) {
                val apiServices = GbusinessService.create(mContext)
                apiServices.updateBusinessListData("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), listData.id,
                    rbUserID, rbName, rbMail, rbWebUrl, rbAboutUs, rbSelectedCatID, rbSelectedSubCatID, filePhotoLogo!!)
                    .enqueue(object : Callback<BusinessListEditResponse> {
                        override fun onResponse(call: Call<BusinessListEditResponse>, response: Response<BusinessListEditResponse>) {
                            val updateListResponse = response.body()
                            if (updateListResponse != null) {
                                CommonUtil.successToast("Update Business List!", "${updateListResponse.message}", requireActivity())
                                MainActivity.navController.navigate(R.id.action_editBusinessListFragment_to_myBusinessListFragment)
                            }
                        }

                        override fun onFailure(call: Call<BusinessListEditResponse>, t: Throwable) {
                            CommonUtil.hideDialog(mContext)
                            CommonUtil.toast(t.toString(), mContext)
                            CommonUtil.logi(t.localizedMessage.toString())
                        }
                    })

            } else {
                CommonUtil.toast("Check Internet", mContext)
            }
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }
    }

    private val logoImageLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            val uri = it.data?.data!!
            mBusinessLogoImageUri = uri
            ivBusinessLogoUpdate.setLocalImage(uri, true)
        } else parseError(it)
    }

    private fun parseError(activityResult: ActivityResult) {
        if (activityResult.resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(requireActivity(), ImagePicker.getError(activityResult.data), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireActivity(), "Task Cancelled", Toast.LENGTH_SHORT).show()
        }
    }

    private fun pickBusinessLogo(view: View) {
        ImagePicker.with(requireActivity())
            .crop()
            .cropOval()
            .maxResultSize(512, 512, true)
            .createIntentFromDialog { logoImageLauncher.launch(it) }
    }

    //todo get sub category names for show in list.........
    private fun loadSubcategoryNameList(subCatDataList: List<SubCategoryDataClass.Subcategory>): ArrayList<String> {
        val subCatList = ArrayList<String>()
        if (!subCatDataList.isNullOrEmpty()) {
            for (list in subCatDataList) {
                val name = list.name
                subCatList.add(name)
            }
        }
        return subCatList
    }

    //todo get category names for show in list.........
    private fun loadCategoryNameList(categoryDataList: List<CategoryDataClass.Data>): ArrayList<String> {
        val catList = ArrayList<String>()
        if (!categoryDataList.isNullOrEmpty()) {
            for (list in categoryDataList) {
                val name = list.name
                catList.add(name)
            }
        }
        return catList
    }

    //todo category api....
    private fun callCategoryApi() {
        if (CommonUtil.checkNetwork(mContext)) {
            val apiServices = GbusinessService.create(mContext)
            //if (userID != null) {
            apiServices.getCategoryList().enqueue(object : Callback<CategoryDataClass> {
                override fun onResponse(call: Call<CategoryDataClass>, response: Response<CategoryDataClass>) {
                    val categoryResponse = response.body()
                    if (categoryResponse != null) {
                        categoryDataList = categoryResponse.data
                        searchableSpinnerCategory.setSpinnerListItems(loadCategoryNameList(categoryDataList))
                        for (i in categoryDataList?.indices!!) {
                            val catName = categoryDataList!![i].name
                            if (tvBusinessCategoryUpdate.text.contentEquals(catName)) {
                                selectedCatId = categoryDataList!![i].id
                                //CommonUtil.successToast("Test", "$selectedCatId", requireActivity())
                                callSubcategoryApi(selectedCatId)
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<CategoryDataClass>, t: Throwable) {
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

    //todo sub category api...
    private fun callSubcategoryApi(selectedCatId: Int, subCatIdDefault: Int = 0) {
        if (CommonUtil.checkNetwork(mContext)) {
            val apiServices = GbusinessService.create(mContext)
            //if (userID != null) {
            apiServices.getSubCategoryList(selectedCatId).enqueue(object : Callback<SubCategoryDataClass> {
                override fun onResponse(call: Call<SubCategoryDataClass>, response: Response<SubCategoryDataClass>) {
                    val subCatResponse = response.body()
                    if (subCatResponse != null) {
                        subCatDataList = subCatResponse.subcategory
                        if (!subCatDataList.isNullOrEmpty()) {
                            searchableSpinnerSubcategory.setSpinnerListItems(loadSubcategoryNameList(subCatDataList))

                            for (i in subCatDataList?.indices!!) {
                                val subCatName = subCatDataList!![i].name
                                if (tvBusinessCategoryUpdate.text.contentEquals(subCatName)) {
                                    selectedSubcatId = subCatDataList!![i].id
                                    tvBusinessSubcategoryUpdate.text = subCatName
                                } /*else {
                                    tvBusinessSubcategoryUpdate.text = ""
                                    tvBusinessSubcategoryUpdate.hint = "Select Subcategory"
                                }*/
                            }
                            /*for (i in subCatDataList?.indices!!) {
                                val subCatName = subCatDataList!![i].name
                                if (tvBusinessSubcategoryUpdate.text.contentEquals(subCatName)) {
                                    tvBusinessSubcategoryUpdate.text = subCatName
                                } else {
                                    tvBusinessSubcategoryUpdate.text = ""
                                    tvBusinessSubcategoryUpdate.hint = "Select Subcategory"
                                }
                            }*/
                        }
                    }
                }

                override fun onFailure(call: Call<SubCategoryDataClass>, t: Throwable) {
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

    //todo get country names for show in list.........
    private fun loadCountriesNameList(countryArrayList: List<CountryDataClass.Country>?): ArrayList<String> {
        val countryList = ArrayList<String>()
        if (!countryArrayList.isNullOrEmpty()) {
            for (list in countryArrayList) {
                val name = list.name
                countryList.add(name)
            }
        }
        return countryList
    }

    //todo get state names for show in list....
    private fun loadStateNameList(stateArrayList: List<StateDataClass.State>?): ArrayList<String> {
        val stateList = ArrayList<String>()
        if (!stateArrayList.isNullOrEmpty()) {
            for (list in stateArrayList) {
                val name = list.name
                stateList.add(name)
            }
        }
        return stateList
    }

    //todo get county api..
    private fun callGetCountriesApi() {
        if (CommonUtil.checkNetwork(mContext)) {
            val countryApiService = GbusinessService.create(mContext)
            countryApiService.getCountries().enqueue(object : Callback<CountryDataClass> {
                override fun onResponse(call: Call<CountryDataClass>, response: Response<CountryDataClass>) {
                    val getCountryListData = response.body()
                    if (getCountryListData != null) {
                        if (response.isSuccessful) {
                            countryList = getCountryListData.countries
                            if (!countryList.isNullOrEmpty()) {
                                searchableSpinnerCountry.setSpinnerListItems(loadCountriesNameList(countryList))
                            }
                        } else
                            CommonUtil.toast("Something went wrong", mContext)
                    }
                }
                override fun onFailure(call: Call<CountryDataClass>, t: Throwable) {
                    CommonUtil.toast(t.message.toString(), mContext)
                }
            })
        } else {
            CommonUtil.toast("Check Internet connection", mContext)
        }
    }

    //todo get state api
    private fun callGetStatesApi(countryId: Int, stateCode: String = "0") {
        if (CommonUtil.checkNetwork(mContext)) {
            val stateApiService = GbusinessService.create(mContext)
            stateApiService.getStates(countryId).enqueue(object : Callback<StateDataClass> {
                override fun onResponse(call: Call<StateDataClass>, response: Response<StateDataClass>) {
                    val getStateData = response?.body()
                    if (getStateData != null) {
                        if (response.isSuccessful) {
                            stateList = getStateData.states
                            if (!stateList.isNullOrEmpty()) {
                                searchableSpinnerState.setSpinnerListItems(loadStateNameList(stateList))
                                for (i in stateList!!.indices) {
                                    val stateId = stateList!![i].id
                                    if (stateCode.contentEquals(stateId.toString())) {
                                        tvBusinessState.text = stateList!![i].name
                                    } else if (stateCode.contentEquals("0")) {
                                        tvBusinessState.text = ""
                                        tvBusinessState.hint = "Select state"
                                    }
                                }
                            }
                        } else
                            CommonUtil.toast("Something went wrong", mContext)
                    }
                }
                override fun onFailure(call: Call<StateDataClass>, t: Throwable) {
                    CommonUtil.toast(R.string.showError.toString(), mContext)
                }
            })
        } else {
            CommonUtil.toast("Check Internet connection", mContext)
        }
    }

    //todo set default data in texts....
    private fun setDefaultData(listData: BusinessListingResponse.Data) {
        fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)
        etBusinessNameUpdate.text = listData.business_name.toEditable()
        etBusinessNameUpdate.isSelected = false
        etBusinessNameUpdate.isEnabled = false
        etBusinessSubdomainUrl.text = listData.sub_domain.toEditable()
        etBusinessSubdomainUrl.isSelected = false
        etBusinessSubdomainUrl.isEnabled = false
        tvBusinessCountry.text = listData.country_id.toString()
        tvBusinessState.text = listData.state_id.toString()
        etBusinessCity.text = listData.city.toEditable()
        etBusinessZipCode.text = listData.zip_code.toEditable()
        etBusinessEstablishDateUpdate.text = listData.establish_date?.toEditable()
        etBusinessAddress.text = listData.address.toEditable()
        etEmailUpdate.text = listData.business_email.toEditable()
        etWebUrlUpdate.text = listData.business_web_url.toEditable()
        etWebUrlUpdate.isSelected = false
        etWebUrlUpdate.isEnabled = false
        etAboutUsPageUpdate.text = listData.business_about_us.toEditable()
        tvBusinessCategoryUpdate.text = listData.catname
        tvBusinessSubcategoryUpdate.setText(listData.subcatname)

        val phoneUtil: PhoneNumberUtil = PhoneNumberUtil.getInstance()
        val number: Phonenumber.PhoneNumber? = phoneUtil.parse(listData.business_phone,"")
        val countryCode: Int = number!!.getCountryCode()
        val nationalNumber: String = number.getNationalNumber().toString()
        etMobileBusinessListing.text = nationalNumber.toEditable()
//        CCP.defaultCountryCode = countryCode.toString()
        etSellerUrlCreate.text = listData.seller_url?.toEditable()
        etFacebookUrlCreate.text = listData.facebook_url?.toEditable()
        etTwitterUrlCreate.text = listData.twitter_url?.toEditable()
        etInstagramUrlCreate.text = listData.instagram_url?.toEditable()
        etLinkedinUrlCreate.text = listData.linkedin_url?.toEditable()

        if (listData.business_logo != null) {
            val urlLogo = GbusinessService.BASE_IMG_URL + listData.business_logo
            Glide.with(mContext)
                .load(urlLogo)
                .into(ivBusinessLogoUpdate)
        } else {
            val urlDefault = "${GbusinessService.BASE_IMG_URL}/default-business-logo.jpg"
            Glide.with(mContext)
                .load(urlDefault)
                .into(ivBusinessLogoUpdate)
        }
    }

    //todo validations..
    private fun validate(): Boolean {
        when {
            CommonUtil.isUriEmpty(mBusinessLogoImageUri) -> {
                CommonUtil.warningToast("Upload Business Logo", "Please upload business logo first.", requireActivity())
                return false
            }

            TextUtils.isEmpty(etBusinessNameUpdate.text.toString()) -> {
                etBusinessNameUpdate.error = "Business name field can't be blank."
                etBusinessNameUpdate.requestFocus()
                return false
            }

            TextUtils.isEmpty(etBusinessSubdomainUrl.text.toString()) -> {
                etBusinessSubdomainUrl.error = "Business Subdomain field can't be blank."
                etBusinessSubdomainUrl.requestFocus()
                return false
            }

            TextUtils.isEmpty(tvBusinessCountry.text.toString()) -> {
                tvBusinessCountry.requestFocus()
                //tvBusinessCategoryCreate.error = "Please Select business category"
                CommonUtil.warningToast("Country Warning", "Please Select the Country", requireActivity())
                return false
            }

            TextUtils.isEmpty(tvBusinessState.text.toString()) -> {
                tvBusinessState.requestFocus()
                //tvBusinessCategoryCreate.error = "Please Select business category"
                CommonUtil.warningToast("State Warning", "Please Select State", requireActivity())
                return false
            }

            TextUtils.isEmpty(etBusinessCity.text.toString()) -> {
                etBusinessCity.error = "Business City field is required."
                etBusinessCity.requestFocus()
                return false
            }

            TextUtils.isEmpty(etBusinessZipCode.text.toString()) -> {
                etBusinessZipCode.error = "Business Zip Code field is required."
                etBusinessZipCode.requestFocus()
                return false
            }

            TextUtils.isEmpty(etBusinessAddress.text.toString()) -> {
                etBusinessAddress.error = "Business Address field is required."
                etBusinessAddress.requestFocus()
                return false
            }

            TextUtils.isEmpty(tvBusinessCategoryUpdate.text.toString()) -> {
                tvBusinessCategoryUpdate.requestFocus()
                //tvBusinessCategoryCreate.error = "Please Select business category"
                CommonUtil.warningToast("Category Warning", "Please Select business category", requireActivity())
                return false
            }

            TextUtils.isEmpty(tvBusinessSubcategoryUpdate.text.toString()) -> {
                tvBusinessSubcategoryUpdate.requestFocus()
                CommonUtil.warningToast("Subcategory Warning", "Please Select business subcategory", requireActivity())
                //tvBusinessSubcategoryCreate.error = ""
                return false
            }

            TextUtils.isEmpty(etEmailUpdate.text.toString()) -> {
                etEmailUpdate.error = "Email field can't be blank."
                etEmailUpdate.requestFocus()
                return false
            }

            CommonUtil.isValidMail(etEmailUpdate.text.toString()) -> {
                etEmailUpdate.error = "Please enter valid mail."
                etEmailUpdate.requestFocus()
                return false
            }


            TextUtils.isEmpty(etMobileBusinessListing.text.toString()) -> {
                etMobileBusinessListing.error = "Mobile No. field can't be blank."
                etMobileBusinessListing.requestFocus()
                return false
            }

            TextUtils.isEmpty(etWebUrlUpdate.text.toString()) -> {
                etWebUrlUpdate.error = "Web url field can't be blank."
                etWebUrlUpdate.requestFocus()
                return false
            }

            /*   CommonUtil.isValidUrl(bUrl)->{
                   etWebUrlCreate.error = "Please enter valid web url."
                   etWebUrlCreate.requestFocus()
                   return false
               }*/

            TextUtils.isEmpty(etAboutUsPageUpdate.text.toString()) -> {
                etAboutUsPageUpdate.error = "About us field can't be blank."
                etAboutUsPageUpdate.requestFocus()
                return false
            }

            else -> return true
        }
    }

    override fun onCountrySelected() {
        county_code = CCP.selectedCountryCode
        county_name_code = CCP.selectedCountryNameCode
    }

}