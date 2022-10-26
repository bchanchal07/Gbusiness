package com.milkyway.gbusiness.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0012\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0004J\u0012\u0010%\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\'\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010\u0004J\u0012\u0010)\u001a\u00020#2\b\u0010*\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u0016H\u0016J&\u0010-\u001a\u0004\u0018\u00010\u001d2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u0010\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u000206H\u0002J\u0010\u00107\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u00108\u001a\u00020\u001b2\u0006\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u00020#H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006<"}, d2 = {"Lcom/milkyway/gbusiness/fragments/BusinessPageFragment;", "Landroidx/fragment/app/Fragment;", "()V", "aboutUsStr", "", "btnUpdateBusinessData", "Landroid/widget/Button;", "etAboutUsBPage", "Landroid/widget/EditText;", "etEmailBPage", "etWebUrlBPage", "ivBusinessLogo", "Lde/hdodenhof/circleimageview/CircleImageView;", "ivCamera", "Landroid/widget/ImageView;", "logoImageLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mBusinessLogoImageUri", "Landroid/net/Uri;", "mContext", "Landroid/content/Context;", "mailStr", "myBusinessPageBack", "webUrlStr", "callApiBusinessData", "", "view", "Landroid/view/View;", "callApiBusinessUpdate", "fileUri", "clickListener", "initializeView", "isValidIFSC", "", "ifsc", "isValidMail", "mail", "isValidMobile", "mobile", "isValidUrl", "urlString", "onAttach", "context", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "parseError", "activityResult", "Landroidx/activity/result/ActivityResult;", "pickProfileImage", "setBusinessData", "businessDataResponse", "Lcom/milkyway/gbusiness/models/GetBusinessDataClass;", "validate", "app_debug"})
public final class BusinessPageFragment extends androidx.fragment.app.Fragment {
    private android.widget.ImageView myBusinessPageBack;
    private de.hdodenhof.circleimageview.CircleImageView ivBusinessLogo;
    private android.widget.ImageView ivCamera;
    private android.widget.EditText etEmailBPage;
    private android.widget.EditText etWebUrlBPage;
    private android.widget.EditText etAboutUsBPage;
    private android.widget.Button btnUpdateBusinessData;
    private android.content.Context mContext;
    private java.lang.String mailStr;
    private java.lang.String webUrlStr;
    private java.lang.String aboutUsStr;
    private android.net.Uri mBusinessLogoImageUri;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> logoImageLauncher = null;
    private java.util.HashMap _$_findViewCache;
    
    public BusinessPageFragment() {
        super();
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    private final void parseError(androidx.activity.result.ActivityResult activityResult) {
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
    
    private final void callApiBusinessData(android.view.View view) {
    }
    
    private final void setBusinessData(com.milkyway.gbusiness.models.GetBusinessDataClass businessDataResponse) {
    }
    
    private final void clickListener(android.view.View view) {
    }
    
    private final void pickProfileImage(android.view.View view) {
    }
    
    private final void callApiBusinessUpdate(android.net.Uri fileUri) {
    }
    
    private final boolean validate() {
        return false;
    }
    
    public final boolean isValidIFSC(@org.jetbrains.annotations.Nullable()
    java.lang.String ifsc) {
        return false;
    }
    
    private final boolean isValidMail(java.lang.String mail) {
        return false;
    }
    
    public final boolean isValidMobile(@org.jetbrains.annotations.Nullable()
    java.lang.String mobile) {
        return false;
    }
    
    private final boolean isValidUrl(java.lang.String urlString) {
        return false;
    }
}