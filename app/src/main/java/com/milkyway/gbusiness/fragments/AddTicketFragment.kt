package com.milkyway.gbusiness.fragments

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.os.Bundle
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
import androidx.navigation.fragment.findNavController
import com.github.drjacky.imagepicker.ImagePicker
import com.leo.searchablespinner.SearchableSpinner
import com.leo.searchablespinner.interfaces.OnItemSelectListener
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.activities.MainActivity
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.AddTicketResponse
import com.milkyway.gbusiness.models.IssueSpinnerResponse
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.global.CommonUtil
import com.milkyway.gbusiness.global.FileUtils
import kotlinx.android.synthetic.main.dlg_new_ticket.view.*
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
 * Use the [AddTicketFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddTicketFragment : Fragment() {
    private lateinit var mContext: Context
    private lateinit var myAddTicketBack: ImageView
    private lateinit var tvUploadScreenshot: TextView
    private lateinit var tvIssue: TextView
    private lateinit var etComment: EditText
    private lateinit var fsvIssue: FieldSetView
    private lateinit var btnSubmitTicket: AppCompatButton
    private lateinit var searchableSpinnerIssue: SearchableSpinner

    private lateinit var issueList: List<IssueSpinnerResponse.Data>
    private var selectedIssueId: Int = 0
    private var mScreenshotImageUri: Uri? = null

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
        val view = inflater.inflate(R.layout.fragment_add_ticket, container, false)
        initializeViews(view)
        setClickListener(view)
        return view
    }

    private fun initializeViews(view: View) {
        myAddTicketBack = view.findViewById(R.id.addTicketBack)
        btnSubmitTicket = view.findViewById(R.id.btnSubmitTicket)
        fsvIssue = view.findViewById(R.id.fsvIssueTicket)
        tvUploadScreenshot = view.findViewById(R.id.tvUploadScreenshotTicket)
        tvIssue = view.findViewById(R.id.tvIssueTicket)
        etComment = view.findViewById(R.id.etCommentTicket)
        searchableSpinnerIssue = SearchableSpinner(requireActivity())
        searchableSpinnerIssue.windowTitle = "Select/Search Issues"
        getIssueSpinnerListApi()
    }

    private fun setClickListener(view: View) {
        fsvIssue.setOnClickListener {
            searchableSpinnerIssue.show()
        }

        searchableSpinnerIssue.onItemSelectListener = object : OnItemSelectListener {
            override fun setOnItemSelectListener(position: Int, selectedIssueName: String) {
                //Toast.makeText(requireActivity(), "${searchableSpinnerCountry.selectedItem}  ${searchableSpinnerCountry.selectedItemPosition}", Toast.LENGTH_SHORT).show()
                tvIssue.text = selectedIssueName
                for (i in issueList?.indices!!) {
                    val countryName = issueList!![i].name
                    if (selectedIssueName.contentEquals(countryName)) {
                        selectedIssueId = issueList!![i].id
                        //CommonUtil.successToast("Test","$selectedIssueId",requireActivity())
                    }
                }
            }
        }

        tvUploadScreenshot.setOnClickListener {
            pickScreenShot(view)
        }
        btnSubmitTicket.setOnClickListener {
            if (validate()) {
                callAddTicketApi(mScreenshotImageUri, selectedIssueId)
                //Toast.makeText(requireActivity(), "Validate", Toast.LENGTH_LONG).show()
            }
        }

        myAddTicketBack.setOnClickListener {
            findNavController().navigate(R.id.action_addTicketFragment_to_supportFragment)
        }
    }

    private fun callAddTicketApi(fileUri: Uri?, selectedIssueId: Int) {
        var filePhotoLogo: MultipartBody.Part? = null
        if (fileUri != null) {
            try {
                val file: File = FileUtils.getFile(requireActivity(), fileUri)
                if (file.exists()) {
                    val requestBody: RequestBody = RequestBody.create("*/*".toMediaTypeOrNull(), file)
                    filePhotoLogo = MultipartBody.Part.createFormData("myfiles", file.name, requestBody)
                }
            } catch (e: NullPointerException) {
                e.printStackTrace()
            }
        } else {
            val attachmentEmpty = RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            filePhotoLogo = MultipartBody.Part.createFormData("myfiles", "", attachmentEmpty)
        }

        try {
            val userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            val comment = etComment.text.toString().trim()

            val rbUserID: RequestBody = if (userID!!.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), userID) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbSelectedIssueId: RequestBody = if (selectedIssueId.toString().isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), selectedIssueId.toString()) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbComment: RequestBody = if (comment.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), comment) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")

            if (CommonUtil.checkNetwork(mContext)) {
                val apiServices = GbusinessService.create(mContext)
                CommonUtil.showDialog(mContext)
                apiServices.addNewTicket("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),
                    rbUserID, rbSelectedIssueId, rbComment, filePhotoLogo!!)
                    .enqueue(object : Callback<AddTicketResponse> {
                        override fun onResponse(call: Call<AddTicketResponse>, response: Response<AddTicketResponse>) {
                            CommonUtil.hideDialog(mContext)
                            val addTicketResponse = response.body()
                            if (addTicketResponse != null) {
                                CommonUtil.successToast("Add New Ticket!", "${addTicketResponse.message}", requireActivity())
                                MainActivity.navController.navigate(R.id.action_addTicketFragment_to_supportFragment)
                            }
                        }

                        override fun onFailure(call: Call<AddTicketResponse>, t: Throwable) {
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
                mScreenshotImageUri = uri
                setUploadStr(mScreenshotImageUri!!, tvUploadScreenshot)
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

    private fun setUploadStr(mScreenshotImageUri: Uri, tvUploadScreenshot: TextView) {
        if (mScreenshotImageUri != null) {
            val file: File = FileUtils.getFile(requireActivity(), mScreenshotImageUri)
            tvUploadScreenshot?.text = file.name
        } else {
            tvUploadScreenshot?.text = "No file chosen yet."
        }
    }

    private fun getIssueSpinnerListApi() {
        if (CommonUtil.checkNetwork(mContext)) {

            val dataNotic = GbusinessService.create(mContext)

            dataNotic.getIssueSpinnerList()
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
                        val getdata = response.body()
                        CommonUtil.logi(getdata.toString())
                        if (getdata != null) {

                            if (getdata.success) {

                                if (getdata.data.isNotEmpty()) {
                                    issueList = getdata.data
                                    searchableSpinnerIssue.setSpinnerListItems(loadIssueNameList(issueList))

                                }

                            } else if (getdata.message != null) CommonUtil.toast(getdata.message, mContext)
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

    private fun validate(): Boolean {
        val tvIssueType = tvIssue.text.toString().trim()
        val etCommentStr = etComment.text.toString().trim()
        when {

            TextUtils.isEmpty(tvIssueType) -> {
                //tvIssue.error = "Issue type field can't be blank."
                //tvIssue.requestFocus()
                CommonUtil.warningToast("Select Issue!", "You have to select issue first.", requireActivity())
                return false
            }
            CommonUtil.isUriEmpty(mScreenshotImageUri) -> {
                CommonUtil.warningToast("Upload Screenshot", "Please upload screenshot where you are facing issues.", requireActivity())
                return false
            }


            TextUtils.isEmpty(etCommentStr) -> {
                etComment.error = "Your issue field can't be blank."
                etComment.requestFocus()
                return false
            }

            else -> return true
        }
    }
}