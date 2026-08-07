package com.box.android.data.observability;

import com.box.android.domain.services.RumService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class ApdexTracker_Factory implements Factory<ApdexTracker> {
    private final Provider<OpenTelemetryInstrumentation> openTelemetryInstrumentationProvider;
    private final Provider<RumService> rumObservabilityProvider;

    private ApdexTracker_Factory(Provider<OpenTelemetryInstrumentation> openTelemetryInstrumentationProvider, Provider<RumService> rumObservabilityProvider) {
        this.openTelemetryInstrumentationProvider = openTelemetryInstrumentationProvider;
        this.rumObservabilityProvider = rumObservabilityProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ApdexTracker get() {
        return newInstance(this.openTelemetryInstrumentationProvider.get(), this.rumObservabilityProvider.get());
    }

    public static ApdexTracker_Factory create(Provider<OpenTelemetryInstrumentation> openTelemetryInstrumentationProvider, Provider<RumService> rumObservabilityProvider) {
        return new ApdexTracker_Factory(openTelemetryInstrumentationProvider, rumObservabilityProvider);
    }

    public static ApdexTracker newInstance(OpenTelemetryInstrumentation openTelemetryInstrumentation, RumService rumObservability) {
        return new ApdexTracker(openTelemetryInstrumentation, rumObservability);
    }
}
