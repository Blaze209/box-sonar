package com.apollographql.apollo3.cache.normalized.internal;

import androidx.exifinterface.media.ExifInterface;
import com.apollographql.apollo3.ConcurrencyInfo;
import com.apollographql.apollo3.api.ApolloRequest;
import com.apollographql.apollo3.api.ApolloResponse;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.ExecutionContext;
import com.apollographql.apollo3.api.Mutation;
import com.apollographql.apollo3.api.Operation;
import com.apollographql.apollo3.api.Query;
import com.apollographql.apollo3.api.Subscription;
import com.apollographql.apollo3.cache.normalized.ApolloStore;
import com.apollographql.apollo3.cache.normalized.CacheInfo;
import com.apollographql.apollo3.cache.normalized.NormalizedCache;
import com.apollographql.apollo3.cache.normalized.api.ApolloCacheHeaders;
import com.apollographql.apollo3.cache.normalized.api.CacheHeaders;
import com.apollographql.apollo3.exception.ApolloExceptionHandlerKt;
import com.apollographql.apollo3.exception.CacheMissException;
import com.apollographql.apollo3.interceptor.ApolloInterceptor;
import com.apollographql.apollo3.interceptor.ApolloInterceptorChain;
import com.apollographql.apollo3.mpp.UtilsKt;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: ApolloCacheInterceptor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001+B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J4\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u00100\u000f\"\b\b\u0000\u0010\t*\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\t0\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J4\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u00100\u000f\"\b\b\u0000\u0010\t*\u00020\u00152\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\t0\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J4\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u00100\u000f\"\b\b\u0000\u0010\t*\u00020\u00172\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\t0\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J4\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u00100\u000f\"\b\b\u0000\u0010\t*\u00020\u00192\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\t0\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002JD\u0010\u001a\u001a\u00020\u001b\"\b\b\u0000\u0010\t*\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\t0\u000b2\u001c\u0010\u001c\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001dH\u0082@¢\u0006\u0002\u0010 JL\u0010!\u001a\u00020\u001b\"\b\b\u0000\u0010\t*\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\t0\u000b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\t0\u00102\u0006\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0082@¢\u0006\u0002\u0010&J4\u0010'\u001a\b\u0012\u0004\u0012\u0002H\t0\u0010\"\b\b\u0000\u0010\t*\u00020\u00172\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\t0\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010(JB\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u00100\u000f\"\b\b\u0000\u0010\t*\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\t0\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010*R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R%\u0010\u0007\u001a\u00020\b\"\b\b\u0000\u0010\t*\u00020\n*\b\u0012\u0004\u0012\u0002H\t0\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006,"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/internal/ApolloCacheInterceptor;", "Lcom/apollographql/apollo3/interceptor/ApolloInterceptor;", "store", "Lcom/apollographql/apollo3/cache/normalized/ApolloStore;", "(Lcom/apollographql/apollo3/cache/normalized/ApolloStore;)V", "getStore", "()Lcom/apollographql/apollo3/cache/normalized/ApolloStore;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "Lcom/apollographql/apollo3/api/ApolloRequest;", "getCustomScalarAdapters", "(Lcom/apollographql/apollo3/api/ApolloRequest;)Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "intercept", "Lkotlinx/coroutines/flow/Flow;", "Lcom/apollographql/apollo3/api/ApolloResponse;", "request", "chain", "Lcom/apollographql/apollo3/interceptor/ApolloInterceptorChain;", "interceptMutation", "Lcom/apollographql/apollo3/api/Mutation$Data;", "interceptQuery", "Lcom/apollographql/apollo3/api/Query$Data;", "interceptSubscription", "Lcom/apollographql/apollo3/api/Subscription$Data;", "maybeAsync", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lcom/apollographql/apollo3/api/ApolloRequest;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "maybeWriteToCache", "response", "extraKeys", "", "", "(Lcom/apollographql/apollo3/api/ApolloRequest;Lcom/apollographql/apollo3/api/ApolloResponse;Lcom/apollographql/apollo3/api/CustomScalarAdapters;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFromCache", "(Lcom/apollographql/apollo3/api/ApolloRequest;Lcom/apollographql/apollo3/api/CustomScalarAdapters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFromNetwork", "(Lcom/apollographql/apollo3/api/ApolloRequest;Lcom/apollographql/apollo3/interceptor/ApolloInterceptorChain;Lcom/apollographql/apollo3/api/CustomScalarAdapters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "apollo-normalized-cache"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ApolloCacheInterceptor implements ApolloInterceptor {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ApolloStore store;

    /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor$readFromCache$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ApolloCacheInterceptor.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor", f = "ApolloCacheInterceptor.kt", i = {0, 0, 0}, l = {209}, m = "readFromCache", n = {"request", SerializedNames.OPERATION, "startMillis"}, s = {"L$0", "L$1", "J$0"})
    static final class C08761<D extends Query.Data> extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C08761(Continuation<? super C08761> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApolloCacheInterceptor.this.readFromCache(null, null, this);
        }
    }

    public ApolloCacheInterceptor(ApolloStore store) {
        Intrinsics.checkNotNullParameter(store, "store");
        this.store = store;
    }

    public final ApolloStore getStore() {
        return this.store;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <D extends Operation.Data> Object maybeAsync(ApolloRequest<D> apolloRequest, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        if (NormalizedCache.getWriteToCacheAsynchronously(apolloRequest)) {
            ExecutionContext.Element element = apolloRequest.getExecutionContext().get(ConcurrencyInfo.INSTANCE);
            Intrinsics.checkNotNull(element);
            BuildersKt__Builders_commonKt.launch$default(((ConcurrencyInfo) element).getCoroutineScope(), null, null, new AnonymousClass2(function1, null), 3, null);
            return Unit.INSTANCE;
        }
        Object objInvoke = function1.invoke(continuation);
        return objInvoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor$maybeAsync$2, reason: invalid class name */
    /* JADX INFO: compiled from: ApolloCacheInterceptor.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor$maybeAsync$2", f = "ApolloCacheInterceptor.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Function1<Continuation<? super Unit>, Object> function1 = this.$block;
                    this.label = 1;
                    if (function1.invoke(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Throwable th) {
                ApolloExceptionHandlerKt.getApolloExceptionHandler().invoke(new Exception("An exception occurred while writing to the cache asynchronously", th));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object maybeWriteToCache$default(ApolloCacheInterceptor apolloCacheInterceptor, ApolloRequest apolloRequest, ApolloResponse apolloResponse, CustomScalarAdapters customScalarAdapters, Set set, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            set = SetsKt.emptySet();
        }
        return apolloCacheInterceptor.maybeWriteToCache(apolloRequest, apolloResponse, customScalarAdapters, set, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <D extends Operation.Data> Object maybeWriteToCache(ApolloRequest<D> apolloRequest, ApolloResponse<D> apolloResponse, CustomScalarAdapters customScalarAdapters, Set<String> set, Continuation<? super Unit> continuation) {
        if (NormalizedCache.getDoNotStore(apolloRequest)) {
            return Unit.INSTANCE;
        }
        if (apolloResponse.hasErrors() && !NormalizedCache.getStorePartialResponses(apolloRequest)) {
            return Unit.INSTANCE;
        }
        Object objMaybeAsync = maybeAsync(apolloRequest, new C08752(apolloResponse, apolloRequest, this, customScalarAdapters, set, null), continuation);
        return objMaybeAsync == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMaybeAsync : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor$maybeWriteToCache$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ApolloCacheInterceptor.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "D", "Lcom/apollographql/apollo3/api/Operation$Data;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor$maybeWriteToCache$2", f = "ApolloCacheInterceptor.kt", i = {}, l = {79, 83}, m = "invokeSuspend", n = {}, s = {})
    static final class C08752 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ CustomScalarAdapters $customScalarAdapters;
        final /* synthetic */ Set<String> $extraKeys;
        final /* synthetic */ ApolloRequest<D> $request;
        final /* synthetic */ ApolloResponse<D> $response;
        int label;
        final /* synthetic */ ApolloCacheInterceptor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08752(ApolloResponse<D> apolloResponse, ApolloRequest<D> apolloRequest, ApolloCacheInterceptor apolloCacheInterceptor, CustomScalarAdapters customScalarAdapters, Set<String> set, Continuation<? super C08752> continuation) {
            super(1, continuation);
            this.$response = apolloResponse;
            this.$request = apolloRequest;
            this.this$0 = apolloCacheInterceptor;
            this.$customScalarAdapters = customScalarAdapters;
            this.$extraKeys = set;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C08752(this.$response, this.$request, this.this$0, this.$customScalarAdapters, this.$extraKeys, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C08752) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:
        
            if (r12 == r0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x008b, code lost:
        
            if (r11.this$0.getStore().publish(kotlin.collections.SetsKt.plus(r12, (java.lang.Iterable) r11.$extraKeys), r11) == r0) goto L22;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r11.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1f
                if (r1 == r3) goto L1b
                if (r1 != r2) goto L13
                kotlin.ResultKt.throwOnFailure(r12)
                goto L8e
            L13:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r12)
                throw r11
            L1b:
                kotlin.ResultKt.throwOnFailure(r12)
                goto L6d
            L1f:
                kotlin.ResultKt.throwOnFailure(r12)
                com.apollographql.apollo3.api.ApolloResponse<D> r12 = r11.$response
                D extends com.apollographql.apollo3.api.Operation$Data r12 = r12.data
                if (r12 == 0) goto L70
                com.apollographql.apollo3.api.ApolloRequest<D> r12 = r11.$request
                com.apollographql.apollo3.cache.normalized.api.CacheHeaders r12 = com.apollographql.apollo3.cache.normalized.NormalizedCache.getCacheHeaders(r12)
                com.apollographql.apollo3.api.ApolloResponse<D> r1 = r11.$response
                com.apollographql.apollo3.cache.normalized.api.CacheHeaders r1 = com.apollographql.apollo3.cache.normalized.NormalizedCache.getCacheHeaders(r1)
                com.apollographql.apollo3.cache.normalized.api.CacheHeaders r12 = r12.plus(r1)
                com.apollographql.apollo3.api.ApolloRequest<D> r1 = r11.$request
                boolean r1 = com.apollographql.apollo3.cache.normalized.NormalizedCache.getStoreReceiveDate(r1)
                if (r1 == 0) goto L4a
                com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor$Companion r1 = com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor.INSTANCE
                com.apollographql.apollo3.cache.normalized.api.CacheHeaders r1 = com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor.Companion.access$nowDateCacheHeaders(r1)
                com.apollographql.apollo3.cache.normalized.api.CacheHeaders r12 = r12.plus(r1)
            L4a:
                r8 = r12
                com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor r12 = r11.this$0
                com.apollographql.apollo3.cache.normalized.ApolloStore r4 = r12.getStore()
                com.apollographql.apollo3.api.ApolloRequest<D> r12 = r11.$request
                com.apollographql.apollo3.api.Operation r5 = r12.getOperation()
                com.apollographql.apollo3.api.ApolloResponse<D> r12 = r11.$response
                D extends com.apollographql.apollo3.api.Operation$Data r6 = r12.data
                kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
                com.apollographql.apollo3.api.CustomScalarAdapters r7 = r11.$customScalarAdapters
                r10 = r11
                kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
                r11.label = r3
                r9 = 0
                java.lang.Object r12 = r4.writeOperation(r5, r6, r7, r8, r9, r10)
                if (r12 != r0) goto L6d
                goto L8d
            L6d:
                java.util.Set r12 = (java.util.Set) r12
                goto L74
            L70:
                java.util.Set r12 = kotlin.collections.SetsKt.emptySet()
            L74:
                com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor r1 = r11.this$0
                com.apollographql.apollo3.cache.normalized.ApolloStore r1 = r1.getStore()
                java.util.Set<java.lang.String> r3 = r11.$extraKeys
                java.lang.Iterable r3 = (java.lang.Iterable) r3
                java.util.Set r12 = kotlin.collections.SetsKt.plus(r12, r3)
                r3 = r11
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r11.label = r2
                java.lang.Object r11 = r1.publish(r12, r3)
                if (r11 != r0) goto L8e
            L8d:
                return r0
            L8e:
                kotlin.Unit r11 = kotlin.Unit.INSTANCE
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor.C08752.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.apollographql.apollo3.interceptor.ApolloInterceptor
    public <D extends Operation.Data> Flow<ApolloResponse<D>> intercept(ApolloRequest<D> request, ApolloInterceptorChain chain) {
        Flow flowInterceptQuery;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(chain, "chain");
        Operation<D> operation = request.getOperation();
        if (operation instanceof Subscription) {
            flowInterceptQuery = interceptSubscription(request, chain);
            Intrinsics.checkNotNull(flowInterceptQuery, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<com.apollographql.apollo3.api.ApolloResponse<D of com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor.intercept>>");
        } else if (operation instanceof Mutation) {
            flowInterceptQuery = interceptMutation(request, chain);
            Intrinsics.checkNotNull(flowInterceptQuery, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<com.apollographql.apollo3.api.ApolloResponse<D of com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor.intercept>>");
        } else if (operation instanceof Query) {
            flowInterceptQuery = interceptQuery(request, chain);
            Intrinsics.checkNotNull(flowInterceptQuery, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<com.apollographql.apollo3.api.ApolloResponse<D of com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor.intercept>>");
        } else {
            throw new IllegalStateException(("Unknown operation " + request.getOperation()).toString());
        }
        ExecutionContext.Element element = request.getExecutionContext().get(ConcurrencyInfo.INSTANCE);
        Intrinsics.checkNotNull(element);
        return FlowKt.flowOn(flowInterceptQuery, ((ConcurrencyInfo) element).getDispatcher());
    }

    private final <D extends Subscription.Data> Flow<ApolloResponse<D>> interceptSubscription(ApolloRequest<D> request, ApolloInterceptorChain chain) {
        return FlowKt.onEach(chain.proceed(request), new C08741(request, getCustomScalarAdapters(request), null));
    }

    /* JADX INFO: Add missing generic type declarations: [D] */
    /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor$interceptSubscription$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ApolloCacheInterceptor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "D", "Lcom/apollographql/apollo3/api/Subscription$Data;", "it", "Lcom/apollographql/apollo3/api/ApolloResponse;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor$interceptSubscription$1", f = "ApolloCacheInterceptor.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
    static final class C08741<D> extends SuspendLambda implements Function2<ApolloResponse<D>, Continuation<? super Unit>, Object> {
        final /* synthetic */ CustomScalarAdapters $customScalarAdapters;
        final /* synthetic */ ApolloRequest<D> $request;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08741(ApolloRequest<D> apolloRequest, CustomScalarAdapters customScalarAdapters, Continuation<? super C08741> continuation) {
            super(2, continuation);
            this.$request = apolloRequest;
            this.$customScalarAdapters = customScalarAdapters;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C08741 c08741 = ApolloCacheInterceptor.this.new C08741(this.$request, this.$customScalarAdapters, continuation);
            c08741.L$0 = obj;
            return c08741;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ApolloResponse<D> apolloResponse, Continuation<? super Unit> continuation) {
            return ((C08741) create(apolloResponse, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ApolloResponse apolloResponse = (ApolloResponse) this.L$0;
                this.label = 1;
                if (ApolloCacheInterceptor.maybeWriteToCache$default(ApolloCacheInterceptor.this, this.$request, apolloResponse, this.$customScalarAdapters, null, this, 8, null) == coroutine_suspended) {
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

    public final <D extends Operation.Data> CustomScalarAdapters getCustomScalarAdapters(ApolloRequest<D> apolloRequest) {
        Intrinsics.checkNotNullParameter(apolloRequest, "<this>");
        ExecutionContext.Element element = apolloRequest.getExecutionContext().get(CustomScalarAdapters.INSTANCE);
        Intrinsics.checkNotNull(element);
        return (CustomScalarAdapters) element;
    }

    private final <D extends Mutation.Data> Flow<ApolloResponse<D>> interceptMutation(ApolloRequest<D> request, ApolloInterceptorChain chain) {
        return FlowKt.flow(new AnonymousClass1(request, this, getCustomScalarAdapters(request), chain, null));
    }

    /* JADX INFO: Add missing generic type declarations: [D] */
    /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor$interceptMutation$1, reason: invalid class name */
    /* JADX INFO: compiled from: ApolloCacheInterceptor.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u008a@"}, d2 = {"<anonymous>", "", "D", "Lcom/apollographql/apollo3/api/Mutation$Data;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/apollographql/apollo3/api/ApolloResponse;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor$interceptMutation$1", f = "ApolloCacheInterceptor.kt", i = {0, 0, 1, 1, 1, 2, 2, 3}, l = {135, 160, 177, 182}, m = "invokeSuspend", n = {"$this$flow", "optimisticData", "optimisticData", "networkException", "optimisticKeys", "networkException", "optimisticKeys", "networkException"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$0"})
    static final class AnonymousClass1<D> extends SuspendLambda implements Function2<FlowCollector<? super ApolloResponse<D>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ApolloInterceptorChain $chain;
        final /* synthetic */ CustomScalarAdapters $customScalarAdapters;
        final /* synthetic */ ApolloRequest<D> $request;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ ApolloCacheInterceptor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ApolloRequest<D> apolloRequest, ApolloCacheInterceptor apolloCacheInterceptor, CustomScalarAdapters customScalarAdapters, ApolloInterceptorChain apolloInterceptorChain, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$request = apolloRequest;
            this.this$0 = apolloCacheInterceptor;
            this.$customScalarAdapters = customScalarAdapters;
            this.$chain = apolloInterceptorChain;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$request, this.this$0, this.$customScalarAdapters, this.$chain, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super ApolloResponse<D>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:25:0x00db  */
        /* JADX WARN: Code duplicated, block: B:28:0x00e2  */
        /* JADX WARN: Code duplicated, block: B:30:0x00e6 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:31:0x00e8  */
        /* JADX WARN: Code duplicated, block: B:34:0x0107  */
        /* JADX WARN: Code duplicated, block: B:36:0x010c  */
        /* JADX WARN: Code duplicated, block: B:38:0x0116 A[PHI: r2 r5
          0x0116: PHI (r2v8 kotlin.jvm.internal.Ref$ObjectRef) = (r2v7 kotlin.jvm.internal.Ref$ObjectRef), (r2v12 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:29:0x00e4, B:37:0x0112] A[DONT_GENERATE, DONT_INLINE]
          0x0116: PHI (r5v6 kotlin.jvm.internal.Ref$ObjectRef) = (r5v3 kotlin.jvm.internal.Ref$ObjectRef), (r5v8 kotlin.jvm.internal.Ref$ObjectRef) binds: [B:29:0x00e4, B:37:0x0112] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:41:0x0135  */
        /* JADX WARN: Code duplicated, block: B:44:0x013e  */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            FlowCollector flowCollector;
            Mutation.Data data;
            FlowCollector flowCollector2;
            Mutation.Data data2;
            Ref.ObjectRef objectRef;
            Flow flowM16356catch;
            Ref.ObjectRef objectRef2;
            Ref.ObjectRef objectRef3;
            Mutation.Data data3;
            Ref.ObjectRef objectRef4;
            Ref.ObjectRef objectRef5;
            Ref.ObjectRef objectRef6;
            Object objRollbackOptimisticUpdates;
            ApolloStore store;
            T t;
            Ref.ObjectRef objectRef7;
            T tEmptySet;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector3 = (FlowCollector) this.L$0;
                Mutation.Data optimisticData = NormalizedCache.getOptimisticData(this.$request);
                if (optimisticData != null) {
                    this.L$0 = flowCollector3;
                    this.L$1 = optimisticData;
                    this.label = 1;
                    if (this.this$0.getStore().writeOptimisticUpdates(this.$request.getOperation(), optimisticData, this.$request.getRequestUuid(), this.$customScalarAdapters, true, this) != coroutine_suspended) {
                        flowCollector2 = flowCollector3;
                        data2 = optimisticData;
                    }
                } else {
                    flowCollector = flowCollector3;
                    data = optimisticData;
                    objectRef = new Ref.ObjectRef();
                    flowM16356catch = FlowKt.m16356catch(this.$chain.proceed(this.$request), new ApolloCacheInterceptor$interceptMutation$1$networkResponses$1(objectRef, null));
                    objectRef2 = new Ref.ObjectRef();
                    this.L$0 = data;
                    this.L$1 = objectRef;
                    this.L$2 = objectRef2;
                    this.label = 2;
                    if (flowM16356catch.collect(new C01031(data, new Ref.ObjectRef(), objectRef2, this.this$0, this.$request, this.$customScalarAdapters, flowCollector), this) != coroutine_suspended) {
                        objectRef3 = objectRef;
                        data3 = data;
                        objectRef4 = objectRef2;
                        if (objectRef3.element != 0) {
                            if (objectRef4.element != 0) {
                                store = this.this$0.getStore();
                                t = objectRef4.element;
                                Intrinsics.checkNotNull(t);
                                this.L$0 = objectRef3;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.label = 4;
                                if (store.publish((Set) t, this) != coroutine_suspended) {
                                    objectRef7 = objectRef3;
                                    T t2 = objectRef7.element;
                                    Intrinsics.checkNotNull(t2);
                                    throw ((Throwable) t2);
                                }
                            } else if (data3 != null) {
                                this.L$0 = objectRef3;
                                this.L$1 = objectRef4;
                                this.L$2 = objectRef4;
                                this.label = 3;
                                objRollbackOptimisticUpdates = this.this$0.getStore().rollbackOptimisticUpdates(this.$request.getRequestUuid(), false, this);
                                if (objRollbackOptimisticUpdates != coroutine_suspended) {
                                    objectRef5 = objectRef3;
                                    objectRef6 = objectRef4;
                                    tEmptySet = (Set) objRollbackOptimisticUpdates;
                                    objectRef4.element = tEmptySet;
                                    objectRef4 = objectRef6;
                                    objectRef3 = objectRef5;
                                    store = this.this$0.getStore();
                                    t = objectRef4.element;
                                    Intrinsics.checkNotNull(t);
                                    this.L$0 = objectRef3;
                                    this.L$1 = null;
                                    this.L$2 = null;
                                    this.label = 4;
                                    if (store.publish((Set) t, this) != coroutine_suspended) {
                                        objectRef7 = objectRef3;
                                        T t3 = objectRef7.element;
                                        Intrinsics.checkNotNull(t3);
                                        throw ((Throwable) t3);
                                    }
                                }
                            } else {
                                objectRef5 = objectRef3;
                                objectRef6 = objectRef4;
                                tEmptySet = SetsKt.emptySet();
                                objectRef4.element = tEmptySet;
                                objectRef4 = objectRef6;
                                objectRef3 = objectRef5;
                                store = this.this$0.getStore();
                                t = objectRef4.element;
                                Intrinsics.checkNotNull(t);
                                this.L$0 = objectRef3;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.label = 4;
                                if (store.publish((Set) t, this) != coroutine_suspended) {
                                    objectRef7 = objectRef3;
                                    T t4 = objectRef7.element;
                                    Intrinsics.checkNotNull(t4);
                                    throw ((Throwable) t4);
                                }
                            }
                        } else {
                            return Unit.INSTANCE;
                        }
                    }
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                data2 = (Mutation.Data) this.L$1;
                flowCollector2 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i == 2) {
                    objectRef4 = (Ref.ObjectRef) this.L$2;
                    objectRef3 = (Ref.ObjectRef) this.L$1;
                    data3 = (Mutation.Data) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (objectRef3.element != 0) {
                        if (objectRef4.element != 0) {
                            store = this.this$0.getStore();
                            t = objectRef4.element;
                            Intrinsics.checkNotNull(t);
                            this.L$0 = objectRef3;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.label = 4;
                            if (store.publish((Set) t, this) != coroutine_suspended) {
                                objectRef7 = objectRef3;
                            }
                        } else if (data3 != null) {
                            this.L$0 = objectRef3;
                            this.L$1 = objectRef4;
                            this.L$2 = objectRef4;
                            this.label = 3;
                            objRollbackOptimisticUpdates = this.this$0.getStore().rollbackOptimisticUpdates(this.$request.getRequestUuid(), false, this);
                            if (objRollbackOptimisticUpdates != coroutine_suspended) {
                                objectRef5 = objectRef3;
                                objectRef6 = objectRef4;
                                tEmptySet = (Set) objRollbackOptimisticUpdates;
                                objectRef4.element = tEmptySet;
                                objectRef4 = objectRef6;
                                objectRef3 = objectRef5;
                                store = this.this$0.getStore();
                                t = objectRef4.element;
                                Intrinsics.checkNotNull(t);
                                this.L$0 = objectRef3;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.label = 4;
                                if (store.publish((Set) t, this) != coroutine_suspended) {
                                    objectRef7 = objectRef3;
                                }
                            }
                        } else {
                            objectRef5 = objectRef3;
                            objectRef6 = objectRef4;
                            tEmptySet = SetsKt.emptySet();
                            objectRef4.element = tEmptySet;
                            objectRef4 = objectRef6;
                            objectRef3 = objectRef5;
                            store = this.this$0.getStore();
                            t = objectRef4.element;
                            Intrinsics.checkNotNull(t);
                            this.L$0 = objectRef3;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.label = 4;
                            if (store.publish((Set) t, this) != coroutine_suspended) {
                                objectRef7 = objectRef3;
                            }
                        }
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                if (i == 3) {
                    objectRef4 = (Ref.ObjectRef) this.L$2;
                    Ref.ObjectRef objectRef8 = (Ref.ObjectRef) this.L$1;
                    Ref.ObjectRef objectRef9 = (Ref.ObjectRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    objectRef5 = objectRef9;
                    objectRef6 = objectRef8;
                    objRollbackOptimisticUpdates = obj;
                    tEmptySet = (Set) objRollbackOptimisticUpdates;
                    objectRef4.element = tEmptySet;
                    objectRef4 = objectRef6;
                    objectRef3 = objectRef5;
                    store = this.this$0.getStore();
                    t = objectRef4.element;
                    Intrinsics.checkNotNull(t);
                    this.L$0 = objectRef3;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 4;
                    if (store.publish((Set) t, this) != coroutine_suspended) {
                        objectRef7 = objectRef3;
                    }
                    return coroutine_suspended;
                }
                if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef7 = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            T t5 = objectRef7.element;
            Intrinsics.checkNotNull(t5);
            throw ((Throwable) t5);
            data = data2;
            flowCollector = flowCollector2;
            objectRef = new Ref.ObjectRef();
            flowM16356catch = FlowKt.m16356catch(this.$chain.proceed(this.$request), new ApolloCacheInterceptor$interceptMutation$1$networkResponses$1(objectRef, null));
            objectRef2 = new Ref.ObjectRef();
            this.L$0 = data;
            this.L$1 = objectRef;
            this.L$2 = objectRef2;
            this.label = 2;
            if (flowM16356catch.collect(new C01031(data, new Ref.ObjectRef(), objectRef2, this.this$0, this.$request, this.$customScalarAdapters, flowCollector), this) != coroutine_suspended) {
                objectRef3 = objectRef;
                data3 = data;
                objectRef4 = objectRef2;
                if (objectRef3.element != 0) {
                    if (objectRef4.element != 0) {
                        store = this.this$0.getStore();
                        t = objectRef4.element;
                        Intrinsics.checkNotNull(t);
                        this.L$0 = objectRef3;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.label = 4;
                        if (store.publish((Set) t, this) != coroutine_suspended) {
                            objectRef7 = objectRef3;
                            T t6 = objectRef7.element;
                            Intrinsics.checkNotNull(t6);
                            throw ((Throwable) t6);
                        }
                    } else if (data3 != null) {
                        this.L$0 = objectRef3;
                        this.L$1 = objectRef4;
                        this.L$2 = objectRef4;
                        this.label = 3;
                        objRollbackOptimisticUpdates = this.this$0.getStore().rollbackOptimisticUpdates(this.$request.getRequestUuid(), false, this);
                        if (objRollbackOptimisticUpdates != coroutine_suspended) {
                            objectRef5 = objectRef3;
                            objectRef6 = objectRef4;
                            tEmptySet = (Set) objRollbackOptimisticUpdates;
                            objectRef4.element = tEmptySet;
                            objectRef4 = objectRef6;
                            objectRef3 = objectRef5;
                            store = this.this$0.getStore();
                            t = objectRef4.element;
                            Intrinsics.checkNotNull(t);
                            this.L$0 = objectRef3;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.label = 4;
                            if (store.publish((Set) t, this) != coroutine_suspended) {
                                objectRef7 = objectRef3;
                                T t7 = objectRef7.element;
                                Intrinsics.checkNotNull(t7);
                                throw ((Throwable) t7);
                            }
                        }
                    } else {
                        objectRef5 = objectRef3;
                        objectRef6 = objectRef4;
                        tEmptySet = SetsKt.emptySet();
                        objectRef4.element = tEmptySet;
                        objectRef4 = objectRef6;
                        objectRef3 = objectRef5;
                        store = this.this$0.getStore();
                        t = objectRef4.element;
                        Intrinsics.checkNotNull(t);
                        this.L$0 = objectRef3;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.label = 4;
                        if (store.publish((Set) t, this) != coroutine_suspended) {
                            objectRef7 = objectRef3;
                            T t8 = objectRef7.element;
                            Intrinsics.checkNotNull(t8);
                            throw ((Throwable) t8);
                        }
                    }
                } else {
                    return Unit.INSTANCE;
                }
            }
            return coroutine_suspended;
        }

        /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor$interceptMutation$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: ApolloCacheInterceptor.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "D", "Lcom/apollographql/apollo3/api/Mutation$Data;", "response", "Lcom/apollographql/apollo3/api/ApolloResponse;", "emit", "(Lcom/apollographql/apollo3/api/ApolloResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 5, 1}, xi = 48)
        static final class C01031<T> implements FlowCollector {
            final /* synthetic */ FlowCollector<ApolloResponse<D>> $$this$flow;
            final /* synthetic */ CustomScalarAdapters $customScalarAdapters;
            final /* synthetic */ Mutation.Data $optimisticData;
            final /* synthetic */ Ref.ObjectRef<Set<String>> $optimisticKeys;
            final /* synthetic */ Ref.ObjectRef<ApolloResponse<D>> $previousResponse;
            final /* synthetic */ ApolloRequest<D> $request;
            final /* synthetic */ ApolloCacheInterceptor this$0;

            /* JADX WARN: Multi-variable type inference failed */
            C01031(Mutation.Data data, Ref.ObjectRef<ApolloResponse<D>> objectRef, Ref.ObjectRef<Set<String>> objectRef2, ApolloCacheInterceptor apolloCacheInterceptor, ApolloRequest<D> apolloRequest, CustomScalarAdapters customScalarAdapters, FlowCollector<? super ApolloResponse<D>> flowCollector) {
                this.$optimisticData = data;
                this.$previousResponse = objectRef;
                this.$optimisticKeys = objectRef2;
                this.this$0 = apolloCacheInterceptor;
                this.$request = apolloRequest;
                this.$customScalarAdapters = customScalarAdapters;
                this.$$this$flow = flowCollector;
            }

            /* JADX WARN: Code duplicated, block: B:39:0x00cb  */
            /* JADX WARN: Code duplicated, block: B:7:0x0014  */
            /* JADX WARN: Code restructure failed: missing block: B:41:0x00d9, code lost:
            
                if (r11.emit(r10, r6) == r0) goto L42;
             */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r10v16 */
            /* JADX WARN: Type inference failed for: r10v4 */
            /* JADX WARN: Type inference failed for: r10v8, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r11v0, types: [T, com.apollographql.apollo3.api.ApolloResponse<D>, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r11v15 */
            /* JADX WARN: Type inference failed for: r11v16 */
            /* JADX WARN: Type inference failed for: r11v17 */
            /* JADX WARN: Type inference failed for: r11v18 */
            /* JADX WARN: Type inference failed for: r11v19 */
            /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r11v20 */
            /* JADX WARN: Type inference failed for: r11v5 */
            /* JADX WARN: Type inference failed for: r11v6 */
            /* JADX WARN: Type inference failed for: r11v8, types: [kotlinx.coroutines.flow.FlowCollector, kotlinx.coroutines.flow.FlowCollector<com.apollographql.apollo3.api.ApolloResponse<D>>] */
            /* JADX WARN: Type inference failed for: r3v1, types: [com.apollographql.apollo3.api.ApolloResponse] */
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
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(com.apollographql.apollo3.api.ApolloResponse<D> r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
                /*
                    Method dump skipped, instruction units count: 223
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor.AnonymousClass1.C01031.emit(com.apollographql.apollo3.api.ApolloResponse, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((ApolloResponse) obj, (Continuation<? super Unit>) continuation);
            }
        }
    }

    private final <D extends Query.Data> Flow<ApolloResponse<D>> interceptQuery(ApolloRequest<D> request, ApolloInterceptorChain chain) {
        return FlowKt.flow(new C08731(NormalizedCache.getFetchFromCache(request), this, request, getCustomScalarAdapters(request), chain, null));
    }

    /* JADX INFO: Add missing generic type declarations: [D] */
    /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor$interceptQuery$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ApolloCacheInterceptor.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u008a@"}, d2 = {"<anonymous>", "", "D", "Lcom/apollographql/apollo3/api/Query$Data;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/apollographql/apollo3/api/ApolloResponse;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor$interceptQuery$1", f = "ApolloCacheInterceptor.kt", i = {}, l = {194, 194, 196, 196}, m = "invokeSuspend", n = {}, s = {})
    static final class C08731<D> extends SuspendLambda implements Function2<FlowCollector<? super ApolloResponse<D>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ApolloInterceptorChain $chain;
        final /* synthetic */ CustomScalarAdapters $customScalarAdapters;
        final /* synthetic */ boolean $fetchFromCache;
        final /* synthetic */ ApolloRequest<D> $request;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ApolloCacheInterceptor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08731(boolean z, ApolloCacheInterceptor apolloCacheInterceptor, ApolloRequest<D> apolloRequest, CustomScalarAdapters customScalarAdapters, ApolloInterceptorChain apolloInterceptorChain, Continuation<? super C08731> continuation) {
            super(2, continuation);
            this.$fetchFromCache = z;
            this.this$0 = apolloCacheInterceptor;
            this.$request = apolloRequest;
            this.$customScalarAdapters = customScalarAdapters;
            this.$chain = apolloInterceptorChain;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C08731 c08731 = new C08731(this.$fetchFromCache, this.this$0, this.$request, this.$customScalarAdapters, this.$chain, continuation);
            c08731.L$0 = obj;
            return c08731;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super ApolloResponse<D>> flowCollector, Continuation<? super Unit> continuation) {
            return ((C08731) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x005d, code lost:
        
            if (r1.emit(r10, r9) == r0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0083, code lost:
        
            if (kotlinx.coroutines.flow.FlowKt.emitAll(r1, (kotlinx.coroutines.flow.Flow) r10, r9) == r0) goto L27;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r9.label
                r2 = 0
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 1
                if (r1 == 0) goto L32
                if (r1 == r6) goto L2a
                if (r1 == r5) goto L26
                if (r1 == r4) goto L1e
                if (r1 != r3) goto L16
                goto L26
            L16:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L1e:
                java.lang.Object r1 = r9.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r10)
                goto L76
            L26:
                kotlin.ResultKt.throwOnFailure(r10)
                goto L86
            L2a:
                java.lang.Object r1 = r9.L$0
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                kotlin.ResultKt.throwOnFailure(r10)
                goto L52
            L32:
                kotlin.ResultKt.throwOnFailure(r10)
                java.lang.Object r10 = r9.L$0
                r1 = r10
                kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
                boolean r10 = r9.$fetchFromCache
                if (r10 == 0) goto L60
                com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor r10 = r9.this$0
                com.apollographql.apollo3.api.ApolloRequest<D> r3 = r9.$request
                com.apollographql.apollo3.api.CustomScalarAdapters r4 = r9.$customScalarAdapters
                r7 = r9
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r9.L$0 = r1
                r9.label = r6
                java.lang.Object r10 = com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor.access$readFromCache(r10, r3, r4, r7)
                if (r10 != r0) goto L52
                goto L85
            L52:
                r3 = r9
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r9.L$0 = r2
                r9.label = r5
                java.lang.Object r9 = r1.emit(r10, r3)
                if (r9 != r0) goto L86
                goto L85
            L60:
                com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor r10 = r9.this$0
                com.apollographql.apollo3.api.ApolloRequest<D> r5 = r9.$request
                com.apollographql.apollo3.interceptor.ApolloInterceptorChain r6 = r9.$chain
                com.apollographql.apollo3.api.CustomScalarAdapters r7 = r9.$customScalarAdapters
                r8 = r9
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                r9.L$0 = r1
                r9.label = r4
                java.lang.Object r10 = com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor.access$readFromNetwork(r10, r5, r6, r7, r8)
                if (r10 != r0) goto L76
                goto L85
            L76:
                kotlinx.coroutines.flow.Flow r10 = (kotlinx.coroutines.flow.Flow) r10
                r4 = r9
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r9.L$0 = r2
                r9.label = r3
                java.lang.Object r9 = kotlinx.coroutines.flow.FlowKt.emitAll(r1, r10, r4)
                if (r9 != r0) goto L86
            L85:
                return r0
            L86:
                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor.C08731.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:30:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:32:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final <D extends Query.Data> Object readFromCache(ApolloRequest<D> apolloRequest, CustomScalarAdapters customScalarAdapters, Continuation<? super ApolloResponse<D>> continuation) {
        C08761 c08761;
        ApolloRequest<D> apolloRequest2;
        Operation operation;
        CacheMissException e;
        long j;
        if (continuation instanceof C08761) {
            c08761 = (C08761) continuation;
            if ((c08761.label & Integer.MIN_VALUE) != 0) {
                c08761.label -= Integer.MIN_VALUE;
            } else {
                c08761 = new C08761(continuation);
            }
        } else {
            c08761 = new C08761(continuation);
        }
        Object obj = c08761.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08761.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Operation operation2 = apolloRequest.getOperation();
            long jCurrentTimeMillis = UtilsKt.currentTimeMillis();
            try {
                ApolloStore apolloStore = this.store;
                CacheHeaders cacheHeaders = NormalizedCache.getCacheHeaders(apolloRequest);
                c08761.L$0 = apolloRequest;
                c08761.L$1 = operation2;
                c08761.J$0 = jCurrentTimeMillis;
                c08761.label = 1;
                Object operation3 = apolloStore.readOperation(operation2, customScalarAdapters, cacheHeaders, c08761);
                if (operation3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                apolloRequest2 = apolloRequest;
                operation = operation2;
                obj = operation3;
                j = jCurrentTimeMillis;
            } catch (CacheMissException e2) {
                apolloRequest2 = apolloRequest;
                operation = operation2;
                e = e2;
                j = jCurrentTimeMillis;
                if (NormalizedCache.getEmitCacheMisses(apolloRequest2)) {
                    return NormalizedCache.cacheInfo(new ApolloResponse.Builder(operation, apolloRequest2.getRequestUuid(), null).addExecutionContext(apolloRequest2.getExecutionContext()), new CacheInfo.Builder().cacheStartMillis(j).cacheEndMillis(UtilsKt.currentTimeMillis()).cacheHit(false).cacheMissException(e).build()).isLast(true).build();
                }
                throw e;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = c08761.J$0;
            operation = (Operation) c08761.L$1;
            apolloRequest2 = (ApolloRequest) c08761.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (CacheMissException e3) {
                e = e3;
                if (NormalizedCache.getEmitCacheMisses(apolloRequest2)) {
                    return NormalizedCache.cacheInfo(new ApolloResponse.Builder(operation, apolloRequest2.getRequestUuid(), null).addExecutionContext(apolloRequest2.getExecutionContext()), new CacheInfo.Builder().cacheStartMillis(j).cacheEndMillis(UtilsKt.currentTimeMillis()).cacheHit(false).cacheMissException(e).build()).isLast(true).build();
                }
                throw e;
            }
        }
        return NormalizedCache.cacheInfo(new ApolloResponse.Builder(operation, apolloRequest2.getRequestUuid(), (Query.Data) obj).addExecutionContext(apolloRequest2.getExecutionContext()), new CacheInfo.Builder().cacheStartMillis(j).cacheEndMillis(UtilsKt.currentTimeMillis()).cacheHit(true).build()).isLast(true).build();
    }

    /* JADX INFO: Add missing generic type declarations: [D] */
    /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor$readFromNetwork$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ApolloCacheInterceptor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "it", "Lcom/apollographql/apollo3/api/ApolloResponse;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor$readFromNetwork$2", f = "ApolloCacheInterceptor.kt", i = {}, l = {260}, m = "invokeSuspend", n = {}, s = {})
    static final class C08772<D> extends SuspendLambda implements Function2<ApolloResponse<D>, Continuation<? super Unit>, Object> {
        final /* synthetic */ CustomScalarAdapters $customScalarAdapters;
        final /* synthetic */ ApolloRequest<D> $request;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08772(ApolloRequest<D> apolloRequest, CustomScalarAdapters customScalarAdapters, Continuation<? super C08772> continuation) {
            super(2, continuation);
            this.$request = apolloRequest;
            this.$customScalarAdapters = customScalarAdapters;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C08772 c08772 = ApolloCacheInterceptor.this.new C08772(this.$request, this.$customScalarAdapters, continuation);
            c08772.L$0 = obj;
            return c08772;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ApolloResponse<D> apolloResponse, Continuation<? super Unit> continuation) {
            return ((C08772) create(apolloResponse, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ApolloResponse apolloResponse = (ApolloResponse) this.L$0;
                this.label = 1;
                if (ApolloCacheInterceptor.maybeWriteToCache$default(ApolloCacheInterceptor.this, this.$request, apolloResponse, this.$customScalarAdapters, null, this, 8, null) == coroutine_suspended) {
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
    public final <D extends Operation.Data> Object readFromNetwork(ApolloRequest<D> apolloRequest, ApolloInterceptorChain apolloInterceptorChain, CustomScalarAdapters customScalarAdapters, Continuation<? super Flow<ApolloResponse<D>>> continuation) {
        final long jCurrentTimeMillis = UtilsKt.currentTimeMillis();
        final Flow flowOnEach = FlowKt.onEach(apolloInterceptorChain.proceed(apolloRequest), new C08772(apolloRequest, customScalarAdapters, null));
        return new Flow<ApolloResponse<D>>() { // from class: com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor$readFromNetwork$$inlined$map$1

            /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor$readFromNetwork$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 5, 1}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ long $startMillis$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor$readFromNetwork$$inlined$map$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
                @DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.internal.ApolloCacheInterceptor$readFromNetwork$$inlined$map$1$2", f = "ApolloCacheInterceptor.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
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

                public AnonymousClass2(FlowCollector flowCollector, long j) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$startMillis$inlined = j;
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
                        ApolloResponse apolloResponseBuild = NormalizedCache.cacheInfo(((ApolloResponse) obj).newBuilder(), new CacheInfo.Builder().networkStartMillis(this.$startMillis$inlined).networkEndMillis(UtilsKt.currentTimeMillis()).build()).build();
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(apolloResponseBuild, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation2) {
                Object objCollect = flowOnEach.collect(new AnonymousClass2(flowCollector, jCurrentTimeMillis), continuation2);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    /* JADX INFO: compiled from: ApolloCacheInterceptor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0005"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/internal/ApolloCacheInterceptor$Companion;", "", "()V", "nowDateCacheHeaders", "Lcom/apollographql/apollo3/cache/normalized/api/CacheHeaders;", "apollo-normalized-cache"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final CacheHeaders nowDateCacheHeaders() {
            return new CacheHeaders.Builder().addHeader(ApolloCacheHeaders.DATE, String.valueOf(UtilsKt.currentTimeMillis() / ((long) 1000))).build();
        }
    }
}
