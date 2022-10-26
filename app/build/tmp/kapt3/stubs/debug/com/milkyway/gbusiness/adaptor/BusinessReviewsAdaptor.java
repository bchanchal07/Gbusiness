package com.milkyway.gbusiness.adaptor;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/milkyway/gbusiness/adaptor/BusinessReviewsAdaptor;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/milkyway/gbusiness/adaptor/BusinessReviewsAdaptor$MyViewHolder;", "mCtx", "Landroid/content/Context;", "reviewsList", "", "Lcom/milkyway/gbusiness/models/GetReviewsDataClass$Data;", "(Landroid/content/Context;Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "MyViewHolder", "app_debug"})
public final class BusinessReviewsAdaptor extends androidx.recyclerview.widget.RecyclerView.Adapter<com.milkyway.gbusiness.adaptor.BusinessReviewsAdaptor.MyViewHolder> {
    private final android.content.Context mCtx = null;
    private final java.util.List<com.milkyway.gbusiness.models.GetReviewsDataClass.Data> reviewsList = null;
    
    public BusinessReviewsAdaptor(@org.jetbrains.annotations.NotNull()
    android.content.Context mCtx, @org.jetbrains.annotations.NotNull()
    java.util.List<com.milkyway.gbusiness.models.GetReviewsDataClass.Data> reviewsList) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.milkyway.gbusiness.adaptor.BusinessReviewsAdaptor.MyViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.adaptor.BusinessReviewsAdaptor.MyViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0004R\u0011\u0010\u0018\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/milkyway/gbusiness/adaptor/BusinessReviewsAdaptor$MyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "ivUserImage", "Lde/hdodenhof/circleimageview/CircleImageView;", "getIvUserImage", "()Lde/hdodenhof/circleimageview/CircleImageView;", "ratingBarReviews", "Landroid/widget/RatingBar;", "getRatingBarReviews", "()Landroid/widget/RatingBar;", "tvReviewComment", "Landroid/widget/TextView;", "getTvReviewComment", "()Landroid/widget/TextView;", "tvUserEmail", "getTvUserEmail", "tvUserName", "getTvUserName", "getView", "()Landroid/view/View;", "setView", "viewSeparator", "getViewSeparator", "app_debug"})
    public static final class MyViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.view.View view;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvUserName = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvUserEmail = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.RatingBar ratingBarReviews = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvReviewComment = null;
        @org.jetbrains.annotations.NotNull()
        private final de.hdodenhof.circleimageview.CircleImageView ivUserImage = null;
        @org.jetbrains.annotations.NotNull()
        private final android.view.View viewSeparator = null;
        
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
        public final android.widget.TextView getTvUserName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvUserEmail() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.RatingBar getRatingBarReviews() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvReviewComment() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final de.hdodenhof.circleimageview.CircleImageView getIvUserImage() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.view.View getViewSeparator() {
            return null;
        }
    }
}