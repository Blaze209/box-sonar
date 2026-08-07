package sdk.pendo.io.u3;

import sdk.pendo.io.k3.o;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a<T, R> implements o<T>, sdk.pendo.io.t3.b<R> {
    protected final o<? super R> a;
    protected sdk.pendo.io.o3.b b;
    protected sdk.pendo.io.t3.b<T> c;
    protected boolean d;
    protected int e;

    public a(o<? super R> oVar) {
        this.a = oVar;
    }

    protected void a() {
    }

    protected boolean b() {
        return true;
    }

    @Override // sdk.pendo.io.t3.g
    public void clear() {
        this.c.clear();
    }

    @Override // sdk.pendo.io.o3.b
    public void dispose() {
        this.b.dispose();
    }

    @Override // sdk.pendo.io.o3.b
    public boolean isDisposed() {
        return this.b.isDisposed();
    }

    @Override // sdk.pendo.io.t3.g
    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override // sdk.pendo.io.t3.g
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // sdk.pendo.io.k3.o
    public void onComplete() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.a.onComplete();
    }

    @Override // sdk.pendo.io.k3.o
    public void onError(Throwable th) {
        if (this.d) {
            sdk.pendo.io.g4.a.b(th);
        } else {
            this.d = true;
            this.a.onError(th);
        }
    }

    @Override // sdk.pendo.io.k3.o
    public final void onSubscribe(sdk.pendo.io.o3.b bVar) {
        if (sdk.pendo.io.r3.b.a(this.b, bVar)) {
            this.b = bVar;
            if (bVar instanceof sdk.pendo.io.t3.b) {
                this.c = (sdk.pendo.io.t3.b) bVar;
            }
            if (b()) {
                this.a.onSubscribe(this);
                a();
            }
        }
    }

    protected final void a(Throwable th) {
        sdk.pendo.io.p3.b.b(th);
        this.b.dispose();
        onError(th);
    }

    protected final int b(int i) {
        sdk.pendo.io.t3.b<T> bVar = this.c;
        if (bVar == null || (i & 4) != 0) {
            return 0;
        }
        int iA = bVar.a(i);
        if (iA != 0) {
            this.e = iA;
        }
        return iA;
    }
}
