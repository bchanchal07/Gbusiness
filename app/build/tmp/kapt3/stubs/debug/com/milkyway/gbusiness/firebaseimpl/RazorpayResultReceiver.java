package com.milkyway.gbusiness.firebaseimpl;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0010B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/milkyway/gbusiness/firebaseimpl/RazorpayResultReceiver;", "Landroid/os/ResultReceiver;", "handler", "Landroid/os/Handler;", "appReceiver", "Lcom/milkyway/gbusiness/firebaseimpl/RazorpayResultReceiver$AppReceiver;", "(Landroid/os/Handler;Lcom/milkyway/gbusiness/firebaseimpl/RazorpayResultReceiver$AppReceiver;)V", "mReceiver", "onReceiveResult", "", "resultCode", "", "resultData", "Landroid/os/Bundle;", "setAppReceiver", "receiver", "AppReceiver", "app_debug"})
public final class RazorpayResultReceiver extends android.os.ResultReceiver {
    private final com.milkyway.gbusiness.firebaseimpl.RazorpayResultReceiver.AppReceiver appReceiver = null;
    private com.milkyway.gbusiness.firebaseimpl.RazorpayResultReceiver.AppReceiver mReceiver;
    
    public RazorpayResultReceiver(@org.jetbrains.annotations.Nullable()
    android.os.Handler handler, @org.jetbrains.annotations.Nullable()
    com.milkyway.gbusiness.firebaseimpl.RazorpayResultReceiver.AppReceiver appReceiver) {
        super(null);
    }
    
    @java.lang.Override()
    public void onReceiveResult(int resultCode, @org.jetbrains.annotations.NotNull()
    android.os.Bundle resultData) {
    }
    
    public final void setAppReceiver(@org.jetbrains.annotations.Nullable()
    com.milkyway.gbusiness.firebaseimpl.RazorpayResultReceiver.AppReceiver receiver) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/milkyway/gbusiness/firebaseimpl/RazorpayResultReceiver$AppReceiver;", "", "onReceiveResult", "", "resultCode", "", "resultData", "Landroid/os/Bundle;", "app_debug"})
    public static abstract interface AppReceiver {
        
        public abstract void onReceiveResult(int resultCode, @org.jetbrains.annotations.Nullable()
        android.os.Bundle resultData);
    }
}