package com.box.android.data.api.graphql;

import com.apollographql.apollo3.ApolloCall;
import com.apollographql.apollo3.ApolloClient;
import com.apollographql.apollo3.api.ApolloResponse;
import com.apollographql.apollo3.cache.normalized.FetchPolicy;
import com.apollographql.apollo3.cache.normalized.NormalizedCache;
import com.box.android.data.GetAiAgentsQuery;
import com.box.android.data.datasource.gql.BoxGraphQL;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetAIAgentsGraphQLQuery.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0086@¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/box/android/data/api/graphql/GetAIAgentsGraphQLQuery;", "", "graphQL", "Lcom/box/android/data/datasource/gql/BoxGraphQL;", "<init>", "(Lcom/box/android/data/datasource/gql/BoxGraphQL;)V", "getAgents", "Lcom/apollographql/apollo3/api/ApolloResponse;", "Lcom/box/android/data/GetAiAgentsQuery$Data;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetAIAgentsGraphQLQuery {
    private final BoxGraphQL graphQL;

    @Inject
    public GetAIAgentsGraphQLQuery(BoxGraphQL graphQL) {
        Intrinsics.checkNotNullParameter(graphQL, "graphQL");
        this.graphQL = graphQL;
    }

    public final Object getAgents(Continuation<? super ApolloResponse<GetAiAgentsQuery.Data>> continuation) {
        ApolloCall apolloCallQuery;
        ApolloCall apolloCall;
        ApolloClient apolloClient = this.graphQL.getApolloClient();
        if (apolloClient == null || (apolloCallQuery = apolloClient.query(new GetAiAgentsQuery())) == null || (apolloCall = (ApolloCall) NormalizedCache.fetchPolicy(apolloCallQuery, FetchPolicy.NetworkOnly)) == null) {
            return null;
        }
        Object objExecute = apolloCall.execute(continuation);
        return objExecute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objExecute : (ApolloResponse) objExecute;
    }
}
