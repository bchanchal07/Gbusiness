package com.milkyway.gbusiness.fragments

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.github.drjacky.imagepicker.ImagePicker
import com.milkyway.gbusiness.activities.MainActivity
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.api.GBusinessServiceSecond
import com.milkyway.gbusiness.models.BusinessUpdateDataClass
import com.milkyway.gbusiness.models.GetBusinessDataClass
import com.milkyway.gbusiness.extension.setLocalImage
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.utils.CommonUtil
import com.milkyway.gbusiness.utils.FileUtils
import de.hdodenhof.circleimageview.CircleImageView
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.net.URL
import java.util.regex.Matcher
import java.util.regex.Pattern

class BusinessPageFragment : Fragment() {

    private lateinit var myBusinessPageBack: ImageView
    private lateinit var ivBusinessLogo: CircleImageView
    private lateinit var ivCamera: ImageView
    private lateinit var etEmailBPage: EditText
    private lateinit var etWebUrlBPage: EditText
    private lateinit var etAboutUsBPage: EditText
    private lateinit var btnUpdateBusinessData: Button
    private lateinit var mContext: Context

    private lateinit var mailStr: String
    private lateinit var webUrlStr: String
    private lateinit var aboutUsStr: String
    private var mBusinessLogoImageUri: Uri? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mContext = context
    }

    private val logoImageLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                val uri = it.data?.data!!
                mBusinessLogoImageUri = uri
                ivBusinessLogo.setLocalImage(uri, true)
            } else parseError(it)
        }

    private fun parseError(activityResult: ActivityResult) {
        if (activityResult.resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(requireActivity(), ImagePicker.getError(activityResult.data), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireActivity(), "Task Cancelled", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_business_page, container, false)
        initializeView(view)
        clickListener(view)
        return view
    }


    private fun initializeView(view: View) {
        myBusinessPageBack = view.findViewById(R.id.myBusinessPageBack)
        ivBusinessLogo = view.findViewById(R.id.ivBusinessLogo)
        ivCamera = view.findViewById(R.id.ivCamera)
        etEmailBPage = view.findViewById(R.id.etEmailBPage)
        etWebUrlBPage = view.findViewById(R.id.etWebUrlBPage)
        etAboutUsBPage = view.findViewById(R.id.etAboutUsBPage)
        btnUpdateBusinessData = view.findViewById(R.id.btnUpdateBusinessData)
        callApiBusinessData(view)
    }

    private fun callApiBusinessData(view: View) {
        if (CommonUtil.checkNetwork(mContext)) {
            CommonUtil.showDialog(mContext)
            val dataBusinessResponse = GBusinessServiceSecond.create()

            dataBusinessResponse.getBusinessData(
                "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), "application/json"
            )
                .enqueue(object : Callback<GetBusinessDataClass> {
                    override fun onFailure(call: Call<GetBusinessDataClass>, t: Throwable) {
                        CommonUtil.hideDialog(mContext)

                        CommonUtil.toast(R.string.showError.toString(), mContext)
                        Log.i("TAGadxx===", t.localizedMessage)

                    }

                    override fun onResponse(call: Call<GetBusinessDataClass>, response: Response<GetBusinessDataClass>) {
                        CommonUtil.hideDialog(mContext)
                        Log.i("TAGadxx===", response.body().toString())
                        val getBusinessDataResponse = response.body()
                        CommonUtil.logi(getBusinessDataResponse.toString())
                        // CommonUtil.toast(businessUpdateResponse!!.,mContext)


                        if (getBusinessDataResponse != null) {
                            //CommonUtil.toast(getBusinessDataResponse.status, mContext)
                            setBusinessData(getBusinessDataResponse)
                        }
                        //else CommonUtil.toast(R.string.showError.toString(),mContext)
                    }
                })
        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }

    private fun setBusinessData(businessDataResponse: GetBusinessDataClass) {
        if (!businessDataResponse.data[0].businessEmail.isNullOrEmpty())
            etEmailBPage.text = Editable.Factory.getInstance().newEditable(businessDataResponse.data[0].businessEmail)
        if (!businessDataResponse.data[0].businessWebUrl.isNullOrEmpty())
            etWebUrlBPage.text = Editable.Factory.getInstance().newEditable(businessDataResponse.data[0].businessWebUrl)
        if (!businessDataResponse.data[0].businessAboutUs.isNullOrEmpty())
            etAboutUsBPage.text = Editable.Factory.getInstance().newEditable(businessDataResponse.data[0].businessAboutUs)

        if (!businessDataResponse.data[0].businessLogo.isNullOrEmpty()) {
            val urlLogo = GBusinessServiceSecond.BASE_IMG_URL + businessDataResponse.data[0].businessLogo
            Glide.with(requireContext())
                .load(urlLogo)
                .into(ivBusinessLogo)

        }
    }

    private fun clickListener(view: View) {
        myBusinessPageBack.setOnClickListener {
            MainActivity.navController.navigate(R.id.action_myBusinessPageFragment_to_mainFragment)
        }

        btnUpdateBusinessData.setOnClickListener {
            if (validate()) {
                //CommonUtil.toast("Validate", mContext)
                callApiBusinessUpdate(mBusinessLogoImageUri)
            } else {
                //CommonUtil.toast("No Validate", mContext)
            }
        }

        ivCamera.setOnClickListener {
            pickProfileImage(view)
        }
    }

    private fun pickProfileImage(view: View) {
        ImagePicker.with(requireActivity())
            .crop()
            .cropOval()
            .maxResultSize(512, 512, true)
            .createIntentFromDialog { logoImageLauncher.launch(it) }
    }


    private fun callApiBusinessUpdate(fileUri: Uri?) {
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
            mailStr = etEmailBPage.text.toString().trim()
            webUrlStr = etWebUrlBPage.text.toString().trim()
            aboutUsStr = etAboutUsBPage.text.toString().trim()

            val rbMail: RequestBody = if (mailStr.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), mailStr) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbWebUrl: RequestBody = if (webUrlStr.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), webUrlStr) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbAboutUs: RequestBody = if (aboutUsStr.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), aboutUsStr) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            if (CommonUtil.checkNetwork(mContext)) {
                CommonUtil.showDialog(mContext)
                val dataBusinessResponse = GBusinessServiceSecond.create()

                dataBusinessResponse.updateBusinessPage(
                    "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), "application/json",
                    rbMail, rbWebUrl, rbAboutUs, filePhotoLogo!!
                )
                    .enqueue(object : Callback<BusinessUpdateDataClass> {
                        override fun onFailure(call: Call<BusinessUpdateDataClass>, t: Throwable) {
                            CommonUtil.hideDialog(mContext)
                            // CommonUtil.toast(t.localizedMessage, mContext)
                            CommonUtil.toast(R.string.showError.toString(), mContext)
                            Log.i("TAGadxx===", t.localizedMessage)

                        }

                        override fun onResponse(call: Call<BusinessUpdateDataClass>, response: Response<BusinessUpdateDataClass>) {
                            Log.i("TAGadxx===", response.body().toString())
                            val businessUpdateResponse = response.body()
                            CommonUtil.logi(businessUpdateResponse.toString())
                            // CommonUtil.toast(businessUpdateResponse!!.,mContext)

                            if (businessUpdateResponse != null) {
                                if (response.isSuccessful) {
                                    if (businessUpdateResponse.status.contains("success")) {
                                        CommonUtil.toast(businessUpdateResponse.status, mContext)
                                        startActivity(Intent(mContext, MainActivity::class.java))
                                    }
                                }

                            }
                            //else CommonUtil.toast(R.string.showError.toString(),mContext)

                        }
                    })


            } else {
                CommonUtil.toast("Check Internet", mContext)
            }
        } catch (e: NullPointerException) {
            e.printStackTrace()
        }

    }

    private fun validate(): Boolean {
        mailStr = etEmailBPage.text.toString().trim()
        webUrlStr = etWebUrlBPage.text.toString().trim()
        aboutUsStr = etAboutUsBPage.text.toString().trim()

        /*if (TextUtils.isEmpty(mailStr)) {
            etEmailBPage.error = "Email field can't be blank."
            etEmailBPage.requestFocus()
            return false
        } else if (isValidMail(mailStr)) {
            etEmailBPage.error = "Enter valid mail."
            etEmailBPage.requestFocus()
            return false
        }*/

        when {

            /*TextUtils.isEmpty(mailStr) -> {
                etEmailBPage.error = "Email field can't be blank."
                etEmailBPage.requestFocus()
                return false
            }*/
            isValidMail(mailStr) -> {
                etEmailBPage.error = "Enter valid mail."
                etEmailBPage.requestFocus()
                return false
            }

            /*TextUtils.isEmpty(webUrlStr) -> {
                etWebUrlBPage.error = "Web url field can't be blank."
                etWebUrlBPage.requestFocus()
                return false
            }*/
            /*URLUtil.isValidUrl(webUrlStr) -> {
                etWebUrlBPage.error = "Enter valid web url."
                etWebUrlBPage.requestFocus()
                return false
            }*/
            webUrlStr.length < 15 -> {
                etWebUrlBPage.error = "Web url must be greater than 15 characters."
                etWebUrlBPage.requestFocus()
                return false
            }
            /*TextUtils.isEmpty(aboutUsStr) -> {
                etAboutUsBPage.error = "About Us field can't be blank."
                etAboutUsBPage.requestFocus()
                return false
            }*/


            aboutUsStr.length < 10 -> {
                etAboutUsBPage.error = "About Us must be greater than 10 characters."
                etAboutUsBPage.requestFocus()
                return false
            }

            else -> return true
        }
    }

    fun isValidIFSC(ifsc: String?): Boolean {
        val pattern: Pattern
        val mobilePattern = "^[A-Z]{4}0[A-Z0-9]{6}$"
        pattern = Pattern.compile(mobilePattern)
        val matcher: Matcher = pattern.matcher(ifsc)
        return !matcher.matches()
    }

    private fun isValidMail(mail: String?): Boolean {
        val pattern: Pattern
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z0-9]+\\.+[a-z]+"
        pattern = Pattern.compile(emailPattern)
        val matcher: Matcher = pattern.matcher(mail)
        return !matcher.matches()
    }

    fun isValidMobile(mobile: String?): Boolean {
        val pattern: Pattern
        val mobilePattern = "^[1-9][0-9]{9}$"
        pattern = Pattern.compile(mobilePattern)
        val matcher: Matcher = pattern.matcher(mobile)
        return !matcher.matches()
    }

    private fun isValidUrl(urlString: String?): Boolean {
        /* Try creating a valid URL */
        return try {
            URL(urlString).toURI()
            true
        } // If there was an Exception while creating URL object
        catch (e: Exception) {
            false
        }
        /*try {
            return URLUtil.isValidUrl(urlString) && Patterns.WEB_URL.matcher(urlString).matches()
        } catch (ignored: MalformedURLException) {
        }
        return false*/
    }

}