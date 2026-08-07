package io.opentelemetry.sdk.metrics.internal.concurrent;

/* JADX INFO: loaded from: classes4.dex */
public interface LongAdder {
    void add(long j);

    void reset();

    long sum();

    long sumThenReset();

    default void increment() {
        add(1L);
    }

    default void decrement() {
        add(-1L);
    }

    default long longValue() {
        return sum();
    }

    default int intValue() {
        return (int) sum();
    }

    default float floatValue() {
        return sum();
    }

    default double doubleValue() {
        return sum();
    }
}
