package io.opentelemetry.sdk.logs;

import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.resources.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes4.dex */
public final class SdkLoggerProviderBuilder {
    private final List<LogRecordProcessor> logRecordProcessors = new ArrayList();
    private Resource resource = Resource.getDefault();
    private Supplier<LogLimits> logLimitsSupplier = new Supplier() { // from class: io.opentelemetry.sdk.logs.SdkLoggerProviderBuilder$$ExternalSyntheticLambda0
        @Override // java.util.function.Supplier
        public final Object get() {
            return LogLimits.getDefault();
        }
    };
    private Clock clock = Clock.getDefault();

    SdkLoggerProviderBuilder() {
    }

    public SdkLoggerProviderBuilder setResource(Resource resource) {
        Objects.requireNonNull(resource, "resource");
        this.resource = resource;
        return this;
    }

    public SdkLoggerProviderBuilder setLogLimits(Supplier<LogLimits> supplier) {
        Objects.requireNonNull(supplier, "logLimitsSupplier");
        this.logLimitsSupplier = supplier;
        return this;
    }

    public SdkLoggerProviderBuilder addLogRecordProcessor(LogRecordProcessor logRecordProcessor) {
        Objects.requireNonNull(logRecordProcessor, "processor");
        this.logRecordProcessors.add(logRecordProcessor);
        return this;
    }

    public SdkLoggerProviderBuilder setClock(Clock clock) {
        Objects.requireNonNull(clock, "clock");
        this.clock = clock;
        return this;
    }

    public SdkLoggerProvider build() {
        return new SdkLoggerProvider(this.resource, this.logLimitsSupplier, this.logRecordProcessors, this.clock);
    }
}
