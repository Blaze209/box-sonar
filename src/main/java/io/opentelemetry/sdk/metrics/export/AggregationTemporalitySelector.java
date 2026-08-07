package io.opentelemetry.sdk.metrics.export;

import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;

/* JADX INFO: loaded from: classes4.dex */
@FunctionalInterface
public interface AggregationTemporalitySelector {
    AggregationTemporality getAggregationTemporality(InstrumentType instrumentType);

    static AggregationTemporalitySelector alwaysCumulative() {
        return new AggregationTemporalitySelector() { // from class: io.opentelemetry.sdk.metrics.export.AggregationTemporalitySelector$$ExternalSyntheticLambda1
            @Override // io.opentelemetry.sdk.metrics.export.AggregationTemporalitySelector
            public final AggregationTemporality getAggregationTemporality(InstrumentType instrumentType) {
                return AggregationTemporality.CUMULATIVE;
            }
        };
    }

    /* JADX INFO: renamed from: io.opentelemetry.sdk.metrics.export.AggregationTemporalitySelector$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType;

        static {
            int[] iArr = new int[InstrumentType.values().length];
            $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType = iArr;
            try {
                iArr[InstrumentType.UP_DOWN_COUNTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType[InstrumentType.OBSERVABLE_UP_DOWN_COUNTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType[InstrumentType.COUNTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType[InstrumentType.OBSERVABLE_COUNTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType[InstrumentType.HISTOGRAM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static AggregationTemporalitySelector deltaPreferred() {
        return new AggregationTemporalitySelector() { // from class: io.opentelemetry.sdk.metrics.export.AggregationTemporalitySelector$$ExternalSyntheticLambda0
            @Override // io.opentelemetry.sdk.metrics.export.AggregationTemporalitySelector
            public final AggregationTemporality getAggregationTemporality(InstrumentType instrumentType) {
                return AggregationTemporalitySelector.lambda$deltaPreferred$1(instrumentType);
            }
        };
    }

    static /* synthetic */ AggregationTemporality lambda$deltaPreferred$1(InstrumentType instrumentType) {
        int i = AnonymousClass1.$SwitchMap$io$opentelemetry$sdk$metrics$InstrumentType[instrumentType.ordinal()];
        if (i == 1 || i == 2) {
            return AggregationTemporality.CUMULATIVE;
        }
        return AggregationTemporality.DELTA;
    }
}
