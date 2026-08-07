package org.apache.hc.core5.concurrent;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CallbackContribution<T> implements FutureCallback<T> {
    private final FutureCallback<?> callback;

    public CallbackContribution(FutureCallback<?> futureCallback) {
        this.callback = futureCallback;
    }

    @Override // org.apache.hc.core5.concurrent.FutureCallback
    public final void failed(Exception exc) {
        FutureCallback<?> futureCallback = this.callback;
        if (futureCallback != null) {
            futureCallback.failed(exc);
        }
    }

    @Override // org.apache.hc.core5.concurrent.FutureCallback
    public final void cancelled() {
        FutureCallback<?> futureCallback = this.callback;
        if (futureCallback != null) {
            futureCallback.cancelled();
        }
    }
}
