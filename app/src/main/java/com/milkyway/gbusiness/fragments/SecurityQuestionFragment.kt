package com.milkyway.gbusiness.fragments


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.DataXXXXXXXXXXXX
import com.milkyway.gbusiness.models.QuestionListDataClass
import com.milkyway.gbusiness.models.UpdateUserDetailsDataClass
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.global.CommonUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SecurityQuestionFragment : Fragment(), AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        itemss = arrayList[position].que_id.toString()
    }

    lateinit var itemss: String
    lateinit var questionDropDownImg: ImageView
    lateinit var SubmittRecBtn: TextView
    lateinit var questionFragQstionTv: Spinner
    lateinit var questionFragAnswerTv: EditText
    private lateinit var mySecQuestionBack: ImageView
    private lateinit var arrayList: MutableList<DataXXXXXXXXXXXX>
    lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_security_question, container, false)
        questionFragQstionTv = view.findViewById(R.id.questionFragQstionTv)
        SubmittRecBtn = view.findViewById(R.id.SubmittRecBtn)
        questionFragAnswerTv = view.findViewById(R.id.questionFragAnswerTv)
        mySecQuestionBack = view.findViewById(R.id.mySecQuestionBack)
        mySecQuestionBack.setOnClickListener { findNavController().navigate(R.id.action_securityQuestionFragment_to_mainFragment) }

        SubmittRecBtn.setOnClickListener { updateAnswer() }
        questionFragQstionTv.onItemSelectedListener = this

        getSecurityQuestionAPI()
        return view
    }


    private fun getSecurityQuestionAPI() {
        if (CommonUtil.checkNetwork(mContext)) {
            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)
            val dataNotic = GbusinessService.create(mContext)
            if (userID != null) {
                dataNotic.getSecrutyQuestionList(
                    "Bearer " + CommonUtil.getPreferencesString(
                        mContext,
                        AppConstants.TOKEN
                    )
                )
                    .enqueue(object : Callback<QuestionListDataClass> {
                        override fun onFailure(call: Call<QuestionListDataClass>, t: Throwable) {
                            CommonUtil.hideDialog(mContext)
                            CommonUtil.toast(R.string.showError.toString(), mContext)
                            CommonUtil.logi(t.localizedMessage.toString())
                        }

                        override fun onResponse(
                            call: Call<QuestionListDataClass>,
                            response: Response<QuestionListDataClass>,
                        ) {
                            CommonUtil.hideDialog(mContext)
                            val getdata = response.body()
                            Log.i("TAG", getdata.toString())
                            if (getdata != null) {

                                if (getdata.success) {
                                    if (getdata.data.isNotEmpty()) {
                                        arrayList = getdata.data as ArrayList<DataXXXXXXXXXXXX>
                                    }

                                    val spinnerArrayAdapter = ArrayAdapter(mContext, android.R.layout.simple_list_item_1, arrayList)
                                    questionFragQstionTv.adapter = spinnerArrayAdapter
                                }
                            }
                        }
                    })
            }
        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }

    private fun updateAnswer() {
        if (questionFragAnswerTv.text.isEmpty()) {
            questionFragAnswerTv.requestFocus()
        }
        if (CommonUtil.checkNetwork(mContext)) {
            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)
            val dataNotic = GbusinessService.create(mContext)
            if (userID != null) {
                dataNotic.getUpdateAnswer("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), userID,
                    questionFragAnswerTv.text.toString(), itemss).enqueue(object : Callback<UpdateUserDetailsDataClass> {
                    override fun onFailure(call: Call<UpdateUserDetailsDataClass>, t: Throwable) {
                        CommonUtil.hideDialog(mContext)
                        CommonUtil.toast(R.string.showError.toString(), mContext)
                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(call: Call<UpdateUserDetailsDataClass>, response: Response<UpdateUserDetailsDataClass>) {
                        CommonUtil.hideDialog(mContext)
                        val getdata = response.body()
                        //  Log.i("dfsdahf",getdata.toString())
                        if (getdata != null) {

                            if (getdata.success) {
                                CommonUtil.toast("Success", mContext)
                                findNavController().navigate(R.id.action_securityQuestionFragment_to_mainFragment)
                            } else {
                                CommonUtil.toast("Some thing went wrong", mContext)
                            }
                        }
                    }
                })
            }
        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }

}

