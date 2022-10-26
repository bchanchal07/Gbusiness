package com.milkyway.gbusiness.extension

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.milkyway.gbusiness.R
import id.ionbit.ionalert.IonAlert

inline fun Activity.alert(title: CharSequence? = null, message: CharSequence? = null, func: AlertDialogHelper.() -> Unit): AlertDialog {
    return AlertDialogHelper(this, title, message).apply {
        func()
    }.create()
}

inline fun Activity.alert(titleResource: Int = 0, messageResource: Int = 0, func: AlertDialogHelper.() -> Unit): AlertDialog {
    val title = if (titleResource == 0) null else getString(titleResource)
    val message = if (messageResource == 0) null else getString(messageResource)
    return AlertDialogHelper(this, title, message).apply {
        func()
    }.create()
}

inline fun Activity.customAlert(title: String, message: String, context: Activity,type:Int):IonAlert{
    val ionAlert = IonAlert(context, type)
    ionAlert.titleText = title
    ionAlert.contentText = message
    ionAlert.show()
    return ionAlert
}

inline fun Fragment.alert(title: CharSequence? = null, message: CharSequence? = null, func: AlertDialogHelper.() -> Unit): AlertDialog {
    return AlertDialogHelper(context!!, title, message).apply {
        func()
    }.create()
}

inline fun Fragment.alert(titleResource: Int = 0, messageResource: Int = 0, func: AlertDialogHelper.() -> Unit): AlertDialog {
    val title = if (titleResource == 0) null else getString(titleResource)
    val message = if (messageResource == 0) null else getString(messageResource)
    return AlertDialogHelper(context!!, title, message).apply {
        func()
    }.create()
}

inline fun TextView.rightDrawable(@DrawableRes id: Int = 0/*, @DimenRes sizeRes: Int*/) {
    val drawable = ContextCompat.getDrawable(context, id)
    /*val size = resources.getDimensionPixelSize(sizeRes)
    drawable?.setBounds(0, 0, size, size)*/
    this.setCompoundDrawables(null, null, drawable, null)
}

@SuppressLint("InflateParams")
class AlertDialogHelper(context: Context, title: CharSequence?, message: CharSequence?) {

    private val dialogView: View by lazy {
        LayoutInflater.from(context).inflate(R.layout.dlg_alert, null)
    }

    private val builder: AlertDialog.Builder = AlertDialog.Builder(context)
        .setView(dialogView)

    private val title: TextView by lazy {
        dialogView.findViewById<TextView>(R.id.tvTitleAlertDialog)
    }

    private val message: TextView by lazy {
        dialogView.findViewById<TextView>(R.id.tvDescAlertDialog)
    }

    private val positiveButton: TextView by lazy {
        dialogView.findViewById<TextView>(R.id.tvOkAlertDialog)
    }

    private val negativeButton: TextView by lazy {
        dialogView.findViewById<TextView>(R.id.tvCancelAlertDialog)
    }

    private var dialog: AlertDialog? = null

    var cancelable: Boolean = true

    init {
        this.title.text = title
        this.message.text = message
    }

    fun positiveButton(@StringRes textResource: Int, func: (() -> Unit)? = null) {
        with(positiveButton) {
            text = builder.context.getString(textResource)
            setClickListenerToDialogButton(func)
        }
    }

    fun positiveButton(text: CharSequence, func: (() -> Unit)? = null) {
        with(positiveButton) {
            this.text = text
            setClickListenerToDialogButton(func)
        }
    }

    fun negativeButton(@StringRes textResource: Int, func: (() -> Unit)? = null) {
        with(negativeButton) {
            text = builder.context.getString(textResource)
            setClickListenerToDialogButton(func)
        }
    }

    fun negativeButton(text: CharSequence, func: (() -> Unit)? = null) {
        with(negativeButton) {
            this.text = text
            setClickListenerToDialogButton(func)
        }
    }

    fun onCancel(func: () -> Unit) {
        builder.setOnCancelListener { func() }
    }



    fun create(): AlertDialog {
        title.goneIfTextEmpty()
        message.goneIfTextEmpty()
        positiveButton.goneIfTextEmpty()
        negativeButton.goneIfTextEmpty()

        dialog = builder
            .setCancelable(cancelable)
            .create()
        return dialog!!
    }

    private fun TextView.goneIfTextEmpty() {
        visibility = if (text.isNullOrEmpty()) {
            View.GONE
        } else {
            View.VISIBLE
        }
    }

    private fun TextView.setClickListenerToDialogButton(func: (() -> Unit)?) {
        setOnClickListener {
            func?.invoke()
            dialog?.dismiss()
        }
    }

}