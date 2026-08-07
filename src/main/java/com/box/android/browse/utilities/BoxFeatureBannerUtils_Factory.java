package com.box.android.browse.utilities;

import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.IAppInBackgroundService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class BoxFeatureBannerUtils_Factory implements Factory<BoxFeatureBannerUtils> {
    private final Provider<IAppInBackgroundService> appInBackgroundServiceProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private BoxFeatureBannerUtils_Factory(Provider<IUserContextManager> provider, Provider<IAppInBackgroundService> provider2) {
        this.userContextManagerProvider = provider;
        this.appInBackgroundServiceProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxFeatureBannerUtils get() {
        return newInstance(this.userContextManagerProvider.get(), this.appInBackgroundServiceProvider.get());
    }

    public static BoxFeatureBannerUtils_Factory create(Provider<IUserContextManager> provider, Provider<IAppInBackgroundService> provider2) {
        return new BoxFeatureBannerUtils_Factory(provider, provider2);
    }

    public static BoxFeatureBannerUtils newInstance(IUserContextManager iUserContextManager, IAppInBackgroundService iAppInBackgroundService) {
        return new BoxFeatureBannerUtils(iUserContextManager, iAppInBackgroundService);
    }
}
