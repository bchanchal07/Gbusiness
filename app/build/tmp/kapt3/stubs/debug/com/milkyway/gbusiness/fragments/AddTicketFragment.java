package com.milkyway.gbusiness.fragments;

import java.lang.System;

/**
 * A simple [Fragment] subclass.
 * Use the [AddTicketFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0002J\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\f\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u0011H\u0016J\u0012\u0010*\u001a\u00020\u001e2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J&\u0010-\u001a\u0004\u0018\u00010#2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0010\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u000204H\u0002J\u0012\u00105\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u0010\u00106\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u00107\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u00108\u001a\u000209H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006:"}, d2 = {"Lcom/milkyway/gbusiness/fragments/AddTicketFragment;", "Landroidx/fragment/app/Fragment;", "()V", "btnSubmitTicket", "Landroidx/appcompat/widget/AppCompatButton;", "etComment", "Landroid/widget/EditText;", "fsvIssue", "Llibs/mjn/fieldset/FieldSetView;", "issueList", "", "Lcom/milkyway/gbusiness/models/IssueSpinnerResponse$Data;", "logoImageLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mContext", "Landroid/content/Context;", "mScreenshotImageUri", "Landroid/net/Uri;", "myAddTicketBack", "Landroid/widget/ImageView;", "searchableSpinnerIssue", "Lcom/leo/searchablespinner/SearchableSpinner;", "selectedIssueId", "", "tvIssue", "Landroid/widget/TextView;", "tvUploadScreenshot", "callAddTicketApi", "", "fileUri", "getIssueSpinnerListApi", "initializeViews", "view", "Landroid/view/View;", "loadIssueNameList", "Ljava/util/ArrayList;", "", "issueArrayList", "onAttach", "context", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "parseError", "activityResult", "Landroidx/activity/result/ActivityResult;", "pickScreenShot", "setClickListener", "setUploadStr", "validate", "", "app_debug"})
public final class AddTicketFragment extends androidx.fragment.app.Fragment {
    private android.content.Context mContext;
    private android.widget.ImageView myAddTicketBack;
    private android.widget.TextView tvUploadScreenshot;
    private android.widget.TextView tvIssue;
    private android.widget.EditText etComment;
    private libs.mjn.fieldset.FieldSetView fsvIssue;
    private androidx.appcompat.widget.AppCompatButton btnSubmitTicket;
    private com.leo.searchablespinner.SearchableSpinner searchableSpinnerIssue;
    private java.util.List<com.milkyway.gbusiness.models.IssueSpinnerResponse.Data> issueList;
    private int selectedIssueId = 0;
    private android.net.Uri mScreenshotImageUri;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> logoImageLauncher = null;
    private java.util.HashMap _$_findViewCache;
    
    public AddTicketFragment() {
        super();
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
    
    private final void initializeViews(android.view.View view) {
    }
    
    private final void setClickListener(android.view.View view) {
    }
    
    private final void callAddTicketApi(android.net.Uri fileUri, int selectedIssueId) {
    }
    
    private final void pickScreenShot(android.view.View view) {
    }
    
    private final void parseError(androidx.activity.result.ActivityResult activityResult) {
    }
    
    private final void setUploadStr(android.net.Uri mScreenshotImageUri, android.widget.TextView tvUploadScreenshot) {
    }
    
    private final void getIssueSpinnerListApi() {
    }
    
    private final java.util.ArrayList<java.lang.String> loadIssueNameList(java.util.List<com.milkyway.gbusiness.models.IssueSpinnerResponse.Data> issueArrayList) {
        return null;
    }
    
    private final boolean validate() {
        return false;
    }
}