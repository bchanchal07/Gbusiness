package com.milkyway.gbusiness.adaptor;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001c"}, d2 = {"Lcom/milkyway/gbusiness/adaptor/MyCartFramentAdaptor;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/milkyway/gbusiness/adaptor/MyCartFramentAdaptor$MyViewHolder;", "listner", "Lcom/milkyway/gbusiness/api/OnAdpterClick;", "array", "", "Lcom/milkyway/gbusiness/models/DataXXXXXX;", "(Lcom/milkyway/gbusiness/api/OnAdpterClick;Ljava/util/List;)V", "getArray", "()Ljava/util/List;", "setArray", "(Ljava/util/List;)V", "getListner", "()Lcom/milkyway/gbusiness/api/OnAdpterClick;", "setListner", "(Lcom/milkyway/gbusiness/api/OnAdpterClick;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "MyViewHolder", "app_debug"})
public final class MyCartFramentAdaptor extends androidx.recyclerview.widget.RecyclerView.Adapter<com.milkyway.gbusiness.adaptor.MyCartFramentAdaptor.MyViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private com.milkyway.gbusiness.api.OnAdpterClick listner;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.milkyway.gbusiness.models.DataXXXXXX> array;
    
    public MyCartFramentAdaptor(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.api.OnAdpterClick listner, @org.jetbrains.annotations.NotNull()
    java.util.List<com.milkyway.gbusiness.models.DataXXXXXX> array) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.api.OnAdpterClick getListner() {
        return null;
    }
    
    public final void setListner(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.api.OnAdpterClick p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.milkyway.gbusiness.models.DataXXXXXX> getArray() {
        return null;
    }
    
    public final void setArray(@org.jetbrains.annotations.NotNull()
    java.util.List<com.milkyway.gbusiness.models.DataXXXXXX> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.milkyway.gbusiness.adaptor.MyCartFramentAdaptor.MyViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.adaptor.MyCartFramentAdaptor.MyViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000f0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u000f0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0004\u00a8\u0006\u0017"}, d2 = {"Lcom/milkyway/gbusiness/adaptor/MyCartFramentAdaptor$MyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "btnBuyNow", "Landroidx/appcompat/widget/AppCompatButton;", "kotlin.jvm.PlatformType", "getBtnBuyNow", "()Landroidx/appcompat/widget/AppCompatButton;", "closeBtn", "Landroid/widget/ImageView;", "getCloseBtn", "()Landroid/widget/ImageView;", "tvDoainName", "Landroid/widget/TextView;", "getTvDoainName", "()Landroid/widget/TextView;", "tv_domainPrice", "getTv_domainPrice", "getView", "()Landroid/view/View;", "setView", "app_debug"})
    public static final class MyViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.view.View view;
        private final android.widget.ImageView closeBtn = null;
        private final android.widget.TextView tvDoainName = null;
        private final android.widget.TextView tv_domainPrice = null;
        private final androidx.appcompat.widget.AppCompatButton btnBuyNow = null;
        
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
        
        public final android.widget.ImageView getCloseBtn() {
            return null;
        }
        
        public final android.widget.TextView getTvDoainName() {
            return null;
        }
        
        public final android.widget.TextView getTv_domainPrice() {
            return null;
        }
        
        public final androidx.appcompat.widget.AppCompatButton getBtnBuyNow() {
            return null;
        }
    }
}