package com.box.android.data.datasource.gql.cache.custom;

import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.Fragment;
import com.apollographql.apollo3.api.Operation;
import com.apollographql.apollo3.cache.normalized.ApolloStore;
import com.apollographql.apollo3.cache.normalized.api.CacheHeaders;
import com.apollographql.apollo3.cache.normalized.api.CacheKey;
import com.apollographql.apollo3.cache.normalized.api.CacheKeyGenerator;
import com.apollographql.apollo3.cache.normalized.api.CacheResolver;
import com.apollographql.apollo3.cache.normalized.api.NormalizedCache;
import com.apollographql.apollo3.cache.normalized.api.NormalizedCacheFactory;
import com.apollographql.apollo3.cache.normalized.api.OperationCacheExtensionsKt;
import com.apollographql.apollo3.cache.normalized.api.Record;
import com.apollographql.apollo3.cache.normalized.api.internal.OptimisticCache;
import com.box.android.data.api.models.adapters.graphql.GQLCustomScalarAdapters;
import com.box.androidsdk.content.models.BoxFile;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import com.pspdfkit.BuildConfig;
import com.pspdfkit.ui.toolbar.ContextualToolbar;
import external.sdk.pendo.io.mozilla.javascript.Token;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: compiled from: CustomApolloStore.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0096@¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u001e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010 J$\u0010\u001c\u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001e0#2\u0006\u0010\u001f\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010$JA\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020'0&\"\b\b\u0000\u0010(*\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H(0+2\u0006\u0010,\u001a\u0002H(2\u0006\u0010-\u001a\u00020.H\u0016¢\u0006\u0002\u0010/J6\u00100\u001a\u0002H(\"\b\b\u0000\u0010(*\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H(0+2\u0006\u0010-\u001a\u00020.2\u0006\u00101\u001a\u000202H\u0096@¢\u0006\u0002\u00103J>\u00104\u001a\u0002H(\"\b\b\u0000\u0010(*\u0002052\f\u00106\u001a\b\u0012\u0004\u0012\u0002H(072\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.2\u0006\u00101\u001a\u000202H\u0096@¢\u0006\u0002\u00108J(\u00109\u001a\u0002H:\"\u0004\b\u0000\u0010:2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u0002H:0<H\u0096@¢\u0006\u0002\u0010>JL\u0010?\u001a\b\u0012\u0004\u0012\u00020\r0\f\"\b\b\u0000\u0010(*\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H(0+2\u0006\u0010@\u001a\u0002H(2\u0006\u0010-\u001a\u00020.2\u0006\u00101\u001a\u0002022\u0006\u0010\u0016\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010AJT\u0010B\u001a\b\u0012\u0004\u0012\u00020\r0\f\"\b\b\u0000\u0010(*\u0002052\f\u00106\u001a\b\u0012\u0004\u0012\u0002H(072\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010C\u001a\u0002H(2\u0006\u0010-\u001a\u00020.2\u0006\u00101\u001a\u0002022\u0006\u0010\u0016\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010DJ^\u0010E\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0F\"\b\b\u0000\u0010(*\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H(0+2\u0006\u0010@\u001a\u0002H(2\u0006\u00101\u001a\u0002022\u0006\u0010\u0016\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.H\u0086@¢\u0006\u0002\u0010GJP\u0010H\u001a\b\u0012\u0004\u0012\u00020\r0\f\"\b\b\u0000\u0010(*\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u0002H(0+2\u0006\u0010@\u001a\u0002H(2\n\u0010I\u001a\u00060Jj\u0002`K2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u0016\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010LJ(\u0010M\u001a\b\u0012\u0004\u0012\u00020\r0\f2\n\u0010I\u001a\u00060Jj\u0002`K2\u0006\u0010\u0016\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010NJ*\u0010O\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030P\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020'0&0&H\u0096@¢\u0006\u0002\u0010QJ\b\u0010R\u001a\u00020\u0017H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/box/android/data/datasource/gql/cache/custom/CustomApolloStore;", "Lcom/apollographql/apollo3/cache/normalized/ApolloStore;", "normalizedCacheFactory", "Lcom/apollographql/apollo3/cache/normalized/api/NormalizedCacheFactory;", "cacheKeyGenerator", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKeyGenerator;", "cacheResolver", "Lcom/apollographql/apollo3/cache/normalized/api/CacheResolver;", "<init>", "(Lcom/apollographql/apollo3/cache/normalized/api/NormalizedCacheFactory;Lcom/apollographql/apollo3/cache/normalized/api/CacheKeyGenerator;Lcom/apollographql/apollo3/cache/normalized/api/CacheResolver;)V", "changedKeysEvents", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "", "changedKeys", "Lkotlinx/coroutines/flow/SharedFlow;", "getChangedKeys", "()Lkotlinx/coroutines/flow/SharedFlow;", SemanticAttributes.DbSystemValues.CACHE, "Lcom/apollographql/apollo3/cache/normalized/api/internal/OptimisticCache;", BoxFile.FIELD_LOCK, "Lcom/box/android/data/datasource/gql/cache/custom/WriteLock;", "publish", "", "keys", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearAll", "", "remove", "cacheKey", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;", "cascade", "(Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "cacheKeys", "", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "normalize", "", "Lcom/apollographql/apollo3/cache/normalized/api/Record;", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", SerializedNames.OPERATION, "Lcom/apollographql/apollo3/api/Operation;", "data", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "(Lcom/apollographql/apollo3/api/Operation;Lcom/apollographql/apollo3/api/Operation$Data;Lcom/apollographql/apollo3/api/CustomScalarAdapters;)Ljava/util/Map;", "readOperation", "cacheHeaders", "Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;", "(Lcom/apollographql/apollo3/api/Operation;Lcom/apollographql/apollo3/api/CustomScalarAdapters;Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFragment", "Lcom/apollographql/apollo3/api/Fragment$Data;", BuildConfig.FLAVOR, "Lcom/apollographql/apollo3/api/Fragment;", "(Lcom/apollographql/apollo3/api/Fragment;Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;Lcom/apollographql/apollo3/api/CustomScalarAdapters;Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "accessCache", "R", "block", "Lkotlin/Function1;", "Lcom/apollographql/apollo3/cache/normalized/api/NormalizedCache;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeOperation", "operationData", "(Lcom/apollographql/apollo3/api/Operation;Lcom/apollographql/apollo3/api/Operation$Data;Lcom/apollographql/apollo3/api/CustomScalarAdapters;Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFragment", "fragmentData", "(Lcom/apollographql/apollo3/api/Fragment;Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;Lcom/apollographql/apollo3/api/Fragment$Data;Lcom/apollographql/apollo3/api/CustomScalarAdapters;Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeOperationWithRecords", "Lkotlin/Pair;", "(Lcom/apollographql/apollo3/api/Operation;Lcom/apollographql/apollo3/api/Operation$Data;Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;ZLcom/apollographql/apollo3/api/CustomScalarAdapters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeOptimisticUpdates", "mutationId", "Ljava/util/UUID;", "Lcom/benasher44/uuid/Uuid;", "(Lcom/apollographql/apollo3/api/Operation;Lcom/apollographql/apollo3/api/Operation$Data;Ljava/util/UUID;Lcom/apollographql/apollo3/api/CustomScalarAdapters;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rollbackOptimisticUpdates", "(Ljava/util/UUID;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dump", "Lkotlin/reflect/KClass;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispose", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CustomApolloStore implements ApolloStore {
    private final OptimisticCache cache;
    private final CacheKeyGenerator cacheKeyGenerator;
    private final CacheResolver cacheResolver;
    private final SharedFlow<Set<String>> changedKeys;
    private final MutableSharedFlow<Set<String>> changedKeysEvents;
    private final WriteLock lock;

    /* JADX INFO: renamed from: com.box.android.data.datasource.gql.cache.custom.CustomApolloStore$rollbackOptimisticUpdates$1, reason: invalid class name */
    /* JADX INFO: compiled from: CustomApolloStore.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.gql.cache.custom.CustomApolloStore", f = "CustomApolloStore.kt", i = {0, 0, 0}, l = {251}, m = "rollbackOptimisticUpdates", n = {"mutationId", "changedKeys", "publish"}, s = {"L$0", "L$1", "Z$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CustomApolloStore.this.rollbackOptimisticUpdates(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.gql.cache.custom.CustomApolloStore$writeFragment$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CustomApolloStore.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.gql.cache.custom.CustomApolloStore", f = "CustomApolloStore.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {ContextualToolbar.DRAG_BUTTON_ALPHA}, m = "writeFragment", n = {BuildConfig.FLAVOR, "cacheKey", "fragmentData", "customScalarAdapters", "cacheHeaders", "changedKeys", "publish"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0"}, v = 1)
    static final class C11551<D extends Fragment.Data> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C11551(Continuation<? super C11551> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CustomApolloStore.this.writeFragment(null, null, null, null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.gql.cache.custom.CustomApolloStore$writeOperation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CustomApolloStore.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.gql.cache.custom.CustomApolloStore", f = "CustomApolloStore.kt", i = {0, 0, 0, 0, 0}, l = {Token.ARRAYCOMP}, m = "writeOperation", n = {SerializedNames.OPERATION, "operationData", "customScalarAdapters", "cacheHeaders", "publish"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 1)
    static final class C11561<D extends Operation.Data> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C11561(Continuation<? super C11561> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CustomApolloStore.this.writeOperation(null, null, null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.gql.cache.custom.CustomApolloStore$writeOperationWithRecords$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CustomApolloStore.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.gql.cache.custom.CustomApolloStore", f = "CustomApolloStore.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {209}, m = "writeOperationWithRecords", n = {SerializedNames.OPERATION, "operationData", "cacheHeaders", "customScalarAdapters", "records", "changedKeys", "publish"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0"}, v = 1)
    static final class C11571<D extends Operation.Data> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C11571(Continuation<? super C11571> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CustomApolloStore.this.writeOperationWithRecords(null, null, null, false, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.gql.cache.custom.CustomApolloStore$writeOptimisticUpdates$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CustomApolloStore.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.gql.cache.custom.CustomApolloStore", f = "CustomApolloStore.kt", i = {0, 0, 0, 0, 0, 0}, l = {239}, m = "writeOptimisticUpdates", n = {SerializedNames.OPERATION, "operationData", "mutationId", "customScalarAdapters", "changedKeys", "publish"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"}, v = 1)
    static final class C11581<D extends Operation.Data> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C11581(Continuation<? super C11581> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CustomApolloStore.this.writeOptimisticUpdates(null, null, null, null, false, this);
        }
    }

    @Override // com.apollographql.apollo3.cache.normalized.ApolloStore
    public void dispose() {
    }

    public CustomApolloStore(NormalizedCacheFactory normalizedCacheFactory, CacheKeyGenerator cacheKeyGenerator, CacheResolver cacheResolver) {
        Intrinsics.checkNotNullParameter(normalizedCacheFactory, "normalizedCacheFactory");
        Intrinsics.checkNotNullParameter(cacheKeyGenerator, "cacheKeyGenerator");
        Intrinsics.checkNotNullParameter(cacheResolver, "cacheResolver");
        this.cacheKeyGenerator = cacheKeyGenerator;
        this.cacheResolver = cacheResolver;
        MutableSharedFlow<Set<String>> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 10, BufferOverflow.DROP_OLDEST, 1, null);
        this.changedKeysEvents = mutableSharedFlowMutableSharedFlow$default;
        this.changedKeys = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
        NormalizedCache normalizedCacheChain = new OptimisticCache().chain(normalizedCacheFactory.createChain());
        Intrinsics.checkNotNull(normalizedCacheChain, "null cannot be cast to non-null type com.apollographql.apollo3.cache.normalized.api.internal.OptimisticCache");
        this.cache = (OptimisticCache) normalizedCacheChain;
        this.lock = new WriteLock();
    }

    @Override // com.apollographql.apollo3.cache.normalized.ApolloStore
    public SharedFlow<Set<String>> getChangedKeys() {
        return this.changedKeys;
    }

    @Override // com.apollographql.apollo3.cache.normalized.ApolloStore
    public Object publish(Set<String> set, Continuation<? super Unit> continuation) {
        if (set.isEmpty()) {
            return Unit.INSTANCE;
        }
        Object objEmit = this.changedKeysEvents.emit(set, continuation);
        return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
    }

    @Override // com.apollographql.apollo3.cache.normalized.ApolloStore
    public boolean clearAll() {
        this.lock.write(new Function0() { // from class: com.box.android.data.datasource.gql.cache.custom.CustomApolloStore$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CustomApolloStore.clearAll$lambda$0(this.f$0);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clearAll$lambda$0(CustomApolloStore customApolloStore) {
        customApolloStore.cache.clearAll();
        return Unit.INSTANCE;
    }

    @Override // com.apollographql.apollo3.cache.normalized.ApolloStore
    public Object remove(final CacheKey cacheKey, final boolean z, Continuation<? super Boolean> continuation) {
        return this.lock.write(new Function0() { // from class: com.box.android.data.datasource.gql.cache.custom.CustomApolloStore$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(CustomApolloStore.remove$lambda$0(this.f$0, cacheKey, z));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean remove$lambda$0(CustomApolloStore customApolloStore, CacheKey cacheKey, boolean z) {
        return customApolloStore.cache.remove(cacheKey, z);
    }

    @Override // com.apollographql.apollo3.cache.normalized.ApolloStore
    public Object remove(final List<CacheKey> list, final boolean z, Continuation<? super Integer> continuation) {
        return this.lock.write(new Function0() { // from class: com.box.android.data.datasource.gql.cache.custom.CustomApolloStore$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(CustomApolloStore.remove$lambda$1(list, this, z));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int remove$lambda$1(List list, CustomApolloStore customApolloStore, boolean z) {
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (customApolloStore.cache.remove((CacheKey) it.next(), z)) {
                i++;
            }
        }
        return i;
    }

    @Override // com.apollographql.apollo3.cache.normalized.ApolloStore
    public <D extends Operation.Data> Map<String, Record> normalize(Operation<D> operation, D data, CustomScalarAdapters customScalarAdapters) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        return OperationCacheExtensionsKt.normalize(operation, data, GQLCustomScalarAdapters.INSTANCE.getCustomScalars(), this.cacheKeyGenerator);
    }

    @Override // com.apollographql.apollo3.cache.normalized.ApolloStore
    public <D extends Operation.Data> Object readOperation(final Operation<D> operation, CustomScalarAdapters customScalarAdapters, final CacheHeaders cacheHeaders, Continuation<? super D> continuation) {
        return this.lock.read(new Function0() { // from class: com.box.android.data.datasource.gql.cache.custom.CustomApolloStore$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CustomApolloStore.readOperation$lambda$0(operation, this, cacheHeaders);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Operation.Data readOperation$lambda$0(Operation operation, CustomApolloStore customApolloStore, CacheHeaders cacheHeaders) {
        return (Operation.Data) OperationCacheExtensionsKt.readDataFromCache(operation, GQLCustomScalarAdapters.INSTANCE.getCustomScalars(), customApolloStore.cache, customApolloStore.cacheResolver, cacheHeaders);
    }

    @Override // com.apollographql.apollo3.cache.normalized.ApolloStore
    public <D extends Fragment.Data> Object readFragment(final Fragment<D> fragment, final CacheKey cacheKey, CustomScalarAdapters customScalarAdapters, final CacheHeaders cacheHeaders, Continuation<? super D> continuation) {
        return this.lock.read(new Function0() { // from class: com.box.android.data.datasource.gql.cache.custom.CustomApolloStore$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CustomApolloStore.readFragment$lambda$0(this.f$0, fragment, cacheKey, cacheHeaders);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Fragment.Data readFragment$lambda$0(CustomApolloStore customApolloStore, Fragment fragment, CacheKey cacheKey, CacheHeaders cacheHeaders) {
        return OperationCacheExtensionsKt.readDataFromCache(fragment, cacheKey, GQLCustomScalarAdapters.INSTANCE.getCustomScalars(), customApolloStore.cache, customApolloStore.cacheResolver, cacheHeaders);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object accessCache$lambda$0(Function1 function1, CustomApolloStore customApolloStore) {
        return function1.invoke(customApolloStore.cache);
    }

    @Override // com.apollographql.apollo3.cache.normalized.ApolloStore
    public <R> Object accessCache(final Function1<? super NormalizedCache, ? extends R> function1, Continuation<? super R> continuation) {
        return this.lock.write(new Function0() { // from class: com.box.android.data.datasource.gql.cache.custom.CustomApolloStore$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CustomApolloStore.accessCache$lambda$0(function1, this);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.apollographql.apollo3.cache.normalized.ApolloStore
    public <D extends Operation.Data> Object writeOperation(Operation<D> operation, D d, CustomScalarAdapters customScalarAdapters, CacheHeaders cacheHeaders, boolean z, Continuation<? super Set<String>> continuation) {
        C11561 c11561;
        if (continuation instanceof C11561) {
            c11561 = (C11561) continuation;
            if ((c11561.label & Integer.MIN_VALUE) != 0) {
                c11561.label -= Integer.MIN_VALUE;
            } else {
                c11561 = new C11561(continuation);
            }
        } else {
            c11561 = new C11561(continuation);
        }
        C11561 c11562 = c11561;
        Object objWriteOperationWithRecords = c11562.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11562.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWriteOperationWithRecords);
            CustomScalarAdapters customScalars = GQLCustomScalarAdapters.INSTANCE.getCustomScalars();
            c11562.L$0 = SpillingKt.nullOutSpilledVariable(operation);
            c11562.L$1 = SpillingKt.nullOutSpilledVariable(d);
            c11562.L$2 = SpillingKt.nullOutSpilledVariable(customScalarAdapters);
            c11562.L$3 = SpillingKt.nullOutSpilledVariable(cacheHeaders);
            c11562.Z$0 = z;
            c11562.label = 1;
            objWriteOperationWithRecords = writeOperationWithRecords(operation, d, cacheHeaders, z, customScalars, c11562);
            if (objWriteOperationWithRecords == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z2 = c11562.Z$0;
            ResultKt.throwOnFailure(objWriteOperationWithRecords);
        }
        return ((Pair) objWriteOperationWithRecords).getSecond();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Override // com.apollographql.apollo3.cache.normalized.ApolloStore
    public <D extends Fragment.Data> Object writeFragment(final Fragment<D> fragment, final CacheKey cacheKey, final D d, CustomScalarAdapters customScalarAdapters, final CacheHeaders cacheHeaders, boolean z, Continuation<? super Set<String>> continuation) {
        C11551 c11551;
        if (continuation instanceof C11551) {
            c11551 = (C11551) continuation;
            if ((c11551.label & Integer.MIN_VALUE) != 0) {
                c11551.label -= Integer.MIN_VALUE;
            } else {
                c11551 = new C11551(continuation);
            }
        } else {
            c11551 = new C11551(continuation);
        }
        C11551 c11552 = c11551;
        Object obj = c11552.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11552.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z2 = c11552.Z$0;
            Set set = (Set) c11552.L$5;
            ResultKt.throwOnFailure(obj);
            return set;
        }
        ResultKt.throwOnFailure(obj);
        Set<String> set2 = (Set) this.lock.write(new Function0() { // from class: com.box.android.data.datasource.gql.cache.custom.CustomApolloStore$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CustomApolloStore.writeFragment$lambda$0(fragment, d, this, cacheKey, cacheHeaders);
            }
        });
        if (z) {
            c11552.L$0 = SpillingKt.nullOutSpilledVariable(fragment);
            c11552.L$1 = SpillingKt.nullOutSpilledVariable(cacheKey);
            c11552.L$2 = SpillingKt.nullOutSpilledVariable(d);
            c11552.L$3 = SpillingKt.nullOutSpilledVariable(customScalarAdapters);
            c11552.L$4 = SpillingKt.nullOutSpilledVariable(cacheHeaders);
            c11552.L$5 = set2;
            c11552.Z$0 = z;
            c11552.label = 1;
            if (publish(set2, c11552) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return set2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set writeFragment$lambda$0(Fragment fragment, Fragment.Data data, CustomApolloStore customApolloStore, CacheKey cacheKey, CacheHeaders cacheHeaders) {
        return customApolloStore.cache.merge(OperationCacheExtensionsKt.normalize(fragment, data, GQLCustomScalarAdapters.INSTANCE.getCustomScalars(), customApolloStore.cacheKeyGenerator, cacheKey.getKey()).values(), cacheHeaders);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final <D extends Operation.Data> Object writeOperationWithRecords(final Operation<D> operation, final D d, final CacheHeaders cacheHeaders, boolean z, CustomScalarAdapters customScalarAdapters, Continuation<? super Pair<? extends Set<Record>, ? extends Set<String>>> continuation) {
        C11571 c11571;
        Map map;
        Set<String> set;
        Set<String> set2;
        Map map2;
        if (continuation instanceof C11571) {
            c11571 = (C11571) continuation;
            if ((c11571.label & Integer.MIN_VALUE) != 0) {
                c11571.label -= Integer.MIN_VALUE;
            } else {
                c11571 = new C11571(continuation);
            }
        } else {
            c11571 = new C11571(continuation);
        }
        Object obj = c11571.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11571.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Pair pair = (Pair) this.lock.write(new Function0() { // from class: com.box.android.data.datasource.gql.cache.custom.CustomApolloStore$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CustomApolloStore.writeOperationWithRecords$lambda$0(operation, d, this, cacheHeaders);
                }
            });
            map = (Map) pair.component1();
            set = (Set) pair.component2();
            if (z) {
                c11571.L$0 = SpillingKt.nullOutSpilledVariable(operation);
                c11571.L$1 = SpillingKt.nullOutSpilledVariable(d);
                c11571.L$2 = SpillingKt.nullOutSpilledVariable(cacheHeaders);
                c11571.L$3 = SpillingKt.nullOutSpilledVariable(customScalarAdapters);
                c11571.L$4 = map;
                c11571.L$5 = set;
                c11571.Z$0 = z;
                c11571.label = 1;
                if (publish(set, c11571) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                set2 = set;
                map2 = map;
            }
            return TuplesKt.to(CollectionsKt.toSet(map.values()), set);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean z2 = c11571.Z$0;
        set2 = (Set) c11571.L$5;
        map2 = (Map) c11571.L$4;
        ResultKt.throwOnFailure(obj);
        set = set2;
        map = map2;
        return TuplesKt.to(CollectionsKt.toSet(map.values()), set);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair writeOperationWithRecords$lambda$0(Operation operation, Operation.Data data, CustomApolloStore customApolloStore, CacheHeaders cacheHeaders) {
        Map<String, Record> mapNormalize = OperationCacheExtensionsKt.normalize(operation, data, GQLCustomScalarAdapters.INSTANCE.getCustomScalars(), customApolloStore.cacheKeyGenerator);
        return TuplesKt.to(mapNormalize, customApolloStore.cache.merge(CollectionsKt.toList(mapNormalize.values()), cacheHeaders));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.apollographql.apollo3.cache.normalized.ApolloStore
    public <D extends Operation.Data> Object writeOptimisticUpdates(final Operation<D> operation, final D d, final UUID uuid, CustomScalarAdapters customScalarAdapters, boolean z, Continuation<? super Set<String>> continuation) {
        C11581 c11581;
        if (continuation instanceof C11581) {
            c11581 = (C11581) continuation;
            if ((c11581.label & Integer.MIN_VALUE) != 0) {
                c11581.label -= Integer.MIN_VALUE;
            } else {
                c11581 = new C11581(continuation);
            }
        } else {
            c11581 = new C11581(continuation);
        }
        Object obj = c11581.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11581.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z2 = c11581.Z$0;
            Set set = (Set) c11581.L$4;
            ResultKt.throwOnFailure(obj);
            return set;
        }
        ResultKt.throwOnFailure(obj);
        Set<String> set2 = (Set) this.lock.write(new Function0() { // from class: com.box.android.data.datasource.gql.cache.custom.CustomApolloStore$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CustomApolloStore.writeOptimisticUpdates$lambda$0(operation, d, this, uuid);
            }
        });
        if (z) {
            c11581.L$0 = SpillingKt.nullOutSpilledVariable(operation);
            c11581.L$1 = SpillingKt.nullOutSpilledVariable(d);
            c11581.L$2 = SpillingKt.nullOutSpilledVariable(uuid);
            c11581.L$3 = SpillingKt.nullOutSpilledVariable(customScalarAdapters);
            c11581.L$4 = set2;
            c11581.Z$0 = z;
            c11581.label = 1;
            if (publish(set2, c11581) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return set2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set writeOptimisticUpdates$lambda$0(Operation operation, Operation.Data data, CustomApolloStore customApolloStore, UUID uuid) {
        Collection<Record> collectionValues = OperationCacheExtensionsKt.normalize(operation, data, GQLCustomScalarAdapters.INSTANCE.getCustomScalars(), customApolloStore.cacheKeyGenerator).values();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collectionValues, 10));
        for (Record record : collectionValues) {
            arrayList.add(new Record(record.getKey(), record.getFields(), uuid));
        }
        return customApolloStore.cache.addOptimisticUpdates(arrayList);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.apollographql.apollo3.cache.normalized.ApolloStore
    public Object rollbackOptimisticUpdates(final UUID uuid, boolean z, Continuation<? super Set<String>> continuation) {
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z2 = anonymousClass1.Z$0;
            Set set = (Set) anonymousClass1.L$1;
            ResultKt.throwOnFailure(obj);
            return set;
        }
        ResultKt.throwOnFailure(obj);
        Set<String> set2 = (Set) this.lock.write(new Function0() { // from class: com.box.android.data.datasource.gql.cache.custom.CustomApolloStore$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CustomApolloStore.rollbackOptimisticUpdates$lambda$0(this.f$0, uuid);
            }
        });
        if (z) {
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(uuid);
            anonymousClass1.L$1 = set2;
            anonymousClass1.Z$0 = z;
            anonymousClass1.label = 1;
            if (publish(set2, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return set2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set rollbackOptimisticUpdates$lambda$0(CustomApolloStore customApolloStore, UUID uuid) {
        return customApolloStore.cache.removeOptimisticUpdates(uuid);
    }

    @Override // com.apollographql.apollo3.cache.normalized.ApolloStore
    public Object dump(Continuation<? super Map<KClass<?>, ? extends Map<String, Record>>> continuation) {
        return this.lock.read(new Function0() { // from class: com.box.android.data.datasource.gql.cache.custom.CustomApolloStore$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CustomApolloStore.dump$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map dump$lambda$0(CustomApolloStore customApolloStore) {
        return customApolloStore.cache.dump();
    }
}
