package io.opentelemetry.sdk.logs;

import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.resources.Resource;
import java.util.function.Supplier;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class LoggerSharedState {
    private final Clock clock;
    private final Supplier<LogLimits> logLimitsSupplier;
    private final LogRecordProcessor logRecordProcessor;
    private final Resource resource;
    private final Object lock = new Object();

    @Nullable
    private volatile CompletableResultCode shutdownResult = null;

    LoggerSharedState(Resource resource, Supplier<LogLimits> supplier, LogRecordProcessor logRecordProcessor, Clock clock) {
        this.resource = resource;
        this.logLimitsSupplier = supplier;
        this.logRecordProcessor = logRecordProcessor;
        this.clock = clock;
    }

    Resource getResource() {
        return this.resource;
    }

    LogLimits getLogLimits() {
        return this.logLimitsSupplier.get();
    }

    LogRecordProcessor getLogRecordProcessor() {
        return this.logRecordProcessor;
    }

    Clock getClock() {
        return this.clock;
    }

    boolean hasBeenShutdown() {
        return this.shutdownResult != null;
    }

    CompletableResultCode shutdown() {
        synchronized (this.lock) {
            if (this.shutdownResult != null) {
                return this.shutdownResult;
            }
            this.shutdownResult = this.logRecordProcessor.shutdown();
            return this.shutdownResult;
        }
    }
}
