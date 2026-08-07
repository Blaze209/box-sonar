package com.box.android.data.di;

import com.box.android.data.observability.OpenTelemetryInstrumentation;
import com.box.android.domain.services.ApdexService;
import com.box.android.domain.services.RumService;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class DataProvidesModule_ProvidesApdexServiceFactory implements Factory<ApdexService> {
    private final DataProvidesModule module;
    private final Provider<OpenTelemetryInstrumentation> openTelemetryInstrumentationProvider;
    private final Provider<RumService> rumServiceProvider;

    private DataProvidesModule_ProvidesApdexServiceFactory(DataProvidesModule module, Provider<OpenTelemetryInstrumentation> openTelemetryInstrumentationProvider, Provider<RumService> rumServiceProvider) {
        this.module = module;
        this.openTelemetryInstrumentationProvider = openTelemetryInstrumentationProvider;
        this.rumServiceProvider = rumServiceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ApdexService get() {
        return providesApdexService(this.module, this.openTelemetryInstrumentationProvider.get(), this.rumServiceProvider.get());
    }

    public static DataProvidesModule_ProvidesApdexServiceFactory create(DataProvidesModule module, Provider<OpenTelemetryInstrumentation> openTelemetryInstrumentationProvider, Provider<RumService> rumServiceProvider) {
        return new DataProvidesModule_ProvidesApdexServiceFactory(module, openTelemetryInstrumentationProvider, rumServiceProvider);
    }

    public static ApdexService providesApdexService(DataProvidesModule instance, OpenTelemetryInstrumentation openTelemetryInstrumentation, RumService rumService) {
        return (ApdexService) Preconditions.checkNotNullFromProvides(instance.providesApdexService(openTelemetryInstrumentation, rumService));
    }
}
