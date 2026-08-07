package com.microsoft.identity.common.java.opentelemetry;

import io.opentelemetry.api.baggage.Baggage;
import io.opentelemetry.api.baggage.BaggageBuilder;
import io.opentelemetry.api.baggage.BaggageEntry;
import io.opentelemetry.api.baggage.BaggageEntryMetadata;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes14.dex */
public class NoopBaggage implements Baggage {
    @Override // io.opentelemetry.api.baggage.Baggage
    public void forEach(BiConsumer<? super String, ? super BaggageEntry> biConsumer) {
    }

    @Override // io.opentelemetry.api.baggage.Baggage
    @Nullable
    public String getEntryValue(String str) {
        return null;
    }

    @Override // io.opentelemetry.api.baggage.Baggage
    public int size() {
        return 0;
    }

    @Override // io.opentelemetry.api.baggage.Baggage
    public Map<String, BaggageEntry> asMap() {
        return new HashMap();
    }

    @Override // io.opentelemetry.api.baggage.Baggage
    public BaggageBuilder toBuilder() {
        return new NoopBaggageBuilder();
    }

    private static class NoopBaggageBuilder implements BaggageBuilder {
        @Override // io.opentelemetry.api.baggage.BaggageBuilder
        public BaggageBuilder put(String str, String str2, BaggageEntryMetadata baggageEntryMetadata) {
            return this;
        }

        @Override // io.opentelemetry.api.baggage.BaggageBuilder
        public BaggageBuilder remove(String str) {
            return this;
        }

        private NoopBaggageBuilder() {
        }

        @Override // io.opentelemetry.api.baggage.BaggageBuilder
        public Baggage build() {
            return new NoopBaggage();
        }
    }
}
