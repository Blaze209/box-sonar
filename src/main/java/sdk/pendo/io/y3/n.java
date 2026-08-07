package sdk.pendo.io.y3;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes6.dex */
public final class n<T, U> extends sdk.pendo.io.y3.a<T, U> {
    final sdk.pendo.io.q3.h<? super T, ? extends sdk.pendo.io.k3.m<? extends U>> b;
    final boolean c;
    final int d;
    final int e;

    static final class a<T, U> extends AtomicReference<sdk.pendo.io.o3.b> implements sdk.pendo.io.k3.o<U> {
        final long a;
        final b<T, U> b;
        volatile boolean c;
        volatile sdk.pendo.io.t3.g<U> d;
        int e;

        a(b<T, U> bVar, long j) {
            this.a = j;
            this.b = bVar;
        }

        public void a() {
            sdk.pendo.io.r3.b.a(this);
        }

        @Override // sdk.pendo.io.k3.o
        public void onComplete() {
            this.c = true;
            this.b.c();
        }

        @Override // sdk.pendo.io.k3.o
        public void onError(Throwable th) {
            if (!this.b.h.a(th)) {
                sdk.pendo.io.g4.a.b(th);
                return;
            }
            b<T, U> bVar = this.b;
            if (!bVar.c) {
                bVar.b();
            }
            this.c = true;
            this.b.c();
        }

        @Override // sdk.pendo.io.k3.o
        public void onNext(U u) {
            if (this.e == 0) {
                this.b.a(u, this);
            } else {
                this.b.c();
            }
        }

        @Override // sdk.pendo.io.k3.o
        public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            if (sdk.pendo.io.r3.b.c(this, bVar) && (bVar instanceof sdk.pendo.io.t3.b)) {
                sdk.pendo.io.t3.b bVar2 = (sdk.pendo.io.t3.b) bVar;
                int iA = bVar2.a(7);
                if (iA == 1) {
                    this.e = iA;
                    this.d = bVar2;
                    this.c = true;
                    this.b.c();
                    return;
                }
                if (iA == 2) {
                    this.e = iA;
                    this.d = bVar2;
                }
            }
        }
    }

    static final class b<T, U> extends AtomicInteger implements sdk.pendo.io.o3.b, sdk.pendo.io.k3.o<T> {
        static final a<?, ?>[] q = new a[0];
        static final a<?, ?>[] r = new a[0];
        final sdk.pendo.io.k3.o<? super U> a;
        final sdk.pendo.io.q3.h<? super T, ? extends sdk.pendo.io.k3.m<? extends U>> b;
        final boolean c;
        final int d;
        final int e;
        volatile sdk.pendo.io.t3.f<U> f;
        volatile boolean g;
        final sdk.pendo.io.d4.c h = new sdk.pendo.io.d4.c();
        volatile boolean i;
        final AtomicReference<a<?, ?>[]> j;
        sdk.pendo.io.o3.b k;
        long l;
        long m;
        int n;
        Queue<sdk.pendo.io.k3.m<? extends U>> o;
        int p;

        b(sdk.pendo.io.k3.o<? super U> oVar, sdk.pendo.io.q3.h<? super T, ? extends sdk.pendo.io.k3.m<? extends U>> hVar, boolean z, int i, int i2) {
            this.a = oVar;
            this.b = hVar;
            this.c = z;
            this.d = i;
            this.e = i2;
            if (i != Integer.MAX_VALUE) {
                this.o = new ArrayDeque(i);
            }
            this.j = new AtomicReference<>(q);
        }

        boolean a(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = this.j.get();
                if (aVarArr == r) {
                    aVar.a();
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.j, aVarArr, aVarArr2));
            return true;
        }

        boolean b() {
            a<?, ?>[] andSet;
            this.k.dispose();
            a<?, ?>[] aVarArr = this.j.get();
            a<?, ?>[] aVarArr2 = r;
            if (aVarArr == aVarArr2 || (andSet = this.j.getAndSet(aVarArr2)) == aVarArr2) {
                return false;
            }
            for (a<?, ?> aVar : andSet) {
                aVar.a();
            }
            return true;
        }

        void c() {
            if (getAndIncrement() == 0) {
                d();
            }
        }

        /* JADX WARN: Code duplicated, block: B:111:0x011d A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:126:0x0100 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:86:0x00f9  */
        /* JADX WARN: Code duplicated, block: B:89:0x00ff A[PHI: r4
          0x00ff: PHI (r4v7 int) = (r4v5 int), (r4v8 int) binds: [B:76:0x00de, B:88:0x00fd] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Multi-variable type inference failed */
        void d() {
            int size;
            boolean z;
            sdk.pendo.io.k3.o<? super U> oVar = this.a;
            int iAddAndGet = 1;
            while (!a()) {
                sdk.pendo.io.t3.f<U> fVar = this.f;
                int i = 0;
                if (fVar != null) {
                    while (!a()) {
                        U uPoll = fVar.poll();
                        if (uPoll != null) {
                            oVar.onNext(uPoll);
                            i++;
                        }
                    }
                    return;
                }
                if (i == 0) {
                    boolean z2 = this.g;
                    sdk.pendo.io.t3.f<U> fVar2 = this.f;
                    a<?, ?>[] aVarArr = this.j.get();
                    int length = aVarArr.length;
                    if (this.d != Integer.MAX_VALUE) {
                        synchronized (this) {
                            size = this.o.size();
                        }
                    } else {
                        size = 0;
                    }
                    if (z2 && ((fVar2 == null || fVar2.isEmpty()) && length == 0 && size == 0)) {
                        Throwable thA = this.h.a();
                        if (thA != sdk.pendo.io.d4.g.a) {
                            if (thA == null) {
                                oVar.onComplete();
                                return;
                            } else {
                                oVar.onError(thA);
                                return;
                            }
                        }
                        return;
                    }
                    if (length != 0) {
                        long j = this.m;
                        int i2 = this.n;
                        if (length <= i2 || aVarArr[i2].a != j) {
                            if (length <= i2) {
                                i2 = 0;
                            }
                            for (int i3 = 0; i3 < length && aVarArr[i2].a != j; i3++) {
                                i2++;
                                if (i2 == length) {
                                    i2 = 0;
                                }
                            }
                            this.n = i2;
                            this.m = aVarArr[i2].a;
                        }
                        for (int i4 = 0; i4 < length; i4++) {
                            if (a()) {
                                return;
                            }
                            a<T, U> aVar = aVarArr[i2];
                            sdk.pendo.io.t3.g<U> gVar = aVar.d;
                            if (gVar != null) {
                                do {
                                    try {
                                        U uPoll2 = gVar.poll();
                                        if (uPoll2 == null) {
                                            z = aVar.c;
                                            sdk.pendo.io.t3.g<U> gVar2 = aVar.d;
                                            if (z && (gVar2 == null || gVar2.isEmpty())) {
                                                b(aVar);
                                                if (a()) {
                                                    return;
                                                } else {
                                                    i++;
                                                }
                                            }
                                            i2++;
                                            if (i2 == length) {
                                                i2 = 0;
                                            }
                                        } else {
                                            oVar.onNext(uPoll2);
                                        }
                                    } catch (Throwable th) {
                                        sdk.pendo.io.p3.b.b(th);
                                        aVar.a();
                                        this.h.a(th);
                                        if (a()) {
                                            return;
                                        }
                                        b(aVar);
                                        i++;
                                        i2++;
                                        if (i2 == length) {
                                        }
                                    }
                                } while (!a());
                                return;
                            }
                            z = aVar.c;
                            sdk.pendo.io.t3.g<U> gVar3 = aVar.d;
                            if (z) {
                                b(aVar);
                                if (a()) {
                                    return;
                                } else {
                                    i++;
                                }
                            }
                            i2++;
                            if (i2 == length) {
                                i2 = 0;
                            }
                        }
                        this.n = i2;
                        this.m = aVarArr[i2].a;
                    }
                    if (i == 0) {
                        iAddAndGet = addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    } else if (this.d != Integer.MAX_VALUE) {
                        a(i);
                    }
                } else if (this.d != Integer.MAX_VALUE) {
                    a(i);
                }
            }
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            Throwable thA;
            if (this.i) {
                return;
            }
            this.i = true;
            if (!b() || (thA = this.h.a()) == null || thA == sdk.pendo.io.d4.g.a) {
                return;
            }
            sdk.pendo.io.g4.a.b(thA);
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return this.i;
        }

        @Override // sdk.pendo.io.k3.o
        public void onComplete() {
            if (this.g) {
                return;
            }
            this.g = true;
            c();
        }

        @Override // sdk.pendo.io.k3.o
        public void onError(Throwable th) {
            if (this.g) {
                sdk.pendo.io.g4.a.b(th);
            } else if (!this.h.a(th)) {
                sdk.pendo.io.g4.a.b(th);
            } else {
                this.g = true;
                c();
            }
        }

        @Override // sdk.pendo.io.k3.o
        public void onNext(T t) {
            if (this.g) {
                return;
            }
            try {
                sdk.pendo.io.k3.m<? extends U> mVar = (sdk.pendo.io.k3.m) sdk.pendo.io.s3.b.a(this.b.apply(t), "The mapper returned a null ObservableSource");
                if (this.d != Integer.MAX_VALUE) {
                    synchronized (this) {
                        int i = this.p;
                        if (i == this.d) {
                            this.o.offer(mVar);
                            return;
                        }
                        this.p = i + 1;
                    }
                }
                a(mVar);
            } catch (Throwable th) {
                sdk.pendo.io.p3.b.b(th);
                this.k.dispose();
                onError(th);
            }
        }

        @Override // sdk.pendo.io.k3.o
        public void onSubscribe(sdk.pendo.io.o3.b bVar) {
            if (sdk.pendo.io.r3.b.a(this.k, bVar)) {
                this.k = bVar;
                this.a.onSubscribe(this);
            }
        }

        boolean a() {
            if (this.i) {
                return true;
            }
            Throwable th = this.h.get();
            if (this.c || th == null) {
                return false;
            }
            b();
            Throwable thA = this.h.a();
            if (thA != sdk.pendo.io.d4.g.a) {
                this.a.onError(thA);
            }
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void b(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a<?, ?>[] aVarArr2;
            do {
                aVarArr = this.j.get();
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
                if (length == 1) {
                    aVarArr2 = q;
                } else {
                    a<?, ?>[] aVarArr3 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr3, 0, i);
                    System.arraycopy(aVarArr, i + 1, aVarArr3, i, (length - i) - 1);
                    aVarArr2 = aVarArr3;
                }
            } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.j, aVarArr, aVarArr2));
        }

        void a(sdk.pendo.io.k3.m<? extends U> mVar) {
            boolean z;
            while (mVar instanceof Callable) {
                if (!a((Callable) mVar) || this.d == Integer.MAX_VALUE) {
                    return;
                }
                synchronized (this) {
                    mVar = this.o.poll();
                    if (mVar == null) {
                        z = true;
                        this.p--;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    c();
                    return;
                }
            }
            long j = this.l;
            this.l = 1 + j;
            a<T, U> aVar = new a<>(this, j);
            if (a(aVar)) {
                mVar.a(aVar);
            }
        }

        void a(int i) {
            while (true) {
                int i2 = i - 1;
                if (i == 0) {
                    return;
                }
                synchronized (this) {
                    sdk.pendo.io.k3.m<? extends U> mVarPoll = this.o.poll();
                    if (mVarPoll == null) {
                        this.p--;
                    } else {
                        a(mVarPoll);
                    }
                }
                i = i2;
            }
        }

        void a(U u, a<T, U> aVar) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.a.onNext(u);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                sdk.pendo.io.t3.g cVar = aVar.d;
                if (cVar == null) {
                    cVar = new sdk.pendo.io.z3.c(this.e);
                    aVar.d = cVar;
                }
                cVar.offer(u);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            d();
        }

        boolean a(Callable<? extends U> callable) {
            try {
                U uCall = callable.call();
                if (uCall == null) {
                    return true;
                }
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.a.onNext(uCall);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                } else {
                    sdk.pendo.io.t3.f<U> cVar = this.f;
                    if (cVar == null) {
                        cVar = this.d == Integer.MAX_VALUE ? new sdk.pendo.io.z3.c<>(this.e) : new sdk.pendo.io.z3.b<>(this.d);
                        this.f = cVar;
                    }
                    if (!cVar.offer(uCall)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return true;
                    }
                    if (getAndIncrement() != 0) {
                        return false;
                    }
                }
                d();
                return true;
            } catch (Throwable th) {
                sdk.pendo.io.p3.b.b(th);
                this.h.a(th);
                c();
                return true;
            }
        }
    }

    public n(sdk.pendo.io.k3.m<T> mVar, sdk.pendo.io.q3.h<? super T, ? extends sdk.pendo.io.k3.m<? extends U>> hVar, boolean z, int i, int i2) {
        super(mVar);
        this.b = hVar;
        this.c = z;
        this.d = i;
        this.e = i2;
    }

    @Override // sdk.pendo.io.k3.j
    public void b(sdk.pendo.io.k3.o<? super U> oVar) {
        if (c0.a(this.a, oVar, this.b)) {
            return;
        }
        this.a.a(new b(oVar, this.b, this.c, this.d, this.e));
    }
}
