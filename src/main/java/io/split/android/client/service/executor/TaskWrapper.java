package io.split.android.client.service.executor;

import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
class TaskWrapper implements Runnable {
    private final WeakReference<SplitTaskExecutionListener> mExecutionListener;
    private final SplitTask mTask;

    TaskWrapper(SplitTask task, SplitTaskExecutionListener executionListener) {
        this.mTask = (SplitTask) Utils.checkNotNull(task);
        this.mExecutionListener = new WeakReference<>(executionListener);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            SplitTaskExecutionInfo splitTaskExecutionInfoExecute = this.mTask.execute();
            SplitTaskExecutionListener splitTaskExecutionListener = this.mExecutionListener.get();
            if (splitTaskExecutionListener != null) {
                splitTaskExecutionListener.taskExecuted(splitTaskExecutionInfoExecute);
            }
        } catch (Exception e) {
            Logger.e("An error has occurred while running task on executor: " + e.getLocalizedMessage());
        }
    }
}
