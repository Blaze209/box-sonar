package com.amplitude.api;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import com.box.androidsdk.content.models.BoxEvent;
import com.box.androidsdk.content.models.BoxOrder;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
class DatabaseHelper extends SQLiteOpenHelper {
    private static final String CREATE_EVENTS_TABLE = "CREATE TABLE IF NOT EXISTS events (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);";
    private static final String CREATE_IDENTIFYS_TABLE = "CREATE TABLE IF NOT EXISTS identifys (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);";
    private static final String CREATE_IDENTIFY_INTERCEPTOR_TABLE = "CREATE TABLE IF NOT EXISTS identify_interceptor (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);";
    private static final String CREATE_LONG_STORE_TABLE = "CREATE TABLE IF NOT EXISTS long_store (key TEXT PRIMARY KEY NOT NULL, value INTEGER);";
    private static final String CREATE_STORE_TABLE = "CREATE TABLE IF NOT EXISTS store (key TEXT PRIMARY KEY NOT NULL, value TEXT);";
    private static final String EVENT_FIELD = "event";
    protected static final String EVENT_TABLE_NAME = "events";
    protected static final String IDENTIFY_INTERCEPTOR_TABLE_NAME = "identify_interceptor";
    protected static final String IDENTIFY_TABLE_NAME = "identifys";
    private static final String ID_FIELD = "id";
    private static final String KEY_FIELD = "key";
    protected static final String LONG_STORE_TABLE_NAME = "long_store";
    protected static final String STORE_TABLE_NAME = "store";
    private static final String TAG = "com.amplitude.api.DatabaseHelper";
    private static final String VALUE_FIELD = "value";
    static final Map<String, DatabaseHelper> instances = new HashMap();
    private static final AmplitudeLog logger = AmplitudeLog.getLogger();
    private boolean callResetListenerOnDatabaseReset;
    private DatabaseResetListener databaseResetListener;
    File file;
    private String instanceName;

    @Deprecated
    static DatabaseHelper getDatabaseHelper(Context context) {
        return getDatabaseHelper(context, null);
    }

    static synchronized DatabaseHelper getDatabaseHelper(Context context, String str) {
        DatabaseHelper databaseHelper;
        String strNormalizeInstanceName = Utils.normalizeInstanceName(str);
        Map<String, DatabaseHelper> map = instances;
        databaseHelper = map.get(strNormalizeInstanceName);
        if (databaseHelper == null) {
            databaseHelper = new DatabaseHelper(context.getApplicationContext(), strNormalizeInstanceName);
            map.put(strNormalizeInstanceName, databaseHelper);
        }
        return databaseHelper;
    }

    private static String getDatabaseName(String str) {
        return (Utils.isEmptyString(str) || str.equals(Constants.DEFAULT_INSTANCE)) ? "com.amplitude.api" : "com.amplitude.api_" + str;
    }

    protected DatabaseHelper(Context context) {
        this(context, null);
    }

    protected DatabaseHelper(Context context, String str) {
        super(context, getDatabaseName(str), (SQLiteDatabase.CursorFactory) null, 4);
        this.callResetListenerOnDatabaseReset = true;
        this.file = context.getDatabasePath(getDatabaseName(str));
        this.instanceName = Utils.normalizeInstanceName(str);
    }

    void setDatabaseResetListener(DatabaseResetListener databaseResetListener) {
        this.databaseResetListener = databaseResetListener;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(CREATE_STORE_TABLE);
        sQLiteDatabase.execSQL(CREATE_LONG_STORE_TABLE);
        sQLiteDatabase.execSQL(CREATE_EVENTS_TABLE);
        sQLiteDatabase.execSQL(CREATE_IDENTIFYS_TABLE);
        sQLiteDatabase.execSQL(CREATE_IDENTIFY_INTERCEPTOR_TABLE);
        DatabaseResetListener databaseResetListener = this.databaseResetListener;
        if (databaseResetListener == null || !this.callResetListenerOnDatabaseReset) {
            return;
        }
        try {
            this.callResetListenerOnDatabaseReset = false;
            databaseResetListener.onDatabaseReset(sQLiteDatabase);
        } catch (SQLiteException e) {
            logger.e(TAG, String.format("databaseReset callback failed during onCreate", new Object[0]), e);
        } finally {
            this.callResetListenerOnDatabaseReset = true;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i > i2) {
            logger.e(TAG, "onUpgrade() with invalid oldVersion and newVersion");
            resetDatabase(sQLiteDatabase);
            return;
        }
        if (i2 <= 1) {
            return;
        }
        if (i == 1) {
            sQLiteDatabase.execSQL(CREATE_STORE_TABLE);
            if (i2 <= 2) {
                return;
            }
        } else {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        logger.e(TAG, "onUpgrade() with unknown oldVersion " + i);
                        resetDatabase(sQLiteDatabase);
                        return;
                    }
                    return;
                }
            }
            sQLiteDatabase.execSQL(CREATE_IDENTIFY_INTERCEPTOR_TABLE);
        }
        sQLiteDatabase.execSQL(CREATE_IDENTIFYS_TABLE);
        sQLiteDatabase.execSQL(CREATE_LONG_STORE_TABLE);
        if (i2 <= 3) {
            return;
        }
        sQLiteDatabase.execSQL(CREATE_IDENTIFY_INTERCEPTOR_TABLE);
    }

    private void resetDatabase(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS store");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS long_store");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS identifys");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS identify_interceptor");
        onCreate(sQLiteDatabase);
    }

    synchronized long insertOrReplaceKeyValue(String str, String str2) {
        long jInsertOrReplaceKeyValueToTable;
        try {
            if (str2 == null) {
                jInsertOrReplaceKeyValueToTable = deleteKeyFromTable(STORE_TABLE_NAME, str);
            } else {
                jInsertOrReplaceKeyValueToTable = insertOrReplaceKeyValueToTable(STORE_TABLE_NAME, str, str2);
            }
        } catch (Throwable th) {
            throw th;
        }
        return jInsertOrReplaceKeyValueToTable;
    }

    synchronized long insertOrReplaceKeyLongValue(String str, Long l) {
        long jInsertOrReplaceKeyValueToTable;
        try {
            if (l == null) {
                jInsertOrReplaceKeyValueToTable = deleteKeyFromTable(LONG_STORE_TABLE_NAME, str);
            } else {
                jInsertOrReplaceKeyValueToTable = insertOrReplaceKeyValueToTable(LONG_STORE_TABLE_NAME, str, l);
            }
        } catch (Throwable th) {
            throw th;
        }
        return jInsertOrReplaceKeyValueToTable;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0035 A[Catch: all -> 0x0067, TRY_LEAVE, TryCatch #2 {, blocks: (B:6:0x000c, B:8:0x0012, B:29:0x005d, B:31:0x0063, B:32:0x0066, B:15:0x002f, B:17:0x0035, B:22:0x0050, B:4:0x0002, B:13:0x0019, B:20:0x003a), top: B:37:0x0002, inners: #1 }] */
    synchronized long insertOrReplaceKeyValueToTable(String str, String str2, Object obj) {
        long jInsertOrReplaceKeyValueToTable;
        SQLiteDatabase writableDatabase = null;
        try {
            try {
                writableDatabase = getWritableDatabase();
                jInsertOrReplaceKeyValueToTable = insertOrReplaceKeyValueToTable(writableDatabase, str, str2, obj);
                if (writableDatabase != null && writableDatabase.isOpen()) {
                    close();
                }
            } catch (SQLiteException e) {
                logger.e(TAG, String.format("insertOrReplaceKeyValue in %s failed", str), e);
                delete();
                if (writableDatabase != null && writableDatabase.isOpen()) {
                    close();
                }
                jInsertOrReplaceKeyValueToTable = -1;
            } catch (StackOverflowError e2) {
                logger.e(TAG, String.format("insertOrReplaceKeyValue in %s failed", str), e2);
                delete();
                if (writableDatabase != null && writableDatabase.isOpen()) {
                    close();
                }
                jInsertOrReplaceKeyValueToTable = -1;
            }
        } catch (Throwable th) {
            if (writableDatabase != null && writableDatabase.isOpen()) {
                close();
            }
            throw th;
        }
        return jInsertOrReplaceKeyValueToTable;
    }

    synchronized long insertOrReplaceKeyValueToTable(SQLiteDatabase sQLiteDatabase, String str, String str2, Object obj) throws StackOverflowError, SQLiteException {
        long jInsertKeyValueContentValuesIntoTable;
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", str2);
        if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else {
            contentValues.put("value", (String) obj);
        }
        jInsertKeyValueContentValuesIntoTable = insertKeyValueContentValuesIntoTable(sQLiteDatabase, str, contentValues);
        if (jInsertKeyValueContentValuesIntoTable == -1) {
            logger.w(TAG, "Insert failed");
        }
        return jInsertKeyValueContentValuesIntoTable;
    }

    synchronized long insertKeyValueContentValuesIntoTable(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues) throws StackOverflowError, SQLiteException {
        return sQLiteDatabase.insertWithOnConflict(str, null, contentValues, 5);
    }

    synchronized long deleteKeyFromTable(String str, String str2) {
        long jDelete;
        try {
            jDelete = getWritableDatabase().delete(str, "key=?", new String[]{str2});
        } catch (StackOverflowError e) {
            logger.e(TAG, String.format("deleteKey from %s failed", str), e);
            delete();
            jDelete = -1;
        } catch (SQLiteException e2) {
            logger.e(TAG, String.format("deleteKey from %s failed", str), e2);
            delete();
            jDelete = -1;
        } finally {
            close();
        }
        return jDelete;
    }

    synchronized long addEvent(String str) {
        return addEventToTable("events", str);
    }

    synchronized long addIdentify(String str) {
        return addEventToTable(IDENTIFY_TABLE_NAME, str);
    }

    synchronized long addIdentifyInterceptor(String str) {
        return addEventToTable(IDENTIFY_INTERCEPTOR_TABLE_NAME, str);
    }

    private synchronized long addEventToTable(String str, String str2) {
        long jInsertEventContentValuesIntoTable;
        long j = -1;
        try {
            try {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("event", str2);
                jInsertEventContentValuesIntoTable = insertEventContentValuesIntoTable(writableDatabase, str, contentValues);
                if (jInsertEventContentValuesIntoTable == -1) {
                    try {
                        logger.w(TAG, String.format("Insert into %s failed", str));
                    } catch (SQLiteException e) {
                        e = e;
                        j = jInsertEventContentValuesIntoTable;
                        logger.e(TAG, String.format("addEvent to %s failed", str), e);
                        delete();
                        close();
                        jInsertEventContentValuesIntoTable = j;
                    } catch (StackOverflowError e2) {
                        e = e2;
                        j = jInsertEventContentValuesIntoTable;
                        logger.e(TAG, String.format("addEvent to %s failed", str), e);
                        delete();
                        close();
                        jInsertEventContentValuesIntoTable = j;
                    }
                }
                close();
            } catch (Throwable th) {
                close();
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
        } catch (StackOverflowError e4) {
            e = e4;
        }
        return jInsertEventContentValuesIntoTable;
    }

    synchronized long insertEventContentValuesIntoTable(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues) throws StackOverflowError, SQLiteException {
        return sQLiteDatabase.insert(str, null, contentValues);
    }

    synchronized String getValue(String str) {
        return (String) getValueFromTable(STORE_TABLE_NAME, str);
    }

    synchronized Long getLongValue(String str) {
        return (Long) getValueFromTable(LONG_STORE_TABLE_NAME, str);
    }

    /* JADX WARN: Code duplicated, block: B:43:0x006c A[Catch: all -> 0x0080, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0080, blocks: (B:15:0x0043, B:51:0x007c, B:43:0x006c, B:50:0x0079, B:60:0x009e, B:67:0x00bd, B:74:0x00c8, B:75:0x00cb, B:76:0x00ce), top: B:79:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0079 A[Catch: all -> 0x0080, TRY_ENTER, TryCatch #0 {all -> 0x0080, blocks: (B:15:0x0043, B:51:0x007c, B:43:0x006c, B:50:0x0079, B:60:0x009e, B:67:0x00bd, B:74:0x00c8, B:75:0x00cb, B:76:0x00ce), top: B:79:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x009e A[Catch: all -> 0x0080, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0080, blocks: (B:15:0x0043, B:51:0x007c, B:43:0x006c, B:50:0x0079, B:60:0x009e, B:67:0x00bd, B:74:0x00c8, B:75:0x00cb, B:76:0x00ce), top: B:79:0x0002 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x00bd A[Catch: all -> 0x0080, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0080, blocks: (B:15:0x0043, B:51:0x007c, B:43:0x006c, B:50:0x0079, B:60:0x009e, B:67:0x00bd, B:74:0x00c8, B:75:0x00cb, B:76:0x00ce), top: B:79:0x0002 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    protected synchronized Object getValueFromTable(String str, String str2) {
        Throwable th;
        DatabaseHelper databaseHelper;
        String str3;
        StackOverflowError stackOverflowError;
        Cursor cursorQueryDb;
        RuntimeException runtimeException;
        IllegalStateException illegalStateException;
        SQLiteException sQLiteException;
        ?? r1 = 0;
        string = null;
        string = null;
        string = null;
        string = null;
        string = null;
        string = null;
        string = null;
        string = null;
        Object string = null;
        try {
            try {
                try {
                    databaseHelper = this;
                    str3 = str;
                    try {
                        cursorQueryDb = databaseHelper.queryDb(getReadableDatabase(), str3, new String[]{"key", "value"}, "key = ?", new String[]{str2}, null, null, null, null);
                        try {
                            if (cursorQueryDb.moveToFirst()) {
                                string = str3.equals(STORE_TABLE_NAME) ? cursorQueryDb.getString(1) : Long.valueOf(cursorQueryDb.getLong(1));
                            }
                            if (cursorQueryDb != null) {
                                cursorQueryDb.close();
                            }
                        } catch (SQLiteException e) {
                            sQLiteException = e;
                            logger.e(TAG, String.format("getValue from %s failed", str3), sQLiteException);
                            databaseHelper.delete();
                            if (cursorQueryDb != null) {
                                cursorQueryDb.close();
                            }
                        } catch (IllegalStateException e2) {
                            illegalStateException = e2;
                            databaseHelper.handleIfCursorRowTooLargeException(illegalStateException);
                            if (cursorQueryDb != null) {
                                cursorQueryDb.close();
                            }
                        } catch (RuntimeException e3) {
                            runtimeException = e3;
                            convertIfCursorWindowException(runtimeException);
                            if (cursorQueryDb != null) {
                                cursorQueryDb.close();
                            }
                        } catch (StackOverflowError e4) {
                            stackOverflowError = e4;
                            logger.e(TAG, String.format("getValue from %s failed", str3), stackOverflowError);
                            databaseHelper.delete();
                            if (cursorQueryDb != null) {
                                cursorQueryDb.close();
                            }
                        }
                    } catch (SQLiteException e5) {
                        e = e5;
                        sQLiteException = e;
                        cursorQueryDb = null;
                        logger.e(TAG, String.format("getValue from %s failed", str3), sQLiteException);
                        databaseHelper.delete();
                        if (cursorQueryDb != null) {
                            cursorQueryDb.close();
                        }
                        databaseHelper.close();
                        return string;
                    } catch (IllegalStateException e6) {
                        e = e6;
                        illegalStateException = e;
                        cursorQueryDb = null;
                        databaseHelper.handleIfCursorRowTooLargeException(illegalStateException);
                        if (cursorQueryDb != null) {
                            cursorQueryDb.close();
                        }
                        databaseHelper.close();
                        return string;
                    } catch (RuntimeException e7) {
                        e = e7;
                        runtimeException = e;
                        cursorQueryDb = null;
                        convertIfCursorWindowException(runtimeException);
                        if (cursorQueryDb != null) {
                            cursorQueryDb.close();
                        }
                        databaseHelper.close();
                        return string;
                    } catch (StackOverflowError e8) {
                        e = e8;
                        stackOverflowError = e;
                        cursorQueryDb = null;
                        logger.e(TAG, String.format("getValue from %s failed", str3), stackOverflowError);
                        databaseHelper.delete();
                        if (cursorQueryDb != null) {
                            cursorQueryDb.close();
                        }
                        databaseHelper.close();
                        return string;
                    } catch (Throwable th2) {
                        th = th2;
                        th = th;
                        if (r1 != 0) {
                            r1.close();
                        }
                        databaseHelper.close();
                        throw th;
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            } catch (SQLiteException e9) {
                e = e9;
                databaseHelper = this;
                str3 = str;
            } catch (IllegalStateException e10) {
                e = e10;
                databaseHelper = this;
            } catch (RuntimeException e11) {
                e = e11;
                databaseHelper = this;
            } catch (StackOverflowError e12) {
                e = e12;
                databaseHelper = this;
                str3 = str;
            } catch (Throwable th4) {
                th = th4;
                databaseHelper = this;
            }
            databaseHelper.close();
            return string;
        } catch (Throwable th5) {
            th = th5;
            r1 = this;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0011: MONITOR_EXIT (r1 I:??[OBJECT, ARRAY]) A[Catch: all -> 0x000c, TRY_ENTER, TRY_LEAVE], block:B:13:0x0011 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    synchronized List<JSONObject> getEvents(long j, long j2) throws JSONException {
        Object obj;
        try {
        } catch (Throwable th) {
            throw th;
        }
        return getEventsFromTable("events", j, j2);
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0011: MONITOR_EXIT (r1 I:??[OBJECT, ARRAY]) A[Catch: all -> 0x000c, TRY_ENTER, TRY_LEAVE], block:B:13:0x0011 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    synchronized List<JSONObject> getIdentifys(long j, long j2) throws JSONException {
        Object obj;
        try {
        } catch (Throwable th) {
            throw th;
        }
        return getEventsFromTable(IDENTIFY_TABLE_NAME, j, j2);
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0011: MONITOR_EXIT (r1 I:??[OBJECT, ARRAY]) A[Catch: all -> 0x000c, TRY_ENTER, TRY_LEAVE], block:B:13:0x0011 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    synchronized List<JSONObject> getIdentifyInterceptors(long j, long j2) throws JSONException {
        Object obj;
        try {
        } catch (Throwable th) {
            throw th;
        }
        return getEventsFromTable(IDENTIFY_INTERCEPTOR_TABLE_NAME, j, j2);
    }

    protected synchronized List<JSONObject> getEventsFromTable(String str, long j, long j2) throws JSONException {
        LinkedList linkedList;
        linkedList = new LinkedList();
        Cursor cursorQueryDb = null;
        try {
            try {
                try {
                    try {
                        cursorQueryDb = queryDb(getReadableDatabase(), str, new String[]{"id", "event"}, j >= 0 ? "id <= " + j : null, null, null, null, "id ASC", j2 >= 0 ? "" + j2 : null);
                        while (cursorQueryDb.moveToNext()) {
                            long j3 = cursorQueryDb.getLong(0);
                            String string = cursorQueryDb.getString(1);
                            if (!Utils.isEmptyString(string)) {
                                JSONObject jSONObject = new JSONObject(string);
                                jSONObject.put(BoxEvent.FIELD_EVENT_ID, j3);
                                linkedList.add(jSONObject);
                            }
                        }
                        if (cursorQueryDb != null) {
                            cursorQueryDb.close();
                        }
                    } catch (SQLiteException e) {
                        logger.e(TAG, String.format("getEvents from %s failed", str), e);
                        delete();
                        if (cursorQueryDb != null) {
                            cursorQueryDb.close();
                        }
                    }
                } catch (StackOverflowError e2) {
                    logger.e(TAG, String.format("getEvents from %s failed", str), e2);
                    delete();
                    if (cursorQueryDb != null) {
                        cursorQueryDb.close();
                    }
                }
            } catch (IllegalStateException e3) {
                handleIfCursorRowTooLargeException(e3);
                if (cursorQueryDb != null) {
                    cursorQueryDb.close();
                }
            } catch (RuntimeException e4) {
                convertIfCursorWindowException(e4);
                if (cursorQueryDb != null) {
                    cursorQueryDb.close();
                }
            }
            close();
        } catch (Throwable th) {
            if (cursorQueryDb != null) {
                cursorQueryDb.close();
            }
            close();
            throw th;
        }
        return linkedList;
    }

    synchronized long getEventCount() {
        return getEventCountFromTable("events");
    }

    synchronized long getIdentifyCount() {
        return getEventCountFromTable(IDENTIFY_TABLE_NAME);
    }

    synchronized long getTotalEventCount() {
        return getEventCount() + getIdentifyCount();
    }

    synchronized long getIdentifyInterceptorCount() {
        return getEventCountFromTable(IDENTIFY_INTERCEPTOR_TABLE_NAME);
    }

    private synchronized long getEventCountFromTable(String str) {
        long jSimpleQueryForLong;
        SQLiteStatement sQLiteStatementCompileStatement = null;
        try {
            sQLiteStatementCompileStatement = getReadableDatabase().compileStatement("SELECT COUNT(*) FROM " + str);
            jSimpleQueryForLong = sQLiteStatementCompileStatement.simpleQueryForLong();
        } catch (SQLiteException e) {
            logger.e(TAG, String.format("getNumberRows for %s failed", str), e);
            delete();
            jSimpleQueryForLong = 0;
        } catch (StackOverflowError e2) {
            logger.e(TAG, String.format("getNumberRows for %s failed", str), e2);
            delete();
            jSimpleQueryForLong = 0;
        } finally {
            if (sQLiteStatementCompileStatement != null) {
                sQLiteStatementCompileStatement.close();
            }
            close();
        }
        return jSimpleQueryForLong;
    }

    synchronized long getNthEventId(long j) {
        return getNthEventIdFromTable("events", j);
    }

    synchronized long getNthIdentifyId(long j) {
        return getNthEventIdFromTable(IDENTIFY_TABLE_NAME, j);
    }

    synchronized long getLastIdentifyInterceptorId() {
        return getNthEventIdFromTable(IDENTIFY_INTERCEPTOR_TABLE_NAME, 1L, BoxOrder.DIRECTION_DESCENDING);
    }

    private synchronized long getNthEventIdFromTable(String str, long j) {
        return getNthEventIdFromTable(str, j, BoxOrder.DIRECTION_ASCENDING);
    }

    private synchronized long getNthEventIdFromTable(String str, long j, String str2) {
        long jSimpleQueryForLong;
        jSimpleQueryForLong = -1;
        SQLiteStatement sQLiteStatement = null;
        try {
            try {
                SQLiteStatement sQLiteStatementCompileStatement = getReadableDatabase().compileStatement("SELECT id FROM " + str + " ORDER BY id " + str2 + " LIMIT 1 OFFSET " + (j - 1));
                try {
                    jSimpleQueryForLong = sQLiteStatementCompileStatement.simpleQueryForLong();
                } catch (SQLiteDoneException e) {
                    logger.w(TAG, e);
                }
                if (sQLiteStatementCompileStatement != null) {
                    sQLiteStatementCompileStatement.close();
                }
            } catch (SQLiteException e2) {
                logger.e(TAG, String.format("getNthEventId from %s failed", str), e2);
                delete();
                if (0 != 0) {
                    sQLiteStatement.close();
                }
            } catch (StackOverflowError e3) {
                logger.e(TAG, String.format("getNthEventId from %s failed", str), e3);
                delete();
                if (0 != 0) {
                    sQLiteStatement.close();
                }
            }
            close();
        } catch (Throwable th) {
            if (0 != 0) {
                sQLiteStatement.close();
            }
            close();
            throw th;
        }
        return jSimpleQueryForLong;
    }

    synchronized void removeEvents(long j) {
        removeEventsFromTable("events", j);
    }

    synchronized void removeIdentifys(long j) {
        removeEventsFromTable(IDENTIFY_TABLE_NAME, j);
    }

    synchronized void removeIdentifyInterceptors(long j) {
        removeEventsFromTable(IDENTIFY_INTERCEPTOR_TABLE_NAME, j);
    }

    private synchronized void removeEventsFromTable(String str, long j) {
        try {
            try {
                getWritableDatabase().delete(str, "id <= " + j, null);
            } catch (SQLiteException e) {
                logger.e(TAG, String.format("removeEvents from %s failed", str), e);
                delete();
            } catch (StackOverflowError e2) {
                logger.e(TAG, String.format("removeEvents from %s failed", str), e2);
                delete();
            }
            close();
        } catch (Throwable th) {
            close();
            throw th;
        }
    }

    synchronized void removeEvent(long j) {
        removeEventFromTable("events", j);
    }

    synchronized void removeIdentify(long j) {
        removeEventFromTable(IDENTIFY_TABLE_NAME, j);
    }

    synchronized void removeIdentifyIntercept(long j) {
        removeEventFromTable(IDENTIFY_INTERCEPTOR_TABLE_NAME, j);
    }

    private synchronized void removeEventFromTable(String str, long j) {
        try {
            try {
                getWritableDatabase().delete(str, "id = " + j, null);
            } catch (SQLiteException e) {
                logger.e(TAG, String.format("removeEvent from %s failed", str), e);
                delete();
            } catch (StackOverflowError e2) {
                logger.e(TAG, String.format("removeEvent from %s failed", str), e2);
                delete();
            }
            close();
        } catch (Throwable th) {
            close();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002a A[DONT_GENERATE, PHI: r0 r1 r2
      0x002a: PHI (r0v12 ??) = (r0v17 ??), (r0v18 ??), (r0v19 ??), (r0v20 ??) binds: [B:52:0x009a, B:43:0x007f, B:22:0x0047, B:13:0x0028] A[DONT_GENERATE, DONT_INLINE]
      0x002a: PHI (r1v12 android.database.sqlite.SQLiteDatabase) = 
      (r1v1 android.database.sqlite.SQLiteDatabase)
      (r1v2 android.database.sqlite.SQLiteDatabase)
      (r1v15 android.database.sqlite.SQLiteDatabase)
      (r1v16 android.database.sqlite.SQLiteDatabase)
     binds: [B:52:0x009a, B:43:0x007f, B:22:0x0047, B:13:0x0028] A[DONT_GENERATE, DONT_INLINE]
      0x002a: PHI (r2v6 ??) = 
      (r2v19 ??)
      (r2v11 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY])
      (r2v20 ??)
      (r2v17 ?? I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY])
     binds: [B:52:0x009a, B:43:0x007f, B:22:0x0047, B:13:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:71:0x00c9 A[DONT_GENERATE] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v16, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.amplitude.api.AmplitudeLog] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void delete() {
        boolean zIsOpen;
        boolean zIsOpen2;
        ?? r0;
        ?? IsOpen = "databaseReset callback failed during delete";
        SQLiteDatabase writableDatabase = null;
        int i = 0;
        i = 0;
         = 0;
        i = 0;
        i = 0;
        i = 0;
        i = 0;
        i = 0;
        ?? r2 = 0;
        i = 0;
        i = 0;
        i = 0;
        try {
            try {
                close();
                this.file.delete();
                if (this.databaseResetListener != null && this.callResetListenerOnDatabaseReset) {
                    this.callResetListenerOnDatabaseReset = false;
                    try {
                        writableDatabase = getWritableDatabase();
                        this.databaseResetListener.onDatabaseReset(writableDatabase);
                    } catch (SQLiteException e) {
                        ?? r5 = logger;
                        String str = TAG;
                        i = new Object[0];
                        IsOpen = String.format("databaseReset callback failed during delete", i);
                        r5.e(str, IsOpen, e);
                        r0 = IsOpen;
                        r2 = i;
                        r0 = IsOpen;
                    } finally {
                        this.callResetListenerOnDatabaseReset = true;
                        if (writableDatabase != null && writableDatabase.isOpen()) {
                            close();
                        }
                    }
                }
            } catch (SecurityException e2) {
                logger.e(TAG, "delete failed", e2);
                if (this.databaseResetListener != null && this.callResetListenerOnDatabaseReset) {
                    this.callResetListenerOnDatabaseReset = false;
                    try {
                        writableDatabase = getWritableDatabase();
                        this.databaseResetListener.onDatabaseReset(writableDatabase);
                    } catch (SQLiteException e3) {
                        AmplitudeLog amplitudeLog = logger;
                        String str2 = TAG;
                        Object[] objArr = new Object[0];
                        String str3 = String.format("databaseReset callback failed during delete", objArr);
                        amplitudeLog.e(str2, str3, e3);
                        r0 = zIsOpen;
                        r2 = objArr;
                        IsOpen = zIsOpen;
                        i = objArr;
                        r0 = zIsOpen2;
                        IsOpen = zIsOpen2;
                    } finally {
                        this.callResetListenerOnDatabaseReset = true;
                        if (writableDatabase != null && writableDatabase.isOpen()) {
                            close();
                        }
                    }
                }
                r0 = IsOpen;
                r2 = i;
                r0 = IsOpen;
            }
            r0 = IsOpen;
            r2 = i;
            r0 = IsOpen;
        } catch (Throwable th) {
            if (this.databaseResetListener != null && this.callResetListenerOnDatabaseReset) {
                this.callResetListenerOnDatabaseReset = i;
                try {
                    writableDatabase = getWritableDatabase();
                    this.databaseResetListener.onDatabaseReset(writableDatabase);
                } catch (SQLiteException e4) {
                    logger.e(TAG, String.format(IsOpen, new Object[i]), e4);
                } finally {
                    this.callResetListenerOnDatabaseReset = true;
                    if (writableDatabase != null && writableDatabase.isOpen()) {
                        close();
                    }
                }
            }
            throw th;
        }
    }

    boolean dbFileExists() {
        return this.file.exists();
    }

    Cursor queryDb(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
    }

    private void handleIfCursorRowTooLargeException(IllegalStateException illegalStateException) {
        String message = illegalStateException.getMessage();
        if (!Utils.isEmptyString(message) && message.contains("Couldn't read") && message.contains("CursorWindow")) {
            delete();
            return;
        }
        throw illegalStateException;
    }

    private static void convertIfCursorWindowException(RuntimeException runtimeException) {
        String message = runtimeException.getMessage();
        if (Utils.isEmptyString(message)) {
            throw runtimeException;
        }
        if (message.startsWith("Cursor window allocation of") || message.startsWith("Could not allocate CursorWindow")) {
            throw new CursorWindowAllocationException(message);
        }
        throw runtimeException;
    }
}
