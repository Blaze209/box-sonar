package io.opentelemetry.sdk.metrics.data;

import io.opentelemetry.sdk.metrics.data.PointData;

/* JADX INFO: loaded from: classes4.dex */
public interface SumData<T extends PointData> extends Data<T> {
    AggregationTemporality getAggregationTemporality();

    boolean isMonotonic();
}
