package io.split.android.client.service.executor.parallel;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface SplitParallelTaskExecutorFactory {
    <T> SplitParallelTaskExecutor<T> create(Class<T> type);

    <T> SplitParallelTaskExecutor<T> create(Class<T> type, int timeoutInSeconds);

    <T> SplitParallelTaskExecutor<List<T>> createForList(Class<T> type);
}
