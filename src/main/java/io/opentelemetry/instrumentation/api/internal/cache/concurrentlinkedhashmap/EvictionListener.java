package io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap;

/* JADX INFO: loaded from: classes4.dex */
public interface EvictionListener<K, V> {
    void onEviction(K k, V v);
}
