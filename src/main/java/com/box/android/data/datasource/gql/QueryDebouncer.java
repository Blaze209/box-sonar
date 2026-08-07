package com.box.android.data.datasource.gql;

import com.apollographql.apollo3.api.Query;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedFactory;
import dagger.assisted.AssistedInject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: QueryDebouncer.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0002\u0017\u0018B\u001d\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\f\u001a\u00020\r\"\b\b\u0000\u0010\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0011J\u001e\u0010\u0012\u001a\u00020\u0013\"\b\b\u0000\u0010\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0011J\u001e\u0010\u0014\u001a\u00020\u0013\"\b\b\u0000\u0010\u000e*\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0011J \u0010\u0016\u001a\u00020\r\"\b\b\u0000\u0010\u000e*\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/box/android/data/datasource/gql/QueryDebouncer;", "", "exclusionPeriod", "", "dateProvider", "Lcom/box/android/data/datasource/gql/DateProviding;", "<init>", "(ILcom/box/android/data/datasource/gql/DateProviding;)V", "map", "", "Lcom/box/android/data/datasource/gql/AnyOperation;", "Lcom/box/android/data/datasource/gql/DebounceTimestamp;", "requestExecution", "", "D", "Lcom/apollographql/apollo3/api/Query$Data;", "query", "Lcom/apollographql/apollo3/api/Query;", "reportCompletion", "", "reportFailure", "queryCall", "isOkToExecute", "Factory", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class QueryDebouncer {
    public static final int DEFAULT_EXCLUSION_PERIOD = 180;
    private final DateProviding dateProvider;
    private final int exclusionPeriod;
    private Map<AnyOperation, DebounceTimestamp> map;

    @AssistedInject
    public QueryDebouncer(@Assisted int i, @Assisted DateProviding dateProvider) {
        Intrinsics.checkNotNullParameter(dateProvider, "dateProvider");
        this.exclusionPeriod = i;
        this.dateProvider = dateProvider;
        this.map = new LinkedHashMap();
    }

    /* JADX INFO: compiled from: QueryDebouncer.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/datasource/gql/QueryDebouncer$Factory;", "", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/box/android/data/datasource/gql/QueryDebouncer;", "exclusionPeriod", "", "dateProvider", "Lcom/box/android/data/datasource/gql/DateProviding;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @AssistedFactory
    public interface Factory {
        QueryDebouncer create(int exclusionPeriod, DateProviding dateProvider);

        /* JADX INFO: compiled from: QueryDebouncer.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final class DefaultImpls {
        }

        static /* synthetic */ QueryDebouncer create$default(Factory factory, int i, DateProviding dateProviding, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: create");
            }
            if ((i2 & 1) != 0) {
                i = 180;
            }
            if ((i2 & 2) != 0) {
                dateProviding = new DefaultDateProvider();
            }
            return factory.create(i, dateProviding);
        }
    }

    public final synchronized <D extends Query.Data> boolean requestExecution(Query<D> query) {
        boolean zIsOkToExecute;
        Intrinsics.checkNotNullParameter(query, "query");
        zIsOkToExecute = isOkToExecute(query);
        if (zIsOkToExecute) {
            this.map.put(AnyOperation.INSTANCE.initWithQueryCall(query), DebounceTimestamp.Executing.INSTANCE);
        }
        return zIsOkToExecute;
    }

    public final synchronized <D extends Query.Data> void reportCompletion(Query<D> query) {
        Intrinsics.checkNotNullParameter(query, "query");
        this.map.put(AnyOperation.INSTANCE.initWithQueryCall(query), new DebounceTimestamp.RecentlySucceeded(this.dateProvider.currentDate()));
    }

    public final synchronized <D extends Query.Data> void reportFailure(Query<D> queryCall) {
        Intrinsics.checkNotNullParameter(queryCall, "queryCall");
        this.map.remove(AnyOperation.INSTANCE.initWithQueryCall(queryCall));
    }

    private final <D extends Query.Data> boolean isOkToExecute(Query<D> queryCall) {
        AnyOperation anyOperationInitWithQueryCall = AnyOperation.INSTANCE.initWithQueryCall(queryCall);
        DebounceTimestamp debounceTimestamp = this.map.get(anyOperationInitWithQueryCall);
        if (debounceTimestamp instanceof DebounceTimestamp.Executing) {
            return false;
        }
        if (!(debounceTimestamp instanceof DebounceTimestamp.RecentlySucceeded)) {
            return true;
        }
        boolean z = this.dateProvider.currentDate().getTime() - ((DebounceTimestamp.RecentlySucceeded) debounceTimestamp).getTimestamp().getTime() > ((long) this.exclusionPeriod);
        if (z) {
            this.map.remove(anyOperationInitWithQueryCall);
        }
        return z;
    }
}
