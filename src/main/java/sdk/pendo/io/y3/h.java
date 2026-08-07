package sdk.pendo.io.y3;

/* JADX INFO: loaded from: classes6.dex */
public final class h<T, K> extends sdk.pendo.io.y3.a<T, T> {
    final sdk.pendo.io.q3.h<? super T, K> b;
    final sdk.pendo.io.q3.c<? super K, ? super K> c;

    static final class a<T, K> extends sdk.pendo.io.u3.a<T, T> {
        final sdk.pendo.io.q3.h<? super T, K> f;
        final sdk.pendo.io.q3.c<? super K, ? super K> g;
        K h;
        boolean i;

        a(sdk.pendo.io.k3.o<? super T> oVar, sdk.pendo.io.q3.h<? super T, K> hVar, sdk.pendo.io.q3.c<? super K, ? super K> cVar) {
            super(oVar);
            this.f = hVar;
            this.g = cVar;
        }

        @Override // sdk.pendo.io.t3.c
        public int a(int i) {
            return b(i);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // sdk.pendo.io.k3.o
        public void onNext(T t) {
            if (this.d) {
                return;
            }
            if (this.e == 0) {
                try {
                    K kApply = this.f.apply(t);
                    if (this.i) {
                        boolean zA = this.g.a(this.h, kApply);
                        this.h = kApply;
                        if (zA) {
                            return;
                        }
                    } else {
                        this.i = true;
                        this.h = kApply;
                    }
                } catch (Throwable th) {
                    a(th);
                    return;
                }
            }
            this.a.onNext((Object) t);
        }

        @Override // sdk.pendo.io.t3.g
        public T poll() {
            T tPoll;
            boolean zA;
            do {
                tPoll = this.c.poll();
                if (tPoll == null) {
                    return null;
                }
                K kApply = this.f.apply(tPoll);
                if (!this.i) {
                    this.i = true;
                    this.h = kApply;
                    return tPoll;
                }
                zA = this.g.a(this.h, kApply);
                this.h = kApply;
            } while (zA);
            return tPoll;
        }
    }

    public h(sdk.pendo.io.k3.m<T> mVar, sdk.pendo.io.q3.h<? super T, K> hVar, sdk.pendo.io.q3.c<? super K, ? super K> cVar) {
        super(mVar);
        this.b = hVar;
        this.c = cVar;
    }

    @Override // sdk.pendo.io.k3.j
    protected void b(sdk.pendo.io.k3.o<? super T> oVar) {
        this.a.a(new a(oVar, this.b, this.c));
    }
}
