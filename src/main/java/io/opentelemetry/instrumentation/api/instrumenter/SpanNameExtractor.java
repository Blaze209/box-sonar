package io.opentelemetry.instrumentation.api.instrumenter;

/* JADX INFO: loaded from: classes4.dex */
@FunctionalInterface
public interface SpanNameExtractor<REQUEST> {
    String extract(REQUEST request);
}
