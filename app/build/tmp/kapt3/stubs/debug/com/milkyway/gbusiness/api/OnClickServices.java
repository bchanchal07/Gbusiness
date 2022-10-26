package com.milkyway.gbusiness.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/milkyway/gbusiness/api/OnClickServices;", "", "editSites", "", "webUrl", "", "nowPublishWebSite", "templateID", "domainId", "nowUnPublishWebSite", "projectId", "onClick", "id", "name", "onClickDownload", "onClickPublish", "onClickTrash", "app_debug"})
public abstract interface OnClickServices {
    
    public abstract void onClick(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String name);
    
    public abstract void onClickDownload(@org.jetbrains.annotations.NotNull()
    java.lang.String webUrl);
    
    public abstract void onClickTrash(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String name);
    
    public abstract void onClickPublish(@org.jetbrains.annotations.NotNull()
    java.lang.String templateID, @org.jetbrains.annotations.NotNull()
    java.lang.String name);
    
    public abstract void nowPublishWebSite(@org.jetbrains.annotations.NotNull()
    java.lang.String templateID, @org.jetbrains.annotations.NotNull()
    java.lang.String domainId);
    
    public abstract void nowUnPublishWebSite(@org.jetbrains.annotations.NotNull()
    java.lang.String projectId);
    
    public abstract void editSites(@org.jetbrains.annotations.NotNull()
    java.lang.String webUrl);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
        
        public static void onClickDownload(@org.jetbrains.annotations.NotNull()
        com.milkyway.gbusiness.api.OnClickServices $this, @org.jetbrains.annotations.NotNull()
        java.lang.String webUrl) {
        }
        
        public static void onClickTrash(@org.jetbrains.annotations.NotNull()
        com.milkyway.gbusiness.api.OnClickServices $this, @org.jetbrains.annotations.NotNull()
        java.lang.String id, @org.jetbrains.annotations.NotNull()
        java.lang.String name) {
        }
        
        public static void onClickPublish(@org.jetbrains.annotations.NotNull()
        com.milkyway.gbusiness.api.OnClickServices $this, @org.jetbrains.annotations.NotNull()
        java.lang.String templateID, @org.jetbrains.annotations.NotNull()
        java.lang.String name) {
        }
        
        public static void nowPublishWebSite(@org.jetbrains.annotations.NotNull()
        com.milkyway.gbusiness.api.OnClickServices $this, @org.jetbrains.annotations.NotNull()
        java.lang.String templateID, @org.jetbrains.annotations.NotNull()
        java.lang.String domainId) {
        }
        
        public static void nowUnPublishWebSite(@org.jetbrains.annotations.NotNull()
        com.milkyway.gbusiness.api.OnClickServices $this, @org.jetbrains.annotations.NotNull()
        java.lang.String projectId) {
        }
        
        public static void editSites(@org.jetbrains.annotations.NotNull()
        com.milkyway.gbusiness.api.OnClickServices $this, @org.jetbrains.annotations.NotNull()
        java.lang.String webUrl) {
        }
    }
}