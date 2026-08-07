package com.box.android.domain.metrics;

import com.box.android.domain.usecases.observability.MetricsUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class Gen204PerformanceLogger_Factory implements Factory<Gen204PerformanceLogger> {
    private final Provider<MetricsUseCase> metricsUseCaseProvider;

    private Gen204PerformanceLogger_Factory(Provider<MetricsUseCase> provider) {
        this.metricsUseCaseProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Gen204PerformanceLogger get() {
        return newInstance(this.metricsUseCaseProvider.get());
    }

    public static Gen204PerformanceLogger_Factory create(Provider<MetricsUseCase> provider) {
        return new Gen204PerformanceLogger_Factory(provider);
    }

    public static Gen204PerformanceLogger newInstance(MetricsUseCase metricsUseCase) {
        return new Gen204PerformanceLogger(metricsUseCase);
    }
}
