package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import io.opentelemetry.sdk.metrics.data.ExemplarData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import io.opentelemetry.sdk.resources.Resource;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface Aggregator<T, U extends ExemplarData> {
    AggregatorHandle<T, U> createHandle();

    T merge(T t, T t2);

    MetricData toMetricData(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, MetricDescriptor metricDescriptor, Map<Attributes, T> map, AggregationTemporality aggregationTemporality, long j, long j2, long j3);

    static Aggregator<Object, DoubleExemplarData> drop() {
        return DropAggregator.INSTANCE;
    }

    @Nullable
    default T accumulateLongMeasurement(long j, Attributes attributes, Context context) {
        AggregatorHandle<T, U> aggregatorHandleCreateHandle = createHandle();
        aggregatorHandleCreateHandle.recordLong(j, attributes, context);
        return aggregatorHandleCreateHandle.accumulateThenReset(attributes);
    }

    @Nullable
    default T accumulateDoubleMeasurement(double d, Attributes attributes, Context context) {
        AggregatorHandle<T, U> aggregatorHandleCreateHandle = createHandle();
        aggregatorHandleCreateHandle.recordDouble(d, attributes, context);
        return aggregatorHandleCreateHandle.accumulateThenReset(attributes);
    }

    default T diff(T t, T t2) {
        throw new UnsupportedOperationException("This aggregator does not support diff.");
    }
}
