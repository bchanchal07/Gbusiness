package com.milkyway.gbusiness.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020*H\u0002J\u0010\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020\"H\u0016J&\u00101\u001a\u0004\u0018\u00010-2\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u00020*H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\"X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010\'\u001a\u00020(X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00069"}, d2 = {"Lcom/milkyway/gbusiness/fragments/DomainPriceDetail;", "Landroidx/fragment/app/Fragment;", "()V", "domainDetailDomainBuy", "Landroid/widget/TextView;", "getDomainDetailDomainBuy", "()Landroid/widget/TextView;", "setDomainDetailDomainBuy", "(Landroid/widget/TextView;)V", "domainDetailDomainNames", "getDomainDetailDomainNames", "setDomainDetailDomainNames", "domainDetailDomainPrices", "getDomainDetailDomainPrices", "setDomainDetailDomainPrices", "domainDetailOfferFive", "getDomainDetailOfferFive", "setDomainDetailOfferFive", "domainDetailOfferFour", "getDomainDetailOfferFour", "setDomainDetailOfferFour", "domainDetailOfferOne", "getDomainDetailOfferOne", "setDomainDetailOfferOne", "domainDetailOfferSix", "getDomainDetailOfferSix", "setDomainDetailOfferSix", "domainDetailOfferThree", "getDomainDetailOfferThree", "setDomainDetailOfferThree", "domainDetailOfferTwo", "getDomainDetailOfferTwo", "setDomainDetailOfferTwo", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "myDomainDetailsBack", "Landroid/widget/ImageView;", "buyNow", "", "initializeView", "view", "Landroid/view/View;", "insertData", "onAttach", "context", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStop", "app_debug"})
public final class DomainPriceDetail extends androidx.fragment.app.Fragment {
    public android.content.Context mContext;
    public android.widget.TextView domainDetailDomainNames;
    public android.widget.TextView domainDetailDomainPrices;
    public android.widget.TextView domainDetailOfferOne;
    public android.widget.TextView domainDetailOfferTwo;
    public android.widget.TextView domainDetailOfferThree;
    public android.widget.TextView domainDetailOfferFour;
    public android.widget.TextView domainDetailOfferFive;
    public android.widget.TextView domainDetailOfferSix;
    public android.widget.TextView domainDetailDomainBuy;
    private android.widget.ImageView myDomainDetailsBack;
    private java.util.HashMap _$_findViewCache;
    
    public DomainPriceDetail() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getDomainDetailDomainNames() {
        return null;
    }
    
    public final void setDomainDetailDomainNames(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getDomainDetailDomainPrices() {
        return null;
    }
    
    public final void setDomainDetailDomainPrices(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getDomainDetailOfferOne() {
        return null;
    }
    
    public final void setDomainDetailOfferOne(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getDomainDetailOfferTwo() {
        return null;
    }
    
    public final void setDomainDetailOfferTwo(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getDomainDetailOfferThree() {
        return null;
    }
    
    public final void setDomainDetailOfferThree(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getDomainDetailOfferFour() {
        return null;
    }
    
    public final void setDomainDetailOfferFour(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getDomainDetailOfferFive() {
        return null;
    }
    
    public final void setDomainDetailOfferFive(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getDomainDetailOfferSix() {
        return null;
    }
    
    public final void setDomainDetailOfferSix(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getDomainDetailDomainBuy() {
        return null;
    }
    
    public final void setDomainDetailDomainBuy(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
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
    
    private final void initializeView(android.view.View view) {
    }
    
    private final void insertData() {
    }
    
    private final void buyNow() {
    }
    
    @java.lang.Override()
    public void onStop() {
    }
}