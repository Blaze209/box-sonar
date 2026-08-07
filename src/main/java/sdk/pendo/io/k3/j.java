package sdk.pendo.io.k3;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import sdk.pendo.io.y3.b0;
import sdk.pendo.io.y3.c0;
import sdk.pendo.io.y3.d0;
import sdk.pendo.io.y3.e0;
import sdk.pendo.io.y3.f0;
import sdk.pendo.io.y3.g0;
import sdk.pendo.io.y3.h0;
import sdk.pendo.io.y3.i0;
import sdk.pendo.io.y3.j0;
import sdk.pendo.io.y3.k0;
import sdk.pendo.io.y3.l0;
import sdk.pendo.io.y3.m0;
import sdk.pendo.io.y3.n0;
import sdk.pendo.io.y3.r;
import sdk.pendo.io.y3.s;
import sdk.pendo.io.y3.t;
import sdk.pendo.io.y3.u;
import sdk.pendo.io.y3.v;
import sdk.pendo.io.y3.w;
import sdk.pendo.io.y3.x;

/* JADX INFO: loaded from: classes4.dex */
public abstract class j<T> implements m<T> {

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[sdk.pendo.io.k3.a.values().length];
            a = iArr;
            try {
                iArr[sdk.pendo.io.k3.a.DROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[sdk.pendo.io.k3.a.LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[sdk.pendo.io.k3.a.MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[sdk.pendo.io.k3.a.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static int c() {
        return d.a();
    }

    public static <T> j<T> e() {
        return sdk.pendo.io.g4.a.a(sdk.pendo.io.y3.k.a);
    }

    public final <B> j<List<T>> a(m<B> mVar) {
        return (j<List<T>>) a(mVar, sdk.pendo.io.d4.b.a());
    }

    public final T b() {
        sdk.pendo.io.u3.e eVar = new sdk.pendo.io.u3.e();
        a((o) eVar);
        T tA = eVar.a();
        if (tA != null) {
            return tA;
        }
        throw new NoSuchElementException();
    }

    protected abstract void b(o<? super T> oVar);

    public final j<T> d() {
        return a((sdk.pendo.io.q3.h) sdk.pendo.io.s3.a.b());
    }

    public final g<T> f() {
        return a(0L);
    }

    public final b g() {
        return sdk.pendo.io.g4.a.a(new r(this));
    }

    public final sdk.pendo.io.e4.a<T> h() {
        return x.f(this);
    }

    public final j<T> i() {
        return h().m();
    }

    public final g<T> j() {
        return sdk.pendo.io.g4.a.a(new e0(this));
    }

    public final q<T> k() {
        return sdk.pendo.io.g4.a.a(new f0(this, null));
    }

    public static j<Long> d(long j, TimeUnit timeUnit) {
        return a(j, j, timeUnit, sdk.pendo.io.i4.a.a());
    }

    public static j<Long> f(long j, TimeUnit timeUnit) {
        return e(j, timeUnit, sdk.pendo.io.i4.a.a());
    }

    public final <B, U extends Collection<? super T>> j<U> a(m<B> mVar, Callable<U> callable) {
        sdk.pendo.io.s3.b.a(mVar, "boundary is null");
        sdk.pendo.io.s3.b.a(callable, "bufferSupplier is null");
        return sdk.pendo.io.g4.a.a(new sdk.pendo.io.y3.b(this, mVar, callable));
    }

    public final j<T> b(long j, TimeUnit timeUnit) {
        return a(j, timeUnit, sdk.pendo.io.i4.a.a(), false);
    }

    public final j<T> c(long j, TimeUnit timeUnit) {
        return b(j, timeUnit, sdk.pendo.io.i4.a.a());
    }

    public final j<T> e(sdk.pendo.io.q3.h<? super j<Throwable>, ? extends m<?>> hVar) {
        sdk.pendo.io.s3.b.a(hVar, "handler is null");
        return sdk.pendo.io.g4.a.a(new b0(this, hVar));
    }

    public static <T1, T2, T3, T4, R> j<R> a(m<? extends T1> mVar, m<? extends T2> mVar2, m<? extends T3> mVar3, m<? extends T4> mVar4, sdk.pendo.io.q3.g<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> gVar) {
        sdk.pendo.io.s3.b.a(mVar, "source1 is null");
        sdk.pendo.io.s3.b.a(mVar2, "source2 is null");
        sdk.pendo.io.s3.b.a(mVar3, "source3 is null");
        sdk.pendo.io.s3.b.a(mVar4, "source4 is null");
        return a(sdk.pendo.io.s3.a.a((sdk.pendo.io.q3.g) gVar), c(), mVar, mVar2, mVar3, mVar4);
    }

    public static j<Long> c(long j, TimeUnit timeUnit, p pVar) {
        return a(j, j, timeUnit, pVar);
    }

    public final j<T> b(long j, TimeUnit timeUnit, p pVar) {
        return b(e(j, timeUnit, pVar));
    }

    public final j<T> d(sdk.pendo.io.q3.h<? super Throwable, ? extends T> hVar) {
        sdk.pendo.io.s3.b.a(hVar, "valueSupplier is null");
        return sdk.pendo.io.g4.a.a(new w(this, hVar));
    }

    public final j<T> e(long j, TimeUnit timeUnit) {
        return d(j, timeUnit, sdk.pendo.io.i4.a.a());
    }

    public static <T1, T2, R> j<R> a(m<? extends T1> mVar, m<? extends T2> mVar2, sdk.pendo.io.q3.b<? super T1, ? super T2, ? extends R> bVar) {
        sdk.pendo.io.s3.b.a(mVar, "source1 is null");
        sdk.pendo.io.s3.b.a(mVar2, "source2 is null");
        return a(sdk.pendo.io.s3.a.a((sdk.pendo.io.q3.b) bVar), c(), mVar, mVar2);
    }

    public static j<Long> e(long j, TimeUnit timeUnit, p pVar) {
        sdk.pendo.io.s3.b.a(timeUnit, "unit is null");
        sdk.pendo.io.s3.b.a(pVar, "scheduler is null");
        return sdk.pendo.io.g4.a.a(new m0(Math.max(j, 0L), timeUnit, pVar));
    }

    public final <U> j<T> b(m<U> mVar) {
        sdk.pendo.io.s3.b.a(mVar, "other is null");
        return sdk.pendo.io.g4.a.a(new sdk.pendo.io.y3.g(this, mVar));
    }

    public final <R> j<R> c(sdk.pendo.io.q3.h<? super T, ? extends R> hVar) {
        sdk.pendo.io.s3.b.a(hVar, "mapper is null");
        return sdk.pendo.io.g4.a.a(new u(this, hVar));
    }

    public final <U> j<T> d(m<U> mVar) {
        sdk.pendo.io.s3.b.a(mVar, "other is null");
        return sdk.pendo.io.g4.a.a(new j0(this, mVar));
    }

    public static <T, R> j<R> a(sdk.pendo.io.q3.h<? super Object[], ? extends R> hVar, int i, m<? extends T>... mVarArr) {
        return a(mVarArr, hVar, i);
    }

    public static <T> j<T> e(m<T> mVar) {
        sdk.pendo.io.s3.b.a(mVar, "source is null");
        return mVar instanceof j ? sdk.pendo.io.g4.a.a((j) mVar) : sdk.pendo.io.g4.a.a(new sdk.pendo.io.y3.q(mVar));
    }

    public final <R> j<R> b(sdk.pendo.io.q3.h<? super T, ? extends m<? extends R>> hVar) {
        return a((sdk.pendo.io.q3.h) hVar, false);
    }

    public final j<T> c(m<? extends T> mVar) {
        sdk.pendo.io.s3.b.a(mVar, "other is null");
        return a(this, mVar);
    }

    public final j<T> d(long j, TimeUnit timeUnit, p pVar) {
        sdk.pendo.io.s3.b.a(timeUnit, "unit is null");
        sdk.pendo.io.s3.b.a(pVar, "scheduler is null");
        return sdk.pendo.io.g4.a.a(new l0(this, j, timeUnit, pVar));
    }

    public static <T, R> j<R> a(m<? extends T>[] mVarArr, sdk.pendo.io.q3.h<? super Object[], ? extends R> hVar, int i) {
        sdk.pendo.io.s3.b.a(mVarArr, "sources is null");
        if (mVarArr.length == 0) {
            return e();
        }
        sdk.pendo.io.s3.b.a(hVar, "combiner is null");
        sdk.pendo.io.s3.b.a(i, "bufferSize");
        return sdk.pendo.io.g4.a.a(new sdk.pendo.io.y3.c(mVarArr, null, hVar, i << 1, false));
    }

    public final j<T> b(long j) {
        return j <= 0 ? sdk.pendo.io.g4.a.a(this) : sdk.pendo.io.g4.a.a(new g0(this, j));
    }

    public final <E extends o<? super T>> E c(E e) {
        a((o) e);
        return e;
    }

    public final <R> j<R> a(n<? super T, ? extends R> nVar) {
        return e(((n) sdk.pendo.io.s3.b.a(nVar, "composer is null")).a(this));
    }

    public final sdk.pendo.io.o3.b b(sdk.pendo.io.q3.e<? super T> eVar) {
        return a(eVar, sdk.pendo.io.s3.a.f, sdk.pendo.io.s3.a.c, sdk.pendo.io.s3.a.a());
    }

    public final j<T> c(long j) {
        if (j >= 0) {
            return sdk.pendo.io.g4.a.a(new i0(this, j));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j);
    }

    public static <T> j<T> a(l<T> lVar) {
        sdk.pendo.io.s3.b.a(lVar, "source is null");
        return sdk.pendo.io.g4.a.a(new sdk.pendo.io.y3.d(lVar));
    }

    public final j<T> b(p pVar) {
        sdk.pendo.io.s3.b.a(pVar, "scheduler is null");
        return sdk.pendo.io.g4.a.a(new h0(this, pVar));
    }

    public final j<T> a(long j, TimeUnit timeUnit) {
        return a(j, timeUnit, sdk.pendo.io.i4.a.a());
    }

    public final j<T> b(sdk.pendo.io.q3.j<? super T> jVar) {
        sdk.pendo.io.s3.b.a(jVar, "predicate is null");
        return sdk.pendo.io.g4.a.a(new k0(this, jVar));
    }

    public final j<T> a(long j, TimeUnit timeUnit, p pVar) {
        sdk.pendo.io.s3.b.a(timeUnit, "unit is null");
        sdk.pendo.io.s3.b.a(pVar, "scheduler is null");
        return sdk.pendo.io.g4.a.a(new sdk.pendo.io.y3.e(this, j, timeUnit, pVar));
    }

    public final j<T> a(long j, TimeUnit timeUnit, p pVar, boolean z) {
        sdk.pendo.io.s3.b.a(timeUnit, "unit is null");
        sdk.pendo.io.s3.b.a(pVar, "scheduler is null");
        return sdk.pendo.io.g4.a.a(new sdk.pendo.io.y3.f(this, j, timeUnit, pVar, z));
    }

    public final <K> j<T> a(sdk.pendo.io.q3.h<? super T, K> hVar) {
        sdk.pendo.io.s3.b.a(hVar, "keySelector is null");
        return sdk.pendo.io.g4.a.a(new sdk.pendo.io.y3.h(this, hVar, sdk.pendo.io.s3.b.a()));
    }

    public final j<T> a(sdk.pendo.io.q3.a aVar) {
        return a(sdk.pendo.io.s3.a.a(), sdk.pendo.io.s3.a.a(), aVar, sdk.pendo.io.s3.a.c);
    }

    private j<T> a(sdk.pendo.io.q3.e<? super T> eVar, sdk.pendo.io.q3.e<? super Throwable> eVar2, sdk.pendo.io.q3.a aVar, sdk.pendo.io.q3.a aVar2) {
        sdk.pendo.io.s3.b.a(eVar, "onNext is null");
        sdk.pendo.io.s3.b.a(eVar2, "onError is null");
        sdk.pendo.io.s3.b.a(aVar, "onComplete is null");
        sdk.pendo.io.s3.b.a(aVar2, "onAfterTerminate is null");
        return sdk.pendo.io.g4.a.a(new sdk.pendo.io.y3.i(this, eVar, eVar2, aVar, aVar2));
    }

    public final j<T> a(sdk.pendo.io.q3.e<? super T> eVar) {
        sdk.pendo.io.q3.e<? super Throwable> eVarA = sdk.pendo.io.s3.a.a();
        sdk.pendo.io.q3.a aVar = sdk.pendo.io.s3.a.c;
        return a(eVar, eVarA, aVar, aVar);
    }

    public final g<T> a(long j) {
        if (j >= 0) {
            return sdk.pendo.io.g4.a.a(new sdk.pendo.io.y3.j(this, j));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j);
    }

    public static <T> j<T> a(Throwable th) {
        sdk.pendo.io.s3.b.a(th, "exception is null");
        return a((Callable<? extends Throwable>) sdk.pendo.io.s3.a.a(th));
    }

    public static <T> j<T> a(Callable<? extends Throwable> callable) {
        sdk.pendo.io.s3.b.a(callable, "errorSupplier is null");
        return sdk.pendo.io.g4.a.a(new sdk.pendo.io.y3.l(callable));
    }

    public final j<T> a(sdk.pendo.io.q3.j<? super T> jVar) {
        sdk.pendo.io.s3.b.a(jVar, "predicate is null");
        return sdk.pendo.io.g4.a.a(new sdk.pendo.io.y3.m(this, jVar));
    }

    public final <R> j<R> a(sdk.pendo.io.q3.h<? super T, ? extends m<? extends R>> hVar, int i) {
        return a((sdk.pendo.io.q3.h) hVar, false, i, c());
    }

    public final <R> j<R> a(sdk.pendo.io.q3.h<? super T, ? extends m<? extends R>> hVar, boolean z) {
        return a(hVar, z, Integer.MAX_VALUE);
    }

    public final <R> j<R> a(sdk.pendo.io.q3.h<? super T, ? extends m<? extends R>> hVar, boolean z, int i) {
        return a(hVar, z, i, c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> j<R> a(sdk.pendo.io.q3.h<? super T, ? extends m<? extends R>> hVar, boolean z, int i, int i2) {
        sdk.pendo.io.s3.b.a(hVar, "mapper is null");
        sdk.pendo.io.s3.b.a(i, "maxConcurrency");
        sdk.pendo.io.s3.b.a(i2, "bufferSize");
        if (!(this instanceof sdk.pendo.io.t3.e)) {
            return sdk.pendo.io.g4.a.a(new sdk.pendo.io.y3.n(this, hVar, z, i, i2));
        }
        Object objCall = ((sdk.pendo.io.t3.e) this).call();
        return objCall == null ? e() : c0.a(objCall, hVar);
    }

    public static <T> j<T> a(T... tArr) {
        sdk.pendo.io.s3.b.a(tArr, "items is null");
        if (tArr.length == 0) {
            return e();
        }
        return tArr.length == 1 ? a(tArr[0]) : sdk.pendo.io.g4.a.a(new sdk.pendo.io.y3.o(tArr));
    }

    public static <T> j<T> a(Iterable<? extends T> iterable) {
        sdk.pendo.io.s3.b.a(iterable, "source is null");
        return sdk.pendo.io.g4.a.a(new sdk.pendo.io.y3.p(iterable));
    }

    public static j<Long> a(long j, long j2, TimeUnit timeUnit, p pVar) {
        sdk.pendo.io.s3.b.a(timeUnit, "unit is null");
        sdk.pendo.io.s3.b.a(pVar, "scheduler is null");
        return sdk.pendo.io.g4.a.a(new s(Math.max(0L, j), Math.max(0L, j2), timeUnit, pVar));
    }

    public static <T> j<T> a(T t) {
        sdk.pendo.io.s3.b.a((Object) t, "item is null");
        return sdk.pendo.io.g4.a.a((j) new t(t));
    }

    public static <T> j<T> a(m<? extends T> mVar, m<? extends T> mVar2) {
        sdk.pendo.io.s3.b.a(mVar, "source1 is null");
        sdk.pendo.io.s3.b.a(mVar2, "source2 is null");
        return a((Object[]) new m[]{mVar, mVar2}).a(sdk.pendo.io.s3.a.b(), false, 2);
    }

    public static <T> j<T> a(m<? extends T> mVar, m<? extends T> mVar2, m<? extends T> mVar3, m<? extends T> mVar4) {
        sdk.pendo.io.s3.b.a(mVar, "source1 is null");
        sdk.pendo.io.s3.b.a(mVar2, "source2 is null");
        sdk.pendo.io.s3.b.a(mVar3, "source3 is null");
        sdk.pendo.io.s3.b.a(mVar4, "source4 is null");
        return a((Object[]) new m[]{mVar, mVar2, mVar3, mVar4}).a(sdk.pendo.io.s3.a.b(), false, 4);
    }

    public static <T> j<T> a(m<? extends T>... mVarArr) {
        return a((Object[]) mVarArr).a(sdk.pendo.io.s3.a.b(), mVarArr.length);
    }

    public final j<T> a(p pVar) {
        return a(pVar, false, c());
    }

    public final j<T> a(p pVar, boolean z, int i) {
        sdk.pendo.io.s3.b.a(pVar, "scheduler is null");
        sdk.pendo.io.s3.b.a(i, "bufferSize");
        return sdk.pendo.io.g4.a.a(new v(this, pVar, z, i));
    }

    public final j<T> a(sdk.pendo.io.q3.b<T, T, T> bVar) {
        sdk.pendo.io.s3.b.a(bVar, "accumulator is null");
        return sdk.pendo.io.g4.a.a(new d0(this, bVar));
    }

    public final sdk.pendo.io.o3.b a(sdk.pendo.io.q3.e<? super T> eVar, sdk.pendo.io.q3.e<? super Throwable> eVar2) {
        return a(eVar, eVar2, sdk.pendo.io.s3.a.c, sdk.pendo.io.s3.a.a());
    }

    public final sdk.pendo.io.o3.b a(sdk.pendo.io.q3.e<? super T> eVar, sdk.pendo.io.q3.e<? super Throwable> eVar2, sdk.pendo.io.q3.a aVar, sdk.pendo.io.q3.e<? super sdk.pendo.io.o3.b> eVar3) {
        sdk.pendo.io.s3.b.a(eVar, "onNext is null");
        sdk.pendo.io.s3.b.a(eVar2, "onError is null");
        sdk.pendo.io.s3.b.a(aVar, "onComplete is null");
        sdk.pendo.io.s3.b.a(eVar3, "onSubscribe is null");
        sdk.pendo.io.u3.f fVar = new sdk.pendo.io.u3.f(eVar, eVar2, aVar, eVar3);
        a((o) fVar);
        return fVar;
    }

    @Override // sdk.pendo.io.k3.m
    public final void a(o<? super T> oVar) {
        sdk.pendo.io.s3.b.a(oVar, "observer is null");
        try {
            o<? super T> oVarA = sdk.pendo.io.g4.a.a(this, oVar);
            sdk.pendo.io.s3.b.a(oVarA, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            b(oVarA);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            sdk.pendo.io.p3.b.b(th);
            sdk.pendo.io.g4.a.b(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final d<T> a(sdk.pendo.io.k3.a aVar) {
        sdk.pendo.io.w3.f fVar = new sdk.pendo.io.w3.f(this);
        int i = a.a[aVar.ordinal()];
        if (i == 1) {
            return fVar.d();
        }
        if (i == 2) {
            return fVar.e();
        }
        if (i != 3) {
            return i != 4 ? fVar.c() : sdk.pendo.io.g4.a.a(new sdk.pendo.io.w3.k(fVar));
        }
        return fVar;
    }

    public static <T1, T2, T3, R> j<R> a(m<? extends T1> mVar, m<? extends T2> mVar2, m<? extends T3> mVar3, sdk.pendo.io.q3.f<? super T1, ? super T2, ? super T3, ? extends R> fVar) {
        sdk.pendo.io.s3.b.a(mVar, "source1 is null");
        sdk.pendo.io.s3.b.a(mVar2, "source2 is null");
        sdk.pendo.io.s3.b.a(mVar3, "source3 is null");
        return a(sdk.pendo.io.s3.a.a((sdk.pendo.io.q3.f) fVar), false, c(), mVar, mVar2, mVar3);
    }

    public static <T, R> j<R> a(sdk.pendo.io.q3.h<? super Object[], ? extends R> hVar, boolean z, int i, m<? extends T>... mVarArr) {
        if (mVarArr.length == 0) {
            return e();
        }
        sdk.pendo.io.s3.b.a(hVar, "zipper is null");
        sdk.pendo.io.s3.b.a(i, "bufferSize");
        return sdk.pendo.io.g4.a.a(new n0(mVarArr, null, hVar, i, z));
    }
}
