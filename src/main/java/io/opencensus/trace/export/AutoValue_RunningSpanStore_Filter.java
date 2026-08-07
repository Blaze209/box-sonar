package io.opencensus.trace.export;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_RunningSpanStore_Filter extends RunningSpanStore.Filter {
    private final int maxSpansToReturn;
    private final String spanName;

    AutoValue_RunningSpanStore_Filter(String str, int i) {
        if (str == null) {
            throw new NullPointerException("Null spanName");
        }
        this.spanName = str;
        this.maxSpansToReturn = i;
    }

    @Override // io.opencensus.trace.export.RunningSpanStore.Filter
    public String getSpanName() {
        return this.spanName;
    }

    @Override // io.opencensus.trace.export.RunningSpanStore.Filter
    public int getMaxSpansToReturn() {
        return this.maxSpansToReturn;
    }

    public String toString() {
        return "Filter{spanName=" + this.spanName + ", maxSpansToReturn=" + this.maxSpansToReturn + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RunningSpanStore.Filter) {
            RunningSpanStore.Filter filter = (RunningSpanStore.Filter) obj;
            if (this.spanName.equals(filter.getSpanName()) && this.maxSpansToReturn == filter.getMaxSpansToReturn()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.maxSpansToReturn ^ ((this.spanName.hashCode() ^ 1000003) * 1000003);
    }
}
