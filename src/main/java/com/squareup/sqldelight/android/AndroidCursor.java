package com.squareup.sqldelight.android;

import android.database.Cursor;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.sqldelight.db.SqlCursor;
import external.sdk.pendo.io.mozilla.javascript.ES6Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: compiled from: AndroidSqliteDriver.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0017\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\rJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/squareup/sqldelight/android/AndroidCursor;", "Lcom/squareup/sqldelight/db/SqlCursor;", "cursor", "Landroid/database/Cursor;", "(Landroid/database/Cursor;)V", HeaderElements.CLOSE, "", "getBytes", "", FirebaseAnalytics.Param.INDEX, "", "getDouble", "", "(I)Ljava/lang/Double;", "getLong", "", "(I)Ljava/lang/Long;", "getString", "", ES6Iterator.NEXT_METHOD, "", "sqldelight-android-driver_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class AndroidCursor implements SqlCursor {
    private final Cursor cursor;

    public AndroidCursor(Cursor cursor) {
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        this.cursor = cursor;
    }

    @Override // com.squareup.sqldelight.db.SqlCursor
    public boolean next() {
        return this.cursor.moveToNext();
    }

    @Override // com.squareup.sqldelight.db.SqlCursor
    public String getString(int index) {
        if (this.cursor.isNull(index)) {
            return null;
        }
        return this.cursor.getString(index);
    }

    @Override // com.squareup.sqldelight.db.SqlCursor
    public Long getLong(int index) {
        if (this.cursor.isNull(index)) {
            return null;
        }
        return Long.valueOf(this.cursor.getLong(index));
    }

    @Override // com.squareup.sqldelight.db.SqlCursor
    public byte[] getBytes(int index) {
        if (this.cursor.isNull(index)) {
            return null;
        }
        return this.cursor.getBlob(index);
    }

    @Override // com.squareup.sqldelight.db.SqlCursor
    public Double getDouble(int index) {
        if (this.cursor.isNull(index)) {
            return null;
        }
        return Double.valueOf(this.cursor.getDouble(index));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.cursor.close();
    }
}
