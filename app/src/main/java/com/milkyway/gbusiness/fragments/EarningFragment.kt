package com.milkyway.gbusiness.fragments


import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.ClipData
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.adaptor.EarningFragmentAdoptor
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.utils.CommonUtil
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.EarningDataClass
import com.milkyway.gbusiness.models.EarningDateWiseDataClass
import com.milkyway.gbusiness.models.Totalearning
import com.milkyway.gbusiness.models.WalletBalanceDataClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.math.RoundingMode
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class EarningFragment : Fragment(), Callback<EarningDataClass> {

    companion object {
        var onDateSection: Boolean = false
    }

    private lateinit var Adopter: EarningFragmentAdoptor
    var recyclerViewEarning: RecyclerView? = null

    private lateinit var myWalletBalance: TextView
    private lateinit var tvCopyRefCode: TextView

    private lateinit var tvEarningTotal: TextView
    private lateinit var tvEarningDirect: TextView
    private lateinit var tvEarningGlobal: TextView
    private lateinit var tvMyDirects: TextView

    private lateinit var tvEarningTotalBtm: TextView
    private lateinit var tvEarningDirectBtm: TextView
    private lateinit var tvEarningGlobalBtm: TextView
    private lateinit var tvMyDirectsBtm: TextView

    private lateinit var tvEarningRefCode: TextView
    private lateinit var earningToDate: TextView
    private lateinit var earningFromDate: TextView
    private lateinit var earningGoBtn: TextView

    private lateinit var layoutEarningTotal: View
    private lateinit var layoutEarningDirect: View
    private lateinit var layoutEarningGlobal: View
    private lateinit var layoutWalletHistory: View

    var earningOf: String = "total"


    private lateinit var myEarningBack: ImageView

    private lateinit var totalEarnList: ArrayList<Totalearning>
    private lateinit var directEarnList: ArrayList<Totalearning>
    private lateinit var globalEarnList: ArrayList<Totalearning>

    private lateinit var arrayDate: ArrayList<Totalearning>
    private lateinit var arrayDirectDate: ArrayList<Totalearning>
    private lateinit var arrayGlobalDate: ArrayList<Totalearning>

    private lateinit var mContext: Context
    var cal = Calendar.getInstance()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_earning, container, false)
        myInitList()
        initViews(view)
        return view
    }

    private fun myInitList() {
        totalEarnList = ArrayList<Totalearning>()
        directEarnList = ArrayList<Totalearning>()
        globalEarnList = ArrayList<Totalearning>()

        arrayDate = ArrayList<Totalearning>()
        arrayDirectDate = ArrayList<Totalearning>()
        arrayGlobalDate = ArrayList<Totalearning>()

        totalEarnList.clear()
        directEarnList.clear()
        globalEarnList.clear()

        arrayDate.clear()
        arrayDirectDate.clear()
        arrayGlobalDate.clear()

        Adopter = EarningFragmentAdoptor(mContext, totalEarnList)
        recyclerViewEarning?.adapter = Adopter

    }

    private fun initViews(view: View) {
        myWalletBalance = view.findViewById<TextView>(R.id.myWalletBalance)
        tvEarningRefCode = view.findViewById<TextView>(R.id.tvEarningRefCode)
        tvCopyRefCode = view.findViewById<TextView>(R.id.tvCopyRefCode)

        tvEarningTotal = view.findViewById<TextView>(R.id.tvEarningTotal)
        tvEarningDirect = view.findViewById<TextView>(R.id.tvEarningDirect)
        tvEarningGlobal = view.findViewById<TextView>(R.id.tvEarningGlobal)
        tvMyDirects = view.findViewById<TextView>(R.id.tvMyDirects)


        tvEarningTotalBtm = view.findViewById<TextView>(R.id.tvEarningTotalBtm)
        tvEarningDirectBtm = view.findViewById<TextView>(R.id.tvEarningDirectBtm)
        tvEarningGlobalBtm = view.findViewById<TextView>(R.id.tvEarningGlobalBtm)
        tvMyDirectsBtm = view.findViewById<TextView>(R.id.tvMyDirectsBtm)

        layoutEarningTotal = view.findViewById<View>(R.id.layoutEarningTotal)
        layoutEarningDirect = view.findViewById<View>(R.id.layoutEarningDirect)
        layoutEarningGlobal = view.findViewById<View>(R.id.layoutEarningGlobal)
        layoutWalletHistory = view.findViewById<View>(R.id.layoutWalletHistory)

        earningToDate = view.findViewById<TextView>(R.id.earningToDate)
        earningFromDate = view.findViewById<TextView>(R.id.earningFromDate)
        earningGoBtn = view.findViewById<TextView>(R.id.earningGoBtn)

        myEarningBack = view.findViewById<ImageView>(R.id.myEarningBack)
        myEarningBack.setOnClickListener { view.findNavController().navigate(R.id.action_earningFragment_to_mainFragment) }

        recyclerViewEarning = view.findViewById<RecyclerView>(R.id.recyclerViewEarning)
        recyclerViewEarning!!.hasFixedSize()
        recyclerViewEarning!!.layoutManager = LinearLayoutManager(mContext)

        tvEarningTotal.background = mContext.resources.getDrawable(R.drawable.bg_gradient_selected)
        tvEarningDirect.background = mContext.resources.getDrawable(R.drawable.bg_gradient)
        tvEarningGlobal.background = mContext.resources.getDrawable(R.drawable.bg_gradient)

        tvEarningTotalBtm.background = mContext.resources.getDrawable(R.drawable.bg_gradient_dark_selected)
        tvEarningDirectBtm.background = mContext.resources.getDrawable(R.drawable.bg_gradient_dark)
        tvEarningGlobalBtm.background = mContext.resources.getDrawable(R.drawable.bg_gradient_dark)


        earningToDate.setOnClickListener { getDatePickers() }
        earningFromDate.setOnClickListener { getDatePickersfrom() }
        earningGoBtn.setOnClickListener { getEarningByDate() }

        layoutWalletHistory.setOnClickListener { showWalletHistory(view) }

        layoutEarningTotal.setOnClickListener {
            earningOf = "total"
            myInitList()
            tvEarningTotal.background = mContext.resources.getDrawable(R.drawable.bg_gradient_selected)
            tvEarningDirect.background = mContext.resources.getDrawable(R.drawable.bg_gradient)
            tvEarningGlobal.background = mContext.resources.getDrawable(R.drawable.bg_gradient)

            tvEarningTotalBtm.background = mContext.resources.getDrawable(R.drawable.bg_gradient_dark_selected)
            tvEarningDirectBtm.background = mContext.resources.getDrawable(R.drawable.bg_gradient_dark)
            tvEarningGlobalBtm.background = mContext.resources.getDrawable(R.drawable.bg_gradient_dark)
            getTottalEarningApi()
        }
        layoutEarningDirect.setOnClickListener {
            earningOf = "direct"
            myInitList()
            tvEarningTotal.background = mContext.resources.getDrawable(R.drawable.bg_gradient)
            tvEarningDirect.background = mContext.resources.getDrawable(R.drawable.bg_gradient_selected)
            tvEarningGlobal.background = mContext.resources.getDrawable(R.drawable.bg_gradient)

            tvEarningTotalBtm.background = mContext.resources.getDrawable(R.drawable.bg_gradient_dark)
            tvEarningDirectBtm.background = mContext.resources.getDrawable(R.drawable.bg_gradient_dark_selected)
            tvEarningGlobalBtm.background = mContext.resources.getDrawable(R.drawable.bg_gradient_dark)
            getTottalEarningApi()
        }
        layoutEarningGlobal.setOnClickListener {
            earningOf = "global"
            myInitList()
            tvEarningTotal.background = mContext.resources.getDrawable(R.drawable.bg_gradient)
            tvEarningDirect.background = mContext.resources.getDrawable(R.drawable.bg_gradient)
            tvEarningGlobal.background = mContext.resources.getDrawable(R.drawable.bg_gradient_selected)

            tvEarningTotalBtm.background = mContext.resources.getDrawable(R.drawable.bg_gradient_dark)
            tvEarningDirectBtm.background = mContext.resources.getDrawable(R.drawable.bg_gradient_dark)
            tvEarningGlobalBtm.background = mContext.resources.getDrawable(R.drawable.bg_gradient_dark_selected)
            getTottalEarningApi()
        }

        view.findViewById<View>(R.id.layoutEarningMyDirectPeoples).setOnClickListener {

            view.findNavController().navigate(R.id.action_earningFragment_to_myDirectsPeoples)
        }

        tvEarningRefCode.setOnClickListener {
            setClipBoard()
        }

        tvCopyRefCode.setOnClickListener {
            setClipBoard()
        }
        // getTimePicker()
        //getDatePickers()

        getWalltBalApi()
        getTottalEarningApi()
    }

    private fun setClipBoard() {
        val clipboard = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
        val clip: ClipData = ClipData.newPlainText("copyAddress", tvEarningRefCode.text)
        clipboard.setPrimaryClip(clip)

        CommonUtil.toast("Text Copied", mContext)
    }


    private fun showWalletHistory(view: View?) {
        view?.findNavController()?.navigate(R.id.action_earningFragment_to_walletHistory)
    }


    private fun getTimePicker() {
        val c = Calendar.getInstance()
        val hour = c.get(Calendar.HOUR)
        val minute = c.get(Calendar.MINUTE)

        val tpd = TimePickerDialog(mContext, TimePickerDialog.OnTimeSetListener(function = { view, h, m ->


            CommonUtil.toast(h.toString() + " : " + m + " : ", mContext)


        }), hour, minute, false)

        tpd.show()
    }


    private fun getTottalEarningApi() {
        checkConnection()

    }

    private fun checkConnection() {
        if (CommonUtil.checkNetwork(mContext)) {
            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)
            val dataNotic = GbusinessService.create(mContext)
            if (userID != null) {
                dataNotic.getEarning(
                    "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), "application/json",
                    userID
                )
                    .enqueue(this)
            }

        } else {
            CommonUtil.toast("Check Internet", mContext)
        }


    }


    private fun getEarningByDate() {
        if (CommonUtil.checkNetwork(mContext)) {
            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)
            val dataNotic = GbusinessService.create(mContext)
            if (userID != null) {
                dataNotic.getEarningByDate(
                    "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), "application/json",
                    earningFromDate.text.toString().trim(), earningToDate.text.toString().trim(), userID, earningOf
                )
                    .enqueue(object : Callback<EarningDateWiseDataClass> {
                        override fun onFailure(call: Call<EarningDateWiseDataClass>, t: Throwable) {
                            CommonUtil.hideDialog(mContext)
                            CommonUtil.toast(R.string.showError.toString(), mContext)
                            CommonUtil.logi(t.localizedMessage.toString())
                        }

                        override fun onResponse(
                            call: Call<EarningDateWiseDataClass>,
                            response: Response<EarningDateWiseDataClass>
                        ) {


                            CommonUtil.hideDialog(mContext)
                            //   Log.i("manu", response.body().toString())
                            val getdata = response.body()
                            CommonUtil.logi(getdata.toString())


                            if (getdata != null) {
                                if (getdata.success) {

                                    if (getdata.data != null && getdata.data.size > 0) {

                                        arrayDate.clear()
                                        arrayDate = getdata.data
                                        Log.i("arrayDate", arrayDate.toString())

                                        if (getdata.data.size > 0) {
                                            for (iteam in getdata.data) {
                                                if (iteam.earning_type.contains("Global Earning")) arrayGlobalDate.add(
                                                    iteam
                                                )
                                                //  Log.i("fdjk", arrayGlobalDate.size?.toString())
                                                //  Log.i("fdjk", iteam.earning_type)

                                                if (iteam.earning_type.contains("Direct Earning")) arrayDirectDate.add(
                                                    iteam
                                                )
                                                //   Log.i("fdjk1", arrayDirectDate.size?.toString())
                                                //   Log.i("fdjk1", iteam.earning_type)
                                            }

                                        } else CommonUtil.toast("no entry found", mContext)

                                        showEarningwithDate()
                                    }
                                }

                                if (getdata.message != null) CommonUtil.toast(getdata.message, mContext)

                            } else CommonUtil.toast("no entry found", mContext)
                        }
                    })
            }
            // startActivity(Intent(this,OtpActivity::class.java))
        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }


    override fun onFailure(call: Call<EarningDataClass>, t: Throwable) {
        CommonUtil.hideDialog(mContext)
        CommonUtil.toast("SomeThing Went Wrong ! Try Later", mContext)
        CommonUtil.logi(t.localizedMessage.toString())
    }

    @SuppressLint("SetTextI18n")
    override fun onResponse(call: Call<EarningDataClass>, response: Response<EarningDataClass>) {
        CommonUtil.hideDialog(mContext)

        val getdata = response.body()
        // CommonUtil.logi(getdata.toString())
        Log.i("paajadfjkgha", getdata.toString())


        if (getdata != null) {
            if (getdata.success) {
                if (getdata.data.directearning != null) {
                    val number = getdata.data.directearning
                    val rounded = number.toBigDecimal().setScale(3, RoundingMode.UP).toDouble()
                    tvEarningDirect.text = "Direct\nEarning\n\$ ${rounded.toString()}"
                }
                if (getdata.data.globalearning != null) {
                    val number = getdata.data.globalearning
                    val rounded = number.toBigDecimal().setScale(3, RoundingMode.UP).toDouble()
                    tvEarningGlobal.text = "Global\nEarning\n\$ ${rounded.toString()}"
                }
                if (getdata.data.totalearning != null) {
                    val number = getdata.data.totalearning
                    val rounded = number.toBigDecimal().setScale(3, RoundingMode.UP).toDouble()
                    tvEarningTotal.text = "Total\nEarning\n\$ ${rounded.toString()}"

                }
                if (getdata.data.userRefferal != null) {
                    tvEarningRefCode.text = "Referral Code: ${getdata.data.userRefferal.toString()}"

                    CommonUtil.saveStringPreferences(mContext, AppConstants.ReferalCode, getdata.data.userRefferal)

                }

                if (getdata.data.totalearning_list != null && getdata.data.totalearning_list.size > 0) {

                    totalEarnList.clear()

                    totalEarnList = getdata.data.totalearning_list
                    //   Log.i("totalEarnList", totalEarnList.toString())

                    if (getdata.data.totalearning_list.size > 0) {
                        for (item in getdata.data.totalearning_list) {
                            if (item.earning_type.contains("Global Earning")) globalEarnList.add(item)
                            //   Log.i("fdjk", globalEarnList.size?.toString())
                            //  Log.i("fdjk", iteam.earning_type)

                            if (item.earning_type.contains("Direct Earning")) directEarnList.add(item)
                            //  Log.i("fdjk1", directEarnList.size?.toString())
                            // Log.i("fdjk1", iteam.earning_type)
                        }
                    }
                    showEarning()
                } else CommonUtil.toast("No entry found", mContext)
            }
            if (getdata.message != null)
                CommonUtil.toast(getdata.message, mContext)

        } else CommonUtil.toast("no entry found", mContext)

    }

    //todo date picker frist

    private fun getDatePickers() {
        DatePickerDialog(mContext, dateSetListener, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show()
    }

    // create an OnDateSetListener
    val dateSetListener = object : DatePickerDialog.OnDateSetListener {
        override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int) {
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateDateInView()
        }
    }

    private fun updateDateInView() {
        val myFormat = "yyyy/MM/dd"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        earningToDate.text = sdf.format(cal.getTime())
        CommonUtil.toast(sdf.format(cal.getTime()), mContext)
    }

    //todo date picker second
    private fun getDatePickersfrom() {
        DatePickerDialog(
            mContext,
            dateSetListenerfrom,
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    // create an OnDateSetListener
    val dateSetListenerfrom = object : DatePickerDialog.OnDateSetListener {
        override fun onDateSet(
            view: DatePicker, year: Int, monthOfYear: Int,
            dayOfMonth: Int
        ) {
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateDateInViewfrom()
        }
    }

    private fun updateDateInViewfrom() {
        val myFormat = "yyyy/MM/dd"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        earningFromDate.text = sdf.format(cal.getTime())
        CommonUtil.toast(sdf.format(cal.getTime()), mContext)
    }

    //todo get wallet details
    private fun getWalltBalApi() {
        if (CommonUtil.checkNetwork(mContext)) {
            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)

            val dataNotic = GbusinessService.create(mContext)
            if (userID != null) {
                dataNotic.getWalletBalance(
                    "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), userID
                ).enqueue(object : Callback<WalletBalanceDataClass> {
                    override fun onFailure(call: Call<WalletBalanceDataClass>, t: Throwable) {

                        CommonUtil.toast("SomeThing Went Wrong ! Try Later", mContext)
                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(
                        call: Call<WalletBalanceDataClass>,
                        response: Response<WalletBalanceDataClass>
                    ) {
                        val getdata = response?.body()
                        CommonUtil.logi(getdata.toString())


                        if (getdata != null) {
                            if (getdata.success) {
                                if (getdata.data != null && getdata.data.size > 0) {

                                    val balance = getdata.data.get(0).balance
                                    myWalletBalance.text = "$ " + CommonUtil.decimslToString(balance)


                                }

                            }
                            if (getdata.message != null) CommonUtil.toast(getdata.message, mContext)
                        } else CommonUtil.toast("SomeThing went Wrong", mContext)
                    }

                })
            }
        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }


    private fun showEarning() {
        onDateSection = false
        if (totalEarnList.size > 0) {
            if (earningOf.contains("total")) {
                Adopter = EarningFragmentAdoptor(mContext, totalEarnList)
                recyclerViewEarning!!.adapter = Adopter
            }
            if (earningOf.contains("direct")) {
                if (directEarnList.size > 0) {
                    Adopter = EarningFragmentAdoptor(mContext, directEarnList)
                    recyclerViewEarning!!.adapter = Adopter
                } else CommonUtil.toast("No entry found", mContext)
            }
            if (earningOf.contains("global")) {
                if (globalEarnList.size > 0) {
                    Adopter = EarningFragmentAdoptor(mContext, globalEarnList)
                    recyclerViewEarning!!.adapter = Adopter
                } else CommonUtil.toast("No entry found", mContext)
            }
        }
    }

    fun showEarningwithDate() {
        onDateSection = false

        if (arrayDate.size > 0) {
            if (earningOf.contains("total")) {
                Adopter = EarningFragmentAdoptor(mContext, arrayDate)
                recyclerViewEarning!!.adapter = Adopter
            }
            if (earningOf.contains("direct")) {
                if (arrayDirectDate.size > 0) {
                    Adopter = EarningFragmentAdoptor(mContext, arrayDirectDate)
                    recyclerViewEarning!!.adapter = Adopter
                } else CommonUtil.toast("No entry found", mContext)
            }
            if (earningOf.contains("global")) {
                if (arrayGlobalDate.size > 0) {
                    Adopter = EarningFragmentAdoptor(mContext, arrayGlobalDate)
                    recyclerViewEarning!!.adapter = Adopter
                } else CommonUtil.toast("No entry found", mContext)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        if (CommonUtil.dialog != null) CommonUtil.dialog.hide()
    }
}
