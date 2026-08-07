package external.sdk.pendo.io.jose4j.jwt.consumer;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class a implements b {
    private static final b.a c = new b.a(7, "No Audience (aud) claim present.");
    private Set<String> a;
    private boolean b;

    public a(Set<String> set, boolean z) {
        this.a = set;
        this.b = z;
    }

    @Override // external.sdk.pendo.io.jose4j.jwt.consumer.b
    public b.a a(g gVar) throws sdk.pendo.io.v0.c {
        sdk.pendo.io.v0.b bVarC = gVar.c();
        if (!bVarC.i()) {
            if (this.b) {
                return c;
            }
            return null;
        }
        List<String> listA = bVarC.a();
        Iterator<String> it = listA.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (this.a.contains(it.next())) {
                z = true;
            }
        }
        if (z) {
            return null;
        }
        StringBuilder sb = new StringBuilder("Audience (aud) claim ");
        sb.append(listA);
        sb.append(this.a.isEmpty() ? " present in the JWT but no expected audience value(s) were provided to the JWT Consumer." : " doesn't contain an acceptable identifier.");
        sb.append(" Expected ");
        if (this.a.size() == 1) {
            sb.append(this.a.iterator().next());
        } else {
            sb.append("one of ").append(this.a);
        }
        sb.append(" as an aud value.");
        return new b.a(8, sb.toString());
    }
}
