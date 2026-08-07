package org.apache.hc.core5.reactor;

/* JADX INFO: loaded from: classes5.dex */
final class IOReactorWorker implements Runnable {
    private final AbstractSingleCoreIOReactor ioReactor;
    private volatile Throwable throwable;

    public IOReactorWorker(AbstractSingleCoreIOReactor abstractSingleCoreIOReactor) {
        this.ioReactor = abstractSingleCoreIOReactor;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.ioReactor.execute();
        } catch (Error e) {
            this.throwable = e;
            throw e;
        } catch (Exception e2) {
            this.throwable = e2;
        }
    }

    public Throwable getThrowable() {
        return this.throwable;
    }
}
