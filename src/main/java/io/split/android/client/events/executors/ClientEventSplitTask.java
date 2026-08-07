package io.split.android.client.events.executors;

import io.split.android.client.SplitClient;
import io.split.android.client.events.SplitEventTask;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;

/* JADX INFO: loaded from: classes4.dex */
class ClientEventSplitTask implements SplitTask {
    private final boolean mIsMainThread;
    private final SplitClient mSplitClient;
    private final SplitEventTask mTask;

    ClientEventSplitTask(SplitEventTask task, SplitClient client, boolean isMainThread) {
        this.mTask = task;
        this.mSplitClient = client;
        this.mIsMainThread = isMainThread;
    }

    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        try {
            if (this.mIsMainThread) {
                this.mTask.onPostExecutionView(this.mSplitClient);
            } else {
                this.mTask.onPostExecution(this.mSplitClient);
            }
            return SplitTaskExecutionInfo.success(SplitTaskType.GENERIC_TASK);
        } catch (Exception unused) {
            return SplitTaskExecutionInfo.error(SplitTaskType.GENERIC_TASK);
        }
    }
}
