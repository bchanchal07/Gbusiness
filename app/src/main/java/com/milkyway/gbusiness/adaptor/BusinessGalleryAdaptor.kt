package com.milkyway.gbusiness.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.retrofit.GbusinessService.BASE_GALLERY_IMG_URL
import com.milkyway.gbusiness.models.GalleryModelData
import kotlinx.android.synthetic.main.recyclerview_item_gallery.view.*

class BusinessGalleryAdaptor(
    private val mCtx: Context, var listner: OnGalleryAdaptorClick,
    private val galleryList: ArrayList<GalleryModelData.Data>,
) : RecyclerView.Adapter<BusinessGalleryAdaptor.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_gallery, parent, false);

        return MyViewHolder(view);
    }

    override fun getItemCount() = galleryList.size
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = galleryList[position]

        val urlGalleryImageString = list.image
        val url = "$BASE_GALLERY_IMG_URL$urlGalleryImageString"
        // sets the text to the textview from our itemHolder class
        if (URLUtil.isValidUrl(url)) {

            Glide.with(mCtx)
                .load(url)
                .into(holder.ivGalleryImage)
            /*Picasso
                .get()
                .load(url)
                .into(holder.ivGalleryImage)*/
        }
        val uriString = ArrayList<String>()
        for (i in galleryList.indices) {
            uriString.add("${BASE_GALLERY_IMG_URL}${galleryList[i].image!!}")
        }
        holder.itemView.setOnClickListener {
            listner.onGalleryItemClicked(position, list, uriString)
        }
    }

    private fun getArrayOfUrls(str: String): MutableList<String> {
        /*"[^A-Za-z0-9]".toRegex().apply {
            yourArray[0] = replace(yourArray[0], "")
        }*/
        return str.split(",").toMutableList()
    }

    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val ivGalleryImage = view.ivGalleryImage!!

    }

    interface OnGalleryAdaptorClick {
        fun onGalleryItemClicked(position: Int, data: GalleryModelData.Data, uriString: ArrayList<String>)

    }
}




