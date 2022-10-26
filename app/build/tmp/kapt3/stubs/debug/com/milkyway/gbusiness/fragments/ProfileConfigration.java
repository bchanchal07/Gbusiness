package com.milkyway.gbusiness.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010#\u001a\u00020!H\u0002J\u0018\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020!2\u0006\u0010#\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u0013H\u0016J&\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020\u001fH\u0002J\u000e\u00102\u001a\u00020!2\u0006\u0010 \u001a\u00020!J\u000e\u00103\u001a\u00020!2\u0006\u0010 \u001a\u00020!R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u00064"}, d2 = {"Lcom/milkyway/gbusiness/fragments/ProfileConfigration;", "Landroidx/fragment/app/Fragment;", "Lcom/milkyway/gbusiness/api/ProfileConfigrationListener;", "()V", "arrayListCurnt", "Ljava/util/ArrayList;", "Lcom/milkyway/gbusiness/models/DomainX;", "Lkotlin/collections/ArrayList;", "getArrayListCurnt", "()Ljava/util/ArrayList;", "setArrayListCurnt", "(Ljava/util/ArrayList;)V", "mAdapter", "Lcom/milkyway/gbusiness/adaptor/ProfileConfigrationAdaptor;", "getMAdapter", "()Lcom/milkyway/gbusiness/adaptor/ProfileConfigrationAdaptor;", "setMAdapter", "(Lcom/milkyway/gbusiness/adaptor/ProfileConfigrationAdaptor;)V", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "activsteSSl", "", "domainNAme", "", "creatWebMail", "emailAddress", "creatWebmailListener", "domainName", "getSslListener", "onAttach", "context", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "openDialogBx", "shortDomainName", "shortDomainName2", "app_debug"})
public final class ProfileConfigration extends androidx.fragment.app.Fragment implements com.milkyway.gbusiness.api.ProfileConfigrationListener {
    public java.util.ArrayList<com.milkyway.gbusiness.models.DomainX> arrayListCurnt;
    public androidx.recyclerview.widget.RecyclerView recyclerView;
    public android.content.Context mContext;
    public com.milkyway.gbusiness.adaptor.ProfileConfigrationAdaptor mAdapter;
    private java.util.HashMap _$_findViewCache;
    
    public ProfileConfigration() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.milkyway.gbusiness.models.DomainX> getArrayListCurnt() {
        return null;
    }
    
    public final void setArrayListCurnt(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.milkyway.gbusiness.models.DomainX> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView getRecyclerView() {
        return null;
    }
    
    public final void setRecyclerView(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.milkyway.gbusiness.adaptor.ProfileConfigrationAdaptor getMAdapter() {
        return null;
    }
    
    public final void setMAdapter(@org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.adaptor.ProfileConfigrationAdaptor p0) {
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String shortDomainName(@org.jetbrains.annotations.NotNull()
    java.lang.String domainNAme) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String shortDomainName2(@org.jetbrains.annotations.NotNull()
    java.lang.String domainNAme) {
        return null;
    }
    
    @java.lang.Override()
    public void getSslListener(@org.jetbrains.annotations.NotNull()
    java.lang.String domainNAme) {
    }
    
    @java.lang.Override()
    public void creatWebmailListener(@org.jetbrains.annotations.NotNull()
    java.lang.String domainName, @org.jetbrains.annotations.NotNull()
    java.lang.String emailAddress) {
    }
    
    private final void activsteSSl(java.lang.String domainNAme) {
    }
    
    private final void creatWebMail(java.lang.String domainNAme, java.lang.String emailAddress) {
    }
    
    private final void openDialogBx() {
    }
}