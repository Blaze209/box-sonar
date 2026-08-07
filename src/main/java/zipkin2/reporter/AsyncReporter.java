package zipkin2.reporter;

import androidx.collection.SieveCacheKt;
import java.io.Flushable;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import zipkin2.Call;
import zipkin2.CheckResult;
import zipkin2.Component;
import zipkin2.Span;
import zipkin2.codec.BytesEncoder;
import zipkin2.codec.Encoding;
import zipkin2.codec.SpanBytesEncoder;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AsyncReporter<S> extends Component implements Reporter<S>, Flushable {
    @Override // zipkin2.Component, java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    @Override // java.io.Flushable
    public abstract void flush();

    public static AsyncReporter<Span> create(Sender sender) {
        return new Builder(sender).build();
    }

    public static Builder builder(Sender sender) {
        return new Builder(sender);
    }

    public static final class Builder {
        long closeTimeoutNanos;
        int messageMaxBytes;
        long messageTimeoutNanos;
        ReporterMetrics metrics;
        int queuedMaxBytes;
        int queuedMaxSpans;
        final Sender sender;
        ThreadFactory threadFactory;

        Builder(BoundedAsyncReporter<?> boundedAsyncReporter) {
            this.threadFactory = Executors.defaultThreadFactory();
            this.metrics = ReporterMetrics.NOOP_METRICS;
            this.messageTimeoutNanos = TimeUnit.SECONDS.toNanos(1L);
            this.closeTimeoutNanos = TimeUnit.SECONDS.toNanos(1L);
            this.queuedMaxSpans = 10000;
            this.queuedMaxBytes = onePercentOfMemory();
            this.sender = boundedAsyncReporter.sender;
            this.threadFactory = boundedAsyncReporter.threadFactory;
            this.metrics = boundedAsyncReporter.metrics;
            this.messageMaxBytes = boundedAsyncReporter.messageMaxBytes;
            this.messageTimeoutNanos = boundedAsyncReporter.messageTimeoutNanos;
            this.closeTimeoutNanos = boundedAsyncReporter.closeTimeoutNanos;
            this.queuedMaxSpans = boundedAsyncReporter.pending.maxSize;
            this.queuedMaxBytes = boundedAsyncReporter.pending.maxBytes;
        }

        static int onePercentOfMemory() {
            return (int) Math.max(Math.min(SieveCacheKt.NodeLinkMask, (long) (Runtime.getRuntime().totalMemory() * 0.01d)), SieveCacheKt.NodeMetaAndPreviousMask);
        }

        Builder(Sender sender) {
            this.threadFactory = Executors.defaultThreadFactory();
            this.metrics = ReporterMetrics.NOOP_METRICS;
            this.messageTimeoutNanos = TimeUnit.SECONDS.toNanos(1L);
            this.closeTimeoutNanos = TimeUnit.SECONDS.toNanos(1L);
            this.queuedMaxSpans = 10000;
            this.queuedMaxBytes = onePercentOfMemory();
            if (sender == null) {
                throw new NullPointerException("sender == null");
            }
            this.sender = sender;
            this.messageMaxBytes = sender.messageMaxBytes();
        }

        public Builder threadFactory(ThreadFactory threadFactory) {
            if (threadFactory == null) {
                throw new NullPointerException("threadFactory == null");
            }
            this.threadFactory = threadFactory;
            return this;
        }

        public Builder metrics(ReporterMetrics reporterMetrics) {
            if (reporterMetrics == null) {
                throw new NullPointerException("metrics == null");
            }
            this.metrics = reporterMetrics;
            return this;
        }

        public Builder messageMaxBytes(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("messageMaxBytes < 0: " + i);
            }
            this.messageMaxBytes = Math.min(i, this.sender.messageMaxBytes());
            return this;
        }

        public Builder messageTimeout(long j, TimeUnit timeUnit) {
            if (j < 0) {
                throw new IllegalArgumentException("messageTimeout < 0: " + j);
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            this.messageTimeoutNanos = timeUnit.toNanos(j);
            return this;
        }

        public Builder closeTimeout(long j, TimeUnit timeUnit) {
            if (j < 0) {
                throw new IllegalArgumentException("closeTimeout < 0: " + j);
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            this.closeTimeoutNanos = timeUnit.toNanos(j);
            return this;
        }

        public Builder queuedMaxSpans(int i) {
            this.queuedMaxSpans = i;
            return this;
        }

        public Builder queuedMaxBytes(int i) {
            this.queuedMaxBytes = i;
            return this;
        }

        public AsyncReporter<Span> build() {
            int i = AnonymousClass1.$SwitchMap$zipkin2$codec$Encoding[this.sender.encoding().ordinal()];
            if (i == 1) {
                return build(SpanBytesEncoder.JSON_V2);
            }
            if (i == 2) {
                return build(SpanBytesEncoder.PROTO3);
            }
            if (i == 3) {
                return build(SpanBytesEncoder.THRIFT);
            }
            throw new UnsupportedOperationException(this.sender.encoding().name());
        }

        public <S> AsyncReporter<S> build(BytesEncoder<S> bytesEncoder) {
            if (bytesEncoder == null) {
                throw new NullPointerException("encoder == null");
            }
            if (bytesEncoder.encoding() != this.sender.encoding()) {
                throw new IllegalArgumentException(String.format("Encoder doesn't match Sender: %s %s", bytesEncoder.encoding(), this.sender.encoding()));
            }
            return new BoundedAsyncReporter(this, bytesEncoder);
        }
    }

    /* JADX INFO: renamed from: zipkin2.reporter.AsyncReporter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$zipkin2$codec$Encoding;

        static {
            int[] iArr = new int[Encoding.values().length];
            $SwitchMap$zipkin2$codec$Encoding = iArr;
            try {
                iArr[Encoding.JSON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$zipkin2$codec$Encoding[Encoding.PROTO3.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$zipkin2$codec$Encoding[Encoding.THRIFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static final class BoundedAsyncReporter<S> extends AsyncReporter<S> {
        static final Logger logger = Logger.getLogger(BoundedAsyncReporter.class.getName());
        final CountDownLatch close;
        final long closeTimeoutNanos;
        final BytesEncoder<S> encoder;
        final int messageMaxBytes;
        final long messageTimeoutNanos;
        final ReporterMetrics metrics;
        final ByteBoundedQueue<S> pending;
        final Sender sender;
        final AtomicBoolean started;
        final ThreadFactory threadFactory;
        private boolean shouldWarnException = true;
        final AtomicBoolean closed = new AtomicBoolean(false);

        BoundedAsyncReporter(Builder builder, BytesEncoder<S> bytesEncoder) {
            this.pending = new ByteBoundedQueue<>(builder.queuedMaxSpans, builder.queuedMaxBytes);
            this.sender = builder.sender;
            this.messageMaxBytes = builder.messageMaxBytes;
            this.messageTimeoutNanos = builder.messageTimeoutNanos;
            this.closeTimeoutNanos = builder.closeTimeoutNanos;
            this.started = new AtomicBoolean(builder.messageTimeoutNanos == 0);
            this.close = new CountDownLatch(builder.messageTimeoutNanos <= 0 ? 0 : 1);
            this.metrics = builder.metrics;
            this.threadFactory = builder.threadFactory;
            this.encoder = bytesEncoder;
        }

        void startFlusherThread() {
            Thread threadNewThread = this.threadFactory.newThread(new Flusher(this, BufferNextMessage.create(this.encoder.encoding(), this.messageMaxBytes, this.messageTimeoutNanos)));
            threadNewThread.setName("AsyncReporter{" + this.sender + "}");
            threadNewThread.setDaemon(true);
            threadNewThread.start();
        }

        @Override // zipkin2.reporter.Reporter
        public void report(S s) {
            if (s == null) {
                throw new NullPointerException("span == null");
            }
            if (this.started.compareAndSet(false, true)) {
                startFlusherThread();
            }
            this.metrics.incrementSpans(1);
            int iSizeInBytes = this.encoder.sizeInBytes(s);
            int iMessageSizeInBytes = this.sender.messageSizeInBytes(iSizeInBytes);
            this.metrics.incrementSpanBytes(iSizeInBytes);
            if (this.closed.get() || iMessageSizeInBytes > this.messageMaxBytes || !this.pending.offer(s, iSizeInBytes)) {
                this.metrics.incrementSpansDropped(1);
            }
        }

        @Override // zipkin2.reporter.AsyncReporter, java.io.Flushable
        public final void flush() {
            if (this.closed.get()) {
                throw new ClosedSenderException();
            }
            flush(BufferNextMessage.create(this.encoder.encoding(), this.messageMaxBytes, 0L));
        }

        void flush(BufferNextMessage<S> bufferNextMessage) {
            this.pending.drainTo(bufferNextMessage, bufferNextMessage.remainingNanos());
            this.metrics.updateQueuedSpans(this.pending.count);
            this.metrics.updateQueuedBytes(this.pending.sizeInBytes);
            if (bufferNextMessage.isReady() || this.closed.get()) {
                this.metrics.incrementMessages();
                this.metrics.incrementMessageBytes(bufferNextMessage.sizeInBytes());
                final ArrayList arrayList = new ArrayList(bufferNextMessage.count());
                bufferNextMessage.drain(new SpanWithSizeConsumer<S>() { // from class: zipkin2.reporter.AsyncReporter.BoundedAsyncReporter.1
                    @Override // zipkin2.reporter.SpanWithSizeConsumer
                    public boolean offer(S s, int i) {
                        arrayList.add(BoundedAsyncReporter.this.encoder.encode(s));
                        if (BoundedAsyncReporter.this.sender.messageSizeInBytes(arrayList) <= BoundedAsyncReporter.this.messageMaxBytes) {
                            return true;
                        }
                        ArrayList arrayList2 = arrayList;
                        arrayList2.remove(arrayList2.size() - 1);
                        return false;
                    }
                });
                try {
                    this.sender.sendSpans(arrayList).execute();
                } catch (Throwable th) {
                    int size = arrayList.size();
                    Call.propagateIfFatal(th);
                    this.metrics.incrementMessagesDropped(th);
                    this.metrics.incrementSpansDropped(size);
                    Level level = Level.FINE;
                    if (this.shouldWarnException) {
                        logger.log(Level.WARNING, "Spans were dropped due to exceptions. All subsequent errors will be logged at FINE level.");
                        level = Level.WARNING;
                        this.shouldWarnException = false;
                    }
                    Logger logger2 = logger;
                    if (logger2.isLoggable(level)) {
                        logger2.log(level, String.format("Dropped %s spans due to %s(%s)", Integer.valueOf(size), th.getClass().getSimpleName(), th.getMessage() == null ? "" : th.getMessage()), (Throwable) th);
                    }
                    if (th instanceof ClosedSenderException) {
                        throw th;
                    }
                    if ((th instanceof IllegalStateException) && th.getMessage().equals("closed")) {
                        throw th;
                    }
                }
            }
        }

        @Override // zipkin2.Component
        public CheckResult check() {
            return this.sender.check();
        }

        @Override // zipkin2.reporter.AsyncReporter, zipkin2.Component, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed.compareAndSet(false, true)) {
                this.started.set(true);
                try {
                    if (!this.close.await(this.closeTimeoutNanos, TimeUnit.NANOSECONDS)) {
                        logger.warning("Timed out waiting for in-flight spans to send");
                    }
                } catch (InterruptedException unused) {
                    logger.warning("Interrupted waiting for in-flight spans to send");
                    Thread.currentThread().interrupt();
                }
                int iClear = this.pending.clear();
                if (iClear > 0) {
                    this.metrics.incrementSpansDropped(iClear);
                    logger.warning("Dropped " + iClear + " spans due to AsyncReporter.close()");
                }
            }
        }

        Builder toBuilder() {
            return new Builder((BoundedAsyncReporter<?>) this);
        }

        public String toString() {
            return "AsyncReporter{" + this.sender + "}";
        }
    }

    static final class Flusher<S> implements Runnable {
        static final Logger logger = Logger.getLogger(Flusher.class.getName());
        final BufferNextMessage<S> consumer;
        final BoundedAsyncReporter<S> result;

        Flusher(BoundedAsyncReporter<S> boundedAsyncReporter, BufferNextMessage<S> bufferNextMessage) {
            this.result = boundedAsyncReporter;
            this.consumer = bufferNextMessage;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!this.result.closed.get()) {
                try {
                    try {
                        this.result.flush(this.consumer);
                    } catch (Error | RuntimeException e) {
                        logger.log(Level.WARNING, "Unexpected error flushing spans", e);
                        throw e;
                    }
                } catch (Throwable th) {
                    int iCount = this.consumer.count();
                    if (iCount > 0) {
                        this.result.metrics.incrementSpansDropped(iCount);
                        logger.warning("Dropped " + iCount + " spans due to AsyncReporter.close()");
                    }
                    this.result.close.countDown();
                    throw th;
                }
            }
            int iCount2 = this.consumer.count();
            if (iCount2 > 0) {
                this.result.metrics.incrementSpansDropped(iCount2);
                logger.warning("Dropped " + iCount2 + " spans due to AsyncReporter.close()");
            }
            this.result.close.countDown();
        }

        public String toString() {
            return "AsyncReporter{" + this.result.sender + "}";
        }
    }
}
