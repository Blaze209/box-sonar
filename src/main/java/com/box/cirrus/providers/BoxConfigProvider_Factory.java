package com.box.cirrus.providers;

import com.box.android.domain.services.IBVEManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class BoxConfigProvider_Factory implements Factory<BoxConfigProvider> {
    private final Provider<IBVEManager> bveManagerProvider;

    private BoxConfigProvider_Factory(Provider<IBVEManager> provider) {
        this.bveManagerProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxConfigProvider get() {
        return newInstance(this.bveManagerProvider.get());
    }

    public static BoxConfigProvider_Factory create(Provider<IBVEManager> provider) {
        return new BoxConfigProvider_Factory(provider);
    }

    public static BoxConfigProvider newInstance(IBVEManager iBVEManager) {
        return new BoxConfigProvider(iBVEManager);
    }
}
