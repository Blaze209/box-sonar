package io.opencensus.trace.samplers;

import io.opencensus.internal.Utils;
import io.opencensus.trace.Sampler;
import io.opencensus.trace.Span;
import io.opencensus.trace.SpanContext;
import io.opencensus.trace.SpanId;
import io.opencensus.trace.TraceId;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
abstract class ProbabilitySampler extends Sampler {
    abstract long getIdUpperBound();

    abstract double getProbability();

    ProbabilitySampler() {
    }

    static ProbabilitySampler create(double d) {
        long j;
        Utils.checkArgument(d >= 0.0d && d <= 1.0d, "probability must be in range [0.0, 1.0]");
        if (d == 0.0d) {
            j = Long.MIN_VALUE;
        } else {
            j = d == 1.0d ? Long.MAX_VALUE : (long) (9.223372036854776E18d * d);
        }
        return new AutoValue_ProbabilitySampler(d, j);
    }

    @Override // io.opencensus.trace.Sampler
    public final boolean shouldSample(@Nullable SpanContext spanContext, @Nullable Boolean bool, TraceId traceId, SpanId spanId, String str, @Nullable List<Span> list) {
        if (spanContext != null && spanContext.getTraceOptions().isSampled()) {
            return true;
        }
        if (list != null) {
            Iterator<Span> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().getContext().getTraceOptions().isSampled()) {
                    return true;
                }
            }
        }
        return Math.abs(traceId.getLowerLong()) < getIdUpperBound();
    }

    @Override // io.opencensus.trace.Sampler
    public final String getDescription() {
        return String.format("ProbabilitySampler{%.6f}", Double.valueOf(getProbability()));
    }
}
