package com.milkyway.gbusiness.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.CategoryDataDetailsClass
import kotlinx.android.synthetic.main.recyclerview_item_business_category_details.view.*

class BusinessCatDetailsAdaptor(
    private val mCtx: Context, var listner: OnCatDetailAdaptorClick,
    private val categoryList: List<CategoryDataDetailsClass.Data.TemplateDetail>,
) : RecyclerView.Adapter<BusinessCatDetailsAdaptor.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item_business_category_details, parent, false);

        return MyViewHolder(view);
    }

    override fun getItemCount() = categoryList.size
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.layoutDomainRv.animation =
            AnimationUtils.loadAnimation(holder.itemView.context, R.anim.scale)
        val list = categoryList[position]

        // sets the text to the textview from our itemHolder class
        holder.tvBusinessName.text = list.domainName
        holder.tvBusinessTitle.text = list.tName
        if (list.businessAboutUs.isNullOrEmpty()) {
            holder.tvBusinessAboutUs.text = ""
        } else {
            holder.tvBusinessAboutUs.text = list.businessAboutUs
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
            val urlDefault = "https://www.gbusiness.co/public/business_images/default-business-logo.jpg"
            Glide.with(mCtx)
                .load(urlDefault)
                .into(holder.ivBusinessLogo)
            /*Picasso
                .get()
                .load(urlDefault)
                .into(holder.categoryImage)*/
        }

        holder.itemView.setOnClickListener {
            listner.onItemClicked(position)
        }

        holder.btnWebsite.setOnClickListener {
            listner.onBtnClickedWebsite(position, list)
        }

        holder.btnQuote.setOnClickListener {
            listner.onBtnClickedQuote(position, list)
        }

    }

    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val ivBusinessLogo = view.ivBusinessLogo!!
        val tvBusinessName = view.tvBusinessName!!
        val tvBusinessTitle = view.tvBusinessTitle!!
        val tvBusinessAboutUs = view.tvBusinessAboutUs!!
        val btnWebsite = view.btnVisitWebsite!!
        val btnQuote = view.btnGetQuotes!!
        val layoutDomainRv = view.layoutDomainRv!!

    }

    interface OnCatDetailAdaptorClick {
        fun onItemClicked(position: Int)
        fun onBtnClickedWebsite(pos: Int, list: CategoryDataDetailsClass.Data.TemplateDetail)
        fun onBtnClickedQuote(pos: Int, list: CategoryDataDetailsClass.Data.TemplateDetail)
    }


}




