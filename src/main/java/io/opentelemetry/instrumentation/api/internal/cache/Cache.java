package io.opentelemetry.instrumentation.api.internal.cache;

import io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap.ConcurrentLinkedHashMap;
import java.util.function.Function;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface Cache<K, V> {
    V computeIfAbsent(K k, Function<? super K, ? extends V> function);

    @Nullable
    V get(K k);

    void put(K k, V v);

    void remove(K k);

    static <K, V> Cache<K, V> weak() {
        return new WeakLockFreeCache();
    }

    static <K, V> Cache<K, V> bounded(int i) {
        return new MapBackedCache(new ConcurrentLinkedHashMap.Builder().maximumWeightedCapacity(i).build());
    }
}
