package io.split.android.client.service.impressions.strategy;

import io.split.android.client.impressions.Impression;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.impressions.ImpressionsCounter;
import io.split.android.client.service.impressions.ImpressionsTaskFactory;
import io.split.android.client.service.impressions.unique.UniqueKeysTracker;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
class NoneStrategy implements ProcessStrategy {
    private final ImpressionsCounter mImpressionsCounter;
    private final SplitTaskExecutor mTaskExecutor;
    private final ImpressionsTaskFactory mTaskFactory;
    private final AtomicBoolean mTrackingIsEnabled;
    private final UniqueKeysTracker mUniqueKeysTracker;

    NoneStrategy(SplitTaskExecutor taskExecutor, ImpressionsTaskFactory taskFactory, ImpressionsCounter impressionsCounter, UniqueKeysTracker uniqueKeysTracker, boolean trackingIsEnabled) {
        this.mTaskExecutor = (SplitTaskExecutor) io.split.android.client.utils.Utils.checkNotNull(taskExecutor);
        this.mTaskFactory = (ImpressionsTaskFactory) io.split.android.client.utils.Utils.checkNotNull(taskFactory);
        this.mImpressionsCounter = (ImpressionsCounter) io.split.android.client.utils.Utils.checkNotNull(impressionsCounter);
        this.mUniqueKeysTracker = (UniqueKeysTracker) io.split.android.client.utils.Utils.checkNotNull(uniqueKeysTracker);
        this.mTrackingIsEnabled = new AtomicBoolean(trackingIsEnabled);
    }

    @Override // io.split.android.client.service.impressions.strategy.ProcessStrategy
    public void apply(Impression impression) {
        this.mImpressionsCounter.inc(impression.split(), impression.time(), 1);
        this.mUniqueKeysTracker.track(impression.key(), impression.split());
        if (this.mUniqueKeysTracker.isFull()) {
            saveUniqueKeys();
        }
    }

    private void saveUniqueKeys() {
        if (this.mTrackingIsEnabled.get()) {
            this.mTaskExecutor.submit(this.mTaskFactory.createSaveUniqueImpressionsTask(this.mUniqueKeysTracker.popAll()), null);
        }
    }
}
