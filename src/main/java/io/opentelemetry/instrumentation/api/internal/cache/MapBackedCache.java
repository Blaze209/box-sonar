package io.opentelemetry.instrumentation.api.internal.cache;

import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class MapBackedCache<K, V> implements Cache<K, V> {
    private final ConcurrentMap<K, V> delegate;

    MapBackedCache(ConcurrentMap<K, V> concurrentMap) {
        this.delegate = concurrentMap;
    }

    @Override // io.opentelemetry.instrumentation.api.internal.cache.Cache
    public V computeIfAbsent(K k, Function<? super K, ? extends V> function) {
        return this.delegate.computeIfAbsent(k, function);
    }

    @Override // io.opentelemetry.instrumentation.api.internal.cache.Cache
    @Nullable
    public V get(K k) {
        return this.delegate.get(k);
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
        return this.delegate.size();
    }
}
