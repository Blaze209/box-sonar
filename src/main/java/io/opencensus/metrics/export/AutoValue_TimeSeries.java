package io.opencensus.metrics.export;

import io.opencensus.common.Timestamp;
import io.opencensus.metrics.LabelValue;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_TimeSeries extends TimeSeries {
    private final List<LabelValue> labelValues;
    private final List<Point> points;
    private final Timestamp startTimestamp;

    AutoValue_TimeSeries(List<LabelValue> list, List<Point> list2, @Nullable Timestamp timestamp) {
        if (list == null) {
            throw new NullPointerException("Null labelValues");
        }
        this.labelValues = list;
        if (list2 == null) {
            throw new NullPointerException("Null points");
        }
        this.points = list2;
        this.startTimestamp = timestamp;
    }

    @Override // io.opencensus.metrics.export.TimeSeries
    public List<LabelValue> getLabelValues() {
        return this.labelValues;
    }

    @Override // io.opencensus.metrics.export.TimeSeries
    public List<Point> getPoints() {
        return this.points;
    }

    @Override // io.opencensus.metrics.export.TimeSeries
    @Nullable
    public Timestamp getStartTimestamp() {
        return this.startTimestamp;
    }

    public String toString() {
        return "TimeSeries{labelValues=" + this.labelValues + ", points=" + this.points + ", startTimestamp=" + this.startTimestamp + "}";
    }

    public boolean equals(Object obj) {
        Timestamp timestamp;
        if (obj == this) {
            return true;
        }
        if (obj instanceof TimeSeries) {
            TimeSeries timeSeries = (TimeSeries) obj;
            if (this.labelValues.equals(timeSeries.getLabelValues()) && this.points.equals(timeSeries.getPoints()) && ((timestamp = this.startTimestamp) != null ? timestamp.equals(timeSeries.getStartTimestamp()) : timeSeries.getStartTimestamp() == null)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((this.labelValues.hashCode() ^ 1000003) * 1000003) ^ this.points.hashCode()) * 1000003;
        Timestamp timestamp = this.startTimestamp;
        return (timestamp == null ? 0 : timestamp.hashCode()) ^ iHashCode;
    }
}
