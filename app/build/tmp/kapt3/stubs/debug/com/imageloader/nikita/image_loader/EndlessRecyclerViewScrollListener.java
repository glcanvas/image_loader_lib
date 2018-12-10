package com.imageloader.nikita.image_loader;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eJ \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H&J \u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/imageloader/nikita/image_loader/EndlessRecyclerViewScrollListener;", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "layout", "Landroid/support/v7/widget/LinearLayoutManager;", "(Landroid/support/v7/widget/LinearLayoutManager;)V", "currentPage", "", "loading", "", "previousTotalItemCount", "startingPageIndex", "visibleThreshold", "getLastVisibleItem", "lastVisibleItemPositions", "", "onLoadMore", "", "page", "totalItemsCount", "view", "Landroid/support/v7/widget/RecyclerView;", "onScrolled", "dx", "dy", "app_debug"})
public abstract class EndlessRecyclerViewScrollListener extends android.support.v7.widget.RecyclerView.OnScrollListener {
    private int visibleThreshold;
    private int currentPage;
    private int previousTotalItemCount;
    private boolean loading;
    private final int startingPageIndex = 0;
    private final android.support.v7.widget.LinearLayoutManager layout = null;
    
    public final int getLastVisibleItem(@org.jetbrains.annotations.NotNull()
    int[] lastVisibleItemPositions) {
        return 0;
    }
    
    @java.lang.Override()
    public void onScrolled(@org.jetbrains.annotations.NotNull()
    android.support.v7.widget.RecyclerView view, int dx, int dy) {
    }
    
    public abstract void onLoadMore(int page, int totalItemsCount, @org.jetbrains.annotations.NotNull()
    android.support.v7.widget.RecyclerView view);
    
    public EndlessRecyclerViewScrollListener(@org.jetbrains.annotations.Nullable()
    android.support.v7.widget.LinearLayoutManager layout) {
        super();
    }
}