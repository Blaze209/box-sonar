package io.opentelemetry.sdk.internal;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import javax.annotation.Nullable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public final class AttributesMap extends HashMap<AttributeKey<?>, Object> implements Attributes {
    private static final long serialVersionUID = -5072696312123632376L;
    private final long capacity;
    private final int lengthLimit;
    private int totalAddedValues = 0;

    private AttributesMap(long j, int i) {
        this.capacity = j;
        this.lengthLimit = i;
    }

    public static AttributesMap create(long j, int i) {
        return new AttributesMap(j, i);
    }

    public <T> void put(AttributeKey<T> attributeKey, T t) {
        this.totalAddedValues++;
        if (size() < this.capacity || containsKey(attributeKey)) {
            super.put(attributeKey, AttributeUtil.applyAttributeLengthLimit(t, this.lengthLimit));
        }
    }

    public int getTotalAddedValues() {
        return this.totalAddedValues;
    }

    @Override // io.opentelemetry.api.common.Attributes
    @Nullable
    public <T> T get(AttributeKey<T> attributeKey) {
        return (T) super.get((Object) attributeKey);
    }

    @Override // io.opentelemetry.api.common.Attributes
    public Map<AttributeKey<?>, Object> asMap() {
        return Collections.unmodifiableMap(this);
    }

    @Override // io.opentelemetry.api.common.Attributes
    public AttributesBuilder toBuilder() {
        return Attributes.builder().putAll(this);
    }

    @Override // java.util.HashMap, java.util.Map, io.opentelemetry.api.common.Attributes
    public void forEach(BiConsumer<? super AttributeKey<?>, ? super Object> biConsumer) {
        super.forEach(biConsumer);
    }

    @Override // java.util.AbstractMap
    public String toString() {
        return "AttributesMap{data=" + super.toString() + ", capacity=" + this.capacity + ", totalAddedValues=" + this.totalAddedValues + AbstractJsonLexerKt.END_OBJ;
    }

    public Attributes immutableCopy() {
        return Attributes.builder().putAll(this).build();
    }
}
