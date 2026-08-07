package com.apollographql.apollo3.interceptor;

import androidx.exifinterface.media.ExifInterface;
import com.apollographql.apollo3.AutoPersistedQueryInfo;
import com.apollographql.apollo3.api.ApolloRequest;
import com.apollographql.apollo3.api.ApolloResponse;
import com.apollographql.apollo3.api.Error;
import com.apollographql.apollo3.api.Mutation;
import com.apollographql.apollo3.api.Operation;
import com.apollographql.apollo3.api.http.HttpMethod;
import com.apollographql.apollo3.exception.AutoPersistedQueriesNotSupported;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: AutoPersistedQueryInterceptor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J4\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\b0\u0007\"\b\b\u0000\u0010\t*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0002J\u0018\u0010\u0014\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0002J*\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\b\b\u0000\u0010\t*\u00020\n*\b\u0012\u0004\u0012\u0002H\t0\b2\u0006\u0010\u0016\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/apollographql/apollo3/interceptor/AutoPersistedQueryInterceptor;", "Lcom/apollographql/apollo3/interceptor/ApolloInterceptor;", "httpMethodForHashedQueries", "Lcom/apollographql/apollo3/api/http/HttpMethod;", "httpMethodForDocumentQueries", "(Lcom/apollographql/apollo3/api/http/HttpMethod;Lcom/apollographql/apollo3/api/http/HttpMethod;)V", "intercept", "Lkotlinx/coroutines/flow/Flow;", "Lcom/apollographql/apollo3/api/ApolloResponse;", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "request", "Lcom/apollographql/apollo3/api/ApolloRequest;", "chain", "Lcom/apollographql/apollo3/interceptor/ApolloInterceptorChain;", "isPersistedQueryNotFound", "", BoxAnalyticsParams.CATEGORY_ERRORS, "", "Lcom/apollographql/apollo3/api/Error;", "isPersistedQueryNotSupported", "withAutoPersistedQueryInfo", "hit", "Companion", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AutoPersistedQueryInterceptor implements ApolloInterceptor {
    private static final String PROTOCOL_NEGOTIATION_ERROR_NOT_SUPPORTED = "PersistedQueryNotSupported";
    private static final String PROTOCOL_NEGOTIATION_ERROR_QUERY_NOT_FOUND = "PersistedQueryNotFound";
    private final HttpMethod httpMethodForDocumentQueries;
    private final HttpMethod httpMethodForHashedQueries;

    public AutoPersistedQueryInterceptor(HttpMethod httpMethodForHashedQueries, HttpMethod httpMethodForDocumentQueries) {
        Intrinsics.checkNotNullParameter(httpMethodForHashedQueries, "httpMethodForHashedQueries");
        Intrinsics.checkNotNullParameter(httpMethodForDocumentQueries, "httpMethodForDocumentQueries");
        this.httpMethodForHashedQueries = httpMethodForHashedQueries;
        this.httpMethodForDocumentQueries = httpMethodForDocumentQueries;
    }

    @Override // com.apollographql.apollo3.interceptor.ApolloInterceptor
    public <D extends Operation.Data> Flow<ApolloResponse<D>> intercept(ApolloRequest<D> request, ApolloInterceptorChain chain) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(chain, "chain");
        Boolean enableAutoPersistedQueries = request.getEnableAutoPersistedQueries();
        if (!(enableAutoPersistedQueries != null ? enableAutoPersistedQueries.booleanValue() : true)) {
            return chain.proceed(request);
        }
        boolean z = request.getOperation() instanceof Mutation;
        return FlowKt.flow(new AnonymousClass1(chain, request.newBuilder().httpMethod(z ? HttpMethod.Post : this.httpMethodForHashedQueries).sendDocument((Boolean) false).sendApqExtensions((Boolean) true).build(), this, z, null));
    }

    /* JADX INFO: Add missing generic type declarations: [D] */
    /* JADX INFO: renamed from: com.apollographql.apollo3.interceptor.AutoPersistedQueryInterceptor$intercept$1, reason: invalid class name */
    /* JADX INFO: compiled from: AutoPersistedQueryInterceptor.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u008a@"}, d2 = {"<anonymous>", "", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/apollographql/apollo3/api/ApolloResponse;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.interceptor.AutoPersistedQueryInterceptor$intercept$1", f = "AutoPersistedQueryInterceptor.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1<D> extends SuspendLambda implements Function2<FlowCollector<? super ApolloResponse<D>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ApolloInterceptorChain $chain;
        final /* synthetic */ boolean $isMutation;
        final /* synthetic */ ApolloRequest<D> $request;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AutoPersistedQueryInterceptor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ApolloInterceptorChain apolloInterceptorChain, ApolloRequest<D> apolloRequest, AutoPersistedQueryInterceptor autoPersistedQueryInterceptor, boolean z, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$chain = apolloInterceptorChain;
            this.$request = apolloRequest;
            this.this$0 = autoPersistedQueryInterceptor;
            this.$isMutation = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$chain, this.$request, this.this$0, this.$isMutation, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super ApolloResponse<D>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final FlowCollector flowCollector = (FlowCollector) this.L$0;
                Flow flowProceed = this.$chain.proceed(this.$request);
                final AutoPersistedQueryInterceptor autoPersistedQueryInterceptor = this.this$0;
                final ApolloRequest<D> apolloRequest = this.$request;
                final boolean z = this.$isMutation;
                final ApolloInterceptorChain apolloInterceptorChain = this.$chain;
                this.label = 1;
                if (flowProceed.collect(new FlowCollector() { // from class: com.apollographql.apollo3.interceptor.AutoPersistedQueryInterceptor.intercept.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((ApolloResponse) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(ApolloResponse<D> apolloResponse, Continuation<? super Unit> continuation) {
                        if (!autoPersistedQueryInterceptor.isPersistedQueryNotFound(apolloResponse.errors)) {
                            if (!autoPersistedQueryInterceptor.isPersistedQueryNotSupported(apolloResponse.errors)) {
                                Object objEmit = flowCollector.emit(autoPersistedQueryInterceptor.withAutoPersistedQueryInfo(apolloResponse, true), continuation);
                                return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
                            }
                            throw new AutoPersistedQueriesNotSupported();
                        }
                        ApolloRequest apolloRequestBuild = apolloRequest.newBuilder().httpMethod(z ? HttpMethod.Post : autoPersistedQueryInterceptor.httpMethodForDocumentQueries).sendDocument(Boxing.boxBoolean(true)).sendApqExtensions(Boxing.boxBoolean(true)).build();
                        FlowCollector<ApolloResponse<D>> flowCollector2 = flowCollector;
                        final Flow flowProceed2 = apolloInterceptorChain.proceed(apolloRequestBuild);
                        final AutoPersistedQueryInterceptor autoPersistedQueryInterceptor2 = autoPersistedQueryInterceptor;
                        Object objEmitAll = FlowKt.emitAll(flowCollector2, new Flow<ApolloResponse<D>>() { // from class: com.apollographql.apollo3.interceptor.AutoPersistedQueryInterceptor$intercept$1$1$emit$$inlined$map$1

                            /* JADX INFO: renamed from: com.apollographql.apollo3.interceptor.AutoPersistedQueryInterceptor$intercept$1$1$emit$$inlined$map$1$2, reason: invalid class name */
                            /* JADX INFO: compiled from: Emitters.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 5, 1}, xi = 48)
                            public static final class AnonymousClass2<T> implements FlowCollector {
                                final /* synthetic */ FlowCollector $this_unsafeFlow;
                                final /* synthetic */ AutoPersistedQueryInterceptor this$0;

                                /* JADX INFO: renamed from: com.apollographql.apollo3.interceptor.AutoPersistedQueryInterceptor$intercept$1$1$emit$$inlined$map$1$2$1, reason: invalid class name */
                                /* JADX INFO: compiled from: Emitters.kt */
                                @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
                                @DebugMetadata(c = "com.apollographql.apollo3.interceptor.AutoPersistedQueryInterceptor$intercept$1$1$emit$$inlined$map$1$2", f = "AutoPersistedQueryInterceptor.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
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

                                public AnonymousClass2(FlowCollector flowCollector, AutoPersistedQueryInterceptor autoPersistedQueryInterceptor) {
                                    this.$this_unsafeFlow = flowCollector;
                                    this.this$0 = autoPersistedQueryInterceptor;
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
                                        ApolloResponse apolloResponseWithAutoPersistedQueryInfo = this.this$0.withAutoPersistedQueryInfo((ApolloResponse) obj, false);
                                        anonymousClass1.label = 1;
                                        if (flowCollector.emit(apolloResponseWithAutoPersistedQueryInfo, anonymousClass1) == coroutine_suspended) {
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
                            public Object collect(FlowCollector flowCollector3, Continuation continuation2) {
                                Object objCollect = flowProceed2.collect(new AnonymousClass2(flowCollector3, autoPersistedQueryInterceptor2), continuation2);
                                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                            }
                        }, continuation);
                        return objEmitAll == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmitAll : Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
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
    public final <D extends Operation.Data> ApolloResponse<D> withAutoPersistedQueryInfo(ApolloResponse<D> apolloResponse, boolean z) {
        return apolloResponse.newBuilder().addExecutionContext(new AutoPersistedQueryInfo(z)).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isPersistedQueryNotFound(List<Error> errors) {
        if (errors != null) {
            List<Error> list = errors;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (StringsKt.equals(((Error) it.next()).getMessage(), PROTOCOL_NEGOTIATION_ERROR_QUERY_NOT_FOUND, true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isPersistedQueryNotSupported(List<Error> errors) {
        if (errors != null) {
            List<Error> list = errors;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (StringsKt.equals(((Error) it.next()).getMessage(), PROTOCOL_NEGOTIATION_ERROR_NOT_SUPPORTED, true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
