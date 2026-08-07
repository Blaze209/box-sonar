package org.apache.hc.core5.pool;

/* JADX INFO: loaded from: classes5.dex */
public interface ConnPoolListener<T> {
    void onLease(T t, ConnPoolStats<T> connPoolStats);

    void onRelease(T t, ConnPoolStats<T> connPoolStats);
}
