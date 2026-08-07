package com.box.android.data.datasource.gql.cache.partial;

import com.apollographql.apollo3.api.ApolloResponse;
import com.apollographql.apollo3.api.Error;
import com.apollographql.apollo3.cache.normalized.ApolloStore;
import com.box.android.data.GetFolderItemsQuery;
import com.box.android.data.datasource.CacheError;
import com.box.android.data.datasource.gql.GQLCache;
import com.box.android.data.datasource.gql.cache.GQLCacheConstants;
import com.box.android.data.datasource.gql.cache.partial.models.PartialFolderItemConnection;
import com.box.android.data.datasource.gql.cache.partial.models.PartialMiniItem;
import com.box.android.data.fragment.ItemConnectionFragment;
import com.box.android.data.persistence.gql.GQLDbHelper;
import com.box.android.data.utilities.GQLCacheHelper;
import com.box.androidsdk.content.BoxException;
import com.facebook.react.modules.dialog.AlertFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
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
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;

/* JADX INFO: compiled from: GQLPartialDataExtractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u0013J\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0016H\u0087@¢\u0006\u0002\u0010\u001aJ$\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0007J\u001e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/box/android/data/datasource/gql/cache/partial/GQLPartialDataExtractor;", "", "gqlDbHelper", "Lcom/box/android/data/persistence/gql/GQLDbHelper;", "gqlPartialModelParser", "Lcom/box/android/data/datasource/gql/cache/partial/GQLPartialModelParser;", "gqlPartialMiniItemsSorter", "Lcom/box/android/data/datasource/gql/cache/partial/GQLPartialMiniItemsSorter;", "gqlCacheHelper", "Lcom/box/android/data/utilities/GQLCacheHelper;", "gqlCache", "Lcom/box/android/data/datasource/gql/GQLCache;", "<init>", "(Lcom/box/android/data/persistence/gql/GQLDbHelper;Lcom/box/android/data/datasource/gql/cache/partial/GQLPartialModelParser;Lcom/box/android/data/datasource/gql/cache/partial/GQLPartialMiniItemsSorter;Lcom/box/android/data/utilities/GQLCacheHelper;Lcom/box/android/data/datasource/gql/GQLCache;)V", "extractPartialFolderItemsFromCache", "Lcom/apollographql/apollo3/api/ApolloResponse;", "Lcom/box/android/data/GetFolderItemsQuery$Data;", "query", "Lcom/box/android/data/GetFolderItemsQuery;", "(Lcom/box/android/data/GetFolderItemsQuery;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractPartialFolderItemsFromCacheInternal", "hydratePartialItemsIntoEdges", "", "Lcom/box/android/data/fragment/ItemConnectionFragment$Edge;", "partialItems", "Lcom/box/android/data/datasource/gql/cache/partial/models/PartialMiniItem;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createApolloResponseWithPartialItems", "folderId", "", AlertFragment.ARG_ITEMS, "createApolloResponseWithException", "cacheError", "Lcom/box/android/data/datasource/CacheError;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLPartialDataExtractor {
    public static final int FOLDER_SIZE_FOR_PARTIAL_DATA = 500;
    public static final String GQL_CACHE_ERROR_KEY = "GQL_DB_ERROR_KEY";
    public static final int PARTIAL_DATA_FIRST_CHUNK_SIZE = 30;
    private final GQLCache gqlCache;
    private final GQLCacheHelper gqlCacheHelper;
    private final GQLDbHelper gqlDbHelper;
    private final GQLPartialMiniItemsSorter gqlPartialMiniItemsSorter;
    private final GQLPartialModelParser gqlPartialModelParser;

    /* JADX INFO: renamed from: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCache$1, reason: invalid class name */
    /* JADX INFO: compiled from: GQLPartialDataExtractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor", f = "GQLPartialDataExtractor.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {175, 47}, m = "extractPartialFolderItemsFromCache", n = {"query", "this_$iv", "$this$withLock_u24default$iv$iv", "$i$f$apolloStoreWithLock", "$i$f$withLock", "query", "this_$iv", "$this$withLock_u24default$iv$iv", "it", "$i$f$apolloStoreWithLock", "$i$f$withLock", "$i$a$-withLock$default-GQLCache$apolloStoreWithLock$2$iv", "$i$a$-apolloStoreWithLock-GQLPartialDataExtractor$extractPartialFolderItemsFromCache$2"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GQLPartialDataExtractor.this.extractPartialFolderItemsFromCache(null, this);
        }
    }

    @Inject
    public GQLPartialDataExtractor(GQLDbHelper gqlDbHelper, GQLPartialModelParser gqlPartialModelParser, GQLPartialMiniItemsSorter gqlPartialMiniItemsSorter, GQLCacheHelper gqlCacheHelper, GQLCache gqlCache) {
        Intrinsics.checkNotNullParameter(gqlDbHelper, "gqlDbHelper");
        Intrinsics.checkNotNullParameter(gqlPartialModelParser, "gqlPartialModelParser");
        Intrinsics.checkNotNullParameter(gqlPartialMiniItemsSorter, "gqlPartialMiniItemsSorter");
        Intrinsics.checkNotNullParameter(gqlCacheHelper, "gqlCacheHelper");
        Intrinsics.checkNotNullParameter(gqlCache, "gqlCache");
        this.gqlDbHelper = gqlDbHelper;
        this.gqlPartialModelParser = gqlPartialModelParser;
        this.gqlPartialMiniItemsSorter = gqlPartialMiniItemsSorter;
        this.gqlCacheHelper = gqlCacheHelper;
        this.gqlCache = gqlCache;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object extractPartialFolderItemsFromCache(GetFolderItemsQuery getFolderItemsQuery, Continuation<? super ApolloResponse<GetFolderItemsQuery.Data>> continuation) {
        AnonymousClass1 anonymousClass1;
        GQLCache gQLCache;
        Mutex mutex;
        int i;
        int i2;
        Mutex mutex2;
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = anonymousClass1.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                gQLCache = this.gqlCache;
                mutex = gQLCache.getMutex();
                anonymousClass1.L$0 = getFolderItemsQuery;
                anonymousClass1.L$1 = gQLCache;
                anonymousClass1.L$2 = mutex;
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = 0;
                anonymousClass1.label = 1;
                if (mutex.lock(null, anonymousClass1) != coroutine_suspended) {
                    i = 0;
                    i2 = 0;
                }
                return coroutine_suspended;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i4 = anonymousClass1.I$3;
                int i5 = anonymousClass1.I$2;
                int i6 = anonymousClass1.I$1;
                int i7 = anonymousClass1.I$0;
                mutex2 = (Mutex) anonymousClass1.L$2;
                try {
                    ResultKt.throwOnFailure(obj);
                    ApolloResponse apolloResponse = (ApolloResponse) obj;
                    mutex2.unlock(null);
                    return apolloResponse;
                } catch (Throwable th) {
                    th = th;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            int i8 = anonymousClass1.I$1;
            int i9 = anonymousClass1.I$0;
            Mutex mutex3 = (Mutex) anonymousClass1.L$2;
            gQLCache = (GQLCache) anonymousClass1.L$1;
            GetFolderItemsQuery getFolderItemsQuery2 = (GetFolderItemsQuery) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            i2 = i9;
            i = i8;
            getFolderItemsQuery = getFolderItemsQuery2;
            ApolloStore apolloStore = gQLCache.getApolloStore();
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(getFolderItemsQuery);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(gQLCache);
            anonymousClass1.L$2 = mutex;
            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(apolloStore);
            anonymousClass1.I$0 = i2;
            anonymousClass1.I$1 = i;
            anonymousClass1.I$2 = 0;
            anonymousClass1.I$3 = 0;
            anonymousClass1.label = 2;
            Object objExtractPartialFolderItemsFromCacheInternal = extractPartialFolderItemsFromCacheInternal(getFolderItemsQuery, anonymousClass1);
            if (objExtractPartialFolderItemsFromCacheInternal != coroutine_suspended) {
                Mutex mutex4 = mutex;
                obj = objExtractPartialFolderItemsFromCacheInternal;
                mutex2 = mutex4;
                ApolloResponse apolloResponse2 = (ApolloResponse) obj;
                mutex2.unlock(null);
                return apolloResponse2;
            }
            return coroutine_suspended;
        } catch (Throwable th2) {
            th = th2;
            mutex2 = mutex;
            mutex2.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object extractPartialFolderItemsFromCacheInternal(GetFolderItemsQuery getFolderItemsQuery, Continuation<? super ApolloResponse<GetFolderItemsQuery.Data>> continuation) {
        final String id = getFolderItemsQuery.getId();
        final Flow flowFlowOf = FlowKt.flowOf(id);
        final Flow<String> flow = new Flow<String>() { // from class: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$map$1

            /* JADX INFO: renamed from: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ GQLPartialDataExtractor this$0;

                /* JADX INFO: renamed from: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$map$1$2", f = "GQLPartialDataExtractor.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, GQLPartialDataExtractor gQLPartialDataExtractor) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = gQLPartialDataExtractor;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        String strExtractFolderItemConnectionAsJsonString = this.this$0.gqlDbHelper.extractFolderItemConnectionAsJsonString((String) obj);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(strExtractFolderItemConnectionAsJsonString, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super String> flowCollector, Continuation continuation2) {
                Object objCollect = flowFlowOf.collect(new AnonymousClass2(flowCollector, this), continuation2);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
        final Flow<PartialFolderItemConnection> flow2 = new Flow<PartialFolderItemConnection>() { // from class: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$mapNotNull$1

            /* JADX INFO: renamed from: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$mapNotNull$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ GQLPartialDataExtractor this$0;

                /* JADX INFO: renamed from: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$mapNotNull$1$2", f = "GQLPartialDataExtractor.kt", i = {0, 0, 0, 0, 0, 0}, l = {57}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, GQLPartialDataExtractor gQLPartialDataExtractor) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = gQLPartialDataExtractor;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) throws BoxException.CacheResultUnavailable {
                    AnonymousClass1 anonymousClass1;
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        String str = (String) obj;
                        if (str != null) {
                            PartialFolderItemConnection partialFolderItemConnection = this.this$0.gqlPartialModelParser.parsePartialFolderItemConnection(str);
                            if (partialFolderItemConnection != null) {
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(partialFolderItemConnection);
                                anonymousClass1.I$0 = 0;
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(partialFolderItemConnection, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        } else {
                            throw new BoxException.CacheResultUnavailable();
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super PartialFolderItemConnection> flowCollector, Continuation continuation2) {
                Object objCollect = flow.collect(new AnonymousClass2(flowCollector, this), continuation2);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
        final Flow<PartialFolderItemConnection> flow3 = new Flow<PartialFolderItemConnection>() { // from class: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$filter$1

            /* JADX INFO: renamed from: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$filter$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$filter$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$filter$1$2", f = "GQLPartialDataExtractor.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$filter_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$filter$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        if (((PartialFolderItemConnection) obj).getTotalCount() >= 500) {
                            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.I$0 = 0;
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super PartialFolderItemConnection> flowCollector, Continuation continuation2) {
                Object objCollect = flow2.collect(new AnonymousClass2(flowCollector), continuation2);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
        final Flow<List<? extends String>> flow4 = new Flow<List<? extends String>>() { // from class: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$map$2

            /* JADX INFO: renamed from: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$map$2$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ GQLPartialDataExtractor this$0;

                /* JADX INFO: renamed from: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$map$2$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$map$2$2", f = "GQLPartialDataExtractor.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, GQLPartialDataExtractor gQLPartialDataExtractor) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = gQLPartialDataExtractor;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        List<String> cacheKeyListForNodes = this.this$0.gqlPartialModelParser.parseCacheKeyListForNodes((PartialFolderItemConnection) obj);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(cacheKeyListForNodes, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends String>> flowCollector, Continuation continuation2) {
                Object objCollect = flow3.collect(new AnonymousClass2(flowCollector, this), continuation2);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
        final Flow<List<? extends String>> flow5 = new Flow<List<? extends String>>() { // from class: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$map$3

            /* JADX INFO: renamed from: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$map$3$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ GQLPartialDataExtractor this$0;

                /* JADX INFO: renamed from: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$map$3$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$map$3$2", f = "GQLPartialDataExtractor.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, GQLPartialDataExtractor gQLPartialDataExtractor) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = gQLPartialDataExtractor;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        List<String> listBatchExtractDbRowsAsJsonString = this.this$0.gqlDbHelper.batchExtractDbRowsAsJsonString((List) obj);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(listBatchExtractDbRowsAsJsonString, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends String>> flowCollector, Continuation continuation2) {
                Object objCollect = flow4.collect(new AnonymousClass2(flowCollector, this), continuation2);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
        final Flow<List<? extends PartialMiniItem>> flow6 = new Flow<List<? extends PartialMiniItem>>() { // from class: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$map$4

            /* JADX INFO: renamed from: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$map$4$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ GQLPartialDataExtractor this$0;

                /* JADX INFO: renamed from: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$map$4$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$map$4$2", f = "GQLPartialDataExtractor.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, GQLPartialDataExtractor gQLPartialDataExtractor) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = gQLPartialDataExtractor;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        List<PartialMiniItem> partialMiniItems = this.this$0.gqlPartialModelParser.parsePartialMiniItems((List) obj);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(partialMiniItems, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends PartialMiniItem>> flowCollector, Continuation continuation2) {
                Object objCollect = flow5.collect(new AnonymousClass2(flowCollector, this), continuation2);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
        final Flow<List<? extends PartialMiniItem>> flow7 = new Flow<List<? extends PartialMiniItem>>() { // from class: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$map$5

            /* JADX INFO: renamed from: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$map$5$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ GQLPartialDataExtractor this$0;

                /* JADX INFO: renamed from: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$map$5$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$map$5$2", f = "GQLPartialDataExtractor.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, GQLPartialDataExtractor gQLPartialDataExtractor) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = gQLPartialDataExtractor;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        List<PartialMiniItem> listSortItems = this.this$0.gqlPartialMiniItemsSorter.sortItems((List) obj);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(listSortItems, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends PartialMiniItem>> flowCollector, Continuation continuation2) {
                Object objCollect = flow6.collect(new AnonymousClass2(flowCollector, this), continuation2);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
        final Flow<List<? extends ItemConnectionFragment.Edge>> flow8 = new Flow<List<? extends ItemConnectionFragment.Edge>>() { // from class: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$map$6

            /* JADX INFO: renamed from: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$map$6$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ GQLPartialDataExtractor this$0;

                /* JADX INFO: renamed from: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$map$6$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$map$6$2", f = "GQLPartialDataExtractor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {51, 50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$completion", "it", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1", "$i$a$-map-GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$9", "value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    int I$1;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, GQLPartialDataExtractor gQLPartialDataExtractor) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = gQLPartialDataExtractor;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                /* JADX WARN: Code restructure failed: missing block: B:21:0x00d3, code lost:
                
                    if (r8.emit(r9, r0) == r1) goto L22;
                 */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r8, kotlin.coroutines.Continuation r9) {
                    /*
                        Method dump skipped, instruction units count: 217
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$map$6.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends ItemConnectionFragment.Edge>> flowCollector, Continuation continuation2) {
                Object objCollect = flow7.collect(new AnonymousClass2(flowCollector, this), continuation2);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
        return FlowKt.firstOrNull(FlowKt.m16356catch(new Flow<ApolloResponse<GetFolderItemsQuery.Data>>() { // from class: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$map$7

            /* JADX INFO: renamed from: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$map$7$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ String $folderId$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ GQLPartialDataExtractor this$0;

                /* JADX INFO: renamed from: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$map$7$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$$inlined$map$7$2", f = "GQLPartialDataExtractor.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, GQLPartialDataExtractor gQLPartialDataExtractor, String str) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = gQLPartialDataExtractor;
                    this.$folderId$inlined = str;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        ApolloResponse<GetFolderItemsQuery.Data> apolloResponseCreateApolloResponseWithPartialItems = this.this$0.createApolloResponseWithPartialItems(this.$folderId$inlined, (List) obj);
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(apolloResponseCreateApolloResponseWithPartialItems, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i2 = anonymousClass1.I$0;
                        Object obj3 = anonymousClass1.L$2;
                        Object obj4 = anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super ApolloResponse<GetFolderItemsQuery.Data>> flowCollector, Continuation continuation2) {
                Object objCollect = flow8.collect(new AnonymousClass2(flowCollector, this, id), continuation2);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, new AnonymousClass11(id, null)), continuation);
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$11, reason: invalid class name */
    /* JADX INFO: compiled from: GQLPartialDataExtractor.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/apollographql/apollo3/api/ApolloResponse;", "Lcom/box/android/data/GetFolderItemsQuery$Data;", "it", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$11", f = "GQLPartialDataExtractor.kt", i = {0, 0, 0, 0}, l = {102}, m = "invokeSuspend", n = {"$this$catch", "it", "it", "$i$a$-let-GQLPartialDataExtractor$extractPartialFolderItemsFromCacheInternal$11$1"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
    static final class AnonymousClass11 extends SuspendLambda implements Function3<FlowCollector<? super ApolloResponse<GetFolderItemsQuery.Data>>, Throwable, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $folderId;
        int I$0;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass11(String str, Continuation<? super AnonymousClass11> continuation) {
            super(3, continuation);
            this.$folderId = str;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super ApolloResponse<GetFolderItemsQuery.Data>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass11 anonymousClass11 = GQLPartialDataExtractor.this.new AnonymousClass11(this.$folderId, continuation);
            anonymousClass11.L$0 = flowCollector;
            anonymousClass11.L$1 = th;
            return anonymousClass11.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Throwable th = (Throwable) this.L$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                BoxException.CacheResultUnavailable cacheResultUnavailable = th instanceof BoxException.CacheResultUnavailable ? (BoxException.CacheResultUnavailable) th : null;
                if (cacheResultUnavailable != null) {
                    ApolloResponse<GetFolderItemsQuery.Data> apolloResponseCreateApolloResponseWithException = GQLPartialDataExtractor.this.createApolloResponseWithException(this.$folderId, CacheError.NoResultFound.INSTANCE);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(th);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(cacheResultUnavailable);
                    this.I$0 = 0;
                    this.label = 1;
                    if (flowCollector.emit(apolloResponseCreateApolloResponseWithException, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$hydratePartialItemsIntoEdges$2, reason: invalid class name */
    /* JADX INFO: compiled from: GQLPartialDataExtractor.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/box/android/data/fragment/ItemConnectionFragment$Edge;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.gql.cache.partial.GQLPartialDataExtractor$hydratePartialItemsIntoEdges$2", f = "GQLPartialDataExtractor.kt", i = {0, 0, 0}, l = {128}, m = "invokeSuspend", n = {"$this$coroutineScope", "edges", "extractedEdgesSize"}, s = {"L$0", "L$1", "I$0"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends ItemConnectionFragment.Edge>>, Object> {
        final /* synthetic */ List<PartialMiniItem> $partialItems;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ GQLPartialDataExtractor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(List<PartialMiniItem> list, GQLPartialDataExtractor gQLPartialDataExtractor, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$partialItems = list;
            this.this$0 = gQLPartialDataExtractor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$partialItems, this.this$0, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends ItemConnectionFragment.Edge>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super List<ItemConnectionFragment.Edge>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<ItemConnectionFragment.Edge>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List<ItemConnectionFragment.Edge> list;
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                int iMin = Math.min(this.$partialItems.size(), 30);
                ArrayList arrayList = new ArrayList(iMin);
                for (int i2 = 0; i2 < iMin; i2++) {
                    arrayList.add(null);
                }
                ArrayList arrayList2 = arrayList;
                IntRange intRangeUntil = RangesKt.until(0, iMin);
                GQLPartialDataExtractor gQLPartialDataExtractor = this.this$0;
                List<PartialMiniItem> list2 = this.$partialItems;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
                Iterator<Integer> it = intRangeUntil.iterator();
                while (it.hasNext()) {
                    ArrayList arrayList4 = arrayList3;
                    arrayList4.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new GQLPartialDataExtractor$hydratePartialItemsIntoEdges$2$1$1(gQLPartialDataExtractor, list2, ((IntIterator) it).nextInt(), arrayList2, null), 3, null));
                    arrayList3 = arrayList4;
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = arrayList2;
                this.I$0 = iMin;
                this.label = 1;
                if (AwaitKt.awaitAll(arrayList3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list = arrayList2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) this.L$1;
                ResultKt.throwOnFailure(obj);
            }
            ArrayList arrayList5 = new ArrayList();
            for (ItemConnectionFragment.Edge edge : list) {
                if (edge != null) {
                    arrayList5.add(edge);
                }
            }
            return arrayList5;
        }
    }

    public final Object hydratePartialItemsIntoEdges(List<PartialMiniItem> list, Continuation<? super List<ItemConnectionFragment.Edge>> continuation) {
        return CoroutineScopeKt.coroutineScope(new AnonymousClass2(list, this, null), continuation);
    }

    public final ApolloResponse<GetFolderItemsQuery.Data> createApolloResponseWithPartialItems(String folderId, List<ItemConnectionFragment.Edge> items) {
        Intrinsics.checkNotNullParameter(folderId, "folderId");
        Intrinsics.checkNotNullParameter(items, "items");
        GetFolderItemsQuery getFolderItemsQuery = new GetFolderItemsQuery(folderId);
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID(...)");
        return new ApolloResponse.Builder(getFolderItemsQuery, uuidRandomUUID, new GetFolderItemsQuery.Data(new GetFolderItemsQuery.Folder(folderId, new GetFolderItemsQuery.ItemConnection(GQLCacheConstants.TYPENAME_ITEM_CONNECTION, new ItemConnectionFragment(items.size(), items))))).build();
    }

    public final ApolloResponse<GetFolderItemsQuery.Data> createApolloResponseWithException(String folderId, CacheError cacheError) {
        Intrinsics.checkNotNullParameter(folderId, "folderId");
        Intrinsics.checkNotNullParameter(cacheError, "cacheError");
        GetFolderItemsQuery getFolderItemsQuery = new GetFolderItemsQuery(folderId);
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID(...)");
        return new ApolloResponse.Builder(getFolderItemsQuery, uuidRandomUUID, null).errors(CollectionsKt.listOf(new Error(cacheError.toString(), null, null, null, MapsKt.mapOf(TuplesKt.to(GQL_CACHE_ERROR_KEY, cacheError))))).build();
    }
}
