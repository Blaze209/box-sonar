package io.opentelemetry.instrumentation.api.internal.cache.concurrentlinkedhashmap;

/* JADX INFO: loaded from: classes4.dex */
public interface Weigher<V> {
    int weightOf(V v);
}
