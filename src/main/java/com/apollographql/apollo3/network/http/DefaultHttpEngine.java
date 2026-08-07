package com.apollographql.apollo3.network.http;

import com.apollographql.apollo3.api.http.HttpBody;
import com.apollographql.apollo3.api.http.HttpHeader;
import com.apollographql.apollo3.api.http.HttpMethod;
import com.apollographql.apollo3.api.http.HttpRequest;
import com.apollographql.apollo3.api.http.HttpResponse;
import com.apollographql.apollo3.api.http.UploadsHttpBody;
import com.apollographql.apollo3.exception.ApolloNetworkException;
import com.apollographql.apollo3.network.OkHttpExtensionsKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;

/* JADX INFO: compiled from: OkHttpEngine.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0011\b\u0016\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0017\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nB\r\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0014R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/apollographql/apollo3/network/http/DefaultHttpEngine;", "Lcom/apollographql/apollo3/network/http/HttpEngine;", "okHttpClient", "Lokhttp3/OkHttpClient;", "(Lokhttp3/OkHttpClient;)V", "timeoutMillis", "", "(J)V", "connectTimeout", "readTimeout", "(JJ)V", "httpCallFactory", "Lokhttp3/Call$Factory;", "(Lokhttp3/Call$Factory;)V", "dispose", "", "execute", "Lcom/apollographql/apollo3/api/http/HttpResponse;", "request", "Lcom/apollographql/apollo3/api/http/HttpRequest;", "(Lcom/apollographql/apollo3/api/http/HttpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "apollo-runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DefaultHttpEngine implements HttpEngine {
    private final Call.Factory httpCallFactory;

    @Override // com.apollographql.apollo3.network.http.HttpEngine
    public void dispose() {
    }

    public DefaultHttpEngine(Call.Factory httpCallFactory) {
        Intrinsics.checkNotNullParameter(httpCallFactory, "httpCallFactory");
        this.httpCallFactory = httpCallFactory;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultHttpEngine(OkHttpClient okHttpClient) {
        this((Call.Factory) okHttpClient);
        Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
    }

    public DefaultHttpEngine(long j) {
        this(j, j);
    }

    public /* synthetic */ DefaultHttpEngine(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 60000L : j);
    }

    public DefaultHttpEngine(long j, long j2) {
        this(new OkHttpClient.Builder().connectTimeout(j, TimeUnit.MILLISECONDS).readTimeout(j2, TimeUnit.MILLISECONDS).build());
    }

    @Override // com.apollographql.apollo3.network.http.HttpEngine
    public Object execute(HttpRequest httpRequest, Continuation<? super HttpResponse> continuation) throws IOException {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        Request.Builder builderHeaders = new Request.Builder().url(httpRequest.getUrl()).headers(OkHttpExtensionsKt.toOkHttpHeaders(httpRequest.getHeaders()));
        if (httpRequest.getMethod() == HttpMethod.Get) {
            builderHeaders.get();
        } else {
            final HttpBody body = httpRequest.getBody();
            if (body == null) {
                throw new IllegalStateException("HTTP POST requires a request body".toString());
            }
            builderHeaders.post(new RequestBody() { // from class: com.apollographql.apollo3.network.http.DefaultHttpEngine$execute$2$httpRequest$1$2
                @Override // okhttp3.RequestBody
                /* JADX INFO: renamed from: contentType */
                public MediaType getMediaType() {
                    return MediaType.INSTANCE.get(body.getContentType());
                }

                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return body.getContentLength();
                }

                @Override // okhttp3.RequestBody
                public boolean isOneShot() {
                    return body instanceof UploadsHttpBody;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(BufferedSink sink) {
                    Intrinsics.checkNotNullParameter(sink, "sink");
                    body.writeTo(sink);
                }
            });
        }
        final Call callNewCall = this.httpCallFactory.newCall(builderHeaders.build());
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.apollographql.apollo3.network.http.DefaultHttpEngine$execute$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                callNewCall.cancel();
            }
        });
        Response responseExecute = null;
        try {
            responseExecute = callNewCall.execute();
            e = null;
        } catch (IOException e) {
            e = e;
        }
        if (e != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl2.resumeWith(Result.m14780constructorimpl(ResultKt.createFailure(new ApolloNetworkException("Failed to execute GraphQL http network request", e))));
        } else {
            Result.Companion companion2 = Result.INSTANCE;
            Intrinsics.checkNotNull(responseExecute);
            HttpResponse.Builder builder = new HttpResponse.Builder(responseExecute.code());
            ResponseBody responseBodyBody = responseExecute.body();
            Intrinsics.checkNotNull(responseBodyBody);
            HttpResponse.Builder builderBody = builder.body(responseBodyBody.getSource());
            Headers headers = responseExecute.headers();
            IntRange intRangeUntil = RangesKt.until(0, headers.size());
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
            Iterator<Integer> it = intRangeUntil.iterator();
            while (it.hasNext()) {
                int iNextInt = ((IntIterator) it).nextInt();
                arrayList.add(new HttpHeader(headers.name(iNextInt), headers.value(iNextInt)));
            }
            Object objM14780constructorimpl = Result.m14780constructorimpl(builderBody.addHeaders(arrayList).build());
            ResultKt.throwOnFailure(objM14780constructorimpl);
            Result.Companion companion3 = Result.INSTANCE;
            cancellableContinuationImpl2.resumeWith(Result.m14780constructorimpl(objM14780constructorimpl));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
