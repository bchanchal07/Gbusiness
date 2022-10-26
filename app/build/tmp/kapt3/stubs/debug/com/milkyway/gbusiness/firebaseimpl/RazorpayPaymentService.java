package com.milkyway.gbusiness.firebaseimpl;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nH\u0002J\u0012\u0010\u001e\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010#\u001a\u00020\u001cH\u0016J\b\u0010$\u001a\u00020\u001cH\u0016J\u0012\u0010%\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0015Jt\u0010(\u001a\u00020\u001c2\b\u0010)\u001a\u0004\u0018\u00010\n2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010\n2\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\nH\u0002J\b\u00106\u001a\u00020\u001cH\u0002Jz\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u00020\n2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010\n2\u0006\u0010-\u001a\u00020\n2\u0006\u0010.\u001a\u00020\n2\u0006\u00109\u001a\u00020\n2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\n2\u0006\u0010:\u001a\u00020\n2\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\nH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e\u00a8\u0006;"}, d2 = {"Lcom/milkyway/gbusiness/firebaseimpl/RazorpayPaymentService;", "Landroid/app/IntentService;", "()V", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "orderId", "", "getOrderId", "()Ljava/lang/String;", "setOrderId", "(Ljava/lang/String;)V", "payID", "getPayID", "setPayID", "receiver", "Landroid/os/ResultReceiver;", "getReceiver", "()Landroid/os/ResultReceiver;", "setReceiver", "(Landroid/os/ResultReceiver;)V", "successMsg", "getSuccessMsg", "setSuccessMsg", "delFromRealmDataBase", "", "payId", "getInfo", "myAmount", "Lcom/milkyway/gbusiness/models/RazorTransDetailsDataClass;", "initRetrofitRazor", "Lcom/milkyway/gbusiness/api/PayPalRazorpayClient;", "onCreate", "onDestroy", "onHandleIntent", "intent", "Landroid/content/Intent;", "startAplanForPayment", "userToken", "paymentID", "invoiceID", "userID", "captureStatus", "paymentID1", "bankRefNo", "capStatus", "type", "cardName", "amount", "createdAt", "description", "startBplanForPayment", "updateRealm", "s", "bank_ref_no", "s11", "app_debug"})
public final class RazorpayPaymentService extends android.app.IntentService {
    @org.jetbrains.annotations.NotNull()
    private android.content.Context mContext;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String payID = "dummy";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String orderId = "dummy";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String successMsg = "";
    @org.jetbrains.annotations.Nullable()
    private android.os.ResultReceiver receiver;
    
    public RazorpayPaymentService() {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPayID() {
        return null;
    }
    
    public final void setPayID(@org.jetbrains.annotations.NotNull()
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
    public final java.lang.String getSuccessMsg() {
        return null;
    }
    
    public final void setSuccessMsg(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.os.ResultReceiver getReceiver() {
        return null;
    }
    
    public final void setReceiver(@org.jetbrains.annotations.Nullable()
    android.os.ResultReceiver p0) {
    }
    
    @android.annotation.SuppressLint(value = {"CheckResult"})
    @java.lang.Override()
    protected void onHandleIntent(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
    }
    
    private final com.milkyway.gbusiness.api.PayPalRazorpayClient initRetrofitRazor(java.lang.String payID) {
        return null;
    }
    
    private final void getInfo(com.milkyway.gbusiness.models.RazorTransDetailsDataClass myAmount) {
    }
    
    private final void delFromRealmDataBase(java.lang.String payId) {
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    private final void updateRealm(java.lang.String s, java.lang.String paymentID, java.lang.String invoiceID, java.lang.String userID, java.lang.String captureStatus, java.lang.String paymentID1, java.lang.String bank_ref_no, java.lang.String capStatus, java.lang.String type, java.lang.String cardName, java.lang.String s11, java.lang.String amount, java.lang.String createdAt, java.lang.String description) {
    }
    
    private final void startAplanForPayment(java.lang.String userToken, java.lang.String paymentID, java.lang.String invoiceID, java.lang.String userID, java.lang.String captureStatus, java.lang.String paymentID1, java.lang.String bankRefNo, java.lang.String capStatus, java.lang.String type, java.lang.String cardName, java.lang.String amount, java.lang.String createdAt, java.lang.String description) {
    }
    
    private final void startBplanForPayment() {
    }
}