package com.box.android.data.api.interceptors;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

/* JADX INFO: compiled from: Gen204RequestInterceptor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¨\u0006\u000f"}, d2 = {"Lcom/box/android/data/api/interceptors/Gen204RequestInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "isGen204Request", "", "originalRequest", "Lokhttp3/Request;", "gzip", "Lokhttp3/RequestBody;", "body", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Gen204RequestInterceptor implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        if (!isGen204Request(request)) {
            return chain.proceed(request);
        }
        return chain.proceed(request.newBuilder().header("Content-Encoding", "gzip").removeHeader("Content-Type").removeHeader("Accept").removeHeader("Authorization").method(request.method(), gzip(request.body())).build());
    }

    private final boolean isGen204Request(Request originalRequest) {
        return originalRequest.body() != null && StringsKt.contains$default((CharSequence) originalRequest.url().getUrl(), (CharSequence) "/index.php?rm=box_gen204_client_analytics", false, 2, (Object) null);
    }

    private final RequestBody gzip(final RequestBody body) {
        return new RequestBody() { // from class: com.box.android.data.api.interceptors.Gen204RequestInterceptor.gzip.1
            @Override // okhttp3.RequestBody
            public long contentLength() {
                return -1L;
            }

            @Override // okhttp3.RequestBody
            /* JADX INFO: renamed from: contentType */
            public MediaType getMediaType() {
                RequestBody requestBody = body;
                Intrinsics.checkNotNull(requestBody);
                return requestBody.getMediaType();
            }

            @Override // okhttp3.RequestBody
            public void writeTo(BufferedSink sink) throws IOException {
                Intrinsics.checkNotNullParameter(sink, "sink");
                BufferedSink bufferedSinkBuffer = Okio.buffer(new GzipSink(sink));
                RequestBody requestBody = body;
                Intrinsics.checkNotNull(requestBody);
                requestBody.writeTo(bufferedSinkBuffer);
                bufferedSinkBuffer.close();
            }
        };
    }
}
