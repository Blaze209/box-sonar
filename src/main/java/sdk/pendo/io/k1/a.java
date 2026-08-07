package sdk.pendo.io.k1;

import java.util.Iterator;
import java.util.List;
import sdk.pendo.io.e1.d;
import sdk.pendo.io.e1.h;
import sdk.pendo.io.g1.c;

/* JADX INFO: loaded from: classes4.dex */
public class a implements c {
    @Override // sdk.pendo.io.g1.c
    public Object a(String str, h hVar, Object obj, d dVar, List<sdk.pendo.io.g1.b> list) {
        StringBuilder sb = new StringBuilder();
        if (dVar.a().f().e(obj)) {
            for (Object obj2 : dVar.a().f().f(obj)) {
                if (obj2 instanceof String) {
                    sb.append(obj2.toString());
                }
            }
        }
        if (list != null) {
            Iterator it = sdk.pendo.io.g1.b.a(String.class, dVar, list).iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
            }
        }
        return sb.toString();
    }
}
