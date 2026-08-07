package io.opentelemetry.sdk.metrics;

import io.opentelemetry.api.internal.ValidationUtil;
import io.opentelemetry.api.metrics.ObservableDoubleMeasurement;
import io.opentelemetry.api.metrics.ObservableLongMeasurement;
import io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.state.CallbackRegistration;
import io.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import io.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import io.opentelemetry.sdk.metrics.internal.state.SdkObservableMeasurement;
import io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage;
import java.util.Collections;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes4.dex */
abstract class AbstractInstrumentBuilder<BuilderT extends AbstractInstrumentBuilder<?>> {
    static final String DEFAULT_UNIT = "";
    private String description;
    protected final String instrumentName;
    private final MeterProviderSharedState meterProviderSharedState;
    protected final MeterSharedState meterSharedState;
    private final InstrumentType type;
    private String unit;
    private final InstrumentValueType valueType;

    @FunctionalInterface
    protected interface SwapBuilder<T> {
        T newBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3);
    }

    protected abstract BuilderT getThis();

    AbstractInstrumentBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, InstrumentType instrumentType, InstrumentValueType instrumentValueType, String str, String str2, String str3) {
        this.type = instrumentType;
        this.valueType = instrumentValueType;
        this.instrumentName = str;
        this.description = str2;
        this.unit = str3;
        this.meterProviderSharedState = meterProviderSharedState;
        this.meterSharedState = meterSharedState;
    }

    public BuilderT setUnit(String str) {
        if (!ValidationUtil.checkValidInstrumentUnit(str, " Using \"\" for instrument " + this.instrumentName + " instead.")) {
            this.unit = "";
        } else {
            this.unit = str;
        }
        return (BuilderT) getThis();
    }

    public BuilderT setDescription(String str) {
        this.description = str;
        return (BuilderT) getThis();
    }

    protected <T> T swapBuilder(SwapBuilder<T> swapBuilder) {
        return swapBuilder.newBuilder(this.meterProviderSharedState, this.meterSharedState, this.instrumentName, this.description, this.unit);
    }

    final <I extends AbstractInstrument> I buildSynchronousInstrument(BiFunction<InstrumentDescriptor, WriteableMetricStorage, I> biFunction) {
        InstrumentDescriptor instrumentDescriptorCreate = InstrumentDescriptor.create(this.instrumentName, this.description, this.unit, this.type, this.valueType);
        return biFunction.apply(instrumentDescriptorCreate, this.meterSharedState.registerSynchronousMetricStorage(instrumentDescriptorCreate, this.meterProviderSharedState));
    }

    final SdkObservableInstrument registerDoubleAsynchronousInstrument(InstrumentType instrumentType, final Consumer<ObservableDoubleMeasurement> consumer) {
        final SdkObservableMeasurement sdkObservableMeasurementBuildObservableMeasurement = buildObservableMeasurement(instrumentType);
        CallbackRegistration callbackRegistrationCreate = CallbackRegistration.create(Collections.singletonList(sdkObservableMeasurementBuildObservableMeasurement), new Runnable() { // from class: io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                consumer.accept(sdkObservableMeasurementBuildObservableMeasurement);
            }
        });
        this.meterSharedState.registerCallback(callbackRegistrationCreate);
        return new SdkObservableInstrument(this.meterSharedState, callbackRegistrationCreate);
    }

    final SdkObservableInstrument registerLongAsynchronousInstrument(InstrumentType instrumentType, final Consumer<ObservableLongMeasurement> consumer) {
        final SdkObservableMeasurement sdkObservableMeasurementBuildObservableMeasurement = buildObservableMeasurement(instrumentType);
        CallbackRegistration callbackRegistrationCreate = CallbackRegistration.create(Collections.singletonList(sdkObservableMeasurementBuildObservableMeasurement), new Runnable() { // from class: io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                consumer.accept(sdkObservableMeasurementBuildObservableMeasurement);
            }
        });
        this.meterSharedState.registerCallback(callbackRegistrationCreate);
        return new SdkObservableInstrument(this.meterSharedState, callbackRegistrationCreate);
    }

    final SdkObservableMeasurement buildObservableMeasurement(InstrumentType instrumentType) {
        return this.meterSharedState.registerObservableMeasurement(InstrumentDescriptor.create(this.instrumentName, this.description, this.unit, instrumentType, this.valueType));
    }

    public String toString() {
        return getClass().getSimpleName() + "{descriptor=" + InstrumentDescriptor.create(this.instrumentName, this.description, this.unit, this.type, this.valueType) + "}";
    }
}
