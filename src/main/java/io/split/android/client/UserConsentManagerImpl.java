package io.split.android.client;

import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.impressions.ImpressionManager;
import io.split.android.client.service.synchronizer.SyncManager;
import io.split.android.client.shared.UserConsent;
import io.split.android.client.storage.events.EventsStorage;
import io.split.android.client.storage.impressions.ImpressionsStorage;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class UserConsentManagerImpl implements UserConsentManager {
    private UserConsent mCurrentStatus;
    private final EventsStorage mEventsStorage;
    private final SplitFactoryImpl.EventsTrackerProvider mEventsTracker;
    private final ImpressionManager mImpressionManager;
    private final ImpressionsStorage mImpressionsStorage;
    private final Object mLock = new Object();
    private final SplitClientConfig mSplitConfig;
    private final SyncManager mSyncManager;
    private final SplitTaskExecutor mTaskExecutor;

    public UserConsentManagerImpl(SplitClientConfig splitConfig, ImpressionsStorage impressionsStorage, EventsStorage eventsStorage, SyncManager syncManager, SplitFactoryImpl.EventsTrackerProvider eventsTracker, ImpressionManager impressionManager, SplitTaskExecutor taskExecutor) {
        this.mSplitConfig = (SplitClientConfig) Utils.checkNotNull(splitConfig);
        this.mImpressionsStorage = (ImpressionsStorage) Utils.checkNotNull(impressionsStorage);
        this.mEventsStorage = (EventsStorage) Utils.checkNotNull(eventsStorage);
        this.mSyncManager = (SyncManager) Utils.checkNotNull(syncManager);
        this.mEventsTracker = (SplitFactoryImpl.EventsTrackerProvider) Utils.checkNotNull(eventsTracker);
        this.mImpressionManager = (ImpressionManager) Utils.checkNotNull(impressionManager);
        this.mTaskExecutor = taskExecutor;
        setStatus(splitConfig.userConsent());
    }

    @Override // io.split.android.client.UserConsentManager
    public void setStatus(UserConsent status) {
        synchronized (this.mLock) {
            if (this.mCurrentStatus == status) {
                return;
            }
            this.mSplitConfig.setUserConsent(status);
            enableTracking(status);
            enablePersistence(status);
            this.mSyncManager.setupUserConsent(status);
            this.mCurrentStatus = status;
            Logger.d("User consent set to " + status.toString());
        }
    }

    @Override // io.split.android.client.UserConsentManager
    public UserConsent getStatus() {
        UserConsent userConsent;
        synchronized (this.mLock) {
            userConsent = this.mCurrentStatus;
        }
        return userConsent;
    }

    private void enableTracking(UserConsent status) {
        boolean z = status != UserConsent.DECLINED;
        this.mEventsTracker.getEventsTracker().enableTracking(z);
        this.mImpressionManager.enableTracking(z);
        Logger.d("Tracking has been set to " + z);
    }

    private void enablePersistence(UserConsent status) {
        final boolean z = status == UserConsent.GRANTED;
        this.mTaskExecutor.submit(new SplitTask() { // from class: io.split.android.client.UserConsentManagerImpl.1
            @Override // io.split.android.client.service.executor.SplitTask
            public SplitTaskExecutionInfo execute() {
                UserConsentManagerImpl.this.mImpressionsStorage.enablePersistence(z);
                UserConsentManagerImpl.this.mEventsStorage.enablePersistence(z);
                return SplitTaskExecutionInfo.success(SplitTaskType.GENERIC_TASK);
            }
        }, null);
        Logger.d("Persistence has been set to " + z);
    }
}
