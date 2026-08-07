package io.opentelemetry.instrumentation.api.internal.cache;

import io.opentelemetry.instrumentation.api.internal.cache.weaklockfree.WeakConcurrentMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes4.dex */
final class WeakLockFreeCache<K, V> implements Cache<K, V> {
    private final WeakConcurrentMap<K, V> delegate = new WeakConcurrentMap.WithInlinedExpunction();

    WeakLockFreeCache() {
    }

    @Override // io.opentelemetry.instrumentation.api.internal.cache.Cache
    public V computeIfAbsent(K k, Function<? super K, ? extends V> function) {
        return (V) this.delegate.computeIfAbsent(k, function);
    }

    @Override // io.opentelemetry.instrumentation.api.internal.cache.Cache
    public V get(K k) {
        return (V) this.delegate.getIfPresent(k);
    }

    @Override // io.opentelemetry.instrumentation.api.internal.cache.Cache
    public void put(K k, V v) {
        this.delegate.put(k, v);
    }

    @Override // io.opentelemetry.instrumentation.api.internal.cache.Cache
    public void remove(K k) {
        this.delegate.remove(k);
    }

    int size() {
        return this.delegate.approximateSize();
    }
}
