package io.opentelemetry.rum.internal.instrumentation.anr;

import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;

/* JADX INFO: loaded from: classes4.dex */
final class StackTraceFormatter implements AttributesExtractor<StackTraceElement[], Void> {
    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public void onEnd(AttributesBuilder attributesBuilder, Context context, StackTraceElement[] stackTraceElementArr, Void r4, Throwable th) {
    }

    StackTraceFormatter() {
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public void onStart(AttributesBuilder attributesBuilder, Context context, StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb.append(stackTraceElement).append("\n");
        }
        attributesBuilder.put(SemanticAttributes.EXCEPTION_STACKTRACE, sb.toString());
    }
}
