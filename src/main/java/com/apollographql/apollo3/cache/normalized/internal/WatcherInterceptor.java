package com.apollographql.apollo3.cache.normalized.internal;

import androidx.exifinterface.media.ExifInterface;
import com.apollographql.apollo3.api.ApolloRequest;
import com.apollographql.apollo3.api.ApolloResponse;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.ExecutionContext;
import com.apollographql.apollo3.api.Operation;
import com.apollographql.apollo3.api.Query;
import com.apollographql.apollo3.cache.normalized.ApolloStore;
import com.apollographql.apollo3.cache.normalized.NormalizedCache;
import com.apollographql.apollo3.cache.normalized.WatchContext;
import com.apollographql.apollo3.cache.normalized.api.OperationCacheExtensionsKt;
import com.apollographql.apollo3.exception.ApolloException;
import com.apollographql.apollo3.interceptor.ApolloInterceptor;
import com.apollographql.apollo3.interceptor.ApolloInterceptorChain;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: compiled from: WatcherInterceptor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J4\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\t0\b\"\b\b\u0000\u0010\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/apollographql/apollo3/cache/normalized/internal/WatcherInterceptor;", "Lcom/apollographql/apollo3/interceptor/ApolloInterceptor;", "store", "Lcom/apollographql/apollo3/cache/normalized/ApolloStore;", "(Lcom/apollographql/apollo3/cache/normalized/ApolloStore;)V", "getStore", "()Lcom/apollographql/apollo3/cache/normalized/ApolloStore;", "intercept", "Lkotlinx/coroutines/flow/Flow;", "Lcom/apollographql/apollo3/api/ApolloResponse;", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "request", "Lcom/apollographql/apollo3/api/ApolloRequest;", "chain", "Lcom/apollographql/apollo3/interceptor/ApolloInterceptorChain;", "apollo-normalized-cache"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class WatcherInterceptor implements ApolloInterceptor {
    private final ApolloStore store;

    public WatcherInterceptor(ApolloStore store) {
        Intrinsics.checkNotNullParameter(store, "store");
        this.store = store;
    }

    public final ApolloStore getStore() {
        return this.store;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.apollographql.apollo3.interceptor.ApolloInterceptor
    public <D extends Operation.Data> Flow<ApolloResponse<D>> intercept(final ApolloRequest<D> request, final ApolloInterceptorChain chain) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(chain, "chain");
        WatchContext watchContext = NormalizedCache.getWatchContext(request);
        if (watchContext == null) {
            return chain.proceed(request);
        }
        if (!(request.getOperation() instanceof Query)) {
            throw new IllegalStateException("It's impossible to watch a mutation or subscription".toString());
        }
        ExecutionContext.Element element = request.getExecutionContext().get(CustomScalarAdapters.INSTANCE);
        Intrinsics.checkNotNull(element);
        final CustomScalarAdapters customScalarAdapters = (CustomScalarAdapters) element;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Query.Data data = watchContext.getData();
        objectRef.element = data != null ? OperationCacheExtensionsKt.dependentKeys(this.store.normalize(request.getOperation(), data, customScalarAdapters).values()) : 0;
        final SharedFlow<Set<String>> changedKeys = this.store.getChangedKeys();
        final Flow<Set<? extends String>> flow = new Flow<Set<? extends String>>() { // from class: com.apollographql.apollo3.cache.normalized.internal.WatcherInterceptor$intercept$$inlined$filter$1

            /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.internal.WatcherInterceptor$intercept$$inlined$filter$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 5, 1}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ Ref.ObjectRef $watchedKeys$inlined;

                /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.internal.WatcherInterceptor$intercept$$inlined$filter$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
                @DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.internal.WatcherInterceptor$intercept$$inlined$filter$1$2", f = "WatcherInterceptor.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
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

                public AnonymousClass2(FlowCollector flowCollector, Ref.ObjectRef objectRef) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$watchedKeys$inlined = objectRef;
                }

                /* JADX WARN: Code duplicated, block: B:18:0x005a  */
                /* JADX WARN: Code duplicated, block: B:20:0x0062 A[RETURN] */
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
                        Set set = (Set) obj;
                        if (this.$watchedKeys$inlined.element != null) {
                            T t = this.$watchedKeys$inlined.element;
                            Intrinsics.checkNotNull(t);
                            if (!CollectionsKt.intersect(set, (Iterable) t).isEmpty()) {
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        } else {
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
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
            public Object collect(FlowCollector<? super Set<? extends String>> flowCollector, Continuation continuation) {
                Object objCollect = changedKeys.collect(new AnonymousClass2(flowCollector, objectRef), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
        return FlowKt.retryWhen(WatcherInterceptorKt.flattenConcatPolyfill(new Flow<Flow<? extends ApolloResponse<D>>>() { // from class: com.apollographql.apollo3.cache.normalized.internal.WatcherInterceptor$intercept$$inlined$map$1

            /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.internal.WatcherInterceptor$intercept$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 5, 1}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ ApolloInterceptorChain $chain$inlined;
                final /* synthetic */ CustomScalarAdapters $customScalarAdapters$inlined;
                final /* synthetic */ ApolloRequest $request$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ Ref.ObjectRef $watchedKeys$inlined;
                final /* synthetic */ WatcherInterceptor this$0;

                /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.internal.WatcherInterceptor$intercept$$inlined$map$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
                @DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.internal.WatcherInterceptor$intercept$$inlined$map$1$2", f = "WatcherInterceptor.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
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

                public AnonymousClass2(FlowCollector flowCollector, ApolloInterceptorChain apolloInterceptorChain, ApolloRequest apolloRequest, Ref.ObjectRef objectRef, WatcherInterceptor watcherInterceptor, CustomScalarAdapters customScalarAdapters) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$chain$inlined = apolloInterceptorChain;
                    this.$request$inlined = apolloRequest;
                    this.$watchedKeys$inlined = objectRef;
                    this.this$0 = watcherInterceptor;
                    this.$customScalarAdapters$inlined = customScalarAdapters;
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
                        Flow flowOnEach = FlowKt.onEach(this.$chain$inlined.proceed(this.$request$inlined.newBuilder().build()), new WatcherInterceptor$intercept$3$1(this.$watchedKeys$inlined, this.this$0, this.$request$inlined, this.$customScalarAdapters$inlined, null));
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(flowOnEach, anonymousClass1) == coroutine_suspended) {
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
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = flow.collect(new AnonymousClass2(flowCollector, chain, request, objectRef, this, customScalarAdapters), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }), new AnonymousClass4(watchContext, null));
    }

    /* JADX INFO: Add missing generic type declarations: [D] */
    /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.internal.WatcherInterceptor$intercept$4, reason: invalid class name */
    /* JADX INFO: compiled from: WatcherInterceptor.kt */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u008a@"}, d2 = {"<anonymous>", "", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/apollographql/apollo3/api/ApolloResponse;", "cause", "", "attempt", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.internal.WatcherInterceptor$intercept$4", f = "WatcherInterceptor.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4<D> extends SuspendLambda implements Function4<FlowCollector<? super ApolloResponse<D>>, Throwable, Long, Continuation<? super Boolean>, Object> {
        final /* synthetic */ WatchContext $watchContext;
        /* synthetic */ long J$0;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(WatchContext watchContext, Continuation<? super AnonymousClass4> continuation) {
            super(4, continuation);
            this.$watchContext = watchContext;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Throwable th, Long l, Continuation<? super Boolean> continuation) {
            return invoke((FlowCollector) obj, th, l.longValue(), continuation);
        }

        public final Object invoke(FlowCollector<? super ApolloResponse<D>> flowCollector, Throwable th, long j, Continuation<? super Boolean> continuation) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$watchContext, continuation);
            anonymousClass4.L$0 = th;
            anonymousClass4.J$0 = j;
            return anonymousClass4.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0040  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Throwable th = (Throwable) this.L$0;
                long j = this.J$0;
                if (th instanceof ApolloException) {
                    Function3<Throwable, Long, Continuation<? super Boolean>, Object> retryWhen = this.$watchContext.getRetryWhen();
                    Long lBoxLong = Boxing.boxLong(j);
                    this.label = 1;
                    obj = retryWhen.invoke(th, lBoxLong, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Boxing.boxBoolean(z);
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            boolean z = ((Boolean) obj).booleanValue();
            return Boxing.boxBoolean(z);
        }
    }
}
