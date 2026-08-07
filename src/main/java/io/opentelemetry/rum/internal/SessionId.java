package io.opentelemetry.rum.internal;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import io.opentelemetry.api.trace.TraceId;
import io.opentelemetry.sdk.common.Clock;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
class SessionId {
    private static final long SESSION_LIFETIME_NANOS = TimeUnit.HOURS.toNanos(4);
    private final Clock clock;
    private volatile long createTimeNanos;
    private volatile SessionIdChangeListener sessionIdChangeListener;
    private final SessionIdTimeoutHandler timeoutHandler;
    private final AtomicReference<String> value;

    SessionId(SessionIdTimeoutHandler sessionIdTimeoutHandler) {
        this(Clock.getDefault(), sessionIdTimeoutHandler);
    }

    SessionId(Clock clock, SessionIdTimeoutHandler sessionIdTimeoutHandler) {
        AtomicReference<String> atomicReference = new AtomicReference<>();
        this.value = atomicReference;
        this.clock = clock;
        this.timeoutHandler = sessionIdTimeoutHandler;
        atomicReference.set(createNewId());
        this.createTimeNanos = clock.now();
    }

    private static String createNewId() {
        Random random = new Random();
        return TraceId.fromLongs(random.nextLong(), random.nextLong());
    }

    String getSessionId() {
        boolean zM;
        String str;
        String str2 = (String) Objects.requireNonNull(this.value.get());
        if (sessionExpired() || this.timeoutHandler.hasTimedOut()) {
            zM = PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.value, str2, createNewId());
            if (zM) {
                this.createTimeNanos = this.clock.nanoTime();
            }
            str = (String) Objects.requireNonNull(this.value.get());
        } else {
            zM = false;
            str = str2;
        }
        this.timeoutHandler.bump();
        SessionIdChangeListener sessionIdChangeListener = this.sessionIdChangeListener;
        if (zM && sessionIdChangeListener != null) {
            sessionIdChangeListener.onChange(str2, str);
        }
        return str;
    }

    private boolean sessionExpired() {
        return this.clock.nanoTime() - this.createTimeNanos >= SESSION_LIFETIME_NANOS;
    }

    void setSessionIdChangeListener(SessionIdChangeListener sessionIdChangeListener) {
        this.sessionIdChangeListener = sessionIdChangeListener;
    }

    public String toString() {
        return (String) Objects.requireNonNull(this.value.get());
    }
}
