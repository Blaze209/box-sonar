package io.opentelemetry.sdk.trace.export;

import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import io.opentelemetry.api.internal.Utils;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public final class BatchSpanProcessorBuilder {
    static final int DEFAULT_EXPORT_TIMEOUT_MILLIS = 30000;
    static final int DEFAULT_MAX_EXPORT_BATCH_SIZE = 512;
    static final int DEFAULT_MAX_QUEUE_SIZE = 2048;
    static final long DEFAULT_SCHEDULE_DELAY_MILLIS = 5000;
    private final SpanExporter spanExporter;
    private long scheduleDelayNanos = TimeUnit.MILLISECONDS.toNanos(5000);
    private int maxQueueSize = 2048;
    private int maxExportBatchSize = 512;
    private long exporterTimeoutNanos = TimeUnit.MILLISECONDS.toNanos(30000);
    private MeterProvider meterProvider = MeterProvider.noop();

    BatchSpanProcessorBuilder(SpanExporter spanExporter) {
        this.spanExporter = (SpanExporter) Objects.requireNonNull(spanExporter, "spanExporter");
    }

    public BatchSpanProcessorBuilder setScheduleDelay(long j, TimeUnit timeUnit) {
        Objects.requireNonNull(timeUnit, "unit");
        Utils.checkArgument(j >= 0, "delay must be non-negative");
        this.scheduleDelayNanos = timeUnit.toNanos(j);
        return this;
    }

    public BatchSpanProcessorBuilder setScheduleDelay(Duration duration) {
        Objects.requireNonNull(duration, SemanticAttributes.MessagingRocketmqMessageTypeValues.DELAY);
        return setScheduleDelay(duration.toNanos(), TimeUnit.NANOSECONDS);
    }

    long getScheduleDelayNanos() {
        return this.scheduleDelayNanos;
    }

    public BatchSpanProcessorBuilder setExporterTimeout(long j, TimeUnit timeUnit) {
        Objects.requireNonNull(timeUnit, "unit");
        Utils.checkArgument(j >= 0, "timeout must be non-negative");
        this.exporterTimeoutNanos = timeUnit.toNanos(j);
        return this;
    }

    public BatchSpanProcessorBuilder setExporterTimeout(Duration duration) {
        Objects.requireNonNull(duration, ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE);
        return setExporterTimeout(duration.toNanos(), TimeUnit.NANOSECONDS);
    }

    long getExporterTimeoutNanos() {
        return this.exporterTimeoutNanos;
    }

    public BatchSpanProcessorBuilder setMaxQueueSize(int i) {
        this.maxQueueSize = i;
        return this;
    }

    int getMaxQueueSize() {
        return this.maxQueueSize;
    }

    public BatchSpanProcessorBuilder setMaxExportBatchSize(int i) {
        Utils.checkArgument(i > 0, "maxExportBatchSize must be positive.");
        this.maxExportBatchSize = i;
        return this;
    }

    public BatchSpanProcessorBuilder setMeterProvider(MeterProvider meterProvider) {
        Objects.requireNonNull(meterProvider, "meterProvider");
        this.meterProvider = meterProvider;
        return this;
    }

    int getMaxExportBatchSize() {
        return this.maxExportBatchSize;
    }

    public BatchSpanProcessor build() {
        return new BatchSpanProcessor(this.spanExporter, this.meterProvider, this.scheduleDelayNanos, this.maxQueueSize, this.maxExportBatchSize, this.exporterTimeoutNanos);
    }
}
