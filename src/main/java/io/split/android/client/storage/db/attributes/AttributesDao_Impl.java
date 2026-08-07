package io.split.android.client.storage.db.attributes;

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
public final class AttributesDao_Impl implements AttributesDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<AttributesEntity> __insertionAdapterOfAttributesEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfUpdate;

    public AttributesDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfAttributesEntity = new EntityInsertionAdapter<AttributesEntity>(__db) { // from class: io.split.android.client.storage.db.attributes.AttributesDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `attributes` (`user_key`,`attributes`,`updated_at`) VALUES (?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement stmt, AttributesEntity value) {
                if (value.getUserKey() == null) {
                    stmt.bindNull(1);
                } else {
                    stmt.bindString(1, value.getUserKey());
                }
                if (value.getAttributes() == null) {
                    stmt.bindNull(2);
                } else {
                    stmt.bindString(2, value.getAttributes());
                }
                stmt.bindLong(3, value.getUpdatedAt());
            }
        };
        this.__preparedStmtOfUpdate = new SharedSQLiteStatement(__db) { // from class: io.split.android.client.storage.db.attributes.AttributesDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE attributes SET user_key = ?, attributes = ? WHERE user_key = ?";
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) { // from class: io.split.android.client.storage.db.attributes.AttributesDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM attributes WHERE user_key = ?";
            }
        };
    }

    @Override // io.split.android.client.storage.db.attributes.AttributesDao
    public void update(final AttributesEntity attributesEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfAttributesEntity.insert(attributesEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.split.android.client.storage.db.attributes.AttributesDao
    public void update(final String formerUserKey, final String userKey, final String attributes) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate.acquire();
        if (userKey == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, userKey);
        }
        if (attributes == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, attributes);
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

    @Override // io.split.android.client.storage.db.attributes.AttributesDao
    public void deleteAll(final String userKey) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteAll.acquire();
        if (userKey == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, userKey);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAll.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // io.split.android.client.storage.db.attributes.AttributesDao
    public AttributesEntity getByUserKey(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT user_key, attributes, updated_at FROM attributes WHERE user_key = ?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        AttributesEntity attributesEntity = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst()) {
                AttributesEntity attributesEntity2 = new AttributesEntity();
                attributesEntity2.setUserKey(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                if (!cursorQuery.isNull(1)) {
                    string = cursorQuery.getString(1);
                }
                attributesEntity2.setAttributes(string);
                attributesEntity2.setUpdatedAt(cursorQuery.getLong(2));
                attributesEntity = attributesEntity2;
            }
            return attributesEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.split.android.client.storage.db.attributes.AttributesDao
    public List<AttributesEntity> getAll() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT user_key, attributes, updated_at FROM attributes", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                AttributesEntity attributesEntity = new AttributesEntity();
                attributesEntity.setUserKey(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                attributesEntity.setAttributes(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                attributesEntity.setUpdatedAt(cursorQuery.getLong(2));
                arrayList.add(attributesEntity);
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
