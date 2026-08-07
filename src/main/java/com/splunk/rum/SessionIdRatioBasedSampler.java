package com.splunk.rum;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.trace.data.LinkData;
import io.opentelemetry.sdk.trace.samplers.Sampler;
import io.opentelemetry.sdk.trace.samplers.SamplingResult;
import java.util.List;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
class SessionIdRatioBasedSampler implements Sampler {
    private final Sampler ratioBasedSampler;
    private final Supplier<SplunkRum> splunkRumSupplier;

    SessionIdRatioBasedSampler(double d, Supplier<SplunkRum> supplier) {
        this.splunkRumSupplier = supplier;
        this.ratioBasedSampler = Sampler.traceIdRatioBased(d);
    }

    @Override // io.opentelemetry.sdk.trace.samplers.Sampler
    public SamplingResult shouldSample(Context context, String str, String str2, SpanKind spanKind, Attributes attributes, List<LinkData> list) {
        return this.ratioBasedSampler.shouldSample(context, this.splunkRumSupplier.get().getRumSessionId(), str2, spanKind, attributes, list);
    }

    @Override // io.opentelemetry.sdk.trace.samplers.Sampler
    public String getDescription() {
        return String.format("SessionIdRatioBased{traceIdRatioBased:%s}", this.ratioBasedSampler.getDescription());
    }
}
