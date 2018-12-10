package com.imageloader.nikita.image_loader.utils;

import java.lang.System;

@android.arch.persistence.room.Dao()
@kotlin.Metadata(mv = {1, 1, 11}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\'J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007H\'\u00a8\u0006\f"}, d2 = {"Lcom/imageloader/nikita/image_loader/utils/SavedDataDAO;", "", "deleteByFullLink", "", "fullLink", "", "existValueByFullLink", "Lcom/imageloader/nikita/image_loader/utils/SavedData;", "getAll", "", "insert", "savedData", "app_debug"})
public abstract interface SavedDataDAO {
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * from savedData")
    public abstract java.util.List<com.imageloader.nikita.image_loader.utils.SavedData> getAll();
    
    @android.arch.persistence.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.imageloader.nikita.image_loader.utils.SavedData savedData);
    
    @org.jetbrains.annotations.Nullable()
    @android.arch.persistence.room.Query(value = "SELECT * from savedData where full_link=:fullLink LIMIT 1")
    public abstract com.imageloader.nikita.image_loader.utils.SavedData existValueByFullLink(@org.jetbrains.annotations.Nullable()
    java.lang.String fullLink);
    
    @android.arch.persistence.room.Query(value = "DELETE FROM savedData where full_link=:fullLink")
    public abstract void deleteByFullLink(@org.jetbrains.annotations.Nullable()
    java.lang.String fullLink);
}