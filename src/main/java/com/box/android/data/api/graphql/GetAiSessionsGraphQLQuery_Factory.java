package com.box.android.data.api.graphql;

import com.box.android.data.datasource.gql.BoxGraphQL;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GetAiSessionsGraphQLQuery_Factory implements Factory<GetAiSessionsGraphQLQuery> {
    private final Provider<BoxGraphQL> graphQLProvider;

    private GetAiSessionsGraphQLQuery_Factory(Provider<BoxGraphQL> graphQLProvider) {
        this.graphQLProvider = graphQLProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetAiSessionsGraphQLQuery get() {
        return newInstance(this.graphQLProvider.get());
    }

    public static GetAiSessionsGraphQLQuery_Factory create(Provider<BoxGraphQL> graphQLProvider) {
        return new GetAiSessionsGraphQLQuery_Factory(graphQLProvider);
    }

    public static GetAiSessionsGraphQLQuery newInstance(BoxGraphQL graphQL) {
        return new GetAiSessionsGraphQLQuery(graphQL);
    }
}
