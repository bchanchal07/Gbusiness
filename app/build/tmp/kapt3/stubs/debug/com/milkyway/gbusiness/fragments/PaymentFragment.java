package com.milkyway.gbusiness.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00b0\u00012\u00020\u00012\u00020\u0002:\u0002\u00b0\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010t\u001a\u00020u2\u0006\u0010v\u001a\u00020\tH\u0016J \u0010w\u001a\u00020u2\u0006\u0010x\u001a\u0002002\b\u0010y\u001a\u0004\u0018\u00010z2\u0006\u0010{\u001a\u000205J\b\u0010|\u001a\u00020uH\u0002J\u0010\u0010}\u001a\u00020u2\u0006\u0010~\u001a\u00020\u007fH\u0002J\u0019\u0010\u0080\u0001\u001a\u00020]2\u0007\u0010\u0081\u0001\u001a\u00020\u00182\u0007\u0010\u0082\u0001\u001a\u00020\u0018J\u0010\u0010\u0083\u0001\u001a\u00020u2\u0007\u0010\u0084\u0001\u001a\u00020\tJ\t\u0010\u0085\u0001\u001a\u00020uH\u0002J\u0012\u0010\u0086\u0001\u001a\u00020u2\u0007\u0010\u0087\u0001\u001a\u00020\tH\u0002JG\u0010\u0088\u0001\u001a\u00020u2\u0007\u0010\u0089\u0001\u001a\u00020\t2\u0007\u0010\u008a\u0001\u001a\u00020\t2\u0007\u0010\u008b\u0001\u001a\u00020\t2\u0007\u0010\u008c\u0001\u001a\u00020\t2\u0007\u0010\u008d\u0001\u001a\u00020\t2\u0007\u0010\u008e\u0001\u001a\u00020\t2\u0006\u0010&\u001a\u00020\tH\u0002J$\u0010\u008f\u0001\u001a\u00030\u0090\u00012\u0007\u0010\u0091\u0001\u001a\u00020\t2\u0006\u0010P\u001a\u00020\t2\u0007\u0010\u0092\u0001\u001a\u00020\tH\u0002J\u000f\u0010\u0093\u0001\u001a\u00020u2\u0006\u0010x\u001a\u000200J\u0011\u0010\u0094\u0001\u001a\u00020u2\u0006\u0010~\u001a\u00020\u007fH\u0002J\'\u0010\u0095\u0001\u001a\u00020u2\u0007\u0010\u0096\u0001\u001a\u00020]2\u0007\u0010\u0097\u0001\u001a\u00020]2\n\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u0001H\u0016J\u0011\u0010\u009a\u0001\u001a\u00020u2\u0006\u0010x\u001a\u000200H\u0016J4\u0010\u009b\u0001\u001a\u00020u2\u0007\u0010\u009c\u0001\u001a\u00020\t2\u0006\u0010P\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0007\u0010\u009d\u0001\u001a\u00020\t2\u0007\u0010\u009e\u0001\u001a\u00020\tH\u0016J-\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u007f2\b\u0010\u00a0\u0001\u001a\u00030\u00a1\u00012\n\u0010\u00a2\u0001\u001a\u0005\u0018\u00010\u00a3\u00012\n\u0010\u00a4\u0001\u001a\u0005\u0018\u00010\u00a5\u0001H\u0017J\t\u0010\u00a6\u0001\u001a\u00020uH\u0016J\t\u0010\u00a7\u0001\u001a\u00020uH\u0016J\t\u0010\u00a8\u0001\u001a\u00020uH\u0016J\t\u0010\u00a9\u0001\u001a\u00020uH\u0016J\u0011\u0010\u00aa\u0001\u001a\u00020u2\u0006\u0010=\u001a\u00020\tH\u0002J\u001b\u0010\u00ab\u0001\u001a\u00020u2\u0006\u0010x\u001a\u0002002\b\u0010\u00ac\u0001\u001a\u00030\u00a5\u0001H\u0002J\t\u0010\u00ad\u0001\u001a\u00020uH\u0002JG\u0010\u00ae\u0001\u001a\u00020u2\u0006\u0010Y\u001a\u00020\t2\u0006\u0010h\u001a\u00020\t2\u0006\u0010\\\u001a\u00020]2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\t2\u0007\u0010\u008c\u0001\u001a\u00020\t2\u0007\u0010\u008d\u0001\u001a\u00020\t2\u0007\u0010\u008e\u0001\u001a\u00020\tH\u0002J\u001c\u0010\u00af\u0001\u001a\u00020u2\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010z2\u0006\u0010x\u001a\u000200H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\u001a\u0010&\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u0014\"\u0004\b(\u0010\u0016R\u001a\u0010)\u001a\u00020*X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u000200X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u00101\u001a\u00020*X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010,\"\u0004\b3\u0010.R\u001a\u00104\u001a\u000205X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u000e\u0010:\u001a\u00020;X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010>\u001a\u00020*X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010,\"\u0004\b@\u0010.R\u001a\u0010A\u001a\u00020*X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010,\"\u0004\bC\u0010.R\u001a\u0010D\u001a\u00020*X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010,\"\u0004\bF\u0010.R\u001a\u0010G\u001a\u00020*X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010,\"\u0004\bI\u0010.R\u001a\u0010J\u001a\u00020*X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010,\"\u0004\bL\u0010.R\u001a\u0010M\u001a\u00020*X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010,\"\u0004\bO\u0010.R\u001a\u0010P\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0014\"\u0004\bR\u0010\u0016R\u001a\u0010S\u001a\u00020TX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001a\u0010Y\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0014\"\u0004\b[\u0010\u0016R\u001a\u0010\\\u001a\u00020]X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001a\u0010b\u001a\u00020cX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001a\u0010h\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u0014\"\u0004\bj\u0010\u0016R\u001a\u0010k\u001a\u00020]X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bl\u0010_\"\u0004\bm\u0010aR\u001a\u0010n\u001a\u00020]X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bo\u0010_\"\u0004\bp\u0010aR\u001a\u0010q\u001a\u00020*X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\br\u0010,\"\u0004\bs\u0010.\u00a8\u0006\u00b1\u0001"}, d2 = {"Lcom/milkyway/gbusiness/fragments/PaymentFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/milkyway/gbusiness/api/OnAdpterClick;", "()V", "PaypalCheckBox", "Landroid/widget/CheckBox;", "RazorCheckBox", "WalletCheckBox", "access_tokenPaypal", "", "btnApplyCoupon", "Landroid/widget/Button;", "getBtnApplyCoupon", "()Landroid/widget/Button;", "setBtnApplyCoupon", "(Landroid/widget/Button;)V", "creditCheckBox", "debitCheckBox", "domainName", "getDomainName", "()Ljava/lang/String;", "setDomainName", "(Ljava/lang/String;)V", "enterBal", "", "getEnterBal", "()D", "setEnterBal", "(D)V", "enterWalletAmountEdt", "Landroid/widget/EditText;", "getEnterWalletAmountEdt", "()Landroid/widget/EditText;", "setEnterWalletAmountEdt", "(Landroid/widget/EditText;)V", "inputCurrency", "getInputCurrency", "setInputCurrency", "inputCurrencyInCreateOrder", "getInputCurrencyInCreateOrder", "setInputCurrencyInCreateOrder", "invoice_id", "Landroid/widget/TextView;", "getInvoice_id", "()Landroid/widget/TextView;", "setInvoice_id", "(Landroid/widget/TextView;)V", "mContext", "Landroid/content/Context;", "myWalletBalanceTv", "getMyWalletBalanceTv", "setMyWalletBalanceTv", "openOrderStatus", "", "getOpenOrderStatus", "()Z", "setOpenOrderStatus", "(Z)V", "paymentBack", "Landroid/widget/ImageView;", "paymentButton", "paymentMode", "paymentServiceDes", "getPaymentServiceDes", "setPaymentServiceDes", "paymentServiceName", "getPaymentServiceName", "setPaymentServiceName", "paymentServicePayAmount", "getPaymentServicePayAmount", "setPaymentServicePayAmount", "paymentServicePrice", "getPaymentServicePrice", "setPaymentServicePrice", "paymentServiceTotalPrice", "getPaymentServiceTotalPrice", "setPaymentServiceTotalPrice", "paypal", "getPaypal", "setPaypal", "price", "getPrice", "setPrice", "radioGpPayment", "Landroid/widget/RadioGroup;", "getRadioGpPayment", "()Landroid/widget/RadioGroup;", "setRadioGpPayment", "(Landroid/widget/RadioGroup;)V", "razorOrderId", "getRazorOrderId", "setRazorOrderId", "razorpayAmountInINR", "", "getRazorpayAmountInINR", "()I", "setRazorpayAmountInINR", "(I)V", "realm", "Lio/realm/Realm;", "getRealm", "()Lio/realm/Realm;", "setRealm", "(Lio/realm/Realm;)V", "receipt", "getReceipt", "setReceipt", "rstl", "getRstl", "setRstl", "rtnvalue", "getRtnvalue", "setRtnvalue", "tvPayFromWallet", "getTvPayFromWallet", "setTvPayFromWallet", "OnClick", "", "cartId", "checkRazorResponse", "context", "paymentData", "Lcom/razorpay/PaymentData;", "success", "checkValidation", "clickListener", "view", "Landroid/view/View;", "compareFun", "a", "b", "displayResultText", "result", "errorToastProfileNotComplete", "getProfileApi", "totalPrice", "getRazorpayOrderId", "payAmount", "wallet", "fullName", "email", "mobile", "fullAddress", "getThingToBuy", "Lcom/paypal/android/sdk/payments/PayPalPayment;", "paymentIntent", "buyThingName", "getToast", "initializeView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "onClickBtn", "cart_id", "services", "currency", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDestroyView", "onDetach", "onResume", "payNowWithCreditCard", "paymentStatus", "bundle", "setDefaultData", "startPaymentWithRazorPay", "updatePaymentStatus", "Companion", "app_debug"})
public final class PaymentFragment extends androidx.fragment.app.Fragment implements com.milkyway.gbusiness.api.OnAdpterClick {
    private android.widget.ImageView paymentBack;
    private boolean openOrderStatus = false;
    private int razorpayAmountInINR = 0;
    public io.realm.Realm realm;
    public android.widget.TextView paypal;
    public android.widget.TextView myWalletBalanceTv;
    public android.widget.TextView tvPayFromWallet;
    public android.widget.TextView invoice_id;
    public android.widget.RadioGroup radioGpPayment;
    public java.lang.String inputCurrency;
    public java.lang.String inputCurrencyInCreateOrder;
    public android.widget.TextView paymentServicePayAmount;
    public android.widget.TextView paymentServiceDes;
    public android.widget.TextView paymentServiceName;
    public android.widget.TextView paymentServicePrice;
    public android.widget.TextView paymentServiceTotalPrice;
    public android.widget.Button btnApplyCoupon;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String razorOrderId = "null";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String receipt = "800";
    public android.widget.EditText enterWalletAmountEdt;
    private android.content.Context mContext;
    private android.widget.CheckBox creditCheckBox;
    private android.widget.CheckBox debitCheckBox;
    private android.widget.CheckBox PaypalCheckBox;
    private android.widget.CheckBox RazorCheckBox;
    private android.widget.CheckBox WalletCheckBox;
    private android.widget.Button paymentButton;
    private java.lang.String access_tokenPaypal;
    private java.lang.String paymentMode = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String price = "0";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String domainName = "dummy";
    private int rstl = 4;
    private int rtnvalue = 4;
    private double enterBal = 0.0;
    @org.jetbrains.annotations.NotNull()
    public static final com.milkyway.gbusiness.fragments.PaymentFragment.Companion Companion = null;
    private static final java.lang.String TAG = "paymentExample";
    
    /**
     * - Set to PayPalConfiguration.ENVIRONMENT_PRODUCTION to move real money.
     * - Set to PayPalConfiguration.ENVIRONMENT_SANDBOX to use your test credentials
     * from https://developer.paypal.com
     * - Set to PayPalConfiguration.ENVIRONMENT_NO_NETWORK to kick the tires
     * without communicating to PayPal's servers.
     */
    private static final java.lang.String CONFIG_ENVIRONMENT = "sandbox";
    private static final java.lang.String CONFIG_CLIENT_ID = "AdPqT75Bupur0gIMKw7ESr5URvgtRtlqiry53xUO4hWg24TmPusfyBPws56whyeI7UirHp4LlR5wOq36";
    private static final java.lang.String CONFIG_SEC_ID = "ELGdx52-2Caagvv5yftzAFm1so3-uzEt-JbSXJJtiELy3MCiH4aH6QF9KVXoFh_oPl0xjKbY_LEEwDby";
    private static final int REQUEST_CODE_PAYMENT = 1;
    private static final int REQUEST_CODE_FUTURE_PAYMENT = 2;
    private static final int REQUEST_CODE_PROFILE_SHARING = 3;
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String invoic_id = "null";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String serviceName = "null";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String Description = "null";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String minPrice = "null";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String totalPrice = "null";
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String service = "domain";
    private static final com.paypal.android.sdk.payments.PayPalConfiguration config = null;
    private java.util.HashMap _$_findViewCache;
    
    public PaymentFragment() {
        super();
    }
    
    @java.lang.Override()
    public void OnClick(@org.jetbrains.annotations.NotNull()
    java.lang.String cartId) {
    }
    
    @java.lang.Override()
    public void onClickBtn(@org.jetbrains.annotations.NotNull()
    java.lang.String cart_id, @org.jetbrains.annotations.NotNull()
    java.lang.String price, @org.jetbrains.annotations.NotNull()
    java.lang.String domainName, @org.jetbrains.annotations.NotNull()
    java.lang.String services, @org.jetbrains.annotations.NotNull()
    java.lang.String currency) {
    }
    
    public final boolean getOpenOrderStatus() {
        return false;
    }
    
    public final void setOpenOrderStatus(boolean p0) {
    }
    
    public final int getRazorpayAmountInINR() {
        return 0;
    }
    
    public final void setRazorpayAmountInINR(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.realm.Realm getRealm() {
        return null;
    }
    
    public final void setRealm(@org.jetbrains.annotations.NotNull()
    io.realm.Realm p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getPaypal() {
        return null;
    }
    
    public final void setPaypal(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getMyWalletBalanceTv() {
        return null;
    }
    
    public final void setMyWalletBalanceTv(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getTvPayFromWallet() {
        return null;
    }
    
    public final void setTvPayFromWallet(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getInvoice_id() {
        return null;
    }
    
    public final void setInvoice_id(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.RadioGroup getRadioGpPayment() {
        return null;
    }
    
    public final void setRadioGpPayment(@org.jetbrains.annotations.NotNull()
    android.widget.RadioGroup p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getInputCurrency() {
        return null;
    }
    
    public final void setInputCurrency(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getInputCurrencyInCreateOrder() {
        return null;
    }
    
    public final void setInputCurrencyInCreateOrder(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getPaymentServicePayAmount() {
        return null;
    }
    
    public final void setPaymentServicePayAmount(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getPaymentServiceDes() {
        return null;
    }
    
    public final void setPaymentServiceDes(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getPaymentServiceName() {
        return null;
    }
    
    public final void setPaymentServiceName(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getPaymentServicePrice() {
        return null;
    }
    
    public final void setPaymentServicePrice(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getPaymentServiceTotalPrice() {
        return null;
    }
    
    public final void setPaymentServiceTotalPrice(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Button getBtnApplyCoupon() {
        return null;
    }
    
    public final void setBtnApplyCoupon(@org.jetbrains.annotations.NotNull()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRazorOrderId() {
        return null;
    }
    
    public final void setRazorOrderId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReceipt() {
        return null;
    }
    
    public final void setReceipt(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getEnterWalletAmountEdt() {
        return null;
    }
    
    public final void setEnterWalletAmountEdt(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPrice() {
        return null;
    }
    
    public final void setPrice(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDomainName() {
        return null;
    }
    
    public final void setDomainName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getRstl() {
        return 0;
    }
    
    public final void setRstl(int p0) {
    }
    
    public final int getRtnvalue() {
        return 0;
    }
    
    public final void setRtnvalue(int p0) {
    }
    
    public final double getEnterBal() {
        return 0.0;
    }
    
    public final void setEnterBal(double p0) {
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @org.jetbrains.annotations.Nullable()
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void initializeView(android.view.View view) {
    }
    
    private final void setDefaultData() {
    }
    
    private final void clickListener(android.view.View view) {
    }
    
    private final void getProfileApi(java.lang.String totalPrice) {
    }
    
    private final void errorToastProfileNotComplete() {
    }
    
    private final void getRazorpayOrderId(java.lang.String payAmount, java.lang.String wallet, java.lang.String fullName, java.lang.String email, java.lang.String mobile, java.lang.String fullAddress, java.lang.String inputCurrencyInCreateOrder) {
    }
    
    private final void startPaymentWithRazorPay(java.lang.String razorOrderId, java.lang.String receipt, int razorpayAmountInINR, java.lang.String fullName, java.lang.String email, java.lang.String mobile, java.lang.String fullAddress) {
    }
    
    public final void checkRazorResponse(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    com.razorpay.PaymentData paymentData, boolean success) {
    }
    
    public final void getToast(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    private final void updatePaymentStatus(com.razorpay.PaymentData data, android.content.Context context) {
    }
    
    private final void paymentStatus(android.content.Context context, android.os.Bundle bundle) {
    }
    
    private final void payNowWithCreditCard(java.lang.String paymentMode) {
    }
    
    private final void checkValidation() {
    }
    
    private final com.paypal.android.sdk.payments.PayPalPayment getThingToBuy(java.lang.String paymentIntent, java.lang.String price, java.lang.String buyThingName) {
        return null;
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    public final void displayResultText(@org.jetbrains.annotations.NotNull()
    java.lang.String result) {
    }
    
    public final int compareFun(double a, double b) {
        return 0;
    }
    
    @java.lang.Override()
    public void onDetach() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\u000bR\u001a\u0010\u0017\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\t\"\u0004\b\u0019\u0010\u000bR\u001a\u0010\u001a\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\t\"\u0004\b\u001c\u0010\u000bR\u001a\u0010\u001d\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\t\"\u0004\b\u001f\u0010\u000bR\u001a\u0010 \u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\t\"\u0004\b\"\u0010\u000b\u00a8\u0006#"}, d2 = {"Lcom/milkyway/gbusiness/fragments/PaymentFragment$Companion;", "", "()V", "CONFIG_CLIENT_ID", "", "CONFIG_ENVIRONMENT", "CONFIG_SEC_ID", "Description", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "REQUEST_CODE_FUTURE_PAYMENT", "", "REQUEST_CODE_PAYMENT", "REQUEST_CODE_PROFILE_SHARING", "TAG", "config", "Lcom/paypal/android/sdk/payments/PayPalConfiguration;", "kotlin.jvm.PlatformType", "invoic_id", "getInvoic_id", "setInvoic_id", "minPrice", "getMinPrice", "setMinPrice", "service", "getService", "setService", "serviceName", "getServiceName", "setServiceName", "totalPrice", "getTotalPrice", "setTotalPrice", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getInvoic_id() {
            return null;
        }
        
        public final void setInvoic_id(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getServiceName() {
            return null;
        }
        
        public final void setServiceName(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDescription() {
            return null;
        }
        
        public final void setDescription(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getMinPrice() {
            return null;
        }
        
        public final void setMinPrice(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTotalPrice() {
            return null;
        }
        
        public final void setTotalPrice(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getService() {
            return null;
        }
        
        public final void setService(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
    }
}