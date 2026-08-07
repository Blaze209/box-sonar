package io.opentelemetry.rum.internal;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.Tracer;

/* JADX INFO: loaded from: classes4.dex */
final class SessionIdChangeTracer implements SessionIdChangeListener {
    static final AttributeKey<String> PREVIOUS_SESSION_ID_KEY = AttributeKey.stringKey("splunk.rum.previous_session_id");
    private final Tracer tracer;

    SessionIdChangeTracer(Tracer tracer) {
        this.tracer = tracer;
    }

    @Override // io.opentelemetry.rum.internal.SessionIdChangeListener
    public void onChange(String str, String str2) {
        this.tracer.spanBuilder("sessionId.change").setAttribute(PREVIOUS_SESSION_ID_KEY, str).startSpan().end();
    }
}
