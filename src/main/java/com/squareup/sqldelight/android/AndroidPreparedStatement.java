package com.squareup.sqldelight.android;

import androidx.sqlite.db.SupportSQLiteStatement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.sqldelight.db.SqlCursor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: compiled from: AndroidSqliteDriver.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\rJ\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0010J\u001a\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/squareup/sqldelight/android/AndroidPreparedStatement;", "Lcom/squareup/sqldelight/android/AndroidStatement;", "statement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "(Landroidx/sqlite/db/SupportSQLiteStatement;)V", "bindBytes", "", FirebaseAnalytics.Param.INDEX, "", "value", "", "bindDouble", "", "(ILjava/lang/Double;)V", "bindLong", "", "(ILjava/lang/Long;)V", "bindString", "", HeaderElements.CLOSE, "execute", "executeQuery", "", "sqldelight-android-driver_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class AndroidPreparedStatement implements AndroidStatement {
    private final SupportSQLiteStatement statement;

    public AndroidPreparedStatement(SupportSQLiteStatement statement) {
        Intrinsics.checkNotNullParameter(statement, "statement");
        this.statement = statement;
    }

    @Override // com.squareup.sqldelight.android.AndroidStatement
    public /* bridge */ /* synthetic */ SqlCursor executeQuery() {
        return (SqlCursor) m14350executeQuery();
    }

    @Override // com.squareup.sqldelight.db.SqlPreparedStatement
    public void bindBytes(int index, byte[] value) {
        SupportSQLiteStatement supportSQLiteStatement = this.statement;
        if (value == null) {
            supportSQLiteStatement.bindNull(index);
        } else {
            supportSQLiteStatement.bindBlob(index, value);
        }
    }

    @Override // com.squareup.sqldelight.db.SqlPreparedStatement
    public void bindLong(int index, Long value) {
        SupportSQLiteStatement supportSQLiteStatement = this.statement;
        if (value == null) {
            supportSQLiteStatement.bindNull(index);
        } else {
            supportSQLiteStatement.bindLong(index, value.longValue());
        }
    }

    @Override // com.squareup.sqldelight.db.SqlPreparedStatement
    public void bindDouble(int index, Double value) {
        SupportSQLiteStatement supportSQLiteStatement = this.statement;
        if (value == null) {
            supportSQLiteStatement.bindNull(index);
        } else {
            supportSQLiteStatement.bindDouble(index, value.doubleValue());
        }
    }

    @Override // com.squareup.sqldelight.db.SqlPreparedStatement
    public void bindString(int index, String value) {
        SupportSQLiteStatement supportSQLiteStatement = this.statement;
        if (value == null) {
            supportSQLiteStatement.bindNull(index);
        } else {
            supportSQLiteStatement.bindString(index, value);
        }
    }

    /* JADX INFO: renamed from: executeQuery, reason: collision with other method in class */
    public Void m14350executeQuery() {
        throw new UnsupportedOperationException();
    }

    @Override // com.squareup.sqldelight.android.AndroidStatement
    /* JADX INFO: renamed from: execute */
    public void mo14351execute() {
        this.statement.execute();
    }

    @Override // com.squareup.sqldelight.android.AndroidStatement
    public void close() {
        this.statement.close();
    }
}
