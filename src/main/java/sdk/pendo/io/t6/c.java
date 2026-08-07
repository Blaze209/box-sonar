package sdk.pendo.io.t6;

import java.security.cert.CertPathValidatorException;
import java.util.NoSuchElementException;
import sdk.pendo.io.k3.h;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.q3.e;

/* JADX INFO: loaded from: classes5.dex */
public final class c<T> implements h<T> {
    private e<? super T> a;
    private e<Throwable> b;
    private sdk.pendo.io.q3.a c;
    private e<? super sdk.pendo.io.o3.b> d;
    private sdk.pendo.io.o3.b e;
    private String f;

    public static final class a<T> {
        private e<? super sdk.pendo.io.o3.b> d;
        private e<Throwable> a = null;
        private sdk.pendo.io.q3.a b = null;
        private e<? super T> c = null;
        private String e = null;

        a<T> a(String str) {
            this.e = str;
            return this;
        }

        a<T> b(e<? super sdk.pendo.io.o3.b> eVar) {
            this.d = eVar;
            return this;
        }

        a<T> c(e<? super T> eVar) {
            this.c = eVar;
            return this;
        }

        a<T> a(sdk.pendo.io.q3.a aVar) {
            this.b = aVar;
            return this;
        }

        a<T> a(e<Throwable> eVar) {
            this.a = eVar;
            return this;
        }

        c<T> a() {
            return new c<>(this.c, this.a, this.b, this.d, this.e);
        }
    }

    private c(e<? super T> eVar, e<Throwable> eVar2, sdk.pendo.io.q3.a aVar, e<? super sdk.pendo.io.o3.b> eVar3, String str) {
        this.a = eVar;
        this.b = eVar2;
        this.c = aVar;
        this.d = eVar3;
        this.f = str;
    }

    public static <T> c<T> a(e<T> eVar, String str) {
        if (eVar != null) {
            return a(eVar, new sdk.pendo.io.q6.a(str), null, null, str);
        }
        throw new IllegalArgumentException("onSuccess can not be null");
    }

    @Override // sdk.pendo.io.k3.h
    public void onComplete() {
        sdk.pendo.io.q3.a aVar = this.c;
        if (aVar != null) {
            try {
                aVar.run();
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), this.f);
            }
        }
    }

    @Override // sdk.pendo.io.k3.h
    public void onError(Throwable th) {
        if (a(th) && !(this.b instanceof sdk.pendo.io.q6.a)) {
            sdk.pendo.io.s7.d.a(th, this.f);
        }
        e<Throwable> eVar = this.b;
        if (eVar != null) {
            try {
                eVar.accept(th);
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), this.f);
            }
        }
    }

    @Override // sdk.pendo.io.k3.h
    public void onSubscribe(sdk.pendo.io.o3.b bVar) {
        this.e = bVar;
        e<? super sdk.pendo.io.o3.b> eVar = this.d;
        if (eVar != null) {
            try {
                eVar.accept(bVar);
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), this.f);
            }
        }
    }

    @Override // sdk.pendo.io.k3.h
    public void onSuccess(T t) {
        try {
            this.a.accept(t);
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), this.f);
        }
    }

    private static <T> c<T> a(e<T> eVar, e<Throwable> eVar2, sdk.pendo.io.q3.a aVar, e<? super sdk.pendo.io.o3.b> eVar3, String str) {
        return new a().c(eVar).a(eVar2).a(aVar).b(eVar3).a(str).a();
    }

    private boolean a(Throwable th) {
        return ((th instanceof NoSuchElementException) || (th instanceof CertPathValidatorException)) ? false : true;
    }
}
