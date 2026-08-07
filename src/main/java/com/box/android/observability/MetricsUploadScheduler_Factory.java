package com.box.android.observability;

import com.box.android.domain.services.IAppInBackgroundService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class MetricsUploadScheduler_Factory implements Factory<MetricsUploadScheduler> {
    private final Provider<IAppInBackgroundService> appInBackgroundServiceProvider;

    private MetricsUploadScheduler_Factory(Provider<IAppInBackgroundService> provider) {
        this.appInBackgroundServiceProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MetricsUploadScheduler get() {
        return newInstance(this.appInBackgroundServiceProvider.get());
    }

    public static MetricsUploadScheduler_Factory create(Provider<IAppInBackgroundService> provider) {
        return new MetricsUploadScheduler_Factory(provider);
    }

    public static MetricsUploadScheduler newInstance(IAppInBackgroundService iAppInBackgroundService) {
        return new MetricsUploadScheduler(iAppInBackgroundService);
    }
}
