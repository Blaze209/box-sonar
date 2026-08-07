package org.apache.hc.core5.util;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes5.dex */
public class DeadlineTimeoutException extends TimeoutException {
    private static final long serialVersionUID = 1;
    private final Deadline deadline;

    public static DeadlineTimeoutException from(Deadline deadline) {
        return new DeadlineTimeoutException(deadline);
    }

    private DeadlineTimeoutException(Deadline deadline) {
        super(deadline.format(TimeUnit.MILLISECONDS));
        this.deadline = deadline;
    }

    public Deadline getDeadline() {
        return this.deadline;
    }
}
