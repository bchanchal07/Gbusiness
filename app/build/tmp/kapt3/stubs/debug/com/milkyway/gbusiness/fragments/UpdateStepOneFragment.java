package com.milkyway.gbusiness.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 m2\u00020\u0001:\u0001mB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010E\u001a\u00020FH\u0002J\u0006\u0010G\u001a\u00020HJ\u0010\u0010I\u001a\u00020H2\u0006\u0010J\u001a\u00020KH\u0002J\"\u0010L\u001a\u00020H2\u0006\u0010M\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\u00042\b\u0010O\u001a\u0004\u0018\u000102H\u0016J\u0010\u0010P\u001a\u00020H2\u0006\u0010Q\u001a\u000205H\u0016J&\u0010R\u001a\u0004\u0018\u00010K2\u0006\u0010S\u001a\u00020T2\b\u0010U\u001a\u0004\u0018\u00010V2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J+\u0010Y\u001a\u00020H2\u0006\u0010M\u001a\u00020\u00042\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020)0[2\u0006\u0010\\\u001a\u00020]H\u0016\u00a2\u0006\u0002\u0010^J\u001a\u0010_\u001a\u00020H2\u0006\u0010J\u001a\u00020K2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J\u0010\u0010`\u001a\u00020H2\u0006\u0010a\u001a\u00020bH\u0002J\u0010\u0010c\u001a\u00020H2\u0006\u0010J\u001a\u00020KH\u0002J\u0010\u0010d\u001a\u00020\u001d2\u0006\u0010e\u001a\u00020fH\u0002J\u0010\u0010g\u001a\u00020H2\u0006\u0010C\u001a\u00020DH\u0002J\u0018\u0010h\u001a\u00020H2\u0006\u0010i\u001a\u00020)2\u0006\u0010j\u001a\u00020kH\u0002J\b\u0010l\u001a\u00020HH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001a\u0010(\u001a\u00020)X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u00100\u001a\u0010\u0012\f\u0012\n 3*\u0004\u0018\u0001020201X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u00104\u001a\u000205X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020)X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010+\"\u0004\b<\u0010-R\u001a\u0010=\u001a\u00020>X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u000e\u0010C\u001a\u00020DX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006n"}, d2 = {"Lcom/milkyway/gbusiness/fragments/UpdateStepOneFragment;", "Landroidx/fragment/app/Fragment;", "()V", "PICTURE_FROM_CAMERA", "", "getPICTURE_FROM_CAMERA", "()I", "REQUEST_ID_MULTIPLE_PERMISSIONS", "getREQUEST_ID_MULTIPLE_PERMISSIONS", "RESULT_LOAD_IMAGE", "getRESULT_LOAD_IMAGE", "setRESULT_LOAD_IMAGE", "(I)V", "btn_update_step_1", "Landroidx/appcompat/widget/AppCompatButton;", "businessListStepOneModel_gl", "Lcom/milkyway/gbusiness/models/BusinessListStepOneModel;", "getBusinessListStepOneModel_gl", "()Lcom/milkyway/gbusiness/models/BusinessListStepOneModel;", "setBusinessListStepOneModel_gl", "(Lcom/milkyway/gbusiness/models/BusinessListStepOneModel;)V", "editBusinessListingBack", "Landroid/widget/ImageView;", "et_payment_bank_detail", "Landroid/widget/EditText;", "et_payment_email", "et_payment_tilte", "et_payment_url", "file", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "setFile", "(Ljava/io/File;)V", "fileUri", "Landroid/net/Uri;", "getFileUri", "()Landroid/net/Uri;", "setFileUri", "(Landroid/net/Uri;)V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "ivBusinessPaymentView", "ivImageSelect", "logoImageLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "picturePath", "getPicturePath", "setPicturePath", "random", "Ljava/util/Random;", "getRandom", "()Ljava/util/Random;", "setRandom", "(Ljava/util/Random;)V", "stepOneBusinessList", "Lcom/milkyway/gbusiness/models/StepOneItemListsModel$BusinessItemsList;", "checkAndRequestPermissions", "", "getPictureDialog", "", "initView", "view", "Landroid/view/View;", "onActivityResult", "requestCode", "resultCode", "data", "onAttach", "context", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onViewCreated", "parseError", "activityResult", "Landroidx/activity/result/ActivityResult;", "pickBusinessLogo", "savebitmap", "bmp", "Landroid/graphics/Bitmap;", "setDefaultData", "showDialogOK", "message", "okListener", "Landroid/content/DialogInterface$OnClickListener;", "updateStepOneDetails", "Companion", "app_debug"})
public final class UpdateStepOneFragment extends androidx.fragment.app.Fragment {
    public android.content.Context mContext;
    private android.widget.ImageView editBusinessListingBack;
    private android.widget.ImageView ivBusinessPaymentView;
    private android.widget.ImageView ivImageSelect;
    private android.widget.EditText et_payment_tilte;
    private android.widget.EditText et_payment_email;
    private android.widget.EditText et_payment_url;
    private android.widget.EditText et_payment_bank_detail;
    private androidx.appcompat.widget.AppCompatButton btn_update_step_1;
    private com.milkyway.gbusiness.models.StepOneItemListsModel.BusinessItemsList stepOneBusinessList;
    public com.milkyway.gbusiness.models.BusinessListStepOneModel businessListStepOneModel_gl;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String id = "";
    @org.jetbrains.annotations.Nullable()
    private android.net.Uri fileUri;
    private final int REQUEST_ID_MULTIPLE_PERMISSIONS = 7;
    private int RESULT_LOAD_IMAGE = 101;
    private final int PICTURE_FROM_CAMERA = 1;
    public java.io.File file;
    public java.lang.String picturePath;
    @org.jetbrains.annotations.NotNull()
    private java.util.Random random;
    @org.jetbrains.annotations.NotNull()
    public static final com.milkyway.gbusiness.fragments.UpdateStepOneFragment.Companion Companion = null;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> logoImageLauncher = null;
    private java.util.HashMap _$_findViewCache;
    
    public UpdateStepOneFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.BusinessListStepOneModel getBusinessListStepOneModel_gl() {
        return null;
    }
    
    public final void setBusinessListStepOneModel_gl(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.BusinessListStepOneModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    public final void setId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.net.Uri getFileUri() {
        return null;
    }
    
    public final void setFileUri(@org.jetbrains.annotations.Nullable()
    android.net.Uri p0) {
    }
    
    public final int getREQUEST_ID_MULTIPLE_PERMISSIONS() {
        return 0;
    }
    
    public final int getRESULT_LOAD_IMAGE() {
        return 0;
    }
    
    public final void setRESULT_LOAD_IMAGE(int p0) {
    }
    
    public final int getPICTURE_FROM_CAMERA() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.io.File getFile() {
        return null;
    }
    
    public final void setFile(@org.jetbrains.annotations.NotNull()
    java.io.File p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPicturePath() {
        return null;
    }
    
    public final void setPicturePath(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Random getRandom() {
        return null;
    }
    
    public final void setRandom(@org.jetbrains.annotations.NotNull()
    java.util.Random p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final com.milkyway.gbusiness.fragments.UpdateStepOneFragment newInstance() {
        return null;
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
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setDefaultData(com.milkyway.gbusiness.models.StepOneItemListsModel.BusinessItemsList stepOneBusinessList) {
    }
    
    private final void initView(android.view.View view) {
    }
    
    private final void updateStepOneDetails() {
    }
    
    private final void pickBusinessLogo(android.view.View view) {
    }
    
    private final void parseError(androidx.activity.result.ActivityResult activityResult) {
    }
    
    public final void getPictureDialog() {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final java.io.File savebitmap(android.graphics.Bitmap bmp) {
        return null;
    }
    
    private final boolean checkAndRequestPermissions() {
        return false;
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    private final void showDialogOK(java.lang.String message, android.content.DialogInterface.OnClickListener okListener) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lcom/milkyway/gbusiness/fragments/UpdateStepOneFragment$Companion;", "", "()V", "newInstance", "Lcom/milkyway/gbusiness/fragments/UpdateStepOneFragment;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final com.milkyway.gbusiness.fragments.UpdateStepOneFragment newInstance() {
            return null;
        }
    }
}