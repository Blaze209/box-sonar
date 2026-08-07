package io.opentelemetry.exporter.logging;

import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import java.util.Collection;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public final class LoggingSpanExporter implements SpanExporter {
    private static final Logger logger = Logger.getLogger(LoggingSpanExporter.class.getName());

    public static LoggingSpanExporter create() {
        return new LoggingSpanExporter();
    }

    @Deprecated
    public LoggingSpanExporter() {
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode export(Collection<SpanData> collection) {
        String version;
        StringBuilder sb = new StringBuilder(60);
        for (SpanData spanData : collection) {
            sb.setLength(0);
            InstrumentationScopeInfo instrumentationScopeInfo = spanData.getInstrumentationScopeInfo();
            StringBuilder sbAppend = sb.append("'").append(spanData.getName()).append("' : ").append(spanData.getTraceId()).append(" ").append(spanData.getSpanId()).append(" ").append(spanData.getKind()).append(" [tracer: ").append(instrumentationScopeInfo.getName()).append(":");
            if (instrumentationScopeInfo.getVersion() == null) {
                version = "";
            } else {
                version = instrumentationScopeInfo.getVersion();
            }
            sbAppend.append(version).append("] ").append(spanData.getAttributes());
            logger.log(Level.INFO, sb.toString());
        }
        return CompletableResultCode.ofSuccess();
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode flush() {
        CompletableResultCode completableResultCode = new CompletableResultCode();
        for (Handler handler : logger.getHandlers()) {
            try {
                handler.flush();
            } catch (Throwable unused) {
                completableResultCode.fail();
            }
        }
        return completableResultCode.succeed();
    }

    @Override // io.opentelemetry.sdk.trace.export.SpanExporter
    public CompletableResultCode shutdown() {
        return flush();
    }
}
