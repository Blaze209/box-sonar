package io.opentelemetry.rum.internal;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.sdk.OpenTelemetrySdk;

/* JADX INFO: loaded from: classes4.dex */
final class OpenTelemetryRumImpl implements OpenTelemetryRum {
    private final OpenTelemetrySdk openTelemetrySdk;
    private final SessionId sessionId;

    OpenTelemetryRumImpl(OpenTelemetrySdk openTelemetrySdk, SessionId sessionId) {
        this.openTelemetrySdk = openTelemetrySdk;
        this.sessionId = sessionId;
    }

    @Override // io.opentelemetry.rum.internal.OpenTelemetryRum
    public OpenTelemetry getOpenTelemetry() {
        return this.openTelemetrySdk;
    }

    @Override // io.opentelemetry.rum.internal.OpenTelemetryRum
    public String getRumSessionId() {
        return this.sessionId.getSessionId();
    }
}
