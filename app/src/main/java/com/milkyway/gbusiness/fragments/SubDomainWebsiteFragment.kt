package com.milkyway.gbusiness.fragments

import android.app.Activity
import android.app.Dialog
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.provider.Telephony
import android.text.Editable
import android.text.TextUtils
import android.util.Log
import android.view.*
import android.webkit.URLUtil
import android.widget.*
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.github.drjacky.imagepicker.ImagePicker
import com.google.android.material.tabs.TabLayout
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.activities.FullImageActivity
import com.milkyway.gbusiness.activities.MainActivity
import com.milkyway.gbusiness.adaptor.*
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.*
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.global.CommonUtil
import com.milkyway.gbusiness.global.FileUtils
import com.milkyway.gbusiness.global.MyRadioButton
import com.squareup.picasso.Picasso
import id.ionbit.ionalert.IonAlert
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.dlg_get_quote.view.*
import kotlinx.android.synthetic.main.dlg_get_quote.view.ivCancel
import kotlinx.android.synthetic.main.dlg_share_business_list.view.*
import kotlinx.android.synthetic.main.dlg_submit_review.view.*
import kotlinx.android.synthetic.main.fragment_rating_review.*
import kotlinx.android.synthetic.main.fragment_sub_domain_website.*
import kotlinx.android.synthetic.main.recyclerview_item_business_category_details.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File
import java.io.UnsupportedEncodingException
import java.net.URLEncoder
import java.text.DecimalFormat


// TODO: Rename parameter arguments, choose names that match
/**
 * A simple [Fragment] subclass.
 * Use the [SubDomainWebsiteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SubDomainWebsiteFragment : Fragment(), PaymentGatewayAdaptor.PaymentGatewayAdaptorClick, SocialMediaAdaptor.SocialMediaAdaptorClick, SellerLinksAdaptor.SellerLinksAdaptorClick, BusinessGalleryAdaptor.OnGalleryAdaptorClick, BusinessServiceAdaptor.OnBusinessServiceAdaptorClick {
    private lateinit var mContext: Context
    private lateinit var args: Bundle
    private lateinit var subdomainWebSiteBack: ImageView
    private lateinit var ivNoGallery: ImageView
    private lateinit var rvPaymentGateway: RecyclerView
    private lateinit var rvReviews: RecyclerView
    private lateinit var rvBusinessHrs: RecyclerView
    private lateinit var rvGalleryImages: RecyclerView
    private val payQRCodeList = ArrayList<PaymentGatewayData>()
    private val hrsList = ArrayList<BusinessHrsDataClass.HrsData>()
    private lateinit var viewPager2: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var layoutView: LinearLayout
    private lateinit var layoutMap: LinearLayout
    private lateinit var layoutMail: LinearLayout
    private lateinit var layoutWriteReview: LinearLayout
    private lateinit var layoutEditThis: LinearLayout
    private lateinit var layoutChangeCampaign: LinearLayout
    private lateinit var layoutWhatsapp: LinearLayout
    private lateinit var rbAboutUs: MyRadioButton
    private lateinit var rbAlsoListed: MyRadioButton
    private lateinit var rbWorkingHrs: MyRadioButton
    private lateinit var rbSocialMedia: MyRadioButton
    private lateinit var rbSellerLink: MyRadioButton
    private lateinit var rbReview: MyRadioButton

    private lateinit var layoutAboutUs: View
    private lateinit var layoutAlsoListed: View
    private lateinit var layoutWorkingHrs: View
    private lateinit var layoutSocialMedia: View
    private lateinit var layoutSellerLinks: View
    private lateinit var layoutReview: View
    private lateinit var mView: View

    private lateinit var tvTitleBusiness: TextView
    private lateinit var ivBannerSubdomain: ImageView
    private lateinit var tvQrNotFound: TextView
    private lateinit var tvTitleBusinessAboutUs: TextView
    private lateinit var tvDescription: TextView
    private lateinit var tvAvgRatingValue: TextView
    private lateinit var tvVotesValue: TextView
    private lateinit var tvLocation: TextView
    private lateinit var tvLocationAboutUs: TextView
    private lateinit var tvMobile: TextView
    private lateinit var tvMobileAboutUs: TextView
    private lateinit var tvBusinessEstablishedDate: TextView
    private lateinit var etNameReview: EditText
    private lateinit var etEmailReview: EditText
    private lateinit var etMobileReview: EditText
    private lateinit var etCommentReview: EditText
    private lateinit var ratingBar: RatingBar
    private lateinit var businessName: String
    private lateinit var businessId: String
    private lateinit var businessPhone: String
    private lateinit var subDomainUrl: String
    private lateinit var ratingBarReview: RatingBar
    private lateinit var btnSubmitReview: Button
    private var addRatingValue: Float = 0.0f
    private lateinit var addRatingResponse: AddReviewsDataClass

    private lateinit var getData: GalleryResponseDataClass
    private lateinit var getReviewsResponse: GetReviewsDataClass
    private lateinit var getPaymentData: BusinessPaymentDataClass
    private var rvSocialMedia: RecyclerView? = null
    private var socialMediaAdaptor: SocialMediaAdaptor? = null
    private var socialMediaList = ArrayList<SocialMediaData>()
    private var rvSellerLink: RecyclerView? = null
    private var rvBusinessServices: RecyclerView? = null
    private var sellerLinksAdaptor: SellerLinksAdaptor? = null
    private var bServiceAdapter: BusinessServiceAdaptor? = null
    private var sellerLinkList = ArrayList<SellerLinkData>()
    private var bServiceList = ArrayList<BusinessServiceModelClass.Data>()
    private var notAvailable: String = "Not Available"
    private var shareBusinessListText: String = ""
    private lateinit var ratingBarReviewDlg: RatingBar
    private lateinit var etQuery: EditText
    private lateinit var tvFileName: TextView
    private lateinit var btnSubmitQuery: Button
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
        val view = inflater.inflate(R.layout.fragment_sub_domain_website, container, false)
        initializeView(view)
        clickListener(view)
        return view
    }

    private fun initializeView(view: View) {
        subdomainWebSiteBack = view.findViewById(R.id.businessSubdomainBack)
        rvPaymentGateway = view.findViewById(R.id.rvPaymentGateway)
        rvReviews = view.findViewById(R.id.rvReviews)
        rvBusinessHrs = view.findViewById(R.id.rvBusinessHours)
        rvGalleryImages = view.findViewById(R.id.rvGalleryImages)
        tabLayout = view.findViewById(R.id.tabLayout)
        viewPager2 = view.findViewById(R.id.viewPager2)
        layoutView = view.findViewById(R.id.layoutView)

        tvQrNotFound = view.findViewById(R.id.tvQrNotFound)
        tvTitleBusiness = view.findViewById(R.id.tvTitleBusiness)
        ivBannerSubdomain = view.findViewById(R.id.ivBannerSubdomain)
        ivNoGallery = view.findViewById(R.id.ivNoGallery)
        tvTitleBusinessAboutUs = view.findViewById(R.id.tvTitleBusinessAboutUs)
        tvDescription = view.findViewById(R.id.tvDescription)
        tvAvgRatingValue = view.findViewById(R.id.tvAvgRatingValue)
        ratingBar = view.findViewById(R.id.ratingBar)
        tvVotesValue = view.findViewById(R.id.tvVotesValue)
        tvLocation = view.findViewById(R.id.tvLocation)
        tvLocationAboutUs = view.findViewById(R.id.tvLocationAboutUs)
        tvMobile = view.findViewById(R.id.tvMobile)
        tvMobileAboutUs = view.findViewById(R.id.tvMobileAboutUs)
        tvBusinessEstablishedDate = view.findViewById(R.id.tvBusinessEstablishedDate)
        layoutMap = view.findViewById(R.id.layoutMap)
        layoutMail = view.findViewById(R.id.layoutMail)
        layoutWriteReview = view.findViewById(R.id.layoutWriteReview)
        layoutEditThis = view.findViewById(R.id.layoutEditThis)
        layoutChangeCampaign = view.findViewById(R.id.layoutChangeCampaign)
        layoutWhatsapp = view.findViewById(R.id.layoutWhatsapp)

        rbAboutUs = view.findViewById(R.id.rbAboutUs)
        rbAlsoListed = view.findViewById(R.id.rbAlsoListed)
        rbWorkingHrs = view.findViewById(R.id.rbWorkingHrs)
        rbSocialMedia = view.findViewById(R.id.rbSocialMedia)
        rbSellerLink = view.findViewById(R.id.rbSellerLink)
        rbReview = view.findViewById(R.id.rbReview)

        layoutAboutUs = view.findViewById(R.id.layoutAboutUs)
        layoutAlsoListed = view.findViewById(R.id.layoutAlsoListed)
        layoutWorkingHrs = view.findViewById(R.id.layoutWorkingHrs)
        layoutSocialMedia = view.findViewById(R.id.layoutSocialMedia)
        layoutSellerLinks = view.findViewById(R.id.layoutSellerLinks)
        layoutReview = view.findViewById(R.id.layoutReview)

        rvSocialMedia = view.findViewById(R.id.rvSocialMedia)
        rvSellerLink = view.findViewById(R.id.rvSellerLink)
        rvBusinessServices = view.findViewById(R.id.rvBusinessServices)
        ratingBarReview = view.findViewById(R.id.ratingBarReview)
        btnSubmitReview = view.findViewById(R.id.btnSubmitReview)

        etNameReview = view.findViewById(R.id.etNameReview)
        etEmailReview = view.findViewById(R.id.etEmailReview)
        etMobileReview = view.findViewById(R.id.etMobileReview)
        etCommentReview = view.findViewById(R.id.etCommentReview)

        etQuery = view.findViewById(R.id.etQuery)
        tvFileName = view.findViewById(R.id.tvFileName)
        btnSubmitQuery = view.findViewById(R.id.btnSubmitQuery)

        ratingBarReview.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            addRatingValue = rating
        }

        args = requireArguments()
        if (args != null) {
            val sunday = args.getString("sunday").toString()
            val sundayStart = args.getString("sunday_start_time").toString()
            val sundayEnd = args.getString("sunday_end_time").toString()
            val monday = args.getString("monday").toString()
            val mondayStart = args.getString("monday_start_time").toString()
            val mondayEnd = args.getString("monday_end_time").toString()
            val tuesday = args.getString("tuesday").toString()
            val tuesdayStart = args.getString("tuesday_start_time").toString()
            val tuesdayEnd = args.getString("tuesday_end_time").toString()
            val wednesday = args.getString("wednesday").toString()
            val wednesdayStart = args.getString("wednesday_start_time").toString()
            val wednesdayEnd = args.getString("wednesday_end_time").toString()
            val thirsday = args.getString("thirsday").toString()
            val thirsdayStart = args.getString("thirsday_start_time").toString()
            val thirsdayEnd = args.getString("thirsday_end_time").toString()
            val friday = args.getString("friday").toString()
            val fridayStart = args.getString("friday_start_time").toString()
            val fridayEnd = args.getString("friday_end_time").toString()
            val saturday = args.getString("saturday").toString()
            val saturdayStart = args.getString("saturday_start_time").toString()
            val saturdayEnd = args.getString("saturday_end_time").toString()
            setBusinessHrsAdapter(sunday, sundayStart, sundayEnd, monday, mondayStart, mondayEnd, tuesday, tuesdayStart, tuesdayEnd, wednesday, wednesdayStart, wednesdayEnd,
                thirsday, thirsdayStart, thirsdayEnd, friday, fridayStart, fridayEnd, saturday, saturdayStart, saturdayEnd)
            setData(args)
        }
        //setReviewsAdapter()
        //setBusinessHrsAdapter()
        callGetReviewsApi()
        callGalleryApi(args)
        callBServiceAdapter()
        callPaymentMethodApi(args)
    }

    private fun callGetReviewsApi() {
        if (CommonUtil.checkNetwork(requireActivity())) {

            val apiServices = GbusinessService.create(mContext)
            val businessId = args.getInt("id", 0)
            apiServices.getBusinessReviewRating(businessId)
                .enqueue(object : Callback<GetReviewsDataClass> {
                    override fun onFailure(call: Call<GetReviewsDataClass>, t: Throwable) {

                        CommonUtil.toast(R.string.showError.toString(), requireActivity())
                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(
                        call: Call<GetReviewsDataClass>,
                        response: Response<GetReviewsDataClass>,
                    ) {
                        getReviewsResponse = response.body()!!
                        if (getReviewsResponse != null) {
                            val reviewList = getReviewsResponse.data
                            val avgRatingVal = getAverageRatingValue(reviewList)

                            if (avgRatingVal.contentEquals("0")) {
                                tvAvgRatingValue.text = "0.0"
                                ratingBar.rating = "0.0".toFloat()
                            } else {
                                tvAvgRatingValue.text = avgRatingVal.toFloat().toString()
                                ratingBar.rating = avgRatingVal.toFloat()
                            }
                            //Toast.makeText(requireActivity(), "Sum: $avgRatingVal", Toast.LENGTH_LONG).show()
                            setReviewsAdapter(reviewList)

                        } else CommonUtil.toast(R.string.showError.toString(), requireActivity())
                    }
                })
        } else {
            CommonUtil.toast("Check Internet", requireActivity())
        }
    }

    private fun getAverageRatingValue(reviewList: List<GetReviewsDataClass.Data>): String {
        var res = 0.0
        val format = DecimalFormat("#.##")
        try {
            var sum = 0.0

            for (i in reviewList.indices) {
                if (reviewList[i].starRating > 0) {
                    sum += reviewList[i].starRating.toDouble()
                }
                res = (sum / reviewList.size.toDouble())
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return format.format(res)
    }

    private fun callBServiceAdapter() {
        rvBusinessServices?.layoutManager = GridLayoutManager(context, 3)
        bServiceList.add(BusinessServiceModelClass.Data(1, "Accommodation Services"))
        bServiceList.add(BusinessServiceModelClass.Data(2, "Beverage Suppliers"))
        bServiceList.add(BusinessServiceModelClass.Data(3, "Business Services"))
        bServiceList.add(BusinessServiceModelClass.Data(4, "City Attractions"))
        bServiceList.add(BusinessServiceModelClass.Data(5, "Clinics And Doctors"))
        bServiceList.add(BusinessServiceModelClass.Data(6, "Accommodation Services"))
        bServiceList.add(BusinessServiceModelClass.Data(7, "Beverage Suppliers"))
        bServiceList.add(BusinessServiceModelClass.Data(8, "Business Services"))
        bServiceList.add(BusinessServiceModelClass.Data(9, "City Attractions"))
        bServiceList.add(BusinessServiceModelClass.Data(10, "Clinics And Doctors"))
        bServiceList.add(BusinessServiceModelClass.Data(9, "City Attractions"))
        bServiceAdapter = BusinessServiceAdaptor(requireActivity(), this, bServiceList)
        rvBusinessServices?.adapter = bServiceAdapter
    }

    private fun setBusinessHrsAdapter(
        sunday: String,
        sundayStart: String,
        sundayEnd: String,
        monday: String,
        mondayStart: String,
        mondayEnd: String,
        tuesday: String,
        tuesdayStart: String,
        tuesdayEnd: String,
        wednesday: String,
        wednesdayStart: String,
        wednesdayEnd: String,
        thirsday: String,
        thirsdayStart: String,
        thirsdayEnd: String,
        friday: String,
        fridayStart: String,
        fridayEnd: String,
        saturday: String,
        saturdayStart: String,
        saturdayEnd: String,
    ) {
        rvBusinessHrs.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        /*hrsList.add(BusinessHrsDataClass.HrsData("Monday", "09:00 AM", "06:00 PM"))
        hrsList.add(BusinessHrsDataClass.HrsData("Tuesday", "09:30 PM", "06:30 AM"))
        hrsList.add(BusinessHrsDataClass.HrsData("Wednesday", "", ""))
        hrsList.add(BusinessHrsDataClass.HrsData("Thursday", "09:00 AM", "06:00 PM"))
        hrsList.add(BusinessHrsDataClass.HrsData("Friday", "10:00 AM", "07:00 PM"))
        hrsList.add(BusinessHrsDataClass.HrsData("Saturday", "09:00 AM", "06:00 PM"))
        hrsList.add(BusinessHrsDataClass.HrsData("Sunday", "", ""))*/
        hrsList.add(BusinessHrsDataClass.HrsData(monday, mondayStart, mondayEnd))
        hrsList.add(BusinessHrsDataClass.HrsData(tuesday, tuesdayStart, tuesdayEnd))
        hrsList.add(BusinessHrsDataClass.HrsData(wednesday, wednesdayStart, wednesdayEnd))
        hrsList.add(BusinessHrsDataClass.HrsData(thirsday, thirsdayStart, thirsdayEnd))
        hrsList.add(BusinessHrsDataClass.HrsData(friday, fridayStart, fridayEnd))
        hrsList.add(BusinessHrsDataClass.HrsData(saturday, saturdayStart, saturdayEnd))
        hrsList.add(BusinessHrsDataClass.HrsData(sunday, sundayStart, sundayEnd))


        // This will pass the ArrayList to our Adapter
        val adapter = BusinessHrsAdaptor(requireActivity(), hrsList)

        // Setting the Adapter with the recyclerview
        rvBusinessHrs.adapter = adapter
    }

    private fun callGalleryApi(args: Bundle) {
        if (CommonUtil.checkNetwork(requireActivity())) {

            val apiServices = GbusinessService.create(mContext)

            apiServices.getGalleryList()
                .enqueue(object : Callback<GalleryResponseDataClass> {
                    override fun onFailure(call: Call<GalleryResponseDataClass>, t: Throwable) {

                        CommonUtil.toast(R.string.showError.toString(), requireActivity())
                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(
                        call: Call<GalleryResponseDataClass>,
                        response: Response<GalleryResponseDataClass>,
                    ) {
                        getData = response.body()!!
                        CommonUtil.logi(getData.toString())
                        if (getData != null) {
                            setGalleryAdapter(getData, args)

                        } else CommonUtil.toast(R.string.showError.toString(), requireActivity())
                    }

                })
        } else {
            CommonUtil.toast("Check Internet", requireActivity())
        }
    }

    private fun callPaymentMethodApi(args: Bundle) {
        if (CommonUtil.checkNetwork(requireActivity())) {

            val apiServices = GbusinessService.create(mContext)

            apiServices.getBusinessPaymentList()
                .enqueue(object : Callback<BusinessPaymentDataClass> {
                    override fun onFailure(call: Call<BusinessPaymentDataClass>, t: Throwable) {
                        CommonUtil.toast(R.string.showError.toString(), requireActivity())
                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(
                        call: Call<BusinessPaymentDataClass>,
                        response: Response<BusinessPaymentDataClass>,
                    ) {
                        getPaymentData = response.body()!!
                        CommonUtil.logi(getPaymentData.toString())
                        if (getPaymentData != null) {
                            val list = getPaymentData.data
                            if (list.isNotEmpty()) {
                                rvPaymentGateway.visibility = View.VISIBLE
                                tvQrNotFound.visibility = View.INVISIBLE
                            } else {
                                rvPaymentGateway.visibility = View.GONE
                                tvQrNotFound.visibility = View.VISIBLE
                            }

                            val bIdInList = args.getInt("id", 0)
                            var businessId = ""
                            var bankDetails = ""
                            var createdAt = ""
                            var email = ""
                            var id = 0
                            var name = ""
                            var paymentUrl = ""
                            var pmethodImage = ""
                            var updatedAt = ""
                            var userId = ""

                            for (i in list.indices) {
                                businessId = list[i].businessId
                                bankDetails = list[i].bankDetails
                                createdAt = list[i].createdAt
                                email = list[i].email
                                id = list[i].id
                                name = list[i].name
                                paymentUrl = list[i].paymentUrl
                                pmethodImage = list[i].pmethodImage
                                updatedAt = list[i].updatedAt
                                userId = list[i].userId

                                if (businessId.contentEquals(bIdInList.toString())) {

                                    val newList = ArrayList<BusinessPaymentDataClass.Data>()
                                    val mBankDetail = if (bankDetails != null) bankDetails else ""
                                    val mName = if (name != null) name else ""
                                    val mEmail = if (email != null) email else ""
                                    val mPaymentUrl = if (paymentUrl != null) paymentUrl else ""
                                    val mPayMethodImage = if (pmethodImage != null) pmethodImage else ""
                                    /* if (bankDetails != null) {*/
                                    newList.add(BusinessPaymentDataClass.Data(mBankDetail, businessId, createdAt, mEmail, id, mName, mPaymentUrl, mPayMethodImage, updatedAt, userId))
                                    /*} else
                                        newList.add(BusinessPaymentDataClass.Data("", businessId, createdAt, email, id, name, paymentUrl, pmethodImage, updatedAt, userId))*/
                                    setPaymentDataAdapter(newList)
                                }
                            }
                        } else
                            CommonUtil.toast(R.string.showError.toString(), requireActivity())
                    }

                })
        } else {
            CommonUtil.toast("Check Internet", requireActivity())
        }
    }

    private fun setPaymentDataAdapter(list: List<BusinessPaymentDataClass.Data>) {
        rvPaymentGateway.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val adapter = PaymentGatewayAdaptor(requireActivity(), this, list)
        rvPaymentGateway.adapter = adapter
    }

    private fun setGalleryAdapter(data: GalleryResponseDataClass, args: Bundle) {
        val list = data.data
        var uriString: String?
        var bId: String?
        var name: String?
        for (i in list.indices) {
            uriString = list[i].galleryImage
            name = list[i].name
            bId = list[i].businessId
            val id = args.getInt("id", 0)
            if (bId.contentEquals(id.toString())) {

                val listGallery = ArrayList<GalleryModelData.Data>()
                val urls = uriString?.split(",")?.toTypedArray()
                for (j in urls.indices) {

                    listGallery.add(GalleryModelData.Data(bId, name, urls[j]))
                }

                if (listGallery.size > 0) {
                    rvGalleryImages.visibility = View.VISIBLE
                    ivNoGallery.visibility = View.INVISIBLE
                    rvGalleryImages.layoutManager = GridLayoutManager(context, 4)
                    val adapter = BusinessGalleryAdaptor(requireActivity(), this, listGallery)
                    rvGalleryImages.adapter = adapter
                    adapter.notifyDataSetChanged()
                } else {
                    ivNoGallery.visibility = View.VISIBLE
                    rvGalleryImages.visibility = View.INVISIBLE
                }
            }
        }
    }

    private fun getArrayOfUrls(str: String): MutableList<String> {
        /*"[^A-Za-z0-9]".toRegex().apply {
            yourArray[0] = replace(yourArray[0], "")
        }*/
        return str.split(",").toMutableList()
    }

    private fun alertRatingReviewDialog() {
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
            mView = mInflater.inflate(R.layout.dlg_submit_review, null, false)

            val finalDialog: Dialog = dialog
            mView.btnSubmitReviewDlg.setOnClickListener {

                ratingBarReviewDlg = mView.ratingBarReviewDlg

                if (isValidate(mView.etNameReviewDlg, mView.etEmailReviewDlg, mView.etMobileReviewDlg, mView.etCommentReviewDlg)) {
                    val ratingVal = ratingBarReviewDlg.rating
                    if (ratingVal == 0.0f) {
                        val ionAlert = IonAlert(requireActivity(), IonAlert.ERROR_TYPE)
                        ionAlert.titleText = "Rating alert!"
                        ionAlert.contentText = "Before submitting, you have to give rating as per your experience!"
                        ionAlert.show()
                        //Toast.makeText(requireActivity(), "Before submitting you have to select rating value as per your experience.", Toast.LENGTH_LONG).show()
                    } else {
                        val name = mView.etNameReviewDlg.text.toString()
                        val email = mView.etEmailReviewDlg.text.toString()
                        val phone = mView.etMobileReviewDlg.text.toString()
                        val comment = mView.etCommentReviewDlg.text.toString()
                        //Toast.makeText(requireActivity(), "selected rating : $ratingVal", Toast.LENGTH_LONG).show()
                        callAddRatingApi(ratingVal, name, email, phone, comment)
                        finalDialog.dismiss()
                    }
                } /*else
                    Toast.makeText(requireActivity(), "No validate", Toast.LENGTH_LONG).show()*/
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

    private fun setReviewsAdapter(reviewList: List<GetReviewsDataClass.Data>) {
        rvReviews.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        // This will pass the ArrayList to our Adapter
        val adapter = BusinessReviewsAdaptor(requireActivity(), reviewList)
        // Setting the Adapter with the recyclerview
        rvReviews.adapter = adapter
    }

    private fun setSocialMediaAdapter(facebookUrl: String, linkedinUrl: String, twitterUrl: String, instagramUrl: String) {
        rvSocialMedia?.layoutManager = GridLayoutManager(context, 2)
        if (!facebookUrl.contentEquals("null"))
            socialMediaList.add(SocialMediaData("Facebook", facebookUrl, R.drawable.ic_facebook))
        else
            socialMediaList.add(SocialMediaData("Facebook", "https://www.facebook.com/", R.drawable.ic_facebook))
        if (!linkedinUrl.contentEquals("null"))
            socialMediaList.add(SocialMediaData("Linkedin", linkedinUrl, R.drawable.ic_linkedin))
        else
            socialMediaList.add(SocialMediaData("Linkedin", "https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin", R.drawable.ic_linkedin))
        if (!twitterUrl.contentEquals("null"))
            socialMediaList.add(SocialMediaData("Twitter", twitterUrl, R.drawable.ic_twitter))
        else
            socialMediaList.add(SocialMediaData("Twitter", "https://twitter.com/i/flow/login", R.drawable.ic_twitter))
        if (!instagramUrl.contentEquals("null"))
            socialMediaList.add(SocialMediaData("Instagram", instagramUrl, R.drawable.ic_instagram))
        else
            socialMediaList.add(SocialMediaData("Instagram", "https://www.instagram.com/accounts/login/", R.drawable.ic_instagram))
        socialMediaAdaptor = SocialMediaAdaptor(requireActivity(), this, socialMediaList)
        rvSocialMedia?.adapter = socialMediaAdaptor
    }

    private fun setData(args: Bundle) {
        businessName = args.getString("businessName").toString()
        val businessLogo = args.getString("businessLogoUrl")
        val businessEmail = args.getString("businessEmail").toString()
        businessPhone = args.getString("businessPhone").toString()
        //businessWebUrl = args.getString("businessWebUrl").toString()
        subDomainUrl = args.getString("subDomainUrl").toString()
        val sellerUrl = args.getString("sellerUrl").toString()
        val facebookUrl = args.getString("facebookUrl").toString()
        val linkedinUrl = args.getString("linkedinUrl").toString()
        val twitterUrl = args.getString("twitterUrl").toString()
        val instagramUrl = args.getString("instagramUrl").toString()
        val businessAboutUs = args.getString("businessAboutUs").toString()
        val city = args.getString("city")
        val establishedDate = args.getString("establish_date")
        val address = args.getString("address")
        val zipCode = args.getInt("zipCode", 0)
        //id = args.getInt("id", 0)
        //countryId = args.getInt("countryId", 0)
        //stateId = args.getInt("stateId", 0)
        //catId = args.getInt("catId", 0)
        //subCatId = args.getInt("subCatId", 0)
        //callCategoryApi()
        //callGetCountriesApi()
        val userName = CommonUtil.getPreferencesString(requireActivity(), AppConstants.FULL_NAME)
        shareBusinessListText = "Hi\n" +
                "Your friend $userName has shared a business listing with you.\n" +
                "Check out this listing on GBusiness Listing.\n" +
                "$businessName\n" +
                "https://$subDomainUrl.gbusiness.co" // Replace with your message.
        val urlLogo = GbusinessService.BASE_IMG_URL + businessLogo
        if (URLUtil.isValidUrl(urlLogo)) {
            Picasso
                .get()
                .load(urlLogo)
                .into(ivBannerSubdomain)
        } else {
            val urlDefault = "https://www.gbusiness.co/public/business_images/default-business-logo.jpg"
            Picasso
                .get()
                .load(urlDefault)
                .into(ivBannerSubdomain)
        }
        if (businessName != null) {

            tvTitleBusiness.text = businessName
            tvTitleBusinessAboutUs.text = businessName
        } else
            tvTitleBusiness.text = notAvailable
        if (address != null) {

            tvLocation.text = address
            tvLocationAboutUs.text = address
        } else
            tvLocation.text = notAvailable
        if (businessPhone != null) {

            tvMobile.text = businessPhone
            tvMobileAboutUs.text = businessPhone
        } else
            tvMobile.text = notAvailable
        if (establishedDate != null) {
            tvBusinessEstablishedDate.text = establishedDate
        } else
            tvBusinessEstablishedDate.text = "YYYY-MM-DD"

        if (businessAboutUs != null) {
            tvDescription.text = businessAboutUs
        } else
            tvDescription.text = notAvailable
        setSocialMediaAdapter(facebookUrl, linkedinUrl, twitterUrl, instagramUrl)
        setSellerLinksAdapter()
    }

    private fun setSellerLinksAdapter() {
        //rvSellerLink?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvSellerLink?.layoutManager = GridLayoutManager(context, 2)
        sellerLinkList.add(SellerLinkData("Alibaba", "https://www.alibaba.com/", R.drawable.ic_alibaba))
        sellerLinkList.add(SellerLinkData("Amazon", "https://www.amazon.com/", R.drawable.ic_amazon))
        sellerLinkList.add(SellerLinkData("Ebay", "https://www.ebay.com/", R.drawable.ic_ebay))
        sellerLinkList.add(SellerLinkData("Etsy", "https://www.etsy.com/", R.drawable.ic_etsy))
        sellerLinkList.add(SellerLinkData("Noon", "https://www.noon.com/uae-en/", R.drawable.ic_noon))
        sellerLinksAdaptor = SellerLinksAdaptor(requireActivity(), this, sellerLinkList)
        rvSellerLink?.adapter = sellerLinksAdaptor
    }

    private fun clickListener(view: View) {
        subdomainWebSiteBack.setOnClickListener {
            val args = arguments
            MainActivity.navController.navigate(R.id.action_businessSubdomainFragment_to_businessListingDetailsFragment, args)
        }
        tvTitleBusiness.setOnClickListener {
//            Toast.makeText(requireActivity(), "Clicked on tvTitleBusiness", Toast.LENGTH_LONG).show()
            alertShareBusinessDialog()
        }
        layoutMap.setOnClickListener {
            Toast.makeText(requireActivity(), "Clicked on layoutMap", Toast.LENGTH_LONG).show()
            val gmmIntentUri =
                Uri.parse("google.navigation:q=${args.getString("address")}")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
        layoutMail.setOnClickListener {
            Toast.makeText(requireActivity(), "Clicked on layoutMail", Toast.LENGTH_LONG).show()
            val subject = "Subject type here"
            val message = "Message type here"

            val intent = Intent(Intent.ACTION_SEND)
            val addressees = arrayOf("")
            intent.putExtra(Intent.EXTRA_EMAIL, addressees)
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent, "Send Email using:"))
        }
        layoutWriteReview.setOnClickListener {
            //Toast.makeText(requireActivity(), "Clicked on layoutWriteReview", Toast.LENGTH_LONG).show()
            alertRatingReviewDialog()
        }
        layoutEditThis.setOnClickListener {
            Toast.makeText(requireActivity(), "Clicked on layoutEditText", Toast.LENGTH_LONG).show()
        }
        layoutChangeCampaign.setOnClickListener {
            Toast.makeText(requireActivity(), "Clicked on layoutChangeCampaign", Toast.LENGTH_LONG).show()
        }
        layoutWhatsapp.setOnClickListener {
            openWhatsApp()
            //Toast.makeText(requireActivity(), "Clicked on layoutWhatsapp", Toast.LENGTH_LONG).show()
        }

        btnSubmitReview.setOnClickListener {

            if (isValidate(etNameReview, etEmailReview, etMobileReview, etCommentReview)) {
                val ratingVal = ratingBarReview.rating
                if (ratingVal == 0.0f) {
                    val ionAlert = IonAlert(requireActivity(), IonAlert.ERROR_TYPE)
                    ionAlert.titleText = "Rating alert!"
                    ionAlert.contentText = "Before submitting, you have to give rating as per your experience!"
                    ionAlert.show()
                    //Toast.makeText(requireActivity(), "Before submitting you have to select rating value as per your experience.", Toast.LENGTH_LONG).show()
                } else {
                    //Toast.makeText(requireActivity(), "selected rating : $ratingVal", Toast.LENGTH_LONG).show()
                    val name = etNameReview.text.toString()
                    val email = etEmailReview.text.toString()
                    val phone = etMobileReview.text.toString()
                    val comment = etCommentReview.text.toString()
                    callAddRatingApi(ratingVal, name, email, phone, comment)
                }
            } /*else
                Toast.makeText(requireActivity(), "No validate", Toast.LENGTH_LONG).show()*/
        }

        tvFileName.setOnClickListener {
            pickScreenShot(view)
        }
        btnSubmitQuery.setOnClickListener {
            if (validateWantToSay()) {
                callWantToSaySomethingApi(mScreenshotImageUri)
                //Toast.makeText(requireActivity(), "Validate", Toast.LENGTH_LONG).show()
            }
        }
        setRadioListeners()
    }

    private fun validateWantToSay(): Boolean {
        val etQueryStr = etQuery.text.toString().trim()
        return when {
            TextUtils.isEmpty(etQueryStr) -> {
                etQuery.error = "Comment field can't be blank."
                etQuery.requestFocus()
                //CommonUtil.warningToast("Select Issue!", "You have to select issue first.", requireActivity())
                false
            }
            CommonUtil.isUriEmpty(mScreenshotImageUri) -> {
                CommonUtil.warningToast("Upload Screenshot", "Please upload screenshot first.", requireActivity())
                false
            }
            else -> true
        }
    }

    private fun pickScreenShot(view: View) {
        ImagePicker.with(requireActivity())
            .crop()
            //.cropOval()
            .maxResultSize(512, 512, true)
            .createIntentFromDialog { logoImageLauncher.launch(it) }
    }

    private val logoImageLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                val uri = it.data?.data!!
                mScreenshotImageUri = uri
                setUploadStr(mScreenshotImageUri!!, tvFileName)
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

    private fun setUploadStr(mScreenshotImageUri: Uri, tvFileName: TextView) {
        if (mScreenshotImageUri != null) {
            val file: File = FileUtils.getFile(requireActivity(), mScreenshotImageUri)
            tvFileName.text = file.name
        } else {
            tvFileName.text = "No file chosen yet."
        }
    }

    private fun callAddRatingApi(ratingVal: Float, name: String, email: String, phone: String, comment: String) {
        if (CommonUtil.checkNetwork(requireActivity())) {
            val id = args.getInt("id", 0)
            //Toast.makeText(requireActivity(), "Business_id:: $id", Toast.LENGTH_LONG).show()

            val apiServices = GbusinessService.create(mContext)
            apiServices.addBusinessReviewRating(id, name, email, phone, comment, ratingVal.toString())
                .enqueue(object : Callback<AddReviewsDataClass> {
                    override fun onFailure(call: Call<AddReviewsDataClass>, t: Throwable) {

                        CommonUtil.toast(R.string.showError.toString(), requireActivity())
                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(
                        call: Call<AddReviewsDataClass>,
                        response: Response<AddReviewsDataClass>,
                    ) {
                        addRatingResponse = response.body()!!
                        if (addRatingResponse.success) {
                            etNameReview.text = Editable.Factory.getInstance().newEditable("")
                            etEmailReview.text = Editable.Factory.getInstance().newEditable("")
                            etMobileReview.text = Editable.Factory.getInstance().newEditable("")
                            etCommentReview.text = Editable.Factory.getInstance().newEditable("")

                            IonAlert(requireActivity(), IonAlert.SUCCESS_TYPE)
                                .setTitleText("Rating Or Reviews!")
                                .setContentText("Thank you for given valuable feedback.")
                                .setConfirmText("Ok")
                                .setConfirmClickListener {
                                    callGetReviewsApi()
                                    it.dismissWithAnimation()
                                }
                                .show()
                            /*val ionAlert = IonAlert(requireActivity(), IonAlert.SUCCESS_TYPE)
                            ionAlert.titleText = "Rating Or Reviews!"
                            ionAlert.contentText = "Thank you for given valuable feedback."
                            ionAlert.show()*/
                        }
                    }

                })
        } else {
            CommonUtil.toast("Check Internet", requireActivity())
        }
    }

    private fun callWantToSaySomethingApi(fileUri: Uri?) {
        var filePhotoLogo: MultipartBody.Part? = null
        if (fileUri != null) {
            try {
                val file: File = FileUtils.getFile(requireActivity(), fileUri)
                if (file.exists()) {
                    val requestBody: RequestBody = RequestBody.create("*/*".toMediaTypeOrNull(), file)
                    filePhotoLogo = MultipartBody.Part.createFormData("attachement", file.name, requestBody)
                }
            } catch (e: NullPointerException) {
                e.printStackTrace()
            }
        } else {
            val attachmentEmpty = RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            filePhotoLogo = MultipartBody.Part.createFormData("attachement", "", attachmentEmpty)
        }

        try {
            val queryMessage = etQuery.text.toString().trim()
            val businessEmail = args.getString("businessEmail")
            val businessName = args.getString("businessName")
            val authToken = "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN)
            Toast.makeText(requireActivity(), "query: $queryMessage\nEmail: $businessEmail\nName: $businessName", Toast.LENGTH_LONG).show()
            val rbQuery: RequestBody = if (queryMessage.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), queryMessage) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbBusinessEmail: RequestBody = if (businessEmail!!.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), businessEmail) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")
            val rbBusinessName: RequestBody = if (businessName!!.isNotEmpty()) RequestBody.create("text/plain".toMediaTypeOrNull(), businessName) else RequestBody.create("text/plain".toMediaTypeOrNull(), "")

            if (CommonUtil.checkNetwork(mContext)) {
                val apiServices = GbusinessService.create(mContext)
                CommonUtil.showDialog(mContext)
                apiServices.wantSaySomething(authToken, rbQuery, rbBusinessEmail, rbBusinessName, filePhotoLogo!!)
                    .enqueue(object : Callback<WantSaySomethingDataClass> {
                        override fun onResponse(call: Call<WantSaySomethingDataClass>, response: Response<WantSaySomethingDataClass>) {
                            CommonUtil.hideDialog(mContext)
                            val wantToSayResponse = response.body()
                            if (wantToSayResponse != null && wantToSayResponse.success) {

                                etQuery.text = Editable.Factory.getInstance().newEditable("")
                                tvFileName.text = ""
                                tvFileName.hint = "No File Chosen"
                                CommonUtil.successToast("Feedback!", "${wantToSayResponse.message}", requireActivity())
                                //MainActivity.navController.navigate(R.id.action_addTicketFragment_to_supportFragment)
                            }
                        }

                        override fun onFailure(call: Call<WantSaySomethingDataClass>, t: Throwable) {
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

    private fun setRadioListeners() {
        rbAboutUs.setOwnOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                layoutAboutUs.visibility = View.VISIBLE
            } else
                layoutAboutUs.visibility = View.GONE
            //Toast.makeText(requireActivity(), "Click on about us", Toast.LENGTH_LONG).show()
        }

        rbAlsoListed.setOwnOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                layoutAlsoListed.visibility = View.VISIBLE
            } else
                layoutAlsoListed.visibility = View.GONE
            //Toast.makeText(requireActivity(), "Click on about us", Toast.LENGTH_LONG).show()
        }

        rbWorkingHrs.setOwnOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                layoutWorkingHrs.visibility = View.VISIBLE
            } else
                layoutWorkingHrs.visibility = View.GONE
            //Toast.makeText(requireActivity(), "Click on about us", Toast.LENGTH_LONG).show()
        }
        rbSocialMedia.setOwnOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                layoutSocialMedia.visibility = View.VISIBLE
            } else
                layoutSocialMedia.visibility = View.GONE
            //Toast.makeText(requireActivity(), "Click on social media", Toast.LENGTH_LONG).show()
        }
        rbSellerLink.setOwnOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                layoutSellerLinks.visibility = View.VISIBLE
            } else
                layoutSellerLinks.visibility = View.GONE
            //Toast.makeText(requireActivity(), "Click on seller links", Toast.LENGTH_LONG).show()
        }
        rbReview.setOwnOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                layoutReview.visibility = View.VISIBLE
            } else
                layoutReview.visibility = View.GONE
            //Toast.makeText(requireActivity(), "Click on review", Toast.LENGTH_LONG).show()
        }
    }

    private fun openWhatsApp() {
        try {
            val text = "Hi" // Replace with your message.
            val toNumber = businessPhone//"7838069435" // Replace with mobile phone number without +Sign or leading zeros, but with country code
            //Suppose your country is India and your phone number is “xxxxxxxxxx”, then you need to send “91xxxxxxxxxx”.
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("http://api.whatsapp.com/send?phone=$toNumber&text=$text")
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onSocialItemClicked(position: Int, list: SocialMediaData) {
        args.putString("back", "SubDomainWebsiteFragment")
        args.putString("webUrl", list.media_link)
        MainActivity.navController.navigate(R.id.action_subDomainWebsiteFragment_to_paymentOrInvoiceWebView, args)
    }

    override fun onSellerLinkItemClicked(position: Int, list: SellerLinkData) {
        args.putString("back", "SubDomainWebsiteFragment")
        args.putString("webUrl", list.sellerLinks)
        MainActivity.navController.navigate(R.id.action_subDomainWebsiteFragment_to_paymentOrInvoiceWebView, args)
    }

    private fun isValidate(etNameReview: EditText, etEmailReview: EditText, etMobileReview: EditText, etCommentReview: EditText): Boolean {
        when {
            TextUtils.isEmpty(etNameReview.text.toString()) -> {
                etNameReview.error = "Name can't be empty."
                etNameReview.requestFocus()
                return false
            }
            TextUtils.isEmpty(etEmailReview.text.toString()) -> {
                etEmailReview.error = "Email can't be empty."
                etEmailReview.requestFocus()
                return false
            }
            CommonUtil.isValidMail(etEmailReview.text.toString()) -> {
                etEmailReview.error = "Please enter valid e-mail."
                etEmailReview.requestFocus()
                return false
            }
            TextUtils.isEmpty(etMobileReview.text.toString()) -> {
                etMobileReview.error = "Mobile number can't be empty."
                etMobileReview.requestFocus()
                return false
            }
            CommonUtil.isValidMobile(etMobileReview.text.toString()) -> {
                etMobileReview.error = "Please enter valid mobile."
                etMobileReview.requestFocus()
                return false
            }

            TextUtils.isEmpty(etCommentReview.text.toString()) -> {
                etCommentReview.error = "Comment can't be empty."
                etCommentReview.requestFocus()
                return false
            }

            else -> return true
        }
    }

    private fun alertShareBusinessDialog() {
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
            mView = mInflater.inflate(R.layout.dlg_share_business_list, null, false)

            val finalDialog: Dialog = dialog
            mView.layoutShareWhatsapp.setOnClickListener {
                finalDialog.dismiss()
                shareBusinessListByWhatsapp("com.whatsapp", shareBusinessListText)
            }
            mView.layoutShareSms.setOnClickListener {
                finalDialog.dismiss()
                val defaultSmsPackageName: String = Telephony.Sms.getDefaultSmsPackage(requireActivity()) // Need to change the build to API 19
                shareBusinessListBySms(defaultSmsPackageName, shareBusinessListText)
            }
            mView.layoutShareFacebook.setOnClickListener {
                finalDialog.dismiss()
                shareBusinessListByFacebook("com.facebook.katana", shareBusinessListText)
            }
            mView.layoutShareTwitter.setOnClickListener {
                finalDialog.dismiss()
                shareBusinessListByTwitter(shareBusinessListText)
            }
            mView.layoutShareInstagram.setOnClickListener {
                finalDialog.dismiss()
                shareBusinessListByInstagram()
            }
            mView.layoutShareLinkedin.setOnClickListener {
                finalDialog.dismiss()
                shareBusinessListByLinkedin()
            }
            mView.ivCancelShare.setOnClickListener {
                finalDialog.dismiss()
            }
            dialog.setContentView(mView)
            dialog.show()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    private fun shareBusinessListByLinkedin() {
        val share = Intent.createChooser(Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "https://developer.android.com/training/sharing/")

            // (Optional) Here we're setting the title of the content
            putExtra(Intent.EXTRA_TITLE, "Introducing content previews")

            // (Optional) Here we're passing a content URI to an image to be displayed
            flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
        }, "Linkedin Sharing")
        startActivity(share)
        /*val isAppInstalled: Boolean = appInstalledOrNot("com.linkedin.android")
        if (isAppInstalled) {*/
        //val shareIntent = Intent(Intent.ACTION_SEND)
        /*shareIntent.setClassName("com.linkedin.android",
            "com.linkedin.android.home.UpdateStatusActivity")*/
        /*shareIntent.type = "text/plan"
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareBusinessListText)
        startActivity(shareIntent)*/
        /*} else {
            Toast.makeText(activity, "Please install the LinkedIn app to share your result", Toast.LENGTH_LONG).show()
        }*/
    }

    private fun shareBusinessListByInstagram() {
        // Use package name which we want to check
        val isAppInstalled: Boolean = appInstalledOrNot("com.instagram.android", requireActivity())

        if (isAppInstalled) {
            //This intent will help you to launch if the package is already installed
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain";
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Instagram") // set uri
            shareIntent.setPackage("com.instagram.android")
            startActivity(shareIntent)
        } else {
            // Do whatever we want to do if application not installed
            Log.i("SampleLog", "Application is not currently installed.")
            Toast.makeText(requireActivity(), "Application is not currently installed.", Toast.LENGTH_LONG).show()
        }
    }

    private fun appInstalledOrNot(packageName: String, context: Context): Boolean {
        return try {
            val packageManager = context.packageManager
            packageManager.getPackageInfo(packageName, 0)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }

    private fun shareBusinessListByTwitter(message: String) {
        val tweetIntent = Intent(Intent.ACTION_SEND)
        tweetIntent.putExtra(Intent.EXTRA_TEXT, "This is a Test.")
        tweetIntent.type = "text/plain"
        val packManager: PackageManager = requireActivity().packageManager
        val resolvedInfoList: List<ResolveInfo> = packManager.queryIntentActivities(tweetIntent, PackageManager.MATCH_DEFAULT_ONLY)
        var resolved = false
        for (resolveInfo in resolvedInfoList) {
            if (resolveInfo.activityInfo.packageName.startsWith("com.twitter.android")) {
                tweetIntent.setClassName(
                    resolveInfo.activityInfo.packageName,
                    resolveInfo.activityInfo.name)
                resolved = true
                break
            }
        }
        if (resolved) {
            startActivity(tweetIntent)
        } else {
            val i = Intent()
            i.putExtra(Intent.EXTRA_TEXT, message)
            i.action = Intent.ACTION_VIEW
            i.data = Uri.parse("https://twitter.com/intent/tweet?text=" + urlEncode(message))
            startActivity(i)
            Toast.makeText(requireActivity(), "Twitter is not installed on this device.", Toast.LENGTH_LONG).show()
        }
    }

    private fun urlEncode(s: String): String {
        return try {
            URLEncoder.encode(s, "UTF-8")
        } catch (e: UnsupportedEncodingException) {
            Log.wtf(TAG, "UTF-8 should always be supported", e)
            ""
        }
    }

    private fun shareBusinessListByFacebook(packageString: String, shareBusinessListText: String) {
        shareIntent(packageString, shareBusinessListText)
    }

    private fun shareBusinessListByWhatsapp(packageString: String, shareBusinessListText: String) {
        shareIntent(packageString, shareBusinessListText)
    }

    private fun shareIntent(packageString: String, shareBusinessListText: String) {
        try {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, shareBusinessListText)
            intent.type = "text/plain"
            intent.setPackage(packageString)
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun shareBusinessListBySms(defaultSmsPackageName: String, shareBusinessListText: String) {

        val sendIntent = Intent(Intent.ACTION_SEND)
        sendIntent.type = "text/plain"
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareBusinessListText)
        if (defaultSmsPackageName != null) // Can be null in case that there is no default, then the user would be able to choose
        // any app that support this intent.
        {
            sendIntent.setPackage(defaultSmsPackageName)
        }
        startActivity(sendIntent)
    }

    override fun onGalleryItemClicked(position: Int, data: GalleryModelData.Data, uriString: ArrayList<String>) {
        val imageUrlList = data.image
        val intent = Intent(requireActivity(), FullImageActivity::class.java)
        intent.putExtra("uriString", uriString)
        intent.putExtra("position", position)
        startActivity(intent)
        /*val bigImageView: BigImageView = findViewById(android.R.id.mBigImage)
        bigImageView.setProgressIndicator(ProgressPieIndicator())
        bigImageView.setImageViewFactory(FrescoImageViewFactory())
        bigImageView.showImage(
            Uri.parse("http://img1.imgtn.bdimg.com/it/u=1520386803,778399414&fm=21&gp=0.jpg"),
            Uri.parse("https://youimg1.c-ctrip.com/target/tg/773/732/734/7ca19416b8cd423f8f6ef2d08366b7dc.jpg")
        )*/
        /*val fullImageIntent = Intent(requireActivity(), FullScreenImageViewActivity::class.java)
        // uriString is an ArrayList<String> of URI of all images
        fullImageIntent.putExtra(FullScreenImageViewActivity.URI_LIST_DATA, uriString)
        // pos is the position of image will be showned when open
        fullImageIntent.putExtra(FullScreenImageViewActivity.IMAGE_FULL_SCREEN_CURRENT_POS, position)
        //fullImageIntent.putExtra("uriString",uriString)
        activity?.startActivity(fullImageIntent)*/
    }

    override fun onPayQrItemClicked(position: Int, list: BusinessPaymentDataClass.Data, uriString: ArrayList<String>) {
        //Toast.makeText(requireActivity(), "Clicked on item ${list.name}", Toast.LENGTH_LONG).show()
        val intent = Intent(requireActivity(), FullImageActivity::class.java)
        intent.putExtra("uriString", uriString)
        intent.putExtra("position", position)
        startActivity(intent)
    }

    override fun onItemClicked(position: Int, data: BusinessServiceModelClass.Data) {

    }

}


