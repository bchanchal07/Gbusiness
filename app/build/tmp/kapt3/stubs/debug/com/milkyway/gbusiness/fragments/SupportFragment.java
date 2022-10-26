package com.milkyway.gbusiness.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010)\u001a\u00020*H\u0003J\u0010\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u0011H\u0002J\b\u0010-\u001a\u00020*H\u0002J\b\u0010.\u001a\u00020*H\u0002J\u0010\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020\u001fH\u0002J\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020\u0011022\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006H\u0002J\"\u00104\u001a\u00020*2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002062\b\u00108\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u00109\u001a\u00020*2\u0006\u0010:\u001a\u00020\u001dH\u0016J&\u0010;\u001a\u0004\u0018\u00010\u001f2\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u0016\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010C\u001a\u00020\u0011H\u0002J\u0010\u0010D\u001a\u00020*2\u0006\u0010E\u001a\u00020FH\u0002J\u0012\u0010G\u001a\u00020*2\b\u00100\u001a\u0004\u0018\u00010\u001fH\u0002J\u0010\u0010H\u001a\u00020*2\u0006\u00100\u001a\u00020\u001fH\u0002J\u0016\u0010I\u001a\u00020*2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0012\u0010J\u001a\u00020*2\b\u0010K\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u0010L\u001a\u00020*2\u0006\u0010,\u001a\u00020\u0011H\u0002J\u0016\u0010M\u001a\u00020*2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u00180\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006O"}, d2 = {"Lcom/milkyway/gbusiness/fragments/SupportFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapters", "Lcom/milkyway/gbusiness/adaptor/SupportFragmentAdapter;", "array", "", "Lcom/milkyway/gbusiness/models/DataXXXXXXXXXXXXXXX;", "btnAddTicket", "Landroidx/appcompat/widget/AppCompatButton;", "clearQueryImageView", "Landroid/widget/ImageView;", "etSearch", "Landroidx/appcompat/widget/AppCompatEditText;", "issueList", "Lcom/milkyway/gbusiness/models/IssueSpinnerResponse$Data;", "itemSelected", "", "getItemSelected", "()Ljava/lang/String;", "setItemSelected", "(Ljava/lang/String;)V", "logoImageLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mBusinessLogoImageUri", "Landroid/net/Uri;", "mContext", "Landroid/content/Context;", "mView", "Landroid/view/View;", "mySupportBack", "noSearchResultsFoundText", "Landroid/widget/TextView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "searchEditText", "searchableSpinnerIssue", "Lcom/leo/searchablespinner/SearchableSpinner;", "voiceSearchImageView", "alertAddTicketPopup", "", "filterWithQuery", "query", "getIssueListAPI", "getIssueSpinnerListApi", "initializeViews", "view", "loadIssueNameList", "Ljava/util/ArrayList;", "issueArrayList", "onActivityResult", "requestCode", "", "resultCode", "data", "onAttach", "context", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onFilterChanged", "filterQuery", "parseError", "activityResult", "Landroidx/activity/result/ActivityResult;", "pickScreenShot", "setClickListener", "setSupportListAdapter", "setUploadStr", "tvUploadScreenshot", "toggleImageView", "toggleRecyclerView", "catList", "app_debug"})
public final class SupportFragment extends androidx.fragment.app.Fragment {
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private android.content.Context mContext;
    private com.milkyway.gbusiness.adaptor.SupportFragmentAdapter adapters;
    private android.widget.ImageView mySupportBack;
    private androidx.appcompat.widget.AppCompatButton btnAddTicket;
    private java.util.List<com.milkyway.gbusiness.models.DataXXXXXXXXXXXXXXX> array;
    private com.leo.searchablespinner.SearchableSpinner searchableSpinnerIssue;
    private java.util.List<com.milkyway.gbusiness.models.IssueSpinnerResponse.Data> issueList;
    private android.view.View mView;
    public java.lang.String itemSelected;
    private android.net.Uri mBusinessLogoImageUri;
    private androidx.appcompat.widget.AppCompatEditText etSearch;
    private android.widget.TextView noSearchResultsFoundText;
    private android.widget.TextView searchEditText;
    private android.widget.ImageView clearQueryImageView;
    private android.widget.ImageView voiceSearchImageView;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> logoImageLauncher = null;
    private java.util.HashMap _$_findViewCache;
    
    public SupportFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getItemSelected() {
        return null;
    }
    
    public final void setItemSelected(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
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
    
    private final void setClickListener(android.view.View view) {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void alertAddTicketPopup() {
    }
    
    private final void setUploadStr(android.widget.TextView tvUploadScreenshot) {
    }
    
    private final void pickScreenShot(android.view.View view) {
    }
    
    private final void parseError(androidx.activity.result.ActivityResult activityResult) {
    }
    
    private final void initializeViews(android.view.View view) {
    }
    
    private final void getIssueSpinnerListApi() {
    }
    
    private final java.util.ArrayList<java.lang.String> loadIssueNameList(java.util.List<com.milkyway.gbusiness.models.IssueSpinnerResponse.Data> issueArrayList) {
        return null;
    }
    
    private final void getIssueListAPI() {
    }
    
    private final void setSupportListAdapter(java.util.List<com.milkyway.gbusiness.models.DataXXXXXXXXXXXXXXX> array) {
    }
    
    private final void filterWithQuery(java.lang.String query) {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void toggleRecyclerView(java.util.List<com.milkyway.gbusiness.models.DataXXXXXXXXXXXXXXX> catList) {
    }
    
    private final void toggleImageView(java.lang.String query) {
    }
    
    private final java.util.List<com.milkyway.gbusiness.models.DataXXXXXXXXXXXXXXX> onFilterChanged(java.lang.String filterQuery) {
        return null;
    }
}