package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.LongExemplarData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableGaugeData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableMetricData;
import io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir;
import io.opentelemetry.sdk.resources.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class LongLastValueAggregator implements Aggregator<LongAccumulation, LongExemplarData> {
    private final Supplier<ExemplarReservoir<LongExemplarData>> reservoirSupplier;

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public LongAccumulation diff(LongAccumulation longAccumulation, LongAccumulation longAccumulation2) {
        return longAccumulation2;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public LongAccumulation merge(LongAccumulation longAccumulation, LongAccumulation longAccumulation2) {
        return longAccumulation2;
    }

    public LongLastValueAggregator(Supplier<ExemplarReservoir<LongExemplarData>> supplier) {
        this.reservoirSupplier = supplier;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public AggregatorHandle<LongAccumulation, LongExemplarData> createHandle() {
        return new Handle(this.reservoirSupplier.get());
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public MetricData toMetricData(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, MetricDescriptor metricDescriptor, Map<Attributes, LongAccumulation> map, AggregationTemporality aggregationTemporality, long j, long j2, long j3) {
        String name = metricDescriptor.getName();
        String description = metricDescriptor.getDescription();
        String unit = metricDescriptor.getSourceInstrument().getUnit();
        if (aggregationTemporality != AggregationTemporality.CUMULATIVE) {
            j = j2;
        }
        return ImmutableMetricData.createLongGauge(resource, instrumentationScopeInfo, name, description, unit, ImmutableGaugeData.create(MetricDataUtils.toLongPointList(map, j, j3)));
    }

    static final class Handle extends AggregatorHandle<LongAccumulation, LongExemplarData> {

        @Nullable
        private static final Long DEFAULT_VALUE = null;
        private final AtomicReference<Long> current;

        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected /* bridge */ /* synthetic */ LongAccumulation doAccumulateThenReset(List list) {
            return doAccumulateThenReset((List<LongExemplarData>) list);
        }

        Handle(ExemplarReservoir<LongExemplarData> exemplarReservoir) {
            super(exemplarReservoir);
            this.current = new AtomicReference<>(DEFAULT_VALUE);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected LongAccumulation doAccumulateThenReset(List<LongExemplarData> list) {
            return LongAccumulation.create(this.current.getAndSet(DEFAULT_VALUE).longValue(), list);
        }

        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected void doRecordLong(long j) {
            this.current.set(Long.valueOf(j));
        }
    }
}
