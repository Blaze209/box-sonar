package io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram;

import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.Data;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.data.MetricDataType;
import java.util.Collection;

/* JADX INFO: loaded from: classes4.dex */
public interface ExponentialHistogramData extends Data<ExponentialHistogramPointData> {
    AggregationTemporality getAggregationTemporality();

    @Override // io.opentelemetry.sdk.metrics.data.Data
    Collection<ExponentialHistogramPointData> getPoints();

    static ExponentialHistogramData create(AggregationTemporality aggregationTemporality, Collection<ExponentialHistogramPointData> collection) {
        return ImmutableExponentialHistogramData.create(aggregationTemporality, collection);
    }

    static ExponentialHistogramData fromMetricData(MetricData metricData) {
        if (metricData.getType() == MetricDataType.EXPONENTIAL_HISTOGRAM) {
            return (ExponentialHistogramData) metricData.getData();
        }
        return ImmutableExponentialHistogramData.empty();
    }
}
