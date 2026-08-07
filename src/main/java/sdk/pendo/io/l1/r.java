package sdk.pendo.io.l1;

import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class r extends j {
    r() {
    }

    @Override // sdk.pendo.io.l1.j
    public void a(String str, sdk.pendo.io.e1.h hVar, Object obj, g gVar) {
        if (gVar.d().a(obj)) {
            Iterator<String> it = gVar.d().c(obj).iterator();
            while (it.hasNext()) {
                a(str, obj, gVar, Collections.singletonList(it.next()));
            }
        } else if (gVar.d().e(obj)) {
            for (int i = 0; i < gVar.d().d(obj); i++) {
                try {
                    a(i, str, obj, gVar);
                } catch (sdk.pendo.io.d1.k e) {
                    if (gVar.e().contains(sdk.pendo.io.d1.i.REQUIRE_PROPERTIES)) {
                        throw e;
                    }
                }
            }
        }
    }

    @Override // sdk.pendo.io.l1.j
    public boolean e() {
        return false;
    }

    @Override // sdk.pendo.io.l1.j
    public String a() {
        return "[*]";
    }
}
