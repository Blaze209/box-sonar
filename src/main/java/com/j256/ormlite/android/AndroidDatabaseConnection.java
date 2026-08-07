package com.j256.ormlite.android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.box.android.data.mappers.annotation.CommentEntityDomainMapper;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.misc.VersionUtils;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.GeneratedKeyHolder;
import java.sql.SQLException;
import java.sql.Savepoint;

/* JADX INFO: loaded from: classes14.dex */
public class AndroidDatabaseConnection implements DatabaseConnection {
    private static final String ANDROID_VERSION = "VERSION__4.45-SNAPSHOT__";
    private final SQLiteDatabase db;
    private final boolean readWrite;
    private static Logger logger = LoggerFactory.getLogger((Class<?>) AndroidDatabaseConnection.class);
    private static final String[] NO_STRING_ARGS = new String[0];

    @Override // com.j256.ormlite.support.DatabaseConnection
    public boolean isAutoCommitSupported() {
        return true;
    }

    static {
        VersionUtils.checkCoreVersusAndroidVersions(ANDROID_VERSION);
    }

    public AndroidDatabaseConnection(SQLiteDatabase sQLiteDatabase, boolean z) {
        this.db = sQLiteDatabase;
        this.readWrite = z;
        logger.trace("{}: db {} opened, read-write = {}", this, sQLiteDatabase, Boolean.valueOf(z));
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public boolean isAutoCommit() throws SQLException {
        try {
            boolean zInTransaction = this.db.inTransaction();
            logger.trace("{}: in transaction is {}", this, Boolean.valueOf(zInTransaction));
            return !zInTransaction;
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems getting auto-commit from database", e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void setAutoCommit(boolean z) {
        if (z) {
            if (this.db.inTransaction()) {
                this.db.setTransactionSuccessful();
                this.db.endTransaction();
                return;
            }
            return;
        }
        if (this.db.inTransaction()) {
            return;
        }
        this.db.beginTransaction();
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public Savepoint setSavePoint(String str) throws SQLException {
        try {
            this.db.beginTransaction();
            logger.trace("{}: save-point set with name {}", this, str);
            return new OurSavePoint(str);
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems beginning transaction " + str, e);
        }
    }

    public boolean isReadWrite() {
        return this.readWrite;
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void commit(Savepoint savepoint) throws SQLException {
        try {
            this.db.setTransactionSuccessful();
            this.db.endTransaction();
            if (savepoint == null) {
                logger.trace("{}: transaction is successfuly ended", this);
            } else {
                logger.trace("{}: transaction {} is successfuly ended", this, savepoint.getSavepointName());
            }
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems commiting transaction " + savepoint.getSavepointName(), e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void rollback(Savepoint savepoint) throws SQLException {
        try {
            this.db.endTransaction();
            if (savepoint == null) {
                logger.trace("{}: transaction is ended, unsuccessfuly", this);
            } else {
                logger.trace("{}: transaction {} is ended, unsuccessfuly", this, savepoint.getSavepointName());
            }
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems rolling back transaction " + savepoint.getSavepointName(), e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public int executeStatement(String str, int i) throws SQLException {
        return AndroidCompiledStatement.execSql(this.db, str, str, NO_STRING_ARGS);
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public CompiledStatement compileStatement(String str, StatementBuilder.StatementType statementType, FieldType[] fieldTypeArr) {
        AndroidCompiledStatement androidCompiledStatement = new AndroidCompiledStatement(str, this.db, statementType);
        logger.trace("{}: compiled statement got {}: {}", this, androidCompiledStatement, str);
        return androidCompiledStatement;
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public CompiledStatement compileStatement(String str, StatementBuilder.StatementType statementType, FieldType[] fieldTypeArr, int i) {
        return compileStatement(str, statementType, fieldTypeArr);
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public int insert(String str, Object[] objArr, FieldType[] fieldTypeArr, GeneratedKeyHolder generatedKeyHolder) throws SQLException {
        SQLiteStatement sQLiteStatementCompileStatement = null;
        try {
            try {
                sQLiteStatementCompileStatement = this.db.compileStatement(str);
                bindArgs(sQLiteStatementCompileStatement, objArr, fieldTypeArr);
                long jExecuteInsert = sQLiteStatementCompileStatement.executeInsert();
                if (generatedKeyHolder != null) {
                    generatedKeyHolder.addKey(Long.valueOf(jExecuteInsert));
                }
                logger.trace("{}: insert statement is compiled and executed, changed {}: {}", (Object) this, (Object) 1, (Object) str);
                if (sQLiteStatementCompileStatement != null) {
                    sQLiteStatementCompileStatement.close();
                }
                return 1;
            } catch (android.database.SQLException e) {
                throw SqlExceptionUtil.create("inserting to database failed: " + str, e);
            }
        } catch (Throwable th) {
            if (sQLiteStatementCompileStatement != null) {
                sQLiteStatementCompileStatement.close();
            }
            throw th;
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public int update(String str, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        return update(str, objArr, fieldTypeArr, "updated");
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public int delete(String str, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        return update(str, objArr, fieldTypeArr, "deleted");
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public <T> Object queryForOne(String str, Object[] objArr, FieldType[] fieldTypeArr, GenericRowMapper<T> genericRowMapper, ObjectCache objectCache) throws Throwable {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = this.db.rawQuery(str, toStrings(objArr));
                try {
                    AndroidDatabaseResults androidDatabaseResults = new AndroidDatabaseResults(cursorRawQuery, objectCache);
                    logger.trace("{}: queried for one result: {}", this, str);
                    if (!androidDatabaseResults.first()) {
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        return null;
                    }
                    T tMapRow = genericRowMapper.mapRow(androidDatabaseResults);
                    if (!androidDatabaseResults.next()) {
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        return tMapRow;
                    }
                    Object obj = MORE_THAN_ONE;
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return obj;
                } catch (android.database.SQLException e) {
                    e = e;
                    cursor = cursorRawQuery;
                    throw SqlExceptionUtil.create("queryForOne from database failed: " + str, e);
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorRawQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (android.database.SQLException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public long queryForLong(String str) throws SQLException {
        SQLiteStatement sQLiteStatementCompileStatement = null;
        try {
            try {
                sQLiteStatementCompileStatement = this.db.compileStatement(str);
                long jSimpleQueryForLong = sQLiteStatementCompileStatement.simpleQueryForLong();
                logger.trace("{}: query for long simple query returned {}: {}", this, Long.valueOf(jSimpleQueryForLong), str);
                if (sQLiteStatementCompileStatement != null) {
                    sQLiteStatementCompileStatement.close();
                }
                return jSimpleQueryForLong;
            } catch (android.database.SQLException e) {
                throw SqlExceptionUtil.create("queryForLong from database failed: " + str, e);
            }
        } catch (Throwable th) {
            if (sQLiteStatementCompileStatement != null) {
                sQLiteStatementCompileStatement.close();
            }
            throw th;
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public long queryForLong(String str, Object[] objArr, FieldType[] fieldTypeArr) throws Throwable {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = this.db.rawQuery(str, toStrings(objArr));
                try {
                    AndroidDatabaseResults androidDatabaseResults = new AndroidDatabaseResults(cursorRawQuery, null);
                    long j = androidDatabaseResults.first() ? androidDatabaseResults.getLong(0) : 0L;
                    logger.trace("{}: query for long raw query returned {}: {}", this, Long.valueOf(j), str);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return j;
                } catch (android.database.SQLException e) {
                    e = e;
                    cursor = cursorRawQuery;
                    throw SqlExceptionUtil.create("queryForLong from database failed: " + str, e);
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorRawQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (android.database.SQLException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void close() throws SQLException {
        try {
            this.db.close();
            logger.trace("{}: db {} closed", this, this.db);
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems closing the database connection", e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void closeQuietly() {
        try {
            close();
        } catch (SQLException unused) {
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public boolean isClosed() throws SQLException {
        try {
            boolean zIsOpen = this.db.isOpen();
            logger.trace("{}: db {} isOpen returned {}", this, this.db, Boolean.valueOf(zIsOpen));
            return !zIsOpen;
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems detecting if the database is closed", e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0028  */
    @Override // com.j256.ormlite.support.DatabaseConnection
    public boolean isTableExists(String str) {
        boolean z;
        Cursor cursorRawQuery = this.db.rawQuery("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name = '" + str + "'", null);
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.getCount() > 0) {
                    z = true;
                } else {
                    z = false;
                }
            } finally {
                cursorRawQuery.close();
            }
        } else {
            z = false;
        }
        logger.trace("{}: isTableExists '{}' returned {}", this, str, Boolean.valueOf(z));
        return z;
    }

    private int update(String str, Object[] objArr, FieldType[] fieldTypeArr, String str2) throws Throwable {
        int iSimpleQueryForLong;
        SQLiteStatement sQLiteStatementCompileStatement = null;
        try {
            try {
                SQLiteStatement sQLiteStatementCompileStatement2 = this.db.compileStatement(str);
                try {
                    bindArgs(sQLiteStatementCompileStatement2, objArr, fieldTypeArr);
                    sQLiteStatementCompileStatement2.execute();
                    if (sQLiteStatementCompileStatement2 != null) {
                        sQLiteStatementCompileStatement2.close();
                    } else {
                        sQLiteStatementCompileStatement = sQLiteStatementCompileStatement2;
                    }
                    try {
                        sQLiteStatementCompileStatement = this.db.compileStatement("SELECT CHANGES()");
                        iSimpleQueryForLong = (int) sQLiteStatementCompileStatement.simpleQueryForLong();
                        if (sQLiteStatementCompileStatement != null) {
                            sQLiteStatementCompileStatement.close();
                        }
                    } catch (android.database.SQLException unused) {
                        if (sQLiteStatementCompileStatement != null) {
                            sQLiteStatementCompileStatement.close();
                        }
                        iSimpleQueryForLong = 1;
                    } catch (Throwable th) {
                        if (sQLiteStatementCompileStatement != null) {
                            sQLiteStatementCompileStatement.close();
                        }
                        throw th;
                    }
                    logger.trace("{} statement is compiled and executed, changed {}: {}", str2, Integer.valueOf(iSimpleQueryForLong), str);
                    return iSimpleQueryForLong;
                } catch (android.database.SQLException e) {
                    e = e;
                    sQLiteStatementCompileStatement = sQLiteStatementCompileStatement2;
                    throw SqlExceptionUtil.create("updating database failed: " + str, e);
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteStatementCompileStatement = sQLiteStatementCompileStatement2;
                    if (sQLiteStatementCompileStatement != null) {
                        sQLiteStatementCompileStatement.close();
                    }
                    throw th;
                }
            } catch (android.database.SQLException e2) {
                e = e2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private void bindArgs(SQLiteStatement sQLiteStatement, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        if (objArr == null) {
            return;
        }
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null) {
                sQLiteStatement.bindNull(i + 1);
            } else {
                SqlType sqlType = fieldTypeArr[i].getSqlType();
                switch (AnonymousClass1.$SwitchMap$com$j256$ormlite$field$SqlType[sqlType.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        sQLiteStatement.bindString(i + 1, obj.toString());
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        sQLiteStatement.bindLong(i + 1, ((Number) obj).longValue());
                        break;
                    case 9:
                    case 10:
                        sQLiteStatement.bindDouble(i + 1, ((Number) obj).doubleValue());
                        break;
                    case 11:
                    case 12:
                        sQLiteStatement.bindBlob(i + 1, (byte[]) obj);
                        break;
                    case 13:
                    case 14:
                    case 15:
                        throw new SQLException("Invalid Android type: " + sqlType);
                    default:
                        throw new SQLException("Unknown sql argument type: " + sqlType);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.j256.ormlite.android.AndroidDatabaseConnection$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$j256$ormlite$field$SqlType;

        static {
            int[] iArr = new int[SqlType.values().length];
            $SwitchMap$com$j256$ormlite$field$SqlType = iArr;
            try {
                iArr[SqlType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG_STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.CHAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BOOLEAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SHORT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.INTEGER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.FLOAT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DOUBLE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE_ARRAY.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SERIALIZABLE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DATE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BLOB.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BIG_DECIMAL.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.UNKNOWN.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    private String[] toStrings(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        String[] strArr = new String[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null) {
                strArr[i] = null;
            } else {
                strArr[i] = obj.toString();
            }
        }
        return strArr;
    }

    public String toString() {
        return getClass().getSimpleName() + CommentEntityDomainMapper.MENTIONS_SYMBOL + Integer.toHexString(super.hashCode());
    }

    private static class OurSavePoint implements Savepoint {
        private String name;

        @Override // java.sql.Savepoint
        public int getSavepointId() {
            return 0;
        }

        public OurSavePoint(String str) {
            this.name = str;
        }

        @Override // java.sql.Savepoint
        public String getSavepointName() {
            return this.name;
        }
    }
}
