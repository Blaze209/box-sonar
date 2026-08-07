package sdk.pendo.io.i0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class d {
    private static final List<sdk.pendo.io.j0.a> a = new ArrayList();

    public static class a {
        public a(c cVar) {
            d.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(c cVar) {
        Iterator<sdk.pendo.io.j0.a> it = a.iterator();
        while (it.hasNext()) {
            if (it.next().a().a().equals(cVar.a())) {
                return;
            }
        }
        a.add(new sdk.pendo.io.j0.a(cVar));
    }

    public static a b(c cVar) {
        return new a(cVar);
    }

    public static sdk.pendo.io.j0.a a(sdk.pendo.io.i0.a aVar) {
        for (sdk.pendo.io.j0.a aVar2 : a) {
            if (aVar2.a(aVar)) {
                return aVar2;
            }
        }
        return null;
    }
}
