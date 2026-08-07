package io.opentelemetry.rum.internal.instrumentation.crash;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;

/* JADX INFO: loaded from: classes4.dex */
final class CrashDetailsAttributesExtractor implements AttributesExtractor<CrashDetails, Void> {
    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public void onEnd(AttributesBuilder attributesBuilder, Context context, CrashDetails crashDetails, Void r4, Throwable th) {
    }

    CrashDetailsAttributesExtractor() {
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public void onStart(AttributesBuilder attributesBuilder, Context context, CrashDetails crashDetails) {
        attributesBuilder.put(SemanticAttributes.THREAD_ID, Long.valueOf(crashDetails.getThread().getId()));
        attributesBuilder.put(SemanticAttributes.THREAD_NAME, crashDetails.getThread().getName());
        attributesBuilder.put((AttributeKey<boolean>) SemanticAttributes.EXCEPTION_ESCAPED, true);
    }
}
