package io.opentelemetry.sdk.metrics;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.DoubleUpDownCounterBuilder;
import io.opentelemetry.api.metrics.LongUpDownCounter;
import io.opentelemetry.api.metrics.LongUpDownCounterBuilder;
import io.opentelemetry.api.metrics.ObservableLongMeasurement;
import io.opentelemetry.api.metrics.ObservableLongUpDownCounter;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.instrument.BoundLongUpDownCounter;
import io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle;
import io.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import io.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes4.dex */
final class SdkLongUpDownCounter extends AbstractInstrument implements LongUpDownCounter {
    private final WriteableMetricStorage storage;

    private SdkLongUpDownCounter(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
        super(instrumentDescriptor);
        this.storage = writeableMetricStorage;
    }

    @Override // io.opentelemetry.api.metrics.LongUpDownCounter
    public void add(long j, Attributes attributes, Context context) {
        this.storage.recordLong(j, attributes, context);
    }

    @Override // io.opentelemetry.api.metrics.LongUpDownCounter
    public void add(long j, Attributes attributes) {
        add(j, attributes, Context.current());
    }

    @Override // io.opentelemetry.api.metrics.LongUpDownCounter
    public void add(long j) {
        add(j, Attributes.empty());
    }

    BoundLongUpDownCounter bind(Attributes attributes) {
        return new BoundInstrument(this.storage.bind(attributes), attributes);
    }

    static final class BoundInstrument implements BoundLongUpDownCounter {
        private final Attributes attributes;
        private final BoundStorageHandle handle;

        BoundInstrument(BoundStorageHandle boundStorageHandle, Attributes attributes) {
            this.handle = boundStorageHandle;
            this.attributes = attributes;
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundLongUpDownCounter
        public void add(long j, Context context) {
            this.handle.recordLong(j, this.attributes, context);
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundLongUpDownCounter
        public void add(long j) {
            add(j, Context.current());
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundLongUpDownCounter
        public void unbind() {
            this.handle.release();
        }
    }

    static final class SdkLongUpDownCounterBuilder extends AbstractInstrumentBuilder<SdkLongUpDownCounterBuilder> implements LongUpDownCounterBuilder {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder
        public SdkLongUpDownCounterBuilder getThis() {
            return this;
        }

        @Override // io.opentelemetry.api.metrics.LongUpDownCounterBuilder
        public /* bridge */ /* synthetic */ LongUpDownCounterBuilder setDescription(String str) {
            return (LongUpDownCounterBuilder) super.setDescription(str);
        }

        @Override // io.opentelemetry.api.metrics.LongUpDownCounterBuilder
        public /* bridge */ /* synthetic */ LongUpDownCounterBuilder setUnit(String str) {
            return (LongUpDownCounterBuilder) super.setUnit(str);
        }

        SdkLongUpDownCounterBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str) {
            super(meterProviderSharedState, meterSharedState, InstrumentType.UP_DOWN_COUNTER, InstrumentValueType.LONG, str, "", "");
        }

        static /* synthetic */ SdkLongUpDownCounter lambda$build$0(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
            return new SdkLongUpDownCounter(instrumentDescriptor, writeableMetricStorage);
        }

        @Override // io.opentelemetry.api.metrics.LongUpDownCounterBuilder
        public LongUpDownCounter build() {
            return (LongUpDownCounter) buildSynchronousInstrument(new BiFunction() { // from class: io.opentelemetry.sdk.metrics.SdkLongUpDownCounter$SdkLongUpDownCounterBuilder$$ExternalSyntheticLambda0
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return SdkLongUpDownCounter.SdkLongUpDownCounterBuilder.lambda$build$0((InstrumentDescriptor) obj, (WriteableMetricStorage) obj2);
                }
            });
        }

        @Override // io.opentelemetry.api.metrics.LongUpDownCounterBuilder
        public DoubleUpDownCounterBuilder ofDoubles() {
            return (DoubleUpDownCounterBuilder) swapBuilder(new AbstractInstrumentBuilder.SwapBuilder() { // from class: io.opentelemetry.sdk.metrics.SdkLongUpDownCounter$SdkLongUpDownCounterBuilder$$ExternalSyntheticLambda1
                @Override // io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder.SwapBuilder
                public final Object newBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3) {
                    return new SdkDoubleUpDownCounter.SdkDoubleUpDownCounterBuilder(meterProviderSharedState, meterSharedState, str, str2, str3);
                }
            });
        }

        @Override // io.opentelemetry.api.metrics.LongUpDownCounterBuilder
        public ObservableLongUpDownCounter buildWithCallback(Consumer<ObservableLongMeasurement> consumer) {
            return registerLongAsynchronousInstrument(InstrumentType.OBSERVABLE_UP_DOWN_COUNTER, consumer);
        }

        @Override // io.opentelemetry.api.metrics.LongUpDownCounterBuilder
        public ObservableLongMeasurement buildObserver() {
            return buildObservableMeasurement(InstrumentType.OBSERVABLE_UP_DOWN_COUNTER);
        }
    }
}
