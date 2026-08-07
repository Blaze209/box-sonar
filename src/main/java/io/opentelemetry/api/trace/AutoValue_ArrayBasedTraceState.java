package io.opentelemetry.api.trace;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_ArrayBasedTraceState extends ArrayBasedTraceState {
    private final List<String> entries;

    AutoValue_ArrayBasedTraceState(List<String> list) {
        if (list == null) {
            throw new NullPointerException("Null entries");
        }
        this.entries = list;
    }

    @Override // io.opentelemetry.api.trace.ArrayBasedTraceState
    List<String> getEntries() {
        return this.entries;
    }

    public String toString() {
        return "ArrayBasedTraceState{entries=" + this.entries + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ArrayBasedTraceState) {
            return this.entries.equals(((ArrayBasedTraceState) obj).getEntries());
        }
        return false;
    }

    public int hashCode() {
        return this.entries.hashCode() ^ 1000003;
    }
}
