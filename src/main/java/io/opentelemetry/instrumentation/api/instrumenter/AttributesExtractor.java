package io.opentelemetry.instrumentation.api.instrumenter;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface AttributesExtractor<REQUEST, RESPONSE> {
    void onEnd(AttributesBuilder attributesBuilder, Context context, REQUEST request, @Nullable RESPONSE response, @Nullable Throwable th);

    void onStart(AttributesBuilder attributesBuilder, Context context, REQUEST request);

    static <REQUEST, RESPONSE, T> AttributesExtractor<REQUEST, RESPONSE> constant(AttributeKey<T> attributeKey, T t) {
        return new ConstantAttributesExtractor((AttributeKey) Objects.requireNonNull(attributeKey, "attributeKey"), Objects.requireNonNull(t, "attributeValue"));
    }
}
