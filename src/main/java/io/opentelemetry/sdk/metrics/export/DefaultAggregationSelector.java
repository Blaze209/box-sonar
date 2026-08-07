package io.opentelemetry.sdk.metrics.export;

import io.opentelemetry.sdk.metrics.Aggregation;
import io.opentelemetry.sdk.metrics.InstrumentType;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
@FunctionalInterface
public interface DefaultAggregationSelector {
    Aggregation getDefaultAggregation(InstrumentType instrumentType);

    static DefaultAggregationSelector getDefault() {
        return new DefaultAggregationSelector() { // from class: io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector$$ExternalSyntheticLambda1
            @Override // io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector
            public final Aggregation getDefaultAggregation(InstrumentType instrumentType) {
                return Aggregation.defaultAggregation();
            }
        };
    }

    default DefaultAggregationSelector with(final InstrumentType instrumentType, final Aggregation aggregation) {
        Objects.requireNonNull(instrumentType, "instrumentType");
        Objects.requireNonNull(aggregation, "aggregation");
        return new DefaultAggregationSelector() { // from class: io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector$$ExternalSyntheticLambda0
            @Override // io.opentelemetry.sdk.metrics.export.DefaultAggregationSelector
            public final Aggregation getDefaultAggregation(InstrumentType instrumentType2) {
                return DefaultAggregationSelector.lambda$with$1(this.f$0, instrumentType, aggregation, instrumentType2);
            }
        };
    }

    static /* synthetic */ Aggregation lambda$with$1(DefaultAggregationSelector _this, InstrumentType instrumentType, Aggregation aggregation, InstrumentType instrumentType2) {
        return instrumentType2 == instrumentType ? aggregation : _this.getDefaultAggregation(instrumentType2);
    }
}
