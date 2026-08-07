package io.opentelemetry.sdk.metrics.internal.view;

import io.opentelemetry.api.internal.Utils;
import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.internal.RandomSupplier;
import io.opentelemetry.sdk.metrics.Aggregation;
import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.data.ExemplarData;
import io.opentelemetry.sdk.metrics.internal.aggregator.Aggregator;
import io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory;
import io.opentelemetry.sdk.metrics.internal.aggregator.DoubleExponentialHistogramAggregator;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter;
import io.opentelemetry.sdk.metrics.internal.exemplar.ExemplarReservoir;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes4.dex */
public final class ExponentialHistogramAggregation implements Aggregation, AggregatorFactory {
    private static final Aggregation DEFAULT = new ExponentialHistogramAggregation(160);
    private static final int DEFAULT_MAX_BUCKETS = 160;
    private static final int DEFAULT_STARTING_SCALE = 20;
    private final int maxBuckets;

    private ExponentialHistogramAggregation(int i) {
        this.maxBuckets = i;
    }

    public static Aggregation getDefault() {
        return DEFAULT;
    }

    public static Aggregation create(int i) {
        Utils.checkArgument(i >= 1, "maxBuckets must be > 0");
        return new ExponentialHistogramAggregation(i);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory
    public <T, U extends ExemplarData> Aggregator<T, U> createAggregator(InstrumentDescriptor instrumentDescriptor, final ExemplarFilter exemplarFilter) {
        return new DoubleExponentialHistogramAggregator(new Supplier() { // from class: io.opentelemetry.sdk.metrics.internal.view.ExponentialHistogramAggregation$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return ExemplarReservoir.filtered(exemplarFilter, ExemplarReservoir.doubleFixedSizeReservoir(Clock.getDefault(), Runtime.getRuntime().availableProcessors(), RandomSupplier.platformDefault()));
            }
        }, this.maxBuckets, 20);
    }

    /* JADX INFO: renamed from: io.opentelemetry.sdk.metrics.internal.view.ExponentialHistogramAggregation$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType;

        static {
            int[] iArr = new int[InstrumentType.values().length];
            $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType = iArr;
            try {
                iArr[InstrumentType.COUNTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType[InstrumentType.HISTOGRAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // io.opentelemetry.sdk.metrics.internal.aggregator.AggregatorFactory
    public boolean isCompatibleWithInstrument(InstrumentDescriptor instrumentDescriptor) {
        int i = AnonymousClass1.$SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType[instrumentDescriptor.getType().ordinal()];
        return i == 1 || i == 2;
    }

    public String toString() {
        return "ExponentialHistogramAggregation{maxBuckets=" + this.maxBuckets + "}";
    }
}
