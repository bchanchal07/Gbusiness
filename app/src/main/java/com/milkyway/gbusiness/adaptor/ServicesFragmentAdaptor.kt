package com.milkyway.gbusiness.adaptor

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.api.OnServiceAdapterClick
import com.milkyway.gbusiness.models.DataXXXX
import kotlinx.android.synthetic.main.recyclerview_item_service_left_image.view.image_slider
import kotlinx.android.synthetic.main.recyclerview_item_service_left_image.view.serviceAdpSubTittle
import kotlinx.android.synthetic.main.recyclerview_item_service_left_image.view.serviceAdpTitle
import kotlinx.android.synthetic.main.recyclerview_item_service_right_image.view.*

class ServicesFragmentAdaptor(
    private val listener: OnServiceAdapterClick, val array: List<DataXXXX>,
) : RecyclerView.Adapter<ServicesFragmentAdaptor.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_service_right_image, parent, false);
        return MyViewHolder(view)
    }

    override fun getItemCount() = array.size
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = array[position]

        if (list.title != null) holder.serviceAdpTitle.text = list.title
        if (list.description != null) holder.serviceAdpSubTittle.text = list.description
        //if(list.image!=null)Picasso.get().load(list.image).placeholder(R.drawable.gallry_place_hoder).into(holder.serviceAdpImage)

        val imageList = ArrayList<SlideModel>() // Create image list
        for (i in list.images.indices) {
            //if (URLUtil.isValidUrl(list.images[i]))

            imageList.add(SlideModel(list.images[i], ScaleTypes.FIT))
        }
        holder.serviceAdpImage.setImageList(imageList)

        if (list.price > 0 && list.price != null) {
            holder.btnOrderNow.text = "$${list.price} Order Now"
        } else {
            holder.btnOrderNow.text = "Order Now"
        }

        //enquiry
        if (list.price != null && list.title != null && list.description != null && list.name != null) {
            holder.btnOrderNow.setOnClickListener {
                listener.onClickServiceItem(
                    list.service_id.toString(), list.title, "buy", list.price.toString(), list.title,
                    list.description, list.name,list.image
                )
            }
        } else {
            holder.btnOrderNow.setOnClickListener {
                listener.onClickServiceItem(
                    list.service_id.toString(), list.title, "enquiry", "0", "0",
                    "0", list.name,list.image)
            }
        }

    }

    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val serviceAdpImage = view.image_slider!!
        val serviceAdpTitle = view.serviceAdpTitle!!
        val btnOrderNow = view.btnOrderNow!!
        val serviceAdpSubTittle = view.serviceAdpSubTittle!!
    }


}




