package io.opentelemetry.rum.internal;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.TraceId;

/* JADX INFO: loaded from: classes4.dex */
enum NoopOpenTelemetryRum implements OpenTelemetryRum {
    INSTANCE;

    @Override // io.opentelemetry.rum.internal.OpenTelemetryRum
    public OpenTelemetry getOpenTelemetry() {
        return OpenTelemetry.noop();
    }

    @Override // io.opentelemetry.rum.internal.OpenTelemetryRum
    public String getRumSessionId() {
        return TraceId.getInvalid();
    }
}
