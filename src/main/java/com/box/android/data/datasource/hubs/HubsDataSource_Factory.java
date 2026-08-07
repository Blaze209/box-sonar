package com.box.android.data.datasource.hubs;

import com.box.android.data.api.graphql.GetHubsGraphQLQuery;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class HubsDataSource_Factory implements Factory<HubsDataSource> {
    private final Provider<GetHubsGraphQLQuery> getHubsGraphQLQueryProvider;

    private HubsDataSource_Factory(Provider<GetHubsGraphQLQuery> getHubsGraphQLQueryProvider) {
        this.getHubsGraphQLQueryProvider = getHubsGraphQLQueryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public HubsDataSource get() {
        return newInstance(this.getHubsGraphQLQueryProvider.get());
    }

    public static HubsDataSource_Factory create(Provider<GetHubsGraphQLQuery> getHubsGraphQLQueryProvider) {
        return new HubsDataSource_Factory(getHubsGraphQLQueryProvider);
    }

    public static HubsDataSource newInstance(GetHubsGraphQLQuery getHubsGraphQLQuery) {
        return new HubsDataSource(getHubsGraphQLQuery);
    }
}
