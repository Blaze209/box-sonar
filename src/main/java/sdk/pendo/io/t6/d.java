package sdk.pendo.io.t6;

import java.security.cert.CertPathValidatorException;
import java.util.NoSuchElementException;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.q3.e;

/* JADX INFO: loaded from: classes5.dex */
public final class d<T> extends sdk.pendo.io.f4.a<T> {
    private e<? super T> b;
    private e<Throwable> c;
    private sdk.pendo.io.q3.a d;
    private String e;

    public static final class a<T> {
        private e<Throwable> a = null;
        private sdk.pendo.io.q3.a b = null;
        private e<? super T> c = null;
        private String d = null;

        a<T> a(String str) {
            this.d = str;
            return this;
        }

        a<T> b(e<? super T> eVar) {
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

        d<T> a() {
            return new d<>(this.c, this.a, this.b, this.d);
        }
    }

    private d(e<? super T> eVar, e<Throwable> eVar2, sdk.pendo.io.q3.a aVar, String str) {
        this.b = eVar;
        this.c = eVar2;
        this.d = aVar;
        this.e = str;
    }

    public static <T> d<T> a(e<T> eVar, String str) {
        if (eVar != null) {
            return a(eVar, new sdk.pendo.io.q6.a(str), null, str);
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    @Override // sdk.pendo.io.k3.o
    public void onComplete() {
        sdk.pendo.io.q3.a aVar = this.d;
        if (aVar != null) {
            try {
                aVar.run();
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), this.e);
            }
        }
    }

    @Override // sdk.pendo.io.k3.o
    public void onError(Throwable th) {
        if (a(th) && !(this.c instanceof sdk.pendo.io.q6.a)) {
            sdk.pendo.io.s7.d.a(th, this.e);
        }
        e<Throwable> eVar = this.c;
        if (eVar != null) {
            try {
                eVar.accept(th);
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), this.e);
            }
        }
    }

    @Override // sdk.pendo.io.k3.o
    public void onNext(T t) {
        try {
            this.b.accept(t);
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), this.e);
        }
    }

    private static <T> d<T> a(e<T> eVar, e<Throwable> eVar2, sdk.pendo.io.q3.a aVar, String str) {
        return new a().b(eVar).a(eVar2).a(aVar).a(str).a();
    }

    public static boolean a(Throwable th) {
        return ((th instanceof NoSuchElementException) || (th instanceof CertPathValidatorException)) ? false : true;
    }
}
