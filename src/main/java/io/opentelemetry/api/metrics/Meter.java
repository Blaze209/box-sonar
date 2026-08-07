package io.opentelemetry.api.metrics;

/* JADX INFO: loaded from: classes4.dex */
public interface Meter {
    LongCounterBuilder counterBuilder(String str);

    DoubleGaugeBuilder gaugeBuilder(String str);

    DoubleHistogramBuilder histogramBuilder(String str);

    LongUpDownCounterBuilder upDownCounterBuilder(String str);

    default BatchCallback batchCallback(Runnable runnable, ObservableMeasurement observableMeasurement, ObservableMeasurement... observableMeasurementArr) {
        return DefaultMeter.getInstance().batchCallback(runnable, observableMeasurement, observableMeasurementArr);
    }
}
