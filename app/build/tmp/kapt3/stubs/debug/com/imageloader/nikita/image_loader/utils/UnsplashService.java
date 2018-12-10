package com.imageloader.nikita.image_loader.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00060\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\'J,\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\bH\'\u00a8\u0006\u000e"}, d2 = {"Lcom/imageloader/nikita/image_loader/utils/UnsplashService;", "", "photos", "Lretrofit2/Call;", "Ljava/util/ArrayList;", "Lcom/imageloader/nikita/image_loader/utils/RetrofitImageList;", "Lkotlin/collections/ArrayList;", "client_id", "", "page", "", "photosByQuery", "Lcom/imageloader/nikita/image_loader/utils/SearchResult;", "query", "app_debug"})
public abstract interface UnsplashService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "photos")
    public abstract retrofit2.Call<java.util.ArrayList<com.imageloader.nikita.image_loader.utils.RetrofitImageList>> photos(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "client_id")
    java.lang.String client_id, @retrofit2.http.Query(value = "page")
    int page);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "search/photos")
    public abstract retrofit2.Call<com.imageloader.nikita.image_loader.utils.SearchResult> photosByQuery(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "client_id")
    java.lang.String client_id, @retrofit2.http.Query(value = "page")
    int page, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "query")
    java.lang.String query);
}