package com.box.android.data.api.graphql;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.apollographql.apollo3.ApolloCall;
import com.apollographql.apollo3.ApolloClient;
import com.apollographql.apollo3.api.ApolloResponse;
import com.apollographql.apollo3.api.Optional;
import com.apollographql.apollo3.cache.normalized.FetchPolicy;
import com.apollographql.apollo3.cache.normalized.NormalizedCache;
import com.box.android.data.GetHubsQuery;
import com.box.android.data.datasource.gql.BoxGraphQL;
import com.box.android.data.type.HubsDirectionEnum;
import com.box.android.data.type.HubsSortEnum;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetHubsGraphQLQuery.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JN\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0086@¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/box/android/data/api/graphql/GetHubsGraphQLQuery;", "", "graphQL", "Lcom/box/android/data/datasource/gql/BoxGraphQL;", "<init>", "(Lcom/box/android/data/datasource/gql/BoxGraphQL;)V", "getHubs", "Lcom/apollographql/apollo3/api/ApolloResponse;", "Lcom/box/android/data/GetHubsQuery$Data;", "first", "", TtmlNode.ANNOTATION_POSITION_AFTER, "", "sort", "Lcom/box/android/data/type/HubsSortEnum;", "direction", "Lcom/box/android/data/type/HubsDirectionEnum;", "fetchPolicy", "Lcom/apollographql/apollo3/cache/normalized/FetchPolicy;", "query", "(ILjava/lang/String;Lcom/box/android/data/type/HubsSortEnum;Lcom/box/android/data/type/HubsDirectionEnum;Lcom/apollographql/apollo3/cache/normalized/FetchPolicy;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetHubsGraphQLQuery {
    private final BoxGraphQL graphQL;

    @Inject
    public GetHubsGraphQLQuery(BoxGraphQL graphQL) {
        Intrinsics.checkNotNullParameter(graphQL, "graphQL");
        this.graphQL = graphQL;
    }

    public static /* synthetic */ Object getHubs$default(GetHubsGraphQLQuery getHubsGraphQLQuery, int i, String str, HubsSortEnum hubsSortEnum, HubsDirectionEnum hubsDirectionEnum, FetchPolicy fetchPolicy, String str2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 32) != 0) {
            str2 = null;
        }
        return getHubsGraphQLQuery.getHubs(i, str, hubsSortEnum, hubsDirectionEnum, fetchPolicy, str2, continuation);
    }

    public final Object getHubs(int i, String str, HubsSortEnum hubsSortEnum, HubsDirectionEnum hubsDirectionEnum, FetchPolicy fetchPolicy, String str2, Continuation<? super ApolloResponse<GetHubsQuery.Data>> continuation) {
        ApolloCall apolloCallQuery;
        ApolloCall apolloCall;
        ApolloClient apolloClient = this.graphQL.getApolloClient();
        if (apolloClient == null || (apolloCallQuery = apolloClient.query(new GetHubsQuery(i, Optional.INSTANCE.presentIfNotNull(str), hubsSortEnum, hubsDirectionEnum, Optional.INSTANCE.presentIfNotNull(str2)))) == null || (apolloCall = (ApolloCall) NormalizedCache.fetchPolicy(apolloCallQuery, fetchPolicy)) == null) {
            return null;
        }
        Object objExecute = apolloCall.execute(continuation);
        return objExecute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objExecute : (ApolloResponse) objExecute;
    }
}
