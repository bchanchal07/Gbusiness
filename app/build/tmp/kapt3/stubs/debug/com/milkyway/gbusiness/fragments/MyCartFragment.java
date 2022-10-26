package com.milkyway.gbusiness.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J0\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020!2\u0006\u0010\'\u001a\u00020!H\u0002J\b\u0010(\u001a\u00020\u001fH\u0002J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\rH\u0016J0\u0010+\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020!2\u0006\u0010\'\u001a\u00020!H\u0016J&\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u000103H\u0016R.\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2 = {"Lcom/milkyway/gbusiness/fragments/MyCartFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/milkyway/gbusiness/api/OnAdpterClick;", "()V", "array", "Ljava/util/ArrayList;", "Lcom/milkyway/gbusiness/models/DataXXXXXX;", "Lkotlin/collections/ArrayList;", "getArray", "()Ljava/util/ArrayList;", "setArray", "(Ljava/util/ArrayList;)V", "mContext", "Landroid/content/Context;", "myMyCartBack", "Landroid/widget/ImageView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "viewAdapter", "Lcom/milkyway/gbusiness/adaptor/MyCartFramentAdaptor;", "getViewAdapter", "()Lcom/milkyway/gbusiness/adaptor/MyCartFramentAdaptor;", "setViewAdapter", "(Lcom/milkyway/gbusiness/adaptor/MyCartFramentAdaptor;)V", "viewManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "OnClick", "", "cartId", "", "buyNow", "cart_id", "price", "domainName", "services", "currency", "getCartApi", "onAttach", "context", "onClickBtn", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class MyCartFragment extends androidx.fragment.app.Fragment implements com.milkyway.gbusiness.api.OnAdpterClick {
    public com.milkyway.gbusiness.adaptor.MyCartFramentAdaptor viewAdapter;
    @org.jetbrains.annotations.Nullable()
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private android.widget.ImageView myMyCartBack;
    @org.jetbrains.annotations.Nullable()
    private java.util.ArrayList<com.milkyway.gbusiness.models.DataXXXXXX> array;
    private androidx.recyclerview.widget.RecyclerView.LayoutManager viewManager;
    private android.content.Context mContext;
    private java.util.HashMap _$_findViewCache;
    
    public MyCartFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.adaptor.MyCartFramentAdaptor getViewAdapter() {
        return null;
    }
    
    public final void setViewAdapter(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.adaptor.MyCartFramentAdaptor p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.recyclerview.widget.RecyclerView getRecyclerView() {
        return null;
    }
    
    public final void setRecyclerView(@org.jetbrains.annotations.Nullable()
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<com.milkyway.gbusiness.models.DataXXXXXX> getArray() {
        return null;
    }
    
    public final void setArray(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.milkyway.gbusiness.models.DataXXXXXX> p0) {
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
    
    private final void getCartApi() {
    }
    
    @java.lang.Override()
    public void OnClick(@org.jetbrains.annotations.NotNull()
    java.lang.String cartId) {
    }
    
    @java.lang.Override()
    public void onClickBtn(@org.jetbrains.annotations.NotNull()
    java.lang.String cart_id, @org.jetbrains.annotations.NotNull()
    java.lang.String price, @org.jetbrains.annotations.NotNull()
    java.lang.String domainName, @org.jetbrains.annotations.NotNull()
    java.lang.String services, @org.jetbrains.annotations.NotNull()
    java.lang.String currency) {
    }
    
    private final void buyNow(java.lang.String cart_id, java.lang.String price, java.lang.String domainName, java.lang.String services, java.lang.String currency) {
    }
}