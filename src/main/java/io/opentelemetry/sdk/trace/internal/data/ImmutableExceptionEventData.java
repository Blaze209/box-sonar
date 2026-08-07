package io.opentelemetry.sdk.trace.internal.data;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.sdk.internal.AttributeUtil;
import io.opentelemetry.sdk.trace.SpanLimits;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes4.dex */
abstract class ImmutableExceptionEventData implements ExceptionEventData {
    protected abstract SpanLimits getSpanLimits();

    static ExceptionEventData create(SpanLimits spanLimits, long j, Throwable th, Attributes attributes) {
        return new AutoValue_ImmutableExceptionEventData(j, th, attributes, spanLimits);
    }

    ImmutableExceptionEventData() {
    }

    @Override // io.opentelemetry.sdk.trace.data.EventData
    public final String getName() {
        return "exception";
    }

    @Override // io.opentelemetry.sdk.trace.data.EventData
    public Attributes getAttributes() {
        Throwable exception = getException();
        Attributes additionalAttributes = getAdditionalAttributes();
        AttributesBuilder attributesBuilderBuilder = Attributes.builder();
        attributesBuilderBuilder.put(SemanticAttributes.EXCEPTION_TYPE, exception.getClass().getCanonicalName());
        String message = exception.getMessage();
        if (message != null) {
            attributesBuilderBuilder.put(SemanticAttributes.EXCEPTION_MESSAGE, message);
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            exception.printStackTrace(printWriter);
            printWriter.close();
            attributesBuilderBuilder.put(SemanticAttributes.EXCEPTION_STACKTRACE, stringWriter.toString());
            attributesBuilderBuilder.putAll(additionalAttributes);
            SpanLimits spanLimits = getSpanLimits();
            return AttributeUtil.applyAttributesLimit(attributesBuilderBuilder.build(), spanLimits.getMaxNumberOfAttributesPerEvent(), spanLimits.getMaxAttributeValueLength());
        } catch (Throwable th) {
            try {
                printWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // io.opentelemetry.sdk.trace.data.EventData
    public final int getTotalAttributeCount() {
        return getAttributes().size();
    }
}
