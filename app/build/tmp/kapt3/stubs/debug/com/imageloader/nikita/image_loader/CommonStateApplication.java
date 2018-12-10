package com.imageloader.nikita.image_loader;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u0000X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\b\u00a8\u0006\u001f"}, d2 = {"Lcom/imageloader/nikita/image_loader/CommonStateApplication;", "Landroid/app/Application;", "()V", "collectionFragment", "Landroid/support/v4/app/Fragment;", "getCollectionFragment", "()Landroid/support/v4/app/Fragment;", "setCollectionFragment", "(Landroid/support/v4/app/Fragment;)V", "currentFragment", "", "getCurrentFragment", "()Ljava/lang/String;", "setCurrentFragment", "(Ljava/lang/String;)V", "defaultFragment", "getDefaultFragment", "setDefaultFragment", "dimension", "getDimension", "setDimension", "instance", "getInstance", "()Lcom/imageloader/nikita/image_loader/CommonStateApplication;", "setInstance", "(Lcom/imageloader/nikita/image_loader/CommonStateApplication;)V", "requestFragment", "getRequestFragment", "setRequestFragment", "onCreate", "", "app_debug"})
public final class CommonStateApplication extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    public com.imageloader.nikita.image_loader.CommonStateApplication instance;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String dimension;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String currentFragment;
    @org.jetbrains.annotations.Nullable()
    private android.support.v4.app.Fragment requestFragment;
    @org.jetbrains.annotations.Nullable()
    private android.support.v4.app.Fragment defaultFragment;
    @org.jetbrains.annotations.Nullable()
    private android.support.v4.app.Fragment collectionFragment;
    
    @org.jetbrains.annotations.NotNull()
    public final com.imageloader.nikita.image_loader.CommonStateApplication getInstance() {
        return null;
    }
    
    public final void setInstance(@org.jetbrains.annotations.NotNull()
    com.imageloader.nikita.image_loader.CommonStateApplication p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDimension() {
        return null;
    }
    
    public final void setDimension(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCurrentFragment() {
        return null;
    }
    
    public final void setCurrentFragment(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.support.v4.app.Fragment getRequestFragment() {
        return null;
    }
    
    public final void setRequestFragment(@org.jetbrains.annotations.Nullable()
    android.support.v4.app.Fragment p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.support.v4.app.Fragment getDefaultFragment() {
        return null;
    }
    
    public final void setDefaultFragment(@org.jetbrains.annotations.Nullable()
    android.support.v4.app.Fragment p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.support.v4.app.Fragment getCollectionFragment() {
        return null;
    }
    
    public final void setCollectionFragment(@org.jetbrains.annotations.Nullable()
    android.support.v4.app.Fragment p0) {
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    public CommonStateApplication() {
        super();
    }
}