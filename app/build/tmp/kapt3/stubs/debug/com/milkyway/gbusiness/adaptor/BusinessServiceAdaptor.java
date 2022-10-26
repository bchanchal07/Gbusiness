package com.milkyway.gbusiness.adaptor;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0019\u001aB#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/milkyway/gbusiness/adaptor/BusinessServiceAdaptor;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/milkyway/gbusiness/adaptor/BusinessServiceAdaptor$MyViewHolder;", "mCtx", "Landroid/content/Context;", "listner", "Lcom/milkyway/gbusiness/adaptor/BusinessServiceAdaptor$OnBusinessServiceAdaptorClick;", "bServiceList", "", "Lcom/milkyway/gbusiness/models/BusinessServiceModelClass$Data;", "(Landroid/content/Context;Lcom/milkyway/gbusiness/adaptor/BusinessServiceAdaptor$OnBusinessServiceAdaptorClick;Ljava/util/List;)V", "getListner", "()Lcom/milkyway/gbusiness/adaptor/BusinessServiceAdaptor$OnBusinessServiceAdaptorClick;", "setListner", "(Lcom/milkyway/gbusiness/adaptor/BusinessServiceAdaptor$OnBusinessServiceAdaptorClick;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "MyViewHolder", "OnBusinessServiceAdaptorClick", "app_debug"})
public final class BusinessServiceAdaptor extends androidx.recyclerview.widget.RecyclerView.Adapter<com.milkyway.gbusiness.adaptor.BusinessServiceAdaptor.MyViewHolder> {
    private final android.content.Context mCtx = null;
    @org.jetbrains.annotations.NotNull()
    private com.milkyway.gbusiness.adaptor.BusinessServiceAdaptor.OnBusinessServiceAdaptorClick listner;
    private final java.util.List<com.milkyway.gbusiness.models.BusinessServiceModelClass.Data> bServiceList = null;
    
    public BusinessServiceAdaptor(@org.jetbrains.annotations.NotNull()
    android.content.Context mCtx, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.adaptor.BusinessServiceAdaptor.OnBusinessServiceAdaptorClick listner, @org.jetbrains.annotations.NotNull()
    java.util.List<com.milkyway.gbusiness.models.BusinessServiceModelClass.Data> bServiceList) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.adaptor.BusinessServiceAdaptor.OnBusinessServiceAdaptorClick getListner() {
        return null;
    }
    
    public final void setListner(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.adaptor.BusinessServiceAdaptor.OnBusinessServiceAdaptorClick p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.milkyway.gbusiness.adaptor.BusinessServiceAdaptor.MyViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.adaptor.BusinessServiceAdaptor.MyViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/milkyway/gbusiness/adaptor/BusinessServiceAdaptor$MyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "serviceName", "Landroid/widget/TextView;", "getServiceName", "()Landroid/widget/TextView;", "getView", "()Landroid/view/View;", "setView", "app_debug"})
    public static final class MyViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.view.View view;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView serviceName = null;
        
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
        public final android.widget.TextView getServiceName() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/milkyway/gbusiness/adaptor/BusinessServiceAdaptor$OnBusinessServiceAdaptorClick;", "", "onItemClicked", "", "position", "", "data", "Lcom/milkyway/gbusiness/models/BusinessServiceModelClass$Data;", "app_debug"})
    public static abstract interface OnBusinessServiceAdaptorClick {
        
        public abstract void onItemClicked(int position, @org.jetbrains.annotations.NotNull()
        com.milkyway.gbusiness.models.BusinessServiceModelClass.Data data);
    }
}