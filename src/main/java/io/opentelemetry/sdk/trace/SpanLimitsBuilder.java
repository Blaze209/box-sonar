package io.opentelemetry.sdk.trace;

import io.opentelemetry.api.internal.Utils;

/* JADX INFO: loaded from: classes4.dex */
public final class SpanLimitsBuilder {
    private static final int DEFAULT_SPAN_MAX_NUM_ATTRIBUTES = 128;
    private static final int DEFAULT_SPAN_MAX_NUM_ATTRIBUTES_PER_EVENT = 128;
    private static final int DEFAULT_SPAN_MAX_NUM_ATTRIBUTES_PER_LINK = 128;
    private static final int DEFAULT_SPAN_MAX_NUM_EVENTS = 128;
    private static final int DEFAULT_SPAN_MAX_NUM_LINKS = 128;
    private int maxNumAttributes = 128;
    private int maxNumEvents = 128;
    private int maxNumLinks = 128;
    private int maxNumAttributesPerEvent = 128;
    private int maxNumAttributesPerLink = 128;
    private int maxAttributeValueLength = Integer.MAX_VALUE;

    SpanLimitsBuilder() {
    }

    public SpanLimitsBuilder setMaxNumberOfAttributes(int i) {
        Utils.checkArgument(i > 0, "maxNumberOfAttributes must be greater than 0");
        this.maxNumAttributes = i;
        return this;
    }

    public SpanLimitsBuilder setMaxNumberOfEvents(int i) {
        Utils.checkArgument(i > 0, "maxNumberOfEvents must be greater than 0");
        this.maxNumEvents = i;
        return this;
    }

    public SpanLimitsBuilder setMaxNumberOfLinks(int i) {
        Utils.checkArgument(i > 0, "maxNumberOfLinks must be greater than 0");
        this.maxNumLinks = i;
        return this;
    }

    public SpanLimitsBuilder setMaxNumberOfAttributesPerEvent(int i) {
        Utils.checkArgument(i > 0, "maxNumberOfAttributesPerEvent must be greater than 0");
        this.maxNumAttributesPerEvent = i;
        return this;
    }

    public SpanLimitsBuilder setMaxNumberOfAttributesPerLink(int i) {
        Utils.checkArgument(i > 0, "maxNumberOfAttributesPerLink must be greater than 0");
        this.maxNumAttributesPerLink = i;
        return this;
    }

    public SpanLimitsBuilder setMaxAttributeValueLength(int i) {
        Utils.checkArgument(i > -1, "maxAttributeValueLength must be non-negative");
        this.maxAttributeValueLength = i;
        return this;
    }

    public SpanLimits build() {
        return SpanLimits.create(this.maxNumAttributes, this.maxNumEvents, this.maxNumLinks, this.maxNumAttributesPerEvent, this.maxNumAttributesPerLink, this.maxAttributeValueLength);
    }
}
