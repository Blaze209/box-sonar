package io.opentelemetry.rum.internal.instrumentation;

import android.app.Application;
import io.opentelemetry.sdk.OpenTelemetrySdk;

/* JADX INFO: loaded from: classes4.dex */
public interface InstrumentedApplication {
    Application getApplication();

    OpenTelemetrySdk getOpenTelemetrySdk();

    void registerApplicationStateListener(ApplicationStateListener applicationStateListener);
}
