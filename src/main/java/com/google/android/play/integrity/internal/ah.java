package com.google.android.play.integrity.internal;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.2.0 */
/* JADX INFO: loaded from: classes13.dex */
public final class ah implements al {
    private static final Object a = new Object();
    private volatile al b;
    private volatile Object c = a;

    private ah(al alVar) {
        this.b = alVar;
    }

    public static al b(al alVar) {
        return alVar instanceof ah ? alVar : new ah(alVar);
    }

    @Override // com.google.android.play.integrity.internal.al
    public final Object a() {
        Object objA;
        Object obj = this.c;
        Object obj2 = a;
        if (obj != obj2) {
            return obj;
        }
        synchronized (this) {
            objA = this.c;
            if (objA == obj2) {
                objA = this.b.a();
                Object obj3 = this.c;
                if (obj3 != obj2 && obj3 != objA) {
                    throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + objA + ". This is likely due to a circular dependency.");
                }
                this.c = objA;
                this.b = null;
            }
        }
        return objA;
    }
}
