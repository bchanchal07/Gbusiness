package com.milkyway.gbusiness.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 d2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001dB\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010A\u001a\u00020BH\u0002J\b\u0010C\u001a\u00020BH\u0002J\b\u0010D\u001a\u00020BH\u0002J\b\u0010E\u001a\u00020BH\u0002J\b\u0010F\u001a\u00020BH\u0002J\b\u0010G\u001a\u00020BH\u0002J\b\u0010H\u001a\u00020BH\u0002J\u0010\u0010I\u001a\u00020B2\u0006\u0010J\u001a\u00020\'H\u0002J\b\u0010K\u001a\u00020BH\u0002J\u0010\u0010L\u001a\u00020B2\u0006\u0010M\u001a\u00020,H\u0016J&\u0010N\u001a\u0004\u0018\u00010\'2\u0006\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010R2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J\u001e\u0010U\u001a\u00020B2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00030W2\u0006\u0010X\u001a\u00020YH\u0016J$\u0010Z\u001a\u00020B2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00030W2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00030\\H\u0017J\b\u0010]\u001a\u00020BH\u0016J\b\u0010^\u001a\u00020BH\u0002J\b\u0010_\u001a\u00020BH\u0002J\u0006\u0010`\u001a\u00020BJ\u0012\u0010a\u001a\u00020B2\b\u0010J\u001a\u0004\u0018\u00010\'H\u0002J\b\u0010b\u001a\u00020BH\u0002J\b\u0010c\u001a\u00020BH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082.\u00a2\u0006\u0002\n\u0000R\"\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u001e\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u00106\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006e"}, d2 = {"Lcom/milkyway/gbusiness/fragments/EarningFragment;", "Landroidx/fragment/app/Fragment;", "Lretrofit2/Callback;", "Lcom/milkyway/gbusiness/models/EarningDataClass;", "()V", "Adopter", "Lcom/milkyway/gbusiness/adaptor/EarningFragmentAdoptor;", "arrayDate", "Ljava/util/ArrayList;", "Lcom/milkyway/gbusiness/models/Totalearning;", "Lkotlin/collections/ArrayList;", "arrayDirectDate", "arrayGlobalDate", "cal", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "getCal", "()Ljava/util/Calendar;", "setCal", "(Ljava/util/Calendar;)V", "dateSetListener", "Landroid/app/DatePickerDialog$OnDateSetListener;", "getDateSetListener", "()Landroid/app/DatePickerDialog$OnDateSetListener;", "dateSetListenerfrom", "getDateSetListenerfrom", "directEarnList", "earningFromDate", "Landroid/widget/TextView;", "earningGoBtn", "earningOf", "", "getEarningOf", "()Ljava/lang/String;", "setEarningOf", "(Ljava/lang/String;)V", "earningToDate", "globalEarnList", "layoutEarningDirect", "Landroid/view/View;", "layoutEarningGlobal", "layoutEarningTotal", "layoutWalletHistory", "mContext", "Landroid/content/Context;", "myEarningBack", "Landroid/widget/ImageView;", "myWalletBalance", "recyclerViewEarning", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerViewEarning", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerViewEarning", "(Landroidx/recyclerview/widget/RecyclerView;)V", "totalEarnList", "tvCopyRefCode", "tvEarningDirect", "tvEarningDirectBtm", "tvEarningGlobal", "tvEarningGlobalBtm", "tvEarningRefCode", "tvEarningTotal", "tvEarningTotalBtm", "tvMyDirects", "tvMyDirectsBtm", "checkConnection", "", "getDatePickers", "getDatePickersfrom", "getEarningByDate", "getTimePicker", "getTottalEarningApi", "getWalltBalApi", "initViews", "view", "myInitList", "onAttach", "context", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onFailure", "call", "Lretrofit2/Call;", "t", "", "onResponse", "response", "Lretrofit2/Response;", "onStop", "setClipBoard", "showEarning", "showEarningwithDate", "showWalletHistory", "updateDateInView", "updateDateInViewfrom", "Companion", "app_debug"})
public final class EarningFragment extends androidx.fragment.app.Fragment implements retrofit2.Callback<com.milkyway.gbusiness.models.EarningDataClass> {
    @org.jetbrains.annotations.NotNull()
    public static final com.milkyway.gbusiness.fragments.EarningFragment.Companion Companion = null;
    private static boolean onDateSection = false;
    private com.milkyway.gbusiness.adaptor.EarningFragmentAdoptor Adopter;
    @org.jetbrains.annotations.Nullable()
    private androidx.recyclerview.widget.RecyclerView recyclerViewEarning;
    private android.widget.TextView myWalletBalance;
    private android.widget.TextView tvCopyRefCode;
    private android.widget.TextView tvEarningTotal;
    private android.widget.TextView tvEarningDirect;
    private android.widget.TextView tvEarningGlobal;
    private android.widget.TextView tvMyDirects;
    private android.widget.TextView tvEarningTotalBtm;
    private android.widget.TextView tvEarningDirectBtm;
    private android.widget.TextView tvEarningGlobalBtm;
    private android.widget.TextView tvMyDirectsBtm;
    private android.widget.TextView tvEarningRefCode;
    private android.widget.TextView earningToDate;
    private android.widget.TextView earningFromDate;
    private android.widget.TextView earningGoBtn;
    private android.view.View layoutEarningTotal;
    private android.view.View layoutEarningDirect;
    private android.view.View layoutEarningGlobal;
    private android.view.View layoutWalletHistory;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String earningOf = "total";
    private android.widget.ImageView myEarningBack;
    private java.util.ArrayList<com.milkyway.gbusiness.models.Totalearning> totalEarnList;
    private java.util.ArrayList<com.milkyway.gbusiness.models.Totalearning> directEarnList;
    private java.util.ArrayList<com.milkyway.gbusiness.models.Totalearning> globalEarnList;
    private java.util.ArrayList<com.milkyway.gbusiness.models.Totalearning> arrayDate;
    private java.util.ArrayList<com.milkyway.gbusiness.models.Totalearning> arrayDirectDate;
    private java.util.ArrayList<com.milkyway.gbusiness.models.Totalearning> arrayGlobalDate;
    private android.content.Context mContext;
    private java.util.Calendar cal;
    @org.jetbrains.annotations.NotNull()
    private final android.app.DatePickerDialog.OnDateSetListener dateSetListener = null;
    @org.jetbrains.annotations.NotNull()
    private final android.app.DatePickerDialog.OnDateSetListener dateSetListenerfrom = null;
    private java.util.HashMap _$_findViewCache;
    
    public EarningFragment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.recyclerview.widget.RecyclerView getRecyclerViewEarning() {
        return null;
    }
    
    public final void setRecyclerViewEarning(@org.jetbrains.annotations.Nullable()
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEarningOf() {
        return null;
    }
    
    public final void setEarningOf(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final java.util.Calendar getCal() {
        return null;
    }
    
    public final void setCal(java.util.Calendar p0) {
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
    
    private final void myInitList() {
    }
    
    private final void initViews(android.view.View view) {
    }
    
    private final void setClipBoard() {
    }
    
    private final void showWalletHistory(android.view.View view) {
    }
    
    private final void getTimePicker() {
    }
    
    private final void getTottalEarningApi() {
    }
    
    private final void checkConnection() {
    }
    
    private final void getEarningByDate() {
    }
    
    @java.lang.Override()
    public void onFailure(@org.jetbrains.annotations.NotNull()
    retrofit2.Call<com.milkyway.gbusiness.models.EarningDataClass> call, @org.jetbrains.annotations.NotNull()
    java.lang.Throwable t) {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    @java.lang.Override()
    public void onResponse(@org.jetbrains.annotations.NotNull()
    retrofit2.Call<com.milkyway.gbusiness.models.EarningDataClass> call, @org.jetbrains.annotations.NotNull()
    retrofit2.Response<com.milkyway.gbusiness.models.EarningDataClass> response) {
    }
    
    private final void getDatePickers() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.DatePickerDialog.OnDateSetListener getDateSetListener() {
        return null;
    }
    
    private final void updateDateInView() {
    }
    
    private final void getDatePickersfrom() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.DatePickerDialog.OnDateSetListener getDateSetListenerfrom() {
        return null;
    }
    
    private final void updateDateInViewfrom() {
    }
    
    private final void getWalltBalApi() {
    }
    
    private final void showEarning() {
    }
    
    public final void showEarningwithDate() {
    }
    
    @java.lang.Override()
    public void onStop() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/milkyway/gbusiness/fragments/EarningFragment$Companion;", "", "()V", "onDateSection", "", "getOnDateSection", "()Z", "setOnDateSection", "(Z)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final boolean getOnDateSection() {
            return false;
        }
        
        public final void setOnDateSection(boolean p0) {
        }
    }
}