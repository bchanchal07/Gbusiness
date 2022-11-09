package com.milkyway.gbusiness.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0019B%\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\bH\u00c6\u0003J-\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0006H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/milkyway/gbusiness/models/BusinessListingResponse;", "", "data", "", "Lcom/milkyway/gbusiness/models/BusinessListingResponse$Data;", "message", "", "success", "", "(Ljava/util/List;Ljava/lang/String;Z)V", "getData", "()Ljava/util/List;", "getMessage", "()Ljava/lang/String;", "getSuccess", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "Data", "app_debug"})
public final class BusinessListingResponse {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.milkyway.gbusiness.models.BusinessListingResponse.Data> data = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String message = null;
    private final boolean success = false;
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.models.BusinessListingResponse copy(@org.jetbrains.annotations.NotNull()
    java.util.List<com.milkyway.gbusiness.models.BusinessListingResponse.Data> data, @org.jetbrains.annotations.NotNull()
    java.lang.String message, boolean success) {
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
    
    public BusinessListingResponse(@org.jetbrains.annotations.NotNull()
    java.util.List<com.milkyway.gbusiness.models.BusinessListingResponse.Data> data, @org.jetbrains.annotations.NotNull()
    java.lang.String message, boolean success) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.milkyway.gbusiness.models.BusinessListingResponse.Data> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.milkyway.gbusiness.models.BusinessListingResponse.Data> getData() {
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
    
    public final boolean component3() {
        return false;
    }
    
    public final boolean getSuccess() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0003\b\u008e\u0001\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u00a1\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010:\u001a\u00020\u0017\u00a2\u0006\u0002\u0010;J\t\u0010u\u001a\u00020\u0003H\u00c6\u0003J\t\u0010v\u001a\u00020\nH\u00c6\u0003J\t\u0010w\u001a\u00020\nH\u00c6\u0003J\t\u0010x\u001a\u00020\nH\u00c6\u0003J\t\u0010y\u001a\u00020\u0003H\u00c6\u0003J\t\u0010z\u001a\u00020\u0003H\u00c6\u0003J\t\u0010{\u001a\u00020\nH\u00c6\u0003J\t\u0010|\u001a\u00020\u0003H\u00c6\u0003J\t\u0010}\u001a\u00020\u0003H\u00c6\u0003J\t\u0010~\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u007f\u001a\u00020\u0017H\u00c6\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0017H\u00c6\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0003H\u00c6\u0003J\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u001dH\u00c6\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u001dH\u00c6\u0003J\f\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0003H\u00c6\u0003J\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u001dH\u00c6\u0003J\f\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u001dH\u00c6\u0003J\f\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u001dH\u00c6\u0003J\f\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u001dH\u00c6\u0003J\f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u001dH\u00c6\u0003J\f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u001dH\u00c6\u0003J\f\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u001dH\u00c6\u0003J\f\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u001dH\u00c6\u0003J\n\u0010\u0096\u0001\u001a\u00020\u0003H\u00c6\u0003J\f\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u001dH\u00c6\u0003J\f\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u001dH\u00c6\u0003J\f\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u001dH\u00c6\u0003J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u001dH\u00c6\u0003J\f\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u001dH\u00c6\u0003J\f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u001dH\u00c6\u0003J\f\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u001dH\u00c6\u0003J\f\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u001dH\u00c6\u0003J\f\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u001dH\u00c6\u0003J\f\u0010\u00a0\u0001\u001a\u0004\u0018\u00010\u001dH\u00c6\u0003J\n\u0010\u00a1\u0001\u001a\u00020\u0003H\u00c6\u0003J\f\u0010\u00a2\u0001\u001a\u0004\u0018\u00010\u001dH\u00c6\u0003J\f\u0010\u00a3\u0001\u001a\u0004\u0018\u00010\u001dH\u00c6\u0003J\f\u0010\u00a4\u0001\u001a\u0004\u0018\u00010\u001dH\u00c6\u0003J\n\u0010\u00a5\u0001\u001a\u00020\u0017H\u00c6\u0003J\n\u0010\u00a6\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00a7\u0001\u001a\u00020\nH\u00c6\u0003J\n\u0010\u00a8\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u00a9\u0001\u001a\u00020\u0003H\u00c6\u0003J\u00d6\u0004\u0010\u00aa\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010:\u001a\u00020\u0017H\u00c6\u0001J\u0016\u0010\u00ab\u0001\u001a\u00030\u00ac\u00012\t\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u001dH\u00d6\u0003J\n\u0010\u00ae\u0001\u001a\u00020\nH\u00d6\u0001J\n\u0010\u00af\u0001\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u001b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010=R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u0010=R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010=R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010=R\u0011\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010=R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u0010DR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010=R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u0010=R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u0010=R\u0011\u0010\u0019\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bK\u0010=R\u0011\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u0010=R\u0013\u0010$\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bO\u0010=R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bP\u0010=R\u0013\u00104\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bQ\u0010DR\u0013\u00106\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bR\u0010DR\u0013\u00105\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bS\u0010DR\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\bT\u0010IR\u0013\u0010!\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bU\u0010=R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bV\u0010=R\u0013\u0010(\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bW\u0010DR\u0013\u0010*\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bX\u0010DR\u0013\u0010)\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bY\u0010DR\u0013\u00107\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bZ\u0010DR\u0013\u00109\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b[\u0010DR\u0013\u00108\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b\\\u0010DR\u0013\u0010#\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b]\u0010=R\u0011\u0010:\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b^\u0010MR\u0011\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b_\u0010MR\u0011\u0010\u000e\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b`\u0010IR\u0011\u0010\u000f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\ba\u0010IR\u0011\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bb\u0010=R\u0011\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bc\u0010=R\u0013\u0010%\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bd\u0010DR\u0013\u0010\'\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\be\u0010DR\u0013\u0010&\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bf\u0010DR\u0013\u00101\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bg\u0010DR\u0013\u00103\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bh\u0010DR\u0013\u00102\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bi\u0010DR\u0013\u0010+\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bj\u0010DR\u0013\u0010-\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bk\u0010DR\u0013\u0010,\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bl\u0010DR\u0013\u0010 \u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bm\u0010=R\u0011\u0010\u0011\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bn\u0010=R\u0011\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bo\u0010=R\u0011\u0010\u0012\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\bp\u0010IR\u0013\u0010.\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bq\u0010DR\u0013\u00100\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\br\u0010DR\u0013\u0010/\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\bs\u0010DR\u0011\u0010\u001a\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bt\u0010=\u00a8\u0006\u00b0\u0001"}, d2 = {"Lcom/milkyway/gbusiness/models/BusinessListingResponse$Data;", "Ljava/io/Serializable;", "business_about_us", "", "business_email", "business_logo", "business_name", "business_type", "business_web_url", "category_id", "", "catname", "created_at", "id", "status", "sub_category_id", "subcatname", "updated_at", "user_id", "sub_domain", "url_slug", "business_phone", "country_id", "", "state_id", "city", "zip_code", "address", "business_services", "", "business_services_other", "facebook_url", "twitter_url", "instagram_url", "linkedin_url", "seller_url", "establish_date", "sunday", "sunday_start_time", "sunday_end_time", "monday", "monday_start_time", "monday_end_time", "tuesday", "tuesday_start_time", "tuesday_end_time", "wednesday", "wednesday_start_time", "wednesday_end_time", "thirsday", "thirsday_start_time", "thirsday_end_time", "friday", "friday_start_time", "friday_end_time", "saturday", "saturday_start_time", "saturday_end_time", "sponsor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;J)V", "getAddress", "()Ljava/lang/String;", "getBusiness_about_us", "getBusiness_email", "getBusiness_logo", "getBusiness_name", "getBusiness_phone", "getBusiness_services", "()Ljava/lang/Object;", "getBusiness_services_other", "getBusiness_type", "getBusiness_web_url", "getCategory_id", "()I", "getCatname", "getCity", "getCountry_id", "()J", "getCreated_at", "getEstablish_date", "getFacebook_url", "getFriday", "getFriday_end_time", "getFriday_start_time", "getId", "getInstagram_url", "getLinkedin_url", "getMonday", "getMonday_end_time", "getMonday_start_time", "getSaturday", "getSaturday_end_time", "getSaturday_start_time", "getSeller_url", "getSponsor", "getState_id", "getStatus", "getSub_category_id", "getSub_domain", "getSubcatname", "getSunday", "getSunday_end_time", "getSunday_start_time", "getThirsday", "getThirsday_end_time", "getThirsday_start_time", "getTuesday", "getTuesday_end_time", "getTuesday_start_time", "getTwitter_url", "getUpdated_at", "getUrl_slug", "getUser_id", "getWednesday", "getWednesday_end_time", "getWednesday_start_time", "getZip_code", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component5", "component50", "component51", "component52", "component53", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
    public static final class Data implements java.io.Serializable {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String business_about_us = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String business_email = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String business_logo = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String business_name = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String business_type = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String business_web_url = null;
        private final int category_id = 0;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String catname = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String created_at = null;
        private final int id = 0;
        private final int status = 0;
        private final int sub_category_id = 0;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String subcatname = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String updated_at = null;
        private final int user_id = 0;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String sub_domain = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String url_slug = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String business_phone = null;
        private final long country_id = 0L;
        private final long state_id = 0L;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String city = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String zip_code = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String address = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Object business_services = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Object business_services_other = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String facebook_url = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String twitter_url = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String instagram_url = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String linkedin_url = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String seller_url = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String establish_date = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Object sunday = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Object sunday_start_time = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Object sunday_end_time = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Object monday = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Object monday_start_time = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Object monday_end_time = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Object tuesday = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Object tuesday_start_time = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Object tuesday_end_time = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Object wednesday = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Object wednesday_start_time = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Object wednesday_end_time = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Object thirsday = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Object thirsday_start_time = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Object thirsday_end_time = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Object friday = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Object friday_start_time = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Object friday_end_time = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Object saturday = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Object saturday_start_time = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.Object saturday_end_time = null;
        private final long sponsor = 0L;
        
        @org.jetbrains.annotations.NotNull()
        public final com.milkyway.gbusiness.models.BusinessListingResponse.Data copy(@org.jetbrains.annotations.NotNull()
        java.lang.String business_about_us, @org.jetbrains.annotations.NotNull()
        java.lang.String business_email, @org.jetbrains.annotations.NotNull()
        java.lang.String business_logo, @org.jetbrains.annotations.NotNull()
        java.lang.String business_name, @org.jetbrains.annotations.NotNull()
        java.lang.String business_type, @org.jetbrains.annotations.NotNull()
        java.lang.String business_web_url, int category_id, @org.jetbrains.annotations.NotNull()
        java.lang.String catname, @org.jetbrains.annotations.NotNull()
        java.lang.String created_at, int id, int status, int sub_category_id, @org.jetbrains.annotations.NotNull()
        java.lang.String subcatname, @org.jetbrains.annotations.NotNull()
        java.lang.String updated_at, int user_id, @org.jetbrains.annotations.NotNull()
        java.lang.String sub_domain, @org.jetbrains.annotations.NotNull()
        java.lang.String url_slug, @org.jetbrains.annotations.NotNull()
        java.lang.String business_phone, long country_id, long state_id, @org.jetbrains.annotations.NotNull()
        java.lang.String city, @org.jetbrains.annotations.NotNull()
        java.lang.String zip_code, @org.jetbrains.annotations.NotNull()
        java.lang.String address, @org.jetbrains.annotations.Nullable()
        java.lang.Object business_services, @org.jetbrains.annotations.Nullable()
        java.lang.Object business_services_other, @org.jetbrains.annotations.Nullable()
        java.lang.String facebook_url, @org.jetbrains.annotations.Nullable()
        java.lang.String twitter_url, @org.jetbrains.annotations.Nullable()
        java.lang.String instagram_url, @org.jetbrains.annotations.Nullable()
        java.lang.String linkedin_url, @org.jetbrains.annotations.Nullable()
        java.lang.String seller_url, @org.jetbrains.annotations.Nullable()
        java.lang.String establish_date, @org.jetbrains.annotations.Nullable()
        java.lang.Object sunday, @org.jetbrains.annotations.Nullable()
        java.lang.Object sunday_start_time, @org.jetbrains.annotations.Nullable()
        java.lang.Object sunday_end_time, @org.jetbrains.annotations.Nullable()
        java.lang.Object monday, @org.jetbrains.annotations.Nullable()
        java.lang.Object monday_start_time, @org.jetbrains.annotations.Nullable()
        java.lang.Object monday_end_time, @org.jetbrains.annotations.Nullable()
        java.lang.Object tuesday, @org.jetbrains.annotations.Nullable()
        java.lang.Object tuesday_start_time, @org.jetbrains.annotations.Nullable()
        java.lang.Object tuesday_end_time, @org.jetbrains.annotations.Nullable()
        java.lang.Object wednesday, @org.jetbrains.annotations.Nullable()
        java.lang.Object wednesday_start_time, @org.jetbrains.annotations.Nullable()
        java.lang.Object wednesday_end_time, @org.jetbrains.annotations.Nullable()
        java.lang.Object thirsday, @org.jetbrains.annotations.Nullable()
        java.lang.Object thirsday_start_time, @org.jetbrains.annotations.Nullable()
        java.lang.Object thirsday_end_time, @org.jetbrains.annotations.Nullable()
        java.lang.Object friday, @org.jetbrains.annotations.Nullable()
        java.lang.Object friday_start_time, @org.jetbrains.annotations.Nullable()
        java.lang.Object friday_end_time, @org.jetbrains.annotations.Nullable()
        java.lang.Object saturday, @org.jetbrains.annotations.Nullable()
        java.lang.Object saturday_start_time, @org.jetbrains.annotations.Nullable()
        java.lang.Object saturday_end_time, long sponsor) {
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
        
        public Data(@org.jetbrains.annotations.NotNull()
        java.lang.String business_about_us, @org.jetbrains.annotations.NotNull()
        java.lang.String business_email, @org.jetbrains.annotations.NotNull()
        java.lang.String business_logo, @org.jetbrains.annotations.NotNull()
        java.lang.String business_name, @org.jetbrains.annotations.NotNull()
        java.lang.String business_type, @org.jetbrains.annotations.NotNull()
        java.lang.String business_web_url, int category_id, @org.jetbrains.annotations.NotNull()
        java.lang.String catname, @org.jetbrains.annotations.NotNull()
        java.lang.String created_at, int id, int status, int sub_category_id, @org.jetbrains.annotations.NotNull()
        java.lang.String subcatname, @org.jetbrains.annotations.NotNull()
        java.lang.String updated_at, int user_id, @org.jetbrains.annotations.NotNull()
        java.lang.String sub_domain, @org.jetbrains.annotations.NotNull()
        java.lang.String url_slug, @org.jetbrains.annotations.NotNull()
        java.lang.String business_phone, long country_id, long state_id, @org.jetbrains.annotations.NotNull()
        java.lang.String city, @org.jetbrains.annotations.NotNull()
        java.lang.String zip_code, @org.jetbrains.annotations.NotNull()
        java.lang.String address, @org.jetbrains.annotations.Nullable()
        java.lang.Object business_services, @org.jetbrains.annotations.Nullable()
        java.lang.Object business_services_other, @org.jetbrains.annotations.Nullable()
        java.lang.String facebook_url, @org.jetbrains.annotations.Nullable()
        java.lang.String twitter_url, @org.jetbrains.annotations.Nullable()
        java.lang.String instagram_url, @org.jetbrains.annotations.Nullable()
        java.lang.String linkedin_url, @org.jetbrains.annotations.Nullable()
        java.lang.String seller_url, @org.jetbrains.annotations.Nullable()
        java.lang.String establish_date, @org.jetbrains.annotations.Nullable()
        java.lang.Object sunday, @org.jetbrains.annotations.Nullable()
        java.lang.Object sunday_start_time, @org.jetbrains.annotations.Nullable()
        java.lang.Object sunday_end_time, @org.jetbrains.annotations.Nullable()
        java.lang.Object monday, @org.jetbrains.annotations.Nullable()
        java.lang.Object monday_start_time, @org.jetbrains.annotations.Nullable()
        java.lang.Object monday_end_time, @org.jetbrains.annotations.Nullable()
        java.lang.Object tuesday, @org.jetbrains.annotations.Nullable()
        java.lang.Object tuesday_start_time, @org.jetbrains.annotations.Nullable()
        java.lang.Object tuesday_end_time, @org.jetbrains.annotations.Nullable()
        java.lang.Object wednesday, @org.jetbrains.annotations.Nullable()
        java.lang.Object wednesday_start_time, @org.jetbrains.annotations.Nullable()
        java.lang.Object wednesday_end_time, @org.jetbrains.annotations.Nullable()
        java.lang.Object thirsday, @org.jetbrains.annotations.Nullable()
        java.lang.Object thirsday_start_time, @org.jetbrains.annotations.Nullable()
        java.lang.Object thirsday_end_time, @org.jetbrains.annotations.Nullable()
        java.lang.Object friday, @org.jetbrains.annotations.Nullable()
        java.lang.Object friday_start_time, @org.jetbrains.annotations.Nullable()
        java.lang.Object friday_end_time, @org.jetbrains.annotations.Nullable()
        java.lang.Object saturday, @org.jetbrains.annotations.Nullable()
        java.lang.Object saturday_start_time, @org.jetbrains.annotations.Nullable()
        java.lang.Object saturday_end_time, long sponsor) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getBusiness_about_us() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getBusiness_email() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getBusiness_logo() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getBusiness_name() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getBusiness_type() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component6() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getBusiness_web_url() {
            return null;
        }
        
        public final int component7() {
            return 0;
        }
        
        public final int getCategory_id() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component8() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCatname() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component9() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCreated_at() {
            return null;
        }
        
        public final int component10() {
            return 0;
        }
        
        public final int getId() {
            return 0;
        }
        
        public final int component11() {
            return 0;
        }
        
        public final int getStatus() {
            return 0;
        }
        
        public final int component12() {
            return 0;
        }
        
        public final int getSub_category_id() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component13() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getSubcatname() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component14() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getUpdated_at() {
            return null;
        }
        
        public final int component15() {
            return 0;
        }
        
        public final int getUser_id() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component16() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getSub_domain() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component17() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getUrl_slug() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component18() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getBusiness_phone() {
            return null;
        }
        
        public final long component19() {
            return 0L;
        }
        
        public final long getCountry_id() {
            return 0L;
        }
        
        public final long component20() {
            return 0L;
        }
        
        public final long getState_id() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component21() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCity() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component22() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getZip_code() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component23() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAddress() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object component24() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getBusiness_services() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object component25() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getBusiness_services_other() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component26() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getFacebook_url() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component27() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getTwitter_url() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component28() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getInstagram_url() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component29() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getLinkedin_url() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component30() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getSeller_url() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component31() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getEstablish_date() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object component32() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getSunday() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object component33() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getSunday_start_time() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object component34() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getSunday_end_time() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object component35() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getMonday() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object component36() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getMonday_start_time() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object component37() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getMonday_end_time() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object component38() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getTuesday() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object component39() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getTuesday_start_time() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object component40() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getTuesday_end_time() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object component41() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getWednesday() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object component42() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getWednesday_start_time() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object component43() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getWednesday_end_time() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object component44() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getThirsday() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object component45() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getThirsday_start_time() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object component46() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getThirsday_end_time() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object component47() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getFriday() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object component48() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getFriday_start_time() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object component49() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getFriday_end_time() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object component50() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getSaturday() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object component51() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getSaturday_start_time() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object component52() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getSaturday_end_time() {
            return null;
        }
        
        public final long component53() {
            return 0L;
        }
        
        public final long getSponsor() {
            return 0L;
        }
    }
}