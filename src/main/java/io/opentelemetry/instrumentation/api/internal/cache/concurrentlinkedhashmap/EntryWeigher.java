package io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap;

/* JADX INFO: loaded from: classes4.dex */
public interface EntryWeigher<K, V> {
    int weightOf(K k, V v);
}
