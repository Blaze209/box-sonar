package io.split.android.client.impressions;

import io.split.android.client.service.synchronizer.SyncManager;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;

/* JADX INFO: loaded from: classes4.dex */
class ImpressionLoggingTask implements Runnable {
    private final DecoratedImpression mImpression;
    private final SyncManager mSyncManager;

    ImpressionLoggingTask(SyncManager syncManager, DecoratedImpression impression) {
        this.mSyncManager = (SyncManager) Utils.checkNotNull(syncManager);
        this.mImpression = impression;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.mSyncManager.pushImpression(this.mImpression);
        } catch (Throwable th) {
            Logger.v("An error occurred logging impression: " + th.getLocalizedMessage());
        }
    }
}
