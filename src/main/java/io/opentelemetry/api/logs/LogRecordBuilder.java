package io.opentelemetry.api.logs;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes4.dex */
public interface LogRecordBuilder {
    void emit();

    <T> LogRecordBuilder setAttribute(AttributeKey<T> attributeKey, T t);

    LogRecordBuilder setBody(String str);

    LogRecordBuilder setContext(Context context);

    LogRecordBuilder setEpoch(long j, TimeUnit timeUnit);

    LogRecordBuilder setEpoch(Instant instant);

    LogRecordBuilder setSeverity(Severity severity);

    LogRecordBuilder setSeverityText(String str);

    default LogRecordBuilder setAllAttributes(Attributes attributes) {
        if (attributes != null && !attributes.isEmpty()) {
            attributes.forEach(new BiConsumer() { // from class: io.opentelemetry.api.logs.LogRecordBuilder$$ExternalSyntheticLambda0
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    this.f$0.setAttribute((AttributeKey) obj, obj2);
                }
            });
        }
        return this;
    }
}
