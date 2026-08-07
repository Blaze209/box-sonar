package sdk.pendo.io.l1;

import com.microsoft.identity.client.internal.MsalUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class n extends j {
    private final Collection<sdk.pendo.io.d1.l> f;

    n(Collection<sdk.pendo.io.d1.l> collection) {
        this.f = collection;
    }

    public boolean a(Object obj, Object obj2, sdk.pendo.io.d1.a aVar, g gVar) {
        m mVar = new m(obj, obj2, aVar, gVar.b());
        Iterator<sdk.pendo.io.d1.l> it = this.f.iterator();
        while (it.hasNext()) {
            try {
                if (!it.next().a(mVar)) {
                    return false;
                }
            } catch (sdk.pendo.io.d1.f unused) {
            }
        }
        return true;
    }

    @Override // sdk.pendo.io.l1.j
    public boolean e() {
        return false;
    }

    n(sdk.pendo.io.d1.l lVar) {
        this.f = Collections.singletonList(lVar);
    }

    @Override // sdk.pendo.io.l1.j
    public void a(String str, sdk.pendo.io.e1.h hVar, Object obj, g gVar) {
        if (gVar.d().a(obj)) {
            if (a(obj, gVar.f(), gVar.a(), gVar)) {
                if (!gVar.c()) {
                    hVar = sdk.pendo.io.e1.h.b;
                }
                if (b()) {
                    gVar.a(str, hVar, obj);
                    return;
                } else {
                    g().a(str, hVar, obj, gVar);
                    return;
                }
            }
            return;
        }
        if (!gVar.d().e(obj)) {
            if (f()) {
                throw new sdk.pendo.io.d1.f(String.format("Filter: %s can not be applied to primitives. Current context is: %s", toString(), obj));
            }
            return;
        }
        Iterator<?> it = gVar.d().f(obj).iterator();
        int i = 0;
        while (it.hasNext()) {
            if (a(it.next(), gVar.f(), gVar.a(), gVar)) {
                a(i, str, obj, gVar);
            }
            i++;
        }
    }

    @Override // sdk.pendo.io.l1.j
    public String a() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < this.f.size(); i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(MsalUtils.QUERY_STRING_SYMBOL);
        }
        sb.append("]");
        return sb.toString();
    }
}
