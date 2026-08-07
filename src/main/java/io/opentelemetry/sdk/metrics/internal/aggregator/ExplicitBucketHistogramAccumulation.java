package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
abstract class ExplicitBucketHistogramAccumulation {
    abstract long[] getCounts();

    abstract List<DoubleExemplarData> getExemplars();

    abstract double getMax();

    abstract double getMin();

    abstract double getSum();

    abstract boolean hasMinMax();

    static ExplicitBucketHistogramAccumulation create(double d, boolean z, double d2, double d3, long[] jArr) {
        return create(d, z, d2, d3, jArr, Collections.emptyList());
    }

    static ExplicitBucketHistogramAccumulation create(double d, boolean z, double d2, double d3, long[] jArr, List<DoubleExemplarData> list) {
        return new AutoValue_ExplicitBucketHistogramAccumulation(d, z, d2, d3, jArr, list);
    }

    ExplicitBucketHistogramAccumulation() {
    }
}
