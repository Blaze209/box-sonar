package io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram;

import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import java.util.Collection;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_ImmutableExponentialHistogramData extends ImmutableExponentialHistogramData {
    private final AggregationTemporality aggregationTemporality;
    private final Collection<ExponentialHistogramPointData> points;

    AutoValue_ImmutableExponentialHistogramData(AggregationTemporality aggregationTemporality, Collection<ExponentialHistogramPointData> collection) {
        if (aggregationTemporality == null) {
            throw new NullPointerException("Null aggregationTemporality");
        }
        this.aggregationTemporality = aggregationTemporality;
        if (collection == null) {
            throw new NullPointerException("Null points");
        }
        this.points = collection;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ImmutableExponentialHistogramData, io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramData
    public AggregationTemporality getAggregationTemporality() {
        return this.aggregationTemporality;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ImmutableExponentialHistogramData, io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramData, io.opentelemetry.sdk.metrics.data.Data
    public Collection<ExponentialHistogramPointData> getPoints() {
        return this.points;
    }

    public String toString() {
        return "ImmutableExponentialHistogramData{aggregationTemporality=" + this.aggregationTemporality + ", points=" + this.points + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableExponentialHistogramData) {
            ImmutableExponentialHistogramData immutableExponentialHistogramData = (ImmutableExponentialHistogramData) obj;
            if (this.aggregationTemporality.equals(immutableExponentialHistogramData.getAggregationTemporality()) && this.points.equals(immutableExponentialHistogramData.getPoints())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.points.hashCode() ^ ((this.aggregationTemporality.hashCode() ^ 1000003) * 1000003);
    }
}
