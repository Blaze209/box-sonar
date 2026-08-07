package io.opentelemetry.sdk.logs.export;

import com.microsoft.identity.common.nativeauth.internal.commands.ResetPasswordSubmitNewPasswordCommand;
import io.opentelemetry.api.internal.Utils;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public final class BatchLogRecordProcessorBuilder {
    static final int DEFAULT_EXPORT_TIMEOUT_MILLIS = 30000;
    static final int DEFAULT_MAX_EXPORT_BATCH_SIZE = 512;
    static final int DEFAULT_MAX_QUEUE_SIZE = 2048;
    static final long DEFAULT_SCHEDULE_DELAY_MILLIS = 200;
    private final LogRecordExporter logRecordExporter;
    private long scheduleDelayNanos = TimeUnit.MILLISECONDS.toNanos(DEFAULT_SCHEDULE_DELAY_MILLIS);
    private int maxQueueSize = 2048;
    private int maxExportBatchSize = 512;
    private long exporterTimeoutNanos = TimeUnit.MILLISECONDS.toNanos(30000);
    private MeterProvider meterProvider = MeterProvider.noop();

    BatchLogRecordProcessorBuilder(LogRecordExporter logRecordExporter) {
        this.logRecordExporter = (LogRecordExporter) Objects.requireNonNull(logRecordExporter, "logRecordExporter");
    }

    public BatchLogRecordProcessorBuilder setScheduleDelay(long j, TimeUnit timeUnit) {
        Objects.requireNonNull(timeUnit, "unit");
        Utils.checkArgument(j >= 0, "delay must be non-negative");
        this.scheduleDelayNanos = timeUnit.toNanos(j);
        return this;
    }

    public BatchLogRecordProcessorBuilder setScheduleDelay(Duration duration) {
        Objects.requireNonNull(duration, SemanticAttributes.MessagingRocketmqMessageTypeValues.DELAY);
        return setScheduleDelay(duration.toNanos(), TimeUnit.NANOSECONDS);
    }

    long getScheduleDelayNanos() {
        return this.scheduleDelayNanos;
    }

    public BatchLogRecordProcessorBuilder setExporterTimeout(long j, TimeUnit timeUnit) {
        Objects.requireNonNull(timeUnit, "unit");
        Utils.checkArgument(j >= 0, "timeout must be non-negative");
        this.exporterTimeoutNanos = timeUnit.toNanos(j);
        return this;
    }

    public BatchLogRecordProcessorBuilder setExporterTimeout(Duration duration) {
        Objects.requireNonNull(duration, ResetPasswordSubmitNewPasswordCommand.POLL_COMPLETION_TIMEOUT_ERROR_CODE);
        return setExporterTimeout(duration.toNanos(), TimeUnit.NANOSECONDS);
    }

    long getExporterTimeoutNanos() {
        return this.exporterTimeoutNanos;
    }

    public BatchLogRecordProcessorBuilder setMaxQueueSize(int i) {
        this.maxQueueSize = i;
        return this;
    }

    int getMaxQueueSize() {
        return this.maxQueueSize;
    }

    public BatchLogRecordProcessorBuilder setMaxExportBatchSize(int i) {
        Utils.checkArgument(i > 0, "maxExportBatchSize must be positive.");
        this.maxExportBatchSize = i;
        return this;
    }

    public BatchLogRecordProcessorBuilder setMeterProvider(MeterProvider meterProvider) {
        Objects.requireNonNull(meterProvider, "meterProvider");
        this.meterProvider = meterProvider;
        return this;
    }

    int getMaxExportBatchSize() {
        return this.maxExportBatchSize;
    }

    public BatchLogRecordProcessor build() {
        return new BatchLogRecordProcessor(this.logRecordExporter, this.meterProvider, this.scheduleDelayNanos, this.maxQueueSize, this.maxExportBatchSize, this.exporterTimeoutNanos);
    }
}
