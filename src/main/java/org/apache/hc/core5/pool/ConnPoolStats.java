package org.apache.hc.core5.pool;

/* JADX INFO: loaded from: classes5.dex */
public interface ConnPoolStats<T> {
    PoolStats getStats(T t);

    PoolStats getTotalStats();
}
