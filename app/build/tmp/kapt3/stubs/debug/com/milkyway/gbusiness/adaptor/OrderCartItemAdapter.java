package com.milkyway.gbusiness.adaptor;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cB#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\b\b\u0001\u0010\u0014\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0002H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/milkyway/gbusiness/adaptor/OrderCartItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/milkyway/gbusiness/adaptor/OrderCartItemAdapter$SearchDomainViewHolder;", "mCtx", "Landroid/content/Context;", "domainList", "", "Lcom/milkyway/gbusiness/models/SearchDomainDataDetailsClass$DomainList;", "listner", "Lcom/milkyway/gbusiness/adaptor/OrderCartItemAdapter$OnOrderListAdaptorClick;", "(Landroid/content/Context;Ljava/util/List;Lcom/milkyway/gbusiness/adaptor/OrderCartItemAdapter$OnOrderListAdaptorClick;)V", "getListner", "()Lcom/milkyway/gbusiness/adaptor/OrderCartItemAdapter$OnOrderListAdaptorClick;", "setListner", "(Lcom/milkyway/gbusiness/adaptor/OrderCartItemAdapter$OnOrderListAdaptorClick;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateCartData", "subscriptionYr", "OnOrderListAdaptorClick", "SearchDomainViewHolder", "app_debug"})
public final class OrderCartItemAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.milkyway.gbusiness.adaptor.OrderCartItemAdapter.SearchDomainViewHolder> {
    private android.content.Context mCtx;
    private java.util.List<com.milkyway.gbusiness.models.SearchDomainDataDetailsClass.DomainList> domainList;
    @org.jetbrains.annotations.NotNull()
    private com.milkyway.gbusiness.adaptor.OrderCartItemAdapter.OnOrderListAdaptorClick listner;
    
    public OrderCartItemAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context mCtx, @org.jetbrains.annotations.NotNull()
    java.util.List<com.milkyway.gbusiness.models.SearchDomainDataDetailsClass.DomainList> domainList, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.adaptor.OrderCartItemAdapter.OnOrderListAdaptorClick listner) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.adaptor.OrderCartItemAdapter.OnOrderListAdaptorClick getListner() {
        return null;
    }
    
    public final void setListner(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.adaptor.OrderCartItemAdapter.OnOrderListAdaptorClick p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.milkyway.gbusiness.adaptor.OrderCartItemAdapter.SearchDomainViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.adaptor.OrderCartItemAdapter.SearchDomainViewHolder holder, @android.annotation.SuppressLint(value = {"RecyclerView"})
    int position) {
    }
    
    private final void updateCartData(int subscriptionYr, com.milkyway.gbusiness.adaptor.OrderCartItemAdapter.SearchDomainViewHolder holder) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0004\u00a8\u0006\u0018"}, d2 = {"Lcom/milkyway/gbusiness/adaptor/OrderCartItemAdapter$SearchDomainViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "ivActionDelete", "Landroid/widget/ImageView;", "getIvActionDelete", "()Landroid/widget/ImageView;", "spinnerYrDuration", "Landroid/widget/Spinner;", "getSpinnerYrDuration", "()Landroid/widget/Spinner;", "tvServices", "Landroid/widget/TextView;", "getTvServices", "()Landroid/widget/TextView;", "tvTtlPrice", "getTvTtlPrice", "tvYearlyPrice", "getTvYearlyPrice", "getView", "()Landroid/view/View;", "setView", "app_debug"})
    public static final class SearchDomainViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.view.View view;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.Spinner spinnerYrDuration = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView ivActionDelete = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvServices = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvYearlyPrice = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvTtlPrice = null;
        
        public SearchDomainViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.view.View getView() {
            return null;
        }
        
        public final void setView(@org.jetbrains.annotations.NotNull()
        android.view.View p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.Spinner getSpinnerYrDuration() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getIvActionDelete() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvServices() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvYearlyPrice() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvTtlPrice() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&JS\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a2\u0006\u0002\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/milkyway/gbusiness/adaptor/OrderCartItemAdapter$OnOrderListAdaptorClick;", "", "onClickedDeleterOrder", "", "pos", "", "list", "Lcom/milkyway/gbusiness/models/SearchDomainDataDetailsClass$DomainList;", "onClickedSpinnerYear", "selectedText", "", "year", "", "clickedPosition", "posAdapter", "positionSpinner", "spinnerYrDuration", "Landroid/widget/Spinner;", "tvTtlPrice", "Landroid/widget/TextView;", "(Ljava/lang/String;[Ljava/lang/String;IIILandroid/widget/Spinner;Landroid/widget/TextView;Lcom/milkyway/gbusiness/models/SearchDomainDataDetailsClass$DomainList;)V", "app_debug"})
    public static abstract interface OnOrderListAdaptorClick {
        
        public abstract void onClickedDeleterOrder(int pos, @org.jetbrains.annotations.NotNull()
        com.milkyway.gbusiness.models.SearchDomainDataDetailsClass.DomainList list);
        
        public abstract void onClickedSpinnerYear(@org.jetbrains.annotations.NotNull()
        java.lang.String selectedText, @org.jetbrains.annotations.NotNull()
        java.lang.String[] year, int clickedPosition, int posAdapter, int positionSpinner, @org.jetbrains.annotations.NotNull()
        android.widget.Spinner spinnerYrDuration, @org.jetbrains.annotations.NotNull()
        android.widget.TextView tvTtlPrice, @org.jetbrains.annotations.NotNull()
        com.milkyway.gbusiness.models.SearchDomainDataDetailsClass.DomainList list);
    }
}