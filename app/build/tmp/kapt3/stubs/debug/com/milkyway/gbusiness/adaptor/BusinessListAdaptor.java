package com.milkyway.gbusiness.adaptor;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/milkyway/gbusiness/adaptor/BusinessListAdaptor;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/milkyway/gbusiness/adaptor/BusinessListAdaptor$MyViewHolder;", "mCtx", "Landroid/content/Context;", "businessList", "", "Lcom/milkyway/gbusiness/models/BusinessListingResponse$Data;", "(Landroid/content/Context;Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "MyViewHolder", "OnBListingAdaptorClick", "app_debug"})
public final class BusinessListAdaptor extends androidx.recyclerview.widget.RecyclerView.Adapter<com.milkyway.gbusiness.adaptor.BusinessListAdaptor.MyViewHolder> {
    private final android.content.Context mCtx = null;
    private final java.util.List<com.milkyway.gbusiness.models.BusinessListingResponse.Data> businessList = null;
    
    public BusinessListAdaptor(@org.jetbrains.annotations.NotNull()
    android.content.Context mCtx, @org.jetbrains.annotations.NotNull()
    java.util.List<com.milkyway.gbusiness.models.BusinessListingResponse.Data> businessList) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.milkyway.gbusiness.adaptor.BusinessListAdaptor.MyViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.adaptor.BusinessListAdaptor.MyViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0017\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u0019\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u001b\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u001d\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012R\u0011\u0010\u001f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012R\u0011\u0010!\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010\u0004\u00a8\u0006&"}, d2 = {"Lcom/milkyway/gbusiness/adaptor/BusinessListAdaptor$MyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "btnDelete", "Landroidx/appcompat/widget/AppCompatImageButton;", "getBtnDelete", "()Landroidx/appcompat/widget/AppCompatImageButton;", "btnUpdate", "getBtnUpdate", "ivBusinessLogo", "Landroid/widget/ImageView;", "getIvBusinessLogo", "()Landroid/widget/ImageView;", "tvAboutBusiness", "Landroid/widget/TextView;", "getTvAboutBusiness", "()Landroid/widget/TextView;", "tvBusinessName", "getTvBusinessName", "tvCategory", "getTvCategory", "tvDate", "getTvDate", "tvEmail", "getTvEmail", "tvSrNo", "getTvSrNo", "tvStatus", "getTvStatus", "tvSubcategory", "getTvSubcategory", "tvUrl", "getTvUrl", "getView", "()Landroid/view/View;", "setView", "app_debug"})
    public static final class MyViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.view.View view;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvSrNo = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvBusinessName = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView ivBusinessLogo = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvEmail = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvUrl = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvAboutBusiness = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvCategory = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvSubcategory = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvDate = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvStatus = null;
        @org.jetbrains.annotations.NotNull()
        private final androidx.appcompat.widget.AppCompatImageButton btnUpdate = null;
        @org.jetbrains.annotations.NotNull()
        private final androidx.appcompat.widget.AppCompatImageButton btnDelete = null;
        
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
        public final android.widget.TextView getTvSrNo() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvBusinessName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getIvBusinessLogo() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvEmail() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvUrl() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvAboutBusiness() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvCategory() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvSubcategory() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvDate() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvStatus() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.appcompat.widget.AppCompatImageButton getBtnUpdate() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.appcompat.widget.AppCompatImageButton getBtnDelete() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/milkyway/gbusiness/adaptor/BusinessListAdaptor$OnBListingAdaptorClick;", "", "onDeleteBtnClicked", "", "pos", "", "list", "Lcom/milkyway/gbusiness/models/BusinessListingResponse$Data;", "onUpdateBtnClicked", "app_debug"})
    public static abstract interface OnBListingAdaptorClick {
        
        public abstract void onDeleteBtnClicked(int pos, @org.jetbrains.annotations.NotNull()
        com.milkyway.gbusiness.models.BusinessListingResponse.Data list);
        
        public abstract void onUpdateBtnClicked(int pos, @org.jetbrains.annotations.NotNull()
        com.milkyway.gbusiness.models.BusinessListingResponse.Data list);
    }
}