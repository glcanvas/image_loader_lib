package com.imageloader.nikita.image_loader;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u00014B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\'\u001a\u00020(H\u0004J\b\u0010)\u001a\u00020(H\u0004J\b\u0010*\u001a\u00020(H\u0016J\b\u0010+\u001a\u00020(H\u0016J\u0010\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020.H\u0016J\u0012\u0010/\u001a\u00020(2\b\u00100\u001a\u0004\u0018\u00010.H\u0004J\u0012\u00101\u001a\u00020(*\u00020\u001a2\u0006\u00102\u001a\u000203R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0084.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0084.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lcom/imageloader/nikita/image_loader/CommonViewFragment;", "Landroid/support/v4/app/Fragment;", "()V", "currentActivity", "Lcom/imageloader/nikita/image_loader/MainActivity;", "currentDimension", "", "currentPage", "", "getCurrentPage", "()I", "setCurrentPage", "(I)V", "listAdapter", "Lcom/imageloader/nikita/image_loader/Adapters/AllImageListAdapter;", "getListAdapter", "()Lcom/imageloader/nikita/image_loader/Adapters/AllImageListAdapter;", "setListAdapter", "(Lcom/imageloader/nikita/image_loader/Adapters/AllImageListAdapter;)V", "listOfPreview", "Ljava/util/ArrayList;", "Lcom/imageloader/nikita/image_loader/utils/PreviewImageModel;", "Lkotlin/collections/ArrayList;", "getListOfPreview", "()Ljava/util/ArrayList;", "listView", "Landroid/support/v7/widget/RecyclerView;", "getListView", "()Landroid/support/v7/widget/RecyclerView;", "setListView", "(Landroid/support/v7/widget/RecyclerView;)V", "setOfAsyncTasks", "Ljava/util/HashSet;", "Lcom/imageloader/nikita/image_loader/utils/AsyncLoadPreviewList;", "Lkotlin/collections/HashSet;", "getSetOfAsyncTasks", "()Ljava/util/HashSet;", "touchCallback", "Landroid/support/v7/widget/helper/ItemTouchHelper$SimpleCallback;", "addReplaceFragment", "", "addSwipeCallback", "asyncLoadList", "onDestroy", "onSaveInstanceState", "outState", "Landroid/os/Bundle;", "saveState", "savedInstanceState", "addOnItemClickListener", "onClickListener", "Lcom/imageloader/nikita/image_loader/CommonViewFragment$OnItemClickListener;", "OnItemClickListener", "app_debug"})
public class CommonViewFragment extends android.support.v4.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    protected android.support.v7.widget.RecyclerView listView;
    @org.jetbrains.annotations.NotNull()
    protected com.imageloader.nikita.image_loader.Adapters.AllImageListAdapter listAdapter;
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.imageloader.nikita.image_loader.utils.PreviewImageModel> listOfPreview = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.HashSet<com.imageloader.nikita.image_loader.utils.AsyncLoadPreviewList> setOfAsyncTasks = null;
    private int currentPage;
    private android.support.v7.widget.helper.ItemTouchHelper.SimpleCallback touchCallback;
    private com.imageloader.nikita.image_loader.MainActivity currentActivity;
    private java.lang.String currentDimension;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    protected final android.support.v7.widget.RecyclerView getListView() {
        return null;
    }
    
    protected final void setListView(@org.jetbrains.annotations.NotNull()
    android.support.v7.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final com.imageloader.nikita.image_loader.Adapters.AllImageListAdapter getListAdapter() {
        return null;
    }
    
    protected final void setListAdapter(@org.jetbrains.annotations.NotNull()
    com.imageloader.nikita.image_loader.Adapters.AllImageListAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final java.util.ArrayList<com.imageloader.nikita.image_loader.utils.PreviewImageModel> getListOfPreview() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final java.util.HashSet<com.imageloader.nikita.image_loader.utils.AsyncLoadPreviewList> getSetOfAsyncTasks() {
        return null;
    }
    
    protected final int getCurrentPage() {
        return 0;
    }
    
    protected final void setCurrentPage(int p0) {
    }
    
    public void asyncLoadList() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @java.lang.Override()
    public void onSaveInstanceState(@org.jetbrains.annotations.NotNull()
    android.os.Bundle outState) {
    }
    
    protected final void saveState(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    protected final void addSwipeCallback() {
    }
    
    protected final void addReplaceFragment() {
    }
    
    public final void addOnItemClickListener(@org.jetbrains.annotations.NotNull()
    android.support.v7.widget.RecyclerView $receiver, @org.jetbrains.annotations.NotNull()
    com.imageloader.nikita.image_loader.CommonViewFragment.OnItemClickListener onClickListener) {
    }
    
    public CommonViewFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/imageloader/nikita/image_loader/CommonViewFragment$OnItemClickListener;", "", "onItemClicked", "", "position", "", "view", "Landroid/view/View;", "app_debug"})
    public static abstract interface OnItemClickListener {
        
        public abstract void onItemClicked(int position, @org.jetbrains.annotations.NotNull()
        android.view.View view);
    }
}