package com.milkyway.gbusiness.fragments


import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.speech.RecognizerIntent
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.drjacky.imagepicker.ImagePicker
import com.leo.searchablespinner.SearchableSpinner
import com.leo.searchablespinner.interfaces.OnItemSelectListener
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.adaptor.SupportFragmentAdapter
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.DataXXXXXXXXXXXXXXX
import com.milkyway.gbusiness.models.IssueSpinnerResponse
import com.milkyway.gbusiness.models.UserQueryListDataClass
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.global.CommonUtil
import com.milkyway.gbusiness.global.FileUtils
import kotlinx.android.synthetic.main.dlg_get_quote.view.ivCancel
import kotlinx.android.synthetic.main.dlg_new_ticket.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.util.*

class SupportFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var mContext: Context
    private lateinit var adapters: SupportFragmentAdapter
    private lateinit var mySupportBack: ImageView
    private lateinit var btnAddTicket: AppCompatButton
    private lateinit var array: List<DataXXXXXXXXXXXXXXX>
    private lateinit var searchableSpinnerIssue: SearchableSpinner

    private lateinit var issueList: List<IssueSpinnerResponse.Data>

    private lateinit var mView: View
    lateinit var itemSelected: String
    private var mBusinessLogoImageUri: Uri? = null

    private lateinit var etSearch: AppCompatEditText
    private lateinit var noSearchResultsFoundText: TextView
    private lateinit var searchEditText: TextView
    private lateinit var clearQueryImageView: ImageView
    private lateinit var voiceSearchImageView: ImageView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View? {

        val view = inflater.inflate(R.layout.fragment_support, container, false)
        initializeViews(view)
        setClickListener(view)
        return view
    }

    private fun setClickListener(view: View) {
        btnAddTicket.setOnClickListener {
            //alertAddTicketPopup()
            findNavController().navigate(R.id.action_supportFragment_to_addTicketFragment)
        }

        mySupportBack.setOnClickListener {
            findNavController().navigate(R.id.action_supportFragment_to_mainFragment)
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
            startActivityForResult(intent, AppConstants.SPEECH_REQUEST_CODE)
        }

        clearQueryImageView.setOnClickListener {
            etSearch.setText("")
            setSupportListAdapter(array)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun alertAddTicketPopup() {
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
            mView = mInflater.inflate(R.layout.dlg_new_ticket, null, false)

            mView.fsvIssue.setOnClickListener {
                searchableSpinnerIssue.show()
            }

            mView.tvUploadScreenshot.setOnClickListener {
                pickScreenShot(view)
            }

            searchableSpinnerIssue.onItemSelectListener = object : OnItemSelectListener {
                override fun setOnItemSelectListener(position: Int, selectedIssueName: String) {
                    //Toast.makeText(requireActivity(), "${searchableSpinnerCountry.selectedItem}  ${searchableSpinnerCountry.selectedItemPosition}", Toast.LENGTH_SHORT).show()
                    mView.tvIssue.text = selectedIssueName
                    for (i in issueList?.indices!!) {
                        val countryName = issueList!![i].name
                        if (selectedIssueName.contentEquals(countryName)) {
                            val selectedIssueId = issueList!![i].id
                            //CommonUtil.successToast("Test","$selectedIssueId",requireActivity())
                        }
                    }
                }
            }

            setUploadStr(mView.tvUploadScreenshot)


            val finalDialog: Dialog = dialog
            mView.btnSubmitTicket.setOnClickListener {

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

    private fun setUploadStr(tvUploadScreenshot: TextView?) {
        if (mBusinessLogoImageUri != null) {
            val file: File = FileUtils.getFile(requireActivity(), mBusinessLogoImageUri)
            tvUploadScreenshot?.text = file.name
        } else {
            tvUploadScreenshot?.text = "No file chosen yet."
        }
    }

    private fun pickScreenShot(view: View?) {
        ImagePicker.with(requireActivity())
            .crop()
            .cropOval()
            .maxResultSize(512, 512, true)
            .createIntentFromDialog { logoImageLauncher.launch(it) }
    }

    private val logoImageLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                val uri = it.data?.data!!
                mBusinessLogoImageUri = uri
                //ivBusinessLogoCreate.setLocalImage(uri, true)
            } else parseError(it)
        }

    private fun parseError(activityResult: ActivityResult) {
        if (activityResult.resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(requireActivity(), ImagePicker.getError(activityResult.data), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireActivity(), "Task Cancelled", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initializeViews(view: View) {
        mySupportBack = view.findViewById(R.id.mySupportBack)
        recyclerView = view.findViewById(R.id.supportRecyclerView)
        btnAddTicket = view.findViewById(R.id.btnAddTicket)

        etSearch = view.findViewById(R.id.search_edit_text)
        noSearchResultsFoundText = view.findViewById(R.id.no_search_results_found_text)
        clearQueryImageView = view.findViewById(R.id.clear_search_query)
        voiceSearchImageView = view.findViewById(R.id.voice_search_query)
        searchEditText = view.findViewById(R.id.search_edit_text)
        searchEditText.hint = "Search Here...."

        searchableSpinnerIssue = SearchableSpinner(requireActivity())
        searchableSpinnerIssue.windowTitle = "Select/Search Issues"

        array = ArrayList()

        getIssueListAPI()
        getIssueSpinnerListApi()
    }


    private fun getIssueSpinnerListApi() {
        if (CommonUtil.checkNetwork(mContext)) {

            val apiServices = GbusinessService.create(mContext)

            apiServices.getIssueSpinnerList()
                .enqueue(object : Callback<IssueSpinnerResponse> {
                    override fun onFailure(call: Call<IssueSpinnerResponse>, t: Throwable) {

                        CommonUtil.toast(R.string.showError.toString(), mContext)
                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(
                        call: Call<IssueSpinnerResponse>,
                        response: Response<IssueSpinnerResponse>,
                    ) {

                        // Log.i("TAGad", response.body()?.success.toString())
                        val getData = response.body()
                        CommonUtil.logi(getData.toString())
                        if (getData != null) {

                            if (getData.success) {

                                if (getData.data.isNotEmpty()) {
                                    issueList = getData.data
                                    searchableSpinnerIssue.setSpinnerListItems(loadIssueNameList(issueList))

                                }

                            } else if (getData.message != null) CommonUtil.toast(getData.message, mContext)
                        } else CommonUtil.toast(R.string.showError.toString(), mContext)
                    }

                })
        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }

    private fun loadIssueNameList(issueArrayList: List<IssueSpinnerResponse.Data>): ArrayList<String> {
        val issueList = ArrayList<String>()
        if (!issueArrayList.isNullOrEmpty()) {
            for (list in issueArrayList) {
                val name = list.name
                issueList.add(name)
            }
        }
        return issueList
    }

    private fun getIssueListAPI() {
        if (CommonUtil.checkNetwork(mContext)) {

            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)


            val apiServices = GbusinessService.create(mContext)

            if (userID != null) {
                CommonUtil.showDialog(mContext)
                apiServices.getSupportedQuery(
                    "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),
                    "application/json",
                    userID)
                    .enqueue(object : Callback<UserQueryListDataClass> {
                        override fun onFailure(call: Call<UserQueryListDataClass>, t: Throwable) {

                            CommonUtil.hideDialog(mContext)
                            CommonUtil.toast(R.string.showError.toString(), mContext)
                            CommonUtil.logi(t.localizedMessage.toString())
                        }

                        override fun onResponse(
                            call: Call<UserQueryListDataClass>,
                            response: Response<UserQueryListDataClass>,
                        ) {
                            CommonUtil.hideDialog(mContext)

                            // Log.i("TAGad", response.body()?.success.toString())
                            val getData = response.body()
                            CommonUtil.logi(getData.toString())
                            if (getData != null) {
                                if (response.code() == 200) {
                                    array = getData.data
                                    if (getData.success) {
                                        setSupportListAdapter(array)
                                        noSearchResultsFoundText.visibility = View.INVISIBLE
                                    } else if (!getData.success) {
                                        noSearchResultsFoundText.text = "Sorry! No ticket found."
                                        noSearchResultsFoundText.visibility = View.VISIBLE
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

    private fun setSupportListAdapter(array: List<DataXXXXXXXXXXXXXXX>) {
        recyclerView.hasFixedSize()
        recyclerView.layoutManager = LinearLayoutManager(mContext)
        adapters = SupportFragmentAdapter(requireActivity(), array)
        recyclerView.adapter = adapters
    }

    private fun filterWithQuery(query: String) {
        if (query.isNotEmpty()) {
            val filteredList: List<DataXXXXXXXXXXXXXXX> = onFilterChanged(query)
            //attachAdapter(filteredList)
            setSupportListAdapter(filteredList)
            toggleRecyclerView(filteredList)
        } else if (query.isEmpty()) {
            //attachAdapter(sportsList)
            setSupportListAdapter(array)
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

    private fun toggleRecyclerView(catList: List<DataXXXXXXXXXXXXXXX>) {
        if (catList.isEmpty()) {
            recyclerView.visibility = View.INVISIBLE
            noSearchResultsFoundText.visibility = View.VISIBLE
        } else {
            recyclerView.visibility = View.VISIBLE
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

    private fun onFilterChanged(filterQuery: String): List<DataXXXXXXXXXXXXXXX> {
        val filteredList = java.util.ArrayList<DataXXXXXXXXXXXXXXX>()
        for (searchList in array) {
            if (searchList.issue_type.lowercase().contains(filterQuery) ||
                searchList.domain_name.lowercase().contains(filterQuery) ||
                searchList.cdate.lowercase().contains(filterQuery)
            ) {
                filteredList.add(searchList)
            }
        }
        return filteredList
    }

    /*override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        itemSelected = issueList[position].name
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }*/

}
