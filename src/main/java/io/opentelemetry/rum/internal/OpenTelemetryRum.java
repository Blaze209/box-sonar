package io.opentelemetry.rum.internal;

import io.opentelemetry.api.OpenTelemetry;

/* JADX INFO: loaded from: classes4.dex */
public interface OpenTelemetryRum {
    OpenTelemetry getOpenTelemetry();

    String getRumSessionId();

    static OpenTelemetryRumBuilder builder() {
        return new OpenTelemetryRumBuilder();
    }

    static OpenTelemetryRum noop() {
        return NoopOpenTelemetryRum.INSTANCE;
    }
}
