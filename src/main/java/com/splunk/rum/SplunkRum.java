package com.splunk.rum;

import android.app.Application;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.WebView;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.instrumentation.okhttp.v3_0.OkHttpTelemetry;
import io.opentelemetry.rum.internal.GlobalAttributesSpanAppender;
import io.opentelemetry.rum.internal.OpenTelemetryRum;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import okhttp3.Call;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes3.dex */
public class SplunkRum {
    static final AttributeKey<String> APP_NAME_KEY;
    static final AttributeKey<Double> BATTERY_PERCENT_KEY;
    static final String COMPONENT_APPSTART = "appstart";
    static final String COMPONENT_CRASH = "crash";
    static final String COMPONENT_ERROR = "error";
    static final AttributeKey<String> COMPONENT_KEY;
    static final String COMPONENT_UI = "ui";
    static final AttributeKey<String> ERROR_MESSAGE_KEY;
    static final AttributeKey<String> ERROR_TYPE_KEY;
    static final AttributeKey<Long> HEAP_FREE_KEY;
    private static SplunkRum INSTANCE = null;
    static final AttributeKey<String> LAST_SCREEN_NAME_KEY;
    static final AttributeKey<String> LINK_SPAN_ID_KEY;
    static final AttributeKey<String> LINK_TRACE_ID_KEY;
    static final AttributeKey<Double> LOCATION_LATITUDE_KEY;
    static final AttributeKey<Double> LOCATION_LONGITUDE_KEY;
    static final String LOG_TAG = "SplunkRum";
    static final String RUM_TRACER_NAME = "SplunkRum";
    static final AttributeKey<String> RUM_VERSION_KEY;
    static final AttributeKey<String> SCREEN_NAME_KEY;
    static final AttributeKey<String> START_TYPE_KEY;
    static final AttributeKey<Long> STORAGE_SPACE_FREE_KEY;
    static final AttributeKey<String> WORKFLOW_NAME_KEY;
    private static final AppStartupTimer startupTimer;
    private final GlobalAttributesSpanAppender globalAttributes;
    private final OpenTelemetryRum openTelemetryRum;

    static {
        AppStartupTimer appStartupTimer = new AppStartupTimer();
        startupTimer = appStartupTimer;
        COMPONENT_KEY = AttributeKey.stringKey("component");
        SCREEN_NAME_KEY = AttributeKey.stringKey("screen.name");
        LAST_SCREEN_NAME_KEY = AttributeKey.stringKey("last.screen.name");
        ERROR_TYPE_KEY = AttributeKey.stringKey("error.type");
        ERROR_MESSAGE_KEY = AttributeKey.stringKey("error.message");
        WORKFLOW_NAME_KEY = AttributeKey.stringKey("workflow.name");
        START_TYPE_KEY = AttributeKey.stringKey("start.type");
        LOCATION_LATITUDE_KEY = AttributeKey.doubleKey("location.lat");
        LOCATION_LONGITUDE_KEY = AttributeKey.doubleKey("location.long");
        STORAGE_SPACE_FREE_KEY = AttributeKey.longKey("storage.free");
        HEAP_FREE_KEY = AttributeKey.longKey("heap.free");
        BATTERY_PERCENT_KEY = AttributeKey.doubleKey("battery.percent");
        LINK_TRACE_ID_KEY = AttributeKey.stringKey("link.traceId");
        LINK_SPAN_ID_KEY = AttributeKey.stringKey("link.spanId");
        APP_NAME_KEY = AttributeKey.stringKey("app");
        RUM_VERSION_KEY = AttributeKey.stringKey("splunk.rum.version");
        appStartupTimer.detectBackgroundStart(new Handler(Looper.getMainLooper()));
    }

    SplunkRum(OpenTelemetryRum openTelemetryRum, GlobalAttributesSpanAppender globalAttributesSpanAppender) {
        this.openTelemetryRum = openTelemetryRum;
        this.globalAttributes = globalAttributesSpanAppender;
    }

    public static SplunkRumBuilder builder() {
        return new SplunkRumBuilder();
    }

    static SplunkRum initialize(SplunkRumBuilder splunkRumBuilder, Application application, ConnectionUtil.Factory factory) {
        if (INSTANCE != null) {
            Log.w("SplunkRum", "Singleton SplunkRum instance has already been initialized.");
            return INSTANCE;
        }
        INSTANCE = new RumInitializer(splunkRumBuilder, application, startupTimer).initialize(factory, Looper.getMainLooper());
        if (splunkRumBuilder.debugEnabled) {
            Log.i("SplunkRum", "Splunk RUM monitoring initialized with session ID: " + INSTANCE.getRumSessionId());
        }
        return INSTANCE;
    }

    public static boolean isInitialized() {
        return INSTANCE != null;
    }

    public static SplunkRum getInstance() {
        SplunkRum splunkRum = INSTANCE;
        if (splunkRum != null) {
            return splunkRum;
        }
        Log.d("SplunkRum", "SplunkRum not initialized. Returning no-op implementation");
        return NoOpSplunkRum.INSTANCE;
    }

    public static SplunkRum noop() {
        return NoOpSplunkRum.INSTANCE;
    }

    public Call.Factory createRumOkHttpCallFactory(OkHttpClient okHttpClient) {
        return createOkHttpTracing().newCallFactory(okHttpClient);
    }

    private OkHttpTelemetry createOkHttpTracing() {
        return OkHttpTelemetry.builder(getOpenTelemetry()).addAttributesExtractor(new RumResponseAttributesExtractor(new ServerTimingHeaderParser())).build();
    }

    public OpenTelemetry getOpenTelemetry() {
        return this.openTelemetryRum.getOpenTelemetry();
    }

    public String getRumSessionId() {
        return this.openTelemetryRum.getRumSessionId();
    }

    public void addRumEvent(String str, Attributes attributes) {
        getTracer().spanBuilder(str).setAllAttributes(attributes).startSpan().end();
    }

    public Span startWorkflow(String str) {
        return getTracer().spanBuilder(str).setAttribute(WORKFLOW_NAME_KEY, str).startSpan();
    }

    public void addRumException(Throwable th) {
        addRumException(th, Attributes.empty());
    }

    public void addRumException(Throwable th, Attributes attributes) {
        getTracer().spanBuilder(th.getClass().getSimpleName()).setAllAttributes(attributes).setAttribute(COMPONENT_KEY, "error").startSpan().recordException(th).end();
    }

    Tracer getTracer() {
        return getOpenTelemetry().getTracer("SplunkRum");
    }

    public <T> void setGlobalAttribute(final AttributeKey<T> attributeKey, final T t) {
        updateGlobalAttributes(new Consumer() { // from class: com.splunk.rum.SplunkRum$$ExternalSyntheticLambda2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                AttributesBuilder attributesBuilder = (AttributesBuilder) obj;
                attributesBuilder.put((AttributeKey<Object>) attributeKey, t);
            }
        });
    }

    public void updateGlobalAttributes(Consumer<AttributesBuilder> consumer) {
        this.globalAttributes.update(consumer);
    }

    static void resetSingletonForTest() {
        INSTANCE = null;
    }

    void flushSpans() {
        OpenTelemetry openTelemetry = getOpenTelemetry();
        if (openTelemetry instanceof OpenTelemetrySdk) {
            ((OpenTelemetrySdk) openTelemetry).getSdkTracerProvider().forceFlush().join(1L, TimeUnit.SECONDS);
        }
    }

    public void integrateWithBrowserRum(WebView webView) {
        webView.addJavascriptInterface(new NativeRumSessionId(this), "SplunkRumNative");
    }

    public void updateLocation(final Location location) {
        if (location == null) {
            updateGlobalAttributes(new Consumer() { // from class: com.splunk.rum.SplunkRum$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((AttributesBuilder) obj).remove(SplunkRum.LOCATION_LATITUDE_KEY).remove(SplunkRum.LOCATION_LONGITUDE_KEY);
                }
            });
        } else {
            updateGlobalAttributes(new Consumer() { // from class: com.splunk.rum.SplunkRum$$ExternalSyntheticLambda1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    Location location2 = location;
                    ((AttributesBuilder) obj).put(SplunkRum.LOCATION_LATITUDE_KEY, Double.valueOf(location2.getLatitude())).put(SplunkRum.LOCATION_LONGITUDE_KEY, Double.valueOf(location2.getLongitude()));
                }
            });
        }
    }
}
