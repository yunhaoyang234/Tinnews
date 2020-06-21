package com.laioffer.tinnews.database;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.laioffer.tinnews.model.Article;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class RoomDao_Impl implements RoomDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Article> __insertionAdapterOfArticle;

  private final EntityDeletionOrUpdateAdapter<Article> __deletionAdapterOfArticle;

  public RoomDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfArticle = new EntityInsertionAdapter<Article>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Article` (`author`,`content`,`description`,`publishedAt`,`title`,`url`,`urlToImage`,`favorite`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Article value) {
        if (value.author == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.author);
        }
        if (value.content == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.content);
        }
        if (value.description == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.description);
        }
        if (value.publishedAt == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.publishedAt);
        }
        if (value.title == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.title);
        }
        if (value.url == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.url);
        }
        if (value.urlToImage == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.urlToImage);
        }
        final int _tmp;
        _tmp = value.favorite ? 1 : 0;
        stmt.bindLong(8, _tmp);
      }
    };
    this.__deletionAdapterOfArticle = new EntityDeletionOrUpdateAdapter<Article>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Article` WHERE `title` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Article value) {
        if (value.title == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.title);
        }
      }
    };
  }

  @Override
  public void saveArticle(final Article news) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfArticle.insert(news);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteArticle(final Article... article) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfArticle.handleMultiple(article);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Article>> getAllArticles() {
    final String _sql = "SELECT * FROM article";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"article"}, false, new Callable<List<Article>>() {
      @Override
      public List<Article> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPublishedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "publishedAt");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
          final int _cursorIndexOfUrlToImage = CursorUtil.getColumnIndexOrThrow(_cursor, "urlToImage");
          final int _cursorIndexOfFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "favorite");
          final List<Article> _result = new ArrayList<Article>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Article _item;
            _item = new Article();
            _item.author = _cursor.getString(_cursorIndexOfAuthor);
            _item.content = _cursor.getString(_cursorIndexOfContent);
            _item.description = _cursor.getString(_cursorIndexOfDescription);
            _item.publishedAt = _cursor.getString(_cursorIndexOfPublishedAt);
            _item.title = _cursor.getString(_cursorIndexOfTitle);
            _item.url = _cursor.getString(_cursorIndexOfUrl);
            _item.urlToImage = _cursor.getString(_cursorIndexOfUrlToImage);
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfFavorite);
            _item.favorite = _tmp != 0;
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
