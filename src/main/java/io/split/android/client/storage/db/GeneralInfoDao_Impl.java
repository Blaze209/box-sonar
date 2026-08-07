package io.split.android.client.storage.db;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class GeneralInfoDao_Impl implements GeneralInfoDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<GeneralInfoEntity> __insertionAdapterOfGeneralInfoEntity;

    public GeneralInfoDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfGeneralInfoEntity = new EntityInsertionAdapter<GeneralInfoEntity>(__db) { // from class: io.split.android.client.storage.db.GeneralInfoDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `general_info` (`name`,`stringValue`,`longValue`,`updated_at`) VALUES (?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement stmt, GeneralInfoEntity value) {
                if (value.getName() == null) {
                    stmt.bindNull(1);
                } else {
                    stmt.bindString(1, value.getName());
                }
                if (value.getStringValue() == null) {
                    stmt.bindNull(2);
                } else {
                    stmt.bindString(2, value.getStringValue());
                }
                stmt.bindLong(3, value.getLongValue());
                stmt.bindLong(4, value.getUpdatedAt());
            }
        };
    }

    @Override // io.split.android.client.storage.db.GeneralInfoDao
    public void update(final GeneralInfoEntity info) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfGeneralInfoEntity.insert(info);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.split.android.client.storage.db.GeneralInfoDao
    public GeneralInfoEntity getByName(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT name, stringValue, longValue, updated_at FROM general_info WHERE name = ?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        GeneralInfoEntity generalInfoEntity = null;
        String string = null;
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            if (cursorQuery.moveToFirst()) {
                GeneralInfoEntity generalInfoEntity2 = new GeneralInfoEntity();
                generalInfoEntity2.setName(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                if (!cursorQuery.isNull(1)) {
                    string = cursorQuery.getString(1);
                }
                generalInfoEntity2.setStringValue(string);
                generalInfoEntity2.setLongValue(cursorQuery.getLong(2));
                generalInfoEntity2.setUpdatedAt(cursorQuery.getLong(3));
                generalInfoEntity = generalInfoEntity2;
            }
            return generalInfoEntity;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
