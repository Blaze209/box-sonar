package sdk.pendo.io.d4;

import java.io.Serializable;
import sdk.pendo.io.k3.o;

/* JADX INFO: loaded from: classes4.dex */
public enum i {
    COMPLETE;

    static final class a implements Serializable {
        final sdk.pendo.io.o3.b a;

        a(sdk.pendo.io.o3.b bVar) {
            this.a = bVar;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.a + "]";
        }
    }

    static final class b implements Serializable {
        final Throwable a;

        b(Throwable th) {
            this.a = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return sdk.pendo.io.s3.b.a(this.a, ((b) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.a + "]";
        }
    }

    static final class c implements Serializable {
        final sdk.pendo.io.j3.c a;

        public String toString() {
            return "NotificationLite.Subscription[" + this.a + "]";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T a(Object obj) {
        return obj;
    }

    public static <T> boolean a(Object obj, o<? super T> oVar) {
        if (obj == COMPLETE) {
            oVar.onComplete();
            return true;
        }
        if (obj instanceof b) {
            oVar.onError(((b) obj).a);
            return true;
        }
        oVar.onNext(obj);
        return false;
    }

    public static <T> boolean b(Object obj, o<? super T> oVar) {
        if (obj == COMPLETE) {
            oVar.onComplete();
            return true;
        }
        if (obj instanceof b) {
            oVar.onError(((b) obj).a);
            return true;
        }
        if (obj instanceof a) {
            oVar.onSubscribe(((a) obj).a);
            return false;
        }
        oVar.onNext(obj);
        return false;
    }

    public static boolean c(Object obj) {
        return obj instanceof b;
    }

    public static <T> Object d(T t) {
        return t;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    public static <T> boolean a(Object obj, sdk.pendo.io.j3.b<? super T> bVar) {
        if (obj == COMPLETE) {
            bVar.onComplete();
            return true;
        }
        if (obj instanceof b) {
            bVar.onError(((b) obj).a);
            return true;
        }
        if (obj instanceof c) {
            bVar.a(((c) obj).a);
            return false;
        }
        bVar.onNext(obj);
        return false;
    }

    public static boolean b(Object obj) {
        return obj == COMPLETE;
    }

    public static Object a() {
        return COMPLETE;
    }

    public static Object a(sdk.pendo.io.o3.b bVar) {
        return new a(bVar);
    }

    public static Object a(Throwable th) {
        return new b(th);
    }
}
