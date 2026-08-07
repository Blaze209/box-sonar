package org.apache.hc.core5.pool;

import java.util.concurrent.Future;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.io.ModalCloseable;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public interface ConnPool<T, C extends ModalCloseable> {
    Future<PoolEntry<T, C>> lease(T t, Object obj, Timeout timeout, FutureCallback<PoolEntry<T, C>> futureCallback);

    void release(PoolEntry<T, C> poolEntry, boolean z);
}
