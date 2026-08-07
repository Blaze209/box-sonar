package sdk.pendo.io.j4;

import sdk.pendo.io.d4.i;
import sdk.pendo.io.k3.o;

/* JADX INFO: loaded from: classes4.dex */
final class c<T> extends d<T> implements sdk.pendo.io.d4.a.InterfaceC0373a<Object> {
    final d<T> a;
    boolean b;
    sdk.pendo.io.d4.a<Object> c;
    volatile boolean d;

    c(d<T> dVar) {
        this.a = dVar;
    }

    @Override // sdk.pendo.io.k3.j
    protected void b(o<? super T> oVar) {
        this.a.a((o) oVar);
    }

    void m() {
        sdk.pendo.io.d4.a<Object> aVar;
        while (true) {
            synchronized (this) {
                aVar = this.c;
                if (aVar == null) {
                    this.b = false;
                    return;
                }
                this.c = null;
            }
            aVar.a((sdk.pendo.io.d4.a.InterfaceC0373a<? super Object>) this);
        }
    }

    @Override // sdk.pendo.io.k3.o
    public void onComplete() {
        if (this.d) {
            return;
        }
        synchronized (this) {
            if (!this.d) {
                this.d = true;
                if (!this.b) {
                    this.b = true;
                    this.a.onComplete();
                } else {
                    sdk.pendo.io.d4.a<Object> aVar = this.c;
                    if (aVar == null) {
                        aVar = new sdk.pendo.io.d4.a<>(4);
                        this.c = aVar;
                    }
                    aVar.a(i.a());
                }
            }
        }
    }

    @Override // sdk.pendo.io.k3.o
    public void onError(Throwable th) {
        if (this.d) {
            sdk.pendo.io.g4.a.b(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.d) {
                this.d = true;
                if (this.b) {
                    sdk.pendo.io.d4.a<Object> aVar = this.c;
                    if (aVar == null) {
                        aVar = new sdk.pendo.io.d4.a<>(4);
                        this.c = aVar;
                    }
                    aVar.b(i.a(th));
                    return;
                }
                this.b = true;
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
        if (this.d) {
            return;
        }
        synchronized (this) {
            if (!this.d) {
                if (!this.b) {
                    this.b = true;
                    this.a.onNext(t);
                    m();
                } else {
                    sdk.pendo.io.d4.a<Object> aVar = this.c;
                    if (aVar == null) {
                        aVar = new sdk.pendo.io.d4.a<>(4);
                        this.c = aVar;
                    }
                    aVar.a(i.d(t));
                }
            }
        }
    }

    @Override // sdk.pendo.io.k3.o
    public void onSubscribe(sdk.pendo.io.o3.b bVar) {
        boolean z = true;
        if (!this.d) {
            synchronized (this) {
                if (!this.d) {
                    if (this.b) {
                        sdk.pendo.io.d4.a<Object> aVar = this.c;
                        if (aVar == null) {
                            aVar = new sdk.pendo.io.d4.a<>(4);
                            this.c = aVar;
                        }
                        aVar.a(i.a(bVar));
                        return;
                    }
                    this.b = true;
                    z = false;
                }
            }
        }
        if (z) {
            bVar.dispose();
        } else {
            this.a.onSubscribe(bVar);
            m();
        }
    }

    @Override // sdk.pendo.io.d4.a.InterfaceC0373a, sdk.pendo.io.q3.j
    public boolean test(Object obj) {
        return i.b(obj, this.a);
    }
}
