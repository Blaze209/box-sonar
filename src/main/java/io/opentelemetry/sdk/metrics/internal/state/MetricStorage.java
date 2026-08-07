package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import io.opentelemetry.sdk.metrics.internal.export.RegisteredReader;
import io.opentelemetry.sdk.resources.Resource;

/* JADX INFO: loaded from: classes4.dex */
public interface MetricStorage {
    MetricData collectAndReset(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, long j, long j2);

    MetricDescriptor getMetricDescriptor();

    RegisteredReader getRegisteredReader();

    default boolean isEmpty() {
        return this == EmptyMetricStorage.INSTANCE;
    }
}
