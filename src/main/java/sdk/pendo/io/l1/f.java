package sdk.pendo.io.l1;

import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class f implements sdk.pendo.io.e1.g {
    private static final sdk.pendo.io.v4.a c = sdk.pendo.io.v4.b.a((Class<?>) f.class);
    private final p a;
    private final boolean b;

    public f(p pVar, boolean z) {
        this.a = a(pVar);
        this.b = z;
    }

    @Override // sdk.pendo.io.e1.g
    public sdk.pendo.io.e1.d a(Object obj, Object obj2, sdk.pendo.io.d1.a aVar) {
        return a(obj, obj2, aVar, false);
    }

    @Override // sdk.pendo.io.e1.g
    public boolean b() {
        return this.b;
    }

    @Override // sdk.pendo.io.e1.g
    public boolean c() {
        return this.a.c();
    }

    public String toString() {
        return this.a.toString();
    }

    public sdk.pendo.io.e1.d a(Object obj, Object obj2, sdk.pendo.io.d1.a aVar, boolean z) {
        sdk.pendo.io.v4.a aVar2 = c;
        if (aVar2.a()) {
            aVar2.b("Evaluating path: {}", toString());
        }
        g gVar = new g(this, obj2, aVar, z);
        try {
            this.a.a("", gVar.c() ? sdk.pendo.io.e1.h.a(obj2) : sdk.pendo.io.e1.h.b, obj, gVar);
        } catch (sdk.pendo.io.e1.c unused) {
        }
        return gVar;
    }

    private p a(p pVar) {
        if (pVar.i() && (pVar.g() instanceof q)) {
            j jVar = null;
            j jVarG = pVar;
            while (true) {
                jVarG = jVarG.g();
                if (jVarG == null || (jVarG instanceof h)) {
                    break;
                }
                jVar = jVarG;
            }
            if (jVarG instanceof h) {
                jVar.b(null);
                pVar.d(jVar);
                sdk.pendo.io.g1.b bVar = new sdk.pendo.io.g1.b();
                bVar.a(new f(pVar, true));
                bVar.a(sdk.pendo.io.g1.a.PATH);
                ((h) jVarG).a(Arrays.asList(bVar));
                p pVar2 = new p('$');
                pVar2.d(jVarG);
                pVar2.b(jVarG);
                return pVar2;
            }
        }
        return pVar;
    }

    @Override // sdk.pendo.io.e1.g
    public boolean a() {
        return this.a.i();
    }
}
