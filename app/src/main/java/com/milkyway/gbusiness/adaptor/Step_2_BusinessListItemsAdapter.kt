package com.milkyway.gbusiness.adaptor

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.models.StepOneItemListsModel
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.adaptor.Step_2_BusinessListItemsAdapter.ViewHolder
import dev.mortezaom.mdtoast.MDToast

class Step_2_BusinessListItemsAdapter(private val context: Context, private val stepTwoItemList_gl: List<StepOneItemListsModel.BusinessItemsList>,
                                      val updateListener: Step_2_BusinessListItemsAdapter.UpdateBtnListener, val deleteItemListener: Step_2_BusinessListItemsAdapter.DeleteBtnListener
) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.step_2_business_list_items_adapter_layout, parent, false);
        return Step_2_BusinessListItemsAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var stepTwoListModel: StepOneItemListsModel.BusinessItemsList = stepTwoItemList_gl[position]
        holder.tv_title.text = stepTwoListModel.name

        val strs = stepTwoListModel.gallery_image.split(",").toTypedArray()
        Log.e("string_image---", strs.toString())


        if (strs.isNotEmpty()) {
            bindAdapter(holder, strs)
        } else {
            MDToast.makeText(context, "No item list..", MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR).show()
        }

        holder.iv_delete_item.setOnClickListener {
            deleteItemListener.deleteClickListener(position, stepTwoItemList_gl)
        }

        holder.iv_update.setOnClickListener {
            updateListener.updateClickListener(position, stepTwoListModel)
        }

    }

    override fun getItemCount(): Int {
        return stepTwoItemList_gl.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv_title: TextView = itemView.findViewById(R.id.tv_title)
        var rv_items: RecyclerView = itemView.findViewById(R.id.rv_items)
        var iv_update: ImageView = itemView.findViewById(R.id.iv_update)
        var iv_delete_item: ImageView = itemView.findViewById(R.id.iv_delete_item)

    }

    open interface UpdateBtnListener {
        fun updateClickListener(position: Int, stepTwoBusinessList: StepOneItemListsModel.BusinessItemsList)
    }

    open interface DeleteBtnListener {
        fun deleteClickListener(position: Int, stepTwoBusinessList: List<StepOneItemListsModel.BusinessItemsList>)
    }


    fun bindAdapter(holder: ViewHolder, strs: Array<String>) {
        var linearLayoutManager: LinearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        var galleryImageAdapter: GalleryImageAdapter = GalleryImageAdapter(context, strs)
        holder.rv_items.layoutManager = linearLayoutManager
        holder.rv_items.adapter = galleryImageAdapter
    }
}