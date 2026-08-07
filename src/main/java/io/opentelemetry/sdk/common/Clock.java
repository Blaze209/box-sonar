package io.opentelemetry.sdk.common;

/* JADX INFO: loaded from: classes4.dex */
public interface Clock {
    long nanoTime();

    long now();

    static Clock getDefault() {
        return SystemClock.getInstance();
    }
}
