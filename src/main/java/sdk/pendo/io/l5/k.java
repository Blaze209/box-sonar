package sdk.pendo.io.l5;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
final class k {
    private final Map<h, Map<c, j>> a = new HashMap();
    private final Set<h> b = new HashSet();

    protected k(Collection<j> collection, boolean z) {
        if (collection != null) {
            for (j jVar : collection) {
                Map<c, j> map = this.a.get(jVar.c());
                if (map == null) {
                    map = new HashMap<>();
                    this.a.put(jVar.c(), map);
                }
                map.put(jVar.b(), jVar);
                if (jVar.e()) {
                    this.b.add(jVar.d());
                }
            }
        }
        if (z) {
            if (collection == null || collection.isEmpty()) {
                throw new sdk.pendo.io.n5.a("No transitions defined");
            }
            for (j jVar2 : collection) {
                h hVarC = jVar2.c();
                if (this.b.contains(hVarC)) {
                    throw new sdk.pendo.io.n5.a("Some events defined for final State: " + hVarC);
                }
                h hVarD = jVar2.d();
                if (!this.b.contains(hVarD) && !this.a.containsKey(hVarD)) {
                    throw new sdk.pendo.io.n5.a("No events defined for non-final State: " + hVarD);
                }
            }
        }
    }

    public j a(h hVar, c cVar) {
        Map<c, j> map = this.a.get(hVar);
        if (map == null) {
            return null;
        }
        return map.get(cVar);
    }

    public String toString() {
        return this.a.toString();
    }

    protected boolean a(h hVar) {
        return this.b.contains(hVar);
    }
}
