package com.box.android.data.di;

import android.webkit.CookieManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_ProvidesCookieManagerFactory implements Factory<CookieManager> {
    private final DataProvidesModule module;

    private DataProvidesModule_ProvidesCookieManagerFactory(DataProvidesModule module) {
        this.module = module;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CookieManager get() {
        return providesCookieManager(this.module);
    }

    public static DataProvidesModule_ProvidesCookieManagerFactory create(DataProvidesModule module) {
        return new DataProvidesModule_ProvidesCookieManagerFactory(module);
    }

    public static CookieManager providesCookieManager(DataProvidesModule instance) {
        return (CookieManager) Preconditions.checkNotNullFromProvides(instance.providesCookieManager());
    }
}
