package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramBuckets;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
abstract class ExponentialHistogramAccumulation {
    abstract List<DoubleExemplarData> getExemplars();

    abstract double getMax();

    abstract double getMin();

    abstract ExponentialHistogramBuckets getNegativeBuckets();

    abstract ExponentialHistogramBuckets getPositiveBuckets();

    abstract int getScale();

    abstract double getSum();

    abstract long getZeroCount();

    abstract boolean hasMinMax();

    ExponentialHistogramAccumulation() {
    }

    static ExponentialHistogramAccumulation create(int i, double d, boolean z, double d2, double d3, ExponentialHistogramBuckets exponentialHistogramBuckets, ExponentialHistogramBuckets exponentialHistogramBuckets2, long j, List<DoubleExemplarData> list) {
        return new AutoValue_ExponentialHistogramAccumulation(i, d, z, d2, d3, exponentialHistogramBuckets, exponentialHistogramBuckets2, j, list);
    }
}
