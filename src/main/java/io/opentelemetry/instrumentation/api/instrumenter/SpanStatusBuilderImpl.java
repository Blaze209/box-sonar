package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;

/* JADX INFO: loaded from: classes4.dex */
final class SpanStatusBuilderImpl implements SpanStatusBuilder {
    private final Span span;

    SpanStatusBuilderImpl(Span span) {
        this.span = span;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanStatusBuilder
    public SpanStatusBuilder setStatus(StatusCode statusCode, String str) {
        this.span.setStatus(statusCode, str);
        return this;
    }
}
