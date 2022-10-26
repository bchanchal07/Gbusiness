package com.milkyway.gbusiness.fragments


import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.adaptor.DomainListAdaptot
import com.milkyway.gbusiness.adaptor.MySiteFragmentAdaptor
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.api.OnClickServices
import com.milkyway.gbusiness.models.*
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.utils.CommonUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MySiteFragment : Fragment(), Callback<MysiteDetailsDataClass>, OnClickServices {


    lateinit var viewAdapter: MySiteFragmentAdaptor
    lateinit var viewAdapterDomain: DomainListAdaptot
    var recyclerView: RecyclerView? = null
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var mySiteBack: ImageView
    private lateinit var trashListFloatingButn: FloatingActionButton
    private lateinit var showeDomainListBootomSheat: BottomSheetDialog
    private lateinit var recyclerViewDomain: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    var mySiteRelativeLayout: RelativeLayout? = null

    private lateinit var mContext: Context
    private var arrayList: List<DataXXXXXXX>? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val view = inflater.inflate(R.layout.fragment_my_site, container, false)

        viewManager = LinearLayoutManager(mContext)

        mySiteRelativeLayout = view.findViewById(R.id.mySiteRelativeLayout)
        trashListFloatingButn = view.findViewById(R.id.trashListFloatingButn)

        mySiteBack = view.findViewById(R.id.mySiteBack)
        recyclerView = view.findViewById(R.id.mySiteRecyclerView)
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout)
        recyclerView?.hasFixedSize()
        recyclerView!!.layoutManager = LinearLayoutManager(mContext)

        mySiteBack.setOnClickListener {
            view.findNavController().navigate(R.id.action_mySiteFragment_to_mainFragment)
        }
        trashListFloatingButn.setOnClickListener {
            view.findNavController().navigate(R.id.action_mySiteFragment_to_trashLisFragment)
        }

        swipeRefreshLayout.setOnRefreshListener {
            refreshData()
            swipeRefreshLayout.isRefreshing = false
        }
        getMySiteApi()
        return view
    }

    private fun refreshData() {
        getMySiteApi()
    }

    private fun getMySiteApi() {

        if (CommonUtil.checkNetwork(mContext)) {
            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)
            val dataNotic = GbusinessService.create(mContext)
            if (userID != null) {
                dataNotic.getMySite(
                    "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),
                    userID
                ).enqueue(this)
            }

        } else {
            CommonUtil.toast("Check Internet", mContext)
        }

    }


    override fun onFailure(call: Call<MysiteDetailsDataClass>, t: Throwable) {
        CommonUtil.hideDialog(mContext)
        CommonUtil.toast(R.string.showError.toString(), mContext)
        CommonUtil.logi(t.localizedMessage.toString())

    }

    override fun onResponse(
        call: Call<MysiteDetailsDataClass>,
        response: Response<MysiteDetailsDataClass>,
    ) {
        CommonUtil.hideDialog(mContext)
        val getData = response?.body()

        Log.i("TAG", getData.toString())

        when (response.code()) {
            200 -> {
                if (getData != null) {
                    if (getData.success) {
                        if (getData.data != null && getData.data.isNotEmpty()) {
                            arrayList = getData.data
                            viewAdapter = MySiteFragmentAdaptor(this, arrayList)
                            recyclerView?.adapter = viewAdapter
                        }
                    } else mySiteRelativeLayout?.background =
                        resources.getDrawable(R.drawable.mysite_background)
                    if (getData.message != null) CommonUtil.toast(getData.message, mContext)

                }
            }
            500 -> CommonUtil.errorToast("Server Error!", "Server isn't responding currently.", requireActivity())
            else -> CommonUtil.errorToast("Error!", "Something went wrong! Please try again.....", requireActivity())
        }
    }

    override fun onClick(id: String, name: String) {
        val bundle = Bundle()
        bundle.putString("back", "MySiteFragment")
        bundle.putString("webUrl", name)
        view?.findNavController()
            ?.navigate(R.id.action_mySiteFragment_to_paymentOrInvoiceWebView, bundle)
    }

    override fun onClickDownload(webUrl: String) {

    }

    override fun onClickTrash(tempID: String, name: String) {

        showAlertDialogButtonClicked(tempID, mContext)
    }

    //todo show alert for move to trash the site
    private fun showAlertDialogButtonClicked(tempID: String, mContext: Context) {
        val builder = AlertDialog.Builder(mContext)

        builder.setTitle("WARNING !")

        builder.setMessage("Are you sure you want to move it to trash ?")

        builder.setPositiveButton("YES") { dialog, _ ->

            siteMoveToTrash(tempID, dialog)
            Log.i("dfd", "djfhdsh")
        }
        // Display a negative button on alert dialog
        builder.setNegativeButton("No") { dialog, which ->
            dialog.dismiss()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }


    fun getDomainList(templateID: String) {

        if (CommonUtil.checkNetwork(mContext)) {
            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)
            val dataNotic = GbusinessService.create(mContext)
            if (userID != null) {
                dataNotic.domainListToPublishSite(
                    "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),
                    userID, templateID
                ).enqueue(object : Callback<DomainListAvalableDataClass> {
                    override fun onFailure(call: Call<DomainListAvalableDataClass>, t: Throwable) {
                        CommonUtil.hideDialog(mContext)
                        CommonUtil.toast(R.string.showError.toString(), mContext)
                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(
                        call: Call<DomainListAvalableDataClass>,
                        response: Response<DomainListAvalableDataClass>,
                    ) {
                        CommonUtil.hideDialog(mContext)

                        Log.i("professddion", response.body().toString())
                        val getData = response.body()
                        CommonUtil.logi(getData.toString())


                        if (getData != null) {
                            if (getData.success) {
                                if (getData.data.isNotEmpty()) {
                                    val arrayDomain = getData.data
                                    showDomainList(arrayDomain, templateID)
                                } else {
                                    CommonUtil.toast("NO Domin Found", mContext)
                                }
                            }

                        }

                    }

                })
            }
        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }

    fun showDomainList(
        arrayDomain: List<DataXXXXXXXXXXXXXXXXXXXXXXXXXXX>,
        templateID: String,
    ) {
        val dialogView = requireActivity().layoutInflater.inflate(R.layout.show_domain, null)
        showeDomainListBootomSheat = BottomSheetDialog(mContext)


        if (arrayDomain != null && arrayDomain.isNotEmpty()) {
            recyclerViewDomain = dialogView.findViewById(R.id.recyclerViewDomainList)
            recyclerViewDomain!!.hasFixedSize()
            recyclerViewDomain!!.layoutManager = LinearLayoutManager(mContext)


            viewAdapterDomain = DomainListAdaptot(this@MySiteFragment, arrayDomain, templateID)
            recyclerViewDomain!!.adapter = viewAdapterDomain
        } else CommonUtil.toast("Book your Domain First", mContext)

        showeDomainListBootomSheat.setContentView(dialogView)
        showeDomainListBootomSheat.setCanceledOnTouchOutside(false)

        showeDomainListBootomSheat.show()
    }

    override fun onClickPublish(templateID: String, name: String) {

        //  CommonUtil.toast("publish click", mContext)
        if (templateID != null) getDomainList(templateID)


    }

    override fun nowPublishWebSite(templateID: String, domainId: String) {

        if (CommonUtil.checkNetwork(mContext)) {


            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)

            Log.i("publish templateID = ", templateID)
            Log.i("publish domainId  = ", domainId)


            val dataNotic = GbusinessService.create(mContext)
            if (userID != null) {
                dataNotic.getPublishWebSite(
                    "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),
                    templateID, domainId
                ).enqueue(object : Callback<PublishORUnPublishWebSiteDataClass> {
                    override fun onFailure(
                        call: Call<PublishORUnPublishWebSiteDataClass>,
                        t: Throwable,
                    ) {
                        CommonUtil.hideDialog(mContext)
                        CommonUtil.toast(R.string.showError.toString(), mContext)
                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(
                        call: Call<PublishORUnPublishWebSiteDataClass>,
                        response: Response<PublishORUnPublishWebSiteDataClass>,
                    ) {
                        CommonUtil.hideDialog(mContext)

                        val getData = response.body()
                        CommonUtil.logi(getData.toString())


                        if (getData != null) {
                            if (getData.success) {

                                //todo to refresh the mySite fragment
                                getMySiteApi()
                                showeDomainListBootomSheat.dismiss()
                                Log.i("publish", getData.data)
                            }
                            if (getData.data != null) CommonUtil.toast(getData.data, mContext)
                            // else CommonUtil.toast("Fail",mContext)

                        } else CommonUtil.toast(R.string.showError.toString(), mContext)

                    }

                })
            }

        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }

    override fun editSites(webUrl: String) {

        if (webUrl != null) {
            val bundle = Bundle()
            bundle.putString("back", "MySiteFragment")
            bundle.putString("webUrl", webUrl)
            findNavController().navigate(R.id.action_mySiteFragment_to_paymentOrInvoiceWebView, bundle)
        } else {
            CommonUtil.toast("No View Found", mContext)
        }
    }


    override fun nowUnPublishWebSite(projectId: String) {

        if (projectId != null) {
            //  Log.i("unpublish proid", projectId)
            callUnPublish(projectId)
        }
    }

    private fun callUnPublish(projectId: String) {

        if (CommonUtil.checkNetwork(mContext)) {

            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)

            // Log.i("unpublish", projectId)

            val dataNotic = GbusinessService.create(mContext)
            if (userID != null) {
                dataNotic.getUnPublishWebSite(
                    "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),
                    projectId
                )

                    .enqueue(object : Callback<PublishORUnPublishWebSiteDataClass> {
                        override fun onFailure(
                            call: Call<PublishORUnPublishWebSiteDataClass>,
                            t: Throwable,
                        ) {
                            CommonUtil.hideDialog(mContext)
                            CommonUtil.toast(R.string.showError.toString(), mContext)
                            CommonUtil.logi(t.localizedMessage.toString())
                        }

                        override fun onResponse(
                            call: Call<PublishORUnPublishWebSiteDataClass>,
                            response: Response<PublishORUnPublishWebSiteDataClass>,
                        ) {
                            CommonUtil.hideDialog(mContext)

                            // Log.i("unpublish", response.body().toString())
                            val getData = response.body()
                            CommonUtil.logi(getData.toString())

                            if (getData != null) {
                                if (getData.success) {
                                    //todo to refresh the mySite fragment
                                    getMySiteApi()

                                    //  Log.i("unpublish", getData.data)
                                }
                                if (getData.data != null) CommonUtil.toast(getData.data, mContext)

                            } else CommonUtil.toast(R.string.showError.toString(), mContext)

                        }
                    })
            }

        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }

    private fun siteMoveToTrash(tempID: String, dialog: DialogInterface) {

        if (CommonUtil.checkNetwork(mContext)) {

            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)

            //  Log.i("siteMoveToTrash", tempID)

            val dataNotic = GbusinessService.create(mContext)
            if (userID != null) {
                dataNotic.moveToTrash(
                    "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),
                    tempID
                )

                    .enqueue(object : Callback<UpdatePhone> {
                        override fun onFailure(
                            call: Call<UpdatePhone>,
                            t: Throwable,
                        ) {
                            CommonUtil.hideDialog(mContext)
                            CommonUtil.toast(R.string.showError.toString(), mContext)
                            dialog.dismiss()

                            CommonUtil.logi(t.localizedMessage.toString())
                        }

                        override fun onResponse(
                            call: Call<UpdatePhone>,
                            response: Response<UpdatePhone>,
                        ) {
                            CommonUtil.hideDialog(mContext)
                            dialog.dismiss()
                            //  Log.i("siteMoveToTrash", response.body().toString())
                            val getData = response.body()
                            CommonUtil.logi(getData.toString())

                            if (getData != null) {
                                if (getData.success) {

                                    //todo to refresh the mySite fragment
                                    getMySiteApi()

                                    //  Log.i("siteMoveToTrash", getData.data)
                                }
                                if (getData.data != null) CommonUtil.toast(getData.data, mContext)

                            } else CommonUtil.toast(R.string.showError.toString(), mContext)

                        }
                    })
            }

        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }


}


