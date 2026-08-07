package io.opentelemetry.sdk.trace.data;

import io.opentelemetry.api.common.Attributes;

/* JADX INFO: loaded from: classes4.dex */
public interface EventData {
    Attributes getAttributes();

    long getEpochNanos();

    String getName();

    int getTotalAttributeCount();

    static EventData create(long j, String str, Attributes attributes) {
        return ImmutableEventData.create(j, str, attributes);
    }

    static EventData create(long j, String str, Attributes attributes, int i) {
        return ImmutableEventData.create(j, str, attributes, i);
    }

    default int getDroppedAttributesCount() {
        return getTotalAttributeCount() - getAttributes().size();
    }
}
