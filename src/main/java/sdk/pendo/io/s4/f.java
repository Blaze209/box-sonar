package sdk.pendo.io.s4;

import java.lang.reflect.Type;
import sdk.pendo.io.k3.j;
import sdk.pendo.io.k3.p;

/* JADX INFO: loaded from: classes5.dex */
final class f<R> implements sdk.pendo.io.l4.c<R, Object> {
    private final Type a;
    private final p b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;

    f(Type type, p pVar, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.a = type;
        this.b = pVar;
        this.c = z;
        this.d = z2;
        this.e = z3;
        this.f = z4;
        this.g = z5;
        this.h = z6;
        this.i = z7;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0028  */
    /* JADX WARN: Code duplicated, block: B:18:0x0030  */
    /* JADX WARN: Code duplicated, block: B:20:0x0037  */
    /* JADX WARN: Code duplicated, block: B:22:0x003b  */
    /* JADX WARN: Code duplicated, block: B:24:0x0040  */
    /* JADX WARN: Code duplicated, block: B:26:0x0044  */
    /* JADX WARN: Code duplicated, block: B:28:0x0049  */
    /* JADX WARN: Code duplicated, block: B:30:0x004d  */
    /* JADX WARN: Code duplicated, block: B:32:0x0052 A[RETURN] */
    @Override // sdk.pendo.io.l4.c
    public Object a(sdk.pendo.io.l4.b<R> bVar) {
        j aVar;
        p pVar;
        j bVar2 = this.c ? new b(bVar) : new c(bVar);
        if (!this.d) {
            if (this.e) {
                aVar = new a(bVar2);
            }
            pVar = this.b;
            if (pVar != null) {
                bVar2 = bVar2.b(pVar);
            }
            if (this.f) {
                return bVar2.a(sdk.pendo.io.k3.a.LATEST);
            }
            if (this.g) {
                return bVar2.k();
            }
            if (this.h) {
                return bVar2.j();
            }
            if (this.i) {
                return bVar2.g();
            }
            return bVar2;
        }
        aVar = new e(bVar2);
        bVar2 = aVar;
        pVar = this.b;
        if (pVar != null) {
            bVar2 = bVar2.b(pVar);
        }
        if (this.f) {
            return bVar2.a(sdk.pendo.io.k3.a.LATEST);
        }
        if (this.g) {
            return bVar2.k();
        }
        if (this.h) {
            return bVar2.j();
        }
        if (this.i) {
            return bVar2.g();
        }
        return bVar2;
    }

    @Override // sdk.pendo.io.l4.c
    public Type a() {
        return this.a;
    }
}
