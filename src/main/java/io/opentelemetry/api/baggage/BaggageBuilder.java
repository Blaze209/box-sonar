package io.opentelemetry.api.baggage;

/* JADX INFO: loaded from: classes4.dex */
public interface BaggageBuilder {
    Baggage build();

    BaggageBuilder put(String str, String str2, BaggageEntryMetadata baggageEntryMetadata);

    BaggageBuilder remove(String str);

    default BaggageBuilder put(String str, String str2) {
        return put(str, str2, BaggageEntryMetadata.empty());
    }
}
