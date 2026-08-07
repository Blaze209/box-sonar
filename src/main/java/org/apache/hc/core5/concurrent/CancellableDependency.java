package org.apache.hc.core5.concurrent;

/* JADX INFO: loaded from: classes5.dex */
public interface CancellableDependency extends Cancellable {
    boolean isCancelled();

    void setDependency(Cancellable cancellable);
}
