package sdk.pendo.io.j4;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.k3.o;

/* JADX INFO: loaded from: classes4.dex */
public final class b<T> extends d<T> {
    static final a[] c = new a[0];
    static final a[] d = new a[0];
    final AtomicReference<a<T>[]> a = new AtomicReference<>(d);
    Throwable b;

    static final class a<T> extends AtomicBoolean implements sdk.pendo.io.o3.b {
        final o<? super T> a;
        final b<T> b;

        a(o<? super T> oVar, b<T> bVar) {
            this.a = oVar;
            this.b = bVar;
        }

        public void a() {
            if (get()) {
                return;
            }
            this.a.onComplete();
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.b.b(this);
            }
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return get();
        }

        public void a(Throwable th) {
            if (get()) {
                sdk.pendo.io.g4.a.b(th);
            } else {
                this.a.onError(th);
            }
        }

        public void a(T t) {
            if (get()) {
                return;
            }
            this.a.onNext(t);
        }
    }

    b() {
    }

    public static <T> b<T> m() {
        return new b<>();
    }

    boolean a(a<T> aVar) {
        a<T>[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = this.a.get();
            if (aVarArr == c) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.a, aVarArr, aVarArr2));
        return true;
    }

    void b(a<T> aVar) {
        a<T>[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = this.a.get();
            if (aVarArr == c || aVarArr == d) {
                return;
            }
            int length = aVarArr.length;
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
            if (length == 1) {
                aVarArr2 = d;
            } else {
                a[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i);
                System.arraycopy(aVarArr, i + 1, aVarArr3, i, (length - i) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.a, aVarArr, aVarArr2));
    }

    @Override // sdk.pendo.io.k3.o
    public void onComplete() {
        a<T>[] aVarArr = this.a.get();
        a<T>[] aVarArr2 = c;
        if (aVarArr == aVarArr2) {
            return;
        }
        a<T>[] andSet = this.a.getAndSet(aVarArr2);
        for (a<T> aVar : andSet) {
            aVar.a();
        }
    }

    @Override // sdk.pendo.io.k3.o
    public void onError(Throwable th) {
        sdk.pendo.io.s3.b.a(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        a<T>[] aVarArr = this.a.get();
        a<T>[] aVarArr2 = c;
        if (aVarArr == aVarArr2) {
            sdk.pendo.io.g4.a.b(th);
            return;
        }
        this.b = th;
        a<T>[] andSet = this.a.getAndSet(aVarArr2);
        for (a<T> aVar : andSet) {
            aVar.a(th);
        }
    }

    @Override // sdk.pendo.io.k3.o
    public void onNext(T t) {
        sdk.pendo.io.s3.b.a((Object) t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (a<T> aVar : this.a.get()) {
            aVar.a(t);
        }
    }

    @Override // sdk.pendo.io.k3.o
    public void onSubscribe(sdk.pendo.io.o3.b bVar) {
        if (this.a.get() == c) {
            bVar.dispose();
        }
    }

    @Override // sdk.pendo.io.k3.j
    protected void b(o<? super T> oVar) {
        a<T> aVar = new a<>(oVar, this);
        oVar.onSubscribe(aVar);
        if (a((a) aVar)) {
            if (aVar.isDisposed()) {
                b(aVar);
            }
        } else {
            Throwable th = this.b;
            if (th != null) {
                oVar.onError(th);
            } else {
                oVar.onComplete();
            }
        }
    }
}
