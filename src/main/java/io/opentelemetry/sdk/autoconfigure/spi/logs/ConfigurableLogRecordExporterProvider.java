package io.opentelemetry.sdk.autoconfigure.spi.logs;

import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;
import io.opentelemetry.sdk.logs.export.LogRecordExporter;

/* JADX INFO: loaded from: classes4.dex */
public interface ConfigurableLogRecordExporterProvider {
    LogRecordExporter createExporter(ConfigProperties configProperties);

    String getName();
}
