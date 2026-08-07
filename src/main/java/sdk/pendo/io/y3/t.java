package sdk.pendo.io.y3;

/* JADX INFO: loaded from: classes6.dex */
public final class t<T> extends sdk.pendo.io.k3.j<T> implements sdk.pendo.io.t3.e<T> {
    private final T a;

    public t(T t) {
        this.a = t;
    }

    @Override // sdk.pendo.io.k3.j
    protected void b(sdk.pendo.io.k3.o<? super T> oVar) {
        c0.a aVar = new c0.a(oVar, this.a);
        oVar.onSubscribe(aVar);
        aVar.run();
    }

    @Override // sdk.pendo.io.t3.e, java.util.concurrent.Callable
    public T call() {
        return this.a;
    }
}
