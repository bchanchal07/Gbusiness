package com.milkyway.gbusiness.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00c6\u0003J\t\u0010\"\u001a\u00020\u000bH\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0\bH\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003Jo\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b2\b\b\u0002\u0010\u000f\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010*\u001a\u00020+H\u00d6\u0001J\t\u0010,\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012\u00a8\u0006-"}, d2 = {"Lcom/milkyway/gbusiness/models/PaypalTransDetailsDataClass;", "", "cart", "", "create_time", "id", "intent", "links", "", "Lcom/milkyway/gbusiness/models/LinkX;", "payer", "Lcom/milkyway/gbusiness/models/Payer;", "state", "transactions", "Lcom/milkyway/gbusiness/models/Transaction;", "update_time", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/milkyway/gbusiness/models/Payer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getCart", "()Ljava/lang/String;", "getCreate_time", "getId", "getIntent", "getLinks", "()Ljava/util/List;", "getPayer", "()Lcom/milkyway/gbusiness/models/Payer;", "getState", "getTransactions", "getUpdate_time", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class PaypalTransDetailsDataClass {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String cart = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String create_time = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String intent = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.milkyway.gbusiness.models.LinkX> links = null;
    @org.jetbrains.annotations.NotNull()
    private final com.milkyway.gbusiness.models.Payer payer = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String state = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.milkyway.gbusiness.models.Transaction> transactions = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String update_time = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.PaypalTransDetailsDataClass copy(@org.jetbrains.annotations.NotNull()
    java.lang.String cart, @org.jetbrains.annotations.NotNull()
    java.lang.String create_time, @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String intent, @org.jetbrains.annotations.NotNull()
    java.util.List<com.milkyway.gbusiness.models.LinkX> links, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.Payer payer, @org.jetbrains.annotations.NotNull()
    java.lang.String state, @org.jetbrains.annotations.NotNull()
    java.util.List<com.milkyway.gbusiness.models.Transaction> transactions, @org.jetbrains.annotations.NotNull()
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
    
    public PaypalTransDetailsDataClass(@org.jetbrains.annotations.NotNull()
    java.lang.String cart, @org.jetbrains.annotations.NotNull()
    java.lang.String create_time, @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String intent, @org.jetbrains.annotations.NotNull()
    java.util.List<com.milkyway.gbusiness.models.LinkX> links, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.Payer payer, @org.jetbrains.annotations.NotNull()
    java.lang.String state, @org.jetbrains.annotations.NotNull()
    java.util.List<com.milkyway.gbusiness.models.Transaction> transactions, @org.jetbrains.annotations.NotNull()
    java.lang.String update_time) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCart() {
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
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getIntent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.milkyway.gbusiness.models.LinkX> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.milkyway.gbusiness.models.LinkX> getLinks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.Payer component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.Payer getPayer() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.milkyway.gbusiness.models.Transaction> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.milkyway.gbusiness.models.Transaction> getTransactions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUpdate_time() {
        return null;
    }
}