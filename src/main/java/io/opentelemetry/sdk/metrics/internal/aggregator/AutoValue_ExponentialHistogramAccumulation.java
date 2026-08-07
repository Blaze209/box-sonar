package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramBuckets;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_ExponentialHistogramAccumulation extends ExponentialHistogramAccumulation {
    private final List<DoubleExemplarData> getExemplars;
    private final double getMax;
    private final double getMin;
    private final ExponentialHistogramBuckets getNegativeBuckets;
    private final ExponentialHistogramBuckets getPositiveBuckets;
    private final int getScale;
    private final double getSum;
    private final long getZeroCount;
    private final boolean hasMinMax;

    AutoValue_ExponentialHistogramAccumulation(int i, double d, boolean z, double d2, double d3, ExponentialHistogramBuckets exponentialHistogramBuckets, ExponentialHistogramBuckets exponentialHistogramBuckets2, long j, List<DoubleExemplarData> list) {
        this.getScale = i;
        this.getSum = d;
        this.hasMinMax = z;
        this.getMin = d2;
        this.getMax = d3;
        if (exponentialHistogramBuckets == null) {
            throw new NullPointerException("Null getPositiveBuckets");
        }
        this.getPositiveBuckets = exponentialHistogramBuckets;
        if (exponentialHistogramBuckets2 == null) {
            throw new NullPointerException("Null getNegativeBuckets");
        }
        this.getNegativeBuckets = exponentialHistogramBuckets2;
        this.getZeroCount = j;
        if (list == null) {
            throw new NullPointerException("Null getExemplars");
        }
        this.getExemplars = list;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramAccumulation
    int getScale() {
        return this.getScale;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramAccumulation
    double getSum() {
        return this.getSum;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramAccumulation
    boolean hasMinMax() {
        return this.hasMinMax;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramAccumulation
    double getMin() {
        return this.getMin;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramAccumulation
    double getMax() {
        return this.getMax;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramAccumulation
    ExponentialHistogramBuckets getPositiveBuckets() {
        return this.getPositiveBuckets;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramAccumulation
    ExponentialHistogramBuckets getNegativeBuckets() {
        return this.getNegativeBuckets;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramAccumulation
    long getZeroCount() {
        return this.getZeroCount;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.ExponentialHistogramAccumulation
    List<DoubleExemplarData> getExemplars() {
        return this.getExemplars;
    }

    public String toString() {
        return "ExponentialHistogramAccumulation{getScale=" + this.getScale + ", getSum=" + this.getSum + ", hasMinMax=" + this.hasMinMax + ", getMin=" + this.getMin + ", getMax=" + this.getMax + ", getPositiveBuckets=" + this.getPositiveBuckets + ", getNegativeBuckets=" + this.getNegativeBuckets + ", getZeroCount=" + this.getZeroCount + ", getExemplars=" + this.getExemplars + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ExponentialHistogramAccumulation) {
            ExponentialHistogramAccumulation exponentialHistogramAccumulation = (ExponentialHistogramAccumulation) obj;
            if (this.getScale == exponentialHistogramAccumulation.getScale() && Double.doubleToLongBits(this.getSum) == Double.doubleToLongBits(exponentialHistogramAccumulation.getSum()) && this.hasMinMax == exponentialHistogramAccumulation.hasMinMax() && Double.doubleToLongBits(this.getMin) == Double.doubleToLongBits(exponentialHistogramAccumulation.getMin()) && Double.doubleToLongBits(this.getMax) == Double.doubleToLongBits(exponentialHistogramAccumulation.getMax()) && this.getPositiveBuckets.equals(exponentialHistogramAccumulation.getPositiveBuckets()) && this.getNegativeBuckets.equals(exponentialHistogramAccumulation.getNegativeBuckets()) && this.getZeroCount == exponentialHistogramAccumulation.getZeroCount() && this.getExemplars.equals(exponentialHistogramAccumulation.getExemplars())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iDoubleToLongBits = (((((((((((((this.getScale ^ 1000003) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.getSum) >>> 32) ^ Double.doubleToLongBits(this.getSum)))) * 1000003) ^ (this.hasMinMax ? 1231 : 1237)) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.getMin) >>> 32) ^ Double.doubleToLongBits(this.getMin)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.getMax) >>> 32) ^ Double.doubleToLongBits(this.getMax)))) * 1000003) ^ this.getPositiveBuckets.hashCode()) * 1000003) ^ this.getNegativeBuckets.hashCode()) * 1000003;
        long j = this.getZeroCount;
        return this.getExemplars.hashCode() ^ ((iDoubleToLongBits ^ ((int) (j ^ (j >>> 32)))) * 1000003);
    }
}
