package com.box.android.data.api.utils;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/* JADX INFO: compiled from: HttpStreamLoggingInterceptor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/box/android/data/api/utils/HttpStreamLoggingInterceptor;", "Lokhttp3/Interceptor;", "interceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "<init>", "(Lokhttp3/logging/HttpLoggingInterceptor;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HttpStreamLoggingInterceptor implements Interceptor {
    private final HttpLoggingInterceptor interceptor;

    @Inject
    public HttpStreamLoggingInterceptor(HttpLoggingInterceptor interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        this.interceptor = interceptor;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Exception {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        HttpLoggingInterceptor.Level level = this.interceptor.getLevel();
        if (((StreamingTag) request.tag(StreamingTag.class)) != null && level == HttpLoggingInterceptor.Level.BODY) {
            this.interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        }
        Response responseIntercept = this.interceptor.intercept(chain);
        this.interceptor.setLevel(level);
        return responseIntercept;
    }
}
