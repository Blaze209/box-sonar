package sdk.pendo.io.l1;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class j {
    static final /* synthetic */ boolean e = true;
    private j a;
    private j b;
    private Boolean c = null;
    private Boolean d = null;

    protected abstract String a();

    j a(j jVar) {
        this.b = jVar;
        jVar.a = this;
        return jVar;
    }

    public abstract void a(String str, sdk.pendo.io.e1.h hVar, Object obj, g gVar);

    boolean b() {
        return this.b == null;
    }

    public boolean c() {
        Boolean bool = this.c;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean zE = e();
        if (zE && !b()) {
            zE = this.b.c();
        }
        this.c = Boolean.valueOf(zE);
        return zE;
    }

    boolean d() {
        return this.a == null;
    }

    public abstract boolean e();

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    boolean f() {
        if (this.d == null) {
            this.d = Boolean.valueOf(d() || (this.a.e() && this.a.f()));
        }
        return this.d.booleanValue();
    }

    j g() {
        if (b()) {
            throw new IllegalStateException("Current path token is a leaf");
        }
        return this.b;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        return b() ? a() : a() + g().toString();
    }

    private static Object b(String str, Object obj, g gVar) {
        return gVar.d().a(obj, str);
    }

    protected void a(int i, String str, Object obj, g gVar) {
        String strA = sdk.pendo.io.e1.i.a(str, "[", String.valueOf(i), "]");
        sdk.pendo.io.e1.h hVarA = gVar.c() ? sdk.pendo.io.e1.h.a(obj, i) : sdk.pendo.io.e1.h.b;
        if (i < 0) {
            i += gVar.d().d(obj);
        }
        try {
            Object objA = gVar.d().a(obj, i);
            if (b()) {
                gVar.a(strA, hVarA, objA);
            } else {
                g().a(strA, hVarA, objA, gVar);
            }
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    void a(String str, Object obj, g gVar, List<String> list) {
        Object objB;
        Object obj2 = null;
        if (list.size() != 1) {
            String str2 = str + "[" + sdk.pendo.io.e1.i.a(", ", "'", list) + "]";
            if (!e && !b()) {
                throw new AssertionError("non-leaf multi props handled elsewhere");
            }
            Object objB2 = gVar.d().b();
            for (String str3 : list) {
                if (a(str3, obj, gVar)) {
                    objB = b(str3, obj, gVar);
                    if (objB != sdk.pendo.io.n1.b.a) {
                        gVar.d().a(objB2, str3, objB);
                    } else if (gVar.e().contains(sdk.pendo.io.d1.i.DEFAULT_PATH_LEAF_TO_NULL)) {
                        objB = null;
                        gVar.d().a(objB2, str3, objB);
                    }
                } else if (gVar.e().contains(sdk.pendo.io.d1.i.DEFAULT_PATH_LEAF_TO_NULL)) {
                    objB = null;
                    gVar.d().a(objB2, str3, objB);
                } else if (gVar.e().contains(sdk.pendo.io.d1.i.REQUIRE_PROPERTIES)) {
                    throw new sdk.pendo.io.d1.k("Missing property in path " + str2);
                }
            }
            gVar.a(str2, gVar.c() ? sdk.pendo.io.e1.h.a(obj, list) : sdk.pendo.io.e1.h.b, objB2);
            return;
        }
        String str4 = list.get(0);
        String strA = sdk.pendo.io.e1.i.a(str, "['", str4, "']");
        Object objB3 = b(str4, obj, gVar);
        if (objB3 != sdk.pendo.io.n1.b.a) {
            obj2 = objB3;
        } else {
            if (!e && !(this instanceof o)) {
                throw new AssertionError("only PropertyPathToken is supported");
            }
            if (!b()) {
                if (((f() && e()) || gVar.e().contains(sdk.pendo.io.d1.i.REQUIRE_PROPERTIES)) && !gVar.e().contains(sdk.pendo.io.d1.i.SUPPRESS_EXCEPTIONS)) {
                    throw new sdk.pendo.io.d1.k("Missing property in path " + strA);
                }
                return;
            }
            if (!gVar.e().contains(sdk.pendo.io.d1.i.DEFAULT_PATH_LEAF_TO_NULL)) {
                if (!gVar.e().contains(sdk.pendo.io.d1.i.SUPPRESS_EXCEPTIONS) && gVar.e().contains(sdk.pendo.io.d1.i.REQUIRE_PROPERTIES)) {
                    throw new sdk.pendo.io.d1.k("No results for path: " + strA);
                }
                return;
            }
        }
        sdk.pendo.io.e1.h hVarA = gVar.c() ? sdk.pendo.io.e1.h.a(obj, str4) : sdk.pendo.io.e1.h.b;
        if (b()) {
            gVar.a(strA, hVarA, obj2);
        } else {
            g().a(strA, hVarA, obj2, gVar);
        }
    }

    public void b(j jVar) {
        this.b = jVar;
    }

    private static boolean a(String str, Object obj, g gVar) {
        return gVar.d().c(obj).contains(str);
    }
}
