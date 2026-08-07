package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import java.util.function.BiFunction;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class MetricStorageUtils$$ExternalSyntheticLambda2 implements BiFunction {
    public final /* synthetic */ Aggregator f$0;

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return this.f$0.merge(obj, obj2);
    }
}
