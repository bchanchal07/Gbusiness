package com.milkyway.gbusiness.api

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.milkyway.gbusiness.retrofit.ApiCall
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.util.concurrent.TimeUnit

object GBusinessServiceSecond {


    const val BASE_IMG_URL = "https://www.gbusiness.co/public/business_images/"
    private const val BASE_URL = "https://www.gbusiness.co/api/user/"
    val okHttpClient = UnsafeOkHttpClient.unsafeOkHttpClient
    private var mClient: OkHttpClient? = null
    private var mGsonConverter: GsonConverterFactory? = null

    /**
     * Don't forget to remove Interceptors (or change Logging Level to NONE)
     * in production! Otherwise people will be able to see your request and response on Log Cat.
     */
    private val client: OkHttpClient
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


    private val gsonConverter: GsonConverterFactory
        get() {
            if (mGsonConverter == null) {
                mGsonConverter = GsonConverterFactory
                    .create(
                        GsonBuilder()
                            .setLenient()
                            .disableHtmlEscaping()
                            .create()
                    )
            }
            return mGsonConverter!!
        }

    fun create(): ApiCall {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(gsonConverter)
            .client(client)
            .build()

        return retrofit.create(ApiCall::class.java)
    }
}