package sdk.pendo.io.l5;

import sdk.pendo.io.l5.i;

/* JADX INFO: loaded from: classes4.dex */
public class d<C extends i> {
    private b<C> a;

    public static class a {
        private c a;

        private a(c cVar) {
            this.a = cVar;
        }

        public j a(h hVar) {
            return new j(this.a, hVar, false);
        }
    }

    private d(h hVar) {
        this.a = new b<>(hVar);
    }

    public static <C extends i> d<C> a(h hVar) {
        return new d<>(hVar);
    }

    public static a a(c cVar) {
        return new a(cVar);
    }

    public <C1 extends i> b<C1> a(boolean z, j... jVarArr) {
        for (j jVar : jVarArr) {
            jVar.a(this.a.a());
        }
        this.a.a(z);
        return this.a;
    }

    public <C1 extends i> b<C1> a(j... jVarArr) {
        return a(false, jVarArr);
    }
}
