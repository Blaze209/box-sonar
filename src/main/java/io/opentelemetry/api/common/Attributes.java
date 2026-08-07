package io.opentelemetry.api.common;

import java.util.Map;
import java.util.function.BiConsumer;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface Attributes {
    Map<AttributeKey<?>, Object> asMap();

    void forEach(BiConsumer<? super AttributeKey<?>, ? super Object> biConsumer);

    @Nullable
    <T> T get(AttributeKey<T> attributeKey);

    boolean isEmpty();

    int size();

    AttributesBuilder toBuilder();

    static Attributes empty() {
        return ArrayBackedAttributes.EMPTY;
    }

    static <T> Attributes of(AttributeKey<T> attributeKey, T t) {
        if (attributeKey == null || attributeKey.getKey().isEmpty() || t == null) {
            return empty();
        }
        return new ArrayBackedAttributes(new Object[]{attributeKey, t});
    }

    static <T, U> Attributes of(AttributeKey<T> attributeKey, T t, AttributeKey<U> attributeKey2, U u) {
        if (attributeKey == null || attributeKey.getKey().isEmpty() || t == null) {
            return of(attributeKey2, u);
        }
        if (attributeKey2 == null || attributeKey2.getKey().isEmpty() || u == null) {
            return of(attributeKey, t);
        }
        if (attributeKey.getKey().equals(attributeKey2.getKey())) {
            return of(attributeKey2, u);
        }
        if (attributeKey.getKey().compareTo(attributeKey2.getKey()) > 0) {
            return new ArrayBackedAttributes(new Object[]{attributeKey2, u, attributeKey, t});
        }
        return new ArrayBackedAttributes(new Object[]{attributeKey, t, attributeKey2, u});
    }

    static <T, U, V> Attributes of(AttributeKey<T> attributeKey, T t, AttributeKey<U> attributeKey2, U u, AttributeKey<V> attributeKey3, V v) {
        return ArrayBackedAttributes.sortAndFilterToAttributes(attributeKey, t, attributeKey2, u, attributeKey3, v);
    }

    static <T, U, V, W> Attributes of(AttributeKey<T> attributeKey, T t, AttributeKey<U> attributeKey2, U u, AttributeKey<V> attributeKey3, V v, AttributeKey<W> attributeKey4, W w) {
        return ArrayBackedAttributes.sortAndFilterToAttributes(attributeKey, t, attributeKey2, u, attributeKey3, v, attributeKey4, w);
    }

    static <T, U, V, W, X> Attributes of(AttributeKey<T> attributeKey, T t, AttributeKey<U> attributeKey2, U u, AttributeKey<V> attributeKey3, V v, AttributeKey<W> attributeKey4, W w, AttributeKey<X> attributeKey5, X x) {
        return ArrayBackedAttributes.sortAndFilterToAttributes(attributeKey, t, attributeKey2, u, attributeKey3, v, attributeKey4, w, attributeKey5, x);
    }

    static <T, U, V, W, X, Y> Attributes of(AttributeKey<T> attributeKey, T t, AttributeKey<U> attributeKey2, U u, AttributeKey<V> attributeKey3, V v, AttributeKey<W> attributeKey4, W w, AttributeKey<X> attributeKey5, X x, AttributeKey<Y> attributeKey6, Y y) {
        return ArrayBackedAttributes.sortAndFilterToAttributes(attributeKey, t, attributeKey2, u, attributeKey3, v, attributeKey4, w, attributeKey5, x, attributeKey6, y);
    }

    static AttributesBuilder builder() {
        return new ArrayBackedAttributesBuilder();
    }
}
