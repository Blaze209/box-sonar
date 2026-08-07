package io.opentelemetry.api.trace;

import java.util.Map;
import java.util.function.BiConsumer;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface TraceState {
    Map<String, String> asMap();

    void forEach(BiConsumer<String, String> biConsumer);

    @Nullable
    String get(String str);

    boolean isEmpty();

    int size();

    TraceStateBuilder toBuilder();

    static TraceState getDefault() {
        return ArrayBasedTraceStateBuilder.empty();
    }

    static TraceStateBuilder builder() {
        return new ArrayBasedTraceStateBuilder();
    }
}
