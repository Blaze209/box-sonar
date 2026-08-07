package io.split.android.client.service.synchronizer;

import io.split.android.client.service.executor.SplitTaskExecutionListener;

/* JADX INFO: loaded from: classes4.dex */
public interface FeatureFlagsSynchronizer {
    void loadAndSynchronize();

    void startPeriodicFetching();

    void stopPeriodicFetching();

    void stopSynchronization();

    void submitLoadingTask(SplitTaskExecutionListener listener);

    void synchronize();

    void synchronize(Long since, Long rbsSince);
}
