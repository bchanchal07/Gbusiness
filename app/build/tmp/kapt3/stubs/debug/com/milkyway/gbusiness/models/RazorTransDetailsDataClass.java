package com.milkyway.gbusiness.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\bG\b\u0086\b\u0018\u00002\u00020\u0001B\u00d5\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0001\u0012\u0006\u0010\u0013\u001a\u00020\u0001\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\u0001\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u0006\u0012\u0006\u0010\u001c\u001a\u00020\u0001\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0001\u0012\u0006\u0010 \u001a\u00020\u0001\u00a2\u0006\u0002\u0010!J\t\u0010B\u001a\u00020\u0003H\u00c6\u0003J\t\u0010C\u001a\u00020\u0006H\u00c6\u0003J\t\u0010D\u001a\u00020\u0006H\u00c6\u0003J\t\u0010E\u001a\u00020\u0006H\u00c6\u0003J\t\u0010F\u001a\u00020\u0001H\u00c6\u0003J\t\u0010G\u001a\u00020\u0001H\u00c6\u0003J\t\u0010H\u001a\u00020\u0003H\u00c6\u0003J\t\u0010I\u001a\u00020\u0006H\u00c6\u0003J\t\u0010J\u001a\u00020\bH\u00c6\u0003J\t\u0010K\u001a\u00020\u0001H\u00c6\u0003J\t\u0010L\u001a\u00020\u0006H\u00c6\u0003J\t\u0010M\u001a\u00020\u0003H\u00c6\u0003J\t\u0010N\u001a\u00020\u001aH\u00c6\u0003J\t\u0010O\u001a\u00020\u0006H\u00c6\u0003J\t\u0010P\u001a\u00020\u0001H\u00c6\u0003J\t\u0010Q\u001a\u00020\u0006H\u00c6\u0003J\t\u0010R\u001a\u00020\u0003H\u00c6\u0003J\t\u0010S\u001a\u00020\u0001H\u00c6\u0003J\t\u0010T\u001a\u00020\u0001H\u00c6\u0003J\t\u0010U\u001a\u00020\u0006H\u00c6\u0003J\t\u0010V\u001a\u00020\bH\u00c6\u0003J\t\u0010W\u001a\u00020\nH\u00c6\u0003J\t\u0010X\u001a\u00020\u0006H\u00c6\u0003J\t\u0010Y\u001a\u00020\u0006H\u00c6\u0003J\t\u0010Z\u001a\u00020\u0003H\u00c6\u0003J\t\u0010[\u001a\u00020\u0006H\u00c6\u0003J\u008d\u0002\u0010\\\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u00012\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020\u0001H\u00c6\u0001J\u0013\u0010]\u001a\u00020\b2\b\u0010^\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010_\u001a\u00020\u0003H\u00d6\u0001J\t\u0010`\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010&R\u0011\u0010\f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010&R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010#R\u0011\u0010\u000e\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010&R\u0011\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010&R\u0011\u0010\u0010\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010&R\u0011\u0010\u0011\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010&R\u0011\u0010\u0012\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u0013\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u00103R\u0011\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010#R\u0011\u0010\u0015\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010&R\u0011\u0010\u0016\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010(R\u0011\u0010\u0017\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u00103R\u0011\u0010\u0018\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010&R\u0011\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010\u001b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010&R\u0011\u0010\u001c\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u00103R\u0011\u0010\u001d\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010&R\u0011\u0010\u001e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010#R\u0011\u0010\u001f\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u00103R\u0011\u0010 \u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u00103\u00a8\u0006a"}, d2 = {"Lcom/milkyway/gbusiness/models/RazorTransDetailsDataClass;", "", "amount", "", "amount_refunded", "bank", "", "captured", "", "card", "Lcom/milkyway/gbusiness/models/Card;", "card_id", "contact", "created_at", "currency", "description", "email", "entity", "error_code", "error_description", "fee", "id", "international", "invoice_id", "method", "notes", "Lcom/milkyway/gbusiness/models/NotesX;", "order_id", "refund_status", "status", "tax", "vpa", "wallet", "(IILjava/lang/String;ZLcom/milkyway/gbusiness/models/Card;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;ILjava/lang/String;ZLjava/lang/Object;Ljava/lang/String;Lcom/milkyway/gbusiness/models/NotesX;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;ILjava/lang/Object;Ljava/lang/Object;)V", "getAmount", "()I", "getAmount_refunded", "getBank", "()Ljava/lang/String;", "getCaptured", "()Z", "getCard", "()Lcom/milkyway/gbusiness/models/Card;", "getCard_id", "getContact", "getCreated_at", "getCurrency", "getDescription", "getEmail", "getEntity", "getError_code", "()Ljava/lang/Object;", "getError_description", "getFee", "getId", "getInternational", "getInvoice_id", "getMethod", "getNotes", "()Lcom/milkyway/gbusiness/models/NotesX;", "getOrder_id", "getRefund_status", "getStatus", "getTax", "getVpa", "getWallet", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class RazorTransDetailsDataClass {
    private final int amount = 0;
    private final int amount_refunded = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String bank = null;
    private final boolean captured = false;
    @org.jetbrains.annotations.NotNull()
    private final com.milkyway.gbusiness.models.Card card = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String card_id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String contact = null;
    private final int created_at = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String currency = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String email = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String entity = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object error_code = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object error_description = null;
    private final int fee = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    private final boolean international = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object invoice_id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String method = null;
    @org.jetbrains.annotations.NotNull()
    private final com.milkyway.gbusiness.models.NotesX notes = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String order_id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object refund_status = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String status = null;
    private final int tax = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object vpa = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object wallet = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.RazorTransDetailsDataClass copy(int amount, int amount_refunded, @org.jetbrains.annotations.NotNull()
    java.lang.String bank, boolean captured, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.Card card, @org.jetbrains.annotations.NotNull()
    java.lang.String card_id, @org.jetbrains.annotations.NotNull()
    java.lang.String contact, int created_at, @org.jetbrains.annotations.NotNull()
    java.lang.String currency, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String entity, @org.jetbrains.annotations.NotNull()
    java.lang.Object error_code, @org.jetbrains.annotations.NotNull()
    java.lang.Object error_description, int fee, @org.jetbrains.annotations.NotNull()
    java.lang.String id, boolean international, @org.jetbrains.annotations.NotNull()
    java.lang.Object invoice_id, @org.jetbrains.annotations.NotNull()
    java.lang.String method, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.NotesX notes, @org.jetbrains.annotations.NotNull()
    java.lang.String order_id, @org.jetbrains.annotations.NotNull()
    java.lang.Object refund_status, @org.jetbrains.annotations.NotNull()
    java.lang.String status, int tax, @org.jetbrains.annotations.NotNull()
    java.lang.Object vpa, @org.jetbrains.annotations.NotNull()
    java.lang.Object wallet) {
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
    
    public RazorTransDetailsDataClass(int amount, int amount_refunded, @org.jetbrains.annotations.NotNull()
    java.lang.String bank, boolean captured, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.Card card, @org.jetbrains.annotations.NotNull()
    java.lang.String card_id, @org.jetbrains.annotations.NotNull()
    java.lang.String contact, int created_at, @org.jetbrains.annotations.NotNull()
    java.lang.String currency, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String entity, @org.jetbrains.annotations.NotNull()
    java.lang.Object error_code, @org.jetbrains.annotations.NotNull()
    java.lang.Object error_description, int fee, @org.jetbrains.annotations.NotNull()
    java.lang.String id, boolean international, @org.jetbrains.annotations.NotNull()
    java.lang.Object invoice_id, @org.jetbrains.annotations.NotNull()
    java.lang.String method, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.NotesX notes, @org.jetbrains.annotations.NotNull()
    java.lang.String order_id, @org.jetbrains.annotations.NotNull()
    java.lang.Object refund_status, @org.jetbrains.annotations.NotNull()
    java.lang.String status, int tax, @org.jetbrains.annotations.NotNull()
    java.lang.Object vpa, @org.jetbrains.annotations.NotNull()
    java.lang.Object wallet) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getAmount() {
        return 0;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getAmount_refunded() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBank() {
        return null;
    }
    
    public final boolean component4() {
        return false;
    }
    
    public final boolean getCaptured() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.Card component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.Card getCard() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCard_id() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContact() {
        return null;
    }
    
    public final int component8() {
        return 0;
    }
    
    public final int getCreated_at() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrency() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEntity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getError_code() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getError_description() {
        return null;
    }
    
    public final int component15() {
        return 0;
    }
    
    public final int getFee() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    public final boolean component17() {
        return false;
    }
    
    public final boolean getInternational() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getInvoice_id() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMethod() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.NotesX component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.NotesX getNotes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component21() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOrder_id() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component22() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getRefund_status() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component23() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatus() {
        return null;
    }
    
    public final int component24() {
        return 0;
    }
    
    public final int getTax() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component25() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getVpa() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component26() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getWallet() {
        return null;
    }
}