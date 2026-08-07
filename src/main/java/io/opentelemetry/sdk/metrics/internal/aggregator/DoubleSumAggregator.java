package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.internal.concurrent.AdderUtil;
import io.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableMetricData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableSumData;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir;
import io.opentelemetry.sdk.resources.Resource;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes4.dex */
public final class DoubleSumAggregator extends AbstractSumAggregator<DoubleAccumulation, DoubleExemplarData> {
    private final Supplier<ExemplarReservoir<DoubleExemplarData>> reservoirSupplier;

    public DoubleSumAggregator(InstrumentDescriptor instrumentDescriptor, Supplier<ExemplarReservoir<DoubleExemplarData>> supplier) {
        super(instrumentDescriptor);
        this.reservoirSupplier = supplier;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public AggregatorHandle<DoubleAccumulation, DoubleExemplarData> createHandle() {
        return new Handle(this.reservoirSupplier.get());
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public DoubleAccumulation accumulateDoubleMeasurement(double d, Attributes attributes, Context context) {
        return DoubleAccumulation.create(d);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public DoubleAccumulation merge(DoubleAccumulation doubleAccumulation, DoubleAccumulation doubleAccumulation2) {
        return DoubleAccumulation.create(doubleAccumulation.getValue() + doubleAccumulation2.getValue(), doubleAccumulation2.getExemplars());
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public DoubleAccumulation diff(DoubleAccumulation doubleAccumulation, DoubleAccumulation doubleAccumulation2) {
        return DoubleAccumulation.create(doubleAccumulation2.getValue() - doubleAccumulation.getValue(), doubleAccumulation2.getExemplars());
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public MetricData toMetricData(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, MetricDescriptor metricDescriptor, Map<Attributes, DoubleAccumulation> map, AggregationTemporality aggregationTemporality, long j, long j2, long j3) {
        String name = metricDescriptor.getName();
        String description = metricDescriptor.getDescription();
        String unit = metricDescriptor.getSourceInstrument().getUnit();
        boolean zIsMonotonic = isMonotonic();
        if (aggregationTemporality != AggregationTemporality.CUMULATIVE) {
            j = j2;
        }
        return ImmutableMetricData.createDoubleSum(resource, instrumentationScopeInfo, name, description, unit, ImmutableSumData.create(zIsMonotonic, aggregationTemporality, MetricDataUtils.toDoublePointList(map, j, j3)));
    }

    static final class Handle extends AggregatorHandle<DoubleAccumulation, DoubleExemplarData> {
        private final DoubleAdder current;

        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected /* bridge */ /* synthetic */ DoubleAccumulation doAccumulateThenReset(List list) {
            return doAccumulateThenReset((List<DoubleExemplarData>) list);
        }

        Handle(ExemplarReservoir<DoubleExemplarData> exemplarReservoir) {
            super(exemplarReservoir);
            this.current = AdderUtil.createDoubleAdder();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected DoubleAccumulation doAccumulateThenReset(List<DoubleExemplarData> list) {
            return DoubleAccumulation.create(this.current.sumThenReset(), list);
        }

        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected void doRecordDouble(double d) {
            this.current.add(d);
        }
    }
}
