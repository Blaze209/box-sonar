package com.box.android.data.api.interceptors;

import java.io.IOException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/* JADX INFO: compiled from: AiRequestInterceptor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/box/android/data/api/interceptors/AiRequestInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AiRequestInterceptor implements Interceptor {
    @Inject
    public AiRequestInterceptor() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        if (!StringsKt.contains$default((CharSequence) request.url().getUrl(), (CharSequence) "/intelligence/", false, 2, (Object) null)) {
            return chain.proceed(request);
        }
        Request.Builder builderHeader = request.newBuilder().header("Accept", "application/vnd.box+json;version=2").header("Cookie", "csrf-token=unused").header("x-csrf-token", "unused");
        RequestBody requestBodyBody = request.body();
        if (requestBodyBody != null) {
            Buffer buffer = new Buffer();
            requestBodyBody.writeTo(buffer);
            RequestBody requestBodyCreate = RequestBody.INSTANCE.create(buffer.readUtf8(), (MediaType) null);
            builderHeader.header("Content-Type", "application/vnd.box+json;version=2");
            builderHeader.post(requestBodyCreate);
        }
        return chain.proceed(builderHeader.build());
    }
}
