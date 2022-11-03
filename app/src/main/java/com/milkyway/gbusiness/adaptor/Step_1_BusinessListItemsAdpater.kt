package com.milkyway.gbusiness.adaptor

import android.app.AlertDialog
import android.content.Context
import android.os.Build
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.milkyway.gbusiness.models.StepOneItemListsModel
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.retrofit.AppConstants
import com.milkyway.gbusiness.retrofit.GbusinessService
import com.milkyway.gbusiness.global.CommonUtil
import de.hdodenhof.circleimageview.CircleImageView


class Step_1_BusinessListItemsAdpater(private val mContext: Context, private val itemList: List<StepOneItemListsModel.BusinessItemsList>,
                                      val updateListener: UpdateBtnListener, val deleteItemListener: DeleteBtnListener) : RecyclerView.Adapter<Step_1_BusinessListItemsAdpater.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.step_1_business_list_items_adapter_layout, parent, false);
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var stepOneItemListsModel: StepOneItemListsModel.BusinessItemsList = itemList[position]
        holder.tv_payment_method.text = stepOneItemListsModel.name
        holder.tv_payment_email.text = stepOneItemListsModel.email
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            holder.tv_payment_email.tooltipText = stepOneItemListsModel.email
        }
        holder.tv_payment_url.text = stepOneItemListsModel.payment_url
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            holder.tv_payment_url.tooltipText = stepOneItemListsModel.payment_url
        }
        holder.tv_bank_details.text = stepOneItemListsModel.bank_details

        if (stepOneItemListsModel.pmethod_image != null) {
            CommonUtil.saveStringPreferences(mContext, AppConstants.ITEM_IMAGE, stepOneItemListsModel.pmethod_image)
            var urlLogo = GbusinessService.STEP_ONE_ITEM_BASE_IMG_URL + CommonUtil.getPreferencesString(mContext, AppConstants.ITEM_IMAGE)
            Glide.with(mContext)
                .load(urlLogo)
                .into(holder.civ_item_qr)

        } else {
            holder.civ_item_qr.setImageResource(R.drawable.default_img)
        }


        holder.civ_item_qr.setOnClickListener {
            val alertadd = AlertDialog.Builder(mContext)
            val layoutInflate = LayoutInflater.from(mContext)
            val view: View = layoutInflate.inflate(R.layout.custom_dialog, null)
            var imageView: ImageView = view.findViewById(R.id.imageView)
            alertadd.setView(view)

            if (stepOneItemListsModel.pmethod_image != null) {
                CommonUtil.saveStringPreferences(mContext, AppConstants.ITEM_IMAGE, stepOneItemListsModel.pmethod_image)
                var urlLogo = GbusinessService.STEP_ONE_ITEM_BASE_IMG_URL + CommonUtil.getPreferencesString(mContext, AppConstants.ITEM_IMAGE)
                Glide.with(mContext)
                    .load(urlLogo)
                    .into(imageView)
            } else {
                imageView.setImageResource(R.drawable.default_img)
            }
            alertadd.show()
        }

        holder.iv_delete_item.setOnClickListener {
            deleteItemListener.deleteClickListener(position, itemList)
        }

        //todo update step one list item..
        holder.iv_update.setOnClickListener {
            updateListener.updateClickListener(position,stepOneItemListsModel)
        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv_payment_method: TextView = itemView.findViewById(R.id.tv_payment_method)
        var tv_payment_email: TextView = itemView.findViewById(R.id.tv_payment_email)
        var tv_payment_url: TextView = itemView.findViewById(R.id.tv_payment_url)
        var tv_bank_details: TextView = itemView.findViewById(R.id.tv_bank_details)
        var civ_item_qr: CircleImageView = itemView.findViewById(R.id.civ_item_qr)
        var iv_delete_item: ImageView = itemView.findViewById(R.id.iv_delete_item)
        var iv_update: ImageView = itemView.findViewById(R.id.iv_update)
    }

    open interface UpdateBtnListener {
        fun updateClickListener(position: Int, stepOneBusinessList: StepOneItemListsModel.BusinessItemsList)
    }

    open interface DeleteBtnListener {
        fun deleteClickListener(position: Int, stepOneBusinessList: List<StepOneItemListsModel.BusinessItemsList>)
    }

}