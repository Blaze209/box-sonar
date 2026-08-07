package sdk.pendo.io.y3;

/* JADX INFO: loaded from: classes6.dex */
public final class m<T> extends sdk.pendo.io.y3.a<T, T> {
    final sdk.pendo.io.q3.j<? super T> b;

    static final class a<T> extends sdk.pendo.io.u3.a<T, T> {
        final sdk.pendo.io.q3.j<? super T> f;

        a(sdk.pendo.io.k3.o<? super T> oVar, sdk.pendo.io.q3.j<? super T> jVar) {
            super(oVar);
            this.f = jVar;
        }

        @Override // sdk.pendo.io.t3.c
        public int a(int i) {
            return b(i);
        }

        @Override // sdk.pendo.io.k3.o
        public void onNext(T t) {
            sdk.pendo.io.k3.o oVar;
            if (this.e == 0) {
                try {
                    if (!this.f.test(t)) {
                        return;
                    } else {
                        oVar = this.a;
                    }
                } catch (Throwable th) {
                    a(th);
                    return;
                }
            } else {
                oVar = this.a;
                t = null;
            }
            oVar.onNext(t);
        }

        @Override // sdk.pendo.io.t3.g
        public T poll() {
            T tPoll;
            do {
                tPoll = this.c.poll();
                if (tPoll == null) {
                    break;
                }
            } while (!this.f.test(tPoll));
            return tPoll;
        }
    }

    public m(sdk.pendo.io.k3.m<T> mVar, sdk.pendo.io.q3.j<? super T> jVar) {
        super(mVar);
        this.b = jVar;
    }

    @Override // sdk.pendo.io.k3.j
    public void b(sdk.pendo.io.k3.o<? super T> oVar) {
        this.a.a(new a(oVar, this.b));
    }
}
