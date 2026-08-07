package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class DoubleAccumulation {
    abstract List<DoubleExemplarData> getExemplars();

    public abstract double getValue();

    static DoubleAccumulation create(double d, List<DoubleExemplarData> list) {
        return new AutoValue_DoubleAccumulation(d, list);
    }

    public static DoubleAccumulation create(double d) {
        return create(d, Collections.emptyList());
    }

    DoubleAccumulation() {
    }
}
