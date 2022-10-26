package com.milkyway.gbusiness.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u000bH\u0016J\u0018\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020 H\u0016J&\u0010$\u001a\u0004\u0018\u00010\u00192\u0006\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0018\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020 H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/milkyway/gbusiness/fragments/PaymentORInvoice;", "Landroidx/fragment/app/Fragment;", "Lcom/milkyway/gbusiness/api/OnClickServices;", "()V", "Adopter", "Lcom/milkyway/gbusiness/fragments/PaymentORInvoiceAdoptor;", "getAdopter", "()Lcom/milkyway/gbusiness/fragments/PaymentORInvoiceAdoptor;", "setAdopter", "(Lcom/milkyway/gbusiness/fragments/PaymentORInvoiceAdoptor;)V", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "myPaymentInvoiceBack", "Landroid/widget/ImageView;", "recyclerViewEarning", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerViewEarning", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerViewEarning", "(Landroidx/recyclerview/widget/RecyclerView;)V", "root", "Landroid/view/View;", "getPaymentOrInvoiceApi", "", "onAttach", "context", "onClick", "id", "", "name", "onClickDownload", "webUrl", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "userDownload", "link", "tittle", "app_debug"})
public final class PaymentORInvoice extends androidx.fragment.app.Fragment implements com.milkyway.gbusiness.api.OnClickServices {
    public com.milkyway.gbusiness.fragments.PaymentORInvoiceAdoptor Adopter;
    @org.jetbrains.annotations.Nullable()
    private androidx.recyclerview.widget.RecyclerView recyclerViewEarning;
    public android.content.Context mContext;
    private android.widget.ImageView myPaymentInvoiceBack;
    private android.view.View root;
    private java.util.HashMap _$_findViewCache;
    
    public PaymentORInvoice() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.fragments.PaymentORInvoiceAdoptor getAdopter() {
        return null;
    }
    
    public final void setAdopter(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.fragments.PaymentORInvoiceAdoptor p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.recyclerview.widget.RecyclerView getRecyclerViewEarning() {
        return null;
    }
    
    public final void setRecyclerViewEarning(@org.jetbrains.annotations.Nullable()
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void getPaymentOrInvoiceApi() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
    
    @java.lang.Override()
    public void onClickDownload(@org.jetbrains.annotations.NotNull()
    java.lang.String webUrl) {
    }
    
    private final void userDownload(java.lang.String link, java.lang.String tittle) {
    }
    
    public void editSites(@org.jetbrains.annotations.NotNull()
    java.lang.String webUrl) {
    }
    
    public void nowPublishWebSite(@org.jetbrains.annotations.NotNull()
    java.lang.String templateID, @org.jetbrains.annotations.NotNull()
    java.lang.String domainId) {
    }
    
    public void nowUnPublishWebSite(@org.jetbrains.annotations.NotNull()
    java.lang.String projectId) {
    }
    
    public void onClickPublish(@org.jetbrains.annotations.NotNull()
    java.lang.String templateID, @org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
    
    public void onClickTrash(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
}