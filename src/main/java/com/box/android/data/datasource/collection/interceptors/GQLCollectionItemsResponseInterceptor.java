package com.box.android.data.datasource.collection.interceptors;

import com.apollographql.apollo3.api.Error;
import com.apollographql.apollo3.cache.normalized.ApolloStore;
import com.apollographql.apollo3.exception.ApolloException;
import com.apollographql.apollo3.exception.CacheMissException;
import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.data.GetCollectionItemsQuery;
import com.box.android.data.api.models.items.IItemDTO;
import com.box.android.data.datasource.collection.CollectionItemsRemoteDataSource;
import com.box.android.data.datasource.errors.CollectionsRemoteError;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.datasource.gql.CustomAttributeKeys;
import com.box.android.data.datasource.gql.GQLBaseInterceptor;
import com.box.android.data.datasource.gql.GQLRequestParser;
import com.box.android.data.mappers.GQLCollectionItemEdgeToIItemDTOMapper;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.exceptions.AbortFlowCollectionException;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.squareup.moshi.Moshi;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import okhttp3.Interceptor;
import okhttp3.Response;

/* JADX INFO: compiled from: GQLCollectionItemsResponseInterceptor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00172\u0006\u0010\u001a\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010\u001bJJ\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d2\u0006\u0010\u001a\u001a\u00020\u00182\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190!H\u0082@¢\u0006\u0002\u0010#R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006$"}, d2 = {"Lcom/box/android/data/datasource/collection/interceptors/GQLCollectionItemsResponseInterceptor;", "Lcom/box/android/data/datasource/gql/GQLBaseInterceptor;", "collectionItemsRemoteDataSource", "Lcom/box/android/data/datasource/collection/CollectionItemsRemoteDataSource;", "requestParser", "Lcom/box/android/data/datasource/gql/GQLRequestParser;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/datasource/collection/CollectionItemsRemoteDataSource;Lcom/box/android/data/datasource/gql/GQLRequestParser;Lcom/squareup/moshi/Moshi;)V", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "apolloStore", "Lcom/apollographql/apollo3/cache/normalized/ApolloStore;", "getApolloStore", "()Lcom/apollographql/apollo3/cache/normalized/ApolloStore;", "setApolloStore", "(Lcom/apollographql/apollo3/cache/normalized/ApolloStore;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "fetchCachedItems", "", "", "Lcom/box/android/data/GetCollectionItemsQuery$Edge;", BoxItemJob.COLLECTION_ID, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCache", "Lcom/box/android/domain/utils/result/Result;", "", "Ljava/io/IOException;", "originalEdgesMap", "", "fetchedEdgesMap", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLCollectionItemsResponseInterceptor extends GQLBaseInterceptor {
    public ApolloStore apolloStore;
    private final CollectionItemsRemoteDataSource collectionItemsRemoteDataSource;
    private final Moshi moshi;
    private final GQLRequestParser requestParser;

    /* JADX INFO: renamed from: com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor$fetchCachedItems$1, reason: invalid class name */
    /* JADX INFO: compiled from: GQLCollectionItemsResponseInterceptor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor", f = "GQLCollectionItemsResponseInterceptor.kt", i = {0}, l = {Token.COLONCOLON}, m = "fetchCachedItems", n = {BoxItemJob.COLLECTION_ID}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GQLCollectionItemsResponseInterceptor.this.fetchCachedItems(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor$updateCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GQLCollectionItemsResponseInterceptor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor", f = "GQLCollectionItemsResponseInterceptor.kt", i = {0, 0, 0, 0}, l = {177}, m = "updateCache", n = {BoxItemJob.COLLECTION_ID, "originalEdgesMap", "fetchedEdgesMap", "mergedMap"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class C11331 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C11331(Continuation<? super C11331> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GQLCollectionItemsResponseInterceptor.this.updateCache(null, null, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GQLCollectionItemsResponseInterceptor(CollectionItemsRemoteDataSource collectionItemsRemoteDataSource, GQLRequestParser requestParser, Moshi moshi) {
        super(moshi);
        Intrinsics.checkNotNullParameter(collectionItemsRemoteDataSource, "collectionItemsRemoteDataSource");
        Intrinsics.checkNotNullParameter(requestParser, "requestParser");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.collectionItemsRemoteDataSource = collectionItemsRemoteDataSource;
        this.requestParser = requestParser;
        this.moshi = moshi;
    }

    @Override // com.box.android.data.datasource.gql.GQLBaseInterceptor
    public Moshi getMoshi() {
        return this.moshi;
    }

    public final ApolloStore getApolloStore() {
        ApolloStore apolloStore = this.apolloStore;
        if (apolloStore != null) {
            return apolloStore;
        }
        Intrinsics.throwUninitializedPropertyAccessException("apolloStore");
        return null;
    }

    public final void setApolloStore(ApolloStore apolloStore) {
        Intrinsics.checkNotNullParameter(apolloStore, "<set-?>");
        this.apolloStore = apolloStore;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws InterruptedException, IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        String id = this.requestParser.parseId(chain.request());
        if (id == null) {
            throw new IOException("No Collection ID provided for the request!");
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        BuildersKt__BuildersKt.runBlocking$default(null, new C11321(id, linkedHashMap, objectRef2, objectRef, null), 1, null);
        if (objectRef.element != 0) {
            T t = objectRef.element;
            Intrinsics.checkNotNull(t, "null cannot be cast to non-null type java.io.IOException");
            throw ((IOException) t);
        }
        return getResponse(200, chain.request(), (Error) objectRef2.element, new GetCollectionItemsQuery.Data(new GetCollectionItemsQuery.Collection(id, new GetCollectionItemsQuery.CollectionItemConnection(CollectionsKt.toList(linkedHashMap.values())))));
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor$intercept$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GQLCollectionItemsResponseInterceptor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor$intercept$1", f = "GQLCollectionItemsResponseInterceptor.kt", i = {1, 1}, l = {53, 81}, m = "invokeSuspend", n = {"originalEdgesMap", CustomAttributeKeys.REMOTE_ERROR}, s = {"L$0", "L$1"}, v = 1)
    static final class C11321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $collectionId;
        final /* synthetic */ Map<String, GetCollectionItemsQuery.Edge> $fetchedEdgesMap;
        final /* synthetic */ Ref.ObjectRef<Error> $responseError;
        final /* synthetic */ Ref.ObjectRef<IOException> $thrownException;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11321(String str, Map<String, GetCollectionItemsQuery.Edge> map, Ref.ObjectRef<Error> objectRef, Ref.ObjectRef<IOException> objectRef2, Continuation<? super C11321> continuation) {
            super(2, continuation);
            this.$collectionId = str;
            this.$fetchedEdgesMap = map;
            this.$responseError = objectRef;
            this.$thrownException = objectRef2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GQLCollectionItemsResponseInterceptor.this.new C11321(this.$collectionId, this.$fetchedEdgesMap, this.$responseError, this.$thrownException, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C11321) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0098, code lost:
        
            if (kotlinx.coroutines.flow.FlowKt.onCompletion(kotlinx.coroutines.flow.FlowKt.m16356catch(kotlinx.coroutines.flow.FlowKt.onEach(r10.this$0.collectionItemsRemoteDataSource.getCollectionItems(r10.$collectionId), new com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor.C11321.C01611(r11, null)), new com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor.C11321.AnonymousClass2(r11, r10.this$0, null)), new com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor.C11321.AnonymousClass3(r11, null)).collect(new com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor.C11321.AnonymousClass4(r10.$fetchedEdgesMap, r10.this$0, r10.$collectionId, r7, r10.$responseError, r10.$thrownException), r10) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r10.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L27
                if (r1 == r3) goto L23
                if (r1 != r2) goto L1b
                java.lang.Object r0 = r10.L$1
                kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
                java.lang.Object r10 = r10.L$0
                java.util.Map r10 = (java.util.Map) r10
                kotlin.ResultKt.throwOnFailure(r11)
                goto L9b
            L1b:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L23:
                kotlin.ResultKt.throwOnFailure(r11)
                goto L3a
            L27:
                kotlin.ResultKt.throwOnFailure(r11)
                com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor r11 = com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor.this
                java.lang.String r1 = r10.$collectionId
                r4 = r10
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r10.label = r3
                java.lang.Object r11 = com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor.access$fetchCachedItems(r11, r1, r4)
                if (r11 != r0) goto L3a
                goto L9a
            L3a:
                r7 = r11
                java.util.Map r7 = (java.util.Map) r7
                kotlin.jvm.internal.Ref$ObjectRef r11 = new kotlin.jvm.internal.Ref$ObjectRef
                r11.<init>()
                com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor r1 = com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor.this
                com.box.android.data.datasource.collection.CollectionItemsRemoteDataSource r1 = com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor.access$getCollectionItemsRemoteDataSource$p(r1)
                java.lang.String r3 = r10.$collectionId
                kotlinx.coroutines.flow.Flow r1 = r1.getCollectionItems(r3)
                com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor$intercept$1$1 r3 = new com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor$intercept$1$1
                r4 = 0
                r3.<init>(r11, r4)
                kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
                kotlinx.coroutines.flow.Flow r1 = kotlinx.coroutines.flow.FlowKt.onEach(r1, r3)
                com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor$intercept$1$2 r3 = new com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor$intercept$1$2
                com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor r5 = com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor.this
                r3.<init>(r11, r5, r4)
                kotlin.jvm.functions.Function3 r3 = (kotlin.jvm.functions.Function3) r3
                kotlinx.coroutines.flow.Flow r1 = kotlinx.coroutines.flow.FlowKt.m16356catch(r1, r3)
                com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor$intercept$1$3 r3 = new com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor$intercept$1$3
                r3.<init>(r11, r4)
                kotlin.jvm.functions.Function3 r3 = (kotlin.jvm.functions.Function3) r3
                kotlinx.coroutines.flow.Flow r1 = kotlinx.coroutines.flow.FlowKt.onCompletion(r1, r3)
                com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor$intercept$1$4 r3 = new com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor$intercept$1$4
                java.util.Map<java.lang.String, com.box.android.data.GetCollectionItemsQuery$Edge> r4 = r10.$fetchedEdgesMap
                com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor r5 = com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor.this
                java.lang.String r6 = r10.$collectionId
                kotlin.jvm.internal.Ref$ObjectRef<com.apollographql.apollo3.api.Error> r8 = r10.$responseError
                kotlin.jvm.internal.Ref$ObjectRef<java.io.IOException> r9 = r10.$thrownException
                r3.<init>(r4, r5, r6, r7, r8, r9)
                kotlinx.coroutines.flow.FlowCollector r3 = (kotlinx.coroutines.flow.FlowCollector) r3
                r4 = r10
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                r10.L$0 = r5
                java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
                r10.L$1 = r11
                r10.label = r2
                java.lang.Object r10 = r1.collect(r3, r4)
                if (r10 != r0) goto L9b
            L9a:
                return r0
            L9b:
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor.C11321.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor$intercept$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: GQLCollectionItemsResponseInterceptor.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003H\n"}, d2 = {"<anonymous>", "", "itemDTOListResult", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/items/IItemDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor$intercept$1$1", f = "GQLCollectionItemsResponseInterceptor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C01611 extends SuspendLambda implements Function2<Result<? extends List<? extends IItemDTO>, ? extends RemoteError>, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<RemoteError> $remoteError;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01611(Ref.ObjectRef<RemoteError> objectRef, Continuation<? super C01611> continuation) {
                super(2, continuation);
                this.$remoteError = objectRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C01611 c01611 = new C01611(this.$remoteError, continuation);
                c01611.L$0 = obj;
                return c01611;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Result<? extends List<? extends IItemDTO>, ? extends RemoteError> result, Continuation<? super Unit> continuation) {
                return ((C01611) create(result, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Type inference failed for: r3v5, types: [T, com.box.android.data.datasource.errors.RemoteError] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws AbortFlowCollectionException {
                Result result = (Result) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef<RemoteError> objectRef = this.$remoteError;
                if (result instanceof Result.Success) {
                    return Unit.INSTANCE;
                }
                if (result instanceof Result.Error) {
                    objectRef.element = (RemoteError) ((Result.Error) result).getValue();
                    throw new AbortFlowCollectionException("Fetching collection items from remote failed!", null, 2, null);
                }
                throw new NoWhenBranchMatchedException();
            }
        }

        /* JADX INFO: renamed from: com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor$intercept$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: GQLCollectionItemsResponseInterceptor.kt */
        @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u00022\u0006\u0010\u0007\u001a\u00020\bH\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/items/IItemDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "cause", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor$intercept$1$2", f = "GQLCollectionItemsResponseInterceptor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super Result<? extends List<? extends IItemDTO>, ? extends RemoteError>>, Throwable, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<RemoteError> $remoteError;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ GQLCollectionItemsResponseInterceptor this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Ref.ObjectRef<RemoteError> objectRef, GQLCollectionItemsResponseInterceptor gQLCollectionItemsResponseInterceptor, Continuation<? super AnonymousClass2> continuation) {
                super(3, continuation);
                this.$remoteError = objectRef;
                this.this$0 = gQLCollectionItemsResponseInterceptor;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(FlowCollector<? super Result<? extends List<? extends IItemDTO>, ? extends RemoteError>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$remoteError, this.this$0, continuation);
                anonymousClass2.L$0 = th;
                return anonymousClass2.invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                T tHandleException;
                Throwable th = (Throwable) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef<RemoteError> objectRef = this.$remoteError;
                RemoteError remoteError = objectRef.element;
                if (remoteError == null) {
                    tHandleException = remoteError;
                    tHandleException = this.this$0.handleException(th);
                }
                tHandleException = remoteError;
                objectRef.element = tHandleException;
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor$intercept$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: GQLCollectionItemsResponseInterceptor.kt */
        @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00030\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/api/models/items/IItemDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "cause", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor$intercept$1$3", f = "GQLCollectionItemsResponseInterceptor.kt", i = {0, 0, 0, 0}, l = {78}, m = "invokeSuspend", n = {"$this$onCompletion", "cause", "it", "$i$a$-let-GQLCollectionItemsResponseInterceptor$intercept$1$3$1"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
        static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super Result<? extends List<? extends IItemDTO>, ? extends RemoteError>>, Throwable, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<RemoteError> $remoteError;
            int I$0;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            Object L$2;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(Ref.ObjectRef<RemoteError> objectRef, Continuation<? super AnonymousClass3> continuation) {
                super(3, continuation);
                this.$remoteError = objectRef;
            }

            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(FlowCollector<? super Result<? extends List<? extends IItemDTO>, ? extends RemoteError>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$remoteError, continuation);
                anonymousClass3.L$0 = flowCollector;
                anonymousClass3.L$1 = th;
                return anonymousClass3.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                RemoteError remoteError;
                FlowCollector flowCollector = (FlowCollector) this.L$0;
                Throwable th = (Throwable) this.L$1;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    if ((th != null || this.$remoteError.element != null) && (remoteError = this.$remoteError.element) != null) {
                        Result.Error error = new Result.Error(remoteError);
                        this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(th);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(remoteError);
                        this.I$0 = 0;
                        this.label = 1;
                        if (flowCollector.emit(error, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
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

        /* JADX INFO: renamed from: com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor$intercept$1$4, reason: invalid class name */
        /* JADX INFO: compiled from: GQLCollectionItemsResponseInterceptor.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        static final class AnonymousClass4<T> implements FlowCollector {
            final /* synthetic */ String $collectionId;
            final /* synthetic */ Map<String, GetCollectionItemsQuery.Edge> $fetchedEdgesMap;
            final /* synthetic */ Map<String, GetCollectionItemsQuery.Edge> $originalEdgesMap;
            final /* synthetic */ Ref.ObjectRef<Error> $responseError;
            final /* synthetic */ Ref.ObjectRef<IOException> $thrownException;
            final /* synthetic */ GQLCollectionItemsResponseInterceptor this$0;

            AnonymousClass4(Map<String, GetCollectionItemsQuery.Edge> map, GQLCollectionItemsResponseInterceptor gQLCollectionItemsResponseInterceptor, String str, Map<String, GetCollectionItemsQuery.Edge> map2, Ref.ObjectRef<Error> objectRef, Ref.ObjectRef<IOException> objectRef2) {
                this.$fetchedEdgesMap = map;
                this.this$0 = gQLCollectionItemsResponseInterceptor;
                this.$collectionId = str;
                this.$originalEdgesMap = map2;
                this.$responseError = objectRef;
                this.$thrownException = objectRef2;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0014  */
            public final Object emit(Result<? extends List<? extends IItemDTO>, ? extends RemoteError> result, Continuation<? super Unit> continuation) {
                GQLCollectionItemsResponseInterceptor$intercept$1$4$emit$1 gQLCollectionItemsResponseInterceptor$intercept$1$4$emit$1;
                if (continuation instanceof GQLCollectionItemsResponseInterceptor$intercept$1$4$emit$1) {
                    gQLCollectionItemsResponseInterceptor$intercept$1$4$emit$1 = (GQLCollectionItemsResponseInterceptor$intercept$1$4$emit$1) continuation;
                    if ((gQLCollectionItemsResponseInterceptor$intercept$1$4$emit$1.label & Integer.MIN_VALUE) != 0) {
                        gQLCollectionItemsResponseInterceptor$intercept$1$4$emit$1.label -= Integer.MIN_VALUE;
                    } else {
                        gQLCollectionItemsResponseInterceptor$intercept$1$4$emit$1 = new GQLCollectionItemsResponseInterceptor$intercept$1$4$emit$1(this, continuation);
                    }
                } else {
                    gQLCollectionItemsResponseInterceptor$intercept$1$4$emit$1 = new GQLCollectionItemsResponseInterceptor$intercept$1$4$emit$1(this, continuation);
                }
                Object objUpdateCache = gQLCollectionItemsResponseInterceptor$intercept$1$4$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = gQLCollectionItemsResponseInterceptor$intercept$1$4$emit$1.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(objUpdateCache);
                    if (result instanceof Result.Success) {
                        Result.Success success = (Result.Success) result;
                        if (!((Collection) success.getValue()).isEmpty()) {
                            Iterable iterable = (Iterable) success.getValue();
                            String str = this.$collectionId;
                            ArrayList arrayList = new ArrayList();
                            Iterator<T> it = iterable.iterator();
                            while (it.hasNext()) {
                                GetCollectionItemsQuery.Edge graphQL = GQLCollectionItemEdgeToIItemDTOMapper.INSTANCE.toGraphQL((IItemDTO) it.next(), (Object) str);
                                if (graphQL != null) {
                                    arrayList.add(graphQL);
                                }
                            }
                            ArrayList arrayList2 = arrayList;
                            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList2, 10)), 16));
                            for (T t : arrayList2) {
                                String id = ((GetCollectionItemsQuery.Edge) t).getId();
                                Intrinsics.checkNotNull(id);
                                linkedHashMap.put(id, t);
                            }
                            this.$fetchedEdgesMap.putAll(linkedHashMap);
                            GQLCollectionItemsResponseInterceptor gQLCollectionItemsResponseInterceptor = this.this$0;
                            String str2 = this.$collectionId;
                            Map<String, GetCollectionItemsQuery.Edge> map = this.$originalEdgesMap;
                            Map<String, GetCollectionItemsQuery.Edge> map2 = this.$fetchedEdgesMap;
                            gQLCollectionItemsResponseInterceptor$intercept$1$4$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(result);
                            gQLCollectionItemsResponseInterceptor$intercept$1$4$emit$1.L$1 = SpillingKt.nullOutSpilledVariable(linkedHashMap);
                            gQLCollectionItemsResponseInterceptor$intercept$1$4$emit$1.label = 1;
                            objUpdateCache = gQLCollectionItemsResponseInterceptor.updateCache(str2, map, map2, gQLCollectionItemsResponseInterceptor$intercept$1$4$emit$1);
                            if (objUpdateCache == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (!(result instanceof Result.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        Result.Error error = (Result.Error) result;
                        if (((RemoteError) error.getValue()) instanceof CollectionsRemoteError) {
                            Ref.ObjectRef<Error> objectRef = this.$responseError;
                            GQLCollectionItemsResponseInterceptor gQLCollectionItemsResponseInterceptor2 = this.this$0;
                            Object value = error.getValue();
                            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type com.box.android.data.datasource.errors.CollectionsRemoteError");
                            objectRef.element = (T) gQLCollectionItemsResponseInterceptor2.getError((CollectionsRemoteError) value);
                        } else {
                            this.$thrownException.element = (T) new IOException(error.getValue() + " Code: " + ((RemoteError) error.getValue()).getCode());
                        }
                    }
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objUpdateCache);
                Result result2 = (Result) objUpdateCache;
                Ref.ObjectRef<IOException> objectRef2 = this.$thrownException;
                if (!(result2 instanceof Result.Success)) {
                    if (result2 instanceof Result.Error) {
                        objectRef2.element = (T) ((IOException) ((Result.Error) result2).getValue());
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                return Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((Result<? extends List<? extends IItemDTO>, ? extends RemoteError>) obj, (Continuation<? super Unit>) continuation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object fetchCachedItems(String str, Continuation<? super Map<String, GetCollectionItemsQuery.Edge>> continuation) {
        AnonymousClass1 anonymousClass1;
        GetCollectionItemsQuery.CollectionItemConnection collectionItemConnection;
        List<GetCollectionItemsQuery.Edge> edges;
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
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object operation$default = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(operation$default);
                ApolloStore apolloStore = getApolloStore();
                GetCollectionItemsQuery getCollectionItemsQuery = new GetCollectionItemsQuery(str);
                anonymousClass2.L$0 = str;
                anonymousClass2.label = 1;
                operation$default = ApolloStore.DefaultImpls.readOperation$default(apolloStore, getCollectionItemsQuery, null, null, anonymousClass2, 6, null);
                if (operation$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(operation$default);
            }
            GetCollectionItemsQuery.Data data = (GetCollectionItemsQuery.Data) operation$default;
            if (data == null) {
                return new LinkedHashMap();
            }
            GetCollectionItemsQuery.Collection collection = data.getCollection();
            if (collection != null && (collectionItemConnection = collection.getCollectionItemConnection()) != null && (edges = collectionItemConnection.getEdges()) != null) {
                List<GetCollectionItemsQuery.Edge> list = edges;
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
                for (Object obj : list) {
                    String id = ((GetCollectionItemsQuery.Edge) obj).getId();
                    Intrinsics.checkNotNull(id);
                    linkedHashMap.put(id, obj);
                }
                Map mutableMap = MapsKt.toMutableMap(linkedHashMap);
                if (mutableMap != null) {
                    return mutableMap;
                }
            }
            return new LinkedHashMap();
        } catch (CacheMissException unused) {
            BoxLogUtils.d(ExtensionsKt.getTAG(this), "Cache miss reading collection items for collection " + str + ", proceeding with network fetch");
            return new LinkedHashMap();
        } catch (ApolloException e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Unexpected cache error reading collection " + str, e);
            return new LinkedHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object updateCache(String str, Map<String, GetCollectionItemsQuery.Edge> map, Map<String, GetCollectionItemsQuery.Edge> map2, Continuation<? super Result<Unit, ? extends IOException>> continuation) {
        C11331 c11331;
        if (continuation instanceof C11331) {
            c11331 = (C11331) continuation;
            if ((c11331.label & Integer.MIN_VALUE) != 0) {
                c11331.label -= Integer.MIN_VALUE;
            } else {
                c11331 = new C11331(continuation);
            }
        } else {
            c11331 = new C11331(continuation);
        }
        C11331 c11332 = c11331;
        Object obj = c11332.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11332.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Map mapPlus = MapsKt.plus(map, map2);
                ApolloStore apolloStore = getApolloStore();
                GetCollectionItemsQuery getCollectionItemsQuery = new GetCollectionItemsQuery(str);
                GetCollectionItemsQuery.Data data = new GetCollectionItemsQuery.Data(new GetCollectionItemsQuery.Collection(str, new GetCollectionItemsQuery.CollectionItemConnection(CollectionsKt.toList(mapPlus.values()))));
                c11332.L$0 = str;
                c11332.L$1 = SpillingKt.nullOutSpilledVariable(map);
                c11332.L$2 = SpillingKt.nullOutSpilledVariable(map2);
                c11332.L$3 = SpillingKt.nullOutSpilledVariable(mapPlus);
                c11332.label = 1;
                if (ApolloStore.DefaultImpls.writeOperation$default(apolloStore, getCollectionItemsQuery, data, null, null, false, c11332, 28, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = (String) c11332.L$0;
                ResultKt.throwOnFailure(obj);
            }
            return new Result.Success(Unit.INSTANCE);
        } catch (ApolloException e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Failed to update cache for collection " + str, e);
            return new Result.Error(new IOException(e.getMessage()));
        }
    }
}
