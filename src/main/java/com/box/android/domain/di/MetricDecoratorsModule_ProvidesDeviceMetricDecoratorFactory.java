package com.box.android.domain.di;

import com.box.android.domain.services.IAppInfoService;
import com.box.android.domain.usecases.observability.MetricDecorator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class MetricDecoratorsModule_ProvidesDeviceMetricDecoratorFactory implements Factory<MetricDecorator> {
    private final Provider<IAppInfoService> appInfoServiceProvider;

    private MetricDecoratorsModule_ProvidesDeviceMetricDecoratorFactory(Provider<IAppInfoService> provider) {
        this.appInfoServiceProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MetricDecorator get() {
        return providesDeviceMetricDecorator(this.appInfoServiceProvider.get());
    }

    public static MetricDecoratorsModule_ProvidesDeviceMetricDecoratorFactory create(Provider<IAppInfoService> provider) {
        return new MetricDecoratorsModule_ProvidesDeviceMetricDecoratorFactory(provider);
    }

    public static MetricDecorator providesDeviceMetricDecorator(IAppInfoService iAppInfoService) {
        return (MetricDecorator) Preconditions.checkNotNullFromProvides(MetricDecoratorsModule.INSTANCE.providesDeviceMetricDecorator(iAppInfoService));
    }
}
