package io.opentelemetry.api.trace;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.internal.ValidationUtil;
import io.opentelemetry.context.Context;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class DefaultTracer implements Tracer {
    private static final Tracer INSTANCE = new DefaultTracer();

    static Tracer getInstance() {
        return INSTANCE;
    }

    @Override // io.opentelemetry.api.trace.Tracer
    public SpanBuilder spanBuilder(String str) {
        return NoopSpanBuilder.create();
    }

    private DefaultTracer() {
    }

    private static final class NoopSpanBuilder implements SpanBuilder {

        @Nullable
        private SpanContext spanContext;

        @Override // io.opentelemetry.api.trace.SpanBuilder
        public NoopSpanBuilder addLink(SpanContext spanContext) {
            return this;
        }

        @Override // io.opentelemetry.api.trace.SpanBuilder
        public NoopSpanBuilder addLink(SpanContext spanContext, Attributes attributes) {
            return this;
        }

        @Override // io.opentelemetry.api.trace.SpanBuilder
        public NoopSpanBuilder setAllAttributes(Attributes attributes) {
            return this;
        }

        @Override // io.opentelemetry.api.trace.SpanBuilder
        public <T> NoopSpanBuilder setAttribute(AttributeKey<T> attributeKey, T t) {
            return this;
        }

        @Override // io.opentelemetry.api.trace.SpanBuilder
        public NoopSpanBuilder setAttribute(String str, double d) {
            return this;
        }

        @Override // io.opentelemetry.api.trace.SpanBuilder
        public NoopSpanBuilder setAttribute(String str, long j) {
            return this;
        }

        @Override // io.opentelemetry.api.trace.SpanBuilder
        public NoopSpanBuilder setAttribute(String str, String str2) {
            return this;
        }

        @Override // io.opentelemetry.api.trace.SpanBuilder
        public NoopSpanBuilder setAttribute(String str, boolean z) {
            return this;
        }

        @Override // io.opentelemetry.api.trace.SpanBuilder
        public NoopSpanBuilder setSpanKind(SpanKind spanKind) {
            return this;
        }

        @Override // io.opentelemetry.api.trace.SpanBuilder
        public NoopSpanBuilder setStartTimestamp(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // io.opentelemetry.api.trace.SpanBuilder
        public /* bridge */ /* synthetic */ SpanBuilder setAttribute(AttributeKey attributeKey, Object obj) {
            return setAttribute((AttributeKey<Object>) attributeKey, obj);
        }

        static NoopSpanBuilder create() {
            return new NoopSpanBuilder();
        }

        @Override // io.opentelemetry.api.trace.SpanBuilder
        public Span startSpan() {
            if (this.spanContext == null) {
                this.spanContext = Span.current().getSpanContext();
            }
            return Span.wrap(this.spanContext);
        }

        @Override // io.opentelemetry.api.trace.SpanBuilder
        public NoopSpanBuilder setParent(Context context) {
            if (context == null) {
                ValidationUtil.log("context is null");
                return this;
            }
            this.spanContext = Span.fromContext(context).getSpanContext();
            return this;
        }

        @Override // io.opentelemetry.api.trace.SpanBuilder
        public NoopSpanBuilder setNoParent() {
            this.spanContext = SpanContext.getInvalid();
            return this;
        }

        private NoopSpanBuilder() {
        }
    }
}
