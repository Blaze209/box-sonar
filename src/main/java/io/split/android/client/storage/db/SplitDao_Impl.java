package io.split.android.client.storage.db;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class SplitDao_Impl implements SplitDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<SplitEntity> __insertionAdapterOfSplitEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfUpdate;

    public SplitDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfSplitEntity = new EntityInsertionAdapter<SplitEntity>(__db) { // from class: io.split.android.client.storage.db.SplitDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `splits` (`name`,`body`,`updated_at`) VALUES (?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement stmt, SplitEntity value) {
                if (value.getName() == null) {
                    stmt.bindNull(1);
                } else {
                    stmt.bindString(1, value.getName());
                }
                if (value.getBody() == null) {
                    stmt.bindNull(2);
                } else {
                    stmt.bindString(2, value.getBody());
                }
                stmt.bindLong(3, value.getUpdatedAt());
            }
        };
        this.__preparedStmtOfUpdate = new SharedSQLiteStatement(__db) { // from class: io.split.android.client.storage.db.SplitDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE splits SET name = ?, body = ? WHERE name = ?";
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) { // from class: io.split.android.client.storage.db.SplitDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM splits";
            }
        };
    }

    @Override // io.split.android.client.storage.db.SplitDao
    public void insert(final List<SplitEntity> splits) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfSplitEntity.insert(splits);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.split.android.client.storage.db.SplitDao
    public void insert(final SplitEntity split) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfSplitEntity.insert(split);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // io.split.android.client.storage.db.SplitDao
    public void update(final String formerName, final String name, final String body) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfUpdate.acquire();
        if (name == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, name);
        }
        if (body == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, body);
        }
        if (formerName == null) {
            supportSQLiteStatementAcquire.bindNull(3);
        } else {
            supportSQLiteStatementAcquire.bindString(3, formerName);
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

    @Override // io.split.android.client.storage.db.SplitDao
    public void deleteAll() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteAll.acquire();
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAll.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // io.split.android.client.storage.db.SplitDao
    public List<SplitEntity> getAll() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT name, body, updated_at FROM splits", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                SplitEntity splitEntity = new SplitEntity();
                splitEntity.setName(cursorQuery.isNull(0) ? null : cursorQuery.getString(0));
                splitEntity.setBody(cursorQuery.isNull(1) ? null : cursorQuery.getString(1));
                splitEntity.setUpdatedAt(cursorQuery.getLong(2));
                arrayList.add(splitEntity);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // io.split.android.client.storage.db.SplitDao
    public void delete(final List<String> names) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("DELETE FROM splits WHERE name IN (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, names.size());
        sbNewStringBuilder.append(")");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(sbNewStringBuilder.toString());
        int i = 1;
        for (String str : names) {
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

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
