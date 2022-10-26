package com.milkyway.gbusiness.fragments;

import java.lang.System;

/**
 * A simple [Fragment] subclass.
 * Use the [BusinessListingDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010S\u001a\u00020TH\u0002J\u0010\u0010U\u001a\u00020T2\u0006\u00109\u001a\u00020\u001cH\u0002J\b\u0010V\u001a\u00020TH\u0002J\u001a\u0010W\u001a\u00020T2\u0006\u0010(\u001a\u00020\u001c2\b\b\u0002\u0010X\u001a\u00020\u0012H\u0002J\u0010\u0010Y\u001a\u00020T2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010Z\u001a\u00020T2\u0006\u0010[\u001a\u00020\\H\u0002J\u0010\u0010]\u001a\u00020T2\u0006\u0010[\u001a\u00020\\H\u0002J\u0010\u0010^\u001a\u00020T2\u0006\u0010_\u001a\u00020.H\u0016J\u0012\u0010`\u001a\u00020T2\b\u0010a\u001a\u0004\u0018\u00010\u0005H\u0016J&\u0010b\u001a\u0004\u0018\u00010\\2\u0006\u0010c\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u00010f2\b\u0010a\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010g\u001a\u00020TH\u0016J\u0018\u0010h\u001a\u00020T2\u0006\u0010i\u001a\u00020\u001c2\u0006\u0010j\u001a\u000208H\u0016J \u0010k\u001a\u00020T2\u0006\u0010l\u001a\u00020\u00122\u0006\u0010m\u001a\u00020\u00122\u0006\u0010n\u001a\u00020\u0012H\u0002J\u0010\u0010o\u001a\u00020T2\u0006\u0010p\u001a\u00020\u0005H\u0002J(\u0010q\u001a\u00020T2\u0006\u0010r\u001a\u00020\u00122\u0006\u0010s\u001a\u00020\u00122\u0006\u0010t\u001a\u00020\u00122\u0006\u0010u\u001a\u00020\u0012H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001a\u0010(\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001e\"\u0004\b*\u0010 R\u000e\u0010+\u001a\u00020,X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020,X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020807X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001e\"\u0004\b;\u0010 R\u001a\u0010<\u001a\u00020=X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010B\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001e\"\u0004\bD\u0010 R \u0010E\u001a\b\u0012\u0004\u0012\u00020F0\"X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010%\"\u0004\bH\u0010\'R\u000e\u0010I\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020KX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020KX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020KX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020KX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020KX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020KX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020KX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006v"}, d2 = {"Lcom/milkyway/gbusiness/fragments/BusinessListingDetailsFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/milkyway/gbusiness/adaptor/SocialMediaIconsAdaptor$SocialMediaAdaptorClick;", "()V", "argsBack", "Landroid/os/Bundle;", "getArgsBack", "()Landroid/os/Bundle;", "setArgsBack", "(Landroid/os/Bundle;)V", "btnEmailId", "Landroidx/appcompat/widget/AppCompatButton;", "btnLocation", "btnMobile", "btnPlayStoreLink", "btnSubDomainLink", "btnWebLink", "businessEmail", "", "businessPhone", "businessWebUrl", "catDataResponse", "Lcom/milkyway/gbusiness/models/CategoryDataClass;", "getCatDataResponse", "()Lcom/milkyway/gbusiness/models/CategoryDataClass;", "setCatDataResponse", "(Lcom/milkyway/gbusiness/models/CategoryDataClass;)V", "catId", "", "getCatId", "()I", "setCatId", "(I)V", "catList", "", "Lcom/milkyway/gbusiness/models/CategoryDataClass$Data;", "getCatList", "()Ljava/util/List;", "setCatList", "(Ljava/util/List;)V", "countryId", "getCountryId", "setCountryId", "ivBusinessLogo", "Landroid/widget/ImageView;", "mContext", "Landroid/content/Context;", "myBusinessListingDetailBack", "notAvailable", "rvSocialLinks", "Landroidx/recyclerview/widget/RecyclerView;", "sellerUrl", "socialMediaIconsAdaptor", "Lcom/milkyway/gbusiness/adaptor/SocialMediaIconsAdaptor;", "socialMediaIconsList", "Ljava/util/ArrayList;", "Lcom/milkyway/gbusiness/models/SocialMediaData;", "stateId", "getStateId", "setStateId", "subCatDataResponse", "Lcom/milkyway/gbusiness/models/SubCategoryDataClass;", "getSubCatDataResponse", "()Lcom/milkyway/gbusiness/models/SubCategoryDataClass;", "setSubCatDataResponse", "(Lcom/milkyway/gbusiness/models/SubCategoryDataClass;)V", "subCatId", "getSubCatId", "setSubCatId", "subCatList", "Lcom/milkyway/gbusiness/models/SubCategoryDataClass$Subcategory;", "getSubCatList", "setSubCatList", "subDomainUrl", "tvAboutUs", "Landroid/widget/TextView;", "tvBusinessCategory", "tvBusinessName", "tvBusinessSubcategory", "tvCity", "tvCountry", "tvState", "tvZipCode", "callCategoryApi", "", "callGetCitiesApi", "callGetCountriesApi", "callGetStatesApi", "stateCode", "callSubCategoryApi", "clickListener", "view", "Landroid/view/View;", "initializeView", "onAttach", "context", "onCreate", "savedInstanceState", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onResume", "onSocialItemClicked", "position", "list", "sendEmail", "recipient", "subject", "message", "setData", "args", "setSocialMediaAdapter", "facebookUrl", "linkedinUrl", "twitterUrl", "instagramUrl", "app_debug"})
public final class BusinessListingDetailsFragment extends androidx.fragment.app.Fragment implements com.milkyway.gbusiness.adaptor.SocialMediaIconsAdaptor.SocialMediaAdaptorClick {
    private android.widget.ImageView myBusinessListingDetailBack;
    private androidx.appcompat.widget.AppCompatButton btnLocation;
    private androidx.appcompat.widget.AppCompatButton btnMobile;
    private androidx.appcompat.widget.AppCompatButton btnEmailId;
    private androidx.appcompat.widget.AppCompatButton btnWebLink;
    private androidx.appcompat.widget.AppCompatButton btnPlayStoreLink;
    private androidx.appcompat.widget.AppCompatButton btnSubDomainLink;
    private android.content.Context mContext;
    private android.widget.ImageView ivBusinessLogo;
    private android.widget.TextView tvBusinessName;
    private android.widget.TextView tvBusinessCategory;
    private android.widget.TextView tvBusinessSubcategory;
    private android.widget.TextView tvCountry;
    private android.widget.TextView tvState;
    private android.widget.TextView tvCity;
    private android.widget.TextView tvZipCode;
    private android.widget.TextView tvAboutUs;
    private androidx.recyclerview.widget.RecyclerView rvSocialLinks;
    public android.os.Bundle argsBack;
    private java.lang.String notAvailable = "Not Available";
    private java.util.ArrayList<com.milkyway.gbusiness.models.SocialMediaData> socialMediaIconsList;
    private com.milkyway.gbusiness.adaptor.SocialMediaIconsAdaptor socialMediaIconsAdaptor;
    private int countryId = 0;
    private int stateId = 0;
    private int catId = 0;
    private int subCatId = 0;
    private java.lang.String businessPhone = "";
    private java.lang.String businessEmail = "";
    private java.lang.String businessWebUrl = "";
    private java.lang.String sellerUrl = "";
    private java.lang.String subDomainUrl = "";
    public com.milkyway.gbusiness.models.CategoryDataClass catDataResponse;
    public java.util.List<com.milkyway.gbusiness.models.CategoryDataClass.Data> catList;
    public com.milkyway.gbusiness.models.SubCategoryDataClass subCatDataResponse;
    public java.util.List<com.milkyway.gbusiness.models.SubCategoryDataClass.Subcategory> subCatList;
    private java.util.HashMap _$_findViewCache;
    
    public BusinessListingDetailsFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.os.Bundle getArgsBack() {
        return null;
    }
    
    public final void setArgsBack(@org.jetbrains.annotations.NotNull()
    android.os.Bundle p0) {
    }
    
    public final int getCountryId() {
        return 0;
    }
    
    public final void setCountryId(int p0) {
    }
    
    public final int getStateId() {
        return 0;
    }
    
    public final void setStateId(int p0) {
    }
    
    public final int getCatId() {
        return 0;
    }
    
    public final void setCatId(int p0) {
    }
    
    public final int getSubCatId() {
        return 0;
    }
    
    public final void setSubCatId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.CategoryDataClass getCatDataResponse() {
        return null;
    }
    
    public final void setCatDataResponse(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.CategoryDataClass p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.milkyway.gbusiness.models.CategoryDataClass.Data> getCatList() {
        return null;
    }
    
    public final void setCatList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.milkyway.gbusiness.models.CategoryDataClass.Data> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.SubCategoryDataClass getSubCatDataResponse() {
        return null;
    }
    
    public final void setSubCatDataResponse(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.SubCategoryDataClass p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.milkyway.gbusiness.models.SubCategoryDataClass.Subcategory> getSubCatList() {
        return null;
    }
    
    public final void setSubCatList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.milkyway.gbusiness.models.SubCategoryDataClass.Subcategory> p0) {
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
    
    private final void callCategoryApi() {
    }
    
    private final void callSubCategoryApi(int catId) {
    }
    
    private final void callGetCountriesApi() {
    }
    
    private final void callGetStatesApi(int countryId, java.lang.String stateCode) {
    }
    
    private final void callGetCitiesApi(int stateId) {
    }
    
    private final void setData(android.os.Bundle args) {
    }
    
    private final void setSocialMediaAdapter(java.lang.String facebookUrl, java.lang.String linkedinUrl, java.lang.String twitterUrl, java.lang.String instagramUrl) {
    }
    
    private final void clickListener(android.view.View view) {
    }
    
    private final void sendEmail(java.lang.String recipient, java.lang.String subject, java.lang.String message) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onSocialItemClicked(int position, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.SocialMediaData list) {
    }
}