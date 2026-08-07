package org.apache.hc.core5.util;

import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes5.dex */
public class TimeoutValueException extends TimeoutException {
    private static final long serialVersionUID = 1;
    private final Timeout actual;
    private final Timeout deadline;

    private static long min0(long j) {
        if (j < 0) {
            return 0L;
        }
        return j;
    }

    public static TimeoutValueException fromMilliseconds(long j, long j2) {
        return new TimeoutValueException(Timeout.ofMilliseconds(min0(j)), Timeout.ofMilliseconds(min0(j2)));
    }

    public TimeoutValueException(Timeout timeout, Timeout timeout2) {
        super(String.format("Timeout deadline: %s, actual: %s", timeout, timeout2));
        this.actual = timeout2;
        this.deadline = timeout;
    }

    public Timeout getActual() {
        return this.actual;
    }

    public Timeout getDeadline() {
        return this.deadline;
    }
}
