package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.context.Context;

/* JADX INFO: loaded from: classes4.dex */
interface SpanSuppressor {
    boolean shouldSuppress(Context context, SpanKind spanKind);

    Context storeInContext(Context context, SpanKind spanKind, Span span);
}
