package io.opentelemetry.sdk;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.metrics.MeterBuilder;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.api.trace.TracerBuilder;
import io.opentelemetry.api.trace.TracerProvider;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.sdk.logs.SdkLoggerProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.trace.SdkTracerProvider;

/* JADX INFO: loaded from: classes4.dex */
public final class OpenTelemetrySdk implements OpenTelemetry {
    private final SdkLoggerProvider loggerProvider;
    private final ObfuscatedMeterProvider meterProvider;
    private final ContextPropagators propagators;
    private final ObfuscatedTracerProvider tracerProvider;

    OpenTelemetrySdk(SdkTracerProvider sdkTracerProvider, SdkMeterProvider sdkMeterProvider, SdkLoggerProvider sdkLoggerProvider, ContextPropagators contextPropagators) {
        this.tracerProvider = new ObfuscatedTracerProvider(sdkTracerProvider);
        this.meterProvider = new ObfuscatedMeterProvider(sdkMeterProvider);
        this.loggerProvider = sdkLoggerProvider;
        this.propagators = contextPropagators;
    }

    public static OpenTelemetrySdkBuilder builder() {
        return new OpenTelemetrySdkBuilder();
    }

    @Override // io.opentelemetry.api.OpenTelemetry
    public TracerProvider getTracerProvider() {
        return this.tracerProvider;
    }

    public SdkTracerProvider getSdkTracerProvider() {
        return this.tracerProvider.unobfuscate();
    }

    @Override // io.opentelemetry.api.OpenTelemetry
    public MeterProvider getMeterProvider() {
        return this.meterProvider;
    }

    public SdkMeterProvider getSdkMeterProvider() {
        return this.meterProvider.unobfuscate();
    }

    public SdkLoggerProvider getSdkLoggerProvider() {
        return this.loggerProvider;
    }

    @Override // io.opentelemetry.api.OpenTelemetry
    public ContextPropagators getPropagators() {
        return this.propagators;
    }

    public String toString() {
        return "OpenTelemetrySdk{tracerProvider=" + this.tracerProvider.unobfuscate() + ", meterProvider=" + this.meterProvider.unobfuscate() + ", loggerProvider=" + this.loggerProvider + ", propagators=" + this.propagators + "}";
    }

    static class ObfuscatedTracerProvider implements TracerProvider {
        private final SdkTracerProvider delegate;

        ObfuscatedTracerProvider(SdkTracerProvider sdkTracerProvider) {
            this.delegate = sdkTracerProvider;
        }

        @Override // io.opentelemetry.api.trace.TracerProvider
        public Tracer get(String str) {
            return this.delegate.get(str);
        }

        @Override // io.opentelemetry.api.trace.TracerProvider
        public Tracer get(String str, String str2) {
            return this.delegate.get(str, str2);
        }

        @Override // io.opentelemetry.api.trace.TracerProvider
        public TracerBuilder tracerBuilder(String str) {
            return this.delegate.tracerBuilder(str);
        }

        public SdkTracerProvider unobfuscate() {
            return this.delegate;
        }
    }

    static class ObfuscatedMeterProvider implements MeterProvider {
        private final SdkMeterProvider delegate;

        ObfuscatedMeterProvider(SdkMeterProvider sdkMeterProvider) {
            this.delegate = sdkMeterProvider;
        }

        @Override // io.opentelemetry.api.metrics.MeterProvider
        public MeterBuilder meterBuilder(String str) {
            return this.delegate.meterBuilder(str);
        }

        public SdkMeterProvider unobfuscate() {
            return this.delegate;
        }
    }
}
