package io.opencensus.stats;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
final class AutoValue_AggregationData_MeanData extends AggregationData.MeanData {
    private final long count;
    private final double mean;

    AutoValue_AggregationData_MeanData(double d, long j) {
        this.mean = d;
        this.count = j;
    }

    @Override // io.opencensus.stats.AggregationData.MeanData
    public double getMean() {
        return this.mean;
    }

    @Override // io.opencensus.stats.AggregationData.MeanData
    public long getCount() {
        return this.count;
    }

    public String toString() {
        return "MeanData{mean=" + this.mean + ", count=" + this.count + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AggregationData.MeanData) {
            AggregationData.MeanData meanData = (AggregationData.MeanData) obj;
            if (Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(meanData.getMean()) && this.count == meanData.getCount()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long jDoubleToLongBits = ((int) (((long) 1000003) ^ ((Double.doubleToLongBits(this.mean) >>> 32) ^ Double.doubleToLongBits(this.mean)))) * 1000003;
        long j = this.count;
        return (int) (jDoubleToLongBits ^ (j ^ (j >>> 32)));
    }
}
