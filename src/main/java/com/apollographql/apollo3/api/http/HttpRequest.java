package com.apollographql.apollo3.api.http;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Http.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B/\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/apollographql/apollo3/api/http/HttpRequest;", "", FirebaseAnalytics.Param.METHOD, "Lcom/apollographql/apollo3/api/http/HttpMethod;", "url", "", "headers", "", "Lcom/apollographql/apollo3/api/http/HttpHeader;", "body", "Lcom/apollographql/apollo3/api/http/HttpBody;", "(Lcom/apollographql/apollo3/api/http/HttpMethod;Ljava/lang/String;Ljava/util/List;Lcom/apollographql/apollo3/api/http/HttpBody;)V", "getBody", "()Lcom/apollographql/apollo3/api/http/HttpBody;", "getHeaders", "()Ljava/util/List;", "getMethod", "()Lcom/apollographql/apollo3/api/http/HttpMethod;", "getUrl", "()Ljava/lang/String;", "newBuilder", "Lcom/apollographql/apollo3/api/http/HttpRequest$Builder;", "Builder", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class HttpRequest {
    private final HttpBody body;
    private final List<HttpHeader> headers;
    private final HttpMethod method;
    private final String url;

    public /* synthetic */ HttpRequest(HttpMethod httpMethod, String str, List list, HttpBody httpBody, DefaultConstructorMarker defaultConstructorMarker) {
        this(httpMethod, str, list, httpBody);
    }

    public final Builder newBuilder() {
        return newBuilder$default(this, null, null, 3, null);
    }

    public final Builder newBuilder(HttpMethod method) {
        Intrinsics.checkNotNullParameter(method, "method");
        return newBuilder$default(this, method, null, 2, null);
    }

    private HttpRequest(HttpMethod httpMethod, String str, List<HttpHeader> list, HttpBody httpBody) {
        this.method = httpMethod;
        this.url = str;
        this.headers = list;
        this.body = httpBody;
    }

    public final HttpMethod getMethod() {
        return this.method;
    }

    public final String getUrl() {
        return this.url;
    }

    public final List<HttpHeader> getHeaders() {
        return this.headers;
    }

    public final HttpBody getBody() {
        return this.body;
    }

    public static /* synthetic */ Builder newBuilder$default(HttpRequest httpRequest, HttpMethod httpMethod, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            httpMethod = httpRequest.method;
        }
        if ((i & 2) != 0) {
            str = httpRequest.url;
        }
        return httpRequest.newBuilder(httpMethod, str);
    }

    public final Builder newBuilder(HttpMethod method, String url) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(url, "url");
        Builder builder = new Builder(method, url);
        HttpBody httpBody = this.body;
        if (httpBody != null) {
            builder.body(httpBody);
        }
        builder.addHeaders(this.headers);
        return builder;
    }

    /* JADX INFO: compiled from: Http.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005J\u0014\u0010\u000f\u001a\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0014\u0010\t\u001a\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/apollographql/apollo3/api/http/HttpRequest$Builder;", "", FirebaseAnalytics.Param.METHOD, "Lcom/apollographql/apollo3/api/http/HttpMethod;", "url", "", "(Lcom/apollographql/apollo3/api/http/HttpMethod;Ljava/lang/String;)V", "body", "Lcom/apollographql/apollo3/api/http/HttpBody;", "headers", "", "Lcom/apollographql/apollo3/api/http/HttpHeader;", "addHeader", "name", "value", "addHeaders", "", "build", "Lcom/apollographql/apollo3/api/http/HttpRequest;", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Builder {
        private HttpBody body;
        private final List<HttpHeader> headers;
        private final HttpMethod method;
        private final String url;

        public Builder(HttpMethod method, String url) {
            Intrinsics.checkNotNullParameter(method, "method");
            Intrinsics.checkNotNullParameter(url, "url");
            this.method = method;
            this.url = url;
            this.headers = new ArrayList();
        }

        public final Builder body(HttpBody body) {
            Intrinsics.checkNotNullParameter(body, "body");
            this.body = body;
            return this;
        }

        public final Builder addHeader(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            this.headers.add(new HttpHeader(name, value));
            return this;
        }

        public final Builder addHeaders(List<HttpHeader> headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.headers.addAll(headers);
            return this;
        }

        public final Builder headers(List<HttpHeader> headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.headers.clear();
            this.headers.addAll(headers);
            return this;
        }

        public final HttpRequest build() {
            return new HttpRequest(this.method, this.url, this.headers, this.body, null);
        }
    }
}
