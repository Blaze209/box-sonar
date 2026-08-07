package io.opentelemetry.sdk.metrics;

import io.opentelemetry.sdk.metrics.internal.view.DefaultAggregation;
import io.opentelemetry.sdk.metrics.internal.view.DropAggregation;
import io.opentelemetry.sdk.metrics.internal.view.ExplicitBucketHistogramAggregation;
import io.opentelemetry.sdk.metrics.internal.view.LastValueAggregation;
import io.opentelemetry.sdk.metrics.internal.view.SumAggregation;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface Aggregation {
    static Aggregation drop() {
        return DropAggregation.getInstance();
    }

    static Aggregation defaultAggregation() {
        return DefaultAggregation.getInstance();
    }

    static Aggregation sum() {
        return SumAggregation.getInstance();
    }

    static Aggregation lastValue() {
        return LastValueAggregation.getInstance();
    }

    static Aggregation explicitBucketHistogram() {
        return ExplicitBucketHistogramAggregation.getDefault();
    }

    static Aggregation explicitBucketHistogram(List<Double> list) {
        return ExplicitBucketHistogramAggregation.create(list);
    }
}
