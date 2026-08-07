package com.splunk.rum;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes3.dex */
public class CustomHeadersRequestInterceptor implements Interceptor {
    private final Supplier<Map<String, String>> headersSupplier;

    public CustomHeadersRequestInterceptor(Supplier<Map<String, String>> supplier) {
        this.headersSupplier = supplier;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request.Builder builderNewBuilder = chain.request().newBuilder();
        Map<String, String> map = this.headersSupplier.get();
        if (map != null) {
            Objects.requireNonNull(builderNewBuilder);
            map.forEach(new CustomHeadersRequestInterceptor$$ExternalSyntheticLambda0(builderNewBuilder));
        }
        return chain.proceed(builderNewBuilder.build());
    }
}
