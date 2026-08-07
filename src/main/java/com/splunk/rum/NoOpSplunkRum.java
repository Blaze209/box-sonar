package com.splunk.rum;

import android.webkit.WebView;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.rum.internal.OpenTelemetryRum;
import java.util.function.Consumer;
import okhttp3.Call;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes3.dex */
class NoOpSplunkRum extends SplunkRum {
    static final NoOpSplunkRum INSTANCE = new NoOpSplunkRum();

    @Override // com.splunk.rum.SplunkRum
    public void addRumEvent(String str, Attributes attributes) {
    }

    @Override // com.splunk.rum.SplunkRum
    public void addRumException(Throwable th, Attributes attributes) {
    }

    @Override // com.splunk.rum.SplunkRum
    public Call.Factory createRumOkHttpCallFactory(OkHttpClient okHttpClient) {
        return okHttpClient;
    }

    @Override // com.splunk.rum.SplunkRum
    void flushSpans() {
    }

    @Override // com.splunk.rum.SplunkRum
    public void integrateWithBrowserRum(WebView webView) {
    }

    @Override // com.splunk.rum.SplunkRum
    public void updateGlobalAttributes(Consumer<AttributesBuilder> consumer) {
    }

    private NoOpSplunkRum() {
        super(OpenTelemetryRum.noop(), null);
    }

    @Override // com.splunk.rum.SplunkRum
    public OpenTelemetry getOpenTelemetry() {
        return OpenTelemetry.noop();
    }

    @Override // com.splunk.rum.SplunkRum
    Tracer getTracer() {
        return getOpenTelemetry().getTracer("unused");
    }

    @Override // com.splunk.rum.SplunkRum
    public String getRumSessionId() {
        return "";
    }
}
