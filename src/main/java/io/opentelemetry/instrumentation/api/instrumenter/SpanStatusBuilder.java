package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.api.trace.StatusCode;

/* JADX INFO: loaded from: classes4.dex */
public interface SpanStatusBuilder {
    SpanStatusBuilder setStatus(StatusCode statusCode, String str);

    default SpanStatusBuilder setStatus(StatusCode statusCode) {
        return setStatus(statusCode, "");
    }
}
