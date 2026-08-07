package sdk.pendo.io.s4;

import sdk.pendo.io.l4.r;

/* JADX INFO: loaded from: classes5.dex */
public final class d<T> {
    private final r<T> a;
    private final Throwable b;

    private d(r<T> rVar, Throwable th) {
        this.a = rVar;
        this.b = th;
    }

    public static <T> d<T> a(Throwable th) {
        if (th != null) {
            return new d<>(null, th);
        }
        throw new NullPointerException("error == null");
    }

    public static <T> d<T> a(r<T> rVar) {
        if (rVar != null) {
            return new d<>(rVar, null);
        }
        throw new NullPointerException("response == null");
    }
}
