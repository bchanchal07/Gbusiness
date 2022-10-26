package com.milkyway.gbusiness.fragments

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.speech.RecognizerIntent
import android.text.TextUtils
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.activities.MainActivity
import com.milkyway.gbusiness.adaptor.BusinessCatDetailsAdaptor
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.BusinessEnqErrorResponse
import com.milkyway.gbusiness.models.BusinessEnquiryResponse
import com.milkyway.gbusiness.models.CategoryDataDetailsClass
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.retrofit.AppConstants.SPEECH_REQUEST_CODE
import com.milkyway.gbusiness.utils.CommonUtil
import id.ionbit.ionalert.IonAlert
import kotlinx.android.synthetic.main.dlg_error_msg.view.*
import kotlinx.android.synthetic.main.dlg_get_quote.view.*
import kotlinx.android.synthetic.main.fragment_business_cat_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

class BusinessCatDetailsFragment : Fragment(), BusinessCatDetailsAdaptor.OnCatDetailAdaptorClick {
    lateinit var mContext: Context
    lateinit var catDataDetailResponse: CategoryDataDetailsClass
    private lateinit var rvCategoryData: RecyclerView
    private lateinit var myBusinessCatDetailsBack: ImageView

    private lateinit var etSearch: AppCompatEditText
    private lateinit var noSearchResultsFoundText: TextView
    private lateinit var catDataList: List<CategoryDataDetailsClass.Data.TemplateDetail>
    private lateinit var clearQueryImageView: ImageView
    private lateinit var voiceSearchImageView: ImageView
    private lateinit var name: String
    private lateinit var email: String
    private lateinit var phone: String
    private lateinit var query: String
    private lateinit var mView: View
    private lateinit var mViewError: View


    /* private var catDataList= List<CategoryDataDetailsClass.Data.TemplateDetail>()
     private var matchedDataList= List<CategoryDataDetailsClass.Data.TemplateDetail>()*/
    private var subCatId: Int = 0
    private var catId: Int = 0
    private var catName: String = ""
    private var imgUrl: String = ""

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = arguments ?: return
        //position = args!!.getInt("position", 0)
        if (args != null) {
            subCatId = args.getInt("sub_cat_id", 0)
            catId = args.getInt("cat_id", 0)
            catName = args.getString("cat_name", "")
            imgUrl = args.getString("img_url", "")

            if (subCatId > 0) {
                getCategoryDetailsApi(subCatId)
            } else {
                getCategoryDetailsApi(CommonUtil.getIntPreferences(mContext, AppConstants.SUB_CAT_ID))
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_business_cat_details, container, false)
        initializeView(view)

        return view
    }


    private fun initializeView(view: View) {
        rvCategoryData = view.findViewById(R.id.rvBusinessCatDetails)
        myBusinessCatDetailsBack = view.findViewById(R.id.myBusinessCatDetailsBack)

        etSearch = view.findViewById(R.id.search_edit_text)
        noSearchResultsFoundText = view.findViewById(R.id.no_search_results_found_text)
        clearQueryImageView = view.findViewById(R.id.clear_search_query)
        voiceSearchImageView = view.findViewById(R.id.voice_search_query)
        etSearch.hint = "Search business directory"
        myBusinessCatDetailsBack.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("sub_cat_id_back", subCatId)
            bundle.putInt("cat_id_back", catId)
            bundle.putString("cat_name_back", catName)
            bundle.putString("img_url_back", imgUrl)
            MainActivity.navController.navigate(R.id.action_myCatDetailsFragment_to_mySubCategoryFragment, bundle)
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
        }

    }

    private fun filterWithQuery(query: String) {
        if (query.isNotEmpty()) {
            val filteredList: List<CategoryDataDetailsClass.Data.TemplateDetail> = onFilterChanged(query)
            //attachAdapter(filteredList)
            setCategoryDataAdaptor(filteredList)
            toggleRecyclerView(filteredList)
        } else if (query.isEmpty()) {
            //attachAdapter(sportsList)
            setCategoryDataAdaptor(catDataList)
        }
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

    private fun toggleRecyclerView(sportsList: List<CategoryDataDetailsClass.Data.TemplateDetail>) {
        if (sportsList.isEmpty()) {
            rvBusinessCatDetails.visibility = View.INVISIBLE
            noSearchResultsFoundText.visibility = View.VISIBLE
        } else {
            rvBusinessCatDetails.visibility = View.VISIBLE
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

    private fun onFilterChanged(filterQuery: String): List<CategoryDataDetailsClass.Data.TemplateDetail> {
        val filteredList = ArrayList<CategoryDataDetailsClass.Data.TemplateDetail>()
        for (searchList in catDataList) {
            if (searchList.domainName.contains(filterQuery)) {
                filteredList.add(searchList)
            }
        }
        return filteredList
    }

    private fun getCategoryDetailsApi(catId: Int?) {

        if (CommonUtil.checkNetwork(mContext)) {
            CommonUtil.showDialog(mContext)
            val dataNotic = GbusinessService.create(mContext)
            //if (userID != null) {
            dataNotic.getCategoryDetails(
                catId!!
            ).enqueue(object : Callback<CategoryDataDetailsClass> {
                override fun onResponse(call: Call<CategoryDataDetailsClass>, response: Response<CategoryDataDetailsClass>) {
                    CommonUtil.hideDialog(mContext)
                    // Log.i("TAGad", response.body()?.success.toString())
                    catDataDetailResponse = response.body()!!
                    if (catDataDetailResponse.code == 200) {
                        if (catDataDetailResponse.data != null) {

                            if (catDataDetailResponse.data.templateDetails.isNotEmpty()) {
                                catDataList = catDataDetailResponse.data.templateDetails
                                setCategoryDataAdaptor(catDataList)
                            } else {
                                Toast.makeText(requireActivity(), "Data is not available", Toast.LENGTH_SHORT).show()
                            }

                        }
                    } else if (catDataDetailResponse.code == 400) {

                        IonAlert(requireActivity(), IonAlert.WARNING_TYPE)
                            .setTitleText("Not Found!")
                            .setContentText("Data not found in this category")
                            .setConfirmText("Ok")
                            .setConfirmClickListener {
                                val bundle = Bundle()
                                bundle.putInt("cat_id_back", catId)
                                CommonUtil.saveIntPreferences(mContext, AppConstants.CAT_ID, catId)
                                bundle.putString("cat_name_back", catName)
                                bundle.putString("img_url_back", imgUrl)
                                MainActivity.navController.navigate(R.id.action_myCatDetailsFragment_to_mySubCategoryFragment)
                                it.dismissWithAnimation()
                            }
                            .show()
                    }
                }

                override fun onFailure(call: Call<CategoryDataDetailsClass>, t: Throwable) {
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

    private fun setCategoryDataAdaptor(catDataList: List<CategoryDataDetailsClass.Data.TemplateDetail>) {
        rvBusinessCatDetails.layoutManager = LinearLayoutManager(context)
        val adapter = BusinessCatDetailsAdaptor(requireActivity(), this, catDataList)
        // Setting the Adapter with the recyclerview
        rvCategoryData.adapter = adapter
    }

    override fun onItemClicked(position: Int) {
        //CommonUtil.toast("Clicked on item", mContext)
    }

    override fun onBtnClickedWebsite(pos: Int, list: CategoryDataDetailsClass.Data.TemplateDetail) {
        //CommonUtil.toast("Clicked on website button", mContext)
        val webUrl = "https://${list.domainName}.gbusiness.co"
        val bundle = Bundle()
        bundle.putString("back", "BusinessCatDetailsFragment")
        bundle.putString("webUrl", webUrl)
        bundle.putString("fromWhere", "BusinessCatDetailsFragment")
        view?.findNavController()
            ?.navigate(R.id.action_myCatDetailsFragment_to_paymentOrInvoiceWebView, bundle)
    }

    override fun onBtnClickedQuote(pos: Int, list: CategoryDataDetailsClass.Data.TemplateDetail) {
        //CommonUtil.toast("Clicked on quote button", mContext)
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

    private fun validate(): Boolean {
        when {
            TextUtils.isEmpty(name) -> {
                mView.etNamePopup.error = "Name field can't be blank."
                mView.etNamePopup.requestFocus()
                return false
            }

            TextUtils.isEmpty(email) -> {
                mView.etEmailPopup.error = "Email field can't be blank."
                mView.etEmailPopup.requestFocus()
                return false
            }

            isValidMail(email) -> {
                mView.etEmailPopup.error = "Please enter valid mail."
                mView.etEmailPopup.requestFocus()
                return false
            }

            TextUtils.isEmpty(phone) -> {
                mView.etContactPopup.error = "Mobile field can't be blank."
                mView.etContactPopup.requestFocus()
                return false
            }

            isValidMobile(phone) -> {
                mView.etContactPopup.error = "Please enter valid mobile having 10 digits."
                mView.etContactPopup.requestFocus()
                return false
            }

            TextUtils.isEmpty(query) -> {
                mView.etQueryPopup.error = "Query field can't be blank."
                mView.etQueryPopup.requestFocus()
                return false
            }

            query.length < 15 -> {
                mView.etQueryPopup.error = "Please enter minimum 15 characters."
                mView.etQueryPopup.requestFocus()
                return false
            }

            else -> return true
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

    private fun isValidMail(mail: String?): Boolean {
        val pattern: Pattern
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z0-9]+\\.+[a-z]+"
        pattern = Pattern.compile(emailPattern)
        val matcher: Matcher = pattern.matcher(mail)
        return !matcher.matches()
    }

    private fun isValidMobile(mobile: String?): Boolean {
        val pattern: Pattern
        val mobilePattern = "^[1-9][0-9]{9}$"
        pattern = Pattern.compile(mobilePattern)
        val matcher: Matcher = pattern.matcher(mobile)
        return !matcher.matches()
    }

    override fun onResume() {
        /*if (catId > 0) {
            getCategoryDetailsApi(catId)
        }*/
        super.onResume()
    }
}