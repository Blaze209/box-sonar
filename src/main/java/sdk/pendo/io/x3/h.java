package sdk.pendo.io.x3;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.k3.i;

/* JADX INFO: loaded from: classes6.dex */
public final class h<T, R> extends sdk.pendo.io.k3.g<R> {
    final i<? extends T>[] a;
    final sdk.pendo.io.q3.h<? super Object[], ? extends R> b;

    final class a implements sdk.pendo.io.q3.h<T, R> {
        a() {
        }

        @Override // sdk.pendo.io.q3.h
        public R apply(T t) {
            return (R) sdk.pendo.io.s3.b.a(h.this.b.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }

    static final class b<T, R> extends AtomicInteger implements sdk.pendo.io.o3.b {
        final sdk.pendo.io.k3.h<? super R> a;
        final sdk.pendo.io.q3.h<? super Object[], ? extends R> b;
        final c<T>[] c;
        final Object[] d;

        b(sdk.pendo.io.k3.h<? super R> hVar, int i, sdk.pendo.io.q3.h<? super Object[], ? extends R> hVar2) {
            super(i);
            this.a = hVar;
            this.b = hVar2;
            c<T>[] cVarArr = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                cVarArr[i2] = new c<>(this, i2);
            }
            this.c = cVarArr;
            this.d = new Object[i];
        }

        void a(int i) {
            c<T>[] cVarArr = this.c;
            int length = cVarArr.length;
            for (int i2 = 0; i2 < i; i2++) {
                cVarArr[i2].a();
            }
            while (true) {
                i++;
                if (i >= length) {
                    return;
                } else {
                    cVarArr[i].a();
                }
            }
        }

        void b(int i) {
            if (getAndSet(0) > 0) {
                a(i);
                this.a.onComplete();
            }
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            if (getAndSet(0) > 0) {
                for (c<T> cVar : this.c) {
                    cVar.a();
                }
            }
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return get() <= 0;
        }

        void a(Throwable th, int i) {
            if (getAndSet(0) <= 0) {
                sdk.pendo.io.g4.a.b(th);
            } else {
                a(i);
                this.a.onError(th);
            }
        }

        void a(T t, int i) {
            this.d[i] = t;
            if (decrementAndGet() == 0) {
                try {
                    this.a.onSuccess(sdk.pendo.io.s3.b.a(this.b.apply(this.d), "The zipper returned a null value"));
                } catch (Throwable th) {
                    sdk.pendo.io.p3.b.b(th);
                    this.a.onError(th);
                }
            }
        }
    }

    static final class c<T> extends AtomicReference<sdk.pendo.io.o3.b> implements sdk.pendo.io.k3.h<T> {
        final b<T, ?> a;
        final int b;

        c(b<T, ?> bVar, int i) {
            this.a = bVar;
            this.b = i;
        }

        public void a() {
            sdk.pendo.io.r3.b.a(this);
        }

        @Override // sdk.pendo.io.k3.h
        public void onComplete() {
            this.a.b(this.b);
        }

        @Override // sdk.pendo.io.k3.h
        public void onError(Throwable th) {
            this.a.a(th, this.b);
        }

        @Override // sdk.pendo.io.k3.h
        public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            sdk.pendo.io.r3.b.c(this, bVar);
        }

        @Override // sdk.pendo.io.k3.h
        public void onSuccess(T t) {
            this.a.a(t, this.b);
        }
    }

    public h(i<? extends T>[] iVarArr, sdk.pendo.io.q3.h<? super Object[], ? extends R> hVar) {
        this.a = iVarArr;
        this.b = hVar;
    }

    @Override // sdk.pendo.io.k3.g
    protected void b(sdk.pendo.io.k3.h<? super R> hVar) {
        i<? extends T>[] iVarArr = this.a;
        int length = iVarArr.length;
        if (length == 1) {
            iVarArr[0].a(new e.a(hVar, new a()));
            return;
        }
        b bVar = new b(hVar, length, this.b);
        hVar.onSubscribe(bVar);
        for (int i = 0; i < length && !bVar.isDisposed(); i++) {
            i<? extends T> iVar = iVarArr[i];
            if (iVar == null) {
                bVar.a((Throwable) new NullPointerException("One of the sources is null"), i);
                return;
            }
            iVar.a(bVar.c[i]);
        }
    }
}
