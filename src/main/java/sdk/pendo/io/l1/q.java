package sdk.pendo.io.l1;

import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class q extends j {
    private static final d f = new a();

    class a implements d {
        a() {
        }

        @Override // sdk.pendo.io.l1.q.d
        public boolean a(Object obj) {
            return false;
        }
    }

    private static final class b implements d {
        private final g a;

        private b(g gVar) {
            this.a = gVar;
        }

        @Override // sdk.pendo.io.l1.q.d
        public boolean a(Object obj) {
            return this.a.d().e(obj);
        }
    }

    private static final class c implements d {
        private final g a;
        private n b;

        private c(j jVar, g gVar) {
            this.a = gVar;
            this.b = (n) jVar;
        }

        @Override // sdk.pendo.io.l1.q.d
        public boolean a(Object obj) {
            return this.b.a(obj, this.a.f(), this.a.a(), this.a);
        }
    }

    private interface d {
        boolean a(Object obj);
    }

    private static final class e implements d {
        private final g a;
        private o b;

        private e(j jVar, g gVar) {
            this.a = gVar;
            this.b = (o) jVar;
        }

        @Override // sdk.pendo.io.l1.q.d
        public boolean a(Object obj) {
            if (!this.a.d().a(obj)) {
                return false;
            }
            if (!this.b.e()) {
                return true;
            }
            if (this.b.b() && this.a.e().contains(sdk.pendo.io.d1.i.DEFAULT_PATH_LEAF_TO_NULL)) {
                return true;
            }
            return this.a.d().c(obj).containsAll(this.b.h());
        }
    }

    private static final class f implements d {
        private f() {
        }

        @Override // sdk.pendo.io.l1.q.d
        public boolean a(Object obj) {
            return true;
        }
    }

    q() {
    }

    private static d a(j jVar, g gVar) {
        if (jVar instanceof o) {
            return new e(jVar, gVar);
        }
        if (jVar instanceof sdk.pendo.io.l1.c) {
            return new b(gVar);
        }
        if (jVar instanceof r) {
            return new f();
        }
        return jVar instanceof n ? new c(jVar, gVar) : f;
    }

    public static void b(j jVar, String str, sdk.pendo.io.e1.h hVar, Object obj, g gVar, d dVar) {
        int i = 0;
        if (dVar.a(obj)) {
            if (jVar.b()) {
                jVar.a(str, hVar, obj, gVar);
            } else {
                j jVarG = jVar.g();
                Iterator<?> it = gVar.d().f(obj).iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    jVarG.a(str + "[" + i2 + "]", hVar, it.next(), gVar);
                    i2++;
                }
            }
        }
        Iterator<?> it2 = gVar.d().f(obj).iterator();
        while (it2.hasNext()) {
            a(jVar, str + "[" + i + "]", sdk.pendo.io.e1.h.a(obj, i), it2.next(), gVar, dVar);
            i++;
        }
    }

    public static void c(j jVar, String str, sdk.pendo.io.e1.h hVar, Object obj, g gVar, d dVar) {
        if (dVar.a(obj)) {
            jVar.a(str, hVar, obj, gVar);
        }
        for (String str2 : gVar.d().c(obj)) {
            String str3 = str + "['" + str2 + "']";
            Object objA = gVar.d().a(obj, str2);
            if (objA != sdk.pendo.io.n1.b.a) {
                a(jVar, str3, sdk.pendo.io.e1.h.a(obj, str2), objA, gVar, dVar);
            }
        }
    }

    @Override // sdk.pendo.io.l1.j
    public boolean e() {
        return false;
    }

    @Override // sdk.pendo.io.l1.j
    public void a(String str, sdk.pendo.io.e1.h hVar, Object obj, g gVar) {
        j jVarG = g();
        a(jVarG, str, hVar, obj, gVar, a(jVarG, gVar));
    }

    @Override // sdk.pendo.io.l1.j
    public String a() {
        return "..";
    }

    public static void a(j jVar, String str, sdk.pendo.io.e1.h hVar, Object obj, g gVar, d dVar) {
        if (gVar.d().a(obj)) {
            c(jVar, str, hVar, obj, gVar, dVar);
        } else if (gVar.d().e(obj)) {
            b(jVar, str, hVar, obj, gVar, dVar);
        }
    }
}
