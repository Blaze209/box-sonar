package sdk.pendo.io.w3;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public final class i<T> extends sdk.pendo.io.w3.a<T, T> {
    final int c;
    final boolean d;
    final boolean e;
    final sdk.pendo.io.q3.a f;

    static final class a<T> extends sdk.pendo.io.c4.a<T> implements sdk.pendo.io.k3.e<T> {
        final sdk.pendo.io.j3.b<? super T> a;
        final sdk.pendo.io.t3.f<T> b;
        final boolean c;
        final sdk.pendo.io.q3.a d;
        sdk.pendo.io.j3.c e;
        volatile boolean f;
        volatile boolean g;
        Throwable h;
        final AtomicLong i = new AtomicLong();
        boolean j;

        a(sdk.pendo.io.j3.b<? super T> bVar, int i, boolean z, boolean z2, sdk.pendo.io.q3.a aVar) {
            this.a = bVar;
            this.d = aVar;
            this.c = z2;
            this.b = z ? new sdk.pendo.io.z3.c<>(i) : new sdk.pendo.io.z3.b<>(i);
        }

        boolean a(boolean z, boolean z2, sdk.pendo.io.j3.b<? super T> bVar) {
            if (this.f) {
                this.b.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (this.c) {
                if (!z2) {
                    return false;
                }
                Throwable th = this.h;
                if (th != null) {
                    bVar.onError(th);
                } else {
                    bVar.onComplete();
                }
                return true;
            }
            Throwable th2 = this.h;
            if (th2 != null) {
                this.b.clear();
                bVar.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            bVar.onComplete();
            return true;
        }

        @Override // sdk.pendo.io.j3.c
        public void cancel() {
            if (this.f) {
                return;
            }
            this.f = true;
            this.e.cancel();
            if (this.j || getAndIncrement() != 0) {
                return;
            }
            this.b.clear();
        }

        @Override // sdk.pendo.io.t3.g
        public void clear() {
            this.b.clear();
        }

        @Override // sdk.pendo.io.t3.g
        public boolean isEmpty() {
            return this.b.isEmpty();
        }

        @Override // sdk.pendo.io.j3.b
        public void onComplete() {
            this.g = true;
            if (this.j) {
                this.a.onComplete();
            } else {
                a();
            }
        }

        @Override // sdk.pendo.io.j3.b
        public void onError(Throwable th) {
            this.h = th;
            this.g = true;
            if (this.j) {
                this.a.onError(th);
            } else {
                a();
            }
        }

        @Override // sdk.pendo.io.j3.b
        public void onNext(T t) {
            if (this.b.offer(t)) {
                if (this.j) {
                    this.a.onNext(null);
                    return;
                } else {
                    a();
                    return;
                }
            }
            this.e.cancel();
            sdk.pendo.io.p3.c cVar = new sdk.pendo.io.p3.c("Buffer is full");
            try {
                this.d.run();
            } catch (Throwable th) {
                sdk.pendo.io.p3.b.b(th);
                cVar.initCause(th);
            }
            onError(cVar);
        }

        @Override // sdk.pendo.io.t3.g
        public T poll() {
            return this.b.poll();
        }

        @Override // sdk.pendo.io.j3.c
        public void request(long j) {
            if (this.j || !sdk.pendo.io.c4.c.b(j)) {
                return;
            }
            sdk.pendo.io.d4.d.a(this.i, j);
            a();
        }

        void a() {
            if (getAndIncrement() == 0) {
                sdk.pendo.io.t3.f<T> fVar = this.b;
                sdk.pendo.io.j3.b<? super T> bVar = this.a;
                int iAddAndGet = 1;
                while (!a(this.g, fVar.isEmpty(), bVar)) {
                    long j = this.i.get();
                    long j2 = 0;
                    while (j2 != j) {
                        boolean z = this.g;
                        T tPoll = fVar.poll();
                        boolean z2 = tPoll == null;
                        if (a(z, z2, bVar)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        bVar.onNext(tPoll);
                        j2++;
                    }
                    if (j2 == j && a(this.g, fVar.isEmpty(), bVar)) {
                        return;
                    }
                    if (j2 != 0 && j != Long.MAX_VALUE) {
                        this.i.addAndGet(-j2);
                    }
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        @Override // sdk.pendo.io.k3.e, sdk.pendo.io.j3.b
        public void a(sdk.pendo.io.j3.c cVar) {
            if (sdk.pendo.io.c4.c.a(this.e, cVar)) {
                this.e = cVar;
                this.a.a(this);
                cVar.request(Long.MAX_VALUE);
            }
        }
    }

    public i(sdk.pendo.io.k3.d<T> dVar, int i, boolean z, boolean z2, sdk.pendo.io.q3.a aVar) {
        super(dVar);
        this.c = i;
        this.d = z;
        this.e = z2;
        this.f = aVar;
    }

    @Override // sdk.pendo.io.k3.d
    protected void b(sdk.pendo.io.j3.b<? super T> bVar) {
        this.b.a((sdk.pendo.io.k3.e) new a(bVar, this.c, this.d, this.e, this.f));
    }
}
