package com.apollographql.apollo3.network.http;

import com.apollographql.apollo3.api.http.HttpHeader;
import com.apollographql.apollo3.api.http.HttpRequest;
import com.apollographql.apollo3.api.http.HttpResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HeadersInterceptor.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/apollographql/apollo3/network/http/HeadersInterceptor;", "Lcom/apollographql/apollo3/network/http/HttpInterceptor;", "headers", "", "Lcom/apollographql/apollo3/api/http/HttpHeader;", "(Ljava/util/List;)V", "intercept", "Lcom/apollographql/apollo3/api/http/HttpResponse;", "request", "Lcom/apollographql/apollo3/api/http/HttpRequest;", "chain", "Lcom/apollographql/apollo3/network/http/HttpInterceptorChain;", "(Lcom/apollographql/apollo3/api/http/HttpRequest;Lcom/apollographql/apollo3/network/http/HttpInterceptorChain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class HeadersInterceptor implements HttpInterceptor {
    private final List<HttpHeader> headers;

    public HeadersInterceptor(List<HttpHeader> headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.headers = headers;
    }

    @Override // com.apollographql.apollo3.network.http.HttpInterceptor
    public void dispose() {
        HttpInterceptor.DefaultImpls.dispose(this);
    }

    @Override // com.apollographql.apollo3.network.http.HttpInterceptor
    public Object intercept(HttpRequest httpRequest, HttpInterceptorChain httpInterceptorChain, Continuation<? super HttpResponse> continuation) {
        return httpInterceptorChain.proceed(HttpRequest.newBuilder$default(httpRequest, null, null, 3, null).addHeaders(this.headers).build(), continuation);
    }
}
