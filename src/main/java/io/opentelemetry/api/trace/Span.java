package io.opentelemetry.api.trace;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.internal.ValidationUtil;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.ImplicitContextKeyed;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface Span extends ImplicitContextKeyed {
    Span addEvent(String str, Attributes attributes);

    Span addEvent(String str, Attributes attributes, long j, TimeUnit timeUnit);

    void end();

    void end(long j, TimeUnit timeUnit);

    SpanContext getSpanContext();

    boolean isRecording();

    Span recordException(Throwable th, Attributes attributes);

    <T> Span setAttribute(AttributeKey<T> attributeKey, T t);

    Span setStatus(StatusCode statusCode, String str);

    Span updateName(String str);

    static Span current() {
        Span span = (Span) Context.current().get(SpanContextKey.KEY);
        return span == null ? getInvalid() : span;
    }

    static Span fromContext(Context context) {
        if (context == null) {
            ValidationUtil.log("context is null");
            return getInvalid();
        }
        Span span = (Span) context.get(SpanContextKey.KEY);
        return span == null ? getInvalid() : span;
    }

    @Nullable
    static Span fromContextOrNull(Context context) {
        if (context == null) {
            ValidationUtil.log("context is null");
            return null;
        }
        return (Span) context.get(SpanContextKey.KEY);
    }

    static Span getInvalid() {
        return PropagatedSpan.INVALID;
    }

    static Span wrap(SpanContext spanContext) {
        if (spanContext == null) {
            ValidationUtil.log("context is null");
            return getInvalid();
        }
        if (!spanContext.isValid()) {
            return getInvalid();
        }
        return PropagatedSpan.create(spanContext);
    }

    default Span setAttribute(String str, String str2) {
        return setAttribute(AttributeKey.stringKey(str), str2);
    }

    default Span setAttribute(String str, long j) {
        return setAttribute(AttributeKey.longKey(str), Long.valueOf(j));
    }

    default Span setAttribute(String str, double d) {
        return setAttribute(AttributeKey.doubleKey(str), Double.valueOf(d));
    }

    default Span setAttribute(String str, boolean z) {
        return setAttribute(AttributeKey.booleanKey(str), Boolean.valueOf(z));
    }

    default Span setAttribute(AttributeKey<Long> attributeKey, int i) {
        return setAttribute(attributeKey, Long.valueOf(i));
    }

    default Span setAllAttributes(Attributes attributes) {
        if (attributes != null && !attributes.isEmpty()) {
            attributes.forEach(new BiConsumer() { // from class: io.opentelemetry.api.trace.Span$$ExternalSyntheticLambda0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f$0.setAttribute((AttributeKey<Object>) obj, obj2);
                }
            });
        }
        return this;
    }

    default Span addEvent(String str) {
        return addEvent(str, Attributes.empty());
    }

    default Span addEvent(String str, long j, TimeUnit timeUnit) {
        return addEvent(str, Attributes.empty(), j, timeUnit);
    }

    default Span addEvent(String str, Instant instant) {
        if (instant == null) {
            return addEvent(str);
        }
        return addEvent(str, TimeUnit.SECONDS.toNanos(instant.getEpochSecond()) + ((long) instant.getNano()), TimeUnit.NANOSECONDS);
    }

    default Span addEvent(String str, Attributes attributes, Instant instant) {
        if (instant == null) {
            return addEvent(str, attributes);
        }
        return addEvent(str, attributes, TimeUnit.SECONDS.toNanos(instant.getEpochSecond()) + ((long) instant.getNano()), TimeUnit.NANOSECONDS);
    }

    default Span setStatus(StatusCode statusCode) {
        return setStatus(statusCode, "");
    }

    default Span recordException(Throwable th) {
        return recordException(th, Attributes.empty());
    }

    default void end(Instant instant) {
        if (instant == null) {
            end();
        } else {
            end(TimeUnit.SECONDS.toNanos(instant.getEpochSecond()) + ((long) instant.getNano()), TimeUnit.NANOSECONDS);
        }
    }

    @Override // io.opentelemetry.context.ImplicitContextKeyed
    default Context storeInContext(Context context) {
        return context.with(SpanContextKey.KEY, this);
    }
}
