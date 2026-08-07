package io.opentelemetry.exporter.internal.retry;

import java.time.Duration;

/* JADX INFO: loaded from: classes4.dex */
public abstract class RetryPolicy {
    private static final RetryPolicy DEFAULT = new RetryPolicyBuilder().build();

    public abstract double getBackoffMultiplier();

    public abstract Duration getInitialBackoff();

    public abstract int getMaxAttempts();

    public abstract Duration getMaxBackoff();

    RetryPolicy() {
    }

    public static RetryPolicy getDefault() {
        return DEFAULT;
    }

    public static RetryPolicyBuilder builder() {
        return new RetryPolicyBuilder();
    }

    static RetryPolicy create(int i, Duration duration, Duration duration2, double d) {
        return new AutoValue_RetryPolicy(i, duration, duration2, d);
    }
}
