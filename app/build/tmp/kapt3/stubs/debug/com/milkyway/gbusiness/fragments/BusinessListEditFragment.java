package com.milkyway.gbusiness.fragments;

import java.lang.System;

/**
 * A simple [Fragment] subclass.
 * Use the [BusinessListEditFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u00103\u001a\u000204H\u0002J\u001a\u00105\u001a\u0002042\u0006\u0010,\u001a\u00020\t2\b\b\u0002\u00106\u001a\u00020\tH\u0002J\"\u00107\u001a\u0002042\b\u00108\u001a\u0004\u0018\u00010\"2\u0006\u0010,\u001a\u00020\t2\u0006\u00109\u001a\u00020\tH\u0002J\u0010\u0010:\u001a\u0002042\u0006\u0010;\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u0002042\u0006\u0010;\u001a\u00020<H\u0002J\u001c\u0010>\u001a\b\u0012\u0004\u0012\u00020\u000e0?2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020\u000e0?2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u0006H\u0002J\u0010\u0010A\u001a\u0002042\u0006\u0010B\u001a\u00020$H\u0016J\u0012\u0010C\u001a\u0002042\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J&\u0010F\u001a\u0004\u0018\u00010<2\u0006\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010J2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u0010\u0010K\u001a\u0002042\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010N\u001a\u0002042\u0006\u0010;\u001a\u00020<H\u0002J\u0010\u0010O\u001a\u0002042\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010P\u001a\u00020QH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u001d0\u001d0\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020$X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u000e\u0010)\u001a\u00020*X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020*X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000201X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006R"}, d2 = {"Lcom/milkyway/gbusiness/fragments/BusinessListEditFragment;", "Landroidx/fragment/app/Fragment;", "()V", "btnUpdateBusinessData", "Landroidx/appcompat/widget/AppCompatButton;", "categoryDataList", "", "Lcom/milkyway/gbusiness/models/CategoryDataClass$Data;", "chooseCatID", "", "chooseSubCatID", "editBusinessListingBack", "Landroid/widget/ImageView;", "encodedString", "", "etAboutUsPageUpdate", "Landroid/widget/EditText;", "etBusinessNameUpdate", "etEmailUpdate", "etWebUrlUpdate", "fsvBusinessCategoryUpdate", "Llibs/mjn/fieldset/FieldSetView;", "fsvBusinessSubcategoryUpdate", "ivBusinessLogoUpdate", "ivCameraUpdate", "listData", "Lcom/milkyway/gbusiness/models/BusinessListingResponse$Data;", "logoImageLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mBottomSheetDialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "mBusinessLogoImageUri", "Landroid/net/Uri;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "searchableSpinnerCategory", "Lcom/leo/searchablespinner/SearchableSpinner;", "searchableSpinnerSubcategory", "selectedCatId", "selectedSubcatId", "subCatDataList", "Lcom/milkyway/gbusiness/models/SubCategoryDataClass$Subcategory;", "tvBusinessCategoryUpdate", "Landroid/widget/TextView;", "tvBusinessSubcategoryUpdate", "callCategoryApi", "", "callSubcategoryApi", "subCatIdDefault", "callUpdateBusinessUpdateApi", "fileUri", "selectedSubCatId", "clickListener", "view", "Landroid/view/View;", "initializeView", "loadCategoryNameList", "Ljava/util/ArrayList;", "loadSubcategoryNameList", "onAttach", "context", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "parseError", "activityResult", "Landroidx/activity/result/ActivityResult;", "pickBusinessLogo", "setDefaultData", "validate", "", "app_debug"})
public final class BusinessListEditFragment extends androidx.fragment.app.Fragment {
    public android.content.Context mContext;
    private android.widget.ImageView editBusinessListingBack;
    private android.widget.ImageView ivBusinessLogoUpdate;
    private android.widget.ImageView ivCameraUpdate;
    private libs.mjn.fieldset.FieldSetView fsvBusinessCategoryUpdate;
    private libs.mjn.fieldset.FieldSetView fsvBusinessSubcategoryUpdate;
    private android.widget.TextView tvBusinessCategoryUpdate;
    private android.widget.TextView tvBusinessSubcategoryUpdate;
    private androidx.appcompat.widget.AppCompatButton btnUpdateBusinessData;
    private android.widget.EditText etBusinessNameUpdate;
    private android.widget.EditText etEmailUpdate;
    private android.widget.EditText etWebUrlUpdate;
    private android.widget.EditText etAboutUsPageUpdate;
    private com.milkyway.gbusiness.models.BusinessListingResponse.Data listData;
    private com.leo.searchablespinner.SearchableSpinner searchableSpinnerCategory;
    private com.leo.searchablespinner.SearchableSpinner searchableSpinnerSubcategory;
    private java.util.List<com.milkyway.gbusiness.models.CategoryDataClass.Data> categoryDataList;
    private java.util.List<com.milkyway.gbusiness.models.SubCategoryDataClass.Subcategory> subCatDataList;
    private int selectedCatId = 0;
    private int selectedSubcatId = 0;
    private int chooseCatID = 0;
    private int chooseSubCatID = 0;
    private java.lang.String encodedString;
    private com.google.android.material.bottomsheet.BottomSheetDialog mBottomSheetDialog;
    private android.net.Uri mBusinessLogoImageUri;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> logoImageLauncher = null;
    private java.util.HashMap _$_findViewCache;
    
    public BusinessListEditFragment() {
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
    
    private final void parseError(androidx.activity.result.ActivityResult activityResult) {
    }
    
    private final void pickBusinessLogo(android.view.View view) {
    }
    
    private final void callUpdateBusinessUpdateApi(android.net.Uri fileUri, int selectedCatId, int selectedSubCatId) {
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
    
    private final void setDefaultData(com.milkyway.gbusiness.models.BusinessListingResponse.Data listData) {
    }
    
    private final boolean validate() {
        return false;
    }
}