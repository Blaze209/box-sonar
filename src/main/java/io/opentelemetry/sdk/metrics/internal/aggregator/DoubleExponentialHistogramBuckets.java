package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.sdk.internal.PrimitiveLongList;
import io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramBuckets;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class DoubleExponentialHistogramBuckets implements ExponentialHistogramBuckets {
    private AdaptingCircularBufferCounter counts;
    private ExponentialHistogramIndexer exponentialHistogramIndexer;
    private int scale;
    private long totalCount;

    DoubleExponentialHistogramBuckets(int i, int i2) {
        this.counts = new AdaptingCircularBufferCounter(i2);
        this.scale = i;
        this.exponentialHistogramIndexer = ExponentialHistogramIndexer.get(i);
        this.totalCount = 0L;
    }

    DoubleExponentialHistogramBuckets(DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets) {
        this.counts = new AdaptingCircularBufferCounter(doubleExponentialHistogramBuckets.counts);
        this.scale = doubleExponentialHistogramBuckets.scale;
        this.exponentialHistogramIndexer = doubleExponentialHistogramBuckets.exponentialHistogramIndexer;
        this.totalCount = doubleExponentialHistogramBuckets.totalCount;
    }

    DoubleExponentialHistogramBuckets copy() {
        return new DoubleExponentialHistogramBuckets(this);
    }

    void clear() {
        this.totalCount = 0L;
        this.counts.clear();
    }

    boolean record(double d) {
        if (d == 0.0d) {
            throw new IllegalStateException("Illegal attempted recording of zero at bucket level.");
        }
        boolean zIncrement = this.counts.increment(this.exponentialHistogramIndexer.computeIndex(d), 1L);
        if (zIncrement) {
            this.totalCount++;
        }
        return zIncrement;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramBuckets
    public int getOffset() {
        if (this.counts.isEmpty()) {
            return 0;
        }
        return this.counts.getIndexStart();
    }

    @Override // io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramBuckets
    public List<Long> getBucketCounts() {
        if (this.counts.isEmpty()) {
            return Collections.emptyList();
        }
        int indexEnd = (this.counts.getIndexEnd() - this.counts.getIndexStart()) + 1;
        long[] jArr = new long[indexEnd];
        for (int i = 0; i < indexEnd; i++) {
            AdaptingCircularBufferCounter adaptingCircularBufferCounter = this.counts;
            jArr[i] = adaptingCircularBufferCounter.get(adaptingCircularBufferCounter.getIndexStart() + i);
        }
        return PrimitiveLongList.wrap(jArr);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramBuckets
    public long getTotalCount() {
        return this.totalCount;
    }

    void downscale(int i) {
        if (i == 0) {
            return;
        }
        if (i < 0) {
            throw new IllegalStateException("Cannot downscale by negative amount. Was given " + i + ".");
        }
        if (!this.counts.isEmpty()) {
            AdaptingCircularBufferCounter adaptingCircularBufferCounter = new AdaptingCircularBufferCounter(this.counts);
            adaptingCircularBufferCounter.clear();
            for (int indexStart = this.counts.getIndexStart(); indexStart <= this.counts.getIndexEnd(); indexStart++) {
                long j = this.counts.get(indexStart);
                if (j > 0 && !adaptingCircularBufferCounter.increment(indexStart >> i, j)) {
                    throw new IllegalStateException("Failed to create new downscaled buckets.");
                }
            }
            this.counts = adaptingCircularBufferCounter;
        }
        int i2 = this.scale - i;
        this.scale = i2;
        this.exponentialHistogramIndexer = ExponentialHistogramIndexer.get(i2);
    }

    void mergeInto(DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets) {
        long jMin;
        int iMax;
        if (doubleExponentialHistogramBuckets.counts.isEmpty()) {
            return;
        }
        int iMin = Math.min(this.scale, doubleExponentialHistogramBuckets.scale);
        int i = this.scale - iMin;
        int i2 = doubleExponentialHistogramBuckets.scale - iMin;
        if (this.counts.isEmpty()) {
            jMin = doubleExponentialHistogramBuckets.getOffset() >> i2;
            iMax = doubleExponentialHistogramBuckets.counts.getIndexEnd() >> i2;
        } else {
            jMin = Math.min(getOffset() >> i, doubleExponentialHistogramBuckets.getOffset() >> i2);
            iMax = Math.max(this.counts.getIndexEnd() >> i, doubleExponentialHistogramBuckets.counts.getIndexEnd() >> i2);
        }
        downscale(i + getScaleReduction(jMin, iMax));
        int i3 = doubleExponentialHistogramBuckets.scale - this.scale;
        for (int offset = doubleExponentialHistogramBuckets.getOffset(); offset <= doubleExponentialHistogramBuckets.counts.getIndexEnd(); offset++) {
            if (!this.counts.increment(offset >> i3, doubleExponentialHistogramBuckets.counts.get(offset))) {
                throw new IllegalStateException("Failed to merge exponential histogram buckets.");
            }
        }
        this.totalCount += doubleExponentialHistogramBuckets.totalCount;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramBuckets
    public int getScale() {
        return this.scale;
    }

    int getScaleReduction(double d) {
        long jComputeIndex = this.exponentialHistogramIndexer.computeIndex(d);
        return getScaleReduction(Math.min(jComputeIndex, this.counts.getIndexStart()), Math.max(jComputeIndex, this.counts.getIndexEnd()));
    }

    int getScaleReduction(long j, long j2) {
        int i = 0;
        while ((j2 - j) + 1 > this.counts.getMaxSize()) {
            j >>= 1;
            j2 >>= 1;
            i++;
        }
        return i;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof DoubleExponentialHistogramBuckets)) {
            return false;
        }
        DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets = (DoubleExponentialHistogramBuckets) obj;
        return this.scale == doubleExponentialHistogramBuckets.scale && sameBucketCounts(doubleExponentialHistogramBuckets);
    }

    private boolean sameBucketCounts(DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets) {
        if (this.totalCount != doubleExponentialHistogramBuckets.totalCount) {
            return false;
        }
        int iMin = Math.min(this.counts.getIndexStart(), doubleExponentialHistogramBuckets.counts.getIndexStart());
        if (iMin == Integer.MIN_VALUE) {
            iMin = Math.max(this.counts.getIndexStart(), doubleExponentialHistogramBuckets.counts.getIndexStart());
        }
        int iMax = Math.max(this.counts.getIndexEnd(), doubleExponentialHistogramBuckets.counts.getIndexEnd());
        while (iMin <= iMax) {
            if (this.counts.get(iMin) != doubleExponentialHistogramBuckets.counts.get(iMin)) {
                return false;
            }
            iMin++;
        }
        return true;
    }

    public int hashCode() {
        int i = 1000003;
        for (int indexStart = this.counts.getIndexStart(); indexStart <= this.counts.getIndexEnd(); indexStart++) {
            long j = this.counts.get(indexStart);
            if (j != 0) {
                i = ((int) (((long) ((i ^ indexStart) * 1000003)) ^ j)) * 1000003;
            }
        }
        return this.scale ^ i;
    }

    public String toString() {
        return "DoubleExponentialHistogramBuckets{scale: " + this.scale + ", offset: " + getOffset() + ", counts: " + this.counts + " }";
    }
}
