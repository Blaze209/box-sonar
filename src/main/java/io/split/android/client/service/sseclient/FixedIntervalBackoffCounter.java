package io.split.android.client.service.sseclient;

/* JADX INFO: loaded from: classes4.dex */
public class FixedIntervalBackoffCounter implements BackoffCounter {
    private final long mRetryInterval;

    @Override // io.split.android.client.service.sseclient.BackoffCounter
    public void resetCounter() {
    }

    public FixedIntervalBackoffCounter(long retryInterval) {
        this.mRetryInterval = retryInterval;
    }

    @Override // io.split.android.client.service.sseclient.BackoffCounter
    public long getNextRetryTime() {
        return this.mRetryInterval;
    }
}
