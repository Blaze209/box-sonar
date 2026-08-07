package com.box.android.data.datasource.collection;

import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;
import com.apollographql.apollo3.ApolloCall;
import com.apollographql.apollo3.api.ApolloResponse;
import com.apollographql.apollo3.api.Error;
import com.apollographql.apollo3.cache.normalized.FetchPolicy;
import com.apollographql.apollo3.cache.normalized.NormalizedCache;
import com.apollographql.apollo3.exception.ApolloException;
import com.box.android.data.GetAllCollectionsQuery;
import com.box.android.data.datasource.gql.BoxGraphQL;
import com.box.android.data.mappers.CollectionsQueryDomainMapper;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: GQLCollectionsDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B/\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0011\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u0013J*\u0010\u0014\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0018H\u0016J$\u0010\u0019\u001a\u00020\u00122\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0087@¢\u0006\u0002\u0010\u0013J*\u0010\u001f\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020 2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030!H\u0016J*\u0010\"\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020 2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030!H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/box/android/data/datasource/collection/GQLCollectionsDataSource;", "Landroidx/paging/PageKeyedDataSource;", "", "Lcom/box/android/domain/models/CollectionModel;", "graphQL", "Lcom/box/android/data/datasource/gql/BoxGraphQL;", "collectionTypes", "", "Lcom/box/android/domain/models/CollectionType;", "comparator", "Ljava/util/Comparator;", "<init>", "(Lcom/box/android/data/datasource/gql/BoxGraphQL;Ljava/util/List;Ljava/util/Comparator;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "lastFetchedData", "Lcom/box/android/data/GetAllCollectionsQuery$Collections;", "watchQuery", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadInitial", SerializedNames.PARAMS, "Landroidx/paging/PageKeyedDataSource$LoadInitialParams;", "callback", "Landroidx/paging/PageKeyedDataSource$LoadInitialCallback;", "onLoadInitialError", "errorMessage", "", "getAllCollectionsQuery", "Lcom/apollographql/apollo3/api/ApolloResponse;", "Lcom/box/android/data/GetAllCollectionsQuery$Data;", "loadBefore", "Landroidx/paging/PageKeyedDataSource$LoadParams;", "Landroidx/paging/PageKeyedDataSource$LoadCallback;", "loadAfter", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLCollectionsDataSource extends PageKeyedDataSource<Integer, CollectionModel> {
    private final List<CollectionType> collectionTypes;
    private final Comparator<CollectionModel> comparator;
    private final CoroutineScope coroutineScope;
    private final BoxGraphQL graphQL;
    private GetAllCollectionsQuery.Collections lastFetchedData;

    /* JADX INFO: renamed from: com.box.android.data.datasource.collection.GQLCollectionsDataSource$watchQuery$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GQLCollectionsDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.collection.GQLCollectionsDataSource", f = "GQLCollectionsDataSource.kt", i = {}, l = {49}, m = "watchQuery", n = {}, s = {}, v = 1)
    static final class C11311 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C11311(Continuation<? super C11311> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GQLCollectionsDataSource.this.watchQuery(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Inject
    public GQLCollectionsDataSource(BoxGraphQL graphQL, List<? extends CollectionType> collectionTypes, Comparator<CollectionModel> comparator) {
        Intrinsics.checkNotNullParameter(graphQL, "graphQL");
        Intrinsics.checkNotNullParameter(collectionTypes, "collectionTypes");
        this.graphQL = graphQL;
        this.collectionTypes = collectionTypes;
        this.comparator = comparator;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        this.coroutineScope = CoroutineScope;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScope, null, null, new AnonymousClass1(null), 3, null);
        addInvalidatedCallback(new DataSource.InvalidatedCallback() { // from class: com.box.android.data.datasource.collection.GQLCollectionsDataSource$$ExternalSyntheticLambda0
            @Override // androidx.paging.DataSource.InvalidatedCallback
            public final void onInvalidated() {
                GQLCollectionsDataSource._init_$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.collection.GQLCollectionsDataSource$1, reason: invalid class name */
    /* JADX INFO: compiled from: GQLCollectionsDataSource.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.collection.GQLCollectionsDataSource$1", f = "GQLCollectionsDataSource.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GQLCollectionsDataSource.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (GQLCollectionsDataSource.this.watchQuery(this) == coroutine_suspended) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(GQLCollectionsDataSource gQLCollectionsDataSource) {
        CoroutineScopeKt.cancel$default(gQLCollectionsDataSource.coroutineScope, null, 1, null);
        BoxLogUtils.d(ExtensionsKt.getTAG(gQLCollectionsDataSource), "Invalidated, cancelling coroutineScope");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object watchQuery(Continuation<? super Unit> continuation) {
        C11311 c11311;
        ApolloCall apolloCall;
        Flow flowWatch$default;
        if (continuation instanceof C11311) {
            c11311 = (C11311) continuation;
            if ((c11311.label & Integer.MIN_VALUE) != 0) {
                c11311.label -= Integer.MIN_VALUE;
            } else {
                c11311 = new C11311(continuation);
            }
        } else {
            c11311 = new C11311(continuation);
        }
        Object obj = c11311.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11311.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                BoxLogUtils.v(ExtensionsKt.getTAG(this), "Watching QUERY...");
                ApolloCall<GetAllCollectionsQuery.Data> allCollectionsQueryFromCache = this.graphQL.getAllCollectionsQueryFromCache();
                if (allCollectionsQueryFromCache != null && (apolloCall = (ApolloCall) NormalizedCache.refetchPolicy(allCollectionsQueryFromCache, FetchPolicy.CacheOnly)) != null && (flowWatch$default = NormalizedCache.watch$default(apolloCall, false, false, 3, (Object) null)) != null) {
                    FlowCollector flowCollector = new FlowCollector() { // from class: com.box.android.data.datasource.collection.GQLCollectionsDataSource.watchQuery.2
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation2) {
                            return emit((ApolloResponse<GetAllCollectionsQuery.Data>) obj2, (Continuation<? super Unit>) continuation2);
                        }

                        public final Object emit(ApolloResponse<GetAllCollectionsQuery.Data> apolloResponse, Continuation<? super Unit> continuation2) {
                            String str;
                            GetAllCollectionsQuery.Collections collections;
                            boolean zIsFromCache = NormalizedCache.isFromCache(apolloResponse);
                            if (zIsFromCache) {
                                str = "Cache";
                            } else {
                                if (zIsFromCache) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                str = "Network";
                            }
                            BoxLogUtils.v(ExtensionsKt.getTAG(GQLCollectionsDataSource.this), "QUERY Watcher collected response (" + str + ")");
                            GetAllCollectionsQuery.Data data = (GetAllCollectionsQuery.Data) apolloResponse.data;
                            if (data != null && (collections = data.getCollections()) != null) {
                                GQLCollectionsDataSource gQLCollectionsDataSource = GQLCollectionsDataSource.this;
                                if (!Intrinsics.areEqual(collections, gQLCollectionsDataSource.lastFetchedData)) {
                                    BoxLogUtils.d(ExtensionsKt.getTAG(gQLCollectionsDataSource), "Invalidating...");
                                    gQLCollectionsDataSource.invalidate();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    c11311.label = 1;
                    if (flowWatch$default.collect(flowCollector, c11311) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (ApolloException e) {
            BoxLogUtils.w("Exception when watching All Collections query: " + e.getCause());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.collection.GQLCollectionsDataSource$loadInitial$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GQLCollectionsDataSource.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.collection.GQLCollectionsDataSource$loadInitial$1", f = "GQLCollectionsDataSource.kt", i = {0}, l = {71}, m = "invokeSuspend", n = {"$this$runBlocking"}, s = {"L$0"}, v = 1)
    static final class C11301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PageKeyedDataSource.LoadInitialCallback<Integer, CollectionModel> $callback;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11301(PageKeyedDataSource.LoadInitialCallback<Integer, CollectionModel> loadInitialCallback, Continuation<? super C11301> continuation) {
            super(2, continuation);
            this.$callback = loadInitialCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C11301 c11301 = GQLCollectionsDataSource.this.new C11301(this.$callback, continuation);
            c11301.L$0 = obj;
            return c11301;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11301) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r9v17, types: [T, java.util.List] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            T tEmptyList;
            GetAllCollectionsQuery.Data data;
            GetAllCollectionsQuery.Collections collections;
            List<GetAllCollectionsQuery.Edge> edges;
            GetAllCollectionsQuery.Data data2;
            List<Error> list;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    BoxLogUtils.v(ExtensionsKt.getTAG(coroutineScope), "Getting collections from cache...");
                    this.L$0 = coroutineScope;
                    this.label = 1;
                    obj = GQLCollectionsDataSource.this.getAllCollectionsQuery(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ApolloResponse apolloResponse = (ApolloResponse) obj;
                BoxLogUtils.v(ExtensionsKt.getTAG(coroutineScope), "Got collections from cache");
                if (apolloResponse == null || (list = apolloResponse.errors) == null) {
                    GQLCollectionsDataSource gQLCollectionsDataSource = GQLCollectionsDataSource.this;
                    PageKeyedDataSource.LoadInitialCallback<Integer, CollectionModel> loadInitialCallback = this.$callback;
                    gQLCollectionsDataSource.lastFetchedData = (apolloResponse == null || (data2 = (GetAllCollectionsQuery.Data) apolloResponse.data) == null) ? null : data2.getCollections();
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    if (apolloResponse == null || (data = (GetAllCollectionsQuery.Data) apolloResponse.data) == null || (collections = data.getCollections()) == null || (edges = collections.getEdges()) == null) {
                        tEmptyList = CollectionsKt.emptyList();
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (GetAllCollectionsQuery.Edge edge : edges) {
                            CollectionModel domain = CollectionsQueryDomainMapper.INSTANCE.toDomain(edge != null ? edge.getNode() : null);
                            if (domain != null) {
                                arrayList.add(domain);
                            }
                        }
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj2 : arrayList) {
                            if (gQLCollectionsDataSource.collectionTypes.contains(((CollectionModel) obj2).getType())) {
                                arrayList2.add(obj2);
                            }
                        }
                        tEmptyList = arrayList2;
                    }
                    objectRef.element = tEmptyList;
                    Comparator comparator = gQLCollectionsDataSource.comparator;
                    if (comparator != null) {
                        objectRef.element = CollectionsKt.sortedWith((Iterable) objectRef.element, comparator);
                    }
                    BoxLogUtils.v(ExtensionsKt.getTAG(coroutineScope), "mapped collections (" + ((Collection) objectRef.element).size() + " items)");
                    loadInitialCallback.onResult(CollectionsKt.toMutableList((Collection) objectRef.element), 0, ((Collection) objectRef.element).size(), null, null);
                } else {
                    GQLCollectionsDataSource.this.onLoadInitialError(this.$callback, "calling error: " + ((Error) CollectionsKt.first((List) list)).getMessage());
                }
            } catch (ApolloException e) {
                GQLCollectionsDataSource.this.onLoadInitialError(this.$callback, "Could not load collections from cache: " + e);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadInitial(PageKeyedDataSource.LoadInitialParams<Integer> params, PageKeyedDataSource.LoadInitialCallback<Integer, CollectionModel> callback) throws InterruptedException {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__BuildersKt.runBlocking$default(null, new C11301(callback, null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLoadInitialError(PageKeyedDataSource.LoadInitialCallback<Integer, CollectionModel> callback, String errorMessage) {
        BoxLogUtils.w(ExtensionsKt.getTAG(this), errorMessage);
        callback.onResult(CollectionsKt.emptyList(), 0, 0, null, null);
    }

    public final Object getAllCollectionsQuery(Continuation<? super ApolloResponse<GetAllCollectionsQuery.Data>> continuation) {
        ApolloCall<GetAllCollectionsQuery.Data> allCollectionsQueryFromCache = this.graphQL.getAllCollectionsQueryFromCache();
        if (allCollectionsQueryFromCache == null) {
            return null;
        }
        Object objExecute = allCollectionsQueryFromCache.execute(continuation);
        return objExecute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objExecute : (ApolloResponse) objExecute;
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadBefore(PageKeyedDataSource.LoadParams<Integer> params, PageKeyedDataSource.LoadCallback<Integer, CollectionModel> callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.onResult(CollectionsKt.emptyList(), null);
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadAfter(PageKeyedDataSource.LoadParams<Integer> params, PageKeyedDataSource.LoadCallback<Integer, CollectionModel> callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.onResult(CollectionsKt.emptyList(), null);
    }
}
