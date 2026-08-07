package io.opentelemetry.sdk.metrics.internal.concurrent;

/* JADX INFO: loaded from: classes4.dex */
final class JreDoubleAdder implements DoubleAdder {
    private final java.util.concurrent.atomic.DoubleAdder delegate = new java.util.concurrent.atomic.DoubleAdder();

    JreDoubleAdder() {
    }

    @Override // io.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder
    public void add(double d) {
        this.delegate.add(d);
    }

    @Override // io.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder
    public double sum() {
        return this.delegate.sum();
    }

    @Override // io.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder
    public void reset() {
        this.delegate.reset();
    }

    @Override // io.opentelemetry.sdk.metrics.internal.concurrent.DoubleAdder
    public double sumThenReset() {
        return this.delegate.sumThenReset();
    }

    public String toString() {
        return this.delegate.toString();
    }
}
