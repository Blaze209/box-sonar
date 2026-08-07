package io.opentelemetry.sdk.metrics.export;

import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.metrics.Aggregation;
import io.opentelemetry.sdk.metrics.InstrumentType;

/* JADX INFO: loaded from: classes4.dex */
public interface MetricReader extends AggregationTemporalitySelector, DefaultAggregationSelector {
    CompletableResultCode forceFlush();

    void register(CollectionRegistration collectionRegistration);

    CompletableResultCode shutdown();

    @Override // io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector
    default Aggregation getDefaultAggregation(InstrumentType instrumentType) {
        return Aggregation.defaultAggregation();
    }
}
