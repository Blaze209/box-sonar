package io.split.android.client.service.synchronizer;

import io.split.android.client.SplitClientConfig;
import io.split.android.client.utils.logger.Logger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
public class SyncGuardianImpl implements SyncGuardian {
    private final AtomicLong mDefaultMaxSyncPeriod;
    private boolean mIsInitialized;
    private final AtomicLong mLastSyncTimestamp;
    private final AtomicLong mMaxSyncPeriod;
    private final TimestampProvider mNewTimestamp;
    private final boolean mStreamingEnabled;
    private final boolean mSyncEnabled;

    interface TimestampProvider {
        long get();
    }

    public SyncGuardianImpl(SplitClientConfig splitConfig) {
        this(splitConfig, null);
    }

    SyncGuardianImpl(SplitClientConfig splitConfig, TimestampProvider timestampProvider) {
        this.mIsInitialized = false;
        long jDefaultSSEConnectionDelay = splitConfig.defaultSSEConnectionDelay();
        this.mDefaultMaxSyncPeriod = new AtomicLong(jDefaultSSEConnectionDelay);
        this.mMaxSyncPeriod = new AtomicLong(jDefaultSSEConnectionDelay);
        this.mLastSyncTimestamp = new AtomicLong(0L);
        this.mSyncEnabled = splitConfig.syncEnabled();
        this.mStreamingEnabled = splitConfig.streamingEnabled();
        this.mNewTimestamp = timestampProvider == null ? new TimestampProvider() { // from class: io.split.android.client.service.synchronizer.SyncGuardianImpl$$ExternalSyntheticLambda0
            @Override // io.split.android.client.service.synchronizer.SyncGuardianImpl.TimestampProvider
            public final long get() {
                return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
            }
        } : timestampProvider;
    }

    @Override // io.split.android.client.service.synchronizer.SyncGuardian
    public void updateLastSyncTimestamp() {
        this.mLastSyncTimestamp.set(this.mNewTimestamp.get());
    }

    @Override // io.split.android.client.service.synchronizer.SyncGuardian
    public boolean mustSync() {
        return this.mIsInitialized && this.mSyncEnabled && this.mStreamingEnabled && this.mNewTimestamp.get() - this.mLastSyncTimestamp.get() >= this.mMaxSyncPeriod.get();
    }

    @Override // io.split.android.client.service.synchronizer.SyncGuardian
    public void setMaxSyncPeriod(long newPeriod) {
        this.mMaxSyncPeriod.set(Math.max(newPeriod, this.mDefaultMaxSyncPeriod.get()));
        Logger.v("Setting new max sync period: " + this.mMaxSyncPeriod.get() + " seconds");
    }

    @Override // io.split.android.client.service.synchronizer.SyncGuardian
    public void initialize() {
        if (this.mIsInitialized) {
            return;
        }
        this.mIsInitialized = true;
    }
}
