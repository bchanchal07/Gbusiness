package com.milkyway.gbusiness.fragments;

import java.lang.System;

/**
 * A simple [Fragment] subclass.
 * Use the [BusinessListCreateFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010-\u001a\u00020.H\u0002J\"\u0010/\u001a\u00020.2\b\u00100\u001a\u0004\u0018\u00010\u001b2\u0006\u0010%\u001a\u00020&2\u0006\u00101\u001a\u00020&H\u0002J\u001a\u00102\u001a\u00020.2\u0006\u0010%\u001a\u00020&2\b\b\u0002\u00103\u001a\u00020&H\u0002J\u0010\u00104\u001a\u00020.2\u0006\u00105\u001a\u000206H\u0002J\u0010\u00107\u001a\u00020.2\u0006\u00105\u001a\u000206H\u0002J\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020:092\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020:092\f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u0006H\u0002J\u0010\u0010<\u001a\u00020.2\u0006\u0010=\u001a\u00020\u001dH\u0016J\u0012\u0010>\u001a\u00020.2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J&\u0010A\u001a\u0004\u0018\u0001062\u0006\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u0010\u0010F\u001a\u00020.2\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010I\u001a\u00020.2\u0006\u00105\u001a\u000206H\u0002J\b\u0010J\u001a\u00020KH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u00180\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006L"}, d2 = {"Lcom/milkyway/gbusiness/fragments/BusinessListCreateFragment;", "Landroidx/fragment/app/Fragment;", "()V", "btnCreateBusinessData", "Landroidx/appcompat/widget/AppCompatButton;", "categoryDataList", "", "Lcom/milkyway/gbusiness/models/CategoryDataClass$Data;", "createBusinessListBack", "Landroid/widget/ImageView;", "etAboutUsPageCreate", "Landroid/widget/EditText;", "etBusinessNameCreate", "etEmailCreate", "etWebUrlCreate", "fsvBusinessCategoryCreate", "Llibs/mjn/fieldset/FieldSetView;", "fsvBusinessSubcategoryCreate", "ivBusinessLogoCreate", "ivCameraCreate", "listData", "Lcom/milkyway/gbusiness/models/BusinessListingResponse$Data;", "logoImageLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mBusinessLogoImageUri", "Landroid/net/Uri;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "searchableSpinnerCategory", "Lcom/leo/searchablespinner/SearchableSpinner;", "searchableSpinnerSubcategory", "selectedCatId", "", "selectedSubcatId", "subCatDataList", "Lcom/milkyway/gbusiness/models/SubCategoryDataClass$Subcategory;", "tvBusinessCategoryCreate", "Landroid/widget/TextView;", "tvBusinessSubcategoryCreate", "callCategoryApi", "", "callCreateBusinessListApi", "fileUri", "selectedSubCatId", "callSubcategoryApi", "subCatIdDefault", "clickListener", "view", "Landroid/view/View;", "initializeView", "loadCategoryNameList", "Ljava/util/ArrayList;", "", "loadSubcategoryNameList", "onAttach", "context", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "parseError", "activityResult", "Landroidx/activity/result/ActivityResult;", "pickBusinessLogo", "validate", "", "app_debug"})
public final class BusinessListCreateFragment extends androidx.fragment.app.Fragment {
    public android.content.Context mContext;
    private android.widget.ImageView createBusinessListBack;
    private android.widget.ImageView ivBusinessLogoCreate;
    private android.widget.ImageView ivCameraCreate;
    private libs.mjn.fieldset.FieldSetView fsvBusinessCategoryCreate;
    private libs.mjn.fieldset.FieldSetView fsvBusinessSubcategoryCreate;
    private android.widget.TextView tvBusinessCategoryCreate;
    private android.widget.TextView tvBusinessSubcategoryCreate;
    private androidx.appcompat.widget.AppCompatButton btnCreateBusinessData;
    private android.widget.EditText etBusinessNameCreate;
    private android.widget.EditText etEmailCreate;
    private android.widget.EditText etWebUrlCreate;
    private android.widget.EditText etAboutUsPageCreate;
    private com.milkyway.gbusiness.models.BusinessListingResponse.Data listData;
    private com.leo.searchablespinner.SearchableSpinner searchableSpinnerCategory;
    private com.leo.searchablespinner.SearchableSpinner searchableSpinnerSubcategory;
    private java.util.List<com.milkyway.gbusiness.models.CategoryDataClass.Data> categoryDataList;
    private java.util.List<com.milkyway.gbusiness.models.SubCategoryDataClass.Subcategory> subCatDataList;
    private int selectedCatId = 0;
    private int selectedSubcatId = 0;
    private android.net.Uri mBusinessLogoImageUri;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> logoImageLauncher = null;
    private java.util.HashMap _$_findViewCache;
    
    public BusinessListCreateFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
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
    
    private final void clickListener(android.view.View view) {
    }
    
    private final void initializeView(android.view.View view) {
    }
    
    private final void callCategoryApi() {
    }
    
    private final void callSubcategoryApi(int selectedCatId, int subCatIdDefault) {
    }
    
    private final java.util.ArrayList<java.lang.String> loadSubcategoryNameList(java.util.List<com.milkyway.gbusiness.models.SubCategoryDataClass.Subcategory> subCatDataList) {
        return null;
    }
    
    private final java.util.ArrayList<java.lang.String> loadCategoryNameList(java.util.List<com.milkyway.gbusiness.models.CategoryDataClass.Data> categoryDataList) {
        return null;
    }
    
    private final void callCreateBusinessListApi(android.net.Uri fileUri, int selectedCatId, int selectedSubCatId) {
    }
    
    private final void parseError(androidx.activity.result.ActivityResult activityResult) {
    }
    
    private final void pickBusinessLogo(android.view.View view) {
    }
    
    private final boolean validate() {
        return false;
    }
}