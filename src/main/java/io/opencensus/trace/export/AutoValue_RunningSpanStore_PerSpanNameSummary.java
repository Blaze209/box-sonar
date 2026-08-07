package io.opencensus.trace.export;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_RunningSpanStore_PerSpanNameSummary extends RunningSpanStore.PerSpanNameSummary {
    private final int numRunningSpans;

    AutoValue_RunningSpanStore_PerSpanNameSummary(int i) {
        this.numRunningSpans = i;
    }

    @Override // io.opencensus.trace.export.RunningSpanStore.PerSpanNameSummary
    public int getNumRunningSpans() {
        return this.numRunningSpans;
    }

    public String toString() {
        return "PerSpanNameSummary{numRunningSpans=" + this.numRunningSpans + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof RunningSpanStore.PerSpanNameSummary) && this.numRunningSpans == ((RunningSpanStore.PerSpanNameSummary) obj).getNumRunningSpans();
    }

    public int hashCode() {
        return this.numRunningSpans ^ 1000003;
    }
}
