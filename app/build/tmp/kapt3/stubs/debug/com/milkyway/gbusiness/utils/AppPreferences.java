package com.milkyway.gbusiness.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ!\u0010\u001f\u001a\u00020\u001c*\u00020\u00172\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001c0!H\u0082\bR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R$\u0010\u0018\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015\u00a8\u0006#"}, d2 = {"Lcom/milkyway/gbusiness/utils/AppPreferences;", "", "()V", "IS_LOGIN", "Lkotlin/Pair;", "", "", "PASSWORD", "PREF_MODE", "", "PREF_NAME", "USERNAME", "value", "isLogin", "()Z", "setLogin", "(Z)V", "password", "getPassword", "()Ljava/lang/String;", "setPassword", "(Ljava/lang/String;)V", "preferences", "Landroid/content/SharedPreferences;", "username", "getUsername", "setUsername", "init", "", "context", "Landroid/content/Context;", "edit", "operation", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "app_debug"})
public final class AppPreferences {
    @org.jetbrains.annotations.NotNull()
    public static final com.milkyway.gbusiness.utils.AppPreferences INSTANCE = null;
    private static final java.lang.String PREF_NAME = "AComputerEngineer";
    private static final int PREF_MODE = android.content.Context.MODE_PRIVATE;
    private static android.content.SharedPreferences preferences;
    private static final kotlin.Pair<java.lang.String, java.lang.Boolean> IS_LOGIN = null;
    private static final kotlin.Pair<java.lang.String, java.lang.String> USERNAME = null;
    private static final kotlin.Pair<java.lang.String, java.lang.String> PASSWORD = null;
    
    private AppPreferences() {
        super();
    }
    
    public final void init(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    private final void edit(android.content.SharedPreferences $this$edit, kotlin.jvm.functions.Function1<? super android.content.SharedPreferences.Editor, kotlin.Unit> operation) {
    }
    
    public final boolean isLogin() {
        return false;
    }
    
    public final void setLogin(boolean value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUsername() {
        return null;
    }
    
    public final void setUsername(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPassword() {
        return null;
    }
    
    public final void setPassword(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
}