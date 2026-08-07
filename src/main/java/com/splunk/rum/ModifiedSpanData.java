package com.splunk.rum;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.trace.data.DelegatingSpanData;
import io.opentelemetry.sdk.trace.data.SpanData;

/* JADX INFO: loaded from: classes3.dex */
final class ModifiedSpanData extends DelegatingSpanData {
    private final Attributes modifiedAttributes;

    ModifiedSpanData(SpanData spanData, Attributes attributes) {
        super(spanData);
        this.modifiedAttributes = attributes;
    }

    @Override // io.opentelemetry.sdk.trace.data.DelegatingSpanData, io.opentelemetry.sdk.trace.data.SpanData
    public Attributes getAttributes() {
        return this.modifiedAttributes;
    }

    @Override // io.opentelemetry.sdk.trace.data.DelegatingSpanData, io.opentelemetry.sdk.trace.data.SpanData
    public int getTotalAttributeCount() {
        return this.modifiedAttributes.size();
    }
}
