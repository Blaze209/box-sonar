package io.opentelemetry.exporter.logging;

import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.logs.data.LogRecordData;
import io.opentelemetry.sdk.logs.export.LogRecordExporter;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class SystemOutLogRecordExporter implements LogRecordExporter {
    private static final DateTimeFormatter ISO_FORMAT = DateTimeFormatter.ISO_DATE_TIME;

    public static SystemOutLogRecordExporter create() {
        return new SystemOutLogRecordExporter();
    }

    private SystemOutLogRecordExporter() {
    }

    @Override // io.opentelemetry.sdk.logs.export.LogRecordExporter
    public CompletableResultCode export(Collection<LogRecordData> collection) {
        StringBuilder sb = new StringBuilder(60);
        for (LogRecordData logRecordData : collection) {
            sb.setLength(0);
            formatLog(sb, logRecordData);
            System.out.println(sb);
        }
        return CompletableResultCode.ofSuccess();
    }

    @Override // io.opentelemetry.sdk.logs.export.LogRecordExporter
    public CompletableResultCode flush() {
        return CompletableResultCode.ofSuccess();
    }

    static void formatLog(StringBuilder sb, LogRecordData logRecordData) {
        String version;
        InstrumentationScopeInfo instrumentationScopeInfo = logRecordData.getInstrumentationScopeInfo();
        StringBuilder sbAppend = sb.append(ISO_FORMAT.format(Instant.ofEpochMilli(TimeUnit.NANOSECONDS.toMillis(logRecordData.getEpochNanos())).atZone(ZoneOffset.UTC))).append(" ").append(logRecordData.getSeverity()).append(" '").append(logRecordData.getBody().asString()).append("' : ").append(logRecordData.getSpanContext().getTraceId()).append(" ").append(logRecordData.getSpanContext().getSpanId()).append(" [scopeInfo: ").append(instrumentationScopeInfo.getName()).append(":");
        if (instrumentationScopeInfo.getVersion() == null) {
            version = "";
        } else {
            version = instrumentationScopeInfo.getVersion();
        }
        sbAppend.append(version).append("] ").append(logRecordData.getAttributes());
    }

    @Override // io.opentelemetry.sdk.logs.export.LogRecordExporter
    public CompletableResultCode shutdown() {
        return CompletableResultCode.ofSuccess();
    }
}
