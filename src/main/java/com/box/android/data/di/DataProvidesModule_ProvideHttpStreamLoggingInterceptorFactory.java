package com.box.android.data.di;

import com.box.android.data.api.utils.HttpStreamLoggingInterceptor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import okhttp3.logging.HttpLoggingInterceptor;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_ProvideHttpStreamLoggingInterceptorFactory implements Factory<HttpStreamLoggingInterceptor> {
    private final Provider<HttpLoggingInterceptor> httpLoggingInterceptorProvider;
    private final DataProvidesModule module;

    private DataProvidesModule_ProvideHttpStreamLoggingInterceptorFactory(DataProvidesModule module, Provider<HttpLoggingInterceptor> httpLoggingInterceptorProvider) {
        this.module = module;
        this.httpLoggingInterceptorProvider = httpLoggingInterceptorProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public HttpStreamLoggingInterceptor get() {
        return provideHttpStreamLoggingInterceptor(this.module, this.httpLoggingInterceptorProvider.get());
    }

    public static DataProvidesModule_ProvideHttpStreamLoggingInterceptorFactory create(DataProvidesModule module, Provider<HttpLoggingInterceptor> httpLoggingInterceptorProvider) {
        return new DataProvidesModule_ProvideHttpStreamLoggingInterceptorFactory(module, httpLoggingInterceptorProvider);
    }

    public static HttpStreamLoggingInterceptor provideHttpStreamLoggingInterceptor(DataProvidesModule instance, HttpLoggingInterceptor httpLoggingInterceptor) {
        return (HttpStreamLoggingInterceptor) Preconditions.checkNotNullFromProvides(instance.provideHttpStreamLoggingInterceptor(httpLoggingInterceptor));
    }
}
