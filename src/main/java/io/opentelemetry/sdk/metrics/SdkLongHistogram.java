package io.opentelemetry.sdk.metrics;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.LongHistogram;
import io.opentelemetry.api.metrics.LongHistogramBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.internal.ThrottlingLogger;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.instrument.BoundLongHistogram;
import io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle;
import io.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import io.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage;
import java.util.function.BiFunction;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
final class SdkLongHistogram extends AbstractInstrument implements LongHistogram {
    private static final Logger logger = Logger.getLogger(SdkLongHistogram.class.getName());
    private final WriteableMetricStorage storage;
    private final ThrottlingLogger throttlingLogger;

    private SdkLongHistogram(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
        super(instrumentDescriptor);
        this.throttlingLogger = new ThrottlingLogger(logger);
        this.storage = writeableMetricStorage;
    }

    @Override // io.opentelemetry.api.metrics.LongHistogram
    public void record(long j, Attributes attributes, Context context) {
        if (j < 0) {
            this.throttlingLogger.log(Level.WARNING, "Histograms can only record non-negative values. Instrument " + getDescriptor().getName() + " has recorded a negative value.");
        } else {
            this.storage.recordLong(j, attributes, context);
        }
    }

    @Override // io.opentelemetry.api.metrics.LongHistogram
    public void record(long j, Attributes attributes) {
        record(j, attributes, Context.current());
    }

    @Override // io.opentelemetry.api.metrics.LongHistogram
    public void record(long j) {
        record(j, Attributes.empty());
    }

    BoundLongHistogram bind(Attributes attributes) {
        return new BoundInstrument(getDescriptor(), this.storage.bind(attributes), attributes);
    }

    static final class BoundInstrument implements BoundLongHistogram {
        private final Attributes attributes;
        private final InstrumentDescriptor descriptor;
        private final BoundStorageHandle handle;
        private final ThrottlingLogger throttlingLogger = new ThrottlingLogger(SdkLongHistogram.logger);

        BoundInstrument(InstrumentDescriptor instrumentDescriptor, BoundStorageHandle boundStorageHandle, Attributes attributes) {
            this.descriptor = instrumentDescriptor;
            this.handle = boundStorageHandle;
            this.attributes = attributes;
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundLongHistogram
        public void record(long j, Context context) {
            if (j < 0) {
                this.throttlingLogger.log(Level.WARNING, "Histograms can only record non-negative values. Instrument " + this.descriptor.getName() + " has recorded a negative value.");
            } else {
                this.handle.recordLong(j, this.attributes, context);
            }
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundLongHistogram
        public void record(long j) {
            record(j, Context.current());
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundLongHistogram
        public void unbind() {
            this.handle.release();
        }
    }

    static final class SdkLongHistogramBuilder extends AbstractInstrumentBuilder<SdkLongHistogramBuilder> implements LongHistogramBuilder {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder
        public SdkLongHistogramBuilder getThis() {
            return this;
        }

        @Override // io.opentelemetry.api.metrics.LongHistogramBuilder
        public /* bridge */ /* synthetic */ LongHistogramBuilder setDescription(String str) {
            return (LongHistogramBuilder) super.setDescription(str);
        }

        @Override // io.opentelemetry.api.metrics.LongHistogramBuilder
        public /* bridge */ /* synthetic */ LongHistogramBuilder setUnit(String str) {
            return (LongHistogramBuilder) super.setUnit(str);
        }

        SdkLongHistogramBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3) {
            super(meterProviderSharedState, meterSharedState, InstrumentType.HISTOGRAM, InstrumentValueType.LONG, str, str2, str3);
        }

        static /* synthetic */ SdkLongHistogram lambda$build$0(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
            return new SdkLongHistogram(instrumentDescriptor, writeableMetricStorage);
        }

        @Override // io.opentelemetry.api.metrics.LongHistogramBuilder
        public SdkLongHistogram build() {
            return (SdkLongHistogram) buildSynchronousInstrument(new BiFunction() { // from class: io.opentelemetry.sdk.metrics.SdkLongHistogram$SdkLongHistogramBuilder$$ExternalSyntheticLambda0
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return SdkLongHistogram.SdkLongHistogramBuilder.lambda$build$0((InstrumentDescriptor) obj, (WriteableMetricStorage) obj2);
                }
            });
        }
    }
}
