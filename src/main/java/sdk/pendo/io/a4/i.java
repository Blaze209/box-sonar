package sdk.pendo.io.a4;

/* JADX INFO: loaded from: classes4.dex */
public final class i extends a implements Runnable {
    public i(Runnable runnable) {
        super(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b = Thread.currentThread();
        try {
            this.a.run();
            this.b = null;
        } catch (Throwable th) {
            this.b = null;
            lazySet(a.c);
            sdk.pendo.io.g4.a.b(th);
        }
    }
}
