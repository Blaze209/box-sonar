package io.opentelemetry.sdk.logs.export;

import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.logs.LogRecordProcessor;
import io.opentelemetry.sdk.logs.ReadWriteLogRecord;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public final class SimpleLogRecordProcessor implements LogRecordProcessor {
    private static final Logger logger = Logger.getLogger(SimpleLogRecordProcessor.class.getName());
    private final LogRecordExporter logRecordExporter;
    private final Set<CompletableResultCode> pendingExports = Collections.newSetFromMap(new ConcurrentHashMap());
    private final AtomicBoolean isShutdown = new AtomicBoolean(false);

    public static LogRecordProcessor create(LogRecordExporter logRecordExporter) {
        Objects.requireNonNull(logRecordExporter, "exporter");
        return new SimpleLogRecordProcessor(logRecordExporter);
    }

    SimpleLogRecordProcessor(LogRecordExporter logRecordExporter) {
        this.logRecordExporter = (LogRecordExporter) Objects.requireNonNull(logRecordExporter, "logRecordExporter");
    }

    @Override // io.opentelemetry.sdk.logs.LogRecordProcessor
    public void onEmit(Context context, ReadWriteLogRecord readWriteLogRecord) {
        try {
            final CompletableResultCode completableResultCodeExport = this.logRecordExporter.export(Collections.singletonList(readWriteLogRecord.toLogRecordData()));
            this.pendingExports.add(completableResultCodeExport);
            completableResultCodeExport.whenComplete(new Runnable() { // from class: io.opentelemetry.sdk.logs.export.SimpleLogRecordProcessor$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m14762x14191179(completableResultCodeExport);
                }
            });
        } catch (RuntimeException e) {
            logger.log(Level.WARNING, "Exporter threw an Exception", (Throwable) e);
        }
    }

    /* JADX INFO: renamed from: lambda$onEmit$0$io-opentelemetry-sdk-logs-export-SimpleLogRecordProcessor, reason: not valid java name */
    /* synthetic */ void m14762x14191179(CompletableResultCode completableResultCode) {
        this.pendingExports.remove(completableResultCode);
        if (completableResultCode.isSuccess()) {
            return;
        }
        logger.log(Level.FINE, "Exporter failed");
    }

    @Override // io.opentelemetry.sdk.logs.LogRecordProcessor
    public CompletableResultCode shutdown() {
        if (this.isShutdown.getAndSet(true)) {
            return CompletableResultCode.ofSuccess();
        }
        final CompletableResultCode completableResultCode = new CompletableResultCode();
        final CompletableResultCode completableResultCodeForceFlush = forceFlush();
        completableResultCodeForceFlush.whenComplete(new Runnable() { // from class: io.opentelemetry.sdk.logs.export.SimpleLogRecordProcessor$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m14763x67979dbf(completableResultCodeForceFlush, completableResultCode);
            }
        });
        return completableResultCode;
    }

    /* JADX INFO: renamed from: lambda$shutdown$2$io-opentelemetry-sdk-logs-export-SimpleLogRecordProcessor, reason: not valid java name */
    /* synthetic */ void m14763x67979dbf(final CompletableResultCode completableResultCode, final CompletableResultCode completableResultCode2) {
        final CompletableResultCode completableResultCodeShutdown = this.logRecordExporter.shutdown();
        completableResultCodeShutdown.whenComplete(new Runnable() { // from class: io.opentelemetry.sdk.logs.export.SimpleLogRecordProcessor$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                SimpleLogRecordProcessor.lambda$shutdown$1(completableResultCode, completableResultCodeShutdown, completableResultCode2);
            }
        });
    }

    static /* synthetic */ void lambda$shutdown$1(CompletableResultCode completableResultCode, CompletableResultCode completableResultCode2, CompletableResultCode completableResultCode3) {
        if (!completableResultCode.isSuccess() || !completableResultCode2.isSuccess()) {
            completableResultCode3.fail();
        } else {
            completableResultCode3.succeed();
        }
    }

    @Override // io.opentelemetry.sdk.logs.LogRecordProcessor
    public CompletableResultCode forceFlush() {
        return CompletableResultCode.ofAll(this.pendingExports);
    }

    public String toString() {
        return "SimpleLogRecordProcessor{logRecordExporter=" + this.logRecordExporter + AbstractJsonLexerKt.END_OBJ;
    }
}
