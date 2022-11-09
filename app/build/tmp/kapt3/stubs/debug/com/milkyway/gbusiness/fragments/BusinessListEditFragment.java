package com.milkyway.gbusiness.fragments;

import java.lang.System;

/**
 * A simple [Fragment] subclass.
 * Use the [BusinessListEditFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00fe\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010v\u001a\u00020wJ\b\u0010x\u001a\u00020wH\u0002J\b\u0010y\u001a\u00020wH\u0002J\u001a\u0010z\u001a\u00020w2\u0006\u0010{\u001a\u00020Y2\b\b\u0002\u0010|\u001a\u00020\u0019H\u0002J\u001a\u0010}\u001a\u00020w2\u0006\u0010X\u001a\u00020Y2\b\b\u0002\u0010~\u001a\u00020YH\u0002J$\u0010\u007f\u001a\u00020w2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010J2\u0006\u0010X\u001a\u00020Y2\u0007\u0010\u0081\u0001\u001a\u00020YH\u0002J\u0013\u0010\u0082\u0001\u001a\u00020w2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0002J\u0013\u0010\u0085\u0001\u001a\u00020w2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0002J\u001d\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020\u00190\"2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J \u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020\u00190\"2\u000f\u0010\u0088\u0001\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\fH\u0002J \u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020\u00190\"2\u000f\u0010\u008a\u0001\u001a\n\u0012\u0004\u0012\u00020d\u0018\u00010\fH\u0002J\u001d\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020\u00190\"2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020h0\fH\u0002J\u0012\u0010\u008c\u0001\u001a\u00020w2\u0007\u0010\u008d\u0001\u001a\u00020LH\u0016J\t\u0010\u008e\u0001\u001a\u00020wH\u0016J\u0015\u0010\u008f\u0001\u001a\u00020w2\n\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u0001H\u0016J.\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0084\u00012\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u00012\n\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0091\u0001H\u0016J\u0013\u0010\u0097\u0001\u001a\u00020w2\b\u0010\u0098\u0001\u001a\u00030\u0099\u0001H\u0002J\u0013\u0010\u009a\u0001\u001a\u00020w2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0002J\t\u0010\u009b\u0001\u001a\u00020wH\u0002J\u0011\u0010\u009c\u0001\u001a\u00020w2\u0006\u0010A\u001a\u00020BH\u0002J\n\u0010\u009d\u0001\u001a\u00030\u009e\u0001H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082.\u00a2\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020&X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020&X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020&X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020&X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020&X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020&X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020&X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020&X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020&X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020&X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020&X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020&X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020&X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000207X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000207X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u000207X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u000207X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u000207X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u000207X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u000207X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020$X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020$X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010E\u001a\u0010\u0012\f\u0012\n H*\u0004\u0018\u00010G0G0FX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010JX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010K\u001a\u00020LX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u000e\u0010Q\u001a\u00020RX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020TX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020TX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020TX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020TX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020YX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010Z\u001a\u00020YX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001a\u0010_\u001a\u00020YX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\\\"\u0004\ba\u0010^R\u000e\u0010b\u001a\u00020YX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010c\u001a\n\u0012\u0004\u0012\u00020d\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\be\u0010\u0011\"\u0004\bf\u0010\u0013R\u0014\u0010g\u001a\b\u0012\u0004\u0012\u00020h0\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020jX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020jX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020jX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010m\u001a\u00020jX\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010n\u001a\u0004\u0018\u00010oX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u000e\u0010t\u001a\u00020uX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u009f\u0001"}, d2 = {"Lcom/milkyway/gbusiness/fragments/BusinessListEditFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/hbb20/CountryCodePicker$OnCountryChangeListener;", "()V", "CCP", "Lcom/hbb20/CountryCodePicker;", "btnUpdateBusinessData", "Landroidx/appcompat/widget/AppCompatButton;", "card_view_hide_list", "Landroidx/cardview/widget/CardView;", "card_view_show_list", "categoryDataList", "", "Lcom/milkyway/gbusiness/models/CategoryDataClass$Data;", "cityList", "Lcom/milkyway/gbusiness/models/CityDataClass$City;", "getCityList", "()Ljava/util/List;", "setCityList", "(Ljava/util/List;)V", "countryList", "Lcom/milkyway/gbusiness/models/CountryDataClass$Country;", "getCountryList", "setCountryList", "county_code", "", "getCounty_code", "()Ljava/lang/String;", "setCounty_code", "(Ljava/lang/String;)V", "county_name_code", "getCounty_name_code", "setCounty_name_code", "daysNameList", "Ljava/util/ArrayList;", "editBusinessListingBack", "Landroid/widget/ImageView;", "etAboutUsPageUpdate", "Landroid/widget/EditText;", "etBusinessAddress", "etBusinessCity", "etBusinessEstablishDateUpdate", "etBusinessNameUpdate", "etBusinessSubdomainUrl", "etBusinessZipCode", "etEmailUpdate", "etFacebookUrlCreate", "etInstagramUrlCreate", "etLinkedinUrlCreate", "etMobileBusinessListing", "Lcom/google/android/material/textfield/TextInputEditText;", "etSellerUrlCreate", "etTwitterUrlCreate", "etWebUrlUpdate", "fsvBusinessCategoryUpdate", "Llibs/mjn/fieldset/FieldSetView;", "fsvBusinessCountry", "fsvBusinessState", "fsvBusinessSubcategoryUpdate", "fsvLayoutFacebookUrl", "fsvLayoutInstagramUrl", "fsvLayoutLinkedinUrl", "fsvLayoutTwitterUrl", "ivBusinessLogoUpdate", "ivCameraUpdate", "listData", "Lcom/milkyway/gbusiness/models/BusinessListingResponse$Data;", "ll_business_working_hours", "Landroid/widget/LinearLayout;", "logoImageLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mBusinessLogoImageUri", "Landroid/net/Uri;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "rv_working_weekdays", "Landroidx/recyclerview/widget/RecyclerView;", "searchableSpinnerCategory", "Lcom/leo/searchablespinner/SearchableSpinner;", "searchableSpinnerCountry", "searchableSpinnerState", "searchableSpinnerSubcategory", "selectedCatId", "", "selectedCountryId", "getSelectedCountryId", "()I", "setSelectedCountryId", "(I)V", "selectedStateId", "getSelectedStateId", "setSelectedStateId", "selectedSubcatId", "stateList", "Lcom/milkyway/gbusiness/models/StateDataClass$State;", "getStateList", "setStateList", "subCatDataList", "Lcom/milkyway/gbusiness/models/SubCategoryDataClass$Subcategory;", "tvBusinessCategoryUpdate", "Landroid/widget/TextView;", "tvBusinessCountry", "tvBusinessState", "tvBusinessSubcategoryUpdate", "weekdaysNameAdapter", "Lcom/milkyway/gbusiness/adaptor/WeekdaysNameAdapter;", "getWeekdaysNameAdapter", "()Lcom/milkyway/gbusiness/adaptor/WeekdaysNameAdapter;", "setWeekdaysNameAdapter", "(Lcom/milkyway/gbusiness/adaptor/WeekdaysNameAdapter;)V", "workingDaysLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "bindWeekDaysAdapter", "", "callCategoryApi", "callGetCountriesApi", "callGetStatesApi", "countryId", "stateCode", "callSubcategoryApi", "subCatIdDefault", "callUpdateBusinessUpdateApi", "fileUri", "selectedSubCatId", "clickListener", "view", "Landroid/view/View;", "initializeView", "loadCategoryNameList", "loadCountriesNameList", "countryArrayList", "loadStateNameList", "stateArrayList", "loadSubcategoryNameList", "onAttach", "context", "onCountrySelected", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "parseError", "activityResult", "Landroidx/activity/result/ActivityResult;", "pickBusinessLogo", "prepareItems", "setDefaultData", "validate", "", "app_debug"})
public final class BusinessListEditFragment extends androidx.fragment.app.Fragment implements com.hbb20.CountryCodePicker.OnCountryChangeListener {
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
    private android.widget.EditText etBusinessEstablishDateUpdate;
    private android.widget.EditText etBusinessSubdomainUrl;
    private libs.mjn.fieldset.FieldSetView fsvBusinessCountry;
    private libs.mjn.fieldset.FieldSetView fsvBusinessState;
    private android.widget.TextView tvBusinessCountry;
    private android.widget.TextView tvBusinessState;
    private android.widget.EditText etBusinessCity;
    private android.widget.EditText etBusinessZipCode;
    private android.widget.EditText etBusinessAddress;
    private com.google.android.material.textfield.TextInputEditText etMobileBusinessListing;
    private android.widget.EditText etSellerUrlCreate;
    private android.widget.EditText etFacebookUrlCreate;
    private android.widget.EditText etTwitterUrlCreate;
    private android.widget.EditText etInstagramUrlCreate;
    private android.widget.EditText etLinkedinUrlCreate;
    private libs.mjn.fieldset.FieldSetView fsvLayoutFacebookUrl;
    private libs.mjn.fieldset.FieldSetView fsvLayoutTwitterUrl;
    private libs.mjn.fieldset.FieldSetView fsvLayoutInstagramUrl;
    private libs.mjn.fieldset.FieldSetView fsvLayoutLinkedinUrl;
    private com.milkyway.gbusiness.models.BusinessListingResponse.Data listData;
    private com.leo.searchablespinner.SearchableSpinner searchableSpinnerCategory;
    private com.leo.searchablespinner.SearchableSpinner searchableSpinnerSubcategory;
    private java.util.List<com.milkyway.gbusiness.models.CategoryDataClass.Data> categoryDataList;
    private java.util.List<com.milkyway.gbusiness.models.SubCategoryDataClass.Subcategory> subCatDataList;
    private int selectedCatId = 0;
    private int selectedSubcatId = 0;
    private android.net.Uri mBusinessLogoImageUri;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String county_name_code = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String county_code = "";
    private androidx.recyclerview.widget.RecyclerView rv_working_weekdays;
    private androidx.recyclerview.widget.LinearLayoutManager workingDaysLayoutManager;
    private android.widget.LinearLayout ll_business_working_hours;
    private androidx.cardview.widget.CardView card_view_show_list;
    private androidx.cardview.widget.CardView card_view_hide_list;
    private com.hbb20.CountryCodePicker CCP;
    @org.jetbrains.annotations.Nullable()
    private com.milkyway.gbusiness.adaptor.WeekdaysNameAdapter weekdaysNameAdapter;
    private final java.util.ArrayList<java.lang.String> daysNameList = null;
    private com.leo.searchablespinner.SearchableSpinner searchableSpinnerCountry;
    private com.leo.searchablespinner.SearchableSpinner searchableSpinnerState;
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCounty_name_code() {
        return null;
    }
    
    public final void setCounty_name_code(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCounty_code() {
        return null;
    }
    
    public final void setCounty_code(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.milkyway.gbusiness.adaptor.WeekdaysNameAdapter getWeekdaysNameAdapter() {
        return null;
    }
    
    public final void setWeekdaysNameAdapter(@org.jetbrains.annotations.Nullable()
    com.milkyway.gbusiness.adaptor.WeekdaysNameAdapter p0) {
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
    
    public final void bindWeekDaysAdapter() {
    }
    
    private final void prepareItems() {
    }
    
    private final void initializeView(android.view.View view) {
    }
    
    private final void callUpdateBusinessUpdateApi(android.net.Uri fileUri, int selectedCatId, int selectedSubCatId) {
    }
    
    private final void parseError(androidx.activity.result.ActivityResult activityResult) {
    }
    
    private final void pickBusinessLogo(android.view.View view) {
    }
    
    private final java.util.ArrayList<java.lang.String> loadSubcategoryNameList(java.util.List<com.milkyway.gbusiness.models.SubCategoryDataClass.Subcategory> subCatDataList) {
        return null;
    }
    
    private final java.util.ArrayList<java.lang.String> loadCategoryNameList(java.util.List<com.milkyway.gbusiness.models.CategoryDataClass.Data> categoryDataList) {
        return null;
    }
    
    private final void callCategoryApi() {
    }
    
    private final void callSubcategoryApi(int selectedCatId, int subCatIdDefault) {
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
    
    private final void setDefaultData(com.milkyway.gbusiness.models.BusinessListingResponse.Data listData) {
    }
    
    private final boolean validate() {
        return false;
    }
    
    @java.lang.Override()
    public void onCountrySelected() {
    }
}