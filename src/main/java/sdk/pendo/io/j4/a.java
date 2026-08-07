package sdk.pendo.io.j4;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import sdk.pendo.io.d4.g;
import sdk.pendo.io.d4.i;
import sdk.pendo.io.k3.o;

/* JADX INFO: loaded from: classes4.dex */
public final class a<T> extends d<T> {
    private static final Object[] h = new Object[0];
    static final C0401a[] i = new C0401a[0];
    static final C0401a[] j = new C0401a[0];
    final AtomicReference<Object> a;
    final AtomicReference<C0401a<T>[]> b;
    final ReadWriteLock c;
    final Lock d;
    final Lock e;
    final AtomicReference<Throwable> f;
    long g;

    /* JADX INFO: renamed from: sdk.pendo.io.j4.a$a, reason: collision with other inner class name */
    static final class C0401a<T> implements sdk.pendo.io.o3.b, sdk.pendo.io.d4.a.InterfaceC0373a<Object> {
        final o<? super T> a;
        final a<T> b;
        boolean c;
        boolean d;
        sdk.pendo.io.d4.a<Object> e;
        boolean f;
        volatile boolean g;
        long h;

        C0401a(o<? super T> oVar, a<T> aVar) {
            this.a = oVar;
            this.b = aVar;
        }

        void a() {
            if (this.g) {
                return;
            }
            synchronized (this) {
                if (!this.g && !this.c) {
                    a<T> aVar = this.b;
                    Lock lock = aVar.d;
                    lock.lock();
                    this.h = aVar.g;
                    Object obj = aVar.a.get();
                    lock.unlock();
                    this.d = obj != null;
                    this.c = true;
                    if (obj == null || test(obj)) {
                        return;
                    }
                    b();
                }
            }
        }

        void b() {
            sdk.pendo.io.d4.a<Object> aVar;
            while (!this.g) {
                synchronized (this) {
                    aVar = this.e;
                    if (aVar == null) {
                        this.d = false;
                        return;
                    }
                    this.e = null;
                }
                aVar.a((sdk.pendo.io.d4.a.InterfaceC0373a<? super Object>) this);
            }
        }

        @Override // sdk.pendo.io.o3.b
        public void dispose() {
            if (this.g) {
                return;
            }
            this.g = true;
            this.b.b((C0401a) this);
        }

        @Override // sdk.pendo.io.o3.b
        public boolean isDisposed() {
            return this.g;
        }

        @Override // sdk.pendo.io.d4.a.InterfaceC0373a, sdk.pendo.io.q3.j
        public boolean test(Object obj) {
            return this.g || i.a(obj, this.a);
        }

        void a(Object obj, long j) {
            if (this.g) {
                return;
            }
            if (!this.f) {
                synchronized (this) {
                    if (!this.g && this.h != j) {
                        if (this.d) {
                            sdk.pendo.io.d4.a<Object> aVar = this.e;
                            if (aVar == null) {
                                aVar = new sdk.pendo.io.d4.a<>(4);
                                this.e = aVar;
                            }
                            aVar.a(obj);
                        } else {
                            this.c = true;
                            this.f = true;
                        }
                    }
                    return;
                }
            }
            test(obj);
        }
    }

    a() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.c = reentrantReadWriteLock;
        this.d = reentrantReadWriteLock.readLock();
        this.e = reentrantReadWriteLock.writeLock();
        this.b = new AtomicReference<>(i);
        this.a = new AtomicReference<>();
        this.f = new AtomicReference<>();
    }

    public static <T> a<T> b(T t) {
        return new a<>(t);
    }

    public static <T> a<T> m() {
        return new a<>();
    }

    boolean a(C0401a<T> c0401a) {
        C0401a<T>[] c0401aArr;
        C0401a[] c0401aArr2;
        do {
            c0401aArr = this.b.get();
            if (c0401aArr == j) {
                return false;
            }
            int length = c0401aArr.length;
            c0401aArr2 = new C0401a[length + 1];
            System.arraycopy(c0401aArr, 0, c0401aArr2, 0, length);
            c0401aArr2[length] = c0401a;
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.b, c0401aArr, c0401aArr2));
        return true;
    }

    void c(Object obj) {
        this.e.lock();
        this.g++;
        this.a.lazySet(obj);
        this.e.unlock();
    }

    C0401a<T>[] d(Object obj) {
        AtomicReference<C0401a<T>[]> atomicReference = this.b;
        C0401a<T>[] c0401aArr = j;
        C0401a<T>[] andSet = atomicReference.getAndSet(c0401aArr);
        if (andSet != c0401aArr) {
            c(obj);
        }
        return andSet;
    }

    public T n() {
        Object obj = this.a.get();
        if (i.b(obj) || i.c(obj)) {
            return null;
        }
        return (T) i.a(obj);
    }

    public boolean o() {
        return i.b(this.a.get());
    }

    @Override // sdk.pendo.io.k3.o
    public void onComplete() {
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.f, null, g.a)) {
            Object objA = i.a();
            for (C0401a<T> c0401a : d(objA)) {
                c0401a.a(objA, this.g);
            }
        }
    }

    @Override // sdk.pendo.io.k3.o
    public void onError(Throwable th) {
        sdk.pendo.io.s3.b.a(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.f, null, th)) {
            sdk.pendo.io.g4.a.b(th);
            return;
        }
        Object objA = i.a(th);
        for (C0401a<T> c0401a : d(objA)) {
            c0401a.a(objA, this.g);
        }
    }

    @Override // sdk.pendo.io.k3.o
    public void onNext(T t) {
        sdk.pendo.io.s3.b.a((Object) t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f.get() != null) {
            return;
        }
        Object objD = i.d(t);
        c(objD);
        for (C0401a<T> c0401a : this.b.get()) {
            c0401a.a(objD, this.g);
        }
    }

    @Override // sdk.pendo.io.k3.o
    public void onSubscribe(sdk.pendo.io.o3.b bVar) {
        if (this.f.get() != null) {
            bVar.dispose();
        }
    }

    public boolean p() {
        Object obj = this.a.get();
        return (obj == null || i.b(obj) || i.c(obj)) ? false : true;
    }

    a(T t) {
        this();
        this.a.lazySet(sdk.pendo.io.s3.b.a((Object) t, "defaultValue is null"));
    }

    void b(C0401a<T> c0401a) {
        C0401a<T>[] c0401aArr;
        C0401a[] c0401aArr2;
        do {
            c0401aArr = this.b.get();
            int length = c0401aArr.length;
            if (length == 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    i2 = -1;
                    break;
                } else if (c0401aArr[i2] == c0401a) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 < 0) {
                return;
            }
            if (length == 1) {
                c0401aArr2 = i;
            } else {
                C0401a[] c0401aArr3 = new C0401a[length - 1];
                System.arraycopy(c0401aArr, 0, c0401aArr3, 0, i2);
                System.arraycopy(c0401aArr, i2 + 1, c0401aArr3, i2, (length - i2) - 1);
                c0401aArr2 = c0401aArr3;
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.b, c0401aArr, c0401aArr2));
    }

    @Override // sdk.pendo.io.k3.j
    protected void b(o<? super T> oVar) {
        C0401a<T> c0401a = new C0401a<>(oVar, this);
        oVar.onSubscribe(c0401a);
        if (a((C0401a) c0401a)) {
            if (c0401a.g) {
                b((C0401a) c0401a);
                return;
            } else {
                c0401a.a();
                return;
            }
        }
        Throwable th = this.f.get();
        if (th == g.a) {
            oVar.onComplete();
        } else {
            oVar.onError(th);
        }
    }
}
