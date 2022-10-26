package com.milkyway.gbusiness.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.models.CategoryDataClass
import kotlinx.android.synthetic.main.recyclerview_item_business_category.view.*

class BusinessCategoryAdaptor(
    private val mCtx: Context, var listner: OnBusinessCatAdaptorClick,
    private val categoryList: List<CategoryDataClass.Data>,
) : RecyclerView.Adapter<BusinessCategoryAdaptor.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_business_category, parent, false);

        return MyViewHolder(view);
    }

    override fun getItemCount() = categoryList.size
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = categoryList[position]
        setAnimation(holder.itemView, position)
        // sets the text to the textview from our itemHolder class
        holder.categoryName.text = list.name
        holder.itemView.setOnClickListener {
            listner.onItemClicked(position, list)
        }
    }

    private fun setAnimation(view: View, position: Int) {
        val animation: Animation = if (position % 2 == 0) {
            AnimationUtils.loadAnimation(mCtx, R.anim.enter_from_left)
        } else {
            AnimationUtils.loadAnimation(mCtx, R.anim.enter_from_right)
        }

        view.animation = animation
    }

    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val categoryName = view.tvBusinessCategoryName!!

    }

    interface OnBusinessCatAdaptorClick {
        fun onItemClicked(position: Int, data: CategoryDataClass.Data)

    }


}




