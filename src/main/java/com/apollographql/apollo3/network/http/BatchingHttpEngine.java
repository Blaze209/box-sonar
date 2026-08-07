package com.apollographql.apollo3.network.http;

import com.apollographql.apollo3.api.http.HttpRequest;
import com.apollographql.apollo3.api.http.HttpResponse;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BatchingHttpEngine.kt */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated(message = "Use ApolloClient.Builder.batching instead")
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u000f\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u0019R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/apollographql/apollo3/network/http/BatchingHttpEngine;", "Lcom/apollographql/apollo3/network/http/HttpEngine;", "delegate", "batchIntervalMillis", "", "maxBatchSize", "", "exposeErrorBody", "", "(Lcom/apollographql/apollo3/network/http/HttpEngine;JIZ)V", "batchingHttpInterceptor", "Lcom/apollographql/apollo3/network/http/BatchingHttpInterceptor;", "getDelegate", "()Lcom/apollographql/apollo3/network/http/HttpEngine;", "engineInterceptor", "com/apollographql/apollo3/network/http/BatchingHttpEngine$engineInterceptor$1", "Lcom/apollographql/apollo3/network/http/BatchingHttpEngine$engineInterceptor$1;", "interceptorChain", "Lcom/apollographql/apollo3/network/http/DefaultHttpInterceptorChain;", "dispose", "", "execute", "Lcom/apollographql/apollo3/api/http/HttpResponse;", "request", "Lcom/apollographql/apollo3/api/http/HttpRequest;", "(Lcom/apollographql/apollo3/api/http/HttpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BatchingHttpEngine implements HttpEngine {
    private final BatchingHttpInterceptor batchingHttpInterceptor;
    private final HttpEngine delegate;
    private final BatchingHttpEngine$engineInterceptor$1 engineInterceptor;
    private final DefaultHttpInterceptorChain interceptorChain;

    public BatchingHttpEngine() {
        this(null, 0L, 0, false, 15, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BatchingHttpEngine(HttpEngine delegate) {
        this(delegate, 0L, 0, false, 14, null);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BatchingHttpEngine(HttpEngine delegate, long j) {
        this(delegate, j, 0, false, 12, null);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BatchingHttpEngine(HttpEngine delegate, long j, int i) {
        this(delegate, j, i, false, 8, null);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.apollographql.apollo3.network.http.BatchingHttpEngine$engineInterceptor$1, java.lang.Object] */
    public BatchingHttpEngine(HttpEngine delegate, long j, int i, boolean z) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.batchingHttpInterceptor = new BatchingHttpInterceptor(j, i, z);
        ?? r2 = new HttpInterceptor() { // from class: com.apollographql.apollo3.network.http.BatchingHttpEngine$engineInterceptor$1
            @Override // com.apollographql.apollo3.network.http.HttpInterceptor
            public void dispose() {
                HttpInterceptor.DefaultImpls.dispose(this);
            }

            @Override // com.apollographql.apollo3.network.http.HttpInterceptor
            public Object intercept(HttpRequest httpRequest, HttpInterceptorChain httpInterceptorChain, Continuation<? super HttpResponse> continuation) {
                return this.this$0.getDelegate().execute(httpRequest, continuation);
            }
        };
        this.engineInterceptor = r2;
        this.interceptorChain = new DefaultHttpInterceptorChain(CollectionsKt.listOf(r2), 0);
    }

    public /* synthetic */ BatchingHttpEngine(DefaultHttpEngine defaultHttpEngine, long j, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new DefaultHttpEngine(0L, 1, null) : defaultHttpEngine, (i2 & 2) != 0 ? 10L : j, (i2 & 4) != 0 ? 10 : i, (i2 & 8) != 0 ? false : z);
    }

    public final HttpEngine getDelegate() {
        return this.delegate;
    }

    @Override // com.apollographql.apollo3.network.http.HttpEngine
    public Object execute(HttpRequest httpRequest, Continuation<? super HttpResponse> continuation) {
        return this.batchingHttpInterceptor.intercept(httpRequest, this.interceptorChain, continuation);
    }

    @Override // com.apollographql.apollo3.network.http.HttpEngine
    public void dispose() {
        this.delegate.dispose();
    }
}
