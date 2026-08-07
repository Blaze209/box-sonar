package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.SpanBuilder;
import io.opentelemetry.api.trace.SpanContext;

/* JADX INFO: loaded from: classes4.dex */
final class SpanLinksBuilderImpl implements SpanLinksBuilder {
    private final SpanBuilder spanBuilder;

    SpanLinksBuilderImpl(SpanBuilder spanBuilder) {
        this.spanBuilder = spanBuilder;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanLinksBuilder
    public SpanLinksBuilder addLink(SpanContext spanContext) {
        this.spanBuilder.addLink(spanContext);
        return this;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanLinksBuilder
    public SpanLinksBuilder addLink(SpanContext spanContext, Attributes attributes) {
        this.spanBuilder.addLink(spanContext, attributes);
        return this;
    }
}
