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
public final class EventDao_Impl implements EventDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<EventEntity> __insertionAdapterOfEventEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByStatus;
    private final SharedSQLiteStatement __preparedStmtOfDeleteOutdated;

    public EventDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfEventEntity = new EntityInsertionAdapter<EventEntity>(__db) { // from class: io.split.android.client.storage.db.EventDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `events` (`id`,`body`,`created_at`,`status`) VALUES (nullif(?, 0),?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement stmt, EventEntity value) {
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
        this.__preparedStmtOfDeleteOutdated = new SharedSQLiteStatement(__db) { // from class: io.split.android.client.storage.db.EventDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM events WHERE created_at < ?";
            }
        };
        this.__preparedStmtOfDeleteByStatus = new SharedSQLiteStatement(__db) { // from class: io.split.android.client.storage.db.EventDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM events WHERE  status = ? AND created_at < ? AND EXISTS(SELECT 1 FROM events AS eve  WHERE eve.id = events.id LIMIT ?)";
            }
        };
    }

    @Override // io.split.android.client.storage.db.EventDao
    public void insert(final EventEntity event) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfEventEntity.insert(event);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.split.android.client.storage.db.EventDao
    public void insert(final List<EventEntity> events) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfEventEntity.insert(events);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.split.android.client.storage.db.EventDao
    public void deleteOutdated(final long updateAt) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteOutdated.acquire();
        supportSQLiteStatementAcquire.bindLong(1, updateAt);
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteOutdated.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // io.split.android.client.storage.db.EventDao
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

    @Override // io.split.android.client.storage.db.EventDao
    public List<EventEntity> getBy(final long updateAt, final int status, final int maxRows) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id, body, created_at, status FROM events WHERE created_at >= ? AND status = ? ORDER BY created_at LIMIT ?", 3);
        roomSQLiteQueryAcquire.bindLong(1, updateAt);
        roomSQLiteQueryAcquire.bindLong(2, status);
        roomSQLiteQueryAcquire.bindLong(3, maxRows);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                EventEntity eventEntity = new EventEntity();
                eventEntity.setId(cursorQuery.getLong(0));
                eventEntity.setBody(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                eventEntity.setCreatedAt(cursorQuery.getLong(2));
                eventEntity.setStatus(cursorQuery.getInt(3));
                arrayList.add(eventEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.split.android.client.storage.db.EventDao
    public List<EventEntity> getAll() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id, body, created_at, status FROM events", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                EventEntity eventEntity = new EventEntity();
                eventEntity.setId(cursorQuery.getLong(0));
                eventEntity.setBody(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                eventEntity.setCreatedAt(cursorQuery.getLong(2));
                eventEntity.setStatus(cursorQuery.getInt(3));
                arrayList.add(eventEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.split.android.client.storage.db.EventDao
    public void updateStatus(final List<Long> ids, final int status) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("UPDATE events SET status = ");
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

    @Override // io.split.android.client.storage.db.EventDao
    public void delete(final List<Long> ids) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("DELETE FROM events WHERE id IN (");
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
