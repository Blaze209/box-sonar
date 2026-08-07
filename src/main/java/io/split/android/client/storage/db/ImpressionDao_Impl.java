package io.split.android.client.storage.db;

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
public final class ImpressionDao_Impl implements ImpressionDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<ImpressionEntity> __insertionAdapterOfImpressionEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByStatus;
    private final SharedSQLiteStatement __preparedStmtOfDeleteOutdated;

    public ImpressionDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfImpressionEntity = new EntityInsertionAdapter<ImpressionEntity>(__db) { // from class: io.split.android.client.storage.db.ImpressionDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `impressions` (`id`,`test_name`,`body`,`created_at`,`status`) VALUES (nullif(?, 0),?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement stmt, ImpressionEntity value) {
                stmt.bindLong(1, value.getId());
                if (value.getTestName() == null) {
                    stmt.bindNull(2);
                } else {
                    stmt.bindString(2, value.getTestName());
                }
                if (value.getBody() == null) {
                    stmt.bindNull(3);
                } else {
                    stmt.bindString(3, value.getBody());
                }
                stmt.bindLong(4, value.getCreatedAt());
                stmt.bindLong(5, value.getStatus());
            }
        };
        this.__preparedStmtOfDeleteOutdated = new SharedSQLiteStatement(__db) { // from class: io.split.android.client.storage.db.ImpressionDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM impressions WHERE created_at < ?";
            }
        };
        this.__preparedStmtOfDeleteByStatus = new SharedSQLiteStatement(__db) { // from class: io.split.android.client.storage.db.ImpressionDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM impressions WHERE  status = ? AND created_at < ? AND EXISTS(SELECT 1 FROM impressions AS imp  WHERE imp.id = impressions.id LIMIT ?)";
            }
        };
    }

    @Override // io.split.android.client.storage.db.ImpressionDao
    public void insert(final ImpressionEntity impression) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfImpressionEntity.insert(impression);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.split.android.client.storage.db.ImpressionDao
    public void insert(final List<ImpressionEntity> impressions) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfImpressionEntity.insert(impressions);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.split.android.client.storage.db.ImpressionDao
    public void deleteOutdated(final long timestamp) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteOutdated.acquire();
        supportSQLiteStatementAcquire.bindLong(1, timestamp);
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteOutdated.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // io.split.android.client.storage.db.ImpressionDao
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

    @Override // io.split.android.client.storage.db.ImpressionDao
    public List<ImpressionEntity> getBy(final long timestamp, final int status, final int maxRows) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id, test_name, body, created_at, status FROM impressions WHERE created_at >= ? AND status = ? ORDER BY created_at LIMIT ?", 3);
        roomSQLiteQueryAcquire.bindLong(1, timestamp);
        roomSQLiteQueryAcquire.bindLong(2, status);
        roomSQLiteQueryAcquire.bindLong(3, maxRows);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                ImpressionEntity impressionEntity = new ImpressionEntity();
                impressionEntity.setId(cursorQuery.getLong(0));
                impressionEntity.setTestName(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                impressionEntity.setBody(cursorQuery.isNull(2) ? null : cursorQuery.getString(2));
                impressionEntity.setCreatedAt(cursorQuery.getLong(3));
                impressionEntity.setStatus(cursorQuery.getInt(4));
                arrayList.add(impressionEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.split.android.client.storage.db.ImpressionDao
    public List<ImpressionEntity> getAll() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id, test_name, body, created_at, status FROM impressions", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                ImpressionEntity impressionEntity = new ImpressionEntity();
                impressionEntity.setId(cursorQuery.getLong(0));
                impressionEntity.setTestName(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                impressionEntity.setBody(cursorQuery.isNull(2) ? null : cursorQuery.getString(2));
                impressionEntity.setCreatedAt(cursorQuery.getLong(3));
                impressionEntity.setStatus(cursorQuery.getInt(4));
                arrayList.add(impressionEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.split.android.client.storage.db.ImpressionDao
    public void updateStatus(final List<Long> ids, final int status) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("UPDATE impressions SET status = ");
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

    @Override // io.split.android.client.storage.db.ImpressionDao
    public void delete(final List<Long> ids) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("DELETE FROM impressions WHERE id IN (");
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
