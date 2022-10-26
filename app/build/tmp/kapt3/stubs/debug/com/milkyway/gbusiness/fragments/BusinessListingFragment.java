package com.milkyway.gbusiness.fragments;

import java.lang.System;

/**
 * A simple [Fragment] subclass.
 * Use the [BusinessListingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=J\u0010\u0010>\u001a\u00020;2\u0006\u0010?\u001a\u00020/H\u0002J8\u0010@\u001a\u00020;2\u0006\u0010?\u001a\u00020/2\u0006\u0010%\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00182\u0006\u0010A\u001a\u00020BH\u0002J\b\u0010C\u001a\u00020;H\u0002J\u0012\u0010D\u001a\u00020;2\b\u0010E\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u0010F\u001a\u00020;2\u0006\u0010)\u001a\u00020\u0018H\u0002J\u0012\u0010G\u001a\u00020;2\b\u0010H\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010I\u001a\u00020;H\u0002J\u0010\u0010J\u001a\u00020;2\u0006\u0010E\u001a\u00020\"H\u0002J\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00180L2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007H\u0002J\"\u0010M\u001a\u00020;2\u0006\u0010N\u001a\u00020/2\u0006\u0010O\u001a\u00020/2\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\u0010\u0010R\u001a\u00020;2\u0006\u0010S\u001a\u00020\u001cH\u0016J\u0018\u0010T\u001a\u00020;2\u0006\u0010U\u001a\u00020/2\u0006\u0010V\u001a\u00020\bH\u0016J\u0018\u0010W\u001a\u00020;2\u0006\u0010U\u001a\u00020/2\u0006\u0010V\u001a\u00020\bH\u0016J\u0012\u0010X\u001a\u00020;2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J&\u0010[\u001a\u0004\u0018\u00010\"2\u0006\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010_2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J\u0016\u0010`\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010a\u001a\u00020\u0018H\u0002J\u0018\u0010b\u001a\u00020;2\u0006\u0010c\u001a\u00020/2\u0006\u0010V\u001a\u00020\bH\u0016J\u0016\u0010d\u001a\u00020;2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0010\u0010e\u001a\u00020;2\u0006\u0010)\u001a\u00020\u0018H\u0002J\u0016\u0010f\u001a\u00020;2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020/X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u000e\u00109\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006h"}, d2 = {"Lcom/milkyway/gbusiness/fragments/BusinessListingFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/milkyway/gbusiness/adaptor/BusinessListingAdaptor$OnBListingAdaptorClick;", "()V", "btnSelectCategory", "Landroidx/appcompat/widget/AppCompatButton;", "businessList", "", "Lcom/milkyway/gbusiness/models/BusinessDirectoryDataClass$Data;", "businessListingResponse", "Lcom/milkyway/gbusiness/models/BusinessDirectoryDataClass;", "getBusinessListingResponse", "()Lcom/milkyway/gbusiness/models/BusinessDirectoryDataClass;", "setBusinessListingResponse", "(Lcom/milkyway/gbusiness/models/BusinessDirectoryDataClass;)V", "categoryList", "Lcom/milkyway/gbusiness/models/CategoryDataClass$Data;", "getCategoryList", "()Ljava/util/List;", "setCategoryList", "(Ljava/util/List;)V", "clearQueryImageView", "Landroid/widget/ImageView;", "email", "", "etSearch", "Landroidx/appcompat/widget/AppCompatEditText;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mView", "Landroid/view/View;", "mViewError", "myBusinessListingBack", "name", "noSearchResultsFoundText", "Landroid/widget/TextView;", "phone", "query", "rvBusinessListing", "Landroidx/recyclerview/widget/RecyclerView;", "searchableSpinnerCategory", "Lcom/leo/searchablespinner/SearchableSpinner;", "selectedCategoryId", "", "getSelectedCategoryId", "()I", "setSelectedCategoryId", "(I)V", "selectedCategorySlug", "getSelectedCategorySlug", "()Ljava/lang/String;", "setSelectedCategorySlug", "(Ljava/lang/String;)V", "voiceSearchImageView", "alertErrorDialog", "", "errorBody", "Lcom/milkyway/gbusiness/models/BusinessEnqErrorResponse;", "alertQuoteDialog", "userId", "callApiBusinessEnquiry", "finalDialog", "Landroid/app/Dialog;", "callCategoryApi", "clickListener", "view", "filterWithQuery", "getBListingDetailsByCategorySlugApi", "catUrl", "getBusinessListingApi", "initializeView", "loadCategoriesNameList", "Ljava/util/ArrayList;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "onBtnClickedQuote", "pos", "list", "onBtnClickedWebsite", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onFilterChanged", "filterQuery", "onItemClicked", "position", "setBusinessListingAdaptor", "toggleImageView", "toggleRecyclerView", "catList", "app_debug"})
public final class BusinessListingFragment extends androidx.fragment.app.Fragment implements com.milkyway.gbusiness.adaptor.BusinessListingAdaptor.OnBListingAdaptorClick {
    public android.content.Context mContext;
    public com.milkyway.gbusiness.models.BusinessDirectoryDataClass businessListingResponse;
    private java.util.List<com.milkyway.gbusiness.models.BusinessDirectoryDataClass.Data> businessList;
    private androidx.recyclerview.widget.RecyclerView rvBusinessListing;
    private android.widget.ImageView myBusinessListingBack;
    private androidx.appcompat.widget.AppCompatButton btnSelectCategory;
    private androidx.appcompat.widget.AppCompatEditText etSearch;
    private android.widget.TextView noSearchResultsFoundText;
    private android.widget.ImageView clearQueryImageView;
    private android.widget.ImageView voiceSearchImageView;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.milkyway.gbusiness.models.CategoryDataClass.Data> categoryList;
    private int selectedCategoryId = 0;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String selectedCategorySlug = "";
    private java.lang.String name;
    private java.lang.String email;
    private java.lang.String phone;
    private java.lang.String query;
    private android.view.View mView;
    private android.view.View mViewError;
    private com.leo.searchablespinner.SearchableSpinner searchableSpinnerCategory;
    private java.util.HashMap _$_findViewCache;
    
    public BusinessListingFragment() {
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
    public final com.milkyway.gbusiness.models.BusinessDirectoryDataClass getBusinessListingResponse() {
        return null;
    }
    
    public final void setBusinessListingResponse(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.BusinessDirectoryDataClass p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.milkyway.gbusiness.models.CategoryDataClass.Data> getCategoryList() {
        return null;
    }
    
    public final void setCategoryList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.milkyway.gbusiness.models.CategoryDataClass.Data> p0) {
    }
    
    public final int getSelectedCategoryId() {
        return 0;
    }
    
    public final void setSelectedCategoryId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSelectedCategorySlug() {
        return null;
    }
    
    public final void setSelectedCategorySlug(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
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
    
    private final void initializeView(android.view.View view) {
    }
    
    private final void getBusinessListingApi() {
    }
    
    private final void setBusinessListingAdaptor(java.util.List<com.milkyway.gbusiness.models.BusinessDirectoryDataClass.Data> businessList) {
    }
    
    private final void filterWithQuery(java.lang.String query) {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void toggleRecyclerView(java.util.List<com.milkyway.gbusiness.models.BusinessDirectoryDataClass.Data> catList) {
    }
    
    private final void toggleImageView(java.lang.String query) {
    }
    
    private final java.util.List<com.milkyway.gbusiness.models.BusinessDirectoryDataClass.Data> onFilterChanged(java.lang.String filterQuery) {
        return null;
    }
    
    private final void clickListener(android.view.View view) {
    }
    
    private final void callCategoryApi() {
    }
    
    private final java.util.ArrayList<java.lang.String> loadCategoriesNameList(java.util.List<com.milkyway.gbusiness.models.CategoryDataClass.Data> categoryList) {
        return null;
    }
    
    private final void getBListingDetailsByCategorySlugApi(java.lang.String catUrl) {
    }
    
    @java.lang.Override()
    public void onItemClicked(int position, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.BusinessDirectoryDataClass.Data list) {
    }
    
    @java.lang.Override()
    public void onBtnClickedWebsite(int pos, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.BusinessDirectoryDataClass.Data list) {
    }
    
    @java.lang.Override()
    public void onBtnClickedQuote(int pos, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.BusinessDirectoryDataClass.Data list) {
    }
    
    private final void alertQuoteDialog(int userId) {
    }
    
    private final void callApiBusinessEnquiry(int userId, java.lang.String name, java.lang.String email, java.lang.String phone, java.lang.String query, android.app.Dialog finalDialog) {
    }
    
    public final void alertErrorDialog(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.BusinessEnqErrorResponse errorBody) {
    }
}