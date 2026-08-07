package io.opentelemetry.rum.internal;

import io.opentelemetry.rum.internal.instrumentation.ApplicationStateListener;
import io.opentelemetry.sdk.common.Clock;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
final class SessionIdTimeoutHandler implements ApplicationStateListener {
    private static final long SESSION_TIMEOUT_NANOS = TimeUnit.MINUTES.toNanos(15);
    private final Clock clock;
    private volatile State state;
    private volatile long timeoutStartNanos;

    private enum State {
        FOREGROUND,
        BACKGROUND,
        TRANSITIONING_TO_FOREGROUND
    }

    SessionIdTimeoutHandler() {
        this(Clock.getDefault());
    }

    SessionIdTimeoutHandler(Clock clock) {
        this.state = State.FOREGROUND;
        this.clock = clock;
    }

    @Override // io.opentelemetry.rum.internal.instrumentation.ApplicationStateListener
    public void onApplicationForegrounded() {
        this.state = State.TRANSITIONING_TO_FOREGROUND;
    }

    @Override // io.opentelemetry.rum.internal.instrumentation.ApplicationStateListener
    public void onApplicationBackgrounded() {
        this.state = State.BACKGROUND;
    }

    boolean hasTimedOut() {
        return this.state != State.FOREGROUND && this.clock.nanoTime() - this.timeoutStartNanos >= SESSION_TIMEOUT_NANOS;
    }

    void bump() {
        this.timeoutStartNanos = this.clock.nanoTime();
        if (this.state == State.TRANSITIONING_TO_FOREGROUND) {
            this.state = State.FOREGROUND;
        }
    }
}
