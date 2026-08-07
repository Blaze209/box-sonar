package io.opentelemetry.api.baggage;

import io.opentelemetry.context.Context;
import io.opentelemetry.context.ImplicitContextKeyed;
import java.util.Map;
import java.util.function.BiConsumer;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface Baggage extends ImplicitContextKeyed {
    Map<String, BaggageEntry> asMap();

    void forEach(BiConsumer<? super String, ? super BaggageEntry> biConsumer);

    @Nullable
    String getEntryValue(String str);

    int size();

    BaggageBuilder toBuilder();

    static Baggage empty() {
        return ImmutableBaggage.empty();
    }

    static BaggageBuilder builder() {
        return ImmutableBaggage.builder();
    }

    static Baggage current() {
        return fromContext(Context.current());
    }

    static Baggage fromContext(Context context) {
        Baggage baggage = (Baggage) context.get(BaggageContextKey.KEY);
        return baggage != null ? baggage : empty();
    }

    @Nullable
    static Baggage fromContextOrNull(Context context) {
        return (Baggage) context.get(BaggageContextKey.KEY);
    }

    @Override // io.opentelemetry.context.ImplicitContextKeyed
    default Context storeInContext(Context context) {
        return context.with(BaggageContextKey.KEY, this);
    }

    default boolean isEmpty() {
        return size() == 0;
    }
}
