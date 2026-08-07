package io.opentelemetry.exporter.logging.internal;

import io.opentelemetry.exporter.logging.LoggingMetricExporter;
import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;
import io.opentelemetry.sdk.autoconfigure.spi.metrics.ConfigurableMetricExporterProvider;
import io.opentelemetry.sdk.metrics.export.MetricExporter;

/* JADX INFO: loaded from: classes4.dex */
public class LoggingMetricExporterProvider implements ConfigurableMetricExporterProvider {
    @Override // io.opentelemetry.sdk.autoconfigure.spi.metrics.ConfigurableMetricExporterProvider
    public MetricExporter createExporter(ConfigProperties configProperties) {
        return LoggingMetricExporter.create();
    }

    @Override // io.opentelemetry.sdk.autoconfigure.spi.metrics.ConfigurableMetricExporterProvider
    public String getName() {
        return "logging";
    }
}
