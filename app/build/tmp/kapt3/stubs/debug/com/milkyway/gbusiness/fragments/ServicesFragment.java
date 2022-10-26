package com.milkyway.gbusiness.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00b6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020\fH\u0002J\b\u00102\u001a\u00020\fH\u0002J\b\u00103\u001a\u000200H\u0002J(\u00104\u001a\u0002002\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u0002062\u0006\u00109\u001a\u000206H\u0002J\u0010\u0010:\u001a\u0002002\u0006\u0010;\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u0002002\u0006\u0010>\u001a\u00020\u001fH\u0016JH\u0010?\u001a\u0002002\u0006\u00105\u001a\u0002062\u0006\u0010@\u001a\u0002062\u0006\u0010A\u001a\u0002062\u0006\u00107\u001a\u0002062\u0006\u0010B\u001a\u0002062\u0006\u0010C\u001a\u0002062\u0006\u00108\u001a\u0002062\u0006\u0010D\u001a\u000206H\u0016J&\u0010E\u001a\u0004\u0018\u00010<2\u0006\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010I2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\b\u0010L\u001a\u000200H\u0016J\u001e\u0010M\u001a\u0002002\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00030O2\u0006\u0010P\u001a\u00020QH\u0016J$\u0010R\u001a\u0002002\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00030O2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00030TH\u0016J@\u0010U\u001a\u0002002\u0006\u00105\u001a\u0002062\u0006\u0010@\u001a\u0002062\u0006\u0010A\u001a\u0002062\u0006\u00107\u001a\u0002062\u0006\u0010V\u001a\u0002062\u0006\u0010W\u001a\u0002062\u0006\u00108\u001a\u000206H\u0003J(\u0010X\u001a\u0002002\u0006\u0010Y\u001a\u0002062\u0006\u0010Z\u001a\u0002062\u0006\u0010A\u001a\u0002062\u0006\u00107\u001a\u000206H\u0002JN\u0010[\u001a\u0002002\b\u0010\\\u001a\u0004\u0018\u0001062\b\u0010]\u001a\u0004\u0018\u0001062\b\u0010^\u001a\u0004\u0018\u0001062\u0006\u0010_\u001a\u0002062\u0006\u0010Y\u001a\u0002062\u0006\u0010`\u001a\u0002062\u0006\u00107\u001a\u0002062\u0006\u0010a\u001a\u000206H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\'X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006b"}, d2 = {"Lcom/milkyway/gbusiness/fragments/ServicesFragment;", "Landroidx/fragment/app/Fragment;", "Lretrofit2/Callback;", "Lcom/milkyway/gbusiness/models/ServicesDataClass;", "Lcom/milkyway/gbusiness/api/OnServiceAdapterClick;", "Lcom/milkyway/gbusiness/api/DialogClick;", "()V", "btnBuyService", "Landroid/widget/Button;", "btnSubmitQuotes", "Landroidx/appcompat/widget/AppCompatButton;", "buyOrOther", "", "getBuyOrOther", "()Z", "setBuyOrOther", "(Z)V", "closeBottomSheet", "Landroid/widget/RelativeLayout;", "edtEmail", "Landroid/widget/EditText;", "edtMessage", "edtName", "edtPhone", "edtServiceMessage", "edtType", "headerOne", "Landroid/widget/TextView;", "headerTwo", "layoutClose", "mContext", "Landroid/content/Context;", "myServiceBack", "Landroid/widget/ImageView;", "openBuyDialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "openOtherDialog", "policeCondition", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "serviceCheckBox", "Landroid/widget/CheckBox;", "termCondition", "viewAdapter", "Lcom/milkyway/gbusiness/adaptor/ServicesFragmentAdaptor;", "viewManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "callSignature", "", "checkCondition", "checkConditions", "getServiceApi", "goForPayment", "service_id", "", "price", "serviceType", "description", "initializeViews", "view", "Landroid/view/View;", "onAttach", "context", "onClickServiceItem", "name", "enqri", "tittle", "descrip", "image", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDialogClick", "onFailure", "call", "Lretrofit2/Call;", "t", "", "onResponse", "response", "Lretrofit2/Response;", "openBuyBottomSheet", "firstHeading", "secondHeading", "openOtherBottomSheet", "id", "ser_name", "submitEnquiry", "firstName", "email", "phone", "serName", "enquiry", "messageUser", "app_debug"})
public final class ServicesFragment extends androidx.fragment.app.Fragment implements retrofit2.Callback<com.milkyway.gbusiness.models.ServicesDataClass>, com.milkyway.gbusiness.api.OnServiceAdapterClick, com.milkyway.gbusiness.api.DialogClick {
    private com.milkyway.gbusiness.adaptor.ServicesFragmentAdaptor viewAdapter;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private android.widget.ImageView myServiceBack;
    private android.widget.EditText edtName;
    private android.widget.EditText edtEmail;
    private android.widget.EditText edtPhone;
    private android.widget.EditText edtType;
    private android.widget.EditText edtMessage;
    private androidx.appcompat.widget.AppCompatButton btnSubmitQuotes;
    private android.widget.RelativeLayout layoutClose;
    private android.widget.TextView headerOne;
    private android.widget.TextView headerTwo;
    private android.widget.TextView termCondition;
    private android.widget.TextView policeCondition;
    private android.widget.CheckBox serviceCheckBox;
    private android.widget.EditText edtServiceMessage;
    private android.widget.Button btnBuyService;
    private android.widget.RelativeLayout closeBottomSheet;
    private com.google.android.material.bottomsheet.BottomSheetDialog openOtherDialog;
    private com.google.android.material.bottomsheet.BottomSheetDialog openBuyDialog;
    private boolean buyOrOther = false;
    private androidx.recyclerview.widget.RecyclerView.LayoutManager viewManager;
    private android.content.Context mContext;
    private java.util.HashMap _$_findViewCache;
    
    public ServicesFragment() {
        super();
    }
    
    @java.lang.Override()
    public void onDialogClick() {
    }
    
    public final boolean getBuyOrOther() {
        return false;
    }
    
    public final void setBuyOrOther(boolean p0) {
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
    
    private final void initializeViews(android.view.View view) {
    }
    
    private final void callSignature() {
    }
    
    private final void getServiceApi() {
    }
    
    @java.lang.Override()
    public void onFailure(@org.jetbrains.annotations.NotNull()
    retrofit2.Call<com.milkyway.gbusiness.models.ServicesDataClass> call, @org.jetbrains.annotations.NotNull()
    java.lang.Throwable t) {
    }
    
    @java.lang.Override()
    public void onResponse(@org.jetbrains.annotations.NotNull()
    retrofit2.Call<com.milkyway.gbusiness.models.ServicesDataClass> call, @org.jetbrains.annotations.NotNull()
    retrofit2.Response<com.milkyway.gbusiness.models.ServicesDataClass> response) {
    }
    
    @java.lang.Override()
    public void onClickServiceItem(@org.jetbrains.annotations.NotNull()
    java.lang.String service_id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String enqri, @org.jetbrains.annotations.NotNull()
    java.lang.String price, @org.jetbrains.annotations.NotNull()
    java.lang.String tittle, @org.jetbrains.annotations.NotNull()
    java.lang.String descrip, @org.jetbrains.annotations.NotNull()
    java.lang.String serviceType, @org.jetbrains.annotations.NotNull()
    java.lang.String image) {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void openBuyBottomSheet(java.lang.String service_id, java.lang.String name, java.lang.String enqri, java.lang.String price, java.lang.String firstHeading, java.lang.String secondHeading, java.lang.String serviceType) {
    }
    
    private final void goForPayment(java.lang.String service_id, java.lang.String price, java.lang.String serviceType, java.lang.String description) {
    }
    
    private final void openOtherBottomSheet(java.lang.String id, java.lang.String ser_name, java.lang.String enqri, java.lang.String price) {
    }
    
    private final boolean checkConditions() {
        return false;
    }
    
    private final boolean checkCondition() {
        return false;
    }
    
    private final void submitEnquiry(java.lang.String firstName, java.lang.String email, java.lang.String phone, java.lang.String serName, java.lang.String id, java.lang.String enquiry, java.lang.String price, java.lang.String messageUser) {
    }
}