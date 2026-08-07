package io.opentelemetry.sdk.metrics.internal.data;

import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.HistogramData;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ImmutableHistogramData implements HistogramData {
    private static final ImmutableHistogramData EMPTY = create(AggregationTemporality.CUMULATIVE, Collections.emptyList());

    public static ImmutableHistogramData empty() {
        return EMPTY;
    }

    ImmutableHistogramData() {
    }

    public static ImmutableHistogramData create(AggregationTemporality aggregationTemporality, Collection<HistogramPointData> collection) {
        return new AutoValue_ImmutableHistogramData(aggregationTemporality, collection);
    }
}
