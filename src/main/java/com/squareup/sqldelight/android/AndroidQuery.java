package com.squareup.sqldelight.android;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: compiled from: AndroidSqliteDriver.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001a\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001f\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0002\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\u001a\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\rH\u0016J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\bH\u0016J\b\u0010%\u001a\u00020\u0004H\u0016J\b\u0010&\u001a\u00020\u0004H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\n\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/squareup/sqldelight/android/AndroidQuery;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "Lcom/squareup/sqldelight/android/AndroidStatement;", "sql", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "argCount", "", "(Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteDatabase;I)V", "binds", "", "Lkotlin/Function1;", "Landroidx/sqlite/db/SupportSQLiteProgram;", "", "bindBytes", FirebaseAnalytics.Param.INDEX, "bytes", "", "bindDouble", "double", "", "(ILjava/lang/Double;)V", "bindLong", "long", "", "(ILjava/lang/Long;)V", "bindString", "string", "bindTo", "statement", HeaderElements.CLOSE, "execute", "", "executeQuery", "Lcom/squareup/sqldelight/android/AndroidCursor;", "getArgCount", "getSql", "toString", "sqldelight-android-driver_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class AndroidQuery implements SupportSQLiteQuery, AndroidStatement {
    private final int argCount;
    private final Map<Integer, Function1<SupportSQLiteProgram, Unit>> binds;
    private final SupportSQLiteDatabase database;
    private final String sql;

    @Override // com.squareup.sqldelight.android.AndroidStatement
    public void close() {
    }

    public AndroidQuery(String sql, SupportSQLiteDatabase database, int i) {
        Intrinsics.checkNotNullParameter(sql, "sql");
        Intrinsics.checkNotNullParameter(database, "database");
        this.sql = sql;
        this.database = database;
        this.argCount = i;
        this.binds = new LinkedHashMap();
    }

    @Override // com.squareup.sqldelight.db.SqlPreparedStatement
    public void bindBytes(final int index, final byte[] bytes) {
        this.binds.put(Integer.valueOf(index), new Function1<SupportSQLiteProgram, Unit>() { // from class: com.squareup.sqldelight.android.AndroidQuery.bindBytes.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SupportSQLiteProgram supportSQLiteProgram) {
                invoke2(supportSQLiteProgram);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SupportSQLiteProgram it) {
                Intrinsics.checkNotNullParameter(it, "it");
                byte[] bArr = bytes;
                int i = index;
                if (bArr == null) {
                    it.bindNull(i);
                } else {
                    it.bindBlob(i, bArr);
                }
            }
        });
    }

    @Override // com.squareup.sqldelight.db.SqlPreparedStatement
    public void bindLong(final int index, final Long l) {
        this.binds.put(Integer.valueOf(index), new Function1<SupportSQLiteProgram, Unit>() { // from class: com.squareup.sqldelight.android.AndroidQuery.bindLong.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SupportSQLiteProgram supportSQLiteProgram) {
                invoke2(supportSQLiteProgram);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SupportSQLiteProgram it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Long l2 = l;
                int i = index;
                if (l2 == null) {
                    it.bindNull(i);
                } else {
                    it.bindLong(i, l2.longValue());
                }
            }
        });
    }

    @Override // com.squareup.sqldelight.db.SqlPreparedStatement
    public void bindDouble(final int index, final Double d) {
        this.binds.put(Integer.valueOf(index), new Function1<SupportSQLiteProgram, Unit>() { // from class: com.squareup.sqldelight.android.AndroidQuery.bindDouble.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SupportSQLiteProgram supportSQLiteProgram) {
                invoke2(supportSQLiteProgram);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SupportSQLiteProgram it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Double d2 = d;
                int i = index;
                if (d2 == null) {
                    it.bindNull(i);
                } else {
                    it.bindDouble(i, d2.doubleValue());
                }
            }
        });
    }

    @Override // com.squareup.sqldelight.db.SqlPreparedStatement
    public void bindString(final int index, final String string) {
        this.binds.put(Integer.valueOf(index), new Function1<SupportSQLiteProgram, Unit>() { // from class: com.squareup.sqldelight.android.AndroidQuery.bindString.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SupportSQLiteProgram supportSQLiteProgram) {
                invoke2(supportSQLiteProgram);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SupportSQLiteProgram it) {
                Intrinsics.checkNotNullParameter(it, "it");
                String str = string;
                int i = index;
                if (str == null) {
                    it.bindNull(i);
                } else {
                    it.bindString(i, str);
                }
            }
        });
    }

    @Override // com.squareup.sqldelight.android.AndroidStatement
    /* JADX INFO: renamed from: execute, reason: merged with bridge method [inline-methods] */
    public Void mo14351execute() {
        throw new UnsupportedOperationException();
    }

    @Override // com.squareup.sqldelight.android.AndroidStatement
    public AndroidCursor executeQuery() {
        Cursor cursorQuery = this.database.query(this);
        Intrinsics.checkNotNullExpressionValue(cursorQuery, "database.query(this)");
        return new AndroidCursor(cursorQuery);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram statement) {
        Intrinsics.checkNotNullParameter(statement, "statement");
        Iterator<Function1<SupportSQLiteProgram, Unit>> it = this.binds.values().iterator();
        while (it.hasNext()) {
            it.next().invoke(statement);
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        return this.sql;
    }

    public String toString() {
        return this.sql;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        return this.argCount;
    }
}
