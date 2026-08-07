package io.opentelemetry.sdk.metrics.export;

import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.metrics.Aggregation;
import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.data.MetricData;
import java.io.Closeable;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public interface MetricExporter extends AggregationTemporalitySelector, DefaultAggregationSelector, Closeable {
    CompletableResultCode export(Collection<MetricData> collection);

    CompletableResultCode flush();

    CompletableResultCode shutdown();

    @Override // io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector
    default Aggregation getDefaultAggregation(InstrumentType instrumentType) {
        return Aggregation.defaultAggregation();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    default void close() {
        shutdown().join(10L, TimeUnit.SECONDS);
    }
}
