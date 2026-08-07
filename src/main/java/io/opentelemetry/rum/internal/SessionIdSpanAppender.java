package io.opentelemetry.rum.internal;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.trace.ReadWriteSpan;
import io.opentelemetry.sdk.trace.ReadableSpan;
import io.opentelemetry.sdk.trace.SpanProcessor;

/* JADX INFO: loaded from: classes4.dex */
final class SessionIdSpanAppender implements SpanProcessor {
    static final AttributeKey<String> SESSION_ID_KEY = AttributeKey.stringKey("splunk.rumSessionId");
    private final SessionId sessionId;

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public boolean isEndRequired() {
        return false;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public boolean isStartRequired() {
        return true;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public void onEnd(ReadableSpan readableSpan) {
    }

    public SessionIdSpanAppender(SessionId sessionId) {
        this.sessionId = sessionId;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public void onStart(Context context, ReadWriteSpan readWriteSpan) {
        readWriteSpan.setAttribute(SESSION_ID_KEY, this.sessionId.getSessionId());
    }
}
