package com.box.android.data.di;

import com.box.android.data.api.interceptors.Gen204RequestInterceptor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_ProvideGen204RequestInterceptorFactory implements Factory<Gen204RequestInterceptor> {
    private final DataProvidesModule module;

    private DataProvidesModule_ProvideGen204RequestInterceptorFactory(DataProvidesModule module) {
        this.module = module;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Gen204RequestInterceptor get() {
        return provideGen204RequestInterceptor(this.module);
    }

    public static DataProvidesModule_ProvideGen204RequestInterceptorFactory create(DataProvidesModule module) {
        return new DataProvidesModule_ProvideGen204RequestInterceptorFactory(module);
    }

    public static Gen204RequestInterceptor provideGen204RequestInterceptor(DataProvidesModule instance) {
        return (Gen204RequestInterceptor) Preconditions.checkNotNullFromProvides(instance.provideGen204RequestInterceptor());
    }
}
