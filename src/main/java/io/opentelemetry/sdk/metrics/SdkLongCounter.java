package io.opentelemetry.sdk.metrics;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.DoubleCounterBuilder;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.LongCounterBuilder;
import io.opentelemetry.api.metrics.ObservableLongCounter;
import io.opentelemetry.api.metrics.ObservableLongMeasurement;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.internal.ThrottlingLogger;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.instrument.BoundLongCounter;
import io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle;
import io.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import io.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
final class SdkLongCounter extends AbstractInstrument implements LongCounter {
    private static final Logger logger = Logger.getLogger(SdkLongCounter.class.getName());
    private final WriteableMetricStorage storage;
    private final ThrottlingLogger throttlingLogger;

    private SdkLongCounter(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
        super(instrumentDescriptor);
        this.throttlingLogger = new ThrottlingLogger(logger);
        this.storage = writeableMetricStorage;
    }

    @Override // io.opentelemetry.api.metrics.LongCounter
    public void add(long j, Attributes attributes, Context context) {
        if (j < 0) {
            this.throttlingLogger.log(Level.WARNING, "Counters can only increase. Instrument " + getDescriptor().getName() + " has recorded a negative value.");
        } else {
            this.storage.recordLong(j, attributes, context);
        }
    }

    @Override // io.opentelemetry.api.metrics.LongCounter
    public void add(long j, Attributes attributes) {
        add(j, attributes, Context.current());
    }

    @Override // io.opentelemetry.api.metrics.LongCounter
    public void add(long j) {
        add(j, Attributes.empty());
    }

    BoundLongCounter bind(Attributes attributes) {
        return new BoundInstrument(getDescriptor(), this.storage.bind(attributes), attributes);
    }

    static final class BoundInstrument implements BoundLongCounter {
        private final Attributes attributes;
        private final InstrumentDescriptor descriptor;
        private final BoundStorageHandle handle;
        private final ThrottlingLogger throttlingLogger = new ThrottlingLogger(SdkLongCounter.logger);

        BoundInstrument(InstrumentDescriptor instrumentDescriptor, BoundStorageHandle boundStorageHandle, Attributes attributes) {
            this.descriptor = instrumentDescriptor;
            this.handle = boundStorageHandle;
            this.attributes = attributes;
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundLongCounter
        public void add(long j, Context context) {
            if (j < 0) {
                this.throttlingLogger.log(Level.WARNING, "Counters can only increase. Instrument " + this.descriptor.getName() + " has recorded a negative value.");
            } else {
                this.handle.recordLong(j, this.attributes, context);
            }
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundLongCounter
        public void add(long j) {
            add(j, Context.current());
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundLongCounter
        public void unbind() {
            this.handle.release();
        }
    }

    static final class SdkLongCounterBuilder extends AbstractInstrumentBuilder<SdkLongCounterBuilder> implements LongCounterBuilder {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder
        public SdkLongCounterBuilder getThis() {
            return this;
        }

        @Override // io.opentelemetry.api.metrics.LongCounterBuilder
        public /* bridge */ /* synthetic */ LongCounterBuilder setDescription(String str) {
            return (LongCounterBuilder) super.setDescription(str);
        }

        @Override // io.opentelemetry.api.metrics.LongCounterBuilder
        public /* bridge */ /* synthetic */ LongCounterBuilder setUnit(String str) {
            return (LongCounterBuilder) super.setUnit(str);
        }

        SdkLongCounterBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str) {
            super(meterProviderSharedState, meterSharedState, InstrumentType.COUNTER, InstrumentValueType.LONG, str, "", "");
        }

        static /* synthetic */ SdkLongCounter lambda$build$0(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
            return new SdkLongCounter(instrumentDescriptor, writeableMetricStorage);
        }

        @Override // io.opentelemetry.api.metrics.LongCounterBuilder
        public SdkLongCounter build() {
            return (SdkLongCounter) buildSynchronousInstrument(new BiFunction() { // from class: io.opentelemetry.sdk.metrics.SdkLongCounter$SdkLongCounterBuilder$$ExternalSyntheticLambda1
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return SdkLongCounter.SdkLongCounterBuilder.lambda$build$0((InstrumentDescriptor) obj, (WriteableMetricStorage) obj2);
                }
            });
        }

        @Override // io.opentelemetry.api.metrics.LongCounterBuilder
        public DoubleCounterBuilder ofDoubles() {
            return (DoubleCounterBuilder) swapBuilder(new AbstractInstrumentBuilder.SwapBuilder() { // from class: io.opentelemetry.sdk.metrics.SdkLongCounter$SdkLongCounterBuilder$$ExternalSyntheticLambda0
                @Override // io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder.SwapBuilder
                public final Object newBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3) {
                    return new SdkDoubleCounter.SdkDoubleCounterBuilder(meterProviderSharedState, meterSharedState, str, str2, str3);
                }
            });
        }

        @Override // io.opentelemetry.api.metrics.LongCounterBuilder
        public ObservableLongCounter buildWithCallback(Consumer<ObservableLongMeasurement> consumer) {
            return registerLongAsynchronousInstrument(InstrumentType.OBSERVABLE_COUNTER, consumer);
        }

        @Override // io.opentelemetry.api.metrics.LongCounterBuilder
        public ObservableLongMeasurement buildObserver() {
            return buildObservableMeasurement(InstrumentType.OBSERVABLE_COUNTER);
        }
    }
}
