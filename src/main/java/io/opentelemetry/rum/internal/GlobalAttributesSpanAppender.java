package io.opentelemetry.rum.internal;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.trace.ReadWriteSpan;
import io.opentelemetry.sdk.trace.ReadableSpan;
import io.opentelemetry.sdk.trace.SpanProcessor;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes4.dex */
public final class GlobalAttributesSpanAppender implements SpanProcessor {
    private final AtomicReference<Attributes> attributes;

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public boolean isEndRequired() {
        return false;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public boolean isStartRequired() {
        return true;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public void onEnd(ReadableSpan readableSpan) {
    }

    public static GlobalAttributesSpanAppender create(Attributes attributes) {
        return new GlobalAttributesSpanAppender(attributes);
    }

    private GlobalAttributesSpanAppender(Attributes attributes) {
        this.attributes = new AtomicReference<>(attributes);
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public void onStart(Context context, ReadWriteSpan readWriteSpan) {
        readWriteSpan.setAllAttributes(this.attributes.get());
    }

    public void update(Consumer<AttributesBuilder> consumer) {
        Attributes attributes;
        AttributesBuilder builder;
        do {
            attributes = (Attributes) Objects.requireNonNull(this.attributes.get());
            builder = attributes.toBuilder();
            consumer.accept(builder);
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.attributes, attributes, builder.build()));
    }
}
