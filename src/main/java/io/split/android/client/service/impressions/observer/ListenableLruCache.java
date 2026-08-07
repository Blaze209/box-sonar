package io.split.android.client.service.impressions.observer;

import android.util.LruCache;

/* JADX INFO: loaded from: classes4.dex */
class ListenableLruCache<K, V> extends LruCache<K, V> {
    private final RemovalListener<K> mRemovalListener;

    interface RemovalListener<T> {
        void onRemoval(T key);
    }

    public ListenableLruCache(int maxSize, RemovalListener<K> removalListener) {
        super(maxSize);
        this.mRemovalListener = removalListener;
    }

    @Override // android.util.LruCache
    protected void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
        super.entryRemoved(evicted, key, oldValue, newValue);
        RemovalListener<K> removalListener = this.mRemovalListener;
        if (removalListener == null || !evicted) {
            return;
        }
        removalListener.onRemoval(key);
    }
}
