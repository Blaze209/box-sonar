package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.sdk.metrics.data.LongExemplarData;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_LongAccumulation extends LongAccumulation {
    private final List<LongExemplarData> exemplars;
    private final long value;

    AutoValue_LongAccumulation(long j, List<LongExemplarData> list) {
        this.value = j;
        if (list == null) {
            throw new NullPointerException("Null exemplars");
        }
        this.exemplars = list;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.LongAccumulation
    long getValue() {
        return this.value;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.LongAccumulation
    List<LongExemplarData> getExemplars() {
        return this.exemplars;
    }

    public String toString() {
        return "LongAccumulation{value=" + this.value + ", exemplars=" + this.exemplars + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LongAccumulation) {
            LongAccumulation longAccumulation = (LongAccumulation) obj;
            if (this.value == longAccumulation.getValue() && this.exemplars.equals(longAccumulation.getExemplars())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.value;
        return this.exemplars.hashCode() ^ ((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003);
    }
}
