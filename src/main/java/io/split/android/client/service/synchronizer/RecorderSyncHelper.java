package io.split.android.client.service.synchronizer;

import io.split.android.client.service.executor.SplitTaskExecutionListener;
import io.split.android.client.storage.common.InBytesSizable;

/* JADX INFO: loaded from: classes4.dex */
public interface RecorderSyncHelper<T extends InBytesSizable> extends SplitTaskExecutionListener {
    void addListener(SplitTaskExecutionListener listener);

    boolean pushAndCheckIfFlushNeeded(T entity);

    void removeListener(SplitTaskExecutionListener listener);
}
