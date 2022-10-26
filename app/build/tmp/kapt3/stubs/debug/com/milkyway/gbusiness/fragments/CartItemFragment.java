package com.milkyway.gbusiness.fragments;

import java.lang.System;

/**
 * A simple [Fragment] subclass.
 * Use the [CartItemFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\tH\u0016J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u001e\u001a\u00020\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J&\u0010!\u001a\u0004\u0018\u00010\u00172\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010&\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/milkyway/gbusiness/fragments/CartItemFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/milkyway/gbusiness/adaptor/DomainCartItemAdapter$OnDomainListAdaptorClick;", "()V", "ivEmptyCart", "Landroid/widget/ImageView;", "layoutEmptyCart", "Landroidx/appcompat/widget/LinearLayoutCompat;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "myCartItemBack", "rvCartItem", "Landroidx/recyclerview/widget/RecyclerView;", "callAlertDialog", "", "list", "Lcom/milkyway/gbusiness/models/SearchDomainDataDetailsClass$DomainList;", "initializeViews", "view", "Landroid/view/View;", "onAttach", "context", "onBtnClickedCheckoutCart", "pos", "", "onBtnClickedRemoveFromCart", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setCartItemAdapter", "app_debug"})
public final class CartItemFragment extends androidx.fragment.app.Fragment implements com.milkyway.gbusiness.adaptor.DomainCartItemAdapter.OnDomainListAdaptorClick {
    private android.widget.ImageView myCartItemBack;
    public android.content.Context mContext;
    private androidx.recyclerview.widget.RecyclerView rvCartItem;
    private android.widget.ImageView ivEmptyCart;
    private androidx.appcompat.widget.LinearLayoutCompat layoutEmptyCart;
    private java.util.HashMap _$_findViewCache;
    
    public CartItemFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
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
    
    private final void initializeViews(android.view.View view) {
    }
    
    private final void setCartItemAdapter() {
    }
    
    @java.lang.Override()
    public void onBtnClickedRemoveFromCart(int pos, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.SearchDomainDataDetailsClass.DomainList list) {
    }
    
    private final void callAlertDialog(com.milkyway.gbusiness.models.SearchDomainDataDetailsClass.DomainList list) {
    }
    
    @java.lang.Override()
    public void onBtnClickedCheckoutCart(int pos, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.SearchDomainDataDetailsClass.DomainList list) {
    }
}