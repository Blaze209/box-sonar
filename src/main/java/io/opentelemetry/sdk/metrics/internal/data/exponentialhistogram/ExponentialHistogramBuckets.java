package io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface ExponentialHistogramBuckets {
    List<Long> getBucketCounts();

    int getOffset();

    int getScale();

    long getTotalCount();
}
