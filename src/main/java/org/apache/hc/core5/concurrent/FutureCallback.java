package org.apache.hc.core5.concurrent;

/* JADX INFO: loaded from: classes5.dex */
public interface FutureCallback<T> {
    void cancelled();

    void completed(T t);

    void failed(Exception exc);
}
