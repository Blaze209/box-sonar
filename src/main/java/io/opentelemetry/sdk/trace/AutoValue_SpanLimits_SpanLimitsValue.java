package io.opentelemetry.sdk.trace;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_SpanLimits_SpanLimitsValue extends SpanLimits.SpanLimitsValue {
    private final int maxAttributeValueLength;
    private final int maxNumberOfAttributes;
    private final int maxNumberOfAttributesPerEvent;
    private final int maxNumberOfAttributesPerLink;
    private final int maxNumberOfEvents;
    private final int maxNumberOfLinks;

    AutoValue_SpanLimits_SpanLimitsValue(int i, int i2, int i3, int i4, int i5, int i6) {
        this.maxNumberOfAttributes = i;
        this.maxNumberOfEvents = i2;
        this.maxNumberOfLinks = i3;
        this.maxNumberOfAttributesPerEvent = i4;
        this.maxNumberOfAttributesPerLink = i5;
        this.maxAttributeValueLength = i6;
    }

    @Override // io.opentelemetry.sdk.trace.SpanLimits
    public int getMaxNumberOfAttributes() {
        return this.maxNumberOfAttributes;
    }

    @Override // io.opentelemetry.sdk.trace.SpanLimits
    public int getMaxNumberOfEvents() {
        return this.maxNumberOfEvents;
    }

    @Override // io.opentelemetry.sdk.trace.SpanLimits
    public int getMaxNumberOfLinks() {
        return this.maxNumberOfLinks;
    }

    @Override // io.opentelemetry.sdk.trace.SpanLimits
    public int getMaxNumberOfAttributesPerEvent() {
        return this.maxNumberOfAttributesPerEvent;
    }

    @Override // io.opentelemetry.sdk.trace.SpanLimits
    public int getMaxNumberOfAttributesPerLink() {
        return this.maxNumberOfAttributesPerLink;
    }

    @Override // io.opentelemetry.sdk.trace.SpanLimits.SpanLimitsValue, io.opentelemetry.sdk.trace.SpanLimits
    public int getMaxAttributeValueLength() {
        return this.maxAttributeValueLength;
    }

    public String toString() {
        return "SpanLimitsValue{maxNumberOfAttributes=" + this.maxNumberOfAttributes + ", maxNumberOfEvents=" + this.maxNumberOfEvents + ", maxNumberOfLinks=" + this.maxNumberOfLinks + ", maxNumberOfAttributesPerEvent=" + this.maxNumberOfAttributesPerEvent + ", maxNumberOfAttributesPerLink=" + this.maxNumberOfAttributesPerLink + ", maxAttributeValueLength=" + this.maxAttributeValueLength + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SpanLimits.SpanLimitsValue) {
            SpanLimits.SpanLimitsValue spanLimitsValue = (SpanLimits.SpanLimitsValue) obj;
            if (this.maxNumberOfAttributes == spanLimitsValue.getMaxNumberOfAttributes() && this.maxNumberOfEvents == spanLimitsValue.getMaxNumberOfEvents() && this.maxNumberOfLinks == spanLimitsValue.getMaxNumberOfLinks() && this.maxNumberOfAttributesPerEvent == spanLimitsValue.getMaxNumberOfAttributesPerEvent() && this.maxNumberOfAttributesPerLink == spanLimitsValue.getMaxNumberOfAttributesPerLink() && this.maxAttributeValueLength == spanLimitsValue.getMaxAttributeValueLength()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.maxAttributeValueLength ^ ((((((((((this.maxNumberOfAttributes ^ 1000003) * 1000003) ^ this.maxNumberOfEvents) * 1000003) ^ this.maxNumberOfLinks) * 1000003) ^ this.maxNumberOfAttributesPerEvent) * 1000003) ^ this.maxNumberOfAttributesPerLink) * 1000003);
    }
}
