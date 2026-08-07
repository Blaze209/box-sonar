package sdk.pendo.io.k1;

import java.util.List;
import sdk.pendo.io.e1.d;
import sdk.pendo.io.e1.h;
import sdk.pendo.io.g1.c;

/* JADX INFO: loaded from: classes4.dex */
public class b implements c {
    @Override // sdk.pendo.io.g1.c
    public Object a(String str, h hVar, Object obj, d dVar, List<sdk.pendo.io.g1.b> list) {
        if (dVar.a().f().e(obj) || dVar.a().f().a(obj)) {
            return Integer.valueOf(dVar.a().f().d(obj));
        }
        return null;
    }
}
