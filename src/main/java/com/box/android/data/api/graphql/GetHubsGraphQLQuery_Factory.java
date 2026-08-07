package com.box.android.data.api.graphql;

import com.box.android.data.datasource.gql.BoxGraphQL;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GetHubsGraphQLQuery_Factory implements Factory<GetHubsGraphQLQuery> {
    private final Provider<BoxGraphQL> graphQLProvider;

    private GetHubsGraphQLQuery_Factory(Provider<BoxGraphQL> graphQLProvider) {
        this.graphQLProvider = graphQLProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetHubsGraphQLQuery get() {
        return newInstance(this.graphQLProvider.get());
    }

    public static GetHubsGraphQLQuery_Factory create(Provider<BoxGraphQL> graphQLProvider) {
        return new GetHubsGraphQLQuery_Factory(graphQLProvider);
    }

    public static GetHubsGraphQLQuery newInstance(BoxGraphQL graphQL) {
        return new GetHubsGraphQLQuery(graphQL);
    }
}
