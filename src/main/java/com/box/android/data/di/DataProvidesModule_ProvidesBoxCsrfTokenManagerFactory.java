package com.box.android.data.di;

import android.webkit.CookieManager;
import com.box.android.domain.webBridgeAuth.BoxCsrfTokenManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_ProvidesBoxCsrfTokenManagerFactory implements Factory<BoxCsrfTokenManager> {
    private final Provider<CookieManager> cookieManagerProvider;
    private final DataProvidesModule module;

    private DataProvidesModule_ProvidesBoxCsrfTokenManagerFactory(DataProvidesModule module, Provider<CookieManager> cookieManagerProvider) {
        this.module = module;
        this.cookieManagerProvider = cookieManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxCsrfTokenManager get() {
        return providesBoxCsrfTokenManager(this.module, this.cookieManagerProvider.get());
    }

    public static DataProvidesModule_ProvidesBoxCsrfTokenManagerFactory create(DataProvidesModule module, Provider<CookieManager> cookieManagerProvider) {
        return new DataProvidesModule_ProvidesBoxCsrfTokenManagerFactory(module, cookieManagerProvider);
    }

    public static BoxCsrfTokenManager providesBoxCsrfTokenManager(DataProvidesModule instance, CookieManager cookieManager) {
        return (BoxCsrfTokenManager) Preconditions.checkNotNullFromProvides(instance.providesBoxCsrfTokenManager(cookieManager));
    }
}
