package com.milkyway.gbusiness.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/milkyway/gbusiness/api/GalleryService;", "", "()V", "BASE_URL", "", "client", "Lokhttp3/OkHttpClient;", "getClient", "()Lokhttp3/OkHttpClient;", "gsonConverter", "Lretrofit2/converter/gson/GsonConverterFactory;", "getGsonConverter", "()Lretrofit2/converter/gson/GsonConverterFactory;", "mClient", "mGsonConverter", "create", "Lcom/milkyway/gbusiness/retrofit/ApiCall;", "app_debug"})
public final class GalleryService {
    @org.jetbrains.annotations.NotNull()
    public static final com.milkyway.gbusiness.api.GalleryService INSTANCE = null;
    private static final java.lang.String BASE_URL = "https://api.unsplash.com/";
    private static okhttp3.OkHttpClient mClient;
    private static retrofit2.converter.gson.GsonConverterFactory mGsonConverter;
    
    private GalleryService() {
        super();
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
    public final com.milkyway.gbusiness.retrofit.ApiCall create() {
        return null;
    }
}