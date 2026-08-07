package io.opentelemetry.sdk.logs.export;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.api.metrics.ObservableLongMeasurement;
import io.opentelemetry.context.Context;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.internal.DaemonThreadFactory;
import io.opentelemetry.sdk.logs.LogRecordProcessor;
import io.opentelemetry.sdk.logs.ReadWriteLogRecord;
import io.opentelemetry.sdk.logs.data.LogRecordData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public final class BatchLogRecordProcessor implements LogRecordProcessor {
    private static final String WORKER_THREAD_NAME = "BatchLogRecordProcessor_WorkerThread";
    private final AtomicBoolean isShutdown = new AtomicBoolean(false);
    private final Worker worker;
    private static final AttributeKey<String> LOG_RECORD_PROCESSOR_TYPE_LABEL = AttributeKey.stringKey("logRecordProcessorType");
    private static final AttributeKey<Boolean> LOG_RECORD_PROCESSOR_DROPPED_LABEL = AttributeKey.booleanKey("dropped");
    private static final String LOG_RECORD_PROCESSOR_TYPE_VALUE = "BatchLogRecordProcessor";

    public static BatchLogRecordProcessorBuilder builder(LogRecordExporter logRecordExporter) {
        return new BatchLogRecordProcessorBuilder(logRecordExporter);
    }

    BatchLogRecordProcessor(LogRecordExporter logRecordExporter, MeterProvider meterProvider, long j, int i, int i2, long j2) {
        Worker worker = new Worker(logRecordExporter, meterProvider, j, i2, j2, new ArrayBlockingQueue(i));
        this.worker = worker;
        new DaemonThreadFactory(WORKER_THREAD_NAME).newThread(worker).start();
    }

    @Override // io.opentelemetry.sdk.logs.LogRecordProcessor
    public void onEmit(Context context, ReadWriteLogRecord readWriteLogRecord) {
        if (readWriteLogRecord == null) {
            return;
        }
        this.worker.addLog(readWriteLogRecord);
    }

    @Override // io.opentelemetry.sdk.logs.LogRecordProcessor
    public CompletableResultCode shutdown() {
        if (this.isShutdown.getAndSet(true)) {
            return CompletableResultCode.ofSuccess();
        }
        return this.worker.shutdown();
    }

    @Override // io.opentelemetry.sdk.logs.LogRecordProcessor
    public CompletableResultCode forceFlush() {
        return this.worker.forceFlush();
    }

    ArrayList<LogRecordData> getBatch() {
        return this.worker.batch;
    }

    public String toString() {
        return "BatchLogRecordProcessor{logRecordExporter=" + this.worker.logRecordExporter + ", scheduleDelayNanos=" + this.worker.scheduleDelayNanos + ", maxExportBatchSize=" + this.worker.maxExportBatchSize + ", exporterTimeoutNanos=" + this.worker.exporterTimeoutNanos + AbstractJsonLexerKt.END_OBJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class Worker implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final Logger logger = Logger.getLogger(Worker.class.getName());
        private final ArrayList<LogRecordData> batch;
        private volatile boolean continueWork;
        private final Attributes droppedAttrs;
        private final Attributes exportedAttrs;
        private final long exporterTimeoutNanos;
        private final AtomicReference<CompletableResultCode> flushRequested;
        private final LogRecordExporter logRecordExporter;
        private final AtomicInteger logsNeeded;
        private final int maxExportBatchSize;
        private long nextExportTime;
        private final LongCounter processedLogsCounter;
        private final Queue<ReadWriteLogRecord> queue;
        private final long scheduleDelayNanos;
        private final BlockingQueue<Boolean> signal;

        private Worker(LogRecordExporter logRecordExporter, MeterProvider meterProvider, long j, int i, long j2, final Queue<ReadWriteLogRecord> queue) {
            this.logsNeeded = new AtomicInteger(Integer.MAX_VALUE);
            this.flushRequested = new AtomicReference<>();
            this.continueWork = true;
            this.logRecordExporter = logRecordExporter;
            this.scheduleDelayNanos = j;
            this.maxExportBatchSize = i;
            this.exporterTimeoutNanos = j2;
            this.queue = queue;
            this.signal = new ArrayBlockingQueue(1);
            Meter meterBuild = meterProvider.meterBuilder("io.opentelemetry.sdk.logs").build();
            meterBuild.gaugeBuilder("queueSize").ofLongs().setDescription("The number of logs queued").setUnit("1").buildWithCallback(new Consumer() { // from class: io.opentelemetry.sdk.logs.export.BatchLogRecordProcessor$Worker$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((ObservableLongMeasurement) obj).record(queue.size(), Attributes.of(BatchLogRecordProcessor.LOG_RECORD_PROCESSOR_TYPE_LABEL, BatchLogRecordProcessor.LOG_RECORD_PROCESSOR_TYPE_VALUE));
                }
            });
            this.processedLogsCounter = meterBuild.counterBuilder("processedLogs").setUnit("1").setDescription("The number of logs processed by the BatchLogRecordProcessor. [dropped=true if they were dropped due to high throughput]").build();
            this.droppedAttrs = Attributes.of(BatchLogRecordProcessor.LOG_RECORD_PROCESSOR_TYPE_LABEL, BatchLogRecordProcessor.LOG_RECORD_PROCESSOR_TYPE_VALUE, BatchLogRecordProcessor.LOG_RECORD_PROCESSOR_DROPPED_LABEL, true);
            this.exportedAttrs = Attributes.of(BatchLogRecordProcessor.LOG_RECORD_PROCESSOR_TYPE_LABEL, BatchLogRecordProcessor.LOG_RECORD_PROCESSOR_TYPE_VALUE, BatchLogRecordProcessor.LOG_RECORD_PROCESSOR_DROPPED_LABEL, false);
            this.batch = new ArrayList<>(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLog(ReadWriteLogRecord readWriteLogRecord) {
            if (!this.queue.offer(readWriteLogRecord)) {
                this.processedLogsCounter.add(1L, this.droppedAttrs);
            } else if (this.queue.size() >= this.logsNeeded.get()) {
                this.signal.offer(true);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            updateNextExportTime();
            while (this.continueWork) {
                if (this.flushRequested.get() != null) {
                    flush();
                }
                while (!this.queue.isEmpty() && this.batch.size() < this.maxExportBatchSize) {
                    this.batch.add(this.queue.poll().toLogRecordData());
                }
                if (this.batch.size() >= this.maxExportBatchSize || System.nanoTime() >= this.nextExportTime) {
                    exportCurrentBatch();
                    updateNextExportTime();
                }
                if (this.queue.isEmpty()) {
                    try {
                        long jNanoTime = this.nextExportTime - System.nanoTime();
                        if (jNanoTime > 0) {
                            this.logsNeeded.set(this.maxExportBatchSize - this.batch.size());
                            this.signal.poll(jNanoTime, TimeUnit.NANOSECONDS);
                            this.logsNeeded.set(Integer.MAX_VALUE);
                        } else {
                            continue;
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
            }
        }

        private void flush() {
            int size = this.queue.size();
            while (size > 0) {
                this.batch.add(this.queue.poll().toLogRecordData());
                size--;
                if (this.batch.size() >= this.maxExportBatchSize) {
                    exportCurrentBatch();
                }
            }
            exportCurrentBatch();
            CompletableResultCode completableResultCode = this.flushRequested.get();
            if (completableResultCode != null) {
                completableResultCode.succeed();
                this.flushRequested.set(null);
            }
        }

        private void updateNextExportTime() {
            this.nextExportTime = System.nanoTime() + this.scheduleDelayNanos;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CompletableResultCode shutdown() {
            final CompletableResultCode completableResultCode = new CompletableResultCode();
            final CompletableResultCode completableResultCodeForceFlush = forceFlush();
            completableResultCodeForceFlush.whenComplete(new Runnable() { // from class: io.opentelemetry.sdk.logs.export.BatchLogRecordProcessor$Worker$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m14761x434dbb(completableResultCodeForceFlush, completableResultCode);
                }
            });
            return completableResultCode;
        }

        /* JADX INFO: renamed from: lambda$shutdown$2$io-opentelemetry-sdk-logs-export-BatchLogRecordProcessor$Worker, reason: not valid java name */
        /* synthetic */ void m14761x434dbb(final CompletableResultCode completableResultCode, final CompletableResultCode completableResultCode2) {
            this.continueWork = false;
            final CompletableResultCode completableResultCodeShutdown = this.logRecordExporter.shutdown();
            completableResultCodeShutdown.whenComplete(new Runnable() { // from class: io.opentelemetry.sdk.logs.export.BatchLogRecordProcessor$Worker$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    BatchLogRecordProcessor.Worker.lambda$shutdown$1(completableResultCode, completableResultCodeShutdown, completableResultCode2);
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

        /* JADX INFO: Access modifiers changed from: private */
        public CompletableResultCode forceFlush() {
            if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.flushRequested, null, new CompletableResultCode())) {
                this.signal.offer(true);
            }
            CompletableResultCode completableResultCode = this.flushRequested.get();
            return completableResultCode == null ? CompletableResultCode.ofSuccess() : completableResultCode;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v3, types: [java.util.ArrayList, java.util.ArrayList<io.opentelemetry.sdk.logs.data.LogRecordData>] */
        private void exportCurrentBatch() {
            try {
                if (this.batch.isEmpty()) {
                    return;
                }
                try {
                    CompletableResultCode completableResultCodeExport = this.logRecordExporter.export(Collections.unmodifiableList(this.batch));
                    completableResultCodeExport.join(this.exporterTimeoutNanos, TimeUnit.NANOSECONDS);
                    if (completableResultCodeExport.isSuccess()) {
                        this.processedLogsCounter.add(this.batch.size(), this.exportedAttrs);
                    } else {
                        logger.log(Level.FINE, "Exporter failed");
                    }
                } catch (RuntimeException e) {
                    logger.log(Level.WARNING, "Exporter threw an Exception", (Throwable) e);
                }
            } finally {
                this.batch.clear();
            }
        }
    }
}
