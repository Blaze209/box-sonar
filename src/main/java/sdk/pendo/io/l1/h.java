package sdk.pendo.io.l1;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class h extends j {
    private final String f;
    private final String g;
    private List<sdk.pendo.io.g1.b> h;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[sdk.pendo.io.g1.a.values().length];
            a = iArr;
            try {
                iArr[sdk.pendo.io.g1.a.PATH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[sdk.pendo.io.g1.a.JSON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public h(String str, List<sdk.pendo.io.g1.b> list) {
        this.g = str + ((list == null || list.size() <= 0) ? "()" : "(...)");
        if (str != null) {
            this.f = str;
            this.h = list;
        } else {
            this.f = null;
            this.h = null;
        }
    }

    private void b(String str, sdk.pendo.io.e1.h hVar, Object obj, g gVar) {
        sdk.pendo.io.i1.a cVar;
        List<sdk.pendo.io.g1.b> list = this.h;
        if (list != null) {
            for (sdk.pendo.io.g1.b bVar : list) {
                if (!bVar.e()) {
                    int i = a.a[bVar.c().ordinal()];
                    if (i == 1) {
                        cVar = new sdk.pendo.io.i1.c(bVar.b(), gVar.f(), gVar.a());
                    } else if (i == 2) {
                        cVar = new sdk.pendo.io.i1.b(gVar.a().f(), bVar);
                    }
                    bVar.a(cVar);
                    bVar.a(Boolean.TRUE);
                }
            }
        }
    }

    @Override // sdk.pendo.io.l1.j
    public void a(String str, sdk.pendo.io.e1.h hVar, Object obj, g gVar) {
        sdk.pendo.io.g1.c cVarA = sdk.pendo.io.g1.d.a(this.f);
        b(str, hVar, obj, gVar);
        Object objA = cVarA.a(str, hVar, obj, gVar, this.h);
        gVar.a(str + "." + this.f, hVar, objA);
        if (b()) {
            return;
        }
        g().a(str, hVar, objA, gVar);
    }

    @Override // sdk.pendo.io.l1.j
    public boolean e() {
        return true;
    }

    @Override // sdk.pendo.io.l1.j
    public String a() {
        return "." + this.g;
    }

    public void a(List<sdk.pendo.io.g1.b> list) {
        this.h = list;
    }
}
