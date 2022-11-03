package com.milkyway.gbusiness.fragments

import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.gson.Gson
import com.hbb20.CountryCodePicker
import com.leo.searchablespinner.SearchableSpinner
import com.leo.searchablespinner.interfaces.OnItemSelectListener
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.activities.MainActivity
import com.milkyway.gbusiness.adaptor.UserProfessionAdapter
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.api.RecyclerviewCallbacks
import com.milkyway.gbusiness.models.*
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.global.CommonUtil
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import id.ionbit.ionalert.IonAlert
import libs.mjn.fieldset.FieldSetView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle
import java.io.IOException


class ProfileFragment : Fragment() {


    lateinit var mContext: Context
    var activateAccount = "0" // 0 for activate , 1 for unactivate
    val REQUEST_IMAGE_CAPTURE = 2
    val REQUEST_GALLERY = 3
    var ccPicker: CountryCodePicker? = null
    var countryCode: String = "+91"
    lateinit var userProfileTvUserName: TextView
    lateinit var profileUserName: TextView
    lateinit var userProfileTvFirstName: EditText
    lateinit var userProfileTvFLastName: EditText
    lateinit var userProfileTvProfessionName: TextView
    lateinit var userProfileTvEmailId: TextView
    lateinit var tvprofilecurrentPas: EditText
    lateinit var tvprofileNewPas: EditText
    lateinit var tvprofileretypePas: EditText
    lateinit var userProfileTvUserPhone: EditText
    lateinit var profileUserDetailsUpdateBtn: Button

    // lateinit var profileGenrateYourEmail: Button
    lateinit var profileUpdateNumberBtn: Button
    lateinit var profileChangePassBtn: Button
    lateinit var profileDeactiviteAccountBtn: Button
    lateinit var userPhoto: CircleImageView
    lateinit var camerabtn: ImageView
    private lateinit var myProfileBack: ImageView
    private lateinit var changePassWordCardView: CardView
    private lateinit var profileFragBtnCreatWebMail: Button
    private lateinit var btnActivateSSL: Button

    private lateinit var fsvCountry: FieldSetView
    private lateinit var fsvState: FieldSetView
    private lateinit var tvCountry: TextView
    private lateinit var tvState: TextView
    private lateinit var etCity: EditText
    private lateinit var ivSelectCity: ImageView
    private lateinit var etZipCode: EditText
    private lateinit var etAddress: EditText
    private lateinit var searchableSpinnerCountry: SearchableSpinner
    private lateinit var searchableSpinnerState: SearchableSpinner
    private lateinit var searchableSpinnerCity: SearchableSpinner

    var isTextInputLayoutClicked: Boolean = false

    var domainArrayList: ArrayList<DomainX>? = null
    var countryList: List<CountryDataClass.Country>? = null
    var stateList: List<StateDataClass.State>? = null
    var cityList: List<CityDataClass.City>? = null
    var selectedCountryId: Int = 0
    var selectedStateId: Int = 0

    lateinit var tvprofileProfession: FieldSetView
    var professionList = ArrayList<DataXXXXX>()

    private var filterPopup: PopupWindow? = null
    private var selectedItem: Int = -1


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        initializeView(view)
        setClickListener()
        return view
    }


    private fun initializeView(view: View) {
        myProfileBack = view.findViewById(R.id.myProfileBack)
        userProfileTvUserName = view.findViewById(R.id.userProfileTvUserName)
        profileUserName = view.findViewById(R.id.profileUserName)
        userProfileTvFirstName = view.findViewById(R.id.userProfileTvFirstName)
        userProfileTvFLastName = view.findViewById(R.id.userProfileTvFLastName)
        userProfileTvProfessionName = view.findViewById(R.id.userProfileTvProfessionName)
        userProfileTvEmailId = view.findViewById(R.id.userProfileTvEmailId)
        tvprofileNewPas = view.findViewById(R.id.tvprofileNewPas)
        tvprofileretypePas = view.findViewById(R.id.tvprofileretypePas)
        tvprofilecurrentPas = view.findViewById(R.id.tvprofilecurrentPas)
        userProfileTvUserPhone = view.findViewById(R.id.userProfileTvUserPhone)
        profileUserDetailsUpdateBtn = view.findViewById(R.id.profileUserDetailsUpdateBtn)
        //  profileGenrateYourEmail = view.findViewById(R.id.profileGenrateYourEmail)
        profileUpdateNumberBtn = view.findViewById(R.id.profileUpdateNumberBtn)
        profileChangePassBtn = view.findViewById(R.id.profileChangePassBtn)
        profileDeactiviteAccountBtn = view.findViewById(R.id.profileDeactiviteAccountBtn)
        userPhoto = view.findViewById(R.id.userPhoto)
        camerabtn = view.findViewById(R.id.camerabtn)
        tvprofileProfession = view.findViewById(R.id.tvprofileProfession)
        changePassWordCardView = view.findViewById(R.id.changePassWordCardView)
        //profileFragCreatWebMail= view.findViewById(R.id.profileFragCreatWebMail)
        profileFragBtnCreatWebMail = view.findViewById(R.id.profileFragBtnCreatWebMail)
        //profileFragActivateSSL= view.findViewById(R.id.profileFragActivateSSL)
        btnActivateSSL = view.findViewById(R.id.btnActivateSSL)
        ccPicker = view.findViewById(R.id.ccpicker)

        fsvCountry = view.findViewById(R.id.fsvCountry)
        tvCountry = view.findViewById(R.id.tvCountry)
        fsvState = view.findViewById(R.id.fsvState)
        tvState = view.findViewById(R.id.tvState)
        etCity = view.findViewById(R.id.etCity)
        ivSelectCity = view.findViewById(R.id.ivSelectCity)
        etZipCode = view.findViewById(R.id.etZipCode)
        etAddress = view.findViewById(R.id.etAddress)

        getProfessionApi()
        getProfileApi()
        searchableSpinnerCountry = SearchableSpinner(requireActivity())
        searchableSpinnerCountry.windowTitle = "Select/Search Country"
        searchableSpinnerState = SearchableSpinner(requireActivity())
        searchableSpinnerState.windowTitle = "Select/Search State"
        searchableSpinnerCity = SearchableSpinner(requireActivity())
        searchableSpinnerCity.windowTitle = "Select/Search City"

        if (CommonUtil.getPreferencesString(mContext, AppConstants.LOGINWITH).equals("withEmail"))
            changePassWordCardView.visibility = View.GONE
        else
            changePassWordCardView.visibility = View.VISIBLE
    }

    private fun callGetCitiesApi(stateId: Int) {
        if (CommonUtil.checkNetwork(mContext)) {

            val cityApiService = GbusinessService.create(mContext)

            cityApiService.getCities(stateId).enqueue(object : Callback<CityDataClass> {
                override fun onFailure(call: Call<CityDataClass>, t: Throwable) {
                    CommonUtil.toast(R.string.showError.toString(), mContext)
                }

                override fun onResponse(
                    call: Call<CityDataClass>,
                    response: Response<CityDataClass>,
                ) {
                    val getCityData = response.body()

                    if (getCityData != null) {
                        if (response.isSuccessful) {
                            //CommonUtil.toast("City list successfully fetched.", mContext)
                            cityList = getCityData.cities
                            if (!cityList.isNullOrEmpty()) {

                                searchableSpinnerCity.setSpinnerListItems(loadCityNameList(cityList))
                                /*for (i in cityList!!.indices) {
                                    val stateId = stateList!![i].id
                                    if (stateCode.contentEquals(stateId.toString())) {
                                        tvState.text = stateList!![i].name
                                    }else if(stateCode.contentEquals("0")){
                                        tvState.text =""
                                        tvState.hint="Select state"
                                    }
                                }*/
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
                            stateList = getStateData.states
                            if (!stateList.isNullOrEmpty()) {

                                searchableSpinnerState.setSpinnerListItems(loadStateNameList(stateList))
                                for (i in stateList!!.indices) {
                                    val stateId = stateList!![i].id
                                    if (stateCode.contentEquals(stateId.toString())) {
                                        tvState.text = stateList!![i].name
                                    } else if (stateCode.contentEquals("0")) {
                                        tvState.text = ""
                                        tvState.hint = "Select state"
                                    }
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

    private fun callGetCountriesApi(countryCode: String, stateCode: String) {
        if (CommonUtil.checkNetwork(mContext)) {

            val countryApiService = GbusinessService.create(mContext)

            countryApiService
                .getCountries()
                .enqueue(object : Callback<CountryDataClass> {
                    override fun onFailure(call: Call<CountryDataClass>, t: Throwable) {
                        CommonUtil.toast(t.message.toString(), mContext)
                    }

                    override fun onResponse(call: Call<CountryDataClass>, response: Response<CountryDataClass>) {
                        val getCountryListData = response.body()
                        if (getCountryListData != null) {
                            if (response.isSuccessful) {
                                //CommonUtil.toast("Country list successfully fetched.", mContext)
                                countryList = getCountryListData.countries

                                if (!countryList.isNullOrEmpty()) {

                                    searchableSpinnerCountry.setSpinnerListItems(loadCountriesNameList(countryList))
                                    for (i in countryList!!.indices) {
                                        val countryId = countryList!![i].id
                                        if (!countryCode.isNullOrEmpty()) {
                                            if (countryCode.contentEquals(countryId.toString())) {
                                                tvCountry.text = countryList!![i].name
                                                callGetStatesApi(countryId, stateCode)
                                            } else {
                                                tvCountry.hint = "Select country"
                                            }
                                        }
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

    private fun checkProfileUpdateValidation(): Boolean {
        if (userProfileTvFirstName.text.toString().isEmpty()) {
            userProfileTvFirstName.requestFocus()
            errorToast("Enter first name")
            //userProfileTvFirstName.error = "Enter first name"
            return false
        }
        if (userProfileTvFLastName.text.toString().isEmpty()) {
            userProfileTvFLastName.requestFocus()
            errorToast("Enter last name")
            //userProfileTvFLastName.error = "Enter last name"
            return false
        }

        if (etCity.text.toString().isEmpty()) {
            etCity.requestFocus()
            errorToast("Enter city")
            //etCity.error = "Enter city"
            return false
        }

        if (etZipCode.text.toString().isEmpty()) {
            etZipCode.requestFocus()
            errorToast("Enter zip code")
            //etZipCode.error = "Enter zip code"
            return false
        }

        if (etAddress.text.toString().isEmpty()) {
            etAddress.requestFocus()
            errorToast("Enter address")
            //etAddress.error = "Enter address"
            return false
        }
        return true
    }

    private fun setClickListener() {
        myProfileBack.setOnClickListener { findNavController().navigate(R.id.action_profileFragment_to_mainFragment) }
        ccPicker!!.setOnCountryChangeListener {

            countryCode = ccPicker!!.selectedCountryCodeWithPlus
            Toast.makeText(
                mContext, "" + ccPicker!!.selectedCountryCodeWithPlus,
                Toast.LENGTH_SHORT
            ).show()
        }

        tvprofileProfession.setOnClickListener { getProfessionApi() }
        camerabtn.setOnClickListener { showDialog() }
        userProfileTvProfessionName.setOnClickListener { getProfissionLayout() }
        profileUserDetailsUpdateBtn.setOnClickListener {
            //openBottomSheet()
            if (checkProfileUpdateValidation()) {
                userProfileUpdateApi(
                    selectedCountryId,
                    selectedStateId,
                    userProfileTvFirstName.text.toString(),
                    userProfileTvFLastName.text.toString(),
                    etCity.text.toString(),
                    etZipCode.text.toString(),
                    etAddress.text.toString())
            }
        }
        profileUpdateNumberBtn.setOnClickListener { updateMobileNumber() }
        profileChangePassBtn.setOnClickListener { getChangePassApi() }
        profileDeactiviteAccountBtn.setOnClickListener { activateDeactivateAccount() }
        profileFragBtnCreatWebMail.setOnClickListener {
            val bundle = Bundle()//bundleOf("key" to "pawam","pk" to "ams","arary" to  domainArrayList)
            bundle.putSerializable("myname", domainArrayList)
            bundle.putString("type", "web")
            requireView().findNavController().navigate(R.id.action_profileFragment_to_profileConfigration, bundle)
        }
        btnActivateSSL.setOnClickListener {

            var bundle = Bundle()//bundleOf("key" to "pawam","pk" to "ams","arary" to  domainArrayList)
            bundle.putSerializable("myname", domainArrayList)
            bundle.putString("type", "ssl")
            requireView().findNavController().navigate(R.id.action_profileFragment_to_profileConfigration, bundle)
        }

        fsvCountry.setOnClickListener(View.OnClickListener {
            searchableSpinnerCountry.show()
        })

        searchableSpinnerCountry.onItemSelectListener = object : OnItemSelectListener {
            override fun setOnItemSelectListener(position: Int, selectedCountryName: String) {
                //Toast.makeText(requireActivity(), "${searchableSpinnerCountry.selectedItem}  ${searchableSpinnerCountry.selectedItemPosition}", Toast.LENGTH_SHORT).show()
                tvCountry.text = selectedCountryName

                for (i in countryList?.indices!!) {
                    val countryName = countryList!![i].name
                    if (selectedCountryName.contentEquals(countryName)) {
                        selectedCountryId = countryList!![i].id
                        callGetStatesApi(selectedCountryId)
                    }
                }
            }
        }

        fsvState.setOnClickListener(View.OnClickListener {
            searchableSpinnerState.show()
        })

        searchableSpinnerState.onItemSelectListener = object : OnItemSelectListener {
            override fun setOnItemSelectListener(position: Int, selectedStateName: String) {
                //Toast.makeText(requireActivity(), "${searchableSpinnerCountry.selectedItem}  ${searchableSpinnerCountry.selectedItemPosition}", Toast.LENGTH_SHORT).show()
                tvState.text = selectedStateName
                for (i in stateList?.indices!!) {
                    val stateName = stateList!![i].name
                    if (selectedStateName.contentEquals(stateName)) {
                        selectedStateId = stateList!![i].id
                        callGetCitiesApi(selectedStateId)
                    }
                }
            }
        }

        ivSelectCity.setOnClickListener(View.OnClickListener {
            searchableSpinnerCity.show()
        })

        searchableSpinnerCity.onItemSelectListener = object : OnItemSelectListener {
            override fun setOnItemSelectListener(position: Int, selectedCityName: String) {
                //Toast.makeText(requireActivity(), "${searchableSpinnerCountry.selectedItem}  ${searchableSpinnerCountry.selectedItemPosition}", Toast.LENGTH_SHORT).show()
                etCity.text = Editable.Factory.getInstance().newEditable(selectedCityName)
                /*var stateId = 0
                for (i in stateList?.indices!!) {
                    val stateName = stateList!![i].name
                    if (selectedCityName.contentEquals(stateName)) {
                        stateId = stateList!![i].id
                        callGetCitiesApi(stateId)
                    }
                }*/

            }
        }


    }

    /*private fun openBottomSheet() {
        Toast.makeText(requireActivity(), "clicked on three line menu", Toast.LENGTH_SHORT).show()
        val bottomSheetOptions = BottomSheetOption.Builder()
            .addOption(BottomSheetOption.OPTION_MY_ORDER, "My Order")
            .addOption(BottomSheetOption.OPTION_MY_CART, "My Cart")
            .addOption(BottomSheetOption.OPTION_NOTIFICATION, "Notifications")
            .addOption(BottomSheetOption.OPTION_WITHDRAWAL_AMOUNT, "Withdrawal Amount")
            .addOption(BottomSheetOption.OPTION_WITHDRAWAL_HISTORY, "Withdrawal History")
            .addOption(BottomSheetOption.OPTION_PAYMENT_INVOICE, "Payment & Invoice")
            .addOption(BottomSheetOption.OPTION_SECURITY_SETTING, "Security Setting")
            .addOption(BottomSheetOption.OPTION_SUPPORT, "Support")
            .addOption(BottomSheetOption.OPTION_RATE_US, "Rate Us")
            .addOption(BottomSheetOption.OPTION_LOGOUT, "Logout")



        val options = BottomSheetOptionsFragment.getInstance(bottomSheetOptions.build())
        options.setOnBottomSheetOptionSelectedListener {
            when (it) {
                BottomSheetOption.OPTION_MY_ORDER -> {
                    Toast.makeText(requireActivity(), "clicked on my order", Toast.LENGTH_SHORT).show()
                }
                BottomSheetOption.OPTION_MY_CART -> {
                }
                BottomSheetOption.OPTION_NOTIFICATION -> {
                }
                BottomSheetOption.OPTION_WITHDRAWAL_AMOUNT -> {
                }
                BottomSheetOption.OPTION_WITHDRAWAL_HISTORY -> {
                }
                BottomSheetOption.OPTION_PAYMENT_INVOICE -> {
                }
                BottomSheetOption.OPTION_SECURITY_SETTING -> {
                }
                BottomSheetOption.OPTION_SUPPORT -> {
                }
                BottomSheetOption.OPTION_RATE_US -> {
                }
                BottomSheetOption.OPTION_LOGOUT -> {
                }
            }
            options.show(childFragmentManager, "options")
        }
    }*/


    private fun loadCountriesNameList(countryArrayList: List<CountryDataClass.Country>?): ArrayList<String> {
        val countryList = ArrayList<String>()
        if (!countryArrayList.isNullOrEmpty()) {
            for (list in countryArrayList) {
                val name = list.name
                countryList.add(name)
            }
        }
        return countryList
    }

    private fun loadStateNameList(stateArrayList: List<StateDataClass.State>?): ArrayList<String> {
        val stateList = ArrayList<String>()
        if (!stateArrayList.isNullOrEmpty()) {
            for (list in stateArrayList) {
                val name = list.name
                stateList.add(name)
            }
        }
        return stateList
    }

    private fun loadCityNameList(cityArrayList: List<CityDataClass.City>?): ArrayList<String> {
        val cityList = ArrayList<String>()
        if (!cityArrayList.isNullOrEmpty()) {
            for (list in cityArrayList) {
                val name = list.name
                cityList.add(name)
            }
        }
        return cityList
    }

    private fun activateDeactivateAccount() {

        if (CommonUtil.checkNetwork(mContext)) {
            val updatedMobileNumber = userProfileTvUserPhone.text.toString().trim()


            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)
            val apiService = GbusinessService.create(mContext)
            if (userID != null) {
                apiService.accouAcivateAndDeactivate(
                    "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), activateAccount
                ).enqueue(object : Callback<UpdatePhone> {
                    override fun onFailure(call: Call<UpdatePhone>, t: Throwable) {
                        CommonUtil.hideDialog(mContext)
                        CommonUtil.toast(R.string.showError.toString(), mContext)
                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(
                        call: Call<UpdatePhone>,
                        response: Response<UpdatePhone>,
                    ) {
                        CommonUtil.hideDialog(mContext)
                        val getData = response?.body()

                        Log.i("webdd", getData.toString())


                        if (getData != null) {
                            if (getData.success) {

                                findNavController().navigate(R.id.action_profileFragment_to_mainFragment)
                            }
                            if (getData.data != null) CommonUtil.toast(getData.data, mContext)

                        } else CommonUtil.toast("SomeThing went wrong", mContext)


                    }
                })
            }


        } else {
            CommonUtil.toast("Check Internet", mContext)
        }

    }

    private fun updateMobileNumber() {
        if (CommonUtil.checkNetwork(mContext)) {
            val updatedMobileNumber = userProfileTvUserPhone.text.toString().trim()
            if (!updatedMobileNumber.isNullOrEmpty()) {

                var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
                CommonUtil.showDialog(mContext)
                val apiService = GbusinessService.create(mContext)
                if (userID != null) {
                    apiService.changePoneNumber(
                        "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), userID, updatedMobileNumber, countryCode
                    ).enqueue(object : Callback<UpdatePhone> {
                        override fun onFailure(call: Call<UpdatePhone>, t: Throwable) {
                            CommonUtil.hideDialog(mContext)
                            CommonUtil.toast(R.string.showError.toString(), mContext)
                            CommonUtil.logi(t.localizedMessage.toString())
                        }

                        override fun onResponse(
                            call: Call<UpdatePhone>,
                            response: Response<UpdatePhone>,
                        ) {
                            CommonUtil.hideDialog(mContext)
                            val getData = response.body()
                            // CommonUtil.logi(getData.toString())
                            Log.i("web", getData.toString())
                            if (getData != null) {
                                if (getData.success) {
                                    val bundle = Bundle()
                                    bundle.putString("phNumber", updatedMobileNumber)
                                    bundle.putString("cuntryCode", countryCode)
                                    findNavController().navigate(R.id.action_profileFragment_to_OTPfragment, bundle)
                                }
                                if (getData.data != null)
                                    CommonUtil.toast(getData.data, mContext)
                            } else
                                CommonUtil.toast("SomeThing went wrong", mContext)


                        }
                    })
                }

            } else {
                userProfileTvUserPhone.requestFocus()
                userProfileTvUserPhone.error = "Enter Mobile Number"
            }


        } else {
            CommonUtil.toast("Check Internet", mContext)
        }

    }

    private fun getChangePassApi() {
        if (CommonUtil.checkNetwork(mContext)) {

            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            var userProfessionID = CommonUtil.getPreferencesString(mContext, AppConstants.PROFESSION)

            val apiService = GbusinessService.create(mContext)
            if (checkPassValidation()) {
                if (userID != null) {
                    CommonUtil.showDialog(mContext)
                    apiService.getChangePassword(
                        "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),
                        "application/json",
                        userID,
                        tvprofileretypePas.text.toString(),
                        tvprofileretypePas.text.toString(),
                        tvprofilecurrentPas.text.toString()
                    )
                        .enqueue(object : Callback<UpdateUserDetailsDataClass> {
                            override fun onFailure(call: Call<UpdateUserDetailsDataClass>, t: Throwable) {

                                CommonUtil.hideDialog(mContext)
                                CommonUtil.toast(R.string.showError.toString(), mContext)
                                CommonUtil.logi(t.localizedMessage.toString())
                            }

                            override fun onResponse(
                                call: Call<UpdateUserDetailsDataClass>,
                                response: Response<UpdateUserDetailsDataClass>,
                            ) {
                                CommonUtil.hideDialog(mContext)

                                Log.i("TAGad", response.body()?.success.toString())
                                val getData = response.body()
                                CommonUtil.logi(getData.toString())
                                if (getData != null) {

                                    if (getData.success) {
                                        tvprofileretypePas.setText("")
                                        tvprofileNewPas.setText("")
                                        tvprofilecurrentPas.setText("")
                                        CommonUtil.toast(getData.data, mContext)

                                    } else {
                                        CommonUtil.toast("please enter valid current password", mContext)
                                    }
                                }
                            }

                        })
                }
                // startActivity(Intent(this,OtpActivity::class.java))
            }

        } else {
            CommonUtil.toast("Check Internet", mContext)
        }

    }

    private fun checkPassValidation(): Boolean {
        if (tvprofilecurrentPas.text.toString().isEmpty()) {
            tvprofilecurrentPas.requestFocus()
            tvprofilecurrentPas.error = "enter  password"
            return false
        }
        if (tvprofileNewPas.text.toString().isEmpty()) {
            tvprofileNewPas.requestFocus()
            tvprofileNewPas.error = "enter  password"
            return false
        }

        if (tvprofileretypePas.text.toString().trim() != tvprofileNewPas.text.toString().trim()) {
            CommonUtil.toast(" password not match", mContext)
            return false
        }
        if (tvprofileretypePas.text.toString().isEmpty()) {
            tvprofileretypePas.requestFocus()
            tvprofileretypePas.error = "enter  password"
            return false
        }
        return true
    }


    private fun showDialog() {
        val mBottomSheetDialog = BottomSheetDialog(requireActivity())
        val sheetView = requireActivity().layoutInflater.inflate(R.layout.open_camera_dialog, null)
        mBottomSheetDialog.setContentView(sheetView)

        val cameraBtn = sheetView.findViewById<TextView>(R.id.tvOpenCamera)
        val galleryBtn = sheetView.findViewById<TextView>(R.id.tvOpenGallery)
        val cancelBtn = sheetView.findViewById<TextView>(R.id.tvOpencancel)
        cameraBtn.setOnClickListener { OpenCamera() }
        galleryBtn.setOnClickListener { OpenGallery() }
        cancelBtn.setOnClickListener { mBottomSheetDialog.dismiss() }
        mBottomSheetDialog.show()
    }

    private fun userProfileUpdateApi(selectedCountryId: Int, selectedStateId: Int, firstName: String, lastName: String, city: String, zipCode: String, address: String) {
        if (CommonUtil.checkNetwork(mContext)) {
            var countryId = ""
            var stateId = ""
            countryId = if (selectedCountryId == 0)
                CommonUtil.getPreferencesString(mContext, AppConstants.COUNTRY_ID)!!
            else
                selectedCountryId.toString()
            stateId = if (selectedStateId == 0)
                CommonUtil.getPreferencesString(mContext, AppConstants.STATE_ID)!!
            else
                selectedStateId.toString()
            val userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            val userProfessionID = CommonUtil.getPreferencesString(mContext, AppConstants.PROFESSION)
            CommonUtil.showDialog(mContext)
            val apiService = GbusinessService.create(mContext)
            if (userID != null) {
                apiService.getuserUpdate("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),
                    "application/json", userID, firstName, lastName, userProfessionID!!, countryId, stateId, city, zipCode, address)
                    .enqueue(object : Callback<UpdateUserDetailsDataClass> {
                        override fun onResponse(call: Call<UpdateUserDetailsDataClass>, response: Response<UpdateUserDetailsDataClass>, ) {
                            CommonUtil.hideDialog(mContext)
                            Log.i("TAGad", response.body()?.success.toString())
                            val getData = response.body()
                            if (response.isSuccessful) {
                                getProfileApi()
                                MotionToast.createColorToast(requireActivity(),
                                    "Profile Update!",
                                    "Your Profile has been updated successfully.",
                                    MotionToastStyle.SUCCESS,
                                    MotionToast.GRAVITY_CENTER,
                                    MotionToast.LONG_DURATION,
                                    ResourcesCompat.getFont(requireActivity(), R.font.helvetica_regular))
                            }
                            CommonUtil.logi(getData.toString())
                        }

                        override fun onFailure(call: Call<UpdateUserDetailsDataClass>, t: Throwable) {
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

    private fun errorToast(message: String) {
        MotionToast.createColorToast(requireActivity(),
            "Validation Error!",
            message,
            MotionToastStyle.ERROR,
            MotionToast.GRAVITY_CENTER,
            MotionToast.LONG_DURATION,
            ResourcesCompat.getFont(requireActivity(), R.font.helvetica_regular))
    }

    private fun getProfissionLayout() {
        dismissPopup()
        filterPopup = showAlertFilter()
        filterPopup?.isOutsideTouchable = true
        filterPopup?.isFocusable = true
        filterPopup?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        filterPopup?.showAsDropDown(userProfileTvProfessionName)

    }

    //todo Popup window like spinner

    private fun showAlertFilter(): PopupWindow {
        val inflater = requireActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.alter_profession_layout, null)
        val recyclerView = view.findViewById<RecyclerView>(R.id.professionRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))

        val adapter = UserProfessionAdapter(professionList)

        recyclerView.adapter = adapter
        adapter.selectedItem(selectedItem)

        adapter.setOnClick(object : RecyclerviewCallbacks<DataXXXXX> {
            override fun onItemClick(view: View, position: Int, item: DataXXXXX) {
                selectedItem = position
                //Toast.makeText(mContext, "data = ${item.profession_id}", Toast.LENGTH_SHORT).show()
                CommonUtil.saveStringPreferences(mContext, AppConstants.PROFESSION, item.profession_id.toString())
                userProfileTvProfessionName.text = item.profession_name.toString()

                dismissPopup()
            }
        })

        return PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onStop() {
        super.onStop()
        dismissPopup()
    }

    private fun dismissPopup() {
        filterPopup?.let {
            if (it.isShowing) {
                it.dismiss()
            }
            filterPopup = null
        }

    }

    //todo call api to get user profile full details
    private fun getProfileApi() {
        Log.i("TAG", " == " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN))
        if (CommonUtil.checkNetwork(mContext)) {
            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)
            val apiService = GbusinessService.create(mContext)
            if (userID != null) {
                apiService.getUserProfile("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),
                    "application/json", userID)
                    .enqueue(object : Callback<Any> {
                        override fun onResponse(call: Call<Any>, response: Response<Any>) {
                            CommonUtil.hideDialog(mContext)
                            val gson = Gson()
                            when (response.code()) {
                                200 -> {
                                    val profileData = gson.fromJson(gson.toJson(response.body()), ProfileDetailaDataClass::class.java)
                                    if (profileData?.success == true) {
                                        if (profileData != null) {
                                            if (profileData.success) {
                                                setProfileData(profileData)
                                            }
                                        }
                                    } else {
                                        val errorBody = gson.fromJson(gson.toJson(response.body()), ProfileDataErrorResponse::class.java)
                                        if (errorBody != null) {
                                            val ionAlert = IonAlert(requireActivity(), IonAlert.ERROR_TYPE)
                                            ionAlert.titleText = "Profile Error!"
                                            ionAlert.contentText = errorBody.message
                                            ionAlert.show()
                                        }
                                    }
                                }
                                500 -> {
                                    val ionAlert = IonAlert(requireActivity(), IonAlert.ERROR_TYPE)
                                    ionAlert.titleText = "Server Error!"
                                    ionAlert.contentText = "Server is not responding at present."
                                    ionAlert.show()
                                }
                            }
                        }

                        override fun onFailure(call: Call<Any>, t: Throwable) {
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

    private fun setProfileData(getData: ProfileDetailaDataClass) {
        if (getData.data.user_name != null)
            userProfileTvUserName.text = getData.data.user_name
        if (getData.data.user_name != null)
            profileUserName.text = getData.data.user_name
        if (getData.data.first_name != null)
            userProfileTvFirstName.setText(getData.data.first_name)
        if (getData.data.last_name != null)
            userProfileTvFLastName.setText(getData.data.last_name)
        if (getData.data.profession_name != null) {
            if (getData.data.profession_name.contentEquals("null")) {
                userProfileTvProfessionName.hint = "Select Profession"
            } else {
                userProfileTvProfessionName.text = getData.data.profession_name
            }
        }
        if (getData.data.profession != null)
            CommonUtil.saveStringPreferences(mContext, AppConstants.PROFESSION, getData.data.profession!!)
        if (getData.data.email != null)
            userProfileTvEmailId.text = getData.data.email
        if (getData.data.phone != null)
            userProfileTvUserPhone.setText(getData.data.phone)

        //to check acount is activate or deactivate
        if (getData.data.deleted != null && getData.data.deleted == "0") {
            profileDeactiviteAccountBtn.text = "DeActivate Account"
            activateAccount = "1"
        }
        if (getData.data.deleted != null && getData.data.deleted == "1") {
            activateAccount = "0"
            profileDeactiviteAccountBtn.text = "Activate Account"
        }
        if (getData.data.country != null)
            CommonUtil.saveStringPreferences(mContext, AppConstants.COUNTRY_ID, getData.data.country)

        if (getData.data.state != null)
            CommonUtil.saveStringPreferences(mContext, AppConstants.STATE_ID, getData.data.state)

        if (getData.data.address != null) {
            etAddress.text = Editable.Factory.getInstance().newEditable(getData.data.address)
        }
        if (getData.data.city != null) {
            etCity.text = Editable.Factory.getInstance().newEditable(getData.data.city)
        }
        if (getData.data.zip_code != null) {
            etZipCode.text = Editable.Factory.getInstance().newEditable(getData.data.zip_code)
        }

        if (getData.data.profile_imge != null) {
            if (URLUtil.isValidUrl(getData.data.profile_imge)) {
                Picasso.get()
                    .load(getData.data.profile_imge)
                    .placeholder(R.mipmap.user)
                    .into(userPhoto)
            } else {
                Picasso.get()
                    .load("https://www.gbusiness.co/public/abhi_public/img/${getData.data.profile_imge}")
                    .into(userPhoto)
            }
        }

        if (getData.domain_list.isNotEmpty()) {
            //profileFragActivateSSL.visibility = View.VISIBLE
            //profileFragCreatWebMail.visibility = View.VISIBLE
            btnActivateSSL.visibility = View.VISIBLE
            profileFragBtnCreatWebMail.visibility = View.VISIBLE
            domainArrayList = ArrayList()
            domainArrayList!!.addAll(getData.domain_list)
        }
        if (getData.message != null) CommonUtil.toast(getData.message, mContext)
        callGetCountriesApi(getData.data.country, getData.data.state)

    }

    //todo call api to getList of profession list of user
    private fun getProfessionApi() {
        if (CommonUtil.checkNetwork(mContext)) {
            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            //   CommonUtil.showDialog(mContext)
            val apiService = GbusinessService.create(mContext)
            if (userID != null) {
                apiService.getProfession(
                    "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), "application/json"
                ).enqueue(object : Callback<ProfessionDataClass> {
                    override fun onFailure(call: Call<ProfessionDataClass>, t: Throwable) {
                        //   CommonUtil.hideDialog(mContext)
                        CommonUtil.toast(R.string.showError.toString(), mContext)
                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(call: Call<ProfessionDataClass>, response: Response<ProfessionDataClass>) {
                        //     CommonUtil.hideDialog(mContext)

                        //  Log.i("professddion", response.body().toString())
                        val getData = response.body()
                        CommonUtil.logi(getData.toString())

                        if (getData != null) {
                            if (getData.data != null) professionList = getData.data
                        } else
                            CommonUtil.toast(R.string.showError.toString(), mContext)

                    }

                })
            }

        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }

    //todo to open camera
    fun OpenCamera() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(requireActivity().packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    //todo to open gallery
    fun OpenGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_GALLERY)
    }

    //todo ActivityResult
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            // imageView.setImageBitmap(imageBitmap)

            userPhoto.setImageBitmap(imageBitmap)

            val encodedString = CommonUtil.toBase64String(imageBitmap)
            //  Toast.makeText(mContext, encodedString, Toast.LENGTH_SHORT).show()
            if (encodedString != null) {
                updateUserImage(encodedString)
            }
        }
        if (requestCode == REQUEST_GALLERY && resultCode == RESULT_OK) {
            if (data != null) {
                val contentURI = data!!.data
                //   val imageBitmap = data?.extras?.get("data") as Bitmap
                try {
                    val imageBitmap = MediaStore.Images.Media.getBitmap(mContext.contentResolver, contentURI)
                    userPhoto.setImageBitmap(imageBitmap)
                    // Toast.makeText(mContext, "Image Saved!", Toast.LENGTH_SHORT).show()
                    // imageview!!.setImageBitmap(bitmap)

                    val encodedString = CommonUtil.toBase64String(imageBitmap)
                    // Toast.makeText(mContext, encodedString, Toast.LENGTH_SHORT).show()
                    if (encodedString != null) {
                        updateUserImage(encodedString)
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                    Toast.makeText(mContext, "Failed!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    //todo  to call api for profile photo update
    private fun updateUserImage(encodedString: String) {


        if (CommonUtil.checkNetwork(mContext)) {

            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)
            val apiService = GbusinessService.create(mContext)
            if (userID != null) {
                apiService.getUpdateProfileImage(
                    "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),
                    "application/json", userID, "data:image/png;base64,$encodedString"
                ).enqueue(object : Callback<UpdateUserDetailsDataClass> {
                    override fun onFailure(call: Call<UpdateUserDetailsDataClass>, t: Throwable) {

                        CommonUtil.hideDialog(mContext)
                        CommonUtil.toast(R.string.showError.toString(), mContext)
                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(
                        call: Call<UpdateUserDetailsDataClass>,
                        response: Response<UpdateUserDetailsDataClass>,
                    ) {
                        CommonUtil.hideDialog(mContext)

                        Log.i("image", response.body().toString())
                        val getData = response.body()
                        CommonUtil.logi(getData.toString())


                        if (getData != null) {
                            if (getData.success) {

                                CommonUtil.toast(getData.data.toString(), mContext)
                                startActivity(Intent(mContext, MainActivity::class.java))
                            }
                            if (getData.message != null) CommonUtil.toast(getData.message, mContext)

                        } else CommonUtil.toast(R.string.showError.toString(), mContext)
                    }
                })
            }

        } else CommonUtil.toast("Check Internet", mContext)
    }


    /*private fun loadJSONFromAsset(): String {
        val json: String?
        try {
            val inputStream = requireContext().assets.open("countries_states_cities.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            val charset: Charset = Charsets.UTF_8
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return ""
        }
        return json
    }

    private fun loadCountriesFromJson(): ArrayList<String> {
        val countryList = ArrayList<String>()
        try {
            val jsonDataString: String = loadJSONFromAsset()
            val jsonArray = JSONArray(jsonDataString)
            for (i in 0 until jsonArray.length()) {
                val itemObj: JSONObject = jsonArray.getJSONObject(i)
                val countryName: String = itemObj.getString("name")
                countryList.add(countryName)
            }
        } catch (e: JSONException) {
            Log.d("TAG", "addItemsFromJSON: ", e)
        } catch (e: IOException) {
            Log.d("TAG", "addItemsFromJSON: ", e)
        }
        return countryList
    }*/

}
