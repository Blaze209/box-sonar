package io.opentelemetry.sdk;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.sdk.logs.SdkLoggerProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class OpenTelemetrySdkBuilder {

    @Nullable
    private SdkLoggerProvider loggerProvider;

    @Nullable
    private SdkMeterProvider meterProvider;
    private ContextPropagators propagators = ContextPropagators.noop();

    @Nullable
    private SdkTracerProvider tracerProvider;

    OpenTelemetrySdkBuilder() {
    }

    public OpenTelemetrySdkBuilder setTracerProvider(SdkTracerProvider sdkTracerProvider) {
        this.tracerProvider = sdkTracerProvider;
        return this;
    }

    public OpenTelemetrySdkBuilder setMeterProvider(SdkMeterProvider sdkMeterProvider) {
        this.meterProvider = sdkMeterProvider;
        return this;
    }

    public OpenTelemetrySdkBuilder setLoggerProvider(SdkLoggerProvider sdkLoggerProvider) {
        this.loggerProvider = sdkLoggerProvider;
        return this;
    }

    public OpenTelemetrySdkBuilder setPropagators(ContextPropagators contextPropagators) {
        this.propagators = contextPropagators;
        return this;
    }

    public OpenTelemetrySdk buildAndRegisterGlobal() {
        OpenTelemetrySdk openTelemetrySdkBuild = build();
        GlobalOpenTelemetry.set(openTelemetrySdkBuild);
        return openTelemetrySdkBuild;
    }

    public OpenTelemetrySdk build() {
        SdkTracerProvider sdkTracerProviderBuild = this.tracerProvider;
        if (sdkTracerProviderBuild == null) {
            sdkTracerProviderBuild = SdkTracerProvider.builder().build();
        }
        SdkMeterProvider sdkMeterProviderBuild = this.meterProvider;
        if (sdkMeterProviderBuild == null) {
            sdkMeterProviderBuild = SdkMeterProvider.builder().build();
        }
        SdkLoggerProvider sdkLoggerProviderBuild = this.loggerProvider;
        if (sdkLoggerProviderBuild == null) {
            sdkLoggerProviderBuild = SdkLoggerProvider.builder().build();
        }
        return new OpenTelemetrySdk(sdkTracerProviderBuild, sdkMeterProviderBuild, sdkLoggerProviderBuild, this.propagators);
    }
}
