package io.opentelemetry.instrumentation.api.internal;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.AttributesBuilder;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class AttributesExtractorUtil {
    public static <T> void internalSet(AttributesBuilder attributesBuilder, AttributeKey<T> attributeKey, @Nullable T t) {
        if (t != null) {
            attributesBuilder.put(attributeKey, t);
        }
    }

    private AttributesExtractorUtil() {
    }
}
