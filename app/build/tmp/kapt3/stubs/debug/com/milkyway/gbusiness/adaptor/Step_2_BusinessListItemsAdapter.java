package com.milkyway.gbusiness.adaptor;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003 !\"B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ!\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u00a2\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006#"}, d2 = {"Lcom/milkyway/gbusiness/adaptor/Step_2_BusinessListItemsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/milkyway/gbusiness/adaptor/Step_2_BusinessListItemsAdapter$ViewHolder;", "context", "Landroid/content/Context;", "stepTwoItemList_gl", "", "Lcom/milkyway/gbusiness/models/StepOneItemListsModel$BusinessItemsList;", "updateListener", "Lcom/milkyway/gbusiness/adaptor/Step_2_BusinessListItemsAdapter$UpdateBtnListener;", "deleteItemListener", "Lcom/milkyway/gbusiness/adaptor/Step_2_BusinessListItemsAdapter$DeleteBtnListener;", "(Landroid/content/Context;Ljava/util/List;Lcom/milkyway/gbusiness/adaptor/Step_2_BusinessListItemsAdapter$UpdateBtnListener;Lcom/milkyway/gbusiness/adaptor/Step_2_BusinessListItemsAdapter$DeleteBtnListener;)V", "getDeleteItemListener", "()Lcom/milkyway/gbusiness/adaptor/Step_2_BusinessListItemsAdapter$DeleteBtnListener;", "getUpdateListener", "()Lcom/milkyway/gbusiness/adaptor/Step_2_BusinessListItemsAdapter$UpdateBtnListener;", "bindAdapter", "", "holder", "strs", "", "", "(Lcom/milkyway/gbusiness/adaptor/Step_2_BusinessListItemsAdapter$ViewHolder;[Ljava/lang/String;)V", "getItemCount", "", "onBindViewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DeleteBtnListener", "UpdateBtnListener", "ViewHolder", "app_debug"})
public final class Step_2_BusinessListItemsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.milkyway.gbusiness.adaptor.Step_2_BusinessListItemsAdapter.ViewHolder> {
    private final android.content.Context context = null;
    private final java.util.List<com.milkyway.gbusiness.models.StepOneItemListsModel.BusinessItemsList> stepTwoItemList_gl = null;
    @org.jetbrains.annotations.NotNull()
    private final com.milkyway.gbusiness.adaptor.Step_2_BusinessListItemsAdapter.UpdateBtnListener updateListener = null;
    @org.jetbrains.annotations.NotNull()
    private final com.milkyway.gbusiness.adaptor.Step_2_BusinessListItemsAdapter.DeleteBtnListener deleteItemListener = null;
    
    public Step_2_BusinessListItemsAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.List<com.milkyway.gbusiness.models.StepOneItemListsModel.BusinessItemsList> stepTwoItemList_gl, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.adaptor.Step_2_BusinessListItemsAdapter.UpdateBtnListener updateListener, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.adaptor.Step_2_BusinessListItemsAdapter.DeleteBtnListener deleteItemListener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.adaptor.Step_2_BusinessListItemsAdapter.UpdateBtnListener getUpdateListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.adaptor.Step_2_BusinessListItemsAdapter.DeleteBtnListener getDeleteItemListener() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.milkyway.gbusiness.adaptor.Step_2_BusinessListItemsAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.adaptor.Step_2_BusinessListItemsAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void bindAdapter(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.adaptor.Step_2_BusinessListItemsAdapter.ViewHolder holder, @org.jetbrains.annotations.NotNull()
    java.lang.String[] strs) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/milkyway/gbusiness/adaptor/Step_2_BusinessListItemsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "iv_delete_item", "Landroid/widget/ImageView;", "getIv_delete_item", "()Landroid/widget/ImageView;", "setIv_delete_item", "(Landroid/widget/ImageView;)V", "iv_update", "getIv_update", "setIv_update", "rv_items", "Landroidx/recyclerview/widget/RecyclerView;", "getRv_items", "()Landroidx/recyclerview/widget/RecyclerView;", "setRv_items", "(Landroidx/recyclerview/widget/RecyclerView;)V", "tv_title", "Landroid/widget/TextView;", "getTv_title", "()Landroid/widget/TextView;", "setTv_title", "(Landroid/widget/TextView;)V", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.widget.TextView tv_title;
        @org.jetbrains.annotations.NotNull()
        private androidx.recyclerview.widget.RecyclerView rv_items;
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView iv_update;
        @org.jetbrains.annotations.NotNull()
        private android.widget.ImageView iv_delete_item;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTv_title() {
            return null;
        }
        
        public final void setTv_title(@org.jetbrains.annotations.NotNull()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.recyclerview.widget.RecyclerView getRv_items() {
            return null;
        }
        
        public final void setRv_items(@org.jetbrains.annotations.NotNull()
        androidx.recyclerview.widget.RecyclerView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getIv_update() {
            return null;
        }
        
        public final void setIv_update(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getIv_delete_item() {
            return null;
        }
        
        public final void setIv_delete_item(@org.jetbrains.annotations.NotNull()
        android.widget.ImageView p0) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/milkyway/gbusiness/adaptor/Step_2_BusinessListItemsAdapter$UpdateBtnListener;", "", "updateClickListener", "", "position", "", "stepTwoBusinessList", "Lcom/milkyway/gbusiness/models/StepOneItemListsModel$BusinessItemsList;", "app_debug"})
    public static abstract interface UpdateBtnListener {
        
        public abstract void updateClickListener(int position, @org.jetbrains.annotations.NotNull()
        com.milkyway.gbusiness.models.StepOneItemListsModel.BusinessItemsList stepTwoBusinessList);
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/milkyway/gbusiness/adaptor/Step_2_BusinessListItemsAdapter$DeleteBtnListener;", "", "deleteClickListener", "", "position", "", "stepTwoBusinessList", "", "Lcom/milkyway/gbusiness/models/StepOneItemListsModel$BusinessItemsList;", "app_debug"})
    public static abstract interface DeleteBtnListener {
        
        public abstract void deleteClickListener(int position, @org.jetbrains.annotations.NotNull()
        java.util.List<com.milkyway.gbusiness.models.StepOneItemListsModel.BusinessItemsList> stepTwoBusinessList);
    }
}