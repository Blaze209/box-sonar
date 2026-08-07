package io.opentelemetry.sdk.metrics.internal.aggregator;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.internal.PrimitiveLongList;
import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.data.DoublePointData;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableDoublePointData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableHistogramPointData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableLongPointData;
import io.opentelemetry.sdk.metrics.internal.data.exponentialhistogram.ExponentialHistogramPointData;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes4.dex */
final class MetricDataUtils {
    private MetricDataUtils() {
    }

    static boolean isMonotonicInstrument(InstrumentDescriptor instrumentDescriptor) {
        InstrumentType type = instrumentDescriptor.getType();
        return type == InstrumentType.HISTOGRAM || type == InstrumentType.COUNTER || type == InstrumentType.OBSERVABLE_COUNTER;
    }

    static List<LongPointData> toLongPointList(Map<Attributes, LongAccumulation> map, final long j, final long j2) {
        final ArrayList arrayList = new ArrayList(map.size());
        map.forEach(new BiConsumer() { // from class: io.opentelemetry.sdk.metrics.internal.aggregator.MetricDataUtils$$ExternalSyntheticLambda3
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                LongAccumulation longAccumulation = (LongAccumulation) obj2;
                arrayList.add(ImmutableLongPointData.create(j, j2, (Attributes) obj, longAccumulation.getValue(), longAccumulation.getExemplars()));
            }
        });
        return arrayList;
    }

    static List<DoublePointData> toDoublePointList(Map<Attributes, DoubleAccumulation> map, final long j, final long j2) {
        final ArrayList arrayList = new ArrayList(map.size());
        map.forEach(new BiConsumer() { // from class: io.opentelemetry.sdk.metrics.internal.aggregator.MetricDataUtils$$ExternalSyntheticLambda2
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                DoubleAccumulation doubleAccumulation = (DoubleAccumulation) obj2;
                arrayList.add(ImmutableDoublePointData.create(j, j2, (Attributes) obj, doubleAccumulation.getValue(), doubleAccumulation.getExemplars()));
            }
        });
        return arrayList;
    }

    static List<HistogramPointData> toExplicitBucketHistogramPointList(Map<Attributes, ExplicitBucketHistogramAccumulation> map, final long j, final long j2, final List<Double> list) {
        final ArrayList arrayList = new ArrayList(map.size());
        map.forEach(new BiConsumer() { // from class: io.opentelemetry.sdk.metrics.internal.aggregator.MetricDataUtils$$ExternalSyntheticLambda1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ExplicitBucketHistogramAccumulation explicitBucketHistogramAccumulation = (ExplicitBucketHistogramAccumulation) obj2;
                arrayList.add(ImmutableHistogramPointData.create(j, j2, (Attributes) obj, explicitBucketHistogramAccumulation.getSum(), Double.valueOf(explicitBucketHistogramAccumulation.getMin()), Double.valueOf(explicitBucketHistogramAccumulation.getMax()), list, PrimitiveLongList.wrap((long[]) explicitBucketHistogramAccumulation.getCounts().clone()), explicitBucketHistogramAccumulation.getExemplars()));
            }
        });
        return arrayList;
    }

    static List<ExponentialHistogramPointData> toExponentialHistogramPointList(Map<Attributes, ExponentialHistogramAccumulation> map, final long j, final long j2) {
        final ArrayList arrayList = new ArrayList(map.size());
        map.forEach(new BiConsumer() { // from class: io.opentelemetry.sdk.metrics.internal.aggregator.MetricDataUtils$$ExternalSyntheticLambda0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ExponentialHistogramAccumulation exponentialHistogramAccumulation = (ExponentialHistogramAccumulation) obj2;
                arrayList.add(ExponentialHistogramPointData.create(exponentialHistogramAccumulation.getScale(), exponentialHistogramAccumulation.getSum(), exponentialHistogramAccumulation.getZeroCount(), Double.valueOf(exponentialHistogramAccumulation.getMin()), Double.valueOf(exponentialHistogramAccumulation.getMax()), exponentialHistogramAccumulation.getPositiveBuckets(), exponentialHistogramAccumulation.getNegativeBuckets(), j, j2, (Attributes) obj, exponentialHistogramAccumulation.getExemplars()));
            }
        });
        return arrayList;
    }
}
