package io.opencensus.metrics.export;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_Value_ValueDouble extends Value.ValueDouble {
    private final double value;

    AutoValue_Value_ValueDouble(double d) {
        this.value = d;
    }

    @Override // io.opencensus.metrics.export.Value.ValueDouble
    double getValue() {
        return this.value;
    }

    public String toString() {
        return "ValueDouble{value=" + this.value + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof Value.ValueDouble) && Double.doubleToLongBits(this.value) == Double.doubleToLongBits(((Value.ValueDouble) obj).getValue());
    }

    public int hashCode() {
        return (int) (((long) 1000003) ^ ((Double.doubleToLongBits(this.value) >>> 32) ^ Double.doubleToLongBits(this.value)));
    }
}
