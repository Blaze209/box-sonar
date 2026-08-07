package io.opentelemetry.api.baggage;

/* JADX INFO: loaded from: classes4.dex */
public interface BaggageEntryMetadata {
    String getValue();

    static BaggageEntryMetadata empty() {
        return ImmutableEntryMetadata.EMPTY;
    }

    static BaggageEntryMetadata create(String str) {
        return ImmutableEntryMetadata.create(str);
    }
}
