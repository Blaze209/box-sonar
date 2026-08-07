package io.split.android.client.storage.db.impressions.unique;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.microsoft.identity.client.internal.MsalUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class UniqueKeysDao_Impl implements UniqueKeysDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<UniqueKeyEntity> __insertionAdapterOfUniqueKeyEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByStatus;
    private final SharedSQLiteStatement __preparedStmtOfDeleteOutdated;

    public UniqueKeysDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfUniqueKeyEntity = new EntityInsertionAdapter<UniqueKeyEntity>(__db) { // from class: io.split.android.client.storage.db.impressions.unique.UniqueKeysDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `unique_keys` (`id`,`user_key`,`feature_list`,`created_at`,`status`) VALUES (nullif(?, 0),?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement stmt, UniqueKeyEntity value) {
                stmt.bindLong(1, value.getId());
                if (value.getUserKey() == null) {
                    stmt.bindNull(2);
                } else {
                    stmt.bindString(2, value.getUserKey());
                }
                if (value.getFeatureList() == null) {
                    stmt.bindNull(3);
                } else {
                    stmt.bindString(3, value.getFeatureList());
                }
                stmt.bindLong(4, value.getCreatedAt());
                stmt.bindLong(5, value.getStatus());
            }
        };
        this.__preparedStmtOfDeleteOutdated = new SharedSQLiteStatement(__db) { // from class: io.split.android.client.storage.db.impressions.unique.UniqueKeysDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM unique_keys WHERE created_at < ?";
            }
        };
        this.__preparedStmtOfDeleteByStatus = new SharedSQLiteStatement(__db) { // from class: io.split.android.client.storage.db.impressions.unique.UniqueKeysDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM unique_keys WHERE status = ? AND created_at < ? AND EXISTS(SELECT 1 FROM unique_keys AS imp WHERE imp.user_key = unique_keys.user_key LIMIT ?)";
            }
        };
    }

    @Override // io.split.android.client.storage.db.impressions.unique.UniqueKeysDao
    public long insert(final UniqueKeyEntity uniqueKeyEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long jInsertAndReturnId = this.__insertionAdapterOfUniqueKeyEntity.insertAndReturnId(uniqueKeyEntity);
            this.__db.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.split.android.client.storage.db.impressions.unique.UniqueKeysDao
    public List<Long> insert(final List<UniqueKeyEntity> uniqueKeyEntityList) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            List<Long> listInsertAndReturnIdsList = this.__insertionAdapterOfUniqueKeyEntity.insertAndReturnIdsList(uniqueKeyEntityList);
            this.__db.setTransactionSuccessful();
            return listInsertAndReturnIdsList;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.split.android.client.storage.db.impressions.unique.UniqueKeysDao
    public void deleteOutdated(final long beforeTimestamp) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteOutdated.acquire();
        supportSQLiteStatementAcquire.bindLong(1, beforeTimestamp);
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteOutdated.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // io.split.android.client.storage.db.impressions.unique.UniqueKeysDao
    public int deleteByStatus(final int status, final long maxTimestamp, final int maxRows) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteByStatus.acquire();
        supportSQLiteStatementAcquire.bindLong(1, status);
        supportSQLiteStatementAcquire.bindLong(2, maxTimestamp);
        supportSQLiteStatementAcquire.bindLong(3, maxRows);
        this.__db.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteByStatus.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // io.split.android.client.storage.db.impressions.unique.UniqueKeysDao
    public List<UniqueKeyEntity> getBy(final long fromTimestamp, final int status, final int maxRows) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id, user_key, feature_list, created_at, status FROM unique_keys WHERE created_at >= ? AND status = ? ORDER BY created_at LIMIT ?", 3);
        roomSQLiteQueryAcquire.bindLong(1, fromTimestamp);
        roomSQLiteQueryAcquire.bindLong(2, status);
        roomSQLiteQueryAcquire.bindLong(3, maxRows);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                UniqueKeyEntity uniqueKeyEntity = new UniqueKeyEntity();
                uniqueKeyEntity.setId(cursorQuery.getLong(0));
                uniqueKeyEntity.setUserKey(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                uniqueKeyEntity.setFeatureList(cursorQuery.isNull(2) ? null : cursorQuery.getString(2));
                uniqueKeyEntity.setCreatedAt(cursorQuery.getLong(3));
                uniqueKeyEntity.setStatus(cursorQuery.getInt(4));
                arrayList.add(uniqueKeyEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.split.android.client.storage.db.impressions.unique.UniqueKeysDao
    public List<UniqueKeyEntity> getAll() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id, user_key, feature_list, created_at, status FROM unique_keys", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                UniqueKeyEntity uniqueKeyEntity = new UniqueKeyEntity();
                uniqueKeyEntity.setId(cursorQuery.getLong(0));
                uniqueKeyEntity.setUserKey(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                uniqueKeyEntity.setFeatureList(cursorQuery.isNull(2) ? null : cursorQuery.getString(2));
                uniqueKeyEntity.setCreatedAt(cursorQuery.getLong(3));
                uniqueKeyEntity.setStatus(cursorQuery.getInt(4));
                arrayList.add(uniqueKeyEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.split.android.client.storage.db.impressions.unique.UniqueKeysDao
    public void updateStatus(final List<Long> ids, final int status) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("UPDATE unique_keys SET status = ");
        sbNewStringBuilder.append(MsalUtils.QUERY_STRING_SYMBOL);
        sbNewStringBuilder.append("  WHERE id IN (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, ids.size());
        sbNewStringBuilder.append(")");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(sbNewStringBuilder.toString());
        supportSQLiteStatementCompileStatement.bindLong(1, status);
        int i = 2;
        for (Long l : ids) {
            if (l == null) {
                supportSQLiteStatementCompileStatement.bindNull(i);
            } else {
                supportSQLiteStatementCompileStatement.bindLong(i, l.longValue());
            }
            i++;
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementCompileStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.split.android.client.storage.db.impressions.unique.UniqueKeysDao
    public void delete(final List<String> userKeys) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("DELETE FROM unique_keys WHERE user_key IN (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, userKeys.size());
        sbNewStringBuilder.append(")");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(sbNewStringBuilder.toString());
        int i = 1;
        for (String str : userKeys) {
            if (str == null) {
                supportSQLiteStatementCompileStatement.bindNull(i);
            } else {
                supportSQLiteStatementCompileStatement.bindString(i, str);
            }
            i++;
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementCompileStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.split.android.client.storage.db.impressions.unique.UniqueKeysDao
    public void deleteById(final List<Long> ids) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("DELETE FROM unique_keys WHERE id IN (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, ids.size());
        sbNewStringBuilder.append(")");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(sbNewStringBuilder.toString());
        int i = 1;
        for (Long l : ids) {
            if (l == null) {
                supportSQLiteStatementCompileStatement.bindNull(i);
            } else {
                supportSQLiteStatementCompileStatement.bindLong(i, l.longValue());
            }
            i++;
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementCompileStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
