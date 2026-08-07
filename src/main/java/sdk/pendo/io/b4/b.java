package sdk.pendo.io.b4;

import sdk.pendo.io.k3.e;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b<T, R> implements e<T>, sdk.pendo.io.t3.d<R> {
    protected final sdk.pendo.io.j3.b<? super R> a;
    protected sdk.pendo.io.j3.c b;
    protected sdk.pendo.io.t3.d<T> c;
    protected boolean d;
    protected int e;

    public b(sdk.pendo.io.j3.b<? super R> bVar) {
        this.a = bVar;
    }

    protected void a() {
    }

    protected boolean b() {
        return true;
    }

    @Override // sdk.pendo.io.j3.c
    public void cancel() {
        this.b.cancel();
    }

    @Override // sdk.pendo.io.t3.g
    public void clear() {
        this.c.clear();
    }

    @Override // sdk.pendo.io.t3.g
    public boolean isEmpty() {
        return this.c.isEmpty();
    }

    @Override // sdk.pendo.io.t3.g
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // sdk.pendo.io.j3.b
    public void onComplete() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.a.onComplete();
    }

    @Override // sdk.pendo.io.j3.b
    public void onError(Throwable th) {
        if (this.d) {
            sdk.pendo.io.g4.a.b(th);
        } else {
            this.d = true;
            this.a.onError(th);
        }
    }

    @Override // sdk.pendo.io.j3.c
    public void request(long j) {
        this.b.request(j);
    }

    protected final void a(Throwable th) {
        sdk.pendo.io.p3.b.b(th);
        this.b.cancel();
        onError(th);
    }

    @Override // sdk.pendo.io.k3.e, sdk.pendo.io.j3.b
    public final void a(sdk.pendo.io.j3.c cVar) {
        if (sdk.pendo.io.c4.c.a(this.b, cVar)) {
            this.b = cVar;
            if (cVar instanceof sdk.pendo.io.t3.d) {
                this.c = (sdk.pendo.io.t3.d) cVar;
            }
            if (b()) {
                this.a.a(this);
                a();
            }
        }
    }
}
