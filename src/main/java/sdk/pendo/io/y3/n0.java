package sdk.pendo.io.y3;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class n0<T, R> extends sdk.pendo.io.k3.j<R> {
    final sdk.pendo.io.k3.m<? extends T>[] a;
    final Iterable<? extends sdk.pendo.io.k3.m<? extends T>> b;
    final sdk.pendo.io.q3.h<? super Object[], ? extends R> c;
    final int d;
    final boolean e;

    static final class a<T, R> extends AtomicInteger implements sdk.pendo.io.o3.b {
        final sdk.pendo.io.k3.o<? super R> a;
        final sdk.pendo.io.q3.h<? super Object[], ? extends R> b;
        final b<T, R>[] c;
        final T[] d;
        final boolean e;
        volatile boolean f;

        a(sdk.pendo.io.k3.o<? super R> oVar, sdk.pendo.io.q3.h<? super Object[], ? extends R> hVar, int i, boolean z) {
            this.a = oVar;
            this.b = hVar;
            this.c = new b[i];
            this.d = (T[]) new Object[i];
            this.e = z;
        }

        void a() {
            c();
            b();
        }

        void b() {
            for (b<T, R> bVar : this.c) {
                bVar.a();
            }
        }

        void c() {
            for (b<T, R> bVar : this.c) {
                bVar.b.clear();
            }
        }

        public void d() {
            Throwable th;
            if (getAndIncrement() != 0) {
                return;
            }
            b<T, R>[] bVarArr = this.c;
            sdk.pendo.io.k3.o<? super R> oVar = this.a;
            T[] tArr = this.d;
            boolean z = this.e;
            int iAddAndGet = 1;
            while (true) {
                int i = 0;
                int i2 = 0;
                for (b<T, R> bVar : bVarArr) {
                    if (tArr[i2] == null) {
                        boolean z2 = bVar.c;
                        T tPoll = bVar.b.poll();
                        boolean z3 = tPoll == null;
                        if (a(z2, z3, oVar, z, bVar)) {
                            return;
                        }
                        if (z3) {
                            i++;
                        } else {
                            tArr[i2] = tPoll;
                        }
                    } else if (bVar.c && !z && (th = bVar.d) != null) {
                        this.f = true;
                        a();
                        oVar.onError(th);
                        return;
                    }
                    i2++;
                }
                if (i != 0) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    try {
                        oVar.onNext((Object) sdk.pendo.io.s3.b.a(this.b.apply(tArr.clone()), "The zipper returned a null value"));
                        Arrays.fill(tArr, (Object) null);
                    } catch (Throwable th2) {
                        sdk.pendo.io.p3.b.b(th2);
                        a();
                        oVar.onError(th2);
                        return;
                    }
                }
            }
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            if (this.f) {
                return;
            }
            this.f = true;
            b();
            if (getAndIncrement() == 0) {
                c();
            }
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return this.f;
        }

        boolean a(boolean z, boolean z2, sdk.pendo.io.k3.o<? super R> oVar, boolean z3, b<?, ?> bVar) {
            if (this.f) {
                a();
                return true;
            }
            if (!z) {
                return false;
            }
            if (z3) {
                if (!z2) {
                    return false;
                }
                Throwable th = bVar.d;
                this.f = true;
                a();
                if (th != null) {
                    oVar.onError(th);
                } else {
                    oVar.onComplete();
                }
                return true;
            }
            Throwable th2 = bVar.d;
            if (th2 != null) {
                this.f = true;
                a();
                oVar.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            this.f = true;
            a();
            oVar.onComplete();
            return true;
        }

        public void a(sdk.pendo.io.k3.m<? extends T>[] mVarArr, int i) {
            b<T, R>[] bVarArr = this.c;
            int length = bVarArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                bVarArr[i2] = new b<>(this, i);
            }
            lazySet(0);
            this.a.onSubscribe(this);
            for (int i3 = 0; i3 < length && !this.f; i3++) {
                mVarArr[i3].a(bVarArr[i3]);
            }
        }
    }

    static final class b<T, R> implements sdk.pendo.io.k3.o<T> {
        final a<T, R> a;
        final sdk.pendo.io.z3.c<T> b;
        volatile boolean c;
        Throwable d;
        final AtomicReference<sdk.pendo.io.o3.b> e = new AtomicReference<>();

        b(a<T, R> aVar, int i) {
            this.a = aVar;
            this.b = new sdk.pendo.io.z3.c<>(i);
        }

        public void a() {
            sdk.pendo.io.r3.b.a(this.e);
        }

        @Override // sdk.pendo.io.k3.o
        public void onComplete() {
            this.c = true;
            this.a.d();
        }

        @Override // sdk.pendo.io.k3.o
        public void onError(Throwable th) {
            this.d = th;
            this.c = true;
            this.a.d();
        }

        @Override // sdk.pendo.io.k3.o
        public void onNext(T t) {
            this.b.offer(t);
            this.a.d();
        }

        @Override // sdk.pendo.io.k3.o
        public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            sdk.pendo.io.r3.b.c(this.e, bVar);
        }
    }

    public n0(sdk.pendo.io.k3.m<? extends T>[] mVarArr, Iterable<? extends sdk.pendo.io.k3.m<? extends T>> iterable, sdk.pendo.io.q3.h<? super Object[], ? extends R> hVar, int i, boolean z) {
        this.a = mVarArr;
        this.b = iterable;
        this.c = hVar;
        this.d = i;
        this.e = z;
    }

    @Override // sdk.pendo.io.k3.j
    public void b(sdk.pendo.io.k3.o<? super R> oVar) {
        int length;
        sdk.pendo.io.k3.m<? extends T>[] mVarArr = this.a;
        if (mVarArr == null) {
            mVarArr = new sdk.pendo.io.k3.m[8];
            length = 0;
            for (sdk.pendo.io.k3.m<? extends T> mVar : this.b) {
                if (length == mVarArr.length) {
                    sdk.pendo.io.k3.m<? extends T>[] mVarArr2 = new sdk.pendo.io.k3.m[(length >> 2) + length];
                    System.arraycopy(mVarArr, 0, mVarArr2, 0, length);
                    mVarArr = mVarArr2;
                }
                mVarArr[length] = mVar;
                length++;
            }
        } else {
            length = mVarArr.length;
        }
        if (length == 0) {
            sdk.pendo.io.r3.c.a(oVar);
        } else {
            new a(oVar, this.c, length, this.e).a(mVarArr, this.d);
        }
    }
}
