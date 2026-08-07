package io.opentelemetry.sdk.metrics;

import io.opentelemetry.api.metrics.LongGaugeBuilder;
import io.opentelemetry.api.metrics.ObservableLongGauge;
import io.opentelemetry.api.metrics.ObservableLongMeasurement;
import io.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import io.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes4.dex */
final class SdkLongGaugeBuilder extends AbstractInstrumentBuilder<SdkLongGaugeBuilder> implements LongGaugeBuilder {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder
    public SdkLongGaugeBuilder getThis() {
        return this;
    }

    @Override // io.opentelemetry.api.metrics.LongGaugeBuilder
    public /* bridge */ /* synthetic */ LongGaugeBuilder setDescription(String str) {
        return (LongGaugeBuilder) super.setDescription(str);
    }

    @Override // io.opentelemetry.api.metrics.LongGaugeBuilder
    public /* bridge */ /* synthetic */ LongGaugeBuilder setUnit(String str) {
        return (LongGaugeBuilder) super.setUnit(str);
    }

    SdkLongGaugeBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3) {
        super(meterProviderSharedState, meterSharedState, InstrumentType.OBSERVABLE_GAUGE, InstrumentValueType.LONG, str, str2, str3);
    }

    @Override // io.opentelemetry.api.metrics.LongGaugeBuilder
    public ObservableLongGauge buildWithCallback(Consumer<ObservableLongMeasurement> consumer) {
        return registerLongAsynchronousInstrument(InstrumentType.OBSERVABLE_GAUGE, consumer);
    }

    @Override // io.opentelemetry.api.metrics.LongGaugeBuilder
    public ObservableLongMeasurement buildObserver() {
        return buildObservableMeasurement(InstrumentType.OBSERVABLE_GAUGE);
    }
}
