package io.opentelemetry.sdk.trace;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.api.trace.TracerBuilder;
import io.opentelemetry.sdk.internal.ComponentRegistry;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
class SdkTracerBuilder implements TracerBuilder {
    private final String instrumentationScopeName;

    @Nullable
    private String instrumentationScopeVersion;
    private final ComponentRegistry<SdkTracer> registry;

    @Nullable
    private String schemaUrl;

    SdkTracerBuilder(ComponentRegistry<SdkTracer> componentRegistry, String str) {
        this.registry = componentRegistry;
        this.instrumentationScopeName = str;
    }

    @Override // io.opentelemetry.api.trace.TracerBuilder
    public TracerBuilder setSchemaUrl(String str) {
        this.schemaUrl = str;
        return this;
    }

    @Override // io.opentelemetry.api.trace.TracerBuilder
    public TracerBuilder setInstrumentationVersion(String str) {
        this.instrumentationScopeVersion = str;
        return this;
    }

    @Override // io.opentelemetry.api.trace.TracerBuilder
    public Tracer build() {
        return this.registry.get(this.instrumentationScopeName, this.instrumentationScopeVersion, this.schemaUrl, Attributes.empty());
    }
}
