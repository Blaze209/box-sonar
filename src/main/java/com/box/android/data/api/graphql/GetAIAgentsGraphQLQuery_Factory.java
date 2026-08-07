package com.box.android.data.api.graphql;

import com.box.android.data.datasource.gql.BoxGraphQL;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class GetAIAgentsGraphQLQuery_Factory implements Factory<GetAIAgentsGraphQLQuery> {
    private final Provider<BoxGraphQL> graphQLProvider;

    private GetAIAgentsGraphQLQuery_Factory(Provider<BoxGraphQL> graphQLProvider) {
        this.graphQLProvider = graphQLProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public GetAIAgentsGraphQLQuery get() {
        return newInstance(this.graphQLProvider.get());
    }

    public static GetAIAgentsGraphQLQuery_Factory create(Provider<BoxGraphQL> graphQLProvider) {
        return new GetAIAgentsGraphQLQuery_Factory(graphQLProvider);
    }

    public static GetAIAgentsGraphQLQuery newInstance(BoxGraphQL graphQL) {
        return new GetAIAgentsGraphQLQuery(graphQL);
    }
}
