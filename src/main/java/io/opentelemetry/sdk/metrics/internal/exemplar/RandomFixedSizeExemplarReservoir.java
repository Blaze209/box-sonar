package io.opentelemetry.sdk.metrics.internal.exemplar;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import io.opentelemetry.sdk.metrics.data.ExemplarData;
import io.opentelemetry.sdk.metrics.data.LongExemplarData;
import io.opentelemetry.sdk.metrics.internal.concurrent.AdderUtil;
import io.opentelemetry.sdk.metrics.internal.concurrent.LongAdder;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes4.dex */
class RandomFixedSizeExemplarReservoir<T extends ExemplarData> extends FixedSizeExemplarReservoir<T> {
    private RandomFixedSizeExemplarReservoir(Clock clock, int i, Supplier<Random> supplier, BiFunction<ReservoirCell, Attributes, T> biFunction) {
        super(clock, i, new RandomCellSelector(supplier), biFunction);
    }

    static RandomFixedSizeExemplarReservoir<LongExemplarData> createLong(Clock clock, int i, Supplier<Random> supplier) {
        return new RandomFixedSizeExemplarReservoir<>(clock, i, supplier, new BiFunction() { // from class: io.opentelemetry.sdk.metrics.internal.exemplar.RandomFixedSizeExemplarReservoir$$ExternalSyntheticLambda0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return ((ReservoirCell) obj).getAndResetLong((Attributes) obj2);
            }
        });
    }

    static RandomFixedSizeExemplarReservoir<DoubleExemplarData> createDouble(Clock clock, int i, Supplier<Random> supplier) {
        return new RandomFixedSizeExemplarReservoir<>(clock, i, supplier, new HistogramExemplarReservoir$$ExternalSyntheticLambda0());
    }

    static class RandomCellSelector implements ReservoirCellSelector {
        private final LongAdder numMeasurements;
        private final Supplier<Random> randomSupplier;

        private RandomCellSelector(Supplier<Random> supplier) {
            this.numMeasurements = AdderUtil.createLongAdder();
            this.randomSupplier = supplier;
        }

        @Override // io.opentelemetry.sdk.metrics.internal.exemplar.ReservoirCellSelector
        public int reservoirCellIndexFor(ReservoirCell[] reservoirCellArr, long j, Attributes attributes, Context context) {
            return reservoirCellIndex(reservoirCellArr);
        }

        @Override // io.opentelemetry.sdk.metrics.internal.exemplar.ReservoirCellSelector
        public int reservoirCellIndexFor(ReservoirCell[] reservoirCellArr, double d, Attributes attributes, Context context) {
            return reservoirCellIndex(reservoirCellArr);
        }

        private int reservoirCellIndex(ReservoirCell[] reservoirCellArr) {
            int iIntValue = this.numMeasurements.intValue() + 1;
            int iNextInt = this.randomSupplier.get().nextInt(iIntValue > 0 ? iIntValue : 1);
            this.numMeasurements.increment();
            if (iNextInt < reservoirCellArr.length) {
                return iNextInt;
            }
            return -1;
        }

        @Override // io.opentelemetry.sdk.metrics.internal.exemplar.ReservoirCellSelector
        public void reset() {
            this.numMeasurements.reset();
        }
    }
}
