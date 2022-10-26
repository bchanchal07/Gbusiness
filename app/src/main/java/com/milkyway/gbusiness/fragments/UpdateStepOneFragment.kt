package com.milkyway.gbusiness.fragments

import android.Manifest
import android.app.ActionBar
import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.github.drjacky.imagepicker.ImagePicker
import com.google.gson.Gson
import com.milkyway.gbusiness.models.BusinessListStepOneModel
import com.milkyway.gbusiness.models.OtpErrorModel
import com.milkyway.gbusiness.models.StepOneItemListsModel
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.activities.MainActivity
import com.milkyway.gbusiness.extension.setLocalImage
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.utils.CommonUtil
import com.milkyway.gbusiness.utils.FileUtils
import dev.mortezaom.mdtoast.MDToast
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.util.*

class UpdateStepOneFragment : Fragment() {
    lateinit var mContext: Context
    private lateinit var editBusinessListingBack: ImageView
    private lateinit var ivBusinessPaymentView: ImageView
    private lateinit var ivImageSelect: ImageView
    private lateinit var et_payment_tilte: EditText
    private lateinit var et_payment_email: EditText
    private lateinit var et_payment_url: EditText
    private lateinit var et_payment_bank_detail: EditText
    private lateinit var btn_update_step_1: AppCompatButton
    private lateinit var stepOneBusinessList: StepOneItemListsModel.BusinessItemsList
    lateinit var businessListStepOneModel_gl: BusinessListStepOneModel

    var id: String = ""
    var fileUri: Uri? = null

    val REQUEST_ID_MULTIPLE_PERMISSIONS = 7
    var RESULT_LOAD_IMAGE = 101
    val PICTURE_FROM_CAMERA: Int = 1

    lateinit var file: File
    lateinit var picturePath: String
    var random: Random = Random()

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() = UpdateStepOneFragment().apply {}
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_step_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //todo get bundle arguments data...
        try {
            val args = arguments ?: return
            if (args != null) {
                id = args.getString("id").toString()
                stepOneBusinessList = args.getSerializable("step_one_item_list") as StepOneItemListsModel.BusinessItemsList
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        initView(view)
        setDefaultData(stepOneBusinessList)

    }

    //todo set default data in text view....
    private fun setDefaultData(stepOneBusinessList: StepOneItemListsModel.BusinessItemsList) {
        //todo set Text..
        if (stepOneBusinessList.pmethod_image != null) {
            val urlLogo = GbusinessService.STEP_ONE_ITEM_BASE_IMG_URL + stepOneBusinessList.pmethod_image
            Glide.with(mContext)
                .load(urlLogo)
                .into(ivBusinessPaymentView)
        } else {
            ivBusinessPaymentView.setImageResource(R.drawable.default_img)
        }

        et_payment_tilte.setText(stepOneBusinessList.name)
        et_payment_email.setText(stepOneBusinessList.email)
        et_payment_url.setText(stepOneBusinessList.payment_url)
        et_payment_bank_detail.setText(stepOneBusinessList.bank_details)
    }

    private fun initView(view: View) {
        editBusinessListingBack = view.findViewById(R.id.editBusinessListingBack)
        ivBusinessPaymentView = view.findViewById(R.id.ivBusinessPaymentView)
        ivImageSelect = view.findViewById(R.id.ivImageSelect)
        et_payment_tilte = view.findViewById(R.id.et_payment_tilte)
        et_payment_email = view.findViewById(R.id.et_payment_email)
        et_payment_url = view.findViewById(R.id.et_payment_url)
        et_payment_bank_detail = view.findViewById(R.id.et_payment_bank_detail)
        btn_update_step_1 = view.findViewById(R.id.btn_update_step_1)

        editBusinessListingBack.setOnClickListener {
            MainActivity.navController.navigate(R.id.action_updateStepOneFragment_to_StepOneBusinessListFragment)
        }

        //todo select image..
        ivImageSelect.setOnClickListener {
            pickBusinessLogo(view)
        }

        //todo update listener...
        btn_update_step_1.setOnClickListener {
            updateStepOneDetails()
        }

    }

    //todo submit step - 1 payment details...
    private fun updateStepOneDetails() {
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
            val defaultUrl = "${GbusinessService.STEP_ONE_ITEM_BASE_IMG_URL}${R.drawable.default_img}"
            val attachmentEmpty = RequestBody.create("text/plain".toMediaTypeOrNull(), defaultUrl)
            filePaymentImage = MultipartBody.Part.createFormData("pmethod_image", "", attachmentEmpty)
        }
        if (et_payment_tilte.text.toString().isNullOrEmpty()) {
            MDToast.makeText(mContext, "The title field is required", MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR).show()
        } else if (et_payment_url.text.toString().isNullOrEmpty()) {
            MDToast.makeText(mContext, "Payment Url field is required", MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR).show()
        } else if (et_payment_bank_detail.text.toString().isNullOrEmpty()) {
            MDToast.makeText(mContext, "The Bank detail field is required", MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR).show()
        } else {
            try {
                var urlLogo = ""
                urlLogo = if (stepOneBusinessList.pmethod_image != null){
                    stepOneBusinessList.pmethod_image
                } else{
                    "${GbusinessService.STEP_ONE_ITEM_BASE_IMG_URL}${R.drawable.default_img}"
                }
                var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
                var businessID = CommonUtil.getIntPreferences(mContext, AppConstants.BUSINESS_ID)
                val requestUserID: RequestBody = if (userID!!.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), userID) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
                val requestID: RequestBody = if (userID!!.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), id) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
                val requestBusinessID: RequestBody = if (businessID!! != null) RequestBody.create("text/plain".toMediaTypeOrNull(), businessID.toString()) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")

                var requestOldImage: RequestBody = RequestBody.create("multipart/form-data".toMediaTypeOrNull(), urlLogo)
                var requestPaymentNAme: RequestBody = RequestBody.create("multipart/form-data".toMediaTypeOrNull(), et_payment_tilte.text.toString())
                var requestPaymentEmail: RequestBody = RequestBody.create("multipart/form-data".toMediaTypeOrNull(), et_payment_email.text.toString())
                var requestPaymentURL: RequestBody = RequestBody.create("multipart/form-data".toMediaTypeOrNull(), et_payment_url.text.toString())
                var requestPaymentBankDetail: RequestBody = RequestBody.create("multipart/form-data".toMediaTypeOrNull(), et_payment_bank_detail.text.toString())

                if (CommonUtil.checkNetwork(mContext)) {
                    CommonUtil.showDialog(mContext)
                    val apiServices = GbusinessService.create(mContext)
                    if (userID != null) {
                        apiServices.updateStepOneItem("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), requestID,
                            requestPaymentNAme, requestUserID, requestPaymentEmail, requestPaymentURL, requestPaymentBankDetail, requestBusinessID, requestOldImage, filePaymentImage!!).apply {
                            Log.e("apiServices----", apiServices.toString())
                            enqueue(object : Callback<BusinessListStepOneModel> {
                                override fun onResponse(call: Call<BusinessListStepOneModel>, response: Response<BusinessListStepOneModel>) {
                                    try {
                                        if (response.isSuccessful) {
                                            CommonUtil.hideDialog(mContext)
                                            businessListStepOneModel_gl = response.body()!!
                                            if (businessListStepOneModel_gl.success && businessListStepOneModel_gl != null) {
                                                MDToast.makeText(requireActivity(), businessListStepOneModel_gl.message, MDToast.LENGTH_SHORT, MDToast.TYPE_SUCCESS).show()
                                                MainActivity.navController.navigate(R.id.action_updateStepOneFragment_to_StepOneBusinessListFragment)
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
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

    }


    //todo set image choose code here...
    private fun pickBusinessLogo(view: View) {
        ImagePicker.with(requireActivity())
            .crop()
            .cropOval()
            .maxResultSize(512, 512, true)
            .createIntentFromDialog { logoImageLauncher.launch(it) }
    }

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


    //todo get image..
    fun getPictureDialog() {
        val dialog = Dialog(mContext)
        dialog.window?.setWindowAnimations(R.style.AnimationsForDailog)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.picturedialog)
        dialog.getWindow()?.getAttributes()!!.width = ActionBar.LayoutParams.FILL_PARENT;
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()

        val cancel = dialog.findViewById(R.id.canceldialog) as TextView
        val gallery = dialog.findViewById<ImageView>(R.id.gallerySelect)
        val camera = dialog.findViewById<ImageView>(R.id.cameraSelect)

        gallery.setOnClickListener {
            val i = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(i, RESULT_LOAD_IMAGE)
            dialog.dismiss()
        }

        camera.setOnClickListener {
            var i = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(i, PICTURE_FROM_CAMERA)
            dialog.dismiss()
        }

        cancel.setOnClickListener {
            dialog.dismiss()
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            RESULT_LOAD_IMAGE -> if (requestCode == RESULT_LOAD_IMAGE && resultCode == AppCompatActivity.RESULT_OK && null != data) {
                val extras: Bundle? = data?.getExtras()
                val selectedImage: Uri? = data!!.data
                val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)
                val cursor: Cursor? = mContext.contentResolver.query(selectedImage!!, filePathColumn, null, null, null)
                cursor?.moveToFirst()
                val columnIndex: Int = cursor!!.getColumnIndex(filePathColumn[0])
                picturePath = cursor.getString(columnIndex)
                if (cursor != null) {
                    cursor.close()
                }
                fileUri = Uri.parse(picturePath)
                ivBusinessPaymentView.setImageURI(Uri.parse(picturePath))
            }

            PICTURE_FROM_CAMERA -> if (requestCode == PICTURE_FROM_CAMERA && resultCode == AppCompatActivity.RESULT_OK) {
                var photo = data?.extras?.get("data")
                file = savebitmap(photo as Bitmap)
                picturePath = file.absolutePath
                Log.e("myBitmap---", photo.toString())
                Log.e("file---", file.toString())
                Log.e("picturePath---", picturePath)
                fileUri = Uri.parse(picturePath)
                ivBusinessPaymentView.setImageBitmap(photo)

                //todo also can set bitmap image in glide way...
//                Glide.with(this).asBitmap().load(photo).into(iv_set_profile)

            }

        }
    }

    //todo to convert bitmap to file--
    private fun savebitmap(bmp: Bitmap): File {
        val extStorageDirectory = Environment.getExternalStorageDirectory().toString()
        var outStream: OutputStream? = null
        // String temp = null;
        val num: Int = random.nextInt(90) + 10
        var file = File(extStorageDirectory, "temp$num.png")
        if (file.exists()) {
            file.delete()
            file = File(extStorageDirectory, "temp$num.png")
        }
        try {
            outStream = FileOutputStream(file)
            bmp.compress(Bitmap.CompressFormat.PNG, 100, outStream)
            outStream.flush()
            outStream.close()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            return null!!
        }
        return file
    }


    //todo set permission for image...
    private fun checkAndRequestPermissions(): Boolean {
        val camera = ContextCompat.checkSelfPermission(mContext, Manifest.permission.CAMERA)
        val wtite = ContextCompat.checkSelfPermission(mContext, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        val read = ContextCompat.checkSelfPermission(mContext, Manifest.permission.READ_EXTERNAL_STORAGE)
        val listPermissionsNeeded: MutableList<String> = java.util.ArrayList()
        if (wtite != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if (camera != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.CAMERA)
        }
        if (read != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(requireActivity(), listPermissionsNeeded.toTypedArray(), REQUEST_ID_MULTIPLE_PERMISSIONS)
            return false
        }
        return true
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        Log.d("in fragment on request", "Permission callback called-------")
        when (requestCode) {
            REQUEST_ID_MULTIPLE_PERMISSIONS -> {
                val perms: MutableMap<String, Int> = HashMap()
                // Initialize the map with both permissions
                perms[Manifest.permission.WRITE_EXTERNAL_STORAGE] =
                    PackageManager.PERMISSION_GRANTED
                perms[Manifest.permission.CAMERA] = PackageManager.PERMISSION_GRANTED
                perms[Manifest.permission.READ_EXTERNAL_STORAGE] = PackageManager.PERMISSION_GRANTED
                // Fill with actual results from user
                if (grantResults.size > 0) {
                    var i = 0
                    while (i < permissions.size) {
                        perms[permissions[i]] = grantResults[i]
                        i++
                    }
                    // Check for both permissions
                    if (perms[Manifest.permission.WRITE_EXTERNAL_STORAGE] == PackageManager.PERMISSION_GRANTED && perms[Manifest.permission.CAMERA] == PackageManager.PERMISSION_GRANTED && perms[Manifest.permission.READ_EXTERNAL_STORAGE] == PackageManager.PERMISSION_GRANTED) {
                        Log.d(
                            "in fragment on request",
                            "CAMERA & WRITE_EXTERNAL_STORAGE READ_EXTERNAL_STORAGE permission granted"
                        )
                        // process the normal flow
                        //else any one or both the permissions are not granted
                    } else {
                        Log.d(
                            "in fragment on request",
                            "Some permissions are not granted ask again "
                        )
                        //permission is denied (this is the first time, when "never ask again" is not checked) so ask again explaining the usage of permission
//                        // shouldShowRequestPermissionRationale will return true
                        //show the dialog or snackbar saying its necessary and try again otherwise proceed with setup.
                        if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) || ActivityCompat.shouldShowRequestPermissionRationale(
                                requireActivity(), Manifest.permission.CAMERA) || ActivityCompat.shouldShowRequestPermissionRationale(
                                requireActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)
                        ) {
                            showDialogOK(
                                "Camera and Storage Permission required for this app"
                            ) { dialog, which ->
                                when (which) {
                                    DialogInterface.BUTTON_POSITIVE -> checkAndRequestPermissions()
                                    DialogInterface.BUTTON_NEGATIVE -> {
                                    }
                                }
                            }
                        } else {
                            Toast.makeText(
                                mContext,
                                "Go to settings and enable permissions",
                                Toast.LENGTH_LONG
                            )
                                .show()
                            //                            //proceed with logic by disabling the related features or quit the app.
                        }
                    }
                }
            }
        }
    }

    private fun showDialogOK(message: String, okListener: DialogInterface.OnClickListener) {
        AlertDialog.Builder(mContext)
            .setMessage(message)
            .setPositiveButton("OK", okListener)
            .setNegativeButton("Cancel", okListener)
            .create()
            .show()
    }


}