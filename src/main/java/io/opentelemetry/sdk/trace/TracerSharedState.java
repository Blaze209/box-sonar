package io.opentelemetry.sdk.trace;

import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.samplers.Sampler;
import java.util.List;
import java.util.function.Supplier;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class TracerSharedState {
    private final SpanProcessor activeSpanProcessor;
    private final Clock clock;
    private final IdGenerator idGenerator;
    private final boolean idGeneratorSafeToSkipIdValidation;
    private final Resource resource;
    private final Sampler sampler;
    private final Supplier<SpanLimits> spanLimitsSupplier;
    private final Object lock = new Object();

    @Nullable
    private volatile CompletableResultCode shutdownResult = null;

    TracerSharedState(Clock clock, IdGenerator idGenerator, Resource resource, Supplier<SpanLimits> supplier, Sampler sampler, List<SpanProcessor> list) {
        this.clock = clock;
        this.idGenerator = idGenerator;
        this.idGeneratorSafeToSkipIdValidation = idGenerator instanceof RandomIdGenerator;
        this.resource = resource;
        this.spanLimitsSupplier = supplier;
        this.sampler = sampler;
        this.activeSpanProcessor = SpanProcessor.composite(list);
    }

    Clock getClock() {
        return this.clock;
    }

    IdGenerator getIdGenerator() {
        return this.idGenerator;
    }

    boolean isIdGeneratorSafeToSkipIdValidation() {
        return this.idGeneratorSafeToSkipIdValidation;
    }

    Resource getResource() {
        return this.resource;
    }

    SpanLimits getSpanLimits() {
        return this.spanLimitsSupplier.get();
    }

    Sampler getSampler() {
        return this.sampler;
    }

    SpanProcessor getActiveSpanProcessor() {
        return this.activeSpanProcessor;
    }

    boolean hasBeenShutdown() {
        return this.shutdownResult != null;
    }

    CompletableResultCode shutdown() {
        synchronized (this.lock) {
            if (this.shutdownResult != null) {
                return this.shutdownResult;
            }
            this.shutdownResult = this.activeSpanProcessor.shutdown();
            return this.shutdownResult;
        }
    }
}
