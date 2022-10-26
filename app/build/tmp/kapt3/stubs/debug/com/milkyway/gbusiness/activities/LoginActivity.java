package com.milkyway.gbusiness.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010=\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u00020>2\u0006\u00107\u001a\u00020!H\u0002J\b\u0010@\u001a\u00020>H\u0002J\b\u0010A\u001a\u00020>H\u0002J.\u0010B\u001a\u00020>2\b\u0010C\u001a\u0004\u0018\u00010!2\b\u0010D\u001a\u0004\u0018\u00010!2\b\b\u0002\u0010E\u001a\u00020!2\u0006\u0010F\u001a\u00020!H\u0002J\b\u0010G\u001a\u00020>H\u0002J\u0006\u0010H\u001a\u00020>J\u0010\u0010I\u001a\u00020>2\u0006\u0010J\u001a\u00020KH\u0002J\b\u0010L\u001a\u00020!H\u0002J\b\u0010M\u001a\u00020>H\u0002J\b\u0010N\u001a\u00020>H\u0002J\b\u0010O\u001a\u00020>H\u0002J\b\u0010P\u001a\u00020>H\u0002J\b\u0010Q\u001a\u00020>H\u0002J\u0010\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020!H\u0002J\"\u0010U\u001a\u00020>2\u0006\u0010V\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\u00052\b\u0010X\u001a\u0004\u0018\u00010YH\u0014J\u0012\u0010Z\u001a\u00020>2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0014J\b\u0010]\u001a\u00020>H\u0016J\b\u0010^\u001a\u00020>H\u0014J\b\u0010_\u001a\u00020>H\u0014J\b\u0010`\u001a\u00020>H\u0002J\u0006\u0010a\u001a\u00020>J\b\u0010b\u001a\u00020SH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010#\"\u0004\b(\u0010%R\u001a\u0010)\u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R\u001a\u0010,\u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010#\"\u0004\b.\u0010%R\u000e\u0010/\u001a\u000200X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u00101\u001a\u000202X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u00020!X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010#\"\u0004\b9\u0010%R\u000e\u0010:\u001a\u00020!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006c"}, d2 = {"Lcom/milkyway/gbusiness/activities/LoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/milkyway/gbusiness/api/DialogClick;", "()V", "RC_SIGN_IN", "", "broadcastReceiver", "Landroid/content/BroadcastReceiver;", "getBroadcastReceiver", "()Landroid/content/BroadcastReceiver;", "setBroadcastReceiver", "(Landroid/content/BroadcastReceiver;)V", "callbackManager", "Lcom/facebook/CallbackManager;", "mAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "getMAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "setMAuth", "(Lcom/google/firebase/auth/FirebaseAuth;)V", "mCheckBoxRemember", "Landroid/widget/CheckBox;", "getMCheckBoxRemember", "()Landroid/widget/CheckBox;", "setMCheckBoxRemember", "(Landroid/widget/CheckBox;)V", "mFacebookLoginButton", "Lcom/facebook/login/widget/LoginButton;", "getMFacebookLoginButton", "()Lcom/facebook/login/widget/LoginButton;", "setMFacebookLoginButton", "(Lcom/facebook/login/widget/LoginButton;)V", "mFbEmail", "", "getMFbEmail", "()Ljava/lang/String;", "setMFbEmail", "(Ljava/lang/String;)V", "mFbId", "getMFbId", "setMFbId", "mFbName", "getMFbName", "setMFbName", "mFbPicUrl", "getMFbPicUrl", "setMFbPicUrl", "mGoogleSignInButton", "Lcom/google/android/gms/common/SignInButton;", "mGoogleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "getMGoogleSignInClient", "()Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "setMGoogleSignInClient", "(Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;)V", "mOtp", "getMOtp", "setMOtp", "opts", "referrerClient", "Lcom/android/installreferrer/api/InstallReferrerClient;", "autoFillLogDetails", "", "callAppLoginApi", "callLoginWithApp", "callSignUpActivity", "callSocialSignUpAPI", "userName", "userEmail", "userPhotoUrl", "userUID", "clickListener", "disconnectFromFacebook", "firebaseAuthWithGoogle", "account", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "getFireBaseToken", "initFacebookLogin", "initGmail", "initGoogleLogin", "initSec", "initViews", "isAppInstalled", "", "packageName", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDialogClick", "onPause", "onStart", "signIn", "signOut", "validation", "app_debug"})
public final class LoginActivity extends androidx.appcompat.app.AppCompatActivity implements com.milkyway.gbusiness.api.DialogClick {
    private com.android.installreferrer.api.InstallReferrerClient referrerClient;
    public android.content.BroadcastReceiver broadcastReceiver;
    public java.lang.String mOtp;
    public android.widget.CheckBox mCheckBoxRemember;
    private com.google.android.gms.common.SignInButton mGoogleSignInButton;
    public com.google.firebase.auth.FirebaseAuth mAuth;
    private final int RC_SIGN_IN = 2;
    private java.lang.String opts = "1";
    public com.google.android.gms.auth.api.signin.GoogleSignInClient mGoogleSignInClient;
    public com.facebook.login.widget.LoginButton mFacebookLoginButton;
    private com.facebook.CallbackManager callbackManager;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String mFbName = "pawan";
    @org.jetbrains.annotations.Nullable()
    private java.lang.String mFbEmail = "email";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String mFbId = "7082184904";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String mFbPicUrl = "pawankhatri14311@gmail.com";
    private java.util.HashMap _$_findViewCache;
    
    public LoginActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.BroadcastReceiver getBroadcastReceiver() {
        return null;
    }
    
    public final void setBroadcastReceiver(@org.jetbrains.annotations.NotNull()
    android.content.BroadcastReceiver p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMOtp() {
        return null;
    }
    
    public final void setMOtp(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.CheckBox getMCheckBoxRemember() {
        return null;
    }
    
    public final void setMCheckBoxRemember(@org.jetbrains.annotations.NotNull()
    android.widget.CheckBox p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.auth.FirebaseAuth getMAuth() {
        return null;
    }
    
    public final void setMAuth(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.auth.api.signin.GoogleSignInClient getMGoogleSignInClient() {
        return null;
    }
    
    public final void setMGoogleSignInClient(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.auth.api.signin.GoogleSignInClient p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.facebook.login.widget.LoginButton getMFacebookLoginButton() {
        return null;
    }
    
    public final void setMFacebookLoginButton(@org.jetbrains.annotations.NotNull()
    com.facebook.login.widget.LoginButton p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMFbName() {
        return null;
    }
    
    public final void setMFbName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMFbEmail() {
        return null;
    }
    
    public final void setMFbEmail(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMFbId() {
        return null;
    }
    
    public final void setMFbId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMFbPicUrl() {
        return null;
    }
    
    public final void setMFbPicUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViews() {
    }
    
    private final void initFacebookLogin() {
    }
    
    private final void initGoogleLogin() {
    }
    
    private final void clickListener() {
    }
    
    private final void callSignUpActivity() {
    }
    
    private final void initSec() {
    }
    
    private final java.lang.String getFireBaseToken() {
        return null;
    }
    
    private final void autoFillLogDetails() {
    }
    
    private final boolean isAppInstalled(java.lang.String packageName) {
        return false;
    }
    
    private final void callLoginWithApp() {
    }
    
    private final void callAppLoginApi(java.lang.String mOtp) {
    }
    
    private final boolean validation() {
        return false;
    }
    
    private final void initGmail() {
    }
    
    private final void signIn() {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void firebaseAuthWithGoogle(com.google.android.gms.auth.api.signin.GoogleSignInAccount account) {
    }
    
    private final void callSocialSignUpAPI(java.lang.String userName, java.lang.String userEmail, java.lang.String userPhotoUrl, java.lang.String userUID) {
    }
    
    public final void disconnectFromFacebook() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @java.lang.Override()
    public void onDialogClick() {
    }
    
    public final void signOut() {
    }
}