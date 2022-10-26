package com.milkyway.gbusiness.fragments;

import java.lang.System;

/**
 * A simple [Fragment] subclass.
 * Use the [OrderSummaryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0017\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u000eH\u0002\u00a2\u0006\u0002\u0010+J\n\u0010,\u001a\u0004\u0018\u00010\u0010H\u0007J\u000f\u0010-\u001a\u0004\u0018\u00010\u000eH\u0002\u00a2\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020)2\u0006\u00100\u001a\u00020\u0010H\u0002J\b\u00101\u001a\u00020)H\u0002J\u0018\u00102\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00122\u0006\u00103\u001a\u00020\u000eH\u0002J\b\u00104\u001a\u00020)H\u0002J\b\u00105\u001a\u00020)H\u0002J\u0012\u00106\u001a\u00020)2\b\u00107\u001a\u0004\u0018\u000108H\u0002J\u0010\u00109\u001a\u00020)2\u0006\u0010:\u001a\u00020\u001bH\u0016J\u0018\u0010;\u001a\u00020)2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u0013H\u0016JS\u0010>\u001a\u00020)2\u0006\u0010?\u001a\u00020\u00102\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00100A2\u0006\u0010B\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020\u000e2\u0006\u0010D\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\'2\u0006\u0010=\u001a\u00020\u0013H\u0016\u00a2\u0006\u0002\u0010HJ\u0012\u0010I\u001a\u00020)2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J&\u0010L\u001a\u0004\u0018\u0001082\u0006\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010P2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\u001a\u0010Q\u001a\u00020)2\u0006\u0010R\u001a\u00020\u000e2\b\u0010S\u001a\u0004\u0018\u00010KH\u0016J\u0012\u0010T\u001a\u00020)2\b\u00107\u001a\u0004\u0018\u000108H\u0002J\b\u0010U\u001a\u00020)H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006V"}, d2 = {"Lcom/milkyway/gbusiness/fragments/OrderSummaryFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/milkyway/gbusiness/adaptor/OrderCartItemAdapter$OnOrderListAdaptorClick;", "Lcom/milkyway/gbusiness/firebaseimpl/RazorpayResultReceiver$AppReceiver;", "()V", "adapter", "Lcom/milkyway/gbusiness/adaptor/OrderCartItemAdapter;", "getAdapter", "()Lcom/milkyway/gbusiness/adaptor/OrderCartItemAdapter;", "setAdapter", "(Lcom/milkyway/gbusiness/adaptor/OrderCartItemAdapter;)V", "btnPayNow", "Landroidx/appcompat/widget/AppCompatButton;", "gradTotalInt", "", "grandTotalTwoDecimal", "", "listCart", "", "Lcom/milkyway/gbusiness/models/SearchDomainDataDetailsClass$DomainList;", "listCheckout", "Lcom/milkyway/gbusiness/models/CheckoutRequest$Cart;", "getListCheckout", "()Ljava/util/List;", "setListCheckout", "(Ljava/util/List;)V", "mContext", "Landroid/content/Context;", "myOrderItemBack", "Landroid/widget/ImageView;", "resultReceiver", "Lcom/milkyway/gbusiness/firebaseimpl/RazorpayResultReceiver;", "getResultReceiver", "()Lcom/milkyway/gbusiness/firebaseimpl/RazorpayResultReceiver;", "setResultReceiver", "(Lcom/milkyway/gbusiness/firebaseimpl/RazorpayResultReceiver;)V", "rvDomainOrderItem", "Landroidx/recyclerview/widget/RecyclerView;", "tvTotalAmount", "Landroid/widget/TextView;", "callAutoLoginService", "", "invoiceId", "(Ljava/lang/Integer;)V", "createCartId", "createRandomId", "()Ljava/lang/Integer;", "errorToast", "message", "errorToastProfileNotComplete", "generateRandomArray", "n", "getProfileApi", "goCheckOut", "initializeViews", "view", "Landroid/view/View;", "onAttach", "context", "onClickedDeleterOrder", "pos", "list", "onClickedSpinnerYear", "selectedText", "years", "", "clickedPosition", "posAdapter", "positionSpinner", "spinnerYrDuration", "Landroid/widget/Spinner;", "tvTtlPrice", "(Ljava/lang/String;[Ljava/lang/String;IIILandroid/widget/Spinner;Landroid/widget/TextView;Lcom/milkyway/gbusiness/models/SearchDomainDataDetailsClass$DomainList;)V", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onReceiveResult", "resultCode", "resultData", "setClickListener", "setOrderListAdapter", "app_debug"})
public final class OrderSummaryFragment extends androidx.fragment.app.Fragment implements com.milkyway.gbusiness.adaptor.OrderCartItemAdapter.OnOrderListAdaptorClick, com.milkyway.gbusiness.firebaseimpl.RazorpayResultReceiver.AppReceiver {
    private android.widget.ImageView myOrderItemBack;
    private android.content.Context mContext;
    private androidx.recyclerview.widget.RecyclerView rvDomainOrderItem;
    private android.widget.TextView tvTotalAmount;
    private androidx.appcompat.widget.AppCompatButton btnPayNow;
    private java.util.List<com.milkyway.gbusiness.models.SearchDomainDataDetailsClass.DomainList> listCart;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.milkyway.gbusiness.models.CheckoutRequest.Cart> listCheckout;
    public com.milkyway.gbusiness.adaptor.OrderCartItemAdapter adapter;
    private java.lang.String grandTotalTwoDecimal = "";
    private int gradTotalInt = 0;
    public com.milkyway.gbusiness.firebaseimpl.RazorpayResultReceiver resultReceiver;
    private java.util.HashMap _$_findViewCache;
    
    public OrderSummaryFragment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.milkyway.gbusiness.models.CheckoutRequest.Cart> getListCheckout() {
        return null;
    }
    
    public final void setListCheckout(@org.jetbrains.annotations.Nullable()
    java.util.List<com.milkyway.gbusiness.models.CheckoutRequest.Cart> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.adaptor.OrderCartItemAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.adaptor.OrderCartItemAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.firebaseimpl.RazorpayResultReceiver getResultReceiver() {
        return null;
    }
    
    public final void setResultReceiver(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.firebaseimpl.RazorpayResultReceiver p0) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
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
    
    private final void initializeViews(android.view.View view) {
    }
    
    private final void getProfileApi() {
    }
    
    private final void goCheckOut() {
    }
    
    private final void callAutoLoginService(java.lang.Integer invoiceId) {
    }
    
    private final void errorToastProfileNotComplete() {
    }
    
    private final void errorToast(java.lang.String message) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @android.annotation.SuppressLint(value = {"SimpleDateFormat"})
    public final java.lang.String createCartId() {
        return null;
    }
    
    private final java.util.List<java.lang.Integer> generateRandomArray(int n) {
        return null;
    }
    
    private final java.lang.Integer createRandomId() {
        return null;
    }
    
    private final void setOrderListAdapter() {
    }
    
    @java.lang.Override()
    public void onClickedDeleterOrder(int pos, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.SearchDomainDataDetailsClass.DomainList list) {
    }
    
    @java.lang.Override()
    public void onClickedSpinnerYear(@org.jetbrains.annotations.NotNull()
    java.lang.String selectedText, @org.jetbrains.annotations.NotNull()
    java.lang.String[] years, int clickedPosition, int posAdapter, int positionSpinner, @org.jetbrains.annotations.NotNull()
    android.widget.Spinner spinnerYrDuration, @org.jetbrains.annotations.NotNull()
    android.widget.TextView tvTtlPrice, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.SearchDomainDataDetailsClass.DomainList list) {
    }
    
    @java.lang.Override()
    public void onReceiveResult(int resultCode, @org.jetbrains.annotations.Nullable()
    android.os.Bundle resultData) {
    }
}