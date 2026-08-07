package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.api.trace.SpanKind;

/* JADX INFO: loaded from: classes4.dex */
@FunctionalInterface
public interface SpanKindExtractor<REQUEST> {
    SpanKind extract(REQUEST request);

    static <REQUEST> SpanKindExtractor<REQUEST> alwaysInternal() {
        return new SpanKindExtractor() { // from class: io.opentelemetry.instrumentation.api.instrumenter.SpanKindExtractor$$ExternalSyntheticLambda2
            @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanKindExtractor
            public final SpanKind extract(Object obj) {
                return SpanKind.INTERNAL;
            }
        };
    }

    static <REQUEST> SpanKindExtractor<REQUEST> alwaysClient() {
        return new SpanKindExtractor() { // from class: io.opentelemetry.instrumentation.api.instrumenter.SpanKindExtractor$$ExternalSyntheticLambda3
            @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanKindExtractor
            public final SpanKind extract(Object obj) {
                return SpanKind.CLIENT;
            }
        };
    }

    static <REQUEST> SpanKindExtractor<REQUEST> alwaysServer() {
        return new SpanKindExtractor() { // from class: io.opentelemetry.instrumentation.api.instrumenter.SpanKindExtractor$$ExternalSyntheticLambda0
            @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanKindExtractor
            public final SpanKind extract(Object obj) {
                return SpanKind.SERVER;
            }
        };
    }

    static <REQUEST> SpanKindExtractor<REQUEST> alwaysProducer() {
        return new SpanKindExtractor() { // from class: io.opentelemetry.instrumentation.api.instrumenter.SpanKindExtractor$$ExternalSyntheticLambda1
            @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanKindExtractor
            public final SpanKind extract(Object obj) {
                return SpanKind.PRODUCER;
            }
        };
    }

    static <REQUEST> SpanKindExtractor<REQUEST> alwaysConsumer() {
        return new SpanKindExtractor() { // from class: io.opentelemetry.instrumentation.api.instrumenter.SpanKindExtractor$$ExternalSyntheticLambda4
            @Override // io.opentelemetry.instrumentation.api.instrumenter.SpanKindExtractor
            public final SpanKind extract(Object obj) {
                return SpanKind.CONSUMER;
            }
        };
    }
}
