package com.milkyway.gbusiness.fragments

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.*
import android.widget.*
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.github.drjacky.imagepicker.ImagePicker
import com.google.android.material.textfield.TextInputEditText
import com.hbb20.CountryCodePicker
import com.leo.searchablespinner.SearchableSpinner
import com.leo.searchablespinner.interfaces.OnItemSelectListener
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.activities.MainActivity
import com.milkyway.gbusiness.extension.setLocalImage
import com.milkyway.gbusiness.models.*
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.global.CommonUtil
import com.milkyway.gbusiness.global.FileUtils
import kotlinx.android.synthetic.main.dlg_get_quote.view.*
import kotlinx.android.synthetic.main.fragment_business_listing_details.*
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_rating_review.*
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
 * Use the [BusinessListCreateFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BusinessListCreateFragment : Fragment() {

    lateinit var mContext: Context
    private lateinit var createBusinessListBack: ImageView

    private lateinit var ivBusinessLogoCreate: ImageView
    private lateinit var ivCameraCreate: ImageView
    private lateinit var fsvBusinessCategoryCreate: FieldSetView
    private lateinit var fsvBusinessSubcategoryCreate: FieldSetView
    private lateinit var fsvBusinessCountry: FieldSetView
    private lateinit var fsvBusinessState: FieldSetView
    private lateinit var tvBusinessCategoryCreate: TextView
    private lateinit var tvBusinessSubcategoryCreate: TextView
    private lateinit var tvBusinessCountry: TextView
    private lateinit var tvBusinessState: TextView
    private lateinit var btnCreateBusinessData: AppCompatButton
    private lateinit var etBusinessNameCreate: EditText
    private lateinit var etEmailCreate: EditText
    private lateinit var etWebUrlCreate: EditText
    private lateinit var etSellerUrlCreate: EditText
    private lateinit var etFacebookUrlCreate: EditText
    private lateinit var etTwitterUrlCreate: EditText
    private lateinit var etInstagramUrlCreate: EditText
    private lateinit var etLinkedinUrlCreate: EditText
    private lateinit var etBusinessSubdomainUrl: EditText
    private lateinit var etMobileBusinessListing: TextInputEditText
    private lateinit var cCPickerBusinessListing: CountryCodePicker
    private lateinit var etBusinessCity: EditText
    private lateinit var etBusinessZipCode: EditText
    private lateinit var etBusinessAddress: EditText
    private lateinit var etAboutUsPageCreate: EditText
    private lateinit var listData: BusinessListingResponse.Data
    private lateinit var searchableSpinnerCategory: SearchableSpinner
    private lateinit var searchableSpinnerSubcategory: SearchableSpinner
    private lateinit var categoryDataList: List<CategoryDataClass.Data>
    private lateinit var subCatDataList: List<SubCategoryDataClass.Subcategory>
    private var selectedCatId: Int = 0
    private var selectedSubcatId: Int = 0
    private var mBusinessLogoImageUri: Uri? = null

    private lateinit var searchableSpinnerCountry: SearchableSpinner
    private lateinit var searchableSpinnerState: SearchableSpinner
    private lateinit var searchableSpinnerCity: SearchableSpinner

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
        val view = inflater.inflate(R.layout.fragment_business_list_create, container, false)
        initializeView(view)
        clickListener(view)
        return view
    }

    private fun clickListener(view: View) {
        createBusinessListBack.setOnClickListener {
            MainActivity.navController.navigate(R.id.action_createBusinessListFragment_to_myBusinessListFragment)
        }
        fsvBusinessCategoryCreate.setOnClickListener {
            searchableSpinnerCategory.show()
        }

        fsvBusinessSubcategoryCreate.setOnClickListener {
            searchableSpinnerSubcategory.show()
        }

        btnCreateBusinessData.setOnClickListener {
            if (validate()) {
                callCreateBusinessListApi(mBusinessLogoImageUri, selectedCatId, selectedSubcatId)
            }
        }

        ivCameraCreate.setOnClickListener {
            //showDialog()
            pickBusinessLogo(view)
        }

        //todo show list for category.....
        searchableSpinnerCategory.onItemSelectListener = object : OnItemSelectListener {
            override fun setOnItemSelectListener(position: Int, selectedCatName: String) {
                tvBusinessCategoryCreate.text = selectedCatName
                for (i in categoryDataList?.indices!!) {
                    val catName = categoryDataList!![i].name
                    if (selectedCatName.contentEquals(catName)) {
                        selectedCatId = categoryDataList!![i].id
                        callSubcategoryApi(selectedCatId)
                    }
                }
            }
        }

        searchableSpinnerSubcategory.onItemSelectListener = object : OnItemSelectListener {
            override fun setOnItemSelectListener(position: Int, selectedSubCatName: String) {
                tvBusinessSubcategoryCreate.text = selectedSubCatName
                for (i in subCatDataList?.indices!!) {
                    val subCatName = subCatDataList!![i].name
                    if (selectedSubCatName.contentEquals(subCatName)) {
                        selectedSubcatId = subCatDataList!![i].id
                    }
                }

            }
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

        //todo set subdomain from business first word......
        etBusinessSubdomainUrl.setOnTouchListener(object : View.OnTouchListener{
            override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
                //todo get first name from business name.....
                var businessName = etBusinessNameCreate.getText().toString()
                val arr: Array<String> = businessName.split(" ").toTypedArray()
                val firstWord = arr[0]
                etBusinessSubdomainUrl.setText(firstWord)
                Log.e("first_word------", firstWord)
                return true
            }

        })

    }

    //todo initialization.......
    private fun initializeView(view: View) {
        createBusinessListBack = view.findViewById(R.id.createBusinessListBack)

        ivBusinessLogoCreate = view.findViewById(R.id.ivBusinessLogoCreate)
        ivCameraCreate = view.findViewById(R.id.ivCameraCreate)
        etBusinessNameCreate = view.findViewById(R.id.etBusinessNameCreate)
        fsvBusinessCategoryCreate = view.findViewById(R.id.fsvBusinessCategoryCreate)
        fsvBusinessSubcategoryCreate = view.findViewById(R.id.fsvBusinessSubcategoryCreate)
        tvBusinessCategoryCreate = view.findViewById(R.id.tvBusinessCategoryCreate)
        tvBusinessSubcategoryCreate = view.findViewById(R.id.tvBusinessSubcategoryCreate)
        etEmailCreate = view.findViewById(R.id.etEmailCreate)
        etWebUrlCreate = view.findViewById(R.id.etWebUrlCreate)
        etSellerUrlCreate = view.findViewById(R.id.etSellerUrlCreate)
        etFacebookUrlCreate = view.findViewById(R.id.etFacebookUrlCreate)
        etTwitterUrlCreate = view.findViewById(R.id.etTwitterUrlCreate)
        etInstagramUrlCreate = view.findViewById(R.id.etInstagramUrlCreate)
        etLinkedinUrlCreate = view.findViewById(R.id.etLinkedinUrlCreate)
        etAboutUsPageCreate = view.findViewById(R.id.etAboutUsPageCreate)
        btnCreateBusinessData = view.findViewById(R.id.btnCreateBusinessList)
        fsvBusinessCountry = view.findViewById(R.id.fsvBusinessCountry)
        fsvBusinessState = view.findViewById(R.id.fsvBusinessState)
        tvBusinessCountry = view.findViewById(R.id.tvBusinessCountry)
        tvBusinessState = view.findViewById(R.id.tvBusinessState)
        etBusinessSubdomainUrl = view.findViewById(R.id.etBusinessSubdomainUrl)
        etMobileBusinessListing = view.findViewById(R.id.etMobileBusinessListing)
        cCPickerBusinessListing = view.findViewById(R.id.cCPickerBusinessListing)
        etBusinessCity = view.findViewById(R.id.etBusinessCity)
        etBusinessZipCode = view.findViewById(R.id.etBusinessZipCode)
        etBusinessAddress = view.findViewById(R.id.etBusinessAddress)

        searchableSpinnerCountry = SearchableSpinner(requireActivity())
        searchableSpinnerCountry.windowTitle = "Select/Search Country"

        searchableSpinnerState = SearchableSpinner(requireActivity())
        searchableSpinnerState.windowTitle = "Select/Search State"

        searchableSpinnerCategory = SearchableSpinner(requireActivity())
        searchableSpinnerCategory.windowTitle = "Select/Search Category"

        searchableSpinnerSubcategory = SearchableSpinner(requireActivity())
        searchableSpinnerSubcategory.windowTitle = "Select/Search Subcategory"

        callCategoryApi()
    }

    //todo submit listing details......
    private fun callCreateBusinessListApi(fileUri: Uri?, selectedCatId: Int, selectedSubCatId: Int) {
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
            val attachmentEmpty = RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            filePhotoLogo = MultipartBody.Part.createFormData("business_logo", "", attachmentEmpty)
        }

        try {
            //todo convert string text into REQUEST BODY form.....
            val userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            val bName = etBusinessNameCreate.text.toString().trim()
            val bSubdomainName = etBusinessSubdomainUrl.text.toString().trim()
            val bCityName = etBusinessCity.text.toString().trim()
            val bZipCode = etBusinessZipCode.text.toString().trim()
            val bAddress = etBusinessAddress.text.toString().trim()
            val bEmail = etEmailCreate.text.toString().trim()
            val bPhone = etMobileBusinessListing.text.toString().trim()
            val bWebUrl = etWebUrlCreate.text.toString().trim()
            val bSellerUrl = etSellerUrlCreate.text.toString().trim()
            val bFacebookUrl = etFacebookUrlCreate.text.toString().trim()
            val bTwitterUrl = etTwitterUrlCreate.text.toString().trim()
            val bInstagramUrl = etInstagramUrlCreate.text.toString().trim()
            val bLinkedinUrl = etLinkedinUrlCreate.text.toString().trim()
            val bAboutUs = etAboutUsPageCreate.text.toString().trim()

            val rbUserID: RequestBody = if (userID!!.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), userID) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbName: RequestBody = if (bName.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), bName) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbSubdomainName: RequestBody = if (bSubdomainName.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), bSubdomainName) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbCountryID: RequestBody = if (selectedCountryId.toString().isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), selectedCountryId.toString()) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbStateID: RequestBody = if (selectedStateId.toString().isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), selectedStateId.toString()) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbCityName: RequestBody = if (bCityName.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), bCityName) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbZipCode: RequestBody = if (bZipCode.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), bZipCode) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbAddress: RequestBody = if (bAddress.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), bAddress) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbSelectedCatID: RequestBody = if (selectedCatId.toString().isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), selectedCatId.toString()) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbSelectedSubCatID: RequestBody = if (selectedSubCatId.toString().isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), selectedSubCatId.toString()) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbMail: RequestBody = if (bEmail.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), bEmail) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbPhone: RequestBody = if (bPhone.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), bPhone) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbWebUrl: RequestBody = if (bWebUrl.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), bWebUrl) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbSellerUrl: RequestBody = if (bSellerUrl.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), bSellerUrl) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbFacebookUrl: RequestBody = if (bFacebookUrl.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), bFacebookUrl) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbTwitterUrl: RequestBody = if (bTwitterUrl.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), bTwitterUrl) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbInstagramUrl: RequestBody = if (bInstagramUrl.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), bInstagramUrl) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbLinkdinUrl: RequestBody = if (bLinkedinUrl.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), bLinkedinUrl) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbAboutUs: RequestBody = if (bAboutUs.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), bAboutUs) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")

            if (CommonUtil.checkNetwork(mContext)) {
                val apiServices = GbusinessService.create(mContext)
                apiServices.createBusinessListData("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),
                    rbUserID, rbName, rbSubdomainName, filePhotoLogo!!, rbMail, rbPhone, rbWebUrl, rbSelectedCatID, rbSelectedSubCatID, rbCountryID, rbStateID, rbCityName,
                    rbZipCode, rbAddress, rbSellerUrl, rbFacebookUrl, rbTwitterUrl, rbInstagramUrl, rbLinkdinUrl, rbAboutUs)
                    .enqueue(object : Callback<BusinessListEditResponse> {
                        override fun onResponse(call: Call<BusinessListEditResponse>, response: Response<BusinessListEditResponse>) {
                            val updateListResponse = response.body()
                            if (updateListResponse != null) {
                                CommonUtil.successToast("Create Business List!", "${updateListResponse.message}", requireActivity())
                                MainActivity.navController.navigate(R.id.action_createBusinessListFragment_to_myBusinessListFragment)
                            }
                        }

                        override fun onFailure(call: Call<BusinessListEditResponse>, t: Throwable) {
                            CommonUtil.hideDialog(mContext)
                            CommonUtil.toast(R.string.showError.toString(), mContext)
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

    //todo category api..
    private fun callCategoryApi() {
        if (CommonUtil.checkNetwork(mContext)) {
            val apiServices = GbusinessService.create(mContext)
            apiServices.getCategoryList().enqueue(object : Callback<CategoryDataClass> {
                override fun onResponse(call: Call<CategoryDataClass>, response: Response<CategoryDataClass>) {
                    val categoryResponse = response.body()
                    if (categoryResponse != null) {
                        categoryDataList = categoryResponse.data
                        searchableSpinnerCategory.setSpinnerListItems(loadCategoryNameList(categoryDataList))
                        for (i in categoryDataList?.indices!!) {
                            val catName = categoryDataList!![i].name
                            if (tvBusinessCategoryCreate.text.contentEquals(catName)) {
                                selectedCatId = categoryDataList!![i].id
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
        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }

    //todo hit subcategory api...
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

    private val logoImageLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            val uri = it.data?.data!!
            mBusinessLogoImageUri = uri
            ivBusinessLogoCreate.setLocalImage(uri, true)
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

    //todo validations.......
    private fun validate(): Boolean {
        when {
            CommonUtil.isUriEmpty(mBusinessLogoImageUri) -> {
                CommonUtil.warningToast("Upload Business Logo", "Please upload business logo first.", requireActivity())
                return false
            }

            TextUtils.isEmpty(etBusinessNameCreate.text.toString()) -> {
                etBusinessNameCreate.error = "Business name field can't be blank."
                etBusinessNameCreate.requestFocus()
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

            TextUtils.isEmpty(tvBusinessCategoryCreate.text.toString()) -> {
                tvBusinessCategoryCreate.requestFocus()
                //tvBusinessCategoryCreate.error = "Please Select business category"
                CommonUtil.warningToast("Category Warning", "Please Select business category", requireActivity())
                return false
            }

            TextUtils.isEmpty(tvBusinessSubcategoryCreate.text.toString()) -> {
                tvBusinessSubcategoryCreate.requestFocus()
                CommonUtil.warningToast("Subcategory Warning", "Please Select business subcategory", requireActivity())
                //tvBusinessSubcategoryCreate.error = ""
                return false
            }

            TextUtils.isEmpty(etEmailCreate.text.toString()) -> {
                etEmailCreate.error = "Email field can't be blank."
                etEmailCreate.requestFocus()
                return false
            }

            CommonUtil.isValidMail(etEmailCreate.text.toString()) -> {
                etEmailCreate.error = "Please enter valid mail."
                etEmailCreate.requestFocus()
                return false
            }


            TextUtils.isEmpty(etMobileBusinessListing.text.toString()) -> {
                etMobileBusinessListing.error = "Mobile No. field can't be blank."
                etMobileBusinessListing.requestFocus()
                return false
            }

            TextUtils.isEmpty(etWebUrlCreate.text.toString()) -> {
                etWebUrlCreate.error = "Web url field can't be blank."
                etWebUrlCreate.requestFocus()
                return false
            }

            /*   CommonUtil.isValidUrl(bUrl)->{
                   etWebUrlCreate.error = "Please enter valid web url."
                   etWebUrlCreate.requestFocus()
                   return false
               }*/

            TextUtils.isEmpty(etAboutUsPageCreate.text.toString()) -> {
                etAboutUsPageCreate.error = "About us field can't be blank."
                etAboutUsPageCreate.requestFocus()
                return false
            }

            else -> return true
        }
    }

}