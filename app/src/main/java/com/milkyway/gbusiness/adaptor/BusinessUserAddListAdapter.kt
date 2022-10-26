package com.milkyway.gbusiness.adaptor

import android.app.Dialog
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Typeface
import android.os.Build
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.google.android.material.chip.Chip
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.models.BusinessListingResponse
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.pawegio.kandroid.layoutInflater


class BusinessUserAddListAdapter internal constructor( private val mCtx: Context, private val businessList: List<BusinessListingResponse.Data>,
    val btnlistener: BtnClickListener) : BaseExpandableListAdapter() {

    override fun getChild(listPosition: Int, expandedListPosition: Int): Any {
        return businessList[listPosition]
    }

    override fun getChildId(listPosition: Int, expandedListPosition: Int): Long {
        return expandedListPosition.toLong()
    }

    override fun getChildrenCount(listPosition: Int): Int {
        return this.businessList.size - this.businessList.size + 1
    }

    override fun getChildView(listPosition: Int, expandedListPosition: Int, p2: Boolean, convertView: View?, p4: ViewGroup?): View {
        var convertView = convertView
        val expandedListText = getChild(listPosition, expandedListPosition) as BusinessListingResponse.Data
        if (convertView == null) {
            val layoutInflater = this.mCtx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.expandable_business_list_child_layout, null)
        }
        val tvUrl = convertView!!.findViewById<TextView>(R.id.tvUrl)
        val tvAboutBusiness = convertView!!.findViewById<TextView>(R.id.tvAboutBusiness)
        val tvCategory = convertView!!.findViewById<TextView>(R.id.tvCategory)
        val tvSubcategory = convertView!!.findViewById<TextView>(R.id.tvSubcategory)
        val chDate = convertView!!.findViewById<Chip>(R.id.chip_Date)
        val chStatus = convertView!!.findViewById<Chip>(R.id.chip_status)
        val chAction = convertView!!.findViewById<Chip>(R.id.ch_action)

        tvUrl.text = expandedListText.businessWebUrl
        tvAboutBusiness.text = expandedListText.businessAboutUs
        tvCategory.text = expandedListText.catname
        tvSubcategory.text = expandedListText.subcatname
        chDate.text = expandedListText.createdAt
        when (expandedListText.status) {
            0 -> {
                chStatus.text = "PENDING"
                chStatus.setTextColor(mCtx.resources.getColor(R.color.white))
                chStatus.chipBackgroundColor = ColorStateList.valueOf(ContextCompat.getColor(mCtx, R.color.red))
            }
            1 -> {
                chStatus.text = "PUBLISHED"
                chStatus.setTextColor(mCtx.resources.getColor(R.color.white))
                chStatus.chipBackgroundColor = ColorStateList.valueOf(ContextCompat.getColor(mCtx, R.color.color_green))
            }
        }

        chAction.setOnClickListener {
            btnlistener.onBtnClick(listPosition, expandedListText)
        }

        tvAboutBusiness.setOnClickListener {
            val inflater = mCtx.layoutInflater
            val PopupView: View = inflater!!.inflate(R.layout.about_us_layout, null)
            val dialog = Dialog(mCtx, R.style.CustomDialogManualQty)
            val window = dialog.window
            val layoutParams = window!!.attributes
            layoutParams.gravity = Gravity.BOTTOM
            window!!.attributes = layoutParams
            window!!.attributes.windowAnimations = R.style.bottome_dialog_animation
            dialog.setContentView(PopupView)
            window!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.setCancelable(true)
            dialog.show()
            dialog.setCancelable(true)

            var text_view: TextView = PopupView.findViewById(R.id.text_view)
            text_view.text = expandedListText.businessAboutUs
        }

        return convertView
    }

    override fun getGroup(listPosition: Int): Any {
        return this.businessList[listPosition]
    }

    override fun getGroupId(listPosition: Int): Long {
        return listPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return this.businessList.size
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun getGroupView(listPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        val listTitle = getGroup(listPosition) as BusinessListingResponse.Data
        if (convertView == null) {
            val layoutInflater = this.mCtx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.expandable_business_list_group_layout, null)
        }
        val tvBusinessName = convertView!!.findViewById<TextView>(R.id.tvBusinessName)
        val ivBusinessLogo = convertView!!.findViewById<ImageView>(R.id.ivBusinessLogo)
        var tvEmail = convertView!!.findViewById<TextView>(R.id.tvEmail)

        //todo set text...
//        tvSrNo.text = (listPosition + 1).toString()
        tvBusinessName.setTypeface(null, Typeface.BOLD)
        tvBusinessName.text = listTitle.businessName
        tvEmail.text = listTitle.businessEmail
        tvEmail.tooltipText = listTitle.businessEmail


        if (listTitle.businessLogo != null) {
            val urlLogo = GbusinessService.BASE_IMG_URL + listTitle.businessLogo
            Glide.with(mCtx)
                .load(urlLogo)
                .into(ivBusinessLogo)
        } else {
            val urlDefault = "${GbusinessService.BASE_IMG_URL}/default-business-logo.jpg"
            Glide.with(mCtx)
                .load(urlDefault)
                .into(ivBusinessLogo)
            /*Picasso.get().load(urlDefault).into(holder.categoryImage)*/
        }
        return convertView
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(listPosition: Int, p1: Int): Boolean {
        return true
    }

    open interface BtnClickListener {
        fun onBtnClick(position: Int, businessList: BusinessListingResponse.Data)
    }

}