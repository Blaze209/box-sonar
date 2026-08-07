package external.sdk.pendo.io.glide.load.engine;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class o {
    private final Map<sdk.pendo.io.e.f, i<?>> a = new HashMap();
    private final Map<sdk.pendo.io.e.f, i<?>> b = new HashMap();

    o() {
    }

    i<?> a(sdk.pendo.io.e.f fVar, boolean z) {
        return a(z).get(fVar);
    }

    void b(sdk.pendo.io.e.f fVar, i<?> iVar) {
        Map<sdk.pendo.io.e.f, i<?>> mapA = a(iVar.h());
        if (iVar.equals(mapA.get(fVar))) {
            mapA.remove(fVar);
        }
    }

    private Map<sdk.pendo.io.e.f, i<?>> a(boolean z) {
        return z ? this.b : this.a;
    }

    void a(sdk.pendo.io.e.f fVar, i<?> iVar) {
        a(iVar.h()).put(fVar, iVar);
    }
}
