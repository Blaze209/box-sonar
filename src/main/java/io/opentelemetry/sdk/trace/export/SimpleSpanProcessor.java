package io.opentelemetry.sdk.trace.export;

import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.trace.ReadWriteSpan;
import io.opentelemetry.sdk.trace.ReadableSpan;
import io.opentelemetry.sdk.trace.SpanProcessor;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public final class SimpleSpanProcessor implements SpanProcessor {
    private static final Logger logger = Logger.getLogger(SimpleSpanProcessor.class.getName());
    private final boolean sampled;
    private final SpanExporter spanExporter;
    private final Set<CompletableResultCode> pendingExports = Collections.newSetFromMap(new ConcurrentHashMap());
    private final AtomicBoolean isShutdown = new AtomicBoolean(false);

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public boolean isEndRequired() {
        return true;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public boolean isStartRequired() {
        return false;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public void onStart(Context context, ReadWriteSpan readWriteSpan) {
    }

    public static SpanProcessor create(SpanExporter spanExporter) {
        Objects.requireNonNull(spanExporter, "exporter");
        return new SimpleSpanProcessor(spanExporter, true);
    }

    SimpleSpanProcessor(SpanExporter spanExporter, boolean z) {
        this.spanExporter = (SpanExporter) Objects.requireNonNull(spanExporter, "spanExporter");
        this.sampled = z;
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public void onEnd(ReadableSpan readableSpan) {
        if (!this.sampled || readableSpan.getSpanContext().isSampled()) {
            try {
                final CompletableResultCode completableResultCodeExport = this.spanExporter.export(Collections.singletonList(readableSpan.toSpanData()));
                this.pendingExports.add(completableResultCodeExport);
                completableResultCodeExport.whenComplete(new Runnable() { // from class: io.opentelemetry.sdk.trace.export.SimpleSpanProcessor$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m14772x532b8784(completableResultCodeExport);
                    }
                });
            } catch (RuntimeException e) {
                logger.log(Level.WARNING, "Exporter threw an Exception", (Throwable) e);
            }
        }
    }

    /* JADX INFO: renamed from: lambda$onEnd$0$io-opentelemetry-sdk-trace-export-SimpleSpanProcessor, reason: not valid java name */
    /* synthetic */ void m14772x532b8784(CompletableResultCode completableResultCode) {
        this.pendingExports.remove(completableResultCode);
        if (completableResultCode.isSuccess()) {
            return;
        }
        logger.log(Level.FINE, "Exporter failed");
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public CompletableResultCode shutdown() {
        if (this.isShutdown.getAndSet(true)) {
            return CompletableResultCode.ofSuccess();
        }
        final CompletableResultCode completableResultCode = new CompletableResultCode();
        final CompletableResultCode completableResultCodeForceFlush = forceFlush();
        completableResultCodeForceFlush.whenComplete(new Runnable() { // from class: io.opentelemetry.sdk.trace.export.SimpleSpanProcessor$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m14773xfbd6c93a(completableResultCodeForceFlush, completableResultCode);
            }
        });
        return completableResultCode;
    }

    /* JADX INFO: renamed from: lambda$shutdown$2$io-opentelemetry-sdk-trace-export-SimpleSpanProcessor, reason: not valid java name */
    /* synthetic */ void m14773xfbd6c93a(final CompletableResultCode completableResultCode, final CompletableResultCode completableResultCode2) {
        final CompletableResultCode completableResultCodeShutdown = this.spanExporter.shutdown();
        completableResultCodeShutdown.whenComplete(new Runnable() { // from class: io.opentelemetry.sdk.trace.export.SimpleSpanProcessor$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                SimpleSpanProcessor.lambda$shutdown$1(completableResultCode, completableResultCodeShutdown, completableResultCode2);
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

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public CompletableResultCode forceFlush() {
        return CompletableResultCode.ofAll(this.pendingExports);
    }

    public String toString() {
        return "SimpleSpanProcessor{spanExporter=" + this.spanExporter + AbstractJsonLexerKt.END_OBJ;
    }
}
