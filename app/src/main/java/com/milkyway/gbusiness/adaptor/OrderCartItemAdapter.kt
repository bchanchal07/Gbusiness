package com.milkyway.gbusiness.adaptor

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.models.SearchDomainDataDetailsClass
import com.milkyway.gbusiness.utils.CommonUtil
import kotlinx.android.synthetic.main.recyclerview_item_orders.view.*
import java.math.RoundingMode
import java.text.DecimalFormat

class OrderCartItemAdapter(private var mCtx: Context, private var domainList: List<SearchDomainDataDetailsClass.DomainList>, var listner: OnOrderListAdaptorClick) : RecyclerView.Adapter<OrderCartItemAdapter.SearchDomainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchDomainViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item_orders, parent, false);
        //this.mCtx = parent.context
        return SearchDomainViewHolder(view);
    }

    override fun onBindViewHolder(holder: SearchDomainViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val list = domainList[position]
        holder.tvServices.text = list.domainName
        holder.tvYearlyPrice.text = "${mCtx.resources.getString(R.string.rs)} ${list.domainPrice}"
        // sets the text to the textview from our itemHolder class
        holder.ivActionDelete.setOnClickListener(View.OnClickListener {
            if (listner != null) {
                listner.onClickedDeleterOrder(position, list)
            }
        })


        //CommonUtil.toast("Clicked on list item $position",mCtx)

        //var adapterYear = ArrayAdapter.createFromResource(mCtx, R.array.register_year, android.R.layout.simple_spinner_item)
        var years = arrayOf("1 Year", "2 Year", "3 Year", "4 Year", "5 Year")

        val arrayAdapter = ArrayAdapter(mCtx, R.layout.spinner_item, years)
        holder.spinnerYrDuration.adapter = arrayAdapter
        var subscriptionYr = 0
        //var getYearInt = 0

        for (i in domainList!!.indices) {
           val getYearInt = domainList!![position].subscriptionYr
            //if (getYearInt == subscriptionYr) {
                holder.spinnerYrDuration.setSelection(getYearInt-1)
            //}
        }

        holder.spinnerYrDuration.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            @SuppressLint("SetTextI18n")
            override fun onItemSelected(parent: AdapterView<*>, view: View, positionSpinner: Int, id: Long) {
                //val getDomainList = CommonUtil.getCartItems(mCtx) //ArrayList<SearchDomainDataDetailsClass.DomainList>()

                /*if (getYearInt != null) {
                    holder.spinnerYrDuration.setSelection(getYearInt-1)
                }*/
                val selectedText: String = parent?.getItemAtPosition(positionSpinner).toString()
                /*var subscriptionYr = 0
                var getYearInt = 0

                for (i in years.indices) {
                    val yrItem = years[i]
                    if (selectedText.contentEquals(yrItem))
                        subscriptionYr = positionSpinner + 1
                }
                for (i in getDomainList!!.indices) {
                    getYearInt = getDomainList[i].subscriptionYr
                    if (getYearInt == subscriptionYr) {
                        holder.spinnerYrDuration.setSelection(subscriptionYr)
                    }
                }*/

                //updateCartData(subscriptionYr, holder)

                if (listner != null) {
                    listner.onClickedSpinnerYear(selectedText, years, position, holder.adapterPosition, positionSpinner, holder.spinnerYrDuration, holder.tvTtlPrice, list)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }


    }

    private fun updateCartData(subscriptionYr: Int, holder: SearchDomainViewHolder) {
        //CommonUtil.toast("$getYearInt", mCtx)
        var priceTwoDecimal = ""
        /*val priceDouble = list.domainPrice.toDouble()
        val finalPriceDouble = (subscriptionYr) * priceDouble
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
        priceTwoDecimal = df.format(finalPriceDouble)
        val totalPrice = priceTwoDecimal.toString()
        val domainPriceData = SearchDomainDataDetailsClass.DomainList(list.domainName, list.domainPrice, subscriptionYr, totalPrice)
        //CommonUtil.toast(domainPriceData.toString(), mCtx)
        finalDomainList.add(domainPriceData)*/
        val finalDomainList = ArrayList<SearchDomainDataDetailsClass.DomainList>()
        for (i in domainList.indices) {
            val priceDouble = domainList[holder.adapterPosition].domainPrice.toDouble()
            val finalPriceDouble = (subscriptionYr) * priceDouble
            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.CEILING
            priceTwoDecimal = df.format(finalPriceDouble)
            val totalPrice = priceTwoDecimal.toString()
            val domainPriceData = SearchDomainDataDetailsClass.DomainList(domainList[holder.adapterPosition].domainName, domainList[holder.adapterPosition].domainPrice, subscriptionYr, totalPrice)
            //CommonUtil.toast(domainPriceData.toString(), mCtx)
            finalDomainList.add(domainPriceData)
        }
        CommonUtil.saveCartItem(mCtx, finalDomainList)
        CommonUtil.toast("Cart updated successfully.", mCtx)
        holder.tvTtlPrice.text = "${mCtx.resources.getString(R.string.rs)} $priceTwoDecimal"
    }

    override fun getItemCount(): Int {
        return domainList.size
    }

    class SearchDomainViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val spinnerYrDuration = view.spinnerYrDuration!!
        val ivActionDelete = view.ivActionDelete!!
        val tvServices = view.tvServices!!
        val tvYearlyPrice = view.tvYrlyPrice!!
        val tvTtlPrice = view.tvTtlPrice!!


    }

    interface OnOrderListAdaptorClick {
        //fun onItemClicked(position: Int)
        fun onClickedDeleterOrder(pos: Int, list: SearchDomainDataDetailsClass.DomainList)
        fun onClickedSpinnerYear(selectedText: String, year: Array<String>, clickedPosition: Int, posAdapter: Int, positionSpinner: Int, spinnerYrDuration: Spinner, tvTtlPrice: TextView, list: SearchDomainDataDetailsClass.DomainList)
    }
}