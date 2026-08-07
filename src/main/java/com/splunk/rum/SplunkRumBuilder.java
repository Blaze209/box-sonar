package com.splunk.rum;

import android.app.Application;
import android.util.Log;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import java.time.Duration;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
public final class SplunkRumBuilder {
    private static final Duration DEFAULT_SLOW_RENDERING_DETECTION_POLL_INTERVAL = Duration.ofSeconds(1);
    String applicationName;
    String beaconEndpoint;
    String deploymentEnvironment;
    Supplier<Map<String, String>> headersSupplier;
    private String realm;
    String rumAccessToken;
    boolean debugEnabled = false;
    boolean diskBufferingEnabled = false;
    boolean reactNativeSupportEnabled = false;
    boolean crashReportingEnabled = true;
    boolean networkMonitorEnabled = true;
    boolean anrDetectionEnabled = true;
    boolean slowRenderingDetectionEnabled = true;
    Duration slowRenderingDetectionPollInterval = DEFAULT_SLOW_RENDERING_DETECTION_POLL_INTERVAL;
    Attributes globalAttributes = Attributes.empty();
    private final SpanFilterBuilder spanFilterBuilder = new SpanFilterBuilder();
    int maxUsageMegabytes = 25;
    boolean sessionBasedSamplerEnabled = false;
    double sessionBasedSamplerRatio = 1.0d;
    boolean gzipCompressionEnabled = true;

    public SplunkRumBuilder setApplicationName(String str) {
        this.applicationName = str;
        return this;
    }

    public SplunkRumBuilder setBeaconEndpoint(String str) {
        if (this.realm != null) {
            Log.w("SplunkRum", "Explicitly setting the beaconEndpoint will override the realm configuration.");
            this.realm = null;
        }
        this.beaconEndpoint = str;
        return this;
    }

    public SplunkRumBuilder setRealm(String str) {
        if (this.beaconEndpoint != null && this.realm == null) {
            Log.w("SplunkRum", "beaconEndpoint has already been set. Realm configuration will be ignored.");
            return this;
        }
        this.beaconEndpoint = "https://rum-ingest." + str + ".signalfx.com/v1/rum";
        this.realm = str;
        return this;
    }

    public SplunkRumBuilder setRumAccessToken(String str) {
        this.rumAccessToken = str;
        return this;
    }

    public SplunkRumBuilder enableDebug() {
        this.debugEnabled = true;
        return this;
    }

    public SplunkRumBuilder enableDiskBuffering() {
        this.diskBufferingEnabled = true;
        return this;
    }

    public SplunkRumBuilder enableReactNativeSupport() {
        this.reactNativeSupportEnabled = true;
        return this;
    }

    public SplunkRumBuilder disableCrashReporting() {
        this.crashReportingEnabled = false;
        return this;
    }

    public SplunkRumBuilder disableNetworkMonitor() {
        this.networkMonitorEnabled = false;
        return this;
    }

    public SplunkRumBuilder disableAnrDetection() {
        this.anrDetectionEnabled = false;
        return this;
    }

    public SplunkRumBuilder disableSlowRenderingDetection() {
        this.slowRenderingDetectionEnabled = false;
        return this;
    }

    public SplunkRumBuilder setSlowRenderingDetectionPollInterval(Duration duration) {
        if (duration.toMillis() <= 0) {
            Log.e("SplunkRum", "invalid slowRenderPollingDuration: " + duration + " is not positive");
            return this;
        }
        this.slowRenderingDetectionPollInterval = duration;
        return this;
    }

    public SplunkRumBuilder setGlobalAttributes(Attributes attributes) {
        if (attributes == null) {
            attributes = Attributes.empty();
        }
        this.globalAttributes = attributes;
        return this;
    }

    public SplunkRumBuilder setDeploymentEnvironment(String str) {
        this.deploymentEnvironment = str;
        return this;
    }

    public SplunkRumBuilder filterSpans(Consumer<SpanFilterBuilder> consumer) {
        consumer.accept(this.spanFilterBuilder);
        return this;
    }

    public SplunkRumBuilder limitDiskUsageMegabytes(int i) {
        this.maxUsageMegabytes = i;
        return this;
    }

    public SplunkRumBuilder enableSessionBasedSampling(double d) {
        if (d < 0.0d) {
            Log.e("SplunkRum", "invalid sessionBasedSamplingRatio: " + d + " must not be negative");
            return this;
        }
        if (d > 1.0d) {
            Log.e("SplunkRum", "invalid sessionBasedSamplingRatio: " + d + " must not be greater than 1.0");
            return this;
        }
        this.sessionBasedSamplerEnabled = true;
        this.sessionBasedSamplerRatio = d;
        return this;
    }

    public SplunkRumBuilder setHeadersSupplier(Supplier<Map<String, String>> supplier) {
        this.headersSupplier = supplier;
        return this;
    }

    public SplunkRumBuilder disableGzipCompression() {
        this.gzipCompressionEnabled = false;
        return this;
    }

    public SplunkRum build(Application application) {
        if (this.rumAccessToken == null || this.beaconEndpoint == null || this.applicationName == null) {
            throw new IllegalStateException("You must provide a rumAccessToken, a realm (or full beaconEndpoint), and an applicationName to create a valid Config instance.");
        }
        return SplunkRum.initialize(this, application, new ConnectionUtil.Factory());
    }

    SpanExporter decorateWithSpanFilter(SpanExporter spanExporter) {
        return this.spanFilterBuilder.build().apply(spanExporter);
    }
}
