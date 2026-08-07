package sdk.pendo.io.h1;

import java.util.List;
import sdk.pendo.io.e1.d;
import sdk.pendo.io.e1.h;
import sdk.pendo.io.g1.b;
import sdk.pendo.io.g1.c;

/* JADX INFO: loaded from: classes4.dex */
public class a implements c {
    @Override // sdk.pendo.io.g1.c
    public Object a(String str, h hVar, Object obj, d dVar, List<b> list) {
        sdk.pendo.io.n1.b bVarF = dVar.a().f();
        if (list != null && list.size() > 0) {
            for (b bVar : list) {
                if (bVarF.e(obj)) {
                    bVarF.a(obj, bVarF.d(obj), bVar.d());
                }
            }
        }
        return obj;
    }
}
