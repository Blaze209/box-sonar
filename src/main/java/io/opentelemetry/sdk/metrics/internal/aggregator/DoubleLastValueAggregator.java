package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
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
public final class DoubleLastValueAggregator implements Aggregator<DoubleAccumulation, DoubleExemplarData> {
    private final Supplier<ExemplarReservoir<DoubleExemplarData>> reservoirSupplier;

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public DoubleAccumulation diff(DoubleAccumulation doubleAccumulation, DoubleAccumulation doubleAccumulation2) {
        return doubleAccumulation2;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public DoubleAccumulation merge(DoubleAccumulation doubleAccumulation, DoubleAccumulation doubleAccumulation2) {
        return doubleAccumulation2;
    }

    public DoubleLastValueAggregator(Supplier<ExemplarReservoir<DoubleExemplarData>> supplier) {
        this.reservoirSupplier = supplier;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public AggregatorHandle<DoubleAccumulation, DoubleExemplarData> createHandle() {
        return new Handle(this.reservoirSupplier.get());
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public MetricData toMetricData(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, MetricDescriptor metricDescriptor, Map<Attributes, DoubleAccumulation> map, AggregationTemporality aggregationTemporality, long j, long j2, long j3) {
        String name = metricDescriptor.getName();
        String description = metricDescriptor.getDescription();
        String unit = metricDescriptor.getSourceInstrument().getUnit();
        if (aggregationTemporality != AggregationTemporality.CUMULATIVE) {
            j = j2;
        }
        return ImmutableMetricData.createDoubleGauge(resource, instrumentationScopeInfo, name, description, unit, ImmutableGaugeData.create(MetricDataUtils.toDoublePointList(map, j, j3)));
    }

    static final class Handle extends AggregatorHandle<DoubleAccumulation, DoubleExemplarData> {

        @Nullable
        private static final Double DEFAULT_VALUE = null;
        private final AtomicReference<Double> current;

        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected /* bridge */ /* synthetic */ DoubleAccumulation doAccumulateThenReset(List list) {
            return doAccumulateThenReset((List<DoubleExemplarData>) list);
        }

        private Handle(ExemplarReservoir<DoubleExemplarData> exemplarReservoir) {
            super(exemplarReservoir);
            this.current = new AtomicReference<>(DEFAULT_VALUE);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected DoubleAccumulation doAccumulateThenReset(List<DoubleExemplarData> list) {
            return DoubleAccumulation.create(this.current.getAndSet(DEFAULT_VALUE).doubleValue(), list);
        }

        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected void doRecordDouble(double d) {
            this.current.set(Double.valueOf(d));
        }
    }
}
