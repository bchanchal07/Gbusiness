package com.milkyway.gbusiness.firebaseimpl;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0012\u0010\u001b\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0015R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001e"}, d2 = {"Lcom/milkyway/gbusiness/firebaseimpl/AutoLoginService;", "Landroid/app/IntentService;", "()V", "invoiceId", "", "getInvoiceId", "()Ljava/lang/Integer;", "setInvoiceId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "receiver", "Landroid/os/ResultReceiver;", "getReceiver", "()Landroid/os/ResultReceiver;", "setReceiver", "(Landroid/os/ResultReceiver;)V", "initRetrofitRazor", "Lcom/milkyway/gbusiness/retrofit/ApiCall;", "onCreate", "", "onDestroy", "onHandleIntent", "intent", "Landroid/content/Intent;", "app_debug"})
public final class AutoLoginService extends android.app.IntentService {
    @org.jetbrains.annotations.NotNull()
    private android.content.Context mContext;
    @org.jetbrains.annotations.Nullable()
    private android.os.ResultReceiver receiver;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer invoiceId;
    
    public AutoLoginService() {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.os.ResultReceiver getReceiver() {
        return null;
    }
    
    public final void setReceiver(@org.jetbrains.annotations.Nullable()
    android.os.ResultReceiver p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getInvoiceId() {
        return null;
    }
    
    public final void setInvoiceId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @android.annotation.SuppressLint(value = {"CheckResult"})
    @java.lang.Override()
    protected void onHandleIntent(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
    }
    
    private final com.milkyway.gbusiness.retrofit.ApiCall initRetrofitRazor() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
}