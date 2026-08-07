package com.box.android.domain.usecases.browse;

import com.box.android.domain.services.IOfflineService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class OfflinedViewInteractor_Factory implements Factory<OfflinedViewInteractor> {
    private final Provider<IOfflineService> offlineServiceProvider;

    private OfflinedViewInteractor_Factory(Provider<IOfflineService> provider) {
        this.offlineServiceProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public OfflinedViewInteractor get() {
        return newInstance(this.offlineServiceProvider.get());
    }

    public static OfflinedViewInteractor_Factory create(Provider<IOfflineService> provider) {
        return new OfflinedViewInteractor_Factory(provider);
    }

    public static OfflinedViewInteractor newInstance(IOfflineService iOfflineService) {
        return new OfflinedViewInteractor(iOfflineService);
    }
}
