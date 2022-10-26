package com.milkyway.gbusiness.firebaseimpl;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0004J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0012\u0010\u001b\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b\u00a8\u0006\u001e"}, d2 = {"Lcom/milkyway/gbusiness/firebaseimpl/PayPalPaymentService;", "Landroid/app/IntentService;", "()V", "invoice", "", "getInvoice", "()Ljava/lang/String;", "setInvoice", "(Ljava/lang/String;)V", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "orderId", "getOrderId", "setOrderId", "payID", "getPayID", "setPayID", "delRealmDetails", "", "getTransationDetails", "accessToken", "initRetrofit", "Lcom/milkyway/gbusiness/api/PayPalRazorpayClient;", "onHandleIntent", "intent", "Landroid/content/Intent;", "app_debug"})
public final class PayPalPaymentService extends android.app.IntentService {
    public java.lang.String payID;
    public java.lang.String invoice;
    public java.lang.String orderId;
    @org.jetbrains.annotations.NotNull()
    private android.content.Context mContext;
    
    public PayPalPaymentService() {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPayID() {
        return null;
    }
    
    public final void setPayID(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getInvoice() {
        return null;
    }
    
    public final void setInvoice(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOrderId() {
        return null;
    }
    
    public final void setOrderId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @java.lang.Override()
    protected void onHandleIntent(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
    }
    
    private final com.milkyway.gbusiness.api.PayPalRazorpayClient initRetrofit() {
        return null;
    }
    
    private final void getTransationDetails(java.lang.String accessToken) {
    }
    
    public final void delRealmDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String payID) {
    }
}