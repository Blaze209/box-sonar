package com.box.android.data.api.utils;

import dagger.internal.Factory;
import dagger.internal.Provider;
import okhttp3.logging.HttpLoggingInterceptor;

/* JADX INFO: loaded from: classes11.dex */
public final class HttpStreamLoggingInterceptor_Factory implements Factory<HttpStreamLoggingInterceptor> {
    private final Provider<HttpLoggingInterceptor> interceptorProvider;

    private HttpStreamLoggingInterceptor_Factory(Provider<HttpLoggingInterceptor> interceptorProvider) {
        this.interceptorProvider = interceptorProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public HttpStreamLoggingInterceptor get() {
        return newInstance(this.interceptorProvider.get());
    }

    public static HttpStreamLoggingInterceptor_Factory create(Provider<HttpLoggingInterceptor> interceptorProvider) {
        return new HttpStreamLoggingInterceptor_Factory(interceptorProvider);
    }

    public static HttpStreamLoggingInterceptor newInstance(HttpLoggingInterceptor interceptor) {
        return new HttpStreamLoggingInterceptor(interceptor);
    }
}
