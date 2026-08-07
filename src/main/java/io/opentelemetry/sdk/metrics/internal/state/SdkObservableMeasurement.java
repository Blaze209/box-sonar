package io.opentelemetry.sdk.metrics.internal.state;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.ObservableDoubleMeasurement;
import io.opentelemetry.api.metrics.ObservableLongMeasurement;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.internal.ThrottlingLogger;
import io.opentelemetry.sdk.metrics.internal.descriptor.InstrumentDescriptor;
import io.opentelemetry.sdk.metrics.internal.export.RegisteredReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class SdkObservableMeasurement implements ObservableLongMeasurement, ObservableDoubleMeasurement {
    private static final Logger logger = Logger.getLogger(SdkObservableMeasurement.class.getName());

    @Nullable
    private volatile RegisteredReader activeReader;
    private final InstrumentDescriptor instrumentDescriptor;
    private final InstrumentationScopeInfo instrumentationScopeInfo;
    private final List<AsynchronousMetricStorage<?, ?>> storages;
    private final ThrottlingLogger throttlingLogger = new ThrottlingLogger(logger);

    private SdkObservableMeasurement(InstrumentationScopeInfo instrumentationScopeInfo, InstrumentDescriptor instrumentDescriptor, List<AsynchronousMetricStorage<?, ?>> list) {
        this.instrumentationScopeInfo = instrumentationScopeInfo;
        this.instrumentDescriptor = instrumentDescriptor;
        this.storages = list;
    }

    public static SdkObservableMeasurement create(InstrumentationScopeInfo instrumentationScopeInfo, InstrumentDescriptor instrumentDescriptor, List<AsynchronousMetricStorage<?, ?>> list) {
        return new SdkObservableMeasurement(instrumentationScopeInfo, instrumentDescriptor, list);
    }

    public InstrumentationScopeInfo getInstrumentationScopeInfo() {
        return this.instrumentationScopeInfo;
    }

    public void setActiveReader(@Nullable RegisteredReader registeredReader) {
        this.activeReader = registeredReader;
    }

    InstrumentDescriptor getInstrumentDescriptor() {
        return this.instrumentDescriptor;
    }

    List<AsynchronousMetricStorage<?, ?>> getStorages() {
        return this.storages;
    }

    @Override // io.opentelemetry.api.metrics.ObservableLongMeasurement
    public void record(long j) {
        record(j, Attributes.empty());
    }

    @Override // io.opentelemetry.api.metrics.ObservableLongMeasurement
    public void record(long j, Attributes attributes) {
        RegisteredReader registeredReader = this.activeReader;
        if (registeredReader == null) {
            this.throttlingLogger.log(Level.FINE, "Measurement recorded for instrument " + this.instrumentDescriptor.getName() + " outside callback registered to instrument. Dropping measurement.");
            return;
        }
        for (AsynchronousMetricStorage<?, ?> asynchronousMetricStorage : this.storages) {
            if (asynchronousMetricStorage.getRegisteredReader().equals(registeredReader)) {
                asynchronousMetricStorage.recordLong(j, attributes);
            }
        }
    }

    @Override // io.opentelemetry.api.metrics.ObservableDoubleMeasurement
    public void record(double d) {
        record(d, Attributes.empty());
    }

    @Override // io.opentelemetry.api.metrics.ObservableDoubleMeasurement
    public void record(double d, Attributes attributes) {
        RegisteredReader registeredReader = this.activeReader;
        if (registeredReader == null) {
            this.throttlingLogger.log(Level.FINE, "Measurement recorded for instrument " + this.instrumentDescriptor.getName() + " outside callback registered to instrument. Dropping measurement.");
            return;
        }
        for (AsynchronousMetricStorage<?, ?> asynchronousMetricStorage : this.storages) {
            if (asynchronousMetricStorage.getRegisteredReader().equals(registeredReader)) {
                asynchronousMetricStorage.recordDouble(d, attributes);
            }
        }
    }
}
