package com.box.android.domain.metrics;

import com.box.android.domain.usecases.observability.MetricsUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class Gen204MoveCopyEventLogger_Factory implements Factory<Gen204MoveCopyEventLogger> {
    private final Provider<CoroutineDispatcher> coroutineDispatcherProvider;
    private final Provider<MetricsUseCase> metricsUseCaseProvider;

    private Gen204MoveCopyEventLogger_Factory(Provider<MetricsUseCase> provider, Provider<CoroutineDispatcher> provider2) {
        this.metricsUseCaseProvider = provider;
        this.coroutineDispatcherProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Gen204MoveCopyEventLogger get() {
        return newInstance(this.metricsUseCaseProvider.get(), this.coroutineDispatcherProvider.get());
    }

    public static Gen204MoveCopyEventLogger_Factory create(Provider<MetricsUseCase> provider, Provider<CoroutineDispatcher> provider2) {
        return new Gen204MoveCopyEventLogger_Factory(provider, provider2);
    }

    public static Gen204MoveCopyEventLogger newInstance(MetricsUseCase metricsUseCase, CoroutineDispatcher coroutineDispatcher) {
        return new Gen204MoveCopyEventLogger(metricsUseCase, coroutineDispatcher);
    }
}
