package com.milkyway.gbusiness.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020/H\u0002J\b\u00101\u001a\u00020/H\u0002J\u0012\u00102\u001a\u00020/2\b\u00103\u001a\u0004\u0018\u000104H\u0014J\b\u00105\u001a\u00020/H\u0014J\b\u00106\u001a\u00020\u0010H\u0002J*\u00107\u001a\u00020/2\u0006\u0010\t\u001a\u00020\n2\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\nH\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020!X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\'X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u0006:"}, d2 = {"Lcom/milkyway/gbusiness/activities/PhoneNumberActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "ccp", "Lcom/hbb20/CountryCodePicker;", "getCcp", "()Lcom/hbb20/CountryCodePicker;", "setCcp", "(Lcom/hbb20/CountryCodePicker;)V", "countryCode", "", "getCountryCode", "()Ljava/lang/String;", "setCountryCode", "(Ljava/lang/String;)V", "filterPopup", "Landroid/widget/PopupWindow;", "professionList", "Ljava/util/ArrayList;", "Lcom/milkyway/gbusiness/models/DataXXXXX;", "getProfessionList", "()Ljava/util/ArrayList;", "setProfessionList", "(Ljava/util/ArrayList;)V", "professionSelected", "getProfessionSelected", "setProfessionSelected", "refcode", "getRefcode", "setRefcode", "selectedItem", "", "tvprofileProfession", "Landroid/widget/RelativeLayout;", "getTvprofileProfession", "()Landroid/widget/RelativeLayout;", "setTvprofileProfession", "(Landroid/widget/RelativeLayout;)V", "userProfileTvProfessionName", "Landroid/widget/TextView;", "getUserProfileTvProfessionName", "()Landroid/widget/TextView;", "setUserProfileTvProfessionName", "(Landroid/widget/TextView;)V", "checkValidation", "", "dismissPopup", "", "getProfissionApi", "getProfissionLayout", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStop", "showAlertFilter", "submitDataAPI", "number", "profession", "app_debug"})
public final class PhoneNumberActivity extends androidx.appcompat.app.AppCompatActivity {
    private android.widget.PopupWindow filterPopup;
    private int selectedItem = -1;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String refcode = "null";
    public android.widget.RelativeLayout tvprofileProfession;
    public android.widget.TextView userProfileTvProfessionName;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String professionSelected;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String countryCode = "+91";
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.milkyway.gbusiness.models.DataXXXXX> professionList;
    @org.jetbrains.annotations.Nullable()
    private com.hbb20.CountryCodePicker ccp;
    private java.util.HashMap _$_findViewCache;
    
    public PhoneNumberActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRefcode() {
        return null;
    }
    
    public final void setRefcode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.RelativeLayout getTvprofileProfession() {
        return null;
    }
    
    public final void setTvprofileProfession(@org.jetbrains.annotations.NotNull()
    android.widget.RelativeLayout p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getUserProfileTvProfessionName() {
        return null;
    }
    
    public final void setUserProfileTvProfessionName(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getProfessionSelected() {
        return null;
    }
    
    public final void setProfessionSelected(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCountryCode() {
        return null;
    }
    
    public final void setCountryCode(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.milkyway.gbusiness.models.DataXXXXX> getProfessionList() {
        return null;
    }
    
    public final void setProfessionList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.milkyway.gbusiness.models.DataXXXXX> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.hbb20.CountryCodePicker getCcp() {
        return null;
    }
    
    public final void setCcp(@org.jetbrains.annotations.Nullable()
    com.hbb20.CountryCodePicker p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final boolean checkValidation() {
        return false;
    }
    
    private final void submitDataAPI(java.lang.String countryCode, java.lang.String number, java.lang.String profession, java.lang.String refcode) {
    }
    
    private final void getProfissionLayout() {
    }
    
    private final void getProfissionApi() {
    }
    
    private final android.widget.PopupWindow showAlertFilter() {
        return null;
    }
    
    @java.lang.Override()
    protected void onStop() {
    }
    
    private final void dismissPopup() {
    }
}