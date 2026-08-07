package com.box.android.data.api.interceptors;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: EmptyBodyInterceptor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/box/android/data/api/interceptors/EmptyBodyInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EmptyBodyInterceptor implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Response responseProceed = chain.proceed(chain.request());
        if (!responseProceed.isSuccessful()) {
            return responseProceed;
        }
        int iCode = responseProceed.code();
        if (iCode != 204 && iCode != 205) {
            return responseProceed;
        }
        ResponseBody responseBodyBody = responseProceed.body();
        if ((responseBodyBody != null ? responseBodyBody.getContentLength() : -1L) >= 0) {
            return responseProceed.newBuilder().code(200).build();
        }
        return responseProceed.newBuilder().code(200).body(ResponseBody.INSTANCE.create(MediaType.INSTANCE.get("text/plain"), "")).build();
    }
}
