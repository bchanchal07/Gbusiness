package com.milkyway.gbusiness.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00f0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010T\u001a\u00020U2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010+J\u0014\u0010V\u001a\u00020U2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020Y0XJ\b\u0010Z\u001a\u00020[H\u0002J\u001e\u0010\\\u001a\u00020U2\u0006\u0010]\u001a\u00020\u00062\f\u0010^\u001a\b\u0012\u0004\u0012\u00020Y0XH\u0016J\u001e\u0010_\u001a\u00020U2\u0006\u0010]\u001a\u00020\u00062\f\u0010^\u001a\b\u0012\u0004\u0012\u00020Y0XH\u0002J\u0006\u0010`\u001a\u00020UJ\f\u0010a\u001a\b\u0012\u0004\u0012\u0002080XJ\u0006\u0010b\u001a\u00020UJ\u0010\u0010c\u001a\u00020U2\u0006\u0010d\u001a\u00020eH\u0002J\"\u0010f\u001a\u00020U2\u0006\u0010g\u001a\u00020\u00062\u0006\u0010h\u001a\u00020\u00062\b\u0010i\u001a\u0004\u0018\u00010jH\u0016J\u0010\u0010k\u001a\u00020U2\u0006\u0010l\u001a\u000201H\u0016J&\u0010m\u001a\u0004\u0018\u00010e2\u0006\u0010n\u001a\u00020o2\b\u0010p\u001a\u0004\u0018\u00010q2\b\u0010r\u001a\u0004\u0018\u00010sH\u0016J+\u0010t\u001a\u00020U2\u0006\u0010g\u001a\u00020\u00062\f\u0010u\u001a\b\u0012\u0004\u0012\u00020>0v2\u0006\u0010w\u001a\u00020xH\u0016\u00a2\u0006\u0002\u0010yJ\u001a\u0010z\u001a\u00020U2\u0006\u0010d\u001a\u00020e2\b\u0010r\u001a\u0004\u0018\u00010sH\u0016J\u001a\u0010{\u001a\u0004\u0018\u0001082\u0006\u0010|\u001a\u00020>2\u0006\u0010\"\u001a\u00020#H\u0003J\u0010\u0010}\u001a\u00020\u001d2\u0006\u0010~\u001a\u00020\u007fH\u0002J\u001c\u0010\u0080\u0001\u001a\u00020U2\u0007\u0010\u0081\u0001\u001a\u00020>2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0002J\t\u0010\u0084\u0001\u001a\u00020UH\u0002J\u0019\u0010\u0085\u0001\u001a\u00020U2\u0006\u0010]\u001a\u00020\u00062\u0006\u0010^\u001a\u00020YH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u000e\u0010(\u001a\u00020)X\u0082.\u00a2\u0006\u0002\n\u0000R\"\u0010*\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R \u00106\u001a\b\u0012\u0004\u0012\u00020807X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020>X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010C\u001a\u00020DX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u000e\u0010I\u001a\u00020JX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020JX\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010L\u001a\u0004\u0018\u00010MX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u000e\u0010R\u001a\u00020SX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0086\u0001"}, d2 = {"Lcom/milkyway/gbusiness/fragments/Step2BusinessListFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/milkyway/gbusiness/adaptor/Step_2_BusinessListItemsAdapter$UpdateBtnListener;", "Lcom/milkyway/gbusiness/adaptor/Step_2_BusinessListItemsAdapter$DeleteBtnListener;", "()V", "PICTURE_FROM_CAMERA", "", "getPICTURE_FROM_CAMERA", "()I", "REQUEST_ID_MULTIPLE_PERMISSIONS", "getREQUEST_ID_MULTIPLE_PERMISSIONS", "RESULT_LOAD_IMAGE", "addPic", "Landroidx/cardview/widget/CardView;", "btn_submit_step_2", "Landroidx/appcompat/widget/AppCompatButton;", "businessListStepOneModel_gl", "Lcom/milkyway/gbusiness/models/BusinessListStepOneModel;", "getBusinessListStepOneModel_gl", "()Lcom/milkyway/gbusiness/models/BusinessListStepOneModel;", "setBusinessListStepOneModel_gl", "(Lcom/milkyway/gbusiness/models/BusinessListStepOneModel;)V", "card_view_hide_list", "card_view_show_list", "editBusinessListingBack", "Landroid/widget/ImageView;", "et_gallery_tilte", "Landroid/widget/EditText;", "file", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "setFile", "(Ljava/io/File;)V", "fileUri", "Landroid/net/Uri;", "getFileUri", "()Landroid/net/Uri;", "setFileUri", "(Landroid/net/Uri;)V", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "mArrayUriList", "Ljava/util/ArrayList;", "getMArrayUriList", "()Ljava/util/ArrayList;", "setMArrayUriList", "(Ljava/util/ArrayList;)V", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "parts_list", "", "Lokhttp3/MultipartBody$Part;", "getParts_list", "()Ljava/util/List;", "setParts_list", "(Ljava/util/List;)V", "picturePath", "", "getPicturePath", "()Ljava/lang/String;", "setPicturePath", "(Ljava/lang/String;)V", "random", "Ljava/util/Random;", "getRandom", "()Ljava/util/Random;", "setRandom", "(Ljava/util/Random;)V", "rv_item_list", "Landroidx/recyclerview/widget/RecyclerView;", "rv_show_image_list", "stepTwoGalleryImagesAdapter", "Lcom/milkyway/gbusiness/adaptor/StepTwoGalleryImagesAdapter;", "getStepTwoGalleryImagesAdapter", "()Lcom/milkyway/gbusiness/adaptor/StepTwoGalleryImagesAdapter;", "setStepTwoGalleryImagesAdapter", "(Lcom/milkyway/gbusiness/adaptor/StepTwoGalleryImagesAdapter;)V", "tv_blank", "Landroid/widget/TextView;", "bindGalleryImagesAdapter", "", "bindItemListAdapter", "stepOneItemList_gl", "", "Lcom/milkyway/gbusiness/models/StepOneItemListsModel$BusinessItemsList;", "checkAndRequestPermissions", "", "deleteClickListener", "position", "stepTwoBusinessList", "deleteStepTwoListItemApi", "getBusinessItemList", "getMultiAttachment", "getPictureDialog", "initView", "view", "Landroid/view/View;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onViewCreated", "prepareFilePart", "partName", "savebitmap", "bmp", "Landroid/graphics/Bitmap;", "showDialogOK", "message", "okListener", "Landroid/content/DialogInterface$OnClickListener;", "submitStepTwoNewRecord", "updateClickListener", "app_debug"})
public final class Step2BusinessListFragment extends androidx.fragment.app.Fragment implements com.milkyway.gbusiness.adaptor.Step_2_BusinessListItemsAdapter.UpdateBtnListener, com.milkyway.gbusiness.adaptor.Step_2_BusinessListItemsAdapter.DeleteBtnListener {
    public android.content.Context mContext;
    private android.widget.ImageView editBusinessListingBack;
    private android.widget.EditText et_gallery_tilte;
    private androidx.recyclerview.widget.RecyclerView rv_show_image_list;
    private androidx.recyclerview.widget.RecyclerView rv_item_list;
    private androidx.appcompat.widget.AppCompatButton btn_submit_step_2;
    private androidx.cardview.widget.CardView card_view_show_list;
    private androidx.cardview.widget.CardView card_view_hide_list;
    private androidx.cardview.widget.CardView addPic;
    private androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager;
    private android.widget.TextView tv_blank;
    public com.milkyway.gbusiness.models.BusinessListStepOneModel businessListStepOneModel_gl;
    @org.jetbrains.annotations.Nullable()
    private com.milkyway.gbusiness.adaptor.StepTwoGalleryImagesAdapter stepTwoGalleryImagesAdapter;
    private int RESULT_LOAD_IMAGE = 101;
    private final int PICTURE_FROM_CAMERA = 1234;
    public java.io.File file;
    public java.lang.String picturePath;
    @org.jetbrains.annotations.NotNull()
    private java.util.Random random;
    @org.jetbrains.annotations.Nullable()
    private java.util.ArrayList<android.net.Uri> mArrayUriList;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<okhttp3.MultipartBody.Part> parts_list;
    public android.net.Uri fileUri;
    private final int REQUEST_ID_MULTIPLE_PERMISSIONS = 7;
    private java.util.HashMap _$_findViewCache;
    
    public Step2BusinessListFragment() {
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
    
    @org.jetbrains.annotations.Nullable()
    public final com.milkyway.gbusiness.adaptor.StepTwoGalleryImagesAdapter getStepTwoGalleryImagesAdapter() {
        return null;
    }
    
    public final void setStepTwoGalleryImagesAdapter(@org.jetbrains.annotations.Nullable()
    com.milkyway.gbusiness.adaptor.StepTwoGalleryImagesAdapter p0) {
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<android.net.Uri> getMArrayUriList() {
        return null;
    }
    
    public final void setMArrayUriList(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<android.net.Uri> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<okhttp3.MultipartBody.Part> getParts_list() {
        return null;
    }
    
    public final void setParts_list(@org.jetbrains.annotations.NotNull()
    java.util.List<okhttp3.MultipartBody.Part> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.net.Uri getFileUri() {
        return null;
    }
    
    public final void setFileUri(@org.jetbrains.annotations.NotNull()
    android.net.Uri p0) {
    }
    
    public final int getREQUEST_ID_MULTIPLE_PERMISSIONS() {
        return 0;
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
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initView(android.view.View view) {
    }
    
    public final void getBusinessItemList() {
    }
    
    public final void bindItemListAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.milkyway.gbusiness.models.StepOneItemListsModel.BusinessItemsList> stepOneItemList_gl) {
    }
    
    @java.lang.Override()
    public void updateClickListener(int position, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.StepOneItemListsModel.BusinessItemsList stepTwoBusinessList) {
    }
    
    @java.lang.Override()
    public void deleteClickListener(int position, @org.jetbrains.annotations.NotNull()
    java.util.List<com.milkyway.gbusiness.models.StepOneItemListsModel.BusinessItemsList> stepTwoBusinessList) {
    }
    
    private final void deleteStepTwoListItemApi(int position, java.util.List<com.milkyway.gbusiness.models.StepOneItemListsModel.BusinessItemsList> stepTwoBusinessList) {
    }
    
    private final void submitStepTwoNewRecord() {
    }
    
    public final void bindGalleryImagesAdapter(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<android.net.Uri> mArrayUriList) {
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
    
    @androidx.annotation.NonNull()
    private final okhttp3.MultipartBody.Part prepareFilePart(java.lang.String partName, android.net.Uri fileUri) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<okhttp3.MultipartBody.Part> getMultiAttachment() {
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
}