package com.apollographql.apollo3.cache.normalized;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.ts.PsExtractor;
import com.apollographql.apollo3.api.ApolloRequest;
import com.apollographql.apollo3.api.ApolloResponse;
import com.apollographql.apollo3.exception.ApolloCompositeException;
import com.apollographql.apollo3.exception.CacheMissException;
import com.apollographql.apollo3.interceptor.ApolloInterceptorChain;
import com.box.android.common.utilities.BoxCommonConstants;
import com.pspdfkit.ui.toolbar.ContextualToolbar;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Add missing generic type declarations: [D] */
/* JADX INFO: compiled from: FetchPolicyInterceptors.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u008a@"}, d2 = {"<anonymous>", "", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/apollographql/apollo3/api/ApolloResponse;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1", f = "FetchPolicyInterceptors.kt", i = {0, 0, 0, 1, 1, 1, 2, 2}, l = {ContextualToolbar.DRAG_BUTTON_ALPHA, PsExtractor.PRIVATE_STREAM_1, BoxCommonConstants.REQUEST_DELETE}, m = "invokeSuspend", n = {"$this$flow", "cacheException", "networkException", "$this$flow", "cacheException", "networkException", "cacheException", "networkException"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1"})
final class FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1<D> extends SuspendLambda implements Function2<FlowCollector<? super ApolloResponse<D>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ApolloInterceptorChain $chain;
    final /* synthetic */ ApolloRequest<D> $request;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1(ApolloInterceptorChain apolloInterceptorChain, ApolloRequest<D> apolloRequest, Continuation<? super FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1> continuation) {
        super(2, continuation);
        this.$chain = apolloInterceptorChain;
        this.$request = apolloRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1 fetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1 = new FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1(this.$chain, this.$request, continuation);
        fetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1.L$0 = obj;
        return fetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super ApolloResponse<D>> flowCollector, Continuation<? super Unit> continuation) {
        return ((FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:30:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:32:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:34:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:36:0x0103  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        FlowCollector flowCollector;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        final Ref.ObjectRef objectRef3;
        FlowCollector flowCollector2;
        final Flow flowM16356catch;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector3 = (FlowCollector) this.L$0;
            Ref.ObjectRef objectRef6 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef7 = new Ref.ObjectRef();
            this.L$0 = flowCollector3;
            this.L$1 = objectRef6;
            this.L$2 = objectRef7;
            this.label = 1;
            Object objSingleOrNull = FlowKt.singleOrNull(FlowKt.m16356catch(this.$chain.proceed(NormalizedCache.fetchFromCache(this.$request.newBuilder(), true).build()), new FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1$cacheResponse$1(objectRef6, null)), this);
            if (objSingleOrNull != coroutine_suspended) {
                flowCollector = flowCollector3;
                obj = objSingleOrNull;
                objectRef = objectRef6;
                objectRef2 = objectRef7;
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            objectRef2 = (Ref.ObjectRef) this.L$2;
            objectRef = (Ref.ObjectRef) this.L$1;
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i == 2) {
                objectRef2 = (Ref.ObjectRef) this.L$2;
                objectRef3 = (Ref.ObjectRef) this.L$1;
                flowCollector2 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                flowCollector = flowCollector2;
                flowM16356catch = FlowKt.m16356catch(this.$chain.proceed(this.$request), new FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1$networkResponses$1(objectRef2, null));
                this.L$0 = objectRef3;
                this.L$1 = objectRef2;
                this.L$2 = null;
                this.label = 3;
                if (FlowKt.emitAll(flowCollector, new Flow<ApolloResponse<D>>() { // from class: com.apollographql.apollo3.cache.normalized.FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1$invokeSuspend$$inlined$map$1

                    /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 5, 1}, xi = 48)
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ Ref.ObjectRef $cacheException$inlined;
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        /* JADX INFO: compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
                        @DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1$invokeSuspend$$inlined$map$1$2", f = "FetchPolicyInterceptors.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
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

                        public AnonymousClass2(FlowCollector flowCollector, Ref.ObjectRef objectRef) {
                            this.$this_unsafeFlow = flowCollector;
                            this.$cacheException$inlined = objectRef;
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
                                ApolloResponse apolloResponse = (ApolloResponse) obj;
                                ApolloResponse.Builder builderNewBuilder = apolloResponse.newBuilder();
                                CacheInfo cacheInfo = NormalizedCache.getCacheInfo(apolloResponse);
                                Intrinsics.checkNotNull(cacheInfo);
                                CacheInfo.Builder builderNewBuilder2 = cacheInfo.newBuilder();
                                T t = this.$cacheException$inlined.element;
                                ApolloResponse apolloResponseBuild = NormalizedCache.cacheInfo(builderNewBuilder, builderNewBuilder2.cacheMissException(t instanceof CacheMissException ? (CacheMissException) t : null).build()).build();
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
                    public Object collect(FlowCollector flowCollector4, Continuation continuation) {
                        Object objCollect = flowM16356catch.collect(new AnonymousClass2(flowCollector4, objectRef3), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                }, this) != coroutine_suspended) {
                    objectRef4 = objectRef2;
                    objectRef5 = objectRef3;
                }
                return coroutine_suspended;
            }
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef4 = (Ref.ObjectRef) this.L$1;
            objectRef5 = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (objectRef4.element != 0) {
            if (objectRef5.element != 0) {
                throw new ApolloCompositeException((Throwable) objectRef5.element, (Throwable) objectRef4.element);
            }
            T t = objectRef4.element;
            Intrinsics.checkNotNull(t);
            throw ((Throwable) t);
        }
        return Unit.INSTANCE;
        ApolloResponse apolloResponse = (ApolloResponse) obj;
        if (apolloResponse != null) {
            this.L$0 = flowCollector;
            this.L$1 = objectRef;
            this.L$2 = objectRef2;
            this.label = 2;
            if (flowCollector.emit(apolloResponse.newBuilder().isLast(false).build(), this) != coroutine_suspended) {
                objectRef3 = objectRef;
                flowCollector2 = flowCollector;
                flowCollector = flowCollector2;
                flowM16356catch = FlowKt.m16356catch(this.$chain.proceed(this.$request), new FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1$networkResponses$1(objectRef2, null));
                this.L$0 = objectRef3;
                this.L$1 = objectRef2;
                this.L$2 = null;
                this.label = 3;
                if (FlowKt.emitAll(flowCollector, new Flow<ApolloResponse<D>>() { // from class: com.apollographql.apollo3.cache.normalized.FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1$invokeSuspend$$inlined$map$1

                    /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 5, 1}, xi = 48)
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ Ref.ObjectRef $cacheException$inlined;
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        /* JADX INFO: compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
                        @DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1$invokeSuspend$$inlined$map$1$2", f = "FetchPolicyInterceptors.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
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

                        public AnonymousClass2(FlowCollector flowCollector, Ref.ObjectRef objectRef) {
                            this.$this_unsafeFlow = flowCollector;
                            this.$cacheException$inlined = objectRef;
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
                                ApolloResponse apolloResponse = (ApolloResponse) obj;
                                ApolloResponse.Builder builderNewBuilder = apolloResponse.newBuilder();
                                CacheInfo cacheInfo = NormalizedCache.getCacheInfo(apolloResponse);
                                Intrinsics.checkNotNull(cacheInfo);
                                CacheInfo.Builder builderNewBuilder2 = cacheInfo.newBuilder();
                                T t = this.$cacheException$inlined.element;
                                ApolloResponse apolloResponseBuild = NormalizedCache.cacheInfo(builderNewBuilder, builderNewBuilder2.cacheMissException(t instanceof CacheMissException ? (CacheMissException) t : null).build()).build();
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
                    public Object collect(FlowCollector flowCollector4, Continuation continuation) {
                        Object objCollect = flowM16356catch.collect(new AnonymousClass2(flowCollector4, objectRef3), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                }, this) != coroutine_suspended) {
                    objectRef4 = objectRef2;
                    objectRef5 = objectRef3;
                    if (objectRef4.element != 0) {
                        if (objectRef5.element != 0) {
                            throw new ApolloCompositeException((Throwable) objectRef5.element, (Throwable) objectRef4.element);
                        }
                        T t2 = objectRef4.element;
                        Intrinsics.checkNotNull(t2);
                        throw ((Throwable) t2);
                    }
                    return Unit.INSTANCE;
                }
            }
        } else {
            objectRef3 = objectRef;
            flowM16356catch = FlowKt.m16356catch(this.$chain.proceed(this.$request), new FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1$networkResponses$1(objectRef2, null));
            this.L$0 = objectRef3;
            this.L$1 = objectRef2;
            this.L$2 = null;
            this.label = 3;
            if (FlowKt.emitAll(flowCollector, new Flow<ApolloResponse<D>>() { // from class: com.apollographql.apollo3.cache.normalized.FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1$invokeSuspend$$inlined$map$1

                /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 5, 1}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ Ref.ObjectRef $cacheException$inlined;
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.apollographql.apollo3.cache.normalized.FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
                    @DebugMetadata(c = "com.apollographql.apollo3.cache.normalized.FetchPolicyInterceptors$CacheAndNetworkInterceptor$1$intercept$1$invokeSuspend$$inlined$map$1$2", f = "FetchPolicyInterceptors.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
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

                    public AnonymousClass2(FlowCollector flowCollector, Ref.ObjectRef objectRef) {
                        this.$this_unsafeFlow = flowCollector;
                        this.$cacheException$inlined = objectRef;
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
                            ApolloResponse apolloResponse = (ApolloResponse) obj;
                            ApolloResponse.Builder builderNewBuilder = apolloResponse.newBuilder();
                            CacheInfo cacheInfo = NormalizedCache.getCacheInfo(apolloResponse);
                            Intrinsics.checkNotNull(cacheInfo);
                            CacheInfo.Builder builderNewBuilder2 = cacheInfo.newBuilder();
                            T t = this.$cacheException$inlined.element;
                            ApolloResponse apolloResponseBuild = NormalizedCache.cacheInfo(builderNewBuilder, builderNewBuilder2.cacheMissException(t instanceof CacheMissException ? (CacheMissException) t : null).build()).build();
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
                public Object collect(FlowCollector flowCollector4, Continuation continuation) {
                    Object objCollect = flowM16356catch.collect(new AnonymousClass2(flowCollector4, objectRef3), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            }, this) != coroutine_suspended) {
                objectRef4 = objectRef2;
                objectRef5 = objectRef3;
                if (objectRef4.element != 0) {
                    if (objectRef5.element != 0) {
                        throw new ApolloCompositeException((Throwable) objectRef5.element, (Throwable) objectRef4.element);
                    }
                    T t3 = objectRef4.element;
                    Intrinsics.checkNotNull(t3);
                    throw ((Throwable) t3);
                }
                return Unit.INSTANCE;
            }
        }
        return coroutine_suspended;
    }
}
