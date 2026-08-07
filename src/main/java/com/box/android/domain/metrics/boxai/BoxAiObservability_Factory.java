package com.box.android.domain.metrics.boxai;

import com.box.android.domain.usecases.observability.MetricsUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxAiObservability_Factory implements Factory<BoxAiObservability> {
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;
    private final Provider<MetricsUseCase> metricsUseCaseProvider;

    private BoxAiObservability_Factory(Provider<MetricsUseCase> provider, Provider<CoroutineDispatcher> provider2) {
        this.metricsUseCaseProvider = provider;
        this.ioDispatcherProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxAiObservability get() {
        return newInstance(this.metricsUseCaseProvider.get(), this.ioDispatcherProvider.get());
    }

    public static BoxAiObservability_Factory create(Provider<MetricsUseCase> provider, Provider<CoroutineDispatcher> provider2) {
        return new BoxAiObservability_Factory(provider, provider2);
    }

    public static BoxAiObservability newInstance(MetricsUseCase metricsUseCase, CoroutineDispatcher coroutineDispatcher) {
        return new BoxAiObservability(metricsUseCase, coroutineDispatcher);
    }
}
