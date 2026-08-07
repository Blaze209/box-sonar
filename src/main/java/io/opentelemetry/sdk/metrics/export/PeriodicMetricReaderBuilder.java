package io.opentelemetry.sdk.metrics.export;

import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationResponse;
import io.opentelemetry.api.internal.Utils;
import io.opentelemetry.sdk.internal.DaemonThreadFactory;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class PeriodicMetricReaderBuilder {
    static final long DEFAULT_SCHEDULE_DELAY_MINUTES = 1;

    @Nullable
    private ScheduledExecutorService executor;
    private long intervalNanos = TimeUnit.MINUTES.toNanos(1);
    private final MetricExporter metricExporter;

    PeriodicMetricReaderBuilder(MetricExporter metricExporter) {
        this.metricExporter = metricExporter;
    }

    public PeriodicMetricReaderBuilder setInterval(long j, TimeUnit timeUnit) {
        Objects.requireNonNull(timeUnit, "unit");
        Utils.checkArgument(j > 0, "interval must be positive");
        this.intervalNanos = timeUnit.toNanos(j);
        return this;
    }

    public PeriodicMetricReaderBuilder setInterval(Duration duration) {
        Objects.requireNonNull(duration, MicrosoftAuthorizationResponse.INTERVAL);
        return setInterval(duration.toNanos(), TimeUnit.NANOSECONDS);
    }

    public PeriodicMetricReaderBuilder setExecutor(ScheduledExecutorService scheduledExecutorService) {
        Objects.requireNonNull(scheduledExecutorService, "executor");
        this.executor = scheduledExecutorService;
        return this;
    }

    public PeriodicMetricReader build() {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = this.executor;
        if (scheduledExecutorServiceNewScheduledThreadPool == null) {
            scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new DaemonThreadFactory("PeriodicMetricReader"));
        }
        return new PeriodicMetricReader(this.metricExporter, this.intervalNanos, scheduledExecutorServiceNewScheduledThreadPool);
    }
}
