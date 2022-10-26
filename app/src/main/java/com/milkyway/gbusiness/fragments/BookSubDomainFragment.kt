package com.milkyway.gbusiness.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.milkyway.gbusiness.activities.MainActivity
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.*
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.utils.CommonUtil
import com.milkyway.gbusiness.utils.ScrollViewText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookSubDomainFragment() : Fragment() {

    private lateinit var bookDomainSearchEdt: EditText
    private lateinit var tvSubdomainFoundNotFound: ScrollViewText
    private lateinit var layoutSubdomainAvailable: CardView
    private lateinit var layoutBookNow: CardView
    private lateinit var tvMsgSubdomain: TextView
    private lateinit var searchDomainName: TextView
    private lateinit var btnBookSubdomain: AppCompatButton
    private lateinit var btnSearchSubdomain: AppCompatButton
    private lateinit var btnSearchSubdomainn: AppCompatButton
    private lateinit var myBookDomainBack: ImageView
    private lateinit var mContext: Context
    private lateinit var mDomainPriceDetail: DomainPriceDetail

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_book_sub_domain, container, false)


        inits(view)

        return view
    }

    private fun inits(view: View) {
        mDomainPriceDetail = DomainPriceDetail()
        bookDomainSearchEdt = view.findViewById(R.id.bookDomainSearchEdt)
        myBookDomainBack = view.findViewById(R.id.myBookDomainBack)
        tvSubdomainFoundNotFound = view.findViewById(R.id.tvSubdomainFoundNotFound)

        layoutSubdomainAvailable = view.findViewById(R.id.layoutSubdomainAvailable)
        layoutBookNow = view.findViewById(R.id.layoutBookNow)
        tvMsgSubdomain = view.findViewById(R.id.tvMsgSubdomain)
        searchDomainName = view.findViewById(R.id.searchDomainName)
        btnSearchSubdomain = view.findViewById(R.id.btnSearchSubdomain)
        btnSearchSubdomainn = view.findViewById(R.id.btnSearchSubdomainn)
        btnBookSubdomain = view.findViewById(R.id.btnBookSubdomain)



        myBookDomainBack.setOnClickListener { MainActivity.navController.navigate(R.id.action_bookYourDomainFragment_to_mainFragment) }

        btnSearchSubdomain.setOnClickListener {
            //CommonUtil.errorToast("Clicked", "Clicked on search txt button", requireActivity())
            callSearchSubdomainApi()
        }

        btnSearchSubdomainn.setOnClickListener {
            CommonUtil.errorToast("Clicked", "Clicked on search txt button", requireActivity())
            callSearchSubdomainApi()
        }

        btnBookSubdomain.setOnClickListener {
            callBookSubdomainApi()
        }

        val anim: Animation = AlphaAnimation(0.0f, 1.0f)
        anim.duration = 700 //You can manage the blinking time with this parameter

        anim.startOffset = 20
        anim.repeatMode = Animation.REVERSE
        anim.repeatCount = Animation.INFINITE
        tvMsgSubdomain.startAnimation(anim)

        tvSubdomainFoundNotFound.startScroll()


        //Pause ACTION_DOWN, resume scroll otherwise.

        //Pause ACTION_DOWN, resume scroll otherwise.
        tvSubdomainFoundNotFound.setOnTouchListener(View.OnTouchListener { view, motionEvent -> //https://developer.android.com/training/gestures/detector.html
            if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                tvSubdomainFoundNotFound.pauseScroll()
                Log.i("BookSubdomainFragment", "Round duration: " + tvSubdomainFoundNotFound.getRoundDuration())
                return@OnTouchListener true
            } else if (motionEvent.action == MotionEvent.ACTION_UP) {
                tvSubdomainFoundNotFound.resumeScroll()
                return@OnTouchListener true
            }
            false
        })
    }

    private fun callSearchSubdomainApi() {
        if (bookDomainSearchEdt.text.isEmpty()) {
            bookDomainSearchEdt.requestFocus()
            bookDomainSearchEdt.error = "enter domain name"

        } else if (bookDomainSearchEdt.text.contains("@")) {
            bookDomainSearchEdt.requestFocus()
            bookDomainSearchEdt.error = "remove @"

        } else if (bookDomainSearchEdt.text.contains("http")) {
            bookDomainSearchEdt.requestFocus()
            bookDomainSearchEdt.error = "remove http"

        } else {
            if (CommonUtil.checkNetwork(mContext)) {
                var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
                CommonUtil.showDialog(mContext)
                val dataNotic = GbusinessService.create(mContext)
                if (userID != null) {
                    dataNotic.searchSubDomain("application/json", bookDomainSearchEdt.text.toString().trim())
                        .enqueue(object : Callback<SubdomainResponse> {
                        override fun onResponse(call: Call<SubdomainResponse>, response: Response<SubdomainResponse>) {
                            CommonUtil.hideDialog(mContext)
                            val getDataResponse = response.body()
                            CommonUtil.logi(getDataResponse.toString())
                            if (response.code() == 200) {
                                val gson = Gson()
                                if (getDataResponse?.success == true) {
                                    //val trueResponse = gson.fromJson(gson.toJson(response.body()), SearchSubdomainSuccess::class.java)
                                    layoutSubdomainAvailable.visibility = View.VISIBLE
                                    layoutBookNow.visibility = View.VISIBLE
                                    tvMsgSubdomain.setTextColor(resources.getColor(R.color.greenMsg))
                                    searchDomainName.text = "${bookDomainSearchEdt.text.toString().trim()}.gbusiness.co"
                                    tvMsgSubdomain.text = "${bookDomainSearchEdt.text.toString().trim()}.gbusiness.co is available."
                                    //CommonUtil.successToast("Available!", "${bookDomainSearchEdt.text.toString().trim()}.gbusiness.co is available.", requireActivity())
                                } else if (getDataResponse?.success == false) {
                                    //val falseResponse = gson.fromJson(gson.toJson(response.errorBody()), SearchSubdomainFalse::class.java)
                                    layoutSubdomainAvailable.visibility = View.VISIBLE
                                    layoutBookNow.visibility = View.GONE
                                    tvMsgSubdomain.setTextColor(resources.getColor(R.color.red))
                                    tvMsgSubdomain.text = "Sub Domain already has been taken.\n" +
                                            "Please try another one....."
                                    //CommonUtil.errorToast("Not Available!", "This sub Domain already has been taken. \nPlease try another.....", requireActivity())
                                }
                            } else if (response.code() == 500) {
                                CommonUtil.errorToast("Server Error!", "Server isn't responding currently", requireActivity())
                            }
                        }

                            override fun onFailure(call: Call<SubdomainResponse>, t: Throwable) {
                                CommonUtil.hideDialog(mContext)
                                CommonUtil.errorToast("Failure Error!", "${t.message}", requireActivity())
                                //CommonUtil.toast(R.string.showError.toString(), mContext)
                                //CommonUtil.login(t.localizedMessage.toString())
                            }
                    })
                }
            } else {
                //CommonUtil.toast("Check Internet", mContext)
                CommonUtil.noInternetToast("Internet Connectivity!", "No internet connectivity. Plz connect your internet.", requireActivity())
            }

        }
    }


    private fun callBookSubdomainApi() {
        if (bookDomainSearchEdt.text.isEmpty()) {
            bookDomainSearchEdt.requestFocus()
            bookDomainSearchEdt.error = "enter domain name"

        } else if (bookDomainSearchEdt.text.contains("@")) {
            bookDomainSearchEdt.requestFocus()
            bookDomainSearchEdt.error = "remove @"

        } else if (bookDomainSearchEdt.text.contains("http")) {
            bookDomainSearchEdt.requestFocus()
            bookDomainSearchEdt.error = "remove http"

        } else {
            if (CommonUtil.checkNetwork(mContext)) {
                var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
                CommonUtil.showDialog(mContext)
                val dataNotic = GbusinessService.create(mContext)
                if (userID != null) {
                    dataNotic.bookSubDomain("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), "application/json",
                        bookDomainSearchEdt.text.toString().trim(),
                        userID
                    ).enqueue(object : Callback<SubdomainResponse> {
                        override fun onFailure(call: Call<SubdomainResponse>, t: Throwable) {
                            CommonUtil.hideDialog(mContext)
                            CommonUtil.errorToast("Failure Error!", "${t.message}", requireActivity())
                            //CommonUtil.toast(R.string.showError.toString(), mContext)
                            //CommonUtil.login(t.localizedMessage.toString())
                        }

                        override fun onResponse(call: Call<SubdomainResponse>, response: Response<SubdomainResponse>) {
                            CommonUtil.hideDialog(mContext)
                            val getData = response.body()
                            CommonUtil.logi(getData.toString())
                            if (response.code() == 200) {

                                if (getData?.success == true) {
                                    CommonUtil.successToast("Subdomain Booking!", "You have booked your subdomain successfully.", requireActivity())
                                    startActivity(Intent(requireActivity(), MainActivity::class.java))
                                }
                            } else if (response.code() == 500) {
                                CommonUtil.errorToast("Server Error!", "Server isn't responding currently", requireActivity())
                            }
                        }
                    })
                }
            } else {
                //CommonUtil.toast("Check Internet", mContext)
                CommonUtil.noInternetToast("Internet Connectivity!", "No internet connectivity. Plz connect your internet.", requireActivity())
            }

        }

    }


}
