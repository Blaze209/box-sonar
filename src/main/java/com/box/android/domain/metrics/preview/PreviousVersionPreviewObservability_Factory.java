package com.box.android.domain.metrics.preview;

import com.box.android.domain.services.ApdexService;
import com.box.android.domain.services.RumService;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class PreviousVersionPreviewObservability_Factory implements Factory<PreviousVersionPreviewObservability> {
    private final Provider<ApdexService> apdexServiceProvider;
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;
    private final Provider<MetricsUseCase> metricsUseCaseProvider;
    private final Provider<RumService> rumServiceProvider;

    private PreviousVersionPreviewObservability_Factory(Provider<MetricsUseCase> provider, Provider<ApdexService> provider2, Provider<RumService> provider3, Provider<CoroutineDispatcher> provider4) {
        this.metricsUseCaseProvider = provider;
        this.apdexServiceProvider = provider2;
        this.rumServiceProvider = provider3;
        this.ioDispatcherProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PreviousVersionPreviewObservability get() {
        return newInstance(this.metricsUseCaseProvider.get(), this.apdexServiceProvider.get(), this.rumServiceProvider.get(), this.ioDispatcherProvider.get());
    }

    public static PreviousVersionPreviewObservability_Factory create(Provider<MetricsUseCase> provider, Provider<ApdexService> provider2, Provider<RumService> provider3, Provider<CoroutineDispatcher> provider4) {
        return new PreviousVersionPreviewObservability_Factory(provider, provider2, provider3, provider4);
    }

    public static PreviousVersionPreviewObservability newInstance(MetricsUseCase metricsUseCase, ApdexService apdexService, RumService rumService, CoroutineDispatcher coroutineDispatcher) {
        return new PreviousVersionPreviewObservability(metricsUseCase, apdexService, rumService, coroutineDispatcher);
    }
}
