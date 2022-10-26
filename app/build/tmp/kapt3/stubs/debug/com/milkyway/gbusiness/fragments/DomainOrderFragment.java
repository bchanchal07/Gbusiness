package com.milkyway.gbusiness.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$H\u0002J\"\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\'2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u000fH\u0016J&\u0010-\u001a\u0004\u0018\u00010$2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u0016\u00104\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u00105\u001a\u00020 H\u0002J\u0018\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\'2\u0006\u00108\u001a\u00020\'H\u0016J\u001a\u00109\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\'2\b\u0010:\u001a\u0004\u0018\u000103H\u0016J\u0016\u0010;\u001a\u00020\u001e2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0010\u0010=\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0016\u0010>\u001a\u00020\u001e2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006@"}, d2 = {"Lcom/milkyway/gbusiness/fragments/DomainOrderFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/milkyway/gbusiness/adaptor/DomainOrderAdapter$OnInvoiceViewClick;", "Lcom/milkyway/gbusiness/firebaseimpl/RazorpayResultReceiver$AppReceiver;", "()V", "clearQueryImageView", "Landroid/widget/ImageView;", "domainAdapter", "Lcom/milkyway/gbusiness/adaptor/DomainOrderAdapter;", "domainOrderDataList", "", "Lcom/milkyway/gbusiness/models/DomainOrderResponse$Orders$Order;", "etSearch", "Landroidx/appcompat/widget/AppCompatEditText;", "mContext", "Landroid/content/Context;", "myMyOrderBack", "noSearchResultsFoundText", "Landroid/widget/TextView;", "recyclerViewOrder", "Landroidx/recyclerview/widget/RecyclerView;", "resultReceiver", "Lcom/milkyway/gbusiness/firebaseimpl/RazorpayResultReceiver;", "getResultReceiver", "()Lcom/milkyway/gbusiness/firebaseimpl/RazorpayResultReceiver;", "setResultReceiver", "(Lcom/milkyway/gbusiness/firebaseimpl/RazorpayResultReceiver;)V", "searchEditText", "voiceSearchImageView", "filterWithQuery", "", "query", "", "getDomainOrderListApi", "initializeViews", "view", "Landroid/view/View;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onFilterChanged", "filterQuery", "onItemClicked", "position", "invoiceId", "onReceiveResult", "resultData", "setDomainAdapter", "dataList", "toggleImageView", "toggleRecyclerView", "filteredList", "app_debug"})
public final class DomainOrderFragment extends androidx.fragment.app.Fragment implements com.milkyway.gbusiness.adaptor.DomainOrderAdapter.OnInvoiceViewClick, com.milkyway.gbusiness.firebaseimpl.RazorpayResultReceiver.AppReceiver {
    private com.milkyway.gbusiness.adaptor.DomainOrderAdapter domainAdapter;
    private androidx.recyclerview.widget.RecyclerView recyclerViewOrder;
    private android.content.Context mContext;
    private android.widget.ImageView myMyOrderBack;
    private androidx.appcompat.widget.AppCompatEditText etSearch;
    private android.widget.TextView noSearchResultsFoundText;
    private android.widget.TextView searchEditText;
    private android.widget.ImageView clearQueryImageView;
    private android.widget.ImageView voiceSearchImageView;
    private java.util.List<com.milkyway.gbusiness.models.DomainOrderResponse.Orders.Order> domainOrderDataList;
    public com.milkyway.gbusiness.firebaseimpl.RazorpayResultReceiver resultReceiver;
    private java.util.HashMap _$_findViewCache;
    
    public DomainOrderFragment() {
        super();
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
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void initializeViews(android.view.View view) {
    }
    
    private final void toggleImageView(java.lang.String query) {
    }
    
    private final void filterWithQuery(java.lang.String query) {
    }
    
    private final void toggleRecyclerView(java.util.List<com.milkyway.gbusiness.models.DomainOrderResponse.Orders.Order> filteredList) {
    }
    
    private final java.util.List<com.milkyway.gbusiness.models.DomainOrderResponse.Orders.Order> onFilterChanged(java.lang.String filterQuery) {
        return null;
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void getDomainOrderListApi() {
    }
    
    private final void setDomainAdapter(java.util.List<com.milkyway.gbusiness.models.DomainOrderResponse.Orders.Order> dataList) {
    }
    
    @java.lang.Override()
    public void onItemClicked(int position, int invoiceId) {
    }
    
    @java.lang.Override()
    public void onReceiveResult(int resultCode, @org.jetbrains.annotations.Nullable()
    android.os.Bundle resultData) {
    }
}