package io.split.android.client.storage.db.impressions.observer;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ImpressionsObserverCacheDao_Impl implements ImpressionsObserverCacheDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<ImpressionsObserverCacheEntity> __insertionAdapterOfImpressionsObserverCacheEntity;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfDeleteOldest;
    private final SharedSQLiteStatement __preparedStmtOfInsert;

    public ImpressionsObserverCacheDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfImpressionsObserverCacheEntity = new EntityInsertionAdapter<ImpressionsObserverCacheEntity>(__db) { // from class: io.split.android.client.storage.db.impressions.observer.ImpressionsObserverCacheDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `impressions_observer_cache` (`hash`,`time`,`created_at`) VALUES (?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement stmt, ImpressionsObserverCacheEntity value) {
                stmt.bindLong(1, value.getHash());
                stmt.bindLong(2, value.getTime());
                stmt.bindLong(3, value.getCreatedAt());
            }
        };
        this.__preparedStmtOfInsert = new SharedSQLiteStatement(__db) { // from class: io.split.android.client.storage.db.impressions.observer.ImpressionsObserverCacheDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO impressions_observer_cache (hash, time, created_at) VALUES (?, ?, ?)";
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) { // from class: io.split.android.client.storage.db.impressions.observer.ImpressionsObserverCacheDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM impressions_observer_cache WHERE hash = ?";
            }
        };
        this.__preparedStmtOfDeleteOldest = new SharedSQLiteStatement(__db) { // from class: io.split.android.client.storage.db.impressions.observer.ImpressionsObserverCacheDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM impressions_observer_cache WHERE created_at < ?";
            }
        };
    }

    @Override // io.split.android.client.storage.db.impressions.observer.ImpressionsObserverCacheDao
    public void insert(final List<ImpressionsObserverCacheEntity> entities) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfImpressionsObserverCacheEntity.insert(entities);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.split.android.client.storage.db.impressions.observer.ImpressionsObserverCacheDao
    public void insert(final Long hash, final Long time, final Long createdAt) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfInsert.acquire();
        if (hash == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindLong(1, hash.longValue());
        }
        if (time == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindLong(2, time.longValue());
        }
        if (createdAt == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindLong(3, createdAt.longValue());
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeInsert();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfInsert.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // io.split.android.client.storage.db.impressions.observer.ImpressionsObserverCacheDao
    public void delete(final Long hash) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDelete.acquire();
        if (hash == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindLong(1, hash.longValue());
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDelete.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // io.split.android.client.storage.db.impressions.observer.ImpressionsObserverCacheDao
    public void deleteOldest(final long timestamp) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteOldest.acquire();
        supportSQLiteStatementAcquire.bindLong(1, timestamp);
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteOldest.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // io.split.android.client.storage.db.impressions.observer.ImpressionsObserverCacheDao
    public List<ImpressionsObserverCacheEntity> getAll(final int limit) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT hash, time, created_at FROM impressions_observer_cache ORDER BY created_at ASC LIMIT ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, limit);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                ImpressionsObserverCacheEntity impressionsObserverCacheEntity = new ImpressionsObserverCacheEntity();
                impressionsObserverCacheEntity.setHash(cursorQuery.getLong(0));
                impressionsObserverCacheEntity.setTime(cursorQuery.getLong(1));
                impressionsObserverCacheEntity.setCreatedAt(cursorQuery.getLong(2));
                arrayList.add(impressionsObserverCacheEntity);
            }
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            return arrayList;
        } catch (Throwable th) {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
            throw th;
        }
    }

    @Override // io.split.android.client.storage.db.impressions.observer.ImpressionsObserverCacheDao
    public ImpressionsObserverCacheEntity get(final Long hash) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT hash, time, created_at FROM impressions_observer_cache WHERE hash = ?", 1);
        if (hash == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindLong(1, hash.longValue());
        }
        this.__db.assertNotSuspendingTransaction();
        ImpressionsObserverCacheEntity impressionsObserverCacheEntity = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst()) {
                impressionsObserverCacheEntity = new ImpressionsObserverCacheEntity();
                impressionsObserverCacheEntity.setHash(cursorQuery.getLong(0));
                impressionsObserverCacheEntity.setTime(cursorQuery.getLong(1));
                impressionsObserverCacheEntity.setCreatedAt(cursorQuery.getLong(2));
            }
            return impressionsObserverCacheEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
