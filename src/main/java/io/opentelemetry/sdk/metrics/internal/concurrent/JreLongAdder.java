package io.opentelemetry.sdk.metrics.internal.concurrent;

/* JADX INFO: loaded from: classes4.dex */
final class JreLongAdder implements LongAdder {
    private final java.util.concurrent.atomic.LongAdder delegate = new java.util.concurrent.atomic.LongAdder();

    JreLongAdder() {
    }

    @Override // io.opentelemetry.sdk.metrics.internal.concurrent.LongAdder
    public void add(long j) {
        this.delegate.add(j);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.concurrent.LongAdder
    public long sum() {
        return this.delegate.sum();
    }

    @Override // io.opentelemetry.sdk.metrics.internal.concurrent.LongAdder
    public void reset() {
        this.delegate.reset();
    }

    @Override // io.opentelemetry.sdk.metrics.internal.concurrent.LongAdder
    public long sumThenReset() {
        return this.delegate.sumThenReset();
    }

    public String toString() {
        return this.delegate.toString();
    }
}
