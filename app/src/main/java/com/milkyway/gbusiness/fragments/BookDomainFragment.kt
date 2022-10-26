package com.milkyway.gbusiness.fragments

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.milkyway.gbusiness.activities.MainActivity
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.adaptor.SearchDomainAdapter
import com.milkyway.gbusiness.api.GBusinessSearchDomainPriceService
import com.milkyway.gbusiness.api.GBusinessSearchDomainService
import com.milkyway.gbusiness.models.SearchDomainDataClass
import com.milkyway.gbusiness.models.SearchDomainDataDetailsClass
import com.milkyway.gbusiness.models.SearchDomainErrorDataClass
import com.milkyway.gbusiness.utils.CommonUtil
import com.milkyway.gbusiness.utils.CustomLoader
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.nikartm.support.BadgePosition
import ru.nikartm.support.ImageBadgeView

class BookDomainFragment : Fragment(), SearchDomainAdapter.OnDomainListAdaptorClick {

    lateinit var etSearchDomain: EditText
    lateinit var btnBookDomain: Button
    private lateinit var mySearchDomainBack: ImageView
    lateinit var mContext: Context
    private lateinit var cvDomainError: CardView
    private lateinit var cvDomainSuccess: CardView
    private lateinit var searchDomainNameError: TextView
    private lateinit var searchDomainNameSuccess: TextView
    private lateinit var ibvCart: ImageBadgeView
    private lateinit var etSearchDomainStr: String
    private var requestQueue: RequestQueue? = null
    lateinit var customLoader: CustomLoader
    private lateinit var rvSearchDomainCartItem: RecyclerView
    var filterName: String = ""
    var cartValue: Int = 0
    var cartItemSize: Int = 0
    lateinit var domainStr: String
    val domainList = ArrayList<SearchDomainDataDetailsClass.DomainList>()
    val finalDomainList = ArrayList<SearchDomainDataDetailsClass.DomainList>()

    //var cartItemList = ArrayList<SearchDomainDataDetailsClass.DomainList>()
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_book_domain, container, false)
        initializeViews(view)
        return view
    }

    private fun initializeViews(view: View) {
        requestQueue = Volley.newRequestQueue(requireActivity())
        etSearchDomain = view.findViewById(R.id.etSearchDomain)
        mySearchDomainBack = view.findViewById(R.id.mySearchDomainBack)
        rvSearchDomainCartItem = view.findViewById(R.id.rvSearchDomainCartItem)
        searchDomainNameError = view.findViewById(R.id.searchDomainNameError)
        searchDomainNameSuccess = view.findViewById(R.id.searchDomainNameSuccess)
        cvDomainError = view.findViewById(R.id.cvDomainError)
        cvDomainSuccess = view.findViewById(R.id.cvDomainSuccess)
        ibvCart = view.findViewById(R.id.ibvCart)
        mySearchDomainBack.setOnClickListener {
            MainActivity.navController.navigate(R.id.action_searchDomainFragment_to_mainFragment)
        }
        customLoader = CustomLoader(requireActivity())
        btnBookDomain = view.findViewById(R.id.btnBookDomain)
        btnBookDomain.setOnClickListener {
            if (validate())
                searchDomainApi()
            //searchTldPricingApi()
        }
        //cartItemSize = CommonUtil.getCartItems(mContext)!!.size
        if (!CommonUtil.getCartItems(mContext).isNullOrEmpty()) {
            cartValue = CommonUtil.getCartItems(mContext)!!.size
        }
        initIconWithBadges(this.ibvCart, cartValue)
        ibvCart.setOnClickListener(View.OnClickListener {
            MainActivity.navController.navigate(R.id.action_searchDomainFragment_to_cartItemFragment)
        })
    }

    private fun initIconWithBadges(ibvCart: ImageBadgeView?, cartValue: Int) {
        ibvCart!!.setBadgeValue(cartValue)
            .setBadgeOvalAfterFirst(true)
            .setBadgeTextSize(12F)
            .setMaxBadgeValue(999)

            .setBadgeBackground(ResourcesCompat.getDrawable(resources,
                R.drawable.rectangle_rounded, null))
            .setBadgePosition(BadgePosition.TOP_RIGHT)
            .setBadgeTextStyle(Typeface.NORMAL)
            .setShowCounter(true)
            .setBadgePadding(3)
    }


    private fun searchDomainApi() {
        etSearchDomainStr = etSearchDomain.text.toString().trim()
        domainStr = if (etSearchDomainStr.contains(".")) {
            etSearchDomainStr
        } else {
            "$etSearchDomainStr.com"
        }
        if (CommonUtil.checkNetwork(mContext)) {
            //CommonUtil.showDialog(mContext)
            //CommonUtil.showDomainSearchDialog(mContext)
            //customLoader.showDialog()
            val searchDomainServices = GBusinessSearchDomainService.create()

            searchDomainServices.searchDomain(
                "DomainWhois",
                "IxlAvgNWOBhnFFKCg3gqYj9PGSEmqZoC",
                "pnUBtrdnPp8vcv68oXQX7P66kO0YKsFa",
                domainStr,
                "json"
            ).enqueue(object : Callback<Any> {
                override fun onFailure(call: Call<Any>, t: Throwable) {
                    //CommonUtil.hideDialog(mContext)
                    //CommonUtil.hideDomainSearchDialog()
                    //customLoader.hideDialog()
                    CommonUtil.toast(R.string.showError.toString(), mContext)
                    CommonUtil.logi(t.localizedMessage.toString())
                }

                override fun onResponse(call: Call<Any>, response: Response<Any>) {
                    //CommonUtil.hideDialog(mContext)
                    //CommonUtil.hideDomainSearchDialog()
                    //customLoader.hideDialog()
                    val gson = Gson()
                    /*val errorType = object : TypeToken<SearchDomainErrorDataClass>() {}.type
                    var errorBodyResponse: SearchDomainErrorDataClass? = gson.fromJson(response.errorBody()!!.charStream(), errorType)*/

                    /*val successType = object : TypeToken<SearchDomainDataClass>() {}.type
                    var searchDomainResponse: SearchDomainDataClass? = gson.fromJson(response.errorBody()!!.charStream(), successType)*/


                    //val searchDomainResponse = gson.fromJson(gson.toJson(response.body()), SearchDomainDataClass::class.java)
                    //val errorBodyResponse = gson.fromJson(gson.toJson(response.errorBody()), SearchDomainErrorDataClass::class.java)
                    if (response.code() == 200) {
                        val searchDomainResponse = gson.fromJson(gson.toJson(response.body()), SearchDomainDataClass::class.java)
                        /*val successType = object : TypeToken<SearchDomainDataClass>() {}.type
                        var searchDomainResponse: SearchDomainDataClass? = gson.fromJson(response.errorBody()!!.charStream(), successType)*/
                        if (searchDomainResponse?.result.contentEquals("success")) {
                            if (searchDomainResponse?.status.contentEquals("available")) {
                                cvDomainError.visibility = View.GONE
                                cvDomainSuccess.visibility = View.VISIBLE
                                searchDomainNameSuccess.text = "$domainStr domain is available."
                                //CommonUtil.toast("$domainStr domain is available.", mContext)
                                searchTldPricingApi(etSearchDomainStr, domainStr)
                            } else if (searchDomainResponse?.status.contentEquals("unavailable")) {
                                //CommonUtil.toastError("$domainStr domain is not available.", mContext)
                                cvDomainError.visibility = View.VISIBLE
                                cvDomainSuccess.visibility = View.GONE
                                searchDomainNameError.text = "$domainStr domain is not available."
                                searchTldPricingApi(etSearchDomainStr, domainStr)
                            }
                        } else {
                            /*val errorType = object : TypeToken<SearchDomainErrorDataClass>() {}.type
                            var errorBodyResponse: SearchDomainErrorDataClass? = gson.fromJson(response.errorBody()!!.charStream(), errorType)*/
                            val errorBodyResponse = gson.fromJson(gson.toJson(response.errorBody()), SearchDomainErrorDataClass::class.java)
                            try {
                                if (errorBodyResponse != null) {
                                    if (errorBodyResponse.result.contentEquals("error")) {
                                        CommonUtil.toastError(errorBodyResponse.message, mContext)
                                    }
                                }

                            } catch (e: java.lang.Exception) {
                                e.printStackTrace()
                                CommonUtil.toastError(e.localizedMessage, mContext)
                            }
                        }
                    } else if (response.code() == 403) {
                        val errorType = object : TypeToken<SearchDomainErrorDataClass>() {}.type
                        var errorBodyResponse: SearchDomainErrorDataClass? = gson.fromJson(response.errorBody()!!.charStream(), errorType)
                        try {
                            if (errorBodyResponse != null) {
                                if (errorBodyResponse.result.contentEquals("error")) {
                                    CommonUtil.toastError(errorBodyResponse.message, mContext)
                                }
                            }
                        } catch (e: java.lang.Exception) {
                            e.printStackTrace()
                            CommonUtil.toastError(e.localizedMessage, mContext)
                        }
                    }
                }
            })
        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }

    private fun searchDomainConfirmApi(domainList: ArrayList<SearchDomainDataDetailsClass.DomainList>) {
        /*etSearchDomainStr = etSearchDomain.text.toString().trim()
        domainStr = if (etSearchDomainStr.contains(".")) {
            etSearchDomainStr
        } else {
            "$etSearchDomainStr.com"
        }*/
        var confirmDomainName = ""

        for (i in 0 until domainList.size) {
            confirmDomainName = domainList[i].domainName
            callConfirmDomainApi(confirmDomainName, domainList)
        }

    }

    private fun callConfirmDomainApi(confirmDomainName: String, domainList: ArrayList<SearchDomainDataDetailsClass.DomainList>) {
        finalDomainList.clear()
        if (CommonUtil.checkNetwork(mContext)) {
            //CommonUtil.showDialog(mContext)
            //CommonUtil.showDomainSearchDialog(mContext)
            //customLoader.showDialog()
            val searchDomainServices = GBusinessSearchDomainService.create()

            searchDomainServices.searchDomain(
                "DomainWhois",
                "IxlAvgNWOBhnFFKCg3gqYj9PGSEmqZoC",
                "pnUBtrdnPp8vcv68oXQX7P66kO0YKsFa",
                confirmDomainName,
                "json"
            ).enqueue(object : Callback<Any> {
                override fun onFailure(call: Call<Any>, t: Throwable) {
                    //CommonUtil.hideDialog(mContext)
                    //CommonUtil.hideDomainSearchDialog()
                    //customLoader.hideDialog()
                    CommonUtil.toast(R.string.showError.toString(), mContext)
                    CommonUtil.logi(t.localizedMessage.toString())
                }

                override fun onResponse(call: Call<Any>, response: Response<Any>) {
                    //CommonUtil.hideDialog(mContext)
                    //CommonUtil.hideDomainSearchDialog()
                    //customLoader.hideDialog()
                    if (response.isSuccessful) {

                        val gson = Gson()
                        val searchDomainResponse = gson.fromJson(
                            gson.toJson(response.body()),
                            SearchDomainDataClass::class.java
                        )
                        if (searchDomainResponse.result.contentEquals("success")) {
                            if (searchDomainResponse.status.contentEquals("available")) {
                                //CommonUtil.toast("$confirmDomainName is confirm", mContext)

                                for (i in 1 until domainList.size) {
                                    if (confirmDomainName.contentEquals(domainList[i].domainName)) {
                                        val domainPriceData = SearchDomainDataDetailsClass.DomainList(domainList[i].domainName, domainList[i].domainPrice,domainList[i].subscriptionYr,domainList[i].subscriptionTotalAmount)
                                        finalDomainList.add(domainPriceData)
                                    }
                                }
                                setAdapter(finalDomainList)


                            } else if (searchDomainResponse.status.contentEquals("unavailable")) {
                                //CommonUtil.toastError("$confirmDomainName is not confirm", mContext)
                            }
                        } else {
                            try {
                                val errorBody = gson.fromJson(
                                    gson.toJson(response.body()),
                                    SearchDomainErrorDataClass::class.java
                                )
                                if (errorBody != null) {
                                    if (errorBody.result.contentEquals("error")) {
                                        CommonUtil.toastError(errorBody.message, mContext)
                                    }
                                }

                            } catch (e: java.lang.Exception) {
                                e.printStackTrace()
                                CommonUtil.toastError(e.localizedMessage, mContext)
                            }
                        }
                    } else {
                        CommonUtil.toast("Something went wrong! Please try again....", mContext)
                    }
                }
            })
        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }


    private fun searchTldPricingApi(domainStr: String, searchDomain: String) {
        var finalDomainName: String = ""
        if (domainStr.contains(".")) {
            //finalDomainName = domainStr.replaceFirst(".*/(\\w+).*".toRegex(), "$1")
            val parts: Array<String> = domainStr.split(".").toTypedArray()
            finalDomainName = parts[0]
        } else {
            finalDomainName = domainStr
        }

        /* if (title.contains("_")) {
            val parts: Array<String> = title.split("_").toTypedArray()
            share_id = parts[1]
        }*/
        if (CommonUtil.checkNetwork(mContext)) {
            //CommonUtil.showDialog(mContext)
            // CommonUtil.showDomainSearchDialog(mContext)
            customLoader.showDialog()
            val searchDomainServices = GBusinessSearchDomainPriceService.create()

            searchDomainServices.searchDomainPricing(
                "GetTLDPricing",
                "IxlAvgNWOBhnFFKCg3gqYj9PGSEmqZoC",
                "pnUBtrdnPp8vcv68oXQX7P66kO0YKsFa",
                "1",
                "json"
            ).enqueue(object : Callback<String> {
                override fun onFailure(call: Call<String>, t: Throwable) {
                    //CommonUtil.hideDialog(mContext)
                    //CommonUtil.hideDomainSearchDialog()
                    customLoader.hideDialog()
                    CommonUtil.toast(R.string.showError.toString(), mContext)
                    CommonUtil.logi(t.localizedMessage.toString())
                }

                override fun onResponse(
                    call: Call<String>,
                    response: Response<String>,
                ) {
                    //CommonUtil.hideDialog(mContext)
                    //CommonUtil.hideDomainSearchDialog()
                    customLoader.hideDialog()
                    if (response.isSuccessful) {
                        domainList.clear()
                        val listTldName = ArrayList<String>()
                        val listRegPrice = ArrayList<String>()
                        val responseBody = response.body().toString()
                        var tldName = ""
                        var regPrice = ""
                        var jsonObject = JSONObject(responseBody)
                        var jsonObjPrice = jsonObject.getJSONObject("pricing")

                        val keys = jsonObjPrice.keys()

                        while (keys.hasNext()) {
                            val key = keys.next()
                            //listTldName.add(key)

                            var jsonObjCom = jsonObjPrice.getJSONObject(key) //keys.getJSONObject("register")
                            var jsonReg = jsonObjCom.getJSONObject("register")
                            val keyReg = jsonReg.keys()

                            while (keyReg.hasNext()) {
                                val key1 = keyReg.next()
                                if (key1.equals("1")) {
                                    val value = jsonReg.optString(key1)
                                    regPrice = "$value"  //${resources.getString(R.string.rs)}
                                }
                                listRegPrice.add("$regPrice\n")
                            }

                            tldName = "$finalDomainName.$key"

                            val domainPriceData = SearchDomainDataDetailsClass.DomainList(tldName, regPrice,1,regPrice)

                            domainList.add(domainPriceData)

                            //filterList(domainList, searchDomain) //comment on 17-11-21
                            //setAdapter(domainList)
                            //addDomainData(domainPrice)

                            //val domainDataModel = SearchDomainDataDetailsClass(tldName,regPrice)

                            //CommonUtil.toast("${domainDataModel.domainName}  ${domainDataModel.registerPrice}",mContext)
                            //tldName += "$key: $etSearchDomainStr.$key"
                            //listTldName.add("$tldName  $regPrice\n")
                        }
                        searchDomainConfirmApi(domainList)


                        /*while (keyReg.hasNext()) {
                            val key = keyReg.next()
                            val value = jsonObjRegister.optString(key)
                            regPrice = "$key year price: $value"
                            listRegPrice.add("$regPrice\n")
                        }*/
                        /*var jsonObjectResponse = JSONObject(responseBody)
                        var jsonObjectResult = jsonObjectResponse.getJSONObject("pricing")
                        val keys = jsonObjectResult.keys()
                        while (keys.hasNext()) {
                            val key = keys.next()
                            val value = jsonObjectResult.optString(key)
                            tldName += "Key: $key Value:$value\n"

                        }*/
                        //CommonUtil.toast("$listTldName", mContext)

                        /*var jsonObjectResponse = JSONObject(responseBody)
                        var jsonObjectResult = jsonObjectResponse.getJSONObject("pricing")
                        val keys: Iterator<*> = jsonObjectResult.keys()
                        var errors = ""
                        while (keys.hasNext()) {
                            // loop to get the dynamic key
                            val currentDynamicKey = keys.next() as String

                            // get the value of the dynamic key
                            val currentDynamicValue = jsonObjectResult.getJSONObject(currentDynamicKey)

                            errors += "$currentDynamicKey  :  $currentDynamicValue"
                        }*/

                    } else {
                        CommonUtil.toast("Something went wrong! Please try again....", mContext)
                    }
                }
            })
        } else {
            CommonUtil.toast("Check Internet", mContext)
        }
    }

    private fun setAdapter(domainList: java.util.ArrayList<SearchDomainDataDetailsClass.DomainList>) {
        rvSearchDomainCartItem.layoutManager = LinearLayoutManager(context)
        val adapter = SearchDomainAdapter(requireActivity(), domainList, this)
        // Setting the Adapter with the recyclerview
        rvSearchDomainCartItem.adapter = adapter
    }

    /*fun addMeal(restaurant: YelpRestaurant) {
        restaurant.meals.add(addedMeal)
    }*/

    private fun addDomainData(list: SearchDomainDataDetailsClass.DomainList) {
        list.domainName
        list.domainPrice
        CommonUtil.toast("$list\n\n", mContext)
    }

    private fun validate(): Boolean {
        etSearchDomainStr = etSearchDomain.text.toString().trim()

        return when {

            TextUtils.isEmpty(etSearchDomainStr) -> {
                etSearchDomain.error = "Search field can't be blank."
                etSearchDomain.requestFocus()
                false
            }
            else -> true
        }
    }

    override fun onBtnClickedAddToCart(pos: Int, list: SearchDomainDataDetailsClass.DomainList, btnSearchDomainAddCart: AppCompatButton) {
        //CommonUtil.toast("You have clicked on domain ${list.domainName}", mContext)
        val addedDomain = CommonUtil.getCartItems(mContext)
        var flag: Boolean = false
        var searchDomainName = ""
        if (!CommonUtil.getCartItems(mContext).isNullOrEmpty()) {
            for (i in 0 until CommonUtil.getCartItems(mContext)!!.size) {
                searchDomainName = addedDomain!![i].domainName
                flag = if (list.domainName == searchDomainName) {
                    true
                } else {
                    false
                }
            }
        }

        if (flag) {
            CommonUtil.toast("${list.domainName} is already in cart", mContext)
        } else {
            CommonUtil.addCartItem(activity, list)
            CommonUtil.toast("You have added ${list.domainName} domain in cart list.", mContext)
        }

//2432113017906

        if (!CommonUtil.getCartItems(mContext).isNullOrEmpty()) {
            cartValue = CommonUtil.getCartItems(mContext)!!.size
            initIconWithBadges(this.ibvCart, cartValue)
        }

    }


}