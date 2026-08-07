package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.sdk.metrics.data.LongExemplarData;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
abstract class LongAccumulation {
    abstract List<LongExemplarData> getExemplars();

    abstract long getValue();

    static LongAccumulation create(long j, List<LongExemplarData> list) {
        return new AutoValue_LongAccumulation(j, list);
    }

    static LongAccumulation create(long j) {
        return create(j, Collections.emptyList());
    }

    LongAccumulation() {
    }
}
