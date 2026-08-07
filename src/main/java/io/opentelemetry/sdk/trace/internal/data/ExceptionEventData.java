package io.opentelemetry.sdk.trace.internal.data;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.trace.SpanLimits;
import io.opentelemetry.sdk.trace.data.EventData;

/* JADX INFO: loaded from: classes4.dex */
public interface ExceptionEventData extends EventData {
    Attributes getAdditionalAttributes();

    Throwable getException();

    static ExceptionEventData create(SpanLimits spanLimits, long j, Throwable th, Attributes attributes) {
        return ImmutableExceptionEventData.create(spanLimits, j, th, attributes);
    }
}
