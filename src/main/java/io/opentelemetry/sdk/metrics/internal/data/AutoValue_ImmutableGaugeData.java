package io.opentelemetry.sdk.metrics.internal.data;

import io.opentelemetry.sdk.metrics.data.PointData;
import java.util.Collection;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_ImmutableGaugeData<T extends PointData> extends ImmutableGaugeData<T> {
    private final Collection<T> points;

    AutoValue_ImmutableGaugeData(Collection<T> collection) {
        if (collection == null) {
            throw new NullPointerException("Null points");
        }
        this.points = collection;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.data.ImmutableGaugeData, io.opentelemetry.sdk.metrics.data.Data
    public Collection<T> getPoints() {
        return this.points;
    }

    public String toString() {
        return "ImmutableGaugeData{points=" + this.points + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableGaugeData) {
            return this.points.equals(((ImmutableGaugeData) obj).getPoints());
        }
        return false;
    }

    public int hashCode() {
        return this.points.hashCode() ^ 1000003;
    }
}
