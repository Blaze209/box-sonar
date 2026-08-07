package sdk.pendo.io.a4;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class c implements Callable<Void>, sdk.pendo.io.o3.b {
    static final FutureTask<Void> f = new FutureTask<>(sdk.pendo.io.s3.a.b, null);
    final Runnable a;
    final ExecutorService d;
    Thread e;
    final AtomicReference<Future<?>> c = new AtomicReference<>();
    final AtomicReference<Future<?>> b = new AtomicReference<>();

    c(Runnable runnable, ExecutorService executorService) {
        this.a = runnable;
        this.d = executorService;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() {
        this.e = Thread.currentThread();
        try {
            this.a.run();
            b(this.d.submit(this));
            this.e = null;
        } catch (Throwable th) {
            this.e = null;
            sdk.pendo.io.g4.a.b(th);
        }
        return null;
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.b.get();
            if (future2 == f) {
                future.cancel(this.e != Thread.currentThread());
                return;
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.b, future2, future));
    }

    @Override // sdk.pendo.io.o3.b
    public void dispose() {
        AtomicReference<Future<?>> atomicReference = this.c;
        FutureTask<Void> futureTask = f;
        Future<?> andSet = atomicReference.getAndSet(futureTask);
        if (andSet != null && andSet != futureTask) {
            andSet.cancel(this.e != Thread.currentThread());
        }
        Future<?> andSet2 = this.b.getAndSet(futureTask);
        if (andSet2 == null || andSet2 == futureTask) {
            return;
        }
        andSet2.cancel(this.e != Thread.currentThread());
    }

    @Override // sdk.pendo.io.o3.b
    public boolean isDisposed() {
        return this.c.get() == f;
    }

    void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.c.get();
            if (future2 == f) {
                future.cancel(this.e != Thread.currentThread());
                return;
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.c, future2, future));
    }
}
