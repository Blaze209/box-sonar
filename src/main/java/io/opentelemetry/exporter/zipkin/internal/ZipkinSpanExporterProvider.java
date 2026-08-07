package io.opentelemetry.exporter.zipkin.internal;

import io.opentelemetry.exporter.zipkin.ZipkinSpanExporter;
import io.opentelemetry.exporter.zipkin.ZipkinSpanExporterBuilder;
import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;
import io.opentelemetry.sdk.autoconfigure.spi.traces.ConfigurableSpanExporterProvider;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import java.time.Duration;

/* JADX INFO: loaded from: classes4.dex */
public class ZipkinSpanExporterProvider implements ConfigurableSpanExporterProvider {
    @Override // io.opentelemetry.sdk.autoconfigure.spi.traces.ConfigurableSpanExporterProvider
    public String getName() {
        return "zipkin";
    }

    @Override // io.opentelemetry.sdk.autoconfigure.spi.traces.ConfigurableSpanExporterProvider
    public SpanExporter createExporter(ConfigProperties configProperties) {
        ZipkinSpanExporterBuilder zipkinSpanExporterBuilderBuilder = ZipkinSpanExporter.builder();
        String string = configProperties.getString("otel.exporter.zipkin.endpoint");
        if (string != null) {
            zipkinSpanExporterBuilderBuilder.setEndpoint(string);
        }
        Duration duration = configProperties.getDuration("otel.exporter.zipkin.timeout");
        if (duration != null) {
            zipkinSpanExporterBuilderBuilder.setReadTimeout(duration);
        }
        return zipkinSpanExporterBuilderBuilder.build();
    }
}
