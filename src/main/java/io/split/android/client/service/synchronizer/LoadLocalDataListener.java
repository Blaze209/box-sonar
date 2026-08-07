package io.split.android.client.service.synchronizer;

import io.split.android.client.events.ISplitEventsManager;
import io.split.android.client.events.SplitInternalEvent;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.service.executor.SplitTaskExecutionStatus;
import io.split.android.client.utils.Utils;

/* JADX INFO: loaded from: classes4.dex */
public class LoadLocalDataListener implements SplitTaskExecutionListener {
    private final SplitInternalEvent mEventToFire;
    private final ISplitEventsManager mSplitEventsManager;

    public LoadLocalDataListener(ISplitEventsManager splitEventsManager, SplitInternalEvent eventToFire) {
        this.mSplitEventsManager = (ISplitEventsManager) Utils.checkNotNull(splitEventsManager);
        this.mEventToFire = (SplitInternalEvent) Utils.checkNotNull(eventToFire);
    }

    @Override // io.split.android.client.service.executor.SplitTaskExecutionListener
    public void taskExecuted(SplitTaskExecutionInfo taskInfo) {
        if (taskInfo.getStatus().equals(SplitTaskExecutionStatus.SUCCESS)) {
            this.mSplitEventsManager.notifyInternalEvent(this.mEventToFire);
        }
    }
}
