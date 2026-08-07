package com.microsoft.identity.common.java.opentelemetry;

import com.microsoft.identity.common.java.logging.Logger;
import io.opentelemetry.api.internal.ImmutableSpanContext;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.SpanId;
import io.opentelemetry.api.trace.TraceId;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.Scope;

/* JADX INFO: loaded from: classes14.dex */
public class SpanExtension {
    private static final SpanContext INVALID = ImmutableSpanContext.create(TraceId.getInvalid(), SpanId.getInvalid(), new NoopTraceFlags(), new NoopTraceState(), false, false);
    private static final String TAG = "SpanExtension";

    public enum NoopScope implements Scope {
        INSTANCE;

        @Override // io.opentelemetry.context.Scope, java.lang.AutoCloseable
        public void close() {
        }
    }

    public static Span current() {
        try {
            return Span.current();
        } catch (NoSuchMethodError e) {
            Logger.error(TAG + ":getCurrentSpan", e.getMessage(), e);
            return new NoopSpan(INVALID);
        }
    }

    public static Scope makeCurrentSpan(Span span) {
        if (span == null) {
            throw new NullPointerException("span is marked non-null but is null");
        }
        try {
            return span.makeCurrent();
        } catch (AbstractMethodError | Exception e) {
            Logger.error(TAG + ":makeCurrentSpan", e.getMessage(), e);
            return NoopScope.INSTANCE;
        }
    }

    public static Span fromContext(Context context) {
        if (context == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
        try {
            return Span.fromContext(context);
        } catch (Exception | NoSuchMethodError e) {
            Logger.error(TAG + ":fromContext", e.getMessage(), e);
            return new NoopSpan(INVALID);
        }
    }
}
