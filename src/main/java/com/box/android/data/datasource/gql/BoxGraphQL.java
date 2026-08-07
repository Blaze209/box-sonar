package com.box.android.data.datasource.gql;

import androidx.core.app.NotificationCompat;
import com.apollographql.apollo3.ApolloCall;
import com.apollographql.apollo3.ApolloClient;
import com.apollographql.apollo3.api.ApolloResponse;
import com.apollographql.apollo3.api.Optional;
import com.apollographql.apollo3.api.Query;
import com.apollographql.apollo3.cache.normalized.FetchPolicy;
import com.apollographql.apollo3.cache.normalized.NormalizedCache;
import com.box.android.common.utilities.FlowExtensionsKt;
import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.data.CopyItemMutation;
import com.box.android.data.CreateCollectionItemMutation;
import com.box.android.data.CreateCollectionMutation;
import com.box.android.data.CreateFolderMutation;
import com.box.android.data.DeleteCollectionItemMutation;
import com.box.android.data.GetAllCollectionsQuery;
import com.box.android.data.GetCollectionItemsQuery;
import com.box.android.data.GetCollectionsWithItemQuery;
import com.box.android.data.GetFolderItemsQuery;
import com.box.android.data.GetFolderMiniQuery;
import com.box.android.data.GetFolderMiniWithParentQuery;
import com.box.android.data.GetItemNamesInFolderQuery;
import com.box.android.data.GetItemQuery;
import com.box.android.data.GetItemWithWatermarkDataQuery;
import com.box.android.data.MoveItemMutation;
import com.box.android.data.type.ItemType;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: BoxGraphQL.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010J\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010J\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00102\u0006\u0010\u001e\u001a\u00020\u0016J\u0016\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00102\u0006\u0010 \u001a\u00020\u0016J\u0016\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00102\u0006\u0010 \u001a\u00020\u0016J\u001c\u0010\"\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170$\u0018\u00010#2\u0006\u0010 \u001a\u00020\u0016J&\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u00102\u0006\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u0016J&\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\u00102\u0006\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u0016J\u001e\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u00102\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u0016J,\u0010.\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\u00102\u0006\u0010\u001e\u001a\u00020\u00162\b\b\u0002\u00100\u001a\u00020\u00162\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0016J\u0016\u00102\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010\u00102\u0006\u0010 \u001a\u00020\u0016J\u0016\u00104\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010\u00102\u0006\u0010 \u001a\u00020\u0016J\u001e\u00105\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u00102\u0006\u0010 \u001a\u00020\u00162\u0006\u00107\u001a\u000208J\u001e\u00109\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010\u00102\u0006\u0010 \u001a\u00020\u00162\u0006\u00107\u001a\u000208J&\u0010;\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010\u00102\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u00162\u0006\u00107\u001a\u000208J&\u0010=\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010\u00102\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u00162\u0006\u00107\u001a\u000208J>\u0010?\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\u00102\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u00162\u0006\u00100\u001a\u00020\u00162\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0016J>\u0010B\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010\u00102\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u00162\u0006\u0010D\u001a\u00020\u00162\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0016J\u0016\u0010E\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010\u00102\u0006\u0010G\u001a\u00020\u0016Jt\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002HI0$0#\"\u000e\b\u0000\u0010J*\b\u0012\u0004\u0012\u0002HI0K\"\b\b\u0001\u0010I*\u00020L2\u0006\u0010M\u001a\u0002HJ29\u0010N\u001a5\b\u0001\u0012\u0013\u0012\u0011HJ¢\u0006\f\bP\u0012\b\b\u001e\u0012\u0004\b\b(M\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002HI\u0018\u00010$0Q\u0012\u0006\u0012\u0004\u0018\u00010\u00010O¢\u0006\u0002\u0010RJ\u0088\u0001\u0010S\u001a\u00020T\"\u000e\b\u0000\u0010J*\b\u0012\u0004\u0012\u0002HI0K\"\b\b\u0001\u0010I*\u00020L2\u0006\u0010M\u001a\u0002HJ29\u0010N\u001a5\b\u0001\u0012\u0013\u0012\u0011HJ¢\u0006\f\bP\u0012\b\b\u001e\u0012\u0004\b\b(M\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002HI\u0018\u00010$0Q\u0012\u0006\u0012\u0004\u0018\u00010\u00010O2\b\b\u0002\u0010U\u001a\u00020V2\u0012\u0010W\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002HI0$0XH\u0007¢\u0006\u0002\u0010YJR\u0010Z\u001a\u00020[\"\u000e\b\u0000\u0010J*\b\u0012\u0004\u0012\u0002HI0K\"\b\b\u0001\u0010I*\u00020L2\u0006\u0010M\u001a\u0002HJ2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020[0\u000f2\u0012\u0010W\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002HI0$0XH\u0087@¢\u0006\u0002\u0010]J8\u0010^\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002HI0$\u0018\u00010#\"\b\b\u0000\u0010I*\u00020L2\u000e\u0010_\u001a\n\u0012\u0004\u0012\u0002HI\u0018\u00010\u00102\b\b\u0002\u00107\u001a\u000208J.\u0010`\u001a\u00020[\"\b\b\u0000\u0010I*\u00020L2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002HI0K2\u0006\u0010a\u001a\u00020bH\u0086@¢\u0006\u0002\u0010cJ.\u0010d\u001a\n\u0012\u0004\u0012\u0002HI\u0018\u00010$\"\b\b\u0000\u0010I*\u00020L2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002HI0KH\u0087@¢\u0006\u0002\u0010eJ\u0018\u0010f\u001a\u00020[2\u0006\u0010g\u001a\u00020\u00162\u0006\u0010h\u001a\u00020iH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R%\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00100\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006j"}, d2 = {"Lcom/box/android/data/datasource/gql/BoxGraphQL;", "", "apolloClientConfigurator", "Lcom/box/android/data/datasource/gql/GQLApolloClientConfigurator;", "queryDebouncerFactory", "Lcom/box/android/data/datasource/gql/QueryDebouncer$Factory;", "<init>", "(Lcom/box/android/data/datasource/gql/GQLApolloClientConfigurator;Lcom/box/android/data/datasource/gql/QueryDebouncer$Factory;)V", "apolloClient", "Lcom/apollographql/apollo3/ApolloClient;", "getApolloClient", "()Lcom/apollographql/apollo3/ApolloClient;", "queryDebouncer", "Lcom/box/android/data/datasource/gql/QueryDebouncer;", "getAllCollectionsQuery", "Lkotlin/Function0;", "Lcom/apollographql/apollo3/ApolloCall;", "Lcom/box/android/data/GetAllCollectionsQuery$Data;", "getGetAllCollectionsQuery", "()Lkotlin/jvm/functions/Function0;", "getCollectionItemsQuery", "Lkotlin/Function1;", "", "Lcom/box/android/data/GetCollectionItemsQuery$Data;", "getGetCollectionItemsQuery", "()Lkotlin/jvm/functions/Function1;", "getAllCollectionsQueryFromCache", "getAllCollectionsQueryFromNetwork", "createCollection", "Lcom/box/android/data/CreateCollectionMutation$Data;", "name", "getCollectionItemsFromNetwork", "id", "getCollectionItemsFromCache", "getCollectionsItemsWatcher", "Lkotlinx/coroutines/flow/Flow;", "Lcom/apollographql/apollo3/api/ApolloResponse;", "removeItemFromCollection", "Lcom/box/android/data/DeleteCollectionItemMutation$Data;", BoxItemJob.COLLECTION_ID, "itemId", "itemType", "createCollectionItem", "Lcom/box/android/data/CreateCollectionItemMutation$Data;", "getCollectionsWithItem", "Lcom/box/android/data/GetCollectionsWithItemQuery$Data;", "createFolder", "Lcom/box/android/data/CreateFolderMutation$Data;", IdentificationData.FIELD_PARENT_ID, "clientMutationId", "getFolderItemsFromNetwork", "Lcom/box/android/data/GetFolderItemsQuery$Data;", "getFolderItemsFromCache", "folderMini", "Lcom/box/android/data/GetFolderMiniQuery$Data;", "fetchPolicy", "Lcom/apollographql/apollo3/cache/normalized/FetchPolicy;", "folderMiniWithParent", "Lcom/box/android/data/GetFolderMiniWithParentQuery$Data;", "item", "Lcom/box/android/data/GetItemQuery$Data;", "itemWithWatermarkData", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$Data;", "copyItem", "Lcom/box/android/data/CopyItemMutation$Data;", "newName", "moveItem", "Lcom/box/android/data/MoveItemMutation$Data;", "newParentId", GetItemNamesInFolderQuery.OPERATION_NAME, "Lcom/box/android/data/GetItemNamesInFolderQuery$Data;", "folderID", "watchWithPreliminaryData", "D", "Q", "Lcom/apollographql/apollo3/api/Query;", "Lcom/apollographql/apollo3/api/Query$Data;", "query", "preliminaryDataProvider", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "Lkotlin/coroutines/Continuation;", "(Lcom/apollographql/apollo3/api/Query;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "preliminaryDataFromCache", "Lkotlinx/coroutines/Job;", "preliminaryDataDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "producerScope", "Lkotlinx/coroutines/channels/ProducerScope;", "(Lcom/apollographql/apollo3/api/Query;Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/channels/ProducerScope;)Lkotlinx/coroutines/Job;", "watchCacheAndSendResults", "", "onResponseReady", "(Lcom/apollographql/apollo3/api/Query;Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "watchCache", NotificationCompat.CATEGORY_CALL, "batch", "debounce", "Lcom/box/android/data/datasource/gql/DebouncePolicy;", "(Lcom/apollographql/apollo3/api/Query;Lcom/box/android/data/datasource/gql/DebouncePolicy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performQuery", "(Lcom/apollographql/apollo3/api/Query;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logError", "errorMessage", "error", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class BoxGraphQL {
    private final GQLApolloClientConfigurator apolloClientConfigurator;
    private final Function0<ApolloCall<GetAllCollectionsQuery.Data>> getAllCollectionsQuery;
    private final Function1<String, ApolloCall<GetCollectionItemsQuery.Data>> getCollectionItemsQuery;
    private final QueryDebouncer queryDebouncer;

    /* JADX INFO: renamed from: com.box.android.data.datasource.gql.BoxGraphQL$batch$1, reason: invalid class name */
    /* JADX INFO: compiled from: BoxGraphQL.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.gql.BoxGraphQL", f = "BoxGraphQL.kt", i = {0, 0, 0, 0}, l = {334}, m = "batch", n = {"query", "debounce", "$i$f$resultOf", "$i$a$-resultOf-BoxGraphQL$batch$2"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1<D extends Query.Data> extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BoxGraphQL.this.batch(null, null, this);
        }
    }

    @Inject
    public BoxGraphQL(GQLApolloClientConfigurator apolloClientConfigurator, QueryDebouncer.Factory queryDebouncerFactory) {
        Intrinsics.checkNotNullParameter(apolloClientConfigurator, "apolloClientConfigurator");
        Intrinsics.checkNotNullParameter(queryDebouncerFactory, "queryDebouncerFactory");
        this.apolloClientConfigurator = apolloClientConfigurator;
        this.queryDebouncer = QueryDebouncer.Factory.create$default(queryDebouncerFactory, 0, new DefaultDateProvider(), 1, null);
        this.getAllCollectionsQuery = new Function0() { // from class: com.box.android.data.datasource.gql.BoxGraphQL$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BoxGraphQL.getAllCollectionsQuery$lambda$0(this.f$0);
            }
        };
        this.getCollectionItemsQuery = new Function1() { // from class: com.box.android.data.datasource.gql.BoxGraphQL$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BoxGraphQL.getCollectionItemsQuery$lambda$0(this.f$0, (String) obj);
            }
        };
    }

    public final ApolloClient getApolloClient() {
        return this.apolloClientConfigurator.getApolloClient();
    }

    public final Function0<ApolloCall<GetAllCollectionsQuery.Data>> getGetAllCollectionsQuery() {
        return this.getAllCollectionsQuery;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ApolloCall getAllCollectionsQuery$lambda$0(BoxGraphQL boxGraphQL) {
        ApolloClient apolloClient = boxGraphQL.getApolloClient();
        if (apolloClient != null) {
            return apolloClient.query(new GetAllCollectionsQuery());
        }
        return null;
    }

    public final Function1<String, ApolloCall<GetCollectionItemsQuery.Data>> getGetCollectionItemsQuery() {
        return this.getCollectionItemsQuery;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ApolloCall getCollectionItemsQuery$lambda$0(BoxGraphQL boxGraphQL, String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        ApolloClient apolloClient = boxGraphQL.getApolloClient();
        if (apolloClient != null) {
            return apolloClient.query(new GetCollectionItemsQuery(id));
        }
        return null;
    }

    public final ApolloCall<GetAllCollectionsQuery.Data> getAllCollectionsQueryFromCache() {
        ApolloCall<GetAllCollectionsQuery.Data> apolloCallInvoke = this.getAllCollectionsQuery.invoke();
        if (apolloCallInvoke != null) {
            return (ApolloCall) NormalizedCache.fetchPolicy(apolloCallInvoke, FetchPolicy.CacheOnly);
        }
        return null;
    }

    public final ApolloCall<GetAllCollectionsQuery.Data> getAllCollectionsQueryFromNetwork() {
        ApolloCall<GetAllCollectionsQuery.Data> apolloCallInvoke = this.getAllCollectionsQuery.invoke();
        if (apolloCallInvoke != null) {
            return (ApolloCall) NormalizedCache.fetchPolicy(apolloCallInvoke, FetchPolicy.NetworkOnly);
        }
        return null;
    }

    public final ApolloCall<CreateCollectionMutation.Data> createCollection(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        ApolloClient apolloClient = getApolloClient();
        if (apolloClient != null) {
            return apolloClient.mutation(new CreateCollectionMutation(name));
        }
        return null;
    }

    public final ApolloCall<GetCollectionItemsQuery.Data> getCollectionItemsFromNetwork(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        ApolloCall<GetCollectionItemsQuery.Data> apolloCallInvoke = this.getCollectionItemsQuery.invoke(id);
        if (apolloCallInvoke != null) {
            return (ApolloCall) NormalizedCache.fetchPolicy(apolloCallInvoke, FetchPolicy.NetworkOnly);
        }
        return null;
    }

    public final ApolloCall<GetCollectionItemsQuery.Data> getCollectionItemsFromCache(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        ApolloCall<GetCollectionItemsQuery.Data> apolloCallInvoke = this.getCollectionItemsQuery.invoke(id);
        if (apolloCallInvoke != null) {
            return (ApolloCall) NormalizedCache.fetchPolicy(apolloCallInvoke, FetchPolicy.CacheOnly);
        }
        return null;
    }

    public final Flow<ApolloResponse<GetCollectionItemsQuery.Data>> getCollectionsItemsWatcher(String id) {
        ApolloCall apolloCall;
        Intrinsics.checkNotNullParameter(id, "id");
        ApolloCall<GetCollectionItemsQuery.Data> apolloCallInvoke = this.getCollectionItemsQuery.invoke(id);
        if (apolloCallInvoke == null || (apolloCall = (ApolloCall) NormalizedCache.refetchPolicy(apolloCallInvoke, FetchPolicy.CacheOnly)) == null) {
            return null;
        }
        return NormalizedCache.watch$default(apolloCall, false, false, 3, (Object) null);
    }

    public final ApolloCall<DeleteCollectionItemMutation.Data> removeItemFromCollection(String collectionId, String itemId, String itemType) {
        Intrinsics.checkNotNullParameter(collectionId, "collectionId");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        ApolloClient apolloClient = getApolloClient();
        if (apolloClient != null) {
            return apolloClient.mutation(new DeleteCollectionItemMutation(collectionId, itemId, ItemType.INSTANCE.safeValueOf(itemType)));
        }
        return null;
    }

    public final ApolloCall<CreateCollectionItemMutation.Data> createCollectionItem(String collectionId, String itemId, String itemType) {
        Intrinsics.checkNotNullParameter(collectionId, "collectionId");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        ApolloClient apolloClient = getApolloClient();
        if (apolloClient != null) {
            return apolloClient.mutation(new CreateCollectionItemMutation(collectionId, itemId, ItemType.INSTANCE.safeValueOf(itemType)));
        }
        return null;
    }

    public final ApolloCall<GetCollectionsWithItemQuery.Data> getCollectionsWithItem(String itemId, String itemType) {
        ApolloCall apolloCallQuery;
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        ApolloClient apolloClient = getApolloClient();
        if (apolloClient == null || (apolloCallQuery = apolloClient.query(new GetCollectionsWithItemQuery(itemId, ItemType.INSTANCE.safeValueOf(itemType)))) == null) {
            return null;
        }
        return (ApolloCall) NormalizedCache.fetchPolicy(apolloCallQuery, FetchPolicy.NetworkFirst);
    }

    public static /* synthetic */ ApolloCall createFolder$default(BoxGraphQL boxGraphQL, String str, String str2, String str3, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createFolder");
        }
        if ((i & 2) != 0) {
            str2 = "0";
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        return boxGraphQL.createFolder(str, str2, str3);
    }

    public final ApolloCall<CreateFolderMutation.Data> createFolder(String name, String parentId, String clientMutationId) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(parentId, "parentId");
        ApolloClient apolloClient = getApolloClient();
        if (apolloClient != null) {
            return apolloClient.mutation(new CreateFolderMutation(name, Optional.INSTANCE.presentIfNotNull(parentId), Optional.INSTANCE.presentIfNotNull(clientMutationId)));
        }
        return null;
    }

    public final ApolloCall<GetFolderItemsQuery.Data> getFolderItemsFromNetwork(String id) {
        ApolloCall apolloCallQuery;
        ApolloCall apolloCall;
        Intrinsics.checkNotNullParameter(id, "id");
        ApolloClient apolloClient = getApolloClient();
        if (apolloClient == null || (apolloCallQuery = apolloClient.query(new GetFolderItemsQuery(id))) == null || (apolloCall = (ApolloCall) NormalizedCache.fetchPolicy(apolloCallQuery, FetchPolicy.NetworkOnly)) == null) {
            return null;
        }
        return (ApolloCall) NormalizedCache.doNotStore(apolloCall, true);
    }

    public final ApolloCall<GetFolderItemsQuery.Data> getFolderItemsFromCache(String id) {
        ApolloCall apolloCallQuery;
        Intrinsics.checkNotNullParameter(id, "id");
        ApolloClient apolloClient = getApolloClient();
        if (apolloClient == null || (apolloCallQuery = apolloClient.query(new GetFolderItemsQuery(id))) == null) {
            return null;
        }
        return (ApolloCall) NormalizedCache.fetchPolicy(apolloCallQuery, FetchPolicy.CacheOnly);
    }

    public final ApolloCall<GetFolderMiniQuery.Data> folderMini(String id, FetchPolicy fetchPolicy) {
        ApolloCall apolloCallQuery;
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(fetchPolicy, "fetchPolicy");
        ApolloClient apolloClient = getApolloClient();
        if (apolloClient == null || (apolloCallQuery = apolloClient.query(new GetFolderMiniQuery(id))) == null) {
            return null;
        }
        return (ApolloCall) NormalizedCache.fetchPolicy(apolloCallQuery, fetchPolicy);
    }

    public final ApolloCall<GetFolderMiniWithParentQuery.Data> folderMiniWithParent(String id, FetchPolicy fetchPolicy) {
        ApolloCall apolloCallQuery;
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(fetchPolicy, "fetchPolicy");
        ApolloClient apolloClient = getApolloClient();
        if (apolloClient == null || (apolloCallQuery = apolloClient.query(new GetFolderMiniWithParentQuery(id))) == null) {
            return null;
        }
        return (ApolloCall) NormalizedCache.fetchPolicy(apolloCallQuery, fetchPolicy);
    }

    public final ApolloCall<GetItemQuery.Data> item(String itemId, String itemType, FetchPolicy fetchPolicy) {
        ApolloCall apolloCallQuery;
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        Intrinsics.checkNotNullParameter(fetchPolicy, "fetchPolicy");
        ApolloClient apolloClient = getApolloClient();
        if (apolloClient == null || (apolloCallQuery = apolloClient.query(new GetItemQuery(itemId, ItemType.INSTANCE.safeValueOf(itemType)))) == null) {
            return null;
        }
        return (ApolloCall) NormalizedCache.fetchPolicy(apolloCallQuery, fetchPolicy);
    }

    public final ApolloCall<GetItemWithWatermarkDataQuery.Data> itemWithWatermarkData(String itemId, String itemType, FetchPolicy fetchPolicy) {
        ApolloCall apolloCallQuery;
        ApolloCall apolloCall;
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        Intrinsics.checkNotNullParameter(fetchPolicy, "fetchPolicy");
        ApolloClient apolloClient = getApolloClient();
        if (apolloClient == null || (apolloCallQuery = apolloClient.query(new GetItemWithWatermarkDataQuery(itemId, ItemType.INSTANCE.safeValueOf(itemType)))) == null || (apolloCall = (ApolloCall) NormalizedCache.fetchPolicy(apolloCallQuery, fetchPolicy)) == null) {
            return null;
        }
        return (ApolloCall) NormalizedCache.doNotStore(apolloCall, true);
    }

    public static /* synthetic */ ApolloCall copyItem$default(BoxGraphQL boxGraphQL, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyItem");
        }
        if ((i & 8) != 0) {
            str4 = null;
        }
        if ((i & 16) != 0) {
            str5 = null;
        }
        return boxGraphQL.copyItem(str, str2, str3, str4, str5);
    }

    public final ApolloCall<CopyItemMutation.Data> copyItem(String itemId, String itemType, String parentId, String newName, String clientMutationId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        Intrinsics.checkNotNullParameter(parentId, "parentId");
        ApolloClient apolloClient = getApolloClient();
        if (apolloClient != null) {
            return apolloClient.mutation(new CopyItemMutation(itemId, ItemType.INSTANCE.safeValueOf(itemType), parentId, new Optional.Present(newName), new Optional.Present(clientMutationId)));
        }
        return null;
    }

    public static /* synthetic */ ApolloCall moveItem$default(BoxGraphQL boxGraphQL, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: moveItem");
        }
        if ((i & 8) != 0) {
            str4 = null;
        }
        if ((i & 16) != 0) {
            str5 = null;
        }
        return boxGraphQL.moveItem(str, str2, str3, str4, str5);
    }

    public final ApolloCall<MoveItemMutation.Data> moveItem(String itemId, String itemType, String newParentId, String newName, String clientMutationId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemType, "itemType");
        Intrinsics.checkNotNullParameter(newParentId, "newParentId");
        ApolloClient apolloClient = getApolloClient();
        if (apolloClient != null) {
            return apolloClient.mutation(new MoveItemMutation(itemId, ItemType.INSTANCE.safeValueOf(itemType), newParentId, new Optional.Present(newName), new Optional.Present(clientMutationId)));
        }
        return null;
    }

    public final ApolloCall<GetItemNamesInFolderQuery.Data> getItemNamesInFolder(String folderID) {
        Intrinsics.checkNotNullParameter(folderID, "folderID");
        ApolloClient apolloClient = getApolloClient();
        if (apolloClient != null) {
            return apolloClient.query(new GetItemNamesInFolderQuery(folderID));
        }
        return null;
    }

    /* JADX INFO: Add missing generic type declarations: [D] */
    /* JADX INFO: renamed from: com.box.android.data.datasource.gql.BoxGraphQL$watchWithPreliminaryData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxGraphQL.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "", "D", "Lcom/apollographql/apollo3/api/Query$Data;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/apollographql/apollo3/api/ApolloResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.gql.BoxGraphQL$watchWithPreliminaryData$1", f = "BoxGraphQL.kt", i = {0, 0}, l = {241}, m = "invokeSuspend", n = {"$this$channelFlow", "preliminaryDataJob"}, s = {"L$0", "L$1"}, v = 1)
    static final class C11531<D> extends SuspendLambda implements Function2<ProducerScope<? super ApolloResponse<D>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Q, Continuation<? super ApolloResponse<D>>, Object> $preliminaryDataProvider;

        /* JADX INFO: Incorrect field signature: TQ; */
        final /* synthetic */ Query $query;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Incorrect types in method signature: (Lcom/box/android/data/datasource/gql/BoxGraphQL;TQ;Lkotlin/jvm/functions/Function2<-TQ;-Lkotlin/coroutines/Continuation<-Lcom/apollographql/apollo3/api/ApolloResponse<TD;>;>;+Ljava/lang/Object;>;Lkotlin/coroutines/Continuation<-Lcom/box/android/data/datasource/gql/BoxGraphQL$watchWithPreliminaryData$1;>;)V */
        C11531(Query query, Function2 function2, Continuation continuation) {
            super(2, continuation);
            this.$query = query;
            this.$preliminaryDataProvider = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C11531 c11531 = BoxGraphQL.this.new C11531(this.$query, this.$preliminaryDataProvider, continuation);
            c11531.L$0 = obj;
            return c11531;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super ApolloResponse<D>> producerScope, Continuation<? super Unit> continuation) {
            return ((C11531) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ProducerScope producerScope = (ProducerScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final Job jobPreliminaryDataFromCache$default = BoxGraphQL.preliminaryDataFromCache$default(BoxGraphQL.this, this.$query, this.$preliminaryDataProvider, null, producerScope, 4, null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(producerScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(jobPreliminaryDataFromCache$default);
                this.label = 1;
                if (BoxGraphQL.this.watchCacheAndSendResults(this.$query, new Function0() { // from class: com.box.android.data.datasource.gql.BoxGraphQL$watchWithPreliminaryData$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxGraphQL.C11531.invokeSuspend$lambda$0(jobPreliminaryDataFromCache$default);
                    }
                }, producerScope, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(Job job) {
            FlowExtensionsKt.cancelIfActive(job);
            return Unit.INSTANCE;
        }
    }

    public final <Q extends Query<D>, D extends Query.Data> Flow<ApolloResponse<D>> watchWithPreliminaryData(Q query, Function2<? super Q, ? super Continuation<? super ApolloResponse<D>>, ? extends Object> preliminaryDataProvider) {
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(preliminaryDataProvider, "preliminaryDataProvider");
        return FlowKt.channelFlow(new C11531(query, preliminaryDataProvider, null));
    }

    public static /* synthetic */ Job preliminaryDataFromCache$default(BoxGraphQL boxGraphQL, Query query, Function2 function2, CoroutineDispatcher coroutineDispatcher, ProducerScope producerScope, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: preliminaryDataFromCache");
        }
        if ((i & 4) != 0) {
            coroutineDispatcher = Dispatchers.getIO();
        }
        return boxGraphQL.preliminaryDataFromCache(query, function2, coroutineDispatcher, producerScope);
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.gql.BoxGraphQL$preliminaryDataFromCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BoxGraphQL.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.gql.BoxGraphQL$preliminaryDataFromCache$1", f = "BoxGraphQL.kt", i = {0, 1, 1, 1}, l = {269, 273}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "response", "$i$a$-let-BoxGraphQL$preliminaryDataFromCache$1$1"}, s = {"L$0", "L$0", "L$1", "I$0"}, v = 1)
    static final class C11521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Q, Continuation<? super ApolloResponse<D>>, Object> $preliminaryDataProvider;
        final /* synthetic */ ProducerScope<ApolloResponse<D>> $producerScope;

        /* JADX INFO: Incorrect field signature: TQ; */
        final /* synthetic */ Query $query;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ BoxGraphQL this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Incorrect types in method signature: (Lkotlin/jvm/functions/Function2<-TQ;-Lkotlin/coroutines/Continuation<-Lcom/apollographql/apollo3/api/ApolloResponse<TD;>;>;+Ljava/lang/Object;>;TQ;Lcom/box/android/data/datasource/gql/BoxGraphQL;Lkotlinx/coroutines/channels/ProducerScope<-Lcom/apollographql/apollo3/api/ApolloResponse<TD;>;>;Lkotlin/coroutines/Continuation<-Lcom/box/android/data/datasource/gql/BoxGraphQL$preliminaryDataFromCache$1;>;)V */
        C11521(Function2 function2, Query query, BoxGraphQL boxGraphQL, ProducerScope producerScope, Continuation continuation) {
            super(2, continuation);
            this.$preliminaryDataProvider = function2;
            this.$query = query;
            this.this$0 = boxGraphQL;
            this.$producerScope = producerScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C11521 c11521 = new C11521(this.$preliminaryDataProvider, this.$query, this.this$0, this.$producerScope, continuation);
            c11521.L$0 = obj;
            return c11521;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11521) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.Continuation to com.box.android.data.datasource.gql.BoxGraphQL$preliminaryDataFromCache$1 for r5v6 'this'  kotlin.coroutines.Continuation
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = r5.L$0
                kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r5.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L28
                if (r2 == r4) goto L22
                if (r2 != r3) goto L1a
                java.lang.Object r0 = r5.L$1
                com.apollographql.apollo3.api.ApolloResponse r0 = (com.apollographql.apollo3.api.ApolloResponse) r0
                kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Exception -> L26
                goto L67
            L1a:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L22:
                kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Exception -> L26
                goto L3a
            L26:
                r6 = move-exception
                goto L5e
            L28:
                kotlin.ResultKt.throwOnFailure(r6)
                kotlin.jvm.functions.Function2<Q, kotlin.coroutines.Continuation<? super com.apollographql.apollo3.api.ApolloResponse<D>>, java.lang.Object> r6 = r5.$preliminaryDataProvider     // Catch: java.lang.Exception -> L26
                com.apollographql.apollo3.api.Query r2 = r5.$query     // Catch: java.lang.Exception -> L26
                r5.L$0 = r0     // Catch: java.lang.Exception -> L26
                r5.label = r4     // Catch: java.lang.Exception -> L26
                java.lang.Object r6 = r6.invoke(r2, r5)     // Catch: java.lang.Exception -> L26
                if (r6 != r1) goto L3a
                goto L5d
            L3a:
                com.apollographql.apollo3.api.ApolloResponse r6 = (com.apollographql.apollo3.api.ApolloResponse) r6     // Catch: java.lang.Exception -> L26
                if (r6 == 0) goto L67
                kotlinx.coroutines.channels.ProducerScope<com.apollographql.apollo3.api.ApolloResponse<D>> r2 = r5.$producerScope     // Catch: java.lang.Exception -> L26
                boolean r4 = kotlinx.coroutines.CoroutineScopeKt.isActive(r0)     // Catch: java.lang.Exception -> L26
                if (r4 == 0) goto L67
                java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)     // Catch: java.lang.Exception -> L26
                r5.L$0 = r0     // Catch: java.lang.Exception -> L26
                java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)     // Catch: java.lang.Exception -> L26
                r5.L$1 = r0     // Catch: java.lang.Exception -> L26
                r0 = 0
                r5.I$0 = r0     // Catch: java.lang.Exception -> L26
                r5.label = r3     // Catch: java.lang.Exception -> L26
                java.lang.Object r5 = r2.send(r6, r5)     // Catch: java.lang.Exception -> L26
                if (r5 != r1) goto L67
            L5d:
                return r1
            L5e:
                com.box.android.data.datasource.gql.BoxGraphQL r5 = r5.this$0
                java.lang.String r0 = "An exception occurred during execution preliminary data job"
                java.lang.Throwable r6 = (java.lang.Throwable) r6
                r5.logError(r0, r6)
            L67:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.gql.BoxGraphQL.C11521.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final <Q extends Query<D>, D extends Query.Data> Job preliminaryDataFromCache(Q query, Function2<? super Q, ? super Continuation<? super ApolloResponse<D>>, ? extends Object> preliminaryDataProvider, CoroutineDispatcher preliminaryDataDispatcher, ProducerScope<? super ApolloResponse<D>> producerScope) {
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(preliminaryDataProvider, "preliminaryDataProvider");
        Intrinsics.checkNotNullParameter(preliminaryDataDispatcher, "preliminaryDataDispatcher");
        Intrinsics.checkNotNullParameter(producerScope, "producerScope");
        return BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(preliminaryDataDispatcher), null, null, new C11521(preliminaryDataProvider, query, this, producerScope, null), 3, null);
    }

    public final <Q extends Query<D>, D extends Query.Data> Object watchCacheAndSendResults(Q q, final Function0<Unit> function0, final ProducerScope<? super ApolloResponse<D>> producerScope, Continuation<? super Unit> continuation) {
        ApolloClient apolloClient = getApolloClient();
        Flow flowWatchCache$default = watchCache$default(this, apolloClient != null ? apolloClient.query(q) : null, null, 2, null);
        if (flowWatchCache$default != null) {
            Object objCollect = flowWatchCache$default.collect(new FlowCollector() { // from class: com.box.android.data.datasource.gql.BoxGraphQL.watchCacheAndSendResults.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                    return emit((ApolloResponse) obj, (Continuation<? super Unit>) continuation2);
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                public final Object emit(ApolloResponse<D> apolloResponse, Continuation<? super Unit> continuation2) {
                    function0.invoke();
                    Object objSend = producerScope.send(apolloResponse, continuation2);
                    return objSend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSend : Unit.INSTANCE;
                }
            }, continuation);
            return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Flow watchCache$default(BoxGraphQL boxGraphQL, ApolloCall apolloCall, FetchPolicy fetchPolicy, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: watchCache");
        }
        if ((i & 2) != 0) {
            fetchPolicy = FetchPolicy.CacheOnly;
        }
        return boxGraphQL.watchCache(apolloCall, fetchPolicy);
    }

    public final <D extends Query.Data> Flow<ApolloResponse<D>> watchCache(ApolloCall<D> call, FetchPolicy fetchPolicy) {
        ApolloCall apolloCall;
        Intrinsics.checkNotNullParameter(fetchPolicy, "fetchPolicy");
        if (call == null || (apolloCall = (ApolloCall) NormalizedCache.fetchPolicy(call, fetchPolicy)) == null) {
            return null;
        }
        return NormalizedCache.watch$default(apolloCall, false, false, 3, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final <D extends Query.Data> Object batch(Query<D> query, DebouncePolicy debouncePolicy, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Result error;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objPerformQuery = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objPerformQuery);
                if (debouncePolicy == DebouncePolicy.None || this.queryDebouncer.requestExecution(query)) {
                    anonymousClass1.L$0 = query;
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(debouncePolicy);
                    anonymousClass1.I$0 = 0;
                    anonymousClass1.I$1 = 0;
                    anonymousClass1.label = 1;
                    objPerformQuery = performQuery(query, anonymousClass1);
                    if (objPerformQuery == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = anonymousClass1.I$1;
            int i3 = anonymousClass1.I$0;
            query = (Query) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objPerformQuery);
            error = new Result.Success((ApolloResponse) objPerformQuery);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        boolean z = error instanceof Result.Success;
        if (z) {
            this.queryDebouncer.reportCompletion(query);
        } else if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!z) {
            if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            this.queryDebouncer.reportFailure(query);
        }
        return Unit.INSTANCE;
    }

    public final <D extends Query.Data> Object performQuery(Query<D> query, Continuation<? super ApolloResponse<D>> continuation) {
        ApolloCall<D> apolloCallQuery;
        ApolloClient apolloClient = getApolloClient();
        if (apolloClient == null || (apolloCallQuery = apolloClient.query(query)) == null) {
            return null;
        }
        Object objExecute = apolloCallQuery.execute(continuation);
        return objExecute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objExecute : (ApolloResponse) objExecute;
    }

    public final void logError(String errorMessage, Throwable error) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        Intrinsics.checkNotNullParameter(error, "error");
        BoxLogUtils.e(ExtensionsKt.getTAG(this), errorMessage, error);
    }
}
