package com.milkyway.gbusiness.global

import android.app.Activity
import android.app.Dialog
import android.view.KeyEvent
import android.view.Window
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.milkyway.gbusiness.R

class CustomLoader(private val activity: Activity) {
    init {
        initDialog()
    }

    private lateinit var dialog: Dialog

    private fun initDialog(){
        dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        //set cancelable false so that it's never get hidden
        dialog.setCancelable(false)
        //that's the layout i told you will inflate later
        dialog.setContentView(R.layout.custom_loader_layout)

        //initialize the imageView form inflated layout
        val gifImageView: ImageView = dialog.findViewById(R.id.custom_loading_imageView)

        /*
        it was never easy to load gif into an ImageView before Glide or Others library
        */

        //now load that gif which we put inside the drawable folder here with the help of //Glide
        Glide.with(activity)
            .load(R.drawable.serp_animation_loader)
            .placeholder(R.drawable.serp_animation_loader)
            .centerCrop()
            .into(gifImageView)


        //on back dismiss loader
        dialog.setOnKeyListener { arg0, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                dialog.dismiss()
            }
            true
        }

    }

    //show loader
    fun showDialog() {

        dialog.show()
    }

    //hide loader
    fun hideDialog() {
        dialog.dismiss()
    }
}