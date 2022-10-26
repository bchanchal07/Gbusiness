package com.milkyway.gbusiness.fragments


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.adaptor.MyCartFramentAdaptor
import com.milkyway.gbusiness.activities.MainActivity

import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.utils.CommonUtil
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.api.OnAdpterClick
import com.milkyway.gbusiness.models.CartDataClass
import com.milkyway.gbusiness.models.CartDeleteDataClass
import com.milkyway.gbusiness.models.DataXXXXXX
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response




class MyCartFragment : Fragment(), OnAdpterClick {



    lateinit var viewAdapter : MyCartFramentAdaptor
    var recyclerView : RecyclerView? = null
    private lateinit var myMyCartBack : ImageView

    var array : ArrayList<DataXXXXXX>? = null
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var mContext : Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my_cart_frament, container, false)

        viewManager = LinearLayoutManager(mContext)
        recyclerView = view.findViewById<RecyclerView>(R.id.cartRecyclerView  )
        recyclerView?.hasFixedSize()
        recyclerView!!.layoutManager = LinearLayoutManager(mContext)


        myMyCartBack = view.findViewById<ImageView>(R.id.myMyCartBack)
        myMyCartBack.setOnClickListener	 { MainActivity.navController.navigate(R.id.action_myCartFragment_to_mainFragment) }

        getCartApi()
        return view
    }
    private fun getCartApi()
    {

        if (CommonUtil.checkNetwork(mContext))
        {
            var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
            CommonUtil.showDialog(mContext)
            val dataNotic = GbusinessService.create(mContext)
            if (userID != null) {
                dataNotic.getCartDetails("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),userID
                ).enqueue(object : Callback<CartDataClass>{
                    override fun onFailure(call: Call<CartDataClass>, t: Throwable) {
                        CommonUtil.hideDialog(mContext)
                        CommonUtil.toast(R.string.showError.toString(),mContext)
                        CommonUtil.logi(t.localizedMessage.toString())
                    }

                    override fun onResponse(call: Call<CartDataClass>, response: Response<CartDataClass>) {

                        CommonUtil.hideDialog(mContext)
                        Log.i("TAGad", response.body()?.success.toString())
                        val getdata = response.body()
                        CommonUtil.logi(getdata.toString())

                        if (getdata != null)
                        {
                            if (getdata.success)
                            {
                                if (getdata.data!=null && getdata.data.size>0)
                                {
                                    array?.clear()
                                     array= getdata.data

                                    viewAdapter = MyCartFramentAdaptor(this@MyCartFragment,array!!)
                                    recyclerView?.adapter=viewAdapter

                                }
                            }
                            if(getdata.message!=null)  CommonUtil.toast(getdata.message,mContext)
                        } else CommonUtil.toast(R.string.showError.toString(),mContext)
                    }

                })
            }

        }
        else
        {
            CommonUtil.toast("Check Internet",mContext)
        }
    }

    override fun OnClick(cartId : String) {
       // CommonUtil.toast("ok", mContext)

        Log.i("TAGad", cartId)
        if (CommonUtil.checkNetwork(mContext)) {
            CommonUtil.showDialog(mContext)
            val dataNotic = GbusinessService.create(mContext)

                dataNotic.getCartDelete(
                    "Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN), cartId
                ).enqueue(object : Callback<CartDeleteDataClass> {
                    override fun onFailure(call: Call<CartDeleteDataClass>, t: Throwable) {
                        CommonUtil.hideDialog(mContext)
                        CommonUtil.toast(R.string.showError.toString(), mContext)
                        CommonUtil.logi(t.localizedMessage.toString())

                    }

                    override fun onResponse(call: Call<CartDeleteDataClass>, response: Response<CartDeleteDataClass>) {

                        CommonUtil.hideDialog(mContext)
                        val getdata = response?.body()
                        Log.i("TAGad", getdata.toString())
                        if (getdata != null) {
                            if (getdata.success)
                            {


                                MainActivity.navController.navigate(R.id.myCartFragment)


                            }
                            if(getdata.message!=null)  CommonUtil.toast(getdata.message,mContext)
                        } else CommonUtil.toast(" try after some time ", mContext)
                    }

                })
        }

    }
    override fun onClickBtn(cart_id : String,price : String,domainName : String,services : String,currency : String)
    {
      //  CommonUtil.toast("ok",mContext)
        buyNow(cart_id ,price,domainName,services,currency)


    }


   /* override fun onDestroy() {
        super.onDestroy()
        MyApplication.instance.mustDie(this)
        Log.i("distroy","MyCartFragment")
    }*/
   private fun buyNow(cart_id : String,price : String,domainName : String,services : String,currency : String)
   {
       if (CommonUtil.checkNetwork(mContext))
       {

           var userID = CommonUtil.getPreferencesString(mContext, AppConstants.USER_ID)
           var userProfessionID = CommonUtil.getPreferencesString(mContext, AppConstants.PROFESSION)
           CommonUtil.showDialog(mContext)


           val dataNotic = GbusinessService.create(mContext)
           if (userID != null && price != null && domainName != null && services != null && currency != null && cart_id != null)
           {
               dataNotic.getBilling("Bearer " + CommonUtil.getPreferencesString(mContext, AppConstants.TOKEN),
                   "application/json",
                   userID,
                   domainName!!,
                   price!!,
                   services!!,
                   currency!!,
                   cart_id!!,
                   userProfessionID!!
               )
                   .enqueue(object : Callback<BillingDataClass> {
                       override fun onFailure(call: Call<BillingDataClass>, t: Throwable) {

                           CommonUtil.hideDialog(mContext)
                           CommonUtil.toast(t.localizedMessage, mContext)
                           CommonUtil.logi(t.localizedMessage.toString())
                       }

                       override fun onResponse(
                           call: Call<BillingDataClass>,
                           response: Response<BillingDataClass>
                       ) {
                           CommonUtil.hideDialog(mContext)
                           /* Log.i("dfdfgf userID",userID)
                            Log.i("dfdfgf userID",domainName)
                            Log.i("dfdfgf price",price)
                            Log.i("dfdfgf services",services)
                            Log.i("dfdfgf currency",currency)
                            Log.i("dfdfgf cart_id",cart_id)
                            Log.i("dfdfgf userProfessionID",userProfessionID)
*/

                           Log.i("TAGad", response.body()?.success.toString())
                           val getdata = response.body()
                           CommonUtil.logi(getdata.toString())

                           if (getdata!=null)
                           {
                               if(getdata.success)
                               {
                                   Log.i("dfdfgf",getdata.walletAmount.balance.toString())
                                   if(getdata.walletAmount.balance!=null)
                                   {
                                       CommonUtil.saveStringPreferences(mContext, AppConstants.Wbalance,getdata.walletAmount.balance.toString())
                                       PaymentFragment.invoic_id = getdata.invoice_id.toString()
                                       PaymentFragment.serviceName = getdata.invoice_slip.domain_name.toString()
                                       PaymentFragment.Description = getdata.invoice_slip.description.toString()
                                       PaymentFragment.minPrice = getdata.invoice_slip.price.toString()
                                       PaymentFragment.totalPrice = getdata.invoice_slip.total.toString()
                                       PaymentFragment.service = "domain"


                                       CommonUtil.saveStringPreferences(mContext, AppConstants.price,getdata.payAmount)
                                       findNavController().navigate(R.id.action_myCartFragment_to_paymentFragment)
                                     //  findNavController().navigate(R.id.action_domainPriceDetail_to_paymentFragment)
                                   }
                               } else CommonUtil.toast(getdata.message,mContext)

                               // CommonUtil.toast(getdata.walletAmount.balance.toString(),mContext)

                               /*if(getdata.walletAmount.balance!=null)
                               {
                                   CommonUtil.saveStringPreferences(mContext,AppConstants.Wbalance,getdata.walletAmount.balance.toString())

                                   findNavController().navigate(R.id.action_domainPriceDetail_to_paymentFragment)
                               }*/

                           }
                           else
                           {
                               CommonUtil.toast("SomeThing Went Wrong",mContext)
                           }
                       }

                   })
           }
           // startActivity(Intent(this,OtpActivity::class.java))
       } else {
           CommonUtil.toast("Check Internet", mContext)
       }

   }
}
