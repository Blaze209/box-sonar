package sdk.pendo.io.a4;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes4.dex */
public final class j extends a implements Callable<Void> {
    public j(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void call() {
        this.b = Thread.currentThread();
        try {
            this.a.run();
            return null;
        } finally {
            lazySet(a.c);
            this.b = null;
        }
    }
}
