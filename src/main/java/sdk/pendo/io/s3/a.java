package sdk.pendo.io.s3;

import java.util.Comparator;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final class a {
    static final sdk.pendo.io.q3.h<Object, Object> a = new j();
    public static final Runnable b = new g();
    public static final sdk.pendo.io.q3.a c = new d();
    static final sdk.pendo.io.q3.e<Object> d = new e();
    public static final sdk.pendo.io.q3.e<Throwable> e = new h();
    public static final sdk.pendo.io.q3.e<Throwable> f = new o();
    public static final sdk.pendo.io.q3.i g = new f();
    static final sdk.pendo.io.q3.j<Object> h = new p();
    static final sdk.pendo.io.q3.j<Object> i = new i();
    static final Callable<Object> j = new n();
    static final Comparator<Object> k = new m();
    public static final sdk.pendo.io.q3.e<sdk.pendo.io.j3.c> l = new l();

    /* JADX INFO: renamed from: sdk.pendo.io.s3.a$a, reason: collision with other inner class name */
    static final class C0476a<T1, T2, R> implements sdk.pendo.io.q3.h<Object[], R> {
        final sdk.pendo.io.q3.b<? super T1, ? super T2, ? extends R> a;

        C0476a(sdk.pendo.io.q3.b<? super T1, ? super T2, ? extends R> bVar) {
            this.a = bVar;
        }

        @Override // sdk.pendo.io.q3.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) {
            if (objArr.length == 2) {
                return this.a.a(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    static final class b<T1, T2, T3, R> implements sdk.pendo.io.q3.h<Object[], R> {
        final sdk.pendo.io.q3.f<T1, T2, T3, R> a;

        b(sdk.pendo.io.q3.f<T1, T2, T3, R> fVar) {
            this.a = fVar;
        }

        @Override // sdk.pendo.io.q3.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) {
            if (objArr.length != 3) {
                throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
            }
            return this.a.a((T1) objArr[0], (T2) objArr[1], (T3) objArr[2]);
        }
    }

    static final class c<T1, T2, T3, T4, R> implements sdk.pendo.io.q3.h<Object[], R> {
        final sdk.pendo.io.q3.g<T1, T2, T3, T4, R> a;

        c(sdk.pendo.io.q3.g<T1, T2, T3, T4, R> gVar) {
            this.a = gVar;
        }

        @Override // sdk.pendo.io.q3.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) {
            if (objArr.length != 4) {
                throw new IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
            }
            return this.a.a((T1) objArr[0], (T2) objArr[1], (T3) objArr[2], (T4) objArr[3]);
        }
    }

    static final class d implements sdk.pendo.io.q3.a {
        d() {
        }

        @Override // sdk.pendo.io.q3.a
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    static final class e implements sdk.pendo.io.q3.e<Object> {
        e() {
        }

        @Override // sdk.pendo.io.q3.e
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    static final class f implements sdk.pendo.io.q3.i {
        f() {
        }
    }

    static final class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    static final class h implements sdk.pendo.io.q3.e<Throwable> {
        h() {
        }

        @Override // sdk.pendo.io.q3.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            sdk.pendo.io.g4.a.b(th);
        }
    }

    static final class i implements sdk.pendo.io.q3.j<Object> {
        i() {
        }

        @Override // sdk.pendo.io.q3.j
        public boolean test(Object obj) {
            return false;
        }
    }

    static final class j implements sdk.pendo.io.q3.h<Object, Object> {
        j() {
        }

        @Override // sdk.pendo.io.q3.h
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    static final class k<T, U> implements Callable<U>, sdk.pendo.io.q3.h<T, U> {
        final U a;

        k(U u) {
            this.a = u;
        }

        @Override // sdk.pendo.io.q3.h
        public U apply(T t) {
            return this.a;
        }

        @Override // java.util.concurrent.Callable
        public U call() {
            return this.a;
        }
    }

    static final class l implements sdk.pendo.io.q3.e<sdk.pendo.io.j3.c> {
        l() {
        }

        @Override // sdk.pendo.io.q3.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(sdk.pendo.io.j3.c cVar) {
            cVar.request(Long.MAX_VALUE);
        }
    }

    static final class m implements Comparator<Object> {
        m() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    static final class n implements Callable<Object> {
        n() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    static final class o implements sdk.pendo.io.q3.e<Throwable> {
        o() {
        }

        @Override // sdk.pendo.io.q3.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            sdk.pendo.io.g4.a.b(new sdk.pendo.io.p3.d(th));
        }
    }

    static final class p implements sdk.pendo.io.q3.j<Object> {
        p() {
        }

        @Override // sdk.pendo.io.q3.j
        public boolean test(Object obj) {
            return true;
        }
    }

    public static <T> sdk.pendo.io.q3.e<T> a() {
        return (sdk.pendo.io.q3.e<T>) d;
    }

    public static <T> sdk.pendo.io.q3.h<T, T> b() {
        return (sdk.pendo.io.q3.h<T, T>) a;
    }

    public static <T> Callable<T> a(T t) {
        return new k(t);
    }

    public static <T1, T2, R> sdk.pendo.io.q3.h<Object[], R> a(sdk.pendo.io.q3.b<? super T1, ? super T2, ? extends R> bVar) {
        sdk.pendo.io.s3.b.a(bVar, "f is null");
        return new C0476a(bVar);
    }

    public static <T1, T2, T3, R> sdk.pendo.io.q3.h<Object[], R> a(sdk.pendo.io.q3.f<T1, T2, T3, R> fVar) {
        sdk.pendo.io.s3.b.a(fVar, "f is null");
        return new b(fVar);
    }

    public static <T1, T2, T3, T4, R> sdk.pendo.io.q3.h<Object[], R> a(sdk.pendo.io.q3.g<T1, T2, T3, T4, R> gVar) {
        sdk.pendo.io.s3.b.a(gVar, "f is null");
        return new c(gVar);
    }
}
