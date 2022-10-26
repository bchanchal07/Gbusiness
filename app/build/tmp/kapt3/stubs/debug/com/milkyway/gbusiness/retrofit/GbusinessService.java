package com.milkyway.gbusiness.retrofit;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001*B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\u0006\u0010!\u001a\u00020&J\u000e\u0010\'\u001a\u00020(2\u0006\u0010$\u001a\u00020%J\u0010\u0010)\u001a\u00020(2\u0006\u0010$\u001a\u00020%H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010 \u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0010\u00a8\u0006+"}, d2 = {"Lcom/milkyway/gbusiness/retrofit/GbusinessService;", "", "()V", "BASE_GALLERY_IMG_URL", "", "BASE_IMG_URL", "BASE_PAYMENT_IMG_URL", "BASE_SUB_CAT_IMG_URL", "BASE_URL", "REQUEST_TIMEOUT", "", "STEP_ONE_ITEM_BASE_IMG_URL", "STEP_TWO_ITEM_BASE_IMG_URL", "client", "Lokhttp3/OkHttpClient;", "getClient", "()Lokhttp3/OkHttpClient;", "gsonConverter", "Lretrofit2/converter/gson/GsonConverterFactory;", "getGsonConverter", "()Lretrofit2/converter/gson/GsonConverterFactory;", "mClient", "mGsonConverter", "okHttpClient", "trustAllCerts", "", "Ljavax/net/ssl/TrustManager;", "getTrustAllCerts", "()[Ljavax/net/ssl/TrustManager;", "setTrustAllCerts", "([Ljavax/net/ssl/TrustManager;)V", "[Ljavax/net/ssl/TrustManager;", "unsafeOkHttpClient", "getUnsafeOkHttpClient", "create", "Lcom/milkyway/gbusiness/retrofit/ApiCall;", "context", "Landroid/content/Context;", "Ljavax/net/ssl/SSLSocketFactory;", "initCallOkHttp", "", "logoutScreen", "OnConnectionTimeoutListener", "app_debug"})
public final class GbusinessService {
    @org.jetbrains.annotations.NotNull()
    public static final com.milkyway.gbusiness.retrofit.GbusinessService INSTANCE = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_IMG_URL = "https://www.gbusiness.co/public/business_images/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String STEP_ONE_ITEM_BASE_IMG_URL = "https://www.gbusiness.co/public/user/pmethod_image/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String STEP_TWO_ITEM_BASE_IMG_URL = "https://www.gbusiness.co/public/user/gallery/files/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_SUB_CAT_IMG_URL = "https://www.gbusiness.co/public/subcategory-image/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_PAYMENT_IMG_URL = "https://www.gbusiness.co/public/user/pmethod_image/";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BASE_GALLERY_IMG_URL = "https://www.gbusiness.co/public/user/gallery/files/";
    private static final java.lang.String BASE_URL = "https://www.gbusiness.co/api/";
    @org.jetbrains.annotations.NotNull()
    private static final okhttp3.OkHttpClient unsafeOkHttpClient = null;
    private static final okhttp3.OkHttpClient okHttpClient = null;
    private static final int REQUEST_TIMEOUT = 30000;
    private static okhttp3.OkHttpClient mClient;
    private static retrofit2.converter.gson.GsonConverterFactory mGsonConverter;
    @org.jetbrains.annotations.NotNull()
    private static javax.net.ssl.TrustManager[] trustAllCerts;
    
    private GbusinessService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.OkHttpClient getUnsafeOkHttpClient() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.Throws(exceptionClasses = {java.security.NoSuchAlgorithmException.class, java.security.KeyManagementException.class})
    public final okhttp3.OkHttpClient getClient() throws java.security.NoSuchAlgorithmException, java.security.KeyManagementException {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.converter.gson.GsonConverterFactory getGsonConverter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.retrofit.ApiCall create(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    public final void initCallOkHttp(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    private final void logoutScreen(android.content.Context context) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final javax.net.ssl.TrustManager[] getTrustAllCerts() {
        return null;
    }
    
    public final void setTrustAllCerts(@org.jetbrains.annotations.NotNull()
    javax.net.ssl.TrustManager[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final javax.net.ssl.SSLSocketFactory getUnsafeOkHttpClient() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/milkyway/gbusiness/retrofit/GbusinessService$OnConnectionTimeoutListener;", "", "onConnectionTimeout", "", "app_debug"})
    public static abstract interface OnConnectionTimeoutListener {
        
        public abstract void onConnectionTimeout();
    }
}