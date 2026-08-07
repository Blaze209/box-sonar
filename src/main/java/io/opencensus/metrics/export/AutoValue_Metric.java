package io.opencensus.metrics.export;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_Metric extends Metric {
    private final MetricDescriptor metricDescriptor;
    private final List<TimeSeries> timeSeriesList;

    AutoValue_Metric(MetricDescriptor metricDescriptor, List<TimeSeries> list) {
        if (metricDescriptor == null) {
            throw new NullPointerException("Null metricDescriptor");
        }
        this.metricDescriptor = metricDescriptor;
        if (list == null) {
            throw new NullPointerException("Null timeSeriesList");
        }
        this.timeSeriesList = list;
    }

    @Override // io.opencensus.metrics.export.Metric
    public MetricDescriptor getMetricDescriptor() {
        return this.metricDescriptor;
    }

    @Override // io.opencensus.metrics.export.Metric
    public List<TimeSeries> getTimeSeriesList() {
        return this.timeSeriesList;
    }

    public String toString() {
        return "Metric{metricDescriptor=" + this.metricDescriptor + ", timeSeriesList=" + this.timeSeriesList + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Metric) {
            Metric metric = (Metric) obj;
            if (this.metricDescriptor.equals(metric.getMetricDescriptor()) && this.timeSeriesList.equals(metric.getTimeSeriesList())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.timeSeriesList.hashCode() ^ ((this.metricDescriptor.hashCode() ^ 1000003) * 1000003);
    }
}
