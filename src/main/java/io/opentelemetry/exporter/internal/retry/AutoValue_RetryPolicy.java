package io.opentelemetry.exporter.internal.retry;

import java.time.Duration;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_RetryPolicy extends RetryPolicy {
    private final double backoffMultiplier;
    private final Duration initialBackoff;
    private final int maxAttempts;
    private final Duration maxBackoff;

    AutoValue_RetryPolicy(int i, Duration duration, Duration duration2, double d) {
        this.maxAttempts = i;
        if (duration == null) {
            throw new NullPointerException("Null initialBackoff");
        }
        this.initialBackoff = duration;
        if (duration2 == null) {
            throw new NullPointerException("Null maxBackoff");
        }
        this.maxBackoff = duration2;
        this.backoffMultiplier = d;
    }

    @Override // io.opentelemetry.exporter.internal.retry.RetryPolicy
    public int getMaxAttempts() {
        return this.maxAttempts;
    }

    @Override // io.opentelemetry.exporter.internal.retry.RetryPolicy
    public Duration getInitialBackoff() {
        return this.initialBackoff;
    }

    @Override // io.opentelemetry.exporter.internal.retry.RetryPolicy
    public Duration getMaxBackoff() {
        return this.maxBackoff;
    }

    @Override // io.opentelemetry.exporter.internal.retry.RetryPolicy
    public double getBackoffMultiplier() {
        return this.backoffMultiplier;
    }

    public String toString() {
        return "RetryPolicy{maxAttempts=" + this.maxAttempts + ", initialBackoff=" + this.initialBackoff + ", maxBackoff=" + this.maxBackoff + ", backoffMultiplier=" + this.backoffMultiplier + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RetryPolicy) {
            RetryPolicy retryPolicy = (RetryPolicy) obj;
            if (this.maxAttempts == retryPolicy.getMaxAttempts() && this.initialBackoff.equals(retryPolicy.getInitialBackoff()) && this.maxBackoff.equals(retryPolicy.getMaxBackoff()) && Double.doubleToLongBits(this.backoffMultiplier) == Double.doubleToLongBits(retryPolicy.getBackoffMultiplier())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((int) ((Double.doubleToLongBits(this.backoffMultiplier) >>> 32) ^ Double.doubleToLongBits(this.backoffMultiplier))) ^ ((((((this.maxAttempts ^ 1000003) * 1000003) ^ this.initialBackoff.hashCode()) * 1000003) ^ this.maxBackoff.hashCode()) * 1000003);
    }
}
