package sdk.pendo.io.f4;

import sdk.pendo.io.d4.i;
import sdk.pendo.io.k3.o;

/* JADX INFO: loaded from: classes4.dex */
public final class b<T> implements o<T>, sdk.pendo.io.o3.b {
    final o<? super T> a;
    final boolean b;
    sdk.pendo.io.o3.b c;
    boolean d;
    sdk.pendo.io.d4.a<Object> e;
    volatile boolean f;

    public b(o<? super T> oVar) {
        this(oVar, false);
    }

    void a() {
        sdk.pendo.io.d4.a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.e;
                if (aVar == null) {
                    this.d = false;
                    return;
                }
                this.e = null;
            }
        } while (!aVar.a((o) this.a));
    }

    @Override // sdk.pendo.io.o3.b
    public void dispose() {
        this.c.dispose();
    }

    @Override // sdk.pendo.io.o3.b
    public boolean isDisposed() {
        return this.c.isDisposed();
    }

    @Override // sdk.pendo.io.k3.o
    public void onComplete() {
        if (this.f) {
            return;
        }
        synchronized (this) {
            if (!this.f) {
                if (!this.d) {
                    this.f = true;
                    this.d = true;
                    this.a.onComplete();
                } else {
                    sdk.pendo.io.d4.a<Object> aVar = this.e;
                    if (aVar == null) {
                        aVar = new sdk.pendo.io.d4.a<>(4);
                        this.e = aVar;
                    }
                    aVar.a(i.a());
                }
            }
        }
    }

    @Override // sdk.pendo.io.k3.o
    public void onError(Throwable th) {
        if (this.f) {
            sdk.pendo.io.g4.a.b(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f) {
                if (this.d) {
                    this.f = true;
                    sdk.pendo.io.d4.a<Object> aVar = this.e;
                    if (aVar == null) {
                        aVar = new sdk.pendo.io.d4.a<>(4);
                        this.e = aVar;
                    }
                    Object objA = i.a(th);
                    if (this.b) {
                        aVar.a(objA);
                    } else {
                        aVar.b(objA);
                    }
                    return;
                }
                this.f = true;
                this.d = true;
                z = false;
            }
            if (z) {
                sdk.pendo.io.g4.a.b(th);
            } else {
                this.a.onError(th);
            }
        }
    }

    @Override // sdk.pendo.io.k3.o
    public void onNext(T t) {
        if (this.f) {
            return;
        }
        if (t == null) {
            this.c.dispose();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (!this.f) {
                if (!this.d) {
                    this.d = true;
                    this.a.onNext(t);
                    a();
                } else {
                    sdk.pendo.io.d4.a<Object> aVar = this.e;
                    if (aVar == null) {
                        aVar = new sdk.pendo.io.d4.a<>(4);
                        this.e = aVar;
                    }
                    aVar.a(i.d(t));
                }
            }
        }
    }

    @Override // sdk.pendo.io.k3.o
    public void onSubscribe(sdk.pendo.io.o3.b bVar) {
        if (sdk.pendo.io.r3.b.a(this.c, bVar)) {
            this.c = bVar;
            this.a.onSubscribe(this);
        }
    }

    public b(o<? super T> oVar, boolean z) {
        this.a = oVar;
        this.b = z;
    }
}
