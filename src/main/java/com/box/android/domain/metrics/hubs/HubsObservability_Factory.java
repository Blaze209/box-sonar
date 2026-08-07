package com.box.android.domain.metrics.hubs;

import com.box.android.domain.services.ApdexService;
import com.box.android.domain.services.RumService;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class HubsObservability_Factory implements Factory<HubsObservability> {
    private final Provider<ApdexService> apdexServiceProvider;
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;
    private final Provider<MetricsUseCase> metricsUseCaseProvider;
    private final Provider<RumService> rumServiceProvider;

    private HubsObservability_Factory(Provider<MetricsUseCase> provider, Provider<RumService> provider2, Provider<ApdexService> provider3, Provider<CoroutineDispatcher> provider4) {
        this.metricsUseCaseProvider = provider;
        this.rumServiceProvider = provider2;
        this.apdexServiceProvider = provider3;
        this.ioDispatcherProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public HubsObservability get() {
        return newInstance(this.metricsUseCaseProvider.get(), this.rumServiceProvider.get(), this.apdexServiceProvider.get(), this.ioDispatcherProvider.get());
    }

    public static HubsObservability_Factory create(Provider<MetricsUseCase> provider, Provider<RumService> provider2, Provider<ApdexService> provider3, Provider<CoroutineDispatcher> provider4) {
        return new HubsObservability_Factory(provider, provider2, provider3, provider4);
    }

    public static HubsObservability newInstance(MetricsUseCase metricsUseCase, RumService rumService, ApdexService apdexService, CoroutineDispatcher coroutineDispatcher) {
        return new HubsObservability(metricsUseCase, rumService, apdexService, coroutineDispatcher);
    }
}
