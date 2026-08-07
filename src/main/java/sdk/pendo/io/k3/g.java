package sdk.pendo.io.k3;

/* JADX INFO: loaded from: classes4.dex */
public abstract class g<T> implements i<T> {
    public static <T> g<T> a() {
        return sdk.pendo.io.g4.a.a((g) sdk.pendo.io.x3.c.a);
    }

    public final g<T> b(p pVar) {
        sdk.pendo.io.s3.b.a(pVar, "scheduler is null");
        return sdk.pendo.io.g4.a.a(new sdk.pendo.io.x3.g(this, pVar));
    }

    protected abstract void b(h<? super T> hVar);

    public final <E extends h<? super T>> E c(E e) {
        a(e);
        return e;
    }

    public final g<T> a(sdk.pendo.io.q3.j<? super T> jVar) {
        sdk.pendo.io.s3.b.a(jVar, "predicate is null");
        return sdk.pendo.io.g4.a.a(new sdk.pendo.io.x3.d(this, jVar));
    }

    public final <R> g<R> a(sdk.pendo.io.q3.h<? super T, ? extends R> hVar) {
        sdk.pendo.io.s3.b.a(hVar, "mapper is null");
        return sdk.pendo.io.g4.a.a(new sdk.pendo.io.x3.e(this, hVar));
    }

    public final g<T> a(p pVar) {
        sdk.pendo.io.s3.b.a(pVar, "scheduler is null");
        return sdk.pendo.io.g4.a.a(new sdk.pendo.io.x3.f(this, pVar));
    }

    public final sdk.pendo.io.o3.b a(sdk.pendo.io.q3.e<? super T> eVar) {
        return a(eVar, sdk.pendo.io.s3.a.f, sdk.pendo.io.s3.a.c);
    }

    public final sdk.pendo.io.o3.b a(sdk.pendo.io.q3.e<? super T> eVar, sdk.pendo.io.q3.e<? super Throwable> eVar2) {
        return a(eVar, eVar2, sdk.pendo.io.s3.a.c);
    }

    public final sdk.pendo.io.o3.b a(sdk.pendo.io.q3.e<? super T> eVar, sdk.pendo.io.q3.e<? super Throwable> eVar2, sdk.pendo.io.q3.a aVar) {
        sdk.pendo.io.s3.b.a(eVar, "onSuccess is null");
        sdk.pendo.io.s3.b.a(eVar2, "onError is null");
        sdk.pendo.io.s3.b.a(aVar, "onComplete is null");
        return (sdk.pendo.io.o3.b) c(new sdk.pendo.io.x3.b(eVar, eVar2, aVar));
    }

    @Override // sdk.pendo.io.k3.i
    public final void a(h<? super T> hVar) {
        sdk.pendo.io.s3.b.a(hVar, "observer is null");
        h<? super T> hVarA = sdk.pendo.io.g4.a.a(this, hVar);
        sdk.pendo.io.s3.b.a(hVarA, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            b(hVarA);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            sdk.pendo.io.p3.b.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public static <T1, T2, R> g<R> a(i<? extends T1> iVar, i<? extends T2> iVar2, sdk.pendo.io.q3.b<? super T1, ? super T2, ? extends R> bVar) {
        sdk.pendo.io.s3.b.a(iVar, "source1 is null");
        sdk.pendo.io.s3.b.a(iVar2, "source2 is null");
        return a(sdk.pendo.io.s3.a.a((sdk.pendo.io.q3.b) bVar), iVar, iVar2);
    }

    public static <T, R> g<R> a(sdk.pendo.io.q3.h<? super Object[], ? extends R> hVar, i<? extends T>... iVarArr) {
        sdk.pendo.io.s3.b.a(iVarArr, "sources is null");
        if (iVarArr.length == 0) {
            return a();
        }
        sdk.pendo.io.s3.b.a(hVar, "zipper is null");
        return sdk.pendo.io.g4.a.a(new sdk.pendo.io.x3.h(iVarArr, hVar));
    }
}
