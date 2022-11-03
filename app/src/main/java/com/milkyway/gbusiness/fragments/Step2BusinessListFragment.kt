package com.milkyway.gbusiness.fragments

import android.Manifest
import android.app.ActionBar
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.activities.MainActivity
import com.milkyway.gbusiness.adaptor.StepTwoGalleryImagesAdapter
import com.milkyway.gbusiness.adaptor.Step_2_BusinessListItemsAdapter
import com.milkyway.gbusiness.models.BusinessListStepOneModel
import com.milkyway.gbusiness.models.OtpErrorModel
import com.milkyway.gbusiness.models.StepOneItemListsModel
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.global.CommonUtil
import com.milkyway.gbusiness.global.FileUtils
import dev.mortezaom.mdtoast.MDToast
import id.ionbit.ionalert.IonAlert
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.net.SocketTimeoutException
import java.util.*


class Step2BusinessListFragment : Fragment(), Step_2_BusinessListItemsAdapter.UpdateBtnListener, Step_2_BusinessListItemsAdapter.DeleteBtnListener {
    lateinit var mContext: Context
    private lateinit var editBusinessListingBack: ImageView
    private lateinit var et_gallery_tilte: EditText
    private lateinit var rv_show_image_list: RecyclerView
    private lateinit var rv_item_list: RecyclerView
    private lateinit var btn_submit_step_2: AppCompatButton
    private lateinit var card_view_show_list: CardView
    private lateinit var card_view_hide_list: CardView
    private lateinit var addPic: CardView
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var tv_blank: TextView
    lateinit var businessListStepOneModel_gl: BusinessListStepOneModel
    var stepTwoGalleryImagesAdapter: StepTwoGalleryImagesAdapter? = null

    private var RESULT_LOAD_IMAGE = 101
    val PICTURE_FROM_CAMERA: Int = 1234
    lateinit var file: File

    lateinit var picturePath: String
    var random: Random = Random()

    var mArrayUriList: ArrayList<Uri>? = null
    var parts_list: MutableList<MultipartBody.Part> = arrayListOf()
    lateinit var fileUri: Uri
    val REQUEST_ID_MULTIPLE_PERMISSIONS = 7


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_step_2_business_list, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)

    }

    //todo initialization..
    private fun initView(view: View) {
        editBusinessListingBack = view.findViewById(R.id.editBusinessListingBack)
        et_gallery_tilte = view.findViewById(R.id.et_gallery_tilte)
        rv_show_image_list = view.findViewById(R.id.rv_show_image_list)
        rv_item_list = view.findViewById(R.id.rv_item_list)
        btn_submit_step_2 = view.findViewById(R.id.btn_submit_step_2)
        card_view_show_list = view.findViewById(R.id.card_view_show_list)
        card_view_hide_list = view.findViewById(R.id.card_view_hide_list)
        addPic = view.findViewById(R.id.addPic)
        tv_blank = view.findViewById(R.id.tv_blank)

        //todo init list
        mArrayUriList = ArrayList()

        editBusinessListingBack.setOnClickListener {
            MainActivity.navController.navigate(R.id.action_stepTwoBusinessListFragment_to_myBusinessListFragment)
        }

        //todo add new multi images....
        addPic.setOnClickListener {
            checkAndRequestPermissions()
            getPictureDialog()
        }

        card_view_show_list.setOnClickListener {
            card_view_show_list.visibility = View.GONE
            card_view_hide_list.visibility = View.VISIBLE
            rv_item_list.visibility = View.VISIBLE
            getBusinessItemList()
        }

        card_view_hide_list.setOnClickListener {
            card_view_hide_list.visibility = View.GONE
            card_view_show_list.visibility = View.VISIBLE
            rv_item_list.visibility = View.VISIBLE
            bindItemListAdapter(ArrayList())
            tv_blank.visibility = View.GONE
        }

        //todo submit step-2 updat details...
        btn_submit_step_2.setOnClickListener {
            submitStepTwoNewRecord()
        }

    }


    //todo show items list...
    fun getBusinessItemList() {
        if (CommonUtil.checkNetwork(mContext)) {
            var business_id = CommonUtil.getIntPreferences(mContext, AppConstants.BUSINESS_ID)
            Log.e("business_id", business_id.toString())
            var token = CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN)
            CommonUtil.showDialog(mContext)
            val apiServices = GbusinessService.create(mContext)
            apiServices.getBusinessStepTwoItemList("Bearer $token", business_id.toString()).apply {
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
                                    var stepTwoItemList_gl: List<StepOneItemListsModel.BusinessItemsList> = itemModelResponse.data
                                    bindItemListAdapter(stepTwoItemList_gl)
                                } else {
                                    bindItemListAdapter(ArrayList())
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

    //todo bind adapter for business items list...
    fun bindItemListAdapter(stepOneItemList_gl: List<StepOneItemListsModel.BusinessItemsList>) {
        var step2Businesslistitemsadapter: Step_2_BusinessListItemsAdapter = Step_2_BusinessListItemsAdapter(mContext, stepOneItemList_gl, this, this)
        linearLayoutManager = LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false)
        rv_item_list.layoutManager = linearLayoutManager
        rv_item_list.adapter = step2Businesslistitemsadapter
    }

    //todo update step-2 items details
    override fun updateClickListener(position: Int, stepTwoBusinessList: StepOneItemListsModel.BusinessItemsList) {
        var bundle = Bundle()
        bundle.putString("id", stepTwoBusinessList.id)
        bundle.putSerializable("step_two_item_list", stepTwoBusinessList)
        try {
            findNavController().navigate(R.id.action_stepTwoBusinessListFragment_to_updateStepTwoFragment, bundle)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    //todo delete step-2 items.
    override fun deleteClickListener(position: Int, stepTwoBusinessList: List<StepOneItemListsModel.BusinessItemsList>) {
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
                deleteStepTwoListItemApi(position, stepTwoBusinessList)
            }
            .show()
    }

    //todo call delete items----
    private fun deleteStepTwoListItemApi(position: Int, stepTwoBusinessList: List<StepOneItemListsModel.BusinessItemsList>) {
        if (CommonUtil.checkNetwork(mContext)) {
            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)
            val apiServices = GbusinessService.create(mContext)
            if (userID != null) {
                apiServices.deleteStepTwoItems("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), stepTwoBusinessList[position].id
                ).enqueue(object : Callback<StepOneItemListsModel> {
                    override fun onResponse(
                        call: Call<StepOneItemListsModel>,
                        response: Response<StepOneItemListsModel>,
                    ) {
                        try {
                            if (response.isSuccessful) {
                                CommonUtil.hideDialog(mContext)
                                val getData = response?.body()
                                Log.i("TAG", getData.toString())

                                if (getData != null) {
                                    if (getData.success) {
                                        getBusinessItemList()
                                        val ionAlert = IonAlert(requireActivity(), IonAlert.SUCCESS_TYPE)
                                        ionAlert.titleText = "Delete Success!"
                                        ionAlert.contentText = getData.message
                                        ionAlert.show()
                                    }
                                } else MDToast.makeText(requireActivity(), getData?.message, MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR).show()
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

    //todo submit step two update details ----
    private fun submitStepTwoNewRecord() {
        //todo convert multi image array list into multipartBody.part form....
        try {
            if (!mArrayUriList.isNullOrEmpty() || mArrayUriList!!.size > 0) {
                for (i in 0 until mArrayUriList!!.size) {
                    parts_list.add(prepareFilePart("files[]", mArrayUriList!![i])!!)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
        var businessID = CommonUtil.getIntPreferences(mContext, AppConstants.BUSINESS_ID)
        val requestUserID: RequestBody = if (userID!!.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), userID) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
        val requestBusinessID: RequestBody = if (businessID!! != null) RequestBody.create("text/plain".toMediaTypeOrNull(), businessID.toString()) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
        if (et_gallery_tilte.text.toString().isNullOrEmpty()) {
            MDToast.makeText(mContext, "The title field is required", MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR).show()
        } else if (mArrayUriList.isNullOrEmpty() || mArrayUriList!!.size == 0) {
            MDToast.makeText(mContext, "Please Choose Images.", MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR).show()
        } else {
            var requestGalleryTitle: RequestBody = RequestBody.create("multipart/form-data".toMediaTypeOrNull(), et_gallery_tilte.text.toString())

            if (CommonUtil.checkNetwork(mContext)) {
                CommonUtil.showDialog(mContext)
                val apiServices = GbusinessService.create(mContext)
                if (userID != null) {
                    apiServices.addBusinessListingAddStepTwo("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), requestUserID,
                        requestGalleryTitle, requestBusinessID, parts_list).apply {
                        enqueue(object : Callback<BusinessListStepOneModel> {
                            override fun onResponse(call: Call<BusinessListStepOneModel>, response: Response<BusinessListStepOneModel>) {
                                try {
                                    if (response.isSuccessful) {
                                        CommonUtil.hideDialog(mContext)
                                        businessListStepOneModel_gl = response.body()!!
                                        if (businessListStepOneModel_gl.success && businessListStepOneModel_gl != null) {
                                            MDToast.makeText(requireActivity(), businessListStepOneModel_gl.message, MDToast.LENGTH_SHORT, MDToast.TYPE_SUCCESS).show()
                                            getBusinessItemList()
                                            et_gallery_tilte.setText("")
                                            bindGalleryImagesAdapter(ArrayList())
                                            mArrayUriList!!.clear()

                                        } else {
                                            MDToast.makeText(requireActivity(), businessListStepOneModel_gl.error.email.toString(), MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR).show()
                                        }

                                    }

                                else {
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

                            override fun onFailure(call: Call<BusinessListStepOneModel>, error: Throwable) {
                                try {
                                    CommonUtil.hideDialog(mContext)
                                    MDToast.makeText(requireActivity(), error.message, MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR).show()
                                }catch (e:SocketTimeoutException){
                                    e.printStackTrace()
                                }
                            }

                        })
                    }
                }

            } else {
                CommonUtil.toast("Check Internet", mContext)
            }
        }
    }

    //todo bind adapter for upload images....
    fun bindGalleryImagesAdapter(mArrayUriList: ArrayList<Uri>?) {
        stepTwoGalleryImagesAdapter = StepTwoGalleryImagesAdapter(mContext, mArrayUriList!!)
        linearLayoutManager = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        rv_show_image_list.layoutManager = linearLayoutManager
        rv_show_image_list.adapter = stepTwoGalleryImagesAdapter
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
            i.type = "image/*"
            i.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
            i.action = Intent.ACTION_GET_CONTENT;
            startActivityForResult(Intent.createChooser(i, "Select Picture"), RESULT_LOAD_IMAGE);
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
                if (data.clipData != null) {
                    try {
                        var cout = data.clipData!!.itemCount
                        var imageurl: Uri? = null
                        for (i in 0 until cout) {
                            imageurl = data.clipData!!.getItemAt(i).uri
                            Log.e("mutlifilesUri [" + imageurl + "] : ", imageurl.toString());
                            mArrayUriList!!.add(imageurl)
                        }
                        bindGalleryImagesAdapter(mArrayUriList)
                        Log.e("mArrayList-----", mArrayUriList.toString())
                        stepTwoGalleryImagesAdapter?.notifyDataSetChanged()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                } else if (data.getData() != null) {
                    val imgurl: String = data.getData()!!.path.toString()
                    mArrayUriList?.add(Uri.parse(imgurl))
                }

            }

            PICTURE_FROM_CAMERA -> if (requestCode == PICTURE_FROM_CAMERA && resultCode == AppCompatActivity.RESULT_OK && null != data) {
                var photo = data?.extras?.get("data")
                file = savebitmap(photo as Bitmap)
                picturePath = file.path
                fileUri = Uri.fromFile(file)
                Log.e("fileUri---", fileUri.toString())

                //todo add camera bitmap file uri photo in arraylist...
                mArrayUriList!!.add(fileUri)
                bindGalleryImagesAdapter(mArrayUriList)

            }

        }
    }

    //todo to convert bitmap to file--
    private fun savebitmap(bmp: Bitmap): File {
//        val extStorageDirectory = Environment.getExternalStorageDirectory().toString()
        var extStorageDirectory = mContext.cacheDir //todo this is use for temporairy file path storage //"/storage/emulated/0/Download"
        var outStream: OutputStream? = null
        val num: Int = random.nextInt(90) + 10
//        var file = File(extStorageDirectory, "temp$num.png")

        Log.e("extStorageDirectory---", extStorageDirectory.toString())
        var file = File.createTempFile("prefix", ".extension", extStorageDirectory)
        if (file.exists()) {
            file.delete()
            file = File(extStorageDirectory, "temp$num.png")
        }
        try {
            outStream = FileOutputStream(file)
            if (outStream!= null) {
                bmp.compress(Bitmap.CompressFormat.PNG, 100, outStream)
                outStream.close()
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            return null!!
        }
        Log.e("file---", file.toString())
        return file
    }

    //todo get multipartBody.part files and name from image array...
    @NonNull
    private fun prepareFilePart(partName: String, fileUri: Uri): MultipartBody.Part? {
        val file: File = FileUtils.getFile(mContext, fileUri)
        val requestFile: RequestBody = RequestBody.create(mContext.getContentResolver().getType(fileUri).toString().toMediaTypeOrNull(), file)
        return MultipartBody.Part.createFormData(partName, file.name, requestFile)
    }

    fun getMultiAttachment(): List<MultipartBody.Part> {
        if (mArrayUriList != null) {
            for (i in 0 until mArrayUriList!!.size) {
                parts_list.add(prepareFilePart("multi_file_Attachment[$i]", mArrayUriList!![i])!!)
            }
        }
        return parts_list
    }


    //todo set permission for image...
    private fun checkAndRequestPermissions(): Boolean {
        val camera = ContextCompat.checkSelfPermission(
            mContext,
            Manifest.permission.CAMERA
        )
        val wtite = ContextCompat.checkSelfPermission(
            mContext,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        val read = ContextCompat.checkSelfPermission(
            mContext,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
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
            ActivityCompat.requestPermissions(
                requireActivity(),
                listPermissionsNeeded.toTypedArray(),
                REQUEST_ID_MULTIPLE_PERMISSIONS
            )
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
                        if (ActivityCompat.shouldShowRequestPermissionRationale(
                                requireActivity(),
                                Manifest.permission.WRITE_EXTERNAL_STORAGE
                            ) || ActivityCompat.shouldShowRequestPermissionRationale(
                                requireActivity(),
                                Manifest.permission.CAMERA
                            ) || ActivityCompat.shouldShowRequestPermissionRationale(
                                requireActivity(),
                                Manifest.permission.READ_EXTERNAL_STORAGE
                            )
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