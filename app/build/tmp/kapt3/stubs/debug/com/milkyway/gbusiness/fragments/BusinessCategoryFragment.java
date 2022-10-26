package com.milkyway.gbusiness.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0002J\"\u0010\'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0010\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\u0012H\u0016J&\u0010/\u001a\u0004\u0018\u00010\"2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0016\u00106\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u00107\u001a\u00020%H\u0002J\u0018\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020)2\u0006\u0010+\u001a\u00020\fH\u0016J\u0016\u0010:\u001a\u00020\u001f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010;\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%H\u0002J\u0016\u0010<\u001a\u00020\u001f2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006>"}, d2 = {"Lcom/milkyway/gbusiness/fragments/BusinessCategoryFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/milkyway/gbusiness/adaptor/BusinessCategoryAdaptor$OnBusinessCatAdaptorClick;", "()V", "catDataResponse", "Lcom/milkyway/gbusiness/models/CategoryDataClass;", "getCatDataResponse", "()Lcom/milkyway/gbusiness/models/CategoryDataClass;", "setCatDataResponse", "(Lcom/milkyway/gbusiness/models/CategoryDataClass;)V", "categoryDataList", "", "Lcom/milkyway/gbusiness/models/CategoryDataClass$Data;", "clearQueryImageView", "Landroid/widget/ImageView;", "etSearch", "Landroidx/appcompat/widget/AppCompatEditText;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "myBusinessCatBack", "noSearchResultsFoundText", "Landroid/widget/TextView;", "rvCategory", "Landroidx/recyclerview/widget/RecyclerView;", "searchEditText", "voiceSearchImageView", "callCategoryApi", "", "clickListener", "view", "Landroid/view/View;", "filterWithQuery", "query", "", "initializeViews", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onFilterChanged", "filterQuery", "onItemClicked", "position", "setCategoryAdaptor", "toggleImageView", "toggleRecyclerView", "catList", "app_debug"})
public final class BusinessCategoryFragment extends androidx.fragment.app.Fragment implements com.milkyway.gbusiness.adaptor.BusinessCategoryAdaptor.OnBusinessCatAdaptorClick {
    private androidx.recyclerview.widget.RecyclerView rvCategory;
    private android.widget.ImageView myBusinessCatBack;
    public android.content.Context mContext;
    public com.milkyway.gbusiness.models.CategoryDataClass catDataResponse;
    private java.util.List<com.milkyway.gbusiness.models.CategoryDataClass.Data> categoryDataList;
    private androidx.appcompat.widget.AppCompatEditText etSearch;
    private android.widget.TextView noSearchResultsFoundText;
    private android.widget.TextView searchEditText;
    private android.widget.ImageView clearQueryImageView;
    private android.widget.ImageView voiceSearchImageView;
    private java.util.HashMap _$_findViewCache;
    
    public BusinessCategoryFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.CategoryDataClass getCatDataResponse() {
        return null;
    }
    
    public final void setCatDataResponse(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.CategoryDataClass p0) {
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
    
    private final void clickListener(android.view.View view) {
    }
    
    private final void initializeViews(android.view.View view) {
    }
    
    private final void filterWithQuery(java.lang.String query) {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void toggleRecyclerView(java.util.List<com.milkyway.gbusiness.models.CategoryDataClass.Data> catList) {
    }
    
    private final void toggleImageView(java.lang.String query) {
    }
    
    private final java.util.List<com.milkyway.gbusiness.models.CategoryDataClass.Data> onFilterChanged(java.lang.String filterQuery) {
        return null;
    }
    
    private final void callCategoryApi() {
    }
    
    private final void setCategoryAdaptor(java.util.List<com.milkyway.gbusiness.models.CategoryDataClass.Data> categoryDataList) {
    }
    
    @java.lang.Override()
    public void onItemClicked(int position, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.CategoryDataClass.Data data) {
    }
}