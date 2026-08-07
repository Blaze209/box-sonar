package com.box.android.domain.metrics;

import com.box.android.domain.usecases.observability.MetricsUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class ForceUpdateObservability_Factory implements Factory<ForceUpdateObservability> {
    private final Provider<CoroutineDispatcher> coroutineDispatcherProvider;
    private final Provider<MetricsUseCase> metricsUseCaseProvider;

    private ForceUpdateObservability_Factory(Provider<MetricsUseCase> provider, Provider<CoroutineDispatcher> provider2) {
        this.metricsUseCaseProvider = provider;
        this.coroutineDispatcherProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ForceUpdateObservability get() {
        return newInstance(this.metricsUseCaseProvider.get(), this.coroutineDispatcherProvider.get());
    }

    public static ForceUpdateObservability_Factory create(Provider<MetricsUseCase> provider, Provider<CoroutineDispatcher> provider2) {
        return new ForceUpdateObservability_Factory(provider, provider2);
    }

    public static ForceUpdateObservability newInstance(MetricsUseCase metricsUseCase, CoroutineDispatcher coroutineDispatcher) {
        return new ForceUpdateObservability(metricsUseCase, coroutineDispatcher);
    }
}
