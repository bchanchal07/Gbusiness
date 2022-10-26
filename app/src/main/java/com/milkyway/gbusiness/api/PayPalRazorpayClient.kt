package com.milkyway.gbusiness.api

import com.milkyway.gbusiness.models.PayPalAccessToken
import com.milkyway.gbusiness.models.RazorTransCaptureResponse
import com.milkyway.gbusiness.models.RazorTransDetailsDataClass
import io.reactivex.Single
import retrofit2.http.*


interface PayPalRazorpayClient
{
    @FormUrlEncoded
    @POST("/v1/oauth2/token")
    fun getAccessToken(
        @Header("Authorization") credentials: String,
        @Field("grant_type") grantType: String
    ): Single<PayPalAccessToken>


    @FormUrlEncoded
    @POST("capture")
    fun getRazorpayCaptureStatus(
        @Header("Authorization") credentials: String,
        @Field("amount") amount: String,
        @Field("currency") currency: String
    ): Single<RazorTransCaptureResponse>

    @FormUrlEncoded
    @POST("capture")
    fun getTransForRazorToken(
        @Header("Authorization") credentials: String,
        @Field("amount") grantType: String,
        @Field("currency") currency: String
    ): Single<RazorTransDetailsDataClass>
}