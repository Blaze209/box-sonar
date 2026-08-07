package sdk.pendo.io.y3;

import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public final class p<T> extends sdk.pendo.io.k3.j<T> {
    final Iterable<? extends T> a;

    static final class a<T> extends sdk.pendo.io.u3.c<T> {
        final sdk.pendo.io.k3.o<? super T> a;
        final Iterator<? extends T> b;
        volatile boolean c;
        boolean d;
        boolean e;
        boolean f;

        a(sdk.pendo.io.k3.o<? super T> oVar, Iterator<? extends T> it) {
            this.a = oVar;
            this.b = it;
        }

        @Override // sdk.pendo.io.t3.c
        public int a(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            this.d = true;
            return 1;
        }

        @Override // sdk.pendo.io.t3.g
        public void clear() {
            this.e = true;
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            this.c = true;
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return this.c;
        }

        @Override // sdk.pendo.io.t3.g
        public boolean isEmpty() {
            return this.e;
        }

        @Override // sdk.pendo.io.t3.g
        public T poll() {
            if (this.e) {
                return null;
            }
            if (!this.f) {
                this.f = true;
            } else if (!this.b.hasNext()) {
                this.e = true;
                return null;
            }
            return (T) sdk.pendo.io.s3.b.a((Object) this.b.next(), "The iterator returned a null value");
        }

        void a() {
            while (!isDisposed()) {
                try {
                    this.a.onNext(sdk.pendo.io.s3.b.a((Object) this.b.next(), "The iterator returned a null value"));
                    if (isDisposed()) {
                        return;
                    }
                    try {
                        if (!this.b.hasNext()) {
                            if (isDisposed()) {
                                return;
                            }
                            this.a.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        sdk.pendo.io.p3.b.b(th);
                        this.a.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    sdk.pendo.io.p3.b.b(th2);
                    this.a.onError(th2);
                    return;
                }
            }
        }
    }

    public p(Iterable<? extends T> iterable) {
        this.a = iterable;
    }

    @Override // sdk.pendo.io.k3.j
    public void b(sdk.pendo.io.k3.o<? super T> oVar) {
        try {
            Iterator<? extends T> it = this.a.iterator();
            if (!it.hasNext()) {
                sdk.pendo.io.r3.c.a(oVar);
                return;
            }
            a aVar = new a(oVar, it);
            oVar.onSubscribe(aVar);
            if (aVar.d) {
                return;
            }
            aVar.a();
        } catch (Throwable th) {
            sdk.pendo.io.p3.b.b(th);
            sdk.pendo.io.r3.c.a(th, oVar);
        }
    }
}
