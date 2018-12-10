package com.imageloader.nikita.image_loader.utils;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class SavedDataDAO_Impl implements SavedDataDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfSavedData;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByFullLink;

  public SavedDataDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSavedData = new EntityInsertionAdapter<SavedData>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `savedData`(`id`,`author_name`,`description`,`full_link`,`preview_link`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, SavedData value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        if (value.getAuthorName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAuthorName());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescription());
        }
        if (value.getFullLink() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getFullLink());
        }
        if (value.getPreviewLink() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPreviewLink());
        }
      }
    };
    this.__preparedStmtOfDeleteByFullLink = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM savedData where full_link=?";
        return _query;
      }
    };
  }

  @Override
  public void insert(SavedData savedData) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfSavedData.insert(savedData);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteByFullLink(String fullLink) {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteByFullLink.acquire();
    __db.beginTransaction();
    try {
      int _argIndex = 1;
      if (fullLink == null) {
        _stmt.bindNull(_argIndex);
      } else {
        _stmt.bindString(_argIndex, fullLink);
      }
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteByFullLink.release(_stmt);
    }
  }

  @Override
  public List<SavedData> getAll() {
    final String _sql = "SELECT * from savedData";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfAuthorName = _cursor.getColumnIndexOrThrow("author_name");
      final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("description");
      final int _cursorIndexOfFullLink = _cursor.getColumnIndexOrThrow("full_link");
      final int _cursorIndexOfPreviewLink = _cursor.getColumnIndexOrThrow("preview_link");
      final List<SavedData> _result = new ArrayList<SavedData>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final SavedData _item;
        _item = new SavedData();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final String _tmpAuthorName;
        _tmpAuthorName = _cursor.getString(_cursorIndexOfAuthorName);
        _item.setAuthorName(_tmpAuthorName);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        _item.setDescription(_tmpDescription);
        final String _tmpFullLink;
        _tmpFullLink = _cursor.getString(_cursorIndexOfFullLink);
        _item.setFullLink(_tmpFullLink);
        final String _tmpPreviewLink;
        _tmpPreviewLink = _cursor.getString(_cursorIndexOfPreviewLink);
        _item.setPreviewLink(_tmpPreviewLink);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public SavedData existValueByFullLink(String fullLink) {
    final String _sql = "SELECT * from savedData where full_link=? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fullLink == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fullLink);
    }
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfAuthorName = _cursor.getColumnIndexOrThrow("author_name");
      final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("description");
      final int _cursorIndexOfFullLink = _cursor.getColumnIndexOrThrow("full_link");
      final int _cursorIndexOfPreviewLink = _cursor.getColumnIndexOrThrow("preview_link");
      final SavedData _result;
      if(_cursor.moveToFirst()) {
        _result = new SavedData();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final String _tmpAuthorName;
        _tmpAuthorName = _cursor.getString(_cursorIndexOfAuthorName);
        _result.setAuthorName(_tmpAuthorName);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        _result.setDescription(_tmpDescription);
        final String _tmpFullLink;
        _tmpFullLink = _cursor.getString(_cursorIndexOfFullLink);
        _result.setFullLink(_tmpFullLink);
        final String _tmpPreviewLink;
        _tmpPreviewLink = _cursor.getString(_cursorIndexOfPreviewLink);
        _result.setPreviewLink(_tmpPreviewLink);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
