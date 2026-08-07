package sdk.pendo.io.y3;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class x<T> extends sdk.pendo.io.e4.a<T> implements z<T> {
    final sdk.pendo.io.k3.m<T> a;
    final AtomicReference<b<T>> b;
    final sdk.pendo.io.k3.m<T> c;

    static final class a<T> extends AtomicReference<Object> implements sdk.pendo.io.o3.b {
        final sdk.pendo.io.k3.o<? super T> a;

        a(sdk.pendo.io.k3.o<? super T> oVar) {
            this.a = oVar;
        }

        void a(b<T> bVar) {
            if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this, null, bVar)) {
                return;
            }
            bVar.b(this);
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            Object andSet = getAndSet(this);
            if (andSet == null || andSet == this) {
                return;
            }
            ((b) andSet).b(this);
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return get() == this;
        }
    }

    static final class b<T> implements sdk.pendo.io.k3.o<T>, sdk.pendo.io.o3.b {
        static final a[] e = new a[0];
        static final a[] f = new a[0];
        final AtomicReference<b<T>> a;
        final AtomicReference<sdk.pendo.io.o3.b> d = new AtomicReference<>();
        final AtomicReference<a<T>[]> b = new AtomicReference<>(e);
        final AtomicBoolean c = new AtomicBoolean();

        b(AtomicReference<b<T>> atomicReference) {
            this.a = atomicReference;
        }

        boolean a(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = this.b.get();
                if (aVarArr == f) {
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.b, aVarArr, aVarArr2));
            return true;
        }

        void b(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = this.b.get();
                int length = aVarArr.length;
                if (length == 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (aVarArr[i].equals(aVar)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    aVarArr2 = e;
                } else {
                    a[] aVarArr3 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr3, 0, i);
                    System.arraycopy(aVarArr, i + 1, aVarArr3, i, (length - i) - 1);
                    aVarArr2 = aVarArr3;
                }
            } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.b, aVarArr, aVarArr2));
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            AtomicReference<a<T>[]> atomicReference = this.b;
            a<T>[] aVarArr = f;
            if (atomicReference.getAndSet(aVarArr) != aVarArr) {
                PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.a, this, null);
                sdk.pendo.io.r3.b.a(this.d);
            }
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return this.b.get() == f;
        }

        @Override // sdk.pendo.io.k3.o
        public void onComplete() {
            PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.a, this, null);
            for (a<T> aVar : this.b.getAndSet(f)) {
                aVar.a.onComplete();
            }
        }

        @Override // sdk.pendo.io.k3.o
        public void onError(Throwable th) {
            PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.a, this, null);
            a<T>[] andSet = this.b.getAndSet(f);
            if (andSet.length == 0) {
                sdk.pendo.io.g4.a.b(th);
                return;
            }
            for (a<T> aVar : andSet) {
                aVar.a.onError(th);
            }
        }

        @Override // sdk.pendo.io.k3.o
        public void onNext(T t) {
            for (a<T> aVar : this.b.get()) {
                aVar.a.onNext(t);
            }
        }

        @Override // sdk.pendo.io.k3.o
        public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            sdk.pendo.io.r3.b.c(this.d, bVar);
        }
    }

    static final class c<T> implements sdk.pendo.io.k3.m<T> {
        private final AtomicReference<b<T>> a;

        c(AtomicReference<b<T>> atomicReference) {
            this.a = atomicReference;
        }

        @Override // sdk.pendo.io.k3.m
        public void a(sdk.pendo.io.k3.o<? super T> oVar) {
            a aVar = new a(oVar);
            oVar.onSubscribe(aVar);
            while (true) {
                b<T> bVar = this.a.get();
                if (bVar == null || bVar.isDisposed()) {
                    b<T> bVar2 = new b<>(this.a);
                    if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.a, bVar, bVar2)) {
                        bVar = bVar2;
                    } else {
                        continue;
                    }
                }
                if (bVar.a(aVar)) {
                    aVar.a(bVar);
                    return;
                }
            }
        }
    }

    private x(sdk.pendo.io.k3.m<T> mVar, sdk.pendo.io.k3.m<T> mVar2, AtomicReference<b<T>> atomicReference) {
        this.c = mVar;
        this.a = mVar2;
        this.b = atomicReference;
    }

    public static <T> sdk.pendo.io.e4.a<T> f(sdk.pendo.io.k3.m<T> mVar) {
        AtomicReference atomicReference = new AtomicReference();
        return sdk.pendo.io.g4.a.a((sdk.pendo.io.e4.a) new x(new c(atomicReference), mVar, atomicReference));
    }

    @Override // sdk.pendo.io.y3.z
    public sdk.pendo.io.k3.m<T> a() {
        return this.a;
    }

    @Override // sdk.pendo.io.k3.j
    protected void b(sdk.pendo.io.k3.o<? super T> oVar) {
        this.c.a(oVar);
    }

    @Override // sdk.pendo.io.e4.a
    public void c(sdk.pendo.io.q3.e<? super sdk.pendo.io.o3.b> eVar) {
        b<T> bVar;
        while (true) {
            bVar = this.b.get();
            if (bVar != null && !bVar.isDisposed()) {
                break;
            }
            b<T> bVar2 = new b<>(this.b);
            if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.b, bVar, bVar2)) {
                bVar = bVar2;
                break;
            }
        }
        boolean z = false;
        if (!bVar.c.get() && bVar.c.compareAndSet(false, true)) {
            z = true;
        }
        try {
            eVar.accept(bVar);
            if (z) {
                this.a.a(bVar);
            }
        } catch (Throwable th) {
            sdk.pendo.io.p3.b.b(th);
            throw sdk.pendo.io.d4.g.a(th);
        }
    }
}
