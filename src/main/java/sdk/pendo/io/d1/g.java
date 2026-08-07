package sdk.pendo.io.d1;

/* JADX INFO: loaded from: classes4.dex */
public class g {
    private final sdk.pendo.io.e1.g a;

    private g(String str, l[] lVarArr) {
        sdk.pendo.io.e1.i.a(str, "path can not be null", new Object[0]);
        this.a = sdk.pendo.io.l1.i.a(str, lVarArr);
    }

    public static g a(String str, l... lVarArr) {
        sdk.pendo.io.e1.i.a(str, "json can not be null or empty", new Object[0]);
        return new g(str, lVarArr);
    }

    public <T> T a(Object obj, a aVar) {
        i iVar = i.AS_PATH_LIST;
        boolean zA = aVar.a(iVar);
        i iVar2 = i.ALWAYS_RETURN_LIST;
        boolean zA2 = aVar.a(iVar2);
        boolean zA3 = aVar.a(i.SUPPRESS_EXCEPTIONS);
        try {
            if (this.a.a()) {
                if (zA || zA2) {
                    throw new h("Options " + iVar + " and " + iVar2 + " are not allowed when using path functions!");
                }
                return (T) this.a.a(obj, obj, aVar).a(true);
            }
            if (zA) {
                return (T) this.a.a(obj, obj, aVar).getPath();
            }
            T t = (T) this.a.a(obj, obj, aVar).a(false);
            if (!zA2 || !this.a.c()) {
                return t;
            }
            T t2 = (T) aVar.f().a();
            aVar.f().a(t2, 0, t);
            return t2;
        } catch (RuntimeException e) {
            if (!zA3) {
                throw e;
            }
            if (zA || zA2) {
                return (T) aVar.f().a();
            }
            if (this.a.c()) {
                return null;
            }
            return (T) aVar.f().a();
        }
    }

    public static j a(a aVar) {
        return new sdk.pendo.io.e1.f(aVar);
    }
}
