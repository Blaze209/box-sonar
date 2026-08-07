package io.split.android.client.service.sseclient;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
public class ReconnectBackoffCounter implements BackoffCounter {
    private static final int MAX_TIME_LIMIT_IN_SECS = 1800;
    private static final int RETRY_EXPONENTIAL_BASE = 2;
    private final AtomicLong mAttemptCount;
    private final int mBackoffBase;
    private final int mMaxTimeLimit;

    public ReconnectBackoffCounter(int backoffBase) {
        this(backoffBase, MAX_TIME_LIMIT_IN_SECS);
    }

    public ReconnectBackoffCounter(int backoffBase, int maxTimeLimit) {
        this.mBackoffBase = backoffBase;
        this.mAttemptCount = new AtomicLong(0L);
        this.mMaxTimeLimit = maxTimeLimit;
    }

    @Override // io.split.android.client.service.sseclient.BackoffCounter
    public long getNextRetryTime() {
        return Math.min((long) Math.pow(this.mBackoffBase * 2, this.mAttemptCount.getAndAdd(1L)), this.mMaxTimeLimit);
    }

    @Override // io.split.android.client.service.sseclient.BackoffCounter
    public void resetCounter() {
        this.mAttemptCount.set(0L);
    }
}
