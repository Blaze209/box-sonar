package com.box.android.domain.metrics;

import com.box.android.domain.services.IApdexScoreProvider;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class Gen204DownloadEventLogger_Factory implements Factory<Gen204DownloadEventLogger> {
    private final Provider<IApdexScoreProvider> apdexScoreProvider;
    private final Provider<CoroutineDispatcher> coroutineDispatcherProvider;
    private final Provider<MetricsUseCase> metricsUseCaseProvider;

    private Gen204DownloadEventLogger_Factory(Provider<MetricsUseCase> provider, Provider<CoroutineDispatcher> provider2, Provider<IApdexScoreProvider> provider3) {
        this.metricsUseCaseProvider = provider;
        this.coroutineDispatcherProvider = provider2;
        this.apdexScoreProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Gen204DownloadEventLogger get() {
        return newInstance(this.metricsUseCaseProvider.get(), this.coroutineDispatcherProvider.get(), this.apdexScoreProvider.get());
    }

    public static Gen204DownloadEventLogger_Factory create(Provider<MetricsUseCase> provider, Provider<CoroutineDispatcher> provider2, Provider<IApdexScoreProvider> provider3) {
        return new Gen204DownloadEventLogger_Factory(provider, provider2, provider3);
    }

    public static Gen204DownloadEventLogger newInstance(MetricsUseCase metricsUseCase, CoroutineDispatcher coroutineDispatcher, IApdexScoreProvider iApdexScoreProvider) {
        return new Gen204DownloadEventLogger(metricsUseCase, coroutineDispatcher, iApdexScoreProvider);
    }
}
