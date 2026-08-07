package sdk.pendo.io.y3;

/* JADX INFO: loaded from: classes6.dex */
public final class v<T> extends sdk.pendo.io.y3.a<T, T> {
    final sdk.pendo.io.k3.p b;
    final boolean c;
    final int d;

    static final class a<T> extends sdk.pendo.io.u3.b<T> implements sdk.pendo.io.k3.o<T>, Runnable {
        final sdk.pendo.io.k3.o<? super T> a;
        final sdk.pendo.io.k3.p.c b;
        final boolean c;
        final int d;
        sdk.pendo.io.t3.g<T> e;
        sdk.pendo.io.o3.b f;
        Throwable g;
        volatile boolean h;
        volatile boolean i;
        int j;
        boolean k;

        a(sdk.pendo.io.k3.o<? super T> oVar, sdk.pendo.io.k3.p.c cVar, boolean z, int i) {
            this.a = oVar;
            this.b = cVar;
            this.c = z;
            this.d = i;
        }

        boolean a(boolean z, boolean z2, sdk.pendo.io.k3.o<? super T> oVar) {
            if (this.i) {
                this.e.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.g;
            if (this.c) {
                if (!z2) {
                    return false;
                }
                this.i = true;
                if (th != null) {
                    oVar.onError(th);
                } else {
                    oVar.onComplete();
                }
                this.b.dispose();
                return true;
            }
            if (th != null) {
                this.i = true;
                this.e.clear();
                oVar.onError(th);
                this.b.dispose();
                return true;
            }
            if (!z2) {
                return false;
            }
            this.i = true;
            oVar.onComplete();
            this.b.dispose();
            return true;
        }

        void b() {
            sdk.pendo.io.t3.g<T> gVar = this.e;
            sdk.pendo.io.k3.o<? super T> oVar = this.a;
            int iAddAndGet = 1;
            while (!a(this.h, gVar.isEmpty(), oVar)) {
                while (true) {
                    boolean z = this.h;
                    try {
                        T tPoll = gVar.poll();
                        boolean z2 = tPoll == null;
                        if (a(z, z2, oVar)) {
                            return;
                        }
                        if (z2) {
                            break;
                        } else {
                            oVar.onNext(tPoll);
                        }
                    } catch (Throwable th) {
                        sdk.pendo.io.p3.b.b(th);
                        this.i = true;
                        this.f.dispose();
                        gVar.clear();
                        oVar.onError(th);
                        this.b.dispose();
                        return;
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        void c() {
            if (getAndIncrement() == 0) {
                this.b.a(this);
            }
        }

        @Override // sdk.pendo.io.t3.g
        public void clear() {
            this.e.clear();
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            if (this.i) {
                return;
            }
            this.i = true;
            this.f.dispose();
            this.b.dispose();
            if (this.k || getAndIncrement() != 0) {
                return;
            }
            this.e.clear();
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return this.i;
        }

        @Override // sdk.pendo.io.t3.g
        public boolean isEmpty() {
            return this.e.isEmpty();
        }

        @Override // sdk.pendo.io.k3.o
        public void onComplete() {
            if (this.h) {
                return;
            }
            this.h = true;
            c();
        }

        @Override // sdk.pendo.io.k3.o
        public void onError(Throwable th) {
            if (this.h) {
                sdk.pendo.io.g4.a.b(th);
                return;
            }
            this.g = th;
            this.h = true;
            c();
        }

        @Override // sdk.pendo.io.k3.o
        public void onNext(T t) {
            if (this.h) {
                return;
            }
            if (this.j != 2) {
                this.e.offer(t);
            }
            c();
        }

        @Override // sdk.pendo.io.k3.o
        public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            if (sdk.pendo.io.r3.b.a(this.f, bVar)) {
                this.f = bVar;
                if (bVar instanceof sdk.pendo.io.t3.b) {
                    sdk.pendo.io.t3.b bVar2 = (sdk.pendo.io.t3.b) bVar;
                    int iA = bVar2.a(7);
                    if (iA == 1) {
                        this.j = iA;
                        this.e = bVar2;
                        this.h = true;
                        this.a.onSubscribe(this);
                        c();
                        return;
                    }
                    if (iA == 2) {
                        this.j = iA;
                        this.e = bVar2;
                        this.a.onSubscribe(this);
                        return;
                    }
                }
                this.e = new sdk.pendo.io.z3.c(this.d);
                this.a.onSubscribe(this);
            }
        }

        @Override // sdk.pendo.io.t3.g
        public T poll() {
            return this.e.poll();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.k) {
                a();
            } else {
                b();
            }
        }

        void a() {
            int iAddAndGet = 1;
            while (!this.i) {
                boolean z = this.h;
                Throwable th = this.g;
                if (this.c || !z || th == null) {
                    this.a.onNext(null);
                    if (z) {
                        this.i = true;
                        Throwable th2 = this.g;
                        if (th2 != null) {
                            this.a.onError(th2);
                        } else {
                            this.a.onComplete();
                        }
                    } else {
                        iAddAndGet = addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    }
                } else {
                    this.i = true;
                    this.a.onError(this.g);
                }
                this.b.dispose();
                return;
            }
        }

        @Override // sdk.pendo.io.t3.c
        public int a(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.k = true;
            return 2;
        }
    }

    public v(sdk.pendo.io.k3.m<T> mVar, sdk.pendo.io.k3.p pVar, boolean z, int i) {
        super(mVar);
        this.b = pVar;
        this.c = z;
        this.d = i;
    }

    @Override // sdk.pendo.io.k3.j
    protected void b(sdk.pendo.io.k3.o<? super T> oVar) {
        sdk.pendo.io.k3.p pVar = this.b;
        if (pVar instanceof sdk.pendo.io.a4.n) {
            this.a.a(oVar);
        } else {
            this.a.a(new a(oVar, pVar.a(), this.c, this.d));
        }
    }
}
