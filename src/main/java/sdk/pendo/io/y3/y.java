package sdk.pendo.io.y3;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class y<T> extends sdk.pendo.io.e4.a<T> implements sdk.pendo.io.r3.e {
    final sdk.pendo.io.k3.m<T> a;
    final AtomicReference<b<T>> b = new AtomicReference<>();

    static final class a<T> extends AtomicReference<b<T>> implements sdk.pendo.io.o3.b {
        final sdk.pendo.io.k3.o<? super T> a;

        a(sdk.pendo.io.k3.o<? super T> oVar, b<T> bVar) {
            this.a = oVar;
            lazySet(bVar);
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            b<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.b(this);
            }
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return get() == null;
        }
    }

    static final class b<T> extends AtomicReference<a<T>[]> implements sdk.pendo.io.k3.o<T>, sdk.pendo.io.o3.b {
        static final a[] e = new a[0];
        static final a[] f = new a[0];
        final AtomicReference<b<T>> b;
        Throwable d;
        final AtomicBoolean a = new AtomicBoolean();
        final AtomicReference<sdk.pendo.io.o3.b> c = new AtomicReference<>();

        b(AtomicReference<b<T>> atomicReference) {
            this.b = atomicReference;
            lazySet(e);
        }

        public boolean a(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = get();
                if (aVarArr == f) {
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this, aVarArr, aVarArr2));
            return true;
        }

        public void b(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = get();
                int length = aVarArr.length;
                if (length == 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (aVarArr[i] == aVar) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                aVarArr2 = e;
                if (length != 1) {
                    aVarArr2 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr2, 0, i);
                    System.arraycopy(aVarArr, i + 1, aVarArr2, i, (length - i) - 1);
                }
            } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this, aVarArr, aVarArr2));
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            getAndSet(f);
            PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.b, this, null);
            sdk.pendo.io.r3.b.a(this.c);
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return get() == f;
        }

        @Override // sdk.pendo.io.k3.o
        public void onComplete() {
            this.c.lazySet(sdk.pendo.io.r3.b.DISPOSED);
            for (a<T> aVar : getAndSet(f)) {
                aVar.a.onComplete();
            }
        }

        @Override // sdk.pendo.io.k3.o
        public void onError(Throwable th) {
            this.d = th;
            this.c.lazySet(sdk.pendo.io.r3.b.DISPOSED);
            for (a<T> aVar : getAndSet(f)) {
                aVar.a.onError(th);
            }
        }

        @Override // sdk.pendo.io.k3.o
        public void onNext(T t) {
            for (a<T> aVar : get()) {
                aVar.a.onNext(t);
            }
        }

        @Override // sdk.pendo.io.k3.o
        public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            sdk.pendo.io.r3.b.c(this.c, bVar);
        }
    }

    public y(sdk.pendo.io.k3.m<T> mVar) {
        this.a = mVar;
    }

    @Override // sdk.pendo.io.r3.e
    public void a(sdk.pendo.io.o3.b bVar) {
        PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.b, (b) bVar, null);
    }

    @Override // sdk.pendo.io.k3.j
    protected void b(sdk.pendo.io.k3.o<? super T> oVar) {
        b<T> bVar;
        while (true) {
            bVar = this.b.get();
            if (bVar != null) {
                break;
            }
            b<T> bVar2 = new b<>(this.b);
            if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.b, bVar, bVar2)) {
                bVar = bVar2;
                break;
            }
        }
        a<T> aVar = new a<>(oVar, bVar);
        oVar.onSubscribe(aVar);
        if (bVar.a(aVar)) {
            if (aVar.isDisposed()) {
                bVar.b(aVar);
            }
        } else {
            Throwable th = bVar.d;
            if (th != null) {
                oVar.onError(th);
            } else {
                oVar.onComplete();
            }
        }
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
        if (!bVar.a.get() && bVar.a.compareAndSet(false, true)) {
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
