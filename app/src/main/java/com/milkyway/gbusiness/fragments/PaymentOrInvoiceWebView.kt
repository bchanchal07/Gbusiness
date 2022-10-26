package com.milkyway.gbusiness.fragments


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.milkyway.gbusiness.R
import com.pawegio.kandroid.hide


class PaymentOrInvoiceWebView : Fragment() {

    private lateinit var webView: WebView
    private lateinit var ivWebBrowser: ImageView
    private lateinit var mProgressBar: ProgressBar
    private lateinit var mContext: Context
    private lateinit var invoiceUrl: String

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context

    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val view = inflater.inflate(R.layout.fragment_payment_or_invoice_web_view, container, false)
        mProgressBar = view.findViewById(R.id.paymentorInvoicePbar)

        val webURL = arguments?.getString("webUrl")
        val invoiceId = arguments?.getInt("invoiceId")
        invoiceUrl = "https://client.gbusiness.co/viewinvoice.php?id=$invoiceId"
        val back = arguments?.getString("back")
        val fromWhere = arguments?.getString("fromWhere")

        webView = view.findViewById(R.id.payAndInvoiceWewView)
        ivWebBrowser = view.findViewById(R.id.ivWebBrowser)
        view.findViewById<ImageView>(R.id.myMySitePreviewBack).setOnClickListener { goBack(back) }

        val settings = webView.settings;

        settings.javaScriptEnabled = true
        // Enable zooming in web view
        settings.setSupportZoom(true)
        settings.builtInZoomControls = true
        settings.displayZoomControls = true
        // Enable disable images in web view
        settings.blockNetworkImage = false
        // Whether the WebView should load image resources
        settings.loadsImagesAutomatically = true
        // More web view settings
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            settings.safeBrowsingEnabled = true  // api 26
        }
        //settings.pluginState = WebSettings.PluginState.ON
        settings.useWideViewPort = true
        settings.loadWithOverviewMode = true
        settings.javaScriptCanOpenWindowsAutomatically = true
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            settings.mediaPlaybackRequiresUserGesture = false
        }

        // More optional settings, you can enable it by yourself
        settings.domStorageEnabled = true
        settings.setSupportMultipleWindows(true)
        settings.loadWithOverviewMode = true
        settings.allowContentAccess = true
        settings.setGeolocationEnabled(true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            settings.allowUniversalAccessFromFileURLs = true
        }

        settings.allowFileAccess = true

        // WebView settings
        webView.fitsSystemWindows = true
        webView.setLayerType(View.LAYER_TYPE_HARDWARE, null)
        webView.webViewClient = MyWebViewClient(mContext, mProgressBar, invoiceUrl, ivWebBrowser)
        if (webURL != null) {
            webView.loadUrl(webURL)
        }

        /*ivWebBrowser.setOnClickListener {
            if (webURL.contentEquals("https://client.gbusiness.co/clientarea.php")) {
                openWebPage(invoiceUrl)
            } else {
                openWebPage(webURL)
            }
        }*/
        return view
    }

    private fun openWebPage(url: String?) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    private fun goBack(back: String?) {
        val args = arguments
        when {
            back.equals("MySiteFragment") -> findNavController().navigate(R.id.paymentOrInvoiceWebView_to_mySiteFragment)
            back.equals("ProfileConfigration") -> findNavController().navigate(R.id.paymentOrInvoiceWebView_to_profileFragment)
            back.equals("BusinessListingFragment") -> findNavController().navigate(R.id.paymentOrInvoiceWebView_to_myBusinessListingFragment)
            back.equals("BusinessListingDetailsFragment") -> findNavController().navigate(R.id.paymentOrInvoiceWebView_to_myBusinessListingDetailsFragment,args)
            back.equals("SubDomainWebsiteFragment") -> findNavController().navigate(R.id.paymentOrInvoiceWebView_to_subDomainWebsiteFragment,args)
            back!!.contains("BusinessCatDetailsFragment") -> findNavController().navigate(R.id.paymentOrInvoiceWebView_to_myCategoryDetailsFragment)
            back!!.contains("DomainOrderFragment") -> findNavController().navigate(R.id.paymentOrInvoiceWebView_to_myOrderFragment)
            else -> findNavController().navigate(R.id.paymentOrInvoiceWebView_to_paymentORInvoice2)
        }

    }

    class MyWebViewClient internal constructor(
        private val activity: Context,
        private val mProgressBar: ProgressBar,
        private val invoiceUrl: String,
        private val ivWebBrowser: ImageView,
    ) : WebViewClient() {

        /*@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            val url: String = request?.url.toString();
            view?.loadUrl(url)
            return true
        }*/

        override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {
            ivWebBrowser.setOnClickListener {
                if (url.contentEquals("https://client.gbusiness.co/clientarea.php")) {
                    openWebPage(invoiceUrl)
                } else {
                    openWebPage(url)
                }
            }
            if (url.contentEquals("https://client.gbusiness.co/clientarea.php")) {
                webView.loadUrl(invoiceUrl)
                return true
            }
            return false
        }

        private fun openWebPage(url: String) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            activity.startActivity(intent)
        }

        override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError) {
            Toast.makeText(activity, "Got Error! $error", Toast.LENGTH_SHORT).show()
        }

        override fun onPageFinished(view: WebView?, url: String?) {

            if (mProgressBar != null)
                mProgressBar.hide()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (mProgressBar != null)
            mProgressBar.hide()

    }
}


