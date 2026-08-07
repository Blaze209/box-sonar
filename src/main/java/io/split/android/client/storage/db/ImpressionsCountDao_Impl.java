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
public final class ImpressionsCountDao_Impl implements ImpressionsCountDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<ImpressionsCountEntity> __insertionAdapterOfImpressionsCountEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByStatus;
    private final SharedSQLiteStatement __preparedStmtOfDeleteOutdated;

    public ImpressionsCountDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfImpressionsCountEntity = new EntityInsertionAdapter<ImpressionsCountEntity>(__db) { // from class: io.split.android.client.storage.db.ImpressionsCountDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `impressions_count` (`id`,`body`,`created_at`,`status`) VALUES (nullif(?, 0),?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement stmt, ImpressionsCountEntity value) {
                stmt.bindLong(1, value.getId());
                if (value.getBody() == null) {
                    stmt.bindNull(2);
                } else {
                    stmt.bindString(2, value.getBody());
                }
                stmt.bindLong(3, value.getCreatedAt());
                stmt.bindLong(4, value.getStatus());
            }
        };
        this.__preparedStmtOfDeleteOutdated = new SharedSQLiteStatement(__db) { // from class: io.split.android.client.storage.db.ImpressionsCountDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM impressions_count WHERE created_at < ?";
            }
        };
        this.__preparedStmtOfDeleteByStatus = new SharedSQLiteStatement(__db) { // from class: io.split.android.client.storage.db.ImpressionsCountDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM impressions_count WHERE  status = ? AND created_at < ? AND EXISTS(SELECT 1 FROM impressions_count AS imp  WHERE imp.id = impressions_count.id LIMIT ?)";
            }
        };
    }

    @Override // io.split.android.client.storage.db.ImpressionsCountDao
    public void insert(final ImpressionsCountEntity count) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfImpressionsCountEntity.insert(count);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.split.android.client.storage.db.ImpressionsCountDao
    public void insert(final List<ImpressionsCountEntity> counts) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfImpressionsCountEntity.insert(counts);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.split.android.client.storage.db.ImpressionsCountDao
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

    @Override // io.split.android.client.storage.db.ImpressionsCountDao
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

    @Override // io.split.android.client.storage.db.ImpressionsCountDao
    public List<ImpressionsCountEntity> getBy(final long timestamp, final int status, final int maxRows) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id, body, created_at, status FROM impressions_count WHERE created_at >= ? AND status = ? ORDER BY created_at LIMIT ?", 3);
        roomSQLiteQueryAcquire.bindLong(1, timestamp);
        roomSQLiteQueryAcquire.bindLong(2, status);
        roomSQLiteQueryAcquire.bindLong(3, maxRows);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                ImpressionsCountEntity impressionsCountEntity = new ImpressionsCountEntity();
                impressionsCountEntity.setId(cursorQuery.getLong(0));
                impressionsCountEntity.setBody(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                impressionsCountEntity.setCreatedAt(cursorQuery.getLong(2));
                impressionsCountEntity.setStatus(cursorQuery.getInt(3));
                arrayList.add(impressionsCountEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.split.android.client.storage.db.ImpressionsCountDao
    public List<ImpressionsCountEntity> getAll() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id, body, created_at, status FROM impressions_count", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                ImpressionsCountEntity impressionsCountEntity = new ImpressionsCountEntity();
                impressionsCountEntity.setId(cursorQuery.getLong(0));
                impressionsCountEntity.setBody(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                impressionsCountEntity.setCreatedAt(cursorQuery.getLong(2));
                impressionsCountEntity.setStatus(cursorQuery.getInt(3));
                arrayList.add(impressionsCountEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.split.android.client.storage.db.ImpressionsCountDao
    public void updateStatus(final List<Long> ids, final int status) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("UPDATE impressions_count SET status = ");
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

    @Override // io.split.android.client.storage.db.ImpressionsCountDao
    public void delete(final List<Long> ids) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("DELETE FROM impressions_count WHERE id IN (");
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
