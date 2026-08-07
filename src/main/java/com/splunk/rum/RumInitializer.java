package com.splunk.rum;

import android.app.Application;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import com.splunk.android.rum.R;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Context;
import io.opentelemetry.exporter.logging.LoggingSpanExporter;
import io.opentelemetry.exporter.zipkin.ZipkinSpanExporter;
import io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor;
import io.opentelemetry.rum.internal.GlobalAttributesSpanAppender;
import io.opentelemetry.rum.internal.OpenTelemetryRum;
import io.opentelemetry.rum.internal.OpenTelemetryRumBuilder;
import io.opentelemetry.rum.internal.instrumentation.InstrumentedApplication;
import io.opentelemetry.rum.internal.instrumentation.anr.AnrDetector;
import io.opentelemetry.rum.internal.instrumentation.crash.CrashReporter;
import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.resources.ResourceBuilder;
import io.opentelemetry.sdk.trace.SdkTracerProviderBuilder;
import io.opentelemetry.sdk.trace.SpanLimits;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import io.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import java.io.File;
import java.net.InetAddress;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.logging.Level;
import zipkin2.reporter.Sender;
import zipkin2.reporter.okhttp3.OkHttpSender;

/* JADX INFO: loaded from: classes3.dex */
class RumInitializer {
    static final int MAX_ATTRIBUTE_LENGTH = 32768;
    private final Application application;
    private final SplunkRumBuilder builder;
    private final List<InitializationEvent> initializationEvents = new ArrayList();
    private final AppStartupTimer startupTimer;
    private final AnchoredClock timingClock;

    static /* synthetic */ InetAddress lambda$getCoreSpanExporter$8() {
        return null;
    }

    RumInitializer(SplunkRumBuilder splunkRumBuilder, Application application, AppStartupTimer appStartupTimer) {
        this.builder = splunkRumBuilder;
        this.application = application;
        this.startupTimer = appStartupTimer;
        this.timingClock = appStartupTimer.startupClock;
    }

    SplunkRum initialize(ConnectionUtil.Factory factory, final Looper looper) {
        final VisibleScreenTracker visibleScreenTracker = new VisibleScreenTracker();
        long jNow = this.timingClock.now();
        OpenTelemetryRumBuilder openTelemetryRumBuilderBuilder = OpenTelemetryRum.builder();
        openTelemetryRumBuilderBuilder.setResource(buildResource(this.builder.applicationName, detectRumVersion()));
        this.initializationEvents.add(new InitializationEvent("resourceInitialized", this.timingClock.now()));
        final ConnectionUtil connectionUtilCreateAndStart = factory.createAndStart(this.application);
        this.initializationEvents.add(new InitializationEvent("connectionUtilInitialized", this.timingClock.now()));
        final GlobalAttributesSpanAppender globalAttributesSpanAppenderCreate = GlobalAttributesSpanAppender.create(this.builder.globalAttributes);
        openTelemetryRumBuilderBuilder.addTracerProviderCustomizer(new BiFunction() { // from class: com.splunk.rum.RumInitializer$$ExternalSyntheticLambda5
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return this.f$0.m14338lambda$initialize$0$comsplunkrumRumInitializer(connectionUtilCreateAndStart, visibleScreenTracker, globalAttributesSpanAppenderCreate, (SdkTracerProviderBuilder) obj, (Application) obj2);
            }
        });
        if (this.builder.anrDetectionEnabled) {
            openTelemetryRumBuilderBuilder.addInstrumentation(new Consumer() { // from class: com.splunk.rum.RumInitializer$$ExternalSyntheticLambda6
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f$0.m14339lambda$initialize$1$comsplunkrumRumInitializer(looper, (InstrumentedApplication) obj);
                }
            });
        }
        if (this.builder.networkMonitorEnabled) {
            openTelemetryRumBuilderBuilder.addInstrumentation(new Consumer() { // from class: com.splunk.rum.RumInitializer$$ExternalSyntheticLambda7
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f$0.m14340lambda$initialize$2$comsplunkrumRumInitializer(connectionUtilCreateAndStart, (InstrumentedApplication) obj);
                }
            });
        }
        openTelemetryRumBuilderBuilder.addInstrumentation(new Consumer() { // from class: com.splunk.rum.RumInitializer$$ExternalSyntheticLambda8
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.m14341lambda$initialize$3$comsplunkrumRumInitializer((InstrumentedApplication) obj);
            }
        });
        openTelemetryRumBuilderBuilder.addInstrumentation(new Consumer() { // from class: com.splunk.rum.RumInitializer$$ExternalSyntheticLambda9
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f$0.m14342lambda$initialize$4$comsplunkrumRumInitializer(visibleScreenTracker, (InstrumentedApplication) obj);
            }
        });
        if (this.builder.crashReportingEnabled) {
            openTelemetryRumBuilderBuilder.addInstrumentation(new Consumer() { // from class: com.splunk.rum.RumInitializer$$ExternalSyntheticLambda10
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f$0.m14343lambda$initialize$5$comsplunkrumRumInitializer((InstrumentedApplication) obj);
                }
            });
        }
        OpenTelemetryRum openTelemetryRumBuild = openTelemetryRumBuilderBuilder.build(this.application);
        recordInitializationSpans(jNow, this.initializationEvents, openTelemetryRumBuild.getOpenTelemetry().getTracer("SplunkRum"));
        return new SplunkRum(openTelemetryRumBuild, globalAttributesSpanAppenderCreate);
    }

    /* JADX INFO: renamed from: lambda$initialize$0$com-splunk-rum-RumInitializer, reason: not valid java name */
    /* synthetic */ SdkTracerProviderBuilder m14338lambda$initialize$0$comsplunkrumRumInitializer(ConnectionUtil connectionUtil, VisibleScreenTracker visibleScreenTracker, GlobalAttributesSpanAppender globalAttributesSpanAppender, SdkTracerProviderBuilder sdkTracerProviderBuilder, Application application) {
        NetworkAttributesAppender networkAttributesAppender = new NetworkAttributesAppender(connectionUtil);
        ScreenAttributesAppender screenAttributesAppender = new ScreenAttributesAppender(visibleScreenTracker);
        this.initializationEvents.add(new InitializationEvent("attributeAppenderInitialized", this.timingClock.now()));
        SpanExporter spanExporterBuildFilteringExporter = buildFilteringExporter(connectionUtil);
        this.initializationEvents.add(new InitializationEvent("exporterInitialized", this.timingClock.now()));
        BatchSpanProcessor batchSpanProcessorBuild = BatchSpanProcessor.builder(spanExporterBuildFilteringExporter).build();
        this.initializationEvents.add(new InitializationEvent("batchSpanProcessorInitialized", this.timingClock.now()));
        sdkTracerProviderBuilder.addSpanProcessor(globalAttributesSpanAppender).addSpanProcessor(networkAttributesAppender).addSpanProcessor(screenAttributesAppender).addSpanProcessor(batchSpanProcessorBuild).setSpanLimits(SpanLimits.builder().setMaxAttributeValueLength(32768).build());
        if (this.builder.sessionBasedSamplerEnabled) {
            sdkTracerProviderBuilder.setSampler(new SessionIdRatioBasedSampler(this.builder.sessionBasedSamplerRatio, new Supplier() { // from class: com.splunk.rum.RumInitializer$$ExternalSyntheticLambda3
                @Override // java.util.function.Supplier
                public final Object get() {
                    return SplunkRum.getInstance();
                }
            }));
        }
        if (this.builder.debugEnabled) {
            sdkTracerProviderBuilder.addSpanProcessor(SimpleSpanProcessor.create(this.builder.decorateWithSpanFilter(LoggingSpanExporter.create())));
            this.initializationEvents.add(new InitializationEvent("debugSpanExporterInitialized", this.timingClock.now()));
        }
        this.initializationEvents.add(new InitializationEvent("tracerProviderInitialized", this.timingClock.now()));
        return sdkTracerProviderBuilder;
    }

    /* JADX INFO: renamed from: lambda$initialize$1$com-splunk-rum-RumInitializer, reason: not valid java name */
    /* synthetic */ void m14339lambda$initialize$1$comsplunkrumRumInitializer(Looper looper, InstrumentedApplication instrumentedApplication) {
        AnrDetector.builder().addAttributesExtractor(AttributesExtractor.constant(SplunkRum.COMPONENT_KEY, "error")).setMainLooper(looper).build().installOn(instrumentedApplication);
        this.initializationEvents.add(new InitializationEvent("anrMonitorInitialized", this.timingClock.now()));
    }

    /* JADX INFO: renamed from: lambda$initialize$2$com-splunk-rum-RumInitializer, reason: not valid java name */
    /* synthetic */ void m14340lambda$initialize$2$comsplunkrumRumInitializer(ConnectionUtil connectionUtil, InstrumentedApplication instrumentedApplication) {
        NetworkMonitor networkMonitor = new NetworkMonitor(connectionUtil);
        networkMonitor.addConnectivityListener(instrumentedApplication.getOpenTelemetrySdk().getTracer("SplunkRum"));
        instrumentedApplication.registerApplicationStateListener(networkMonitor);
        this.initializationEvents.add(new InitializationEvent("networkMonitorInitialized", this.timingClock.now()));
    }

    /* JADX INFO: renamed from: lambda$initialize$3$com-splunk-rum-RumInitializer, reason: not valid java name */
    /* synthetic */ void m14341lambda$initialize$3$comsplunkrumRumInitializer(InstrumentedApplication instrumentedApplication) {
        buildSlowRenderingDetector(instrumentedApplication.getOpenTelemetrySdk().getTracer("SplunkRum")).start(instrumentedApplication.getApplication());
    }

    /* JADX INFO: renamed from: lambda$initialize$4$com-splunk-rum-RumInitializer, reason: not valid java name */
    /* synthetic */ void m14342lambda$initialize$4$comsplunkrumRumInitializer(VisibleScreenTracker visibleScreenTracker, InstrumentedApplication instrumentedApplication) {
        instrumentedApplication.getApplication().registerActivityLifecycleCallbacks(new ActivityCallbacks(instrumentedApplication.getOpenTelemetrySdk().getTracer("SplunkRum"), visibleScreenTracker, this.startupTimer));
        this.initializationEvents.add(new InitializationEvent("activityLifecycleCallbacksInitialized", this.timingClock.now()));
    }

    /* JADX INFO: renamed from: lambda$initialize$5$com-splunk-rum-RumInitializer, reason: not valid java name */
    /* synthetic */ void m14343lambda$initialize$5$comsplunkrumRumInitializer(InstrumentedApplication instrumentedApplication) {
        CrashReporter.builder().addAttributesExtractor(RuntimeDetailsExtractor.create(instrumentedApplication.getApplication().getApplicationContext())).addAttributesExtractor(new CrashComponentExtractor()).build().installOn(instrumentedApplication);
        this.initializationEvents.add(new InitializationEvent("crashReportingInitialized", this.timingClock.now()));
    }

    private SlowRenderingDetector buildSlowRenderingDetector(Tracer tracer) {
        if (!this.builder.slowRenderingDetectionEnabled) {
            Log.w("SplunkRum", "Slow/frozen rendering detection has been disabled by user.");
            return NoOpSlowRenderingDetector.INSTANCE;
        }
        this.initializationEvents.add(new InitializationEvent("slowRenderingDetectorInitialized", this.timingClock.now()));
        return new SlowRenderingDetectorImpl(tracer, this.builder.slowRenderingDetectionPollInterval);
    }

    private String detectRumVersion() {
        try {
            return this.application.getApplicationContext().getResources().getString(R.string.rum_version);
        } catch (Exception unused) {
            return "unknown";
        }
    }

    private void recordInitializationSpans(long j, List<InitializationEvent> list, Tracer tracer) {
        final Span spanStartSpan = tracer.spanBuilder("SplunkRum.initialize").setParent(Context.current().with(this.startupTimer.start(tracer))).setStartTimestamp(j, TimeUnit.NANOSECONDS).setAttribute(SplunkRum.COMPONENT_KEY, "appstart").startSpan();
        spanStartSpan.setAttribute("config_settings", "[debug:" + this.builder.debugEnabled + ",crashReporting:" + this.builder.crashReportingEnabled + ",anrReporting:" + this.builder.anrDetectionEnabled + ",slowRenderingDetector:" + this.builder.slowRenderingDetectionEnabled + ",networkMonitor:" + this.builder.networkMonitorEnabled + "]");
        for (InitializationEvent initializationEvent : list) {
            spanStartSpan.addEvent(initializationEvent.name, initializationEvent.time, TimeUnit.NANOSECONDS);
        }
        final long jNow = this.timingClock.now();
        this.startupTimer.setCompletionCallback(new Runnable() { // from class: com.splunk.rum.RumInitializer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                spanStartSpan.end(jNow, TimeUnit.NANOSECONDS);
            }
        });
    }

    private Resource buildResource(String str, String str2) {
        ResourceBuilder resourceBuilderPut = Resource.getDefault().toBuilder().put(SplunkRum.APP_NAME_KEY, str).put(ResourceAttributes.SERVICE_NAME, str);
        if (this.builder.deploymentEnvironment != null) {
            resourceBuilderPut.put(ResourceAttributes.DEPLOYMENT_ENVIRONMENT, this.builder.deploymentEnvironment);
        }
        return resourceBuilderPut.put(SplunkRum.RUM_VERSION_KEY, str2).put(ResourceAttributes.DEVICE_MODEL_NAME, Build.MODEL).put(ResourceAttributes.DEVICE_MODEL_IDENTIFIER, Build.MODEL).put(ResourceAttributes.OS_NAME, "Android").put(ResourceAttributes.OS_TYPE, ResourceAttributes.OsTypeValues.LINUX).put(ResourceAttributes.OS_VERSION, Build.VERSION.RELEASE).build();
    }

    SpanExporter buildFilteringExporter(ConnectionUtil connectionUtil) {
        SpanExporter spanExporterDecorateWithSpanFilter = this.builder.decorateWithSpanFilter(new SplunkSpanDataModifier(buildExporter(connectionUtil), this.builder.reactNativeSupportEnabled));
        this.initializationEvents.add(new InitializationEvent("zipkin exporter initialized", this.timingClock.now()));
        return spanExporterDecorateWithSpanFilter;
    }

    private SpanExporter buildExporter(ConnectionUtil connectionUtil) {
        if (this.builder.debugEnabled) {
            ZipkinSpanExporter.baseLogger.setLevel(Level.SEVERE);
            this.initializationEvents.add(new InitializationEvent("logger setup complete", this.timingClock.now()));
        }
        if (this.builder.diskBufferingEnabled) {
            return buildStorageBufferingExporter(connectionUtil);
        }
        return buildMemoryBufferingThrottledExporter(connectionUtil);
    }

    private SpanExporter buildStorageBufferingExporter(ConnectionUtil connectionUtil) {
        Sender senderBuildSender = buildSender();
        File spansDirectory = FileUtils.getSpansDirectory(this.application);
        BandwidthTracker bandwidthTracker = new BandwidthTracker();
        DiskToZipkinExporter.builder().connectionUtil(connectionUtil).fileSender(FileSender.builder().sender(senderBuildSender).bandwidthTracker(bandwidthTracker).build()).bandwidthTracker(bandwidthTracker).spanFilesPath(spansDirectory).build().startPolling();
        return getToDiskExporter();
    }

    private String getEndpoint() {
        return this.builder.beaconEndpoint + "?auth=" + this.builder.rumAccessToken;
    }

    private SpanExporter buildMemoryBufferingThrottledExporter(ConnectionUtil connectionUtil) {
        return ThrottlingExporter.newBuilder(new MemoryBufferingExporter(connectionUtil, getCoreSpanExporter(getEndpoint()))).categorizeByAttribute(SplunkRum.COMPONENT_KEY).maxSpansInWindow(100).windowSize(Duration.ofSeconds(30L)).build();
    }

    SpanExporter getToDiskExporter() {
        return new LazyInitSpanExporter(new Supplier() { // from class: com.splunk.rum.RumInitializer$$ExternalSyntheticLambda2
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m14337lambda$getToDiskExporter$7$comsplunkrumRumInitializer();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$getToDiskExporter$7$com-splunk-rum-RumInitializer, reason: not valid java name */
    /* synthetic */ SpanExporter m14337lambda$getToDiskExporter$7$comsplunkrumRumInitializer() {
        return ZipkinWriteToDiskExporterFactory.create(this.application, this.builder.maxUsageMegabytes);
    }

    SpanExporter getCoreSpanExporter(final String str) {
        return new LazyInitSpanExporter(new Supplier() { // from class: com.splunk.rum.RumInitializer$$ExternalSyntheticLambda4
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.f$0.m14336lambda$getCoreSpanExporter$9$comsplunkrumRumInitializer(str);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$getCoreSpanExporter$9$com-splunk-rum-RumInitializer, reason: not valid java name */
    /* synthetic */ SpanExporter m14336lambda$getCoreSpanExporter$9$comsplunkrumRumInitializer(String str) {
        return ZipkinSpanExporter.builder().setEncoder(new CustomZipkinEncoder()).setEndpoint(str).setSender(buildSender()).setLocalIpAddressSupplier(new Supplier() { // from class: com.splunk.rum.RumInitializer$$ExternalSyntheticLambda1
            @Override // java.util.function.Supplier
            public final Object get() {
                return RumInitializer.lambda$getCoreSpanExporter$8();
            }
        }).build();
    }

    Sender buildSender() {
        OkHttpSender.Builder builderCompressionEnabled = OkHttpSender.newBuilder().endpoint(getEndpoint()).compressionEnabled(this.builder.gzipCompressionEnabled);
        if (this.builder.headersSupplier != null) {
            builderCompressionEnabled.clientBuilder().addInterceptor(new CustomHeadersRequestInterceptor(this.builder.headersSupplier));
        }
        return builderCompressionEnabled.build();
    }

    static class InitializationEvent {
        private final String name;
        private final long time;

        private InitializationEvent(String str, long j) {
            this.name = str;
            this.time = j;
        }
    }

    static final class AnchoredClock {
        private final Clock clock;
        private final long epochNanos;
        private final long nanoTime;

        private AnchoredClock(Clock clock, long j, long j2) {
            this.clock = clock;
            this.epochNanos = j;
            this.nanoTime = j2;
        }

        public static AnchoredClock create(Clock clock) {
            return new AnchoredClock(clock, clock.now(), clock.nanoTime());
        }

        long now() {
            return this.epochNanos + (this.clock.nanoTime() - this.nanoTime);
        }
    }

    private static class LazyInitSpanExporter implements SpanExporter {
        private volatile SpanExporter delegate;
        private final Supplier<SpanExporter> s;

        public LazyInitSpanExporter(Supplier<SpanExporter> supplier) {
            this.s = supplier;
        }

        private SpanExporter getDelegate() {
            SpanExporter spanExporter;
            SpanExporter spanExporter2 = this.delegate;
            if (spanExporter2 != null) {
                return spanExporter2;
            }
            synchronized (this) {
                spanExporter = this.delegate;
                if (spanExporter == null) {
                    spanExporter = this.s.get();
                    this.delegate = spanExporter;
                }
            }
            return spanExporter;
        }

        @Override // io.opentelemetry.sdk.trace.export.SpanExporter
        public CompletableResultCode export(Collection<SpanData> collection) {
            return getDelegate().export(collection);
        }

        @Override // io.opentelemetry.sdk.trace.export.SpanExporter
        public CompletableResultCode flush() {
            return getDelegate().flush();
        }

        @Override // io.opentelemetry.sdk.trace.export.SpanExporter
        public CompletableResultCode shutdown() {
            return getDelegate().shutdown();
        }
    }
}
