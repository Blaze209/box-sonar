package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.ContextKey;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class LocalRootSpan {
    private static final ContextKey<Span> KEY = ContextKey.named("opentelemetry-traces-local-root-span");

    public static Span current() {
        return fromContext(Context.current());
    }

    public static Span fromContext(Context context) {
        Span spanFromContextOrNull = fromContextOrNull(context);
        return spanFromContextOrNull == null ? Span.getInvalid() : spanFromContextOrNull;
    }

    @Nullable
    public static Span fromContextOrNull(Context context) {
        return (Span) context.get(KEY);
    }

    static boolean isLocalRoot(Context context) {
        SpanContext spanContext = Span.fromContext(context).getSpanContext();
        return !spanContext.isValid() || spanContext.isRemote();
    }

    static Context store(Context context, Span span) {
        return context.with(KEY, span);
    }

    private LocalRootSpan() {
    }
}
