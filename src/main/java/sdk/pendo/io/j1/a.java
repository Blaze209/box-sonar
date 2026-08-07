package sdk.pendo.io.j1;

import java.util.Iterator;
import java.util.List;
import sdk.pendo.io.e1.h;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a implements sdk.pendo.io.g1.c {
    protected abstract Number a();

    @Override // sdk.pendo.io.g1.c
    public Object a(String str, h hVar, Object obj, sdk.pendo.io.e1.d dVar, List<sdk.pendo.io.g1.b> list) {
        int i = 0;
        if (dVar.a().f().e(obj)) {
            for (Object obj2 : dVar.a().f().f(obj)) {
                if (obj2 instanceof Number) {
                    i++;
                    a((Number) obj2);
                }
            }
        }
        if (list != null) {
            Iterator it = sdk.pendo.io.g1.b.a(Number.class, dVar, list).iterator();
            while (it.hasNext()) {
                i++;
                a((Number) it.next());
            }
        }
        if (i != 0) {
            return a();
        }
        throw new sdk.pendo.io.d1.h("Aggregation function attempted to calculate value using empty array");
    }

    protected abstract void a(Number number);
}
