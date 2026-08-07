package io.opencensus.trace;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_Tracestate_Entry extends Tracestate.Entry {
    private final String key;
    private final String value;

    AutoValue_Tracestate_Entry(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Null key");
        }
        this.key = str;
        if (str2 == null) {
            throw new NullPointerException("Null value");
        }
        this.value = str2;
    }

    @Override // io.opencensus.trace.Tracestate.Entry
    public String getKey() {
        return this.key;
    }

    @Override // io.opencensus.trace.Tracestate.Entry
    public String getValue() {
        return this.value;
    }

    public String toString() {
        return "Entry{key=" + this.key + ", value=" + this.value + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Tracestate.Entry) {
            Tracestate.Entry entry = (Tracestate.Entry) obj;
            if (this.key.equals(entry.getKey()) && this.value.equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.value.hashCode() ^ ((this.key.hashCode() ^ 1000003) * 1000003);
    }
}
