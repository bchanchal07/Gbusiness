package com.milkyway.gbusiness.ui.main;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 F2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001FB\u0005\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u001dH\u0002J\b\u0010$\u001a\u00020\u001dH\u0002J\b\u0010%\u001a\u00020\u001dH\u0002J\b\u0010&\u001a\u00020\u0015H\u0002J\b\u0010\'\u001a\u00020\u001dH\u0002J\b\u0010(\u001a\u00020\u001dH\u0002J\b\u0010)\u001a\u00020\u001dH\u0002J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020,H\u0003J\b\u0010-\u001a\u00020\u001dH\u0002J\u0006\u0010.\u001a\u00020\u001dJ\u0012\u0010/\u001a\u00020\u001d2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0010\u00102\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u000eH\u0016J\u0012\u00104\u001a\u00020\u001d2\b\u00105\u001a\u0004\u0018\u00010,H\u0016J\b\u00106\u001a\u00020\u001dH\u0016J$\u00107\u001a\u00020,2\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\b\u0010<\u001a\u00020\u001dH\u0016J\u001a\u0010=\u001a\u00020\u001d2\b\u0010>\u001a\u0004\u0018\u00010\u00152\u0006\u0010?\u001a\u00020@H\u0016J\b\u0010A\u001a\u00020\u001dH\u0002J\b\u0010B\u001a\u00020\u001dH\u0002J\b\u0010C\u001a\u00020\u001dH\u0002J\u0010\u0010D\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010E\u001a\u00020\u001dH\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006G"}, d2 = {"Lcom/milkyway/gbusiness/ui/main/MainFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "Lcom/milkyway/gbusiness/api/DialogClick;", "Lcom/milkyway/gbusiness/api/CallPemission;", "Lcom/milkyway/gbusiness/adaptor/DashboardItemAdaptor$OnDashboardAdaptorClick;", "Lcom/commit451/modalbottomsheetdialogfragment/ModalBottomSheetDialogFragment$Listener;", "()V", "dashCategoryList", "Ljava/util/ArrayList;", "Lcom/milkyway/gbusiness/models/DashboardData;", "infoImage", "Landroid/widget/ImageView;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mainFragOverFlowIcon", "rfCode", "", "rvDashboard", "Landroidx/recyclerview/widget/RecyclerView;", "userNamemainUi", "Landroid/widget/TextView;", "viewModel", "Lcom/milkyway/gbusiness/ui/main/MainViewModel;", "OnItemClicked", "", "position", "", "alertLogOutDialog", "checkAndRequestPermissions", "", "feedback", "forRatingOfApp", "getFirstDialogBox", "getInvitationMessage", "getRefCode", "getRuntimePermission", "imageAndText", "initializeView", "view", "Landroid/view/View;", "launchMarketTesting", "logout", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "onClick", "v", "onClickPermission", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDialogClick", "onModalOptionSelected", "tag", "option", "Lcom/commit451/modalbottomsheetdialogfragment/Option;", "openActionBottomSheet", "openShareDialog", "rateUs", "setDashCategoryAdaptor", "setPin", "Companion", "app_debug"})
public final class MainFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener, com.milkyway.gbusiness.api.DialogClick, com.milkyway.gbusiness.api.CallPemission, com.milkyway.gbusiness.adaptor.DashboardItemAdaptor.OnDashboardAdaptorClick, com.commit451.modalbottomsheetdialogfragment.ModalBottomSheetDialogFragment.Listener {
    private com.milkyway.gbusiness.ui.main.MainViewModel viewModel;
    private android.widget.ImageView infoImage;
    private android.widget.ImageView mainFragOverFlowIcon;
    private android.widget.TextView userNamemainUi;
    private java.lang.String rfCode;
    private androidx.recyclerview.widget.RecyclerView rvDashboard;
    private final java.util.ArrayList<com.milkyway.gbusiness.models.DashboardData> dashCategoryList = null;
    public android.content.Context mContext;
    @org.jetbrains.annotations.NotNull()
    public static final com.milkyway.gbusiness.ui.main.MainFragment.Companion Companion = null;
    private static int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;
    private java.util.HashMap _$_findViewCache;
    
    public MainFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onClickPermission() {
    }
    
    @java.lang.Override()
    public void onDialogClick() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
    
    private final void openActionBottomSheet() {
    }
    
    private final void openShareDialog() {
    }
    
    private final void launchMarketTesting() {
    }
    
    private final void imageAndText() {
    }
    
    private final java.lang.String getInvitationMessage() {
        return null;
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    private final void forRatingOfApp() {
    }
    
    private final void getRuntimePermission() {
    }
    
    private final boolean checkAndRequestPermissions() {
        return false;
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void initializeView(android.view.View view) {
    }
    
    private final void setDashCategoryAdaptor(android.view.View view) {
    }
    
    @java.lang.Override()
    public void onActivityCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setPin() {
    }
    
    private final void getFirstDialogBox() {
    }
    
    private final void feedback() {
    }
    
    private final void rateUs() {
    }
    
    public final void logout() {
    }
    
    private final void alertLogOutDialog() {
    }
    
    private final void getRefCode() {
    }
    
    @java.lang.Override()
    public void OnItemClicked(int position) {
    }
    
    @java.lang.Override()
    public void onModalOptionSelected(@org.jetbrains.annotations.Nullable()
    java.lang.String tag, @org.jetbrains.annotations.NotNull()
    com.commit451.modalbottomsheetdialogfragment.Option option) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/milkyway/gbusiness/ui/main/MainFragment$Companion;", "", "()V", "REQUEST_ID_MULTIPLE_PERMISSIONS", "", "getREQUEST_ID_MULTIPLE_PERMISSIONS", "()I", "setREQUEST_ID_MULTIPLE_PERMISSIONS", "(I)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final int getREQUEST_ID_MULTIPLE_PERMISSIONS() {
            return 0;
        }
        
        public final void setREQUEST_ID_MULTIPLE_PERMISSIONS(int p0) {
        }
    }
}