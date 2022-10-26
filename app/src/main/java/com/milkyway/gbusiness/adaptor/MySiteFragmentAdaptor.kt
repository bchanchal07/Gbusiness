package com.milkyway.gbusiness.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.api.OnClickServices
import com.milkyway.gbusiness.models.DataXXXXXXX
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.mysite_adopter.view.*

class MySiteFragmentAdaptor(
    private val listener: OnClickServices,
    private val arrayList: List<DataXXXXXXX>?
) : RecyclerView.Adapter<MySiteFragmentAdaptor.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.mysite_adopter, parent, false);

        return MyViewHolder(view);
    }

    override fun getItemCount() = arrayList!!.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = arrayList?.get(position)

        /* holder.tvearningDate.setText()
         holder.tvearningDirect.setText()
         holder.tvearningGlobal.setText()*/


        /* var list = lransList.get(position)

         if (list.qustn != null)
         {
             holder.tvQuestions.setText(list.qustn)
         }*/

        //  Log.i(list?.publish,listener
        Picasso.get().load(list?.thumbnail).placeholder(R.drawable.gallry_place_hoder)
            .into(holder.ivMySite)
        if (list?.preview != null)
            holder.btnSitePreview.setOnClickListener {
                listener.onClick(
                    "1",
                    list!!.preview
                )
            }
        if (list?.id != null) holder.btnPublishUnPublish.setOnClickListener {
            if (list?.publish_id_status.toString().contentEquals("0")) {
                listener.onClickPublish(list!!.id.toString(), "btnSitePreview")
            } else listener.nowUnPublishWebSite(list!!.id.toString())
        }
        if (list?.domain != null) {
            holder.btnSiteTrash.visibility = View.GONE
        } else holder.btnSiteTrash.visibility = View.VISIBLE

        if (list?.id != null) holder.btnSiteTrash.setOnClickListener {
            listener.onClickTrash(
                list!!.id.toString(),
                "btnPublishUnPublish"
            )
        }
        if (list?.id != null) holder.btnSiteTrash.setOnClickListener {
            listener.nowUnPublishWebSite(list!!.id.toString())
        }

        if (list?.id != null) holder.btnEditSites.setOnClickListener {
            listener.editSites(list!!.edit_now)
        }

        if (list?.publish_id_status != null) {
            if (list?.publish_id_status.toString()
                    .contentEquals("0")
            ) {
                holder.btnPublishUnPublish.text = "Publish"
                holder.btnSiteTrash.visibility = View.VISIBLE
            } else {
                holder.btnPublishUnPublish.text = "UnPublish"
                holder.btnSiteTrash.visibility = View.GONE
            }
        }



        holder.tvSiteTittle.text = list?.title
    }

    class MyViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

        val ivMySite: ImageView = view.ivMySite
        val btnSitePreview: AppCompatButton = view.btnSitePreview
        val btnSiteTrash: AppCompatButton = view.btnSiteTrash
        val btnPublishUnPublish: AppCompatButton = view.btnPublishUnPublish
        val btnEditSites: AppCompatButton = view.btnEditSites
        val tvSiteTittle: TextView = view.tvSiteTittle
        val tvSiteSubTittle: TextView = view.tvSiteSubTittle


    }

}