package com.milkyway.gbusiness.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.models.SubCategoryDataClass
import kotlinx.android.synthetic.main.recyclerview_item_sub_category.view.*

class BusinessSubCategoryAdaptor(
    val mCtx: Context, var listner: OnSubCatAdaptorClick,
    private val subCategoryList: List<SubCategoryDataClass.Subcategory>,
) : RecyclerView.Adapter<BusinessSubCategoryAdaptor.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item_sub_category, parent, false);

        return MyViewHolder(view);
    }

    override fun getItemCount() = subCategoryList.size
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = subCategoryList[position]
        setAnimation(holder.itemView, position)
        // sets the text to the textview from our itemHolder class
        holder.subCategoryName.text = list.name
        holder.itemView.setOnClickListener {
            listner.onItemClicked(position, list)
        }
    }

    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val subCategoryName = view.tvSubCategoryName!!
    }

    private fun setAnimation(view: View, position: Int) {
        val animation: Animation = if (position % 2 == 0) {
            AnimationUtils.loadAnimation(mCtx, R.anim.slide_in_left)
        } else {
            AnimationUtils.loadAnimation(mCtx, R.anim.slide_in_right)
        }

        view.animation = animation
    }

    interface OnSubCatAdaptorClick {
        fun onItemClicked(position: Int, data: SubCategoryDataClass.Subcategory)
    }
}




