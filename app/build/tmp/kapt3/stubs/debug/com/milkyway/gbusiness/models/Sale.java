package com.milkyway.gbusiness.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0012J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0010H\u00c6\u0003J\t\u0010$\u001a\u00020\u0005H\u00c6\u0003J\t\u0010%\u001a\u00020\u0005H\u00c6\u0003J\t\u0010&\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\'\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00c6\u0003J\t\u0010(\u001a\u00020\u0005H\u00c6\u0003J\t\u0010)\u001a\u00020\u0005H\u00c6\u0003J\t\u0010*\u001a\u00020\u0005H\u00c6\u0003J\t\u0010+\u001a\u00020\u0005H\u00c6\u0003J\t\u0010,\u001a\u00020\u0005H\u00c6\u0003J}\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00101\u001a\u000202H\u00d6\u0001J\t\u00103\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0011\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016\u00a8\u00064"}, d2 = {"Lcom/milkyway/gbusiness/models/Sale;", "", "amount", "Lcom/milkyway/gbusiness/models/Amount;", "create_time", "", "id", "links", "", "Lcom/milkyway/gbusiness/models/Link;", "parent_payment", "payment_mode", "protection_eligibility", "protection_eligibility_type", "state", "transaction_fee", "Lcom/milkyway/gbusiness/models/TransactionFee;", "update_time", "(Lcom/milkyway/gbusiness/models/Amount;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/milkyway/gbusiness/models/TransactionFee;Ljava/lang/String;)V", "getAmount", "()Lcom/milkyway/gbusiness/models/Amount;", "getCreate_time", "()Ljava/lang/String;", "getId", "getLinks", "()Ljava/util/List;", "getParent_payment", "getPayment_mode", "getProtection_eligibility", "getProtection_eligibility_type", "getState", "getTransaction_fee", "()Lcom/milkyway/gbusiness/models/TransactionFee;", "getUpdate_time", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class Sale {
    @org.jetbrains.annotations.NotNull()
    private final com.milkyway.gbusiness.models.Amount amount = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String create_time = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.milkyway.gbusiness.models.Link> links = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String parent_payment = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String payment_mode = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String protection_eligibility = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String protection_eligibility_type = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String state = null;
    @org.jetbrains.annotations.NotNull()
    private final com.milkyway.gbusiness.models.TransactionFee transaction_fee = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String update_time = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.Sale copy(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.Amount amount, @org.jetbrains.annotations.NotNull()
    java.lang.String create_time, @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.util.List<com.milkyway.gbusiness.models.Link> links, @org.jetbrains.annotations.NotNull()
    java.lang.String parent_payment, @org.jetbrains.annotations.NotNull()
    java.lang.String payment_mode, @org.jetbrains.annotations.NotNull()
    java.lang.String protection_eligibility, @org.jetbrains.annotations.NotNull()
    java.lang.String protection_eligibility_type, @org.jetbrains.annotations.NotNull()
    java.lang.String state, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.TransactionFee transaction_fee, @org.jetbrains.annotations.NotNull()
    java.lang.String update_time) {
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
    
    public Sale(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.Amount amount, @org.jetbrains.annotations.NotNull()
    java.lang.String create_time, @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.util.List<com.milkyway.gbusiness.models.Link> links, @org.jetbrains.annotations.NotNull()
    java.lang.String parent_payment, @org.jetbrains.annotations.NotNull()
    java.lang.String payment_mode, @org.jetbrains.annotations.NotNull()
    java.lang.String protection_eligibility, @org.jetbrains.annotations.NotNull()
    java.lang.String protection_eligibility_type, @org.jetbrains.annotations.NotNull()
    java.lang.String state, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.TransactionFee transaction_fee, @org.jetbrains.annotations.NotNull()
    java.lang.String update_time) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.Amount component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.Amount getAmount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCreate_time() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.milkyway.gbusiness.models.Link> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.milkyway.gbusiness.models.Link> getLinks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getParent_payment() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPayment_mode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getProtection_eligibility() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getProtection_eligibility_type() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.TransactionFee component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.TransactionFee getTransaction_fee() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUpdate_time() {
        return null;
    }
}