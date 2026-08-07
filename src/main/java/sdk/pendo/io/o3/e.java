package sdk.pendo.io.o3;

/* JADX INFO: loaded from: classes4.dex */
final class e extends d<Runnable> {
    e(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return "RunnableDisposable(disposed=" + isDisposed() + ", " + get() + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.o3.d
    public void a(Runnable runnable) {
        runnable.run();
    }
}
