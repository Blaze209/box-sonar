package io.opentelemetry.sdk.metrics.internal.data;

import io.opentelemetry.sdk.metrics.data.SummaryPointData;
import java.util.Collection;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_ImmutableSummaryData extends ImmutableSummaryData {
    private final Collection<SummaryPointData> points;

    AutoValue_ImmutableSummaryData(Collection<SummaryPointData> collection) {
        if (collection == null) {
            throw new NullPointerException("Null points");
        }
        this.points = collection;
    }

    @Override // io.opentelemetry.sdk.metrics.data.Data
    public Collection<SummaryPointData> getPoints() {
        return this.points;
    }

    public String toString() {
        return "ImmutableSummaryData{points=" + this.points + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableSummaryData) {
            return this.points.equals(((ImmutableSummaryData) obj).getPoints());
        }
        return false;
    }

    public int hashCode() {
        return this.points.hashCode() ^ 1000003;
    }
}
