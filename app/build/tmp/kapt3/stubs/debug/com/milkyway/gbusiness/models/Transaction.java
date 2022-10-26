package com.milkyway.gbusiness.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\tH\u00c6\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u00c6\u0003JA\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\"H\u00d6\u0001J\t\u0010#\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006$"}, d2 = {"Lcom/milkyway/gbusiness/models/Transaction;", "", "amount", "Lcom/milkyway/gbusiness/models/Amount;", "description", "", "item_list", "Lcom/milkyway/gbusiness/models/ItemList;", "payee", "Lcom/milkyway/gbusiness/models/Payee;", "related_resources", "", "Lcom/milkyway/gbusiness/models/RelatedResource;", "(Lcom/milkyway/gbusiness/models/Amount;Ljava/lang/String;Lcom/milkyway/gbusiness/models/ItemList;Lcom/milkyway/gbusiness/models/Payee;Ljava/util/List;)V", "getAmount", "()Lcom/milkyway/gbusiness/models/Amount;", "getDescription", "()Ljava/lang/String;", "getItem_list", "()Lcom/milkyway/gbusiness/models/ItemList;", "getPayee", "()Lcom/milkyway/gbusiness/models/Payee;", "getRelated_resources", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class Transaction {
    @org.jetbrains.annotations.NotNull()
    private final com.milkyway.gbusiness.models.Amount amount = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    @org.jetbrains.annotations.NotNull()
    private final com.milkyway.gbusiness.models.ItemList item_list = null;
    @org.jetbrains.annotations.NotNull()
    private final com.milkyway.gbusiness.models.Payee payee = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.milkyway.gbusiness.models.RelatedResource> related_resources = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.Transaction copy(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.Amount amount, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.ItemList item_list, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.Payee payee, @org.jetbrains.annotations.NotNull()
    java.util.List<com.milkyway.gbusiness.models.RelatedResource> related_resources) {
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
    
    public Transaction(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.Amount amount, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.ItemList item_list, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.Payee payee, @org.jetbrains.annotations.NotNull()
    java.util.List<com.milkyway.gbusiness.models.RelatedResource> related_resources) {
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
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.ItemList component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.ItemList getItem_list() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.Payee component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.Payee getPayee() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.milkyway.gbusiness.models.RelatedResource> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.milkyway.gbusiness.models.RelatedResource> getRelated_resources() {
        return null;
    }
}