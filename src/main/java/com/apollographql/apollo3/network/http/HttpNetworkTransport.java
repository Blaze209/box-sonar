package com.apollographql.apollo3.network.http;

import androidx.exifinterface.media.ExifInterface;
import com.apollographql.apollo3.api.AdapterContext;
import com.apollographql.apollo3.api.ApolloRequest;
import com.apollographql.apollo3.api.ApolloResponse;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.DeferredFragmentIdentifier;
import com.apollographql.apollo3.api.ExecutionContext;
import com.apollographql.apollo3.api.Operation;
import com.apollographql.apollo3.api.Operations;
import com.apollographql.apollo3.api.Subscription;
import com.apollographql.apollo3.api.http.DefaultHttpRequestComposer;
import com.apollographql.apollo3.api.http.HttpHeader;
import com.apollographql.apollo3.api.http.HttpRequest;
import com.apollographql.apollo3.api.http.HttpRequestComposer;
import com.apollographql.apollo3.api.http.HttpResponse;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.api.json.JsonReaders;
import com.apollographql.apollo3.exception.ApolloException;
import com.apollographql.apollo3.exception.ApolloParseException;
import com.apollographql.apollo3.exception.SubscriptionOperationException;
import com.apollographql.apollo3.internal.DeferredJsonMerger;
import com.apollographql.apollo3.internal.MultipartKt;
import com.apollographql.apollo3.mpp.UtilsKt;
import com.apollographql.apollo3.network.NetworkTransport;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import okio.BufferedSource;

/* JADX INFO: compiled from: HttpNetworkTransport.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 02\u00020\u0001:\u0003/01B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J,\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00190\u00180\u0017\"\b\b\u0000\u0010\u0019*\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00190\u001cH\u0016J:\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00190\u00180\u0017\"\b\b\u0000\u0010\u0019*\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00190\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J<\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00190\u00180\u0017\"\b\b\u0000\u0010\u0019*\u00020\u001a2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00190#2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010$\u001a\u00020%H\u0002J\u0006\u0010&\u001a\u00020'J6\u0010(\u001a\b\u0012\u0004\u0012\u0002H\u00190\u0018\"\b\b\u0000\u0010\u0019*\u00020\u001a2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00190#2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010$\u001a\u00020%H\u0002J>\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u00190\u0018\"\b\b\u0000\u0010\u0019*\u00020\u001a*\b\u0012\u0004\u0012\u0002H\u00190\u00182\n\u0010*\u001a\u00060+j\u0002`,2\u0006\u0010$\u001a\u00020%2\u0006\u0010-\u001a\u00020.H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00060\u000fR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u00062"}, d2 = {"Lcom/apollographql/apollo3/network/http/HttpNetworkTransport;", "Lcom/apollographql/apollo3/network/NetworkTransport;", "httpRequestComposer", "Lcom/apollographql/apollo3/api/http/HttpRequestComposer;", "engine", "Lcom/apollographql/apollo3/network/http/HttpEngine;", "interceptors", "", "Lcom/apollographql/apollo3/network/http/HttpInterceptor;", "exposeErrorBody", "", "(Lcom/apollographql/apollo3/api/http/HttpRequestComposer;Lcom/apollographql/apollo3/network/http/HttpEngine;Ljava/util/List;Z)V", "getEngine", "()Lcom/apollographql/apollo3/network/http/HttpEngine;", "engineInterceptor", "Lcom/apollographql/apollo3/network/http/HttpNetworkTransport$EngineInterceptor;", "getExposeErrorBody", "()Z", "getInterceptors", "()Ljava/util/List;", "dispose", "", "execute", "Lkotlinx/coroutines/flow/Flow;", "Lcom/apollographql/apollo3/api/ApolloResponse;", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "request", "Lcom/apollographql/apollo3/api/ApolloRequest;", "httpRequest", "Lcom/apollographql/apollo3/api/http/HttpRequest;", "customScalarAdapters", "Lcom/apollographql/apollo3/api/CustomScalarAdapters;", "multipleResponses", SerializedNames.OPERATION, "Lcom/apollographql/apollo3/api/Operation;", "httpResponse", "Lcom/apollographql/apollo3/api/http/HttpResponse;", "newBuilder", "Lcom/apollographql/apollo3/network/http/HttpNetworkTransport$Builder;", "singleResponse", "withHttpInfo", "requestUuid", "Ljava/util/UUID;", "Lcom/benasher44/uuid/Uuid;", "millisStart", "", "Builder", "Companion", "EngineInterceptor", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class HttpNetworkTransport implements NetworkTransport {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final HttpEngine engine;
    private final EngineInterceptor engineInterceptor;
    private final boolean exposeErrorBody;
    private final HttpRequestComposer httpRequestComposer;
    private final List<HttpInterceptor> interceptors;

    /* JADX INFO: compiled from: HttpNetworkTransport.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Companion.Kind.values().length];
            try {
                iArr[Companion.Kind.EMPTY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Companion.Kind.PAYLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Companion.Kind.OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ HttpNetworkTransport(HttpRequestComposer httpRequestComposer, HttpEngine httpEngine, List list, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(httpRequestComposer, httpEngine, list, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private HttpNetworkTransport(HttpRequestComposer httpRequestComposer, HttpEngine httpEngine, List<? extends HttpInterceptor> list, boolean z) {
        this.httpRequestComposer = httpRequestComposer;
        this.engine = httpEngine;
        this.interceptors = list;
        this.exposeErrorBody = z;
        this.engineInterceptor = new EngineInterceptor();
    }

    public final HttpEngine getEngine() {
        return this.engine;
    }

    public final List<HttpInterceptor> getInterceptors() {
        return this.interceptors;
    }

    public final boolean getExposeErrorBody() {
        return this.exposeErrorBody;
    }

    @Override // com.apollographql.apollo3.network.NetworkTransport
    public <D extends Operation.Data> Flow<ApolloResponse<D>> execute(ApolloRequest<D> request) {
        Intrinsics.checkNotNullParameter(request, "request");
        ExecutionContext.Element element = request.getExecutionContext().get(CustomScalarAdapters.INSTANCE);
        Intrinsics.checkNotNull(element);
        return execute(request, this.httpRequestComposer.compose(request), (CustomScalarAdapters) element);
    }

    /* JADX INFO: Add missing generic type declarations: [D] */
    /* JADX INFO: renamed from: com.apollographql.apollo3.network.http.HttpNetworkTransport$execute$1, reason: invalid class name */
    /* JADX INFO: compiled from: HttpNetworkTransport.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u008a@"}, d2 = {"<anonymous>", "", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/apollographql/apollo3/api/ApolloResponse;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.network.http.HttpNetworkTransport$execute$1", f = "HttpNetworkTransport.kt", i = {0, 0}, l = {66, 86, 91}, m = "invokeSuspend", n = {"$this$flow", "millisStart"}, s = {"L$0", "J$0"})
    static final class AnonymousClass1<D> extends SuspendLambda implements Function2<FlowCollector<? super ApolloResponse<D>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ CustomScalarAdapters $customScalarAdapters;
        final /* synthetic */ HttpRequest $httpRequest;
        final /* synthetic */ ApolloRequest<D> $request;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(HttpRequest httpRequest, ApolloRequest<D> apolloRequest, CustomScalarAdapters customScalarAdapters, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$httpRequest = httpRequest;
            this.$request = apolloRequest;
            this.$customScalarAdapters = customScalarAdapters;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = HttpNetworkTransport.this.new AnonymousClass1(this.$httpRequest, this.$request, this.$customScalarAdapters, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super ApolloResponse<D>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x009e, code lost:
        
            if (kotlinx.coroutines.flow.FlowKt.emitAll(r1, new com.apollographql.apollo3.network.http.HttpNetworkTransport$execute$1$invokeSuspend$$inlined$map$1<>(r5, r6, r7, r7, r9), r12) == r0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x00c5, code lost:
        
            if (r1.emit(r4.withHttpInfo(r4.singleResponse(r12.$request.getOperation(), r12.$customScalarAdapters, r7), r12.$request.getRequestUuid(), r7, r8), r12) == r0) goto L27;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 270
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apollographql.apollo3.network.http.HttpNetworkTransport.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final <D extends Operation.Data> Flow<ApolloResponse<D>> execute(ApolloRequest<D> request, HttpRequest httpRequest, CustomScalarAdapters customScalarAdapters) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(httpRequest, "httpRequest");
        Intrinsics.checkNotNullParameter(customScalarAdapters, "customScalarAdapters");
        return FlowKt.flow(new AnonymousClass1(httpRequest, request, customScalarAdapters, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <D extends Operation.Data> ApolloResponse<D> singleResponse(Operation<D> operation, CustomScalarAdapters customScalarAdapters, HttpResponse httpResponse) {
        try {
            BufferedSource body = httpResponse.getBody();
            Intrinsics.checkNotNull(body);
            return Operations.parseJsonResponse(operation, JsonReaders.jsonReader(body), customScalarAdapters).newBuilder().isLast(true).build();
        } catch (Exception e) {
            throw INSTANCE.wrapThrowableIfNeeded(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <D extends Operation.Data> Flow<ApolloResponse<D>> multipleResponses(final Operation<D> operation, final CustomScalarAdapters customScalarAdapters, HttpResponse httpResponse) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Flow<BufferedSource> flowMultipartBodyFlow = MultipartKt.multipartBodyFlow(httpResponse);
        return FlowKt.m16356catch(new Flow<ApolloResponse<D>>() { // from class: com.apollographql.apollo3.network.http.HttpNetworkTransport$multipleResponses$$inlined$mapNotNull$1

            /* JADX INFO: renamed from: com.apollographql.apollo3.network.http.HttpNetworkTransport$multipleResponses$$inlined$mapNotNull$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 5, 1}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ CustomScalarAdapters $customScalarAdapters$inlined;
                final /* synthetic */ Ref.ObjectRef $jsonMerger$inlined;
                final /* synthetic */ Operation $operation$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.apollographql.apollo3.network.http.HttpNetworkTransport$multipleResponses$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
                @DebugMetadata(c = "com.apollographql.apollo3.network.http.HttpNetworkTransport$multipleResponses$$inlined$mapNotNull$1$2", f = "HttpNetworkTransport.kt", i = {}, l = {306}, m = "emit", n = {}, s = {})
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

                public AnonymousClass2(FlowCollector flowCollector, Operation operation, CustomScalarAdapters customScalarAdapters, Ref.ObjectRef objectRef) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$operation$inlined = operation;
                    this.$customScalarAdapters$inlined = customScalarAdapters;
                    this.$jsonMerger$inlined = objectRef;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) throws Throwable {
                    AnonymousClass1 anonymousClass1;
                    Throwable th;
                    HttpNetworkTransport.Companion.Kind kind;
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
                        BufferedSource bufferedSource = (BufferedSource) obj;
                        ApolloResponse apolloResponseBuild = null;
                        if (this.$operation$inlined instanceof Subscription) {
                            JsonReader jsonReader = JsonReaders.jsonReader(bufferedSource.peek());
                            try {
                                JsonReader jsonReader2 = jsonReader;
                                jsonReader2.beginObject();
                                if (jsonReader2.hasNext()) {
                                    kind = (!Intrinsics.areEqual(jsonReader2.nextName(), "payload") || jsonReader2.getPeekedToken() == JsonReader.Token.NULL) ? HttpNetworkTransport.Companion.Kind.OTHER : HttpNetworkTransport.Companion.Kind.PAYLOAD;
                                } else {
                                    kind = HttpNetworkTransport.Companion.Kind.EMPTY;
                                }
                                if (jsonReader != null) {
                                    try {
                                        jsonReader.close();
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                }
                                th = null;
                            } catch (Throwable th3) {
                                if (jsonReader != null) {
                                    try {
                                        jsonReader.close();
                                    } catch (Throwable th4) {
                                        ExceptionsKt.addSuppressed(th3, th4);
                                    }
                                }
                                th = th3;
                                kind = null;
                            }
                            if (th != null) {
                                throw th;
                            }
                            int i2 = HttpNetworkTransport.WhenMappings.$EnumSwitchMapping$0[kind.ordinal()];
                            if (i2 != 1) {
                                if (i2 != 2) {
                                    if (i2 != 3) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    throw new SubscriptionOperationException(this.$operation$inlined.name(), JsonReaders.readAny(JsonReaders.jsonReader(bufferedSource)));
                                }
                                JsonReader jsonReader3 = JsonReaders.jsonReader(bufferedSource);
                                jsonReader3.beginObject();
                                jsonReader3.nextName();
                                apolloResponseBuild = Operations.parseJsonResponseInternal(this.$operation$inlined, jsonReader3, this.$customScalarAdapters$inlined, false);
                            }
                        } else {
                            if (this.$jsonMerger$inlined.element == null) {
                                this.$jsonMerger$inlined.element = (T) new DeferredJsonMerger();
                            }
                            T t = this.$jsonMerger$inlined.element;
                            Intrinsics.checkNotNull(t);
                            Map<String, Object> mapMerge = ((DeferredJsonMerger) t).merge(bufferedSource);
                            T t2 = this.$jsonMerger$inlined.element;
                            Intrinsics.checkNotNull(t2);
                            Set<DeferredFragmentIdentifier> mergedFragmentIds = ((DeferredJsonMerger) t2).getMergedFragmentIds();
                            T t3 = this.$jsonMerger$inlined.element;
                            Intrinsics.checkNotNull(t3);
                            boolean z = !((DeferredJsonMerger) t3).getHasNext();
                            T t4 = this.$jsonMerger$inlined.element;
                            Intrinsics.checkNotNull(t4);
                            if (!((DeferredJsonMerger) t4).getIsEmptyPayload()) {
                                apolloResponseBuild = Operations.parseJsonResponse(this.$operation$inlined, JsonReaders.jsonReader((Map<String, ? extends Object>) mapMerge), AdapterContext.withDeferredFragmentIds(this.$customScalarAdapters$inlined, mergedFragmentIds)).newBuilder().isLast(z).build();
                            }
                        }
                        if (apolloResponseBuild != null) {
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(apolloResponseBuild, anonymousClass1) == coroutine_suspended) {
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
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = flowMultipartBodyFlow.collect(new AnonymousClass2(flowCollector, operation, customScalarAdapters, objectRef), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, new AnonymousClass2(null));
    }

    /* JADX INFO: Add missing generic type declarations: [D] */
    /* JADX INFO: renamed from: com.apollographql.apollo3.network.http.HttpNetworkTransport$multipleResponses$2, reason: invalid class name */
    /* JADX INFO: compiled from: HttpNetworkTransport.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u008a@"}, d2 = {"<anonymous>", "", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/apollographql/apollo3/api/ApolloResponse;", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.network.http.HttpNetworkTransport$multipleResponses$2", f = "HttpNetworkTransport.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2<D> extends SuspendLambda implements Function3<FlowCollector<? super ApolloResponse<D>>, Throwable, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super ApolloResponse<D>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = th;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            throw HttpNetworkTransport.INSTANCE.wrapThrowableIfNeeded((Throwable) this.L$0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <D extends Operation.Data> ApolloResponse<D> withHttpInfo(ApolloResponse<D> apolloResponse, UUID uuid, HttpResponse httpResponse, long j) {
        return apolloResponse.newBuilder().requestUuid(uuid).addExecutionContext(new HttpInfo(j, UtilsKt.currentTimeMillis(), httpResponse.getStatusCode(), httpResponse.getHeaders())).build();
    }

    /* JADX INFO: compiled from: HttpNetworkTransport.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/apollographql/apollo3/network/http/HttpNetworkTransport$EngineInterceptor;", "Lcom/apollographql/apollo3/network/http/HttpInterceptor;", "(Lcom/apollographql/apollo3/network/http/HttpNetworkTransport;)V", "intercept", "Lcom/apollographql/apollo3/api/http/HttpResponse;", "request", "Lcom/apollographql/apollo3/api/http/HttpRequest;", "chain", "Lcom/apollographql/apollo3/network/http/HttpInterceptorChain;", "(Lcom/apollographql/apollo3/api/http/HttpRequest;Lcom/apollographql/apollo3/network/http/HttpInterceptorChain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class EngineInterceptor implements HttpInterceptor {
        public EngineInterceptor() {
        }

        @Override // com.apollographql.apollo3.network.http.HttpInterceptor
        public void dispose() {
            HttpInterceptor.DefaultImpls.dispose(this);
        }

        @Override // com.apollographql.apollo3.network.http.HttpInterceptor
        public Object intercept(HttpRequest httpRequest, HttpInterceptorChain httpInterceptorChain, Continuation<? super HttpResponse> continuation) {
            return HttpNetworkTransport.this.getEngine().execute(httpRequest, continuation);
        }
    }

    @Override // com.apollographql.apollo3.network.NetworkTransport
    public void dispose() {
        Iterator<T> it = this.interceptors.iterator();
        while (it.hasNext()) {
            ((HttpInterceptor) it.next()).dispose();
        }
        this.engine.dispose();
    }

    public final Builder newBuilder() {
        return new Builder().httpEngine(this.engine).interceptors(this.interceptors).httpRequestComposer(this.httpRequestComposer);
    }

    /* JADX INFO: compiled from: HttpNetworkTransport.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0004J\u0014\u0010\u0013\u001a\u00020\u00002\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\t\u001a\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/apollographql/apollo3/network/http/HttpNetworkTransport$Builder;", "", "()V", "engine", "Lcom/apollographql/apollo3/network/http/HttpEngine;", "exposeErrorBody", "", "httpRequestComposer", "Lcom/apollographql/apollo3/api/http/HttpRequestComposer;", "interceptors", "", "Lcom/apollographql/apollo3/network/http/HttpInterceptor;", "serverUrl", "", "addInterceptor", "interceptor", "build", "Lcom/apollographql/apollo3/network/http/HttpNetworkTransport;", "httpEngine", "httpHeaders", "headers", "", "Lcom/apollographql/apollo3/api/http/HttpHeader;", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private HttpEngine engine;
        private boolean exposeErrorBody;
        private HttpRequestComposer httpRequestComposer;
        private final List<HttpInterceptor> interceptors = new ArrayList();
        private String serverUrl;

        public final Builder httpRequestComposer(HttpRequestComposer httpRequestComposer) {
            Intrinsics.checkNotNullParameter(httpRequestComposer, "httpRequestComposer");
            this.httpRequestComposer = httpRequestComposer;
            return this;
        }

        public final Builder serverUrl(String serverUrl) {
            Intrinsics.checkNotNullParameter(serverUrl, "serverUrl");
            this.serverUrl = serverUrl;
            return this;
        }

        public final Builder exposeErrorBody(boolean exposeErrorBody) {
            this.exposeErrorBody = exposeErrorBody;
            return this;
        }

        public final Builder httpHeaders(List<HttpHeader> headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.interceptors.add(new HeadersInterceptor(headers));
            return this;
        }

        public final Builder httpEngine(HttpEngine httpEngine) {
            Intrinsics.checkNotNullParameter(httpEngine, "httpEngine");
            this.engine = httpEngine;
            return this;
        }

        public final Builder interceptors(List<? extends HttpInterceptor> interceptors) {
            Intrinsics.checkNotNullParameter(interceptors, "interceptors");
            this.interceptors.clear();
            this.interceptors.addAll(interceptors);
            return this;
        }

        public final Builder addInterceptor(HttpInterceptor interceptor) {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            this.interceptors.add(interceptor);
            return this;
        }

        public final HttpNetworkTransport build() {
            DefaultHttpRequestComposer defaultHttpRequestComposer = this.httpRequestComposer;
            if (defaultHttpRequestComposer != null && this.serverUrl != null) {
                throw new IllegalStateException("It is an error to set both 'httpRequestComposer' and 'serverUrl'".toString());
            }
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (defaultHttpRequestComposer == null) {
                String str = this.serverUrl;
                DefaultHttpRequestComposer defaultHttpRequestComposer2 = str != null ? new DefaultHttpRequestComposer(str) : null;
                if (defaultHttpRequestComposer2 != null) {
                    defaultHttpRequestComposer = defaultHttpRequestComposer2;
                } else {
                    throw new IllegalStateException("No HttpRequestComposer found. Use 'httpRequestComposer' or 'serverUrl'".toString());
                }
            }
            HttpRequestComposer httpRequestComposer = defaultHttpRequestComposer;
            DefaultHttpEngine defaultHttpEngine = this.engine;
            if (defaultHttpEngine == null) {
                defaultHttpEngine = new DefaultHttpEngine(0L, 1, defaultConstructorMarker);
            }
            return new HttpNetworkTransport(httpRequestComposer, defaultHttpEngine, this.interceptors, this.exposeErrorBody, null);
        }
    }

    /* JADX INFO: compiled from: HttpNetworkTransport.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\b"}, d2 = {"Lcom/apollographql/apollo3/network/http/HttpNetworkTransport$Companion;", "", "()V", "wrapThrowableIfNeeded", "Lcom/apollographql/apollo3/exception/ApolloException;", "throwable", "", "Kind", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: compiled from: HttpNetworkTransport.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/apollographql/apollo3/network/http/HttpNetworkTransport$Companion$Kind;", "", "(Ljava/lang/String;I)V", "EMPTY", "PAYLOAD", "OTHER", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
        enum Kind {
            EMPTY,
            PAYLOAD,
            OTHER
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ApolloException wrapThrowableIfNeeded(Throwable throwable) {
            if (throwable instanceof ApolloException) {
                return (ApolloException) throwable;
            }
            return new ApolloParseException("Failed to parse GraphQL http network response", throwable);
        }
    }
}
