package com.milkyway.gbusiness.ui.main

import android.Manifest
import android.annotation.SuppressLint
import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.beautycoder.pflockscreen.fragments.PFLockScreenFragment
import com.commit451.modalbottomsheetdialogfragment.ModalBottomSheetDialogFragment
import com.commit451.modalbottomsheetdialogfragment.Option
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.activities.LoginActivity
import com.milkyway.gbusiness.activities.Main2Activity
import com.milkyway.gbusiness.adaptor.DashboardItemAdaptor
import com.milkyway.gbusiness.api.CallPemission
import com.milkyway.gbusiness.api.DialogClick
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.DashboardData
import com.milkyway.gbusiness.models.EarningDataClass
import com.milkyway.gbusiness.models.LogoutDataClass
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.global.CommonUtil
import kotlinx.android.synthetic.main.dlg_logout.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainFragment : Fragment(), View.OnClickListener, DialogClick, CallPemission, DashboardItemAdaptor.OnDashboardAdaptorClick, ModalBottomSheetDialogFragment.Listener {

    private lateinit var viewModel: MainViewModel
    private lateinit var infoImage: ImageView
    private lateinit var mainFragOverFlowIcon: ImageView
    private lateinit var userNamemainUi: TextView
    private lateinit var rfCode: String
    private lateinit var rvDashboard: RecyclerView
    private val dashCategoryList = ArrayList<DashboardData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_main, container, false)
        if (CommonUtil.getPreferencesString(mContext, AppConstants.FirstTimeSignUp).equals("")) {
            getFirstDialogBox()
        }
        Log.i("shoerate", CommonUtil.getPreferencesString(mContext, AppConstants.SHOW_RATE).toString())
        CommonUtil.saveStringPreferences(mContext, AppConstants.AUTO_REFCODE, "flase")
        forRatingOfApp()
        initializeView(view)

        rfCode = CommonUtil.getPreferencesString(mContext, AppConstants.ReferalCode)!!

        Log.i("rfCode", "rfCode==  " + rfCode)
        if (rfCode.equals("ReferalCode") || rfCode.equals("") || rfCode.equals("google-play&utm_medium") || rfCode == null) getRefCode()

        getRuntimePermission()

        return view
    }

    override fun onClickPermission() {
        checkAndRequestPermissions()
    }


    override fun onDialogClick() {
        // Toast.makeText(mContext,"Ok, main Comming soon.",Toast.LENGTH_SHORT).show()

        //logout()
        alertLogOutDialog()
    }


    lateinit var mContext: Context


    override fun onClick(v: View?) {
        when (v?.id) {

            R.id.infoImage -> getFirstDialogBox()
            R.id.mainFragOverFlowIcon -> openActionBottomSheet()//openPopUp(mainFragOverFlowIcon)//(requireActivity() as MainActivity).openCloseNavigationDrawer()//openPopUp(mainFragOverFlowIcon)//openBottomSheet()

        }
    }

    private fun openActionBottomSheet() {
        ModalBottomSheetDialogFragment.Builder()
            .add(R.menu.drawer_menu)
            .show(childFragmentManager, "options")
    }

    private fun openShareDialog() {
        launchMarketTesting()
    }

    private fun launchMarketTesting() {
        var shareMessage: String = "\nLet me recommend you Gbusiness application $rfCode   \n\n"
        shareMessage += getInvitationMessage()
        val bm = BitmapFactory.decodeResource(mContext.resources, R.drawable.share)
        val intent = Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, shareMessage);
        val path = MediaStore.Images.Media.insertImage(mContext.getContentResolver(), bm, "", null);
        val screenshotUri = Uri.parse(path);

        intent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
        intent.type = "image/*";
        startActivity(Intent.createChooser(intent, "Share"))
    }

    private fun imageAndText() {
        val sendIntent = Intent()
        var shareMessage: String = "\nLet me recommend you Gbusiness application with my ref. code $rfCode   \n\n"
        shareMessage += getInvitationMessage()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Share");
        sendIntent.type = "text/plain";
        mContext.startActivity(Intent.createChooser(sendIntent, "Share"));
    }


    private fun getInvitationMessage(): String {
        val playStoreLink = "https://play.google.com/store/apps/details?id=com.milkyway.gbusiness&referrer=utm_source=";
        return playStoreLink + CommonUtil.getPreferencesString(mContext, AppConstants.ReferalCode)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }


    private fun forRatingOfApp() {
        val alertValue = CommonUtil.getPreferencesString(mContext, AppConstants.SHOW_RATE)!!
        if (alertValue != "") {
            val updateVal = Integer.parseInt(alertValue)
            val totl = (updateVal + 1)
            CommonUtil.saveStringPreferences(mContext, AppConstants.SHOW_RATE, totl.toString())

            Log.i("lokll", totl.toString())


            if (alertValue.equals("8")) {
                Log.i("lokll = ", CommonUtil.getPreferencesString(mContext, AppConstants.IS_SHOW_RATE).toString())
                Log.i("lokll == ", CommonUtil.getPreferencesString(mContext, AppConstants.SHOW_RATE).toString())
                CommonUtil.saveStringPreferences(mContext, AppConstants.SHOW_RATE, "1")
                if (CommonUtil.getPreferencesString(mContext, AppConstants.IS_SHOW_RATE).equals("1")) rateUs()
            }

        } else {
            CommonUtil.saveStringPreferences(mContext, AppConstants.IS_SHOW_RATE, "1")
            CommonUtil.saveStringPreferences(mContext, AppConstants.SHOW_RATE, "1")
        }

    }

    private fun getRuntimePermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            checkAndRequestPermissions()
        }

    }

    private fun checkAndRequestPermissions(): Boolean {
        val cameraPermission = ContextCompat.checkSelfPermission(mContext, Manifest.permission.CAMERA)
        val writePermission = ContextCompat.checkSelfPermission(mContext, Manifest.permission.WRITE_EXTERNAL_STORAGE)


        val listPermissionsNeeded = ArrayList<String>()
        if (cameraPermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.CAMERA)
        }
        if (writePermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }

        if (listPermissionsNeeded.isNotEmpty()) {
            ActivityCompat.requestPermissions(requireActivity(), listPermissionsNeeded.toTypedArray(), REQUEST_ID_MULTIPLE_PERMISSIONS)
            return false
        }
        return true
    }

    @SuppressLint("SetTextI18n")
    private fun initializeView(view: View) {
        infoImage = view.findViewById(com.milkyway.gbusiness.R.id.infoImage)
        mainFragOverFlowIcon = view.findViewById(com.milkyway.gbusiness.R.id.mainFragOverFlowIcon)
        userNamemainUi = view.findViewById(com.milkyway.gbusiness.R.id.userNamemainUi)
        rvDashboard = view.findViewById(R.id.rvDashboard)
        var userName = CommonUtil.getPreferencesString(mContext, AppConstants.FULL_NAME)
        if (userName != null)
            userNamemainUi.text = "Welcome, $userName"

        setDashCategoryAdaptor(view)

        infoImage.setOnClickListener(this)
        mainFragOverFlowIcon.setOnClickListener(this)

    }

    private fun setDashCategoryAdaptor(view: View) {
        rvDashboard.layoutManager = GridLayoutManager(context, 2)
        dashCategoryList.add(DashboardData("My Site", R.drawable.imageone))
        dashCategoryList.add(DashboardData("Book Sub-Domain", R.drawable.imagetwo))
        //dashCategoryList.add(DashboardData("Share & Earn", R.drawable.imagethree))
        dashCategoryList.add(DashboardData("Services", R.drawable.imagefour))
        dashCategoryList.add(DashboardData("Business Listing", R.drawable.ic_business_list))
        dashCategoryList.add(DashboardData("My Business Page", R.drawable.imageone))
        dashCategoryList.add(DashboardData("Book Domain", R.drawable.imagetwo))
        // This will pass the ArrayList to our Adapter
        val adapter = DashboardItemAdaptor(requireActivity(), this, dashCategoryList)

        // Setting the Adapter with the recyclerview
        rvDashboard.adapter = adapter

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    companion object {
        var REQUEST_ID_MULTIPLE_PERMISSIONS = 1
    }

    private fun setPin() {
        val pf_lock = PFLockScreenFragment()
        //  pf_lock.deleteEncodeKey()
        val m = pf_lock.javaClass.getDeclaredMethod("deleteEncodeKey")//.getDeclaredMethod("deleteEncodeKey");
        m.isAccessible = true
        m.invoke(pf_lock)

        startActivity(Intent(mContext, Main2Activity::class.java))

        /* val changePas= PFPinCodeViewModel()
         changePas.encodePin(mContext,"1111").observe(pf_lock,Observer<PFResult<String>>(){

             Log.i("lock","pawan =  ${it.result.toString()}")
             Log.i("lock","pawan er =  ${it.error.toString()}")
             if ( it.error!=null)
            {
                val m = pf_lock.javaClass.getDeclaredMethod("deleteEncodeKey")//.getDeclaredMethod("deleteEncodeKey");
                m.setAccessible(true)
                m.invoke(pf_lock)
            }
             val encodedCode = it.result
             CommonUtil.saveStringPreferences(mContext, AppConstants.PIN_PASS,encodedCode)
             Log.i("lock","pawan =  $encodedCode")
         })
 */

    }

    private fun getFirstDialogBox() {
        val box = AlertDialog.Builder(mContext).create();

        box.setCancelable(false)

        val layoutInflater = LayoutInflater.from(mContext).inflate(R.layout.first_box, null)
        box.setView(layoutInflater)
        val imgCancel = layoutInflater.findViewById<ImageView>(R.id.boxCancel)
        val openDialog = layoutInflater.findViewById<Button>(R.id.investButton)

        imgCancel.setOnClickListener {
            box.dismiss()
            CommonUtil.saveStringPreferences(mContext, AppConstants.FirstTimeSignUp, "false")
        }
        openDialog.setOnClickListener {
            box.dismiss()
            findNavController().navigate(R.id.searchSubDomainFragment)
            CommonUtil.saveStringPreferences(mContext, AppConstants.FirstTimeSignUp, "false")
        }
        box.show()
    }

    private fun feedback() {
        CommonUtil.toast("Comming soon", mContext)
    }

    private fun rateUs() {
        try {
            val alertDialog = AlertDialog.Builder(mContext, R.style.AlertDialogTheme)
            alertDialog.setTitle("Rate GBusiness Application")
            alertDialog.setMessage("If you are enjoy using this app, please take a moment to rate it. thanks for your support!")

            alertDialog.setCancelable(false)
                .setPositiveButton("Rate Now", ({ dialogInterface: DialogInterface, i: Int ->

                    CommonUtil.saveStringPreferences(mContext, AppConstants.SHOW_RATE, "1")

                    val uri = Uri.parse("market://details?id=" + context?.getPackageName());
                    val goToMarket = Intent(Intent.ACTION_VIEW, uri);
                    // To count with Play market backstack, After pressing back button,
                    // to taken back to our application, we need to add following flags to intent.
                    goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
                    goToMarket.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT)
                    goToMarket.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
                    try {
                        startActivity(goToMarket);
                    } catch (e: ActivityNotFoundException) {
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("http://play.google.com/store/apps/details?id=" + context?.getPackageName())
                            )
                        );
                    }

                }))

                /*.setNegativeButton("Later", ({ dialogInterface: DialogInterface, i: Int ->


                }))*/
                .setNeutralButton("No Thank", ({ dialogInterface: DialogInterface, i: Int ->

                    CommonUtil.saveStringPreferences(mContext, AppConstants.IS_SHOW_RATE, "0")
                }))
                .show()
            //.getButton(AlertDialog.BUTTON_POSITIVE).setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.white))
            /*.getButton(AlertDialog.BUTTON_NEGATIVE).setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.white))
            .getButton(AlertDialog.BUTTON_NEUTRAL).setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.white))*/

        } catch (e: Exception) {
            Log.i("error", "in rate us")
        }
    }


    //for logout
    fun logout() {

        if (CommonUtil.checkNetwork(mContext)) {
            CommonUtil.showDialog(mContext)

            val userToken = CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN)!!
            val logWith = CommonUtil.getPreferencesString(mContext, AppConstants.LOGINWITH)!!

            if (logWith.equals("withEmail")) {
                val login = LoginActivity()
                login.onDialogClick()
            }

            val dataNotic = GbusinessService.create(mContext)
            dataNotic.getLogout(userToken, "application/json")
                .enqueue(object : Callback<LogoutDataClass> {
                    override fun onFailure(call: Call<LogoutDataClass>, t: Throwable) {
                        CommonUtil.hideDialog(mContext)
                        CommonUtil.toast(R.string.showError.toString(), mContext)
                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(call: Call<LogoutDataClass>, response: Response<LogoutDataClass>) {
                        CommonUtil.hideDialog(mContext)
                        //  Log.i("TAGad", response.body()?.success.toString())
                        val getdata = response.body()
                        CommonUtil.logi(getdata.toString())
                        if (getdata != null) {

                            if (getdata.success) {
                                CommonUtil.saveStringPreferences(mContext, AppConstants.TOKEN, "")
                                CommonUtil.saveStringPreferences(mContext, AppConstants.LOGINUSER, "")
                                CommonUtil.saveStringPreferences(mContext, AppConstants.LOGINPASSWORD, "")
                                CommonUtil.saveStringPreferences(mContext, AppConstants.USER_ID, "")
                                CommonUtil.saveStringPreferences(mContext, AppConstants.FULL_NAME, "")
                                CommonUtil.saveStringPreferences(mContext, AppConstants.FirstTimeSignUp, "")

                                startActivity(Intent(mContext, LoginActivity::class.java))
                                activity!!.finish()

                            } else
                                CommonUtil.toast("Something went wrong", mContext)

                        } else CommonUtil.toast("Something went wrong", mContext)
                    }

                })

        } else {
            CommonUtil.toast("Check Internet", mContext)
            CommonUtil.hideDialog(requireActivity())
        }
    }

    private fun alertLogOutDialog() {
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
            val m_inflater = LayoutInflater.from(activity)
            val m_view = m_inflater.inflate(R.layout.dlg_logout, null, false)

            val finalDialog: Dialog = dialog
            m_view.tvLogout.setOnClickListener {
                finalDialog.dismiss()
                logout()
                //Common.setLogout(this@DashboardActivity)

            }
            m_view.tvCancel.setOnClickListener {
                finalDialog.dismiss()
            }
            dialog.setContentView(m_view)
            dialog.show()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }


    private fun getRefCode() {
        Log.i("TAGadxx===", "start api")

        if (CommonUtil.checkNetwork(mContext)) {
            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)
            val dataNotic = GbusinessService.create(mContext)
            if (userID != null) {
                dataNotic.getEarning(
                    "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), "application/json",
                    userID
                )
                    .enqueue(object : Callback<EarningDataClass> {
                        override fun onFailure(call: Call<EarningDataClass>, t: Throwable) {
                            CommonUtil.hideDialog(mContext)
                            // CommonUtil.toast(t.localizedMessage, mContext)
                            CommonUtil.toast(R.string.showError.toString(), mContext)
                            Log.i("TAGadxx===", t.localizedMessage)

                        }

                        override fun onResponse(call: Call<EarningDataClass>, response: Response<EarningDataClass>) {
                            CommonUtil.hideDialog(mContext)
                            Log.i("TAGadxx===", response.body().toString())
                            val getdata = response.body()
                            CommonUtil.logi(getdata.toString())
                            // CommonUtil.toast(getdata!!.,mContext)


                            if (getdata != null) {
                                if (getdata.success) {

                                    if (getdata.data.userRefferal != null) {
                                        CommonUtil.saveStringPreferences(
                                            mContext,
                                            AppConstants.ReferalCode,
                                            getdata.data.userRefferal.toString()
                                        )
                                    }
                                }

                            }
                            //else CommonUtil.toast(R.string.showError.toString(),mContext)

                        }
                    })
            }

        } else {
            // CommonUtil.toast("Check Internet", mContext)
        }


    }

    override fun OnItemClicked(position: Int) {
        when (position) {
            0 -> findNavController().navigate(R.id.mySiteFragment)
            1 -> findNavController().navigate(R.id.searchSubDomainFragment)
            //2 -> openShareDialog()
            2 -> findNavController().navigate(R.id.servicesFragment)
            3 -> findNavController().navigate(R.id.myBusinessListingFragment) //Toast.makeText(requireActivity(), "Clicked on category", Toast.LENGTH_SHORT).show()
            4 -> findNavController().navigate(R.id.myBusinessListFragment)
            5 -> findNavController().navigate(R.id.searchDomainFragment)
        }
    }

    override fun onModalOptionSelected(tag: String?, option: Option) {
        when (option.id) {
            R.id.nav_order -> findNavController().navigate(R.id.action_mainFragment_to_myOrderFragment)
            //R.id.nav_my_cart -> findNavController().navigate(R.id.myCartFrament)
            //R.id.action_notification -> findNavController().navigate(R.id.action_mainFragment_to_notificationOnGbusniess)
            //R.id.withdrowl -> findNavController().navigate(R.id.action_mainFragment_to_withDarawlFagment)
            //R.id.withdrowlHistory -> findNavController().navigate(R.id.action_mainFragment_to_withDrawalHistory)
            R.id.nav_payment_invoice -> findNavController().navigate(R.id.action_mainFragment_to_paymentORInvoice2)
            R.id.nav_security_setting -> findNavController().navigate(R.id.action_mainFragment_to_securityQuestionFragment)
            //   R.id.onAndOffLock->setPinPassword()
               /*R.id.setPinLock -> {
                   if (!isPinActive.equals("true"))
                   {
                       CommonUtil.saveStringPreferences(mContext,AppConstants.IS_PIN_PASS,"true")
                       setPin()
                   } else
                   {
                       CommonUtil.saveStringPreferences(mContext,AppConstants.IS_PIN_PASS,"false")
                       CommonUtil.toast("Lock DeActivated",mContext)
                   }
                 //  setPin()
                   }*/
            R.id.nav_support -> findNavController().navigate(R.id.action_mainFragment_to_supportFragment)
            R.id.nav_rate_us -> rateUs()
            //  R.id.feedback -> feedback()
            R.id.nav_logout -> alertLogOutDialog() //logout()
        }
    }
}









