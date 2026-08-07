package io.split.android.client.storage.db;

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
public final class MyLargeSegmentDao_Impl implements MyLargeSegmentDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<MyLargeSegmentEntity> __insertionAdapterOfMyLargeSegmentEntity;
    private final SharedSQLiteStatement __preparedStmtOfUpdate;

    public MyLargeSegmentDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfMyLargeSegmentEntity = new EntityInsertionAdapter<MyLargeSegmentEntity>(__db) { // from class: io.split.android.client.storage.db.MyLargeSegmentDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `my_large_segments` (`user_key`,`segment_list`,`updated_at`) VALUES (?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement stmt, MyLargeSegmentEntity value) {
                if (value.getUserKey() == null) {
                    stmt.bindNull(1);
                } else {
                    stmt.bindString(1, value.getUserKey());
                }
                if (value.getSegmentList() == null) {
                    stmt.bindNull(2);
                } else {
                    stmt.bindString(2, value.getSegmentList());
                }
                stmt.bindLong(3, value.getUpdatedAt());
            }
        };
        this.__preparedStmtOfUpdate = new SharedSQLiteStatement(__db) { // from class: io.split.android.client.storage.db.MyLargeSegmentDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE my_large_segments SET user_key = ?, segment_list = ? WHERE user_key = ?";
            }
        };
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.split.android.client.storage.db.MyLargeSegmentDao, io.split.android.client.storage.db.SegmentDao
    public void update(final MyLargeSegmentEntity mySegment) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfMyLargeSegmentEntity.insert(mySegment);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.split.android.client.storage.db.MyLargeSegmentDao, io.split.android.client.storage.db.SegmentDao
    public void update(final String formerUserKey, final String userKey, final String segmentList) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate.acquire();
        if (userKey == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, userKey);
        }
        if (segmentList == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, segmentList);
        }
        if (formerUserKey == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, formerUserKey);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdate.release(supportSQLiteStatementAcquire);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.split.android.client.storage.db.MyLargeSegmentDao, io.split.android.client.storage.db.SegmentDao
    public MyLargeSegmentEntity getByUserKey(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT user_key, segment_list, updated_at FROM my_large_segments WHERE user_key = ?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        MyLargeSegmentEntity myLargeSegmentEntity = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst()) {
                MyLargeSegmentEntity myLargeSegmentEntity2 = new MyLargeSegmentEntity();
                myLargeSegmentEntity2.setUserKey(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                if (!cursorQuery.isNull(1)) {
                    string = cursorQuery.getString(1);
                }
                myLargeSegmentEntity2.setSegmentList(string);
                myLargeSegmentEntity2.setUpdatedAt(cursorQuery.getLong(2));
                myLargeSegmentEntity = myLargeSegmentEntity2;
            }
            return myLargeSegmentEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.split.android.client.storage.db.MyLargeSegmentDao, io.split.android.client.storage.db.SegmentDao
    public List<MyLargeSegmentEntity> getAll() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT user_key, segment_list, updated_at FROM my_large_segments", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                MyLargeSegmentEntity myLargeSegmentEntity = new MyLargeSegmentEntity();
                myLargeSegmentEntity.setUserKey(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                myLargeSegmentEntity.setSegmentList(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                myLargeSegmentEntity.setUpdatedAt(cursorQuery.getLong(2));
                arrayList.add(myLargeSegmentEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
