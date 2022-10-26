package com.milkyway.gbusiness.fragments;

import java.lang.System;

/**
 * A simple [Fragment] subclass.
 * Use the [BusinessListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001CB\u0005\u00a2\u0006\u0002\u0010\u0003J\u0016\u0010\u001f\u001a\u00020 2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\b\u0010!\u001a\u00020 H\u0002J\u0010\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0010H\u0002J\u0010\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010\'\u001a\u00020 2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020 2\u0006\u0010%\u001a\u00020&H\u0002J\"\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0010\u00101\u001a\u00020 2\u0006\u00102\u001a\u00020\u0012H\u0016J\u0018\u00103\u001a\u00020 2\u0006\u00104\u001a\u00020-2\u0006\u0010#\u001a\u00020\u0010H\u0016J&\u00105\u001a\u0004\u0018\u00010&2\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010=\u001a\u00020)H\u0002J\u001a\u0010>\u001a\u00020 2\u0006\u0010%\u001a\u00020&2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u0016\u0010?\u001a\u00020 2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u0010\u0010@\u001a\u00020 2\u0006\u0010(\u001a\u00020)H\u0002J\u0016\u0010A\u001a\u00020 2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006D"}, d2 = {"Lcom/milkyway/gbusiness/fragments/BusinessListFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/milkyway/gbusiness/adaptor/BusinessUserAddListAdapter$BtnClickListener;", "()V", "btnAddNewList", "Landroidx/appcompat/widget/AppCompatButton;", "businessListAdapter", "Lcom/milkyway/gbusiness/adaptor/BusinessListAdaptor;", "clearQueryImageView", "Landroid/widget/ImageView;", "etSearch", "Landroidx/appcompat/widget/AppCompatEditText;", "expendableList", "Landroid/widget/ExpandableListView;", "listingDataList", "", "Lcom/milkyway/gbusiness/models/BusinessListingResponse$Data;", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "myBusinessListBack", "noSearchResultsFoundText", "Landroid/widget/TextView;", "rvBusinessList", "Landroidx/recyclerview/widget/RecyclerView;", "scrollView", "Landroid/widget/ScrollView;", "voiceSearchImageView", "bindExpandableListAdapter", "", "callBusinessListingApi", "callDeleteBusinessListItemApi", "list", "clickListener", "view", "Landroid/view/View;", "filterWithQuery", "query", "", "initializeView", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "onBtnClick", "position", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onFilterChanged", "filterQuery", "onViewCreated", "setListingDataAdapter", "toggleImageView", "toggleRecyclerView", "catList", "Companion", "app_debug"})
public final class BusinessListFragment extends androidx.fragment.app.Fragment implements com.milkyway.gbusiness.adaptor.BusinessUserAddListAdapter.BtnClickListener {
    public android.content.Context mContext;
    private androidx.recyclerview.widget.RecyclerView rvBusinessList;
    private android.widget.ImageView myBusinessListBack;
    private androidx.appcompat.widget.AppCompatButton btnAddNewList;
    private java.util.List<com.milkyway.gbusiness.models.BusinessListingResponse.Data> listingDataList;
    private com.milkyway.gbusiness.adaptor.BusinessListAdaptor businessListAdapter;
    private androidx.appcompat.widget.AppCompatEditText etSearch;
    private android.widget.TextView noSearchResultsFoundText;
    private android.widget.ImageView clearQueryImageView;
    private android.widget.ImageView voiceSearchImageView;
    private android.widget.ScrollView scrollView;
    private android.widget.ExpandableListView expendableList;
    @org.jetbrains.annotations.NotNull()
    public static final com.milkyway.gbusiness.fragments.BusinessListFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    public BusinessListFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final com.milkyway.gbusiness.fragments.BusinessListFragment newInstance() {
        return null;
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
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void clickListener(android.view.View view) {
    }
    
    private final void initializeView(android.view.View view) {
    }
    
    private final void callBusinessListingApi() {
    }
    
    private final void setListingDataAdapter(java.util.List<com.milkyway.gbusiness.models.BusinessListingResponse.Data> listingDataList) {
    }
    
    private final void bindExpandableListAdapter(java.util.List<com.milkyway.gbusiness.models.BusinessListingResponse.Data> listingDataList) {
    }
    
    @java.lang.Override()
    public void onBtnClick(int position, @org.jetbrains.annotations.NotNull()
    com.milkyway.gbusiness.models.BusinessListingResponse.Data list) {
    }
    
    private final void callDeleteBusinessListItemApi(com.milkyway.gbusiness.models.BusinessListingResponse.Data list) {
    }
    
    private final void filterWithQuery(java.lang.String query) {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void toggleRecyclerView(java.util.List<com.milkyway.gbusiness.models.BusinessListingResponse.Data> catList) {
    }
    
    private final void toggleImageView(java.lang.String query) {
    }
    
    private final java.util.List<com.milkyway.gbusiness.models.BusinessListingResponse.Data> onFilterChanged(java.lang.String filterQuery) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lcom/milkyway/gbusiness/fragments/BusinessListFragment$Companion;", "", "()V", "newInstance", "Lcom/milkyway/gbusiness/fragments/BusinessListFragment;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final com.milkyway.gbusiness.fragments.BusinessListFragment newInstance() {
            return null;
        }
    }
}