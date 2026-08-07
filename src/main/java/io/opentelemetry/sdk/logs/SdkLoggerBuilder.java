package io.opentelemetry.sdk.logs;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.logs.LoggerBuilder;
import io.opentelemetry.sdk.internal.ComponentRegistry;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class SdkLoggerBuilder implements LoggerBuilder {

    @Nullable
    private String eventDomain;
    private final String instrumentationScopeName;

    @Nullable
    private String instrumentationScopeVersion;
    private final ComponentRegistry<SdkLogger> registry;

    @Nullable
    private String schemaUrl;

    SdkLoggerBuilder(ComponentRegistry<SdkLogger> componentRegistry, String str) {
        this.registry = componentRegistry;
        this.instrumentationScopeName = str;
    }

    @Override // io.opentelemetry.api.logs.LoggerBuilder
    public LoggerBuilder setEventDomain(String str) {
        this.eventDomain = str;
        return this;
    }

    @Override // io.opentelemetry.api.logs.LoggerBuilder
    public SdkLoggerBuilder setSchemaUrl(String str) {
        this.schemaUrl = str;
        return this;
    }

    @Override // io.opentelemetry.api.logs.LoggerBuilder
    public SdkLoggerBuilder setInstrumentationVersion(String str) {
        this.instrumentationScopeVersion = str;
        return this;
    }

    @Override // io.opentelemetry.api.logs.LoggerBuilder
    public SdkLogger build() {
        SdkLogger sdkLogger = this.registry.get(this.instrumentationScopeName, this.instrumentationScopeVersion, this.schemaUrl, Attributes.empty());
        String str = this.eventDomain;
        return str == null ? sdkLogger : sdkLogger.withEventDomain(str);
    }
}
