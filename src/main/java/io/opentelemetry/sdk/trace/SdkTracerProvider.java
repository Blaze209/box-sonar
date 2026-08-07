package io.opentelemetry.sdk.trace;

import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.api.trace.TracerBuilder;
import io.opentelemetry.api.trace.TracerProvider;
import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.internal.ComponentRegistry;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.samplers.Sampler;
import java.io.Closeable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public final class SdkTracerProvider implements TracerProvider, Closeable {
    static final String DEFAULT_TRACER_NAME = "";
    private static final Logger logger = Logger.getLogger(SdkTracerProvider.class.getName());
    private final TracerSharedState sharedState;
    private final ComponentRegistry<SdkTracer> tracerSdkComponentRegistry = new ComponentRegistry<>(new Function() { // from class: io.opentelemetry.sdk.trace.SdkTracerProvider$$ExternalSyntheticLambda0
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return this.f$0.m14769lambda$new$0$ioopentelemetrysdktraceSdkTracerProvider((InstrumentationScopeInfo) obj);
        }
    });

    public static SdkTracerProviderBuilder builder() {
        return new SdkTracerProviderBuilder();
    }

    SdkTracerProvider(Clock clock, IdGenerator idGenerator, Resource resource, Supplier<SpanLimits> supplier, Sampler sampler, List<SpanProcessor> list) {
        this.sharedState = new TracerSharedState(clock, idGenerator, resource, supplier, sampler, list);
    }

    /* JADX INFO: renamed from: lambda$new$0$io-opentelemetry-sdk-trace-SdkTracerProvider, reason: not valid java name */
    /* synthetic */ SdkTracer m14769lambda$new$0$ioopentelemetrysdktraceSdkTracerProvider(InstrumentationScopeInfo instrumentationScopeInfo) {
        return new SdkTracer(this.sharedState, instrumentationScopeInfo);
    }

    @Override // io.opentelemetry.api.trace.TracerProvider
    public Tracer get(String str) {
        return tracerBuilder(str).build();
    }

    @Override // io.opentelemetry.api.trace.TracerProvider
    public Tracer get(String str, String str2) {
        return tracerBuilder(str).setInstrumentationVersion(str2).build();
    }

    @Override // io.opentelemetry.api.trace.TracerProvider
    public TracerBuilder tracerBuilder(@Nullable String str) {
        if (str == null || str.isEmpty()) {
            logger.fine("Tracer requested without instrumentation scope name.");
            str = "";
        }
        return new SdkTracerBuilder(this.tracerSdkComponentRegistry, str);
    }

    public SpanLimits getSpanLimits() {
        return this.sharedState.getSpanLimits();
    }

    public Sampler getSampler() {
        return this.sharedState.getSampler();
    }

    public CompletableResultCode shutdown() {
        if (this.sharedState.hasBeenShutdown()) {
            logger.log(Level.WARNING, "Calling shutdown() multiple times.");
            return CompletableResultCode.ofSuccess();
        }
        return this.sharedState.shutdown();
    }

    public CompletableResultCode forceFlush() {
        return this.sharedState.getActiveSpanProcessor().forceFlush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }

    public String toString() {
        return "SdkTracerProvider{clock=" + this.sharedState.getClock() + ", idGenerator=" + this.sharedState.getIdGenerator() + ", resource=" + this.sharedState.getResource() + ", spanLimitsSupplier=" + this.sharedState.getSpanLimits() + ", sampler=" + this.sharedState.getSampler() + ", spanProcessor=" + this.sharedState.getActiveSpanProcessor() + AbstractJsonLexerKt.END_OBJ;
    }
}
