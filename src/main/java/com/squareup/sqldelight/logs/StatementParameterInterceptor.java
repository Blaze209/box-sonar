package com.squareup.sqldelight.logs;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.sqldelight.db.SqlPreparedStatement;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: LogSqliteDriver.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001f\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010\u0013J\u001a\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0018R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/squareup/sqldelight/logs/StatementParameterInterceptor;", "Lcom/squareup/sqldelight/db/SqlPreparedStatement;", "()V", "values", "", "", "bindBytes", "", FirebaseAnalytics.Param.INDEX, "", "bytes", "", "bindDouble", "double", "", "(ILjava/lang/Double;)V", "bindLong", "long", "", "(ILjava/lang/Long;)V", "bindString", "string", "", "getAndClearParameters", "", "runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class StatementParameterInterceptor implements SqlPreparedStatement {
    private final List<Object> values = new ArrayList();

    @Override // com.squareup.sqldelight.db.SqlPreparedStatement
    public void bindBytes(int index, byte[] bytes) {
        this.values.add(bytes);
    }

    @Override // com.squareup.sqldelight.db.SqlPreparedStatement
    public void bindDouble(int index, Double d) {
        this.values.add(d);
    }

    @Override // com.squareup.sqldelight.db.SqlPreparedStatement
    public void bindLong(int index, Long l) {
        this.values.add(l);
    }

    @Override // com.squareup.sqldelight.db.SqlPreparedStatement
    public void bindString(int index, String string) {
        this.values.add(string);
    }

    public final List<Object> getAndClearParameters() {
        List<Object> list = CollectionsKt.toList(this.values);
        this.values.clear();
        return list;
    }
}
