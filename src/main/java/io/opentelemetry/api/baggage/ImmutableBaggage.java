package io.opentelemetry.api.baggage;

import io.opentelemetry.api.internal.ImmutableKeyValuePairs;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class ImmutableBaggage extends ImmutableKeyValuePairs<String, BaggageEntry> implements Baggage {
    private static final Baggage EMPTY = new Builder().build();

    private ImmutableBaggage(Object[] objArr) {
        super(objArr, Comparator.naturalOrder());
    }

    static Baggage empty() {
        return EMPTY;
    }

    static BaggageBuilder builder() {
        return new Builder();
    }

    @Override // io.opentelemetry.api.baggage.Baggage
    @Nullable
    public String getEntryValue(String str) {
        BaggageEntry baggageEntry = get(str);
        if (baggageEntry != null) {
            return baggageEntry.getValue();
        }
        return null;
    }

    @Override // io.opentelemetry.api.baggage.Baggage
    public BaggageBuilder toBuilder() {
        return new Builder(new ArrayList(data()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Baggage sortAndFilterToBaggage(Object[] objArr) {
        return new ImmutableBaggage(objArr);
    }

    static class Builder implements BaggageBuilder {
        private final List<Object> data;

        Builder() {
            this.data = new ArrayList();
        }

        Builder(List<Object> list) {
            this.data = list;
        }

        @Override // io.opentelemetry.api.baggage.BaggageBuilder
        public BaggageBuilder put(String str, String str2, BaggageEntryMetadata baggageEntryMetadata) {
            if (str != null && str2 != null && baggageEntryMetadata != null) {
                this.data.add(str);
                this.data.add(ImmutableEntry.create(str2, baggageEntryMetadata));
            }
            return this;
        }

        @Override // io.opentelemetry.api.baggage.BaggageBuilder
        public BaggageBuilder remove(String str) {
            if (str == null) {
                return this;
            }
            this.data.add(str);
            this.data.add(null);
            return this;
        }

        @Override // io.opentelemetry.api.baggage.BaggageBuilder
        public Baggage build() {
            return ImmutableBaggage.sortAndFilterToBaggage(this.data.toArray());
        }
    }
}
