package com.squareup.sqldelight.db;

import com.google.firebase.analytics.FirebaseAnalytics;
import external.sdk.pendo.io.mozilla.javascript.ES6Iterator;
import java.io.Closeable;
import kotlin.Metadata;

/* JADX INFO: compiled from: SqlCursor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00060\u0001j\u0002`\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H&¢\u0006\u0002\u0010\tJ\u0017\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H&¢\u0006\u0002\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0011"}, d2 = {"Lcom/squareup/sqldelight/db/SqlCursor;", "Ljava/io/Closeable;", "Lcom/squareup/sqldelight/db/Closeable;", "getBytes", "", FirebaseAnalytics.Param.INDEX, "", "getDouble", "", "(I)Ljava/lang/Double;", "getLong", "", "(I)Ljava/lang/Long;", "getString", "", ES6Iterator.NEXT_METHOD, "", "runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface SqlCursor extends Closeable {
    byte[] getBytes(int index);

    Double getDouble(int index);

    Long getLong(int index);

    String getString(int index);

    boolean next();
}
