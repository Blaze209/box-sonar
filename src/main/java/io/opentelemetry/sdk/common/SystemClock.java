package io.opentelemetry.sdk.common;

import io.opentelemetry.sdk.internal.JavaVersionSpecific;

/* JADX INFO: loaded from: classes4.dex */
final class SystemClock implements Clock {
    private static final SystemClock INSTANCE = new SystemClock();

    private SystemClock() {
    }

    static Clock getInstance() {
        return INSTANCE;
    }

    @Override // io.opentelemetry.sdk.common.Clock
    public long now() {
        return JavaVersionSpecific.get().currentTimeNanos();
    }

    @Override // io.opentelemetry.sdk.common.Clock
    public long nanoTime() {
        return System.nanoTime();
    }

    public String toString() {
        return "SystemClock{}";
    }
}
