package io.opentelemetry.exporter.logging.internal;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;
import io.opentelemetry.sdk.autoconfigure.spi.logs.ConfigurableLogRecordExporterProvider;
import io.opentelemetry.sdk.logs.export.LogRecordExporter;

/* JADX INFO: loaded from: classes4.dex */
public class LoggingLogRecordExporterProvider implements ConfigurableLogRecordExporterProvider {
    @Override // io.opentelemetry.sdk.autoconfigure.spi.logs.ConfigurableLogRecordExporterProvider
    public LogRecordExporter createExporter(ConfigProperties configProperties) {
        return SystemOutLogRecordExporter.create();
    }

    @Override // io.opentelemetry.sdk.autoconfigure.spi.logs.ConfigurableLogRecordExporterProvider
    public String getName() {
        return "logging";
    }
}
