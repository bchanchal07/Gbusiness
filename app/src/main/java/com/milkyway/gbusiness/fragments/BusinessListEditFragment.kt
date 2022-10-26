package com.milkyway.gbusiness.fragments

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.github.drjacky.imagepicker.ImagePicker
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.leo.searchablespinner.SearchableSpinner
import com.leo.searchablespinner.interfaces.OnItemSelectListener
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.activities.MainActivity
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.BusinessListEditResponse
import com.milkyway.gbusiness.models.BusinessListingResponse
import com.milkyway.gbusiness.models.CategoryDataClass
import com.milkyway.gbusiness.models.SubCategoryDataClass
import com.milkyway.gbusiness.extension.setLocalImage
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.utils.CommonUtil
import com.milkyway.gbusiness.utils.FileUtils
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
class BusinessListEditFragment : Fragment() {

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
    private lateinit var listData: BusinessListingResponse.Data
    private lateinit var searchableSpinnerCategory: SearchableSpinner
    private lateinit var searchableSpinnerSubcategory: SearchableSpinner
    private lateinit var categoryDataList: List<CategoryDataClass.Data>
    private lateinit var subCatDataList: List<SubCategoryDataClass.Subcategory>
    private var selectedCatId: Int = 0
    private var selectedSubcatId: Int = 0
    private var chooseCatID: Int = 0
    private var chooseSubCatID: Int = 0
    private lateinit var encodedString: String
    private lateinit var mBottomSheetDialog: BottomSheetDialog
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
    }

    private val logoImageLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
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
            val defaultUrl = "${GbusinessService.BASE_IMG_URL}${listData.businessLogo}"
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

        searchableSpinnerCategory = SearchableSpinner(requireActivity())
        searchableSpinnerCategory.windowTitle = "Select/Search Category"

        searchableSpinnerSubcategory = SearchableSpinner(requireActivity())
        searchableSpinnerSubcategory.windowTitle = "Select/Search Subcategory"

        val args = arguments ?: return
        listData = args.getSerializable("list") as BusinessListingResponse.Data
        setDefaultData(listData)
        callCategoryApi()
        //callSubcategoryApi(selectedCatId)
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
                                } else {
                                    tvBusinessSubcategoryUpdate.text = ""
                                    tvBusinessSubcategoryUpdate.hint = "Select Subcategory"
                                }
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

    private fun setDefaultData(listData: BusinessListingResponse.Data) {
        fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)
        etBusinessNameUpdate.text = listData.businessName.toEditable()
        etEmailUpdate.text = listData.businessEmail.toEditable()
        etWebUrlUpdate.text = listData.businessWebUrl.toEditable()
        etAboutUsPageUpdate.text = listData.businessAboutUs.toEditable()
        tvBusinessCategoryUpdate.text = listData.catname
        tvBusinessSubcategoryUpdate.text = listData.subcatname

        if (listData.businessLogo != null) {
            val urlLogo = GbusinessService.BASE_IMG_URL + listData.businessLogo

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

    private fun validate(): Boolean {
        val bName = etBusinessNameUpdate.text.toString().trim()
        val bEmail = etEmailUpdate.text.toString().trim()
        val bCat = tvBusinessCategoryUpdate.text.toString().trim()
        val bSubCat = tvBusinessSubcategoryUpdate.text.toString().trim()
        val bUrl = etWebUrlUpdate.text.toString().trim()
        val bAboutUs = etAboutUsPageUpdate.text.toString().trim()
        when {

            /*CommonUtil.isUriEmpty(mBusinessLogoImageUri) -> {
                CommonUtil.warningToast("Upload Business Logo", "Please upload business logo first.", requireActivity())
                return false
            }*/

            TextUtils.isEmpty(bName) -> {
                etBusinessNameUpdate.error = "Business name field can't be blank."
                etBusinessNameUpdate.requestFocus()
                return false
            }

            TextUtils.isEmpty(bCat) -> {
                tvBusinessCategoryUpdate.requestFocus()
                //tvBusinessCategoryCreate.error = "Please Select business category"
                CommonUtil.warningToast("Category Warning", "Please Select business category", requireActivity())
                return false
            }

            TextUtils.isEmpty(bSubCat) -> {
                tvBusinessSubcategoryUpdate.requestFocus()
                CommonUtil.warningToast("Subcategory Warning", "Please Select business subcategory", requireActivity())
                //tvBusinessSubcategoryCreate.error = ""
                return false
            }

            tvBusinessCategoryUpdate.hint.contentEquals("Select Subcategory") -> {
                etEmailUpdate.error = "Email field can't be blank."
                etEmailUpdate.requestFocus()
                return false
            }


            TextUtils.isEmpty(bEmail) -> {
                etEmailUpdate.error = "Email field can't be blank."
                etEmailUpdate.requestFocus()
                return false
            }

            CommonUtil.isValidMail(bEmail) -> {
                etEmailUpdate.error = "Please enter valid mail."
                etEmailUpdate.requestFocus()
                return false
            }

            TextUtils.isEmpty(bUrl) -> {
                etWebUrlUpdate.error = "Web url field can't be blank."
                etWebUrlUpdate.requestFocus()
                return false
            }

            /*CommonUtil.isValidUrl(bUrl) -> {
                etWebUrlUpdate.error = "Please enter valid web url."
                etWebUrlUpdate.requestFocus()
                return false
            }*/

            TextUtils.isEmpty(bAboutUs) -> {
                etAboutUsPageUpdate.error = "About us field can't be blank."
                etAboutUsPageUpdate.requestFocus()
                return false
            }

            else -> return true
        }
    }
}