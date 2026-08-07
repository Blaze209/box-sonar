package com.box.android.data.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import okhttp3.logging.HttpLoggingInterceptor;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_ProvideHttpLoggingInterceptorFactory implements Factory<HttpLoggingInterceptor> {
    private final DataProvidesModule module;

    private DataProvidesModule_ProvideHttpLoggingInterceptorFactory(DataProvidesModule module) {
        this.module = module;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public HttpLoggingInterceptor get() {
        return provideHttpLoggingInterceptor(this.module);
    }

    public static DataProvidesModule_ProvideHttpLoggingInterceptorFactory create(DataProvidesModule module) {
        return new DataProvidesModule_ProvideHttpLoggingInterceptorFactory(module);
    }

    public static HttpLoggingInterceptor provideHttpLoggingInterceptor(DataProvidesModule instance) {
        return (HttpLoggingInterceptor) Preconditions.checkNotNullFromProvides(instance.provideHttpLoggingInterceptor());
    }
}
