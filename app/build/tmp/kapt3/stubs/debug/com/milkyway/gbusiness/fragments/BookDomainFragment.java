package com.milkyway.gbusiness.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u001eH\u0002J(\u0010G\u001a\u00020E2\u0006\u0010H\u001a\u00020\"2\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`IH\u0002J\u001a\u0010J\u001a\u00020E2\b\u00103\u001a\u0004\u0018\u0001042\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\u0010\u0010K\u001a\u00020E2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010N\u001a\u00020E2\u0006\u0010O\u001a\u000206H\u0016J \u0010P\u001a\u00020E2\u0006\u0010Q\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020\u001e2\u0006\u0010R\u001a\u00020SH\u0016J&\u0010T\u001a\u0004\u0018\u00010M2\u0006\u0010U\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010X2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J\b\u0010[\u001a\u00020EH\u0002J \u0010\\\u001a\u00020E2\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`IH\u0002J\u0018\u0010]\u001a\u00020E2\u0006\u0010!\u001a\u00020\"2\u0006\u0010^\u001a\u00020\"H\u0002J\u0016\u0010_\u001a\u00020E2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002J\b\u0010`\u001a\u00020aH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\'\u001a\u00020(X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010$\"\u0004\b0\u0010&R\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010 R\u000e\u00103\u001a\u000204X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u00105\u001a\u000206X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020<X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020BX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006b"}, d2 = {"Lcom/milkyway/gbusiness/fragments/BookDomainFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/milkyway/gbusiness/adaptor/SearchDomainAdapter$OnDomainListAdaptorClick;", "()V", "btnBookDomain", "Landroid/widget/Button;", "getBtnBookDomain", "()Landroid/widget/Button;", "setBtnBookDomain", "(Landroid/widget/Button;)V", "cartItemSize", "", "getCartItemSize", "()I", "setCartItemSize", "(I)V", "cartValue", "getCartValue", "setCartValue", "customLoader", "Lcom/milkyway/gbusiness/global/CustomLoader;", "getCustomLoader", "()Lcom/milkyway/gbusiness/global/CustomLoader;", "setCustomLoader", "(Lcom/milkyway/gbusiness/global/CustomLoader;)V", "cvDomainError", "Landroidx/cardview/widget/CardView;", "cvDomainSuccess", "domainList", "Ljava/util/ArrayList;", "Lcom/milkyway/gbusiness/models/SearchDomainDataDetailsClass$DomainList;", "getDomainList", "()Ljava/util/ArrayList;", "domainStr", "", "getDomainStr", "()Ljava/lang/String;", "setDomainStr", "(Ljava/lang/String;)V", "etSearchDomain", "Landroid/widget/EditText;", "getEtSearchDomain", "()Landroid/widget/EditText;", "setEtSearchDomain", "(Landroid/widget/EditText;)V", "etSearchDomainStr", "filterName", "getFilterName", "setFilterName", "finalDomainList", "getFinalDomainList", "ibvCart", "Lru/nikartm/support/ImageBadgeView;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mySearchDomainBack", "Landroid/widget/ImageView;", "requestQueue", "Lcom/android/volley/RequestQueue;", "rvSearchDomainCartItem", "Landroidx/recyclerview/widget/RecyclerView;", "searchDomainNameError", "Landroid/widget/TextView;", "searchDomainNameSuccess", "addDomainData", "", "list", "callConfirmDomainApi", "confirmDomainName", "Lkotlin/collections/ArrayList;", "initIconWithBadges", "initializeViews", "view", "Landroid/view/View;", "onAttach", "context", "onBtnClickedAddToCart", "pos", "btnSearchDomainAddCart", "Landroidx/appcompat/widget/AppCompatButton;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "searchDomainApi", "searchDomainConfirmApi", "searchTldPricingApi", "searchDomain", "setAdapter", "validate", "", "app_debug"})
public final class BookDomainFragment extends androidx.fragment.app.Fragment implements com.milkyway.gbusiness.adaptor.SearchDomainAdapter.OnDomainListAdaptorClick {
    public android.widget.EditText etSearchDomain;
    public android.widget.Button btnBookDomain;
    private android.widget.ImageView mySearchDomainBack;
    public android.content.Context mContext;
    private androidx.cardview.widget.CardView cvDomainError;
    private androidx.cardview.widget.CardView cvDomainSuccess;
    private android.widget.TextView searchDomainNameError;
    private android.widget.TextView searchDomainNameSuccess;
    private ru.nikartm.support.ImageBadgeView ibvCart;
    private java.lang.String etSearchDomainStr;
    private com.android.volley.RequestQueue requestQueue;
    public com.milkyway.gbusiness.global.CustomLoader customLoader;
    private androidx.recyclerview.widget.RecyclerView rvSearchDomainCartItem;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String filterName = "";
    private int cartValue = 0;
    private int cartItemSize = 0;
    public java.lang.String domainStr;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.milkyway.gbusiness.models.SearchDomainDataDetailsClass.DomainList> domainList = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.milkyway.gbusiness.models.SearchDomainDataDetailsClass.DomainList> finalDomainList = null;
    private java.util.HashMap _$_findViewCache;
    
    public BookDomainFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getEtSearchDomain() {
        return null;
    }
    
    public final void setEtSearchDomain(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Button getBtnBookDomain() {
        return null;
    }
    
    public final void setBtnBookDomain(@org.jetbrains.annotations.NotNull()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.global.CustomLoader getCustomLoader() {
        return null;
    }
    
    public final void setCustomLoader(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.global.CustomLoader p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFilterName() {
        return null;
    }
    
    public final void setFilterName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getCartValue() {
        return 0;
    }
    
    public final void setCartValue(int p0) {
    }
    
    public final int getCartItemSize() {
        return 0;
    }
    
    public final void setCartItemSize(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDomainStr() {
        return null;
    }
    
    public final void setDomainStr(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.milkyway.gbusiness.models.SearchDomainDataDetailsClass.DomainList> getDomainList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.milkyway.gbusiness.models.SearchDomainDataDetailsClass.DomainList> getFinalDomainList() {
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
    
    private final void initializeViews(android.view.View view) {
    }
    
    private final void initIconWithBadges(ru.nikartm.support.ImageBadgeView ibvCart, int cartValue) {
    }
    
    private final void searchDomainApi() {
    }
    
    private final void searchDomainConfirmApi(java.util.ArrayList<com.milkyway.gbusiness.models.SearchDomainDataDetailsClass.DomainList> domainList) {
    }
    
    private final void callConfirmDomainApi(java.lang.String confirmDomainName, java.util.ArrayList<com.milkyway.gbusiness.models.SearchDomainDataDetailsClass.DomainList> domainList) {
    }
    
    private final void searchTldPricingApi(java.lang.String domainStr, java.lang.String searchDomain) {
    }
    
    private final void setAdapter(java.util.ArrayList<com.milkyway.gbusiness.models.SearchDomainDataDetailsClass.DomainList> domainList) {
    }
    
    private final void addDomainData(com.milkyway.gbusiness.models.SearchDomainDataDetailsClass.DomainList list) {
    }
    
    private final boolean validate() {
        return false;
    }
    
    @java.lang.Override()
    public void onBtnClickedAddToCart(int pos, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.SearchDomainDataDetailsClass.DomainList list, @org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.AppCompatButton btnSearchDomainAddCart) {
    }
}