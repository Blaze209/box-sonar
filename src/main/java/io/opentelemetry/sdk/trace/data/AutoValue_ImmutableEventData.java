package io.opentelemetry.sdk.trace.data;

import io.opentelemetry.api.common.Attributes;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_ImmutableEventData extends ImmutableEventData {
    private final Attributes attributes;
    private final long epochNanos;
    private final String name;
    private final int totalAttributeCount;

    AutoValue_ImmutableEventData(String str, Attributes attributes, long j, int i) {
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.name = str;
        if (attributes == null) {
            throw new NullPointerException("Null attributes");
        }
        this.attributes = attributes;
        this.epochNanos = j;
        this.totalAttributeCount = i;
    }

    @Override // io.opentelemetry.sdk.trace.data.EventData
    public String getName() {
        return this.name;
    }

    @Override // io.opentelemetry.sdk.trace.data.EventData
    public Attributes getAttributes() {
        return this.attributes;
    }

    @Override // io.opentelemetry.sdk.trace.data.EventData
    public long getEpochNanos() {
        return this.epochNanos;
    }

    @Override // io.opentelemetry.sdk.trace.data.EventData
    public int getTotalAttributeCount() {
        return this.totalAttributeCount;
    }

    public String toString() {
        return "ImmutableEventData{name=" + this.name + ", attributes=" + this.attributes + ", epochNanos=" + this.epochNanos + ", totalAttributeCount=" + this.totalAttributeCount + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableEventData) {
            ImmutableEventData immutableEventData = (ImmutableEventData) obj;
            if (this.name.equals(immutableEventData.getName()) && this.attributes.equals(immutableEventData.getAttributes()) && this.epochNanos == immutableEventData.getEpochNanos() && this.totalAttributeCount == immutableEventData.getTotalAttributeCount()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((this.name.hashCode() ^ 1000003) * 1000003) ^ this.attributes.hashCode()) * 1000003;
        long j = this.epochNanos;
        return this.totalAttributeCount ^ ((iHashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003);
    }
}
