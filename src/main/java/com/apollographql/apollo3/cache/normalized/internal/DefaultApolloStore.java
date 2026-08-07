package com.apollographql.apollo3.cache.normalized.internal;

import androidx.media3.extractor.ts.TsExtractor;
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
import com.box.androidsdk.content.models.BoxFile;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import com.pspdfkit.BuildConfig;
import external.sdk.pendo.io.mozilla.javascript.Token;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: compiled from: DefaultApolloStore.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ(\u0010\u0019\u001a\u0002H\u001a\"\u0004\b\u0000\u0010\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u0002H\u001a0\u001cH\u0096@¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\"H\u0016J*\u0010#\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030%\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020&0$0$H\u0096@¢\u0006\u0002\u0010'JA\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020&0$\"\b\b\u0000\u0010)*\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H)0,2\u0006\u0010-\u001a\u0002H)2\u0006\u0010.\u001a\u00020/H\u0016¢\u0006\u0002\u00100J\u001c\u00101\u001a\u00020\"2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0096@¢\u0006\u0002\u00103J>\u00104\u001a\u0002H)\"\b\b\u0000\u0010)*\u0002052\f\u00106\u001a\b\u0012\u0004\u0012\u0002H)072\u0006\u00108\u001a\u0002092\u0006\u0010.\u001a\u00020/2\u0006\u0010:\u001a\u00020;H\u0096@¢\u0006\u0002\u0010<J6\u0010=\u001a\u0002H)\"\b\b\u0000\u0010)*\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H)0,2\u0006\u0010.\u001a\u00020/2\u0006\u0010:\u001a\u00020;H\u0096@¢\u0006\u0002\u0010>J\u001e\u0010?\u001a\u00020 2\u0006\u00108\u001a\u0002092\u0006\u0010@\u001a\u00020 H\u0096@¢\u0006\u0002\u0010AJ$\u0010?\u001a\u00020B2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002090D2\u0006\u0010@\u001a\u00020 H\u0096@¢\u0006\u0002\u0010EJ(\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\n\u0010G\u001a\u00060Hj\u0002`I2\u0006\u00101\u001a\u00020 H\u0096@¢\u0006\u0002\u0010JJT\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\"\b\b\u0000\u0010)*\u0002052\f\u00106\u001a\b\u0012\u0004\u0012\u0002H)072\u0006\u00108\u001a\u0002092\u0006\u0010L\u001a\u0002H)2\u0006\u0010.\u001a\u00020/2\u0006\u0010:\u001a\u00020;2\u0006\u00101\u001a\u00020 H\u0096@¢\u0006\u0002\u0010MJL\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\"\b\b\u0000\u0010)*\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H)0,2\u0006\u0010O\u001a\u0002H)2\u0006\u0010.\u001a\u00020/2\u0006\u0010:\u001a\u00020;2\u0006\u00101\u001a\u00020 H\u0096@¢\u0006\u0002\u0010PJ^\u0010Q\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110R\"\b\b\u0000\u0010)*\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H)0,2\u0006\u0010O\u001a\u0002H)2\u0006\u0010:\u001a\u00020;2\u0006\u00101\u001a\u00020 2\u0006\u0010.\u001a\u00020/H\u0086@¢\u0006\u0002\u0010SJP\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\"\b\b\u0000\u0010)*\u00020*2\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H)0,2\u0006\u0010O\u001a\u0002H)2\n\u0010G\u001a\u00060Hj\u0002`I2\u0006\u0010.\u001a\u00020/2\u0006\u00101\u001a\u00020 H\u0096@¢\u0006\u0002\u0010UR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/internal/DefaultApolloStore;", "Lcom/apollographql/apollo3/cache/normalized/ApolloStore;", "normalizedCacheFactory", "Lcom/apollographql/apollo3/cache/normalized/api/NormalizedCacheFactory;", "cacheKeyGenerator", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKeyGenerator;", "cacheResolver", "Lcom/apollographql/apollo3/cache/normalized/api/CacheResolver;", "(Lcom/apollographql/apollo3/cache/normalized/api/NormalizedCacheFactory;Lcom/apollographql/apollo3/cache/normalized/api/CacheKeyGenerator;Lcom/apollographql/apollo3/cache/normalized/api/CacheResolver;)V", SemanticAttributes.DbSystemValues.CACHE, "Lcom/apollographql/apollo3/cache/normalized/api/internal/OptimisticCache;", "getCache", "()Lcom/apollographql/apollo3/cache/normalized/api/internal/OptimisticCache;", "cache$delegate", "Lkotlin/Lazy;", "changedKeys", "Lkotlinx/coroutines/flow/SharedFlow;", "", "", "getChangedKeys", "()Lkotlinx/coroutines/flow/SharedFlow;", "changedKeysEvents", "Lkotlinx/coroutines/flow/MutableSharedFlow;", BoxFile.FIELD_LOCK, "Lcom/apollographql/apollo3/cache/normalized/internal/Lock;", "accessCache", "R", "block", "Lkotlin/Function1;", "Lcom/apollographql/apollo3/cache/normalized/api/NormalizedCache;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearAll", "", "dispose", "", "dump", "", "Lkotlin/reflect/KClass;", "Lcom/apollographql/apollo3/cache/normalized/api/Record;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "normalize", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", SerializedNames.OPERATION, "Lcom/apollographql/apollo3/api/Operation;", "data", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "(Lcom/apollographql/apollo3/api/Operation;Lcom/apollographql/apollo3/api/Operation$Data;Lcom/apollographql/apollo3/api/CustomScalarAdapters;)Ljava/util/Map;", "publish", "keys", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFragment", "Lcom/apollographql/apollo3/api/Fragment$Data;", BuildConfig.FLAVOR, "Lcom/apollographql/apollo3/api/Fragment;", "cacheKey", "Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;", "cacheHeaders", "Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;", "(Lcom/apollographql/apollo3/api/Fragment;Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;Lcom/apollographql/apollo3/api/CustomScalarAdapters;Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readOperation", "(Lcom/apollographql/apollo3/api/Operation;Lcom/apollographql/apollo3/api/CustomScalarAdapters;Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remove", "cascade", "(Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "cacheKeys", "", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rollbackOptimisticUpdates", "mutationId", "Ljava/util/UUID;", "Lcom/benasher44/uuid/Uuid;", "(Ljava/util/UUID;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFragment", "fragmentData", "(Lcom/apollographql/apollo3/api/Fragment;Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;Lcom/apollographql/apollo3/api/Fragment$Data;Lcom/apollographql/apollo3/api/CustomScalarAdapters;Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeOperation", "operationData", "(Lcom/apollographql/apollo3/api/Operation;Lcom/apollographql/apollo3/api/Operation$Data;Lcom/apollographql/apollo3/api/CustomScalarAdapters;Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeOperationWithRecords", "Lkotlin/Pair;", "(Lcom/apollographql/apollo3/api/Operation;Lcom/apollographql/apollo3/api/Operation$Data;Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;ZLcom/apollographql/apollo3/api/CustomScalarAdapters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeOptimisticUpdates", "(Lcom/apollographql/apollo3/api/Operation;Lcom/apollographql/apollo3/api/Operation$Data;Ljava/util/UUID;Lcom/apollographql/apollo3/api/CustomScalarAdapters;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "apollo-normalized-cache"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DefaultApolloStore implements ApolloStore {

    /* JADX INFO: renamed from: cache$delegate, reason: from kotlin metadata */
    private final Lazy cache;
    private final CacheKeyGenerator cacheKeyGenerator;
    private final CacheResolver cacheResolver;
    private final SharedFlow<Set<String>> changedKeys;
    private final MutableSharedFlow<Set<String>> changedKeysEvents;
    private final Lock lock;

    /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.internal.DefaultApolloStore$rollbackOptimisticUpdates$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultApolloStore.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.internal.DefaultApolloStore", f = "DefaultApolloStore.kt", i = {0}, l = {244}, m = "rollbackOptimisticUpdates", n = {"changedKeys"}, s = {"L$0"})
    static final class C08821 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C08821(Continuation<? super C08821> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultApolloStore.this.rollbackOptimisticUpdates(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.internal.DefaultApolloStore$writeFragment$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultApolloStore.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.internal.DefaultApolloStore", f = "DefaultApolloStore.kt", i = {0}, l = {TsExtractor.TS_STREAM_TYPE_AC4}, m = "writeFragment", n = {"changedKeys"}, s = {"L$0"})
    static final class C08831<D extends Fragment.Data> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C08831(Continuation<? super C08831> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultApolloStore.this.writeFragment(null, null, null, null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.internal.DefaultApolloStore$writeOperation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultApolloStore.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.internal.DefaultApolloStore", f = "DefaultApolloStore.kt", i = {}, l = {Token.SET_REF_OP}, m = "writeOperation", n = {}, s = {})
    static final class C08841<D extends Operation.Data> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C08841(Continuation<? super C08841> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultApolloStore.this.writeOperation(null, null, null, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.internal.DefaultApolloStore$writeOperationWithRecords$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultApolloStore.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.internal.DefaultApolloStore", f = "DefaultApolloStore.kt", i = {0, 0}, l = {195}, m = "writeOperationWithRecords", n = {"records", "changedKeys"}, s = {"L$0", "L$1"})
    static final class C08851<D extends Operation.Data> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C08851(Continuation<? super C08851> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultApolloStore.this.writeOperationWithRecords(null, null, null, false, null, this);
        }
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.internal.DefaultApolloStore$writeOptimisticUpdates$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultApolloStore.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.internal.DefaultApolloStore", f = "DefaultApolloStore.kt", i = {0}, l = {229}, m = "writeOptimisticUpdates", n = {"changedKeys"}, s = {"L$0"})
    static final class C08871<D extends Operation.Data> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C08871(Continuation<? super C08871> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultApolloStore.this.writeOptimisticUpdates(null, null, null, null, false, this);
        }
    }

    @Override // com.apollographql.apollo3.cache.normalized.ApolloStore
    public void dispose() {
    }

    public DefaultApolloStore(final NormalizedCacheFactory normalizedCacheFactory, CacheKeyGenerator cacheKeyGenerator, CacheResolver cacheResolver) {
        Intrinsics.checkNotNullParameter(normalizedCacheFactory, "normalizedCacheFactory");
        Intrinsics.checkNotNullParameter(cacheKeyGenerator, "cacheKeyGenerator");
        Intrinsics.checkNotNullParameter(cacheResolver, "cacheResolver");
        this.cacheKeyGenerator = cacheKeyGenerator;
        this.cacheResolver = cacheResolver;
        MutableSharedFlow<Set<String>> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 10, BufferOverflow.DROP_OLDEST, 1, null);
        this.changedKeysEvents = mutableSharedFlowMutableSharedFlow$default;
        this.changedKeys = FlowKt.asSharedFlow(mutableSharedFlowMutableSharedFlow$default);
        this.cache = LazyKt.lazy(new Function0<OptimisticCache>() { // from class: com.apollographql.apollo3.cache.normalized.internal.DefaultApolloStore$cache$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final OptimisticCache invoke() {
                NormalizedCache normalizedCacheChain = new OptimisticCache().chain(normalizedCacheFactory.createChain());
                Intrinsics.checkNotNull(normalizedCacheChain, "null cannot be cast to non-null type com.apollographql.apollo3.cache.normalized.api.internal.OptimisticCache");
                return (OptimisticCache) normalizedCacheChain;
            }
        });
        this.lock = new Lock();
    }

    @Override // com.apollographql.apollo3.cache.normalized.ApolloStore
    public SharedFlow<Set<String>> getChangedKeys() {
        return this.changedKeys;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OptimisticCache getCache() {
        return (OptimisticCache) this.cache.getValue();
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
        this.lock.write(new Function0<Unit>() { // from class: com.apollographql.apollo3.cache.normalized.internal.DefaultApolloStore.clearAll.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                DefaultApolloStore.this.getCache().clearAll();
            }
        });
        return true;
    }

    @Override // com.apollographql.apollo3.cache.normalized.ApolloStore
    public Object remove(final CacheKey cacheKey, final boolean z, Continuation<? super Boolean> continuation) {
        return this.lock.write(new Function0<Boolean>() { // from class: com.apollographql.apollo3.cache.normalized.internal.DefaultApolloStore.remove.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(DefaultApolloStore.this.getCache().remove(cacheKey, z));
            }
        });
    }

    @Override // com.apollographql.apollo3.cache.normalized.ApolloStore
    public Object remove(final List<CacheKey> list, final boolean z, Continuation<? super Integer> continuation) {
        return this.lock.write(new Function0<Integer>() { // from class: com.apollographql.apollo3.cache.normalized.internal.DefaultApolloStore.remove.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                Iterator<CacheKey> it = list.iterator();
                int i = 0;
                while (it.hasNext()) {
                    if (this.getCache().remove(it.next(), z)) {
                        i++;
                    }
                }
                return Integer.valueOf(i);
            }
        });
    }

    @Override // com.apollographql.apollo3.cache.normalized.ApolloStore
    public <D extends Operation.Data> Map<String, Record> normalize(Operation<D> operation, D data, CustomScalarAdapters customScalarAdapters) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        return OperationCacheExtensionsKt.normalize(operation, data, customScalarAdapters, this.cacheKeyGenerator);
    }

    @Override // com.apollographql.apollo3.cache.normalized.ApolloStore
    public <D extends Operation.Data> Object readOperation(final Operation<D> operation, final CustomScalarAdapters customScalarAdapters, final CacheHeaders cacheHeaders, Continuation<? super D> continuation) {
        return this.lock.read(new Function0<D>() { // from class: com.apollographql.apollo3.cache.normalized.internal.DefaultApolloStore.readOperation.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TD; */
            @Override // kotlin.jvm.functions.Function0
            public final Operation.Data invoke() {
                return (Operation.Data) OperationCacheExtensionsKt.readDataFromCache(operation, customScalarAdapters, this.getCache(), this.cacheResolver, cacheHeaders);
            }
        });
    }

    @Override // com.apollographql.apollo3.cache.normalized.ApolloStore
    public <D extends Fragment.Data> Object readFragment(final Fragment<D> fragment, final CacheKey cacheKey, final CustomScalarAdapters customScalarAdapters, final CacheHeaders cacheHeaders, Continuation<? super D> continuation) {
        return this.lock.read(new Function0<D>() { // from class: com.apollographql.apollo3.cache.normalized.internal.DefaultApolloStore.readFragment.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TD; */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment.Data invoke() {
                return OperationCacheExtensionsKt.readDataFromCache(fragment, cacheKey, customScalarAdapters, DefaultApolloStore.this.getCache(), DefaultApolloStore.this.cacheResolver, cacheHeaders);
            }
        });
    }

    @Override // com.apollographql.apollo3.cache.normalized.ApolloStore
    public <R> Object accessCache(final Function1<? super NormalizedCache, ? extends R> function1, Continuation<? super R> continuation) {
        return this.lock.write(new Function0<R>() { // from class: com.apollographql.apollo3.cache.normalized.internal.DefaultApolloStore.accessCache.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final R invoke() {
                return function1.invoke(this.getCache());
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.apollographql.apollo3.cache.normalized.ApolloStore
    public <D extends Operation.Data> Object writeOperation(Operation<D> operation, D d, CustomScalarAdapters customScalarAdapters, CacheHeaders cacheHeaders, boolean z, Continuation<? super Set<String>> continuation) {
        C08841 c08841;
        if (continuation instanceof C08841) {
            c08841 = (C08841) continuation;
            if ((c08841.label & Integer.MIN_VALUE) != 0) {
                c08841.label -= Integer.MIN_VALUE;
            } else {
                c08841 = new C08841(continuation);
            }
        } else {
            c08841 = new C08841(continuation);
        }
        C08841 c08842 = c08841;
        Object objWriteOperationWithRecords = c08842.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08842.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWriteOperationWithRecords);
            c08842.label = 1;
            objWriteOperationWithRecords = writeOperationWithRecords(operation, d, cacheHeaders, z, customScalarAdapters, c08842);
            if (objWriteOperationWithRecords == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWriteOperationWithRecords);
        }
        return ((Pair) objWriteOperationWithRecords).getSecond();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Override // com.apollographql.apollo3.cache.normalized.ApolloStore
    public <D extends Fragment.Data> Object writeFragment(final Fragment<D> fragment, final CacheKey cacheKey, final D d, final CustomScalarAdapters customScalarAdapters, final CacheHeaders cacheHeaders, boolean z, Continuation<? super Set<String>> continuation) {
        C08831 c08831;
        if (continuation instanceof C08831) {
            c08831 = (C08831) continuation;
            if ((c08831.label & Integer.MIN_VALUE) != 0) {
                c08831.label -= Integer.MIN_VALUE;
            } else {
                c08831 = new C08831(continuation);
            }
        } else {
            c08831 = new C08831(continuation);
        }
        C08831 c08832 = c08831;
        Object obj = c08832.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08832.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Set set = (Set) c08832.L$0;
            ResultKt.throwOnFailure(obj);
            return set;
        }
        ResultKt.throwOnFailure(obj);
        Set<String> set2 = (Set) this.lock.write(new Function0<Set<? extends String>>() { // from class: com.apollographql.apollo3.cache.normalized.internal.DefaultApolloStore$writeFragment$changedKeys$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Incorrect types in method signature: (Lcom/apollographql/apollo3/api/Fragment<TD;>;TD;Lcom/apollographql/apollo3/api/CustomScalarAdapters;Lcom/apollographql/apollo3/cache/normalized/internal/DefaultApolloStore;Lcom/apollographql/apollo3/cache/normalized/api/CacheKey;Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;)V */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set<? extends String> invoke() {
                return this.getCache().merge(OperationCacheExtensionsKt.normalize(fragment, d, customScalarAdapters, this.cacheKeyGenerator, cacheKey.getKey()).values(), cacheHeaders);
            }
        });
        if (z) {
            c08832.L$0 = set2;
            c08832.label = 1;
            if (publish(set2, c08832) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return set2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final <D extends Operation.Data> Object writeOperationWithRecords(final Operation<D> operation, final D d, final CacheHeaders cacheHeaders, boolean z, final CustomScalarAdapters customScalarAdapters, Continuation<? super Pair<? extends Set<Record>, ? extends Set<String>>> continuation) {
        C08851 c08851;
        Map map;
        Set<String> set;
        if (continuation instanceof C08851) {
            c08851 = (C08851) continuation;
            if ((c08851.label & Integer.MIN_VALUE) != 0) {
                c08851.label -= Integer.MIN_VALUE;
            } else {
                c08851 = new C08851(continuation);
            }
        } else {
            c08851 = new C08851(continuation);
        }
        C08851 c08852 = c08851;
        Object obj = c08852.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08852.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Pair pair = (Pair) this.lock.write(new Function0<Pair<? extends Map<String, ? extends Record>, ? extends Set<? extends String>>>() { // from class: com.apollographql.apollo3.cache.normalized.internal.DefaultApolloStore.writeOperationWithRecords.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Incorrect types in method signature: (Lcom/apollographql/apollo3/api/Operation<TD;>;TD;Lcom/apollographql/apollo3/api/CustomScalarAdapters;Lcom/apollographql/apollo3/cache/normalized/internal/DefaultApolloStore;Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;)V */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Pair<? extends Map<String, ? extends Record>, ? extends Set<? extends String>> invoke() {
                    Map<String, Record> mapNormalize = OperationCacheExtensionsKt.normalize(operation, d, customScalarAdapters, this.cacheKeyGenerator);
                    return TuplesKt.to(mapNormalize, this.getCache().merge(CollectionsKt.toList(mapNormalize.values()), cacheHeaders));
                }
            });
            map = (Map) pair.component1();
            set = (Set) pair.component2();
            if (z) {
                c08852.L$0 = map;
                c08852.L$1 = set;
                c08852.label = 1;
                if (publish(set, c08852) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            set = (Set) c08852.L$1;
            map = (Map) c08852.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return TuplesKt.to(CollectionsKt.toSet(map.values()), set);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Override // com.apollographql.apollo3.cache.normalized.ApolloStore
    public <D extends Operation.Data> Object writeOptimisticUpdates(final Operation<D> operation, final D d, final UUID uuid, final CustomScalarAdapters customScalarAdapters, boolean z, Continuation<? super Set<String>> continuation) {
        C08871 c08871;
        if (continuation instanceof C08871) {
            c08871 = (C08871) continuation;
            if ((c08871.label & Integer.MIN_VALUE) != 0) {
                c08871.label -= Integer.MIN_VALUE;
            } else {
                c08871 = new C08871(continuation);
            }
        } else {
            c08871 = new C08871(continuation);
        }
        C08871 c08872 = c08871;
        Object obj = c08872.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08872.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Set set = (Set) c08872.L$0;
            ResultKt.throwOnFailure(obj);
            return set;
        }
        ResultKt.throwOnFailure(obj);
        Set<String> set2 = (Set) this.lock.write(new Function0<Set<? extends String>>() { // from class: com.apollographql.apollo3.cache.normalized.internal.DefaultApolloStore$writeOptimisticUpdates$changedKeys$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Incorrect types in method signature: (Lcom/apollographql/apollo3/api/Operation<TD;>;TD;Lcom/apollographql/apollo3/api/CustomScalarAdapters;Lcom/apollographql/apollo3/cache/normalized/internal/DefaultApolloStore;Ljava/util/UUID;)V */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set<? extends String> invoke() {
                Collection<Record> collectionValues = OperationCacheExtensionsKt.normalize(operation, d, customScalarAdapters, this.cacheKeyGenerator).values();
                UUID uuid2 = uuid;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collectionValues, 10));
                for (Record record : collectionValues) {
                    arrayList.add(new Record(record.getKey(), record.getFields(), uuid2));
                }
                return this.getCache().addOptimisticUpdates(arrayList);
            }
        });
        if (z) {
            c08872.L$0 = set2;
            c08872.label = 1;
            if (publish(set2, c08872) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return set2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.apollographql.apollo3.cache.normalized.ApolloStore
    public Object rollbackOptimisticUpdates(final UUID uuid, boolean z, Continuation<? super Set<String>> continuation) {
        C08821 c08821;
        if (continuation instanceof C08821) {
            c08821 = (C08821) continuation;
            if ((c08821.label & Integer.MIN_VALUE) != 0) {
                c08821.label -= Integer.MIN_VALUE;
            } else {
                c08821 = new C08821(continuation);
            }
        } else {
            c08821 = new C08821(continuation);
        }
        Object obj = c08821.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08821.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Set set = (Set) c08821.L$0;
            ResultKt.throwOnFailure(obj);
            return set;
        }
        ResultKt.throwOnFailure(obj);
        Set<String> set2 = (Set) this.lock.write(new Function0<Set<? extends String>>() { // from class: com.apollographql.apollo3.cache.normalized.internal.DefaultApolloStore$rollbackOptimisticUpdates$changedKeys$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set<? extends String> invoke() {
                return this.this$0.getCache().removeOptimisticUpdates(uuid);
            }
        });
        if (z) {
            c08821.L$0 = set2;
            c08821.label = 1;
            if (publish(set2, c08821) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return set2;
    }

    @Override // com.apollographql.apollo3.cache.normalized.ApolloStore
    public Object dump(Continuation<? super Map<KClass<?>, ? extends Map<String, Record>>> continuation) {
        return this.lock.read(new Function0<Map<KClass<?>, ? extends Map<String, ? extends Record>>>() { // from class: com.apollographql.apollo3.cache.normalized.internal.DefaultApolloStore.dump.2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map<KClass<?>, ? extends Map<String, ? extends Record>> invoke() {
                return DefaultApolloStore.this.getCache().dump();
            }
        });
    }
}
