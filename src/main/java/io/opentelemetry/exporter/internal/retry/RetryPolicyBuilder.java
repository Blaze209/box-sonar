package io.opentelemetry.exporter.internal.retry;

import io.opentelemetry.api.internal.Utils;
import java.time.Duration;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class RetryPolicyBuilder {
    private static final double DEFAULT_BACKOFF_MULTIPLIER = 1.5d;
    private static final int DEFAULT_MAX_ATTEMPTS = 5;
    private static final Duration DEFAULT_INITIAL_BACKOFF = Duration.ofSeconds(1);
    private static final Duration DEFAULT_MAX_BACKOFF = Duration.ofSeconds(5);
    private int maxAttempts = 5;
    private Duration initialBackoff = DEFAULT_INITIAL_BACKOFF;
    private Duration maxBackoff = DEFAULT_MAX_BACKOFF;
    private double backoffMultiplier = 1.5d;

    RetryPolicyBuilder() {
    }

    public RetryPolicyBuilder setMaxAttempts(int i) {
        Utils.checkArgument(i > 1 && i < 6, "maxAttempts must be greater than 1 and less than 6");
        this.maxAttempts = i;
        return this;
    }

    public RetryPolicyBuilder setInitialBackoff(Duration duration) {
        Objects.requireNonNull(duration, "initialBackoff");
        Utils.checkArgument(duration.toNanos() > 0, "initialBackoff must be greater than 0");
        this.initialBackoff = duration;
        return this;
    }

    public RetryPolicyBuilder setMaxBackoff(Duration duration) {
        Objects.requireNonNull(duration, "maxBackoff");
        Utils.checkArgument(duration.toNanos() > 0, "maxBackoff must be greater than 0");
        this.maxBackoff = duration;
        return this;
    }

    public RetryPolicyBuilder setBackoffMultiplier(double d) {
        Utils.checkArgument(d > 0.0d, "backoffMultiplier must be greater than 0");
        this.backoffMultiplier = d;
        return this;
    }

    public RetryPolicy build() {
        return RetryPolicy.create(this.maxAttempts, this.initialBackoff, this.maxBackoff, this.backoffMultiplier);
    }
}
