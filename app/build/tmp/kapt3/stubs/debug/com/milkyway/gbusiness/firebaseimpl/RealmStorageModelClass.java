package com.milkyway.gbusiness.firebaseimpl;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b9\b\u0016\u0018\u00002\u00020\u0001B\u00dd\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0015R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0017\"\u0004\b\'\u0010\u0019R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0017\"\u0004\b-\u0010\u0019R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0017\"\u0004\b/\u0010\u0019R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u0010\u0019R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0017\"\u0004\b3\u0010\u0019R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0017\"\u0004\b5\u0010\u0019R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0017\"\u0004\b7\u0010\u0019R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0017\"\u0004\b9\u0010\u0019R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0017\"\u0004\b;\u0010\u0019\u00a8\u0006<"}, d2 = {"Lcom/milkyway/gbusiness/firebaseimpl/RealmStorageModelClass;", "Lio/realm/RealmObject;", "payMethod", "", "paytype", "pay_id", "invoice_id", "user_id", "captured", "transaction_id", "bank_ref_no", "order_status", "failure_message", "payment_mode", "card_name", "currency", "amount", "created_at", "domain_name", "status", "workingStage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/String;", "setAmount", "(Ljava/lang/String;)V", "getBank_ref_no", "setBank_ref_no", "getCaptured", "setCaptured", "getCard_name", "setCard_name", "getCreated_at", "setCreated_at", "getCurrency", "setCurrency", "getDomain_name", "setDomain_name", "getFailure_message", "setFailure_message", "getInvoice_id", "setInvoice_id", "getOrder_status", "setOrder_status", "getPayMethod", "setPayMethod", "getPay_id", "setPay_id", "getPayment_mode", "setPayment_mode", "getPaytype", "setPaytype", "getStatus", "setStatus", "getTransaction_id", "setTransaction_id", "getUser_id", "setUser_id", "getWorkingStage", "setWorkingStage", "app_debug"})
public class RealmStorageModelClass extends io.realm.RealmObject {
    @org.jetbrains.annotations.Nullable()
    private java.lang.String payMethod;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String paytype;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String pay_id;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String invoice_id;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String user_id;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String captured;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String transaction_id;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String bank_ref_no;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String order_status;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String failure_message;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String payment_mode;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String card_name;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String currency;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String amount;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String created_at;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String domain_name;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String status;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String workingStage;
    
    public RealmStorageModelClass() {
        super();
    }
    
    public RealmStorageModelClass(@org.jetbrains.annotations.Nullable()
    java.lang.String payMethod, @org.jetbrains.annotations.Nullable()
    java.lang.String paytype, @org.jetbrains.annotations.Nullable()
    java.lang.String pay_id, @org.jetbrains.annotations.Nullable()
    java.lang.String invoice_id, @org.jetbrains.annotations.Nullable()
    java.lang.String user_id, @org.jetbrains.annotations.Nullable()
    java.lang.String captured, @org.jetbrains.annotations.Nullable()
    java.lang.String transaction_id, @org.jetbrains.annotations.Nullable()
    java.lang.String bank_ref_no, @org.jetbrains.annotations.Nullable()
    java.lang.String order_status, @org.jetbrains.annotations.Nullable()
    java.lang.String failure_message, @org.jetbrains.annotations.Nullable()
    java.lang.String payment_mode, @org.jetbrains.annotations.Nullable()
    java.lang.String card_name, @org.jetbrains.annotations.Nullable()
    java.lang.String currency, @org.jetbrains.annotations.Nullable()
    java.lang.String amount, @org.jetbrains.annotations.Nullable()
    java.lang.String created_at, @org.jetbrains.annotations.Nullable()
    java.lang.String domain_name, @org.jetbrains.annotations.Nullable()
    java.lang.String status, @org.jetbrains.annotations.Nullable()
    java.lang.String workingStage) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPayMethod() {
        return null;
    }
    
    public final void setPayMethod(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPaytype() {
        return null;
    }
    
    public final void setPaytype(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPay_id() {
        return null;
    }
    
    public final void setPay_id(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getInvoice_id() {
        return null;
    }
    
    public final void setInvoice_id(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUser_id() {
        return null;
    }
    
    public final void setUser_id(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCaptured() {
        return null;
    }
    
    public final void setCaptured(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTransaction_id() {
        return null;
    }
    
    public final void setTransaction_id(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBank_ref_no() {
        return null;
    }
    
    public final void setBank_ref_no(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getOrder_status() {
        return null;
    }
    
    public final void setOrder_status(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFailure_message() {
        return null;
    }
    
    public final void setFailure_message(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPayment_mode() {
        return null;
    }
    
    public final void setPayment_mode(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCard_name() {
        return null;
    }
    
    public final void setCard_name(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCurrency() {
        return null;
    }
    
    public final void setCurrency(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAmount() {
        return null;
    }
    
    public final void setAmount(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCreated_at() {
        return null;
    }
    
    public final void setCreated_at(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDomain_name() {
        return null;
    }
    
    public final void setDomain_name(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStatus() {
        return null;
    }
    
    public final void setStatus(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getWorkingStage() {
        return null;
    }
    
    public final void setWorkingStage(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
}