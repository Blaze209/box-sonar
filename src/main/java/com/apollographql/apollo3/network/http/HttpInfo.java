package com.apollographql.apollo3.network.http;

import com.apollographql.apollo3.api.ExecutionContext;
import com.apollographql.apollo3.api.http.HttpHeader;
import com.pspdfkit.annotations.NoteAnnotation;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HttpExecutionContext.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB-\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\fR\u001a\u0010\u0017\u001a\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/apollographql/apollo3/network/http/HttpInfo;", "Lcom/apollographql/apollo3/api/ExecutionContext$Element;", "startMillis", "", "endMillis", "statusCode", "", "headers", "", "Lcom/apollographql/apollo3/api/http/HttpHeader;", "(JJILjava/util/List;)V", "getEndMillis", "()J", "getHeaders", "()Ljava/util/List;", "key", "Lcom/apollographql/apollo3/api/ExecutionContext$Key;", "getKey", "()Lcom/apollographql/apollo3/api/ExecutionContext$Key;", "millisEnd", "getMillisEnd$annotations", "()V", "getMillisEnd", "millisStart", "getMillisStart$annotations", "getMillisStart", "getStartMillis", "getStatusCode", "()I", NoteAnnotation.KEY, "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class HttpInfo implements ExecutionContext.Element {

    /* JADX INFO: renamed from: Key, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long endMillis;
    private final List<HttpHeader> headers;
    private final long startMillis;
    private final int statusCode;

    @Deprecated(message = "Use endMillis instead", replaceWith = @ReplaceWith(expression = "endMillis", imports = {}))
    public static /* synthetic */ void getMillisEnd$annotations() {
    }

    @Deprecated(message = "Use startMillis instead", replaceWith = @ReplaceWith(expression = "startMillis", imports = {}))
    public static /* synthetic */ void getMillisStart$annotations() {
    }

    @Deprecated(message = "HttpInfo is only to be constructed internally. Declare your own class if needed")
    public HttpInfo(long j, long j2, int i, List<HttpHeader> headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.startMillis = j;
        this.endMillis = j2;
        this.statusCode = i;
        this.headers = headers;
    }

    @Override // com.apollographql.apollo3.api.ExecutionContext.Element, com.apollographql.apollo3.api.ExecutionContext
    public <R> R fold(R r, Function2<? super R, ? super ExecutionContext.Element, ? extends R> function2) {
        return (R) ExecutionContext.Element.DefaultImpls.fold(this, r, function2);
    }

    @Override // com.apollographql.apollo3.api.ExecutionContext.Element, com.apollographql.apollo3.api.ExecutionContext
    public <E extends ExecutionContext.Element> E get(ExecutionContext.Key<E> key) {
        return (E) ExecutionContext.Element.DefaultImpls.get(this, key);
    }

    @Override // com.apollographql.apollo3.api.ExecutionContext.Element, com.apollographql.apollo3.api.ExecutionContext
    public ExecutionContext minusKey(ExecutionContext.Key<?> key) {
        return ExecutionContext.Element.DefaultImpls.minusKey(this, key);
    }

    @Override // com.apollographql.apollo3.api.ExecutionContext
    public ExecutionContext plus(ExecutionContext executionContext) {
        return ExecutionContext.Element.DefaultImpls.plus(this, executionContext);
    }

    public final long getStartMillis() {
        return this.startMillis;
    }

    public final long getEndMillis() {
        return this.endMillis;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final List<HttpHeader> getHeaders() {
        return this.headers;
    }

    /* JADX INFO: renamed from: getMillisStart, reason: from getter */
    public final long getStartMillis() {
        return this.startMillis;
    }

    public final long getMillisEnd() {
        return this.endMillis;
    }

    @Override // com.apollographql.apollo3.api.ExecutionContext.Element
    public ExecutionContext.Key<?> getKey() {
        return INSTANCE;
    }

    /* JADX INFO: renamed from: com.apollographql.apollo3.network.http.HttpInfo$Key, reason: from kotlin metadata */
    /* JADX INFO: compiled from: HttpExecutionContext.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/apollographql/apollo3/network/http/HttpInfo$Key;", "Lcom/apollographql/apollo3/api/ExecutionContext$Key;", "Lcom/apollographql/apollo3/network/http/HttpInfo;", "()V", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion implements ExecutionContext.Key<HttpInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
