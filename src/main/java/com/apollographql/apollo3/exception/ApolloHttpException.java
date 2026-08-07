package com.apollographql.apollo3.exception;

import com.apollographql.apollo3.api.http.HttpHeader;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;

/* JADX INFO: compiled from: Exceptions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/apollographql/apollo3/exception/ApolloHttpException;", "Lcom/apollographql/apollo3/exception/ApolloException;", "statusCode", "", "headers", "", "Lcom/apollographql/apollo3/api/http/HttpHeader;", "body", "Lokio/BufferedSource;", "message", "", "cause", "", "(ILjava/util/List;Lokio/BufferedSource;Ljava/lang/String;Ljava/lang/Throwable;)V", "getBody", "()Lokio/BufferedSource;", "getHeaders", "()Ljava/util/List;", "getStatusCode", "()I", "apollo-api"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ApolloHttpException extends ApolloException {
    private final BufferedSource body;
    private final List<HttpHeader> headers;
    private final int statusCode;

    public /* synthetic */ ApolloHttpException(int i, List list, BufferedSource bufferedSource, String str, Throwable th, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list, bufferedSource, str, (i2 & 16) != 0 ? null : th);
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final List<HttpHeader> getHeaders() {
        return this.headers;
    }

    public final BufferedSource getBody() {
        return this.body;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApolloHttpException(int i, List<HttpHeader> headers, BufferedSource bufferedSource, String message, Throwable th) {
        super(message, th);
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(message, "message");
        this.statusCode = i;
        this.headers = headers;
        this.body = bufferedSource;
    }
}
