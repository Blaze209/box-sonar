package io.opentelemetry.api.baggage;

/* JADX INFO: loaded from: classes4.dex */
abstract class ImmutableEntry implements BaggageEntry {
    ImmutableEntry() {
    }

    static ImmutableEntry create(String str, BaggageEntryMetadata baggageEntryMetadata) {
        return new AutoValue_ImmutableEntry(str, baggageEntryMetadata);
    }
}
