package com.milkyway.gbusiness.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\bS\b\u0086\b\u0018\u00002\u00020\u0001:\u0003opqB\u00f5\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0001\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0001\u0012\u0006\u0010\u0015\u001a\u00020\u0001\u0012\u0006\u0010\u0016\u001a\u00020\u0001\u0012\u0006\u0010\u0017\u001a\u00020\u0001\u0012\u0006\u0010\u0018\u001a\u00020\u0001\u0012\u0006\u0010\u0019\u001a\u00020\u0005\u0012\u0006\u0010\u001a\u001a\u00020\r\u0012\u0006\u0010\u001b\u001a\u00020\t\u0012\u0006\u0010\u001c\u001a\u00020\u0001\u0012\u0006\u0010\u001d\u001a\u00020\r\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020\u0001\u0012\u0006\u0010!\u001a\u00020\u0001\u0012\u0006\u0010\"\u001a\u00020\r\u0012\u0006\u0010#\u001a\u00020\u0005\u0012\u0006\u0010$\u001a\u00020\u0001\u0012\u0006\u0010%\u001a\u00020\u0001\u00a2\u0006\u0002\u0010&J\t\u0010L\u001a\u00020\u0003H\u00c6\u0003J\t\u0010M\u001a\u00020\rH\u00c6\u0003J\t\u0010N\u001a\u00020\rH\u00c6\u0003J\t\u0010O\u001a\u00020\rH\u00c6\u0003J\t\u0010P\u001a\u00020\rH\u00c6\u0003J\t\u0010Q\u001a\u00020\u0001H\u00c6\u0003J\t\u0010R\u001a\u00020\u0001H\u00c6\u0003J\t\u0010S\u001a\u00020\u0001H\u00c6\u0003J\t\u0010T\u001a\u00020\u0001H\u00c6\u0003J\t\u0010U\u001a\u00020\u0001H\u00c6\u0003J\t\u0010V\u001a\u00020\u0005H\u00c6\u0003J\t\u0010W\u001a\u00020\u0005H\u00c6\u0003J\t\u0010X\u001a\u00020\rH\u00c6\u0003J\t\u0010Y\u001a\u00020\tH\u00c6\u0003J\t\u0010Z\u001a\u00020\u0001H\u00c6\u0003J\t\u0010[\u001a\u00020\rH\u00c6\u0003J\t\u0010\\\u001a\u00020\u001fH\u00c6\u0003J\t\u0010]\u001a\u00020\u0001H\u00c6\u0003J\t\u0010^\u001a\u00020\u0001H\u00c6\u0003J\t\u0010_\u001a\u00020\rH\u00c6\u0003J\t\u0010`\u001a\u00020\u0005H\u00c6\u0003J\t\u0010a\u001a\u00020\u0001H\u00c6\u0003J\t\u0010b\u001a\u00020\u0005H\u00c6\u0003J\t\u0010c\u001a\u00020\u0001H\u00c6\u0003J\t\u0010d\u001a\u00020\u0001H\u00c6\u0003J\t\u0010e\u001a\u00020\tH\u00c6\u0003J\t\u0010f\u001a\u00020\u000bH\u00c6\u0003J\t\u0010g\u001a\u00020\rH\u00c6\u0003J\t\u0010h\u001a\u00020\rH\u00c6\u0003J\t\u0010i\u001a\u00020\u0005H\u00c6\u0003J\u00b5\u0002\u0010j\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u00012\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u00012\b\b\u0002\u0010!\u001a\u00020\u00012\b\b\u0002\u0010\"\u001a\u00020\r2\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00012\b\b\u0002\u0010%\u001a\u00020\u0001H\u00c6\u0001J\u0013\u0010k\u001a\u00020\t2\b\u0010l\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010m\u001a\u00020\u0005H\u00d6\u0001J\t\u0010n\u001a\u00020\rH\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0011\u0010\u0007\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u000e\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u00103R\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010*R\u0011\u0010\u0010\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00103R\u0011\u0010\u0011\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u00103R\u0011\u0010\u0012\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u00103R\u0011\u0010\u0013\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u00103R\u0016\u0010\u0014\u001a\u00020\u00018\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010-R\u0016\u0010\u0015\u001a\u00020\u00018\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010-R\u0016\u0010\u0016\u001a\u00020\u00018\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010-R\u0016\u0010\u0017\u001a\u00020\u00018\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010-R\u0016\u0010\u0018\u001a\u00020\u00018\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010-R\u0011\u0010\u0019\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010*R\u0011\u0010\u001a\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u00103R\u0011\u0010\u001b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010/R\u0016\u0010\u001c\u001a\u00020\u00018\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010-R\u0011\u0010\u001d\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u00103R\u0011\u0010\u001e\u001a\u00020\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0016\u0010 \u001a\u00020\u00018\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010-R\u0016\u0010!\u001a\u00020\u00018\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u0010-R\u0011\u0010\"\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u00103R\u0011\u0010#\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bI\u0010*R\u0011\u0010$\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u0010-R\u0011\u0010%\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\bK\u0010-\u00a8\u0006r"}, d2 = {"Lcom/milkyway/gbusiness/models/RazorTransCaptureResponse;", "", "acquirerData", "Lcom/milkyway/gbusiness/models/RazorTransCaptureResponse$AcquirerData;", "amount", "", "amountRefunded", "bank", "captured", "", "card", "Lcom/milkyway/gbusiness/models/RazorTransCaptureResponse$Card;", "cardId", "", "contact", "createdAt", "currency", "description", "email", "entity", "errorCode", "errorDescription", "errorReason", "errorSource", "errorStep", "fee", "id", "international", "invoiceId", "method", "notes", "Lcom/milkyway/gbusiness/models/RazorTransCaptureResponse$Notes;", "orderId", "refundStatus", "status", "tax", "vpa", "wallet", "(Lcom/milkyway/gbusiness/models/RazorTransCaptureResponse$AcquirerData;IILjava/lang/Object;ZLcom/milkyway/gbusiness/models/RazorTransCaptureResponse$Card;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;ILjava/lang/String;ZLjava/lang/Object;Ljava/lang/String;Lcom/milkyway/gbusiness/models/RazorTransCaptureResponse$Notes;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;ILjava/lang/Object;Ljava/lang/Object;)V", "getAcquirerData", "()Lcom/milkyway/gbusiness/models/RazorTransCaptureResponse$AcquirerData;", "getAmount", "()I", "getAmountRefunded", "getBank", "()Ljava/lang/Object;", "getCaptured", "()Z", "getCard", "()Lcom/milkyway/gbusiness/models/RazorTransCaptureResponse$Card;", "getCardId", "()Ljava/lang/String;", "getContact", "getCreatedAt", "getCurrency", "getDescription", "getEmail", "getEntity", "getErrorCode", "getErrorDescription", "getErrorReason", "getErrorSource", "getErrorStep", "getFee", "getId", "getInternational", "getInvoiceId", "getMethod", "getNotes", "()Lcom/milkyway/gbusiness/models/RazorTransCaptureResponse$Notes;", "getOrderId", "getRefundStatus", "getStatus", "getTax", "getVpa", "getWallet", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "AcquirerData", "Card", "Notes", "app_debug"})
public final class RazorTransCaptureResponse {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "acquirer_data")
    private final com.milkyway.gbusiness.models.RazorTransCaptureResponse.AcquirerData acquirerData = null;
    private final int amount = 0;
    @com.google.gson.annotations.SerializedName(value = "amount_refunded")
    private final int amountRefunded = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object bank = null;
    private final boolean captured = false;
    @org.jetbrains.annotations.NotNull()
    private final com.milkyway.gbusiness.models.RazorTransCaptureResponse.Card card = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "card_id")
    private final java.lang.String cardId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String contact = null;
    @com.google.gson.annotations.SerializedName(value = "created_at")
    private final int createdAt = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String currency = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String email = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String entity = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "error_code")
    private final java.lang.Object errorCode = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "error_description")
    private final java.lang.Object errorDescription = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "error_reason")
    private final java.lang.Object errorReason = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "error_source")
    private final java.lang.Object errorSource = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "error_step")
    private final java.lang.Object errorStep = null;
    private final int fee = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    private final boolean international = false;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "invoice_id")
    private final java.lang.Object invoiceId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String method = null;
    @org.jetbrains.annotations.NotNull()
    private final com.milkyway.gbusiness.models.RazorTransCaptureResponse.Notes notes = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "order_id")
    private final java.lang.Object orderId = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "refund_status")
    private final java.lang.Object refundStatus = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String status = null;
    private final int tax = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object vpa = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object wallet = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.RazorTransCaptureResponse copy(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.RazorTransCaptureResponse.AcquirerData acquirerData, int amount, int amountRefunded, @org.jetbrains.annotations.NotNull()
    java.lang.Object bank, boolean captured, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.RazorTransCaptureResponse.Card card, @org.jetbrains.annotations.NotNull()
    java.lang.String cardId, @org.jetbrains.annotations.NotNull()
    java.lang.String contact, int createdAt, @org.jetbrains.annotations.NotNull()
    java.lang.String currency, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String entity, @org.jetbrains.annotations.NotNull()
    java.lang.Object errorCode, @org.jetbrains.annotations.NotNull()
    java.lang.Object errorDescription, @org.jetbrains.annotations.NotNull()
    java.lang.Object errorReason, @org.jetbrains.annotations.NotNull()
    java.lang.Object errorSource, @org.jetbrains.annotations.NotNull()
    java.lang.Object errorStep, int fee, @org.jetbrains.annotations.NotNull()
    java.lang.String id, boolean international, @org.jetbrains.annotations.NotNull()
    java.lang.Object invoiceId, @org.jetbrains.annotations.NotNull()
    java.lang.String method, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.RazorTransCaptureResponse.Notes notes, @org.jetbrains.annotations.NotNull()
    java.lang.Object orderId, @org.jetbrains.annotations.NotNull()
    java.lang.Object refundStatus, @org.jetbrains.annotations.NotNull()
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
    
    public RazorTransCaptureResponse(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.RazorTransCaptureResponse.AcquirerData acquirerData, int amount, int amountRefunded, @org.jetbrains.annotations.NotNull()
    java.lang.Object bank, boolean captured, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.RazorTransCaptureResponse.Card card, @org.jetbrains.annotations.NotNull()
    java.lang.String cardId, @org.jetbrains.annotations.NotNull()
    java.lang.String contact, int createdAt, @org.jetbrains.annotations.NotNull()
    java.lang.String currency, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String entity, @org.jetbrains.annotations.NotNull()
    java.lang.Object errorCode, @org.jetbrains.annotations.NotNull()
    java.lang.Object errorDescription, @org.jetbrains.annotations.NotNull()
    java.lang.Object errorReason, @org.jetbrains.annotations.NotNull()
    java.lang.Object errorSource, @org.jetbrains.annotations.NotNull()
    java.lang.Object errorStep, int fee, @org.jetbrains.annotations.NotNull()
    java.lang.String id, boolean international, @org.jetbrains.annotations.NotNull()
    java.lang.Object invoiceId, @org.jetbrains.annotations.NotNull()
    java.lang.String method, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.RazorTransCaptureResponse.Notes notes, @org.jetbrains.annotations.NotNull()
    java.lang.Object orderId, @org.jetbrains.annotations.NotNull()
    java.lang.Object refundStatus, @org.jetbrains.annotations.NotNull()
    java.lang.String status, int tax, @org.jetbrains.annotations.NotNull()
    java.lang.Object vpa, @org.jetbrains.annotations.NotNull()
    java.lang.Object wallet) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.RazorTransCaptureResponse.AcquirerData component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.RazorTransCaptureResponse.AcquirerData getAcquirerData() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getAmount() {
        return 0;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getAmountRefunded() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getBank() {
        return null;
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean getCaptured() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.RazorTransCaptureResponse.Card component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.RazorTransCaptureResponse.Card getCard() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCardId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContact() {
        return null;
    }
    
    public final int component9() {
        return 0;
    }
    
    public final int getCreatedAt() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrency() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEntity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getErrorCode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getErrorDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getErrorReason() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getErrorSource() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getErrorStep() {
        return null;
    }
    
    public final int component19() {
        return 0;
    }
    
    public final int getFee() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    public final boolean component21() {
        return false;
    }
    
    public final boolean getInternational() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component22() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getInvoiceId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component23() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMethod() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.RazorTransCaptureResponse.Notes component24() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.RazorTransCaptureResponse.Notes getNotes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component25() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getOrderId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component26() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getRefundStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component27() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatus() {
        return null;
    }
    
    public final int component28() {
        return 0;
    }
    
    public final int getTax() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component29() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getVpa() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object component30() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getWallet() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/milkyway/gbusiness/models/RazorTransCaptureResponse$AcquirerData;", "", "authCode", "", "(Ljava/lang/String;)V", "getAuthCode", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class AcquirerData {
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "auth_code")
        private final java.lang.String authCode = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.milkyway.gbusiness.models.RazorTransCaptureResponse.AcquirerData copy(@org.jetbrains.annotations.NotNull()
        java.lang.String authCode) {
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
        
        public AcquirerData(@org.jetbrains.annotations.NotNull()
        java.lang.String authCode) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAuthCode() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\'\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0001\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0001\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0001H\u00c6\u0003J\t\u0010 \u001a\u00020\u0005H\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0005H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0001H\u00c6\u0003J\t\u0010%\u001a\u00020\u0005H\u00c6\u0003J\t\u0010&\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0005H\u00c6\u0003J\t\u0010(\u001a\u00020\u0005H\u00c6\u0003Jw\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010*\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010,\u001a\u00020-H\u00d6\u0001J\t\u0010.\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0016\u0010\r\u001a\u00020\u00018\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013\u00a8\u0006/"}, d2 = {"Lcom/milkyway/gbusiness/models/RazorTransCaptureResponse$Card;", "", "emi", "", "entity", "", "id", "international", "issuer", "last4", "name", "network", "subType", "tokenIin", "type", "(ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "getEmi", "()Z", "getEntity", "()Ljava/lang/String;", "getId", "getInternational", "getIssuer", "()Ljava/lang/Object;", "getLast4", "getName", "getNetwork", "getSubType", "getTokenIin", "getType", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
    public static final class Card {
        private final boolean emi = false;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String entity = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String id = null;
        private final boolean international = false;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.Object issuer = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String last4 = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String name = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String network = null;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "sub_type")
        private final java.lang.String subType = null;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "token_iin")
        private final java.lang.Object tokenIin = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String type = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.milkyway.gbusiness.models.RazorTransCaptureResponse.Card copy(boolean emi, @org.jetbrains.annotations.NotNull()
        java.lang.String entity, @org.jetbrains.annotations.NotNull()
        java.lang.String id, boolean international, @org.jetbrains.annotations.NotNull()
        java.lang.Object issuer, @org.jetbrains.annotations.NotNull()
        java.lang.String last4, @org.jetbrains.annotations.NotNull()
        java.lang.String name, @org.jetbrains.annotations.NotNull()
        java.lang.String network, @org.jetbrains.annotations.NotNull()
        java.lang.String subType, @org.jetbrains.annotations.NotNull()
        java.lang.Object tokenIin, @org.jetbrains.annotations.NotNull()
        java.lang.String type) {
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
        
        public Card(boolean emi, @org.jetbrains.annotations.NotNull()
        java.lang.String entity, @org.jetbrains.annotations.NotNull()
        java.lang.String id, boolean international, @org.jetbrains.annotations.NotNull()
        java.lang.Object issuer, @org.jetbrains.annotations.NotNull()
        java.lang.String last4, @org.jetbrains.annotations.NotNull()
        java.lang.String name, @org.jetbrains.annotations.NotNull()
        java.lang.String network, @org.jetbrains.annotations.NotNull()
        java.lang.String subType, @org.jetbrains.annotations.NotNull()
        java.lang.Object tokenIin, @org.jetbrains.annotations.NotNull()
        java.lang.String type) {
            super();
        }
        
        public final boolean component1() {
            return false;
        }
        
        public final boolean getEmi() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getEntity() {
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
        
        public final boolean component4() {
            return false;
        }
        
        public final boolean getInternational() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.Object component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.Object getIssuer() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component6() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getLast4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component7() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component8() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getNetwork() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component9() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getSubType() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.Object component10() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.Object getTokenIin() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component11() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getType() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/milkyway/gbusiness/models/RazorTransCaptureResponse$Notes;", "", "address", "", "merchantOrderId", "(Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getMerchantOrderId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class Notes {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String address = null;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "merchant_order_id")
        private final java.lang.String merchantOrderId = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.milkyway.gbusiness.models.RazorTransCaptureResponse.Notes copy(@org.jetbrains.annotations.NotNull()
        java.lang.String address, @org.jetbrains.annotations.NotNull()
        java.lang.String merchantOrderId) {
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
        
        public Notes(@org.jetbrains.annotations.NotNull()
        java.lang.String address, @org.jetbrains.annotations.NotNull()
        java.lang.String merchantOrderId) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAddress() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getMerchantOrderId() {
            return null;
        }
    }
}