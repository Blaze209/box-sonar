package org.apache.hc.core5.concurrent;

import java.util.concurrent.atomic.AtomicMarkableReference;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public final class ComplexCancellable implements CancellableDependency {
    private final AtomicMarkableReference<Cancellable> dependencyRef = new AtomicMarkableReference<>(null, false);

    @Override // org.apache.hc.core5.concurrent.CancellableDependency
    public boolean isCancelled() {
        return this.dependencyRef.isMarked();
    }

    @Override // org.apache.hc.core5.concurrent.CancellableDependency
    public void setDependency(Cancellable cancellable) {
        Args.notNull(cancellable, "dependency");
        if (this.dependencyRef.compareAndSet(this.dependencyRef.getReference(), cancellable, false, false)) {
            return;
        }
        cancellable.cancel();
    }

    @Override // org.apache.hc.core5.concurrent.Cancellable
    public boolean cancel() {
        while (!this.dependencyRef.isMarked()) {
            Cancellable reference = this.dependencyRef.getReference();
            if (this.dependencyRef.compareAndSet(reference, reference, false, true)) {
                if (reference != null) {
                    reference.cancel();
                }
                return true;
            }
        }
        return false;
    }
}
