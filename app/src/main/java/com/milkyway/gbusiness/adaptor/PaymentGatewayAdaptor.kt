package com.milkyway.gbusiness.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.models.BusinessPaymentDataClass
import kotlinx.android.synthetic.main.recyclerview_item_payment_gateway.view.*

class PaymentGatewayAdaptor(
    val mCtx: Context, var listner: PaymentGatewayAdaptorClick,
    private val payQRCodeList: List<BusinessPaymentDataClass.Data>,
) : RecyclerView.Adapter<PaymentGatewayAdaptor.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_item_payment_gateway, parent, false);

        return MyViewHolder(view);
    }

    override fun getItemCount() = payQRCodeList.size
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = payQRCodeList[position]
        // sets the image to the imageview from our itemHolder class
        holder.title.text = list.name
        if (list.pmethodImage != null) {
            val pImgUrl = GbusinessService.BASE_PAYMENT_IMG_URL + list.pmethodImage

            Glide.with(mCtx)
                .load(pImgUrl)
                .into(holder.image)
            /*Picasso
                .get()
                .load(urlLogo)
                .into(holder.categoryImage)*/
        }

        val uriString = ArrayList<String>()
        for (i in payQRCodeList.indices) {
            uriString.add("${GbusinessService.BASE_PAYMENT_IMG_URL}${payQRCodeList[i].pmethodImage!!}")
        }
        holder.itemView.setOnClickListener {
            listner.onPayQrItemClicked(position, list,uriString)

        }

    }

    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        val title = view.tvPaymentGatewayTitle!!
        val image = view.ivPaymentQRCode!!

    }

    interface PaymentGatewayAdaptorClick {
        fun onPayQrItemClicked(position: Int, list: BusinessPaymentDataClass.Data, uriString: ArrayList<String>)

    }


}




