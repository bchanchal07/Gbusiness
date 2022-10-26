package com.milkyway.gbusiness.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-J\u0010\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020\u000eH\u0002J8\u00100\u001a\u00020+2\u0006\u0010/\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u00102\u0006\u00101\u001a\u000202H\u0002J\u0010\u00103\u001a\u00020+2\u0006\u0010%\u001a\u00020\u0010H\u0002J\u0017\u00104\u001a\u00020+2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002\u00a2\u0006\u0002\u00105J\u0010\u00106\u001a\u00020+2\u0006\u00107\u001a\u00020\u001eH\u0002J\u0012\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010;\u001a\u0002092\b\u0010<\u001a\u0004\u0018\u00010\u0010H\u0002J\"\u0010=\u001a\u00020+2\u0006\u0010>\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\u000e2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u0010\u0010B\u001a\u00020+2\u0006\u0010C\u001a\u00020\u0018H\u0016J\u0018\u0010D\u001a\u00020+2\u0006\u0010E\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020\fH\u0016J\u0018\u0010G\u001a\u00020+2\u0006\u0010E\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020\fH\u0016J\u0012\u0010H\u001a\u00020+2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J&\u0010K\u001a\u0004\u0018\u00010\u001e2\u0006\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010O2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\u0016\u0010P\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010Q\u001a\u00020\u0010H\u0002J\u0010\u0010R\u001a\u00020+2\u0006\u0010S\u001a\u00020\u000eH\u0016J\b\u0010T\u001a\u00020+H\u0016J\u0016\u0010U\u001a\u00020+2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010V\u001a\u00020+2\u0006\u0010%\u001a\u00020\u0010H\u0002J\u0016\u0010W\u001a\u00020+2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\b\u0010Y\u001a\u000209H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006Z"}, d2 = {"Lcom/milkyway/gbusiness/fragments/BusinessCatDetailsFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/milkyway/gbusiness/adaptor/BusinessCatDetailsAdaptor$OnCatDetailAdaptorClick;", "()V", "catDataDetailResponse", "Lcom/milkyway/gbusiness/models/CategoryDataDetailsClass;", "getCatDataDetailResponse", "()Lcom/milkyway/gbusiness/models/CategoryDataDetailsClass;", "setCatDataDetailResponse", "(Lcom/milkyway/gbusiness/models/CategoryDataDetailsClass;)V", "catDataList", "", "Lcom/milkyway/gbusiness/models/CategoryDataDetailsClass$Data$TemplateDetail;", "catId", "", "catName", "", "clearQueryImageView", "Landroid/widget/ImageView;", "email", "etSearch", "Landroidx/appcompat/widget/AppCompatEditText;", "imgUrl", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mView", "Landroid/view/View;", "mViewError", "myBusinessCatDetailsBack", "name", "noSearchResultsFoundText", "Landroid/widget/TextView;", "phone", "query", "rvCategoryData", "Landroidx/recyclerview/widget/RecyclerView;", "subCatId", "voiceSearchImageView", "alertErrorDialog", "", "errorBody", "Lcom/milkyway/gbusiness/models/BusinessEnqErrorResponse;", "alertQuoteDialog", "userId", "callApiBusinessEnquiry", "finalDialog", "Landroid/app/Dialog;", "filterWithQuery", "getCategoryDetailsApi", "(Ljava/lang/Integer;)V", "initializeView", "view", "isValidMail", "", "mail", "isValidMobile", "mobile", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "onBtnClickedQuote", "pos", "list", "onBtnClickedWebsite", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onFilterChanged", "filterQuery", "onItemClicked", "position", "onResume", "setCategoryDataAdaptor", "toggleImageView", "toggleRecyclerView", "sportsList", "validate", "app_debug"})
public final class BusinessCatDetailsFragment extends androidx.fragment.app.Fragment implements com.milkyway.gbusiness.adaptor.BusinessCatDetailsAdaptor.OnCatDetailAdaptorClick {
    public android.content.Context mContext;
    public com.milkyway.gbusiness.models.CategoryDataDetailsClass catDataDetailResponse;
    private androidx.recyclerview.widget.RecyclerView rvCategoryData;
    private android.widget.ImageView myBusinessCatDetailsBack;
    private androidx.appcompat.widget.AppCompatEditText etSearch;
    private android.widget.TextView noSearchResultsFoundText;
    private java.util.List<com.milkyway.gbusiness.models.CategoryDataDetailsClass.Data.TemplateDetail> catDataList;
    private android.widget.ImageView clearQueryImageView;
    private android.widget.ImageView voiceSearchImageView;
    private java.lang.String name;
    private java.lang.String email;
    private java.lang.String phone;
    private java.lang.String query;
    private android.view.View mView;
    private android.view.View mViewError;
    private int subCatId = 0;
    private int catId = 0;
    private java.lang.String catName = "";
    private java.lang.String imgUrl = "";
    private java.util.HashMap _$_findViewCache;
    
    public BusinessCatDetailsFragment() {
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
    public final com.milkyway.gbusiness.models.CategoryDataDetailsClass getCatDataDetailResponse() {
        return null;
    }
    
    public final void setCatDataDetailResponse(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.CategoryDataDetailsClass p0) {
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
    
    private final void filterWithQuery(java.lang.String query) {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void toggleRecyclerView(java.util.List<com.milkyway.gbusiness.models.CategoryDataDetailsClass.Data.TemplateDetail> sportsList) {
    }
    
    private final void toggleImageView(java.lang.String query) {
    }
    
    private final java.util.List<com.milkyway.gbusiness.models.CategoryDataDetailsClass.Data.TemplateDetail> onFilterChanged(java.lang.String filterQuery) {
        return null;
    }
    
    private final void getCategoryDetailsApi(java.lang.Integer catId) {
    }
    
    private final void setCategoryDataAdaptor(java.util.List<com.milkyway.gbusiness.models.CategoryDataDetailsClass.Data.TemplateDetail> catDataList) {
    }
    
    @java.lang.Override()
    public void onItemClicked(int position) {
    }
    
    @java.lang.Override()
    public void onBtnClickedWebsite(int pos, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.CategoryDataDetailsClass.Data.TemplateDetail list) {
    }
    
    @java.lang.Override()
    public void onBtnClickedQuote(int pos, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.CategoryDataDetailsClass.Data.TemplateDetail list) {
    }
    
    private final void alertQuoteDialog(int userId) {
    }
    
    private final boolean validate() {
        return false;
    }
    
    private final void callApiBusinessEnquiry(int userId, java.lang.String name, java.lang.String email, java.lang.String phone, java.lang.String query, android.app.Dialog finalDialog) {
    }
    
    public final void alertErrorDialog(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.BusinessEnqErrorResponse errorBody) {
    }
    
    private final boolean isValidMail(java.lang.String mail) {
        return false;
    }
    
    private final boolean isValidMobile(java.lang.String mobile) {
        return false;
    }
    
    @java.lang.Override()
    public void onResume() {
    }
}