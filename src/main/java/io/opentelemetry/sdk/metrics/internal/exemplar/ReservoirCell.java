package io.opentelemetry.sdk.metrics.internal.exemplar;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import io.opentelemetry.sdk.metrics.data.LongExemplarData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableDoubleExemplarData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableLongExemplarData;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
class ReservoirCell {

    @Nullable
    private Attributes attributes;
    private final Clock clock;
    private double doubleValue;
    private long longValue;
    private long recordTime;
    private SpanContext spanContext = SpanContext.getInvalid();

    ReservoirCell(Clock clock) {
        this.clock = clock;
    }

    synchronized void recordLongMeasurement(long j, Attributes attributes, Context context) {
        this.longValue = j;
        offerMeasurement(attributes, context);
    }

    synchronized void recordDoubleMeasurement(double d, Attributes attributes, Context context) {
        this.doubleValue = d;
        offerMeasurement(attributes, context);
    }

    private void offerMeasurement(Attributes attributes, Context context) {
        this.attributes = attributes;
        this.recordTime = this.clock.now();
        Span spanFromContext = Span.fromContext(context);
        if (spanFromContext.getSpanContext().isValid()) {
            this.spanContext = spanFromContext.getSpanContext();
        }
    }

    @Nullable
    synchronized LongExemplarData getAndResetLong(Attributes attributes) {
        Attributes attributes2 = this.attributes;
        if (attributes2 == null) {
            return null;
        }
        LongExemplarData longExemplarDataCreate = ImmutableLongExemplarData.create(filtered(attributes2, attributes), this.recordTime, this.spanContext, this.longValue);
        reset();
        return longExemplarDataCreate;
    }

    @Nullable
    synchronized DoubleExemplarData getAndResetDouble(Attributes attributes) {
        Attributes attributes2 = this.attributes;
        if (attributes2 == null) {
            return null;
        }
        DoubleExemplarData doubleExemplarDataCreate = ImmutableDoubleExemplarData.create(filtered(attributes2, attributes), this.recordTime, this.spanContext, this.doubleValue);
        reset();
        return doubleExemplarDataCreate;
    }

    synchronized void reset() {
        this.attributes = null;
        this.longValue = 0L;
        this.doubleValue = 0.0d;
        this.spanContext = SpanContext.getInvalid();
        this.recordTime = 0L;
    }

    private static Attributes filtered(Attributes attributes, Attributes attributes2) {
        if (attributes2.isEmpty()) {
            return attributes;
        }
        final Set<AttributeKey<?>> setKeySet = attributes2.asMap().keySet();
        AttributesBuilder builder = attributes.toBuilder();
        Objects.requireNonNull(setKeySet);
        return builder.removeIf(new Predicate() { // from class: io.opentelemetry.sdk.metrics.internal.exemplar.ReservoirCell$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return setKeySet.contains((AttributeKey) obj);
            }
        }).build();
    }
}
