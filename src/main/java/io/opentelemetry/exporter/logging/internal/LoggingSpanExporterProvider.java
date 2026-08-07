package io.opentelemetry.exporter.logging.internal;

import io.opentelemetry.exporter.logging.LoggingSpanExporter;
import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;
import io.opentelemetry.sdk.autoconfigure.spi.traces.ConfigurableSpanExporterProvider;
import io.opentelemetry.sdk.trace.export.SpanExporter;

/* JADX INFO: loaded from: classes4.dex */
public class LoggingSpanExporterProvider implements ConfigurableSpanExporterProvider {
    @Override // io.opentelemetry.sdk.autoconfigure.spi.traces.ConfigurableSpanExporterProvider
    public SpanExporter createExporter(ConfigProperties configProperties) {
        return LoggingSpanExporter.create();
    }

    @Override // io.opentelemetry.sdk.autoconfigure.spi.traces.ConfigurableSpanExporterProvider
    public String getName() {
        return "logging";
    }
}
