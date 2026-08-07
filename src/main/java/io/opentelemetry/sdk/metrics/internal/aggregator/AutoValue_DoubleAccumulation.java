package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_DoubleAccumulation extends DoubleAccumulation {
    private final List<DoubleExemplarData> exemplars;
    private final double value;

    AutoValue_DoubleAccumulation(double d, List<DoubleExemplarData> list) {
        this.value = d;
        if (list == null) {
            throw new NullPointerException("Null exemplars");
        }
        this.exemplars = list;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.DoubleAccumulation
    public double getValue() {
        return this.value;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.DoubleAccumulation
    List<DoubleExemplarData> getExemplars() {
        return this.exemplars;
    }

    public String toString() {
        return "DoubleAccumulation{value=" + this.value + ", exemplars=" + this.exemplars + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof DoubleAccumulation) {
            DoubleAccumulation doubleAccumulation = (DoubleAccumulation) obj;
            if (Double.doubleToLongBits(this.value) == Double.doubleToLongBits(doubleAccumulation.getValue()) && this.exemplars.equals(doubleAccumulation.getExemplars())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.exemplars.hashCode() ^ ((((int) ((Double.doubleToLongBits(this.value) >>> 32) ^ Double.doubleToLongBits(this.value))) ^ 1000003) * 1000003);
    }
}
