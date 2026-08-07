package sdk.pendo.io.w3;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class l<T> extends sdk.pendo.io.w3.a<T, T> {

    static final class a<T> extends AtomicInteger implements sdk.pendo.io.k3.e<T>, sdk.pendo.io.j3.c {
        final sdk.pendo.io.j3.b<? super T> a;
        sdk.pendo.io.j3.c b;
        volatile boolean c;
        Throwable d;
        volatile boolean e;
        final AtomicLong f = new AtomicLong();
        final AtomicReference<T> g = new AtomicReference<>();

        a(sdk.pendo.io.j3.b<? super T> bVar) {
            this.a = bVar;
        }

        boolean a(boolean z, boolean z2, sdk.pendo.io.j3.b<?> bVar, AtomicReference<T> atomicReference) {
            if (this.e) {
                atomicReference.lazySet(null);
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.d;
            if (th != null) {
                atomicReference.lazySet(null);
                bVar.onError(th);
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
            if (this.e) {
                return;
            }
            this.e = true;
            this.b.cancel();
            if (getAndIncrement() == 0) {
                this.g.lazySet(null);
            }
        }

        @Override // sdk.pendo.io.j3.b
        public void onComplete() {
            this.c = true;
            a();
        }

        @Override // sdk.pendo.io.j3.b
        public void onError(Throwable th) {
            this.d = th;
            this.c = true;
            a();
        }

        @Override // sdk.pendo.io.j3.b
        public void onNext(T t) {
            this.g.lazySet(t);
            a();
        }

        @Override // sdk.pendo.io.j3.c
        public void request(long j) {
            if (sdk.pendo.io.c4.c.b(j)) {
                sdk.pendo.io.d4.d.a(this.f, j);
                a();
            }
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            sdk.pendo.io.j3.b<? super T> bVar = this.a;
            AtomicLong atomicLong = this.f;
            AtomicReference<T> atomicReference = this.g;
            int iAddAndGet = 1;
            do {
                long j = 0;
                while (true) {
                    if (j == atomicLong.get()) {
                        break;
                    }
                    boolean z = this.c;
                    T andSet = atomicReference.getAndSet(null);
                    boolean z2 = andSet == null;
                    if (a(z, z2, bVar, atomicReference)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    bVar.onNext(andSet);
                    j++;
                }
                if (j == atomicLong.get()) {
                    if (a(this.c, atomicReference.get() == null, bVar, atomicReference)) {
                        return;
                    }
                }
                if (j != 0) {
                    sdk.pendo.io.d4.d.c(atomicLong, j);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // sdk.pendo.io.k3.e, sdk.pendo.io.j3.b
        public void a(sdk.pendo.io.j3.c cVar) {
            if (sdk.pendo.io.c4.c.a(this.b, cVar)) {
                this.b = cVar;
                this.a.a(this);
                cVar.request(Long.MAX_VALUE);
            }
        }
    }

    public l(sdk.pendo.io.k3.d<T> dVar) {
        super(dVar);
    }

    @Override // sdk.pendo.io.k3.d
    protected void b(sdk.pendo.io.j3.b<? super T> bVar) {
        this.b.a((sdk.pendo.io.k3.e) new a(bVar));
    }
}
