package sdk.pendo.io.h4;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.d4.d;
import sdk.pendo.io.j3.c;

/* JADX INFO: loaded from: classes4.dex */
public final class b<T> extends sdk.pendo.io.h4.a<T> {
    static final a[] d = new a[0];
    static final a[] e = new a[0];
    final AtomicReference<a<T>[]> b = new AtomicReference<>(e);
    Throwable c;

    static final class a<T> extends AtomicLong implements c {
        final sdk.pendo.io.j3.b<? super T> a;
        final b<T> b;

        a(sdk.pendo.io.j3.b<? super T> bVar, b<T> bVar2) {
            this.a = bVar;
            this.b = bVar2;
        }

        public boolean a() {
            return get() == Long.MIN_VALUE;
        }

        public void b() {
            if (get() != Long.MIN_VALUE) {
                this.a.onComplete();
            }
        }

        @Override // sdk.pendo.io.j3.c
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.b.b(this);
            }
        }

        @Override // sdk.pendo.io.j3.c
        public void request(long j) {
            if (sdk.pendo.io.c4.c.b(j)) {
                d.b(this, j);
            }
        }

        public void a(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.a.onError(th);
            } else {
                sdk.pendo.io.g4.a.b(th);
            }
        }

        public void a(T t) {
            long j = get();
            if (j == Long.MIN_VALUE) {
                return;
            }
            if (j != 0) {
                this.a.onNext(t);
                d.d(this, 1L);
            } else {
                cancel();
                this.a.onError(new sdk.pendo.io.p3.c(MissingBackpressureException.DEFAULT_MESSAGE));
            }
        }
    }

    b() {
    }

    public static <T> b<T> f() {
        return new b<>();
    }

    boolean a(a<T> aVar) {
        a<T>[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = this.b.get();
            if (aVarArr == d) {
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
            if (aVarArr == d || aVarArr == e) {
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
                aVarArr2 = e;
            } else {
                a[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i);
                System.arraycopy(aVarArr, i + 1, aVarArr3, i, (length - i) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.b, aVarArr, aVarArr2));
    }

    @Override // sdk.pendo.io.j3.b
    public void onComplete() {
        a<T>[] aVarArr = this.b.get();
        a<T>[] aVarArr2 = d;
        if (aVarArr == aVarArr2) {
            return;
        }
        a<T>[] andSet = this.b.getAndSet(aVarArr2);
        for (a<T> aVar : andSet) {
            aVar.b();
        }
    }

    @Override // sdk.pendo.io.j3.b
    public void onError(Throwable th) {
        sdk.pendo.io.s3.b.a(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        a<T>[] aVarArr = this.b.get();
        a<T>[] aVarArr2 = d;
        if (aVarArr == aVarArr2) {
            sdk.pendo.io.g4.a.b(th);
            return;
        }
        this.c = th;
        a<T>[] andSet = this.b.getAndSet(aVarArr2);
        for (a<T> aVar : andSet) {
            aVar.a(th);
        }
    }

    @Override // sdk.pendo.io.j3.b
    public void onNext(T t) {
        sdk.pendo.io.s3.b.a((Object) t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (a<T> aVar : this.b.get()) {
            aVar.a(t);
        }
    }

    @Override // sdk.pendo.io.j3.b
    public void a(c cVar) {
        if (this.b.get() == d) {
            cVar.cancel();
        } else {
            cVar.request(Long.MAX_VALUE);
        }
    }

    @Override // sdk.pendo.io.k3.d
    protected void b(sdk.pendo.io.j3.b<? super T> bVar) {
        a<T> aVar = new a<>(bVar, this);
        bVar.a(aVar);
        if (a((a) aVar)) {
            if (aVar.a()) {
                b(aVar);
            }
        } else {
            Throwable th = this.c;
            if (th != null) {
                bVar.onError(th);
            } else {
                bVar.onComplete();
            }
        }
    }
}
