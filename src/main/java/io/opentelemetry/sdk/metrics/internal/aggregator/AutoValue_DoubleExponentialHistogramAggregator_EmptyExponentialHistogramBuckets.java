package io.opentelemetry.sdk.metrics.internal.aggregator;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_DoubleExponentialHistogramAggregator_EmptyExponentialHistogramBuckets extends DoubleExponentialHistogramAggregator.EmptyExponentialHistogramBuckets {
    private final List<Long> bucketCounts;
    private final int offset;
    private final int scale;
    private final long totalCount;

    AutoValue_DoubleExponentialHistogramAggregator_EmptyExponentialHistogramBuckets(int i, int i2, List<Long> list, long j) {
        this.scale = i;
        this.offset = i2;
        if (list == null) {
            throw new NullPointerException("Null bucketCounts");
        }
        this.bucketCounts = list;
        this.totalCount = j;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramBuckets
    public int getScale() {
        return this.scale;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramBuckets
    public int getOffset() {
        return this.offset;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramBuckets
    public List<Long> getBucketCounts() {
        return this.bucketCounts;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramBuckets
    public long getTotalCount() {
        return this.totalCount;
    }

    public String toString() {
        return "EmptyExponentialHistogramBuckets{scale=" + this.scale + ", offset=" + this.offset + ", bucketCounts=" + this.bucketCounts + ", totalCount=" + this.totalCount + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DoubleExponentialHistogramAggregator.EmptyExponentialHistogramBuckets) {
            DoubleExponentialHistogramAggregator.EmptyExponentialHistogramBuckets emptyExponentialHistogramBuckets = (DoubleExponentialHistogramAggregator.EmptyExponentialHistogramBuckets) obj;
            if (this.scale == emptyExponentialHistogramBuckets.getScale() && this.offset == emptyExponentialHistogramBuckets.getOffset() && this.bucketCounts.equals(emptyExponentialHistogramBuckets.getBucketCounts()) && this.totalCount == emptyExponentialHistogramBuckets.getTotalCount()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((((this.scale ^ 1000003) * 1000003) ^ this.offset) * 1000003) ^ this.bucketCounts.hashCode()) * 1000003;
        long j = this.totalCount;
        return ((int) (j ^ (j >>> 32))) ^ iHashCode;
    }
}
