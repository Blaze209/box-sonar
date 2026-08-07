package io.opentelemetry.sdk.metrics;

import io.opentelemetry.api.metrics.DoubleGaugeBuilder;
import io.opentelemetry.api.metrics.LongGaugeBuilder;
import io.opentelemetry.api.metrics.ObservableDoubleGauge;
import io.opentelemetry.api.metrics.ObservableDoubleMeasurement;
import io.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import io.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes4.dex */
final class SdkDoubleGaugeBuilder extends AbstractInstrumentBuilder<SdkDoubleGaugeBuilder> implements DoubleGaugeBuilder {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder
    public SdkDoubleGaugeBuilder getThis() {
        return this;
    }

    @Override // io.opentelemetry.api.metrics.DoubleGaugeBuilder
    public /* bridge */ /* synthetic */ DoubleGaugeBuilder setDescription(String str) {
        return (DoubleGaugeBuilder) super.setDescription(str);
    }

    @Override // io.opentelemetry.api.metrics.DoubleGaugeBuilder
    public /* bridge */ /* synthetic */ DoubleGaugeBuilder setUnit(String str) {
        return (DoubleGaugeBuilder) super.setUnit(str);
    }

    SdkDoubleGaugeBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str) {
        super(meterProviderSharedState, meterSharedState, InstrumentType.OBSERVABLE_GAUGE, InstrumentValueType.DOUBLE, str, "", "");
    }

    @Override // io.opentelemetry.api.metrics.DoubleGaugeBuilder
    public LongGaugeBuilder ofLongs() {
        return (LongGaugeBuilder) swapBuilder(new AbstractInstrumentBuilder.SwapBuilder() { // from class: io.opentelemetry.sdk.metrics.SdkDoubleGaugeBuilder$$ExternalSyntheticLambda0
            @Override // io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder.SwapBuilder
            public final Object newBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3) {
                return new SdkLongGaugeBuilder(meterProviderSharedState, meterSharedState, str, str2, str3);
            }
        });
    }

    @Override // io.opentelemetry.api.metrics.DoubleGaugeBuilder
    public ObservableDoubleGauge buildWithCallback(Consumer<ObservableDoubleMeasurement> consumer) {
        return registerDoubleAsynchronousInstrument(InstrumentType.OBSERVABLE_GAUGE, consumer);
    }

    @Override // io.opentelemetry.api.metrics.DoubleGaugeBuilder
    public ObservableDoubleMeasurement buildObserver() {
        return buildObservableMeasurement(InstrumentType.OBSERVABLE_GAUGE);
    }
}
