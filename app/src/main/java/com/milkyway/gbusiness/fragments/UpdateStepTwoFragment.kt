package com.milkyway.gbusiness.fragments

import android.app.ActionBar
import android.app.Dialog
import android.content.Context
import android.content.Intent
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
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.milkyway.gbusiness.models.BusinessListStepOneModel
import com.milkyway.gbusiness.models.OtpErrorModel
import com.milkyway.gbusiness.models.StepOneItemListsModel
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.activities.MainActivity
import com.milkyway.gbusiness.adaptor.GalleryImageAdapter
import com.milkyway.gbusiness.adaptor.StepTwoGalleryImagesAdapter
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
import kotlin.collections.ArrayList

class UpdateStepTwoFragment : Fragment() {
    lateinit var mContext: Context
    private lateinit var editBusinessListingBack: ImageView
    private lateinit var et_gallery_tilte: EditText
    private lateinit var rv_show_image_list: RecyclerView
    private lateinit var rv_add_new_images: RecyclerView
    private lateinit var btn_update_step_2: AppCompatButton
    private lateinit var addPic: CardView
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var newImageLinearLayout: LinearLayoutManager
    lateinit var stepTwoBusinessList: StepOneItemListsModel.BusinessItemsList
    lateinit var businessListStepOneModel_gl: BusinessListStepOneModel
    var stepTwoGalleryImagesAdapter: StepTwoGalleryImagesAdapter? = null

    var id: String = ""

    private var RESULT_LOAD_IMAGE = 101
    val PICTURE_FROM_CAMERA: Int = 1234
    lateinit var file: File

    lateinit var picturePath: String
    var random: Random = Random()
    lateinit var fileUri: Uri

    var mArrayUriList: ArrayList<Uri> = java.util.ArrayList()
    var parts_list: MutableList<MultipartBody.Part> = arrayListOf()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_update_step_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //todo get bundle arguments data...
        try {
            val args = arguments ?: return
            if (args != null) {
                id = args.getString("id").toString()
                stepTwoBusinessList = args.getSerializable("step_two_item_list") as StepOneItemListsModel.BusinessItemsList
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        initView(view)
        setDefaultData(stepTwoBusinessList)
    }

    //todo initialization view...
    private fun initView(view: View) {
        editBusinessListingBack = view.findViewById(R.id.editBusinessListingBack)
        et_gallery_tilte = view.findViewById(R.id.et_gallery_tilte)
        rv_show_image_list = view.findViewById(R.id.rv_show_image_list)
        rv_add_new_images = view.findViewById(R.id.rv_add_new_images)
        btn_update_step_2 = view.findViewById(R.id.btn_update_step_2)
        addPic = view.findViewById(R.id.addPic)

        linearLayoutManager = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        rv_show_image_list.layoutManager = linearLayoutManager

        newImageLinearLayout = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        rv_add_new_images.layoutManager = newImageLinearLayout

        editBusinessListingBack.setOnClickListener {
            MainActivity.navController.navigate(R.id.action_updateStepTwoFragment_to_StepTwoBusinessListFragment)
        }

        btn_update_step_2.setOnClickListener {
            updateStepTwoDetails()
        }

        //todo add images..
        addPic.setOnClickListener {
            getPictureDialog()
        }
    }

    //todo set default text fields...
    private fun setDefaultData(stepTwoBusinessList: StepOneItemListsModel.BusinessItemsList) {
        et_gallery_tilte.setText(stepTwoBusinessList.name)

        //todo set server multiple images in recycler view list..
        val strs = stepTwoBusinessList.gallery_image.split(",").toTypedArray()
        Log.e("string_image---", strs.toString())
        if (strs.isNotEmpty()) {
            rv_add_new_images.visibility = View.GONE
            var galleryImageAdapter: GalleryImageAdapter = GalleryImageAdapter(mContext, strs)
            rv_show_image_list.adapter = galleryImageAdapter
        }
    }

    //todo submit step - 2 payment details...
    private fun updateStepTwoDetails() {
        //todo convert multi image array list into multipartBody.part form....
        try {
            if (!mArrayUriList.isNullOrEmpty() || mArrayUriList.size > 0) {
                for (i in 0 until mArrayUriList.size) {
                    parts_list.add(prepareFilePart("files[]", mArrayUriList[i])!!)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        if (et_gallery_tilte.text.toString().isNullOrEmpty()) {
            MDToast.makeText(mContext, "The title field is required", MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR).show()
        }else if (mArrayUriList.isNullOrEmpty()){
            MDToast.makeText(mContext, "Please Choose Image First for update.", MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR).show()
        } else {
            try {
                var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
                var businessID = CommonUtil.getIntPreferences(mContext, AppConstants.BUSINESS_ID)
                val requestUserID: RequestBody = if (userID!!.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), userID) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
                val requestID: RequestBody = if (userID!!.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), id) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
                val requestBusinessID: RequestBody = if (businessID!! != null) RequestBody.create("text/plain".toMediaTypeOrNull(), businessID.toString()) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
                var requestGalleryTitle: RequestBody = RequestBody.create("multipart/form-data".toMediaTypeOrNull(), et_gallery_tilte.text.toString())

                if (CommonUtil.checkNetwork(mContext)) {
                    CommonUtil.showDialog(mContext)
                    val apiServices = GbusinessService.create(mContext)
                    if (userID != null) {
                        apiServices.updateStepTwoItem("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), requestID,
                            requestGalleryTitle, requestUserID, requestBusinessID, parts_list).apply {
                            enqueue(object : Callback<BusinessListStepOneModel> {
                                override fun onResponse(call: Call<BusinessListStepOneModel>, response: Response<BusinessListStepOneModel>) {
                                    try {
                                        if (response.isSuccessful) {
                                            CommonUtil.hideDialog(mContext)
                                            businessListStepOneModel_gl = response.body()!!
                                            if (businessListStepOneModel_gl.success && businessListStepOneModel_gl != null) {
                                                MDToast.makeText(requireActivity(), businessListStepOneModel_gl.message, MDToast.LENGTH_SHORT, MDToast.TYPE_SUCCESS).show()
                                                MainActivity.navController.navigate(R.id.action_updateStepTwoFragment_to_StepTwoBusinessListFragment)
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
                                    MDToast.makeText(requireActivity(), t.message, MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR).show()
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


    //todo bind adapter for upload images..
    fun bindGalleryImagesAdapter(mArrayUriList: ArrayList<Uri>?) {
        rv_add_new_images.visibility = View.VISIBLE
        rv_show_image_list.visibility = View.GONE
        stepTwoGalleryImagesAdapter = StepTwoGalleryImagesAdapter(mContext, mArrayUriList!!)
        linearLayoutManager = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        rv_add_new_images.layoutManager = linearLayoutManager
        rv_add_new_images.adapter = stepTwoGalleryImagesAdapter
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
            i.setType("image/*");
            i.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
            i.setAction(Intent.ACTION_GET_CONTENT);
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
                        var cout: Int = data.clipData!!.itemCount
                        var imageurl: Uri? = null
                        for (i in 0 until cout) {
                            imageurl = data.clipData!!.getItemAt(i).uri
                            Log.e("mutlifilesUri [" + imageurl + "] : ", imageurl.toString());
                            mArrayUriList?.add(imageurl)
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
                mArrayUriList.add(fileUri)
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

}