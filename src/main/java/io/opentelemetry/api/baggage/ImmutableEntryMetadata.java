package io.opentelemetry.api.baggage;

import io.opentelemetry.api.internal.ValidationUtil;

/* JADX INFO: loaded from: classes4.dex */
abstract class ImmutableEntryMetadata implements BaggageEntryMetadata {
    static final ImmutableEntryMetadata EMPTY = create("");

    @Override // io.opentelemetry.api.baggage.BaggageEntryMetadata
    public abstract String getValue();

    ImmutableEntryMetadata() {
    }

    static ImmutableEntryMetadata create(String str) {
        if (str == null) {
            ValidationUtil.log("metadata is null");
            return EMPTY;
        }
        return new AutoValue_ImmutableEntryMetadata(str);
    }
}
