package com.milkyway.gbusiness.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0001KB\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u000205H\u0002J\u0010\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u001aH\u0002J\u0010\u0010;\u001a\u0002052\u0006\u0010<\u001a\u00020\u0005H\u0016J&\u0010=\u001a\u0004\u0018\u0001072\u0006\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010A2\b\u0010B\u001a\u0004\u0018\u00010CH\u0017J\u001a\u0010D\u001a\u0002052\u0006\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010CH\u0016J\b\u0010H\u001a\u000205H\u0016J \u0010I\u001a\u00020J2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u001aH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001a\u0010\"\u001a\u00020\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001a\u0010%\u001a\u00020\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001c\"\u0004\b\'\u0010\u001eR\u001a\u0010(\u001a\u00020)X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020/X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103\u00a8\u0006L"}, d2 = {"Lcom/milkyway/gbusiness/fragments/PaymentStatusFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/milkyway/gbusiness/firebaseimpl/RazorpayResultReceiver$AppReceiver;", "()V", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "payStatusDateTime", "Landroid/widget/TextView;", "getPayStatusDateTime", "()Landroid/widget/TextView;", "setPayStatusDateTime", "(Landroid/widget/TextView;)V", "payStatusInvoiceId", "getPayStatusInvoiceId", "setPayStatusInvoiceId", "payStatusOrderId", "getPayStatusOrderId", "setPayStatusOrderId", "payStatusPayAmount", "getPayStatusPayAmount", "setPayStatusPayAmount", "paymentMode", "", "getPaymentMode", "()Ljava/lang/String;", "setPaymentMode", "(Ljava/lang/String;)V", "razorpayOrderId", "getRazorpayOrderId", "setRazorpayOrderId", "razorpayPaymentId", "getRazorpayPaymentId", "setRazorpayPaymentId", "razorpaySignature", "getRazorpaySignature", "setRazorpaySignature", "resultReceiver", "Lcom/milkyway/gbusiness/firebaseimpl/RazorpayResultReceiver;", "getResultReceiver", "()Lcom/milkyway/gbusiness/firebaseimpl/RazorpayResultReceiver;", "setResultReceiver", "(Lcom/milkyway/gbusiness/firebaseimpl/RazorpayResultReceiver;)V", "successImage", "Landroid/widget/ImageView;", "getSuccessImage", "()Landroid/widget/ImageView;", "setSuccessImage", "(Landroid/widget/ImageView;)V", "animation", "", "view", "Landroid/view/View;", "dummyUpdater", "getInvoiceID", "payID", "onAttach", "context", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onReceiveResult", "resultCode", "", "resultData", "onStop", "verifySignature", "", "Companion", "app_debug"})
public final class PaymentStatusFragment extends androidx.fragment.app.Fragment implements com.milkyway.gbusiness.firebaseimpl.RazorpayResultReceiver.AppReceiver {
    public android.widget.TextView payStatusInvoiceId;
    public android.widget.TextView payStatusOrderId;
    public android.widget.TextView payStatusDateTime;
    public android.widget.TextView payStatusPayAmount;
    public android.widget.ImageView successImage;
    public android.content.Context mContext;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String razorpayPaymentId = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String razorpayOrderId = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String razorpaySignature = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String paymentMode = "";
    public com.milkyway.gbusiness.firebaseimpl.RazorpayResultReceiver resultReceiver;
    @org.jetbrains.annotations.NotNull()
    public static final com.milkyway.gbusiness.fragments.PaymentStatusFragment.Companion Companion = null;
    public static android.widget.TextView payStatusResult;
    private java.util.HashMap _$_findViewCache;
    
    public PaymentStatusFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getPayStatusInvoiceId() {
        return null;
    }
    
    public final void setPayStatusInvoiceId(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getPayStatusOrderId() {
        return null;
    }
    
    public final void setPayStatusOrderId(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getPayStatusDateTime() {
        return null;
    }
    
    public final void setPayStatusDateTime(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getPayStatusPayAmount() {
        return null;
    }
    
    public final void setPayStatusPayAmount(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getSuccessImage() {
        return null;
    }
    
    public final void setSuccessImage(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRazorpayPaymentId() {
        return null;
    }
    
    public final void setRazorpayPaymentId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRazorpayOrderId() {
        return null;
    }
    
    public final void setRazorpayOrderId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRazorpaySignature() {
        return null;
    }
    
    public final void setRazorpaySignature(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPaymentMode() {
        return null;
    }
    
    public final void setPaymentMode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.firebaseimpl.RazorpayResultReceiver getResultReceiver() {
        return null;
    }
    
    public final void setResultReceiver(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.firebaseimpl.RazorpayResultReceiver p0) {
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final boolean verifySignature(java.lang.String razorpayOrderId, java.lang.String razorpayPaymentId, java.lang.String razorpaySignature) {
        return false;
    }
    
    private final void dummyUpdater() {
    }
    
    private final void animation(android.view.View view) {
    }
    
    private final java.lang.String getInvoiceID(java.lang.String payID) {
        return null;
    }
    
    @java.lang.Override()
    public void onReceiveResult(int resultCode, @org.jetbrains.annotations.Nullable()
    android.os.Bundle resultData) {
    }
    
    @java.lang.Override()
    public void onStop() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/milkyway/gbusiness/fragments/PaymentStatusFragment$Companion;", "", "()V", "payStatusResult", "Landroid/widget/TextView;", "getPayStatusResult", "()Landroid/widget/TextView;", "setPayStatusResult", "(Landroid/widget/TextView;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getPayStatusResult() {
            return null;
        }
        
        public final void setPayStatusResult(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
    }
}