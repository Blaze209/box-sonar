package io.opencensus.stats;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_Measurement_MeasurementLong extends Measurement.MeasurementLong {
    private final Measure.MeasureLong measure;
    private final long value;

    AutoValue_Measurement_MeasurementLong(Measure.MeasureLong measureLong, long j) {
        if (measureLong == null) {
            throw new NullPointerException("Null measure");
        }
        this.measure = measureLong;
        this.value = j;
    }

    @Override // io.opencensus.stats.Measurement.MeasurementLong, io.opencensus.stats.Measurement
    public Measure.MeasureLong getMeasure() {
        return this.measure;
    }

    @Override // io.opencensus.stats.Measurement.MeasurementLong
    public long getValue() {
        return this.value;
    }

    public String toString() {
        return "MeasurementLong{measure=" + this.measure + ", value=" + this.value + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Measurement.MeasurementLong) {
            Measurement.MeasurementLong measurementLong = (Measurement.MeasurementLong) obj;
            if (this.measure.equals(measurementLong.getMeasure()) && this.value == measurementLong.getValue()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long jHashCode = (this.measure.hashCode() ^ 1000003) * 1000003;
        long j = this.value;
        return (int) (jHashCode ^ (j ^ (j >>> 32)));
    }
}
