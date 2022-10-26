package com.milkyway.gbusiness.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u0014H\u0016J&\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016J0\u00108\u001a\u00020-2\f\u00109\u001a\b\u0012\u0002\b\u0003\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u0001012\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0016J\u0016\u0010@\u001a\u00020-2\f\u00109\u001a\b\u0012\u0002\b\u0003\u0018\u00010:H\u0016J\b\u0010A\u001a\u00020-H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001aX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\'X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u0006B"}, d2 = {"Lcom/milkyway/gbusiness/fragments/SecurityQuestionFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/widget/AdapterView$OnItemSelectedListener;", "()V", "SubmittRecBtn", "Landroid/widget/TextView;", "getSubmittRecBtn", "()Landroid/widget/TextView;", "setSubmittRecBtn", "(Landroid/widget/TextView;)V", "arrayList", "", "Lcom/milkyway/gbusiness/models/DataXXXXXXXXXXXX;", "itemss", "", "getItemss", "()Ljava/lang/String;", "setItemss", "(Ljava/lang/String;)V", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mySecQuestionBack", "Landroid/widget/ImageView;", "questionDropDownImg", "getQuestionDropDownImg", "()Landroid/widget/ImageView;", "setQuestionDropDownImg", "(Landroid/widget/ImageView;)V", "questionFragAnswerTv", "Landroid/widget/EditText;", "getQuestionFragAnswerTv", "()Landroid/widget/EditText;", "setQuestionFragAnswerTv", "(Landroid/widget/EditText;)V", "questionFragQstionTv", "Landroid/widget/Spinner;", "getQuestionFragQstionTv", "()Landroid/widget/Spinner;", "setQuestionFragQstionTv", "(Landroid/widget/Spinner;)V", "getSecurityQuestionAPI", "", "onAttach", "context", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onItemSelected", "parent", "Landroid/widget/AdapterView;", "view", "position", "", "id", "", "onNothingSelected", "updateAnswer", "app_debug"})
public final class SecurityQuestionFragment extends androidx.fragment.app.Fragment implements android.widget.AdapterView.OnItemSelectedListener {
    public java.lang.String itemss;
    public android.widget.ImageView questionDropDownImg;
    public android.widget.TextView SubmittRecBtn;
    public android.widget.Spinner questionFragQstionTv;
    public android.widget.EditText questionFragAnswerTv;
    private android.widget.ImageView mySecQuestionBack;
    private java.util.List<com.milkyway.gbusiness.models.DataXXXXXXXXXXXX> arrayList;
    public android.content.Context mContext;
    private java.util.HashMap _$_findViewCache;
    
    public SecurityQuestionFragment() {
        super();
    }
    
    @java.lang.Override()
    public void onNothingSelected(@org.jetbrains.annotations.Nullable()
    android.widget.AdapterView<?> parent) {
    }
    
    @java.lang.Override()
    public void onItemSelected(@org.jetbrains.annotations.Nullable()
    android.widget.AdapterView<?> parent, @org.jetbrains.annotations.Nullable()
    android.view.View view, int position, long id) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getItemss() {
        return null;
    }
    
    public final void setItemss(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getQuestionDropDownImg() {
        return null;
    }
    
    public final void setQuestionDropDownImg(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getSubmittRecBtn() {
        return null;
    }
    
    public final void setSubmittRecBtn(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Spinner getQuestionFragQstionTv() {
        return null;
    }
    
    public final void setQuestionFragQstionTv(@org.jetbrains.annotations.NotNull()
    android.widget.Spinner p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getQuestionFragAnswerTv() {
        return null;
    }
    
    public final void setQuestionFragAnswerTv(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
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
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void getSecurityQuestionAPI() {
    }
    
    private final void updateAnswer() {
    }
}