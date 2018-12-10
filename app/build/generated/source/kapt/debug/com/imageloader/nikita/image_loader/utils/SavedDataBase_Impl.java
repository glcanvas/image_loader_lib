package com.imageloader.nikita.image_loader.utils;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class SavedDataBase_Impl extends SavedDataBase {
  private volatile SavedDataDAO _savedDataDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `savedData` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `author_name` TEXT, `description` TEXT, `full_link` TEXT, `preview_link` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"de76478e4cf07f4a9e749464a624d1cb\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `savedData`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsSavedData = new HashMap<String, TableInfo.Column>(5);
        _columnsSavedData.put("id", new TableInfo.Column("id", "INTEGER", false, 1));
        _columnsSavedData.put("author_name", new TableInfo.Column("author_name", "TEXT", false, 0));
        _columnsSavedData.put("description", new TableInfo.Column("description", "TEXT", false, 0));
        _columnsSavedData.put("full_link", new TableInfo.Column("full_link", "TEXT", false, 0));
        _columnsSavedData.put("preview_link", new TableInfo.Column("preview_link", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSavedData = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSavedData = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSavedData = new TableInfo("savedData", _columnsSavedData, _foreignKeysSavedData, _indicesSavedData);
        final TableInfo _existingSavedData = TableInfo.read(_db, "savedData");
        if (! _infoSavedData.equals(_existingSavedData)) {
          throw new IllegalStateException("Migration didn't properly handle savedData(com.imageloader.nikita.image_loader.utils.SavedData).\n"
                  + " Expected:\n" + _infoSavedData + "\n"
                  + " Found:\n" + _existingSavedData);
        }
      }
    }, "de76478e4cf07f4a9e749464a624d1cb", "e61dbace03ebf86dcf19baba5e3ce01a");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "savedData");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `savedData`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public SavedDataDAO savedDataDAO() {
    if (_savedDataDAO != null) {
      return _savedDataDAO;
    } else {
      synchronized(this) {
        if(_savedDataDAO == null) {
          _savedDataDAO = new SavedDataDAO_Impl(this);
        }
        return _savedDataDAO;
      }
    }
  }
}
