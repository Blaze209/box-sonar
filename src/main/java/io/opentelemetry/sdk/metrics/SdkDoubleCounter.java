package io.opentelemetry.sdk.metrics;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.DoubleCounter;
import io.opentelemetry.api.metrics.DoubleCounterBuilder;
import io.opentelemetry.api.metrics.ObservableDoubleCounter;
import io.opentelemetry.api.metrics.ObservableDoubleMeasurement;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.internal.ThrottlingLogger;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleCounter;
import io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle;
import io.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import io.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
final class SdkDoubleCounter extends AbstractInstrument implements DoubleCounter {
    private static final Logger logger = Logger.getLogger(SdkDoubleCounter.class.getName());
    private final WriteableMetricStorage storage;
    private final ThrottlingLogger throttlingLogger;

    private SdkDoubleCounter(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
        super(instrumentDescriptor);
        this.throttlingLogger = new ThrottlingLogger(logger);
        this.storage = writeableMetricStorage;
    }

    @Override // io.opentelemetry.api.metrics.DoubleCounter
    public void add(double d, Attributes attributes, Context context) {
        if (d < 0.0d) {
            this.throttlingLogger.log(Level.WARNING, "Counters can only increase. Instrument " + getDescriptor().getName() + " has recorded a negative value.");
        } else {
            this.storage.recordDouble(d, attributes, context);
        }
    }

    @Override // io.opentelemetry.api.metrics.DoubleCounter
    public void add(double d, Attributes attributes) {
        add(d, attributes, Context.current());
    }

    @Override // io.opentelemetry.api.metrics.DoubleCounter
    public void add(double d) {
        add(d, Attributes.empty());
    }

    BoundDoubleCounter bind(Attributes attributes) {
        return new BoundInstrument(getDescriptor(), this.storage.bind(attributes), attributes);
    }

    static final class BoundInstrument implements BoundDoubleCounter {
        private final Attributes attributes;
        private final InstrumentDescriptor descriptor;
        private final BoundStorageHandle handle;
        private final ThrottlingLogger throttlingLogger = new ThrottlingLogger(SdkDoubleCounter.logger);

        BoundInstrument(InstrumentDescriptor instrumentDescriptor, BoundStorageHandle boundStorageHandle, Attributes attributes) {
            this.descriptor = instrumentDescriptor;
            this.handle = boundStorageHandle;
            this.attributes = attributes;
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleCounter
        public void add(double d, Context context) {
            if (d < 0.0d) {
                this.throttlingLogger.log(Level.WARNING, "Counters can only increase. Instrument " + this.descriptor.getName() + " has recorded a negative value.");
            } else {
                this.handle.recordDouble(d, this.attributes, context);
            }
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleCounter
        public void add(double d) {
            add(d, Context.current());
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleCounter
        public void unbind() {
            this.handle.release();
        }
    }

    static final class SdkDoubleCounterBuilder extends AbstractInstrumentBuilder<SdkDoubleCounterBuilder> implements DoubleCounterBuilder {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder
        public SdkDoubleCounterBuilder getThis() {
            return this;
        }

        @Override // io.opentelemetry.api.metrics.DoubleCounterBuilder
        public /* bridge */ /* synthetic */ DoubleCounterBuilder setDescription(String str) {
            return (DoubleCounterBuilder) super.setDescription(str);
        }

        @Override // io.opentelemetry.api.metrics.DoubleCounterBuilder
        public /* bridge */ /* synthetic */ DoubleCounterBuilder setUnit(String str) {
            return (DoubleCounterBuilder) super.setUnit(str);
        }

        SdkDoubleCounterBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3) {
            super(meterProviderSharedState, meterSharedState, InstrumentType.COUNTER, InstrumentValueType.DOUBLE, str, str2, str3);
        }

        static /* synthetic */ SdkDoubleCounter lambda$build$0(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
            return new SdkDoubleCounter(instrumentDescriptor, writeableMetricStorage);
        }

        @Override // io.opentelemetry.api.metrics.DoubleCounterBuilder
        public SdkDoubleCounter build() {
            return (SdkDoubleCounter) buildSynchronousInstrument(new BiFunction() { // from class: io.opentelemetry.sdk.metrics.SdkDoubleCounter$SdkDoubleCounterBuilder$$ExternalSyntheticLambda0
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return SdkDoubleCounter.SdkDoubleCounterBuilder.lambda$build$0((InstrumentDescriptor) obj, (WriteableMetricStorage) obj2);
                }
            });
        }

        @Override // io.opentelemetry.api.metrics.DoubleCounterBuilder
        public ObservableDoubleCounter buildWithCallback(Consumer<ObservableDoubleMeasurement> consumer) {
            return registerDoubleAsynchronousInstrument(InstrumentType.OBSERVABLE_COUNTER, consumer);
        }

        @Override // io.opentelemetry.api.metrics.DoubleCounterBuilder
        public ObservableDoubleMeasurement buildObserver() {
            return buildObservableMeasurement(InstrumentType.OBSERVABLE_COUNTER);
        }
    }
}
