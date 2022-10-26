package com.milkyway.gbusiness.adaptor;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001b\u001c\u001dB+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001e"}, d2 = {"Lcom/milkyway/gbusiness/adaptor/Step_1_BusinessListItemsAdpater;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/milkyway/gbusiness/adaptor/Step_1_BusinessListItemsAdpater$ViewHolder;", "mContext", "Landroid/content/Context;", "itemList", "", "Lcom/milkyway/gbusiness/models/StepOneItemListsModel$BusinessItemsList;", "updateListener", "Lcom/milkyway/gbusiness/adaptor/Step_1_BusinessListItemsAdpater$UpdateBtnListener;", "deleteItemListener", "Lcom/milkyway/gbusiness/adaptor/Step_1_BusinessListItemsAdpater$DeleteBtnListener;", "(Landroid/content/Context;Ljava/util/List;Lcom/milkyway/gbusiness/adaptor/Step_1_BusinessListItemsAdpater$UpdateBtnListener;Lcom/milkyway/gbusiness/adaptor/Step_1_BusinessListItemsAdpater$DeleteBtnListener;)V", "getDeleteItemListener", "()Lcom/milkyway/gbusiness/adaptor/Step_1_BusinessListItemsAdpater$DeleteBtnListener;", "getUpdateListener", "()Lcom/milkyway/gbusiness/adaptor/Step_1_BusinessListItemsAdpater$UpdateBtnListener;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DeleteBtnListener", "UpdateBtnListener", "ViewHolder", "app_debug"})
public final class Step_1_BusinessListItemsAdpater extends androidx.recyclerview.widget.RecyclerView.Adapter<com.milkyway.gbusiness.adaptor.Step_1_BusinessListItemsAdpater.ViewHolder> {
    private final android.content.Context mContext = null;
    private final java.util.List<com.milkyway.gbusiness.models.StepOneItemListsModel.BusinessItemsList> itemList = null;
    @org.jetbrains.annotations.NotNull()
    private final com.milkyway.gbusiness.adaptor.Step_1_BusinessListItemsAdpater.UpdateBtnListener updateListener = null;
    @org.jetbrains.annotations.NotNull()
    private final com.milkyway.gbusiness.adaptor.Step_1_BusinessListItemsAdpater.DeleteBtnListener deleteItemListener = null;
    
    public Step_1_BusinessListItemsAdpater(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, @org.jetbrains.annotations.NotNull()
    java.util.List<com.milkyway.gbusiness.models.StepOneItemListsModel.BusinessItemsList> itemList, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.adaptor.Step_1_BusinessListItemsAdpater.UpdateBtnListener updateListener, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.adaptor.Step_1_BusinessListItemsAdpater.DeleteBtnListener deleteItemListener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.adaptor.Step_1_BusinessListItemsAdpater.UpdateBtnListener getUpdateListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.adaptor.Step_1_BusinessListItemsAdpater.DeleteBtnListener getDeleteItemListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.milkyway.gbusiness.adaptor.Step_1_BusinessListItemsAdpater.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.adaptor.Step_1_BusinessListItemsAdpater.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001a\u0010 \u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019\u00a8\u0006#"}, d2 = {"Lcom/milkyway/gbusiness/adaptor/Step_1_BusinessListItemsAdpater$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "civ_item_qr", "Lde/hdodenhof/circleimageview/CircleImageView;", "getCiv_item_qr", "()Lde/hdodenhof/circleimageview/CircleImageView;", "setCiv_item_qr", "(Lde/hdodenhof/circleimageview/CircleImageView;)V", "iv_delete_item", "Landroid/widget/ImageView;", "getIv_delete_item", "()Landroid/widget/ImageView;", "setIv_delete_item", "(Landroid/widget/ImageView;)V", "iv_update", "getIv_update", "setIv_update", "tv_bank_details", "Landroid/widget/TextView;", "getTv_bank_details", "()Landroid/widget/TextView;", "setTv_bank_details", "(Landroid/widget/TextView;)V", "tv_payment_email", "getTv_payment_email", "setTv_payment_email", "tv_payment_method", "getTv_payment_method", "setTv_payment_method", "tv_payment_url", "getTv_payment_url", "setTv_payment_url", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView tv_payment_method;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView tv_payment_email;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView tv_payment_url;
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView tv_bank_details;
        @org.jetbrains.annotations.NotNull()
        private de.hdodenhof.circleimageview.CircleImageView civ_item_qr;
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView iv_delete_item;
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView iv_update;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTv_payment_method() {
            return null;
        }
        
        public final void setTv_payment_method(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTv_payment_email() {
            return null;
        }
        
        public final void setTv_payment_email(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTv_payment_url() {
            return null;
        }
        
        public final void setTv_payment_url(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTv_bank_details() {
            return null;
        }
        
        public final void setTv_bank_details(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final de.hdodenhof.circleimageview.CircleImageView getCiv_item_qr() {
            return null;
        }
        
        public final void setCiv_item_qr(@org.jetbrains.annotations.NotNull()
        de.hdodenhof.circleimageview.CircleImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getIv_delete_item() {
            return null;
        }
        
        public final void setIv_delete_item(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getIv_update() {
            return null;
        }
        
        public final void setIv_update(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/milkyway/gbusiness/adaptor/Step_1_BusinessListItemsAdpater$UpdateBtnListener;", "", "updateClickListener", "", "position", "", "stepOneBusinessList", "Lcom/milkyway/gbusiness/models/StepOneItemListsModel$BusinessItemsList;", "app_debug"})
    public static abstract interface UpdateBtnListener {
        
        public abstract void updateClickListener(int position, @org.jetbrains.annotations.NotNull()
        com.milkyway.gbusiness.models.StepOneItemListsModel.BusinessItemsList stepOneBusinessList);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/milkyway/gbusiness/adaptor/Step_1_BusinessListItemsAdpater$DeleteBtnListener;", "", "deleteClickListener", "", "position", "", "stepOneBusinessList", "", "Lcom/milkyway/gbusiness/models/StepOneItemListsModel$BusinessItemsList;", "app_debug"})
    public static abstract interface DeleteBtnListener {
        
        public abstract void deleteClickListener(int position, @org.jetbrains.annotations.NotNull()
        java.util.List<com.milkyway.gbusiness.models.StepOneItemListsModel.BusinessItemsList> stepOneBusinessList);
    }
}