package io.split.android.client.service.executor.parallel;

import io.split.android.client.utils.Utils;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes4.dex */
public class SplitDeferredTaskItem<T> implements Callable<T> {
    private final Callable<T> mCallable;

    public SplitDeferredTaskItem(Callable<T> callable) {
        this.mCallable = (Callable) Utils.checkNotNull(callable);
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return this.mCallable.call();
    }
}
