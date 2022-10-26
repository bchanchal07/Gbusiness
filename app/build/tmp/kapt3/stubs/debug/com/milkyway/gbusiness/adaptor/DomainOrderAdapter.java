package com.milkyway.gbusiness.adaptor;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0019\u001aB#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/milkyway/gbusiness/adaptor/DomainOrderAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/milkyway/gbusiness/adaptor/DomainOrderAdapter$MyViewHolder;", "context", "Landroid/content/Context;", "domainOrderList", "", "Lcom/milkyway/gbusiness/models/DomainOrderResponse$Orders$Order;", "listner", "Lcom/milkyway/gbusiness/adaptor/DomainOrderAdapter$OnInvoiceViewClick;", "(Landroid/content/Context;Ljava/util/List;Lcom/milkyway/gbusiness/adaptor/DomainOrderAdapter$OnInvoiceViewClick;)V", "getListner", "()Lcom/milkyway/gbusiness/adaptor/DomainOrderAdapter$OnInvoiceViewClick;", "setListner", "(Lcom/milkyway/gbusiness/adaptor/DomainOrderAdapter$OnInvoiceViewClick;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "MyViewHolder", "OnInvoiceViewClick", "app_debug"})
public final class DomainOrderAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.milkyway.gbusiness.adaptor.DomainOrderAdapter.MyViewHolder> {
    private final android.content.Context context = null;
    private final java.util.List<com.milkyway.gbusiness.models.DomainOrderResponse.Orders.Order> domainOrderList = null;
    @org.jetbrains.annotations.NotNull()
    private com.milkyway.gbusiness.adaptor.DomainOrderAdapter.OnInvoiceViewClick listner;
    
    public DomainOrderAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.List<com.milkyway.gbusiness.models.DomainOrderResponse.Orders.Order> domainOrderList, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.adaptor.DomainOrderAdapter.OnInvoiceViewClick listner) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.adaptor.DomainOrderAdapter.OnInvoiceViewClick getListner() {
        return null;
    }
    
    public final void setListner(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.adaptor.DomainOrderAdapter.OnInvoiceViewClick p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.milkyway.gbusiness.adaptor.DomainOrderAdapter.MyViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.adaptor.DomainOrderAdapter.MyViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0011\u0010\u0011\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0011\u0010\u0013\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0004\u00a8\u0006\u0018"}, d2 = {"Lcom/milkyway/gbusiness/adaptor/DomainOrderAdapter$MyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "tvDomainName", "Landroid/widget/TextView;", "getTvDomainName", "()Landroid/widget/TextView;", "tvInvoiceView", "getTvInvoiceView", "tvMobileNo", "getTvMobileNo", "tvOrderAmount", "getTvOrderAmount", "tvOrderDateTime", "getTvOrderDateTime", "tvOrderID", "getTvOrderID", "tvPaymentStatus", "getTvPaymentStatus", "getView", "()Landroid/view/View;", "setView", "app_debug"})
    public static final class MyViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.view.View view;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvDomainName = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvOrderID = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvOrderDateTime = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvMobileNo = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvPaymentStatus = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvOrderAmount = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvInvoiceView = null;
        
        public MyViewHolder(@org.jetbrains.annotations.NotNull()
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
        public final android.widget.TextView getTvDomainName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvOrderID() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvOrderDateTime() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvMobileNo() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvPaymentStatus() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvOrderAmount() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvInvoiceView() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/milkyway/gbusiness/adaptor/DomainOrderAdapter$OnInvoiceViewClick;", "", "onItemClicked", "", "position", "", "invoiceId", "app_debug"})
    public static abstract interface OnInvoiceViewClick {
        
        public abstract void onItemClicked(int position, int invoiceId);
    }
}