package io.opentelemetry.sdk.trace.samplers;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.trace.data.LinkData;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class ParentBasedSampler implements Sampler {
    private final Sampler localParentNotSampled;
    private final Sampler localParentSampled;
    private final Sampler remoteParentNotSampled;
    private final Sampler remoteParentSampled;
    private final Sampler root;

    ParentBasedSampler(Sampler sampler, @Nullable Sampler sampler2, @Nullable Sampler sampler3, @Nullable Sampler sampler4, @Nullable Sampler sampler5) {
        this.root = sampler;
        this.remoteParentSampled = sampler2 == null ? Sampler.alwaysOn() : sampler2;
        this.remoteParentNotSampled = sampler3 == null ? Sampler.alwaysOff() : sampler3;
        this.localParentSampled = sampler4 == null ? Sampler.alwaysOn() : sampler4;
        this.localParentNotSampled = sampler5 == null ? Sampler.alwaysOff() : sampler5;
    }

    @Override // io.opentelemetry.sdk.trace.samplers.Sampler
    public SamplingResult shouldSample(Context context, String str, String str2, SpanKind spanKind, Attributes attributes, List<LinkData> list) {
        SpanContext spanContext = Span.fromContext(context).getSpanContext();
        if (!spanContext.isValid()) {
            return this.root.shouldSample(context, str, str2, spanKind, attributes, list);
        }
        if (spanContext.isRemote()) {
            if (spanContext.isSampled()) {
                return this.remoteParentSampled.shouldSample(context, str, str2, spanKind, attributes, list);
            }
            return this.remoteParentNotSampled.shouldSample(context, str, str2, spanKind, attributes, list);
        }
        if (spanContext.isSampled()) {
            return this.localParentSampled.shouldSample(context, str, str2, spanKind, attributes, list);
        }
        return this.localParentNotSampled.shouldSample(context, str, str2, spanKind, attributes, list);
    }

    @Override // io.opentelemetry.sdk.trace.samplers.Sampler
    public String getDescription() {
        return String.format("ParentBased{root:%s,remoteParentSampled:%s,remoteParentNotSampled:%s,localParentSampled:%s,localParentNotSampled:%s}", this.root.getDescription(), this.remoteParentSampled.getDescription(), this.remoteParentNotSampled.getDescription(), this.localParentSampled.getDescription(), this.localParentNotSampled.getDescription());
    }

    public String toString() {
        return getDescription();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParentBasedSampler)) {
            return false;
        }
        ParentBasedSampler parentBasedSampler = (ParentBasedSampler) obj;
        return this.root.equals(parentBasedSampler.root) && this.remoteParentSampled.equals(parentBasedSampler.remoteParentSampled) && this.remoteParentNotSampled.equals(parentBasedSampler.remoteParentNotSampled) && this.localParentSampled.equals(parentBasedSampler.localParentSampled) && this.localParentNotSampled.equals(parentBasedSampler.localParentNotSampled);
    }

    public int hashCode() {
        return (((((((this.root.hashCode() * 31) + this.remoteParentSampled.hashCode()) * 31) + this.remoteParentNotSampled.hashCode()) * 31) + this.localParentSampled.hashCode()) * 31) + this.localParentNotSampled.hashCode();
    }
}
