package io.opentelemetry.sdk.metrics.data;

import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableGaugeData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableHistogramData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableSumData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableSummaryData;
import io.opentelemetry.sdk.resources.Resource;

/* JADX INFO: loaded from: classes4.dex */
public interface MetricData {
    Data<?> getData();

    String getDescription();

    InstrumentationScopeInfo getInstrumentationScopeInfo();

    String getName();

    Resource getResource();

    MetricDataType getType();

    String getUnit();

    default boolean isEmpty() {
        return getData().getPoints().isEmpty();
    }

    default GaugeData<DoublePointData> getDoubleGaugeData() {
        if (getType() == MetricDataType.DOUBLE_GAUGE) {
            return (GaugeData) getData();
        }
        return ImmutableGaugeData.empty();
    }

    default GaugeData<LongPointData> getLongGaugeData() {
        if (getType() == MetricDataType.LONG_GAUGE) {
            return (GaugeData) getData();
        }
        return ImmutableGaugeData.empty();
    }

    default SumData<DoublePointData> getDoubleSumData() {
        if (getType() == MetricDataType.DOUBLE_SUM) {
            return (ImmutableSumData) getData();
        }
        return ImmutableSumData.empty();
    }

    default SumData<LongPointData> getLongSumData() {
        if (getType() == MetricDataType.LONG_SUM) {
            return (SumData) getData();
        }
        return ImmutableSumData.empty();
    }

    default SummaryData getSummaryData() {
        if (getType() == MetricDataType.SUMMARY) {
            return (SummaryData) getData();
        }
        return ImmutableSummaryData.empty();
    }

    default HistogramData getHistogramData() {
        if (getType() == MetricDataType.HISTOGRAM) {
            return (HistogramData) getData();
        }
        return ImmutableHistogramData.empty();
    }
}
