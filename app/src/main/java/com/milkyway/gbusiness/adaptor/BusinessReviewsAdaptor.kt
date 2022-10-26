package com.milkyway.gbusiness.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.models.GetReviewsDataClass
import kotlinx.android.synthetic.main.recyclerview_item_reviews.view.*

class BusinessReviewsAdaptor(
    private val mCtx: Context,
    private val reviewsList: List<GetReviewsDataClass.Data>,
) : RecyclerView.Adapter<BusinessReviewsAdaptor.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_reviews, parent, false);

        return MyViewHolder(view)
    }

    override fun getItemCount() = reviewsList.size
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = reviewsList[position]
        // sets the text to the textview from our itemHolder class
        holder.tvUserName.text = list.name
        holder.tvUserEmail.text = list.email
        holder.ratingBarReviews.rating= list.starRating.toFloat()
        holder.tvReviewComment.text = list.comments
        if (position == reviewsList.lastIndex)
            holder.viewSeparator.visibility = View.GONE
        else
            holder.viewSeparator.visibility = View.VISIBLE
    }

    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val tvUserName = view.tvUserName!!
        val tvUserEmail = view.tvUserEmail!!
        val ratingBarReviews = view.ratingBarReviews!!
        val tvReviewComment = view.tvReviewComment!!
        val ivUserImage = view.ivUserImage!!
        val viewSeparator = view.viewSeparator!!

    }
}




