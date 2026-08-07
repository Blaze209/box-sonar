package com.box.android.data.observability;

import com.box.android.data.service.impl.ApdexScoreProvider;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class OpenTelemetryInstrumentationImpl_Factory implements Factory<OpenTelemetryInstrumentationImpl> {
    private final Provider<ApdexScoreProvider> apdexScoreProvider;
    private final Provider<MetricsUseCase> metricsUseCaseProvider;

    private OpenTelemetryInstrumentationImpl_Factory(Provider<MetricsUseCase> metricsUseCaseProvider, Provider<ApdexScoreProvider> apdexScoreProvider) {
        this.metricsUseCaseProvider = metricsUseCaseProvider;
        this.apdexScoreProvider = apdexScoreProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public OpenTelemetryInstrumentationImpl get() {
        return newInstance(this.metricsUseCaseProvider.get(), this.apdexScoreProvider.get());
    }

    public static OpenTelemetryInstrumentationImpl_Factory create(Provider<MetricsUseCase> metricsUseCaseProvider, Provider<ApdexScoreProvider> apdexScoreProvider) {
        return new OpenTelemetryInstrumentationImpl_Factory(metricsUseCaseProvider, apdexScoreProvider);
    }

    public static OpenTelemetryInstrumentationImpl newInstance(MetricsUseCase metricsUseCase, ApdexScoreProvider apdexScoreProvider) {
        return new OpenTelemetryInstrumentationImpl(metricsUseCase, apdexScoreProvider);
    }
}
