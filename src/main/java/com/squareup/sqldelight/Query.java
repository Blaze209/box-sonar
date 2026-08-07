package com.squareup.sqldelight;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.squareup.sqldelight.db.SqlCursor;
import com.squareup.sqldelight.internal.FunctionsJvmKt;
import com.squareup.sqldelight.internal.QueryLock;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Query.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\b&\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0002:\u0001\u001aB+\u0012\u0010\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fJ\b\u0010\u0012\u001a\u00020\u0007H&J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014J\u000b\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u0016J\r\u0010\u0017\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0016J\u0006\u0010\u0018\u001a\u00020\u0010J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/squareup/sqldelight/Query;", "RowType", "", "queries", "", "mapper", "Lkotlin/Function1;", "Lcom/squareup/sqldelight/db/SqlCursor;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "listenerLock", "Lcom/squareup/sqldelight/internal/QueryLock;", "listeners", "Lcom/squareup/sqldelight/Query$Listener;", "getMapper", "()Lkotlin/jvm/functions/Function1;", "addListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "execute", "executeAsList", "", "executeAsOne", "()Ljava/lang/Object;", "executeAsOneOrNull", "notifyDataChanged", "removeListener", "Listener", "runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class Query<RowType> {
    private final QueryLock listenerLock;
    private final List<Listener> listeners;
    private final Function1<SqlCursor, RowType> mapper;
    private final List<Query<?>> queries;

    /* JADX INFO: compiled from: Query.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/squareup/sqldelight/Query$Listener;", "", "queryResultsChanged", "", "runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface Listener {
        void queryResultsChanged();
    }

    public abstract SqlCursor execute();

    /* JADX WARN: Multi-variable type inference failed */
    public Query(List<Query<?>> queries, Function1<? super SqlCursor, ? extends RowType> mapper) {
        Intrinsics.checkNotNullParameter(queries, "queries");
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        this.queries = queries;
        this.mapper = mapper;
        this.listenerLock = new QueryLock();
        this.listeners = FunctionsJvmKt.copyOnWriteListGeneric();
    }

    public final Function1<SqlCursor, RowType> getMapper() {
        return this.mapper;
    }

    public final void notifyDataChanged() {
        synchronized (this.listenerLock) {
            Iterator<T> it = this.listeners.iterator();
            while (it.hasNext()) {
                ((Listener) it.next()).queryResultsChanged();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void addListener(Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.listenerLock) {
            if (this.listeners.isEmpty()) {
                this.queries.add(this);
            }
            this.listeners.add(listener);
        }
    }

    public final void removeListener(Listener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this.listenerLock) {
            this.listeners.remove(listener);
            if (this.listeners.isEmpty()) {
                this.queries.remove(this);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final List<RowType> executeAsList() throws IOException {
        ArrayList arrayList = new ArrayList();
        SqlCursor sqlCursorExecute = execute();
        try {
            SqlCursor sqlCursor = sqlCursorExecute;
            while (sqlCursor.next()) {
                arrayList.add(getMapper().invoke(sqlCursor));
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(sqlCursorExecute, null);
            return arrayList;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(sqlCursorExecute, th);
                throw th2;
            }
        }
    }

    public final RowType executeAsOne() throws IOException {
        RowType rowtypeExecuteAsOneOrNull = executeAsOneOrNull();
        if (rowtypeExecuteAsOneOrNull != null) {
            return rowtypeExecuteAsOneOrNull;
        }
        throw new NullPointerException(Intrinsics.stringPlus("ResultSet returned null for ", this));
    }

    public final RowType executeAsOneOrNull() throws IOException {
        SqlCursor sqlCursorExecute = execute();
        try {
            SqlCursor sqlCursor = sqlCursorExecute;
            if (!sqlCursor.next()) {
                CloseableKt.closeFinally(sqlCursorExecute, null);
                return null;
            }
            RowType rowtypeInvoke = getMapper().invoke(sqlCursor);
            if (sqlCursor.next()) {
                throw new IllegalStateException(Intrinsics.stringPlus("ResultSet returned more than 1 row for ", this).toString());
            }
            CloseableKt.closeFinally(sqlCursorExecute, null);
            return rowtypeInvoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(sqlCursorExecute, th);
                throw th2;
            }
        }
    }
}
