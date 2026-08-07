package io.opentelemetry.rum.internal;

import android.app.Application;
import io.opentelemetry.rum.internal.instrumentation.ApplicationStateListener;
import io.opentelemetry.rum.internal.instrumentation.InstrumentedApplication;
import io.opentelemetry.sdk.OpenTelemetrySdk;

/* JADX INFO: loaded from: classes4.dex */
final class InstrumentedApplicationImpl implements InstrumentedApplication {
    private final Application application;
    private final ApplicationStateWatcher applicationStateWatcher;
    private final OpenTelemetrySdk openTelemetrySdk;

    InstrumentedApplicationImpl(Application application, OpenTelemetrySdk openTelemetrySdk, ApplicationStateWatcher applicationStateWatcher) {
        this.application = application;
        this.openTelemetrySdk = openTelemetrySdk;
        this.applicationStateWatcher = applicationStateWatcher;
    }

    @Override // io.opentelemetry.rum.internal.instrumentation.InstrumentedApplication
    public Application getApplication() {
        return this.application;
    }

    @Override // io.opentelemetry.rum.internal.instrumentation.InstrumentedApplication
    public OpenTelemetrySdk getOpenTelemetrySdk() {
        return this.openTelemetrySdk;
    }

    @Override // io.opentelemetry.rum.internal.instrumentation.InstrumentedApplication
    public void registerApplicationStateListener(ApplicationStateListener applicationStateListener) {
        this.applicationStateWatcher.registerListener(applicationStateListener);
    }
}
