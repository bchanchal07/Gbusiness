package com.milkyway.gbusiness.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/milkyway/gbusiness/utils/CommonUtil;", "", "()V", "Companion", "app_debug"})
public final class CommonUtil {
    @org.jetbrains.annotations.NotNull()
    public static final com.milkyway.gbusiness.utils.CommonUtil.Companion Companion = null;
    public static android.app.Dialog dialog;
    @org.jetbrains.annotations.Nullable()
    private static android.app.Dialog dialogLoader;
    
    public CommonUtil() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u000fH\u0007J&\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\"J\u001e\u0010$\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u001dJ\b\u0010%\u001a\u00020\rH\u0016J`\u0010&\u001a\u00020\u00192\b\u0010\'\u001a\u0004\u0018\u00010\u00152\b\u0010(\u001a\u0004\u0018\u00010\u00152\b\u0010)\u001a\u0004\u0018\u00010\u00152\b\u0010*\u001a\u0004\u0018\u00010\u00152\b\u0010+\u001a\u0004\u0018\u00010\u00152\b\u0010,\u001a\u0004\u0018\u00010\u00152\b\u0010-\u001a\u0004\u0018\u00010\u00152\b\u0010.\u001a\u0004\u0018\u00010\u00152\b\u0010/\u001a\u0004\u0018\u00010\u0015J\u001e\u00100\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u001dJ\u0016\u00101\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001022\u0006\u0010\u0011\u001a\u00020\u000fJ\u0016\u00103\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u0015J\u0018\u00105\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u0015J\u000e\u00106\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fJ \u00107\u001a\u00020\u00152\b\u00108\u001a\u0004\u0018\u00010\u00152\u0006\u00109\u001a\u00020\u00152\u0006\u00104\u001a\u00020\u0015J\u001e\u0010:\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u001dJ\u0010\u0010;\u001a\u00020\u00192\b\u0010<\u001a\u0004\u0018\u00010=J\u0010\u0010>\u001a\u00020\u00192\b\u0010?\u001a\u0004\u0018\u00010\u0015J\u0010\u0010@\u001a\u00020\u00192\b\u0010*\u001a\u0004\u0018\u00010\u0015J\u0010\u0010A\u001a\u00020\u00192\b\u0010B\u001a\u0004\u0018\u00010\u0015J\"\u0010C\u001a\u00020\r2\u0006\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010G2\b\u0010H\u001a\u0004\u0018\u00010\u0015J\u000e\u0010I\u001a\u00020\r2\u0006\u0010J\u001a\u00020\u0015J\u001e\u0010K\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u001dJ\u0018\u0010L\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010M\u001a\u00020\u0013J\u000e\u0010N\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fJ\u001e\u0010O\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000f2\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u000102J\u001e\u0010Q\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u00152\u0006\u0010R\u001a\u00020\u001fJ\u001e\u0010S\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u00152\u0006\u0010R\u001a\u00020\u0015J\u000e\u0010T\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fJ\u0010\u0010U\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u001dH\u0016J\u001e\u0010V\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u001dJ\u000e\u0010W\u001a\u00020\u00152\u0006\u0010X\u001a\u00020YJ\u0016\u0010Z\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u000fJ\u0016\u0010[\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\\2\u0006\u0010\u0011\u001a\u00020\u000fJ\u001e\u0010]\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u001dR\u001a\u0010\u0003\u001a\u00020\u0004X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b\u00a8\u0006^"}, d2 = {"Lcom/milkyway/gbusiness/utils/CommonUtil$Companion;", "", "()V", "dialog", "Landroid/app/Dialog;", "getDialog$app_debug", "()Landroid/app/Dialog;", "setDialog$app_debug", "(Landroid/app/Dialog;)V", "dialogLoader", "getDialogLoader", "setDialogLoader", "ClearSession", "", "mContext", "Landroid/content/Context;", "addCartItem", "context", "domain", "Lcom/milkyway/gbusiness/models/SearchDomainDataDetailsClass$DomainList;", "bytesToHex", "", "hash", "", "checkNetwork", "", "customToast", "title", "message", "Landroid/app/Activity;", "type", "", "decimslToString", "money", "", "decimslToStringUPtoFourDigit", "deleteToast", "dismissLoadingProgress", "eligibleForPurchaseDomain", "firstName", "lastName", "email", "mobile", "country", "state", "city", "address", "zipCode", "errorToast", "getCartItems", "Ljava/util/ArrayList;", "getIntPreferences", "key", "getPreferencesString", "hideDialog", "hmacWithJava", "algorithm", "data", "infoToast", "isUriEmpty", "uri", "Landroid/net/Uri;", "isValidMail", "mail", "isValidMobile", "isValidUrl", "urlString", "loadFragmentsWithBackStack", "activity", "Landroidx/fragment/app/FragmentActivity;", "selectedFragment", "Landroidx/fragment/app/Fragment;", "fragment_tag", "logi", "classBody", "noInternetToast", "removeCartItem", "product", "removeCartItems", "saveCartItem", "cartItemList", "saveIntPreferences", "value", "saveStringPreferences", "showDialog", "showLoadingProgress", "successToast", "toBase64String", "bm", "Landroid/graphics/Bitmap;", "toast", "toastError", "", "warningToast", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.app.Dialog getDialog$app_debug() {
            return null;
        }
        
        public final void setDialog$app_debug(@org.jetbrains.annotations.NotNull()
        android.app.Dialog p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public android.app.Dialog getDialogLoader() {
            return null;
        }
        
        public void setDialogLoader(@org.jetbrains.annotations.Nullable()
        android.app.Dialog p0) {
        }
        
        public void dismissLoadingProgress() {
        }
        
        public void showLoadingProgress(@org.jetbrains.annotations.NotNull()
        android.app.Activity context) {
        }
        
        public final boolean eligibleForPurchaseDomain(@org.jetbrains.annotations.Nullable()
        java.lang.String firstName, @org.jetbrains.annotations.Nullable()
        java.lang.String lastName, @org.jetbrains.annotations.Nullable()
        java.lang.String email, @org.jetbrains.annotations.Nullable()
        java.lang.String mobile, @org.jetbrains.annotations.Nullable()
        java.lang.String country, @org.jetbrains.annotations.Nullable()
        java.lang.String state, @org.jetbrains.annotations.Nullable()
        java.lang.String city, @org.jetbrains.annotations.Nullable()
        java.lang.String address, @org.jetbrains.annotations.Nullable()
        java.lang.String zipCode) {
            return false;
        }
        
        public final void toast(@org.jetbrains.annotations.NotNull()
        java.lang.String message, @org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        public final void customToast(@org.jetbrains.annotations.NotNull()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.lang.String message, @org.jetbrains.annotations.NotNull()
        android.app.Activity context, int type) {
        }
        
        public final void errorToast(@org.jetbrains.annotations.NotNull()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.lang.String message, @org.jetbrains.annotations.NotNull()
        android.app.Activity context) {
        }
        
        public final void successToast(@org.jetbrains.annotations.NotNull()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.lang.String message, @org.jetbrains.annotations.NotNull()
        android.app.Activity context) {
        }
        
        public final void warningToast(@org.jetbrains.annotations.NotNull()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.lang.String message, @org.jetbrains.annotations.NotNull()
        android.app.Activity context) {
        }
        
        public final void infoToast(@org.jetbrains.annotations.NotNull()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.lang.String message, @org.jetbrains.annotations.NotNull()
        android.app.Activity context) {
        }
        
        public final void deleteToast(@org.jetbrains.annotations.NotNull()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.lang.String message, @org.jetbrains.annotations.NotNull()
        android.app.Activity context) {
        }
        
        public final void noInternetToast(@org.jetbrains.annotations.NotNull()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.lang.String message, @org.jetbrains.annotations.NotNull()
        android.app.Activity context) {
        }
        
        public final void toastError(@org.jetbrains.annotations.NotNull()
        java.lang.CharSequence message, @org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        public final void saveStringPreferences(@org.jetbrains.annotations.NotNull()
        android.content.Context mContext, @org.jetbrains.annotations.NotNull()
        java.lang.String key, @org.jetbrains.annotations.NotNull()
        java.lang.String value) {
        }
        
        public final void saveIntPreferences(@org.jetbrains.annotations.NotNull()
        android.content.Context mContext, @org.jetbrains.annotations.NotNull()
        java.lang.String key, int value) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getPreferencesString(@org.jetbrains.annotations.NotNull()
        android.content.Context mContext, @org.jetbrains.annotations.NotNull()
        java.lang.String key) {
            return null;
        }
        
        public final int getIntPreferences(@org.jetbrains.annotations.NotNull()
        android.content.Context mContext, @org.jetbrains.annotations.NotNull()
        java.lang.String key) {
            return 0;
        }
        
        public final void ClearSession(@org.jetbrains.annotations.NotNull()
        android.content.Context mContext) {
        }
        
        public final void saveCartItem(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.Nullable()
        java.util.ArrayList<com.milkyway.gbusiness.models.SearchDomainDataDetailsClass.DomainList> cartItemList) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.util.ArrayList<com.milkyway.gbusiness.models.SearchDomainDataDetailsClass.DomainList> getCartItems(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        public final void removeCartItems(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        public final void addCartItem(@org.jetbrains.annotations.Nullable()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        com.milkyway.gbusiness.models.SearchDomainDataDetailsClass.DomainList domain) {
        }
        
        public final void removeCartItem(@org.jetbrains.annotations.Nullable()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        com.milkyway.gbusiness.models.SearchDomainDataDetailsClass.DomainList product) {
        }
        
        @android.annotation.SuppressLint(value = {"MissingPermission"})
        public final boolean checkNetwork(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return false;
        }
        
        public final void showDialog(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        public final void hideDialog(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        public final void logi(@org.jetbrains.annotations.NotNull()
        java.lang.String classBody) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String toBase64String(@org.jetbrains.annotations.NotNull()
        android.graphics.Bitmap bm) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String decimslToString(double money) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String decimslToStringUPtoFourDigit(double money) {
            return null;
        }
        
        public final boolean isValidMail(@org.jetbrains.annotations.Nullable()
        java.lang.String mail) {
            return false;
        }
        
        public final boolean isValidMobile(@org.jetbrains.annotations.Nullable()
        java.lang.String mobile) {
            return false;
        }
        
        public final boolean isValidUrl(@org.jetbrains.annotations.Nullable()
        java.lang.String urlString) {
            return false;
        }
        
        public final boolean isUriEmpty(@org.jetbrains.annotations.Nullable()
        android.net.Uri uri) {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.Throws(exceptionClasses = {java.security.NoSuchAlgorithmException.class, java.security.InvalidKeyException.class})
        public final java.lang.String hmacWithJava(@org.jetbrains.annotations.Nullable()
        java.lang.String algorithm, @org.jetbrains.annotations.NotNull()
        java.lang.String data, @org.jetbrains.annotations.NotNull()
        java.lang.String key) throws java.security.NoSuchAlgorithmException, java.security.InvalidKeyException {
            return null;
        }
        
        private final java.lang.String bytesToHex(byte[] hash) {
            return null;
        }
        
        public final void loadFragmentsWithBackStack(@org.jetbrains.annotations.NotNull()
        androidx.fragment.app.FragmentActivity activity, @org.jetbrains.annotations.Nullable()
        androidx.fragment.app.Fragment selectedFragment, @org.jetbrains.annotations.Nullable()
        java.lang.String fragment_tag) {
        }
    }
}