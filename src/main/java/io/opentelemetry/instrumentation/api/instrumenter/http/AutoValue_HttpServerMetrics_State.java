package io.opentelemetry.instrumentation.api.instrumenter.http;

import io.opentelemetry.api.common.Attributes;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_HttpServerMetrics_State extends HttpServerMetrics.State {
    private final Attributes startAttributes;
    private final long startTimeNanos;

    AutoValue_HttpServerMetrics_State(Attributes attributes, long j) {
        if (attributes == null) {
            throw new NullPointerException("Null startAttributes");
        }
        this.startAttributes = attributes;
        this.startTimeNanos = j;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpServerMetrics.State
    Attributes startAttributes() {
        return this.startAttributes;
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpServerMetrics.State
    long startTimeNanos() {
        return this.startTimeNanos;
    }

    public String toString() {
        return "State{startAttributes=" + this.startAttributes + ", startTimeNanos=" + this.startTimeNanos + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof HttpServerMetrics.State) {
            HttpServerMetrics.State state = (HttpServerMetrics.State) obj;
            if (this.startAttributes.equals(state.startAttributes()) && this.startTimeNanos == state.startTimeNanos()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.startAttributes.hashCode() ^ 1000003) * 1000003;
        long j = this.startTimeNanos;
        return ((int) (j ^ (j >>> 32))) ^ iHashCode;
    }
}
