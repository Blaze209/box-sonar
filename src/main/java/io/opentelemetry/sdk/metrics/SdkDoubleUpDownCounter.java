package io.opentelemetry.sdk.metrics;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.DoubleUpDownCounter;
import io.opentelemetry.api.metrics.DoubleUpDownCounterBuilder;
import io.opentelemetry.api.metrics.ObservableDoubleMeasurement;
import io.opentelemetry.api.metrics.ObservableDoubleUpDownCounter;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleUpDownCounter;
import io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle;
import io.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import io.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes4.dex */
final class SdkDoubleUpDownCounter extends AbstractInstrument implements DoubleUpDownCounter {
    private final WriteableMetricStorage storage;

    private SdkDoubleUpDownCounter(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
        super(instrumentDescriptor);
        this.storage = writeableMetricStorage;
    }

    @Override // io.opentelemetry.api.metrics.DoubleUpDownCounter
    public void add(double d, Attributes attributes, Context context) {
        this.storage.recordDouble(d, attributes, context);
    }

    @Override // io.opentelemetry.api.metrics.DoubleUpDownCounter
    public void add(double d, Attributes attributes) {
        add(d, attributes, Context.current());
    }

    @Override // io.opentelemetry.api.metrics.DoubleUpDownCounter
    public void add(double d) {
        add(d, Attributes.empty());
    }

    BoundDoubleUpDownCounter bind(Attributes attributes) {
        return new BoundInstrument(this.storage.bind(attributes), attributes);
    }

    static final class BoundInstrument implements BoundDoubleUpDownCounter {
        private final Attributes attributes;
        private final BoundStorageHandle handle;

        BoundInstrument(BoundStorageHandle boundStorageHandle, Attributes attributes) {
            this.handle = boundStorageHandle;
            this.attributes = attributes;
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleUpDownCounter
        public void add(double d, Context context) {
            this.handle.recordDouble(d, this.attributes, context);
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleUpDownCounter
        public void add(double d) {
            add(d, Context.current());
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleUpDownCounter
        public void unbind() {
            this.handle.release();
        }
    }

    static final class SdkDoubleUpDownCounterBuilder extends AbstractInstrumentBuilder<SdkDoubleUpDownCounterBuilder> implements DoubleUpDownCounterBuilder {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder
        public SdkDoubleUpDownCounterBuilder getThis() {
            return this;
        }

        @Override // io.opentelemetry.api.metrics.DoubleUpDownCounterBuilder
        public /* bridge */ /* synthetic */ DoubleUpDownCounterBuilder setDescription(String str) {
            return (DoubleUpDownCounterBuilder) super.setDescription(str);
        }

        @Override // io.opentelemetry.api.metrics.DoubleUpDownCounterBuilder
        public /* bridge */ /* synthetic */ DoubleUpDownCounterBuilder setUnit(String str) {
            return (DoubleUpDownCounterBuilder) super.setUnit(str);
        }

        SdkDoubleUpDownCounterBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3) {
            super(meterProviderSharedState, meterSharedState, InstrumentType.UP_DOWN_COUNTER, InstrumentValueType.DOUBLE, str, str2, str3);
        }

        static /* synthetic */ SdkDoubleUpDownCounter lambda$build$0(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
            return new SdkDoubleUpDownCounter(instrumentDescriptor, writeableMetricStorage);
        }

        @Override // io.opentelemetry.api.metrics.DoubleUpDownCounterBuilder
        public DoubleUpDownCounter build() {
            return (DoubleUpDownCounter) buildSynchronousInstrument(new BiFunction() { // from class: io.opentelemetry.sdk.metrics.SdkDoubleUpDownCounter$SdkDoubleUpDownCounterBuilder$$ExternalSyntheticLambda0
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return SdkDoubleUpDownCounter.SdkDoubleUpDownCounterBuilder.lambda$build$0((InstrumentDescriptor) obj, (WriteableMetricStorage) obj2);
                }
            });
        }

        @Override // io.opentelemetry.api.metrics.DoubleUpDownCounterBuilder
        public ObservableDoubleUpDownCounter buildWithCallback(Consumer<ObservableDoubleMeasurement> consumer) {
            return registerDoubleAsynchronousInstrument(InstrumentType.OBSERVABLE_UP_DOWN_COUNTER, consumer);
        }

        @Override // io.opentelemetry.api.metrics.DoubleUpDownCounterBuilder
        public ObservableDoubleMeasurement buildObserver() {
            return buildObservableMeasurement(InstrumentType.OBSERVABLE_UP_DOWN_COUNTER);
        }
    }
}
