package io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram;

import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ImmutableExponentialHistogramData implements ExponentialHistogramData {
    private static final ExponentialHistogramData EMPTY = ExponentialHistogramData.create(AggregationTemporality.CUMULATIVE, Collections.emptyList());

    @Override // io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramData
    public abstract AggregationTemporality getAggregationTemporality();

    @Override // io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramData, io.opentelemetry.sdk.metrics.data.Data
    public abstract Collection<ExponentialHistogramPointData> getPoints();

    public static ExponentialHistogramData empty() {
        return EMPTY;
    }

    public static ExponentialHistogramData create(AggregationTemporality aggregationTemporality, Collection<ExponentialHistogramPointData> collection) {
        return new AutoValue_ImmutableExponentialHistogramData(aggregationTemporality, collection);
    }

    ImmutableExponentialHistogramData() {
    }
}
