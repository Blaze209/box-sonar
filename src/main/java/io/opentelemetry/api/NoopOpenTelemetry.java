package io.opentelemetry.api;

import io.opentelemetry.api.trace.NoopTracerProvider;
import io.opentelemetry.api.trace.TracerProvider;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.context.propagation.NoopContextPropagators;

/* JADX INFO: loaded from: classes4.dex */
public class NoopOpenTelemetry implements OpenTelemetry {
    @Override // io.opentelemetry.api.OpenTelemetry
    public TracerProvider getTracerProvider() {
        return NoopTracerProvider.getInstance();
    }

    @Override // io.opentelemetry.api.OpenTelemetry
    public ContextPropagators getPropagators() {
        return NoopContextPropagators.getInstance();
    }
}
