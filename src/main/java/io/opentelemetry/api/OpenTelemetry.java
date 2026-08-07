package io.opentelemetry.api;

import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterBuilder;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.api.trace.TracerBuilder;
import io.opentelemetry.api.trace.TracerProvider;
import io.opentelemetry.context.propagation.ContextPropagators;

/* JADX INFO: loaded from: classes4.dex */
public interface OpenTelemetry {
    ContextPropagators getPropagators();

    TracerProvider getTracerProvider();

    static OpenTelemetry noop() {
        return DefaultOpenTelemetry.getNoop();
    }

    static OpenTelemetry propagating(ContextPropagators contextPropagators) {
        return DefaultOpenTelemetry.getPropagating(contextPropagators);
    }

    default Tracer getTracer(String str) {
        return getTracerProvider().get(str);
    }

    default Tracer getTracer(String str, String str2) {
        return getTracerProvider().get(str, str2);
    }

    default TracerBuilder tracerBuilder(String str) {
        return getTracerProvider().tracerBuilder(str);
    }

    default MeterProvider getMeterProvider() {
        return MeterProvider.noop();
    }

    default Meter getMeter(String str) {
        return getMeterProvider().get(str);
    }

    default MeterBuilder meterBuilder(String str) {
        return getMeterProvider().meterBuilder(str);
    }
}
