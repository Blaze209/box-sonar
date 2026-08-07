package io.split.android.client.service.executor;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface SplitTaskExecutor {
    void executeSerially(List<SplitTaskBatchItem> tasks);

    void pause();

    void resume();

    String schedule(SplitTask task, long initialDelayInSecs, long periodInSecs, SplitTaskExecutionListener executionListener);

    String schedule(SplitTask task, long initialDelayInSecs, SplitTaskExecutionListener executionListener);

    void stop();

    void stopTask(String taskId);

    void submit(SplitTask task, SplitTaskExecutionListener executionListener);

    void submitOnMainThread(SplitTask splitTask);
}
