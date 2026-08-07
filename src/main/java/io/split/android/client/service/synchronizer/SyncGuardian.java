package io.split.android.client.service.synchronizer;

/* JADX INFO: loaded from: classes4.dex */
public interface SyncGuardian {
    void initialize();

    boolean mustSync();

    void setMaxSyncPeriod(long maxSyncPeriod);

    void updateLastSyncTimestamp();
}
