package sdk.pendo.io.k4;

import sdk.pendo.io.d4.i;
import sdk.pendo.io.j3.b;
import sdk.pendo.io.j3.c;
import sdk.pendo.io.k3.e;

/* JADX INFO: loaded from: classes4.dex */
public final class a<T> implements e<T>, c {
    final b<? super T> a;
    final boolean b;
    c c;
    boolean d;
    sdk.pendo.io.d4.a<Object> e;
    volatile boolean f;

    public a(b<? super T> bVar) {
        this(bVar, false);
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
        } while (!aVar.a((b) this.a));
    }

    @Override // sdk.pendo.io.j3.c
    public void cancel() {
        this.c.cancel();
    }

    @Override // sdk.pendo.io.j3.b
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

    @Override // sdk.pendo.io.j3.b
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

    @Override // sdk.pendo.io.j3.b
    public void onNext(T t) {
        if (this.f) {
            return;
        }
        if (t == null) {
            this.c.cancel();
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

    @Override // sdk.pendo.io.j3.c
    public void request(long j) {
        this.c.request(j);
    }

    public a(b<? super T> bVar, boolean z) {
        this.a = bVar;
        this.b = z;
    }

    @Override // sdk.pendo.io.k3.e, sdk.pendo.io.j3.b
    public void a(c cVar) {
        if (sdk.pendo.io.c4.c.a(this.c, cVar)) {
            this.c = cVar;
            this.a.a(this);
        }
    }
}
