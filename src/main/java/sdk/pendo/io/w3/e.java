package sdk.pendo.io.w3;

/* JADX INFO: loaded from: classes5.dex */
public final class e<T> extends sdk.pendo.io.w3.a<T, T> {
    final sdk.pendo.io.q3.j<? super T> c;

    static final class a<T> extends sdk.pendo.io.b4.a<T, T> {
        final sdk.pendo.io.q3.j<? super T> f;

        a(sdk.pendo.io.t3.a<? super T> aVar, sdk.pendo.io.q3.j<? super T> jVar) {
            super(aVar);
            this.f = jVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // sdk.pendo.io.t3.a
        public boolean a(T t) {
            if (this.d) {
                return false;
            }
            if (this.e != 0) {
                return this.a.a((Object) null);
            }
            try {
                return this.f.test(t) && this.a.a((Object) t);
            } catch (Throwable th) {
                a(th);
                return true;
            }
        }

        @Override // sdk.pendo.io.j3.b
        public void onNext(T t) {
            if (a(t)) {
                return;
            }
            this.b.request(1L);
        }

        @Override // sdk.pendo.io.t3.g
        public T poll() {
            sdk.pendo.io.t3.d<T> dVar = this.c;
            sdk.pendo.io.q3.j<? super T> jVar = this.f;
            while (true) {
                T tPoll = dVar.poll();
                if (tPoll == null) {
                    return null;
                }
                if (jVar.test(tPoll)) {
                    return tPoll;
                }
                if (this.e == 2) {
                    dVar.request(1L);
                }
            }
        }
    }

    static final class b<T> extends sdk.pendo.io.b4.b<T, T> implements sdk.pendo.io.t3.a<T> {
        final sdk.pendo.io.q3.j<? super T> f;

        b(sdk.pendo.io.j3.b<? super T> bVar, sdk.pendo.io.q3.j<? super T> jVar) {
            super(bVar);
            this.f = jVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // sdk.pendo.io.t3.a
        public boolean a(T t) {
            if (this.d) {
                return false;
            }
            if (this.e != 0) {
                this.a.onNext(null);
                return true;
            }
            try {
                boolean zTest = this.f.test(t);
                if (zTest) {
                    this.a.onNext((Object) t);
                }
                return zTest;
            } catch (Throwable th) {
                a(th);
                return true;
            }
        }

        @Override // sdk.pendo.io.j3.b
        public void onNext(T t) {
            if (a(t)) {
                return;
            }
            this.b.request(1L);
        }

        @Override // sdk.pendo.io.t3.g
        public T poll() {
            sdk.pendo.io.t3.d<T> dVar = this.c;
            sdk.pendo.io.q3.j<? super T> jVar = this.f;
            while (true) {
                T tPoll = dVar.poll();
                if (tPoll == null) {
                    return null;
                }
                if (jVar.test(tPoll)) {
                    return tPoll;
                }
                if (this.e == 2) {
                    dVar.request(1L);
                }
            }
        }
    }

    public e(sdk.pendo.io.k3.d<T> dVar, sdk.pendo.io.q3.j<? super T> jVar) {
        super(dVar);
        this.c = jVar;
    }

    @Override // sdk.pendo.io.k3.d
    protected void b(sdk.pendo.io.j3.b<? super T> bVar) {
        sdk.pendo.io.k3.d<T> dVar;
        sdk.pendo.io.k3.e<? super T> bVar2;
        if (bVar instanceof sdk.pendo.io.t3.a) {
            dVar = this.b;
            bVar2 = new a<>((sdk.pendo.io.t3.a) bVar, this.c);
        } else {
            dVar = this.b;
            bVar2 = new b<>(bVar, this.c);
        }
        dVar.a((sdk.pendo.io.k3.e) bVar2);
    }
}
