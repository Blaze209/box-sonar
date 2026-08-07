package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.context.Context;

/* JADX INFO: loaded from: classes4.dex */
@FunctionalInterface
public interface SpanLinksExtractor<REQUEST> {
    void extract(SpanLinksBuilder spanLinksBuilder, Context context, REQUEST request);
}
