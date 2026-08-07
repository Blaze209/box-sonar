package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.SpanContext;

/* JADX INFO: loaded from: classes4.dex */
public interface SpanLinksBuilder {
    SpanLinksBuilder addLink(SpanContext spanContext);

    SpanLinksBuilder addLink(SpanContext spanContext, Attributes attributes);
}
