package com.milkyway.gbusiness.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0006H\u00c6\u0003J\t\u0010 \u001a\u00020\u0006H\u00c6\u0003J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\nH\u00c6\u0003J\t\u0010#\u001a\u00020\fH\u00c6\u0003J\t\u0010$\u001a\u00020\u000eH\u00c6\u0003JY\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u00c6\u0001J\u0013\u0010&\u001a\u00020\n2\b\u0010\'\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010(\u001a\u00020\u0006H\u00d6\u0001J\t\u0010)\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006*"}, d2 = {"Lcom/milkyway/gbusiness/fragments/BillingDataClass;", "", "currency", "", "message", "domain_created_id", "", "invoice_id", "payAmount", "success", "", "walletAmount", "Lcom/milkyway/gbusiness/fragments/WalletAmount;", "invoice_slip", "Lcom/milkyway/gbusiness/models/Invoice_slip;", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ZLcom/milkyway/gbusiness/fragments/WalletAmount;Lcom/milkyway/gbusiness/models/Invoice_slip;)V", "getCurrency", "()Ljava/lang/String;", "getDomain_created_id", "()I", "getInvoice_id", "getInvoice_slip", "()Lcom/milkyway/gbusiness/models/Invoice_slip;", "getMessage", "getPayAmount", "getSuccess", "()Z", "getWalletAmount", "()Lcom/milkyway/gbusiness/fragments/WalletAmount;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class BillingDataClass {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String currency = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String message = null;
    private final int domain_created_id = 0;
    private final int invoice_id = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String payAmount = null;
    private final boolean success = false;
    @org.jetbrains.annotations.NotNull()
    private final com.milkyway.gbusiness.fragments.WalletAmount walletAmount = null;
    @org.jetbrains.annotations.NotNull()
    private final com.milkyway.gbusiness.models.Invoice_slip invoice_slip = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.fragments.BillingDataClass copy(@org.jetbrains.annotations.NotNull()
    java.lang.String currency, @org.jetbrains.annotations.NotNull()
    java.lang.String message, int domain_created_id, int invoice_id, @org.jetbrains.annotations.NotNull()
    java.lang.String payAmount, boolean success, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.fragments.WalletAmount walletAmount, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.Invoice_slip invoice_slip) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public BillingDataClass(@org.jetbrains.annotations.NotNull()
    java.lang.String currency, @org.jetbrains.annotations.NotNull()
    java.lang.String message, int domain_created_id, int invoice_id, @org.jetbrains.annotations.NotNull()
    java.lang.String payAmount, boolean success, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.fragments.WalletAmount walletAmount, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.Invoice_slip invoice_slip) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrency() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMessage() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getDomain_created_id() {
        return 0;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getInvoice_id() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPayAmount() {
        return null;
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final boolean getSuccess() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.fragments.WalletAmount component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.fragments.WalletAmount getWalletAmount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.Invoice_slip component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.Invoice_slip getInvoice_slip() {
        return null;
    }
}