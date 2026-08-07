package io.opentelemetry.api.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes4.dex */
class ArrayBackedAttributesBuilder implements AttributesBuilder {
    private final List<Object> data;

    ArrayBackedAttributesBuilder() {
        this.data = new ArrayList();
    }

    ArrayBackedAttributesBuilder(List<Object> list) {
        this.data = list;
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public Attributes build() {
        if (this.data.size() == 2 && this.data.get(0) != null) {
            return new ArrayBackedAttributes(this.data.toArray());
        }
        return ArrayBackedAttributes.sortAndFilterToAttributes(this.data.toArray());
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public <T> AttributesBuilder put(AttributeKey<Long> attributeKey, int i) {
        return put(attributeKey, Long.valueOf(i));
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public <T> AttributesBuilder put(AttributeKey<T> attributeKey, T t) {
        if (attributeKey != null && !attributeKey.getKey().isEmpty() && t != null) {
            this.data.add(attributeKey);
            this.data.add(t);
        }
        return this;
    }

    /* JADX INFO: renamed from: lambda$putAll$0$io-opentelemetry-api-common-ArrayBackedAttributesBuilder, reason: not valid java name */
    /* synthetic */ void m14744xff16beb8(AttributeKey attributeKey, Object obj) {
        put((AttributeKey<Object>) attributeKey, obj);
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public AttributesBuilder putAll(Attributes attributes) {
        if (attributes == null) {
            return this;
        }
        attributes.forEach(new BiConsumer() { // from class: io.opentelemetry.api.common.ArrayBackedAttributesBuilder$$ExternalSyntheticLambda1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                this.f$0.m14744xff16beb8((AttributeKey) obj, obj2);
            }
        });
        return this;
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public <T> AttributesBuilder remove(final AttributeKey<T> attributeKey) {
        return (attributeKey == null || attributeKey.getKey().isEmpty()) ? this : removeIf(new Predicate() { // from class: io.opentelemetry.api.common.ArrayBackedAttributesBuilder$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ArrayBackedAttributesBuilder.lambda$remove$1(attributeKey, (AttributeKey) obj);
            }
        });
    }

    static /* synthetic */ boolean lambda$remove$1(AttributeKey attributeKey, AttributeKey attributeKey2) {
        return attributeKey.getKey().equals(attributeKey2.getKey()) && attributeKey.getType().equals(attributeKey2.getType());
    }

    @Override // io.opentelemetry.api.common.AttributesBuilder
    public AttributesBuilder removeIf(Predicate<AttributeKey<?>> predicate) {
        if (predicate != null) {
            for (int i = 0; i < this.data.size() - 1; i += 2) {
                Object obj = this.data.get(i);
                if ((obj instanceof AttributeKey) && predicate.test((AttributeKey) obj)) {
                    this.data.set(i, null);
                    this.data.set(i + 1, null);
                }
            }
        }
        return this;
    }

    static List<Double> toList(double... dArr) {
        Double[] dArr2 = new Double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = Double.valueOf(dArr[i]);
        }
        return Arrays.asList(dArr2);
    }

    static List<Long> toList(long... jArr) {
        Long[] lArr = new Long[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            lArr[i] = Long.valueOf(jArr[i]);
        }
        return Arrays.asList(lArr);
    }

    static List<Boolean> toList(boolean... zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i = 0; i < zArr.length; i++) {
            boolArr[i] = Boolean.valueOf(zArr[i]);
        }
        return Arrays.asList(boolArr);
    }
}
