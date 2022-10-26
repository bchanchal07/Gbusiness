package com.milkyway.gbusiness.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/milkyway/gbusiness/api/ProfileConfigrationListener;", "", "creatWebmailListener", "", "domainName", "", "emailAdress", "getSslListener", "app_debug"})
public abstract interface ProfileConfigrationListener {
    
    public abstract void getSslListener(@org.jetbrains.annotations.NotNull()
    java.lang.String domainName);
    
    public abstract void creatWebmailListener(@org.jetbrains.annotations.NotNull()
    java.lang.String domainName, @org.jetbrains.annotations.NotNull()
    java.lang.String emailAdress);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
        
        public static void getSslListener(@org.jetbrains.annotations.NotNull()
        com.milkyway.gbusiness.api.ProfileConfigrationListener $this, @org.jetbrains.annotations.NotNull()
        java.lang.String domainName) {
        }
        
        public static void creatWebmailListener(@org.jetbrains.annotations.NotNull()
        com.milkyway.gbusiness.api.ProfileConfigrationListener $this, @org.jetbrains.annotations.NotNull()
        java.lang.String domainName, @org.jetbrains.annotations.NotNull()
        java.lang.String emailAdress) {
        }
    }
}