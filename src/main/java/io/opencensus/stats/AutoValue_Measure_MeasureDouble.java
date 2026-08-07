package io.opencensus.stats;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_Measure_MeasureDouble extends Measure.MeasureDouble {
    private final String description;
    private final String name;
    private final String unit;

    AutoValue_Measure_MeasureDouble(String str, String str2, String str3) {
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        this.name = str;
        if (str2 == null) {
            throw new NullPointerException("Null description");
        }
        this.description = str2;
        if (str3 == null) {
            throw new NullPointerException("Null unit");
        }
        this.unit = str3;
    }

    @Override // io.opencensus.stats.Measure.MeasureDouble, io.opencensus.stats.Measure
    public String getName() {
        return this.name;
    }

    @Override // io.opencensus.stats.Measure.MeasureDouble, io.opencensus.stats.Measure
    public String getDescription() {
        return this.description;
    }

    @Override // io.opencensus.stats.Measure.MeasureDouble, io.opencensus.stats.Measure
    public String getUnit() {
        return this.unit;
    }

    public String toString() {
        return "MeasureDouble{name=" + this.name + ", description=" + this.description + ", unit=" + this.unit + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Measure.MeasureDouble) {
            Measure.MeasureDouble measureDouble = (Measure.MeasureDouble) obj;
            if (this.name.equals(measureDouble.getName()) && this.description.equals(measureDouble.getDescription()) && this.unit.equals(measureDouble.getUnit())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.unit.hashCode() ^ ((((this.name.hashCode() ^ 1000003) * 1000003) ^ this.description.hashCode()) * 1000003);
    }
}
