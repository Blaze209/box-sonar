package sdk.pendo.io.a4;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
abstract class a extends AtomicReference<Future<?>> implements sdk.pendo.io.o3.b {
    protected static final FutureTask<Void> c;
    protected static final FutureTask<Void> d;
    protected final Runnable a;
    protected Thread b;

    static {
        Runnable runnable = sdk.pendo.io.s3.a.b;
        c = new FutureTask<>(runnable, null);
        d = new FutureTask<>(runnable, null);
    }

    a(Runnable runnable) {
        this.a = runnable;
    }

    public final void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = get();
            if (future2 == c) {
                return;
            }
            if (future2 == d) {
                future.cancel(this.b != Thread.currentThread());
                return;
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this, future2, future));
    }

    @Override // sdk.pendo.io.o3.b
    public final void dispose() {
        FutureTask<Void> futureTask;
        Future<?> future = get();
        if (future == c || future == (futureTask = d) || !PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this, future, futureTask) || future == null) {
            return;
        }
        future.cancel(this.b != Thread.currentThread());
    }

    @Override // sdk.pendo.io.o3.b
    public final boolean isDisposed() {
        Future<?> future = get();
        return future == c || future == d;
    }
}
