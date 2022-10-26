package com.milkyway.gbusiness.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J8\u0010#\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0006H\u0002J\b\u0010%\u001a\u00020 H\u0002J\b\u0010&\u001a\u00020\u0006H\u0002J\b\u0010\'\u001a\u00020 H\u0002J\u0012\u0010(\u001a\u00020\u00152\b\u0010)\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010*\u001a\u00020\u00152\b\u0010$\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010+\u001a\u00020\u0015H\u0002J\u0012\u0010,\u001a\u00020 2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006/"}, d2 = {"Lcom/milkyway/gbusiness/activities/SignUpActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "cCPickerSignUp", "Lcom/hbb20/CountryCodePicker;", "countryCode", "", "emailStr", "etEmailSignUp", "Lcom/google/android/material/textfield/TextInputEditText;", "etFirstNameSignUp", "etLastNameSignUp", "etMobileSignUp", "etPasswordSignUp", "firstNameStr", "lastNameStr", "mViewError", "Landroid/view/View;", "mobileStr", "passwordStr", "saveLogin", "", "Ljava/lang/Boolean;", "sharedPreferences", "Landroid/content/SharedPreferences;", "sharedPreferencesEditor", "Landroid/content/SharedPreferences$Editor;", "getSharedPreferencesEditor", "()Landroid/content/SharedPreferences$Editor;", "setSharedPreferencesEditor", "(Landroid/content/SharedPreferences$Editor;)V", "alertErrorDialog", "", "errorBody", "Lcom/milkyway/gbusiness/models/SignupDataErrorResponse;", "callSignUpApi", "mobile", "clickListeners", "getFireBaseToken", "initViews", "isValidMail", "mail", "isValidMobile", "isValidate", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class SignUpActivity extends androidx.appcompat.app.AppCompatActivity {
    private java.lang.String firstNameStr;
    private java.lang.String lastNameStr;
    private java.lang.String emailStr;
    private java.lang.String passwordStr;
    private java.lang.String mobileStr;
    private java.lang.String countryCode = "+91";
    private android.view.View mViewError;
    private com.google.android.material.textfield.TextInputEditText etFirstNameSignUp;
    private com.google.android.material.textfield.TextInputEditText etLastNameSignUp;
    private com.google.android.material.textfield.TextInputEditText etEmailSignUp;
    private com.google.android.material.textfield.TextInputEditText etPasswordSignUp;
    private com.google.android.material.textfield.TextInputEditText etMobileSignUp;
    private com.hbb20.CountryCodePicker cCPickerSignUp;
    @org.jetbrains.annotations.Nullable()
    private android.content.SharedPreferences.Editor sharedPreferencesEditor;
    private android.content.SharedPreferences sharedPreferences;
    private java.lang.Boolean saveLogin;
    private java.util.HashMap _$_findViewCache;
    
    public SignUpActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.content.SharedPreferences.Editor getSharedPreferencesEditor() {
        return null;
    }
    
    public final void setSharedPreferencesEditor(@org.jetbrains.annotations.Nullable()
    android.content.SharedPreferences.Editor p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViews() {
    }
    
    private final void clickListeners() {
    }
    
    private final void callSignUpApi(java.lang.String firstNameStr, java.lang.String lastNameStr, java.lang.String emailStr, java.lang.String passwordStr, java.lang.String countryCode, java.lang.String mobile) {
    }
    
    public final void alertErrorDialog(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.SignupDataErrorResponse errorBody) {
    }
    
    private final java.lang.String getFireBaseToken() {
        return null;
    }
    
    private final boolean isValidate() {
        return false;
    }
    
    private final boolean isValidMail(java.lang.String mail) {
        return false;
    }
    
    private final boolean isValidMobile(java.lang.String mobile) {
        return false;
    }
}