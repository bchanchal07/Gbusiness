package com.milkyway.gbusiness.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.BusinessListingResponse
import com.milkyway.gbusiness.global.DateTimeUtils
import kotlinx.android.synthetic.main.recyclerview_item_business_list.view.*

class BusinessListAdaptor(private val mCtx: Context, private val businessList: List<BusinessListingResponse.Data>, ) : RecyclerView.Adapter<BusinessListAdaptor.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item_business_list, parent, false);

        return MyViewHolder(view);
    }

    override fun getItemCount() = businessList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = businessList[position]
        holder.tvSrNo.text = (position + 1).toString()
        holder.tvBusinessName.text = list.businessName
        holder.tvEmail.text = list.businessEmail
        holder.tvUrl.text = list.businessWebUrl
        holder.tvAboutBusiness.text = list.businessAboutUs
        holder.tvCategory.text = list.catname
        holder.tvSubcategory.text = list.subcatname
        var returnDate = if (list.updatedAt != null) {
            DateTimeUtils.getMaxDateFromTwoDatesString(list.createdAt, list.updatedAt, DateTimeUtils.DATE_FORMAT_33).toString()

        } else {
            list.createdAt
        }
        val finalDateFormatStr = DateTimeUtils.formatDateFromDateString(
            DateTimeUtils.DATE_FORMAT_33,
            DateTimeUtils.DATE_FORMAT_8,
            returnDate
        )
        holder.tvDate.text = finalDateFormatStr

        when (list.status) {
            0 -> {
                holder.tvStatus.text = "Pending"
                holder.tvStatus.setTextColor(mCtx.resources.getColor(R.color.red))
            }
            1 -> {
                holder.tvStatus.text = "Success"
                holder.tvStatus.setTextColor(mCtx.resources.getColor(R.color.color_green))
            }
        }

        if (list.businessLogo != null) {
            val urlLogo = GbusinessService.BASE_IMG_URL + list.businessLogo

            Glide.with(mCtx)
                .load(urlLogo)
                .into(holder.ivBusinessLogo)
            /*Picasso
                .get()
                .load(urlLogo)
                .into(holder.categoryImage)*/
        } else {
            val urlDefault = "${GbusinessService.BASE_IMG_URL}/default-business-logo.jpg"
            Glide.with(mCtx)
                .load(urlDefault)
                .into(holder.ivBusinessLogo)
            /*Picasso
                .get()
                .load(urlDefault)
                .into(holder.categoryImage)*/
        }

     /*   holder.btnDelete.setOnClickListener {
            listner.onDeleteBtnClicked(position, list)
        }

        holder.btnUpdate.setOnClickListener {
            listner.onUpdateBtnClicked(position, list)
        }*/

    }

    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val tvSrNo = view.tvSrNo!!
        val tvBusinessName = view.tvBusinessName!!
        val ivBusinessLogo = view.ivBusinessLogo!!
        val tvEmail = view.tvEmail!!
        val tvUrl = view.tvUrl!!
        val tvAboutBusiness = view.tvAboutBusiness!!
        val tvCategory = view.tvCategory!!
        val tvSubcategory = view.tvSubcategory!!
        val tvDate = view.tvDate!!
        val tvStatus = view.tvStatus!!
        val btnUpdate = view.btnUpdate!!
        val btnDelete = view.btnDelete!!

    }

    interface OnBListingAdaptorClick {
        fun onDeleteBtnClicked(pos: Int, list: BusinessListingResponse.Data)

        fun onUpdateBtnClicked(pos: Int, list: BusinessListingResponse.Data)
    }


}




