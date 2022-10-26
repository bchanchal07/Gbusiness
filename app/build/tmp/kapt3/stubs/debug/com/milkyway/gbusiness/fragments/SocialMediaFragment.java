package com.milkyway.gbusiness.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J&\u0010\u0019\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0018\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/milkyway/gbusiness/fragments/SocialMediaFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/milkyway/gbusiness/adaptor/SocialMediaAdaptor$SocialMediaAdaptorClick;", "()V", "btnSubmit", "Landroid/widget/Button;", "facebook", "", "instagram", "linkedin", "rvSocialMedia", "Landroidx/recyclerview/widget/RecyclerView;", "socialMediaAdaptor", "Lcom/milkyway/gbusiness/adaptor/SocialMediaAdaptor;", "socialMediaList", "Ljava/util/ArrayList;", "Lcom/milkyway/gbusiness/models/SocialMediaData;", "twitter", "initViews", "", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onSocialItemClicked", "position", "", "list", "Companion", "app_debug"})
public final class SocialMediaFragment extends androidx.fragment.app.Fragment implements com.milkyway.gbusiness.adaptor.SocialMediaAdaptor.SocialMediaAdaptorClick {
    private java.lang.String facebook;
    private java.lang.String linkedin;
    private java.lang.String twitter;
    private java.lang.String instagram;
    private androidx.recyclerview.widget.RecyclerView rvSocialMedia;
    private com.milkyway.gbusiness.adaptor.SocialMediaAdaptor socialMediaAdaptor;
    private java.util.ArrayList<com.milkyway.gbusiness.models.SocialMediaData> socialMediaList;
    private android.widget.Button btnSubmit;
    @org.jetbrains.annotations.NotNull()
    public static final com.milkyway.gbusiness.fragments.SocialMediaFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public SocialMediaFragment() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void initViews(android.view.View view) {
    }
    
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SocialMediaFragment.
     */
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final com.milkyway.gbusiness.fragments.SocialMediaFragment newInstance(@org.jetbrains.annotations.NotNull()
    android.os.Bundle args) {
        return null;
    }
    
    @java.lang.Override()
    public void onSocialItemClicked(int position, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.SocialMediaData list) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/milkyway/gbusiness/fragments/SocialMediaFragment$Companion;", "", "()V", "newInstance", "Lcom/milkyway/gbusiness/fragments/SocialMediaFragment;", "args", "Landroid/os/Bundle;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SocialMediaFragment.
         */
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final com.milkyway.gbusiness.fragments.SocialMediaFragment newInstance(@org.jetbrains.annotations.NotNull()
        android.os.Bundle args) {
            return null;
        }
    }
}