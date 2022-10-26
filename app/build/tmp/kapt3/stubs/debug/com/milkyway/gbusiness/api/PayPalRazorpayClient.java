package com.milkyway.gbusiness.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\'J,\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u0006H\'J,\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u0006H\'\u00a8\u0006\u000e"}, d2 = {"Lcom/milkyway/gbusiness/api/PayPalRazorpayClient;", "", "getAccessToken", "Lio/reactivex/Single;", "Lcom/milkyway/gbusiness/models/PayPalAccessToken;", "credentials", "", "grantType", "getRazorpayCaptureStatus", "Lcom/milkyway/gbusiness/models/RazorTransCaptureResponse;", "amount", "currency", "getTransForRazorToken", "Lcom/milkyway/gbusiness/models/RazorTransDetailsDataClass;", "app_debug"})
public abstract interface PayPalRazorpayClient {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "/v1/oauth2/token")
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Single<com.milkyway.gbusiness.models.PayPalAccessToken> getAccessToken(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String credentials, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "grant_type")
    java.lang.String grantType);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "capture")
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Single<com.milkyway.gbusiness.models.RazorTransCaptureResponse> getRazorpayCaptureStatus(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String credentials, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "amount")
    java.lang.String amount, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "currency")
    java.lang.String currency);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "capture")
    @retrofit2.http.FormUrlEncoded()
    public abstract io.reactivex.Single<com.milkyway.gbusiness.models.RazorTransDetailsDataClass> getTransForRazorToken(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String credentials, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "amount")
    java.lang.String grantType, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "currency")
    java.lang.String currency);
}