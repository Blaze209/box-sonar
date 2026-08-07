package io.opentelemetry.api.baggage;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_ImmutableEntryMetadata extends ImmutableEntryMetadata {
    private final String value;

    AutoValue_ImmutableEntryMetadata(String str) {
        if (str == null) {
            throw new NullPointerException("Null value");
        }
        this.value = str;
    }

    @Override // io.opentelemetry.api.baggage.ImmutableEntryMetadata, io.opentelemetry.api.baggage.BaggageEntryMetadata
    public String getValue() {
        return this.value;
    }

    public String toString() {
        return "ImmutableEntryMetadata{value=" + this.value + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableEntryMetadata) {
            return this.value.equals(((ImmutableEntryMetadata) obj).getValue());
        }
        return false;
    }

    public int hashCode() {
        return this.value.hashCode() ^ 1000003;
    }
}
