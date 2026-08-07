package io.split.android.client.service.splits;

import io.split.android.client.dtos.Split;
import io.split.android.client.events.ISplitEventsManager;
import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class SplitKillTask implements SplitTask {
    private final ISplitEventsManager mEventsManager;
    private final Split mKilledSplit;
    private final SplitsStorage mSplitsStorage;

    public SplitKillTask(SplitsStorage splitsStorage, Split split, ISplitEventsManager eventsManager) {
        this.mSplitsStorage = (SplitsStorage) Utils.checkNotNull(splitsStorage);
        this.mKilledSplit = split;
        this.mEventsManager = eventsManager;
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        try {
            if (this.mKilledSplit == null) {
                logError("Feature flag name to kill could not be null.");
                return SplitTaskExecutionInfo.error(SplitTaskType.SPLIT_KILL);
            }
            if (this.mKilledSplit.changeNumber <= this.mSplitsStorage.getTill()) {
                Logger.d("Skipping killed feature flag notification for old change number: " + this.mKilledSplit.changeNumber);
                return SplitTaskExecutionInfo.success(SplitTaskType.SPLIT_KILL);
            }
            Split split = this.mSplitsStorage.get(this.mKilledSplit.name);
            if (split == null) {
                Logger.d("Skipping " + this.mKilledSplit.name + " since not in storage");
                return SplitTaskExecutionInfo.error(SplitTaskType.SPLIT_KILL);
            }
            split.killed = true;
            split.defaultTreatment = this.mKilledSplit.defaultTreatment;
            split.changeNumber = this.mKilledSplit.changeNumber;
            this.mSplitsStorage.updateWithoutChecks(split);
            this.mEventsManager.notifyInternalEvent(SplitInternalEvent.SPLIT_KILLED_NOTIFICATION);
            Logger.d("Killed feature flag has been updated");
            return SplitTaskExecutionInfo.success(SplitTaskType.SPLIT_KILL);
        } catch (Exception e) {
            logError("Unknown error while updating killed feature flag: " + e.getLocalizedMessage());
            return SplitTaskExecutionInfo.error(SplitTaskType.SPLIT_KILL);
        }
    }

    private void logError(String message) {
        Logger.e("Error while executing feature flag kill task: " + message);
    }
}
