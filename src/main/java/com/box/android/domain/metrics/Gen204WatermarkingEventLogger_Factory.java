package com.box.android.domain.metrics;

import com.box.android.domain.usecases.observability.MetricsUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class Gen204WatermarkingEventLogger_Factory implements Factory<Gen204WatermarkingEventLogger> {
    private final Provider<CoroutineDispatcher> coroutineDispatcherProvider;
    private final Provider<MetricsUseCase> metricsUseCaseProvider;

    private Gen204WatermarkingEventLogger_Factory(Provider<MetricsUseCase> provider, Provider<CoroutineDispatcher> provider2) {
        this.metricsUseCaseProvider = provider;
        this.coroutineDispatcherProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Gen204WatermarkingEventLogger get() {
        return newInstance(this.metricsUseCaseProvider.get(), this.coroutineDispatcherProvider.get());
    }

    public static Gen204WatermarkingEventLogger_Factory create(Provider<MetricsUseCase> provider, Provider<CoroutineDispatcher> provider2) {
        return new Gen204WatermarkingEventLogger_Factory(provider, provider2);
    }

    public static Gen204WatermarkingEventLogger newInstance(MetricsUseCase metricsUseCase, CoroutineDispatcher coroutineDispatcher) {
        return new Gen204WatermarkingEventLogger(metricsUseCase, coroutineDispatcher);
    }
}
