package io.split.android.client.impressions;

import io.split.android.client.service.synchronizer.SyncManager;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes4.dex */
public class SyncImpressionListener implements DecoratedImpressionListener {
    private final ExecutorService mExecutorService;
    private final SyncManager mSyncManager;

    public SyncImpressionListener(SyncManager syncManager, ExecutorService executorService) {
        this.mSyncManager = (SyncManager) Utils.checkNotNull(syncManager);
        this.mExecutorService = (ExecutorService) Utils.checkNotNull(executorService);
    }

    @Override // io.split.android.client.impressions.DecoratedImpressionListener
    public void log(DecoratedImpression impression) {
        try {
            this.mExecutorService.submit(new ImpressionLoggingTask(this.mSyncManager, impression));
        } catch (Exception e) {
            Logger.w("Error submitting impression logging task: " + e.getLocalizedMessage());
        }
    }
}
