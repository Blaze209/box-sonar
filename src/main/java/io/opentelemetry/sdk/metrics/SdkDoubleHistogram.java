package io.opentelemetry.sdk.metrics;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.DoubleHistogram;
import io.opentelemetry.api.metrics.DoubleHistogramBuilder;
import io.opentelemetry.api.metrics.LongHistogramBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.internal.ThrottlingLogger;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleHistogram;
import io.opentelemetry.sdk.metrics.internal.state.BoundStorageHandle;
import io.opentelemetry.sdk.metrics.internal.state.MeterProviderSharedState;
import io.opentelemetry.sdk.metrics.internal.state.MeterSharedState;
import io.opentelemetry.sdk.metrics.internal.state.WriteableMetricStorage;
import java.util.function.BiFunction;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
final class SdkDoubleHistogram extends AbstractInstrument implements DoubleHistogram {
    private static final Logger logger = Logger.getLogger(SdkDoubleHistogram.class.getName());
    private final WriteableMetricStorage storage;
    private final ThrottlingLogger throttlingLogger;

    private SdkDoubleHistogram(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
        super(instrumentDescriptor);
        this.throttlingLogger = new ThrottlingLogger(logger);
        this.storage = writeableMetricStorage;
    }

    @Override // io.opentelemetry.api.metrics.DoubleHistogram
    public void record(double d, Attributes attributes, Context context) {
        if (d < 0.0d) {
            this.throttlingLogger.log(Level.WARNING, "Histograms can only record non-negative values. Instrument " + getDescriptor().getName() + " has recorded a negative value.");
        } else {
            this.storage.recordDouble(d, attributes, context);
        }
    }

    @Override // io.opentelemetry.api.metrics.DoubleHistogram
    public void record(double d, Attributes attributes) {
        record(d, attributes, Context.current());
    }

    @Override // io.opentelemetry.api.metrics.DoubleHistogram
    public void record(double d) {
        record(d, Attributes.empty());
    }

    BoundDoubleHistogram bind(Attributes attributes) {
        return new BoundInstrument(getDescriptor(), this.storage.bind(attributes), attributes);
    }

    static final class BoundInstrument implements BoundDoubleHistogram {
        private final BoundStorageHandle aggregatorHandle;
        private final Attributes attributes;
        private final InstrumentDescriptor descriptor;
        private final ThrottlingLogger throttlingLogger = new ThrottlingLogger(SdkDoubleHistogram.logger);

        BoundInstrument(InstrumentDescriptor instrumentDescriptor, BoundStorageHandle boundStorageHandle, Attributes attributes) {
            this.descriptor = instrumentDescriptor;
            this.aggregatorHandle = boundStorageHandle;
            this.attributes = attributes;
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleHistogram
        public void record(double d, Context context) {
            if (d < 0.0d) {
                this.throttlingLogger.log(Level.WARNING, "Histograms can only record non-negative values. Instrument " + this.descriptor.getName() + " has recorded a negative value.");
            } else {
                this.aggregatorHandle.recordDouble(d, this.attributes, context);
            }
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleHistogram
        public void record(double d) {
            record(d, Context.current());
        }

        @Override // io.opentelemetry.sdk.metrics.internal.instrument.BoundDoubleHistogram
        public void unbind() {
            this.aggregatorHandle.release();
        }
    }

    static final class SdkDoubleHistogramBuilder extends AbstractInstrumentBuilder<SdkDoubleHistogramBuilder> implements DoubleHistogramBuilder {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder
        public SdkDoubleHistogramBuilder getThis() {
            return this;
        }

        @Override // io.opentelemetry.api.metrics.DoubleHistogramBuilder
        public /* bridge */ /* synthetic */ DoubleHistogramBuilder setDescription(String str) {
            return (DoubleHistogramBuilder) super.setDescription(str);
        }

        @Override // io.opentelemetry.api.metrics.DoubleHistogramBuilder
        public /* bridge */ /* synthetic */ DoubleHistogramBuilder setUnit(String str) {
            return (DoubleHistogramBuilder) super.setUnit(str);
        }

        SdkDoubleHistogramBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str) {
            super(meterProviderSharedState, meterSharedState, InstrumentType.HISTOGRAM, InstrumentValueType.DOUBLE, str, "", "");
        }

        static /* synthetic */ SdkDoubleHistogram lambda$build$0(InstrumentDescriptor instrumentDescriptor, WriteableMetricStorage writeableMetricStorage) {
            return new SdkDoubleHistogram(instrumentDescriptor, writeableMetricStorage);
        }

        @Override // io.opentelemetry.api.metrics.DoubleHistogramBuilder
        public SdkDoubleHistogram build() {
            return (SdkDoubleHistogram) buildSynchronousInstrument(new BiFunction() { // from class: io.opentelemetry.sdk.metrics.SdkDoubleHistogram$SdkDoubleHistogramBuilder$$ExternalSyntheticLambda1
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return SdkDoubleHistogram.SdkDoubleHistogramBuilder.lambda$build$0((InstrumentDescriptor) obj, (WriteableMetricStorage) obj2);
                }
            });
        }

        @Override // io.opentelemetry.api.metrics.DoubleHistogramBuilder
        public LongHistogramBuilder ofLongs() {
            return (LongHistogramBuilder) swapBuilder(new AbstractInstrumentBuilder.SwapBuilder() { // from class: io.opentelemetry.sdk.metrics.SdkDoubleHistogram$SdkDoubleHistogramBuilder$$ExternalSyntheticLambda0
                @Override // io.opentelemetry.sdk.metrics.AbstractInstrumentBuilder.SwapBuilder
                public final Object newBuilder(MeterProviderSharedState meterProviderSharedState, MeterSharedState meterSharedState, String str, String str2, String str3) {
                    return new SdkLongHistogram.SdkLongHistogramBuilder(meterProviderSharedState, meterSharedState, str, str2, str3);
                }
            });
        }
    }
}
