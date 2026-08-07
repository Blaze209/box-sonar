package com.box.android.data.di;

import com.box.android.data.api.interceptors.RetryRequestInterceptor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_ProvideNetworkInterceptorFactory implements Factory<RetryRequestInterceptor> {
    private final DataProvidesModule module;

    private DataProvidesModule_ProvideNetworkInterceptorFactory(DataProvidesModule module) {
        this.module = module;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public RetryRequestInterceptor get() {
        return provideNetworkInterceptor(this.module);
    }

    public static DataProvidesModule_ProvideNetworkInterceptorFactory create(DataProvidesModule module) {
        return new DataProvidesModule_ProvideNetworkInterceptorFactory(module);
    }

    public static RetryRequestInterceptor provideNetworkInterceptor(DataProvidesModule instance) {
        return (RetryRequestInterceptor) Preconditions.checkNotNullFromProvides(instance.provideNetworkInterceptor());
    }
}
