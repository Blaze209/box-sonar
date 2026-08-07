package io.opentelemetry.sdk.metrics.internal.export;

import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.export.CollectionRegistration;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes4.dex */
public interface MetricProducer extends CollectionRegistration {
    Collection<MetricData> collectAllMetrics();

    static MetricProducer asMetricProducer(CollectionRegistration collectionRegistration) {
        if (!(collectionRegistration instanceof MetricProducer)) {
            throw new IllegalArgumentException("unrecognized CollectionRegistration, custom MetricReader implementations are not currently supported");
        }
        return (MetricProducer) collectionRegistration;
    }

    static MetricProducer noop() {
        return new MetricProducer() { // from class: io.opentelemetry.sdk.metrics.internal.export.MetricProducer$$ExternalSyntheticLambda0
            @Override // io.opentelemetry.sdk.metrics.internal.export.MetricProducer
            public final Collection collectAllMetrics() {
                return Collections.emptyList();
            }
        };
    }
}
