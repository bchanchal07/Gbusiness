package com.milkyway.gbusiness.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.models.SocialMediaData
import kotlinx.android.synthetic.main.recyclerview_item_social_media.view.*

class SocialMediaAdaptor(
    val mCtx: Context, var listner: SocialMediaAdaptorClick,
    private val socialList: List<SocialMediaData>,
) : RecyclerView.Adapter<SocialMediaAdaptor.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item_social_media, parent, false);

        return MyViewHolder(view)
    }

    override fun getItemCount() = socialList.size
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = socialList[position]
        // sets the image to the imageview from our itemHolder class
        holder.image.setImageResource(list.image)

        // sets the text to the textview from our itemHolder class
        holder.title.text = list.title
        holder.itemView.setOnClickListener {
            //Toast.makeText(mCtx, "Clicked on item $position on SocialMediaAdaptor", Toast.LENGTH_LONG).show()
            listner.onSocialItemClicked(position, list)
        }

    }

    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val title = view.tvSocialMediaName!!
        val image = view.ivSocialImage!!

    }

    interface SocialMediaAdaptorClick {
        fun onSocialItemClicked(position: Int, list: SocialMediaData)

    }


}




