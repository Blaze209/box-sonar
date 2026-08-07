package com.box.android.data.datasource.gql;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxGraphQL_Factory implements Factory<BoxGraphQL> {
    private final Provider<GQLApolloClientConfigurator> apolloClientConfiguratorProvider;
    private final Provider<QueryDebouncer.Factory> queryDebouncerFactoryProvider;

    private BoxGraphQL_Factory(Provider<GQLApolloClientConfigurator> apolloClientConfiguratorProvider, Provider<QueryDebouncer.Factory> queryDebouncerFactoryProvider) {
        this.apolloClientConfiguratorProvider = apolloClientConfiguratorProvider;
        this.queryDebouncerFactoryProvider = queryDebouncerFactoryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxGraphQL get() {
        return newInstance(this.apolloClientConfiguratorProvider.get(), this.queryDebouncerFactoryProvider.get());
    }

    public static BoxGraphQL_Factory create(Provider<GQLApolloClientConfigurator> apolloClientConfiguratorProvider, Provider<QueryDebouncer.Factory> queryDebouncerFactoryProvider) {
        return new BoxGraphQL_Factory(apolloClientConfiguratorProvider, queryDebouncerFactoryProvider);
    }

    public static BoxGraphQL newInstance(GQLApolloClientConfigurator apolloClientConfigurator, QueryDebouncer.Factory queryDebouncerFactory) {
        return new BoxGraphQL(apolloClientConfigurator, queryDebouncerFactory);
    }
}
