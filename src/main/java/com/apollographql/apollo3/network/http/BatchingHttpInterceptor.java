package com.apollographql.apollo3.network.http;

import com.apollographql.apollo3.ApolloCall;
import com.apollographql.apollo3.ApolloClient;
import com.apollographql.apollo3.api.Adapters;
import com.apollographql.apollo3.api.CustomScalarAdapters;
import com.apollographql.apollo3.api.Operation;
import com.apollographql.apollo3.api.http.HttpBody;
import com.apollographql.apollo3.api.http.HttpHeader;
import com.apollographql.apollo3.api.http.HttpHeaders;
import com.apollographql.apollo3.api.http.HttpMethod;
import com.apollographql.apollo3.api.http.HttpRequest;
import com.apollographql.apollo3.api.http.HttpResponse;
import com.apollographql.apollo3.api.json.BufferedSinkJsonWriter;
import com.apollographql.apollo3.api.json.BufferedSourceJsonReader;
import com.apollographql.apollo3.api.json.JsonReader;
import com.apollographql.apollo3.exception.ApolloException;
import com.apollographql.apollo3.exception.ApolloHttpException;
import com.apollographql.apollo3.exception.JsonDataException;
import com.apollographql.apollo3.internal.CloseableSingleThreadDispatcher;
import com.apollographql.apollo3.mpp.UtilsKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: compiled from: BatchingHttpInterceptor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0002 !B%\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u000e\u0010\u0018\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/apollographql/apollo3/network/http/BatchingHttpInterceptor;", "Lcom/apollographql/apollo3/network/http/HttpInterceptor;", "batchIntervalMillis", "", "maxBatchSize", "", "exposeErrorBody", "", "(JIZ)V", "creationTime", "dispatcher", "Lcom/apollographql/apollo3/internal/CloseableSingleThreadDispatcher;", "disposed", "interceptorChain", "Lcom/apollographql/apollo3/network/http/HttpInterceptorChain;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "pendingRequests", "", "Lcom/apollographql/apollo3/network/http/BatchingHttpInterceptor$PendingRequest;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dispose", "", "executePendingRequests", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "intercept", "Lcom/apollographql/apollo3/api/http/HttpResponse;", "request", "Lcom/apollographql/apollo3/api/http/HttpRequest;", "chain", "(Lcom/apollographql/apollo3/api/http/HttpRequest;Lcom/apollographql/apollo3/network/http/HttpInterceptorChain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "PendingRequest", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BatchingHttpInterceptor implements HttpInterceptor {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long batchIntervalMillis;
    private final long creationTime;
    private final CloseableSingleThreadDispatcher dispatcher;
    private boolean disposed;
    private final boolean exposeErrorBody;
    private HttpInterceptorChain interceptorChain;
    private final int maxBatchSize;
    private final Mutex mutex;
    private final List<PendingRequest> pendingRequests;
    private final CoroutineScope scope;

    /* JADX INFO: renamed from: com.apollographql.apollo3.network.http.BatchingHttpInterceptor$executePendingRequests$1, reason: invalid class name */
    /* JADX INFO: compiled from: BatchingHttpInterceptor.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.network.http.BatchingHttpInterceptor", f = "BatchingHttpInterceptor.kt", i = {0, 0, 1, 1, 1}, l = {260, 168}, m = "executePendingRequests", n = {"this", "$this$withLock_u24default$iv", "this", "pending", "exception"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BatchingHttpInterceptor.this.executePendingRequests(this);
        }
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.network.http.BatchingHttpInterceptor$intercept$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BatchingHttpInterceptor.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.network.http.BatchingHttpInterceptor", f = "BatchingHttpInterceptor.kt", i = {1, 1, 1, 2}, l = {92, 263, 106, 114}, m = "intercept", n = {"this", "pendingRequest", "$this$withLock_u24default$iv", "pendingRequest"}, s = {"L$0", "L$1", "L$2", "L$0"})
    static final class C09061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C09061(Continuation<? super C09061> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BatchingHttpInterceptor.this.intercept(null, null, this);
        }
    }

    public BatchingHttpInterceptor() {
        this(0L, 0, false, 7, null);
    }

    public BatchingHttpInterceptor(long j) {
        this(j, 0, false, 6, null);
    }

    public BatchingHttpInterceptor(long j, int i) {
        this(j, i, false, 4, null);
    }

    @JvmStatic
    public static final <D extends Operation.Data> void configureApolloCall(ApolloCall<D> apolloCall, boolean z) {
        INSTANCE.configureApolloCall(apolloCall, z);
    }

    @JvmStatic
    public static final void configureApolloClientBuilder(ApolloClient.Builder builder, boolean z) {
        INSTANCE.configureApolloClientBuilder(builder, z);
    }

    public BatchingHttpInterceptor(long j, int i, boolean z) {
        this.batchIntervalMillis = j;
        this.maxBatchSize = i;
        this.exposeErrorBody = z;
        this.creationTime = UtilsKt.currentTimeMillis();
        CloseableSingleThreadDispatcher closeableSingleThreadDispatcher = new CloseableSingleThreadDispatcher();
        this.dispatcher = closeableSingleThreadDispatcher;
        this.scope = CoroutineScopeKt.CoroutineScope(closeableSingleThreadDispatcher.getCoroutineDispatcher());
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.pendingRequests = new ArrayList();
    }

    public /* synthetic */ BatchingHttpInterceptor(long j, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 10L : j, (i2 & 2) != 0 ? 10 : i, (i2 & 4) != 0 ? false : z);
    }

    /* JADX INFO: compiled from: BatchingHttpInterceptor.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/apollographql/apollo3/network/http/BatchingHttpInterceptor$PendingRequest;", "", "request", "Lcom/apollographql/apollo3/api/http/HttpRequest;", "(Lcom/apollographql/apollo3/api/http/HttpRequest;)V", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "Lcom/apollographql/apollo3/api/http/HttpResponse;", "getDeferred", "()Lkotlinx/coroutines/CompletableDeferred;", "getRequest", "()Lcom/apollographql/apollo3/api/http/HttpRequest;", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class PendingRequest {
        private final CompletableDeferred<HttpResponse> deferred;
        private final HttpRequest request;

        public PendingRequest(HttpRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.request = request;
            this.deferred = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        }

        public final HttpRequest getRequest() {
            return this.request;
        }

        public final CompletableDeferred<HttpResponse> getDeferred() {
            return this.deferred;
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x012e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    @Override // com.apollographql.apollo3.network.http.HttpInterceptor
    public Object intercept(HttpRequest httpRequest, HttpInterceptorChain httpInterceptorChain, Continuation<? super HttpResponse> continuation) {
        C09061 c09061;
        Mutex mutex;
        PendingRequest pendingRequest;
        PendingRequest pendingRequest2;
        Object objAwait;
        BatchingHttpInterceptor batchingHttpInterceptor = this;
        if (continuation instanceof C09061) {
            c09061 = (C09061) continuation;
            if ((c09061.label & Integer.MIN_VALUE) != 0) {
                c09061.label -= Integer.MIN_VALUE;
            } else {
                c09061 = batchingHttpInterceptor.new C09061(continuation);
            }
        } else {
            c09061 = batchingHttpInterceptor.new C09061(continuation);
        }
        Object obj = c09061.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09061.label;
        try {
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                if (i == 2) {
                    Mutex mutex2 = (Mutex) c09061.L$2;
                    pendingRequest = (PendingRequest) c09061.L$1;
                    BatchingHttpInterceptor batchingHttpInterceptor2 = (BatchingHttpInterceptor) c09061.L$0;
                    ResultKt.throwOnFailure(obj);
                    mutex = mutex2;
                    batchingHttpInterceptor = batchingHttpInterceptor2;
                } else {
                    if (i != 3) {
                        if (i != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    pendingRequest2 = (PendingRequest) c09061.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                pendingRequest = pendingRequest2;
                CompletableDeferred<HttpResponse> deferred = pendingRequest.getDeferred();
                c09061.L$0 = null;
                c09061.L$1 = null;
                c09061.L$2 = null;
                c09061.label = 4;
                objAwait = deferred.await(c09061);
                if (objAwait == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objAwait;
            }
            ResultKt.throwOnFailure(obj);
            String strValueOf = HttpHeaders.valueOf(httpRequest.getHeaders(), "X-APOLLO-CAN-BE-BATCHED");
            if (!(strValueOf != null ? Boolean.parseBoolean(strValueOf) : true)) {
                HttpRequest.Builder builderNewBuilder$default = HttpRequest.newBuilder$default(httpRequest, null, null, 3, null);
                List<HttpHeader> headers = httpRequest.getHeaders();
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : headers) {
                    if (!Intrinsics.areEqual(((HttpHeader) obj2).getName(), "X-APOLLO-CAN-BE-BATCHED")) {
                        arrayList.add(obj2);
                    }
                }
                HttpRequest httpRequestBuild = builderNewBuilder$default.addHeaders(arrayList).build();
                c09061.label = 1;
                Object objProceed = httpInterceptorChain.proceed(httpRequestBuild, c09061);
                if (objProceed != coroutine_suspended) {
                    return objProceed;
                }
            } else {
                batchingHttpInterceptor.interceptorChain = httpInterceptorChain;
                PendingRequest pendingRequest3 = new PendingRequest(httpRequest);
                Mutex mutex3 = batchingHttpInterceptor.mutex;
                c09061.L$0 = batchingHttpInterceptor;
                c09061.L$1 = pendingRequest3;
                c09061.L$2 = mutex3;
                c09061.label = 2;
                if (mutex3.lock(null, c09061) != coroutine_suspended) {
                    mutex = mutex3;
                    pendingRequest = pendingRequest3;
                }
            }
            return coroutine_suspended;
            batchingHttpInterceptor.pendingRequests.add(pendingRequest);
            boolean z = batchingHttpInterceptor.pendingRequests.size() >= batchingHttpInterceptor.maxBatchSize;
            mutex.unlock(null);
            if (!z) {
                BuildersKt__Builders_commonKt.launch$default(batchingHttpInterceptor.scope, null, null, batchingHttpInterceptor.new AnonymousClass3(null), 3, null);
                CompletableDeferred<HttpResponse> deferred2 = pendingRequest.getDeferred();
                c09061.L$0 = null;
                c09061.L$1 = null;
                c09061.L$2 = null;
                c09061.label = 4;
                objAwait = deferred2.await(c09061);
                if (objAwait == coroutine_suspended) {
                    return objAwait;
                }
            } else {
                c09061.L$0 = pendingRequest;
                c09061.L$1 = null;
                c09061.L$2 = null;
                c09061.label = 3;
                if (batchingHttpInterceptor.executePendingRequests(c09061) != coroutine_suspended) {
                    pendingRequest2 = pendingRequest;
                    pendingRequest = pendingRequest2;
                    CompletableDeferred<HttpResponse> deferred3 = pendingRequest.getDeferred();
                    c09061.L$0 = null;
                    c09061.L$1 = null;
                    c09061.L$2 = null;
                    c09061.label = 4;
                    objAwait = deferred3.await(c09061);
                    if (objAwait == coroutine_suspended) {
                        return objAwait;
                    }
                }
            }
            return coroutine_suspended;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.network.http.BatchingHttpInterceptor$intercept$3, reason: invalid class name */
    /* JADX INFO: compiled from: BatchingHttpInterceptor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.apollographql.apollo3.network.http.BatchingHttpInterceptor$intercept$3", f = "BatchingHttpInterceptor.kt", i = {}, l = {109, 110}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BatchingHttpInterceptor.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0054, code lost:
        
            if (r10.this$0.executePendingRequests(r10) == r0) goto L15;
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
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r11)
                goto L57
            L12:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L1a:
                kotlin.ResultKt.throwOnFailure(r11)
                goto L49
            L1e:
                kotlin.ResultKt.throwOnFailure(r11)
                com.apollographql.apollo3.network.http.BatchingHttpInterceptor r11 = com.apollographql.apollo3.network.http.BatchingHttpInterceptor.this
                long r4 = com.apollographql.apollo3.network.http.BatchingHttpInterceptor.access$getBatchIntervalMillis$p(r11)
                long r6 = com.apollographql.apollo3.mpp.UtilsKt.currentTimeMillis()
                com.apollographql.apollo3.network.http.BatchingHttpInterceptor r11 = com.apollographql.apollo3.network.http.BatchingHttpInterceptor.this
                long r8 = com.apollographql.apollo3.network.http.BatchingHttpInterceptor.access$getCreationTime$p(r11)
                long r6 = r6 - r8
                com.apollographql.apollo3.network.http.BatchingHttpInterceptor r11 = com.apollographql.apollo3.network.http.BatchingHttpInterceptor.this
                long r8 = com.apollographql.apollo3.network.http.BatchingHttpInterceptor.access$getBatchIntervalMillis$p(r11)
                long r6 = r6 % r8
                long r4 = r4 - r6
                r6 = 1
                long r4 = r4 - r6
                r11 = r10
                kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
                r10.label = r3
                java.lang.Object r11 = kotlinx.coroutines.DelayKt.delay(r4, r11)
                if (r11 != r0) goto L49
                goto L56
            L49:
                com.apollographql.apollo3.network.http.BatchingHttpInterceptor r11 = com.apollographql.apollo3.network.http.BatchingHttpInterceptor.this
                r1 = r10
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r10.label = r2
                java.lang.Object r10 = com.apollographql.apollo3.network.http.BatchingHttpInterceptor.access$executePendingRequests(r11, r1)
                if (r10 != r0) goto L57
            L56:
                return r0
            L57:
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apollographql.apollo3.network.http.BatchingHttpInterceptor.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:102:0x0291 A[Catch: Exception -> 0x0045, TryCatch #3 {Exception -> 0x0045, blocks: (B:13:0x0040, B:57:0x018e, B:61:0x019a, B:63:0x01a0, B:80:0x01ef, B:82:0x01f3, B:84:0x0200, B:85:0x0211, B:87:0x0217, B:89:0x021d, B:90:0x023b, B:91:0x0242, B:92:0x0243, B:93:0x0248, B:94:0x027a, B:95:0x027b, B:96:0x0282, B:97:0x0283, B:77:0x01e8, B:98:0x0284, B:99:0x028c, B:100:0x028d, B:102:0x0291, B:104:0x0297, B:107:0x02a1, B:108:0x02d0, B:106:0x029c, B:64:0x01a7, B:70:0x01c4, B:71:0x01e0, B:74:0x01e3), top: B:144:0x0040, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:104:0x0297 A[Catch: Exception -> 0x0045, TryCatch #3 {Exception -> 0x0045, blocks: (B:13:0x0040, B:57:0x018e, B:61:0x019a, B:63:0x01a0, B:80:0x01ef, B:82:0x01f3, B:84:0x0200, B:85:0x0211, B:87:0x0217, B:89:0x021d, B:90:0x023b, B:91:0x0242, B:92:0x0243, B:93:0x0248, B:94:0x027a, B:95:0x027b, B:96:0x0282, B:97:0x0283, B:77:0x01e8, B:98:0x0284, B:99:0x028c, B:100:0x028d, B:102:0x0291, B:104:0x0297, B:107:0x02a1, B:108:0x02d0, B:106:0x029c, B:64:0x01a7, B:70:0x01c4, B:71:0x01e0, B:74:0x01e3), top: B:144:0x0040, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x029c A[Catch: Exception -> 0x0045, TryCatch #3 {Exception -> 0x0045, blocks: (B:13:0x0040, B:57:0x018e, B:61:0x019a, B:63:0x01a0, B:80:0x01ef, B:82:0x01f3, B:84:0x0200, B:85:0x0211, B:87:0x0217, B:89:0x021d, B:90:0x023b, B:91:0x0242, B:92:0x0243, B:93:0x0248, B:94:0x027a, B:95:0x027b, B:96:0x0282, B:97:0x0283, B:77:0x01e8, B:98:0x0284, B:99:0x028c, B:100:0x028d, B:102:0x0291, B:104:0x0297, B:107:0x02a1, B:108:0x02d0, B:106:0x029c, B:64:0x01a7, B:70:0x01c4, B:71:0x01e0, B:74:0x01e3), top: B:144:0x0040, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:114:0x02da  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object executePendingRequests(Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Mutex mutex;
        List list;
        Ref.ObjectRef objectRef;
        T apolloException;
        HttpResponse httpResponse;
        int statusCode;
        BufferedSource body;
        BufferedSource body2;
        Throwable th;
        Object objFromJson;
        BatchingHttpInterceptor batchingHttpInterceptor = this;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = batchingHttpInterceptor.new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = batchingHttpInterceptor.new AnonymousClass1(continuation);
        }
        Object objProceed = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        ArrayList arrayList = null;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objProceed);
                mutex = batchingHttpInterceptor.mutex;
                anonymousClass1.L$0 = batchingHttpInterceptor;
                anonymousClass1.L$1 = mutex;
                anonymousClass1.label = 1;
                if (mutex.lock(null, anonymousClass1) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                Mutex mutex2 = (Mutex) anonymousClass1.L$1;
                BatchingHttpInterceptor batchingHttpInterceptor2 = (BatchingHttpInterceptor) anonymousClass1.L$0;
                ResultKt.throwOnFailure(objProceed);
                mutex = mutex2;
                batchingHttpInterceptor = batchingHttpInterceptor2;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef = (Ref.ObjectRef) anonymousClass1.L$2;
                list = (List) anonymousClass1.L$1;
                batchingHttpInterceptor = (BatchingHttpInterceptor) anonymousClass1.L$0;
                try {
                    ResultKt.throwOnFailure(objProceed);
                    httpResponse = (HttpResponse) objProceed;
                    statusCode = httpResponse.getStatusCode();
                    if (200 <= statusCode || statusCode >= 300) {
                        if (!batchingHttpInterceptor.exposeErrorBody) {
                            body = httpResponse.getBody();
                        } else {
                            body2 = httpResponse.getBody();
                            if (body2 != null) {
                                body2.close();
                            }
                            body = null;
                        }
                        throw new ApolloHttpException(httpResponse.getStatusCode(), httpResponse.getHeaders(), body, "HTTP error " + httpResponse.getStatusCode() + " while executing batched query", null, 16, null);
                    }
                    BufferedSource body3 = httpResponse.getBody();
                    if (body3 == null) {
                        throw new ApolloException("null body when executing batched query", null, 2, null);
                    }
                    BufferedSourceJsonReader bufferedSourceJsonReader = new BufferedSourceJsonReader(body3);
                    try {
                        BufferedSourceJsonReader bufferedSourceJsonReader2 = bufferedSourceJsonReader;
                        objFromJson = Adapters.AnyAdapter.fromJson(bufferedSourceJsonReader2, CustomScalarAdapters.Empty);
                        if (bufferedSourceJsonReader2.getPeekedToken() != JsonReader.Token.END_DOCUMENT) {
                            throw new JsonDataException("Expected END_DOCUMENT but was " + bufferedSourceJsonReader2.getPeekedToken());
                        }
                        try {
                            bufferedSourceJsonReader.close();
                            th = null;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        if (th == null) {
                            if (!(objFromJson instanceof List)) {
                                throw new ApolloException("batched query response is not a list when executing batched query", null, 2, null);
                            }
                            if (((List) objFromJson).size() != list.size()) {
                                throw new ApolloException("batched query response count (" + ((List) objFromJson).size() + ") does not match the requested queries (" + list.size() + ')', null, 2, null);
                            }
                            Iterable iterable = (Iterable) objFromJson;
                            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                            for (Object obj : iterable) {
                                if (obj == null) {
                                    throw new ApolloException("batched query response contains a null item", null, 2, null);
                                }
                                Buffer buffer = new Buffer();
                                Adapters.AnyAdapter.toJson(new BufferedSinkJsonWriter(buffer, null), CustomScalarAdapters.Empty, obj);
                                arrayList2.add(buffer.readByteString());
                            }
                            arrayList = arrayList2;
                            if (objectRef.element == 0) {
                                Intrinsics.checkNotNull(arrayList);
                                int i2 = 0;
                                for (Object obj2 : arrayList) {
                                    int i3 = i2 + 1;
                                    if (i2 < 0) {
                                        CollectionsKt.throwIndexOverflow();
                                    }
                                    ((PendingRequest) list.get(i2)).getDeferred().complete(new HttpResponse.Builder(200).body((ByteString) obj2).build());
                                    i2 = i3;
                                }
                                return Unit.INSTANCE;
                            }
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                ((PendingRequest) it.next()).getDeferred().completeExceptionally((Throwable) objectRef.element);
                            }
                            return Unit.INSTANCE;
                        }
                        throw th;
                    } catch (Throwable th3) {
                        try {
                            bufferedSourceJsonReader.close();
                        } catch (Throwable th4) {
                            ExceptionsKt.addSuppressed(th3, th4);
                        }
                        th = th3;
                        objFromJson = null;
                    }
                } catch (Exception e) {
                    e = e;
                    if (e instanceof ApolloException) {
                        apolloException = (ApolloException) e;
                    } else {
                        apolloException = new ApolloException("batched query failed with exception", e);
                    }
                    objectRef.element = apolloException;
                }
            }
            list = CollectionsKt.toList(batchingHttpInterceptor.pendingRequests);
            batchingHttpInterceptor.pendingRequests.clear();
            mutex.unlock(null);
            if (list.isEmpty()) {
                return Unit.INSTANCE;
            }
            HttpRequest request = ((PendingRequest) CollectionsKt.first(list)).getRequest();
            List list2 = list;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                HttpBody body4 = ((PendingRequest) it2.next()).getRequest().getBody();
                if (body4 == null) {
                    throw new IllegalStateException("empty body while batching queries".toString());
                }
                arrayList3.add(body4);
            }
            final ArrayList arrayList4 = arrayList3;
            ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator it3 = list2.iterator();
            while (it3.hasNext()) {
                arrayList5.add(((PendingRequest) it3.next()).getRequest().getHeaders());
            }
            Iterator it4 = arrayList5.iterator();
            if (!it4.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object next = it4.next();
            while (it4.hasNext()) {
                next = CollectionsKt.toList(CollectionsKt.intersect((List) next, CollectionsKt.toSet((List) it4.next())));
            }
            ArrayList arrayList6 = new ArrayList();
            for (Object obj3 : (Iterable) next) {
                if (!Intrinsics.areEqual(((HttpHeader) obj3).getName(), "X-APOLLO-CAN-BE-BATCHED")) {
                    arrayList6.add(obj3);
                }
            }
            HttpRequest httpRequestBuild = new HttpRequest.Builder(HttpMethod.Post, request.getUrl()).body(new HttpBody() { // from class: com.apollographql.apollo3.network.http.BatchingHttpInterceptor$executePendingRequests$body$1
                private final String contentType = "application/json";
                private final long contentLength = -1;

                @Override // com.apollographql.apollo3.api.http.HttpBody
                public String getContentType() {
                    return this.contentType;
                }

                @Override // com.apollographql.apollo3.api.http.HttpBody
                public long getContentLength() {
                    return this.contentLength;
                }

                @Override // com.apollographql.apollo3.api.http.HttpBody
                public void writeTo(BufferedSink bufferedSink) throws IOException {
                    Intrinsics.checkNotNullParameter(bufferedSink, "bufferedSink");
                    BufferedSinkJsonWriter bufferedSinkJsonWriter = new BufferedSinkJsonWriter(bufferedSink, null, 2, null);
                    List<HttpBody> list3 = arrayList4;
                    bufferedSinkJsonWriter.beginArray();
                    BufferedSinkJsonWriter bufferedSinkJsonWriter2 = bufferedSinkJsonWriter;
                    for (HttpBody httpBody : list3) {
                        Buffer buffer2 = new Buffer();
                        httpBody.writeTo(buffer2);
                        bufferedSinkJsonWriter2.jsonValue(buffer2.readUtf8());
                    }
                    bufferedSinkJsonWriter.endArray();
                }
            }).headers(arrayList6).build();
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            try {
                HttpInterceptorChain httpInterceptorChain = batchingHttpInterceptor.interceptorChain;
                Intrinsics.checkNotNull(httpInterceptorChain);
                anonymousClass1.L$0 = batchingHttpInterceptor;
                anonymousClass1.L$1 = list;
                anonymousClass1.L$2 = objectRef2;
                anonymousClass1.label = 2;
                objProceed = httpInterceptorChain.proceed(httpRequestBuild, anonymousClass1);
                if (objProceed != coroutine_suspended) {
                    objectRef = objectRef2;
                    httpResponse = (HttpResponse) objProceed;
                    statusCode = httpResponse.getStatusCode();
                    if (200 <= statusCode) {
                    }
                    if (!batchingHttpInterceptor.exposeErrorBody) {
                        body = httpResponse.getBody();
                    } else {
                        body2 = httpResponse.getBody();
                        if (body2 != null) {
                            body2.close();
                        }
                        body = null;
                    }
                    throw new ApolloHttpException(httpResponse.getStatusCode(), httpResponse.getHeaders(), body, "HTTP error " + httpResponse.getStatusCode() + " while executing batched query", null, 16, null);
                }
                return coroutine_suspended;
            } catch (Exception e2) {
                e = e2;
                objectRef = objectRef2;
                if (e instanceof ApolloException) {
                    apolloException = (ApolloException) e;
                } else {
                    apolloException = new ApolloException("batched query failed with exception", e);
                }
                objectRef.element = apolloException;
            }
        } catch (Throwable th5) {
            mutex.unlock(null);
            throw th5;
        }
    }

    @Override // com.apollographql.apollo3.network.http.HttpInterceptor
    public void dispose() {
        if (this.disposed) {
            return;
        }
        this.interceptorChain = null;
        CoroutineScopeKt.cancel$default(this.scope, null, 1, null);
        this.dispatcher.close();
        this.disposed = true;
    }

    /* JADX INFO: compiled from: BatchingHttpInterceptor.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u0004\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000e"}, d2 = {"Lcom/apollographql/apollo3/network/http/BatchingHttpInterceptor$Companion;", "", "()V", "configureApolloCall", "", "D", "Lcom/apollographql/apollo3/api/Operation$Data;", "apolloCall", "Lcom/apollographql/apollo3/ApolloCall;", "canBeBatched", "", "configureApolloClientBuilder", "apolloClientBuilder", "Lcom/apollographql/apollo3/ApolloClient$Builder;", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void configureApolloClientBuilder(ApolloClient.Builder apolloClientBuilder, boolean canBeBatched) {
            Intrinsics.checkNotNullParameter(apolloClientBuilder, "apolloClientBuilder");
            apolloClientBuilder.canBeBatched(Boolean.valueOf(canBeBatched));
        }

        @JvmStatic
        public final <D extends Operation.Data> void configureApolloCall(ApolloCall<D> apolloCall, boolean canBeBatched) {
            Intrinsics.checkNotNullParameter(apolloCall, "apolloCall");
            apolloCall.canBeBatched(Boolean.valueOf(canBeBatched));
        }
    }
}
