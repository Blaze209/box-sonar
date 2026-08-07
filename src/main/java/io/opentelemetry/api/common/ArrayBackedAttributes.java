package io.opentelemetry.api.common;

import io.opentelemetry.api.internal.ImmutableKeyValuePairs;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Function;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class ArrayBackedAttributes extends ImmutableKeyValuePairs<AttributeKey<?>, Object> implements Attributes {
    private static final Comparator<AttributeKey<?>> KEY_COMPARATOR_FOR_CONSTRUCTION = Comparator.comparing(new Function() { // from class: io.opentelemetry.api.common.ArrayBackedAttributes$$ExternalSyntheticLambda0
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return ((AttributeKey) obj).getKey();
        }
    });
    static final Attributes EMPTY = Attributes.builder().build();

    private ArrayBackedAttributes(Object[] objArr, Comparator<AttributeKey<?>> comparator) {
        super(objArr, comparator);
    }

    ArrayBackedAttributes(Object[] objArr) {
        super(objArr);
    }

    @Override // io.opentelemetry.api.common.Attributes
    public AttributesBuilder toBuilder() {
        return new ArrayBackedAttributesBuilder(new ArrayList(data()));
    }

    @Override // io.opentelemetry.api.common.Attributes
    @Nullable
    public <T> T get(AttributeKey<T> attributeKey) {
        return (T) super.get(attributeKey);
    }

    static Attributes sortAndFilterToAttributes(Object... objArr) {
        for (int i = 0; i < objArr.length; i += 2) {
            AttributeKey attributeKey = (AttributeKey) objArr[i];
            if (attributeKey != null && attributeKey.getKey().isEmpty()) {
                objArr[i] = null;
            }
        }
        return new ArrayBackedAttributes(objArr, KEY_COMPARATOR_FOR_CONSTRUCTION);
    }
}
