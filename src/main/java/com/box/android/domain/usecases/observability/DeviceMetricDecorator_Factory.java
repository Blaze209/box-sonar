package com.box.android.domain.usecases.observability;

import com.box.android.domain.services.IAppInfoService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DeviceMetricDecorator_Factory implements Factory<DeviceMetricDecorator> {
    private final Provider<IAppInfoService> appInfoServiceProvider;

    private DeviceMetricDecorator_Factory(Provider<IAppInfoService> provider) {
        this.appInfoServiceProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DeviceMetricDecorator get() {
        return newInstance(this.appInfoServiceProvider.get());
    }

    public static DeviceMetricDecorator_Factory create(Provider<IAppInfoService> provider) {
        return new DeviceMetricDecorator_Factory(provider);
    }

    public static DeviceMetricDecorator newInstance(IAppInfoService iAppInfoService) {
        return new DeviceMetricDecorator(iAppInfoService);
    }
}
