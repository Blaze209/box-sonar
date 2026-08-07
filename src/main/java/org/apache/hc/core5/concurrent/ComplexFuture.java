package org.apache.hc.core5.concurrent;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public final class ComplexFuture<T> extends BasicFuture<T> implements CancellableDependency {
    private final AtomicReference<Cancellable> dependencyRef;

    public ComplexFuture(FutureCallback<T> futureCallback) {
        super(futureCallback);
        this.dependencyRef = new AtomicReference<>();
    }

    @Override // org.apache.hc.core5.concurrent.CancellableDependency
    public void setDependency(Cancellable cancellable) {
        Args.notNull(cancellable, "dependency");
        if (isDone()) {
            cancellable.cancel();
        } else {
            this.dependencyRef.set(cancellable);
        }
    }

    public void setDependency(final Future<?> future) {
        Args.notNull(future, "dependency");
        if (future instanceof Cancellable) {
            setDependency((Cancellable) future);
        } else {
            setDependency(new Cancellable() { // from class: org.apache.hc.core5.concurrent.ComplexFuture$$ExternalSyntheticLambda0
                @Override // org.apache.hc.core5.concurrent.Cancellable
                public final boolean cancel() {
                    return future.cancel(true);
                }
            });
        }
    }

    @Override // org.apache.hc.core5.concurrent.BasicFuture
    public boolean completed(T t) {
        boolean zCompleted = super.completed(t);
        this.dependencyRef.set(null);
        return zCompleted;
    }

    @Override // org.apache.hc.core5.concurrent.BasicFuture
    public boolean failed(Exception exc) {
        boolean zFailed = super.failed(exc);
        this.dependencyRef.set(null);
        return zFailed;
    }

    @Override // org.apache.hc.core5.concurrent.BasicFuture, java.util.concurrent.Future
    public boolean cancel(boolean z) {
        boolean zCancel = super.cancel(z);
        Cancellable andSet = this.dependencyRef.getAndSet(null);
        if (andSet != null) {
            andSet.cancel();
        }
        return zCancel;
    }
}
