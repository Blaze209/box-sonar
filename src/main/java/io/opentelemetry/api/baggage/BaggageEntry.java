package io.opentelemetry.api.baggage;

/* JADX INFO: loaded from: classes4.dex */
public interface BaggageEntry {
    BaggageEntryMetadata getMetadata();

    String getValue();
}
