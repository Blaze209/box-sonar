package org.apache.hc.core5.concurrent;

/* JADX INFO: loaded from: classes5.dex */
public abstract class FutureContribution<T> implements FutureCallback<T> {
    private final BasicFuture<?> future;

    public FutureContribution(BasicFuture<?> basicFuture) {
        this.future = basicFuture;
    }

    @Override // org.apache.hc.core5.concurrent.FutureCallback
    public final void failed(Exception exc) {
        BasicFuture<?> basicFuture = this.future;
        if (basicFuture != null) {
            basicFuture.failed(exc);
        }
    }

    @Override // org.apache.hc.core5.concurrent.FutureCallback
    public final void cancelled() {
        BasicFuture<?> basicFuture = this.future;
        if (basicFuture != null) {
            basicFuture.cancel();
        }
    }
}
