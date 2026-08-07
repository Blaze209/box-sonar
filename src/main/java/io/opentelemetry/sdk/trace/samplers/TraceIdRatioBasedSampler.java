package io.opentelemetry.sdk.trace.samplers;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.internal.OtelEncodingUtils;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.trace.data.LinkData;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class TraceIdRatioBasedSampler implements Sampler {
    private final String description;
    private final long idUpperBound;
    private static final SamplingResult POSITIVE_SAMPLING_RESULT = SamplingResult.recordAndSample();
    private static final SamplingResult NEGATIVE_SAMPLING_RESULT = SamplingResult.drop();

    static TraceIdRatioBasedSampler create(double d) {
        long j;
        if (d < 0.0d || d > 1.0d) {
            throw new IllegalArgumentException("ratio must be in range [0.0, 1.0]");
        }
        if (d == 0.0d) {
            j = Long.MIN_VALUE;
        } else {
            j = d == 1.0d ? Long.MAX_VALUE : (long) (9.223372036854776E18d * d);
        }
        return new TraceIdRatioBasedSampler(d, j);
    }

    TraceIdRatioBasedSampler(double d, long j) {
        this.idUpperBound = j;
        this.description = "TraceIdRatioBased{" + decimalFormat(d) + "}";
    }

    @Override // io.opentelemetry.sdk.trace.samplers.Sampler
    public SamplingResult shouldSample(Context context, String str, String str2, SpanKind spanKind, Attributes attributes, List<LinkData> list) {
        if (Math.abs(getTraceIdRandomPart(str)) < this.idUpperBound) {
            return POSITIVE_SAMPLING_RESULT;
        }
        return NEGATIVE_SAMPLING_RESULT;
    }

    @Override // io.opentelemetry.sdk.trace.samplers.Sampler
    public String getDescription() {
        return this.description;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof TraceIdRatioBasedSampler) && this.idUpperBound == ((TraceIdRatioBasedSampler) obj).idUpperBound;
    }

    public int hashCode() {
        return Long.hashCode(this.idUpperBound);
    }

    public String toString() {
        return getDescription();
    }

    long getIdUpperBound() {
        return this.idUpperBound;
    }

    private static long getTraceIdRandomPart(String str) {
        return OtelEncodingUtils.longFromBase16String(str, 16);
    }

    private static String decimalFormat(double d) {
        DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance();
        decimalFormatSymbols.setDecimalSeparator('.');
        return new DecimalFormat("0.000000", decimalFormatSymbols).format(d);
    }
}
