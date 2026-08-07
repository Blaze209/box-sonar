package io.opentelemetry.sdk.metrics.internal.export;

import io.opentelemetry.sdk.metrics.export.MetricReader;
import io.opentelemetry.sdk.metrics.internal.view.ViewRegistry;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class RegisteredReader {
    private static final AtomicInteger ID_COUNTER = new AtomicInteger(1);
    private final int id = ID_COUNTER.incrementAndGet();
    private volatile long lastCollectEpochNanos;
    private final MetricReader metricReader;
    private final ViewRegistry viewRegistry;

    public static RegisteredReader create(MetricReader metricReader, ViewRegistry viewRegistry) {
        return new RegisteredReader(metricReader, viewRegistry);
    }

    private RegisteredReader(MetricReader metricReader, ViewRegistry viewRegistry) {
        this.metricReader = metricReader;
        this.viewRegistry = viewRegistry;
    }

    public MetricReader getReader() {
        return this.metricReader;
    }

    public void setLastCollectEpochNanos(long j) {
        this.lastCollectEpochNanos = j;
    }

    public long getLastCollectEpochNanos() {
        return this.lastCollectEpochNanos;
    }

    public ViewRegistry getViewRegistry() {
        return this.viewRegistry;
    }

    public int hashCode() {
        return this.id;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RegisteredReader) && this.id == ((RegisteredReader) obj).id;
    }

    public String toString() {
        return "RegisteredReader{" + this.id + "}";
    }
}
