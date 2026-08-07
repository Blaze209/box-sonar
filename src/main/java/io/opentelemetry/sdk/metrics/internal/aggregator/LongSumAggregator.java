package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.LongExemplarData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.internal.concurrent.AdderUtil;
import io.opentelemetry.sdk.metrics.internal.concurrent.LongAdder;
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
public final class LongSumAggregator extends AbstractSumAggregator<LongAccumulation, LongExemplarData> {
    private final Supplier<ExemplarReservoir<LongExemplarData>> reservoirSupplier;

    public LongSumAggregator(InstrumentDescriptor instrumentDescriptor, Supplier<ExemplarReservoir<LongExemplarData>> supplier) {
        super(instrumentDescriptor);
        this.reservoirSupplier = supplier;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public AggregatorHandle<LongAccumulation, LongExemplarData> createHandle() {
        return new Handle(this.reservoirSupplier.get());
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public LongAccumulation merge(LongAccumulation longAccumulation, LongAccumulation longAccumulation2) {
        return LongAccumulation.create(longAccumulation.getValue() + longAccumulation2.getValue(), longAccumulation2.getExemplars());
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public LongAccumulation diff(LongAccumulation longAccumulation, LongAccumulation longAccumulation2) {
        return LongAccumulation.create(longAccumulation2.getValue() - longAccumulation.getValue(), longAccumulation2.getExemplars());
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public MetricData toMetricData(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, MetricDescriptor metricDescriptor, Map<Attributes, LongAccumulation> map, AggregationTemporality aggregationTemporality, long j, long j2, long j3) {
        String name = metricDescriptor.getName();
        String description = metricDescriptor.getDescription();
        String unit = metricDescriptor.getSourceInstrument().getUnit();
        boolean zIsMonotonic = isMonotonic();
        if (aggregationTemporality != AggregationTemporality.CUMULATIVE) {
            j = j2;
        }
        return ImmutableMetricData.createLongSum(resource, instrumentationScopeInfo, name, description, unit, ImmutableSumData.create(zIsMonotonic, aggregationTemporality, MetricDataUtils.toLongPointList(map, j, j3)));
    }

    static final class Handle extends AggregatorHandle<LongAccumulation, LongExemplarData> {
        private final LongAdder current;

        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected /* bridge */ /* synthetic */ LongAccumulation doAccumulateThenReset(List list) {
            return doAccumulateThenReset((List<LongExemplarData>) list);
        }

        Handle(ExemplarReservoir<LongExemplarData> exemplarReservoir) {
            super(exemplarReservoir);
            this.current = AdderUtil.createLongAdder();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected LongAccumulation doAccumulateThenReset(List<LongExemplarData> list) {
            return LongAccumulation.create(this.current.sumThenReset(), list);
        }

        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        public void doRecordLong(long j) {
            this.current.add(j);
        }
    }
}
