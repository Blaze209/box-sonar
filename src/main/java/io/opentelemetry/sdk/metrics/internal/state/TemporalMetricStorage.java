package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.ExemplarData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import io.opentelemetry.sdk.metrics.internal.aggregator.EmptyMetricData;
import io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import io.opentelemetry.sdk.metrics.internal.export.RegisteredReader;
import io.opentelemetry.sdk.resources.Resource;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
class TemporalMetricStorage<T, U extends ExemplarData> {
    private final Aggregator<T, U> aggregator;
    private final boolean isSynchronous;
    private Map<Attributes, T> lastAccumulation = new HashMap();
    private final MetricDescriptor metricDescriptor;
    private final RegisteredReader registeredReader;
    private final AggregationTemporality temporality;

    TemporalMetricStorage(Aggregator<T, U> aggregator, boolean z, RegisteredReader registeredReader, AggregationTemporality aggregationTemporality, MetricDescriptor metricDescriptor) {
        this.aggregator = aggregator;
        this.isSynchronous = z;
        this.registeredReader = registeredReader;
        this.temporality = aggregationTemporality;
        this.metricDescriptor = metricDescriptor;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0046 A[Catch: all -> 0x006a, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000f, B:8:0x0013, B:19:0x0042, B:21:0x0046, B:23:0x004b, B:25:0x0051, B:28:0x0057, B:22:0x0049, B:10:0x001e, B:12:0x0024, B:14:0x0028, B:16:0x0039, B:17:0x003e), top: B:35:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x0049 A[Catch: all -> 0x006a, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000f, B:8:0x0013, B:19:0x0042, B:21:0x0046, B:23:0x004b, B:25:0x0051, B:28:0x0057, B:22:0x0049, B:10:0x001e, B:12:0x0024, B:14:0x0028, B:16:0x0039, B:17:0x003e), top: B:35:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0051 A[Catch: all -> 0x006a, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000f, B:8:0x0013, B:19:0x0042, B:21:0x0046, B:23:0x004b, B:25:0x0051, B:28:0x0057, B:22:0x0049, B:10:0x001e, B:12:0x0024, B:14:0x0028, B:16:0x0039, B:17:0x003e), top: B:35:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0057 A[Catch: all -> 0x006a, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000f, B:8:0x0013, B:19:0x0042, B:21:0x0046, B:23:0x004b, B:25:0x0051, B:28:0x0057, B:22:0x0049, B:10:0x001e, B:12:0x0024, B:14:0x0028, B:16:0x0039, B:17:0x003e), top: B:35:0x0003 }] */
    synchronized MetricData buildMetricFor(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, Map<Attributes, T> map, long j, long j2) {
        Map<Attributes, T> map2;
        Map<Attributes, T> map3;
        long lastCollectEpochNanos = this.registeredReader.getLastCollectEpochNanos();
        if (this.temporality == AggregationTemporality.DELTA && !this.isSynchronous) {
            MetricStorageUtils.diffInPlace(this.lastAccumulation, map, this.aggregator);
            map3 = this.lastAccumulation;
        } else {
            if (this.temporality == AggregationTemporality.CUMULATIVE && this.isSynchronous) {
                MetricStorageUtils.mergeAndPreserveInPlace(this.lastAccumulation, map, this.aggregator);
                if (this.lastAccumulation.size() > 2000) {
                    MetricStorageUtils.removeUnseen(this.lastAccumulation, map);
                }
                map3 = this.lastAccumulation;
            } else {
                map2 = map;
            }
            if (this.isSynchronous) {
                this.lastAccumulation = map2;
            } else {
                this.lastAccumulation = map;
            }
            if (map2.isEmpty()) {
                return EmptyMetricData.getInstance();
            }
            return this.aggregator.toMetricData(resource, instrumentationScopeInfo, this.metricDescriptor, map2, this.temporality, j, lastCollectEpochNanos, j2);
        }
        map2 = map3;
        if (this.isSynchronous) {
            this.lastAccumulation = map2;
        } else {
            this.lastAccumulation = map;
        }
        if (map2.isEmpty()) {
            return EmptyMetricData.getInstance();
        }
        return this.aggregator.toMetricData(resource, instrumentationScopeInfo, this.metricDescriptor, map2, this.temporality, j, lastCollectEpochNanos, j2);
    }
}
