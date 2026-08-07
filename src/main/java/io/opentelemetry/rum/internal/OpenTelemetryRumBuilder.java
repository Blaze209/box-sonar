package io.opentelemetry.rum.internal;

import android.app.Application;
import io.opentelemetry.rum.internal.instrumentation.InstrumentedApplication;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.logs.SdkLoggerProvider;
import io.opentelemetry.sdk.logs.SdkLoggerProviderBuilder;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.SdkTracerProviderBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes4.dex */
public final class OpenTelemetryRumBuilder {
    private Resource resource = Resource.getDefault();
    private final List<BiFunction<SdkTracerProviderBuilder, Application, SdkTracerProviderBuilder>> tracerProviderCustomizers = new ArrayList();
    private final List<BiFunction<SdkMeterProviderBuilder, Application, SdkMeterProviderBuilder>> meterProviderCustomizers = new ArrayList();
    private final List<BiFunction<SdkLoggerProviderBuilder, Application, SdkLoggerProviderBuilder>> loggerProviderCustomizers = new ArrayList();
    private final List<Consumer<InstrumentedApplication>> instrumentationInstallers = new ArrayList();

    OpenTelemetryRumBuilder() {
    }

    public OpenTelemetryRumBuilder setResource(Resource resource) {
        this.resource = resource;
        return this;
    }

    public OpenTelemetryRumBuilder addTracerProviderCustomizer(BiFunction<SdkTracerProviderBuilder, Application, SdkTracerProviderBuilder> biFunction) {
        this.tracerProviderCustomizers.add(biFunction);
        return this;
    }

    public OpenTelemetryRumBuilder addMeterProviderCustomizer(BiFunction<SdkMeterProviderBuilder, Application, SdkMeterProviderBuilder> biFunction) {
        this.meterProviderCustomizers.add(biFunction);
        return this;
    }

    public OpenTelemetryRumBuilder addLoggerProviderCustomizer(BiFunction<SdkLoggerProviderBuilder, Application, SdkLoggerProviderBuilder> biFunction) {
        this.loggerProviderCustomizers.add(biFunction);
        return this;
    }

    public OpenTelemetryRumBuilder addInstrumentation(Consumer<InstrumentedApplication> consumer) {
        this.instrumentationInstallers.add(consumer);
        return this;
    }

    public OpenTelemetryRum build(Application application) {
        ApplicationStateWatcher applicationStateWatcher = new ApplicationStateWatcher();
        application.registerActivityLifecycleCallbacks(applicationStateWatcher);
        SessionIdTimeoutHandler sessionIdTimeoutHandler = new SessionIdTimeoutHandler();
        SessionId sessionId = new SessionId(sessionIdTimeoutHandler);
        applicationStateWatcher.registerListener(sessionIdTimeoutHandler);
        OpenTelemetrySdk openTelemetrySdkBuild = OpenTelemetrySdk.builder().setTracerProvider(buildTracerProvider(sessionId, application)).setMeterProvider(buildMeterProvider(application)).setLoggerProvider(buildLoggerProvider(application)).build();
        sessionId.setSessionIdChangeListener(new SessionIdChangeTracer(openTelemetrySdkBuild.getTracer("OpenTelemetryRum")));
        InstrumentedApplicationImpl instrumentedApplicationImpl = new InstrumentedApplicationImpl(application, openTelemetrySdkBuild, applicationStateWatcher);
        Iterator<Consumer<InstrumentedApplication>> it = this.instrumentationInstallers.iterator();
        while (it.hasNext()) {
            it.next().accept(instrumentedApplicationImpl);
        }
        return new OpenTelemetryRumImpl(openTelemetrySdkBuild, sessionId);
    }

    private SdkTracerProvider buildTracerProvider(SessionId sessionId, Application application) {
        SdkTracerProviderBuilder sdkTracerProviderBuilderAddSpanProcessor = SdkTracerProvider.builder().setResource(this.resource).addSpanProcessor(new SessionIdSpanAppender(sessionId));
        Iterator<BiFunction<SdkTracerProviderBuilder, Application, SdkTracerProviderBuilder>> it = this.tracerProviderCustomizers.iterator();
        while (it.hasNext()) {
            sdkTracerProviderBuilderAddSpanProcessor = it.next().apply(sdkTracerProviderBuilderAddSpanProcessor, application);
        }
        return sdkTracerProviderBuilderAddSpanProcessor.build();
    }

    private SdkMeterProvider buildMeterProvider(Application application) {
        SdkMeterProviderBuilder resource = SdkMeterProvider.builder().setResource(this.resource);
        Iterator<BiFunction<SdkMeterProviderBuilder, Application, SdkMeterProviderBuilder>> it = this.meterProviderCustomizers.iterator();
        while (it.hasNext()) {
            resource = it.next().apply(resource, application);
        }
        return resource.build();
    }

    private SdkLoggerProvider buildLoggerProvider(Application application) {
        SdkLoggerProviderBuilder resource = SdkLoggerProvider.builder().setResource(this.resource);
        Iterator<BiFunction<SdkLoggerProviderBuilder, Application, SdkLoggerProviderBuilder>> it = this.loggerProviderCustomizers.iterator();
        while (it.hasNext()) {
            resource = it.next().apply(resource, application);
        }
        return resource.build();
    }
}
