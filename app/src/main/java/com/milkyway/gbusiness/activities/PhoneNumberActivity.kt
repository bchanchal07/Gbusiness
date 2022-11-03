package com.milkyway.gbusiness.activities

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.RelativeLayout
import android.widget.TextView
import com.milkyway.gbusiness.global.CommonUtil
import kotlinx.android.synthetic.main.activity_phone_number.*
import com.hbb20.CountryCodePicker
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.adaptor.UserProfessionAdapter
import com.milkyway.gbusiness.activities.OtpActivity.Companion.openBy
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.api.RecyclerviewCallbacks
import com.milkyway.gbusiness.models.DataXXXXX
import com.milkyway.gbusiness.models.PhoneVerificationDataClass
import com.milkyway.gbusiness.models.ProfessionDataClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PhoneNumberActivity : AppCompatActivity() {

    private var filterPopup: PopupWindow? = null
    private var selectedItem: Int = -1
    var refcode : String = "null"
    lateinit var tvprofileProfession: RelativeLayout
    lateinit var userProfileTvProfessionName: TextView
     var professionSelected: String? = null
    var countryCode : String = "+91"
    var professionList = ArrayList<DataXXXXX>()
    var ccp: CountryCodePicker? = null
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_number)

        val autoCode = CommonUtil.getPreferencesString(this, AppConstants.ReferalCode)
        if (autoCode!=null && !autoCode.equals("google-play&utm_medium") && !autoCode.equals("ReferalCode"))
        {
            Log.i("realm","reff = byplaystore  = "+autoCode)
            edRefCode.setText(autoCode)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                edRefCode.setEnabled(false)
            }
            refcode = autoCode

        }

        getProfissionApi()
        userProfileTvProfessionName = findViewById(R.id.userProfileTvProfessionName)
        tvprofileProfession = findViewById(R.id.tvUserProfession)
        userProfileTvProfessionName.setOnClickListener {
            //getProfissionApi()

            getProfissionLayout()
        }


        mobileverificationSubmit.setOnClickListener {

            if(refcode.equals("")) refcode = edRefCode.text.toString().trim()

            if (checkValidation()) submitDataAPI(countryCode,EdgetphonNumber.text.toString().trim(),userProfileTvProfessionName.text.toString().trim(),refcode)
        }

        ccp = findViewById(R.id.ccp);
        ccp!!.setOnCountryChangeListener(CountryCodePicker.OnCountryChangeListener {
            /*Toast.makeText(
                this, "Updated " + ccp!!.getSelectedCountryName(),
                Toast.LENGTH_SHORT
            ).show()*/
            countryCode = ccp!!.selectedCountryCodeWithPlus
        /*    Toast.makeText(
                this, "Updated " + ccp!!.selectedCountryCodeWithPlus,
                Toast.LENGTH_SHORT
            ).show()*/
        })


    }

    private fun checkValidation(): Boolean {

        if(EdgetphonNumber.text.toString().isEmpty())
        {
            EdgetphonNumber.requestFocus()
            EdgetphonNumber.error = "enter phone number"
            return false

        }
        if(userProfileTvProfessionName.text.toString().isEmpty())
        {
            userProfileTvProfessionName.requestFocus()
            userProfileTvProfessionName.error = "enter profession"
            return false

        }
        if(professionSelected==null)
        {
            userProfileTvProfessionName.requestFocus()
            userProfileTvProfessionName.error = "enter profession"
            return false

        }

        return true
    }

    private fun submitDataAPI(countryCode: String, number: String, profession: String, refcode: String = "null")
{

    if (CommonUtil.checkNetwork(this))
    {
       /* Log.i("professddion id =",professionSelected)
        Log.i("professddion id2 =",CommonUtil.getPreferencesString(this, AppConstants.PROFESSION))*/
        var userID = CommonUtil.getPreferencesString(this, AppConstants.USER_ID)
        CommonUtil.showDialog(this)
        val phoneNumber = countryCode+" "+number
        val dataNotic = GbusinessService.create(this)
        if (userID != null) {
            dataNotic.getPhoneVerification(
                "Bearer " + CommonUtil.getPreferencesString(this, AppConstants.TOKEN), "application/json",
                phoneNumber,
                professionSelected!!,
                refcode,
                userID,
                countryCode,
                "code"
            ).enqueue(object : Callback<PhoneVerificationDataClass> {
                override fun onFailure(call: Call<PhoneVerificationDataClass>, t: Throwable) {
                    CommonUtil.hideDialog(this@PhoneNumberActivity)
                  //  CommonUtil.toast(t.localizedMessage, this@PhoneNumberActivity)
                    CommonUtil.logi(t.localizedMessage.toString())
                }

                override fun onResponse(call: Call<PhoneVerificationDataClass>, response: Response<PhoneVerificationDataClass>) {
                    CommonUtil.hideDialog(this@PhoneNumberActivity)

                    Log.i("professddion", response.body().toString())
                    val getdata = response.body()
                    CommonUtil.logi(getdata.toString())


                    if (getdata != null)
                    {

                        if (getdata.success)
                        {
                            if(getdata.data!=null) CommonUtil.toast(getdata.data.toString(),this@PhoneNumberActivity)


                          //  phoneNumber : String, professionSelected : String,refcode : String,countryCode : String

                           // bundle.putString("openBy","phoneActivity")
                            openBy = "phoneActivity"
                           val intent = Intent(this@PhoneNumberActivity, OtpActivity::class.java)
                            intent.putExtra("phoneNumber",phoneNumber)
                            intent.putExtra("professionSelected",professionSelected)
                            intent.putExtra("refcode",refcode)
                            intent.putExtra("countryCode",countryCode)
                            startActivity(intent)

                        } else
                        {
                            if(getdata.error!=null)
                            {
                                CommonUtil.toast(getdata.error, this@PhoneNumberActivity)

                            }
                        }

                    }else
                    {
                        CommonUtil.toast(R.string.showError.toString(), this@PhoneNumberActivity)
                    }

                }

            })
        }
        // startActivity(Intent(this,OtpActivity::class.java))
    } else {
        CommonUtil.toast("Check Internet", this@PhoneNumberActivity)
    }
}

    private fun getProfissionLayout() {
        // CommonUtil.toast("dfdfggfgff", mContext)
        dismissPopup()
        filterPopup = showAlertFilter()
        filterPopup?.isOutsideTouchable = true
        filterPopup?.isFocusable = true
        filterPopup?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        filterPopup?.showAsDropDown(userProfileTvProfessionName)

    }

    //todo call api to getList of profession list of user
    private fun getProfissionApi() {

        if (CommonUtil.checkNetwork(this)) {
            var userID = CommonUtil.getPreferencesString(this, AppConstants.USER_ID)
               CommonUtil.showDialog(this)
            val dataNotic = GbusinessService.create(this)
            if (userID != null) {
                dataNotic.getProfession(
                    "Bearer " + CommonUtil.getPreferencesString(this, AppConstants.TOKEN), "application/json"
                ).enqueue(object : Callback<ProfessionDataClass> {
                    override fun onFailure(call: Call<ProfessionDataClass>, t: Throwable) {
                           CommonUtil.hideDialog(this@PhoneNumberActivity)
                        CommonUtil.toast(R.string.showError.toString(), this@PhoneNumberActivity)
                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(call: Call<ProfessionDataClass>, response: Response<ProfessionDataClass>) {
                             CommonUtil.hideDialog(this@PhoneNumberActivity)

                        Log.i("professddion", response.body().toString())
                        val getdata = response.body()
                        CommonUtil.logi(getdata.toString())


                        if (getdata != null) {
                            if (getdata.data!=null) professionList = getdata.data
                        }

                    }

                })
            }
            // startActivity(Intent(this,OtpActivity::class.java))
        } else {
            CommonUtil.toast("Check Internet", this@PhoneNumberActivity)
        }
    }

    //todo Popup window like spinner

    private fun showAlertFilter(): PopupWindow {
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.alter_profession_layout, null)
        val recyclerView = view.findViewById<RecyclerView>(R.id.professionRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))

        val adapter = UserProfessionAdapter(professionList)

        recyclerView.adapter = adapter
        adapter.selectedItem(selectedItem)

        adapter.setOnClick(object : RecyclerviewCallbacks<DataXXXXX> {
            override fun onItemClick(view: View, position: Int, item: DataXXXXX) {
                selectedItem = position
              //  Toast.makeText(this@PhoneNumberActivity, "data = ${item.profession_id}", Toast.LENGTH_SHORT).show()
                CommonUtil.saveStringPreferences(
                    this@PhoneNumberActivity, AppConstants.PROFESSION, item.profession_id.toString())
                userProfileTvProfessionName.text = item.profession_name.toString()
              professionSelected =  item.profession_id.toString()
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
}

