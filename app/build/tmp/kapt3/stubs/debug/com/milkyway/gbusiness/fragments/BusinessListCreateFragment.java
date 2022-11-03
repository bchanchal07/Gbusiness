package com.milkyway.gbusiness.fragments;

import java.lang.System;

/**
 * A simple [Fragment] subclass.
 * Use the [BusinessListCreateFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00da\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010W\u001a\u00020XH\u0002J\"\u0010Y\u001a\u00020X2\b\u0010Z\u001a\u0004\u0018\u0001042\u0006\u0010A\u001a\u00020B2\u0006\u0010[\u001a\u00020BH\u0002J\b\u0010\\\u001a\u00020XH\u0002J\u001a\u0010]\u001a\u00020X2\u0006\u0010^\u001a\u00020B2\b\b\u0002\u0010_\u001a\u00020`H\u0002J\u001a\u0010a\u001a\u00020X2\u0006\u0010A\u001a\u00020B2\b\b\u0002\u0010b\u001a\u00020BH\u0002J\u0010\u0010c\u001a\u00020X2\u0006\u0010d\u001a\u00020eH\u0002J\u0010\u0010f\u001a\u00020X2\u0006\u0010d\u001a\u00020eH\u0002J\u001c\u0010g\u001a\b\u0012\u0004\u0012\u00020`0h2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u001e\u0010i\u001a\b\u0012\u0004\u0012\u00020`0h2\u000e\u0010j\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\bH\u0002J\u001e\u0010k\u001a\b\u0012\u0004\u0012\u00020`0h2\u000e\u0010l\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010\bH\u0002J\u001c\u0010m\u001a\b\u0012\u0004\u0012\u00020`0h2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0\bH\u0002J\u0010\u0010n\u001a\u00020X2\u0006\u0010o\u001a\u000206H\u0016J\u0012\u0010p\u001a\u00020X2\b\u0010q\u001a\u0004\u0018\u00010rH\u0016J&\u0010s\u001a\u0004\u0018\u00010e2\u0006\u0010t\u001a\u00020u2\b\u0010v\u001a\u0004\u0018\u00010w2\b\u0010q\u001a\u0004\u0018\u00010rH\u0016J\u0010\u0010x\u001a\u00020X2\u0006\u0010y\u001a\u00020zH\u0002J\u0010\u0010{\u001a\u00020X2\u0006\u0010d\u001a\u00020eH\u0002J\b\u0010|\u001a\u00020}H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082.\u00a2\u0006\u0002\n\u0000R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010/\u001a\u0010\u0012\f\u0012\n 2*\u0004\u0018\u0001010100X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u00105\u001a\u000206X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020<X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020<X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020<X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020<X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020<X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010C\u001a\u00020BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010H\u001a\u00020BX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010E\"\u0004\bJ\u0010GR\u000e\u0010K\u001a\u00020BX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010L\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\r\"\u0004\bO\u0010\u000fR\u0014\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020SX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020SX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020SX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020SX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006~"}, d2 = {"Lcom/milkyway/gbusiness/fragments/BusinessListCreateFragment;", "Landroidx/fragment/app/Fragment;", "()V", "btnCreateBusinessData", "Landroidx/appcompat/widget/AppCompatButton;", "cCPickerBusinessListing", "Lcom/hbb20/CountryCodePicker;", "categoryDataList", "", "Lcom/milkyway/gbusiness/models/CategoryDataClass$Data;", "cityList", "Lcom/milkyway/gbusiness/models/CityDataClass$City;", "getCityList", "()Ljava/util/List;", "setCityList", "(Ljava/util/List;)V", "countryList", "Lcom/milkyway/gbusiness/models/CountryDataClass$Country;", "getCountryList", "setCountryList", "createBusinessListBack", "Landroid/widget/ImageView;", "etAboutUsPageCreate", "Landroid/widget/EditText;", "etBusinessAddress", "etBusinessCity", "etBusinessNameCreate", "etBusinessSubdomainUrl", "etBusinessZipCode", "etEmailCreate", "etFacebookUrlCreate", "etInstagramUrlCreate", "etLinkedinUrlCreate", "etMobileBusinessListing", "Lcom/google/android/material/textfield/TextInputEditText;", "etSellerUrlCreate", "etTwitterUrlCreate", "etWebUrlCreate", "fsvBusinessCategoryCreate", "Llibs/mjn/fieldset/FieldSetView;", "fsvBusinessCountry", "fsvBusinessState", "fsvBusinessSubcategoryCreate", "ivBusinessLogoCreate", "ivCameraCreate", "listData", "Lcom/milkyway/gbusiness/models/BusinessListingResponse$Data;", "logoImageLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mBusinessLogoImageUri", "Landroid/net/Uri;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "searchableSpinnerCategory", "Lcom/leo/searchablespinner/SearchableSpinner;", "searchableSpinnerCity", "searchableSpinnerCountry", "searchableSpinnerState", "searchableSpinnerSubcategory", "selectedCatId", "", "selectedCountryId", "getSelectedCountryId", "()I", "setSelectedCountryId", "(I)V", "selectedStateId", "getSelectedStateId", "setSelectedStateId", "selectedSubcatId", "stateList", "Lcom/milkyway/gbusiness/models/StateDataClass$State;", "getStateList", "setStateList", "subCatDataList", "Lcom/milkyway/gbusiness/models/SubCategoryDataClass$Subcategory;", "tvBusinessCategoryCreate", "Landroid/widget/TextView;", "tvBusinessCountry", "tvBusinessState", "tvBusinessSubcategoryCreate", "callCategoryApi", "", "callCreateBusinessListApi", "fileUri", "selectedSubCatId", "callGetCountriesApi", "callGetStatesApi", "countryId", "stateCode", "", "callSubcategoryApi", "subCatIdDefault", "clickListener", "view", "Landroid/view/View;", "initializeView", "loadCategoryNameList", "Ljava/util/ArrayList;", "loadCountriesNameList", "countryArrayList", "loadStateNameList", "stateArrayList", "loadSubcategoryNameList", "onAttach", "context", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "parseError", "activityResult", "Landroidx/activity/result/ActivityResult;", "pickBusinessLogo", "validate", "", "app_debug"})
public final class BusinessListCreateFragment extends androidx.fragment.app.Fragment {
    public android.content.Context mContext;
    private android.widget.ImageView createBusinessListBack;
    private android.widget.ImageView ivBusinessLogoCreate;
    private android.widget.ImageView ivCameraCreate;
    private libs.mjn.fieldset.FieldSetView fsvBusinessCategoryCreate;
    private libs.mjn.fieldset.FieldSetView fsvBusinessSubcategoryCreate;
    private libs.mjn.fieldset.FieldSetView fsvBusinessCountry;
    private libs.mjn.fieldset.FieldSetView fsvBusinessState;
    private android.widget.TextView tvBusinessCategoryCreate;
    private android.widget.TextView tvBusinessSubcategoryCreate;
    private android.widget.TextView tvBusinessCountry;
    private android.widget.TextView tvBusinessState;
    private androidx.appcompat.widget.AppCompatButton btnCreateBusinessData;
    private android.widget.EditText etBusinessNameCreate;
    private android.widget.EditText etEmailCreate;
    private android.widget.EditText etWebUrlCreate;
    private android.widget.EditText etSellerUrlCreate;
    private android.widget.EditText etFacebookUrlCreate;
    private android.widget.EditText etTwitterUrlCreate;
    private android.widget.EditText etInstagramUrlCreate;
    private android.widget.EditText etLinkedinUrlCreate;
    private android.widget.EditText etBusinessSubdomainUrl;
    private com.google.android.material.textfield.TextInputEditText etMobileBusinessListing;
    private com.hbb20.CountryCodePicker cCPickerBusinessListing;
    private android.widget.EditText etBusinessCity;
    private android.widget.EditText etBusinessZipCode;
    private android.widget.EditText etBusinessAddress;
    private android.widget.EditText etAboutUsPageCreate;
    private com.milkyway.gbusiness.models.BusinessListingResponse.Data listData;
    private com.leo.searchablespinner.SearchableSpinner searchableSpinnerCategory;
    private com.leo.searchablespinner.SearchableSpinner searchableSpinnerSubcategory;
    private java.util.List<com.milkyway.gbusiness.models.CategoryDataClass.Data> categoryDataList;
    private java.util.List<com.milkyway.gbusiness.models.SubCategoryDataClass.Subcategory> subCatDataList;
    private int selectedCatId = 0;
    private int selectedSubcatId = 0;
    private android.net.Uri mBusinessLogoImageUri;
    private com.leo.searchablespinner.SearchableSpinner searchableSpinnerCountry;
    private com.leo.searchablespinner.SearchableSpinner searchableSpinnerState;
    private com.leo.searchablespinner.SearchableSpinner searchableSpinnerCity;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.milkyway.gbusiness.models.CountryDataClass.Country> countryList;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.milkyway.gbusiness.models.StateDataClass.State> stateList;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.milkyway.gbusiness.models.CityDataClass.City> cityList;
    private int selectedCountryId = 0;
    private int selectedStateId = 0;
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.milkyway.gbusiness.models.CountryDataClass.Country> getCountryList() {
        return null;
    }
    
    public final void setCountryList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.milkyway.gbusiness.models.CountryDataClass.Country> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.milkyway.gbusiness.models.StateDataClass.State> getStateList() {
        return null;
    }
    
    public final void setStateList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.milkyway.gbusiness.models.StateDataClass.State> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.milkyway.gbusiness.models.CityDataClass.City> getCityList() {
        return null;
    }
    
    public final void setCityList(@org.jetbrains.annotations.Nullable()
    java.util.List<com.milkyway.gbusiness.models.CityDataClass.City> p0) {
    }
    
    public final int getSelectedCountryId() {
        return 0;
    }
    
    public final void setSelectedCountryId(int p0) {
    }
    
    public final int getSelectedStateId() {
        return 0;
    }
    
    public final void setSelectedStateId(int p0) {
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
    
    private final void callCreateBusinessListApi(android.net.Uri fileUri, int selectedCatId, int selectedSubCatId) {
    }
    
    private final java.util.ArrayList<java.lang.String> loadCountriesNameList(java.util.List<com.milkyway.gbusiness.models.CountryDataClass.Country> countryArrayList) {
        return null;
    }
    
    private final java.util.ArrayList<java.lang.String> loadStateNameList(java.util.List<com.milkyway.gbusiness.models.StateDataClass.State> stateArrayList) {
        return null;
    }
    
    private final void callGetCountriesApi() {
    }
    
    private final void callGetStatesApi(int countryId, java.lang.String stateCode) {
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
    
    private final void parseError(androidx.activity.result.ActivityResult activityResult) {
    }
    
    private final void pickBusinessLogo(android.view.View view) {
    }
    
    private final boolean validate() {
        return false;
    }
}