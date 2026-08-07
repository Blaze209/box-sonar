package com.box.android.data.di;

import com.box.android.data.api.interceptors.EmptyBodyInterceptor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_ProvideEmptyBodyInterceptorFactory implements Factory<EmptyBodyInterceptor> {
    private final DataProvidesModule module;

    private DataProvidesModule_ProvideEmptyBodyInterceptorFactory(DataProvidesModule module) {
        this.module = module;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public EmptyBodyInterceptor get() {
        return provideEmptyBodyInterceptor(this.module);
    }

    public static DataProvidesModule_ProvideEmptyBodyInterceptorFactory create(DataProvidesModule module) {
        return new DataProvidesModule_ProvideEmptyBodyInterceptorFactory(module);
    }

    public static EmptyBodyInterceptor provideEmptyBodyInterceptor(DataProvidesModule instance) {
        return (EmptyBodyInterceptor) Preconditions.checkNotNullFromProvides(instance.provideEmptyBodyInterceptor());
    }
}
