package com.box.android.data.datasource.gql;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GQLCache_Factory implements Factory<GQLCache> {
    private final Provider<GQLApolloClientConfigurator> apolloClientConfiguratorProvider;

    private GQLCache_Factory(Provider<GQLApolloClientConfigurator> apolloClientConfiguratorProvider) {
        this.apolloClientConfiguratorProvider = apolloClientConfiguratorProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GQLCache get() {
        return newInstance(this.apolloClientConfiguratorProvider.get());
    }

    public static GQLCache_Factory create(Provider<GQLApolloClientConfigurator> apolloClientConfiguratorProvider) {
        return new GQLCache_Factory(apolloClientConfiguratorProvider);
    }

    public static GQLCache newInstance(GQLApolloClientConfigurator apolloClientConfigurator) {
        return new GQLCache(apolloClientConfigurator);
    }
}
