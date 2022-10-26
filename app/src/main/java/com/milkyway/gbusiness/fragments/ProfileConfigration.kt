package com.milkyway.gbusiness.fragments


import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.adaptor.ProfileConfigrationAdaptor

import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.utils.CommonUtil
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.api.ProfileConfigrationListener
import com.milkyway.gbusiness.models.DomainX
import com.milkyway.gbusiness.models.SSLactivateDataclass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProfileConfigration : Fragment(), ProfileConfigrationListener
{
     lateinit var arrayListCurnt: ArrayList<DomainX>
    lateinit var recyclerView: RecyclerView
    lateinit var mContext : Context
    lateinit var mAdapter : ProfileConfigrationAdaptor


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view= inflater.inflate(R.layout.fragment_profile_configration, container, false)


        view.findViewById<ImageView>(R.id.myProfileConfirationBack).setOnClickListener { view.findNavController().navigate(R.id.action_profileConfigration_to_profileFragment) }
       view.findViewById<ImageView>(R.id.infoWebMail).setOnClickListener {openDialogBx()
           /*CommonUtil.toast("soon",mContext) */}
       view.findViewById<Button>(R.id.loginToWebMail).setOnClickListener {
           val bundel = Bundle()
           bundel.putString("webUrl","https://gbusiness.co:2096/")
           bundel.putString("back", "ProfileConfigration")
           view.findNavController().navigate(R.id.action_profileConfigration_to_paymentOrInvoiceWebView,bundel)
       }

        arrayListCurnt = ArrayList()
              //Log.i("array size",arrayListCurnt.size.toString())

        val typeofaAction = arguments?.getString("type")
         arrayListCurnt = arguments?.getSerializable("myname") as ArrayList<DomainX>

        if (typeofaAction=="ssl") view.findViewById<TextView>(R.id.profileConfigTittle).setText("Activate SSL")
        else if (typeofaAction=="web") view.findViewById<TextView>(R.id.profileConfigTittle).setText("Create Business Webmail")
        else view.findViewById<TextView>(R.id.profileConfigTittle).setText("Configration")

      //  Log.i("array size",arrayListCurnt.size.toString())

        if (arrayListCurnt.size>0)
        {
            recyclerView = view.findViewById(R.id.profileConfigRecycler)
            recyclerView.hasFixedSize()
            recyclerView.layoutManager = LinearLayoutManager(mContext)

            mAdapter= ProfileConfigrationAdaptor(arrayListCurnt,typeofaAction!!,mContext,this@ProfileConfigration)
            recyclerView.adapter =mAdapter
        }else
        {
            CommonUtil.toast(R.string.showError.toString(),mContext)
        }



        return view
    }


    fun shortDomainName(domainNAme : String) :String
    {
        val dff = domainNAme.split("//")

        val domain = dff[1]
        val domaintwo = domain.split(".")
        return domaintwo[0]
    }
    fun shortDomainName2(domainNAme : String) :String
    {
        val dff = domainNAme.split("//")

        val domain = dff[1]
        return domain
    }
    override
    fun getSslListener(domainNAme : String)
    {

        activsteSSl(shortDomainName(domainNAme))
      //  Log.i("dfdfd",shortDomainName(domainNAme))
       // CommonUtil.toast("ssl= "+shortDomainName(domainNAme),mContext)

    }
    override
    fun creatWebmailListener(domainName : String,emailAddress : String)
    {
     //   Log.i("dfdfd = domain",shortDomainName2(domainName))
    //    Log.i("dfdfd e =",emailAddress)
      //  creatWebMail(shortDomainName2(domainName),emailAddress)
        CommonUtil.toast("web",mContext)

        creatWebMail(shortDomainName2(domainName),emailAddress)
    }


    private fun activsteSSl(domainNAme : String)
    {

        if (CommonUtil.checkNetwork(mContext))
        {
            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)
            val dataNotic = GbusinessService.create(mContext)
            if (userID != null) {
                dataNotic.getActivateSSL("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),domainNAme ,"1"
                ).enqueue(object : Callback<SSLactivateDataclass> {
                    override fun onFailure(call: Call<SSLactivateDataclass>, t: Throwable)
                    {
                        CommonUtil.hideDialog(mContext)
                        CommonUtil.toast(R.string.showError.toString(),mContext)
                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(
                        call: Call<SSLactivateDataclass>,
                        response: Response<SSLactivateDataclass>
                    )
                    {
                        CommonUtil.hideDialog(mContext)
                        val getdata = response?.body()
                         CommonUtil.logi(getdata.toString())
                        //Log.i("ssl", getdata.toString())


                        if (getdata != null)
                        {
                            if (getdata.success)
                            {

                                findNavController().navigate(R.id.action_profileConfigration_to_profileFragment)
                            }
                           if (!getdata.message.isNullOrEmpty()) CommonUtil.toast(getdata.message,mContext)


                        }  else CommonUtil.toast("SomeThing went wrong",mContext)


                    }
                })
            }

        }
        else
        {
            CommonUtil.toast("Check Internet",mContext)
        }

    }

    private fun creatWebMail(domainNAme: String, emailAddress: String)
    {

        if (CommonUtil.checkNetwork(mContext))
        {
            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)
            val dataNotic = GbusinessService.create(mContext)
            if (userID != null) {
                dataNotic.creatWebmail("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),emailAddress,
                    userID,
                    "@"+domainNAme).enqueue(object : Callback<SSLactivateDataclass> {
                    override fun onFailure(call: Call<SSLactivateDataclass>, t: Throwable)
                    {
                        CommonUtil.hideDialog(mContext)
                        CommonUtil.toast(R.string.showError.toString(),mContext)
                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(
                        call: Call<SSLactivateDataclass>,
                        response: Response<SSLactivateDataclass>
                    )
                    {
                        CommonUtil.hideDialog(mContext)
                        val getdata = response?.body()
                         CommonUtil.logi(getdata.toString())
                      // Log.i("web", getdata.toString())


                        if (getdata != null)
                        {
                            if (getdata.success)
                            {

                                findNavController().navigate(R.id.action_profileConfigration_to_profileFragment)
                            }
                            if (!getdata.message.isNullOrEmpty()) CommonUtil.toast(getdata.message,mContext)


                        }  else CommonUtil.toast("SomeThing went wrong",mContext)


                    }
                })
            }

        }
        else
        {
            CommonUtil.toast("Check Internet",mContext)
        }

    }

    private fun openDialogBx()
    {
        val dialog = AlertDialog.Builder(mContext)
        dialog.setTitle("Info")
        dialog.setMessage("Your Id can be created once and can't be modified\n" +
                "\n"+"Your mail id and password will be send on register Email id")
            .setPositiveButton("ok",  DialogInterface.OnClickListener()
            { dialogInterface: DialogInterface, i: Int ->  Log.i("MainActivity", "Sending atomic bombs to Jupiter")

        }).show()

    }
}


