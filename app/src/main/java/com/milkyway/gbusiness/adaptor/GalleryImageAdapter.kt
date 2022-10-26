package com.milkyway.gbusiness.adaptor

import android.content.Context
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

class GalleryImageAdapter(private val context: Context, private val itemList: Array<String>) : RecyclerView.Adapter<GalleryImageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.gallery_image_view_adapter_layout, parent, false);
        return GalleryImageAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        try {
            if (itemList.size > 0) {
                var image = itemList[position]
                CommonUtil.saveStringPreferences(context, AppConstants.ITEM_IMAGE, image)
                var urlLogo = GbusinessService.STEP_TWO_ITEM_BASE_IMG_URL + CommonUtil.getPreferencesString(context, AppConstants.ITEM_IMAGE)
                Glide.with(context)
                    .load(urlLogo)
                    .into(holder.civ_item_qr)
            } else {
                holder.civ_item_qr.setImageResource(R.drawable.default_img)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var civ_item_qr: CircleImageView = itemView.findViewById(R.id.civ_item_qr)
    }
}