package sdk.pendo.io.y3;

/* JADX INFO: loaded from: classes6.dex */
public final class u<T, U> extends sdk.pendo.io.y3.a<T, U> {
    final sdk.pendo.io.q3.h<? super T, ? extends U> b;

    static final class a<T, U> extends sdk.pendo.io.u3.a<T, U> {
        final sdk.pendo.io.q3.h<? super T, ? extends U> f;

        a(sdk.pendo.io.k3.o<? super U> oVar, sdk.pendo.io.q3.h<? super T, ? extends U> hVar) {
            super(oVar);
            this.f = hVar;
        }

        @Override // sdk.pendo.io.t3.c
        public int a(int i) {
            return b(i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [sdk.pendo.io.k3.o] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5 */
        @Override // sdk.pendo.io.k3.o
        public void onNext(T t) {
            Object objA;
            ?? r1;
            if (this.d) {
                return;
            }
            if (this.e != 0) {
                objA = null;
                r1 = this.a;
            } else {
                try {
                    objA = sdk.pendo.io.s3.b.a(this.f.apply(t), "The mapper function returned a null value.");
                    r1 = this.a;
                } catch (Throwable th) {
                    a(th);
                    return;
                }
            }
            r1.onNext(objA);
        }

        @Override // sdk.pendo.io.t3.g
        public U poll() {
            T tPoll = this.c.poll();
            if (tPoll != null) {
                return (U) sdk.pendo.io.s3.b.a(this.f.apply(tPoll), "The mapper function returned a null value.");
            }
            return null;
        }
    }

    public u(sdk.pendo.io.k3.m<T> mVar, sdk.pendo.io.q3.h<? super T, ? extends U> hVar) {
        super(mVar);
        this.b = hVar;
    }

    @Override // sdk.pendo.io.k3.j
    public void b(sdk.pendo.io.k3.o<? super U> oVar) {
        this.a.a(new a(oVar, this.b));
    }
}
