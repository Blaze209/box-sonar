package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.sdk.metrics.data.ExemplarData;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;

/* JADX INFO: loaded from: classes4.dex */
abstract class AbstractSumAggregator<T, U extends ExemplarData> implements Aggregator<T, U> {
    private final boolean isMonotonic;

    AbstractSumAggregator(InstrumentDescriptor instrumentDescriptor) {
        this.isMonotonic = MetricDataUtils.isMonotonicInstrument(instrumentDescriptor);
    }

    final boolean isMonotonic() {
        return this.isMonotonic;
    }
}
