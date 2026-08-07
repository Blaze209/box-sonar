package io.opentelemetry.instrumentation.api.instrumenter;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@FunctionalInterface
public interface SpanStatusExtractor<REQUEST, RESPONSE> {
    void extract(SpanStatusBuilder spanStatusBuilder, REQUEST request, @Nullable RESPONSE response, @Nullable Throwable th);

    static <REQUEST, RESPONSE> SpanStatusExtractor<REQUEST, RESPONSE> getDefault() {
        return (SpanStatusExtractor<REQUEST, RESPONSE>) DefaultSpanStatusExtractor.INSTANCE;
    }
}
