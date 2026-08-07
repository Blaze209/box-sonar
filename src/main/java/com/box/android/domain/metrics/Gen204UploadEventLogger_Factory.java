package com.box.android.domain.metrics;

import com.box.android.domain.services.IApdexScoreProvider;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class Gen204UploadEventLogger_Factory implements Factory<Gen204UploadEventLogger> {
    private final Provider<IApdexScoreProvider> apdexScoreProvider;
    private final Provider<CoroutineDispatcher> coroutineDispatcherProvider;
    private final Provider<MetricsUseCase> metricsUseCaseProvider;

    private Gen204UploadEventLogger_Factory(Provider<MetricsUseCase> provider, Provider<CoroutineDispatcher> provider2, Provider<IApdexScoreProvider> provider3) {
        this.metricsUseCaseProvider = provider;
        this.coroutineDispatcherProvider = provider2;
        this.apdexScoreProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public Gen204UploadEventLogger get() {
        return newInstance(this.metricsUseCaseProvider.get(), this.coroutineDispatcherProvider.get(), this.apdexScoreProvider.get());
    }

    public static Gen204UploadEventLogger_Factory create(Provider<MetricsUseCase> provider, Provider<CoroutineDispatcher> provider2, Provider<IApdexScoreProvider> provider3) {
        return new Gen204UploadEventLogger_Factory(provider, provider2, provider3);
    }

    public static Gen204UploadEventLogger newInstance(MetricsUseCase metricsUseCase, CoroutineDispatcher coroutineDispatcher, IApdexScoreProvider iApdexScoreProvider) {
        return new Gen204UploadEventLogger(metricsUseCase, coroutineDispatcher, iApdexScoreProvider);
    }
}
