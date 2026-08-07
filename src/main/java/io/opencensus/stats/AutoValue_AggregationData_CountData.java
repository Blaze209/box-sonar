package io.opencensus.stats;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_AggregationData_CountData extends AggregationData.CountData {
    private final long count;

    AutoValue_AggregationData_CountData(long j) {
        this.count = j;
    }

    @Override // io.opencensus.stats.AggregationData.CountData
    public long getCount() {
        return this.count;
    }

    public String toString() {
        return "CountData{count=" + this.count + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof AggregationData.CountData) && this.count == ((AggregationData.CountData) obj).getCount();
    }

    public int hashCode() {
        long j = this.count;
        return (int) (((long) 1000003) ^ (j ^ (j >>> 32)));
    }
}
