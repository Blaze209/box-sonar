package io.split.android.client.service.executor;

import io.split.android.client.utils.Utils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public class SplitTaskBatchItem {
    private final WeakReference<SplitTaskExecutionListener> listener;
    private final SplitTask task;

    public SplitTaskBatchItem(SplitTask task, SplitTaskExecutionListener listener) {
        this.task = (SplitTask) Utils.checkNotNull(task);
        this.listener = new WeakReference<>(listener);
    }

    public SplitTask getTask() {
        return this.task;
    }

    public SplitTaskExecutionListener getListener() {
        return this.listener.get();
    }
}
