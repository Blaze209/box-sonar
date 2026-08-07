package sdk.pendo.io.u3;

/* JADX INFO: loaded from: classes5.dex */
public final class e<T> extends d<T> {
    @Override // sdk.pendo.io.k3.o
    public void onError(Throwable th) {
        if (this.a == null) {
            this.b = th;
        }
        countDown();
    }

    @Override // sdk.pendo.io.k3.o
    public void onNext(T t) {
        if (this.a == null) {
            this.a = t;
            this.c.dispose();
            countDown();
        }
    }
}
