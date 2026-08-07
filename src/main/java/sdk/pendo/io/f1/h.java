package sdk.pendo.io.f1;

import sdk.pendo.io.d1.l;

/* JADX INFO: loaded from: classes4.dex */
public class h extends c {
    private static final sdk.pendo.io.v4.a d = sdk.pendo.io.v4.b.a((Class<?>) h.class);
    private final j a;
    private final i b;
    private final j c;

    public h(j jVar, i iVar, j jVar2) {
        this.a = jVar;
        this.b = iVar;
        this.c = jVar2;
        d.a("ExpressionNode {}", toString());
    }

    @Override // sdk.pendo.io.d1.l
    public boolean a(l.a aVar) {
        j jVarB = this.a;
        j jVarB2 = this.c;
        if (jVarB.n()) {
            jVarB = this.a.e().b(aVar);
        }
        if (this.c.n()) {
            jVarB2 = this.c.e().b(aVar);
        }
        a aVarA = b.a(this.b);
        if (aVarA != null) {
            return aVarA.a(jVarB, jVarB2, aVar);
        }
        return false;
    }

    public String toString() {
        return this.b == i.EXISTS ? this.a.toString() : this.a.toString() + " " + this.b.toString() + " " + this.c.toString();
    }
}
