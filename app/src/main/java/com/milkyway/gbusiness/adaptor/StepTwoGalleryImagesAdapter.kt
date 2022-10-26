package com.milkyway.gbusiness.adaptor

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.utils.CommonUtil
import de.hdodenhof.circleimageview.CircleImageView

class StepTwoGalleryImagesAdapter(private val context: Context, private val list: ArrayList<*>): RecyclerView.Adapter<StepTwoGalleryImagesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.step_two_gallery_images_adapter, parent, false);
        return StepTwoGalleryImagesAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        try {
            if (list!!.size > 0) {
                holder.civ_item_qr.setImageURI(list[position] as Uri)
            } else {
                holder.civ_item_qr.setImageResource(R.drawable.default_img)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var civ_item_qr: CircleImageView = itemView.findViewById(R.id.civ_item_qr)
    }

}