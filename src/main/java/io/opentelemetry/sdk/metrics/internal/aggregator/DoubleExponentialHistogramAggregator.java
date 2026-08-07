package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableMetricData;
import io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramBuckets;
import io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramData;
import io.opentelemetry.sdk.metrics.internal.descriptor.MetricDescriptor;
import io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir;
import io.opentelemetry.sdk.resources.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class DoubleExponentialHistogramAggregator implements Aggregator<ExponentialHistogramAccumulation, DoubleExemplarData> {
    private final int maxBuckets;
    private final Supplier<ExemplarReservoir<DoubleExemplarData>> reservoirSupplier;
    private final int startingScale;

    public DoubleExponentialHistogramAggregator(Supplier<ExemplarReservoir<DoubleExemplarData>> supplier, int i, int i2) {
        this.reservoirSupplier = supplier;
        this.maxBuckets = i;
        this.startingScale = i2;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public AggregatorHandle<ExponentialHistogramAccumulation, DoubleExemplarData> createHandle() {
        return new Handle(this.reservoirSupplier.get(), this.maxBuckets, this.startingScale);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x008e  */
    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public ExponentialHistogramAccumulation merge(ExponentialHistogramAccumulation exponentialHistogramAccumulation, ExponentialHistogramAccumulation exponentialHistogramAccumulation2) {
        double d;
        double d2;
        double min;
        double max;
        boolean z;
        ExponentialHistogramBuckets exponentialHistogramBucketsMerge = merge(exponentialHistogramAccumulation.getPositiveBuckets(), exponentialHistogramAccumulation2.getPositiveBuckets());
        ExponentialHistogramBuckets exponentialHistogramBucketsMerge2 = merge(exponentialHistogramAccumulation.getNegativeBuckets(), exponentialHistogramAccumulation2.getNegativeBuckets());
        int iMin = Math.min(exponentialHistogramBucketsMerge.getScale(), exponentialHistogramBucketsMerge2.getScale());
        ExponentialHistogramBuckets exponentialHistogramBucketsDownscale = downscale(exponentialHistogramBucketsMerge, iMin);
        ExponentialHistogramBuckets exponentialHistogramBucketsDownscale2 = downscale(exponentialHistogramBucketsMerge2, iMin);
        if (exponentialHistogramAccumulation.hasMinMax() && exponentialHistogramAccumulation2.hasMinMax()) {
            min = Math.min(exponentialHistogramAccumulation.getMin(), exponentialHistogramAccumulation2.getMin());
            max = Math.max(exponentialHistogramAccumulation.getMax(), exponentialHistogramAccumulation2.getMax());
        } else if (exponentialHistogramAccumulation.hasMinMax()) {
            min = exponentialHistogramAccumulation.getMin();
            max = exponentialHistogramAccumulation.getMax();
        } else {
            if (exponentialHistogramAccumulation2.hasMinMax()) {
                min = exponentialHistogramAccumulation2.getMin();
                max = exponentialHistogramAccumulation2.getMax();
            } else {
                d = -1.0d;
                d2 = -1.0d;
            }
            double sum = exponentialHistogramAccumulation.getSum() + exponentialHistogramAccumulation2.getSum();
            if (!exponentialHistogramAccumulation.hasMinMax() || exponentialHistogramAccumulation2.hasMinMax()) {
                z = true;
            } else {
                z = false;
            }
            return ExponentialHistogramAccumulation.create(iMin, sum, z, d, d2, exponentialHistogramBucketsDownscale, exponentialHistogramBucketsDownscale2, exponentialHistogramAccumulation.getZeroCount() + exponentialHistogramAccumulation2.getZeroCount(), exponentialHistogramAccumulation2.getExemplars());
        }
        d = min;
        d2 = max;
        double sum2 = exponentialHistogramAccumulation.getSum() + exponentialHistogramAccumulation2.getSum();
        if (exponentialHistogramAccumulation.hasMinMax()) {
            z = true;
        } else {
            z = true;
        }
        return ExponentialHistogramAccumulation.create(iMin, sum2, z, d, d2, exponentialHistogramBucketsDownscale, exponentialHistogramBucketsDownscale2, exponentialHistogramAccumulation.getZeroCount() + exponentialHistogramAccumulation2.getZeroCount(), exponentialHistogramAccumulation2.getExemplars());
    }

    private static ExponentialHistogramBuckets merge(ExponentialHistogramBuckets exponentialHistogramBuckets, ExponentialHistogramBuckets exponentialHistogramBuckets2) {
        if ((exponentialHistogramBuckets instanceof EmptyExponentialHistogramBuckets) || exponentialHistogramBuckets.getTotalCount() == 0) {
            return exponentialHistogramBuckets2;
        }
        if ((exponentialHistogramBuckets2 instanceof EmptyExponentialHistogramBuckets) || exponentialHistogramBuckets2.getTotalCount() == 0) {
            return exponentialHistogramBuckets;
        }
        if ((exponentialHistogramBuckets instanceof DoubleExponentialHistogramBuckets) && (exponentialHistogramBuckets2 instanceof DoubleExponentialHistogramBuckets)) {
            DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets = (DoubleExponentialHistogramBuckets) exponentialHistogramBuckets;
            doubleExponentialHistogramBuckets.mergeInto((DoubleExponentialHistogramBuckets) exponentialHistogramBuckets2);
            return doubleExponentialHistogramBuckets;
        }
        throw new IllegalStateException("Unable to merge ExponentialHistogramBuckets. Unrecognized implementation.");
    }

    private static ExponentialHistogramBuckets downscale(ExponentialHistogramBuckets exponentialHistogramBuckets, int i) {
        if (exponentialHistogramBuckets.getScale() == i) {
            return exponentialHistogramBuckets;
        }
        if (exponentialHistogramBuckets instanceof EmptyExponentialHistogramBuckets) {
            return EmptyExponentialHistogramBuckets.get(i);
        }
        if (exponentialHistogramBuckets instanceof DoubleExponentialHistogramBuckets) {
            DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets = (DoubleExponentialHistogramBuckets) exponentialHistogramBuckets;
            doubleExponentialHistogramBuckets.downscale(doubleExponentialHistogramBuckets.getScale() - i);
            return doubleExponentialHistogramBuckets;
        }
        throw new IllegalStateException("Unable to merge ExponentialHistogramBuckets. Unrecognized implementation");
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator
    public MetricData toMetricData(Resource resource, InstrumentationScopeInfo instrumentationScopeInfo, MetricDescriptor metricDescriptor, Map<Attributes, ExponentialHistogramAccumulation> map, AggregationTemporality aggregationTemporality, long j, long j2, long j3) {
        String name = metricDescriptor.getName();
        String description = metricDescriptor.getDescription();
        String unit = metricDescriptor.getSourceInstrument().getUnit();
        if (aggregationTemporality != AggregationTemporality.CUMULATIVE) {
            j = j2;
        }
        return ImmutableMetricData.createExponentialHistogram(resource, instrumentationScopeInfo, name, description, unit, ExponentialHistogramData.create(aggregationTemporality, MetricDataUtils.toExponentialHistogramPointList(map, j, j3)));
    }

    static final class Handle extends AggregatorHandle<ExponentialHistogramAccumulation, DoubleExemplarData> {
        private long count;
        private double max;
        private final int maxBuckets;
        private double min;

        @Nullable
        private DoubleExponentialHistogramBuckets negativeBuckets;

        @Nullable
        private DoubleExponentialHistogramBuckets positiveBuckets;
        private int scale;
        private double sum;
        private long zeroCount;

        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected /* bridge */ /* synthetic */ ExponentialHistogramAccumulation doAccumulateThenReset(List list) {
            return doAccumulateThenReset((List<DoubleExemplarData>) list);
        }

        Handle(ExemplarReservoir<DoubleExemplarData> exemplarReservoir, int i, int i2) {
            super(exemplarReservoir);
            this.maxBuckets = i;
            this.sum = 0.0d;
            this.zeroCount = 0L;
            this.min = Double.MAX_VALUE;
            this.max = -1.0d;
            this.count = 0L;
            this.scale = i2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected synchronized ExponentialHistogramAccumulation doAccumulateThenReset(List<DoubleExemplarData> list) {
            ExponentialHistogramBuckets exponentialHistogramBucketsCopy;
            ExponentialHistogramBuckets exponentialHistogramBucketsCopy2;
            ExponentialHistogramAccumulation exponentialHistogramAccumulationCreate;
            DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets = this.positiveBuckets;
            if (doubleExponentialHistogramBuckets != null) {
                exponentialHistogramBucketsCopy = doubleExponentialHistogramBuckets.copy();
                this.positiveBuckets.clear();
            } else {
                exponentialHistogramBucketsCopy = EmptyExponentialHistogramBuckets.get(this.scale);
            }
            ExponentialHistogramBuckets exponentialHistogramBuckets = exponentialHistogramBucketsCopy;
            DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets2 = this.negativeBuckets;
            if (doubleExponentialHistogramBuckets2 != null) {
                exponentialHistogramBucketsCopy2 = doubleExponentialHistogramBuckets2.copy();
                this.negativeBuckets.clear();
            } else {
                exponentialHistogramBucketsCopy2 = EmptyExponentialHistogramBuckets.get(this.scale);
            }
            ExponentialHistogramBuckets exponentialHistogramBuckets2 = exponentialHistogramBucketsCopy2;
            int i = this.scale;
            double d = this.sum;
            long j = this.count;
            boolean z = j > 0;
            double d2 = j > 0 ? this.min : -1.0d;
            double d3 = j > 0 ? this.max : -1.0d;
            exponentialHistogramAccumulationCreate = ExponentialHistogramAccumulation.create(i, d, z, d2, d3, exponentialHistogramBuckets, exponentialHistogramBuckets2, this.zeroCount, list);
            this.sum = 0.0d;
            this.zeroCount = 0L;
            this.min = Double.MAX_VALUE;
            this.max = -1.0d;
            this.count = 0L;
            return exponentialHistogramAccumulationCreate;
        }

        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected synchronized void doRecordDouble(double d) {
            DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets;
            if (Double.isFinite(d)) {
                this.sum += d;
                this.min = Math.min(this.min, d);
                this.max = Math.max(this.max, d);
                this.count++;
                int iCompare = Double.compare(d, 0.0d);
                if (iCompare == 0) {
                    this.zeroCount++;
                    return;
                }
                if (iCompare > 0) {
                    if (this.positiveBuckets == null) {
                        this.positiveBuckets = new DoubleExponentialHistogramBuckets(this.scale, this.maxBuckets);
                    }
                    doubleExponentialHistogramBuckets = this.positiveBuckets;
                } else {
                    if (this.negativeBuckets == null) {
                        this.negativeBuckets = new DoubleExponentialHistogramBuckets(this.scale, this.maxBuckets);
                    }
                    doubleExponentialHistogramBuckets = this.negativeBuckets;
                }
                if (!doubleExponentialHistogramBuckets.record(d)) {
                    downScale(doubleExponentialHistogramBuckets.getScaleReduction(d));
                    doubleExponentialHistogramBuckets.record(d);
                }
            }
        }

        @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorHandle
        protected void doRecordLong(long j) {
            doRecordDouble(j);
        }

        void downScale(int i) {
            DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets = this.positiveBuckets;
            if (doubleExponentialHistogramBuckets != null) {
                doubleExponentialHistogramBuckets.downscale(i);
                this.scale = this.positiveBuckets.getScale();
            }
            DoubleExponentialHistogramBuckets doubleExponentialHistogramBuckets2 = this.negativeBuckets;
            if (doubleExponentialHistogramBuckets2 != null) {
                doubleExponentialHistogramBuckets2.downscale(i);
                this.scale = this.negativeBuckets.getScale();
            }
        }
    }

    static abstract class EmptyExponentialHistogramBuckets implements ExponentialHistogramBuckets {
        private static final Map<Integer, ExponentialHistogramBuckets> ZERO_BUCKETS = new ConcurrentHashMap();

        EmptyExponentialHistogramBuckets() {
        }

        static ExponentialHistogramBuckets get(int i) {
            return ZERO_BUCKETS.computeIfAbsent(Integer.valueOf(i), new Function() { // from class: io.opentelemetry.sdk.metrics.internal.aggregator.DoubleExponentialHistogramAggregator$EmptyExponentialHistogramBuckets$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return DoubleExponentialHistogramAggregator.EmptyExponentialHistogramBuckets.lambda$get$0((Integer) obj);
                }
            });
        }

        static /* synthetic */ ExponentialHistogramBuckets lambda$get$0(Integer num) {
            return new AutoValue_DoubleExponentialHistogramAggregator_EmptyExponentialHistogramBuckets(num.intValue(), 0, Collections.emptyList(), 0L);
        }
    }
}
