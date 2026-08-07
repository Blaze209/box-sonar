package io.split.android.client.service.executor.parallel;

import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface SplitParallelTaskExecutor<T> {
    List<T> execute(Collection<SplitDeferredTaskItem<T>> taskItems);

    int getAvailableThreads();
}
