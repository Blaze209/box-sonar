package com.apollographql.apollo3.network.http;

import com.apollographql.apollo3.api.http.HttpHeader;
import com.apollographql.apollo3.api.http.HttpRequest;
import com.apollographql.apollo3.api.http.HttpResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClientAwarenessInterceptor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/apollographql/apollo3/network/http/ApolloClientAwarenessInterceptor;", "Lcom/apollographql/apollo3/network/http/HttpInterceptor;", "clientName", "", "clientVersion", "(Ljava/lang/String;Ljava/lang/String;)V", "extraHeaders", "", "Lcom/apollographql/apollo3/api/http/HttpHeader;", "intercept", "Lcom/apollographql/apollo3/api/http/HttpResponse;", "request", "Lcom/apollographql/apollo3/api/http/HttpRequest;", "chain", "Lcom/apollographql/apollo3/network/http/HttpInterceptorChain;", "(Lcom/apollographql/apollo3/api/http/HttpRequest;Lcom/apollographql/apollo3/network/http/HttpInterceptorChain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ApolloClientAwarenessInterceptor implements HttpInterceptor {
    private final List<HttpHeader> extraHeaders;

    public ApolloClientAwarenessInterceptor(String clientName, String clientVersion) {
        Intrinsics.checkNotNullParameter(clientName, "clientName");
        Intrinsics.checkNotNullParameter(clientVersion, "clientVersion");
        this.extraHeaders = CollectionsKt.listOf((Object[]) new HttpHeader[]{new HttpHeader("apollographql-client-name", clientName), new HttpHeader("apollographql-client-version", clientVersion)});
    }

    @Override // com.apollographql.apollo3.network.http.HttpInterceptor
    public void dispose() {
        HttpInterceptor.DefaultImpls.dispose(this);
    }

    @Override // com.apollographql.apollo3.network.http.HttpInterceptor
    public Object intercept(HttpRequest httpRequest, HttpInterceptorChain httpInterceptorChain, Continuation<? super HttpResponse> continuation) {
        return httpInterceptorChain.proceed(HttpRequest.newBuilder$default(httpRequest, null, null, 3, null).addHeaders(this.extraHeaders).build(), continuation);
    }
}
