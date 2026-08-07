package io.split.android.client.service.executor;

import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class SplitTaskBatchWrapper implements Runnable {
    private final List<SplitTaskBatchItem> mTaskQueue;

    SplitTaskBatchWrapper(List<SplitTaskBatchItem> taskQueue) {
        this.mTaskQueue = (List) Utils.checkNotNull(taskQueue);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            for (SplitTaskBatchItem splitTaskBatchItem : this.mTaskQueue) {
                SplitTaskExecutionInfo splitTaskExecutionInfoExecute = splitTaskBatchItem.getTask().execute();
                SplitTaskExecutionListener listener = splitTaskBatchItem.getListener();
                if (listener != null) {
                    listener.taskExecuted(splitTaskExecutionInfoExecute);
                }
            }
        } catch (Exception e) {
            Logger.e("An error has occurred while running task on executor: " + e.getLocalizedMessage());
        }
    }
}
