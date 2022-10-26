package com.milkyway.gbusiness.fragments

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.activities.MainActivity
import com.milkyway.gbusiness.adaptor.SocialMediaIconsAdaptor
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.*
import com.milkyway.gbusiness.utils.CommonUtil
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 * Use the [BusinessListingDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BusinessListingDetailsFragment : Fragment(), SocialMediaIconsAdaptor.SocialMediaAdaptorClick {
    private lateinit var myBusinessListingDetailBack: ImageView
    private lateinit var btnLocation: AppCompatButton
    private lateinit var btnMobile: AppCompatButton
    private lateinit var btnEmailId: AppCompatButton
    private lateinit var btnWebLink: AppCompatButton
    private lateinit var btnPlayStoreLink: AppCompatButton
    private lateinit var btnSubDomainLink: AppCompatButton
    private lateinit var mContext: Context
    private lateinit var ivBusinessLogo: ImageView
    private lateinit var tvBusinessName: TextView
    private lateinit var tvBusinessCategory: TextView
    private lateinit var tvBusinessSubcategory: TextView
    private lateinit var tvCountry: TextView
    private lateinit var tvState: TextView
    private lateinit var tvCity: TextView
    private lateinit var tvZipCode: TextView
    private lateinit var tvAboutUs: TextView
    private lateinit var rvSocialLinks: RecyclerView
    lateinit var argsBack: Bundle
    private var notAvailable: String = "Not Available"
    private var socialMediaIconsList = ArrayList<SocialMediaData>()
    private var socialMediaIconsAdaptor: SocialMediaIconsAdaptor? = null

    var countryId = 0
    var stateId = 0
    var catId = 0
    var subCatId = 0
    private var businessPhone: String = ""
    private var businessEmail: String = ""
    private var businessWebUrl: String = ""
    private var sellerUrl: String = ""
    private var subDomainUrl: String = ""

    lateinit var catDataResponse: CategoryDataClass
    lateinit var catList: List<CategoryDataClass.Data>
    lateinit var subCatDataResponse: SubCategoryDataClass
    lateinit var subCatList: List<SubCategoryDataClass.Subcategory>


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
        val view = inflater.inflate(R.layout.fragment_business_listing_details, container, false)
        initializeView(view)
        clickListener(view)
        return view
    }

    private fun initializeView(view: View) {
        myBusinessListingDetailBack = view.findViewById(R.id.myBusinessListingDetailBack)
        btnLocation = view.findViewById(R.id.btnLocation)
        btnMobile = view.findViewById(R.id.btnMobile)
        btnEmailId = view.findViewById(R.id.btnEmailId)
        btnWebLink = view.findViewById(R.id.btnWebLink)
        btnPlayStoreLink = view.findViewById(R.id.btnPlayStoreLink)
        btnSubDomainLink = view.findViewById(R.id.btnVisitSubdomainSite)

        ivBusinessLogo = view.findViewById(R.id.ivBusinessLogo)

        tvBusinessName = view.findViewById(R.id.tvBusinessName)
        tvBusinessCategory = view.findViewById(R.id.tvBusinessCategory)
        tvBusinessSubcategory = view.findViewById(R.id.tvBusinessSubcategory)
        tvCountry = view.findViewById(R.id.tvCountry)
        tvState = view.findViewById(R.id.tvState)
        tvCity = view.findViewById(R.id.tvCity)
        tvZipCode = view.findViewById(R.id.tvZipCode)
        tvAboutUs = view.findViewById(R.id.tvAboutUs)
        rvSocialLinks = view.findViewById(R.id.rvSocialLinks)


        val args = arguments
        argsBack = args!!
        if (args != null) {
            setData(args)
        }
    }

    private fun callCategoryApi() {

        if (CommonUtil.checkNetwork(mContext)) {
            val dataNotic = GbusinessService.create(mContext)

            dataNotic.getCategoryList().enqueue(object : Callback<CategoryDataClass> {
                override fun onResponse(call: Call<CategoryDataClass>, response: Response<CategoryDataClass>) {

                    // Log.i("TAGad", response.body()?.success.toString())
                    catDataResponse = response.body()!!
                    catList = catDataResponse.data
                    for (i in catList.indices) {
                        if (catId == catList[i].id) {
                            tvBusinessCategory.text = catList[i].name
                            callSubCategoryApi(catId)
                        }
                    }
                }

                override fun onFailure(call: Call<CategoryDataClass>, t: Throwable) {
                    CommonUtil.toast(R.string.showError.toString(), mContext)
                    CommonUtil.logi(t.localizedMessage.toString())
                }
            })

        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }

    private fun callSubCategoryApi(catId: Int) {
        if (CommonUtil.checkNetwork(mContext)) {
            GbusinessService.create(mContext).getSubCategoryList(
                catId
            ).enqueue(object : Callback<SubCategoryDataClass> {
                override fun onResponse(call: Call<SubCategoryDataClass>, response: Response<SubCategoryDataClass>) {

                    // Log.i("TAGad", response.body()?.success.toString())
                    subCatDataResponse = response.body()!!
                    subCatList = subCatDataResponse.subcategory
                    for (i in subCatList.indices) {
                        if (subCatId == subCatList[i].id)
                            tvBusinessSubcategory.text = subCatList[i].name
                    }
                }

                override fun onFailure(call: Call<SubCategoryDataClass>, t: Throwable) {
                    CommonUtil.toast(R.string.showError.toString(), mContext)
                    CommonUtil.logi(t.localizedMessage.toString())
                }
            })
        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }

    private fun callGetCountriesApi() {
        if (CommonUtil.checkNetwork(mContext)) {
            val countryApiService = GbusinessService.create(mContext)
            countryApiService.getCountries()
                .enqueue(object : Callback<CountryDataClass> {
                    override fun onFailure(call: Call<CountryDataClass>, t: Throwable) {
                        CommonUtil.toast(t.message.toString(), mContext)
                    }

                    override fun onResponse(call: Call<CountryDataClass>, response: Response<CountryDataClass>) {
                        val getCountryListData = response.body()
                        val countryList = getCountryListData?.countries
                        if (!countryList.isNullOrEmpty()) {
                            for (i in countryList!!.indices) {
                                if (countryId == countryList[i].id) {
                                    tvCountry.text = countryList[i].name
                                    callGetStatesApi(countryId)
                                }
                            }
                        }
                    }
                })
        } else {
            CommonUtil.toast("Check Internet connection", mContext)
        }
    }

    private fun callGetStatesApi(countryId: Int, stateCode: String = "0") {
        if (CommonUtil.checkNetwork(mContext)) {
            val stateApiService = GbusinessService.create(mContext)
            stateApiService.getStates(countryId).enqueue(object : Callback<StateDataClass> {
                override fun onFailure(call: Call<StateDataClass>, t: Throwable) {
                    CommonUtil.toast(R.string.showError.toString(), mContext)
                }

                override fun onResponse(call: Call<StateDataClass>, response: Response<StateDataClass>) {
                    val getStateData = response?.body()
                    if (getStateData != null) {
                        if (response.isSuccessful) {
                            //CommonUtil.toast("State list successfully fetched.", mContext)
                            val stateList = getStateData.states
                            if (!stateList.isNullOrEmpty()) {
                                for (i in stateList.indices) {
                                    if (stateId == stateList[i].id) {
                                        tvState.text = stateList[i].name
                                        //callGetCitiesApi(stateId)
                                    }
                                }
                            }
                        }
                    } else
                        CommonUtil.toast("Something went wrong", mContext)
                }
            })
        } else {
            CommonUtil.toast("Check Internet connection", mContext)
        }
    }

    private fun callGetCitiesApi(stateId: Int) {
        if (CommonUtil.checkNetwork(mContext)) {
            val apiService = GbusinessService.create(mContext)
            apiService.getCities(stateId).enqueue(object : Callback<CityDataClass> {
                override fun onFailure(call: Call<CityDataClass>, t: Throwable) {
                    CommonUtil.toast(R.string.showError.toString(), mContext)
                }

                override fun onResponse(
                    call: Call<CityDataClass>, response: Response<CityDataClass>,
                ) {
                    val getCityData = response.body()

                    if (getCityData != null) {
                        if (response.isSuccessful) {
                            //CommonUtil.toast("City list successfully fetched.", mContext)
                            val cityList = getCityData.cities
                            if (!cityList.isNullOrEmpty()) {
                                for (i in cityList.indices) {

                                }
                            }
                        } else
                            CommonUtil.toast("Something went wrong", mContext)
                    }
                }
            })
        } else {
            CommonUtil.toast("Check Internet connection", mContext)
        }
    }

    private fun setData(args: Bundle) {
        val urlLogo = GbusinessService.BASE_IMG_URL + args.getString("businessLogoUrl")
        val businessName = args.getString("businessName")
        businessEmail = args.getString("businessEmail").toString()
        businessPhone = args.getString("businessPhone").toString()
        businessWebUrl = args.getString("businessWebUrl").toString()
        subDomainUrl = args.getString("subDomainUrl").toString()
        sellerUrl = args.getString("sellerUrl").toString()
        val facebookUrl = args.getString("facebookUrl").toString()
        val linkedinUrl = args.getString("linkedinUrl").toString()
        val twitterUrl = args.getString("twitterUrl").toString()
        val instagramUrl = args.getString("instagramUrl").toString()
        val businessAboutUs = args.getString("businessAboutUs")
        val city = args.getString("city")
        val address = args.getString("address")
        val zipCode = args.getInt("zipCode", 0)
        //id = args.getInt("id", 0)
        countryId = args.getInt("countryId", 0)
        stateId = args.getInt("stateId", 0)
        catId = args.getInt("catId", 0)
        subCatId = args.getInt("subCatId", 0)
        setSocialMediaAdapter(facebookUrl, linkedinUrl, twitterUrl, instagramUrl)
        callCategoryApi()
        callGetCountriesApi()
        if (URLUtil.isValidUrl(urlLogo)) {
            Picasso
                .get()
                .load(urlLogo)
                .into(ivBusinessLogo)
        } else {
            val urlDefault = "https://www.gbusiness.co/public/business_images/default-business-logo.jpg"
            Picasso
                .get()
                .load(urlDefault)
                .into(ivBusinessLogo)
        }
        if (businessName != null)
            tvBusinessName.text = businessName
        else
            tvBusinessName.text = notAvailable
        btnEmailId.text = businessEmail
        btnMobile.text = businessPhone
        if (businessWebUrl.contains("https://play.google.com/store/apps/details?id=")) {
            btnPlayStoreLink.text = businessWebUrl
            btnPlayStoreLink.visibility = View.VISIBLE
            btnWebLink.visibility = View.GONE
        } else {
            btnWebLink.text = businessWebUrl
            btnPlayStoreLink.visibility = View.GONE
            btnWebLink.visibility = View.VISIBLE
        }

        if (!subDomainUrl.isNullOrEmpty()) {
            btnSubDomainLink.text = "https://$subDomainUrl.gbusiness.co"
            btnSubDomainLink.visibility = View.VISIBLE
        } else {
            btnSubDomainLink.visibility = View.GONE
        }

        btnLocation.text = address

        if (city != null)
            tvCity.text = city
        else
            tvCity.text = notAvailable
        if (zipCode != null)
            tvZipCode.text = zipCode.toString()
        else
            tvZipCode.text = notAvailable
        if (businessAboutUs != null)
            tvAboutUs.text = businessAboutUs
        else
            tvAboutUs.text = notAvailable
    }

    private fun setSocialMediaAdapter(facebookUrl: String, linkedinUrl: String, twitterUrl: String, instagramUrl: String) {
        rvSocialLinks.layoutManager = GridLayoutManager(context, 4)
        if (!facebookUrl.contentEquals("null"))
            socialMediaIconsList.add(SocialMediaData("Facebook", facebookUrl, R.drawable.ic_facebook))
        else
            socialMediaIconsList.add(SocialMediaData("Facebook", "https://www.facebook.com/", R.drawable.ic_facebook))
        if (!linkedinUrl.contentEquals("null"))
            socialMediaIconsList.add(SocialMediaData("Linkedin", linkedinUrl, R.drawable.ic_linkedin))
        else
            socialMediaIconsList.add(SocialMediaData("Linkedin", "https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin", R.drawable.ic_linkedin))
        if (!twitterUrl.contentEquals("null"))
            socialMediaIconsList.add(SocialMediaData("Twitter", twitterUrl, R.drawable.ic_twitter))
        else
            socialMediaIconsList.add(SocialMediaData("Twitter", "https://twitter.com/i/flow/login", R.drawable.ic_twitter))
        if (!instagramUrl.contentEquals("null"))
            socialMediaIconsList.add(SocialMediaData("Instagram", instagramUrl, R.drawable.ic_instagram))
        else
            socialMediaIconsList.add(SocialMediaData("Instagram", "https://www.instagram.com/accounts/login/", R.drawable.ic_instagram))
        socialMediaIconsAdaptor = SocialMediaIconsAdaptor(requireActivity(), this, socialMediaIconsList)
        rvSocialLinks.adapter = socialMediaIconsAdaptor
    }

    private fun clickListener(view: View) {
        myBusinessListingDetailBack.setOnClickListener {
            MainActivity.navController.navigate(R.id.action_myBusinessListingDetailsFragment_to_businessListingFragment)
        }
        btnLocation.setOnClickListener {
            val address = btnLocation.text.toString().trim()
            val gmmIntentUri = Uri.parse("google.navigation:q=$address")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
            //Toast.makeText(requireActivity(), "Clicked on location", Toast.LENGTH_LONG).show()
        }
        btnMobile.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel:$businessPhone")
            startActivity(dialIntent)
            //Toast.makeText(requireActivity(), "Clicked on Mobile", Toast.LENGTH_LONG).show()
        }
        btnEmailId.setOnClickListener {
            sendEmail(businessEmail, "", "")
            //Toast.makeText(requireActivity(), "Clicked on Email ID", Toast.LENGTH_LONG).show()
        }
        btnWebLink.setOnClickListener {
            //val bundle = Bundle()
            argsBack.putString("back", "BusinessListingDetailsFragment")
            argsBack.putString("webUrl", businessWebUrl)
            MainActivity.navController.navigate(R.id.action_businessListingDetailsFragment_to_paymentOrInvoiceWebView, argsBack)
            //Toast.makeText(requireActivity(), "Clicked on Website link", Toast.LENGTH_LONG).show()
        }

        btnPlayStoreLink.setOnClickListener {

            val playStoreIntent = Intent(Intent.ACTION_VIEW)
            playStoreIntent.data = Uri.parse(businessWebUrl)
            startActivity(playStoreIntent)
            //Toast.makeText(requireActivity(), "Clicked on Play Store link", Toast.LENGTH_LONG).show()
        }

        btnSubDomainLink.setOnClickListener {
            /*val bundle = Bundle()
            bundle.putString("back", "BusinessListingDetailsFragment")
            bundle.putString("webUrl", sellerUrl)
            MainActivity.navController.navigate(R.id.action_businessListingDetailsFragment_to_paymentOrInvoiceWebView, bundle)*/
            MainActivity.navController.navigate(R.id.action_businessListingDetailsFragment_to_businessSubdomainWebsiteFragment, argsBack)
        }
    }

    private fun sendEmail(recipient: String, subject: String, message: String) {
        val mIntent = Intent(Intent.ACTION_SEND)
        /*To send an email you need to specify mailto: as URI using setData() method
        and data type will be to text/plain using setType() method*/
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"
        // put recipient email in intent
        /* recipient is put as array because you may wanna send email to multiple emails
           so enter comma(,) separated emails, it will be stored in array*/
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        //put the Subject in the intent
        mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        //put the message in the intent
        mIntent.putExtra(Intent.EXTRA_TEXT, message)


        try {
            //start email intent
            startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))
        } catch (e: Exception) {
            //if any thing goes wrong for example no email client application or any exception
            //get and show exception message
            Toast.makeText(requireActivity(), e.message, Toast.LENGTH_LONG).show()
        }
    }

    override fun onResume() {
        super.onResume()
        //setData(argsBack)
    }

    override fun onSocialItemClicked(position: Int, list: SocialMediaData) {
        argsBack.putString("back", "BusinessListingDetailsFragment")
        argsBack.putString("webUrl", list.media_link)
        MainActivity.navController.navigate(R.id.action_businessListingDetailsFragment_to_paymentOrInvoiceWebView, argsBack)
    }
}