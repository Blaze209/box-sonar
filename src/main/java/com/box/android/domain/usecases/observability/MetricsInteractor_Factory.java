package com.box.android.domain.usecases.observability;

import com.box.android.domain.services.IMetricsLoggingService;
import dagger.internal.Factory;
import dagger.internal.Provider;
import java.util.Set;

/* JADX INFO: loaded from: classes11.dex */
public final class MetricsInteractor_Factory implements Factory<MetricsInteractor> {
    private final Provider<Set<MetricDecorator>> metricDecoratorsProvider;
    private final Provider<IMetricsLoggingService> metricsLoggingServiceProvider;

    private MetricsInteractor_Factory(Provider<IMetricsLoggingService> provider, Provider<Set<MetricDecorator>> provider2) {
        this.metricsLoggingServiceProvider = provider;
        this.metricDecoratorsProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MetricsInteractor get() {
        return newInstance(this.metricsLoggingServiceProvider.get(), this.metricDecoratorsProvider.get());
    }

    public static MetricsInteractor_Factory create(Provider<IMetricsLoggingService> provider, Provider<Set<MetricDecorator>> provider2) {
        return new MetricsInteractor_Factory(provider, provider2);
    }

    public static MetricsInteractor newInstance(IMetricsLoggingService iMetricsLoggingService, Set<MetricDecorator> set) {
        return new MetricsInteractor(iMetricsLoggingService, set);
    }
}
