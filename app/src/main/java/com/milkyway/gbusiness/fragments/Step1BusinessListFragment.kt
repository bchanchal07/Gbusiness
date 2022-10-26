package com.milkyway.gbusiness.fragments

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.os.Bundle
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
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.drjacky.imagepicker.ImagePicker
import com.google.gson.Gson
import com.milkyway.gbusiness.models.BusinessListStepOneModel
import com.milkyway.gbusiness.models.OtpErrorModel
import com.milkyway.gbusiness.models.StepOneItemListsModel
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.activities.MainActivity
import com.milkyway.gbusiness.adaptor.Step_1_BusinessListItemsAdpater
import com.milkyway.gbusiness.extension.setLocalImage
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.utils.CommonUtil
import com.milkyway.gbusiness.utils.FileUtils
import dev.mortezaom.mdtoast.MDToast
import id.ionbit.ionalert.IonAlert
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

class Step1BusinessListFragment : Fragment(), Step_1_BusinessListItemsAdpater.UpdateBtnListener, Step_1_BusinessListItemsAdpater.DeleteBtnListener {
    lateinit var mContext: Context
    private lateinit var editBusinessListingBack: ImageView
    private lateinit var ivImageSelect: ImageView
    private lateinit var ivBusinessPaymentView: ImageView
    private lateinit var et_payment_tilte: EditText
    private lateinit var et_payment_email: EditText
    private lateinit var et_payment_url: EditText
    private lateinit var et_payment_bank_detail: EditText
    private lateinit var tv_blank: TextView
    private lateinit var btn_submit_step_1: AppCompatButton
    var fileUri: Uri? = null
    lateinit var businessListStepOneModel_gl: BusinessListStepOneModel
    lateinit var ll_show_list: LinearLayout
    lateinit var ll_hide_list: LinearLayout
    lateinit var rv_item_list: RecyclerView
    lateinit var iv_down_arrow: ImageView
    lateinit var iv_up_arrow: ImageView
    lateinit var card_view_show_list: CardView
    lateinit var card_view_hide_list: CardView
    var pos: Boolean = false
    lateinit var step1Businesslistitemsadpater: Step_1_BusinessListItemsAdpater
    lateinit var linearLayoutManager: LinearLayoutManager

    //todo fragment constructor calling for view this fragment... else #fragmentInstantiateException..
    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = Step1BusinessListFragment().apply {}
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_step_1_business_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView(view)

    }

    //todo id's initialization..
    private fun initView(view: View) {
        editBusinessListingBack = view.findViewById(R.id.editBusinessListingBack)
        ivImageSelect = view.findViewById(R.id.ivImageSelect)
        ivBusinessPaymentView = view.findViewById(R.id.ivBusinessPaymentView)
        et_payment_tilte = view.findViewById(R.id.et_payment_tilte)
        et_payment_email = view.findViewById(R.id.et_payment_email)
        et_payment_url = view.findViewById(R.id.et_payment_url)
        et_payment_bank_detail = view.findViewById(R.id.et_payment_bank_detail)
        btn_submit_step_1 = view.findViewById(R.id.btn_submit_step_1)
        ll_show_list = view.findViewById(R.id.ll_show_list)
        ll_hide_list = view.findViewById(R.id.ll_hide_list)
        rv_item_list = view.findViewById(R.id.rv_item_list)
        iv_down_arrow = view.findViewById(R.id.iv_down_arrow)
        iv_up_arrow = view.findViewById(R.id.iv_up_arrow)
        card_view_show_list = view.findViewById(R.id.card_view_show_list)
        card_view_hide_list = view.findViewById(R.id.card_view_hide_list)
        tv_blank = view.findViewById(R.id.tv_blank)


        editBusinessListingBack.setOnClickListener {
            try {
                MainActivity.navController.navigate(R.id.action_stepOneFragment_to_myBusinessListFragment)
               /* var bundle = Bundle()
                var businessListFragment = BusinessListFragment()
                businessListFragment.arguments = bundle
                CommonUtil.loadFragmentsWithBackStack(requireActivity(), businessListFragment, "back_stack")*/
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        //todo select image from gallery..
        ivImageSelect.setOnClickListener {
            pickBusinessLogo(view)
        }

        //todo submit step - 1 details..
        btn_submit_step_1.setOnClickListener {
            addBusinessStepOneList()
        }

        card_view_show_list.setOnClickListener {
            card_view_show_list.visibility = View.GONE
            card_view_hide_list.visibility = View.VISIBLE
            rv_item_list.visibility = View.VISIBLE
            getBusinessItemsList()
        }
        card_view_hide_list.setOnClickListener {
            card_view_hide_list.visibility = View.GONE
            card_view_show_list.visibility = View.VISIBLE
            rv_item_list.visibility = View.VISIBLE
            itemAdapterBind(ArrayList())
            tv_blank.visibility = View.GONE
        }

    }

    //todo submit step - 1 payment details...
    private fun addBusinessStepOneList() {
        var filePaymentImage: MultipartBody.Part? = null
        if (fileUri != null) {
            try {
                val file: File = FileUtils.getFile(requireActivity(), fileUri)
                if (file.exists()) {
                    val requestBody: RequestBody = RequestBody.create("*/*".toMediaTypeOrNull(), file)
                    filePaymentImage = MultipartBody.Part.createFormData("pmethod_image", file.name, requestBody)
                }
            } catch (e: NullPointerException) {
                e.printStackTrace()
            }
        } else {
            val attachmentEmpty = RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            filePaymentImage = MultipartBody.Part.createFormData("pmethod_image", "", attachmentEmpty)
        }

        var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
        var businessID = CommonUtil.getIntPreferences(mContext, AppConstants.BUSINESS_ID)
        val requestUserID: RequestBody = if (userID!!.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), userID) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
        val requestBusinessID: RequestBody = if (businessID!! != null) RequestBody.create("text/plain".toMediaTypeOrNull(), businessID.toString()) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
        if (et_payment_tilte.text.toString().isNullOrEmpty()) {
            MDToast.makeText(mContext, "The title field is required", MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR).show()
        } else if (et_payment_url.text.toString().isNullOrEmpty()) {
            MDToast.makeText(mContext, "Payment Url field is required", MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR).show()
        } else if (et_payment_bank_detail.text.toString().isNullOrEmpty()) {
            MDToast.makeText(mContext, "The Bank detail field is required", MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR).show()
        }
        else {
            var requestPaymentTitle: RequestBody = RequestBody.create("multipart/form-data".toMediaTypeOrNull(), et_payment_tilte.text.toString())
            var requestPaymentEmail: RequestBody = RequestBody.create("multipart/form-data".toMediaTypeOrNull(), et_payment_email.text.toString())
            var requestPaymentURL: RequestBody = RequestBody.create("multipart/form-data".toMediaTypeOrNull(), et_payment_url.text.toString())
            var requestPaymentBankDetail: RequestBody = RequestBody.create("multipart/form-data".toMediaTypeOrNull(), et_payment_bank_detail.text.toString())

            if (CommonUtil.checkNetwork(mContext)) {
                CommonUtil.showDialog(mContext)
                val apiServices = GbusinessService.create(mContext)
                if (userID != null) {
                    apiServices.addBusinessListingStepOne("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), requestUserID, requestPaymentTitle,
                        requestPaymentEmail, requestPaymentURL, requestPaymentBankDetail, requestBusinessID, filePaymentImage!!).apply {
                        enqueue(object : Callback<BusinessListStepOneModel> {
                            override fun onResponse(call: Call<BusinessListStepOneModel>, response: Response<BusinessListStepOneModel>) {
                                try {
                                    if (response.isSuccessful) {
                                        CommonUtil.hideDialog(mContext)
                                        businessListStepOneModel_gl = response.body()!!
                                        if (businessListStepOneModel_gl.success && businessListStepOneModel_gl != null) {
                                            MDToast.makeText(requireActivity(), businessListStepOneModel_gl.message, MDToast.LENGTH_SHORT, MDToast.TYPE_SUCCESS).show()
                                            MainActivity.navController.navigate(R.id.action_stepOneFragment_to_myBusinessListFragment)
                                            clearAllTextField()
                                        } else {
                                            MDToast.makeText(requireActivity(), businessListStepOneModel_gl.error.email.toString(), MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR).show()
                                        }

                                    } else {
                                        CommonUtil.hideDialog(mContext)
                                        val gson = Gson()
                                        val message: OtpErrorModel = gson.fromJson(
                                            response.errorBody()!!.charStream(),
                                            OtpErrorModel::class.java
                                        )
                                        if (message.message != null) {
                                            MDToast.makeText(requireActivity(), businessListStepOneModel_gl.message, MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR).show()
                                            Log.e("error---------", message.message)
                                        }
                                    }

                                } catch (e: Exception) {
                                    e.printStackTrace()
                                    CommonUtil.hideDialog(mContext)
                                }
                            }

                            override fun onFailure(call: Call<BusinessListStepOneModel>, t: Throwable) {
                                CommonUtil.hideDialog(mContext)
                                CommonUtil.toast(R.string.showError.toString(), mContext)
                                CommonUtil.logi(t.localizedMessage.toString())
                            }

                        })
                    }
                }

            } else {
                CommonUtil.toast("Check Internet", mContext)
            }
        }

    }

    private fun clearAllTextField() {
        et_payment_tilte.setText("")
        et_payment_email.setText("")
        et_payment_url.setText("")
        et_payment_bank_detail.setText("")
        ivBusinessPaymentView.setImageResource(R.drawable.img_not_available)
    }

    //todo get business item lists..
    private fun getBusinessItemsList() {
        if (CommonUtil.checkNetwork(mContext)) {
            var business_id = CommonUtil.getIntPreferences(mContext, AppConstants.BUSINESS_ID)
            Log.e("business_id", business_id.toString())
            var token = CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN)
            CommonUtil.showDialog(mContext)
            val apiServices = GbusinessService.create(mContext)
            apiServices.getBusinessStepOneItemList("Bearer $token", business_id.toString()).apply {
                enqueue(object : Callback<StepOneItemListsModel> {
                    override fun onResponse(
                        call: Call<StepOneItemListsModel>,
                        response: Response<StepOneItemListsModel>,
                    ) {
                        try {
                            var itemModelResponse: StepOneItemListsModel? = null
                            if (response.isSuccessful) {
                                Log.e("response_api", response.body().toString())
                                CommonUtil.hideDialog(mContext)
                                itemModelResponse = response.body()!!
                                Log.i("itemModelResponse", itemModelResponse.toString())
                                if (itemModelResponse != null && itemModelResponse.success) {
                                    var stepOneItemList_gl: List<StepOneItemListsModel.BusinessItemsList> = itemModelResponse.data
                                    itemAdapterBind(stepOneItemList_gl)
                                } else {
                                    itemAdapterBind(ArrayList())
                                    tv_blank.visibility = View.VISIBLE
                                }
                            } else {
                                if (itemModelResponse?.success == false) {
                                    MDToast.makeText(requireActivity(), "No Item Found.", MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR).show()
                                }
                                CommonUtil.hideDialog(mContext)
                                val gson = Gson()
                                val message: OtpErrorModel = gson.fromJson(
                                    response.errorBody()!!.charStream(),
                                    OtpErrorModel::class.java
                                )
                                if (message.message != null) {
                                    MDToast.makeText(requireActivity(), response.message(), MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR).show()
                                    Log.e("error---------", message.message)
                                }
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }

                    }

                    override fun onFailure(call: Call<StepOneItemListsModel>, t: Throwable) {
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

    //todo bind adapter..
    fun itemAdapterBind(itemList: List<StepOneItemListsModel.BusinessItemsList>) {
        step1Businesslistitemsadpater = Step_1_BusinessListItemsAdpater(mContext, itemList, this, this)
        linearLayoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        rv_item_list.layoutManager = linearLayoutManager
        rv_item_list.adapter = step1Businesslistitemsadpater
    }

    //todo update item list...
    override fun updateClickListener(position: Int, stepOneBusinessList: StepOneItemListsModel.BusinessItemsList) {
        var bundle = Bundle()
        bundle.putString("id", stepOneBusinessList.id)
        bundle.putSerializable("step_one_item_list", stepOneBusinessList)
        try {
            findNavController().navigate(R.id.action_stepOneFragment_to_updateStepOneFragment, bundle)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    //todo item delete api calling here...
    override fun deleteClickListener(position: Int, stepOneBusinessList: List<StepOneItemListsModel.BusinessItemsList>) {
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
                callDeleteStepOneListItemApi(position, stepOneBusinessList)
            }
            .show()
    }

    private fun callDeleteStepOneListItemApi(position: Int, stepOneBusinessList: List<StepOneItemListsModel.BusinessItemsList>) {
        if (CommonUtil.checkNetwork(mContext)) {
            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)
            val apiServices = GbusinessService.create(mContext)
            if (userID != null) {
                apiServices.deleteStepOneItems("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), stepOneBusinessList[position].id
                ).enqueue(object : Callback<StepOneItemListsModel> {
                    override fun onResponse(
                        call: Call<StepOneItemListsModel>,
                        response: Response<StepOneItemListsModel>,
                    ) {
                        CommonUtil.hideDialog(mContext)
                        val getData = response?.body()
                        Log.i("TAG", getData.toString())
                        if (getData != null) {
                            if (getData.success) {
                                getBusinessItemsList()
                                val ionAlert = IonAlert(requireActivity(), IonAlert.SUCCESS_TYPE)
                                ionAlert.titleText = "Delete Success!"
                                ionAlert.contentText = getData.message
                                ionAlert.show()
                            }
                        } else MDToast.makeText(requireActivity(), getData?.message, MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR).show()
                    }

                    override fun onFailure(call: Call<StepOneItemListsModel>, t: Throwable) {
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


    //todo set image choose code here...
    private val logoImageLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            val uri = it.data?.data!!
            fileUri = uri
            ivBusinessPaymentView.setLocalImage(uri, true)
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


}