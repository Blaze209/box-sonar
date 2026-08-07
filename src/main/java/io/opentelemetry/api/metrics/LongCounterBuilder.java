package io.opentelemetry.api.metrics;

import java.util.function.Consumer;

/* JADX INFO: loaded from: classes4.dex */
public interface LongCounterBuilder {
    LongCounter build();

    ObservableLongCounter buildWithCallback(Consumer<ObservableLongMeasurement> consumer);

    DoubleCounterBuilder ofDoubles();

    LongCounterBuilder setDescription(String str);

    LongCounterBuilder setUnit(String str);

    default ObservableLongMeasurement buildObserver() {
        return DefaultMeter.getInstance().counterBuilder("noop").buildObserver();
    }
}
