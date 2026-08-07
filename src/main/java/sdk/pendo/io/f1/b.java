package sdk.pendo.io.f1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class b {
    private static final Map<sdk.pendo.io.f1.i, sdk.pendo.io.f1.a> a;

    private static class a implements sdk.pendo.io.f1.a {
        private a() {
        }

        @Override // sdk.pendo.io.f1.a
        public boolean a(sdk.pendo.io.f1.j jVar, sdk.pendo.io.f1.j jVar2, sdk.pendo.io.d1.l.a aVar) {
            sdk.pendo.io.f1.k.C0383k c0383kI = jVar2.i();
            if (!jVar.l()) {
                return false;
            }
            sdk.pendo.io.f1.j jVarB = jVar.c().b(aVar);
            if (!jVarB.r()) {
                return true;
            }
            sdk.pendo.io.f1.k.C0383k c0383kI2 = jVarB.i();
            Iterator<sdk.pendo.io.f1.j> it = c0383kI.iterator();
            while (it.hasNext()) {
                if (!c0383kI2.a(it.next())) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.f1.b$b, reason: collision with other inner class name */
    private static class C0382b implements sdk.pendo.io.f1.a {
        private C0382b() {
        }

        @Override // sdk.pendo.io.f1.a
        public boolean a(sdk.pendo.io.f1.j jVar, sdk.pendo.io.f1.j jVar2, sdk.pendo.io.d1.l.a aVar) {
            sdk.pendo.io.f1.k.C0383k c0383kI;
            if (jVar2.l()) {
                sdk.pendo.io.f1.j jVarB = jVar2.c().b(aVar);
                if (jVarB.q()) {
                    return false;
                }
                c0383kI = jVarB.i();
            } else {
                c0383kI = jVar2.i();
            }
            if (jVar.l()) {
                jVar = jVar.c().b(aVar);
                if (jVar.q()) {
                    return false;
                }
            }
            for (sdk.pendo.io.f1.j jVar3 : jVar.i()) {
                Iterator<sdk.pendo.io.f1.j> it = c0383kI.iterator();
                while (it.hasNext()) {
                    if (jVar3.equals(it.next())) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private static class c implements sdk.pendo.io.f1.a {
        private c() {
        }

        @Override // sdk.pendo.io.f1.a
        public boolean a(sdk.pendo.io.f1.j jVar, sdk.pendo.io.f1.j jVar2, sdk.pendo.io.d1.l.a aVar) {
            if (jVar.p() && jVar2.p()) {
                return jVar.h().a(jVar2.h().s());
            }
            if (!jVar.l()) {
                return false;
            }
            sdk.pendo.io.f1.j jVarB = jVar.c().b(aVar);
            if (jVarB.q()) {
                return false;
            }
            return jVarB.i().a(jVar2);
        }
    }

    private static class d implements sdk.pendo.io.f1.a {
        private d() {
        }

        @Override // sdk.pendo.io.f1.a
        public boolean a(sdk.pendo.io.f1.j jVar, sdk.pendo.io.f1.j jVar2, sdk.pendo.io.d1.l.a aVar) {
            if (jVar.p()) {
                return jVar.h().isEmpty() == jVar2.a().s();
            }
            return jVar.l() && jVar.c().d(aVar) == jVar2.a().s();
        }
    }

    private static class e implements sdk.pendo.io.f1.a {
        private e() {
        }

        @Override // sdk.pendo.io.f1.a
        public boolean a(sdk.pendo.io.f1.j jVar, sdk.pendo.io.f1.j jVar2, sdk.pendo.io.d1.l.a aVar) {
            return (jVar.l() && jVar2.l()) ? jVar.c().a(jVar2.c(), aVar) : jVar.equals(jVar2);
        }
    }

    private static class f implements sdk.pendo.io.f1.a {
        private f() {
        }

        @Override // sdk.pendo.io.f1.a
        public boolean a(sdk.pendo.io.f1.j jVar, sdk.pendo.io.f1.j jVar2, sdk.pendo.io.d1.l.a aVar) {
            if (jVar.k() || jVar2.k()) {
                return jVar.a().s() == jVar2.a().s();
            }
            throw new sdk.pendo.io.d1.h("Failed to evaluate exists expression");
        }
    }

    private static class g implements sdk.pendo.io.f1.a {
        private g() {
        }

        @Override // sdk.pendo.io.f1.a
        public boolean a(sdk.pendo.io.f1.j jVar, sdk.pendo.io.f1.j jVar2, sdk.pendo.io.d1.l.a aVar) {
            if (jVar.m() && jVar2.m()) {
                return jVar.d().s().compareTo(jVar2.d().s()) >= 0;
            }
            sdk.pendo.io.f1.k.e eVarD = jVar.d();
            sdk.pendo.io.f1.k.e eVarD2 = jVar2.d();
            return (eVarD.s() == null || eVarD2.s() == null || eVarD.s().compareTo(eVarD2.s()) < 0) ? false : true;
        }
    }

    private static class h implements sdk.pendo.io.f1.a {
        private h() {
        }

        @Override // sdk.pendo.io.f1.a
        public boolean a(sdk.pendo.io.f1.j jVar, sdk.pendo.io.f1.j jVar2, sdk.pendo.io.d1.l.a aVar) {
            if (jVar.m() && jVar2.m()) {
                return jVar.d().s().compareTo(jVar2.d().s()) > 0;
            }
            sdk.pendo.io.f1.k.e eVarD = jVar.d();
            sdk.pendo.io.f1.k.e eVarD2 = jVar2.d();
            return (eVarD.s() == null || eVarD2.s() == null || eVarD.s().compareTo(eVarD2.s()) <= 0) ? false : true;
        }
    }

    private static class i implements sdk.pendo.io.f1.a {
        private i() {
        }

        @Override // sdk.pendo.io.f1.a
        public boolean a(sdk.pendo.io.f1.j jVar, sdk.pendo.io.f1.j jVar2, sdk.pendo.io.d1.l.a aVar) {
            sdk.pendo.io.f1.k.C0383k c0383kI;
            if (jVar2.l()) {
                sdk.pendo.io.f1.j jVarB = jVar2.c().b(aVar);
                if (jVarB.q()) {
                    return false;
                }
                c0383kI = jVarB.i();
            } else {
                try {
                    c0383kI = jVar2.i();
                } catch (sdk.pendo.io.d1.f unused) {
                    return false;
                }
            }
            return c0383kI.a(jVar);
        }
    }

    private static class j implements sdk.pendo.io.f1.a {
        private j() {
        }

        @Override // sdk.pendo.io.f1.a
        public boolean a(sdk.pendo.io.f1.j jVar, sdk.pendo.io.f1.j jVar2, sdk.pendo.io.d1.l.a aVar) {
            if (jVar.m() && jVar2.m()) {
                return jVar.d().s().compareTo(jVar2.d().s()) <= 0;
            }
            sdk.pendo.io.f1.k.e eVarD = jVar.d();
            sdk.pendo.io.f1.k.e eVarD2 = jVar2.d();
            return (eVarD.s() == null || eVarD2.s() == null || eVarD.s().compareTo(eVarD2.s()) > 0) ? false : true;
        }
    }

    private static class k implements sdk.pendo.io.f1.a {
        private k() {
        }

        @Override // sdk.pendo.io.f1.a
        public boolean a(sdk.pendo.io.f1.j jVar, sdk.pendo.io.f1.j jVar2, sdk.pendo.io.d1.l.a aVar) {
            if (jVar.m() && jVar2.m()) {
                return jVar.d().s().compareTo(jVar2.d().s()) < 0;
            }
            sdk.pendo.io.f1.k.e eVarD = jVar.d();
            sdk.pendo.io.f1.k.e eVarD2 = jVar2.d();
            return (eVarD.s() == null || eVarD2.s() == null || eVarD.s().compareTo(eVarD2.s()) >= 0) ? false : true;
        }
    }

    private static class l implements sdk.pendo.io.f1.a {
        private l() {
        }

        @Override // sdk.pendo.io.f1.a
        public boolean a(sdk.pendo.io.f1.j jVar, sdk.pendo.io.f1.j jVar2, sdk.pendo.io.d1.l.a aVar) {
            sdk.pendo.io.f1.k.C0383k c0383kI;
            if (jVar2.l()) {
                sdk.pendo.io.f1.j jVarB = jVar2.c().b(aVar);
                if (jVarB.q()) {
                    return false;
                }
                c0383kI = jVarB.i();
            } else {
                c0383kI = jVar2.i();
            }
            if (jVar.l()) {
                jVar = jVar.c().b(aVar);
                if (jVar.q()) {
                    return false;
                }
            }
            for (sdk.pendo.io.f1.j jVar3 : jVar.i()) {
                Iterator<sdk.pendo.io.f1.j> it = c0383kI.iterator();
                while (it.hasNext()) {
                    if (jVar3.equals(it.next())) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    private static class m implements sdk.pendo.io.f1.a {
        private m() {
        }

        @Override // sdk.pendo.io.f1.a
        public boolean a(sdk.pendo.io.f1.j jVar, sdk.pendo.io.f1.j jVar2, sdk.pendo.io.d1.l.a aVar) {
            return !((sdk.pendo.io.f1.a) b.a.get(sdk.pendo.io.f1.i.EQ)).a(jVar, jVar2, aVar);
        }
    }

    private static class n implements sdk.pendo.io.f1.a {
        private n() {
        }

        @Override // sdk.pendo.io.f1.a
        public boolean a(sdk.pendo.io.f1.j jVar, sdk.pendo.io.f1.j jVar2, sdk.pendo.io.d1.l.a aVar) {
            return !((sdk.pendo.io.f1.a) b.a.get(sdk.pendo.io.f1.i.IN)).a(jVar, jVar2, aVar);
        }
    }

    private static class o implements sdk.pendo.io.f1.a {
        private o() {
        }

        @Override // sdk.pendo.io.f1.a
        public boolean a(sdk.pendo.io.f1.j jVar, sdk.pendo.io.f1.j jVar2, sdk.pendo.io.d1.l.a aVar) {
            jVar2.g();
            throw null;
        }
    }

    private static class p implements sdk.pendo.io.f1.a {
        private p() {
        }

        @Override // sdk.pendo.io.f1.a
        public boolean a(sdk.pendo.io.f1.j jVar, sdk.pendo.io.f1.j jVar2, sdk.pendo.io.d1.l.a aVar) {
            if (jVar.o() ^ jVar2.o()) {
                return jVar.o() ? a(jVar.f(), a(jVar2)) : a(jVar2.f(), a(jVar));
            }
            return false;
        }

        private String a(sdk.pendo.io.f1.j jVar) {
            if (jVar.p() || jVar.m()) {
                return jVar.h().s();
            }
            return jVar.k() ? jVar.a().toString() : "";
        }

        private boolean a(sdk.pendo.io.f1.k.g gVar, String str) {
            return gVar.s().matcher(str).matches();
        }
    }

    private static class q implements sdk.pendo.io.f1.a {
        private q() {
        }

        @Override // sdk.pendo.io.f1.a
        public boolean a(sdk.pendo.io.f1.j jVar, sdk.pendo.io.f1.j jVar2, sdk.pendo.io.d1.l.a aVar) {
            if (!jVar2.m()) {
                return false;
            }
            int iIntValue = jVar2.d().s().intValue();
            if (jVar.p()) {
                return jVar.h().t() == iIntValue;
            }
            return jVar.l() && jVar.c().f(aVar) == iIntValue;
        }
    }

    private static class r implements sdk.pendo.io.f1.a {
        private r() {
        }

        @Override // sdk.pendo.io.f1.a
        public boolean a(sdk.pendo.io.f1.j jVar, sdk.pendo.io.f1.j jVar2, sdk.pendo.io.d1.l.a aVar) {
            sdk.pendo.io.f1.k.C0383k c0383kI;
            if (jVar2.l()) {
                sdk.pendo.io.f1.j jVarB = jVar2.c().b(aVar);
                if (jVarB.q()) {
                    return false;
                }
                c0383kI = jVarB.i();
            } else {
                c0383kI = jVar2.i();
            }
            if (jVar.l()) {
                jVar = jVar.c().b(aVar);
                if (jVar.q()) {
                    return false;
                }
            }
            return jVar.i().a(c0383kI);
        }
    }

    private static class s implements sdk.pendo.io.f1.a {
        private s() {
        }

        @Override // sdk.pendo.io.f1.a
        public boolean a(sdk.pendo.io.f1.j jVar, sdk.pendo.io.f1.j jVar2, sdk.pendo.io.d1.l.a aVar) {
            return jVar2.b().s() == jVar.a(aVar);
        }
    }

    private static class t implements sdk.pendo.io.f1.a {
        private t() {
        }

        @Override // sdk.pendo.io.f1.a
        public boolean a(sdk.pendo.io.f1.j jVar, sdk.pendo.io.f1.j jVar2, sdk.pendo.io.d1.l.a aVar) {
            if (jVar.getClass().equals(jVar2.getClass())) {
                return ((sdk.pendo.io.f1.a) b.a.get(sdk.pendo.io.f1.i.EQ)).a(jVar, jVar2, aVar);
            }
            return false;
        }
    }

    private static class u implements sdk.pendo.io.f1.a {
        private u() {
        }

        @Override // sdk.pendo.io.f1.a
        public boolean a(sdk.pendo.io.f1.j jVar, sdk.pendo.io.f1.j jVar2, sdk.pendo.io.d1.l.a aVar) {
            return !((sdk.pendo.io.f1.a) b.a.get(sdk.pendo.io.f1.i.TSEQ)).a(jVar, jVar2, aVar);
        }
    }

    static {
        HashMap map = new HashMap();
        a = map;
        map.put(sdk.pendo.io.f1.i.EXISTS, new f());
        map.put(sdk.pendo.io.f1.i.NE, new m());
        map.put(sdk.pendo.io.f1.i.TSNE, new u());
        map.put(sdk.pendo.io.f1.i.EQ, new e());
        map.put(sdk.pendo.io.f1.i.TSEQ, new t());
        map.put(sdk.pendo.io.f1.i.LT, new k());
        map.put(sdk.pendo.io.f1.i.LTE, new j());
        map.put(sdk.pendo.io.f1.i.GT, new h());
        map.put(sdk.pendo.io.f1.i.GTE, new g());
        map.put(sdk.pendo.io.f1.i.REGEX, new p());
        map.put(sdk.pendo.io.f1.i.SIZE, new q());
        map.put(sdk.pendo.io.f1.i.EMPTY, new d());
        map.put(sdk.pendo.io.f1.i.IN, new i());
        map.put(sdk.pendo.io.f1.i.NIN, new n());
        map.put(sdk.pendo.io.f1.i.ALL, new a());
        map.put(sdk.pendo.io.f1.i.CONTAINS, new c());
        map.put(sdk.pendo.io.f1.i.MATCHES, new o());
        map.put(sdk.pendo.io.f1.i.TYPE, new s());
        map.put(sdk.pendo.io.f1.i.SUBSETOF, new r());
        map.put(sdk.pendo.io.f1.i.ANYOF, new C0382b());
        map.put(sdk.pendo.io.f1.i.NONEOF, new l());
    }

    public static sdk.pendo.io.f1.a a(sdk.pendo.io.f1.i iVar) {
        return a.get(iVar);
    }
}
