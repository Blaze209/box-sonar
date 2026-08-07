package com.box.android.data.datasource.gql;

import dagger.internal.InstanceFactory;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class QueryDebouncer_Factory_Impl implements QueryDebouncer.Factory {
    private final C1154QueryDebouncer_Factory delegateFactory;

    QueryDebouncer_Factory_Impl(C1154QueryDebouncer_Factory delegateFactory) {
        this.delegateFactory = delegateFactory;
    }

    @Override // com.box.android.data.datasource.gql.QueryDebouncer.Factory
    public QueryDebouncer create(int exclusionPeriod, DateProviding dateProvider) {
        return this.delegateFactory.get(exclusionPeriod, dateProvider);
    }

    public static Provider<QueryDebouncer.Factory> create(C1154QueryDebouncer_Factory delegateFactory) {
        return InstanceFactory.create(new QueryDebouncer_Factory_Impl(delegateFactory));
    }

    public static dagger.internal.Provider<QueryDebouncer.Factory> createFactoryProvider(C1154QueryDebouncer_Factory delegateFactory) {
        return InstanceFactory.create(new QueryDebouncer_Factory_Impl(delegateFactory));
    }
}
