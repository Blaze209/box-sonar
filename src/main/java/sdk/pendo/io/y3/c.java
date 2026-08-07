package sdk.pendo.io.y3;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class c<T, R> extends sdk.pendo.io.k3.j<R> {
    final sdk.pendo.io.k3.m<? extends T>[] a;
    final Iterable<? extends sdk.pendo.io.k3.m<? extends T>> b;
    final sdk.pendo.io.q3.h<? super Object[], ? extends R> c;
    final int d;
    final boolean e;

    static final class a<T, R> extends AtomicReference<sdk.pendo.io.o3.b> implements sdk.pendo.io.k3.o<T> {
        final b<T, R> a;
        final int b;

        a(b<T, R> bVar, int i) {
            this.a = bVar;
            this.b = i;
        }

        public void a() {
            sdk.pendo.io.r3.b.a(this);
        }

        @Override // sdk.pendo.io.k3.o
        public void onComplete() {
            this.a.a(this.b);
        }

        @Override // sdk.pendo.io.k3.o
        public void onError(Throwable th) {
            this.a.a(this.b, th);
        }

        @Override // sdk.pendo.io.k3.o
        public void onNext(T t) {
            this.a.a(this.b, t);
        }

        @Override // sdk.pendo.io.k3.o
        public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            sdk.pendo.io.r3.b.c(this, bVar);
        }
    }

    static final class b<T, R> extends AtomicInteger implements sdk.pendo.io.o3.b {
        final sdk.pendo.io.k3.o<? super R> a;
        final sdk.pendo.io.q3.h<? super Object[], ? extends R> b;
        final a<T, R>[] c;
        Object[] d;
        final sdk.pendo.io.z3.c<Object[]> e;
        final boolean f;
        volatile boolean g;
        volatile boolean h;
        final sdk.pendo.io.d4.c i = new sdk.pendo.io.d4.c();
        int j;
        int k;

        b(sdk.pendo.io.k3.o<? super R> oVar, sdk.pendo.io.q3.h<? super Object[], ? extends R> hVar, int i, int i2, boolean z) {
            this.a = oVar;
            this.b = hVar;
            this.f = z;
            this.d = new Object[i];
            a<T, R>[] aVarArr = new a[i];
            for (int i3 = 0; i3 < i; i3++) {
                aVarArr[i3] = new a<>(this, i3);
            }
            this.c = aVarArr;
            this.e = new sdk.pendo.io.z3.c<>(i2);
        }

        void a() {
            for (a<T, R> aVar : this.c) {
                aVar.a();
            }
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            sdk.pendo.io.z3.c<Object[]> cVar = this.e;
            sdk.pendo.io.k3.o<? super R> oVar = this.a;
            boolean z = this.f;
            int iAddAndGet = 1;
            while (!this.g) {
                if (z || this.i.get() == null) {
                    boolean z2 = this.h;
                    Object[] objArrPoll = cVar.poll();
                    boolean z3 = objArrPoll == null;
                    if (z2 && z3) {
                        a((sdk.pendo.io.z3.c<?>) cVar);
                        Throwable thA = this.i.a();
                        if (thA == null) {
                            oVar.onComplete();
                            return;
                        } else {
                            oVar.onError(thA);
                            return;
                        }
                    }
                    if (z3) {
                        iAddAndGet = addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    } else {
                        try {
                            oVar.onNext((Object) sdk.pendo.io.s3.b.a(this.b.apply(objArrPoll), "The combiner returned a null value"));
                        } catch (Throwable th) {
                            sdk.pendo.io.p3.b.b(th);
                            this.i.a(th);
                        }
                    }
                }
                a();
                a((sdk.pendo.io.z3.c<?>) cVar);
                oVar.onError(this.i.a());
                return;
            }
            a((sdk.pendo.io.z3.c<?>) cVar);
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            if (this.g) {
                return;
            }
            this.g = true;
            a();
            if (getAndIncrement() == 0) {
                a((sdk.pendo.io.z3.c<?>) this.e);
            }
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return this.g;
        }

        void a(sdk.pendo.io.z3.c<?> cVar) {
            synchronized (this) {
                this.d = null;
            }
            cVar.clear();
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0019 A[Catch: all -> 0x0025, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x0007, B:12:0x0011, B:15:0x001b, B:14:0x0019), top: B:23:0x0001 }] */
        void a(int i) {
            synchronized (this) {
                Object[] objArr = this.d;
                if (objArr == null) {
                    return;
                }
                boolean z = objArr[i] == null;
                if (z) {
                    this.h = true;
                } else {
                    int i2 = this.k + 1;
                    this.k = i2;
                    if (i2 == objArr.length) {
                        this.h = true;
                    }
                }
                if (z) {
                    a();
                }
                b();
            }
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0025 A[Catch: all -> 0x002a, TryCatch #0 {, blocks: (B:7:0x000e, B:9:0x0012, B:11:0x0014, B:16:0x001d, B:19:0x0027, B:18:0x0025), top: B:30:0x000e }] */
        void a(int i, Throwable th) {
            if (!this.i.a(th)) {
                sdk.pendo.io.g4.a.b(th);
                return;
            }
            boolean z = true;
            if (this.f) {
                synchronized (this) {
                    Object[] objArr = this.d;
                    if (objArr == null) {
                        return;
                    }
                    boolean z2 = objArr[i] == null;
                    if (z2) {
                        this.h = true;
                    } else {
                        int i2 = this.k + 1;
                        this.k = i2;
                        if (i2 == objArr.length) {
                            this.h = true;
                        }
                    }
                    z = z2;
                }
            }
            if (z) {
                a();
            }
            b();
        }

        void a(int i, T t) {
            boolean z;
            synchronized (this) {
                Object[] objArr = this.d;
                if (objArr == null) {
                    return;
                }
                Object obj = objArr[i];
                int i2 = this.j;
                if (obj == null) {
                    i2++;
                    this.j = i2;
                }
                objArr[i] = t;
                if (i2 == objArr.length) {
                    this.e.offer((Object[]) objArr.clone());
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    b();
                }
            }
        }

        public void a(sdk.pendo.io.k3.m<? extends T>[] mVarArr) {
            a<T, R>[] aVarArr = this.c;
            int length = aVarArr.length;
            this.a.onSubscribe(this);
            for (int i = 0; i < length && !this.h && !this.g; i++) {
                mVarArr[i].a(aVarArr[i]);
            }
        }
    }

    public c(sdk.pendo.io.k3.m<? extends T>[] mVarArr, Iterable<? extends sdk.pendo.io.k3.m<? extends T>> iterable, sdk.pendo.io.q3.h<? super Object[], ? extends R> hVar, int i, boolean z) {
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
        int i = length;
        if (i == 0) {
            sdk.pendo.io.r3.c.a(oVar);
        } else {
            new b(oVar, this.c, i, this.d, this.e).a(mVarArr);
        }
    }
}
