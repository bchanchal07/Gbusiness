package com.milkyway.gbusiness.fragments;

import java.lang.System;

/**
 * A simple [Fragment] subclass.
 * Use the [BusinessSubcategoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010+\u001a\u00020,2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0010\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\bH\u0002J\u0010\u0010/\u001a\u00020,2\u0006\u00100\u001a\u000201H\u0002J\"\u00102\u001a\u00020,2\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00052\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0010\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020\u0014H\u0016J\u0012\u00109\u001a\u00020,2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J&\u0010<\u001a\u0004\u0018\u0001012\u0006\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u0016\u0010A\u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010B\u001a\u00020\bH\u0002J\u0018\u0010C\u001a\u00020,2\u0006\u0010D\u001a\u00020\u00052\u0006\u00105\u001a\u00020\"H\u0016J\u0016\u0010E\u001a\u00020,2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002J\u0010\u0010F\u001a\u00020,2\u0006\u0010.\u001a\u00020\bH\u0002J\u0016\u0010G\u001a\u00020,2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020$X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u000e\u0010)\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006I"}, d2 = {"Lcom/milkyway/gbusiness/fragments/BusinessSubcategoryFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/milkyway/gbusiness/adaptor/BusinessSubCategoryAdaptor$OnSubCatAdaptorClick;", "()V", "catId", "", "catIdSaveState", "catName", "", "catNameBack", "catNameFinal", "clearQueryImageView", "Landroid/widget/ImageView;", "etSearch", "Landroidx/appcompat/widget/AppCompatEditText;", "imgUrl", "imgUrlBack", "imgUrlFinal", "ivSubCatImage", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "myBusinessSubCatBack", "noSearchResultsFoundText", "Landroid/widget/TextView;", "rvSubCategoryData", "Landroidx/recyclerview/widget/RecyclerView;", "searchEditText", "searchImageView", "subCatDataList", "", "Lcom/milkyway/gbusiness/models/SubCategoryDataClass$Subcategory;", "subCatDataResponse", "Lcom/milkyway/gbusiness/models/SubCategoryDataClass;", "getSubCatDataResponse", "()Lcom/milkyway/gbusiness/models/SubCategoryDataClass;", "setSubCatDataResponse", "(Lcom/milkyway/gbusiness/models/SubCategoryDataClass;)V", "tvSubCatTitle", "voiceSearchImageView", "callSubCategoryApi", "", "filterWithQuery", "query", "initializeView", "view", "Landroid/view/View;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onFilterChanged", "filterQuery", "onItemClicked", "position", "setSubCategoryDataAdaptor", "toggleImageView", "toggleRecyclerView", "sportsList", "app_debug"})
public final class BusinessSubcategoryFragment extends androidx.fragment.app.Fragment implements com.milkyway.gbusiness.adaptor.BusinessSubCategoryAdaptor.OnSubCatAdaptorClick {
    public android.content.Context mContext;
    public com.milkyway.gbusiness.models.SubCategoryDataClass subCatDataResponse;
    private androidx.recyclerview.widget.RecyclerView rvSubCategoryData;
    private android.widget.ImageView myBusinessSubCatBack;
    private android.widget.ImageView searchImageView;
    private androidx.appcompat.widget.AppCompatEditText etSearch;
    private android.widget.TextView noSearchResultsFoundText;
    private android.widget.TextView searchEditText;
    private android.widget.TextView tvSubCatTitle;
    private java.util.List<com.milkyway.gbusiness.models.SubCategoryDataClass.Subcategory> subCatDataList;
    private android.widget.ImageView clearQueryImageView;
    private android.widget.ImageView voiceSearchImageView;
    private android.widget.ImageView ivSubCatImage;
    private int catId = 0;
    private int catIdSaveState = 0;
    private java.lang.String catName = "";
    private java.lang.String catNameFinal = "";
    private java.lang.String imgUrl = "";
    private java.lang.String imgUrlFinal = "";
    private java.lang.String catNameBack = "";
    private java.lang.String imgUrlBack = "";
    private java.util.HashMap _$_findViewCache;
    
    public BusinessSubcategoryFragment() {
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
    public final com.milkyway.gbusiness.models.SubCategoryDataClass getSubCatDataResponse() {
        return null;
    }
    
    public final void setSubCatDataResponse(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.SubCategoryDataClass p0) {
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void callSubCategoryApi(int catId) {
    }
    
    private final void setSubCategoryDataAdaptor(java.util.List<com.milkyway.gbusiness.models.SubCategoryDataClass.Subcategory> subCatDataList) {
    }
    
    private final void initializeView(android.view.View view) {
    }
    
    private final void filterWithQuery(java.lang.String query) {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void toggleRecyclerView(java.util.List<com.milkyway.gbusiness.models.SubCategoryDataClass.Subcategory> sportsList) {
    }
    
    private final void toggleImageView(java.lang.String query) {
    }
    
    private final java.util.List<com.milkyway.gbusiness.models.SubCategoryDataClass.Subcategory> onFilterChanged(java.lang.String filterQuery) {
        return null;
    }
    
    @java.lang.Override()
    public void onItemClicked(int position, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.SubCategoryDataClass.Subcategory data) {
    }
}