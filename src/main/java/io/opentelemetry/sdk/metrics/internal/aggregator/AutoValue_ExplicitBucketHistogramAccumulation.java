package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_ExplicitBucketHistogramAccumulation extends ExplicitBucketHistogramAccumulation {
    private final long[] getCounts;
    private final List<DoubleExemplarData> getExemplars;
    private final double getMax;
    private final double getMin;
    private final double getSum;
    private final boolean hasMinMax;

    AutoValue_ExplicitBucketHistogramAccumulation(double d, boolean z, double d2, double d3, long[] jArr, List<DoubleExemplarData> list) {
        this.getSum = d;
        this.hasMinMax = z;
        this.getMin = d2;
        this.getMax = d3;
        if (jArr == null) {
            throw new NullPointerException("Null getCounts");
        }
        this.getCounts = jArr;
        if (list == null) {
            throw new NullPointerException("Null getExemplars");
        }
        this.getExemplars = list;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExplicitBucketHistogramAccumulation
    double getSum() {
        return this.getSum;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExplicitBucketHistogramAccumulation
    boolean hasMinMax() {
        return this.hasMinMax;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExplicitBucketHistogramAccumulation
    double getMin() {
        return this.getMin;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExplicitBucketHistogramAccumulation
    double getMax() {
        return this.getMax;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExplicitBucketHistogramAccumulation
    long[] getCounts() {
        return this.getCounts;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExplicitBucketHistogramAccumulation
    List<DoubleExemplarData> getExemplars() {
        return this.getExemplars;
    }

    public String toString() {
        return "ExplicitBucketHistogramAccumulation{getSum=" + this.getSum + ", hasMinMax=" + this.hasMinMax + ", getMin=" + this.getMin + ", getMax=" + this.getMax + ", getCounts=" + Arrays.toString(this.getCounts) + ", getExemplars=" + this.getExemplars + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ExplicitBucketHistogramAccumulation) {
            ExplicitBucketHistogramAccumulation explicitBucketHistogramAccumulation = (ExplicitBucketHistogramAccumulation) obj;
            if (Double.doubleToLongBits(this.getSum) == Double.doubleToLongBits(explicitBucketHistogramAccumulation.getSum()) && this.hasMinMax == explicitBucketHistogramAccumulation.hasMinMax() && Double.doubleToLongBits(this.getMin) == Double.doubleToLongBits(explicitBucketHistogramAccumulation.getMin()) && Double.doubleToLongBits(this.getMax) == Double.doubleToLongBits(explicitBucketHistogramAccumulation.getMax())) {
                if (Arrays.equals(this.getCounts, explicitBucketHistogramAccumulation instanceof AutoValue_ExplicitBucketHistogramAccumulation ? ((AutoValue_ExplicitBucketHistogramAccumulation) explicitBucketHistogramAccumulation).getCounts : explicitBucketHistogramAccumulation.getCounts()) && this.getExemplars.equals(explicitBucketHistogramAccumulation.getExemplars())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return this.getExemplars.hashCode() ^ ((((((((((((int) ((Double.doubleToLongBits(this.getSum) >>> 32) ^ Double.doubleToLongBits(this.getSum))) ^ 1000003) * 1000003) ^ (this.hasMinMax ? 1231 : 1237)) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.getMin) >>> 32) ^ Double.doubleToLongBits(this.getMin)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.getMax) >>> 32) ^ Double.doubleToLongBits(this.getMax)))) * 1000003) ^ Arrays.hashCode(this.getCounts)) * 1000003);
    }
}
