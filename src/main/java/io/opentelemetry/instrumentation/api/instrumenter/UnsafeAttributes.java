package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes4.dex */
final class UnsafeAttributes extends HashMap<AttributeKey<?>, Object> implements Attributes, AttributesBuilder {
    private static final long serialVersionUID = 1;

    @Override // io.opentelemetry.api.common.Attributes
    public Map<AttributeKey<?>, Object> asMap() {
        return this;
    }

    UnsafeAttributes() {
    }

    @Override // io.opentelemetry.api.common.Attributes
    public <T> T get(AttributeKey<T> attributeKey) {
        return (T) super.get((Object) attributeKey);
    }

    @Override // io.opentelemetry.api.common.Attributes
    public AttributesBuilder toBuilder() {
        return Attributes.builder().putAll(this);
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public Attributes build() {
        return toBuilder().build();
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public <T> AttributesBuilder put(AttributeKey<Long> attributeKey, int i) {
        return put(attributeKey, Long.valueOf(i));
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public <T> AttributesBuilder put(AttributeKey<T> attributeKey, T t) {
        super.put(attributeKey, t);
        return this;
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public AttributesBuilder putAll(Attributes attributes) {
        attributes.forEach(new BiConsumer() { // from class: io.opentelemetry.instrumentation.api.instrumenter.UnsafeAttributes$$ExternalSyntheticLambda0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                this.f$0.put((AttributeKey) obj, obj2);
            }
        });
        return this;
    }

    @Override // java.util.HashMap, java.util.Map, io.opentelemetry.api.common.Attributes
    public void forEach(BiConsumer<? super AttributeKey<?>, ? super Object> biConsumer) {
        super.forEach(biConsumer);
    }
}
