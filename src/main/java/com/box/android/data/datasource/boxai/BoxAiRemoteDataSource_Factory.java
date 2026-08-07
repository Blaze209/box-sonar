package com.box.android.data.datasource.boxai;

import com.box.android.data.api.graphql.GetAIAgentsGraphQLQuery;
import com.box.android.data.api.graphql.GetAiSessionsGraphQLQuery;
import com.box.android.data.api.requests.BoxAiRequest;
import com.box.android.data.datasource.SharedLinkTokenRetryHelper;
import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxAiRemoteDataSource_Factory implements Factory<BoxAiRemoteDataSource> {
    private final Provider<BoxAiRequest> boxAiRequestProvider;
    private final Provider<GetAIAgentsGraphQLQuery> getAIAgentsGraphQLQueryProvider;
    private final Provider<GetAiSessionsGraphQLQuery> getAiSessionsGraphQLQueryProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<SharedLinkTokenRetryHelper> sharedLinkTokenRetryHelperProvider;

    private BoxAiRemoteDataSource_Factory(Provider<BoxAiRequest> boxAiRequestProvider, Provider<SharedLinkTokenRetryHelper> sharedLinkTokenRetryHelperProvider, Provider<Moshi> moshiProvider, Provider<GetAIAgentsGraphQLQuery> getAIAgentsGraphQLQueryProvider, Provider<GetAiSessionsGraphQLQuery> getAiSessionsGraphQLQueryProvider) {
        this.boxAiRequestProvider = boxAiRequestProvider;
        this.sharedLinkTokenRetryHelperProvider = sharedLinkTokenRetryHelperProvider;
        this.moshiProvider = moshiProvider;
        this.getAIAgentsGraphQLQueryProvider = getAIAgentsGraphQLQueryProvider;
        this.getAiSessionsGraphQLQueryProvider = getAiSessionsGraphQLQueryProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxAiRemoteDataSource get() {
        return newInstance(this.boxAiRequestProvider.get(), this.sharedLinkTokenRetryHelperProvider.get(), this.moshiProvider.get(), this.getAIAgentsGraphQLQueryProvider.get(), this.getAiSessionsGraphQLQueryProvider.get());
    }

    public static BoxAiRemoteDataSource_Factory create(Provider<BoxAiRequest> boxAiRequestProvider, Provider<SharedLinkTokenRetryHelper> sharedLinkTokenRetryHelperProvider, Provider<Moshi> moshiProvider, Provider<GetAIAgentsGraphQLQuery> getAIAgentsGraphQLQueryProvider, Provider<GetAiSessionsGraphQLQuery> getAiSessionsGraphQLQueryProvider) {
        return new BoxAiRemoteDataSource_Factory(boxAiRequestProvider, sharedLinkTokenRetryHelperProvider, moshiProvider, getAIAgentsGraphQLQueryProvider, getAiSessionsGraphQLQueryProvider);
    }

    public static BoxAiRemoteDataSource newInstance(BoxAiRequest boxAiRequest, SharedLinkTokenRetryHelper sharedLinkTokenRetryHelper, Moshi moshi, GetAIAgentsGraphQLQuery getAIAgentsGraphQLQuery, GetAiSessionsGraphQLQuery getAiSessionsGraphQLQuery) {
        return new BoxAiRemoteDataSource(boxAiRequest, sharedLinkTokenRetryHelper, moshi, getAIAgentsGraphQLQuery, getAiSessionsGraphQLQuery);
    }
}
