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
import com.leo.searchablespinner.SearchableSpinner
import com.leo.searchablespinner.interfaces.OnItemSelectListener
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.activities.MainActivity
import com.milkyway.gbusiness.extension.setLocalImage
import com.milkyway.gbusiness.models.*
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.utils.CommonUtil
import com.milkyway.gbusiness.utils.FileUtils
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
    private lateinit var tvBusinessCategoryCreate: TextView
    private lateinit var tvBusinessSubcategoryCreate: TextView
    private lateinit var btnCreateBusinessData: AppCompatButton
    private lateinit var etBusinessNameCreate: EditText
    private lateinit var etEmailCreate: EditText
    private lateinit var etWebUrlCreate: EditText
    private lateinit var etSellerUrlCreate: EditText
    private lateinit var etAboutUsPageCreate: EditText
    private lateinit var listData: BusinessListingResponse.Data
    private lateinit var searchableSpinnerCategory: SearchableSpinner
    private lateinit var searchableSpinnerSubcategory: SearchableSpinner
    private lateinit var categoryDataList: List<CategoryDataClass.Data>
    private lateinit var subCatDataList: List<SubCategoryDataClass.Subcategory>
    private var selectedCatId: Int = 0
    private var selectedSubcatId: Int = 0
    private var mBusinessLogoImageUri: Uri? = null


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
                //CommonUtil.warningToast("Warning", "Validate", requireActivity())
                callCreateBusinessListApi(mBusinessLogoImageUri, selectedCatId, selectedSubcatId)

            } /*else {
                CommonUtil.warningToast("Warning", "No validate", requireActivity())
            }*/
        }

        ivCameraCreate.setOnClickListener {
            //showDialog()
            pickBusinessLogo(view)
        }

        searchableSpinnerCategory.onItemSelectListener = object : OnItemSelectListener {
            override fun setOnItemSelectListener(position: Int, selectedCatName: String) {
                //Toast.makeText(requireActivity(), "${searchableSpinnerCountry.selectedItem}  ${searchableSpinnerCountry.selectedItemPosition}", Toast.LENGTH_SHORT).show()
                tvBusinessCategoryCreate.text = selectedCatName
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
                tvBusinessSubcategoryCreate.text = selectedSubCatName
                for (i in subCatDataList?.indices!!) {
                    val subCatName = subCatDataList!![i].name
                    if (selectedSubCatName.contentEquals(subCatName)) {
                        selectedSubcatId = subCatDataList!![i].id
                        //CommonUtil.successToast("Test", "Subcat ID: $selectedSubcatId", requireActivity())
                    }
                }

            }
        }
    }

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
        etAboutUsPageCreate = view.findViewById(R.id.etAboutUsPageCreate)
        btnCreateBusinessData = view.findViewById(R.id.btnCreateBusinessList)

        searchableSpinnerCategory = SearchableSpinner(requireActivity())
        searchableSpinnerCategory.windowTitle = "Select/Search Category"

        searchableSpinnerSubcategory = SearchableSpinner(requireActivity())
        searchableSpinnerSubcategory.windowTitle = "Select/Search Subcategory"

        var businessName = etBusinessNameCreate.getText().toString()
        val arr: List<String> = businessName.split(" ")

        val firstWord = arr[0] //the

        Log.e("first_word------", firstWord.toString())

        callCategoryApi()
    }

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
                            if (tvBusinessCategoryCreate.text.contentEquals(catName)) {
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
            val userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            val bName = etBusinessNameCreate.text.toString().trim()
            val bEmail = etEmailCreate.text.toString().trim()
            val bWebUrl = etWebUrlCreate.text.toString().trim()
            val bSellerUrl = etSellerUrlCreate.text.toString().trim()
            val bAboutUs = etAboutUsPageCreate.text.toString().trim()

            val rbUserID: RequestBody = if (userID!!.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), userID) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbSelectedCatID: RequestBody = if (selectedCatId.toString().isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), selectedCatId.toString()) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbSelectedSubCatID: RequestBody = if (selectedSubCatId.toString().isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), selectedSubCatId.toString()) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbName: RequestBody = if (bName.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), bName) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbMail: RequestBody = if (bEmail.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), bEmail) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbWebUrl: RequestBody = if (bWebUrl.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), bWebUrl) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbAboutUs: RequestBody = if (bAboutUs.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), bAboutUs) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")

            if (CommonUtil.checkNetwork(mContext)) {
                val apiServices = GbusinessService.create(mContext)
                apiServices.createBusinessListData("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),
                    rbUserID, rbName,filePhotoLogo!!, rbMail, null!!, null!! , rbWebUrl,  rbSelectedCatID, rbSelectedSubCatID,null!!, null!!, null!!,
                    null!!, null!!, null!!, null!!, null!!, null!!,null!!, rbAboutUs)
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

    private fun validate(): Boolean {
        val bName = etBusinessNameCreate.text.toString().trim()
        val bEmail = etEmailCreate.text.toString().trim()
        val bCat = tvBusinessCategoryCreate.text.toString().trim()
        val bSubCat = tvBusinessSubcategoryCreate.text.toString().trim()
        val bUrl = etWebUrlCreate.text.toString().trim()
        val bAboutUs = etAboutUsPageCreate.text.toString().trim()
        when {

            CommonUtil.isUriEmpty(mBusinessLogoImageUri)->{
                CommonUtil.warningToast("Upload Business Logo","Please upload business logo first.",requireActivity())
                return false
            }

            TextUtils.isEmpty(bName) -> {
                etBusinessNameCreate.error = "Business name field can't be blank."
                etBusinessNameCreate.requestFocus()
                return false
            }

            TextUtils.isEmpty(bCat) -> {
                tvBusinessCategoryCreate.requestFocus()
                //tvBusinessCategoryCreate.error = "Please Select business category"
                CommonUtil.warningToast("Category Warning","Please Select business category",requireActivity())
                return false
            }

            TextUtils.isEmpty(bSubCat) -> {
                tvBusinessSubcategoryCreate.requestFocus()
                CommonUtil.warningToast("Subcategory Warning", "Please Select business subcategory", requireActivity())
                //tvBusinessSubcategoryCreate.error = ""
                return false
            }

            TextUtils.isEmpty(bEmail) -> {
                etEmailCreate.error = "Email field can't be blank."
                etEmailCreate.requestFocus()
                return false
            }

            CommonUtil.isValidMail(bEmail) -> {
                etEmailCreate.error = "Please enter valid mail."
                etEmailCreate.requestFocus()
                return false
            }

            TextUtils.isEmpty(bUrl) -> {
                etWebUrlCreate.error = "Web url field can't be blank."
                etWebUrlCreate.requestFocus()
                return false
            }

            /*CommonUtil.isValidUrl(bUrl)->{
                etWebUrlCreate.error = "Please enter valid web url."
                etWebUrlCreate.requestFocus()
                return false
            }*/

            TextUtils.isEmpty(bAboutUs) -> {
                etAboutUsPageCreate.error = "About us field can't be blank."
                etAboutUsPageCreate.requestFocus()
                return false
            }

            else -> return true
        }
    }
}