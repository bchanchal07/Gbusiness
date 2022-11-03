package com.milkyway.gbusiness.adaptor

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.milkyway.gbusiness.R
import com.milkyway.gbusiness.api.ProfileConfigrationListener
import com.milkyway.gbusiness.models.DomainX
import com.milkyway.gbusiness.global.CommonUtil
import kotlinx.android.synthetic.main.adpter_profile_config.view.*

class ProfileConfigrationAdaptor(
    val arrayList: ArrayList<DomainX>,
    val types: String,
    val mContext: Context,
    val listnerSSl: ProfileConfigrationListener,
) : RecyclerView.Adapter<ProfileConfigrationAdaptor.MyViewHolder>() {
    lateinit var view: View
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        view = LayoutInflater.from(parent.context).inflate(R.layout.adpter_profile_config, parent, false)

        return MyViewHolder(view = view)
    }

    override fun getItemCount() = arrayList.size//arrayList.size

    @SuppressLint("UseCompatLoadingForColorStateLists", "SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val list = arrayList.get(position)

        // if(!list.domain_name.isNullOrEmpty()) holder.configAdpDomian.setText(list.domain_name)

        Log.i("dsd", "dfdfdsf=" + types)

        if (types == "ssl") {
            holder.configActivateSSL.visibility = View.VISIBLE
            holder.configActivateWebMail.visibility = View.GONE
        } else {
            holder.configActivateSSL.visibility = View.GONE
            holder.configActivateWebMail.visibility = View.VISIBLE
        }
        /* if (types == "ssl")
         {*/
        Log.i("dsd", "dfdfdsf= true")


        if (list.domain_name != null) holder.configAdpDomian.text = list.domain_name
        if (list.ssl_ative != null && list.ssl_ative == "1") {
            holder.tvActivateSSl.backgroundTintList = view.resources.getColorStateList(R.color.colorAccent)
            holder.tvActivateSSl.setText(R.string.activated)
        } else holder.tvActivateSSl.setText(R.string.active)

        if (!list.domain_name.isNullOrEmpty()) holder.tvActivateSSl.setOnClickListener {

            if (list.ssl_ative != null && list.ssl_ative == "0") listnerSSl.getSslListener(list.domain_name)
            else CommonUtil.toast("Already Activated", mContext)

        }
        /*  }else
          {
            */


        if (list.domain_name != null) {
            var getDomain = list.domain_name
            var dff = getDomain.split("//")

            val domain = dff[1]

            if (list.webmail_name != null) {
                holder.configAdpDomianWebName.visibility = View.GONE
                holder.configAdpDomianWebMail.text = list.webmail_name
                holder.tvActivateWebMail.backgroundTintList = view.resources.getColorStateList(R.color.colorAccent)
                holder.tvActivateWebMail.setText(R.string.created)
            } else {
                holder.configAdpDomianWebName.visibility = View.VISIBLE
                holder.configAdpDomianWebMail.text = "@$domain"
            }
        }


        if (list.domain_name != null) holder.tvActivateWebMail.setOnClickListener {

            var emailAddress = holder.configAdpDomianWebName.text.toString().trim()
            var emailSecond = holder.configAdpDomianWebMail.text.toString().trim()


            if (list.webmail_name == null) {
                if (!emailAddress.isNullOrEmpty()) listnerSSl.creatWebmailListener(list.domain_name, emailAddress + emailSecond)
                else CommonUtil.toast("Please out this field", mContext)
            } else CommonUtil.toast("Already Created", mContext)


        }
        //   }


    }

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val configAdpDomian: TextView = view.configAdpDomian
        val tvActivateSSl: TextView = view.tvActivateSSl
        val tvActivateWebMail: TextView = view.tvActivateWebMail
        val configActivateWebMail: CardView = view.configActivateWebMail
        val configActivateSSL: CardView = view.configActivateSSL
        val configAdpDomianWebMail: TextView = view.configAdpDomianWebMail
        val configAdpDomianWebName: EditText = view.configAdpDomianWebName
    }
}