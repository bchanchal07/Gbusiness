package com.milkyway.gbusiness.retrofit

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.milkyway.gbusiness.activities.LoginActivity
import com.milkyway.gbusiness.api.UnsafeOkHttpClient
import com.milkyway.gbusiness.global.CommonUtil
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

object GbusinessService {

    const val BASE_IMG_URL = "https://www.gbusiness.co/public/business_images/"
    const val STEP_ONE_ITEM_BASE_IMG_URL = "https://www.gbusiness.co/public/user/pmethod_image/"
    const val STEP_TWO_ITEM_BASE_IMG_URL = "https://www.gbusiness.co/public/user/gallery/files/"
    const val BASE_SUB_CAT_IMG_URL = "https://www.gbusiness.co/public/subcategory-image/"
    const val BASE_PAYMENT_IMG_URL = "https://www.gbusiness.co/public/user/pmethod_image/"
    const val BASE_GALLERY_IMG_URL = "https://www.gbusiness.co/public/user/gallery/files/"
    private const val BASE_URL = "https://www.gbusiness.co/api/"
    val unsafeOkHttpClient = UnsafeOkHttpClient.unsafeOkHttpClient
    private val okHttpClient: OkHttpClient? = null

    private const val REQUEST_TIMEOUT = 30000


    ///////////////////////////////////////////
    private var mClient: OkHttpClient? = null
    private var mGsonConverter: GsonConverterFactory? = null

    /**
     * Don't forget to remove Interceptors (or change Logging Level to NONE)
     * in production! Otherwise people will be able to see your request and response on Log Cat.
     */
    val client: OkHttpClient
        @Throws(NoSuchAlgorithmException::class, KeyManagementException::class)
        get() {
            if (mClient == null) {
                val interceptor = HttpLoggingInterceptor()
                interceptor.level = HttpLoggingInterceptor.Level.BODY

                val httpBuilder = OkHttpClient.Builder()
                httpBuilder
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(20, TimeUnit.SECONDS)
                    .addInterceptor(interceptor)  /// show all JSON in logCat
                mClient = httpBuilder.build()

            }
            return mClient!!
        }


    val gsonConverter: GsonConverterFactory
        get() {
            if (mGsonConverter == null) {
                mGsonConverter = GsonConverterFactory
                    .create(
                        GsonBuilder()
                            .setLenient()
                            .disableHtmlEscaping()
                            .create())
            }
            return mGsonConverter!!
        }

    interface OnConnectionTimeoutListener {
        fun onConnectionTimeout()
    }

    fun create(context: Context): ApiCall {
        if (okHttpClient == null)
            initCallOkHttp(context)
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(gsonConverter)
            .client(client)
            .build()

        return retrofit.create(ApiCall::class.java)
    }


    fun initCallOkHttp(context: Context) {
        val httpClient = OkHttpClient().newBuilder()
            .connectTimeout(30, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.MINUTES)
            .writeTimeout(30, TimeUnit.MINUTES);

        httpClient.addInterceptor(Interceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
                .addHeader("Authorization", (if (CommonUtil.getPreferencesString(context,AppConstants.TOKEN) != null) CommonUtil.getPreferencesString(context,AppConstants.TOKEN) else "").toString())
//                .addHeader("Content-Type", "application/json;charset=UTF-8")
            val request = requestBuilder.build()
            val response = chain.proceed(request)
            if (response.message == "Token has been expired") {
                CommonUtil.ClearSession(context)
                logoutScreen(context)
                return@Interceptor response
            }
            response
        })

       /* httpClient.sslSocketFactory(getUnsafeOkHttpClient(), trustAllCerts.get(0) as X509TrustManager)
        httpClient.hostnameVerifier { hostname, session ->
            if (BASE_URL.contains(hostname)) {
                true
            } else {
                true
            }
        }
        okHttpClient*/
    }

    private fun logoutScreen(context: Context) {
        val mainIntent = Intent(context, LoginActivity::class.java)
        mainIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        context.applicationContext.startActivity(mainIntent)
        (context as Activity).finish()
    }

    var trustAllCerts = arrayOf<TrustManager>(
        object : X509TrustManager {
            @Throws(CertificateException::class)
            override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {  return }
            @Throws(CertificateException::class)
            override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) { return }
            override fun getAcceptedIssuers(): Array<X509Certificate> { return arrayOf() }
        }
    )

    fun getUnsafeOkHttpClient(): SSLSocketFactory {
        return try {
            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, SecureRandom())
            // Create an ssl socket factory with our all-trusting manager
            sslContext.socketFactory
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

}