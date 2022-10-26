package com.milkyway.gbusiness.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u000bH\u0016J\u0018\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J&\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u001e\u0010,\u001a\u00020\u001d2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030.2\u0006\u0010/\u001a\u000200H\u0016J$\u00101\u001a\u00020\u001d2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030.2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000303H\u0016J\u0010\u00104\u001a\u00020\u001d2\u0006\u00105\u001a\u00020\"H\u0002J\u0010\u00106\u001a\u00020\u001d2\u0006\u00105\u001a\u00020\"H\u0002R\"\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2 = {"Lcom/milkyway/gbusiness/fragments/TrashLisFragment;", "Landroidx/fragment/app/Fragment;", "Lretrofit2/Callback;", "Lcom/milkyway/gbusiness/models/TrashListDataClass;", "Lcom/milkyway/gbusiness/api/OnClickServices;", "()V", "arrayList", "Ljava/util/ArrayList;", "Lcom/milkyway/gbusiness/models/DataXXXXXXXXXXXXXXXXXX;", "Lkotlin/collections/ArrayList;", "mContext", "Landroid/content/Context;", "myTrashBack", "Landroid/widget/ImageView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "viewAdapter", "Lcom/milkyway/gbusiness/adaptor/TrashLisFragmentAdaptor;", "getViewAdapter", "()Lcom/milkyway/gbusiness/adaptor/TrashLisFragmentAdaptor;", "setViewAdapter", "(Lcom/milkyway/gbusiness/adaptor/TrashLisFragmentAdaptor;)V", "viewManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "getTrashApi", "", "onAttach", "context", "onClick", "id", "", "name", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onFailure", "call", "Lretrofit2/Call;", "t", "", "onResponse", "response", "Lretrofit2/Response;", "siteReStore", "tempID", "siteRemove", "app_debug"})
public final class TrashLisFragment extends androidx.fragment.app.Fragment implements retrofit2.Callback<com.milkyway.gbusiness.models.TrashListDataClass>, com.milkyway.gbusiness.api.OnClickServices {
    public com.milkyway.gbusiness.adaptor.TrashLisFragmentAdaptor viewAdapter;
    @org.jetbrains.annotations.Nullable()
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private androidx.recyclerview.widget.RecyclerView.LayoutManager viewManager;
    private android.widget.ImageView myTrashBack;
    private android.content.Context mContext;
    private java.util.ArrayList<com.milkyway.gbusiness.models.DataXXXXXXXXXXXXXXXXXX> arrayList;
    private java.util.HashMap _$_findViewCache;
    
    public TrashLisFragment() {
        super();
    }
    
    @java.lang.Override()
    public void onFailure(@org.jetbrains.annotations.NotNull()
    retrofit2.Call<com.milkyway.gbusiness.models.TrashListDataClass> call, @org.jetbrains.annotations.NotNull()
    java.lang.Throwable t) {
    }
    
    @java.lang.Override()
    public void onResponse(@org.jetbrains.annotations.NotNull()
    retrofit2.Call<com.milkyway.gbusiness.models.TrashListDataClass> call, @org.jetbrains.annotations.NotNull()
    retrofit2.Response<com.milkyway.gbusiness.models.TrashListDataClass> response) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.adaptor.TrashLisFragmentAdaptor getViewAdapter() {
        return null;
    }
    
    public final void setViewAdapter(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.adaptor.TrashLisFragmentAdaptor p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.recyclerview.widget.RecyclerView getRecyclerView() {
        return null;
    }
    
    public final void setRecyclerView(@org.jetbrains.annotations.Nullable()
    androidx.recyclerview.widget.RecyclerView p0) {
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
    
    private final void getTrashApi() {
    }
    
    private final void siteReStore(java.lang.String tempID) {
    }
    
    private final void siteRemove(java.lang.String tempID) {
    }
    
    public void editSites(@org.jetbrains.annotations.NotNull()
    java.lang.String webUrl) {
    }
    
    public void nowPublishWebSite(@org.jetbrains.annotations.NotNull()
    java.lang.String templateID, @org.jetbrains.annotations.NotNull()
    java.lang.String domainId) {
    }
    
    public void nowUnPublishWebSite(@org.jetbrains.annotations.NotNull()
    java.lang.String projectId) {
    }
    
    public void onClickDownload(@org.jetbrains.annotations.NotNull()
    java.lang.String webUrl) {
    }
    
    public void onClickPublish(@org.jetbrains.annotations.NotNull()
    java.lang.String templateID, @org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
    
    public void onClickTrash(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
}