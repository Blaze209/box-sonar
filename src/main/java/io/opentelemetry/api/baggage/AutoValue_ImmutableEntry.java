package io.opentelemetry.api.baggage;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_ImmutableEntry extends ImmutableEntry {
    private final BaggageEntryMetadata metadata;
    private final String value;

    AutoValue_ImmutableEntry(String str, BaggageEntryMetadata baggageEntryMetadata) {
        if (str == null) {
            throw new NullPointerException("Null value");
        }
        this.value = str;
        if (baggageEntryMetadata == null) {
            throw new NullPointerException("Null metadata");
        }
        this.metadata = baggageEntryMetadata;
    }

    @Override // io.opentelemetry.api.baggage.BaggageEntry
    public String getValue() {
        return this.value;
    }

    @Override // io.opentelemetry.api.baggage.BaggageEntry
    public BaggageEntryMetadata getMetadata() {
        return this.metadata;
    }

    public String toString() {
        return "ImmutableEntry{value=" + this.value + ", metadata=" + this.metadata + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableEntry) {
            ImmutableEntry immutableEntry = (ImmutableEntry) obj;
            if (this.value.equals(immutableEntry.getValue()) && this.metadata.equals(immutableEntry.getMetadata())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.metadata.hashCode() ^ ((this.value.hashCode() ^ 1000003) * 1000003);
    }
}
