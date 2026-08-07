package sdk.pendo.io.y3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class a0<T> extends sdk.pendo.io.k3.j<T> {
    final sdk.pendo.io.e4.a<T> a;
    final int b;
    final long c;
    final TimeUnit d;
    final sdk.pendo.io.k3.p e;
    a f;

    static final class a extends AtomicReference<sdk.pendo.io.o3.b> implements Runnable, sdk.pendo.io.q3.e<sdk.pendo.io.o3.b> {
        final a0<?> a;
        sdk.pendo.io.o3.b b;
        long c;
        boolean d;
        boolean e;

        a(a0<?> a0Var) {
            this.a = a0Var;
        }

        @Override // sdk.pendo.io.q3.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(sdk.pendo.io.o3.b bVar) {
            sdk.pendo.io.r3.b.a(this, bVar);
            synchronized (this.a) {
                if (this.e) {
                    ((sdk.pendo.io.r3.e) this.a.a).a(bVar);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.e(this);
        }
    }

    static final class b<T> extends AtomicBoolean implements sdk.pendo.io.k3.o<T>, sdk.pendo.io.o3.b {
        final sdk.pendo.io.k3.o<? super T> a;
        final a0<T> b;
        final a c;
        sdk.pendo.io.o3.b d;

        b(sdk.pendo.io.k3.o<? super T> oVar, a0<T> a0Var, a aVar) {
            this.a = oVar;
            this.b = a0Var;
            this.c = aVar;
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            this.d.dispose();
            if (compareAndSet(false, true)) {
                this.b.a(this.c);
            }
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return this.d.isDisposed();
        }

        @Override // sdk.pendo.io.k3.o
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.b.d(this.c);
                this.a.onComplete();
            }
        }

        @Override // sdk.pendo.io.k3.o
        public void onError(Throwable th) {
            if (!compareAndSet(false, true)) {
                sdk.pendo.io.g4.a.b(th);
            } else {
                this.b.d(this.c);
                this.a.onError(th);
            }
        }

        @Override // sdk.pendo.io.k3.o
        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // sdk.pendo.io.k3.o
        public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            if (sdk.pendo.io.r3.b.a(this.d, bVar)) {
                this.d = bVar;
                this.a.onSubscribe(this);
            }
        }
    }

    public a0(sdk.pendo.io.e4.a<T> aVar) {
        this(aVar, 1, 0L, TimeUnit.NANOSECONDS, null);
    }

    void a(a aVar) {
        synchronized (this) {
            a aVar2 = this.f;
            if (aVar2 != null && aVar2 == aVar) {
                long j = aVar.c - 1;
                aVar.c = j;
                if (j == 0 && aVar.d) {
                    if (this.c != 0) {
                        sdk.pendo.io.r3.f fVar = new sdk.pendo.io.r3.f();
                        aVar.b = fVar;
                        fVar.a(this.e.a(aVar, this.c, this.d));
                        return;
                    }
                    e(aVar);
                }
            }
        }
    }

    void b(a aVar) {
        sdk.pendo.io.o3.b bVar = aVar.b;
        if (bVar != null) {
            bVar.dispose();
            aVar.b = null;
        }
    }

    void c(a aVar) {
        sdk.pendo.io.e4.a<T> aVar2 = this.a;
        if (aVar2 instanceof sdk.pendo.io.o3.b) {
            ((sdk.pendo.io.o3.b) aVar2).dispose();
        } else if (aVar2 instanceof sdk.pendo.io.r3.e) {
            ((sdk.pendo.io.r3.e) aVar2).a(aVar.get());
        }
    }

    void d(a aVar) {
        synchronized (this) {
            if (this.a instanceof z) {
                a aVar2 = this.f;
                if (aVar2 != null && aVar2 == aVar) {
                    this.f = null;
                    b(aVar);
                }
                long j = aVar.c - 1;
                aVar.c = j;
                if (j == 0) {
                    c(aVar);
                }
            } else {
                a aVar3 = this.f;
                if (aVar3 != null && aVar3 == aVar) {
                    b(aVar);
                    long j2 = aVar.c - 1;
                    aVar.c = j2;
                    if (j2 == 0) {
                        this.f = null;
                        c(aVar);
                    }
                }
            }
        }
    }

    void e(a aVar) {
        synchronized (this) {
            if (aVar.c == 0 && aVar == this.f) {
                this.f = null;
                sdk.pendo.io.o3.b bVar = aVar.get();
                sdk.pendo.io.r3.b.a(aVar);
                sdk.pendo.io.e4.a<T> aVar2 = this.a;
                if (aVar2 instanceof sdk.pendo.io.o3.b) {
                    ((sdk.pendo.io.o3.b) aVar2).dispose();
                } else if (aVar2 instanceof sdk.pendo.io.r3.e) {
                    if (bVar == null) {
                        aVar.e = true;
                    } else {
                        ((sdk.pendo.io.r3.e) aVar2).a(bVar);
                    }
                }
            }
        }
    }

    public a0(sdk.pendo.io.e4.a<T> aVar, int i, long j, TimeUnit timeUnit, sdk.pendo.io.k3.p pVar) {
        this.a = aVar;
        this.b = i;
        this.c = j;
        this.d = timeUnit;
        this.e = pVar;
    }

    @Override // sdk.pendo.io.k3.j
    protected void b(sdk.pendo.io.k3.o<? super T> oVar) {
        a aVar;
        boolean z;
        sdk.pendo.io.o3.b bVar;
        synchronized (this) {
            aVar = this.f;
            if (aVar == null) {
                aVar = new a(this);
                this.f = aVar;
            }
            long j = aVar.c;
            if (j == 0 && (bVar = aVar.b) != null) {
                bVar.dispose();
            }
            long j2 = j + 1;
            aVar.c = j2;
            if (aVar.d || j2 != this.b) {
                z = false;
            } else {
                z = true;
                aVar.d = true;
            }
        }
        this.a.a((sdk.pendo.io.k3.o) new b(oVar, this, aVar));
        if (z) {
            this.a.c(aVar);
        }
    }
}
