package io.opentelemetry.sdk.trace;

import io.opentelemetry.sdk.common.Clock;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.samplers.Sampler;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes4.dex */
public final class SdkTracerProviderBuilder {
    private static final Sampler DEFAULT_SAMPLER = Sampler.parentBased(Sampler.alwaysOn());
    private final List<SpanProcessor> spanProcessors = new ArrayList();
    private Clock clock = Clock.getDefault();
    private IdGenerator idsGenerator = IdGenerator.random();
    private Resource resource = Resource.getDefault();
    private Supplier<SpanLimits> spanLimitsSupplier = new Supplier() { // from class: io.opentelemetry.sdk.trace.SdkTracerProviderBuilder$$ExternalSyntheticLambda0
        @Override // java.util.function.Supplier
        public final Object get() {
            return SpanLimits.getDefault();
        }
    };
    private Sampler sampler = DEFAULT_SAMPLER;

    static /* synthetic */ SpanLimits lambda$setSpanLimits$0(SpanLimits spanLimits) {
        return spanLimits;
    }

    public SdkTracerProviderBuilder setClock(Clock clock) {
        Objects.requireNonNull(clock, "clock");
        this.clock = clock;
        return this;
    }

    public SdkTracerProviderBuilder setIdGenerator(IdGenerator idGenerator) {
        Objects.requireNonNull(idGenerator, "idGenerator");
        this.idsGenerator = idGenerator;
        return this;
    }

    public SdkTracerProviderBuilder setResource(Resource resource) {
        Objects.requireNonNull(resource, "resource");
        this.resource = resource;
        return this;
    }

    public SdkTracerProviderBuilder setSpanLimits(final SpanLimits spanLimits) {
        Objects.requireNonNull(spanLimits, "spanLimits");
        this.spanLimitsSupplier = new Supplier() { // from class: io.opentelemetry.sdk.trace.SdkTracerProviderBuilder$$ExternalSyntheticLambda1
            @Override // java.util.function.Supplier
            public final Object get() {
                return SdkTracerProviderBuilder.lambda$setSpanLimits$0(spanLimits);
            }
        };
        return this;
    }

    public SdkTracerProviderBuilder setSpanLimits(Supplier<SpanLimits> supplier) {
        Objects.requireNonNull(supplier, "spanLimitsSupplier");
        this.spanLimitsSupplier = supplier;
        return this;
    }

    public SdkTracerProviderBuilder setSampler(Sampler sampler) {
        Objects.requireNonNull(sampler, "sampler");
        this.sampler = sampler;
        return this;
    }

    public SdkTracerProviderBuilder addSpanProcessor(SpanProcessor spanProcessor) {
        this.spanProcessors.add(spanProcessor);
        return this;
    }

    public SdkTracerProvider build() {
        return new SdkTracerProvider(this.clock, this.idsGenerator, this.resource, this.spanLimitsSupplier, this.sampler, this.spanProcessors);
    }

    SdkTracerProviderBuilder() {
    }
}
