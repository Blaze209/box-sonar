package io.opentelemetry.api.metrics;

import java.util.function.Consumer;

/* JADX INFO: loaded from: classes4.dex */
public interface LongGaugeBuilder {
    ObservableLongGauge buildWithCallback(Consumer<ObservableLongMeasurement> consumer);

    LongGaugeBuilder setDescription(String str);

    LongGaugeBuilder setUnit(String str);

    default ObservableLongMeasurement buildObserver() {
        return DefaultMeter.getInstance().gaugeBuilder("noop").ofLongs().buildObserver();
    }
}
