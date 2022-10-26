package com.milkyway.gbusiness.fragments


import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi

import android.widget.ProgressBar
import androidx.navigation.findNavController
import com.milkyway.gbusiness.R
import com.pawegio.kandroid.hide


class CCavanuPaymentWebview : Fragment() {

    lateinit var mContext : Context
    lateinit var mProgressBar : ProgressBar

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View?
    {

        val view =  inflater.inflate(R.layout.fragment_ccavanu_payment_webview, container, false)



        val load = arguments?.getString("webs")
        Log.i("dfjkdjk","dd"+load)

        var webview = view.findViewById<WebView>(R.id.ccavanuPayWewView)
        mProgressBar = view.findViewById(R.id.ccavanuProgressbar)
         view.findViewById<ImageView>(R.id.myccavanuBack).setOnClickListener { view.findNavController().navigate(R.id.CCavanuPaymentWebview_to_mainFragment) }

        webview.webViewClient = MyWebViewClientccavenu(mContext,mProgressBar)

        webview.loadUrl(load!!)
        webview.settings.javaScriptEnabled = true

        return view
    }


    class MyWebViewClientccavenu internal constructor(
        private val activity: Context,
       val mProgressBar: ProgressBar
    ) : WebViewClient() {

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            val url: String = request?.url.toString();
            view?.loadUrl(url)
            return true
        }

        override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {
            webView.loadUrl(url)
            return true
        }

        override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError) {
            Toast.makeText(activity, "Got Error! $error", Toast.LENGTH_SHORT).show()
        }

        override fun onPageFinished(view: WebView?, url: String?) {

            if(mProgressBar!=null) mProgressBar.hide()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if(mProgressBar!=null) mProgressBar.hide()

    }
}
