package io.opentelemetry.sdk.trace.export;

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
import io.opentelemetry.sdk.internal.ThrowableUtil;
import io.opentelemetry.sdk.trace.ReadWriteSpan;
import io.opentelemetry.sdk.trace.ReadableSpan;
import io.opentelemetry.sdk.trace.SpanProcessor;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.internal.JcTools;
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
public final class BatchSpanProcessor implements SpanProcessor {
    private final AtomicBoolean isShutdown = new AtomicBoolean(false);
    private final Worker worker;
    private static final Logger logger = Logger.getLogger(BatchSpanProcessor.class.getName());
    private static final String WORKER_THREAD_NAME = "BatchSpanProcessor_WorkerThread";
    private static final AttributeKey<String> SPAN_PROCESSOR_TYPE_LABEL = AttributeKey.stringKey("spanProcessorType");
    private static final AttributeKey<Boolean> SPAN_PROCESSOR_DROPPED_LABEL = AttributeKey.booleanKey("dropped");
    private static final String SPAN_PROCESSOR_TYPE_VALUE = "BatchSpanProcessor";

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

    public static BatchSpanProcessorBuilder builder(SpanExporter spanExporter) {
        return new BatchSpanProcessorBuilder(spanExporter);
    }

    BatchSpanProcessor(SpanExporter spanExporter, MeterProvider meterProvider, long j, int i, int i2, long j2) {
        Worker worker = new Worker(spanExporter, meterProvider, j, i2, j2, JcTools.newFixedSizeQueue(i));
        this.worker = worker;
        new DaemonThreadFactory(WORKER_THREAD_NAME).newThread(worker).start();
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public void onEnd(ReadableSpan readableSpan) {
        if (readableSpan == null || !readableSpan.getSpanContext().isSampled()) {
            return;
        }
        this.worker.addSpan(readableSpan);
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public CompletableResultCode shutdown() {
        if (this.isShutdown.getAndSet(true)) {
            return CompletableResultCode.ofSuccess();
        }
        return this.worker.shutdown();
    }

    @Override // io.opentelemetry.sdk.trace.SpanProcessor
    public CompletableResultCode forceFlush() {
        return this.worker.forceFlush();
    }

    ArrayList<SpanData> getBatch() {
        return this.worker.batch;
    }

    Queue<ReadableSpan> getQueue() {
        return this.worker.queue;
    }

    public String toString() {
        return "BatchSpanProcessor{spanExporter=" + this.worker.spanExporter + ", scheduleDelayNanos=" + this.worker.scheduleDelayNanos + ", maxExportBatchSize=" + this.worker.maxExportBatchSize + ", exporterTimeoutNanos=" + this.worker.exporterTimeoutNanos + AbstractJsonLexerKt.END_OBJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class Worker implements Runnable {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final ArrayList<SpanData> batch;
        private volatile boolean continueWork;
        private final Attributes droppedAttrs;
        private final Attributes exportedAttrs;
        private final long exporterTimeoutNanos;
        private final AtomicReference<CompletableResultCode> flushRequested;
        private final int maxExportBatchSize;
        private long nextExportTime;
        private final LongCounter processedSpansCounter;
        private final Queue<ReadableSpan> queue;
        private final long scheduleDelayNanos;
        private final BlockingQueue<Boolean> signal;
        private final SpanExporter spanExporter;
        private final AtomicInteger spansNeeded;

        private Worker(SpanExporter spanExporter, MeterProvider meterProvider, long j, int i, long j2, final Queue<ReadableSpan> queue) {
            this.spansNeeded = new AtomicInteger(Integer.MAX_VALUE);
            this.flushRequested = new AtomicReference<>();
            this.continueWork = true;
            this.spanExporter = spanExporter;
            this.scheduleDelayNanos = j;
            this.maxExportBatchSize = i;
            this.exporterTimeoutNanos = j2;
            this.queue = queue;
            this.signal = new ArrayBlockingQueue(1);
            Meter meterBuild = meterProvider.meterBuilder("io.opentelemetry.sdk.trace").build();
            meterBuild.gaugeBuilder("queueSize").ofLongs().setDescription("The number of spans queued").setUnit("1").buildWithCallback(new Consumer() { // from class: io.opentelemetry.sdk.trace.export.BatchSpanProcessor$Worker$$ExternalSyntheticLambda2
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((ObservableLongMeasurement) obj).record(queue.size(), Attributes.of(BatchSpanProcessor.SPAN_PROCESSOR_TYPE_LABEL, BatchSpanProcessor.SPAN_PROCESSOR_TYPE_VALUE));
                }
            });
            this.processedSpansCounter = meterBuild.counterBuilder("processedSpans").setUnit("1").setDescription("The number of spans processed by the BatchSpanProcessor. [dropped=true if they were dropped due to high throughput]").build();
            this.droppedAttrs = Attributes.of(BatchSpanProcessor.SPAN_PROCESSOR_TYPE_LABEL, BatchSpanProcessor.SPAN_PROCESSOR_TYPE_VALUE, BatchSpanProcessor.SPAN_PROCESSOR_DROPPED_LABEL, true);
            this.exportedAttrs = Attributes.of(BatchSpanProcessor.SPAN_PROCESSOR_TYPE_LABEL, BatchSpanProcessor.SPAN_PROCESSOR_TYPE_VALUE, BatchSpanProcessor.SPAN_PROCESSOR_DROPPED_LABEL, false);
            this.batch = new ArrayList<>(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addSpan(ReadableSpan readableSpan) {
            if (!this.queue.offer(readableSpan)) {
                this.processedSpansCounter.add(1L, this.droppedAttrs);
            } else if (this.queue.size() >= this.spansNeeded.get()) {
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
                JcTools.drain(this.queue, this.maxExportBatchSize - this.batch.size(), new Consumer() { // from class: io.opentelemetry.sdk.trace.export.BatchSpanProcessor$Worker$$ExternalSyntheticLambda1
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        this.f$0.m14770xa5528bf2((ReadableSpan) obj);
                    }
                });
                if (this.batch.size() >= this.maxExportBatchSize || System.nanoTime() >= this.nextExportTime) {
                    exportCurrentBatch();
                    updateNextExportTime();
                }
                if (this.queue.isEmpty()) {
                    try {
                        long jNanoTime = this.nextExportTime - System.nanoTime();
                        if (jNanoTime > 0) {
                            this.spansNeeded.set(this.maxExportBatchSize - this.batch.size());
                            this.signal.poll(jNanoTime, TimeUnit.NANOSECONDS);
                            this.spansNeeded.set(Integer.MAX_VALUE);
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

        /* JADX INFO: renamed from: lambda$run$1$io-opentelemetry-sdk-trace-export-BatchSpanProcessor$Worker, reason: not valid java name */
        /* synthetic */ void m14770xa5528bf2(ReadableSpan readableSpan) {
            this.batch.add(readableSpan.toSpanData());
        }

        private void flush() {
            int size = this.queue.size();
            while (size > 0) {
                this.batch.add(this.queue.poll().toSpanData());
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
            completableResultCodeForceFlush.whenComplete(new Runnable() { // from class: io.opentelemetry.sdk.trace.export.BatchSpanProcessor$Worker$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m14771xf1cce899(completableResultCodeForceFlush, completableResultCode);
                }
            });
            return completableResultCode;
        }

        /* JADX INFO: renamed from: lambda$shutdown$3$io-opentelemetry-sdk-trace-export-BatchSpanProcessor$Worker, reason: not valid java name */
        /* synthetic */ void m14771xf1cce899(final CompletableResultCode completableResultCode, final CompletableResultCode completableResultCode2) {
            this.continueWork = false;
            final CompletableResultCode completableResultCodeShutdown = this.spanExporter.shutdown();
            completableResultCodeShutdown.whenComplete(new Runnable() { // from class: io.opentelemetry.sdk.trace.export.BatchSpanProcessor$Worker$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    BatchSpanProcessor.Worker.lambda$shutdown$2(completableResultCode, completableResultCodeShutdown, completableResultCode2);
                }
            });
        }

        static /* synthetic */ void lambda$shutdown$2(CompletableResultCode completableResultCode, CompletableResultCode completableResultCode2, CompletableResultCode completableResultCode3) {
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

        private void exportCurrentBatch() {
            if (this.batch.isEmpty()) {
                return;
            }
            try {
                CompletableResultCode completableResultCodeExport = this.spanExporter.export(Collections.unmodifiableList(this.batch));
                completableResultCodeExport.join(this.exporterTimeoutNanos, TimeUnit.NANOSECONDS);
                if (!completableResultCodeExport.isSuccess()) {
                    BatchSpanProcessor.logger.log(Level.FINE, "Exporter failed");
                } else {
                    this.processedSpansCounter.add(this.batch.size(), this.exportedAttrs);
                }
            } catch (Throwable th) {
                try {
                    ThrowableUtil.propagateIfFatal(th);
                    BatchSpanProcessor.logger.log(Level.WARNING, "Exporter threw an Exception", th);
                } finally {
                    this.batch.clear();
                }
            }
        }
    }
}
