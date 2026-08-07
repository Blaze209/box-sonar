package com.box.android.domain.metrics.msal;

import com.box.android.domain.usecases.observability.MetricsUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class MsalObservability_Factory implements Factory<MsalObservability> {
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;
    private final Provider<MetricsUseCase> metricsUseCaseProvider;

    private MsalObservability_Factory(Provider<MetricsUseCase> provider, Provider<CoroutineDispatcher> provider2) {
        this.metricsUseCaseProvider = provider;
        this.ioDispatcherProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MsalObservability get() {
        return newInstance(this.metricsUseCaseProvider.get(), this.ioDispatcherProvider.get());
    }

    public static MsalObservability_Factory create(Provider<MetricsUseCase> provider, Provider<CoroutineDispatcher> provider2) {
        return new MsalObservability_Factory(provider, provider2);
    }

    public static MsalObservability newInstance(MetricsUseCase metricsUseCase, CoroutineDispatcher coroutineDispatcher) {
        return new MsalObservability(metricsUseCase, coroutineDispatcher);
    }
}
