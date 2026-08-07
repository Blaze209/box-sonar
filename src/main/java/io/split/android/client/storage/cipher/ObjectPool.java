package io.split.android.client.storage.cipher;

import androidx.core.util.Pools;

/* JADX INFO: loaded from: classes4.dex */
class ObjectPool<T> {
    private final ObjectPoolFactory<T> mFactory;
    private final Pools.SynchronizedPool<T> mPool;

    ObjectPool(int maxSize, ObjectPoolFactory<T> factory) {
        this.mFactory = factory;
        this.mPool = new Pools.SynchronizedPool<>(maxSize);
    }

    T acquire() {
        T tAcquire = this.mPool.acquire();
        return tAcquire == null ? this.mFactory.createObject() : tAcquire;
    }

    void release(T instance) {
        this.mPool.release(instance);
    }
}
