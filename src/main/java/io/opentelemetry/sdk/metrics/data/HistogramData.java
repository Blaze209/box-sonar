package io.opentelemetry.sdk.metrics.data;

import java.util.Collection;

/* JADX INFO: loaded from: classes4.dex */
public interface HistogramData extends Data<HistogramPointData> {
    AggregationTemporality getAggregationTemporality();

    @Override // io.opentelemetry.sdk.metrics.data.Data
    Collection<HistogramPointData> getPoints();
}
